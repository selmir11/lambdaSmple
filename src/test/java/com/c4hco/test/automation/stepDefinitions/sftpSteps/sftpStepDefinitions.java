package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.edi.EdiValidations.Ob834Validations;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
    Ob834Validations ob834Validations = new Ob834Validations();
    @And("I download the file(s) from sftp server with location {string}")
    public void downloadFiles(String remoteLocation)  {
        // move the code to sftp Util - WIP
        try{
            List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();
            String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
            SharedData.setLocalPathToDownloadFile(sftpDownloadPath);

            for (Ob834DetailsEntity entry : ob834Entries) {
                if (entry.getInsurance_line_code().equals("HLT")) {
                    SharedData.setMedicalFileName(entry.getFilename());
                    sftpUtil.downloadFileWithSftp(remoteLocation, entry.getFilename());

                } else if (entry.getInsurance_line_code().equals("DEN")) {
                    SharedData.setDentalFileName(entry.getFilename());
                    sftpUtil.downloadFileWithSftp(remoteLocation, entry.getFilename());
                }
            }

        } catch(Exception e){
            // fail
        }

    }

    @And("I validate the ob834 files should not be empty")
    public void validateOb834RecordsNotNull(){
        sftpUtil.validateFileIsNotEmpty(SharedData.getMedicalFileName());
        sftpUtil.validateFileIsNotEmpty(SharedData.getDentalFileName());
    }

    @And("I validate the ob834 files should have the values")
    public void validateOb834Records(List<Map<String, String>> expectedValues) {

        List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();

        for (Ob834DetailsEntity entry : ob834Entries) {
            if (entry.getInsurance_line_code().equals("HLT")) {
                sftpUtil.readEdiFile(SharedData.getMedicalFileName());
                ob834Validations.validateOb834File();
            } else if (entry.getInsurance_line_code().equals("DEN")) {
                sftpUtil.readEdiFile(SharedData.getDentalFileName());
                ob834Validations.validateOb834File();
            }
        }

    }


    @And("I read the edi file locally")
    public void readEdiFile(){
        sftpUtil.readEdiFromLocal();
       // edi834Validations.validateOb834Record();
    }

}
