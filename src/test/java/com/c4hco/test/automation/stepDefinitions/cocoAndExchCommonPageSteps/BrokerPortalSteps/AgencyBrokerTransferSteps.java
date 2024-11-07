package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.AgencyBrokerTransferPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AgencyBrokerTransferSteps {
    AgencyBrokerTransferPage agencyBrokerTransferPage = new AgencyBrokerTransferPage(WebDriverManager.getDriver());

    @Then("I search for a broker named {string} on the Agency Broker Transfer page")
    public void iSearchForBrokerOnAgencyBrokerTransfer(String brokerName){
        agencyBrokerTransferPage.searchBrokerOnAgencyBrokerTransfer(brokerName);
    }

    @And("I validate the broker results match my broker named {string}")
    public void iValidateBrokerSearchResults(String brokerName){
        agencyBrokerTransferPage.validateBrokerSearchResults(brokerName);
    }

    @Then("I click the transfer link on the Agency Broker Transfer page")
    public void iClickTransferLink(){
        agencyBrokerTransferPage.clickTransferLink();
    }

    @Then("I validate the Agency Broker Transfer page title")
    public void iValidateAgencyBrokerPageTitle(){
        agencyBrokerTransferPage.validateAgencyBrokerPageTitle();
    }
}
