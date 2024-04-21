package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.edi.EdiValidations.Edi834Validations;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
    Edi834Validations edi834Validations = new Edi834Validations();
    @And("I download the file(s) from sftp server with location {string}")
    public void downloadFiles(String remoteLocation) throws JSchException {
        List<String> ediFileNames = new ArrayList<>();
        List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();

        for (Ob834DetailsEntity entry : ob834Entries) {
            if (entry.getInsurance_line_code().equals("HLT")) {
                SharedData.setMedicalFileName(entry.getFilename());
            } else if (entry.getInsurance_line_code().equals("DEN")) {
                SharedData.setDentalFileName(entry.getFilename());
            }
            ediFileNames.add(entry.getFilename());
        }

       String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
        SharedData.setLocalPathToDownloadFile(sftpDownloadPath);
        for (String filename : ediFileNames) {
            sftpUtil.downloadFileWithSftp(remoteLocation, filename);
        }

    }

    @And("I validate the ob834 files should have the values")
    public void validateOb834Records(List<Map<String, String>> expectedValues) {
        List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();

        for (Ob834DetailsEntity entry : ob834Entries) {
            if (entry.getInsurance_line_code().equals("HLT")) {
                sftpUtil.readEdiFile(SharedData.getMedicalFileName());
            } else if (entry.getInsurance_line_code().equals("DEN")) {
                sftpUtil.readEdiFile(SharedData.getDentalFileName());
            }
            edi834Validations.validateOb834Record(expectedValues);
        }

    }

    @And("I read the edi file locally")
    public void readEdiFile(){
        sftpUtil.readEdiFromLocal();
    }

}
