package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.AddABrokerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddABrokerSteps {
    AddABrokerPage addABrokerPage = new AddABrokerPage(WebDriverManager.getDriver());

    @Then("I search for the new broker")
    public void searchForTheNewBroker(){
        addABrokerPage.searchForNewBroker();
    }

    @And("I validate the broker results match my broker's details")
    public void validateNewBrokerDetails(){
        addABrokerPage.validateBrokerDetails();
    }

    @Then("I click the Add link on the Add a Broker page")
    public void iClickAddLink(){
        addABrokerPage.clickAddLink();
    }

    @Then("I validate the Invitation Sent text")
    public void iValidateInviteSentText(){
        addABrokerPage.validateInviteSentText();
    }

    @Then("I click Go Back on the Add a Broker page")
    public void iClickGoBackAddaBrokerPage(){
        addABrokerPage.clickGoBackAddaBrokerPage();
    }
}
