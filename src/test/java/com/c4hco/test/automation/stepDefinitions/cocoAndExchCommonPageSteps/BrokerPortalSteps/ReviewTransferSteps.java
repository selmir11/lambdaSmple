package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.ReviewTransferPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ReviewTransferSteps {
    ReviewTransferPage reviewTransferPage = new ReviewTransferPage(WebDriverManager.getDriver());

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
}
