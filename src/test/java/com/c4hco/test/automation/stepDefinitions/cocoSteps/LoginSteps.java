package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import io.cucumber.java8.En;
import com.c4hco.test.automation.pages.cocoPages.LoginPage;

public class LoginSteps implements En {

    public LoginSteps(){

        LoginPage loginPage = new LoginPage();


        When("I open the sample page", () -> {
            System.out.println("TEst code - working from step definitions!!");
            loginPage.openPage();
        });

        And("I create a new account", () -> {
            loginPage.clickCreateAccount();
        });

    }


}
