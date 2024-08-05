package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EmploymentSummaryPageSteps {
    EmploymentSummaryPage employmentSummaryPage = new EmploymentSummaryPage(WebDriverManager.getDriver());

    @Then("I click continue on the Employment Summary Page")
        public void iClickContinueEmpSummary(){employmentSummaryPage.clickContinue();}

    @Then("I click Edit on Income Summary row {int}")
        public void iClickEditIncomeLink(int Index){
        employmentSummaryPage.clickEditIncome(Index);}








    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Employment Summary page in {string}")
    public void iVerifyTextOnEmploymentSummaryPage(String language){employmentSummaryPage.verifyHeadersEmploymentSummaryPage(language);}
}
