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

    @And("I verify dropdown controls in coco plan detail page")
    public void verifyDropDowninMedicalCompr(List<String> planDetails){
        medicalPlanDetailCoCoPage.verifyDropdownMedicalplancmpr(planDetails);
    }

    @And("I select the Go Back button on the coco Medical Plan Detail page")
    public void clickMedicalDetailGoBack(){medicalPlanDetailCoCoPage.clickMedicalDetailGoBack();
    }
}
