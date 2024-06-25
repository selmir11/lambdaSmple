package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlansResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DentalPlansResultsPageSteps {
    DentalPlansResultsPage dentalPlansResultsPage = new DentalPlansResultsPage(WebDriverManager.getDriver());

    @Then("I select first dental plan")
    public void selectFirstDentalPlan() { dentalPlansResultsPage.selectFirstDentalPlan(); }

    @And("I select {string}")
    public void selectDentalPlan(String dentalPlanNames) {
        dentalPlansResultsPage.selectDentalPlan(dentalPlanNames);
    }

    @Then("I click continue on dental plan results page")
    public void clickContinueOnDentalResultsPage() {
        dentalPlansResultsPage.clickContinueOnDentalResultsPage();
    }

    @Then("I click on back button on dental Plan Results")
    public void clickGoBackButton() {
        dentalPlansResultsPage.clickGoBack();
    }

    @Then("I click on the compare links on the first 2 dental plans")
    public void clickFirstTwoCompareButtons() {
        dentalPlansResultsPage.clickFirstTwoCompareButtons();
    }

    @Then("I click on the compare dental button")
    public void clickCompareOnDentalPlanResults() {
        dentalPlansResultsPage.clickCompareOnDentalPlanResults();
    }

    @And("I click the Coverage Level dropdown")
    public void clickCoverageLevelDropdown() {
        dentalPlansResultsPage.clickCoverageLevelDropdown();
    }

    @And("I click the Dental Insurance Company Dropdown")
    public void clickDentalInsuranceCompanyDropdown() {
        dentalPlansResultsPage.clickDentalInsuranceCompanyDropdown();
    }

    @And("I validate plan option {int} has {string}")
    public void validateDentalPlanText(int Index, String coverageLevelPlanText) {
        dentalPlansResultsPage.validateDentalPlanText(Index, coverageLevelPlanText);
    }

    @And("I select {string} to filter for a Coverage Level plan")
    public void selectToFilterForACoverageLevelPlan(String coverageLevel) {
        dentalPlansResultsPage.selectfromCoverageLevelList(coverageLevel);
    }

    @And("I select {string} to filter for a Dental Insurance Company")
    public void selectfromInsuranceCompanyList(String insuranceCompany) {
        dentalPlansResultsPage.selectfromInsuranceCompanyList(insuranceCompany);
    }

    @And("I validate the Dental Plan option {int} has a plan result {string}")
    public void validatePlanText(int Index, String dentalPlanText) {
        dentalPlansResultsPage.validateDentalPlanText(Index,dentalPlanText);
    }
}
