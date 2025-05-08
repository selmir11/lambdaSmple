package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.LoginPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages.LoginPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;


public class LoginPageSteps {

        LoginPage loginPage = new LoginPage(WebDriverManager.getDriver());

        @Given("I open the login page on the {string} portal")
        public void openPage(String portalType) {
            loginPage.openPage(portalType);
        }



      //   =================VALIDATION STEPS==============//
        @When("I click on sign in on login page")
        public void iClickOnSignInonloginpage() {
            loginPage.clickSignIn();
        }

    @And("I validate the error msg username and password required in {string}")
    public void iValidateTheErrorMsgUsernameAndPasswordRequiredIn(String language) {
            loginPage.validateTheErrorMsgUsernameAndPasswordRequiredIn(language);
    }

    @And("I change the language from header to {string}")
    public void iChangeLanguage(String language){ loginPage.changeLanguage(language);}
}
