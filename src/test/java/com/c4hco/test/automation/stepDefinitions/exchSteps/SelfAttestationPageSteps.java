package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.RaceAndEthnicityPage;
import com.c4hco.test.automation.pages.exchPages.SelfAttestationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SelfAttestationPageSteps {

    SelfAttestationPage SelfAttestationPage = new SelfAttestationPage(WebDriverManager.getDriver());

    @And("I select {string} for Household Income")
    public void iSelectForHouseholdIncome(String householdIncome) {
        SelfAttestationPage.clickHousehold(householdIncome);
    }

    @And("I select {string} for Federal Income")
    public void iSelectForFederalIncome(String federalIncome) {
        SelfAttestationPage.clickFederal(federalIncome);
    }

    @And("I select {string} for Tax Info")
    public void iSelectForTaxInfo(String taxInfo) {
        SelfAttestationPage.clickTax(taxInfo);
    }

    @Then("I click on Submit Self Attestation button")
    public void iClickOnSubmitSelfAttestationButton() {
        SelfAttestationPage.clickSubmit();
    }

    @Then("I verify the text on the Post Attestation page")
    public void iVerifyTheTextOnThePostAttestationPage() {

        SelfAttestationPage.checkText();
    }

    @Then("I click on Finish")
    public void iClickOnFinish() {
        SelfAttestationPage.clickFinish();
    }
}
