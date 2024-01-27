package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import io.cucumber.java.en.*;

public class CreateAccountPageSteps {

        CreateAccountPage createAccountPage = new CreateAccountPage();

        @And("I click on help icon")
            public void iClickHelpIcon(){
            createAccountPage.clickHelpIcon();
        };

        @Then("I validate the default verbiage on help icon")
                public void iValidateHelpVerbiage(){
            createAccountPage.validateHelpVerbiage();
        };

        @Then("I enter general mandatory data for {string} account creation")
        public void iEnterDataForAccCreation(String appType){
            createAccountPage.createGeneralAccount(appType);
        };

        // =================== VALIDATION STEPS ===============//
       @ When("I validate I am on the createAccount page")
        public void iValidateCreateAccountPage(){
            createAccountPage.validateCreateAccountPage();
        };

    }
