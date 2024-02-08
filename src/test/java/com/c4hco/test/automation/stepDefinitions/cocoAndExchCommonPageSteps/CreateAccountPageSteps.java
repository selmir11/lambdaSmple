package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import com.c4hco.test.automation.utils.Utils;
import io.cucumber.java.en.*;

import java.time.Duration;



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
            utils.waitForClickablility(createAccountPage.closeHelpIcone,Duration.ofSeconds(2000));
            createAccountPage.closeHelpIcone.click();
        }

        @Then("I enter general mandatory data for {string} account creation")
        public void iEnterDataForAccCreation(String appType){
            createAccountPage.createGeneralAccount(appType);
        };

    @Then("I click on help icon button")
    public void i_click_on_help_icon_button() {
        utils.waitForClickablility(createAccountPage.helpDrawerButton,Duration.ofSeconds(2000));
        createAccountPage.helpDrawerButton.click();
    }

    @And("I click on help icon button {string}")
    public void i_click_on_help_icon_button(String Language) {
            switch (Language){
                case "Spanish" :

                    utils.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                    createAccountPage.languageDrp.click();
                    createAccountPage.spanishLanguage.click();
                    utils.scrollToElement(createAccountPage.helpDrawerButton);
                    createAccountPage.clickHelpIconButton();

                    break;


                case "English" :
                    utils.implicitWait(2000);
                    utils.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                    createAccountPage.languageDrp.click();
                    utils.waitForClickablility(createAccountPage.spanishLanguage, Duration.ofSeconds(1000));
                    createAccountPage.englishLanguage.click();
                    createAccountPage.helpDrawerButton.click();
                    utils.implicitWait(2000);

                    break;
            }


    }

    @And("I click on help icon {string}")
    public void i_click_on_help_icon(String language) {
        switch(language) {
            case "English":
                utils.implicitWait(3000);
                utils.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                createAccountPage.languageDrp.click();
                utils.waitForClickablility(createAccountPage.englishLanguage, Duration.ofSeconds(1000));
                createAccountPage.languageDrp.click();
                createAccountPage.helpIcon.click();

                break;
            case "Spanish":
                utils.implicitWait(3000);
                utils.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                createAccountPage.languageDrp.click();
                utils.waitForClickablility(createAccountPage.spanishLanguage, Duration.ofSeconds(1000));
                createAccountPage.spanishLanguage.click();
                utils.waitForClickablility(createAccountPage.helpIconSP, Duration.ofSeconds(1000));
                createAccountPage.helpIconSP.click();
                break;
            default:
                System.out.println("The wrong language option has been selected");
        }
    }

    @Then("I validate the default verbiage on help icon in {string}")
    public void i_validate_the_default_verbiage_on_help_icon_in(String language) {

            switch(language) {
                case "English":
                    createAccountPage.validateHelpVerbiage();
                    createAccountPage.closeHelpIcone.click();
                    break;
                case "Spanish":
                    createAccountPage.validateHelpVerbiageSP();
                    utils.waitForClickablility(createAccountPage.closeHelpIcone, Duration.ofSeconds(1000));
                    createAccountPage.closeHelpIcone.click();


                    break;
                default:
                    System.out.println("The wrong language option has been selected");
            }


    }



        // =================== VALIDATION STEPS ===============//
       @ When("I validate I am on the createAccount page")
        public void iValidateCreateAccountPage(){
           utils.implicitWait(5000);
            createAccountPage.validateCreateAccountPage();
        };

    }
