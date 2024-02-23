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

    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @Then("I verify {string} text on the Additional Income page with errors")
    public void verifyFirstTimeText(String Language)  { additionalIncomePage.verifyTextOnAdditionalIncomeWithErrors(Language); }




}
