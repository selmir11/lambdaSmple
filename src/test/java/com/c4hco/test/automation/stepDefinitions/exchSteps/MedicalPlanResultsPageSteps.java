package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalPlanResultsPage;
import io.cucumber.java.en.*;

public class MedicalPlanResultsPageSteps {

    MedicalPlanResultsPage medPlanResultsPage = new MedicalPlanResultsPage();

    @And("I select the first medical plan and continue")
    public void selectFirstMedicalPlanAndContinue() {
        medPlanResultsPage.SelectFirstMedicalPlan();
    }

    @Then("I select the compare on medical Plan Results")
    public void selectComparebtn() {
        medPlanResultsPage.SelectCompare();
    }

    @Then("I click on the compare links on the first 2 medical plans")
    public void clickFirstTwoCompareButtons() {
        medPlanResultsPage.clickFirstTwoCompareButtons();
    }
}