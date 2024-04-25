package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ForgetPasswordPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class ForgetPasswordPageSteps {
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(WebDriverManager.getDriver());
    @Then("I verify enter your password text is displayed")
    public void iVerifyEnterYourPasswordTextIsDisplayed() {
        forgetPasswordPage.enterPasswordText();
    }

    @And("I click submit button")
    public void iClickSubmitButton() {
        forgetPasswordPage.clickSubmit();
    }

    @Then("I verify error username required text is displayed")
    public void iVerifyErrorUsernameRequiredTextIsDisplayed() {
        forgetPasswordPage.errorUsernameRequiredText();
    }

    @And("I enter valid email {string}")
    public void iEnterValidEmail(String emailAddress) {
        forgetPasswordPage.enterValidPassword(emailAddress);
    }

    @Then("I verify notice is sent to the client text")
    public void iVerifyNoticeIsSentToTheClientText() {
        forgetPasswordPage.verifyNoticeIsSentText();
    }
}
