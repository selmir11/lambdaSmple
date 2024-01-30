package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import io.cucumber.java.en.*;

import java.time.Duration;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.waitFor;

public class CreateAccountPageSteps {

        CreateAccountPage createAccountPage = new CreateAccountPage();

        @And("I click on help icon")
            public void iClickHelpIcon(){
            createAccountPage.clickHelpIcon();
        };

        @Then("I validate the default verbiage on help icon")
                public void iValidateHelpVerbiage(){
            createAccountPage.validateHelpVerbiage();
            waitFor(1);
            createAccountPage.closeHelpIcone.click();
        }

        @Then("I enter general mandatory data for {string} account creation")
        public void iEnterDataForAccCreation(String appType){
            createAccountPage.createGeneralAccount(appType);
        };

    @Then("I click on help icon button")
    public void i_click_on_help_icon_button() {
        waitFor(2);
        createAccountPage.helpDrawerButton.click();
    }

    @And("I click on help icon button {string}")
    public void i_click_on_help_icon_button(String Language) {
            switch (Language){
                case "Spanish" :

                    createAccountPage.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                    createAccountPage.languageDrp.click();
                    createAccountPage.spanishLanguage.click();
                    createAccountPage.scrollToElement(createAccountPage.helpDrawerButton);
                    createAccountPage.clickHelpIconButton();

                    break;


                case "English" :
                    waitFor(2);
                    createAccountPage.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                    createAccountPage.languageDrp.click();
                    createAccountPage.waitForClickablility(createAccountPage.spanishLanguage, Duration.ofSeconds(1000));
                    createAccountPage.englishLanguage.click();
                    createAccountPage.helpDrawerButton.click();
                    waitFor(2);

                    break;
            }


    }

    @And("I click on help icon {string}")
    public void i_click_on_help_icon(String language) {
        switch(language) {
            case "English":
                createAccountPage.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                createAccountPage.languageDrp.click();
                createAccountPage.waitForClickablility(createAccountPage.englishLanguage, Duration.ofSeconds(1000));
                createAccountPage.languageDrp.click();
                createAccountPage.helpIcon.click();

                break;
            case "Spanish":
                createAccountPage.waitForClickablility(createAccountPage.languageDrp, Duration.ofSeconds(1000));
                createAccountPage.languageDrp.click();
                createAccountPage.waitForClickablility(createAccountPage.spanishLanguage, Duration.ofSeconds(1000));
                createAccountPage.spanishLanguage.click();
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
                    waitFor(2);
                    createAccountPage.validateHelpVerbiageSP();
                    createAccountPage.waitForClickablility(createAccountPage.closeHelpIcone, Duration.ofSeconds(1000));
                    createAccountPage.closeHelpIcone.click();


                    break;
                default:
                    System.out.println("The wrong language option has been selected");
            }


    }



        // =================== VALIDATION STEPS ===============//
       @ When("I validate I am on the createAccount page")
        public void iValidateCreateAccountPage(){
            createAccountPage.validateCreateAccountPage();
        };

    }
