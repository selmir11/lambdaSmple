package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.LoginPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages.ForgetPasswordPage;
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

    @Then("I enter valid email of the account created")
    public void iEnterValidEmailOfTheAccountCreated() {
        forgetPasswordPage.enterValidEmailOfTheAccountCreated();
    }

    @And("I login as individual with password reset code")
    public void ILoginAsIndividualWithPasswordResetCode() {
        forgetPasswordPage.LoginAsIndividualWithPasswordResetCode();
    }

    @And("I enter the previous password")
    public void iEnterThePreviousPassword() {
        forgetPasswordPage.enterThePreviousPassword();
    }

    @Then("I validate the error msg for used password {string}")
    public void iValidateTheErrorMsgForUsedPassword(String language) {
        forgetPasswordPage.validateTheErrorMsgForUsedPassword(language);
    }

    @Then("I validate create new password must contain at least 8 characters error message in {string}")
    public void iValidateCreateNewPasswordMustContainAtLeastCharactersErrorMessageIn( String language) {
        forgetPasswordPage.validateCreateNewPasswordMustContainAtLeastCharactersErrorMessageIn(language);
    }

    @Then("I validate create new password must contain 1 uppercase character error message in {string}")
    public void iValidateCreateNewPasswordMustContainUppercaseCharacterErrorMessageIn( String language) {
        forgetPasswordPage.validateCreateNewPasswordMustContainUppercaseCharacterErrorMessageIn(language);
    }

    @Then("I validate create new password must contain 1 lowercase character error message in {string}")
    public void iValidateCreateNewPasswordMustContainLowercaseCharacterErrorMessageIn( String language) {
        forgetPasswordPage.validateCreateNewPasswordMustContainLowercaseCharacterErrorMessageIn( language);
    }

    @Then("I validate create new password must contain 1 number error message in {string}")
    public void iValidateCreateNewPasswordMustContainNumberErrorMessageIn( String language) {
        forgetPasswordPage.validateCreateNewPasswordMustContainNumberErrorMessageIn( language);
    }

    @Then("I validate the password cannot contain part of the {string} error message in {string}")
    public void iValidateThePasswordCannotContainPartOfTheErrorMessageIn(String typeUser, String language) {
        forgetPasswordPage.validateCreateNewPasswordCannotContainPartOfTheUsernameErrorMessageIn(typeUser,language);
    }

    @Then("I validate create new password cannot contain the first name error message in {string}")
    public void iValidateCreateNewPasswordCannotContainTheFirstNameErrorMessageIn(String language) {
        forgetPasswordPage.validateCreateNewPasswordCannotContainTheFirstNameErrorMessageIn(language);
    }

    @And("I validate the assistance information is displayed in {string}")
    public void iValidateTheAssistanceInformationIsDisplayedIn(String language) {
        forgetPasswordPage.validateTheAssistanceInformationIsDisplayedIn(language);
    }
}
