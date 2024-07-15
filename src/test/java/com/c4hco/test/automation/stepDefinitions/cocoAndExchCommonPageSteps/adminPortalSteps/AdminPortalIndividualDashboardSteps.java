package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminLceToolPage;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalIndividualDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPortalIndividualDashboardSteps {

    AdminPortalIndividualDashboardPage adminPortalIndividualDashboardPage = new AdminPortalIndividualDashboardPage(WebDriverManager.getDriver());

    @Then("I verify {string} container title")
    public void iVerifyContainerTitle() {
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
    @Then("I click on manage plan button on admin portal Individual dashboard")
    public void iClickManagePlanButton() {
        adminPortalIndividualDashboardPage.clickManagePlan();
    }
    @And("I Validate the correct enrolled plans are displayed on admin portal individual page")
    public void iverifyPlanDetails(List<String> data) {
        adminPortalIndividualDashboardPage.verifyPlanDetails(data);
    }
    @And("I validate individual dashboard container titles are displayed")
    public void iValidateIndividualDashboardContainerTitles() {
        adminPortalIndividualDashboardPage.validateIndividualDashboardContainerTitles();
    }
    @Then("I validate Selected Member data on the far left side")
    public void iValidateSelectedMemberData() {
        adminPortalIndividualDashboardPage.validateSelectedMemberData();    }
    @And("I Verify Payload Information Container")
    public void iVerifyPayloadInformationContainer() {
        adminPortalIndividualDashboardPage.verifyPayloadsContainer();   }
    @Then("I verify the option in years displays")
    public void iVerifyYears() {
        adminPortalIndividualDashboardPage.verifyYears();   }
    @And("I verify message displays in Renewals")
    public void iVerifyText() {
        adminPortalIndividualDashboardPage.verifyText();   }
    @And("I verify Program Manager information Account Summary")
    public void iVerifyProgramManagerInformationAccountSummary() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerInformationAccountSummary(); }
    @And("I validate all program manager dashboard container titles are displayed")
    public void iValidateProgramManagerDashboardContainerTitles() {
        adminPortalIndividualDashboardPage.validateProgramManagerDashboardContainerTitles();    }
    @And("I verify Program Manager contract status")
    public void iVerifyProgramManagerContractStatus() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerContractStatus(); }
    @And("I verify Program Manager Account Activity Container")
    public void iVerifyBrokerAccountActivityContainer() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerAccountActivityContainer();  }
    @And("I Verify Program Manager Client Information Container")
    public void iVerifyBrokerClientInformationContainer() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerClientInformationContainer();    }
    @And("I Verify organization Information Container")
    public void iVerifyProgramManagerOrganizationInformation() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerOrganizationInformation();    }
    @And("I click Go Back on admin portal program manager dashboard")
    public void iClickGoBackOnAdminPortalBrokerDashboard() {
        adminPortalIndividualDashboardPage.clickGoBackONAdminPortalProgramManager();    }
}





