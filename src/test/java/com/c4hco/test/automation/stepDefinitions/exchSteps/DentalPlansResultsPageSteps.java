package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlansResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DentalPlansResultsPageSteps {
    DentalPlansResultsPage dentalPlansResultsPage = new DentalPlansResultsPage(WebDriverManager.getDriver());

    @Then("I select first dental plan")
    public void selectDentalPlan(){
        dentalPlansResultsPage.selectFirstDentalPlan();
    }
    @Then("I click continue on dental plan results page")
    public void iClickContinueOnDentalResultsPage(){
        dentalPlansResultsPage.iclickContinueOnDentalResultsPage();
    }

    @Then("I click on back button on dental Plan Results")
    public void clickGoBackButton(){
        dentalPlansResultsPage.clickGoBack();
    }

    @Then("I click on the compare links on the first 2 dental plans")
    public void clickFirstTwoCompareButtons() {dentalPlansResultsPage.clickFirstTwoCompareButtons();
    }
    @Then("I click on the compare dental button")
    public void clickCompareOnDentalPlanResults() {dentalPlansResultsPage.clickCompareOnDentalPlanResults();}

    @And("I click the Coverage Level dropdown")
    public void clickCoverageLevelDropdown() {
        dentalPlansResultsPage.clickCoverageLevelDropdown();
    }

    @And("I select {string} to filter for a Coverage Level plan")
    public void selectfromCoverageLevelList(String coverageLevel) {
        dentalPlansResultsPage.selectfromCoverageLevelList(coverageLevel);
    }
}
