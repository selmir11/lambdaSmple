package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.EmploymentIncomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import com.c4hco.test.automation.stepDefinitions.databaseSteps.DbSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class EmploymentIncomePageSteps {
    EmploymentIncomePage employmentIncomePage = new EmploymentIncomePage(WebDriverManager.getDriver());

    @And("I select {string} employment option")
    public void iSelectMemberEmployment(String memberEmployment){employmentIncomePage.answerEmploymentQs(memberEmployment);}

    @And("I enter {string} income amount")
    public void iEnterIncomeAmount(String incomeAmount){employmentIncomePage.enterIncomeAmount(incomeAmount);}

    @And("I select {string} income frequency option")
    public void iSelectIncomeFrequency(String incomeFrequency){employmentIncomePage.selectIncomeFrequency(incomeFrequency);}

    @And("I select {string} income seasonal option")
    public void iSelectIncomeSeasonal(String incomeSeasonal){employmentIncomePage.answerIsIncomeSeasonalQs(incomeSeasonal);}

    @And("I select {string} income changes option")
    public void iSelectIncomeChanges(String incomeChanges){employmentIncomePage.answerIncomeChangesQs(incomeChanges);}

    @And("I click continue on the Employment income page")
    public void clickContinue(){employmentIncomePage.clickSaveAndContinueButton();}


    @And("I click Go back on the Employment income page")
    public void clickGoBackButton(){employmentIncomePage.clickGoBackButton();}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo Employment income page in {string}")
    public void iVerifyTextOnEmploymentIncomePage(String language){employmentIncomePage.verifyHeadersEmploymentIncomePage(language);}

    @Then("I verify the header for additional member on the CoCo Employment income page in {string}")
    public void iVerifyAdditionalMemberHeadersOnEmploymentIncomePage(String language) {employmentIncomePage.verifyAdditionalMemberHeadersOnEmploymentIncomeCoCoPage(language);}

    @Then("I validate no errors are displayed on the Employment income page")
    public void iValidateNoErrorsPresent(){employmentIncomePage.verifyNoErrorMessage_EmploymentInfo();}

    @Then("I validate {string} job option is selected on the Employment income page")
    public void iValidateNoJobButton(String haveEmployment){employmentIncomePage.verifyJobOption_EmploymentInfo(haveEmployment);}

    @Then("I validate all text on the Employment Income page in {string}")
    public void iValidateCoCoEmploymentIncomeText(String language) {employmentIncomePage.validateCoCoEmploymentIncomeText(language);}

    @Then("I verify the income frequency options in {string}")
    public void iVerifyIncomeFrequencyOptionsCoCo(String language) {employmentIncomePage.verifyIncomeFrequencyOptionsCoCo(language);}

    @Then("I verify the navigation buttons on the CoCo Employment Income page in {string}")
    public void iVerifyEmploymentIncomeNavigationButtonsCoCo(String language) {employmentIncomePage.verifyEmploymentIncomeNavigationButtonsCoCo(language);}

    @Then("I validate page Navigation works for Header and Footer hyperlink text")
    public void iverifyPageNavigation(DataTable dataTable){
        employmentIncomePage.verifyPageNavigation(dataTable);
    }

    @Then("I verify validation text on the CoCo Employment Income page")
    public void iverifyPageText(DataTable dataTable){
        employmentIncomePage.validateErrorMessageAndStyleProp(dataTable);
    }

    @Then("I verify Employment Income CoCo error format for {string}")
    public void iVerifyErrorFormat(String incomeType){employmentIncomePage.verifyErrorFormat(incomeType);}

    @And("I verify selected data on the CoCo Employment Income data")
    public void iVerifySelectedData(List<Map<String, String>> employmentData){employmentIncomePage.verifySelectedData(employmentData);}

    @Then("I validate yes and no buttons for {string} on the Employment Income page in {string}")
    public void iValidateYesNoButtons(String incomeType, String language) {employmentIncomePage.validateYesNoButtons(incomeType, language);}

    @Then("I validate {string} option has no selection on the Employment income page")
    public void iValidateNoSelection(String incomeType){employmentIncomePage.validateNoSelection(incomeType);}
}
