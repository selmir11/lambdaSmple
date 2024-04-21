
package com.c4hco.test.automation.sftpConfig;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.Ob834FileDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import io.xlate.edi.stream.EDIInputFactory;
import io.xlate.edi.stream.EDIStreamReader;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class SftpUtil {
    private Session session;
    SoftAssert softAssert = new SoftAssert();

    public SftpUtil(){
    }

    public int setSftpPort(){
        final String env = ApplicationProperties.getInstance().getProperty("env");
        int sftpPort = 0;
        if(SharedData.getAppType().equals("coco")){
            if("qa".equals(env)){
                sftpPort = 10023;
            }else if("staging".equals(env)){
                sftpPort = 10024;
            }
        }else if("exchange".equals(SharedData.getAppType())){
            if("qa".equals(env)){
                sftpPort = 10021;
            }else if("staging".equals(env)){
                sftpPort = 10022;
            }
        }
        return sftpPort;
    }

    public void connectToSftp(){
        String sftpUsername = ApplicationProperties.getInstance().getProperty("sftpUsername");
        String privateKeyPath = ApplicationProperties.getInstance().getProperty("sftpPrivateKeyPath");
        String passPhrase = ApplicationProperties.getInstance().getProperty("sftpPassphrase");

        int sftpPort = 10021;
        // setSftpPort();

        try{
            JSch jsch = new JSch();
            jsch.addIdentity(privateKeyPath, passPhrase);
            session = jsch.getSession(sftpUsername,"localhost",sftpPort);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println("---!!! SFTP CONNECTED !!!---");

        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Error while connecting to SFTP server");
        }
    }

    public void downloadFileWithSftp(String remoteFilePath, String fileNameToDownload) throws JSchException {
        connectToSftp();
        String localPath = SharedData.getLocalPathToDownloadFile();
        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
        try{
            channelSftp.get(remoteFilePath+fileNameToDownload, localPath);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            channelSftp.disconnect();
            disconnectFromSftp();
        }
    }

    public void disconnectFromSftp(){
        if(session != null && session.isConnected()){
            session.disconnect();
        }
    }

    public String getLocalSftpDownloadPath(){
        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
        String sftpFolderPath = "target/sftp-downloads/download-" + timestamp;
        File reportFolder = new File(sftpFolderPath);
        if (!reportFolder.exists()) {
            boolean folderCreated = reportFolder.mkdirs();
            if (!folderCreated) {
                System.out.println("Failed to create the report folder.");
            }
        }
        return sftpFolderPath;
    }

    public void readEdiFile(String filename){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();
        try{
            File file = new File(sftpFolderPath+"\\"+filename);
            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                System.out.println("EDI File Found on SFTP Server");
                parseEdiFile(inputStream);
            } else {
                System.err.println("File not found in the resource folder.");
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void parseEdiFile(InputStream inputStream){
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
            int stCount=0;
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
                        if(currentSegmentName.equals("LS")){
                            lsLoop = true;
                        } else if(currentSegmentName.equals("LE")){
                            lsLoop = false;
                            LXCOUNT =0;
                        }
                        if(currentSegmentName.equals("INS")){
                            insCount++;
                            member = "member"+insCount;
                        }
                        if(currentSegmentName.equals("ST")){
                            stCount++;
                        }
                        if(currentSegmentName.equals("SE")){
                            insCount=0;
                        }
                        break;

                    case ELEMENT_DATA:
                        String data = reader.getText();
                        if(currentSegmentName.equals("LX")){
                            LXCOUNT = Integer.parseInt(data);
                        }
                        if(lsLoop){
                            currentSegmentArray.add("LX"+LXCOUNT);
                        }
                        currentSegmentArray.add(data);
                        segmentsObject.set(currentSegmentName,currentSegmentArray);
                        break;
                    case END_SEGMENT:
                        if (currentSegmentName != null && currentSegmentArray != null) {
                            if(member!=null){
                                //member segregate code start here
                                if(insCount==previousIndex){
                                    memberArrayNode.add(currentSegmentArray);
                                    memberSegmentData.put(currentSegmentName,currentSegmentArray);
                                }else{
                                    //memberSegmentData.put(currentSegmentName,memberArrayNode);
                                    String jsonString = objectMapper.writeValueAsString(memberSegmentData.asMap());
                                    JsonNode jsonNode = objectMapper.readTree(jsonString);
                                    memberObject.set("Member-"+previousIndex,jsonNode);
                                    memberArrayNode = objectMapper.createArrayNode();
                                    memberSegmentData = new ArrayListValuedHashMap<>();
                                    previousIndex = insCount;
                                }
                                // member segregate code ends here
//                                ObjectNode memberNode = objectMapper.createObjectNode();
//                                memberNode.set(member,currentSegmentArray);
//                                segmentData.put(currentSegmentName, memberNode);
                            }else{
                                //ObjectNode memberNode = objectMapper.createObjectNode();
                                //memberNode.set(currentSegmentName,currentSegmentArray);
                                segmentData.put(currentSegmentName, currentSegmentArray);
                            }
                            segmentsObject.set(currentSegmentName,currentSegmentArray);
                            if(currentSegmentName.equals("SE")){
                                String jsonString = objectMapper.writeValueAsString(segmentData.asMap());
                                JsonNode jsonCommonSegmentNode = objectMapper.readTree(jsonString);
                                memberObject.set("Common_Segments",jsonCommonSegmentNode);
                                transactionObjectNode.set("Transaction_"+stCount,memberObject);
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

            System.out.println(transactionObjectNode.toString());

            String jsonString1 = objectMapper.writeValueAsString(transactionObjectNode);
            JSONObject jsonObj = new JSONObject(objectMapper.writeValueAsString(transactionObjectNode));
            System.out.println("jsonStrin1--"+jsonString1);
            System.out.println("jsonObj--"+jsonObj);
            sendToDto(jsonObj);

            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void sendToDto(JSONObject jsonObject){
        System.out.println("jsonObj length--"+jsonObject.length());
        jsonObject.length();
        for(int i=0;i<=jsonObject.length(); i++){

            JSONObject transactionObject = jsonObject.getJSONObject("Transaction_"+i);
            for(int j=1;j<transactionObject.length();j++){
                JSONObject memberObj = transactionObject.getJSONObject("Member-"+j);
            }

        }

    }

    public void parseEdiFile_old(InputStream inputStream){
        try {
            EDIInputFactory factory = EDIInputFactory.newFactory();
            EDIStreamReader reader = factory.createEDIStreamReader(inputStream);
            // Create ObjectMapper for creating JSON objects
            ObjectMapper objectMapper = new ObjectMapper();
            // Create JSON object to hold segments
            ObjectNode segmentsObject = objectMapper.createObjectNode();
            ObjectNode memberObject = objectMapper.createObjectNode();

            ArrayNode memberArrayNode = objectMapper.createArrayNode();
            ListValuedMap<String, ArrayNode> memberSegmentData = new ArrayListValuedHashMap<>();

            ListValuedMap<String, ObjectNode> segmentData = new ArrayListValuedHashMap<>();


            Boolean lsLoop = false;
            int LXCOUNT = 0;

            Boolean insLoop = false;
            int insCount = 0;
            int previousIndex =1;
            String member = null;


            Boolean stLoop = false;
            int stCount = 0;
            String transaction = null;

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
                        if(currentSegmentName.equals("LS")){
                            lsLoop = true;
                        } else if(currentSegmentName.equals("LE")){
                            lsLoop = false;
                            LXCOUNT =0;
                        }
                        if(currentSegmentName.equals("INS")){
                            insLoop = true;
                            insCount++;
                            member = "member"+ insCount;
                        }
                        if(currentSegmentName.equals("SE")){
                            insLoop = false;
                            insCount = 0;
                        }
                        if(currentSegmentName.equals("ST")){
                            stLoop = true;
                            stCount++;
                            transaction="transaction"+stCount;
                        }
                        if(currentSegmentName.equals("GE")){
                            stLoop = false;
                            stCount = 0;
                            transaction = null;
                        }
                        break;

                    case ELEMENT_DATA:
                        String data = reader.getText();
                        if(currentSegmentName.equals("LX")){
                            LXCOUNT = Integer.parseInt(data);
                        }
                        currentSegmentArray.add(data);
                        segmentsObject.set(currentSegmentName, currentSegmentArray);

                        break;
                    case END_SEGMENT:
                        if (currentSegmentName != null && currentSegmentArray != null) {
                            if(member!=null){
                                //member segregate code starts here
                                if(insCount==previousIndex){
                                    memberArrayNode.add(currentSegmentArray);
                                    memberSegmentData.put(currentSegmentName,currentSegmentArray);

                                }else{
                                    String jsonString = objectMapper.writeValueAsString(memberSegmentData.asMap());
                                    JsonNode jsonNode = objectMapper.readTree(jsonString);
                                    memberObject.set("Member-"+previousIndex,jsonNode);
                                    System.out.println("--jsonNode--"+jsonNode);
                                    System.out.println("memberObj after set--"+memberObject);
                                    memberArrayNode = objectMapper.createArrayNode();
                                    memberSegmentData = new ArrayListValuedHashMap<>();
                                    previousIndex = insCount;

                                }

                                // member segregate code ends here

                                ObjectNode memberNode = objectMapper.createObjectNode();
                                memberNode.set(member,currentSegmentArray);
                                segmentData.put(currentSegmentName, memberNode);

                            }else{
                                ObjectNode memberNode = objectMapper.createObjectNode();
                                memberNode.set(currentSegmentName,currentSegmentArray);
                                segmentData.put(currentSegmentName, memberNode);
                            }

                            segmentsObject.set(currentSegmentName,currentSegmentArray);
                            System.out.println("member object::"+memberObject.toString());
                            currentSegmentName = null;
                            currentSegmentArray = null;

                        }
                        break;
                }
            }

            // Convert segments object to JSON string
            String jsonString = objectMapper.writeValueAsString(segmentData.asMap());

            System.out.println(jsonString);

            JSONObject jsonObject = new JSONObject(jsonString);
            getGe(jsonObject);
            // getSegments(jsonObject);
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readEdiFromLocal(){
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("4STMultiINS");
            if (inputStream != null) {
                System.out.println("File found");
                parseEdiFile(inputStream);
            } else {
                System.err.println("File 'edi_384' not found in the resource folder.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getGe(JSONObject jsonObj){
        Ob834FileDetails ob834FileDetails = new Ob834FileDetails();

        // get Total transactions count
        JSONArray functionalGrpTrailer = jsonObj.getJSONArray("GE");
//        String totalTrnCount = String.valueOf(functionalGrpTrailer.getJSONArray(0).get(0));
//        ob834FileDetails.setTotalTransactions(totalTrnCount);
        ob834FileDetails.setCtrlGrpNum(String.valueOf(functionalGrpTrailer.getJSONArray(0).get(1)));

        List<Ob834FileDetails> ob834FileRecords = SharedData.getOb834FileDetails();
        if(ob834FileRecords==null){
            ob834FileRecords = new ArrayList<>();
        }
        ob834FileRecords.add(ob834FileDetails);
        SharedData.setOb834FileDetails(ob834FileRecords);

        if("1".equals("1")){
            getSegments(jsonObj);
        } else {
            // handle multiple transactions
        }

    }

    // Function to remove "member1" or "member2" from a JSONArray
    private static JSONArray removeMember(JSONArray array) {
        JSONArray modifiedArray = new JSONArray();
        for (int i = 0; i < array.length(); i++) {
            String value = array.optString(i, "");
            if (!value.isEmpty() && !value.contains("member")) {
                modifiedArray.put(value);
            }
        }
        return modifiedArray;
    }



    public void getSegments(JSONObject jsonObj) {
        JSONObject    data = jsonObj;

        // TO DO:: Move this to a diff file - set OB834 segments and values.
        // Validate - no null values - if null - proceed and save the others.
        Ob834FileDetails ob834FileDetails = new Ob834FileDetails();

        JSONArray jsonArray = new JSONArray();


        JSONObject member1Data = new JSONObject();
        JSONObject member2Data = new JSONObject();

        // Iterate through the JSON data and extract values for member1 and member2
        for (String key : data.keySet()) {
            JSONArray valueArray = data.getJSONArray(key);
            for (int i = 0; i < valueArray.length(); i++) {
                JSONArray entry = valueArray.getJSONArray(i);
                String memberId = entry.optString(0, ""); // Get the member ID from the first element of the array
                if (memberId.equals("member1")) {
                    JSONArray modifiedEntry = removeMember(entry);
                    if (modifiedEntry.length() > 0) {
                        if (!member1Data.has(key)) {
                            member1Data.put(key, new JSONArray());
                        }
                        member1Data.getJSONArray(key).put(modifiedEntry);
                    }
                } else if (memberId.equals("member2")) {
                    JSONArray modifiedEntry = removeMember(entry);
                    if (modifiedEntry.length() > 0) {
                        if (!member2Data.has(key)) {
                            member2Data.put(key, new JSONArray());
                        }
                        member2Data.getJSONArray(key).put(modifiedEntry);
                    }
                }
            }
        }

        // Convert JSON objects to formatted strings
        String member1Json = member1Data.toString();
        String member2Json = member2Data.toString();

        // Print the extracted data for member1 and member2
        System.out.println("Modified Data for member1::"+member1Json);
        System.out.println("Modified Data for member2:"+member2Json);


        // name segment
        JSONArray nameSegment = jsonObj.getJSONArray("N1");
        ob834FileDetails.setSponsorName(String.valueOf(nameSegment.getJSONArray(0).get(1)));
        ob834FileDetails.setSponsorId(String.valueOf(nameSegment.getJSONArray(0).get(3)));

        Optional<Object> addlMainOptional = nameSegment.toList().stream().filter(o -> o.toString().contains("ADDL MAINT REASON")).findFirst();
        if(addlMainOptional.isPresent()){
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
        System.out.println("subscriber list obj--"+subscriberOptionalObj);

        // TO DO:: UPdate to list if we may have more with this entity_id_code.
        Optional<Object> updatedSubscriberOptionalObj = nm1Segment.toList().stream()
                .filter(obj -> obj.toString().contains("74")).findFirst();

        Optional<Object> incorrectEntityOptional = nm1Segment.toList().stream()
                .filter(obj -> obj.toString().contains("70")).findFirst();


        System.out.println("updated subscriber list obj--"+updatedSubscriberOptionalObj);

        if(subscriberOptionalObj.isPresent()){
            ArrayList<?> subscriberObj = (ArrayList<?>) subscriberOptionalObj.get();
            ob834FileDetails.setFirstName((String) subscriberObj.get(3));
            ob834FileDetails.setLastName((String) subscriberObj.get(2));
            ob834FileDetails.setSsn((String) subscriberObj.get(8));
        }

        if(updatedSubscriberOptionalObj.isPresent()){
            ArrayList<?> updatedSubscriberObj = (ArrayList<?>) updatedSubscriberOptionalObj.get();
            ob834FileDetails.setUpdatedFirstName((String) updatedSubscriberObj.get(2));
            ob834FileDetails.setUpdatedLastName((String) updatedSubscriberObj.get(3));
            ob834FileDetails.setUpdatedSsn((String) updatedSubscriberObj.get(8));
        }

        if(incorrectEntityOptional.isPresent()){
            ArrayList<?> incorrectEntityOptionalObj = (ArrayList<?>) incorrectEntityOptional.get();
            ob834FileDetails.setIncorrectEntityIdCode((String) incorrectEntityOptionalObj.get(0));
            ob834FileDetails.setIncorrectIdCodeQualifier((String) incorrectEntityOptionalObj.get(7));
            ob834FileDetails.setIncorrectIdCode((String) incorrectEntityOptionalObj.get(8));
        }



        List<Ob834FileDetails> ob834FileRecords = SharedData.getOb834FileDetails();
        if(ob834FileRecords==null){
            ob834FileRecords = new ArrayList<>();
        }
        ob834FileRecords.add(ob834FileDetails);
        SharedData.setOb834FileDetails(ob834FileRecords);
    }

    public void validateOb834Record(List<Map<String, String>> expectedValues){
        // TO DO - Adjust the format - actual vs expected.
        MemberDetails subscriber = SharedData.getPrimaryMember();
        Map<String, String> medicalRecord = expectedValues.get(0);
        Map<String, String> dentalRecord = expectedValues.get(1);
        List<Ob834FileDetails> ob834Records = SharedData.getOb834FileDetails();

        Optional<Ob834FileDetails> actualMedicalFileDataOptional = ob834Records.stream().filter(e-> e.getInsurance_line_code().equals("HLT")).findFirst();
        if(actualMedicalFileDataOptional.isPresent()){
            Ob834FileDetails actualMedicalFileData = actualMedicalFileDataOptional.get();
            validateMedicalRecord(actualMedicalFileData, medicalRecord);
        }
        Optional<Ob834FileDetails> actualDentalFileDataOptional = ob834Records.stream().filter(e-> e.getInsurance_line_code().equals("DEN")).findFirst();
        if(actualDentalFileDataOptional.isPresent()){
            Ob834FileDetails actualDentalFileData = actualDentalFileDataOptional.get();
            validateMedicalRecord(actualDentalFileData, medicalRecord);
            validateDentalRecord(actualDentalFileData, dentalRecord);
        }

        // validate the common data for both the records below - TO DO
        for(Ob834FileDetails record: ob834Records){
            softAssert.assertEquals(subscriber.getFirstName(), record.getFirstName(), "First name did not match" );
            softAssert.assertEquals(subscriber.getLastName(), record.getLastName(), "First name did not match" );
            softAssert.assertEquals(subscriber.getSsn(), record.getSsn(), "SSN did not match" );
            softAssert.assertEquals(subscriber.getMedicalPlanStartDate(), record.getBenefit_startDate(), "benefit start date did not match");
            softAssert.assertEquals(subscriber.getMedicalPlanEndDate(), record.getBenefit_endDate(), "benefit end date did not match");
            softAssert.assertEquals(subscriber.getMedicalFinancialStartDate(), record.getFinancial_effectiveDate());
            //  softAssert.assertAll();
        }
    }

    public void validateMedicalRecord( Ob834FileDetails ob834Record, Map<String, String> expectedResult){
        softAssert.assertEquals(expectedResult.get("maintenance_type_code"), ob834Record.getMaint_type_code(), "maint type code did not match");
        softAssert.assertEquals(expectedResult.get("hd_maint_type_code"), ob834Record.getHd_maint_typeCode());
        softAssert.assertEquals(expectedResult.get("maintenance_reas_code"), ob834Record.getMaint_reasCode());
        softAssert.assertEquals(expectedResult.get("incorrect_entity_id_code"), ob834Record.getIncorrectEntityIdCode());
        softAssert.assertEquals(expectedResult.get("incorrect_id_code_qualifier"), ob834Record.getIncorrectIdCodeQualifier());
        softAssert.assertEquals(expectedResult.get("incorrect_entity_id_code"), ob834Record.getIncorrectEntityIdCode());
        softAssert.assertEquals(expectedResult.get("addl_maint_reason"), ob834Record.getAddtl_maintreason());
        //  sponsor_id  | incorrect_id_code - Any other validations?
        //  softAssert.assertAll();
    }

    public void validateDentalRecord(Ob834FileDetails ob834Record, Map<String, String> expectedResult){
    }
}
