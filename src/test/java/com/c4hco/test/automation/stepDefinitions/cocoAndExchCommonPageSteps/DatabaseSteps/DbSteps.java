package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.DatabaseSteps;

import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class DbSteps {
private DbDataProvider_Exch exchDbData = new DbDataProvider_Exch();

   @And("I validate the member details in policy table")
   public void isMemberInPolicyTable(){
      exchDbData.getDataFromPolicyTable();

      // get plan id and acc Id from dto
// create policyMemberEntity List - file/db record
// Need to use policyMemberEntity List for both policyMembers and policyAccHolderMember
      // validate medical plan name, medical policy
// set dto with this medical plan name and medical policy

   }

   @And("I validate the member details in pre-edi table")
   public void isMemberInPreEdiTable(){
      // get accountId from dto
      // create ob834DetailsEntity - account records
// dto should have ob834DetailsEntity
      // validate the entry exists in db
      // set what you got from db to dto in ob834DetailsEntity - setter

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
