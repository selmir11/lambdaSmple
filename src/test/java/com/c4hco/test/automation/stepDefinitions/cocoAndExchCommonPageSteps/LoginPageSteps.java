package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import io.cucumber.java.en.*;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;

import java.time.Duration;



public class LoginPageSteps {

        LoginPage loginPage = new LoginPage();
        BasicActions basicActions = new BasicActions();

        CreateAccountPage createAccountPage = new CreateAccountPage();

        @When("I click create a new account on login page")
            public void iClickCreateAccount(){
            loginPage.clickCreateAccount();
        }

        @And("I enter valid credentials to login")
           public void iEnterValidCredentials(){
            loginPage.logInWithValidCredentials();
        }


    @When("I login as Admin User")
    public void i_login_as_admin_user() {
        loginPage.loginAsAnAdminUser();

    }

        // =================VALIDATION STEPS==============//
    }
