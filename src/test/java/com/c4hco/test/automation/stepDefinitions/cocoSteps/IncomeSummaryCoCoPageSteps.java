package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.IncomeSummaryCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class IncomeSummaryCoCoPageSteps {
    IncomeSummaryCoCoPage incomeSummaryCoCoPage = new IncomeSummaryCoCoPage(WebDriverManager.getDriver());

    @Then("I verify the total annual income to be {string}")
    public void verifyTotalAnnualIncome(String Amount){
        incomeSummaryCoCoPage.verifyTotalAnnualIncome(Amount);
    }

    @Then("I select the projected income option {string} on Income Summary CoCo page")
    public void selectProjectedOptionCoCo(String projectedOption){incomeSummaryCoCoPage.selectProjectedIncome(projectedOption);}

    @And("I enter {string} of projected income on Income Summary CoCo page")
    public void enterProjectedIncome(String projectedAmount){incomeSummaryCoCoPage.enterProjectedIncomeAmountCoCo(projectedAmount);}

    @And("I select continue on the income Summary CoCo page")
    public void selectContinueIncomeSummary(){incomeSummaryCoCoPage.clickSaveAndContinueButton();}
}
