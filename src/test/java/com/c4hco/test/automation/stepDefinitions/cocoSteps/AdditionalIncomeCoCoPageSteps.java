package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.AdditionalIncomeCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdditionalIncomeCoCoPageSteps {
    AdditionalIncomeCoCoPage additionalIncomeCoCoPage = new AdditionalIncomeCoCoPage(WebDriverManager.getDriver());

    @And("I select {string} as additional income option with {string} amount at {string} frequency")
    public void enterAdditionalIncome(String addtlIncomeOption, String Amount, String Frequency) {
        additionalIncomeCoCoPage.selectAddIncomeOption(addtlIncomeOption, Amount, Frequency);
    }

    @Then("I select {string} as additional income option CoCO page")
    public void iSelectAddtlIncomeOptionOnly(String addtlIncomeOption){additionalIncomeCoCoPage.selectAddtlIncomeOptionOnly(addtlIncomeOption);}

    @And("I select None of these as additional income option")
    public void noneAdditionalIncome() {
        additionalIncomeCoCoPage.selectNoneAddIncomeOption();
    }

    @And("I select continue on the Additional Income CoCO page")
    public void selectContinue(){additionalIncomeCoCoPage.clickSaveAndContinueButton();}

    @And("I select Go Back on the Additional Income CoCo page")
    public void selectGoBack(){additionalIncomeCoCoPage.clickGoBackButton();}

    @And("I open the Additional Income CoCo page in the new tab")
    public void openInNewTab(){additionalIncomeCoCoPage.openNewTab();}

    @And("I unselect {string} option on the Additional Income CoCo page")
    public void unselectOption(String option){additionalIncomeCoCoPage.unselectOptions(option);}





    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo Additional Income page in {string}")
    public void iVerifyTextOnAdditionalIncomePage(String language){additionalIncomeCoCoPage.verifyHeadersAdditionalIncomePage(language);}

    @Then("I verify the text on the CoCo Additional Income page in {string}")
    public void iVerifyAdditionalIncomeText(String language){additionalIncomeCoCoPage.verifyAdditionalIncomeTextCoCo(language);}

    @Then("I verify the navigation buttons on the CoCO Additional Income page in {string}")
    public void iVerifyAdditionalIncomeNavigationButtons(String language) {additionalIncomeCoCoPage.verifyAdditionalIncomeNavigationButtonsCoCo(language);}

    @Then("I validate no errors are displayed on the Additional Income CoCo page")
    public void iValidateNoErrorsPresent(){additionalIncomeCoCoPage.verifyNoErrorMessage_AdditionalIncome();}

    @Then("I validate the error banner is displayed on the Additional Income CoCo page")
    public void iValidateErrorsPresent(){additionalIncomeCoCoPage.verifyErrorMessage_AdditionalIncome();}

    @Then("I validate {string} option is selected on the Additional Income CoCo page")
    public void iValidateOptionSelection(String incomeOption){additionalIncomeCoCoPage.verifyOptionSelected_AdditionalIncome(incomeOption);}

    @Then("I verify error for additional income no option in {string} CoCo page")
    public void iVerifyAddtlIncomeOptionHdrError(String language){additionalIncomeCoCoPage.verifyAddtlIncomeOptionHdrError(language);}

    @Then("I verify error for additional income option with no amount in {string} CoCo page")
    public void iVerifyAddtlIncomeOptionAmt1Error(String language){additionalIncomeCoCoPage.verifyAddtlIncomeOptionAmt1Error(language);}

    @Then("I verify error for additional income option with no frequency in {string} CoCo page")
    public void iVerifyAddtlIncomeOptionFreq1Error(String language){additionalIncomeCoCoPage.verifyAddtlIncomeOptionFreq1Error(language);}

    @Then("I verify no errors show for additional income options CoCo page")
    public void iVerifyAddtlIncomeOptionNoError(){additionalIncomeCoCoPage.verifyAddtlIncomeOptionNoError();}

    @Then("I verify {string} as additional income option with {string} amount at {string} frequency CoCo page")
    public void iVerifyAddtlIncomeEnteredData(String addtlIncomeOption, String Amount, String Frequency) {additionalIncomeCoCoPage.verifyAddtlIncomeEnteredData(addtlIncomeOption, Amount, Frequency);}

    @Then("I verify Additional Income checkbox COCO in {string} state")
    public void iVerifyStateOfAddIncomeCheckboxCOCO(String state){
        additionalIncomeCoCoPage.verifyAddtlIncomeOptionCheckboxCOCO(state);}
}
