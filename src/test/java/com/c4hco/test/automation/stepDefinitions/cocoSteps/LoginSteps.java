package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PrescreenPage;
import io.cucumber.java8.En;
import com.c4hco.test.automation.pages.cocoPages.LoginPage;

public class LoginSteps implements En {

    public LoginSteps(){
        // have all the pages instantiation on one page and call that page here.

        LoginPage loginPage = new LoginPage();
        PrescreenPage prescreenPage = new PrescreenPage();



        When("I open the sample page", () -> {
            System.out.println("TEst code - working from step definitions!!");
            loginPage.openPage();
        });

        And("I create a new account", () -> {
            loginPage.clickCreateAccount();
            // make the below into another step - click on create account link from pre-screen page
            prescreenPage.clickCreateAccountLink();
        });

        And("I click on help icon", ()->{
          // move steps to the right step definitions page. This belongs to login-portal page
            loginPage.clickHelpIcon();
        });

        Then("I validate the default verbiage on help icon", () -> {
            loginPage.validateHelpVerbiage();
        });



    }


}
