package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.PrescreenPage;
import io.cucumber.java.en.*;

public class PreScreenPageSteps {
        PrescreenPage prescreenPage = new PrescreenPage();
    BasicSteps basicSteps = new BasicSteps();

        @And("I click create my account from pre-screen page")
        public void iClickCreateAccountLink(){
            prescreenPage.clickCreateAccountLink();
        };
    // =================VALIDATION STEPS==============//
//        @And("I validate I am on the pre-screen page")
//        public void iValidatePreScreenPage(String page){
//            basicSteps.iValidatePage("Prescreen");
//        }

    }
