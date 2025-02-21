package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.ManageAssociatedBrokersPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ManageAssociatedBrokersSteps {
    ManageAssociatedBrokersPage manageAssociatedBrokersPage = new ManageAssociatedBrokersPage(WebDriverManager.getDriver());

    @Then("I validate the Manage Associated Brokers page title")
    public void iValidateManageBrokerPageTitle(){
        manageAssociatedBrokersPage.validateManageBrokerPageTitle();
    }

    @And("I search for a broker named {string}")
    public void manageBrokerSearch(String brokerName){
        manageAssociatedBrokersPage.manageAssocBrokerSearch(brokerName);
    }

    @Then("I click the Add New Broker Link")
    public void iClickAddNewBrokerLink(){
        manageAssociatedBrokersPage.clickAddNewBrokerLink();
    }

    @Then("I send the invite to join my agency")
    public void sendAgencyInvite(){
        manageAssociatedBrokersPage.manageAssocBrokerSendInvite();
    }

    @Then("I remove the broker from my agency")
    public void removeBrokerFromAgency(){
        manageAssociatedBrokersPage.manageAssocBrokerRemove();
    }

    @Then("I click Go Back on the Manage Associated Brokers page")
    public void clickGoBackManageAssocBrokersPage(){
        manageAssociatedBrokersPage.clickGoBackManageAssocBrokers();
    }

    @Then("I validate the Send Invite link is {string}")
    public void validateSendInviteLink(String expectedState){
        manageAssociatedBrokersPage.validateSendInviteLinkExists(expectedState);
    }

    @And("I verify the invite is {string}")
    public void verifyAgencyInvite(String expectedStatus){
        manageAssociatedBrokersPage.verifyAgencyInviteStatus(expectedStatus);
    }

    @And("I validate the broker results match my broker named {string} on associated brokers")
    public void iValidateTheBrokerResultsMatchMyBrokerNamedOnAssociatedBrokers(String brokerName) {
        manageAssociatedBrokersPage.validateTheBrokerResultsMatchMyBrokerNamedOnAssociatedBrokers(brokerName);
    }

    @Then("I validate the broker status invite is on the right action")
    public void iValidateTheBrokerStatusInviteIsOnTheRightAction() {
        manageAssociatedBrokersPage.validateTheBrokerStatusInviteIsOnTheRightAction();
    }
}

