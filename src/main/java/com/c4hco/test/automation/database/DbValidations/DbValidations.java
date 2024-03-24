package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.EntityObj.PolicyTableEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DbValidations {
  DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
  SoftAssert softAssert = new SoftAssert();

    public void validatePolicyData(){
      MemberDetails subscriber = SharedData.getPrimaryMember();
      List<PolicyTableEntity> policyEntity = exchDbDataProvider.getDataFromPolicyTable();
       softAssert.assertEquals( String.valueOf(subscriber.getAccount_id()), policyEntity.get(0).getAccount_id(), "acc id did not match");
       // Application Id
      softAssert.assertEquals( subscriber.getFirstName(), policyEntity.get(0).getFirst_name(), "First Name did not match");
      softAssert.assertEquals( subscriber.getLastName(), policyEntity.get(0).getLast_name(), "Last Name did not match");
      softAssert.assertAll();
    }

    public void validateMemberExistsInPolicyTable(){
      List<PolicyTableEntity> policyEntity = exchDbDataProvider.getDataFromPolicyTable();
      Assert.assertTrue("No records exists with this account number in Policy table ", policyEntity.size()>0);
    }

  public void validateMemberExistsInOb834DetailsTable(){
    List<Ob834DetailsEntity> ob834DetailsEntityList = exchDbDataProvider.getOb83Db4Details();
    Assert.assertTrue("No records exists with this account number in ob834 details table ", ob834DetailsEntityList.size()>0);
  }


    public void validateOb834Data(){

    }



}
