package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalPlanResultsPage;
import io.cucumber.java.en.*;

public class MedicalPlanResultsPageSteps {

    MedicalPlanResultsPage medPlanResults = new MedicalPlanResultsPage();
    @And("I select the first medical plan and continue")
    public void selectFirstMedicalPlanAndContinue(){
        medPlanResults.SelectFirstMedicalPlan();
    }
}
