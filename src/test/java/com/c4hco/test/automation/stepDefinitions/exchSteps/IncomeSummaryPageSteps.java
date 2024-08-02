package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.IncomeSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class IncomeSummaryPageSteps {
    IncomeSummaryPage incomeSummaryPage = new IncomeSummaryPage(WebDriverManager.getDriver());

    @Then("I select the projected income option {string} and continue")
    public void iSelectProjectedIncomeOption(String projectedIncomeOption) {
        incomeSummaryPage.selectProjectedIncome(projectedIncomeOption);

    }
    @Then("I click the save and continue button on the Income Summary Detail page")
    public void iClickSaveandContinue(){
        incomeSummaryPage.clickSaveandContinue();
    }







    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Income Summary page in {string}")
    public void iVerifyTextOnIncomeSummaryPage(String language){incomeSummaryPage.verifyHeadersIncomeSummaryPage(language);}}
