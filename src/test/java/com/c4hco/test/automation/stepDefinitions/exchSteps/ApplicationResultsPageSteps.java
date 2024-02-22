package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ApplicationResultsPageSteps {
    ApplicationResultsPage applicationResultsPage = new ApplicationResultsPage();

    @Then("I click continue on application results page")
    public void iClickContinueOnApplicationResult(){
        applicationResultsPage.clickBtnContinue();
    }


    @Then("I validate that my APTC value is {string}")
    public void validateAPTC(String expectedAPTC){applicationResultsPage.validateAPTC(expectedAPTC);}

    @Then("I verify text that the member don't qualify for a health plan on the app results page")
    public void verifyTextDoNotQualifyForHealthPlan () {
        applicationResultsPage.verifyTextNotQualifyForPlanOnAppResultsPage();
    }

    @Then("I verify text that the member eligible for MA on the app results page")
    public void verifyTextMAEligibility() {
        applicationResultsPage.verifyTextMAEligibility();
    }
}
