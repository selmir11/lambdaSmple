package com.c4hco.test.automation.stepDefinitions.databaseSteps;

import com.c4hco.test.automation.database.DbValidations.DbValidations;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class DbSteps {
private final DbValidations dbValidations = new DbValidations();

   @And("I validate member exists in policy table")
   public void memberExistsInPolicyTable(){
      dbValidations.validateMemberExistsInPolicyTable();
   }

   @And("I validate the member details from policy tables")
   public void validateFromPolicyTables(){
      dbValidations.validateDataFromPolicyTables();
   }

   @And("I validate member details from ob834_details table")
   public void validateOb834Details(List<Map<String, String>> expectedValues){
      dbValidations.validateOb834FromDb(expectedValues);
   }

   @And("I verify the OHI info in the DB")
   public void validateOhiInfo(){dbValidations.validateOhiDetails();}

   @And("I verify the OHI options selected in the DB")
   public void iValidateOhiOptions(List<Map<String, String>> expectedValues){dbValidations.validateOhiOptions(expectedValues);}


   @And("I verify the policy data quality check")
   public void iValidatePolicyDqCheck(){dbValidations.validatePolicyDqCheck();}

   @And("I verify the data from book of business queue table")
   public void iValidateBookOfBusinessQ(){dbValidations.validateBookOfBusinessQ();}

   @And("I verify the account holder Name in BOB DB")
   public void iVerifyTheAccountHolderNameInBOBDB() {
      dbValidations.validateAccountHolderNameFromBOB();
   }

}
