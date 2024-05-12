package com.c4hco.test.automation.stepDefinitions.APISteps;
import com.c4hco.test.automation.pages.API.APTCCalculator;
import io.cucumber.java.en.*;


public class APTCCalculatorSteps {

    APTCCalculator aptcCalculator = new APTCCalculator();
    @Given("I get APTC CALCULATOR base URL")
    public void iGetAPTCCALCULATORBaseURL() {
        aptcCalculator.getAPIEnvConnection();
    }

    @When("I send the household Information's: {string}, {string}, {string}, {string}, {string}")
    public void iSendTheHouseholdInformationS(String income, String zipCode, String fipsCode, String fpl, String dateOfBirth) {
        aptcCalculator.sendTheHouseholdInformation(income,zipCode,fipsCode,fpl,dateOfBirth);
    }

    @And("I send the APTC Calculator Request")
    public void iSendTheAPTCCalculatorRequest() {
        aptcCalculator.sendAPTCCalculatorRequest();
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatus) {
        aptcCalculator.validateStatusCodeAndContentType(expectedStatus);
    }

    @And("I expect {string} and {string}")
    public void iExpectAPTCAndContributionAmount(String expectedAPTC, String contribution) {
        aptcCalculator.expectedAPTCContributionAmount(expectedAPTC,contribution);
    }


}

