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
    private String sftpFolderPath;

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
     // separate from download? As we are downloading 2files, no need to connect twice!! connecting once is enough to download multiple files
            connectToSftp();
        String localPath = getLocalSftpDownloadPath();
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

    private String getLocalSftpDownloadPath(){
        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
         sftpFolderPath = "target/sftp-downloads/download-" + timestamp;
       // - local testing development -   sftpFolderPath = "target/sftp-downloads/download-03302024-095143";
        // Create the timestamped folder
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

            try{
          File file = new File(sftpFolderPath+"\\"+filename);
          System.out.println("file ---"+file);
                InputStream inputStream = new FileInputStream(file);

                if (inputStream != null) {
                    System.out.println("File found");

                    parseEdiFile(inputStream);
                } else {
                    // File not found
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
                        System.out.println("standard=="+standard);
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
        System.out.println("N!---" + nameSegment);
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
        System.out.println("dtp list --" + dtpSegment.toList()); // List<Object>

        Optional<Object> benefitBgnDtObj = dtpSegment.toList().stream()
                .filter(obj -> obj.toString().contains("348"))
                .findFirst();

        Optional<Object> benefitEndDtObj = dtpSegment.toList().stream()
                .filter(obj -> obj.toString().contains("349"))
                .findFirst();

        if (benefitBgnDtObj.isPresent()) {
            System.out.println("optional get benefit::" + benefitBgnDtObj.get());

            ArrayList<?> variable = (ArrayList<?>) benefitBgnDtObj.get();
            System.out.println("===variable==" + variable);

            System.out.println("---get 2--" + variable.get(2));


            String benefitBgnDate = (String) variable.get(2);
            ob834FileDetails.setBenefit_startDate(benefitBgnDate);
        }

        if (benefitEndDtObj.isPresent()) {
                System.out.println("optional get benefit end date::" + benefitEndDtObj.get());

                ArrayList<?> variable1 = (ArrayList<?>) benefitEndDtObj.get();
                System.out.println("===variable==" + variable1);

                System.out.println("---get 2--" + variable1.get(2));


                String benefitEndDate = (String) variable1.get(2);
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


        SharedData.setOb834FileDetails(ob834FileDetails);


            System.out.println("f name  ---" + SharedData.getOb834FileDetails().getFirstName());
            System.out.println("l name  ---" + SharedData.getOb834FileDetails().getFirstName());
        System.out.println(" ssn  ---" + SharedData.getOb834FileDetails().getSsn());

        System.out.println("updated ssn  ---" + SharedData.getOb834FileDetails().getUpdatedSsn());

        System.out.println("main tyoe code ---" + SharedData.getOb834FileDetails().getMaint_type_code());
            System.out.println("benefit stat date ---" + SharedData.getOb834FileDetails().getBenefit_startDate());
            System.out.println("benefit end date ---" + SharedData.getOb834FileDetails().getBenefit_endDate());
        System.out.println("addl main code ---" + SharedData.getOb834FileDetails().getAddtl_maintreason());


    }

    public void validateOb834Record(List<Map<String, String>> expectedValues){
        // TO DO - Adjust the format - actual vs expected.
        SoftAssert softAssert = new SoftAssert();
        MemberDetails subscriber = SharedData.getPrimaryMember();
        Ob834FileDetails ob834Record = SharedData.getOb834FileDetails();
        Map<String, String> medicalRecord = expectedValues.get(0);

        softAssert.assertEquals(subscriber.getFirstName(), ob834Record.getFirstName(), "First name did not match" );
        softAssert.assertEquals(subscriber.getLastName(), ob834Record.getLastName(), "First name did not match" );
        softAssert.assertEquals(subscriber.getSsn(), ob834Record.getSsn(), "First name did not match" );
        softAssert.assertEquals(medicalRecord.get("maintenance_type_code"), ob834Record.getMaint_type_code(), "maint type code did not match");
        softAssert.assertEquals(subscriber.getMedicalPlanStartDate(), ob834Record.getBenefit_startDate(), "benefit start date did not match");
        softAssert.assertEquals(subscriber.getMedicalPlanEndDate(), ob834Record.getBenefit_endDate(), "benefit end date did not match");
        softAssert.assertEquals(subscriber.getFinancialStartDate(), ob834Record.getFinancial_effectiveDate());
        softAssert.assertEquals(medicalRecord.get("hd_maint_type_code"), ob834Record.getHd_maint_typeCode());
        softAssert.assertEquals(medicalRecord.get("maintenance_reas_code"), ob834Record.getMaint_reasCode());
        softAssert.assertEquals(medicalRecord.get("incorrect_entity_id_code"), ob834Record.getIncorrectEntityIdCode());
        softAssert.assertEquals(medicalRecord.get("incorrect_id_code_qualifier"), ob834Record.getIncorrectIdCodeQualifier());
        softAssert.assertEquals(medicalRecord.get("incorrect_entity_id_code"), ob834Record.getIncorrectEntityIdCode());
        softAssert.assertEquals(medicalRecord.get("addl_maint_reason"), ob834Record.getAddtl_maintreason());
      //  softAssert.assertAll();

        //  sponsor_id  | incorrect_id_code - Any other validations?
    }

}