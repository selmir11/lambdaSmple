package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlansResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class DentalPlansResultsPageSteps {
    DentalPlansResultsPage dentalPlansResultsPage = new DentalPlansResultsPage(WebDriverManager.getDriver());


    @Then ("I select the filter reset button")
    public void clickResetButton(){dentalPlansResultsPage.clickResetButton();}

    @Then("I select first dental plan")
    public void selectFirstDentalPlan() { dentalPlansResultsPage.selectFirstDentalPlan(); }

    @And("I select {string} plan")
    public void selectDentalPlan(String dentalPlanNames) {
        dentalPlansResultsPage.selectDentalPlan(dentalPlanNames);
    }

    @And("I validate for Pediatric Dental Plans")
    public void validatePediatric(){dentalPlansResultsPage.validatePediatric();}

    @And("I validate that Pediatric Dental Plans are not available")
    public void validatePediatricFalse(){dentalPlansResultsPage.validatePediatricFalse();}

    @And("I validate the text in dental plan results page")
    public void DentalresultspagetextValidation(){dentalPlansResultsPage.DentalresultspagetextValidation();}

    @And ("I validate for Pediatric and Adult Dental Plans")
    public void validatePediatricAndAdult(){dentalPlansResultsPage.validateAdultPediatric();}

    @And("I click on the First Dental Detail button")
    public void clickFirstPlanDetailButton(){dentalPlansResultsPage.clickFirstPlanDetailBtn();}

    @And("I click on the remove plan button on dental plan results page")
    public void removeplanondentalplanresults(){dentalPlansResultsPage.removeplanondentalplanresults();}

    @Then("I click continue on dental plan results page")
    public void clickContinueOnDentalResultsPage() {
        dentalPlansResultsPage.clickContinueOnDentalResultsPage();}

    @Then("I click Go Back on Dental Plan Results page")
    public void clickGoBackButton() { dentalPlansResultsPage.clickGoBack(); }

    @Then("I click Skip on Dental Plan Results page")
    public void selectSkipOnDentalPlanResultsPage() { dentalPlansResultsPage.clickSkip(); }

    @Then("I click on the compare links on the first 2 dental plans")
    public void clickFirstTwoCompareBoxes() {dentalPlansResultsPage.clickFirstTwoCompareBoxes();
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

    @Then("I validate the dental plans count to be {string}")
    public void validateDentalPlanCount(String plansCount) {
        dentalPlansResultsPage.validateDentalPlanCount(plansCount);
    }

    @Then("I validate the dental plans")
    public void validateDentalPlans() {
        dentalPlansResultsPage.validateDentalPlanNames();
    }

    @And("I select or skip the dental plans for groups")
    public void selectDentalPlanForGroup(List<String> plansOfGroups) {
        dentalPlansResultsPage.selectDentalPlansForGroups(plansOfGroups);
    }

    @And("I validate dental premium amount is  zero")
    public void verifypremiumamountiszero() {
        dentalPlansResultsPage.verifyPremiumAmountIsZero();
    }

    @And("I store the Dental plan market names from results page")
    public void getMedicalPlanMarketNames() {dentalPlansResultsPage.getDentalPlanMarketNames();
    }

    @And("I validate there are a total {int} dentalPlans")
    public void validateTotalMedicalPlans(int expectedCount) {dentalPlansResultsPage.validateTotalDentalPlans(expectedCount);
    }

    @And( "I validate the {string} Tool Tips Text on the Dental Plan Results page" )
    public void validateToolTipText(String language){dentalPlansResultsPage.validateToolTipText(language);}

    @And("I select the sorting {string} option on the Dental Plan Results page")
    public void clickSortingDropdown(String sortingValue) {
        dentalPlansResultsPage.clickSortingDropdown(sortingValue);
    }

    @Then("I validate sorting based on {string} on the Dental Plan Results page")
    public void evaluateSortingValue(String sortingTypeSelection) { dentalPlansResultsPage.evaluateSortingValue(sortingTypeSelection);}

    @Then("I validate Spanish sorting based on {string} on the Dental Plan Results page")
    public void evaluateSpanishSortingValues(String sortingTypeSelection) { dentalPlansResultsPage.evaluateSpanishSortingValues(sortingTypeSelection);}

    @And("I validate the current plan green banner {string} text on the Dental Plan Results page")
    public void validateGreenBannerTxt(String language) {dentalPlansResultsPage.validateGreenBannerText(language);
    }

    @And ("I validate the {string} Plan Not Available message on the Dental Plan Results page")
    public void validatePlanNotAvailableTxt(String language) {dentalPlansResultsPage.validatePlanNotAvailableTxt(language);
    }

    @And("I validate that the Continue button is disabled on the Dental Plan Results page")
    public void validateContinueButtonDisabled() {
        dentalPlansResultsPage.validateContinueButtonDisabled();
    }
}
