package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import com.c4hco.test.automation.utils.Utils;
import io.cucumber.java.en.*;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;

import java.time.Duration;



public class LoginPageSteps {

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
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
        utils.refreshPage();
        utils.waitForVisibility(loginPage.usernameAdmin,Duration.ofSeconds(2000));
        // TO DO: Get the credentials coming from a different file
        loginPage.usernameAdmin.sendKeys("C4test.aduser123@gmail.com");
        loginPage.passwordAdmin.sendKeys("ALaska12!");
        loginPage.signAdmin.click();
    }

        // =================VALIDATION STEPS==============//
    }
