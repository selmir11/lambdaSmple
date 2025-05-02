package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.edi.EdiValidations.*;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import io.cucumber.java.en.And;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
   Ib999FileValidations ib999FileValidations = new Ib999FileValidations();
   Ob999FileValidations ob999FileValidations = new Ob999FileValidations();
   Ib834FileValidation ib834FileValidations_grps = new Ib834FileValidation();
   Ob834FileValidations ob834FileValidations = new Ob834FileValidations();
    COCO_ib834FileValidations coco_ib834FileValidations = new COCO_ib834FileValidations();

    @And("I download the medical and dental files from sftp server with location {string}")
    public void downloadMedDenFiles(String remoteLocation)  {
        try{
             String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
            SharedData.setLocalPathToDownloadFile(sftpDownloadPath);
            List<String> allFiles = new ArrayList<>();
            if(!SharedData.getAppType().equals("coco")) {
                allFiles.addAll(SharedData.getDentalFileName_grp());
            }
            allFiles.addAll(SharedData.getMedicalFileName_grp());
            for(String fileName: allFiles){
                sftpUtil.downloadFileWithSftp(remoteLocation, fileName);
            }
        } catch(Exception e){
           Assert.fail("Failed with this exception::"+e);
        }
    }

    @And("I validate the ob834 files should not be empty")
    public void validateOb834RecordsNotNull(){
        sftpUtil.validateFileIsNotEmpty(SharedData.getMedicalFileName());
        sftpUtil.validateFileIsNotEmpty(SharedData.getDentalFileName());
    }

    @And("I validate the ob834 {string} file data")
    public void validateOb834FileDetails_grp(String type) {
        switch (type) {
            case "medical":
                List<String> medFileNames = SharedData.getMedicalFileName_grp();
                for(String medFileName: medFileNames){
                    System.out.println("***********Validating Medical EDI File::"+medFileName+"***********");
                    sftpUtil.readEdiFile(medFileName);
                    ob834FileValidations.validateOb834MedFile(medFileName);
                }
                break;
            case "dental":
                List<String> denFileNames = SharedData.getDentalFileName_grp();
                for(String denFileName: denFileNames){
                    System.out.println("***********Validating Dental EDI File::"+denFileName+"***********");
                    sftpUtil.readEdiFile(denFileName);
                    ob834FileValidations.validateOb834DenFile(denFileName);
                }
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }


    @And("I upload all the {string} ob834 edi files to sftp server with location {string}")
    public void uploadMedOb834Files(String fileType, String remoteFileLocation) {
        List<String> fileNames = new ArrayList<>();
        switch(fileType){
            case "medical":
                fileNames = SharedData.getMedicalFileName_grp();
                break;
            case "dental":
                fileNames = SharedData.getDentalFileName_grp();
                break;
            default: Assert.fail("Illegal argument passed");
        }
        for(String fileName: fileNames){
            sftpUtil.uploadFileInSftp(fileName, remoteFileLocation);
        }
    }

    @And("I validate the ib999 {string} file data")
    public void validateIb999FileDetails(String type) {
        switch (type) {
            case "medical":
                List<String> medFileNames = SharedData.getMedicalIb999FileNames();
                for(String medFileName:medFileNames){
                    System.out.println("***********Validating Medical IB999 File::"+medFileName+"***********");
                    sftpUtil.readIb999File(medFileName);
                    ib999FileValidations.validateIb999MedFileData();
                }
                break;
            case "dental":
                List<String> denFileNames = SharedData.getDentalIb999FileNames();
                for(String denFileName:denFileNames){
                    System.out.println("***********Validating Dental IB999 File::"+denFileName+"***********");
                    sftpUtil.readIb999File(denFileName);
                    ib999FileValidations.validateIb999DenFileData();
                }
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }

    }

    @And("I validate the ob999 {string} file data")
    public void validateOb999FileDetails(String type) {
        switch (type) {
            case "medical":
                List<String> medFileNames = SharedData.getMedicalOb999FileNames();
                for(String medFileName: medFileNames){
                    System.out.println("***********Validating Medical OB999 File::"+medFileName+"***********");
                    sftpUtil.readOb999File(medFileName);
                    ob999FileValidations.validateOb999MedFileData();
                }
                break;
            case "dental":
                List<String> denFileNames = SharedData.getDentalOb999FileNames();
                for(String denFileName: denFileNames){
                    System.out.println("***********Validating Dental OB999 File::"+denFileName+"***********");
                    sftpUtil.readOb999File(denFileName);
                    ob999FileValidations.validateOb999DenFileData();
                }
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }

    @And("I download the {string} ib999 file from sftp server with location {string}")
    @And("I download the {string} ib999 files from sftp server with location {string}")
    public void downloadIb999Files(String fileType, String inbound999RemotePath) {
        List<String> fileNames = null;
            switch (fileType) {
                case "medical":
                    fileNames = SharedData.getMedicalIb999FileNames();
                    break;
                case "dental":
                    fileNames = SharedData.getDentalIb999FileNames();
                    break;
                default:
                    Assert.fail("Invalid argument: " + fileType);
        }
        for(String fileName: fileNames){
            sftpUtil.downloadFileWithSftp(inbound999RemotePath, fileName);
        }
    }

    @And("I download the {string} ob999 file from sftp server with location {string}")
    public void downloadOb999Files(String fileType, String remotePath) {
        List<String> fileNames = null;
        List<String> uniqueFileNamesList= null;
            switch (fileType) {
                case "medical":
                    fileNames = SharedData.getMedicalOb999FileNames();
                    Set<String> uniqueFileNames = new HashSet<>(fileNames);
                    uniqueFileNamesList = uniqueFileNames.stream().collect(Collectors.toList());
                    break;
                case "dental":
                    fileNames = SharedData.getDentalOb999FileNames();
                    Set<String> uniqueDenFileNames = new HashSet<>(fileNames);
                    uniqueFileNamesList = uniqueDenFileNames.stream().collect(Collectors.toList());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid argument: " + fileType);
            }
        for(String fileName: uniqueFileNamesList){
            sftpUtil.downloadOb999File(remotePath, fileName);
        }
    }

    @And("I validate the ib999 files should have the values")
    public void validateIb999Records() {
        sftpUtil.readIb999File(SharedData.getMedicalFileName());
    }

    @And("I download the {string} ib834 file from sftp server location {string}")
    public void downloadIb834MedFileToTarget(String recordType, String remoteLocation)  {
        switch (recordType) {
            case "medical":
                sftpUtil.downloadFileWithSftp(remoteLocation, SharedData.getMedicalIb834FileName());
                break;
            case "dental":
                sftpUtil.downloadFileWithSftp(remoteLocation, SharedData.getDentalIb834FileName());
                break;
            default:
                Assert.fail("Record Type does not exist.");

        }
    }

    @And("I validate the ib834 {string} file data")
    @And("I validate the ib834 {string} files data")
    public void validateIb834FileDetails(String type) {
        switch (type) {
            case "medical":
                List<String> medFileNames = SharedData.getMedicalIb834FileNames();
                for(String medIb834FileName: medFileNames){
                    System.out.println("***Validating Ib834 Medical EDI File::"+medIb834FileName+"***");
                    sftpUtil.readIb834EdiFile(medIb834FileName);
                    ib834FileValidations_grps.validateIb834MedFile(medIb834FileName);
                }
                break;
            case "dental":
                List<String> denIb834FileNames = SharedData.getDentalIb834FileNames();
                for(String denIb834FileName: denIb834FileNames){
                    System.out.println("***Validating Ib834  Dental EDI File::"+denIb834FileName+"***");
                    sftpUtil.readIb834EdiFile(denIb834FileName);
                    ib834FileValidations_grps.validateIb834DenFile(denIb834FileName);
                }
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }
    @And("I validate coco Ib834 file data")
    public void validateIb834FileDetails(){
        List<String> medFileNames = SharedData.getMedicalIb834FileNames();
        for(String medIb834FileName: medFileNames){
            System.out.println("***Validating Ib834 Medical EDI File::"+medIb834FileName+"***");
            sftpUtil.readIb834EdiFile(medIb834FileName);
            coco_ib834FileValidations.validateCocoIb834MedFile(medIb834FileName);
        }
    }
}