package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalAccountCreationPages;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminPortalAccountCreationSteps {
    AdminPortalAccountCreationPages adminPortalAccountCreationPages = new AdminPortalAccountCreationPages(WebDriverManager.getDriver());


    @And("I enter general data to create admin account with email {string}")
    public void iEnterGeneralDataToCreateAdminAccountWithEmail(String email) {
        adminPortalAccountCreationPages.enterValidDataToCreateAdminAccount(email);
    }

    @Then("I validate the Success message is displayed")
    public void iValidateTheSuccessMessageIsDisplayed() {
        adminPortalAccountCreationPages.validateTheSuccessMessageIsDisplayed();
    }
}
