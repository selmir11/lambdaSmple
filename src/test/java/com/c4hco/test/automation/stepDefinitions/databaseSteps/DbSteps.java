package com.c4hco.test.automation.stepDefinitions.databaseSteps;

import com.c4hco.test.automation.database.DbValidations.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DbSteps {
    private final DbValidations dbValidations = new DbValidations();
    private final IndividualPolicyTableValidations policyTableValidations = new IndividualPolicyTableValidations();

    @And("I validate member exists in policy table")
    public void memberExistsInPolicyTable() {
        dbValidations.validateMemberExistsInPolicyTable();
    }

    @And("I verify the OHI info in the DB for {string}")
    public void validateOhiInfo(String memPrefix) {
        dbValidations.validateOhiDetails(memPrefix);
    }

    @And("I verify the OHI options selected in the DB for {string}")
    public void iValidateOhiOptions(String memPrefix, List<Map<String, String>> expectedValues) {
        dbValidations.validateOhiOptions(memPrefix, expectedValues);
    }

    @And("I verify the HRA options selected in the DB")
    public void iValidateHraOptions(List<Map<String, String>> expectedValues) {
        dbValidations.validateHraOptions(expectedValues);
    }

    @And("I verify the policy data quality check with Policy Ah keyset size {int}")
    public void iValidatePolicyDqCheck(int keysetSize) {
        dbValidations.validatePolicyDqCheck(keysetSize);
    }

    @And("I verify the data from book of business queue table with {string} as event type")
    public void iValidateBookOfBusinessQ(String eventType) {
        dbValidations.validateBookOfBusinessQ(eventType);
    }

    @And("I verify the account holder Name in BOB DB")
    public void iVerifyTheAccountHolderNameInBOBDB() {
        dbValidations.validateAccountHolderNameFromBOB();
    }

    @And("I verify the Member will be CSR NON_AIAN")
    public void iVerifyTheMemberCSRNonAIAN() {
        dbValidations.validateMemberCSRNonAIANData();
    }

    @And("I verify the application result details in DB as {string} for {string}")
    public void iVerifyApplicationResult(String eligibilityStatus, String memPrefix) {
        dbValidations.validateApplicationResult(eligibilityStatus, memPrefix);
    }


    @And("I verify the client's updated email address in BoB DB")
    public void iVerifyUpdatedEmailAddressBOBDB() {
        dbValidations.verifyUpdatedEmailAddressBOB();
    }

    @And("I verify the broker authorization in BoB DB is {string}")
    public void iVerifyBrokerAuthorizationBobDb(String expectedBrokerName) {
        dbValidations.validateBrokerAuthorizationBob(expectedBrokerName);
    }

    @And("I validate MVR details for account")
    public void iValidateMVRDetails(List<Map<String, String>> expectedValues) {
        dbValidations.validateMVR(expectedValues);
    }

    @And("I validate the SSA response code is {string} in the DB for {string}")
    public void iVerifySsaResponseCodeDb(String code, String memPrefix) {
        dbValidations.verifySsaResponseCodeDb(code, memPrefix);
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

    @And("I verify the password reset notice is not being archived in the DB for account number STG {string} QA {string}")
    public void iVerifyPasswordResetNotArchivedDb(String accountStg, String accountQa) {
        dbValidations.verifyPasswordResetNotArchivedDb(accountStg, accountQa);
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
    public void iValidateUniquePersonId() {
        policyTableValidations.validateUniquePersonId();
    }

    @And("I verify Person ID review status is Manual Review Required")
    public void iValidatePersonIdReviewStatus() {
        policyTableValidations.validatePersonIdReviewStatus();
    }

    @And("I validate initial email remains in the database")
    public void iValidateDatabaseEmail() {
        dbValidations.validateDatabaseEmail();
    }

    @And("I verify the HRA options selected in the DB after Application Results")
    public void iValidateHraAhOptions(List<Map<String, String>> expectedValues) {
        dbValidations.validateHraAhOptions(expectedValues);
    }

    @And("I validate the medical plan market names in the DB")
    public void validateDatabaseMedicalPlanMarketNamesInTheDB() {
        dbValidations.validateDatabaseMedicalPlanList();
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

    @And("I validate new event {string} is present in DB")
    public void iValidateNewEventDB(String event) {
        dbValidations.validateNewEventDB(event);
    }

    @And("I validate lce type and plan year from es_member table")
    public void validateEsMember() {
        dbValidations.validateLceTypeAndPlanYr_EsMember();
    }

    @Then("I validate the dental Latest Application Date for the year DB")
    public void iValidateTheDentalLatestApplicationDateForTheYearDB() {
        dbValidations.validateTheDentalLatestApplicationDateForTheYearDB();
    }

    @Then("I validate the broker email in DB")
    public void iValidateTheEmailInDB() {
        dbValidations.validateTheBrokerEmailInDB();
    }

    @Then("I validate the agency email in DB")
    public void iValidateTheAgencyEmailInDB() {
        dbValidations.validateTheAgencyEmailInDB();
    }

    @And("I Validate enrollment period end date is set to {int} days from current QLCE days")
    public void validateEnrolmentEndDate(int enrollmentEndDate) {
        dbValidations.validateEnrollmentEndDateDB(enrollmentEndDate);
    }

    @And("I verify the tax filing data for {string} in DB")
    public void iVerifyTaxFilingData(String memPrefix, List<Map<String, String>> expectedValues) {
        dbValidations.verifyTaxFilingData(memPrefix, expectedValues);
    }

    @And("I verify the tax return data for {string} in DB")
    public void iVerifyTaxReturnData(String memPrefix, List<Map<String, String>> expectedValues) {
        dbValidations.verifyTaxReturnData(memPrefix, expectedValues);
    }

    @Then("I validate the details from rq_queue_messages database")
    public void validate_rq_queue_msg() {
        dbValidations.validate_rq_queue_msg();
    }

    @Then("I validate member id of all members")
    public void validateMemberId() {
        dbValidations.validateMemIds();
    }

    @Then("I validate the data entered on tell us about yourself page is saved in DB")
    public void validateAbtUrslfDataInDb(){
        dbValidations.validateTellUsAbtUrslfDetails();
    }

    @Then("I validate the application id from the db")
    public void validateApplicationId(){
        dbValidations.validateApplicationId();
    }

    @Then("I validate that applications id's are different for current and next year")
    public void validateApplicationIds(){
        dbValidations.validateApplicationIds();
    }

    @Then("I validate the Self Attestation details in DB")
    public void iValidateSelfAttestation(List<Map<String, String>> expectedValues){dbValidations.validateSelfAttest(expectedValues);}

    @Then("I validate the exch_person_id related fields to be null")
    public void validateExchPersonIdFieldsTobeNull(){
        dbValidations.validateExchPersonIdRelatedFieldsToBeNull();
    }

    @Then("I validate the exch_person_id related fields from db for a new member after tell us about yourself page")
    public void validateExchPersonIdFields(){
        dbValidations.validateExchPersonIdRelatedFields();
    }

    @Then("I validate the exch_person_id related fields from db for a specific member after tell us about yourself page")
    public void validateExchPersnIdFields(){
        dbValidations.validateExchPersonIdFields_specifcPerson();
    }

    @Then("I validate the exch_person_id related fields from db for a duplicate member after tell us about yourself page")
    public void validateExchPersonIdFields_duplicateMem(){
        dbValidations.validateExchPersonIdFields_duplicateMem();
    }

    @Then("I validate eventCD when no notices are sent")
    public void iValidateEventCD(){
        dbValidations.validateEventCD();
    }
    @Then("I validate event log in DB")
    public void iValidateEventLog(){
        dbValidations.validateEventLog();
    }

    @Then("I validate complete residential address details for {string} member in DB addressLine1 {string},addressLine2 {string},city {string},state {string},zipcode {string},county {string}")
    public void validateAddressInformation(String FName,String address_line1, String address_line2, String city, String state, String zip, String county){
        dbValidations.validateAddressDetailsinDB(FName,address_line1,address_line2,city,state,zip,county);
    }
    @Then("I validate mailing address details for {string} member in DB addressLine1 {string},city {string},state {string},zipcode {string},county {string}")
    public void validateMailingAddressInformation(String FName,String address_line1, String city, String state, String zip, String county){
        dbValidations.validateMailingAddressDetailsinDB(FName,address_line1,city,state,zip,county);
    }
    @Then("I validate state details for {string} member in DB {int}")
    public void validateStateInformation(String FName, int state){
        dbValidations.validateStateInformation(FName, state);
    }

    @Then("I validate the details of the Tell us about additional members of your household page for the {string} in the database")
    public void validateTellUsAboutAdditionalInformation(String FName){
        dbValidations.validateTellAboutAdditionalInformationinDB(FName);
    }
}

