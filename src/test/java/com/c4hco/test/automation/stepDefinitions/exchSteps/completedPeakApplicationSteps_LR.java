package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CompletedPeakApplication_LR;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class completedPeakApplicationSteps_LR {
    CompletedPeakApplication_LR completedApplication = new CompletedPeakApplication_LR();
    @Then("I select No Thanks")
    public void selectNoThanks(){
        completedApplication.setNoThanks();
    }
    @And("I click on save and continue")
    public void selectSaveAndContinue(){
        completedApplication.saveAndContinue();
    }
}
