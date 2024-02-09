package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import com.c4hco.test.automation.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;



public class CreateAccountPageSteps {

        CreateAccountPage createAccountPage = new CreateAccountPage();
        Utils utils=new Utils();

        @And("I click on help icon")
            public void iClickHelpIcon(){
            createAccountPage.clickHelpIcon();
        };

        @Then("I validate the default verbiage on help icon")
        public void iValidateHelpVerbiage(){
            createAccountPage.validateHelpVerbiage();
            createAccountPage.closeHelpIcon();
        }

        @Then("I enter general mandatory data for {string} account creation")
        public void iEnterDataForAccCreation(String appType){
            createAccountPage.createGeneralAccount(appType);
        };

    @Then("I click on help icon button")
    public void i_click_on_help_icon_button() {
        createAccountPage.clickHelpIconButton();
    }


    @And("I click on help icon button {string}")
    public void i_click_on_help_icon_button(String Language) {

        createAccountPage.changeLanguage(Language);
        createAccountPage.clickHelpIconButton();
    }

    @And("I click on help icon {string}")
    public void i_click_on_help_icon(String Language) {
                createAccountPage.changeLanguage(Language);
                createAccountPage.clickHelpIconButton();

    }

    @Then("I validate the default verbiage on help icon in {string}")
    public void i_validate_the_default_verbiage_on_help_icon_in(String Language) {
        createAccountPage.validateHelpText(Language);
        createAccountPage.closeHelpIcon();
    }


        // =================== VALIDATION STEPS ===============//

    }
