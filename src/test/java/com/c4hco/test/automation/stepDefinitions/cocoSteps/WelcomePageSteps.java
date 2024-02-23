package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

    public class WelcomePageSteps {
        WelcomePage welcomePage = new WelcomePage();

        @And("I apply for the current year in CoCo")
        public void iApplyForCurrentYear(){welcomePage.clickApplyForInsurance();}

        @Then("I click on My Profile Button CoCo")
            public void iClickMyProfileButton() { welcomePage.clickMyProfileButton(); }

        @Then("I click on Application Results Button CoCo")
        public void iClickApplicationResultsButton() { welcomePage.clickApplicationResultsButton(); }

        @Then("I click on My Documents and Letters Button CoCo")
        public void iClickMyDocumentsButton() { welcomePage.clickMyDocumentsButton(); }

        @And("I click on {string} link on welcome page")
        public void iClickActionLink(String actionLink) { welcomePage.clickActionLinks(actionLink); }

// ############################## VALIDATION STEPS #########################
        // Add only validation methods below this line
    @Then("I verify text on the Welcome page for first time signed into an account")
    public void verifyFirstTimeText()  { welcomePage.verifyTextOnWelcomePageFirstTime(); }

    @Then("I verify text on the Welcome page for an account without a policy")
    public void verifyNoPolicyText()  { welcomePage.verifyTextOnWelcomePageNoPolicy(); }

    @Then("I validate {string} link text on welcome page")
    public void verifyActionLinkText(String actionLink)  { welcomePage.validateActionLinksText(actionLink); }





}




