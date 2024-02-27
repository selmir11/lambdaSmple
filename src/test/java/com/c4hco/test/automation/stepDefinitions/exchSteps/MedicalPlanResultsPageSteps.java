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
    @Then("I click continue on medical plan results page")
    public void selectContinueOnMedicalPlanResultsPage(){
        medPlanResultsPage.iclickContinue();
    }


    @Then("I click on the compare links on the first 2 medical plans")
    public void clickFirstTwoCompareButtons() {
        medPlanResultsPage.clickFirstTwoCompareButtons();
    }

    @And("I select the Insurance Company dropdown")
    public void clickInsuranceCompanyDropdown() {
        medPlanResultsPage.clickInsuranceCompanyDropdown(); }

    @And("I select {string} to filter for desired plan provider")
    public void selectfromProviderList(String carrierOption) {
        medPlanResultsPage.selectfromProviderList(carrierOption);
    }

       @And("I validate the plan option {int} has text {string}")
    public void validatePlanText(int Index, String planText){
        medPlanResultsPage.validatePlanResults(Index, planText);
    }

}
