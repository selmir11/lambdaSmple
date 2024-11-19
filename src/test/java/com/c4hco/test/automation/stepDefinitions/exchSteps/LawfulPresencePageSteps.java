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

    @Then("I select {string} for the question have you lived in the US since 1996")
    public void isMemberLivedInUSSince1996(String YNLivedInUSSince1996) {
        lawfulPresencePage.isMemberLivedInUSSince1996(YNLivedInUSSince1996);
    }

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
}
