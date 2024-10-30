package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.edi.EdiValidations.Ib999FileValidations;
import com.c4hco.test.automation.edi.EdiValidations.Ob834FileValidations;
import com.c4hco.test.automation.edi.EdiValidations.Ob834FileValidations_new;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
     Ob834FileValidations ob834Validations = new Ob834FileValidations();
    Ob834FileValidations_new ob834Validations_new = new Ob834FileValidations_new();
   Ib999FileValidations ib999FileValidations = new Ib999FileValidations();

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

    @And("I download the file(s) from sftp server with location {string}")
    public void downloadFiles(String remoteLocation)  {
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


    @And("I validate the ob834 {string} file should have the values")
    public void validateOb834FileDetails(String type, List<Map<String, String>> lxExpectedDetailsFromStep) {
        switch (type) {
            case "medical":
                String medFileName = SharedData.getMedicalFileName();
                System.out.println("***********Validating Medical EDI File::"+SharedData.getMedicalFileName()+"***********");
                sftpUtil.readEdiFile(medFileName);
                ob834Validations_new.validateOb834MedFile(lxExpectedDetailsFromStep);
                break;
            case "dental":
                String denFileName = SharedData.getDentalFileName();
                sftpUtil.readEdiFile(denFileName);
                ob834Validations_new.validateOb834DenFile(lxExpectedDetailsFromStep);
                break;
            default:
                Assert.fail("Incorrect Argument passed in the step");
        }
    }

    @And("I validate the ob834 files should have the values")
    public void validateOb834Records(List<Map<String, String>> segments) {

        List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();

        for (Ob834DetailsEntity entry : ob834Entries) {
            if (entry.getInsurance_line_code().equals("HLT")) {
                sftpUtil.readEdiFile(SharedData.getMedicalFileName());
                System.out.println("***********Validating Medical EDI File::"+SharedData.getMedicalFileName()+"***********");
                ob834Validations.validateOb834File(entry);
                ob834Validations.validateMed_LXREFSeg(segments);
            } else if (entry.getInsurance_line_code().equals("DEN")) {
                System.out.println("***********Validating Dental EDI File::"+SharedData.getDentalFileName()+"***********");
                sftpUtil.readEdiFile(SharedData.getDentalFileName());
                ob834Validations.validateOb834File(entry);
                ob834Validations.validateDen_LXREFSeg(segments);
            }
        }
    }

    @And("I read the edi file locally")
    public void readEdiFile(){
        sftpUtil.readEdiFromLocal();
        // edi834Validations.validateOb834Record();
    }

    @And("I read the edi999 file locally") public void readEdi999File(){
        sftpUtil.readEdi999FromLocal();
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

    @And("I get I999 medical file name from DB and download it from sftp server location {string}")
        public void getI999MedicalFileToLocal(String inbound999FolderPath){
        try {
            List<Ib999Entity> ib999MedEntity = SharedData.getIb999MedDetailsEntities();
            for (Ib999Entity entry : ib999MedEntity) {
                String ib999MedFileName = entry.getFilename();
                SharedData.setMedicalIb999FileName(ib999MedFileName);
                System.out.println("File name from query:: " + ib999MedFileName);
                sftpUtil.downloadFileWithSftp(inbound999FolderPath, ib999MedFileName);
            }
        }catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @And("I get I999 dental file name from DB and download it from sftp server location {string}")
    public void getI999DentalFileToLocal(String inbound999FolderPath) {
        try {
            List<Ib999Entity> ib999DenEntity = SharedData.getIb999DenDetailsEntities();
            for (Ib999Entity entry : ib999DenEntity) {
                String ib999DenFileName = entry.getFilename();
                SharedData.setDentalIb999FileName(ib999DenFileName);
                System.out.println("File name from query:: " + ib999DenFileName);
                sftpUtil.downloadFileWithSftp(inbound999FolderPath, ib999DenFileName);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @And("I validate the contents of ib999 medical file")
    public void validateMedIb999Records() {
        List<Ib999Entity> ib999MedEntries = SharedData.getIb999MedDetailsEntities();
        for (Ib999Entity entry : ib999MedEntries) {
            if(entry.getAk1_group_ctrl_number().equals(SharedData.getMedGroupCtlNumber())) {
                System.out.println("***********Validating Medical Ib999 File:: " + SharedData.getMedicalIb999FileName() + "***********");
                sftpUtil.readIb999File(SharedData.getMedicalIb999FileName());
                ib999FileValidations.validateib999File(entry);
            }
        }
    }

    @And("I validate the contents of ib999 dental file")
    public void validateDenIb999Records() {
        List<Ib999Entity> ib999DenEntries = SharedData.getIb999DenDetailsEntities();
        for (Ib999Entity entry : ib999DenEntries) {
            System.out.println("***********Validating Dental Ib999 File:: "+SharedData.getDentalIb999FileName()+"***********");
            if(entry.getAk1_group_ctrl_number().equals(SharedData.getDenGroupCtlNumber())){
                sftpUtil.readIb999File(SharedData.getDentalIb999FileName());
                ib999FileValidations.validateib999File(entry);
            }
        }
    }

    @And("I validate the ib999 files should have the values")
    public void validateIb999Records() {
        sftpUtil.readIb999File(SharedData.getMedicalFileName());
    }

    @And("I download medical Ib834 file to local from sftp server location {string}")
    public void downloadIb834FileToTarget(String remoteLocation) throws JSchException {
        sftpUtil.downloadFileWithSftp(remoteLocation, SharedData.getMedicalIb834FileName());
            }

}