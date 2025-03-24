package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalReportsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminPortalReportsPageSteps {

    AdminPortalReportsPage adminPortalReportsPage = new AdminPortalReportsPage(WebDriverManager.getDriver());


    // =================== VALIDATION STEPS ===============//

    @Then("I validate Account Activity title row")
    public void iValidateTitleAccountActivity() {
        adminPortalReportsPage.validateTitleAccountActivity();
    }

    @Then("I validate {string} event code and description {string} in activity event report")
    public void iValidateEventCodeAndInActivityDescriptionEventReport(String eventType, String description) {
        adminPortalReportsPage.validateEventCodeInActivityEventReport(eventType, description);
    }

    @Then("I verify {string} and following events are displaying as {string} {string} {string} {string} {string} {string}")
    public void iVerifyAndFollowingEventsAreDisplayingAs(String text, String timeCondition, String qaUsername, String stagingUsername, String expectedValue, String expectedStatus, String expectedKey) {
        adminPortalReportsPage.VerifyEvents(text, timeCondition, qaUsername, stagingUsername, expectedValue, expectedStatus, expectedKey);
    }

    @Then("I validate the account activity record for {string} for {string}")
    public void validateAccActivityRecord(String recordType, String userType) {
        adminPortalReportsPage.validateRecord(recordType, userType);
    }

    @And("I validate Account Activity title")
    public void iValidateAccountActivityTitle() {
        adminPortalReportsPage.validateActivityTitle();
    }

    @Then("I verify Activity report table column names")
    public void iVerifyAccountReportTableColumnNames() {
        adminPortalReportsPage.validateActivityReportColumnNames();
    }

    @Then("I verify Primary account holder and account number displays on Activity Report")
    public void iVerifyPrimaryAccountHolderAndAccountNumberDisplaysOnActivityReport() {
        adminPortalReportsPage.validateMemberNameAndAccountID();
    }

    @Then("I validate {string} event code and their description {string} in activity event report")
    public void ValidateEventCodeAndDescription(String eventType, String description) {
        adminPortalReportsPage.validateEventCodeWithDescription(eventType, description);
    }
}
