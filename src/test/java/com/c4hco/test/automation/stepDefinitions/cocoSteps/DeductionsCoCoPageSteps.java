package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DeductionsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeductionsCoCoPageSteps {
    DeductionsCoCoPage deductionsCoCoPage = new DeductionsCoCoPage(WebDriverManager.getDriver());

    @And("I select {string} as deductions option")
    public void iSelectDeductionOptionOnly(String deductionOption){deductionsCoCoPage.selectDeductionOptionOnly(deductionOption);}

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

    @And("I verify the header for additional member on the CoCo Deductions page in {string}")
    public void iVerifyAdditionalMemberTextOnDeductionsPage(String language) {deductionsCoCoPage.verifyAddtlMemHeadersDeductionsPage(language);}

    @Then("I verify error for Deductions no option in {string} CoCo page")
    public void iVerifyDeductionsOptionHdrError(String language){deductionsCoCoPage.verifyDeductionsOptionHdrError(language);}

    @Then("I verify error for Deductions option with no amount in {string} CoCo page")
    public void iVerifyDeductionsOptionAmtError(String language){deductionsCoCoPage.verifyDeductionsOptionAmtError(language);}

    @Then("I verify error for Deductions option with no frequency in {string} CoCo page")
    public void iVerifyDeductionsOptionFreqError(String language){deductionsCoCoPage.verifyDeductionsOptionFreqError(language);}

    @Then("I verify no errors show for Deductions options CoCo page")
    public void iVerifyDeductionsOptionNoError(){deductionsCoCoPage.verifyDeductionsOptionNoError();}

    @Then("I verify {string} as Deductions option with {string} amount at {string} frequency CoCo page")
    public void iVerifyDeductionsEnteredData(String deductionsOption, String Amount, String Frequency) {deductionsCoCoPage.verifyDeductionsEnteredData(deductionsOption, Amount, Frequency);}

    @Then("I verify the text on the deductions coco page in {string}")
    public void iVerifyDeductionsText(String language) {deductionsCoCoPage.verifyDeductionsText(language);}

    @Then("I verify the navigation buttons on the deductions coco page in {string}")
    public void iVerifyDeductionsNavigationButtons(String language) {deductionsCoCoPage.verifyDeductionsNavigationButtons(language);}

    @Then("I verify Deductions checkbox COCO in {string} state")
    public void iVerifyStateOfDeductionsCheckbox(String state){
        deductionsCoCoPage.verifyDeductionsOptionCheckboxCOCO(state);}

    @Then("I verify the error banner at the top of the deductions coco page")
    public void iVerifyErrorBanner(){deductionsCoCoPage.verifyErrorBanner();}

}
