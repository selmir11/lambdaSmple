package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalAccountDetailsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class AdminPortalAccountDetailsSteps {
    AdminPortalAccountDetailsPage adminPortalAccountDetailsPage = new AdminPortalAccountDetailsPage(WebDriverManager.getDriver());

    @Then("I validate the primary member details on the account details page")
    public void iEnterGeneralDataToCreateAdminAccountWithEmail() {
        adminPortalAccountDetailsPage.validatePrimaryMemDetails();
    }

    @Then("I click on Edit Fields via OBO button on the account details page")
    public void iClickOnEditFieldsViaOBOButtonOnTheAccountDetailsPage() {
        adminPortalAccountDetailsPage.clickEditFieldsViaOBOButton();
    }

    @Then("I validate all details for primary holder on account details page")
    public void iValidateAllDetailsOfPrimary() {
        adminPortalAccountDetailsPage.validateAllDetailsOfPrimaryHolder();
    }

    @Then("I validate all Coco details for primary holder on account details page")
    public void iValidateCocoDetailsOfPrimary() {
        adminPortalAccountDetailsPage.validateCocoDetailsOfPrimaryHolder();
    }

}
