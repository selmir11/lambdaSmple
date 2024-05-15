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
   public void validateOhiInfo(){
      dbValidations.validateOhiDetails();
   }
}
