package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalPlanResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class MedicalPlanResultsPageSteps {

    MedicalPlanResultsPage medPlanResultsPage = new MedicalPlanResultsPage(WebDriverManager.getDriver());

    @And("I select the first medical plan")
    public void selectFirstMedicalPlanAndContinue() {
        medPlanResultsPage.SelectFirstMedicalPlan();
    }

    @And("I select {string} medical plan")
    public void selectMedicalPlan(String medicalPlan) {
        medPlanResultsPage.selectMedicalPlan(medicalPlan);
    }

    @Then("I click continue on medical plan results page")
    public void selectContinueOnMedicalPlanResultsPage() {
        medPlanResultsPage.iclickContinue();
    }

    @Then("I click on the compare button")
    public void btnCompare() {
        medPlanResultsPage.clickCompare();
    }

    @Then("I click on the compare links on the first 2 medical plans")
    public void clickFirstTwoCompareButtons() {
        medPlanResultsPage.clickFirstTwoCompareButtons();
    }

    @And("I select the Insurance Company dropdown")
    public void clickInsuranceCompanyDropdown() {
        medPlanResultsPage.clickInsuranceCompanyDropdown();
    }

    @And("I select {string} to filter for desired plan provider")
    public void selectfromProviderList(String carrierOption) {
        medPlanResultsPage.selectfromProviderList(carrierOption);
    }

    @And("I select the Metal Tier dropdown")
    public void clickMetalTierDropdown() {
        medPlanResultsPage.clickMetalTierDropdown();
    }

    @And("I select {string} to filter for a Metal Tier plan")
    public void selectfromMetalTierList(String metalOption) {
        medPlanResultsPage.selectfromMetalTierList(metalOption);
    }

    @And("I validate the plan option {int} has text {string}")
    public void validatePlanText(int Index, String planText) {
        medPlanResultsPage.validatePlanResults(Index, planText);
    }

    @And("I click the HSA dropdown")
    public void clickHSADropdown() {
        medPlanResultsPage.clickHSADropdown();
    }

    @And("I select the HSA option")
    public void selectHSAOption() {
        medPlanResultsPage.selectHSAOption();
    }

    @And("I click the Colorado Option dropdown")
    public void clickColoradoOptionDropdown() {
        medPlanResultsPage.clickColoradoOptionDropdown();
    }

    @And("I select the Colorado Option")
    public void selectColoradoOptionSelection() {
        medPlanResultsPage.selectColoradoOptionSelection();
    }
}



