package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DbValidations {
  DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
  SoftAssert softAssert = new SoftAssert();

    public void validateDataFromPolicyTables(){

      MemberDetails subscriber = SharedData.getPrimaryMember();
      List<PolicyTablesEntity> policyEntity = exchDbDataProvider.getDataFromPolicyTables();

      for(PolicyTablesEntity policyTablesEntity: policyEntity){

        if(policyTablesEntity.getCoverage_type().equals("1")){
          // validate medical specific details
          //        // Set POLICY START DATE in  SUBSCRIBER - IS it the plan start date?
//        softAssert.assertEquals(subscriber.getMedicalPlanStartDate(), policyTablesEntity.getPolicy_start_date(), "Policy start date did not match");
//        softAssert.assertEquals(subscriber.getMedicalPlanEndDate(), policyTablesEntity.getPolicy_end_date(), "Policy end date did not match");
//        softAssert.assertEquals(subscriber.getFinancialStartDate(), policyTablesEntity.getFinancial_period_start_date(), "Financial start date did not match");
//        softAssert.assertEquals(subscriber.getFinancialEndDate(), policyTablesEntity.getFinancial_period_end_date(), "Policy start date did not match");
          // financial period start date or member financial start date?
        } else{
          // validate dental specific detail
        }

        subscriber.compareWithCombinedQueryData(policyTablesEntity); // may be get rid of this? - TO DO

        // To DO:: Add more validations here
        // TO DO:: Remove duplicates from either compare method or here
        softAssert.assertEquals( String.valueOf(subscriber.getAccount_id()), policyTablesEntity.getAccount_id(), "acc id did not match");
        softAssert.assertEquals( subscriber.getFirstName(), policyTablesEntity.getFirst_name(), "First Name did not match");
        softAssert.assertEquals( subscriber.getLastName(), policyTablesEntity.getLast_name(), "Last Name did not match");
        softAssert.assertTrue(policyTablesEntity.getPolicy_status().equals("SUBMITTED"));
        softAssert.assertAll();
      }
    }

    public void validateOb834FromDb(){
      MemberDetails subscriber = SharedData.getPrimaryMember();

      List<Ob834DetailsEntity> ob834DetailsEntities = exchDbDataProvider.getOb83Db4Details();
      SharedData.setOb834DetailsEntities(ob834DetailsEntities);

      for(Ob834DetailsEntity ob834Entity: ob834DetailsEntities){
      if(ob834Entity.getInsurance_line_code().equals("HLT")){
          // validate medical records
        } else {
         // validate dental records
          softAssert.assertTrue(ob834Entity.getInsurance_line_code().equals("DEN"));
        }

        // TO DO:: Add More Assertions - UI vs DB
        softAssert.assertEquals(subscriber.getSsn(), ob834Entity.getMember_ssn(), "ssn did not match");
        softAssert.assertEquals(subscriber.getFirstName(), ob834Entity.getMember_first_name(), "member firstname did not match");
        softAssert.assertEquals(subscriber.getLastName(), ob834Entity.getMember_last_name(), "member firstname did not match");

      //  softAssert.assertAll();;
      }
    }

  public void validateMemberExistsInPolicyTable(){
    List<PolicyTablesEntity> policyEntity = exchDbDataProvider.getDataFromPolicyTables();
    Assert.assertFalse(policyEntity.isEmpty(), "No records exists with this account number in Policy table");
  }

  public void validateOhiDetails(){
      Boolean hasRecords = exchDbDataProvider.getDataFromOhiTables();
      Assert.assertFalse(hasRecords, "Query returned records");
  }

}
