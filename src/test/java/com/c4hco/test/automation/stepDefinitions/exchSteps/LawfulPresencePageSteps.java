package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LawfulPresencePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;

public class LawfulPresencePageSteps {

    LawfulPresencePage lawfulPresencePage = new LawfulPresencePage(WebDriverManager.getDriver());

    @Then("I select {string} for Citizen option")
    public void isMemberCitizen(String YNCitizen){lawfulPresencePage.isMemberCitizen(YNCitizen);}

    @Then("I select {string} for Naturalized Immigrant option")
    public void isMemberNaturalized(String YNNaturalized){lawfulPresencePage.isMemberNaturalized(YNNaturalized);}

    @Then("I select {string} for Eligible Immigration Status option")
    public void isMemberHaveEligibleImmigrationStatus(String YNEligibleImmigrationStatus) {
        lawfulPresencePage.isMemberHaveEligibleImmigrationStatus(YNEligibleImmigrationStatus);
    }

    @Then("I select {string} as Document type")
    public void selectDocumentType(String documentType) {
        lawfulPresencePage.selectDocumentType(documentType);
    }

    @Then("I enter A-Number USCIS number for {string} on Lawful Presence page")
    public void enterANumberUSCISNumber(String citizenship) {lawfulPresencePage.enterUSCISNumber(citizenship);}

    @Then("I select {string} as Document type on Lawful Presence page")
    public void iClickDocType(String docType) {lawfulPresencePage.clickDocType(docType);}

    @Then("I enter Document Number on Lawful Presence page")
    public void iEnterDocumentNumber() {lawfulPresencePage.enterDocumentNumber();}

    @Then("I enter Card Number") public void enterCardNumber() {lawfulPresencePage.enterCardNumber();}

    @Then("I enter Expiration Date") public void enterExpirationDate() {lawfulPresencePage.enterExpirationDate();}

    @Then("I select {string} active-duty members of the military or honorably discharged veterans")
    public void selectActiveDutyMilitaryOrHonorablyDischargedVeterans(String memberOptions) {
        lawfulPresencePage.selectActiveDutyMilitaryOrHonorablyDischargedVeterans(memberOptions);
    }

    @Then("I select {string} for name matching the document")
    public void selectNameMatchesDocument(String YNNameMatchesDocument) {
        lawfulPresencePage.selectNameMatchesDocument(YNNameMatchesDocument);
    }

    @Then("I click continue on the Citizenship page")
    public void clickContinue(){lawfulPresencePage.clickContinue();}

    @Then("I click Go back on the Citizenship page")
    public void clickGoBack(){lawfulPresencePage.clickGoBack();}

    @And("I get the Primary Member ID")
    public void iGetPrimaryMemberId(){lawfulPresencePage.getMemberId();}

    @And("I verify the text on the Citizenship and Immigration Status page in {string}")
    public void verifyTextOnCitizenshipAndImmigrationStatusPage(String language, List<String> data) {
        lawfulPresencePage.validateVerbiageOnCitizenshipAndImmigratioStatusPage(language, data);
    }

    @And("I verify the text for Naturalized Citizen in {string}")
    public void verifyTheTextForNaturalizedCitizenInEnglish(String language, List<String> data) {
        lawfulPresencePage.validateVerbageForNaturalizedCitizenIn(language, data);
    }

    @And("I verify the text for Eligible Immigration Status in {string}")
    public void iVerifyTheTextForEligibleImmigrationStatusIn(String language, List<String> data) {
        lawfulPresencePage.validateVerbiageForEligibleImmigrationStausIn(language, data);
    }

    @Then("I verify the Document Type dropdown options in {string}")
    public void iVerifyTheTextForDocumentTypeIn(String language, List<String> data) {
        lawfulPresencePage.validateVerbiageForDocumentTypeIn(language, data);
    }

    @Then("I verify the text Document Type in {string}")
    public void iValidateTheVerbiageOnTheCurrentPage(String language,List<String> data) {
        lawfulPresencePage.validateDocumentTypeText(language, data);
    }

    @And("I verify the text for undocumented citizen information in {string}")
    public void verifyTextForUndocumentedCitizenInfo(String language) {
        lawfulPresencePage.validateUndocumentedCitizenInfoText(language);
    }

    @And("I select {string} icon on the Citizenship and Immigration Status page")
    public void iSelectHelpIcon(String labelIcon){lawfulPresencePage.clickHelpIcon(labelIcon);}

    @Then("I validate Lawful Presence help drawer {string} verbiage in {string}")
    public void iValidateHelp(String helpText, String language){lawfulPresencePage.validateHelpVerbiage(helpText, language);}

    @Then("I validate the error message {string} is thrown while clicking on Continue button")
    public void iValidateUSCitizenErrorMessage(String expectedErrorMessage){lawfulPresencePage.validateUSCitizenErrorMessage(expectedErrorMessage);}

    @Then("I Validate the Naturalized citizen question and its options text along with the Yes & No radio buttons")
    public void iValidateNaturalizedCitizenQuestionAndOptions(List<String> expectedTextList){lawfulPresencePage.validateNaturalizedCitizenQuestionAndOptions(expectedTextList);}

    @Then("I validate the text for Eligible Immigration Status along with the Yes & No radio buttons")
    public void iValidateEligibleImmigrationStatusQuestionAndOptions(List<String> expectedTextList){lawfulPresencePage.validateEligibleImmigrationStatusQuestionAndOptions(expectedTextList);}

    @Then("I validate the following text on selecting No to Eligible Immigration Status Question")
    public void iValidateTextOnSelectingNoToEligibleImmigrationStatusQuestion(List<String> expectedTextList){lawfulPresencePage.validateTextOnSelectingNoToEligibleImmigrationStatusQuestion(expectedTextList);}

    @Then("I validate the error message {string} is thrown while clicking on Continue button when no answer is selected for Naturalized citizen question")
    public void iValidateNaturalizedCitizenErrorMessage(String expectedErrorMessage){lawfulPresencePage.validateNaturalizedCitizenErrorMessage(expectedErrorMessage);}

    @Then("I validate the error message {string} is thrown while clicking on Continue button when no answer is selected for Eligible Immigration Status question")
    public void iValidateEligibleImmigrationStatusErrorMessage(String expectedErrorMessage){lawfulPresencePage.validateEligibleImmigrationStatusErrorMessage(expectedErrorMessage);}

    @Then("I Validate the US citizen question and its options text along with the Yes & No radio buttons")
    public void iValidateUSCitizenQuestionAndOptions(List<String> expectedTextList){lawfulPresencePage.validateUSCitizenQuestionAndOptions(expectedTextList);}

    @Then("I validate page texts when us citizen option is {string}")
    public void iValidatePageTextsWhenUsCitizenOptionIs(String option,List<String> languageText) {
        lawfulPresencePage.validatePageTextWhenUsCitizenOptYesOrNo(option, languageText);
    }
    @Then("I validate the error message in Citizenship and Immigration status page in {string}")
    public void iValidateTheErrorMessageInCitizenshipAndImmigrationStatusPageIn(String language, List<String> dataText) {
        lawfulPresencePage.verifyErrMsgInCitizenshipAndImmigrationPage(language,dataText);
    }

    @Then("I validate the error message {string} is thrown while clicking on Continue button when no answer is selected for Document type dropdown")
    public void iValidateDocumentTypeDropdownErrorMessage(String expectedErrorMessage){lawfulPresencePage.validateDocumentTypeDropdownErrorMessage(expectedErrorMessage);}

    @Then("I validate the following text along with the checkboxes,radiobuttons,text box and the username match with document name question")
    public void iValidateWebElementsAfterSelectingDocumentType(List<String> expectedText){lawfulPresencePage.validateWebElementsAfterSelectingDocumentType(expectedText);}

    @Then("I validate the error message {string} is thrown while clicking on Continue button when value {string} is given in the field A-Number Or USCIS number")
    public void iValidateWebElementsAfterSelectingDocumentType(String expectedErrorMessage,String value){lawfulPresencePage.validateAlienNumberFieldErrorMessage(expectedErrorMessage,value);}

    @Then("I validate the value in A-number field is trimmed to {string} when the input is given as {string}")
    public void iValidateTrimmedValueInANumberField(String expectedValue,String givenValue){lawfulPresencePage.iValidateTrimmedValueInANumberField(expectedValue,givenValue);}

    @Then("I validate the error message {string} is thrown while clicking on Continue button when username match the name on the document question")
    public void iValidateNameMatchesDocumentErrorMessage(String expectedErrorMessage){lawfulPresencePage.validateNameMatchesDocumentErrorMessage(expectedErrorMessage);}

    @Then("I validate the following text along with the First Name,Middle Name & Last Name textboxes")
    public void iValidateTextAndWebElementsAfterSelectingNoToDocumentNameMatchQuestion(List<String> expectedText){lawfulPresencePage.validateTextAndWebElementsAfterSelectingNoToDocumentNameMatchQuestion(expectedText);}

    @Then("I validate the following error messages are thrown while clicking on Continue button when no values are given in the First Name and Last Name fields")
    public void iValidateErrorMessagesWhenNoValueGivenInFirstNameAndLastNameFields(List<String> expectedText){lawfulPresencePage.validateErrorMessagesWhenNoValueGivenInFirstNameAndLastNameFields(expectedText);}

    @Then("I enter the value {string} in First Name field and validate that it doesnot accept the characters more than 25")
    public void iValidateFieldDoesNotAcceptMoreThan25Characters(String inputText){lawfulPresencePage.validateFieldDoesNotAcceptMoreThan25Characters(inputText);}

    @Then("I enter the value {string} in Last Name field and validate that it doesnot accept the characters more than 40")
    public void iValidateFieldDoesNotAcceptMoreThan40Characters(String inputText){lawfulPresencePage.validateFieldDoesNotAcceptMoreThan40Characters(inputText);}

    @Then("I validate the error message {string} is thrown while clicking on Continue button when value {string} is given in the field Last Name")
    public void iValidateLastNameFieldErrorMessageWhenNumericValueIsGivenInIt(String expectedErrorMessage,String value){lawfulPresencePage.validateLastNameFieldErrorMessageWhenNumericValueIsGivenInIt(expectedErrorMessage,value);}

    @Then("I validate the error message {string} is thrown while clicking on Continue button when no answers are selected for military or honorably discharged veterans question")
    public void iValidateMilitaryOrHonorablyDischargedVeteranErrorMessage(String expectedErrorMessage){lawfulPresencePage.validateMilitaryOrHonorablyDischargedVeteranErrorMessage(expectedErrorMessage);}




}
