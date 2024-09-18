package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalPlanDetailCoCoPage;
import com.c4hco.test.automation.pages.cocoPages.MedicalPlansCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

import java.util.List;

public class MedicalPlanDetailCoCoPageSteps {

    MedicalPlanDetailCoCoPage medicalPlanDetailCoCoPage = new MedicalPlanDetailCoCoPage(WebDriverManager.getDriver());

    @And("I verify text on the Coco Plan Detail page")
    public void verifyTextinMedicalCompr(List<String> planDetails){
        medicalPlanDetailCoCoPage.verifyTextMedicalplancmpr(planDetails);
    }
}
