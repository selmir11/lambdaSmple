package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalPlanResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;

public class MedicalPlanResultsPageSteps {

    MedicalPlanResultsPage medPlanResultsPage = new MedicalPlanResultsPage(WebDriverManager.getDriver());

    @And("I select the first medical plan")
    public void selectFirstMedicalPlanAndContinue() {
        medPlanResultsPage.SelectFirstMedicalPlan();
    }

    @And("I select the first plan detail")
    public void selectFirstMedicalPlanDetailButton() {
        medPlanResultsPage.selectFirstMedicalPlanDetailButton();
    }

    @And("I select {string} medical plan")
    public void selectMedicalPlan(String medicalPlan) {
        medPlanResultsPage.selectMedicalPlan(medicalPlan);
    }

    @Then("I click continue on medical plan results page")
    public void selectContinueOnMedicalPlanResultsPage() {medPlanResultsPage.clickContinue();
    }

    @Then("I click skip on medical plan results page")
    public void selectSkipOnMedicalPlanResultsPage() { medPlanResultsPage.clickSkip();}

    @Then ("I click Go Back on the medical plan results page")
    public void selectGoBackOnMedicalPlanResultsPage() { medPlanResultsPage.clickGoBack();}

    @Then("I click on the compare button")
    public void btnCompare() {
        medPlanResultsPage.clickCompare();
    }

    @Then("I click on the compare links on the first 2 medical plans")
    public void clickFirstTwoCompareButtons() {
        medPlanResultsPage.clickFirstTwoCompareButtons();
    }

    @Then("I click on the compare links on the first 3 medical plans")
    public void clickFirstThreeCompareButtons() {
        medPlanResultsPage.clickFirstThreeCompareButtons();
    }

    @Then("I click on the compare links on the first 4 medical plans")
    public void clickFirstFourCompareButtons() {
        medPlanResultsPage.clickFirstFourCompareButtons();
    }

    @And( "I validate the Compare Warning Box" )
    public void validateCompareBoxWarningTxt(){
        medPlanResultsPage.validateCompareBoxWarningTxt();
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

    @And("I store the medical plan market names from results page")
    public void getMedicalPlanMarketNames() {
        medPlanResultsPage.getMedicalPlanMarketNames();
    }

    @And("I validate there are a total {int} MedicalPlans")
    public void validateTotalMedicalPlans(int expectedCount) {
        medPlanResultsPage.validateTotalMedicalPlans(expectedCount);
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

    @Then("I validate the medical plans count to be {string}")
    public void validateMedicalPlanCount(String plansCount) {
        medPlanResultsPage.validatePlanCount(plansCount);
    }

    @And("I select or skip the medical plans for groups")
    public void selectMedicalPlanForGroup(List<String> plansOfGroups) {
        medPlanResultsPage.selectPlansForGroups(plansOfGroups);
    }

    @And("I validate medical premium amount is not zero")
    public void verifypremiumamountisnotzero() {
        medPlanResultsPage.verifyPremiumAmountIsNotZero();
    }

    @And("I validate the current plan green banner {string} on the Medical Plan Results page")
    public void validateCurrentPlanGreenBanner(String language) {medPlanResultsPage.validateMedicalGreenBannerTxt(language);}

    @And( "I validate the {string} Plan Not Available message on the Medical Plan Results page")
    public void validatePlanNotAvailableTxt(String language) {medPlanResultsPage.validatePlanNotAvailableTxt(language);}
}



