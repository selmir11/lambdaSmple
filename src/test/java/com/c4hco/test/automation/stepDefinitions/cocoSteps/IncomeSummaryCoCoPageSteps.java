package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.IncomeSummaryCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class IncomeSummaryCoCoPageSteps {
    IncomeSummaryCoCoPage incomeSummaryCoCoPage = new IncomeSummaryCoCoPage(WebDriverManager.getDriver());

    @Then("I select the projected income option {string} on Income Summary CoCo page")
    public void selectProjectedOptionCoCo(String projectedOption){incomeSummaryCoCoPage.selectProjectedIncome(projectedOption);}

    @And("I enter {string} of projected income on Income Summary CoCo page")
    public void enterProjectedIncome(String projectedAmount){incomeSummaryCoCoPage.enterProjectedIncomeAmountCoCo(projectedAmount);}

    @And("I select continue on the income Summary CoCo page")
    public void selectContinueIncomeSummary(){incomeSummaryCoCoPage.clickSaveAndContinueButton();}

    @And("I select the No projected Income button on the Income Summary page")
    public void selectProjectedIncomeNo() {incomeSummaryCoCoPage.clickprojectedIncomeNo();}

    @And("I click on the edit {string} icon on the Income Summary CoCo page")
    public void iSelectEditIcon(String type) {incomeSummaryCoCoPage.selectEditIcon(type);}





    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo Income Summary page in {string}")
    public void iVerifyTextOnIncomeSummaryPage(String language){incomeSummaryCoCoPage.verifyHeadersIncomeSummaryPage(language);}

    @Then("I verify the total annual income to be {string}")
    public void verifyTotalAnnualIncome(String Amount){
        incomeSummaryCoCoPage.verifyTotalAnnualIncome(Amount);
    }

    @Then("I verify the edit icon")
    public void iVerifyEditIcon(){incomeSummaryCoCoPage.verifyEditIcon();}

}
