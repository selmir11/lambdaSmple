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

    @And("I verify the OHC info in the DB for {string}")
    public void validateOhcInfo(String memPrefix) {
        dbValidations.validateOhcDetails(memPrefix);
    }

    @And("I verify the OHC options selected in the DB for {string}")
    public void iValidateOhcOptions(String memPrefix, List<Map<String, String>> expectedValues) {
        dbValidations.validateOhcOptions(memPrefix, expectedValues);
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
    @And("I verify the data from book of business queue by applicationId with {string} as event type")
    public void iValidateBOBByApplicationId(String eventType ){
        dbValidations.validateBobByApplicationId(eventType);
    }
    @And("I verify the BOB entry for {string} with {string} as event type")
    public void iValidateBoBMedical(String coverageType, String eventType){
        dbValidations.validateBookOfBusinessQMedical(coverageType,eventType);
    }

    @And("I verify the account holder Name in BOB DB")
    public void iVerifyTheAccountHolderNameInBOBDB() {
        dbValidations.validateAccountHolderNameFromBOB();
    }

    @And("I verify the Member will be CSR {string}")
    public void iVerifyTheMemberCSRNonAIAN(String reasonCode) {
        dbValidations.validateMemberCSRNonAIANData(reasonCode);
    }

    @Then("I verify the application result details in DB as {string} for {string}")
    public void iVerifyApplicationResult(String eligibilityStatus, String memPrefix) {
        dbValidations.validateApplicationResult(eligibilityStatus, memPrefix);
    }

    @Then("I verify the created by value as {string} for {string} and determination as {string}")
    public void validateCreatedBy(String createdBy, String memPrefix, String expectedReasonCode) {
        dbValidations.validateCreatedBy(createdBy, memPrefix, expectedReasonCode);
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

    @And("I verify that the account has no MVRs")
    public void iValidateMVRDNE(){dbValidations.validateMVRDoesNotExist();}

    @And("I validate the SSA response code is {string} in the DB for {string}")
    public void iVerifySsaResponseCodeDb(String code, String memPrefix) {
        dbValidations.verifySsaResponseCodeDb(code, memPrefix);
    }

    @And("I validate the SSA response code is {string} in the DB")
    public void iVerifySsaResponseCodeDbCreatedByPrimary(String code) {
        dbValidations.verifySsaResponseCodeDbByCreatedBy(code);
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

    @And("I Validate enrollment period end date based on latest QLCE")
    public void validateEnrolmentEndDate() {
        dbValidations.validateEnrollmentEndDateDB();
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
    @Then("I validate event_cd in easy enrollment event log in DB")
    public void ivalidateEventCD(List<String> eventCD){
        dbValidations.validateEventLog(eventCD);
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
    @Then("I validate enrollment period end date for AI&AN should be lastdayofYear")
    public void validateEnrollmentEndDateForAIAN() { dbValidations.validateEnrollmentEndDateForAIANDB();}

    @Then("I validate the FPL percent {int}")
    public void iValidateTheFplPercent(int expectedFplPercent) {dbValidations.validateFplPercent(String.valueOf(expectedFplPercent));
    }

    @Then("I validate the FPL percent in es_tax_return_aptc is {double}")
    public void iValidateFPLEsTaxReturnAPTC(double expectedFPL){dbValidations.validateFPLESTaxReturnAPTC(String.valueOf(expectedFPL));}

    @And("I verify Persons ID are validated in the DB with count only {string}")
    public void iValidateExchPersonIds(String validateCountOnly) {
        policyTableValidations.validateExchPersonIds(validateCountOnly);
    }

    @Then("I validate ARP Indicator is set correctly in DB")
    public void iValidateArpIndicator() {policyTableValidations.validateArpIndicator();}

    @And("I Validate enrollment period end date is set to {int} days from current date of the admin LCE being processed")
    public void validateEnrolmentEndDate(int enrollmentEndDate) {
        dbValidations.validateEnrollmentEndDateDB(enrollmentEndDate);
    }

    @Then("I validate system functionality for member being eligible for CYA")
    public void validateCyaEligibility() {
        dbValidations.validateCyaEligibility();
    }

    @And("I Validate VLP response code as {string} for request type {string}")
    public void validateEnrolmentEndDate(String responseCode, String requestType) {
        dbValidations.validateVLPResponseCode(responseCode, requestType);
    }

    @And("I Validate FDSH retry type as {string} and retry status as {string}")
    public void validateFDSHRetryTypeAndStatus(String retryType, String retryStatus) {
        dbValidations.validateFDSHRetryTypeandStatus(retryType,retryStatus);
    }

    @And("I verify the Member reason code as {string}")
    public void iVerifyTheMemberReasonCode(String expectedReasonCode) {
        dbValidations.validateReasonCode(expectedReasonCode);
    }

    @And("I validate the FDSH Retry Details")
    public void validateFDSHRetry(List<Map<String, String>> expectedValues){
        dbValidations.validateFDSHRetry(expectedValues);
    }

    @Then("I validate the Income details in DB")
    public void iValidateIncomeDetails(List<Map<String, String>> expectedValues){dbValidations.validateIncomeDetails(expectedValues);}

    @And("I validate the employee income details row count {int}")
    public void ivalidateMemberRowCount(int expectedRowCount) {
        dbValidations.validateMemberRowCount(expectedRowCount);
    }

    @Then("I validate the deduction for kind {string} with amount {string} and frequency {string} in DB")
    public void iValidateTheDeduction(String kind, String amount, String frequency) {
        dbValidations.validateDeductionAmount(kind, amount, frequency);
    }

    @Then("I validate the Overridden APTC amount is {string} in DB")
    public void iValidateOverriddenAmount(String overriddenAmt) {dbValidations.validateOverriddenAmount(overriddenAmt);}

    @Then("I validate {int} VLP calls have been made for the member")
    public void iValidateVLPCallsHaveBeenMadeForTheMember(int number) {
        dbValidations.verifyVLPCallsMadeForMember(number);
    }

    @And("I verify the primary's eligibility type is {string}")
    public void iVerifyPrimaryEligibilityType(String reasonCode) {dbValidations.verifyPrimaryEligibilityType(reasonCode);}

    @And("I verify the most recent determination is {string} with an effective date of {string}")
    public void iVerifyDeterminationEffectiveDate(String qlceType, String dateType) {dbValidations.verifyDeterminationEffectiveDate(qlceType, dateType);}

    @And("I verify outcome_ind is {string}")
    public void iValidateOutcomeInd(String outcome) {dbValidations.validateOutcomeInd(outcome);}

    @And("I verify removed_effective_date is first of next year")
    public void iValidateRemovedEffectiveDate() {dbValidations.validateRemovedEffectiveDate();}

    @And("I verify {string}'s applying_for_coverage_ind is {string}")
    public void iValidateApplyingForCoverageIndDB(String FName, String applying) {dbValidations.validateApplyingForCoverageIndDB(FName, applying);}

    @And("I verify {string}'s LCE data is moved to ah table")
    public void iValidateLceMovedToAh(String FName) {dbValidations.validateLceMovedToAh(FName);}

    @Then("I validate the number of deduction rows is {int} in DB")
    public void iValidateDeductionRowCount(int expectedRowCount) {dbValidations.validateDeductionRowCount(expectedRowCount);}

    @And("I verify plan year is {string} in the DB")
    public void iValidateEnrollmentPlanYear(String year) {dbValidations.validateEnrollmentPlanYear(year);}

    @And("I verify the LCE data in the DB")
    public void iValidateEnrollmentPlanLce(List<Map<String, String>> expectedValues) {dbValidations.validateEnrollmentPlanLce(expectedValues);}

    @And("I validate the LCE data row count {int}")
    public void iValidateEnrollmentPlanLceRowCount(int expectedRowCount) {dbValidations.validateEnrollmentPlanLceRowCount(expectedRowCount);}


    @Then("I validate the document details with values")
    public void iValidateTheDocumentDetails(List<String> expectedValues) {
        dbValidations.validateDocumentDetails(expectedValues);
    }

    @Then("I validate the assistnet email in DB")
    public void iValidateTheAssistnetEmailInDB() {
        dbValidations.validateTheAssistnetEmailInDB();
    }
}


