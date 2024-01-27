package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.PrescreenPage;
import io.cucumber.java.en.*;

public class PreScreenPageSteps {
        PrescreenPage prescreenPage = new PrescreenPage();

        @And("I click create my account from pre-screen page")
        public void iClickCreateAccountLink(){
            prescreenPage.clickCreateAccountLink();
        };

        @And("I validate I am on the pre-screen page")
                public void iValidatePreScreenPage(){
            prescreenPage.validatePreScreenPage();
        }

    }
