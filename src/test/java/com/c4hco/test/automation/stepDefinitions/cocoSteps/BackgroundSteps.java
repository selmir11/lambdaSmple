package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.LoginPage;
import io.cucumber.java8.En;

public class BackgroundSteps implements En {

    public BackgroundSteps(){
        LoginPage loginPage = new LoginPage();

        When("I open the login page on the login portal", () -> {
            loginPage.openPage();
        });
    }
}
