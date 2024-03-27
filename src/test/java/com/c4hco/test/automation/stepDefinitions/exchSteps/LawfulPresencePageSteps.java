package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LawfulPresencePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

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

    @Then("I enter A-Number USCIS number")
    public void enterANumberUSCISNumber() {
        lawfulPresencePage.enterUSCISNumber();
    }

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

    @And("I get the Primary Member ID")
    public void iGetPrimaryMemberId(){lawfulPresencePage.getPrimaryMemberId();}

    @And("I change the C4 url to {string}")
    public void iChangeToNewUrl(String page){lawfulPresencePage.changeToNewUrl(page);}

    @And("I change the C4 URL to {string} PrimaryMemberId {string}")
    public void iChangeUrl(String UrlStart, String UrlEnd){lawfulPresencePage.changeUrl(UrlStart, UrlEnd);}
}
