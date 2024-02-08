package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;
import org.openqa.selenium.support.ui.Wait;

    public class WelcomePageSteps {
        WelcomePage welcomePage = new WelcomePage();

        @Then("I validate I am on the welcome page")
            public void iValidateWelcomePage() { welcomePage.validateWelcomePage(); }

        @And("I apply for 2024 CoCo")
            public void iClickApply2024CoCo() { welcomePage.clickApply2024CoCo(); }

        @Then("I click on My Profile Button CoCo")
            public void iClickMyProfileButton() { welcomePage.clickMyProfileButton(); }


    }




