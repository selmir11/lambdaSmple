package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.DbValidations.COCO_Ib999DbValidations;
import com.c4hco.test.automation.edi.EdiValidations.*;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import io.cucumber.java.en.And;

import java.util.*;

public class COCO_sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
   COCO_Ob834FileValidations ob834Validations_coco = new COCO_Ob834FileValidations();
    COCO_Grp_Ob834FileValidations cocoGrpOb834FileValidations = new COCO_Grp_Ob834FileValidations();
    COCO_Ib999DbValidations cocoIb999DbValidations = new COCO_Ib999DbValidations();
    COCO_Ib999FileValidations cocoIb999FileValidations = new COCO_Ib999FileValidations();
    COCO_Ob999FileValidations cocoOb999FileValidations = new COCO_Ob999FileValidations();
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
    @And("I validate different issuer medical files in coco")
    public void validateMultipleOb834Files(){
        List<String> groupfiles = SharedData.getMedicalFileName_grp();
        for(String medFileName: groupfiles){
            System.out.println("***********Validating COCO Medical EDI File::"+medFileName+"***********");
            sftpUtil.readEdiFile(medFileName);
            cocoGrpOb834FileValidations.validateOb834MedFile(medFileName);
        }
    }
    @And("I upload coco files on to sftp server location {string}")
    public void uploadMultipleFiles( String remoteFileLocation){
        List<String> fileNames = SharedData.getMedicalFileName_grp();
        for(String fileName: fileNames){
            sftpUtil.uploadFileInSftp(fileName, remoteFileLocation);
        }
    }
    @And("I validate coco entities from ib999_details db table")
    public void validateIb999DetailsDB(){
        cocoIb999DbValidations.ib999RecordsValidations();
    }

    @And("I validate the COCO ib999 file data")
    public void validateIb999FileDetails() {
        List<String> medFileNames = SharedData.getMedicalIb999FileNames();
        for (String cocoIb999file : medFileNames) {
            System.out.println("***********Validating COCO IB999 File::" + cocoIb999file + "***********");
            sftpUtil.readIb999File(cocoIb999file);
            cocoIb999FileValidations.ib999FilesValidations(cocoIb999file);
        }
    }
    @And("I download coco ib834 files from sftp location {string}")
    public void downloadIb834FilesFromServer(String remotePath) {
        String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
        SharedData.setLocalPathToDownloadFile(sftpDownloadPath);

        List<String> allIb834Files = SharedData.getMedicalIb834FileNames();
        Set<String> uniqueib834Files = new HashSet<>(allIb834Files);
        SharedData.setMedicalIb834FileNames(new ArrayList<>(uniqueib834Files));
       for(String file: uniqueib834Files){
           sftpUtil.downloadFileWithSftp(remotePath, file);
       }
    }
    @And("I download coco ob999 files from sftp location {string}")
    public void downloadOb999FilesFromServer(String remotePath) {
        String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
        SharedData.setLocalPathToDownloadFile(sftpDownloadPath);

        List<String> allOb999Files = SharedData.getMedicalOb999FileNames();
        Set<String> uniqueOb999Files = new HashSet<>(allOb999Files);
        SharedData.setMedicalOb999FileNames(new ArrayList<>(uniqueOb999Files));
        for(String file: uniqueOb999Files){
            sftpUtil.downloadFileWithSftp(remotePath, file);
        }
    }
    @And("I validate the COCO Ob999 file data")
    public void validateOb999FileDetails() {
        List<String> ob999FileNames = SharedData.getMedicalOb999FileNames();
        for (String cocoOb999file : ob999FileNames) {
            System.out.println("***********Validating COCO OB999 File::" + cocoOb999file + "***********");
            sftpUtil.readOb999File(cocoOb999file);
            cocoOb999FileValidations.Ob999FilesValidations(cocoOb999file);
        }
    }
}