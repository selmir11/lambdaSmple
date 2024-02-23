package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdditionalIncomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class AdditionalIncomePageSteps {
    AdditionalIncomePage additionalIncomePage = new AdditionalIncomePage(WebDriverManager.getDriver());

    @Then("I click {string} as additional income option and continue")
    public void noAdditionalIncome(String addtlIncomeOption) {
        additionalIncomePage.selectAddtlIncomeOption(addtlIncomeOption);
    }
}
