package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import io.cucumber.java.en.*;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;

import java.time.Duration;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.waitFor;

public class LoginPageSteps {

        LoginPage loginPage = new LoginPage();
        CreateAccountPage createAccountPage = new CreateAccountPage();

        @When("I click create a new account on login page")
            public void iClickCreateAccount(){
            loginPage.clickCreateAccount();
        }

        @And("I enter valid credentials to login")
           public void iEnterValidCredentials(){
            loginPage.logInWithValidCredentials();
        }

    @Given("I open the login page on the admin portal")
    public void i_open_the_login_page_on_the_admin_portal() {
        createAccountPage.implicitWait(2000);
        loginPage.OpenAdminPortal();
        loginPage.refreshPage();
    }

    @When("I login as Admin User")
    public void i_login_as_admin_user() {
        createAccountPage.waitForVisibility(loginPage.usernameAdmin,Duration.ofSeconds(2000));
        loginPage.usernameAdmin.sendKeys("C4test.aduser123@gmail.com");
        loginPage.passwordAdmin.sendKeys("ALaska12!");
        loginPage.signAdmin.click();
    }

        // =================VALIDATION STEPS==============//
    }
