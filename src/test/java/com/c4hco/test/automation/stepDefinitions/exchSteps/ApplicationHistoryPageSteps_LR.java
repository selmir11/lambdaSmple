package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationHistoryPage_LR;
import io.cucumber.java.en.*;

public class ApplicationHistoryPageSteps_LR {
    ApplicationHistoryPage_LR history = new ApplicationHistoryPage_LR();

    @Then("I click on view results and shop")
    public void clickViewResultsNSHop(){
        history.clickViewResults();
    }
}
