package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdditionalIncomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class AdditionalIncomePageSteps {
    AdditionalIncomePage additionalIncomePage = new AdditionalIncomePage(WebDriverManager.getDriver());

    @Then("I click {string} as additional income option with {string} amount at {string} frequency")
    public void noAdditionalIncome(String addtlIncomeOption, String Amount, String Frequency) {
        additionalIncomePage.selectAddtlIncomeOption(addtlIncomeOption, Amount, Frequency);
    }

    @Then("I click None of these as additional income option and continue")
    public void noAdditionalIncome() {
        additionalIncomePage.selectNoneAddtlIncomeOption();
    }

    @And("I click None of these as additional income option")
    public void clickNoneOfThese(){additionalIncomePage.clickNoneAddtlIncomeOption();}

    @Then("I click continue on the Additional Income page")
    public void clickContinue(){additionalIncomePage.clickContinue();}

    @And("I select {string} icon on the Additional Income Page")
    public void iSelectHelpIcon(String labelIcon){additionalIncomePage.clickHelpIcon(labelIcon);}


    @Then("I click on {string} link in Help Drawer on the Additional Income page")
    public void iClickHelpDrawerContactUs(String lnkName){additionalIncomePage.clickHelpContactUsNavigation(lnkName);}

    @When("I click on Alimony Received check box")
    public void iClickOnAlimonyReceivedCheckBox() {
        additionalIncomePage.clickOnAlimonyReceivedCheckBox();
    }



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Additional Income page in {string}")
    public void iVerifyTextOnAdditionalIncomePage(String language){additionalIncomePage.verifyHeadersAdditionalIncomePage(language);}

    @Then("I verify {string} text on the Additional Income page with errors")
    public void verifyFirstTimeText(String Language)  { additionalIncomePage.verifyTextOnAdditionalIncomeWithErrors(Language); }

    @Then("I click {string} as additional income option")
    public void iSelectAddtlIncomeOptionOnly(String addtlIncomeOption)  { additionalIncomePage.selectAddtlIncomeOptionOnly(addtlIncomeOption); }

    @Then("I verify error for additional income option with no amount in {string}")
    public void iVerifyAddtlIncomeOptionAmt1Error(String language)  { additionalIncomePage.verifyAddtlIncomeOptionAmt1Error(language); }

    @Then("I verify error for additional income option with no frequency in {string}")
    public void iVerifyAddtlIncomeOptionFreq1Error(String language)  { additionalIncomePage.verifyAddtlIncomeOptionFreq1Error(language); }

    @Then("I verify no errors show for additional income options")
    public void iVerifyAddtlIncomeOptionNoError()  { additionalIncomePage.verifyAddtlIncomeOptionNoError(); }

    @Then("I verify {string} as additional income option with {string} amount at {string} frequency")
    public void iVerifyAddtlIncomeEnteredData(String addtlIncomeOption, String Amount, String Frequency) {additionalIncomePage.verifyAddtlIncomeEnteredData(addtlIncomeOption, Amount, Frequency);}

    @Then("I verify no error shows for additional income page")
    public void iVerifyAddtlIncomePageNoError()  { additionalIncomePage.verifyAddtlIncomePageNoError(); }

    @Then("I verify {string} error shows for additional income page")
    public void iVerifyAddtlIncomePageError(String language)  { additionalIncomePage.verifyAddtlIncomePageError(language); }

    @Then("I validate Additional Income help drawer {string} verbiage in {string}")
    public void iValidateHelp(String helpText, String language){additionalIncomePage.validateHelpVerbiage(helpText, language);}

    @Then("I verify Additional Income checkbox in {string} state")
    public void iVerifyStateOfAddIncomeCheckbox(String state){
        additionalIncomePage.verifyAddtlIncomeOptionCheckbox(state);}

    @Then("I click on the Back button on the Additionalincomepage")
    public void iClickOnTheBackButton() {
        additionalIncomePage.clickOnBackButton();
    }

    @Then("I validate the error text with its properties and the error icon on the Additional Income page")
    public void iVerifyErrorMessageAndItsProperties(DataTable dataTable){additionalIncomePage.validateErrorMessageAndItsProperties(dataTable);}

    @And("I verify the Active Error message as {string}")
    public void iVerifyActiveErrorMessage(String expectedErrorMessage) {
        additionalIncomePage.verifyActiveErrorMessage(expectedErrorMessage);
    }

    @And("I enter the value {string} and verify that the value is converted to {string}")
    public void iEnterAndVerifyTheAmount(String enteredValue,String expectedValue) {
        additionalIncomePage.enterAndVerifyTheAmount(enteredValue,expectedValue);
    }


    @Then("I verify color font border of the header and other page texts other than check boxes for AI page")
    public void iVerifyColorFontBorderOfTheHeaderAndOtherPageTextsOtherThanCheckBoxesForAIPage(List<String> pageTexts) {
        additionalIncomePage.verifyHeaderAndOtherTextsColorEtc(pageTexts);
    }

    @Then("I verify all add income options color size format text and view order")
    public void iVerifyAllAddIncomeOptionsColorSizeFormatTextAndViewOrder(List<String> addIncomeOpts) {
        additionalIncomePage.verifyViewOrderTextColorFormatOfAddIncomeOptions(addIncomeOpts);
    }

    @Then("I verify page text of Go_Back as {string} and Save_And_Continue as {string} in AI page")
    public void iVerifyPageTextOfGo_BackAsAndSave_And_ContinueAsInAIPage(String btnBack, String btnSave) {
        additionalIncomePage.verifyTextsOfBackAndSaveBtn(btnBack,btnSave);
    }

    @Then("I verify default property of amount box and dropdown in AI page for {string}")
    public void iVerifyDefaultPropertyOfAmountBoxAndDropdownInAIPageFor(String languageOpt,List<String> dropdownOptions) {
        additionalIncomePage.verifyDefaultPropertyOfTextBoxAndDropdown(languageOpt,dropdownOptions);
    }

    @Then("I verify amount {string} and frequency {string} is selected in AI page")
    public void iVerifyAmountAndFrequencyIsSelectedInAIPage(String amount, String freq) {
        additionalIncomePage.verifyEnteredAmountAndFreq(amount,freq);
    }

    @Then("I verify when None_of_these selected Other checkboxes not selected in AI page")
    public void iVerifyWhenNone_of_theseSelectedOtherCheckboxesNotSelectedInAIPage() {
        additionalIncomePage.verifyNone_Of_TheseOnlySelected();
    }

    @Then("I verify font color size of back and save button in AI page when mouse_Hover is {string}")
    public void iVerifyFontColorSizeOfBackAndSaveButtonInAIPageWhenMouse_HoverIs(String mouseOverOpt) {
        additionalIncomePage.verifyFontColorBorderOfBackAndSaveBtn(mouseOverOpt);
    }
}
