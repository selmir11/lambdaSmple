package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.CreateAccountPage;
import io.cucumber.java8.En;

public class CreateAccountPageSteps implements En {

    public CreateAccountPageSteps(){
        CreateAccountPage createAccountPage = new CreateAccountPage();

        When("I validate I am on the createAccount page", () -> {
            createAccountPage.validateCreateAccountPage();
        });

        And("I click on help icon", ()->{
            // move steps to the right step definitions page. This belongs to login-portal page
            createAccountPage.clickHelpIcon();
        });

        Then("I validate the default verbiage on help icon", () -> {
            createAccountPage.validateHelpVerbiage();
        });

        And("I enter a mandatory data for account creation", ()->{
            createAccountPage.createGeneralAccount();
        });

    }
}
