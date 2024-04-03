package com.c4hco.test.automation.sftpConfig;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.Ob834FileDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
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
        int sftpPort = 10021;
                // setSftpPort();

        try{
            JSch jsch = new JSch();
            jsch.addIdentity(privateKeyPath);
                System.out.println("sftpusername::"+sftpUsername);
            System.out.println("sftpPort::"+sftpPort
            );
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
            System.out.println("remotepath and file---"+remoteFilePath+fileNameToDownload);
            System.out.println("====localPath==="+localPath);
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
          System.out.println("file ---"+file);
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

           ListValuedMap<String, ArrayNode> segmentData = new ArrayListValuedHashMap<>();


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
                        break;

                    case ELEMENT_DATA:
                        String data = reader.getText();
                        currentSegmentArray.add(data);
                        break;
                    case END_SEGMENT:
                        if (currentSegmentName != null && currentSegmentArray != null) {
                            segmentData.put(currentSegmentName, currentSegmentArray);
                            segmentsObject.set(currentSegmentName, currentSegmentArray);
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
            getSegments(jsonObject);
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSegments(JSONObject jsonObj) {
        // TO DO:: Move this to a diff file - set OB834 segments and values.
        // Validate - no null values - if null - proceed and save the others.

        Ob834FileDetails ob834FileDetails = new Ob834FileDetails();

        // name segment
        JSONArray nameSegment = jsonObj.getJSONArray("N1");
        System.out.println(nameSegment.getJSONArray(0).get(1));
        ob834FileDetails.setSponsorName(String.valueOf(nameSegment.getJSONArray(0).get(1)));
        ob834FileDetails.setSponsorId(String.valueOf(nameSegment.getJSONArray(0).get(3)));

        Optional<Object> addlMainOptional = nameSegment.toList().stream().filter(o -> o.toString().contains("ADDL MAINT REASON")).findFirst();
        if(addlMainOptional.isPresent()){
          ArrayList<?> addlMainObj = (ArrayList<?>) addlMainOptional.get();
          ob834FileDetails.setAddtl_maintreason((String) addlMainObj.get(0));
        }

        // Individual Relationship Segment
        JSONArray insSegment = jsonObj.getJSONArray("INS");
        System.out.println("ins seg---" + insSegment);
        ob834FileDetails.setMaint_type_code(String.valueOf(insSegment.getJSONArray(0).get(2)));
        ob834FileDetails.setMaint_reasCode(String.valueOf(insSegment.getJSONArray(0).get(3)));



        // Date/Time Period Segment
        JSONArray dtpSegment = jsonObj.getJSONArray("DTP");
        System.out.println("dtp segment --" + dtpSegment); // JSONArray

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
        System.out.println("HD---" + hdSegment);
        ob834FileDetails.setHd_maint_typeCode(String.valueOf(hdSegment.getJSONArray(0).get(0)));
        ob834FileDetails.setInsurance_line_code(String.valueOf(hdSegment.getJSONArray(0).get(2)));

        // NM1
        JSONArray nm1Segment = jsonObj.getJSONArray("NM1");
        System.out.println("NM1---" + nm1Segment);

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
        softAssert.assertEquals(subscriber.getFinancialStartDate(), record.getFinancial_effectiveDate());
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