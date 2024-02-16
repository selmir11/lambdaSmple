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

    @And("I should see the following text on the Let us guide you page {string}")
    public void iShouldSeeTheText(String expectedText) {
        completedApplicationPage.verifyTheText(expectedText);
    }

    @When("I switch to {string}")
    public void iSwitchTo(String switchTo) {
        completedApplicationPage.selectLocale(switchTo);
    }

    @And("I select Yes, I'm new to Connect for Health Colorado option")
    public void iSelectYesIMNewToConnectForHealthColoradoOption() {
        completedApplicationPage.setYesImNew();
    }
}
