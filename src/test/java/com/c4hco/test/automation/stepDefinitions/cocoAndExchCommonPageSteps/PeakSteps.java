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

    @Then("I click on the Sign in with Connect for Health Colorado button")
    public void iClickSignInWIthConnectForHealthColoradoButton() {
        peakPage.clickSignInWIthConnectForHealthColoradoButton();
    }

    @Then("I click on the PEAK Sign out button")
    public void iClickPeakSignOUtButton() {
        peakPage.clickPeakSignOUtButton();
    }

    @And("I validate the PEAK welcome text")
    public void iValidatePeakWelcomeText() {
        peakPage.validatePeakWelcomeText();
    }
}
