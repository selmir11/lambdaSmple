package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import io.cucumber.java.en.*;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.waitFor;

public class LoginPageSteps {

        LoginPage loginPage = new LoginPage();

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
        waitFor(2);

        loginPage.OpenAdminPortal();
        loginPage.refreshPage();
    }

    @When("I login as Admin User")
    public void i_login_as_admin_user() {
        waitFor(2);
        loginPage.usernameAdmin.sendKeys("C4test.aduser123@gmail.com");
        loginPage.passwordAdmin.sendKeys("ALaska12!");
        loginPage.signAdmin.click();
    }

        // =================VALIDATION STEPS==============//
    }
