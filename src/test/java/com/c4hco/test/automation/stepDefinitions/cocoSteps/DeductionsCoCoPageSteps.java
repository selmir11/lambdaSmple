package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DeductionsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class DeductionsCoCoPageSteps {
    DeductionsCoCoPage deductionsCoCoPage = new DeductionsCoCoPage(WebDriverManager.getDriver());

    @And("I select None of these as deductions option")
    public void noneDeductions(){deductionsCoCoPage.selectNoneDeductionsOption();}

    @And("I select {string} as deduction option with {string} amount at {string} frequency")
    public void selectDeduction(String deductionOption, String Amount, String Frequency) {
        deductionsCoCoPage.selectDeductionOption(deductionOption, Amount, Frequency);
    }

    @And("I select continue on the Deductions CoCo page")
    public void selectContinueDeductions(){deductionsCoCoPage.clickSaveAndContinueButton();}

    @And("I select Back on the Deductions CoCo page")
    public void selectBackDeductions(){deductionsCoCoPage.clickBackButton();}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo Deductions page in {string}")
    public void iVerifyTextOnDeductionsPage(String language){deductionsCoCoPage.verifyHeadersDeductionsPage(language);}

}
