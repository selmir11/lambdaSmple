package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.IncomeSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Income Summary page in {string}")
    public void iVerifyTextOnIncomeSummaryPage(String language) {
        incomeSummaryPage.verifyHeadersIncomeSummaryPage(language);
    }

    @Then("I validate Income Summary help drawer {string} verbiage in {string}")
    public void iValidateHelp(String helpText, String language) {incomeSummaryPage.validateHelpVerbiage(helpText, language);}


}