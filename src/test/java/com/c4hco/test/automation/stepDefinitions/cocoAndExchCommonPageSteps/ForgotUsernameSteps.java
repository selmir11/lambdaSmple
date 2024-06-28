package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ForgotUsernamePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ForgotUsernameSteps {
    ForgotUsernamePage forgotUsernamePage =  new ForgotUsernamePage(WebDriverManager.getDriver());
    @Then("I enter information's for Forgot username in {string} {string}")
    public void iEnterInformationSForForgotUsernameIn(String language, String appType) {
        forgotUsernamePage.informationSForForgotUsername(language, appType);
    }

    @And("I validate notice sent successful msg is displayed")
    public void iValidateNoticeSentSuccessfulMsgIsDisplayed() {
        forgotUsernamePage.ValidateNoticeSentSuccessfulMsgIsDisplayed();
    }
}
