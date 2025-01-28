package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.UnauthorizedPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class UnauthorizedSteps {

    UnauthorizedPage unauthorizedPage = new UnauthorizedPage(WebDriverManager.getDriver());

    @Then("I verify unauthorized text in {string}")
    public void iVerifyUnauthorizedText(String language){unauthorizedPage.verifyUnauthorizedText(language); }

}
