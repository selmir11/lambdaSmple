package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class EmploymentSummaryPageSteps {
    EmploymentSummaryPage employmentSummaryPage = new EmploymentSummaryPage(WebDriverManager.getDriver());

    @Then("I click continue on the Employment Summary Page")
        public void iClickContinueEmpSummary(){employmentSummaryPage.clickContinue();}

    @Then("I click Edit on Income Summary row {int}")
        public void iClickEditIncomeLink(int Index){
        employmentSummaryPage.clickEditIncome(Index);}

}
