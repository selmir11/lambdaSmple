package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.IncomeSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class IncomeSummaryPageSteps {
    IncomeSummaryPage incomeSummaryPage = new IncomeSummaryPage(WebDriverManager.getDriver());

    @Then("I select the projected income option {string} and continue")
    public void iSelectProjectedIncomeOption(String projectedIncomeOption) {
        incomeSummaryPage.selectProjectedIncome(projectedIncomeOption);
    }

    @Then("I click the save and continue button on the Income Summary Detail page")
    public void iClickSaveandContinue() {
        incomeSummaryPage.clickSaveandContinue();
    }

    @And("I select {string} icon on the Income Summary Page")
    public void iSelectHelpIcon(String labelIcon) {incomeSummaryPage.clickHelpIcon(labelIcon);}

    @Then("I click on Contact Us link in Help Drawer on the Income Summary page")
    public void iClickHelpDrawerContactUs(){incomeSummaryPage.clickHelpContactUsNavigation();}

    @Then("I select the projected income option as {string}")
    public void iSelectOneOfTheProjectedIncomeOptions(String projectedIncomeOption) {
        incomeSummaryPage.selectOneOfTheProjectedIncomeOptions(projectedIncomeOption);
    }

    @Then("I enter the projected income amount as {string}")
    public void iEnterProjectedIncomeAmount(String projectedIncome) {
        incomeSummaryPage.enterProjectedIncomeAmount(projectedIncome);
    }


    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Income Summary page in {string}")
    public void iVerifyTextOnIncomeSummaryPage(String language) {
        incomeSummaryPage.verifyHeadersIncomeSummaryPage(language);
    }

    @Then("I validate Income Summary help drawer {string} verbiage in {string}")
    public void iValidateHelp(String helpText, String language) {incomeSummaryPage.validateHelpVerbiage(helpText, language);}

    @Then("I Verify the following text in Income Summary page and verify whether the Company name is present or not")
    public void iVerifyTextInIncomeSummaryPage(List<String> dataText) {incomeSummaryPage.verifyTextInIncomeSummaryPage(dataText);}

    @Then("I verify the following text along with the dollar sign after clicking yes button to the Income different than the amount Question")
    public void iVerifyTextAfterClickingYesToDifferentIncomeQuestion(List<String> dataText) {incomeSummaryPage.verifyTextAfterClickingYesToDifferentIncomeQuestion(dataText);}

    @And("I click on Go Back on income summary page")
    public void iClickOnGoBackOnIncomeSummaryPage() {
        incomeSummaryPage.clickGoBackOnIncomeSummary();
    }
    @And("I verify the error message on income summary page")
    public void iverifyErrorMessage() {
        incomeSummaryPage.verifyErrorMessage();
    }

    @And("I verify the active error message as {string}")
    public void iVerifyActiveErrorMessage(String expectedErrorMessage) {
        incomeSummaryPage.verifyActiveErrorMessage(expectedErrorMessage);
    }

    @And("I verify no error is displayed on the Income Summary page")
    public void iVerifyNoErrors(){incomeSummaryPage.verifyNoErrors();}

    @Then("I verify page Header text in income summary page")
    public void iVerifyPageHeaderTextInIncomeSummaryPage() {
        incomeSummaryPage.validatePageHeaderText();
    }

    @Then("I validate font colour height and format of text in income summary page")
    public void iValidateFontColourHeightAndFormatOfTextInIncomeSummaryPage() {
        incomeSummaryPage.validateTextFontColourEtc();
    }

    @Then("I verify added income name {string} and amount {string} in income summary page")
    public void iVerifyAddedIncomeNameAndAmountInIncomeSummaryPage(String incomeName,String amount) {
        incomeSummaryPage.validateAddedIncomeNameAndAmount(incomeName,amount);
    }

    @When("I click on {string} in income summary page")
    public void iClickOnInIncomeSummaryPage(String editButton) {
        incomeSummaryPage.clickOnEditIncomeOrDeductionButton(editButton);
    }

    @Then("I validate income amounts {string} and {string} in income summary page")
    public void iValidateIncomeAmountsAndInIncomeSummaryPage(String amount1, String amount2) {
        incomeSummaryPage.validateTwoIncomeAmounts(amount1,amount2);
    }
    @Then("I validate income amounts {string} {string} and {string} in income summary page")
    public void iValidateIncomeAmountsAndInIncomeSummaryPage(String amount1, String amount2, String amount3) {
        incomeSummaryPage.validateThreeIncomeAmounts(amount1,amount2,amount3);
    }

    @Then("I validate deduction amount {string} along with income amounts {string} {string} and {string}")
    public void iValidateDeductionAmountAlongWithIncomeAmountsAnd(String deductAmount, String incomeAmt1, String incomeAmt2, String incomeAmt3) {
        incomeSummaryPage.validateDeductionAmount(deductAmount,incomeAmt1,incomeAmt2,incomeAmt3);
    }

    @Then("I validate income and deduction calculations")
    public void iValidateIncomeAndDeductionCalculations() {
        incomeSummaryPage.validateIncomeDeductionCalculations();
    }

    @Then("I verify spouse name in income summary page")
    public void iVerifyAdditionalMemberNameInIncomeSummaryPage() {
        incomeSummaryPage.validateSpouseName();
    }

    @Then("I verify projected income question has not been answered")
    public void iVerifyProjectedIncomeQuestionHasNotBeenAnswered() {
        incomeSummaryPage.verifyProjectIncomeQstnNotAnswered();
    }

    @Then("I verify font colour text of Total annual income")
    public void iVerifyFontColourTextOfTotalAnnualIncome() {
        incomeSummaryPage.verifyFontColorText();
    }

    @Then("I verify total annual income amount {string} in income summary page")
    public void iVerifyTotalAnnualIncomeAmountInIncomeSummaryPage(String amount) {
        incomeSummaryPage.verifyTotalAnnualIncome(amount);
    }

    @Then("I validate entered project income amount is {string}")
    public void iValidateEnteredProjectIncomeIs(String amount) {
        incomeSummaryPage.verifyEnteredProjectedIncome(amount);
    }
}