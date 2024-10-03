package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PlanSummaryMedicalDentalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class PlanSummaryMedicalDentalPageCoCoStep {

        PlanSummaryMedicalDentalCoCoPage planSummaryMedicalDentalCoCoPage = new PlanSummaryMedicalDentalCoCoPage(WebDriverManager.getDriver());

        @And("I click continue on coco plan summary page")
        public void continueButton(){
            planSummaryMedicalDentalCoCoPage.continueButton();
        }

    @Then("I click Go Back on coco plan summary page")
    public void clickGoBackStartShoppingPage(){
        planSummaryMedicalDentalCoCoPage.iclickGoBack();
    }

    @Then ("I validate the English text on the Plan Summary CoCo page")
    public void verifyEnglishTextPlanSummaryCOCOPage(){planSummaryMedicalDentalCoCoPage.verifyEnglishTextPlanSummaryCOCOPage();
    }

    @Then ("I validate the Spanish text on the Plan Summary CoCo page")
    public void verifySpanishextPlanSummaryCOCOPage(){planSummaryMedicalDentalCoCoPage.verifySpanishextPlanSummaryCOCOPage();
    }


    }
