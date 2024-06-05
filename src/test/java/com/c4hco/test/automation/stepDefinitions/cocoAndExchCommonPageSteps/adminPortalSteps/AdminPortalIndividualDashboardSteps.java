package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalIndividualDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class AdminPortalIndividualDashboardSteps {

    AdminPortalIndividualDashboardPage adminPortalIndividualDashboardPage = new AdminPortalIndividualDashboardPage(WebDriverManager.getDriver());

    @Then("I verify {string} container title")
    public void iVerifyContainerTitle(String reports) {
        adminPortalIndividualDashboardPage.verifyContainerTitle();       }
    @Then("I click on view button for {string} report")
    public void iClickOnViewButtonForreport(String searchText) {
        adminPortalIndividualDashboardPage.viewReportLinks(searchText);     }
    @Then("I verify Primary account holder and account number displays")
    public void iVerifyPrimaryAccountHolderDisplays() {
        adminPortalIndividualDashboardPage.verifyPrimaryHolder();       }
    @Then("I click on manage plan button on admin portal Individual dashboard")
    public void iClickManagePlanButton() {
        adminPortalIndividualDashboardPage.clickManagePlan();
    }
    @And("I Validate the correct enrolled plans are displayed on admin portal individual page")
    public void iverifyPlanDetails(List<String> data) {
        adminPortalIndividualDashboardPage.verifyPlanDetails(data);
    }
}
