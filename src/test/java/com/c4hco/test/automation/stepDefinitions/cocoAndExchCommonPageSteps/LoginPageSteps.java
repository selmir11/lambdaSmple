package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;


public class LoginPageSteps {

        LoginPage loginPage = new LoginPage(WebDriverManager.getDriver());

        @Given("I open the login page on the {string} portal")
        public void openPage(String portalType) {
            loginPage.openPage(portalType);
        }
        
        @When("I click create a new account on login page")
            public void iClickCreateAccount(){ loginPage.clickCreateAccount();}

        @And("I enter valid credentials to login")
           public void iEnterValidCredentials(){
            loginPage.logInWithValidCredentials();
        }

         @When("I login as Admin User")
            public void i_login_as_admin_user() {loginPage.loginAsAnAdminUser();}
    @When("I login as Admin any User {string} and {string}")
    public void i_login_as_adminAnyUser(String usernameAdmin, String passwordAdmin) {
        loginPage.loginAdminUser(usernameAdmin, passwordAdmin); }

    @When("I login as {string} and {string} individual existing user")
    public void iLoginAsExistingIndividual(String userIndividual,String password) {
        loginPage.loginAsExistingIndividual(userIndividual, password);}

    @When("I login as Broker User {string} password {string}")
    public void i_login_as_Broker_user(String BrokerUserName,String password) {loginPage.loginAsBrokerUser(BrokerUserName,password);}

    @And("I login as Broker User any environment {string} password {string} and {string} password {string}")
    public void iLoginAsBrokerUserAnyEnvironmentPasswordAndPassword(String stgUser, String stgPW, String qaUser, String qaPW) {
        loginPage.loginAsBrokerUserAnyEnv(stgUser,stgPW,qaUser,qaPW);
    }

    @When("I click create forgot {string}")
    public void i_click_create_forget(String credentials) {
            switch (credentials){
                case "password":
                    loginPage.clickForgotPassword();
                break;
                case "username":
                    loginPage.clickForgotUsername();
                    break;}
            }


        // =================VALIDATION STEPS==============//
        @When("I click on sign in on login page")
        public void iClickOnSignInonloginpage() {
            loginPage.clickSignIn();
        }

    @And("I receive error message for Username")
    public void iReceiveErrorMessageForUsername() {
        loginPage.usernameRequiredMessage();
    }

    @And("I receive error message for Password")
    public void iReceiveErrorMessageForPassword() {
        loginPage.passwordRequiredMessage();
    }

    @And("I receive message I forgot username and password")
    public void iReceiveMessageIForgotUsernameAndPassword() {
        loginPage.usernameandpasswordRequiredMessage();
    }

    @Then("I validate the title of the page")
    public void iValidateTheTitleOfThePage() {

    }

    @Then("I validate the title of the page in {string}")
    public void iValidateTheTitleOfThePageIn(String language) {
        loginPage.validateTheTitleOfThePage(language);
    }

    @And("I validate the username and password text in the login page in {string}")
    public void iValidateTheUsernameAndPasswordTextInTheLoginPageIn(String language) {
        loginPage.ValidateTheUsernameAndPasswordText(language);
    }

    @Then("I validate PEAK Text in {string}")
    public void iValidatePEAKTextIn(String language) {
        loginPage.ValidatePEAKText(language);
    }

    @And("I validate legal notice text in {string}")
    public void iValidateLegalNoticeTextIn(String language) {
        loginPage.ValidateLegalNoticeText(language);
    }

    @Then("I verify Expired Password error message in {string}")
    public void iVerifyExpiredPasswordErrorMessageIn(String language) {
        loginPage.verifyExpiredPasswordErrorMessage(language);
    }


}
