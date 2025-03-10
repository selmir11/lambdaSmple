package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.DashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashboardPageSteps {
    DashboardPage dashboardPage = new DashboardPage(WebDriverManager.getDriver());

    @Then("I click Agency Dashboard")
    public void iClickAgencyDashboard(){
        dashboardPage.clickAgencyDashboard();
    }

    @Then("I click Broker Dashboard")
    public void iClickBrokerDashboard(){
        dashboardPage.clickBrokerDashboard();
    }

    @Then("I verify the Broker Dashboard button is displayed")
    public void iVerifyBrokerDashboard(){
        dashboardPage.verifyBrokerDashboard();
    }

    @Then("I verify the Agency Dashboard button is displayed")
    public void iVerifyAgencyDashboard(){
        dashboardPage.verifyAgencyDashboard();
    }

    @Then("I validate the dashboard displays my {string} name")
    public void iVerifyBrokerDashboardTitle(String portalUserType){
        dashboardPage.verifyBrokerDashboardTitle(portalUserType);
    }

    @Then("I validate the current broker certification status is {string}")
    public void iVerifyBrokerCertStatus(String certificationStatus){
        dashboardPage.verifyBrokerCertStatus(certificationStatus);
    }

    @Then("I validate the current agency certification status is {string}")
    public void iVerifyAgencyCertStatus(String certificationStatus){
        dashboardPage.verifyAgencyCertStatus(certificationStatus);
    }

    @And("I validate that the broker certification is not displayed")
    public void iVerifyBrokerCertStatusNotDisplayed(){
        dashboardPage.verifyBrokerCertStatusNotDisplayed();
    }

    @And("I click the C4U Link")
    public void iClickC4ULink(){
        dashboardPage.clickC4ULink();
    }

    @And("I click Complete Profile")
    public void iClickCompleteProfile(){
        dashboardPage.clickCompleteProfile();
    }

    @And("I click Agency Complete Profile")
    public void iClickAgencyCompleteProfile(){
        dashboardPage.clickAgencyCompleteProfile();
    }

    @Then("I click the Manage Brokers button")
    public void clickManageBrokersButton(){
        dashboardPage.clickManageBrokersButton();
    }

    @Then("I click the Manage Users button")
    public void clickManageUsersButton(){
        dashboardPage.clickManageUsersButton();
    }

    @Then("I click the My Agency View link")
    public void clickMyAgencyViewLink(){
        dashboardPage.clickMyAgencyView();
    }

    @Then("I click the Edit Agency Information link")
    public void clickEditAgencyInformation(){
        dashboardPage.clickEditAgencyInformation();
    }

    @Then("I click Edit in Account Summary")
    public void clickEditAccountSummary(){
        dashboardPage.clickEditAccountSummary();
    }

    @And("I verify the new agency owner Account Summary details")
    public void iVerifyAgencyOwnerAccountSummaryDetails(){
        dashboardPage.verifyAgencyOwnerAccountSummaryDetails();
    }

    @Then("I click View Your Clients button")
    public void clickViewYourClients(){
        dashboardPage.clickViewYourClientsButton();
    }

    @And("I search Client Information for my client")
    public void clientInformationSearch(){
        dashboardPage.clientInformationSearch();
    }

    @Then("I verify my client's name is displayed in Client Information")
    public void verifyClientNameClientInformation(){
        dashboardPage.clientNameClientInformation();
    }

    @Then("I verify the currently assigned broker is {string}")
    public void verifyCurrentAssignedBroker(String assignedBroker){
        dashboardPage.currentAssignedBroker(assignedBroker);
    }

    @Then("I change the assigned broker to {string}")
    public void updateAssignedBroker(String assignedBroker){
        dashboardPage.changeAssignedBroker(assignedBroker);
    }

    @Then("I validate the {string} email on the communication Prefrences container on broker dashboard page")
    public void iValidateTheEmailOnTheCommunicationPrefrencesContainerOnBrokerDashboardPage(String brokerType) {
        dashboardPage.validateTheEmailOnTheCommunicationPrefrencesContainerOnBrokerDashboardPage(brokerType);
    }
    @Then("I save the agency details")
    public void saveExistingAgencyDetails(){
        dashboardPage.saveAgencyDetails();
    }

    @Then("I verify the Agency Information displays {string}, {string} and {string}")
    public void iVerifyAgencyInformationDetails(String agencyName, String agencyEmail, String agencyPhone){
        dashboardPage.verifyAgencyInformationDetails(agencyName,agencyEmail, agencyPhone);
    }

    @Then("I verify the Enter Agency invitation code field is displayed")
    public void iVerifyAgencyInformationInviteCode(){
        dashboardPage.verifyAgencyInformationInviteCode();
    }

    @Then("I verify the Enter Agency invitation code error message")
    public void iVerifyAgencyInfoInviteCodeError(){
        dashboardPage.verifyAgencyInfoInviteCodeError();
    }

    @Then("I enter the admin staff invitation code under Agency Information")
    public void iEnterAgencyInfoInviteCode(){
        dashboardPage.enterAgencyInfoInviteCode();
    }

    @Then("I verify the new Agency Information displays")
    public void iVerifyNewAgencyInformation(){
        dashboardPage.verifyNewAgencyInformation();
    }

    @And("I verify the Agency Information does not display")
    public void iVerifyNoAgencyInformation(){
        dashboardPage.verifyNoAgencyInformation();
    }

    @And("I verify the Complete your profile button displays")
    public void iVerifyCompleteProfileButtonDisplays(){
        dashboardPage.verifyCompleteProfileButtonDisplays();
    }
}
