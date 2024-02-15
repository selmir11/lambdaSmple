package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalPlanResultsPage;
import io.cucumber.java.en.*;

public class MedicalPlanResultsPageSteps {

    MedicalPlanResultsPage medPlanResultsPage = new MedicalPlanResultsPage();

    @And("I select the first medical plan and continue")
    public void selectFirstMedicalPlanAndContinue() {
        medPlanResultsPage.SelectFirstMedicalPlan();
    }

    @And("I select the Insurance Company dropdown")
    public void clickInsuranceProvider() {
        medPlanResultsPage.clickInsuranceCompanyDropdown();
    }

    @And("I select the Anthem Insurance Company box")
    public void selectAnthemProvider() {
        medPlanResultsPage.selectAnthemProvider();
    }
}
