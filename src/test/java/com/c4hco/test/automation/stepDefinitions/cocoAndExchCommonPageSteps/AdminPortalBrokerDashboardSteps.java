package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalBrokerDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

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
    @And("I validate in Broker portal Certification Status: {string}")
    public void iVerifyInBrokerPortalStatusIsChanged(String certificationStatusBrokerPortal) {
        adminPortalBrokerDashboardPage.verifyInBrokerPortalStatusIsChanged(certificationStatusBrokerPortal);
    }

    @Then("I click {string} on Account Summary container AP Broker dashboard page")
    public void iClickOnAccountSummaryContainerAPBrokerDashboardPage(String accountSummaryType) {
        adminPortalBrokerDashboardPage.clickOnAccountSummaryContainerAPBrokerDashboardPage( accountSummaryType);
    }

    @And("I enter new email email address {string} in the Summary container")
    public void iEnterNewEmailEmailAddressInTheSummaryContainer(String newEmail) {
        adminPortalBrokerDashboardPage.EnterNewEmailEmailAdresseInTheSummaryContainer( newEmail);
    }

    @Then("I click {string} button on Account Summary container AP Broker dashboard page")
    public void iClickButtonOnAccountSummaryContainerAPBrokerDashboardPage(String SaveCancelBtn) {
        adminPortalBrokerDashboardPage.clickButtonOnAccountSummaryContainerAPBrokerDashboardPage(SaveCancelBtn);

    }
    @Then("I set the email value for agency STG {string} QA {string}")
    public void iSetTheEmailValueForAgencySTGQA( String STGAccount, String QAAccount) {
        adminPortalBrokerDashboardPage.setTheEmailValue(STGAccount, QAAccount);
    }

    @And("I validate the success message is displayed")
    public void iValidateTheSuccessMessageIsDisplayed() {
        adminPortalBrokerDashboardPage.validateTheSuccessMessageIsDisplayed();
    }


    @Then("I set the email value for broker STG {string} QA {string}")
    public void iSetTheEmailValueForBrokerSTGQA(String STGAccount, String QAAccount) {
        adminPortalBrokerDashboardPage.setTheEmailValueForBrokerSTGQA(STGAccount, QAAccount);
    }

    @And("I click on Search button in AP broker dashboard page")
    public void iClickOnSearchButtonInAPBrokerDashboardPage() {
        adminPortalBrokerDashboardPage.clickOnSearchButtonInAPBrokerDashboardPage();
    }

    @Then("I validate the agency TIN in STG {string} and QA {string}")
    public void iValidateTheAgencyTINInSTGAndQA(String TINSTG, String TINQA) {
        adminPortalBrokerDashboardPage.validateTheAgencyTINInSTGAndQA(TINSTG,TINQA);
    }

    @And("I validate the status certification is {string}")
    public void iValidateTheStatusCertificationIs(String certificationStatus) {
        adminPortalBrokerDashboardPage.validateTheStatusCertificationIs(certificationStatus);
    }

    @Then("I change the certification status to {string}")
    public void iChangeTheCertificationStatusTo(String certificationStatus) {
        adminPortalBrokerDashboardPage.changeTheCertificationStatusTo(certificationStatus);
    }

}
