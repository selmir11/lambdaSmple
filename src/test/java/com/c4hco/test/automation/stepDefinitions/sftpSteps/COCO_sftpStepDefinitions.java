package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.edi.EdiValidations.*;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import io.cucumber.java.en.And;

public class COCO_sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
   COCO_Ob834FileValidations ob834Validations_coco = new COCO_Ob834FileValidations();

    @And("I download the medical files from coco sftp server with location {string}")
    public void downloadMedFiles(String remoteLocation)  {
            String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
            SharedData.setLocalPathToDownloadFile(sftpDownloadPath);
            sftpUtil.downloadFileWithSftp(remoteLocation, SharedData.getMedicalFileName());
    }
    @And("I validate the coco ob834 medical file data")
    public void validateOb834FileDetails() {
         String medFileName = SharedData.getMedicalFileName();
         System.out.println("***********Validating Medical EDI File::"+medFileName+"***********");
         sftpUtil.readEdiFile(medFileName);
         ob834Validations_coco.validateOb834MedFile();
    }
    @And("I validate the coco ob834 medical file data that present in localPath or coco sftp server {string}")
    public void validateOB834FileDownloadedAndValidateOb834FileDetails(String remoteLocation){
        String medFileName = SharedData.getMedicalFileName();
        sftpUtil.checkEdiFileLocalOrSftp(medFileName,remoteLocation);
        System.out.println("***********Validating Medical EDI File::"+medFileName+"***********");
        sftpUtil.readEdiFile(medFileName);
        ob834Validations_coco.validateOb834MedFile();
    }
}