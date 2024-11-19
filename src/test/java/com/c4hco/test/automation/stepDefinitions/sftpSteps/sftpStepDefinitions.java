package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.edi.EdiValidations.Ib834FileValidations;
import com.c4hco.test.automation.edi.EdiValidations.Ib999FileValidations;
import com.c4hco.test.automation.edi.EdiValidations.Ob834FileValidations;
import com.c4hco.test.automation.edi.EdiValidations.Ob834FileValidations_new;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
     Ob834FileValidations ob834Validations = new Ob834FileValidations();
    Ob834FileValidations_new ob834Validations_new = new Ob834FileValidations_new();
   Ib999FileValidations ib999FileValidations = new Ib999FileValidations();
   Ib834FileValidations ib834FileValidations = new Ib834FileValidations();

    @And("I download the medical and dental files from sftp server with location {string}")
    public void downloadMedDenFiles(String remoteLocation)  {
        try{
            String sftpDownloadPath = sftpUtil.getLocalSftpDownloadPath();
            SharedData.setLocalPathToDownloadFile(sftpDownloadPath);
            sftpUtil.downloadFileWithSftp(remoteLocation, SharedData.getMedicalFileName());
            sftpUtil.downloadFileWithSftp(remoteLocation, SharedData.getDentalFileName());
        } catch(Exception e){
            // fail
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
                sftpUtil.readIb999File(medFileName);
                break;
            case "dental":
                String denFileName = SharedData.getDentalOb999FileName();
                System.out.println("***********Validating Dental OB999 File::"+denFileName+"***********");
               // sftpUtil.readIb999File(denFileName);
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
       // ib999FileValidations.validateIb999FileData(type);
    }

    @And("I download the {string} file from sftp server with location {string}")
    public void downloadIb999Files(String fileType, String inbound999RemotePath) {
        switch (fileType) {
            case "medical":
                sftpUtil.downloadFileWithSftp(inbound999RemotePath, SharedData.getMedicalIb999FileName());
                break;
            case "dental":
                sftpUtil.downloadFileWithSftp(inbound999RemotePath, SharedData.getDentalIb999FileName());
                break;
            default: Assert.fail("Invalid argument::"+ fileType);
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
                System.out.println("***Validating Medical EDI File::"+medIb834FileName+"***");
                sftpUtil.readEdiFile(medIb834FileName);
                ib834FileValidations.validateIb834MedFile();
                break;
            case "dental":
                String denIb834FileName = SharedData.getDentalIb834FileName();
                System.out.println("***Validating Dental EDI File::"+denIb834FileName+"***");
                sftpUtil.readEdiFile(denIb834FileName);
               // ib834FileValidations.validateIb834DenFile();
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }



}