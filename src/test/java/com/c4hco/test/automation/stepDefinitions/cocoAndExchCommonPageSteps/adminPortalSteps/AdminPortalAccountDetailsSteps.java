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

    @Then("I verify font color format of primary account holder label")
    public void iVerifyFontColorFormatOfPrimaryAccountHolderLabel() {
        adminPortalAccountDetailsPage.verifyFontColorFormatOfPrimaryAccountHolderLabel();
    }

    @Then("I verify account id displayed in any Env {string} {string}")
    public void iVerifyAccountIdDisplayedInAnyEnv(String staging, String qa) {
        adminPortalAccountDetailsPage.verifyAccountIdDisplayedInAnyEnv(staging,qa);
    }

    @Then("I verify account table labels of account detail container")
    public void iVerifyAccountTableLabelOfAccountDetailContainer() {
        adminPortalAccountDetailsPage.verifyAccountTableLabelOfAccountDetailContainer();
    }

    @Then("I verify primary account holder name in account detail container")
    public void iVerifyPrimaryAccountHolderNameInAccountDetailContainer() {
        adminPortalAccountDetailsPage.verifyPrimaryAccountHolderNameInAccountDetailContainer();
    }

    @Then("I verify account table field values of account detail container")
    public void iVerifyAccountTableFieldValuesOfAccountDetailContainer() {
        adminPortalAccountDetailsPage.verifyAccountTableFieldValuesOfAccountDetailContainer();
    }
}
