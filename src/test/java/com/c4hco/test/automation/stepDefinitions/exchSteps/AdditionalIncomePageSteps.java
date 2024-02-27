package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdditionalIncomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class AdditionalIncomePageSteps {
    AdditionalIncomePage additionalIncomePage = new AdditionalIncomePage(WebDriverManager.getDriver());

    @Then("I click {string} as additional income option with {string} amount at {string} frequency")
    public void noAdditionalIncome(String addtlIncomeOption, String Amount, String Frequency) {
        additionalIncomePage.selectAddtlIncomeOption(addtlIncomeOption, Amount, Frequency);
    }

    @Then("I click None of these as additional income option and continue")
    public void noAdditionalIncome() {
        additionalIncomePage.selectNoneAddtlIncomeOption();
    }

    @Then("I click continue on the Additional Income page")
    public void clickContinue(){additionalIncomePage.clickContinue();}
}
