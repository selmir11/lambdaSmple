package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentInfoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class EmploymentInfoPageSteps {

    EmploymentInfoPage employmentInfoPage = new EmploymentInfoPage(WebDriverManager.getDriver());

    @Then("I select the option {string} to employment")
    public void selectEmployment(String Employment) {
        employmentInfoPage.isUserEmployed(Employment);
    }

    @And("I select the option {string} to self employment")
    public void selectSelfEmployment(String SelfEmployment) {
        employmentInfoPage.isUserSelfEmplyed(SelfEmployment);
    }

    @And("I enter employment details with {string} income at {string} frequency") // deprecate this to use below
    public void iEnterEmploymentDetails(String Salary, String Frequency) {
        employmentInfoPage.addEmploymentInfo(Salary, Frequency);
    }

    @And("I enter self-employment details with {string} income at {string} frequency and {string} to same or lower")
    // deprecate this to use below
    public void iEnterSelfEmploymentDetails(String Salary, String Frequency, String Same) {
        employmentInfoPage.addSelfEmploymentInfo(Salary, Frequency, Same);
    }

    @Then("I enter company details with addressline1 as {string} and city as {string} and state as {string} and zipcode as {string} and income {string} at frequency {string}")
    public void ienterCompanyDetails(String addressline1, String city, String state, String zipcode, String income, String frequency) {
        employmentInfoPage.genericEmploymentInfo(addressline1, city, state, zipcode, income, frequency);
    }

    @And("I edit the income level to {string}")
    public void iEnterEmploymentIncome(String Salary) {
        employmentInfoPage.enterEmploymentIncome(Salary);
    }

    @And("I select the option {string} to seasonal employment")
    public void selectSeasonalEmployment(String SeasonalEmployment) {
        employmentInfoPage.isUserEmploymentSeasonal(SeasonalEmployment);
    }

    @And("I select the option {string} to projected income")
    public void selectProjectedIncome(String ProjectedIncome) {
        employmentInfoPage.projectedIncomeQuestion(ProjectedIncome);
    }

    @And("I click continue on the Employment Info Page")
    public void saveAndContinue() {
        employmentInfoPage.saveAndContinue();
    }

    @And("I select {string} icon on the Employment Info Page")
    public void iSelectGeneralHelpIcon(String labelIcon) {
        employmentInfoPage.clickHelpIcon(labelIcon);
    }

    @And("I click Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink() {
        employmentInfoPage.clickHelpContactUsNavigation();
    }

    @Then("I select the EditUpdate link for employer {int}")
    public void iClickEditUpdateLink(int index) {
        employmentInfoPage.clickEditUpdateLink(index);
    }

    @And("I click go back button on the Employment Info Page")
    public void iClickGoBackButton() {
        employmentInfoPage.goBackButton();
    }

    @Then("I click on company Name input field and click out of it")
    public void iClickOnCompanyNameInputFieldAndClickOutOfIt() {
        employmentInfoPage.clickOnCompanyNameInputFieldAndClickOutOfIt();
    }

    @Then("I enter the value {string} in company name input field")
    public void iEnterValueInCompanyNameInputField(String value) {
        employmentInfoPage.enterValueInCompanyNameInputField(value);
    }

    @Then("I click on enter profit input field and click out of it")
    public void iClickOnEnterProfitInputFieldAndClickOutOfIt() {
        employmentInfoPage.clickOnEnterProfitInputFieldAndClickOutOfIt();
    }

    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @Then("I validate Employment Info Page header in {string}")
    public void iValidateHeaderOnEmploymentInfo(String languageSelection) {
        employmentInfoPage.validateHeaderOnEmploymentInfo(languageSelection);
    }

    ;

    @Then("I validate help drawer header verbiage in {string}")
    public void iValidateHelpHeader(String languageSelection) {
        employmentInfoPage.validateHelpHeaderVerbiage(languageSelection);
    }

    @Then("I validate general help drawer body verbiage in {string}")
    public void iValidateGeneralHelpBody(String languageOption) {
        employmentInfoPage.validateGeneralHelpBodyVerbiage(languageOption);
    }

    @Then("I validate help drawer footer verbiage in {string}")
    public void iValidateHelpFooter(String languageSelection) {
        employmentInfoPage.validateHelpFooterVerbiage(languageSelection);
    }

    @Then("I validate job question verbiage in {string}")
    public void iValidateJobQsHelpVerbiage(String languageSelection) {
        employmentInfoPage.validateJobQuestionsHelpVerbiage(languageSelection);
    }

    ;

    @Then("I validate Company verbiage in {string}")
    public void iValidateCompanyQsHelpVerbiage(String languageSelection) {
        employmentInfoPage.validateCompanyHelpVerbiage(languageSelection);
    }

    ;

    @Then("I validate Net Income verbiage in {string}")
    public void iValidateNetIncomeQsHelpVerbiage(String languageSelection) {
        employmentInfoPage.validateNetIncomeHelpVerbiage(languageSelection);
    }

    ;

    @Then("I validate Income Change verbiage in {string}")
    public void iValidateIncomeChangeQsHelpVerbiage(String languageSelection) {
        employmentInfoPage.validateIncomeChangeHelpVerbiage(languageSelection);
    }

    ;

    @Then("I validate Address 1 verbiage in {string}")
    public void iValidateAddress1QsHelpVerbiage(String languageSelection) {
        employmentInfoPage.validateAddress1HelpVerbiage(languageSelection);
    }

    ;

    @Then("I validate Gross Income verbiage in {string}")
    public void iValidateGrossIncomeQsHelpVerbiage(String languageSelection) {
        employmentInfoPage.validateGrossIncomeHelpVerbiage(languageSelection);
    }

    ;

    @Then("I validate Seasonal verbiage in {string}")
    public void iValidateSeasonalQsHelpVerbiage(String languageSelection) {
        employmentInfoPage.validateSeasonalHelpVerbiage(languageSelection);
    }

    ;

    @Then("I Verify the page text on Employment Income page, which is in initial state")
    public void iVerifyTextOnInitialIncomePage(List<String> dataText) {
        employmentInfoPage.verifyTextOnInitialIncomePage(dataText);
    }

    @Then("I Verify the page text on Employment Income page after clicking yes to employment")
    public void iVerifyTextOnIncomePageAfterSelectingYesToEmployment(List<String> dataText) {
        employmentInfoPage.verifyTextOnIncomePageAfterClickingYesToEmploymentQuestion(dataText);
    }

    @Then("I Verify the page text on Employment Income page after clicking yes to self employment question")
    public void iVerifyTextOnIncomePageAfterSelectingYesToSelfEmployment(List<String> dataText) {
        employmentInfoPage.verifyTextOnIncomePageAfterClickingYesToSelfEmploymentQuestion(dataText);
    }

    @Then("I Verify the page text on Employment Income page after clicking No to self employment question")
    public void iVerifyTextOnIncomePageAfterSelectingNoToSelfEmployment(List<String> dataText) {
        employmentInfoPage.verifyTextOnIncomePageAfterClickingNoToSelfEmploymentQuestion(dataText);
    }

    @And("I enter the projected income {string} on summary details page")
    public void iEnterTheProjectedIncomeOnSummaryDetailsPage(String projectedIncome) {
        employmentInfoPage.enterProjectedIncome(projectedIncome);
    }

    @Then("I validate the Net Income Frequency Dropdown Menu in {string}")
    public void iValidateTheNetIncomeFrequencyDropdownMenuIn(String language) {
        employmentInfoPage.validateNetIncomeFrequencyDropdown(language);
    }

    @Then(("I validate company names in employment summary page"))
    public  void ivalidatecompanyname(){
        employmentInfoPage.validateCompanyName();

    }

    @Then("I verify that the No Employment button is enabled")
    public void verifyNoEmploymentButton() {
        employmentInfoPage.verifyNoEmployedButtonIsEnabled();
    }

    @Then("I validate that the employment status label is not present")
    public void validateEmploymentStatusLabelAbsence() {
        employmentInfoPage.validateEmploymentStatusLabelAbsence();
    }

    @Then("I verify the company name error message {string}")
    public void iValidateCompanyNameErrorMessage(String expectedErrorMessage) {
        employmentInfoPage.validateCompanyNameErrorMessage(expectedErrorMessage);
    }

    @Then("I enter the value of 110 characters in Company Name Input field and validate that it does not accept the characters more than 100")
    public void iValidateFieldDoesNotAcceptMoreThan100Characters(){employmentInfoPage.validateFieldDoesNotAcceptMoreThan100Characters();}

    @Then("I verify no errors show for company name field")
    public void iVerifyCompanyNameFieldNoError()  { employmentInfoPage.verifyCompanyNameFieldNoError(); }

    @Then("I verify the Enter profit amount error message {string}")
    public void iValidateEnterProfitAmountErrorMessage(String expectedErrorMessage) {
        employmentInfoPage.validateEnterProfitAmountErrorMessage(expectedErrorMessage);
    }

    @Then("I verify the income gets converted to {string}")
    public void iValidateEnterProfitAmount(String expectedAmount) {
        employmentInfoPage.validateEnterProfitAmount(expectedAmount);
    }

    @Then("I verify no errors show for Enter profit Income field")
    public void iVerifyEnterProfitIncomeFieldNoError()  { employmentInfoPage.verifyEnterProfitIncomeFieldNoError(); }

    @Then("I verify the income frequency type error message {string}")
    public void iValidateIncomeFrequencyErrorMessage(String expectedErrorMessage) {
        employmentInfoPage.validateIncomeFrequencyErrorMessage(expectedErrorMessage);
    }

    @Then("I verify the Income same or Lower question error message {string}")
    public void iValidateIncomeSameOrLowerErrorMessage(String expectedErrorMessage) {
        employmentInfoPage.validateIncomeSameOrLowerErrorMessage(expectedErrorMessage);
    }

    @Then("I verify no errors show for Income frequency field and Income same or lower question field")
    public void iVerifyNoErrorsShowForFrequencyAndIncomeSameLowerField()  { employmentInfoPage.verifyNoErrorsShowForFrequencyAndIncomeSameLowerField(); }
    @Then("I verify page header in English in Employment Income page")
    public void iVerifyPageHeaderInEnglish(List<String> pageHeader) {
        employmentInfoPage.validateHeaderOnEmploymentIncome(pageHeader);
    }

    @Then("I validate All error message colour and text in Employment Income page")
    public void iValidateAllErrorMessageColourAndTextInEmploymentIncomePage(List<String> errorMessages) {
        employmentInfoPage.validateAllErrorMessageColourAndText(errorMessages);
    }

    @Then("I validate max length of each text field in Employment Income page")
    public void iValidateMaxLengthOfEachTextFieldInEmploymentIncomePage() {
        employmentInfoPage.validateMaxLengthOfEachTextField();
    }

    @Then("I validate zip code and include commission text box field")
    public void iValidateZipCodeAndCommissionTextBoxField() {
        employmentInfoPage.validateZipCodeAndCommissionTextField();
    }

    @Then("I verify the income frequency dropdown allows single selection")
    public void iVerifyTheIncomeFrequencyDropdownAllowsSingleSelection() {
        employmentInfoPage.validateIncomeFreAllowsSingleSelection();
    }

    @Then("I validate functionality of {string} question")
    public void iValidateFunctionalityOfQuestion(String question) {
        employmentInfoPage.validateFunctionalityOfQuestions(question);
    }

    @Then("I validate Employment Income page for text design")
    public void iverifiEmploymentIncomeTextDesign()  { employmentInfoPage.verifiEmploymentIncomeTextDesign(); }


    @Then("I validate Employment Income page for YesOption text design")
    public void iverifiEmploymentIncomeTextDesignYesOption()  { employmentInfoPage.verifiEmploymentIncomeTextDesignYesOption(); }


    @Then("I validate Employment Income page for NoOption text design")
    public void iverifiEmploymentIncomeTextDesignNoOption()  { employmentInfoPage.verifiEmploymentIncomeTextDesignNoOption(); }

    @Then("I verify the page text for secondary member on Employment Income page, which is in initial state")
    public void iVerifyTextForSecondaryMemberOnInitialIncomePage(List<String> dataText) {
        employmentInfoPage.verifyTextForSecondaryMemberOnInitialIncomePage(dataText);
    }

    @Then("I verify the page text for secondary member on Employment Income page after clicking yes to employment")
    public void iVerifyTextOnIncomePageForSecondaryMemberAfterSelectingYesToEmployment(List<String> dataText) {
        employmentInfoPage.verifyTextOnIncomePageForSecondaryMemberAfterSelectingYesToEmployment(dataText);
    }

    @Then("I verify the Yes button is selected for have a job or currently employed question")
    public void iVerifyYesButtonIsSelectedForHaveAJobOrCurrentlyEmployedQuestion() {
        employmentInfoPage.verifyYesButtonIsSelectedForHaveAJobOrCurrentlyEmployedQuestion();
    }

    @Then("I verify the page text for secondary member on Employment Income page after clicking yes to self employment question")
    public void iVerifyPageTextForSecondaryMemberOnIncomePageAfterSelectingYesToSelfEmployment(List<String> dataText) {
        employmentInfoPage.verifyPageTextForSecondaryMemberOnIncomePageAfterSelectingYesToSelfEmployment(dataText);
    }

    @Then("I verify the {string} button is selected for self-employment question")
    public void iVerifyTheMentionedButtonIsSelectedForTheSelfEmploymentQuestion(String button) {
        employmentInfoPage.verifyTheMentionedButtonIsSelectedForTheSelfEmploymentQuestion(button);
    }

    @Then("I verify the page text for secondary member on Employment Income page after clicking No to self employment question")
    public void iVerifyPageTextForSecondaryMemberOnIncomePageAfterSelectingNoToSelfEmployment(List<String> dataText) {
        employmentInfoPage.verifyPageTextForSecondaryMemberOnIncomePageAfterSelectingNoToSelfEmployment(dataText);
    }

}
