package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.LoginPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages.ForgotUsernamePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ForgotUsernameSteps {
    ForgotUsernamePage forgotUsernamePage =  new ForgotUsernamePage(WebDriverManager.getDriver());
    @Then("I enter information's for Forgot username in STG Firsname {string} LastName {string} phone {string} accountType {string} or QA Firsname {string} LastName {string} phone {string}")
    public void iEnterInformationSForForgotUsernameInInSTGFirsnameLastNamePhoneAccountTypeOrQAFirsnameLastNamePhoneAccountType( String FirsnameSTG, String LastNameSTG, String phoneSTG, String accountTypeData, String FirsnameQA, String LastNameQA, String phoneQA) {
        forgotUsernamePage.informationSForForgotUsername(FirsnameSTG,LastNameSTG,phoneSTG, accountTypeData, FirsnameQA, LastNameQA, phoneQA);
    }

    @And("I validate notice sent successful msg is displayed")
    public void iValidateNoticeSentSuccessfulMsgIsDisplayed() {
        forgotUsernamePage.ValidateNoticeSentSuccessfulMsgIsDisplayed();
    }


    @Then("I click submit on forgot username Page")
    public void iClickSubmitOnForgotUsernamePage() {
        forgotUsernamePage.clickSubmitOnForgotUsernamePage();
    }

    @And("I verify the error msg in {string}")
    public void iVerifyTheErrorMsgIn(String language) {
        forgotUsernamePage.verifyTheFirstNameErrorMsgIn(language);
    }

}
