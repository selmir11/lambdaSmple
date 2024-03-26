package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.WelcomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

    public class WelcomePageSteps {
        WelcomePage welcomePage = new WelcomePage(WebDriverManager.getDriver());

        @And("I apply for the current year in CoCo")
        public void iApplyForCurrentYear(){welcomePage.clickApplyForInsurance();}

        @And("I click on {string} link on welcome page")
        public void iClickActionLink(String actionLink) { welcomePage.clickActionLinks(actionLink); }

// ############################## VALIDATION STEPS #########################
        // Add only validation methods below this line
    @Then("I verify text on the Welcome page for first time signed into an account in {string}")
    public void verifyFirstTimeText(String language)  { welcomePage.verifyTextOnWelcomePageFirstTime(language); }

        @Then("I verify text on the Welcome page with policy {string} {string} for ${string} in {string}")
        public void iVerifyTextOnWelcomePagePolicy(String policyName, String policyLevel, String policyPremium, String language)  { welcomePage.verifyTextOnWelcomePagePolicy(policyName, policyLevel, policyPremium, language); }

    @Then("I verify text on the Welcome page for an account without a policy in {string}")
    public void verifyNoPolicyText(String language)  { welcomePage.verifyTextOnWelcomePageNoPolicy(language); }

    @Then("I validate action link text on welcome page in {string}")
    public void verifyActionLinkText(String language)  { welcomePage.validateActionLinksText(language); }





}




