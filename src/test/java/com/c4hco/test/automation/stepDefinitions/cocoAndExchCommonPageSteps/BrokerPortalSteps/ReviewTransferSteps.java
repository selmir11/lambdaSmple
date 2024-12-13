package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.ReviewTransferPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ReviewTransferSteps {
    ReviewTransferPage reviewTransferPage = new ReviewTransferPage(WebDriverManager.getDriver());

    @Then("I validate the Review Transfer page title")
    public void iValidateReviewTransferPageTitle(){
        reviewTransferPage.validateReviewTransferPageTitle();
    }

    @And("I validate the new broker field labels")
    public void iValidateNewBrokerFieldLabels(){
        reviewTransferPage.validateNewBrokerFieldLabels();
    }

    @Then("I validate the new broker transfer details are {string}, {string}, {string}, {string}, or {string}")
    public void iValidateNewBrokerTransferDetails(String brokerName, String agencyName, String brokerAddress, String brokerEmailSTG, String brokerEmailQA){
        reviewTransferPage.validateNewBrokerTransferDetails(brokerName, agencyName, brokerAddress, brokerEmailSTG, brokerEmailQA);
    }

    @Then("I validate the confirmation text transferring to {string} within {string}")
    public void iValidateTransferConfirmationText(String brokerName, String agencyName){
        reviewTransferPage.validateTransferConfirmationText(brokerName, agencyName);
    }

    @Then("I validate the buttons on the Review Transfer page")
    public void iValidateReviewTransferButtons(){
        reviewTransferPage.validateReviewTransferButtons();
    }

    @And("I validate the transfer warning text")
    public void iValidateTransferWarningText(){
        reviewTransferPage.validateTransferWarningText();
    }

    @And("I validate the client name is displayed on the Review Transfer page")
    public void iValidateClientNameDisplayed(){
        reviewTransferPage.validateClientNameDisplayed();
    }

    @And("I verify the number of clients to transfer is {string}")
    public void iVerifyClientTransferCount(String expectedCount){
        reviewTransferPage.verifyClientTransferCount(expectedCount);
    }

    @Then("I click the Transfer Clients button on the Review Transfer page")
    public void iClickTransferClientsButton(){
        reviewTransferPage.clickTransferClients();
    }

    @Then("I click the Remove from Transfer link for the first client listed")
    public void iClickRemoveFromTranferLink(){
        reviewTransferPage.clickRemoveFromTranfer();
    }

    @Then("I click {string} to removing the client from the transfer client list")
    public void iVerifyRemoveConfirmation(String confirmation){
        reviewTransferPage.removeClientConfirmation(confirmation);
    }

    @And("I verify that the Remove from Transfer link is disabled")
    public void iVerifyRemoveFromTransferLinkDisabled(){
        reviewTransferPage.verifyRemoveFromTransferLinkDisabled();
    }

    @Then("I click the Cancel button on the Review Transfer page")
    public void iClickCancelButton(){
        reviewTransferPage.clickCancelTransferClients();
    }

    @And("I verify the transfer all client message")
    public void iVerifyTransferAllClientsMessage(){
        reviewTransferPage.verifyTransferAllClientsMessage();
    }

    @And("I verify the total number of clients to transfer")
    public void iTotalClientNumber(){
        reviewTransferPage.totalClientNumber();
    }
}
