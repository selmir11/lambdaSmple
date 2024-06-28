package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ForgetPasswordPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class ForgetPasswordPageSteps {
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(WebDriverManager.getDriver());

    @Then("I validate the Forgot my password page title in {string}")
    public void iValidateForgotMyPasswordPageTitle(String language) {
        forgetPasswordPage.validateForgotMyPasswordPageTitle(language);
    }

    @Then("I verify enter your password text is displayed in {string}")
    public void iVerifyEnterYourPasswordTextIsDisplayed(String language) {
        forgetPasswordPage.enterPasswordText(language);
    }

    @And("I click submit button")
    public void iClickSubmitButton() {
        forgetPasswordPage.clickSubmit();
    }

    @Then("I verify error username required text is displayed in {string}")
    public void iVerifyErrorUsernameRequiredTextIsDisplayed(String language) {
        forgetPasswordPage.errorUsernameRequiredText(language);
    }

    @And("I enter valid email {string}")
    public void iEnterValidEmail(String emailAddress) {
        forgetPasswordPage.enterValidPassword(emailAddress);
    }

    @Then("I verify notice is sent to the client text in {string}")
    public void iVerifyNoticeIsSentToTheClientText(String language) {
        forgetPasswordPage.verifyNoticeIsSentText(language);
    }
}
