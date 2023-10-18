package org.c4hco.stepDefinitions.cocoSteps;

import io.cucumber.java8.En;
import org.c4hco.pages.cocoPages.LoginPage;

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
