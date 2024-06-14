package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalIndividualDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPortalIndividualDashboardSteps {

    AdminPortalIndividualDashboardPage adminPortalIndividualDashboardPage = new AdminPortalIndividualDashboardPage(WebDriverManager.getDriver());

    @Then("I verify {string} container title")
    public void iVerifyContainerTitle(String reports) {
        adminPortalIndividualDashboardPage.verifyContainerTitle();
    }
    @Then("I click on view button for {string} report")
    public void iClickOnViewButtonForreport(String searchText) {
        adminPortalIndividualDashboardPage.viewReportLinks(searchText);
    }
    @Then("I verify Primary account holder and account number displays")
    public void iVerifyPrimaryAccountHolderDisplays() {
        adminPortalIndividualDashboardPage.verifyPrimaryHolder();
    }
    @And("I search for Agency using {string} {string} on Agency dashboard")
    public void iSearchForAgency(String agencyData, String type) {
        adminPortalIndividualDashboardPage.enterAgencyData(agencyData, type);
    }
    @Then("I verify Agency name and account number displays")
    public void iVerifyAgencyContainerTitle() {
        adminPortalIndividualDashboardPage.verifyAgencyContainerTitle();
    }
    @Then("I validate data for Agency Summary: {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iValidateDataForAgencySummary(String name, String license, String thin, String agent, String email, String website, String phone, String preferredLanguage) {
        adminPortalIndividualDashboardPage.agencySummaryValidation(name, license, thin, agent, email, website, phone, preferredLanguage);
    }
    @Then("I validate my agency address is {string}")
    public void iValidateMyAgencyAddress(String address) {
        adminPortalIndividualDashboardPage.validateAgencyAddress(address);
    }
    @Then("I click on manage plan button on admin portal Individual dashboard")
    public void iClickManagePlanButton() {
        adminPortalIndividualDashboardPage.clickManagePlan();
    }
    @And("I Validate the correct enrolled plans are displayed on admin portal individual page")
    public void iverifyPlanDetails(List<String> data) {
        adminPortalIndividualDashboardPage.verifyPlanDetails(data);
    }
}






