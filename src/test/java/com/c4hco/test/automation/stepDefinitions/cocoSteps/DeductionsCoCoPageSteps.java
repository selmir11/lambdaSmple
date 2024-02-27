package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DeductionsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class DeductionsCoCoPageSteps {
    DeductionsCoCoPage deductionsCoCoPage = new DeductionsCoCoPage(WebDriverManager.getDriver());

    @And("I select None of these as deductions option")
    public void noneDeductions(){deductionsCoCoPage.selectNoneDeductionsOption();}

    @And("I select continue on the Deductions CoCo page")
    public void selectContinueDeductions(){deductionsCoCoPage.clickSaveAndContinueButton();}
}
