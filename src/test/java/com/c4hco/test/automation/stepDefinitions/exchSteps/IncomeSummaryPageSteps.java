package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.IncomeSummaryPage;
import io.cucumber.java.en.Then;

public class IncomeSummaryPageSteps {
    IncomeSummaryPage incomeSummaryPage = new IncomeSummaryPage();

    @Then("I select the projected income option {string} and continue")
    public void iSelectProjectedIncomeOption(String projectedIncomeOption){
        incomeSummaryPage.selectProjectedIncome(projectedIncomeOption);
    }
}
