package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DeductionsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class DeductionsPageSteps {
    DeductionsPage deductionsPage = new DeductionsPage(WebDriverManager.getDriver());

    @Then("I click {string} as deduction option with {string} amount at {string} frequency")
    public void setDeductions(String addtlDeductionOption, String Amount, String Frequency){
        deductionsPage.selectAddtlDeductionOption(addtlDeductionOption, Amount, Frequency);}

    @Then("I click None of these as deduction option and continue")
    public void noDeductions(){deductionsPage.selectNoneAddtlDeductionOption();}

    @Then("I click continue on the Deductions page")
    public void clickContinue(){deductionsPage.clickContinue();}
}
