package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateAccountPageSteps {

        CreateAccountPage createAccountPage = new CreateAccountPage(WebDriverManager.getDriver());

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


        // =================== VALIDATION STEPS ===============//

        @Then("I validate the verbiage on help icon in {string}")
        public void iValidateVerbiageOnHelpIcon(String Language) {createAccountPage.validateHelpText(Language);}


    @And("I verify Create Your Account Header in {string}")
    public void iVerifyCreateYourAccountHeaderIn(String language) {
            createAccountPage.verifyCreateYourAccountHeader(language);
    }

    @Then("I verify field headers in {string}")
    public void iVerifyFieldHeadersIn(String language) {
            createAccountPage.verifyFieldHeaders(language);
    }

    @And("I verify account holder preferences in {string}")
    public void iVerifyAccountHolderPreferencesIn(String language) {
        createAccountPage.verifyAccountHolderPreferences(language);
    }

    @And("I verify information sharing options in {string}")
    public void iVerifyInformationSharingOptionsIn(String language) {
        createAccountPage.verifyInformationSharingOptions(language);
    }

    @And("I enter duplicate data for account creation")
    public void iEnterDuplicateDateForAccountCreation(){
            createAccountPage.enterDuplicateAccountCreationData();
    }

    @Then("I validate the We're unable to proceed with this email error message in {string}")
    public void iValidateTheAccountExistsErrorMessage(String language){
            createAccountPage.validateAccountExistsErrorMessage(language);
    }
}
