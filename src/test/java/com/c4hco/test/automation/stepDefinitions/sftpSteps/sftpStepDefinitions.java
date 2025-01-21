package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.edi.EdiValidations.*;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;
import org.testng.Assert;

import java.util.List;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
   Ob834FileValidations ob834Validations_new = new Ob834FileValidations();
   Ib999FileValidations ib999FileValidations = new Ib999FileValidations();
   Ob999FileValidations ob999FileValidations = new Ob999FileValidations();
   Ib834FileValidations ib834FileValidations = new Ib834FileValidations();
   Ob834FileValidations_Grps ob834FileValidations_Grps = new Ob834FileValidations_Grps();

    @And("I download the medical and dental files from sftp server with location {string}")
    public void downloadMedDenFiles(String remoteLocation)  {
        try{
            String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
            SharedData.setLocalPathToDownloadFile(sftpDownloadPath);
            List<String> allFiles = SharedData.getMedicalFileName_grp();
          //  allFiles.addAll(SharedData.getDentalFileName_grp());
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
    public void validateOb834FileDetails(String type) {
        switch (type) {
            case "medical":
                String medFileName = SharedData.getMedicalFileName();
                System.out.println("***********Validating Medical EDI File::"+medFileName+"***********");
                sftpUtil.readEdiFile(medFileName);
                ob834Validations_new.validateOb834MedFile();
                break;
            case "dental":
                String denFileName = SharedData.getDentalFileName();
                System.out.println("***********Validating Dental EDI File::"+denFileName+"***********");
                sftpUtil.readEdiFile(denFileName);
               ob834Validations_new.validateOb834DenFile();
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }

    @And("I validate the ob834 {string} file data for groups")
    public void validateOb834FileDetails_grp(String type) {
        switch (type) {
            case "medical":
                List<String> medFileNames = SharedData.getMedicalFileName_grp();
                for(String medFileName: medFileNames){
                    System.out.println("***********Validating Medical EDI File::"+medFileName+"***********");
                    sftpUtil.readEdiFile(medFileName);
                    ob834FileValidations_Grps.validateOb834MedFile(medFileName);
                }
                break;
            case "dental":
                List<String> denFileNames = SharedData.getDentalFileName_grp();
                for(String denFileName: denFileNames){
                    System.out.println("***********Validating Dental EDI File::"+denFileName+"***********");
                    sftpUtil.readEdiFile(denFileName);
                    ob834FileValidations_Grps.validateOb834DenFile(denFileName);
                }
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }

    @And("I upload medical ob834 edi files to sftp server with location {string}")
    public void uploadMedOb834fileToSftp(String remoteFilePath) throws JSchException {
                String fileName = SharedData.getMedicalFileName();
                sftpUtil.uploadFileInSftp(fileName, remoteFilePath);
    }
    @And("I upload dental ob834 edi files to sftp server with location {string}")
    public void uploadDenOb834fileToSftp(String remoteFilePath) throws JSchException {
                String fileName = SharedData.getDentalFileName();
                sftpUtil.uploadFileInSftp(fileName, remoteFilePath);
    }

    @And("I validate the ib999 {string} file data")
    public void validateIb999FileDetails(String type) {
        switch (type) {
            case "medical":
                String medFileName = SharedData.getMedicalIb999FileName();
                System.out.println("***********Validating Medical IB999 File::"+medFileName+"***********");
                sftpUtil.readIb999File(medFileName);
                break;
            case "dental":
                String denFileName = SharedData.getDentalIb999FileName();
                System.out.println("***********Validating Dental IB999 File::"+denFileName+"***********");
                sftpUtil.readIb999File(denFileName);
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
        ib999FileValidations.validateIb999FileData(type);
    }

    @And("I validate the ob999 {string} file data")
    public void validateOb999FileDetails(String type) {
        switch (type) {
            case "medical":
                String medFileName = SharedData.getMedicalOb999FileName();
                System.out.println("***********Validating Medical OB999 File::"+medFileName+"***********");
                sftpUtil.readOb999File(medFileName);
                break;
            case "dental":
                String denFileName = SharedData.getDentalOb999FileName();
                System.out.println("***********Validating Dental OB999 File::"+denFileName+"***********");
                sftpUtil.readOb999File(denFileName);
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
        ob999FileValidations.validateOb999FileData(type);
    }

    @And("I download the {string} ib999 file from sftp server with location {string}")
    public void downloadIb999Files(String fileType, String inbound999RemotePath) {
        String fileName;
        try {
            switch (fileType) {
                case "medical":
                    fileName = SharedData.getMedicalIb999FileName();
                    break;
                case "dental":
                    fileName = SharedData.getDentalIb999FileName();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid argument: " + fileType);
            }
            sftpUtil.downloadFileWithSftp(inbound999RemotePath, fileName);
        } catch (Exception e) {
            Assert.fail("Failed to download IB999 file for fileType: " + fileType + ", error: " + e.getMessage());
        }
    }

    @And("I download the {string} ob999 file from sftp server with location {string}")
    public void downloadOb999Files(String fileType, String remotePath) {
        String fileName;
        try {
            switch (fileType) {
                case "medical":
                    fileName = SharedData.getMedicalOb999FileName();
                    break;
                case "dental":
                    fileName = SharedData.getDentalOb999FileName();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid argument: " + fileType);
            }
            sftpUtil.downloadFileWithSftp(remotePath, fileName);
        } catch (Exception e) {
            Assert.fail("Failed to download IB999 file for fileType: " + fileType + ", error: " + e.getMessage());
        }
    }

    @And("I validate the ib999 files should have the values")
    public void validateIb999Records() {
        sftpUtil.readIb999File(SharedData.getMedicalFileName());
    }

    @And("I download the {string} ib834 file from sftp server location {string}")
    public void downloadIb834MedFileToTarget(String recordType, String remoteLocation) throws JSchException {
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
    public void validateIb834FileDetails(String type) {
        switch (type) {
            case "medical":
                String medIb834FileName = SharedData.getMedicalIb834FileName();
                System.out.println("***Validating Ib834 Medical EDI File::"+medIb834FileName+"***");
                sftpUtil.readIb834EdiFile(medIb834FileName);
                ib834FileValidations.validateIb834MedFile();
                break;
            case "dental":
                String denIb834FileName = SharedData.getDentalIb834FileName();
                System.out.println("***Validating Ib834  Dental EDI File::"+denIb834FileName+"***");
                sftpUtil.readIb834EdiFile(denIb834FileName);
                ib834FileValidations.validateIb834DenFile();
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }



}