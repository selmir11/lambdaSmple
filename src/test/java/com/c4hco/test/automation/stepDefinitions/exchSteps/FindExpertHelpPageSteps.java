package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.FindExpertHelpPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class FindExpertHelpPageSteps {
    FindExpertHelpPage findExpertHelpPage = new FindExpertHelpPage(WebDriverManager.getDriver());

    @Then("I click Continue on my own button from Find Expert Help page")
    public void iClickContinueOnMyOwnButton() {
        findExpertHelpPage.clickContinueOnMyOwnButton();
    }

    @Then("I click the back button from Find Expert Help page")
    public void iClickBackButton() {
        findExpertHelpPage.clickBackButton();
    }
    @Then("I click Find a Broker button")
    public void iClickfindABroker(){
         findExpertHelpPage.clickFindABrokerBtn();
    }
     @And("I Find the broker by name {string}")
    public void iFindBrokerByName(String brokerName){
        findExpertHelpPage.findBrokerByName(brokerName);
     }

}
