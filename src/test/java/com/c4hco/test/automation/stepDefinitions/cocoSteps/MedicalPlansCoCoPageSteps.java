package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalPlansCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class MedicalPlansCoCoPageSteps {
    MedicalPlansCoCoPage medicalPlansCoCoPage = new MedicalPlansCoCoPage(WebDriverManager.getDriver());

    @And("I select {string} medical plan option")
    public void selectMedicalPlanOption(String medicalPlan){medicalPlansCoCoPage.selectMedicalPlan(medicalPlan);}

    @And("I click Continue on the Medical Plans Page CoCo")
    public void selectContinueMedPlansCoCo(){medicalPlansCoCoPage.selectContinueMedicalPlansCoCo();}
}
