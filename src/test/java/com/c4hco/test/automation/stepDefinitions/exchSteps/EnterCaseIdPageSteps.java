package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EnterCaseIdPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnterCaseIdPageSteps {
    EnterCaseIdPage enterCaseIdPage = new EnterCaseIdPage();

    @And("I should see the following text on the Enter Case ID page {string}")
    public void iShouldSeeTheText(String expectedText) {
        enterCaseIdPage.verifyTheText(expectedText);
    }
}
