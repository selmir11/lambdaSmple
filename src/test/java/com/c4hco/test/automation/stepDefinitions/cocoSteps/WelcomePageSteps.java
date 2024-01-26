package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.LoginPage;
import com.c4hco.test.automation.pages.cocoPages.WelcomePage;
import io.cucumber.java8.En;

public class WelcomePageSteps implements En {
    public WelcomePageSteps(){
        WelcomePage welcomePage = new WelcomePage();

        Then("I validate I am on the welcome page", () -> {
            welcomePage.validateWelcomePage();
        });

    }
}
