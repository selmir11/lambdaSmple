package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.PeakPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PeakSteps {
    PeakPage peakPage = new PeakPage(WebDriverManager.getDriver());

    @Then("I click Ok on the PEAK alert")
    public void iClickOkOnThePeakAlertWindow() {
        peakPage.clickOkOnThePeakAlertWindow();
    }

    @When("I login as PEAK User {string} password {string}")
    public void iLoginPeakUser(String username, String password) {
        peakPage.loginPeakUser(username, password);
    }

    @And("I validate the PEAK skeleton error message text")
    public void iValidatePeakSkeletonErrorMessage() {
        peakPage.validatePeakSkeletonErrorMessage();
    }
}
