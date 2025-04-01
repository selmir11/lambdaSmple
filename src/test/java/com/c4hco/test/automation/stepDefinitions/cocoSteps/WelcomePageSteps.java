package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.WelcomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class WelcomePageSteps {
        WelcomePage welcomePage = new WelcomePage(WebDriverManager.getDriver());

    @And("I apply for the current year in CoCo")
    public void iApplyForCurrentYear(){welcomePage.clickApplyForInsurance();}

    @And("I click make Changes button on welcome page")
    public void iClickmakeChangeButton(){welcomePage.clickMakeChanges();}

    @And("I apply for the next year in CoCo during open enrollment")
    public void iApplyForNextYear(){welcomePage.applyForNextYear();}

    @And("I click Make changes button on Welcome Page")
    public void iClickMakeChangeButton(){welcomePage.iClickMakeChangeButton();
    }

    @And("I click on {string} link on welcome page")
    public void iClickActionLink(String actionLink) { welcomePage.clickActionLinks(actionLink); }

    @And("I select year {string} from My Current Plan container")
    public void iSelectPlanYear(String planYear) {welcomePage.selectPlanyear(planYear);}

    @And("I select take a short quiz on welcome page")
    public void iClickTakeQuiz() {welcomePage.clickTakeQuiz();}

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

    @Then("I validate CAC Screener banner text on welcome page in {string}")
    public void verifyCacBannerText(String language)  { welcomePage.validateCacBannerText(language); }

    @And("I Validate the correct enrolled plans are displayed on coco welcome page")
    public void validatePlanDetails() {welcomePage.validateMemAndPlanInfo();}

    @And("I set the test scenario details in coco")
    public void ivalidateScenarioDetails(List<Map<String, String>> expectedResult) {welcomePage.setScenarioDetailsCoco(expectedResult);}

    @Given("I set the dynamic policy, coverage and financial dates in coco")
    public void iSetDates(List<Map<String, String>> expectedResult){welcomePage.setDates(expectedResult);}

    @And("I validate notification banner on welcome page in {string}")
    public void verifyNotificationBanner(String language)  { welcomePage.validateNotificationBanner(language); }

    @And("I validate no notification banner on welcome page")
    public void verifyNoNotificationBanner()  { welcomePage.validateNoNotificationBanner(); }

    @Then("I validate the action link properties on welcome page")
    public void iValidateActionLinks() {welcomePage.validateActionLinks();}

    @Then("I validate the plan image for {string} on welcome page")
    public void iValidateActionLinks(String carrier) {welcomePage.validatePlanImage(carrier);}
}




