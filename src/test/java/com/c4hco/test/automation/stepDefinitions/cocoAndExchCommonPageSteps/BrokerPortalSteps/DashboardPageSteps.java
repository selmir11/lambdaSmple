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



}
