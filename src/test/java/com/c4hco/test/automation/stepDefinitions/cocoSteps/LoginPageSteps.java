package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PrescreenPage;
import io.cucumber.java8.En;
import com.c4hco.test.automation.pages.cocoPages.LoginPage;

public class LoginPageSteps implements En {

    public LoginPageSteps(){
        LoginPage loginPage = new LoginPage();

        And("I click create a new account on login page", () -> {
            loginPage.clickCreateAccount();
        });

        Then("I validate I am on the login page", () -> {
            loginPage.validateLoginPage();
        });

        And("I enter a pair of valid credentials", () -> {
            loginPage.signInWithValidCredentials();
        });

    }


}
