package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalAccountAccessPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;


public class AdminPortalAccountAccessSteps {

    AdminPortalAccountAccessPage adminPortalAccountAccessPage = new AdminPortalAccountAccessPage((WebDriverManager.getDriver()));
    @Then("I verify account access status is {string}")
    public void iVerifyAccountAccessStatusIs(String status) {
        adminPortalAccountAccessPage.validateAccountStatus(status);
    }
}
