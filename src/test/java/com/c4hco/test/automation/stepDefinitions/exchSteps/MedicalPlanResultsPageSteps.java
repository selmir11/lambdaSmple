package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalPlanResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class MedicalPlanResultsPageSteps {

    MedicalPlanResultsPage medPlanResultsPage = new MedicalPlanResultsPage(WebDriverManager.getDriver());

    @And("I select the first medical plan and continue")
    public void selectFirstMedicalPlanAndContinue() {
        medPlanResultsPage.SelectFirstMedicalPlan();
    }

    @Then("I click on the compare button")
    public void selectCompare() {
        medPlanResultsPage.selectCompare();}

    @Then("I click on the compare links on the first 2 medical plans")
    public void clickFirstTwoCompareButtons() {
        medPlanResultsPage.clickFirstTwoCompareButtons();
    }

    @And("I select the Insurance Company dropdown")
    public void clickInsuranceProvider() {
        medPlanResultsPage.clickInsuranceCompanyDropdown();
    }

    @And("I select {string} to filter for desired plan provider")
    public void selectfromProviderList(String Selecting) {
        medPlanResultsPage.selectfromProviderList(Selecting);
    }

    @And("I validate the plan option {int} has text {string}")
    public void validatePlanText(int Index, String planText){
        medPlanResultsPage.validatePlanResults(Index, planText);
    }

}
