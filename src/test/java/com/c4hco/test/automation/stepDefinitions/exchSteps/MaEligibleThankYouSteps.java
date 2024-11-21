package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleThankYouPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MaEligibleThankYouSteps {

    MaEligibleThankYouPage maEligibleThankYouPage = new MaEligibleThankYouPage(WebDriverManager.getDriver());

    @Then("I click Continue on Thank You MA page")
    public void iClickContinue() {maEligibleThankYouPage.clickContinue();}

}
