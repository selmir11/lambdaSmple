package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.DatabaseSteps;

import com.c4hco.test.automation.database.DbValidations.DbValidations;
import com.c4hco.test.automation.database.ModelObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class DbSteps {
private DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
private DbValidations dbValidations = new DbValidations();
SftpUtil sftpUtil = new SftpUtil();


   @And("I validate member exists in policy table")
   public void memberExistsInPolicyTable(){
      dbValidations.validateMemberExistsInPolicyTable();
   }

   @And("I validate member exists in ob834_details table")
   public void memberExistsInPreEdiTable(){
      dbValidations.validateMemberExistsInOb834DetailsTable();
   }

   @And("I validate file exists on sftp server with location {string}")
   public void validateFileExists(String sftpRemoteLocation) throws JSchException {
      List<Ob834DetailsEntity> ob834DetailsEntityList = exchDbDataProvider.getFileNames();
     String medicalPlanFile = ob834DetailsEntityList.get(0).getFile_name();
     String dentalPlanFile = ob834DetailsEntityList.get(1).getFile_name();
      sftpUtil.connectToSftp();
      sftpUtil.downloadFileWithSftp(sftpRemoteLocation, medicalPlanFile);
      sftpUtil.downloadFileWithSftp(sftpRemoteLocation, dentalPlanFile);
      sftpUtil.disconnectFromSftp();
   }


   @And("I validate the member details in policy table")
   public void isMemberInPolicyTable(){
      dbValidations.validatePolicyData();
//      PolicyMember subscriber = SharedData.getSubscriber();
//      List<PolicyTableEntity> policyTableEntityList = exchDbDataProvider.getDataFromPolicyTable();
      // Instead of validating individual fields - can we validate the list to list (with more fields in subscriber)- find out: TO DO
    //  Assert.assertEquals(subscriber.getFirstName(), policyTableEntityList.get(0).getFirst_name());


      // --- Pending Validation---//

      // get plan id and acc Id from dto
// create policyMemberEntity List - file/db record
// Need to use policyMemberEntity List for both policyMembers and policyAccHolderMember
      // validate medical plan name, medical policy
// set dto with this medical plan name and medical policy

   }

   @And("I validate the member details in pre-edi table")
   public void isMemberInPreEdiTable(){
      exchDbDataProvider.getOb83Db4Details();
      // --- Pending Validation---//

      // validate the entry exists in db
   }

   @And("I get the file name from the pre-edi table")
   public void getFileName(){

   }

   @When("member records are processed by OB834 EDI process")
   public void kjkj(){
      // get records with acc id from ob834DetailsEntity - getter
      // get enrollmentReqIds when enrollmentStatus - EDI PENDING
      // if enrollment req ids are not empty, get the pendingEdiCount //getter
      // not sure why to submit a batch soze to process all pending records - what is this? why?
      // start sftp connection
// once the file is downloaded, get the pending edi count?

      // Any setters needed for entities? - what setters are needed?

      // -- Another step
      // Read member policy records have all the fields needed - sftp?
      // -- Another step to read member pre-edi records - db?
      // -- Another step to validate these records match
   }


}
