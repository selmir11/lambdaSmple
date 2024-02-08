package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.IncomeOptOutPage;
import io.cucumber.java.en.*;

public class IncomeOptOutPageSteps {
    IncomeOptOutPage incomeOptOutPage = new IncomeOptOutPage();

    @And("I Apply for no financial help")
    public void clickNoThanks(){
        incomeOptOutPage.chooseNoFinancialHelp();
    }

    @And("I Apply for financial help")
    public void clickApply(){
        incomeOptOutPage.chooseApply();
    }
}
