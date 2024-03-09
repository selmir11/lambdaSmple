package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.c4hco.test.automation.sftpConfig.SftpConnection;

public class LoginPageSteps {

        LoginPage loginPage = new LoginPage(WebDriverManager.getDriver());

        @Given("I open the login page on the {string} portal")
        public void openPage(String portalType){
            loginPage.openPage(portalType);
            SftpConnection.main();
        }
        
        @When("I click create a new account on login page")
            public void iClickCreateAccount(){ loginPage.clickCreateAccount();}

        @And("I enter valid credentials to login")
           public void iEnterValidCredentials(){
            loginPage.logInWithValidCredentials();
        }

         @When("I login as Admin User")
            public void i_login_as_admin_user() {loginPage.loginAsAnAdminUser();}

    @When("I login as Broker User")
    public void i_login_as_Broker_user() {loginPage.loginAsBrokerUser();}
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
    }
