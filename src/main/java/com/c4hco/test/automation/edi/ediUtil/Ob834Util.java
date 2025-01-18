package com.c4hco.test.automation.edi.ediUtil;

import com.c4hco.test.automation.Dto.Edi.Edi834.*;
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
import org.testng.Assert;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ob834Util {

    public void validateFileIsNotEmpty(InputStream inputStream){
        Boolean isFileEmpty = true;
        try {
            EDIInputFactory factory = EDIInputFactory.newFactory();
            EDIStreamReader reader = factory.createEDIStreamReader(inputStream);
            if (reader.hasNext()) {
                isFileEmpty = false;
            } else {
                isFileEmpty = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertFalse(isFileEmpty, "The EDI file is empty");
    }


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
                                    memberArrayNode.add(currentSegmentArray);
                                    memberSegmentData.put(currentSegmentName, currentSegmentArray);

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
                                segmentData.put(currentSegmentName, currentSegmentArray);
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
            JSONObject commonEdiSegJsonObj = new JSONObject(jsonCommonSegmentString);
            setCommonEdiSegments(commonEdiSegJsonObj);

            parseEdiJsonToModel(transactionObjectNode.toString());
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCommonEdiSegments(JSONObject jsonCommonSegmentString){
        CommonEDISegments commonEDISegments = new CommonEDISegments();

        JSONArray isaSeg = jsonCommonSegmentString.getJSONArray("ISA");
        JSONArray ieaSeg = jsonCommonSegmentString.getJSONArray("IEA");
        JSONArray gsSegment = jsonCommonSegmentString.getJSONArray("GS");
        JSONArray geSeg = jsonCommonSegmentString.getJSONArray("GE");

        JSONArray isaSegment = (JSONArray) isaSeg.get(0);
        JSONArray ieaSegment = (JSONArray) ieaSeg.get(0);

        commonEDISegments.setISA(isaSegment);
        commonEDISegments.setIEA(ieaSegment);
        commonEDISegments.setGS(gsSegment);
        commonEDISegments.setGE(geSeg);
        SharedData.setCommonEDISegments(commonEDISegments);

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
                    transaction.setMembersList(memberList);

                }
                transactionList.add(transaction);
            }
            edi834TransactionDetails.setTransactionList(transactionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SharedData.setEdi834TransactionDetails(edi834TransactionDetails);
        testLocal();
    }

    public void testLocal(){
        Edi834TransactionDetails edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        List<Transaction> transactionList = edi834TransactionDetails.getTransactionList();
        Transaction transaction = edi834TransactionDetails.getTransactionList().get(0);
        Member member = transaction.getMembersList().get(0);
        List<List<String>> lxSegment = member.getLX();
        edi834TransactionDetails.getTransactionList().get(0).getCommonSegments();
        List<List<String>> nm1Seg1  = member.getNM1();
        String expectedEmail = "emailaddressforautomation+R0gJAhGbv@gmail.com";
        List<Transaction> sortedTransactionList = new ArrayList<>();

        for(Transaction transaction1: transactionList){
            List<Member> members = transaction1.getMembersList();

            for(Member mem: members){
                if(mem.getINS().get(0).get(0).equals("Y") && mem.getPER().get(0).get(5).equals(expectedEmail)){
                    break;
                }
            }
            sortedTransactionList.add(transaction1);
        }

        edi834TransactionDetails.setTransactionList(sortedTransactionList);
        SharedData.setEdi834TransactionDetails(edi834TransactionDetails);
        transactionList = edi834TransactionDetails.getTransactionList();
    }
}
