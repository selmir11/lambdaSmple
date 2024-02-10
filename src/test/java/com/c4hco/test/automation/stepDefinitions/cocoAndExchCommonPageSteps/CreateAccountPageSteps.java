package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateAccountPageSteps {

        CreateAccountPage createAccountPage = new CreateAccountPage();

        @And("I click on help icon")
            public void iClickHelpIcon(){createAccountPage.clickHelpIcon();}

        @And("I close the help icon")
        public void iCloseHelpIcon(){createAccountPage.closeHelpIcon();}

        @Then("I enter general mandatory data for {string} account creation")
        public void iEnterDataForAccCreation(String appType){
            createAccountPage.createGeneralAccount(appType);
        }

         @And("I click on help icon button")
          public void iClickOnHelpIconButton() {createAccountPage.clickHelpIconButton();}

        @Then("I validate the verbiage on help icon in {string}")
         public void iValidateVerbiageOnHelpIcon(String Language) {createAccountPage.validateHelpText(Language);}


        // =================== VALIDATION STEPS ===============//

    }
