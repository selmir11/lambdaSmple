package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MyProfileExchPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyProfilePageSteps {

    MyProfileExchPage myProfileExchPage = new MyProfileExchPage(WebDriverManager.getDriver());

    @Then("I click on Go back to Welcome page Button on My Profile Exch")
    public void iBackToWelcomeButtonExch() {
    myProfileExchPage.backToWelcomeButtonExch();
    }

    // WIP - Rename the below step add include the page name
    @And("I click on Make Changes Button")
    public void iclickMakeChangesButton() {
        myProfileExchPage.clickMakeChangesButton();
    }

    @And("I click on Save Button")
    public void iclickSaveButton() {
        myProfileExchPage.clickSaveButton();
    }

    @And("I click on the My Profile Save Button while OBO")
    public void iclickSaveButtonObo() {
        myProfileExchPage.clickSaveButtonObO();
    }

    @And("I click on Cancel Button on password pop on My Profile page Exch")
    public void iclickCancelButton() {
        myProfileExchPage.clickCancelButton();
    }

    @And("I click the Change Password Button")
    public void iclickChangePasswordButton() {myProfileExchPage.clickChangePasswordButton();
    }
    @And("I validate Email save changes on My Profile page")
    public void iValidateSaveChangesEmail() {myProfileExchPage.ValidateSaveChangesEmail();
    }

    @And("I validate phone number save changes on My Profile page")
    public void iValidateSaveChangesPhonenumber() {myProfileExchPage.ValidateSaveChangesPhonenumber();
    }

    @And("I validate Preferred Language save changes on My Profile page")
    public void iValidateSaveChangesLanguage() {myProfileExchPage.ValidateSaveChangesLanguage();
    }

    @And("I validate Preferred Contact Method save changes on My Profile page")
    public void iValidateSaveChangesContactMethod() {myProfileExchPage.ValidateSaveChangesContactMethod();
    }

///////////////////////////////////Validation Steps/////////////////

    @And("I verify text on My profile page {string}")
    public void verifyTextOnMyProfilePage(String language)  { myProfileExchPage.verifyTextOnMyProfileExchPage(language); }


   @Then("I verify Password text on My profile page {string}")
   public void verifyPasswordTextOnMyProfilePage(String language)  { myProfileExchPage.verifyPasswordTextOnMyProfileExchPage(language); }

    @Then("I Validate the error message when no password in provided on the password popup on My profile page in Exch {string}")
    public void iverifyErrortextpopupOnMyProfileExchPage(String language)  { myProfileExchPage.verifyErrortextpopupOnMyProfileExchPage(language); }

    @And("I validate the incorrect password error message on My profile page in Exch {string}")
    public void iverifyIncorrectPasswordErrortextpopupOnMyProfileExchPage(String language)  { myProfileExchPage.verifyIncorrectPasswordErrortextpopupOnMyProfileExchPage(language); }

    @Then("I verify Password Popup text on My profile page Exch {string}")
    public void iverifyPasswordPopupTextOnMyProfileExchPage(String language)  { myProfileExchPage.verifyPasswordPopupTextOnMyProfileExchPage(language); }

    @And("I validate the functionality of the Cancel link on My profile page Exch {string}")
    public void iverifyCancelbuttonOnMyProfileExchPage(String language)  { myProfileExchPage.verifyCancelbuttonOnMyProfileExchPage(language); }

    @Then("I validate member is logged out of account after third incorrect attempt on password popup")
    public void iValidatethirdattemptincorrectPassword() {
        myProfileExchPage.ValidatethirdattemptincorrectPassword();
    }

    @Then("I change Preferred Contact Method {string}")
    public void iChangePreferredContactMethod() {
        myProfileExchPage.clickPreferredContactDrp();
    }

    @And("I change the Preferred Contact Method to {string}")
    public void iChangeThePreferredContactMethodTo(String contactPrefrences) {
        myProfileExchPage.PreferredContactMethod(contactPrefrences);
    }

    @And("I change Preferred Language Contact Method to {string}")
    public void iChangePreferredLanguageContactMethodTo(String langContactPreferred) {
        myProfileExchPage.PreferredContactLanguageMethod(langContactPreferred);
    }

    @And("I click change primary contact on my profile page")
    public void iClickChangePrimaryContactOnMyProfilePage() {
        myProfileExchPage.ClickChangePrimaryContactOnMyProfilePage();
    }

    @And("I update the contact home phone number on profile page")
    public void iUpdateContactPhoneNumber() {
        myProfileExchPage.updateContactPhoneNumber();
    }

    @And("I update the contact mobile phone number on profile page")
    public void updateMobileNum() {
        myProfileExchPage.updateMobilePhNum();
    }

    @And("I update the contact email address on profile page")
    public void updateContactEmailAddress() {myProfileExchPage.UpdateContactEmailAddress();}

    @And("I update the contact preferred language on profile page")
    public void updateContactPreferredLang() {myProfileExchPage.PreferredContactLanguageMethod("Spanish");}

    @And("I update the contact preferred method on profile page")
    public void updateContactPreferredMethod() {myProfileExchPage.PreferredContactMethod("Mail");}

    @Then("I update {string} as primary member")
    public void iSelectTheHouseholdMemberAsPrimaryContact(String memberName) {
        myProfileExchPage.SelectTheHouseholdMemberAsPrimaryContact(memberName);
    }

    @And("I validate Email error message in {string} on my Profile Page")
    public void iverifyEmailUseErrorMessage(String language)  { myProfileExchPage.verifyEmailUseErrorMessage(language); }

    @And("I validate timeout session popup {string} on My Profile page")
    public void iVerifyTimeoutPopup(String language)  { myProfileExchPage.VerifyTimeoutPopup(language); }

    @Then("I validate Primary Contact Change Popup {string} on My profile page")
    public void ivalidateChangePrimaryContactpopop(String language)  { myProfileExchPage.validateChangePrimaryContactpopop(language); }

    @And("I validate error messages {string} on My Profile page")
    public void validateErrorMessage(String language)  { myProfileExchPage.validateErrorMessage(language); }

    @Then("I verify change button is not displaying for primary contact on the my profile page")
    public void iVerifyChangeButtonIsNotDisplayingForPrimaryContactOnTheMyProfilePage() {
        myProfileExchPage.changePrimaryContactnotdisplay();
    }

    @And("I update Preferred Written Language to {string}")
    public void iUpdatePreferredLanguageContactMethodTo(String langContactPreferred) {
        myProfileExchPage.PreferredWritternLanguage(langContactPreferred);
    }

    @And("I validate timeout session popup without taking any actions")
    public void iValidateTimeoutSessionPopupWithoutTakingAnyActions() {
        myProfileExchPage.validateTimeoutSessionPopupWithoutTakingAnyActions();
    }
}

