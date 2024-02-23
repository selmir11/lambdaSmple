package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CompletedPeakApplicationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class completedPeakApplicationSteps {
    CompletedPeakApplicationPage completedApplicationPage = new CompletedPeakApplicationPage();
    @Then("I select No Thanks option from guide you section")
    public void iSelectNoThanks(){
        completedApplicationPage.selectNoThanksOption();
    }

    @And("I click on save and continue button")
    public void selectSaveAndContinue(){
        completedApplicationPage.clickSaveAndContinueButton();
    }

    @When("I switch to {string}")
    public void iSwitchTo(String switchTo) {
        completedApplicationPage.selectLocale(switchTo);
    }

    @And("I validate the verbiage on Let us guide you page in {string}")
    public void iValidateTheVerbiageOnLetUsGuideYouPage(String language) {
        completedApplicationPage.validateTheVerbiageOnLetUsGuideYouPage(language);
    }

    @And("I select {string} option on the Let us guide you page")
    public void iSelectOptionOnTheLetUsGuideYouPage(String option) {
        completedApplicationPage.iSelectOption(option);
    }
}
