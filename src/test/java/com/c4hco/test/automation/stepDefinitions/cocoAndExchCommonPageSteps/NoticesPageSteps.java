package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.NoticesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class NoticesPageSteps {

    NoticesPage gmailPage = new NoticesPage(WebDriverManager.getDriver());
    @Then("I open Gmail Tab")
    public void i_open_gmail_Tab() {
            gmailPage.openGmailTab();
    }

    @Then("I validate the verbiage of the MFA page")
    public void i_validate_the_varbiage_of_the_MFA_page() {
            gmailPage.verbiageValidation();
    }

    @Then("I sign in with Valid Credentials {string} and {string}")
    public void i_sign_with_valid_credentials_and(String email, String password) {
        gmailPage.signInEmail(email, password);
    }

    @Then("I open the MFA notice")
    public void i_open_the_mfa_notice() {
        gmailPage.openMFANotice();
    }

    @And("I enter Invalid Verification Code")
    public void iEnterInvalidVerificationCode() {
        gmailPage.enterInvalidMFACode();
    }

    @Then("I click send new code")
    public void iClickSendNewCode() {
        gmailPage.sendNewCode();
    }

    @Then("I get the MFA code")
    public void iGetTheMFACode() {
        gmailPage.getMfaCode();
    }

    @Then("I enter the MFA code and click Verify")
    public void iEnterTheMFACodeAndClickVerify() {
        gmailPage.enterValidMfaCode();
    }

    @Then("I validate the error message on the MFA page")
    public void iValidateTheErrorMessageOnTheMFAPage() {
        gmailPage.verifyErrorText();
    }

}
