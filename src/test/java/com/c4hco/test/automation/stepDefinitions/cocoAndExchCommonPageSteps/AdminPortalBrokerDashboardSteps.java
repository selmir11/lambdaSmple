package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalBrokerDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPortalBrokerDashboardSteps {
    AdminPortalBrokerDashboardPage adminPortalBrokerDashboardPage = new AdminPortalBrokerDashboardPage(WebDriverManager.getDriver());

    @Then("I validate AP broker dashboard Header any env: QA name {string} ID {string} User Type {string} STG name {string} ID {string} User Type {string}")
    public void iValidateAPBrokerDashboardHeaderAnyEnvQANameIDUserTypeSTGNameIDUserType(String qaName, String qaID, String qaUserType, String stgName, String stgID, String stgUserType) {
    adminPortalBrokerDashboardPage.validateAPBrokerDashboardHeader(qaName,qaID,qaUserType, stgName,  stgID,stgUserType);
    }

    @And("I verify Broker information's Account Summary")
    public void iVerifyBrokerInformationsAccountSummary() {
        adminPortalBrokerDashboardPage.VerifyBrokerInformationsAccountSummary();
    }

    @And("I verify Broker certification information's")
    public void iVerifyBrokerCertificationInformationS() {
        adminPortalBrokerDashboardPage.VerifyBrokerBrokerCertificationInformationS();
    }

    @And("I verify Broker Account Activity Container")
    public void iVerifyBrokerAccountActivityContainer() {
        adminPortalBrokerDashboardPage.VerifyBrokerAccountActivityContainer();
    }

    @And("I Verify Broker Client Information Container")
    public void iVerifyBrokerClientInformationContainer() {
        adminPortalBrokerDashboardPage.verifyBrokerClientInformationContainer();
    }

    @And("I click Go Back on admin portal broker dashboard")
    public void iClickGoBackOnAdminPortalBrokerDashboard() {
        adminPortalBrokerDashboardPage.clickGoBackONAdminPortalBroker();
    }

    @Then("I verify broker client information container no clients")
    public void iVerifyBrokerClientInformationContainerNoClients() {
        adminPortalBrokerDashboardPage.VerifyBrokerClientInformationContainerNoClients();
    }
    @Then("I click Manage Certification button")
    public void iClickManageCertification() {
        adminPortalBrokerDashboardPage.clickManageCertification();      }

    @And("I validate current Broker License Status: {string} and License Expiration Date: {string} with Certification Status: {string}")
    public void iVerifyBrokerLicenseStatusAndLicenseExpirationDateWithCertificationStatus(String licenseStatus, String licenseDate, String certificationStatus) {
        adminPortalBrokerDashboardPage.VerifyBrokerLicenseStatusAndLicenseExpirationDateWithCertificationStatus(licenseStatus, licenseDate, certificationStatus);
    }
    @Then("I change statuses and click Save button in manage certification container")
    public void iChangeStatusesThenClickSaveButton() {
        adminPortalBrokerDashboardPage.changeStatusesThenClickSaveButton();
    }
    @Then("I click Cancel button")
    public void iClickCancelButton() {
        adminPortalBrokerDashboardPage.clickCancelButton();
    }
    @And("I change statuses back and click Save")
    public void iChangeStatusesBack() {
        adminPortalBrokerDashboardPage.changeStatusesBack();
    }
    @Then("I click View Report button")
    public void iClickViewReportButton() {
        adminPortalBrokerDashboardPage.clickViewReportButton();
    }
    @Then("I verify Account Activity title")
    public void iVerifyTableTitle() {
        adminPortalBrokerDashboardPage.verifyTableTitle();
    }
    @And("I validate latest Broker Account Activity Report Event Code: {string} and today's Date then Username: {string} with Description: {string} and finally Detail Value: {string}")
    public void iVerifyBrokerAccountActivityReport(String eventCode, String nameOfUser, String description, String valueForAccountId) {
        adminPortalBrokerDashboardPage.verifyBrokerAccountActivityReport(eventCode, nameOfUser, description, valueForAccountId);
    }
    @And("I validate in Broker portal Certification Status: {string}")
    public void iVerifyInBrokerPortalStatusIsChanged(String certificationStatusBrokerPortal) {
        adminPortalBrokerDashboardPage.verifyInBrokerPortalStatusIsChanged(certificationStatusBrokerPortal);
    }
}
