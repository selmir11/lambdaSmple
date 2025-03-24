package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.IncomeSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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


}