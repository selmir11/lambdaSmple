package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdditionalIncomePage;
import io.cucumber.java.en.Then;

public class AdditionalIncomePageSteps {
    AdditionalIncomePage additionalIncomePage = new AdditionalIncomePage();

    @Then("I have no additional income")
    public void noAdditionalIncome(){additionalIncomePage.noAdditionalIncome();}
}
