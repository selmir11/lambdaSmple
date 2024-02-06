package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import io.cucumber.java.en.*;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;
import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.emailId;
import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.pswrd;

public class LoginPageSteps {

        LoginPage loginPage = new LoginPage();

        @When("I click create a new account on login page")
                public void iClickCreateAccount(){
            loginPage.clickCreateAccount();
        }

        @And("I enter valid credentials to login")
                public void iEnterValidCredentials(){
            loginPage.logInWithValidCredentials(emailId,pswrd);
        }

        // =================VALIDATION STEPS==============//
    }
