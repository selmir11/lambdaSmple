package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.YourInformationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class YourInformationPageSteps {
    YourInformationPage yourInformationPage = new YourInformationPage(WebDriverManager.getDriver());

    @Then("I validate the Your Information page title")
    public void iValidateYourInformationTitle(){
        yourInformationPage.validateYourInformationTitle();
    }

    @Then("I validate the First Name field shows my {string} name")
    public void iValidateFirstNameAutoPopulated(String portalUserType){
        yourInformationPage.validateFirstNameAutoPopulated(portalUserType);
    }

    @Then("I validate the First Name mandatory field error message")
    public void iValidateFirstNameFieldError(){
        yourInformationPage.validateFirstNameErrorMessage();
    }

    @Then("I validate the Last Name field shows my {string} name")
    public void iValidateLastNameAutoPopulated(String portalUserType){
        yourInformationPage.validateLastNameAutoPopulated(portalUserType);
    }

    @Then("I validate the Last Name mandatory field error message")
    public void iValidateLastNameFieldError(){
        yourInformationPage.validateLastNameErrorMessage();
    }

    @Then("I click the license match checkbox")
    public void iClickLicenseMatchCheckbox(){
        yourInformationPage.clickLicenseMatchCheckbox();
    }

    @Then("I validate the First Name on license error message")
    public void iValidateFirstNameLicenseError(){
        yourInformationPage.validateLicenseFirstNameErrorMessage();
    }

    @Then("I validate the Last Name on license error message")
    public void iValidateLastNameLicenseError(){
        yourInformationPage.validateLicenseLastNameErrorMessage();
    }

    @Then("I validate the license field error message")
    public void iValidateLicenseError(){
        yourInformationPage.validateLicenseErrorMessage();
    }

    @Then("I validate the license required error message")
    public void iValidateLicenseRequiredError(){
        yourInformationPage.validateLicenseRequiredErrorMessage();
    }

    @Then("I validate the license valid from field error message")
    public void iValidateLicenseValidFromError(){
        yourInformationPage.validateLicenseValidFromErrorMessage();
    }

    @Then("I validate the license valid to field error message")
    public void iValidateLicenseValidToError(){
        yourInformationPage.validateLicenseValidToErrorMessage();
    }

    @Then("I validate the Book of Business error message")
    public void iValidateBoBErrorMessage(){
        yourInformationPage.validateBoBErrorMessage();
    }

    @Then("I validate the maximum character limit for the license field")
    public void iValidateLicenseMaxCharacterLimit(){
        yourInformationPage.validateLicenseMaxCharacterLimit();
    }

    @Then("I click Go Back on the Your Information page")
    public void iClickGoBackYourInformation(){
        yourInformationPage.clickGoBackYourInformationPage();
    }

    @Then("I enter my {string} license number and dates")
    public void iEnterLicenseAndDates(String accountType){
        yourInformationPage.enterLicenseAndDates(accountType);
    }

    @And("I update my {string} license and effective dates")
    public void iUpdateLicenseAndDates(String accountType){
        yourInformationPage.updateLicenseAndDates(accountType);
    }

    @And("I click No to the Book of Business question")
    public void iClickBookOfBusinessNoButton(){
        yourInformationPage.clickBookOfBusinessNoButton();
    }

    @And("I click Yes to the Book of Business question")
    public void iClickBookOfBusinessYesButton(){
        yourInformationPage.clickBookOfBusinessYesButton();
    }

    @Then("I validate the invitation code error message")
    public void iValidateInviteCodeErrorMessage(){
        yourInformationPage.validateInviteCodeErrorMessage();
    }

    @Then("I enter the admin staff invitation code on the Your Information page")
    public void iEnterAdminStaffInviteCode(){
        yourInformationPage.enterAdminStaffInviteCode();
    }

    @Then("I click the checkbox for I do not have a code")
    public void iClickIDoNotHaveCodeCheckbox(){
        yourInformationPage.clickIDoNotHaveCodeCheckbox();
    }

    @Then("I click Continue on the Your Information page")
    public void iClickContinueYourInformationPage(){
        yourInformationPage.clickContinueYourInformationPage();
    }

    @Then("I verify the Book of Business buttons are disabled")
    public void iVerifyBoBDisabled(){
        yourInformationPage.verifyBoBDisabled();
    }

    @Then("I validate the error message for the license expiration date")
    public void iValidateTheErrorMessageForTheLicenseExpirationDate() {
        yourInformationPage.validateTheErrorMessageForTheLicenseExpirationDate();
    }
}
