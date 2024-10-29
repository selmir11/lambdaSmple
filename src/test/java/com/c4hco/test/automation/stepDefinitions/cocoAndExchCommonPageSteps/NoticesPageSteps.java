package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.NoticesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;

public class NoticesPageSteps {

    NoticesPage noticesPage = new NoticesPage(WebDriverManager.getDriver());
    @Then("I open outlook Tab")
    public void i_open_outlook_Tab() {
            noticesPage.openOutlookTab();
    }
    @Then("I open Password Reset Tab")
    public void i_open_Password_Reset_Tab() {
            noticesPage.openPasswordResetTab();
    }

    @Then("I validate the verbiage of the MFA page")
    public void i_validate_the_varbiage_of_the_MFA_page() {
            noticesPage.verbiageValidation();
    }

    @Then("I sign in to outlook with Valid Credentials {string} and {string}")
    public void i_sign_to_outlook_with_valid_credentials_and(String email, String password) {
        noticesPage.signInEmail(email, password);
    }

    @Then("I sign out of Outlook")
    public void iSignOutOutlook() {
        noticesPage.signOutEmail();
    }

    @Then("I open the MFA notice")
    public void i_open_the_mfa_notice() {
        noticesPage.openMFANotice();
    }

    @And("I enter Invalid Verification Code")
    public void iEnterInvalidVerificationCode() {
        noticesPage.enterInvalidMFACode();
    }

    @Then("I click Didn't receive an email?")
    public void iClickDidnTReceiveAnEmail() {
        noticesPage.sendNewCode();
    }

    @Then("I get the MFA code")
    public void iGetTheMFACode() {
        noticesPage.getMfaCode();
    }

    @Then("I enter the MFA code and click Verify")
    public void iEnterTheMFACodeAndClickVerify() {
        noticesPage.enterValidMfaCode();
    }

    @Then("I validate the error message on the MFA page")
    public void iValidateTheErrorMessageOnTheMFAPage() {
        noticesPage.verifyErrorText();
    }

    @And("I delete the open notice")
    public void iDeleteTheOpenNotice() {noticesPage.deleteOpenNotice();}


    @And("I verify request new option is displayed")
    public void iVerifyRequestNewOptionIsDisplayed() {
        noticesPage.VerifyRequestNewOptionIsDisplayed();
    }

    @Then("I click request new code")
    public void iClickRequestNewCode() {
        noticesPage.clickRequestNewCode();
    }

    @Then("I open the notice {string} in {string}")
    public void iOpenTheNoticeIn(String noticeNumber, String language) {
        noticesPage.openAllNotices(noticeNumber, language);
    }


    @And("I verify the notice Text for {string} in {string} for {string}")
    public void iVerifyTheNoticeTextForAMIn(String noticeNumber, String language,String typeAPP) {
        noticesPage.VerifyTheNoticeText(noticeNumber,language,typeAPP);
    }
    @And("I verify the notice Text for AM-016-01 coco in {string}")
    public void iVerifyTheNoticeTextForAMCocoIn( String language) {
        noticesPage.VerifyTheNoticeTextAM01601coco(language);
    }

    @And("I verify the notice Text for AM-016-03")
    public void iVerifyTheNoticeTextForAM() {
        noticesPage.VerifyTheNoticeTextAM01603();
    }

    @And("I validate additional details for {string} plan on email notice")
    public void validatePolicyDetailsInEmail(String planType, List <String> memberListOnPolicy) {
        noticesPage.validateDetailsFromEmailPolicy(planType, memberListOnPolicy);
    }
    @Then("I click the password reset link")
    public void iClickThePasswordResetLink() {
        noticesPage.clickThePasswordResetLink();
    }
}
