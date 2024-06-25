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

    @When("I send information for two tax households one with two members: Magi1:{string}, Magi2:{string}, Zip:{string}, Fips:{string}, FPL1:{string}, FPL2:{string}, DOB1:{string}, DOB2:{string}, DOB3:{string}")
    public void iSendTheHouseholdInfomration(String magi, String magi2, String zipCode, String fipsCode, String fpl, String fpl2, String dateOfBirth, String dateOfBirth2, String dateOfBirth3) {
        aptcCalculator.buildTwoTaxHouseHoldOneTwoMember(magi, magi2, zipCode, fipsCode, fpl, fpl2, dateOfBirth, dateOfBirth2, dateOfBirth3);}

    @When("I send information for two tax households one with three members and one with one no APTC Member: Magi1:{string}, Magi2:{string}, Zip:{string}, Fips:{string}, FPL1:{string}, FPL2:{string}, DOB1:{string}, DOB2:{string}, DOB3:{string}, DOB4:{string}")
    public void iSendTheHouseholdInfomration(String magi, String magi2, String zipCode, String fipsCode, String fpl, String fpl2, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4) {
        aptcCalculator.buildTwoTHHTHH1ThreeMemberOneNotAPTCTHH2OneMemberNotAPTC(magi, magi2, zipCode, fipsCode, fpl, fpl2, dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4);}

    @When("I send information for two tax households one with three members and one with one Member: Magi1:{string}, Magi2:{string}, Zip:{string}, Fips:{string}, FPL1:{string}, FPL2:{string}, DOB1:{string}, DOB2:{string}, DOB3:{string}, DOB4:{string}")
    public void iSendTheHouseholdInfomrationS(String magi, String magi2, String zipCode, String fipsCode, String fpl, String fpl2, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4) {
        aptcCalculator.buildTwoTHHTHH1ThreeMemberOneNotAPTCTHH2OneMember(magi, magi2, zipCode, fipsCode, fpl, fpl2, dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4);}

    @When("I send information for three tax households one with three members and two with one Member: Magi1:{string}, Magi2:{string}, Magi3:{string}, Zip:{string}, Fips:{string}, FPL1:{string}, FPL2:{string}, FPL3:{string}, DOB1:{string}, DOB2:{string}, DOB3:{string}, DOB4:{string}, DOB5:{string}")
    public void iSendTheHouseholdInfomrationS(String magi, String magi2, String magi3, String zipCode, String fipsCode, String fpl, String fpl2, String fpl3, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5) {
        aptcCalculator.buildThreeTHHTHH1ThreeMemberTHH2OneMemberTHH3OneMember(magi, magi2, magi3, zipCode, fipsCode, fpl, fpl2, fpl3, dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5);}


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

