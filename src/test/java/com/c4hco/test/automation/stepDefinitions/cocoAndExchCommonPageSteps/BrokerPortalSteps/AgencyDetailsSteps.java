package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.AgencyDetailsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AgencyDetailsSteps {
    AgencyDetailsPage agencyDetailsPage = new AgencyDetailsPage(WebDriverManager.getDriver());

    @Then("I click Continue on the Agency Details page")
    public void iClickContinueAgencyDetailsPage(){
        agencyDetailsPage.clickContinueAgencyDetailsPage();
    }

    @Then("I click Go Back on the Agency Details page")
    public void iClickGoBackAgencyDetailsPage(){
        agencyDetailsPage.clickGoBackAgencyDetailsPage();
    }

    @Then("I validate the Agency Details page title")
    public void iValidateAgencyDetailsPageTitle(){
        agencyDetailsPage.validateAgencyDetailsPageTitle();
    }

    @And("I validate the field labels on the Agency Details page")
    public void iValidateFieldLabelsAgencyDetailsPage(){
        agencyDetailsPage.validateFieldLabels();
    }

    @Then("I validate the mandatory field error messages")
    public void iValidateMandatoryFieldErrorMessages(){
        agencyDetailsPage.validateMandatoryFieldErrorMessages();
    }

    @Then("I validate the agency name maximum character limit")
    public void iValidateAgencyNameMaxCharacters(){
        agencyDetailsPage.validateAgencyNameMaxCharacters();
    }

    @And("I validate letters are not allowed in the Agency TIN field")
    public void iValidateLettersNotAllowedAgencyTin(){
        agencyDetailsPage.validateLettersNotAllowsAgencyTin();
    }

    @Then("I validate the Agency TIN field maximum limit")
    public void iValidateAgencyTinMax(){
        agencyDetailsPage.validateAgencyTinMax();
    }

    @Then("I validate the fields cannot contain special characters")
    public void iValidateSpecialCharactersInFields(){
        agencyDetailsPage.validateFieldSpecialCharacters();
    }

    @Then("I validate the address fields maximum character limit")
    public void iValidateAddressFieldsMaxCharacter(){
        agencyDetailsPage.validateAddressFieldsMaxCharacter();
    }

    @Then("I validate the city field maximum character limit")
    public void iValidateCityMaxCharacters(){
        agencyDetailsPage.validateCityMaxCharacters();
    }

    @Then("I validate the zip code field maximum limit")
    public void iValidateZipCodeMax(){
        agencyDetailsPage.validateZipCodeMax();
    }

    @Then("I validate the email field will not allow an invalid address")
    public void iValidateEmailInvalidAddress(){
        agencyDetailsPage.validateEmailInvalidAddress();
    }

    @Then("I validate the email field maximum character limit")
    public void iValidateEmailMaxCharacters(){
        agencyDetailsPage.validateEmailMaxCharacters();
    }

    @Then("I validate the phone number field formatting")
    public void iValidatePhoneNumberFormat(){
        agencyDetailsPage.validatePhoneNumberFormat();
    }

    @And("I validate letters are not allowed in the phone field")
    public void iValidateLettersNotAllowedPhoneField(){
        agencyDetailsPage.validatePhoneFieldLettersNotAllowed();
    }

    @Then("I validate the agency group tooltip text")
    public void iValidateAgencyGroupTooltipText(){
        agencyDetailsPage.validateAgencyGroupTooltipText();
    }

    @Then("I verify the Agency Group field is disabled")
    public void iVerifyAgencyGroupDisabled(){
        agencyDetailsPage.verifyAgencyGroupDisabled();
    }

    @Then("I click Cancel on the Agency Details page")
    public void iClickCancelAgencyDetails(){
        agencyDetailsPage.clickCancelAgencyDetails();
    }

    @And("I click the Hide This Address checkbox")
    public void clickHideThisAddressCheckbox(){
        agencyDetailsPage.clickHideAddressCheckbox();
    }

    @And("I click the Save and Submit button on the Agency Details page")
    public void clickSaveSubmitAgencyDetails(){
        agencyDetailsPage.clickAgencyDetailsSaveSubmit();
    }

    @Then("I validate the agency hide address tooltip text")
    public void iValidateAgencyHidAddressTooltipText(){
        agencyDetailsPage.validateAgencyHideAddressTooltipText();
    }

    @Then("I validate the error message to enter both to and from working hours")
    public void iValidateFromToWorkingHoursError(){
        agencyDetailsPage.validateFromToWorkingHoursError();
    }

    @Then("I update my agency TIN")
    public void iUpdateAgencyTin(){
        agencyDetailsPage.updateAgencyTin();
    }

    @And("I update my agency address on the Agency Details page")
    public void iUpdateAgencyAddress(){
        agencyDetailsPage.updateAgencyAddress();
    }

    @Then("I enter the mandatory information on the Agency Details page")
    public void iEnterAgencyDetails(){
        agencyDetailsPage.enterAgencyDetails();
    }

    @And("I validate the Save and Finish Later button is not displayed")
    public void iValidateSaveAndFinishLaterButton(){
        agencyDetailsPage.validateSaveAndFinishLaterButton();
    }

}
