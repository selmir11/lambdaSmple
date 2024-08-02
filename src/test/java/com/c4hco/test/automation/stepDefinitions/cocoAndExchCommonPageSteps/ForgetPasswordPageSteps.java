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

    @Then("I enter valid email to any env QA {string} STG {string}")
    public void iEnterValidEmailToAnyEnvQASTG(String qaEmail, String stgEmail) {
        forgetPasswordPage.EnterValidEmailToAnyEnvQASTG(qaEmail, stgEmail);
    }

    @And("I enter the new password in create new password page")
    public void iEnterTheNewPasswordInCreateNewPasswordPage() {
        forgetPasswordPage.enterTheNewPasswordInCreateNewPasswordPage();
    }

    @And("I login as individual with password reset code to any env QA {string} STG {string}")
    public void iLoginAsIndividualWithPasswordResetCodeToAnyEnvQASTG(String qaEmail, String stgEmail) {
        forgetPasswordPage.loginAsIndividualWithPasswordResetCode(qaEmail,stgEmail);
    }
}
