package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.AdditionalIncomeCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdditionalIncomeCoCoPageSteps {
    AdditionalIncomeCoCoPage additionalIncomeCoCoPage = new AdditionalIncomeCoCoPage(WebDriverManager.getDriver());

    @And("I select {string} as additional income option with {string} amount at {string} frequency")
    public void enterAdditionalIncome(String addtlIncomeOption, String Amount, String Frequency) {
        additionalIncomeCoCoPage.selectAddIncomeOption(addtlIncomeOption, Amount, Frequency);
    }

    @And("I select None of these as additional income option and continue")
    public void noneAdditionalIncome() {
        additionalIncomeCoCoPage.selectNoneAddIncomeOption();
    }

    @And("I select continue on the Additional Income CoCO page")
    public void selectContinue(){additionalIncomeCoCoPage.clickSaveAndContinueButton();}

}
