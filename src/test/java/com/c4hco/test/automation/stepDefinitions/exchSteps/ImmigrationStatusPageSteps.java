package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ImmigrationStatusPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class ImmigrationStatusPageSteps {

    ImmigrationStatusPage ImmigrationStatusPage = new ImmigrationStatusPage(WebDriverManager.getDriver());

    @Then("I select {string} for Lawful Permanent Resident")
    public void isMemberLawfulPermanentResident(String YNLawfulPermanentResident) {
        ImmigrationStatusPage.isMemberLawfulPermanentResident(YNLawfulPermanentResident);
    }

    @Then("I select {string} for immigration status")
    public void selectImmigrationStatus(String selectImmigrationStatus) {
        ImmigrationStatusPage.selectImmigrationStatus(selectImmigrationStatus);
    }

    @Then("I click continue on the Immigration Status page")
        public void clickContinue(){
        ImmigrationStatusPage.clickContinue();}


    @And("I validate Citizenship and Immigration status for juvenile {string}")
    public void ivalidateCitizenshipAndImmigrationJuvenileText(String language) {
        ImmigrationStatusPage.validateCitizenshipAndImmigrationJuvenileText(language);
    }

    @Then("I select {string} for the question have you lived in the US since 1996")
    public void isMemberLivedInUSSince1996(String YNLivedInUSSince1996) {
        ImmigrationStatusPage.isMemberLivedInUSSince1996(YNLivedInUSSince1996);
    }

    @Then("I input the grant date of my Lawful Permanent Residency as {string}")
    public void inputGrantDate(String grantDate) {
        ImmigrationStatusPage.inputGrantDate(grantDate);
    }

    @Then("I verify text on the Immigration Status on {string}")
    public void iVerifyTextOnImmigrationStatusPage1890(String status, List<String> dataText) {
        ImmigrationStatusPage.VerifyImmigrationStatusPageText(status, dataText);
    }

    @And("I select {string} icon on the Five-Year Bar Immigration Status page")
    public void iSelectHelpIcon(String labelIcon){ImmigrationStatusPage.clickHelpIcon(labelIcon);}

    @Then("I validate Lawful Presence help drawer Five-Year Bar page {string} verbiage in {string}")
    public void iValidateHelp(String helpText, String language){ImmigrationStatusPage.validateHelpVerbiage(helpText, language);}


}
