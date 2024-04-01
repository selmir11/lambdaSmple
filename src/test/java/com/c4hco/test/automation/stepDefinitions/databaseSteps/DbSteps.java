package com.c4hco.test.automation.stepDefinitions.databaseSteps;

import com.c4hco.test.automation.database.DbValidations.DbValidations;
import io.cucumber.java.en.And;

public class DbSteps {
private final DbValidations dbValidations = new DbValidations();

   @And("I validate member exists in policy table")
   public void memberExistsInPolicyTable(){
      dbValidations.validateMemberExistsInPolicyTable();
   }

   @And("I validate the member details from few tables")
   public void isMemberInPolicyTable(){
      dbValidations.validateDataFromMultipleTables();
   }

   @And("I validate member details from ob834_details table")
   public void isMemberInPreEdiTable(){
      dbValidations.validateOb834FromDb();
   }

}
