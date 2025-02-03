package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.AssistnetPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages.MyClientAssistNetPortal;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MyClientAssistNetPortalSteps {

    MyClientAssistNetPortal myClientAssistNetPortal = new MyClientAssistNetPortal(WebDriverManager.getDriver());
    @Then("I validate The Client is removed successfully from assistnet Portal")
    public void iValidateTheClientIsRemovedSuccessfullyFromAssistnetPortal() {
        myClientAssistNetPortal.validateTheClientIsRemovedSuccessfullyFromAssistnetPortal();
    }

    @Then("I verify that a total of {string} clients have been selected from the My Clients list")
    public void iValidateTotalSelectedClientCount(String expectedCount) {
        myClientAssistNetPortal.validateTotalSelectedClientCount(expectedCount);
    }

    @Then("I verify existing assister client details {string}, {string}, {string}, {string} or {string}")
    public void iVerifyExistingClientDetails(String clientName, String clientZip, String phoneNumber, String clientAccountStg, String clientAccountQA) {
        myClientAssistNetPortal.verifyExistingClientDetails(clientName, clientZip, phoneNumber, clientAccountStg, clientAccountQA);
    }

    @Then("I verify existing assister client plan details {string}, {string}, {string}")
    public void iVerifyExistingClientPlanDetails(String planYear, String eligResults, String issuerName) {
        myClientAssistNetPortal.verifyExistingClientPlanDetails(planYear, eligResults, issuerName);
    }

    @Then("I verify the existing assister secondary client details {string}, {string}, {string}, {string}, {string}")
    public void iVerifyExistingSecondaryClientDetails(String clientName, String clientZip, String planYear, String eligResults, String issuerName) {
        myClientAssistNetPortal.verifyExistingSecondaryClientDetails(clientName, clientZip, planYear, eligResults, issuerName);
    }

}
