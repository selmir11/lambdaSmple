package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();

    @And("I download the file(s) from sftp server with location {string}")
    public void downloadFiles(String remoteLocation) throws JSchException {

        // TO DO:: This file name validation can fo to DB Validations - see if we do not need to save entity in shared data.
        // Set Medical file name and dental fileName in SharedData - Later can change it to List.

        Map<String, String> insCodeAndFileName = new HashMap<>();;

      List<Ob834DetailsEntity> ob834Entries =  SharedData.getOb834DetailsEntities();
      for(Ob834DetailsEntity entry: ob834Entries){
          System.out.println("entry ---::"+entry);
         System.out.println("Insurance line code "+ entry.getInsurance_line_code());
                System.out.println("fileName from entry--"+entry.getFilename());
          insCodeAndFileName.put(entry.getInsurance_line_code(), entry.getFilename());
      }

      String medicalFileName = insCodeAndFileName.get("HLT");
      String dentalFileName = insCodeAndFileName.get("DEN");

      SharedData.setMedicalFileName(medicalFileName);
      SharedData.setDentalFileName(dentalFileName);


      List<String> fileNames = new ArrayList<>();

      fileNames.add(medicalFileName);
      fileNames.add(dentalFileName);
      System.out.println("--med file name--"+medicalFileName);
        System.out.println("--dental file name--"+dentalFileName);

        System.out.println("filenNEMA--"+fileNames);

        for(String filename: fileNames){
          System.out.println("fileName--"+filename);
          sftpUtil.downloadFileWithSftp(remoteLocation, filename);

      }


    }

    @And("I validate the ob834 files should have the values")
    public void validateOb834Records(List<Map<String, String>> expectedValues){
        sftpUtil.readEdiFile(SharedData.getMedicalFileName());
        sftpUtil.validateOb834Record(expectedValues);
    }

}
