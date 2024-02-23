package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ImmigrationStatusPage;
import io.cucumber.java.en.Then;

public class ImmigrationStatusPageSteps {

    ImmigrationStatusPage ImmigrationStatusPage = new ImmigrationStatusPage();

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

}
