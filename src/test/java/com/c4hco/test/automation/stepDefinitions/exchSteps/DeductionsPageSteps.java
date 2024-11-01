package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DeductionsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
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

    @And("I select {string} icon on the Deductions Page")
    public void iSelectHelpIcon(String labelIcon){deductionsPage.clickHelpIcon(labelIcon);}

    @Then("I click on {string} link in Help Drawer on the Deductions page")
    public void iClickHelpDrawerContactUs(String lnkName){deductionsPage.clickHelpContactUsNavigation(lnkName);}



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line

    @And("I verify the header for Primary Member on the Deductions page in {string}")
    public void iVerifyTextOnDeductionsInsurancePage(String language){deductionsPage.verifyHeadersDeductionsPage(language);}

    @Then("I click {string} as deduction option only")
    public void iSelectAddtlDeductionOptionOnly(String addtlDeductionOption){
        deductionsPage.selectAddtlDeductionOptionOnly(addtlDeductionOption);}

    @Then("I verify error for Deductions option with no amount in {string}")
    public void iVerifyDeductionsOptionAmt1Error(String language)  { deductionsPage.verifyDeductionsOptionAmt1Error(language); }

    @Then("I verify error for Deductions option with no frequency in {string}")
    public void iVerifyDeductionsOptionFreq1Error(String language)  { deductionsPage.verifyDeductionsOptionFreq1Error(language); }

    @Then("I verify no errors show for Deductions options")
    public void iVerifyDeductionsOptionNoError()  { deductionsPage.verifyDeductionsOptionNoError(); }

    @Then("I verify {string} Deduction details of {string} amount at {string} frequency")
    public void iVerifyDeductionOption(String addtlDeductionOption, String Amount, String Frequency){
        deductionsPage.verifyDeductionOption(addtlDeductionOption, Amount, Frequency);}

    @Then("I verify no error shows for Deductions page")
    public void iVerifyDeductionsPageNoError()  { deductionsPage.verifyDeductionsPageNoError(); }

    @Then("I verify {string} error shows for Deductions page")
    public void iVerifyDeductionsPageError(String language)  { deductionsPage.verifyDeductionsPageError(language); }

    @Then("I validate Deductions help drawer {string} verbiage in {string}")
    public void iValidateHelp(String helpText, String language){deductionsPage.validateHelpVerbiage(helpText, language);}

    @Then("I verify Deductions checkbox in {string} state")
    public void iVerifyStateOfDeductionsCheckbox(String state){
        deductionsPage.verifyDeductionsOptionCheckbox(state);}




}
