package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.MultipleTablesEntity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DbValidations {
  DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
  SoftAssert softAssert = new SoftAssert();

    public void validateDataFromMultipleTables(){

      MemberDetails subscriber = SharedData.getPrimaryMember();
      List<MultipleTablesEntity> policyEntity = exchDbDataProvider.getDataFromMultipleTables();

      for(MultipleTablesEntity multipleTablesEntity: policyEntity){

        subscriber.compareWithCombinedQueryData(multipleTablesEntity);

        // To DO:: Add more validations here
        // TO DO:: Remove duplicates from either compare method or here
        softAssert.assertEquals( String.valueOf(subscriber.getAccount_id()), multipleTablesEntity.getAccount_id(), "acc id did not match");
        softAssert.assertEquals( subscriber.getFirstName(), multipleTablesEntity.getFirst_name(), "First Name did not match");
        softAssert.assertEquals( subscriber.getLastName(), multipleTablesEntity.getLast_name(), "Last Name did not match");
        softAssert.assertAll();
      }
    }

    public void validateOb834Data(){
      MemberDetails subscriber = SharedData.getPrimaryMember(); // TO DO:: Can do this globally?
      List<Ob834DetailsEntity> ob834DetailsEntity = exchDbDataProvider.getOb83Db4Details();

      for(Ob834DetailsEntity ob834Entity: ob834DetailsEntity){

        // TO DO:: Add More Assertions
        softAssert.assertEquals(subscriber.getSsn(), ob834Entity.getMember_ssn(), "ssn did not match");
        softAssert.assertEquals(subscriber.getFirstName(), ob834Entity.getMember_first_name(), "member firstname did not match");
        softAssert.assertAll();;
      }

    }

  public void validateMemberExistsInPolicyTable(){
    List<MultipleTablesEntity> policyEntity = exchDbDataProvider.getDataFromMultipleTables();
    Assert.assertFalse("No records exists with this account number in Policy table ", policyEntity.isEmpty());
  }



}
