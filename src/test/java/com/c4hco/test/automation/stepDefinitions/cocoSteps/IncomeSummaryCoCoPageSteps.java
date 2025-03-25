package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.IncomeSummaryCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class IncomeSummaryCoCoPageSteps {
    IncomeSummaryCoCoPage incomeSummaryCoCoPage = new IncomeSummaryCoCoPage(WebDriverManager.getDriver());

    @Then("I select the projected income option {string} on Income Summary CoCo page")
    public void selectProjectedOptionCoCo(String projectedOption){incomeSummaryCoCoPage.selectProjectedIncome(projectedOption);}

    @And("I enter {string} of projected income on Income Summary CoCo page")
    public void enterProjectedIncome(String projectedAmount){incomeSummaryCoCoPage.enterProjectedIncomeAmountCoCo(projectedAmount);}

    @And("I select continue on the income Summary CoCo page")
    public void selectContinueIncomeSummary(){incomeSummaryCoCoPage.clickSaveAndContinueButton();}

    @And("I select go back on the income summary CoCo page")
    public void selectGoBackIncomeSUmmary() {incomeSummaryCoCoPage.clickGoBackButton();}

    @And("I select the No projected Income button on the Income Summary page")
    public void selectProjectedIncomeNo() {incomeSummaryCoCoPage.clickprojectedIncomeNo();}

    @And("I click on the edit {string} icon on the Income Summary CoCo page")
    public void iSelectEditIcon(String type) {incomeSummaryCoCoPage.selectEditIcon(type);}

    @And("I click on the Projected Income Input field and click out of this field")
    public void iClickOnProjectedIncomeInputFieldAndClickOutOfIt() {incomeSummaryCoCoPage.clickOnProjectedIncomeInputFieldAndClickOutOfIt();}






    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo Income Summary page in {string}")
    public void iVerifyTextOnIncomeSummaryPage(String language){incomeSummaryCoCoPage.verifyHeadersIncomeSummaryPage(language);}

    @Then("I verify the total annual income to be {string}")
    public void verifyTotalAnnualIncome(String Amount){
        incomeSummaryCoCoPage.verifyTotalAnnualIncome(Amount);
    }

    @Then("I verify the total annual income description in {string}")
    public void verifyTotalAnnualIncomeDescription(String language) {incomeSummaryCoCoPage.verifyTotalAnnualIncomeDescription(language);}

    @Then("I verify the edit icon")
    public void iVerifyEditIcon(){incomeSummaryCoCoPage.verifyEditIcon();}

    @Then("I verify income {string} in {string} on the income summary CoCo page")
    public void iVerifyIncomeName(String income, String language) {incomeSummaryCoCoPage.verifyIncomeName(income, language);}

    @Then("I verify deduction {string} in {string} on the income summary CoCo page")
    public void iVerifyDeductionName(String income, String language) {incomeSummaryCoCoPage.verifyDeductionName(income, language);}

    @Then("I verify the Projected Income text on CoCo Income Summary in {string}")
    public void iVerifyProjectedIncomeText(String language) {incomeSummaryCoCoPage.verifyProjectedIncomeText(language);}

    @Then("I verify income Summary CoCo error format for {string}")
    public void iVerifyErrorFormat(String incomeType){incomeSummaryCoCoPage.verifyErrorFormat(incomeType);}

    @Then("I validate the error text along with its properties on the CoCo Income Summary page")
    public void iVerifyErrorMessageAndItsProperties(DataTable dataTable){
        incomeSummaryCoCoPage.validateErrorMessageAndItsProperties(dataTable);
    }

    @Then("I validate the label text along with its properties on the CoCo Income Summary page")
    public void iVerifyLabelTextAndItsProperties(DataTable dataTable){
        incomeSummaryCoCoPage.validateLabelTextAndItsProperties(dataTable);
    }

    @And("I verify no error shows on the Income Summary page")
    public void iVerifyNoErrors(){incomeSummaryCoCoPage.verifyNoErrors();}

    @Then("I verify the deduction Amount {string} on the Income Summary Coco Page")
    public void iVerifyDeductionAmount(String amount) {incomeSummaryCoCoPage.verifyDeductionAmount(amount);}

    @Then("I validate that the Total Annual Income is correctly determined by adding the Employment Income {string} and Additional Income {string}, then subtracting the Deduction Amount {string}")
    public void iValidateThatTheTotalAnnualIncomeIsCorrectlyDeterminedByAddingTheEmploymentIncomeAndAdditionalIncomeThenSubtractingTheDeductionAmount(String EmploymentIncome, String AdditionalIncome, String DeductionAmt) {
        incomeSummaryCoCoPage.verifyIncomeAmountCalculations(EmploymentIncome, AdditionalIncome, DeductionAmt);
    }
}
