package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.NoticesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class NoticesPageSteps {

    NoticesPage noticesPage = new NoticesPage(WebDriverManager.getDriver());
    @Then("I open outlook Tab")
    public void i_open_outlook_Tab() {
            noticesPage.openOutlookTab();
    }

    @Then("I validate the verbiage of the MFA page")
    public void i_validate_the_varbiage_of_the_MFA_page() {
            noticesPage.verbiageValidation();
    }

    @Then("I sign in to outlook with Valid Credentials {string} and {string}")
    public void i_sign_to_outlook_with_valid_credentials_and(String email, String password) {
        noticesPage.signInEmail(email, password);
    }

    @Then("I open the MFA notice")
    public void i_open_the_mfa_notice() {
        noticesPage.openMFANotice();
    }

    @And("I enter Invalid Verification Code")
    public void iEnterInvalidVerificationCode() {
        noticesPage.enterInvalidMFACode();
    }

    @Then("I click send new code")
    public void iClickSendNewCode() {
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

}
