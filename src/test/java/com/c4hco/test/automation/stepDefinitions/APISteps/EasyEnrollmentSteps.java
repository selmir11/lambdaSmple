package com.c4hco.test.automation.stepDefinitions.APISteps;

import com.c4hco.test.automation.pages.API.EasyEnrollment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EasyEnrollmentSteps {

    EasyEnrollment easyEnrollment = new EasyEnrollment();

    @Given("I get Easy Enrollment API base URL")
    public void iGetDORToC4APIBaseURL() {
        easyEnrollment.getDORToC4APIEnvConnection();
    }

    @When("I send a request with the following data: adjustedGrossIncome:{string}, emailAddress:{string}, filedByDeadline:{string}, filingType:{string}, firstName:{string}, householdSize:{string}, lastName:{string}, mailingAddressLine1:{string}, zipCode:{string}, middleInitial:{string}, phoneNumber:{string}, dateOfBirth:{string}, ssn:{string}")
    public void iSendDataForTaxHouseholdValidation(String adjustedGrossIncome, String emailAddress, String filedByDeadline, String filingType, String firstName, String householdSize, String lastName, String mailingAddressLine1, String zipCode, String middleInitial, String phoneNumber, String dateOfBirth, String ssn) {
        easyEnrollment.dorToC4APIDataRequest(adjustedGrossIncome, emailAddress, filedByDeadline, filingType, firstName, householdSize, lastName, mailingAddressLine1, zipCode, middleInitial, phoneNumber, dateOfBirth, ssn);
    }
    @Then("I send a request body with the following data: adjustedGrossIncome:{string}, emailAddress:{string}, filedByDeadline:{string}, filingType:{string}, firstName:{string}, householdSize:{string}, lastName:{string}, mailingAddressLine1:{string}, mailingAddressLine2:{string}, city:{string}, zipCode:{string}, middleInitial:{string}, phoneNumber:{string}, dateOfBirth:{string}, ssn:{string}, year:{string}")
    public void isendDataForTaxHousehold(String adjustedGrossIncome, String emailAddress, String filedByDeadline, String filingType, String firstName, String householdSize, String lastName, String mailingAddressLine1,String mailingAddressLine2, String city, String zipCode, String middleInitial, String phoneNumber, String dateOfBirth, String ssn, String year){
        easyEnrollment.dorForTaxHousehold(adjustedGrossIncome, emailAddress, filedByDeadline, filingType, firstName, householdSize, lastName, mailingAddressLine1,mailingAddressLine2, city, zipCode, middleInitial, phoneNumber, dateOfBirth, ssn, year);
    }

    @And("I send the DOR to C4 API request")
    public void iSendTheDORToC4DataRequest() {
        easyEnrollment.sendDorToC4DataRequest();
    }

    @Then("response status code should be {int}")
    public void statuscodeshouldbe(int expectedStatus) {easyEnrollment.validateStatusCodeAndContentType(expectedStatus);}

    @Then("validation message should be {string}")
    public void validationMessageShouldBe(String expectedMessage) {
        easyEnrollment.validateValidationMessage(expectedMessage);
    }
}
