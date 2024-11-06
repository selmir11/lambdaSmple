package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdditionalIncomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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
}
