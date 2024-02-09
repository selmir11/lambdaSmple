package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import io.cucumber.java.en.*;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;

public class LoginPageSteps {

        LoginPage loginPage = new LoginPage();

        @When("I click create a new account on login page")
                public void iClickCreateAccount(){
            loginPage.clickCreateAccount();
        }

        @And("I enter valid credentials to login")
                public void iEnterValidCredentials(){ loginPage.logInWithValidCredentials(); }

        // =================VALIDATION STEPS==============//
    }
