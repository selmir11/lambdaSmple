package com.c4hco.test.automation.stepDefinitions.databaseSteps;

import com.c4hco.test.automation.database.DbValidations.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DbSteps {
private final DbValidations dbValidations = new DbValidations();
private final PolicyTableValidations policyTableValidations = new PolicyTableValidations();
private final PolicyTableDBValidations policyTableDBValidations = new PolicyTableDBValidations();

   @And("I validate member exists in policy table")
   public void memberExistsInPolicyTable(){
      dbValidations.validateMemberExistsInPolicyTable();
   }

   @And("I validate the member details from policy tables")
   public void validateFromPolicyTables(){
      policyTableDBValidations.validateDataFromPolicyTables();
   }

   @And("I validate member details from ob834_details table")
   public void validateOb834Details(List<Map<String, String>> expectedValues){
      dbValidations.validateOb834FromDb(expectedValues);
   }
   @And("I set ib999 entites for both medical and dental files")
   public void setib999(){
      dbValidations.setIb999DetailsEntity();
   }

   @And("I verify the OHI info in the DB")
   public void validateOhiInfo(){dbValidations.validateOhiDetails();}

   @And("I verify the OHI options selected in the DB")
   public void iValidateOhiOptions(List<Map<String, String>> expectedValues){dbValidations.validateOhiOptions(expectedValues);}

   @And("I verify the HRA options selected in the DB")
   public void iValidateHraOptions(List<Map<String, String>> expectedValues){dbValidations.validateHraOptions(expectedValues);}


   @And("I verify the policy data quality check with Policy Ah keyset size {int}")
   public void iValidatePolicyDqCheck(int keysetSize){dbValidations.validatePolicyDqCheck(keysetSize);}

   @And("I verify the data from book of business queue table with {string} as event type")
   public void iValidateBookOfBusinessQ(String eventType){dbValidations.validateBookOfBusinessQ(eventType);}

   @And("I verify the account holder Name in BOB DB")
   public void iVerifyTheAccountHolderNameInBOBDB() {
      dbValidations.validateAccountHolderNameFromBOB();
   }

   @And("I verify the client's updated email address in BoB DB")
   public void iVerifyUpdatedEmailAddressBOBDB() {
      dbValidations.verifyUpdatedEmailAddressBOB();
   }

   @And("I verify the broker authorization in BoB DB is {string}")
   public void iVerifyBrokerAuthorizationBobDb(String expectedBrokerName) {
      dbValidations.validateBrokerAuthorizationBob(expectedBrokerName);
   }

   @And("I verify the client application submission in BoB DB")
   public void iVerifyApplicationSubmissionBobDb() {
      dbValidations.validateApplicationSubmissionBob();
   }

   @And("I verify the client's policy submission in BoB DB has {int} expected records for coverage type {int}")
   public void iVerifyMedicalPolicySubmissionBobDb(int expectedRecords, int coverageType) {
      dbValidations.validatePolicySubmissionBob(expectedRecords, coverageType);
   }

   @And("I verify there are no medical records for my client in BoB DB")
   public void iVerifyNoMedicalPolicySubmissionBobDb() {
      dbValidations.validateNoMedicalPolicySubmissionBob();
   }

   @And("I verify my agency commission TIN in the database")
   public void iVerifyAgencyCommissionTinDb() {
      dbValidations.verifyAgencyCommissionTinDb();
   }

   @And("I verify the new Exchange individual account's household ID in the database")
   public void iVerifyExchHouseholdIdDb() {
      dbValidations.verifyExchHouseholdIdDb();
   }

   @And("I verify broker deauthorization in the database")
   public void iVerifyBrokerAuthorizationStatusDb() {
      dbValidations.verifyBrokerAuthorizationStatusDb();
   }

   @And("I verify the broker authorization type in the database is {string}")
   public void iVerifyBrokerAuthorizationTypeDb(String expectedBrokerType) {
      dbValidations.verifyBrokerAuthorizationTypeDb(expectedBrokerType);
   }

   @And("I verify Person ID is unique in the DB")
   public void iValidateUniquePersonId(){policyTableValidations.validateUniquePersonId();}

   @And("I verify Person ID review status is Manual Review Required")
   public void iValidatePersonIdReviewStatus(){policyTableValidations.validatePersonIdReviewStatus();}

   @And("I validate initial email remains in the database")
   public void iValidateDatabaseEmail() {dbValidations.validateDatabaseEmail();}

   @And("I verify the HRA options selected in the DB after Application Results")
   public void iValidateHraAhOptions(List<Map<String, String>> expectedValues){dbValidations.validateHraAhOptions(expectedValues);}

   @And("I validate the medical plan market names in the DB")
   public void validateDatabaseMedicalPlanMarketNamesInTheDB() {dbValidations.validateDatabaseMedicalPlanList();
   }

   @And("I validate {string} race and {string} other text in the database")
   public void iValidateRaceAndOtherTextInDatabase(String expectedRaceEthnicity, String expectedRaceOtherText) {
      dbValidations.validateDatabaseRaceEthnicity(expectedRaceEthnicity, expectedRaceOtherText);
   }

   @Then("I validate current dental plan name for the account for the year {string} DB")
   public void iValidateCurrentDentalPlanNameForTheAccountForTheYearDB(String year) {
      dbValidations.validateCurrentDentalPlanNameForTheYear(year);
   }


   @And("I validate current Medical policy start and end date for the year DB")
   public void iValidateCurrentMedicalPolicyStartAndEndDateForTheYearDB() {
      dbValidations.validateCurrentDentalPolicyStartAndEndDateForTheYearDB();
   }

   @Then("I validate the Latest Application Date for the year DB")
   public void iValidateTheLatestApplicationDateForTheYearDB() {
      dbValidations.validateTheLatestApplicationDateForTheYearDB();
   }

   @And("I validate the second medical policy for the year {string} DB")
   public void iValidateTheSecondMedicalPolicyForTheYearDB(String year) {
      dbValidations.validateTheSecondMedicalPoliciyForTheYearDB(year);
   }

   @And("I validate the second dental policy for the year {string} DB")
   public void iValidateTheSecondDentalPolicyForTheYearDB(String year) {
      dbValidations.validateTheSecondDentalPoliciyForTheYearDB(year);
   }
}
