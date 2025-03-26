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
    @Then("I validate the name in QA {string} or stg {string} exist in the header of activity report Page")
    public void iValidateTheNameInQAOrStgExistInTheHeaderOfActivityReportPage(String qaName, String stgName) {
        adminPortalReportsPage.validateTheNameExistInTheHeaderOfActivityReportPage(qaName, stgName);
    }

    @And("I validate the accountID in QA {string} or stg {string} and userType is {string}")
    public void iValidateTheAccountIDInQAOrStgAndUserTypeIs(String qaAccountId, String stgAccountId, String userType) {
        adminPortalReportsPage.validateTheAccountIDInQAOrStgAndUserTypeIs(qaAccountId, stgAccountId,userType);}

    @Then("I verify {string} and following events are displaying as {string}")
    public void iVerifyAndFollowingEventsAreDisplayingAs(String text, String timeCondition) {
        adminPortalReportsPage. VerifyEventAndTime( text,  timeCondition);
    }

    @Then("I verify Primary account holder and account number displays on activity report")
    public void iVerifyPrimaryAccountHolderAndAccountNumberDisplaysOnActivityReport() {
        adminPortalReportsPage.validateActivityHeader();
    }

    @Then("I verify event code {string} and time and compare with previous update log event")
    public void iVerifyEventCodeAndTimeAndCompareWithPreviuosUpdateLogEvent(String event) {
        adminPortalReportsPage. VerifyAndCompareEventAndTime(event);
    }

    @Then("I verify and compare all {string} event and their time on activity report")
    public void iVerifyAllEventAndTheirTimeAndCompareLatestEventTime(String event) {
        adminPortalReportsPage.compareTimestamp(event);}
}
