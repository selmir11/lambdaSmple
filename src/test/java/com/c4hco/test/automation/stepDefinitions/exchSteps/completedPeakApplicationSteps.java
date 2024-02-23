package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CompletedPeakApplicationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class completedPeakApplicationSteps {
    CompletedPeakApplicationPage completedApplicationPage = new CompletedPeakApplicationPage(WebDriverManager.getDriver());
    @Then("I select No Thanks option from guide you section")
    public void iSelectNoThanks(){
        completedApplicationPage.selectNoThanksOption();
    }
    @And("I click on save and continue button")
    public void selectSaveAndContinue(){
        completedApplicationPage.clickSaveAndContinueButton();
    }
}
