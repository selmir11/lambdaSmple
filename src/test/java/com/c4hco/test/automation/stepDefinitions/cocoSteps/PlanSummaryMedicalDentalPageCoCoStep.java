package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PlanSummaryMedicalDentalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class PlanSummaryMedicalDentalPageCoCoStep {

        PlanSummaryMedicalDentalCoCoPage planSummaryMedicalDentalCoCoPage = new PlanSummaryMedicalDentalCoCoPage(WebDriverManager.getDriver());

        @And("I click continue on coco plan summary page")
        public void continueButton(){
            planSummaryMedicalDentalCoCoPage.continueButton();
        }

    }
