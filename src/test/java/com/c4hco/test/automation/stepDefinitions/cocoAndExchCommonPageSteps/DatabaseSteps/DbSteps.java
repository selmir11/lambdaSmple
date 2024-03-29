package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.DatabaseSteps;

import com.c4hco.test.automation.database.DbValidations.DbValidations;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import io.cucumber.java.en.And;

public class DbSteps {
private DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
private DbValidations dbValidations = new DbValidations();

// SftpUtil sftpUtil = new SftpUtil();


   @And("I validate member exists in policy table")
   public void memberExistsInPolicyTable(){
      dbValidations.validateMemberExistsInPolicyTable();
   }

//   @And("I validate member exists in ob834_details table")
//   public void memberExistsInPreEdiTable(){
//      dbValidations.validateMemberExistsInOb834DetailsTable();
//   }

//   @And("I validate file exists on sftp server with location {string}")
//   public void validateFileExists(String sftpRemoteLocation) throws JSchException {
//      List<Ob834DetailsEntity> ob834DetailsEntityList = exchDbDataProvider.getFileNames();
//     String medicalPlanFile = ob834DetailsEntityList.get(0).getFile_name();
//     String dentalPlanFile = ob834DetailsEntityList.get(1).getFile_name();
//      sftpUtil.connectToSftp();
//      sftpUtil.downloadFileWithSftp(sftpRemoteLocation, medicalPlanFile);
//      sftpUtil.downloadFileWithSftp(sftpRemoteLocation, dentalPlanFile);
//      sftpUtil.disconnectFromSftp();
//   }


   @And("I validate the member details from few tables")
   public void isMemberInPolicyTable(){
      dbValidations.validateDataFromMultipleTables();
   }

   @And("I validate member details from ob834_details table")
   public void isMemberInPreEdiTable(){
      dbValidations.validateOb834Data();
   }

   @And("I get the file name from the pre-edi table")
   public void getFileName(){

   }

}
