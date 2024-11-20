package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalReportsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class AdminPortalReportsPageSteps {

    AdminPortalReportsPage adminPortalReportsPage = new AdminPortalReportsPage(WebDriverManager.getDriver());


    // =================== VALIDATION STEPS ===============//

    @Then("I validate Account Activity title row")
    public void iValidateTitleAccountActivity() {
        adminPortalReportsPage.validateTitleAccountActivity();  }
    @Then("I validate {string} {string} {string} {string} in account activity table")
    public void iValidateInAccountActivityTable(String activityText, String activityUser, String activityTime, String descriptionData) {
        adminPortalReportsPage.viewActivity(activityText, activityUser, activityTime, descriptionData);    }

    @Then("I validate {string} event code and description {string} in activity event report")
    public void iValidateEventCodeAndInActivityDescriptionEventReport(String eventType, String description) {
        adminPortalReportsPage.validateEventCodeInActivityEventReport(eventType, description);
    }

}
