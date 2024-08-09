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

    @Then("I validate no errors are displayed on the Additional Income CoCo page")
    public void iValidateNoErrorsPresent(){additionalIncomeCoCoPage.verifyNoErrorMessage_AdditionalIncome();}

    @Then("I validate the error banner is displayed on the Additional Income CoCo page")
    public void iValidateErrorsPresent(){additionalIncomeCoCoPage.verifyErrorMessage_AdditionalIncome();}

    @Then("I validate {string} option is selected on the Additional Income CoCo page")
    public void iValidateOptionSelection(String incomeOption){additionalIncomeCoCoPage.verifyOptionSelected_AdditionalIncome(incomeOption);}

}
