package com.c4hco.test.automation.edi.ediUtil;

import com.c4hco.test.automation.Dto.Ob834FileDetails;
import com.c4hco.test.automation.Dto.SharedData;
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
import java.util.Optional;

public class Edi834Util {


    public void parseEdiFile(InputStream inputStream) {
        //Notes::  transform as jsonObj
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
            Boolean lsLoop = false;
            int LXCOUNT = 0;

            Boolean insLoop = false;
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
                                //member segregate code start here
                                if (insCount == previousIndex) {
                                    memberArrayNode.add(currentSegmentArray);
                                    memberSegmentData.put(currentSegmentName, currentSegmentArray);
                                } else {
                                    //memberSegmentData.put(currentSegmentName,memberArrayNode);
                                    String jsonString = objectMapper.writeValueAsString(memberSegmentData.asMap());
                                    JsonNode jsonNode = objectMapper.readTree(jsonString);
                                    memberObject.set("Member-" + previousIndex, jsonNode);
                                    memberArrayNode = objectMapper.createArrayNode();
                                    memberSegmentData = new ArrayListValuedHashMap<>();
                                    previousIndex = insCount;
                                }
                            } else {
                                segmentData.put(currentSegmentName, currentSegmentArray);
                            }
                            segmentsObject.set(currentSegmentName, currentSegmentArray);
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

            String jsonString1 = objectMapper.writeValueAsString(transactionObjectNode);
            JSONObject jsonObj = new JSONObject(objectMapper.writeValueAsString(transactionObjectNode));
            System.out.println("file as transformed jsonObj--" + jsonObj);
            sendToDto(jsonObj);

            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void sendToDto(JSONObject jsonObject) {
        System.out.println("jsonObj length--" + jsonObject.length());
        jsonObject.length();
        for (int i = 0; i <= jsonObject.length(); i++) {

//            JSONObject transactionObject = jsonObject.getJSONObject("Transaction_"+i);
//            for(int j=1;j<transactionObject.length();j++){
//                JSONObject memberObj = transactionObject.getJSONObject("Member-"+j);
//            }

        }

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
