package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationResultsPage_LR;
import io.cucumber.java.en.Then;

public class ApplicationResultsPageSteps_LR {
    ApplicationResultsPage_LR results = new ApplicationResultsPage_LR();

    @Then("I click continue on application results page")
    public void applicationResult(){
        results.clickBtnContinue();
    }
}
