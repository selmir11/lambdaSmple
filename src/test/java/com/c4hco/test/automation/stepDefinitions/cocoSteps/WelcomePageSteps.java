package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

    public class WelcomePageSteps {
        WelcomePage welcomePage = new WelcomePage();

        @Then("I validate I am on the welcome page")
            public void iValidateWelcomePage() { welcomePage.validateWelcomePage(); }

        @And("I apply for 2024 CoCo")
            public void iClickApply2024CoCo() { welcomePage.clickApply2024CoCo(); }

        @Then("I click on My Profile Button CoCo")
            public void iClickMyProfileButton() { welcomePage.clickMyProfileButton(); }

        @Then("I click on Application Results Button CoCo")
        public void iClickApplicationResultsButton() { welcomePage.clickApplicationResultsButton(); }

        @Then("I click on My Documents and Letters Button CoCo")
        public void iClickMyDocumentsButton() { welcomePage.clickMyDocumentsButton(); }


    }




