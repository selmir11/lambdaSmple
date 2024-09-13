package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.edi.EdiValidations.Ob834FileValidations;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();
    Ob834FileValidations ob834Validations = new Ob834FileValidations();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
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
    public void validateOb834Records(List<Map<String, String>> segments) {

        List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();

        for (Ob834DetailsEntity entry : ob834Entries) {
            if (entry.getInsurance_line_code().equals("HLT")) {
                sftpUtil.readEdiFile(SharedData.getMedicalFileName());
                ob834Validations.validateOb834File(entry);
            } else if (entry.getInsurance_line_code().equals("DEN")) {
                sftpUtil.readEdiFile(SharedData.getDentalFileName());
                ob834Validations.validateOb834File(entry);
            }
        }
    }

    @And("I read the edi file locally")
    public void readEdiFile(){
        sftpUtil.readEdiFromLocal();
        // edi834Validations.validateOb834Record();
    }
    @And("I upload medical and dental edi files to sftp server with location {string}")
    public void uploadAfileToSftp(String remoteFilePath) throws JSchException {
        List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();

        for (Ob834DetailsEntity entry : ob834Entries) {
            if (entry.getInsurance_line_code().equals("HLT")) {
                String fileName = SharedData.getMedicalFileName();
                sftpUtil.uploadFileInSftp(fileName, remoteFilePath);
            } else if (entry.getInsurance_line_code().equals("DEN")) {
                String fileName = SharedData.getDentalFileName();
                sftpUtil.uploadFileInSftp(fileName, remoteFilePath);
            }
        }
    }
        @And("I get I999 medical file name from DB and download it from sftp server location {string}")
        public void getI999MedicalFileToLocal(String inbound999FolderPath){
        try {
            List<Ib999Entity> ib999MedEntity = exchDbDataProvider.getIb999Details(SharedData.getMedGroupCtlNumber());
            for (Ib999Entity entry : ib999MedEntity) {
                String ib999MedFileName = entry.getFilename();
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
            List<Ib999Entity> ib999DenEntity = exchDbDataProvider.getIb999Details(SharedData.getDenGroupCtlNumber());
            for (Ib999Entity entry : ib999DenEntity) {
                String ib999DenFileName = entry.getFilename();
                System.out.println("File name from query:: " + ib999DenFileName);
                sftpUtil.downloadFileWithSftp(inbound999FolderPath, ib999DenFileName);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

}