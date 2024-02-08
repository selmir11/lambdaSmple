package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentSummaryPage;
import io.cucumber.java.en.Then;

public class EmploymentSummaryPageSteps {
    EmploymentSummaryPage employmentSummaryPage = new EmploymentSummaryPage();

    @Then("I click continue on the Employment Summary Page")
        public void iClickContinueEmpSummary(){employmentSummaryPage.clickContinue();}
}
