package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationResultsPage;
import io.cucumber.java.en.Then;

public class ApplicationResultsPageSteps {
    ApplicationResultsPage applicationResultsPage = new ApplicationResultsPage();

    @Then("I click continue on application results page")
    public void iClickContinueOnApplicationResult(){
        applicationResultsPage.clickBtnContinue();
    }
}
