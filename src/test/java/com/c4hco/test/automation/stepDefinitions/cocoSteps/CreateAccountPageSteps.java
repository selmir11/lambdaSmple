package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.CreateAccountPage;
import io.cucumber.java8.En;

public class CreateAccountPageSteps implements En {

    public CreateAccountPageSteps(){
        CreateAccountPage createAccountPage = new CreateAccountPage();

        And("I click on help icon", ()->{
            createAccountPage.clickHelpIcon();
        });

        Then("I validate the default verbiage on help icon", () -> {
            createAccountPage.validateHelpVerbiage();
        });

        And("I enter general mandatory data for \"([^\"]*)\" account creation", (String appType)->{
            createAccountPage.createGeneralAccount(appType);
        });

        // =================== VALIDATION STEPS ===============//
        When("I validate I am on the createAccount page", () -> {
            createAccountPage.validateCreateAccountPage();
        });

    }
}
