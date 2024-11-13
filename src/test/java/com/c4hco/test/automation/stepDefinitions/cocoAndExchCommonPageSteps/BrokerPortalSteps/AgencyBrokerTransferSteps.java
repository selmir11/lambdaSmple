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

    @Then("I search for a broker by license number {string} on the Agency Broker Transfer page")
    public void iSearchForBrokerLicenseOnAgencyBrokerTransfer(String brokerLicense){
        agencyBrokerTransferPage.searchBrokerLicenseOnAgencyBrokerTransfer(brokerLicense);
    }

    @And("I clear the broker search box on the Agency Broker Transfer page")
    public void iClearBrokerSearchBoxAgencyBrokerTransfer(){
        agencyBrokerTransferPage.clearBrokerSearchBoxAgencyBrokerTransfer();
    }

    @And("I validate the broker results match my broker named {string}")
    public void iValidateBrokerSearchResults(String brokerName){
        agencyBrokerTransferPage.validateBrokerSearchResults(brokerName);
    }

    @And("I validate the new broker details are {string}, {string}, or {string}, {string}, {string}, {string}, {string}")
    public void iValidateBrokerSearchResultsDetails(String brokerName, String brokerEmailStg, String brokerEmailQa, String brokerPhone, String contactType, String agencyName, String brokerLicense){
        agencyBrokerTransferPage.validateBrokerSearchResultsDetails(brokerName, brokerEmailStg, brokerEmailQa, brokerPhone, contactType, agencyName, brokerLicense);
    }

    @Then("I click the transfer link on the Agency Broker Transfer page")
    public void iClickTransferLink(){
        agencyBrokerTransferPage.clickTransferLink();
    }

    @Then("I click the go back button on the Agency Broker Transfer page")
    public void iClickTransferGoBackButton(){
        agencyBrokerTransferPage.clickTransferGoBackButton();
    }

    @Then("I validate the Agency Broker Transfer page title")
    public void iValidateAgencyBrokerPageTitle(){
        agencyBrokerTransferPage.validateAgencyBrokerPageTitle();
    }
}
