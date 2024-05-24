package com.c4hco.test.automation.stepDefinitions.APISteps;
import com.c4hco.test.automation.pages.API.APTCCalculator;
import io.cucumber.java.en.*;


public class APTCCalculatorSteps {

    APTCCalculator aptcCalculator = new APTCCalculator();
    @Given("I get APTC CALCULATOR base URL")
    public void iGetAPTCCALCULATORBaseURL() {
        aptcCalculator.getAPIEnvConnection();
    }

    @When("I send the single member household's Information: {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth) {
        aptcCalculator.buildSingleMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth);}

    @When("I send the two member household's Information: {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2) {
        aptcCalculator.buildTwoMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2);}

    @When("I send the three member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3) {
        aptcCalculator.buildThreeMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3);}

    @When("I send the four member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4) {
        aptcCalculator.buildFourMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4);}

    @When("I send the five member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5) {
        aptcCalculator.buildFiveMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5);}

    @When("I send the six member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6) {
        aptcCalculator.buildSixMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6);}

    @When("I send the seven member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7) {
        aptcCalculator.buildSevenMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7);}

    @When("I send the eight member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7, String dateOfBirth8) {
        aptcCalculator.buildEightMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7, dateOfBirth8);}

    @When("I send the nine member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7, String dateOfBirth8, String dateOfBirth9) {
        aptcCalculator.buildNineMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7, dateOfBirth8, dateOfBirth9);}

    @When("I send the ten member household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7, String dateOfBirth8, String dateOfBirth9, String dateOfBirth10) {
        aptcCalculator.buildTenMemberTaxHouseholdRequest(magi,zipCode,fipsCode,fpl,dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7, dateOfBirth8, dateOfBirth9, dateOfBirth10);}

    @When("I send the two member in different zip codes household's Information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationSDiffZip(String magi, String zipCode, String fipsCode, String zipCode2, String fipsCode2, String fpl, String dateOfBirth, String dateOfBirth2) {
        aptcCalculator.buildTwoMemberDifferentZipTaxHouseholdRequest(magi,zipCode,fipsCode,zipCode2, fipsCode2, fpl,dateOfBirth, dateOfBirth2);}

    @And("I send the APTC Calculator Request")
    public void iSendTheAPTCCalculatorRequest() {
        aptcCalculator.sendAPTCCalculatorRequest();
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatus) {aptcCalculator.validateStatusCodeAndContentType(expectedStatus);}

    @And("I expect {string} and {string}")
    public void iExpectAPTCAndContributionAmount(String expectedAPTC, String contribution) {
        aptcCalculator.expectedAPTCContributionAmount(expectedAPTC,contribution);}


}

