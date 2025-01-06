package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.LoginPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages.CreateAccountPage;
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

    @Then("I enter general mandatory data for {string} account creation for the script {string}")
    public void enterScriptBasedData(String appType, String scriptNum){
        createAccountPage.createAccountForScript(appType, scriptNum);
    }

    @Then("I enter first name {string}, middle name {string}, last name {string} and general mandatory data for {string} account creation")
    public void iEnterSpecificDataForAccCreation(String fName, String mName, String lName, String appType){createAccountPage.createSpecificAccount(fName, mName, lName, appType);}

    @Then("I enter general mandatory data for {string} account creation with email {string}@outlook.com")
    public void iCreateGeneralAccountOutlook(String appType, String emailBase){
        createAccountPage.createGeneralAccountOutlook(appType, emailBase);
    }

    @Then("I enter general mandatory data for {string} account creation with email {string}@gmail.com")
    public void iCreateGeneralAccountGmail(String appType, String emailBase){
        createAccountPage.createGeneralAccountGmail(appType, emailBase);
    }

    @Then("I enter mandatory data for {string} account creation with email {string}@outlook.com")
    public void iEnterDataForBrokerAccCreation(String accountType, String emailBase){
        createAccountPage.createBrokerAccount(accountType, emailBase);
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

    @And("I enter duplicate data for account creation for {string}")
    public void iEnterDuplicateDateForAccountCreation(String appType){
        createAccountPage.enterDuplicateAccountCreationData(appType);
    }

    @And("I enter duplicate data for account creation for {string} with new email")
    public void duplicateAccWithNewEmail(String appType){
        createAccountPage.duplicateAccWithNewEmail(appType);
    }

    @And("I enter duplicate data for Agency Owner account creation")
    public void iEnterDuplicateDateForBrokerAccountCreation(){
            createAccountPage.enterDuplicateBrokerAccountCreationData();
    }

    @Then("I validate the We're unable to proceed with this email error message in {string}")
    public void iValidateTheAccountExistsErrorMessage(String language){
        createAccountPage.validateAccountExistsErrorMessage(language);
    }

    @Then("I validate the mandatory field error messages in {string}")
    public void iValidateMandatoryFieldErrorMessages(String language){
        createAccountPage.validateMandatoryFieldErrorMessages(language);
    }

    @Then("I validate the mandatory options error messages in {string}")
    public void iValidateMandatoryOptionsErrorMessages(String language){
        createAccountPage.validateMandatoryOptionsErrorMessages(language);
    }

    @Then("I validate that letters are not allowed in the phone field")
    public void iValidateLettersNotAllowedPhoneField(){
        createAccountPage.validatePhoneFieldLettersNotAllowed();
    }

    @Then("I validate the fields cannot contain special characters error message in {string}")
    public void iValidateSpecialCharactersErrorMessages(String language){
        createAccountPage.validateSpecialCharactersErrorMessage(language);
    }

    @Then("I validate the password must contain at least 8 characters error message in {string}")
    public void iValidatePasswordMinimumCharacterErrorMessage(String language){
        createAccountPage.validatePasswordMinimumCharacterErrorMessage(language);
    }

    @Then("I validate the password must contain 1 uppercase character error message in {string}")
    public void iValidatePasswordUppercaseErrorMessage(String language){
        createAccountPage.validatePasswordUppercaseErrorMessage(language);
    }

    @Then("I validate the password must contain 1 lowercase character error message in {string}")
    public void iValidatePasswordLowercaseErrorMessage(String language){
        createAccountPage.validatePasswordLowercaseErrorMessage(language);
    }

    @Then("I validate the password must contain 1 number error message in {string}")
    public void iValidatePasswordNumberErrorMessage(String language){
        createAccountPage.validatePasswordNumberErrorMessage(language);
    }

    @Then("I validate the password cannot contain part of the username error message in {string}")
    public void iValidatePasswordUsernameErrorMessage(String language){
        createAccountPage.validatePasswordUsernameErrorMessage(language);
    }

    @Then("I validate the password cannot contain the first name error message in {string}")
    public void iValidatePasswordFirstNameErrorMessage(String language){
        createAccountPage.validatePasswordFirstNameErrorMessage(language);
    }

    @Then("I validate the mandatory checkbox error messages in {string}")
    public void iValidateMandatoryCheckboxErrorMessages(String language){
        createAccountPage.validateMandatoryCheckboxErrorMessages(language);
    }

    @Then("I validate the mandatory role error message in {string}")
    public void iValidateMandatoryBrokerRoleErrorMessage(String language){
        createAccountPage.validateMandatoryBrokerRoleErrorMessage(language);
    }

    @And("I enter password in Create Account Page")
    public void iEnterPasswordInCreateAccountPage() {
        createAccountPage.EnterPasswordInCreateAccountPage();
    }
}