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

}
