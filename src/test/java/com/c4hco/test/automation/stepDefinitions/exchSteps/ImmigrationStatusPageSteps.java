package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ImmigrationStatusPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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

}
