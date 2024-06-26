package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.IncomeOptOutPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class IncomeOptOutPageSteps {
    IncomeOptOutPage incomeOptOutPage = new IncomeOptOutPage(WebDriverManager.getDriver());

    @And("I Apply for no financial help")
    public void clickNoThanks(){
        incomeOptOutPage.chooseNoFinancialHelp();
    }

    @When("I continue without financial help")
    public void chooseNoFinancialHelp(){
        incomeOptOutPage.chooseNoFinancialHelp();
    }

    @And("I Apply for financial help")
    public void clickApply(){
        incomeOptOutPage.chooseApply();
    }

    @And("I verify the {string} text on the Income Opt Out page")
    public void verifyPageText(String Language){incomeOptOutPage.verifyPageText(Language);}

    @And("I click on financial help link within text")
    public void clickFinancialHelpWithinText(){incomeOptOutPage.financialHelpWithinText();}
}
