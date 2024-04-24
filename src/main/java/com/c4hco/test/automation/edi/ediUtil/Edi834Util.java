package com.c4hco.test.automation.edi.ediUtil;

import com.c4hco.test.automation.Dto.Edi.*;
import com.c4hco.test.automation.Dto.Ob834FileDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.xlate.edi.stream.EDIInputFactory;
import io.xlate.edi.stream.EDIStreamReader;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Edi834Util {


    public void parseEdiFile(InputStream inputStream) {
        try {
            EDIInputFactory factory = EDIInputFactory.newFactory();
            EDIStreamReader reader = factory.createEDIStreamReader(inputStream);
            // Create ObjectMapper for creating JSON objects
            ObjectMapper objectMapper = new ObjectMapper();
            // Create JSON object to hold segments
            ObjectNode segmentsObject = objectMapper.createObjectNode();
            ObjectNode memberObject = objectMapper.createObjectNode();
            ObjectNode transactionObjectNode = objectMapper.createObjectNode();

            ArrayNode memberArrayNode = objectMapper.createArrayNode();

            ListValuedMap<String, ArrayNode> memberSegmentData = new ArrayListValuedHashMap<>();

            ListValuedMap<String, ArrayNode> segmentData = new ArrayListValuedHashMap<>();
            ListValuedMap<String, ArrayNode> commonEdiSegments = new ArrayListValuedHashMap<>();
            Boolean lsLoop = false;
            int LXCOUNT = 0;

            int insCount = 0;
            int previousIndex = 1;
            int stCount = 0;
            String member = null;

            String currentSegmentName = null;
            ArrayNode currentSegmentArray = objectMapper.createArrayNode();


            while (reader.hasNext()) {
                switch (reader.next()) {
                    case START_INTERCHANGE:
                        String standard = reader.getStandard();
                        break;
                    case START_SEGMENT:
                        currentSegmentName = reader.getText();
                        currentSegmentArray = objectMapper.createArrayNode();
                        segmentsObject = objectMapper.createObjectNode();
                        if (currentSegmentName.equals("LS")) {
                            lsLoop = true;
                        } else if (currentSegmentName.equals("LE")) {
                            lsLoop = false;
                            LXCOUNT = 0;
                        }
                        if (currentSegmentName.equals("INS")) {
                            insCount++;
                            member = "member" + insCount;
                        }
                        if (currentSegmentName.equals("ST")) {
                            stCount++;
                        }
                        if (currentSegmentName.equals("SE")) {
                            insCount = 0;
                        }
                        break;

                    case ELEMENT_DATA:
                        String data = reader.getText();
                        if (currentSegmentName.equals("LX")) {
                            LXCOUNT = Integer.parseInt(data);
                        }
                        if (lsLoop) {
                            currentSegmentArray.add("LX" + LXCOUNT);
                        }
                        currentSegmentArray.add(data);
                        segmentsObject.set(currentSegmentName, currentSegmentArray);
                        break;
                    case END_SEGMENT:
                        if (currentSegmentName != null && currentSegmentArray != null) {
                            if (member != null) {
                                if (insCount == previousIndex) {
                                    memberArrayNode.add(currentSegmentArray);
                                    memberSegmentData.put(currentSegmentName, currentSegmentArray);
                                } else {
                                    String jsonString = objectMapper.writeValueAsString(memberSegmentData.asMap());
                                    JsonNode jsonNode = objectMapper.readTree(jsonString);
                                    memberObject.set("Member-" + previousIndex, jsonNode);
                                    memberArrayNode = objectMapper.createArrayNode();
                                    memberSegmentData = new ArrayListValuedHashMap<>();
                                    previousIndex = insCount;
                                }
                            } else{
                                if(currentSegmentName.equals("ISA") || currentSegmentName.equals("GS") ||
                                        currentSegmentName.equals("GE") || currentSegmentName.equals("IEA")){
                                    commonEdiSegments.put(currentSegmentName,currentSegmentArray);
                                }else
                                    segmentData.put(currentSegmentName, currentSegmentArray);
                            }
                            segmentsObject.set(currentSegmentName,currentSegmentArray);
                            if (currentSegmentName.equals("SE")) {
                                String jsonString = objectMapper.writeValueAsString(segmentData.asMap());
                                JsonNode jsonCommonSegmentNode = objectMapper.readTree(jsonString);
                                memberObject.set("Common_Segments", jsonCommonSegmentNode);
                                transactionObjectNode.set("Transaction_" + stCount, memberObject);
                                member = null;
                                memberObject = objectMapper.createObjectNode();
                                segmentData = new ArrayListValuedHashMap<>();
                                previousIndex = 1;
                            }
                            currentSegmentName = null;
                            currentSegmentArray = null;
                        }
                        break;
                }
            }
            String jsonCommonSegmentString = objectMapper.writeValueAsString(commonEdiSegments.asMap());
            System.out.println("jsonCommonSegmentString::"+jsonCommonSegmentString);

            parseEdiJsonToModel(transactionObjectNode.toString());
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseEdiJsonToModel(String jsonString){
        Edi834TransactionDetails edi834TransactionDetails = new Edi834TransactionDetails();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("jsonString::"+jsonString);
            Map<String, Map<String, Object>> transactions = objectMapper.readValue(jsonString, new TypeReference<Map<String, Map<String, Object>>>() {});
            List<Transaction> transactionList = new ArrayList<>();
            // Now you can access the parsed data using the transactions map
            for (Map.Entry<String, Map<String, Object>> entry : transactions.entrySet()) {
                String transactionId = entry.getKey();
                Transaction transaction = new Transaction();
                List<Member> memberList = new ArrayList<>();
                Map<String, Object> transactionData = entry.getValue();
                if(transactionId.equals("Common_EDI_Segments")){
                    String commonEDISegmentsJson = new ObjectMapper().writeValueAsString(transactionData);
                    CommonEDISegments commonEDISegments = objectMapper.readValue(commonEDISegmentsJson,CommonEDISegments.class);
                    edi834TransactionDetails.setCommonEDISegments(commonEDISegments);
                }
                else{
                    for(Map.Entry<String,Object> transactionEntry : transactionData.entrySet()){
                        String transactionKeys = transactionEntry.getKey();
                        Map<String, Object> membersObject = (Map<String, Object>) transactionEntry.getValue();
                        String json = new ObjectMapper().writeValueAsString(membersObject);
                        Member member = new Member();
                        CommonSegments commonSegments = new CommonSegments();
                        if(transactionKeys.equals("Common_Segments")){
                            commonSegments = objectMapper.readValue(json,CommonSegments.class);
                            transaction.setCommonSegments(commonSegments);
                        }else {
                            member = objectMapper.readValue(json, Member.class);
                            memberList.add(member);
                        }
                    }
                    transaction.setMembersList(memberList);
                    transactionList.add(transaction);
                }
            }
            edi834TransactionDetails.setTransactionList(transactionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SharedData.setEdi834TransactionDetails(edi834TransactionDetails);
        readTheDataFromEDIModel();
    }

    public void readTheDataFromEDIModel(){
        // WIP - move this to where we need validations
        Edi834TransactionDetails edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        List<Transaction> transactionList = edi834TransactionDetails.getTransactionList();
        for(Transaction transaction : transactionList){
            List<Member> memberList = transaction.getMembersList();
            CommonSegments commonSegments = transaction.getCommonSegments();
        }
        CommonEDISegments commonEDISegments = edi834TransactionDetails.getCommonEDISegments();
        List<List<String>> ISA = commonEDISegments.getISA();
    }



    public void getGe(JSONObject jsonObj) {
        Ob834FileDetails ob834FileDetails = new Ob834FileDetails();

        // get Total transactions count
        JSONArray functionalGrpTrailer = jsonObj.getJSONArray("GE");
//        String totalTrnCount = String.valueOf(functionalGrpTrailer.getJSONArray(0).get(0));
//        ob834FileDetails.setTotalTransactions(totalTrnCount);
        ob834FileDetails.setCtrlGrpNum(String.valueOf(functionalGrpTrailer.getJSONArray(0).get(1)));

        List<Ob834FileDetails> ob834FileRecords = SharedData.getOb834FileDetails();
        if (ob834FileRecords == null) {
            ob834FileRecords = new ArrayList<>();
        }
        ob834FileRecords.add(ob834FileDetails);
        SharedData.setOb834FileDetails(ob834FileRecords);

        if ("1".equals("1")) {
            getSegments(jsonObj);
        } else {
            // handle multiple transactions
        }

    }

    public void getSegments(JSONObject jsonObj) {
        // TO DO:: Move this to a diff file - set OB834 segments and values.
        // Validate - no null values - if null - proceed and save the others.
        Ob834FileDetails ob834FileDetails = new Ob834FileDetails();

        // name segment
        JSONArray nameSegment = jsonObj.getJSONArray("N1");
        ob834FileDetails.setSponsorName(String.valueOf(nameSegment.getJSONArray(0).get(1)));
        ob834FileDetails.setSponsorId(String.valueOf(nameSegment.getJSONArray(0).get(3)));

        Optional<Object> addlMainOptional = nameSegment.toList().stream().filter(o -> o.toString().contains("ADDL MAINT REASON")).findFirst();
        if (addlMainOptional.isPresent()) {
            ArrayList<?> addlMainObj = (ArrayList<?>) addlMainOptional.get();
            ob834FileDetails.setAddtl_maintreason((String) addlMainObj.get(0));
        }

        // Individual Relationship Segment
        JSONArray insSegment = jsonObj.getJSONArray("INS");
        ob834FileDetails.setMaint_type_code(String.valueOf(insSegment.getJSONArray(0).get(2)));
        ob834FileDetails.setMaint_reasCode(String.valueOf(insSegment.getJSONArray(0).get(3)));


        // Date/Time Period Segment
        JSONArray dtpSegment = jsonObj.getJSONArray("DTP");
        Optional<Object> benefitBgnDtObj = dtpSegment.toList().stream()
                .filter(obj -> obj.toString().contains("348"))
                .findFirst();

        Optional<Object> benefitEndDtObj = dtpSegment.toList().stream()
                .filter(obj -> obj.toString().contains("349"))
                .findFirst();

        if (benefitBgnDtObj.isPresent()) {
            ArrayList<?> benefitBgnDrObj = (ArrayList<?>) benefitBgnDtObj.get();

            String benefitBgnDate = (String) benefitBgnDrObj.get(2);
            ob834FileDetails.setBenefit_startDate(benefitBgnDate);
        }

        if (benefitEndDtObj.isPresent()) {
            ArrayList<?> benefitEndObj = (ArrayList<?>) benefitEndDtObj.get();

            String benefitEndDate = (String) benefitEndObj.get(2);
            ob834FileDetails.setBenefit_endDate(benefitEndDate);
        }

        // Hierarchy level segment
        JSONArray hdSegment = jsonObj.getJSONArray("HD");
        ob834FileDetails.setHd_maint_typeCode(String.valueOf(hdSegment.getJSONArray(0).get(0)));
        ob834FileDetails.setInsurance_line_code(String.valueOf(hdSegment.getJSONArray(0).get(2)));

        // NM1
        JSONArray nm1Segment = jsonObj.getJSONArray("NM1");

        Optional<Object> subscriberOptionalObj = nm1Segment.toList().stream()
                .filter(obj -> obj.toString().contains("IL")).findFirst();
        System.out.println("subscriber list obj--" + subscriberOptionalObj);

        // TO DO:: UPdate to list if we may have more with this entity_id_code.
        Optional<Object> updatedSubscriberOptionalObj = nm1Segment.toList().stream()
                .filter(obj -> obj.toString().contains("74")).findFirst();

        Optional<Object> incorrectEntityOptional = nm1Segment.toList().stream()
                .filter(obj -> obj.toString().contains("70")).findFirst();


        System.out.println("updated subscriber list obj--" + updatedSubscriberOptionalObj);

        if (subscriberOptionalObj.isPresent()) {
            ArrayList<?> subscriberObj = (ArrayList<?>) subscriberOptionalObj.get();
            ob834FileDetails.setFirstName((String) subscriberObj.get(3));
            ob834FileDetails.setLastName((String) subscriberObj.get(2));
            ob834FileDetails.setSsn((String) subscriberObj.get(8));
        }

        if (updatedSubscriberOptionalObj.isPresent()) {
            ArrayList<?> updatedSubscriberObj = (ArrayList<?>) updatedSubscriberOptionalObj.get();
            ob834FileDetails.setUpdatedFirstName((String) updatedSubscriberObj.get(2));
            ob834FileDetails.setUpdatedLastName((String) updatedSubscriberObj.get(3));
            ob834FileDetails.setUpdatedSsn((String) updatedSubscriberObj.get(8));
        }

        if (incorrectEntityOptional.isPresent()) {
            ArrayList<?> incorrectEntityOptionalObj = (ArrayList<?>) incorrectEntityOptional.get();
            ob834FileDetails.setIncorrectEntityIdCode((String) incorrectEntityOptionalObj.get(0));
            ob834FileDetails.setIncorrectIdCodeQualifier((String) incorrectEntityOptionalObj.get(7));
            ob834FileDetails.setIncorrectIdCode((String) incorrectEntityOptionalObj.get(8));
        }


        List<Ob834FileDetails> ob834FileRecords = SharedData.getOb834FileDetails();
        if (ob834FileRecords == null) {
            ob834FileRecords = new ArrayList<>();
        }
        ob834FileRecords.add(ob834FileDetails);
        SharedData.setOb834FileDetails(ob834FileRecords);
    }


}
