package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MyProfilePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyProfilePageStepsCoco {

    MyProfilePage myProfilePage = new MyProfilePage(WebDriverManager.getDriver());

    @Then("I click on Go back to Welcome page Button on My Profile CoCo")
    public void iBackToWelcomeButton() {
        myProfilePage.backToWelcomeButton();
    }

    @And("I click on Make Changes Button in CoCo")
    public void iclickMakeChangesButtonCoCo() {
        myProfilePage.clickMakeChangesButtonCoCo();
    }

    @And("I click on Save Button on My profile CoCo")
    public void iclickSaveButtonCoCo() {
        myProfilePage.clickSaveButtonCoCo();
    }


    @Then("I click on dropdown Preferred Contact Method")
    public void iClickOnDropdownPreferredContactMethod() {
        myProfilePage.clickSaveButtonCoCo();
    }

    @And("I change the Preferred Contact Method to {string} in CoCo")
    public void iChangeThePreferredContactMethodTo(String contactPrefrences) {
        myProfilePage.PreferredContactMethod(contactPrefrences);
    }

    @And("I change Preferred Language Contact Method to {string} in CoCo")
    public void iChangePreferredLanguageContactMethodTo(String langContactPreferred) {
        myProfilePage.PreferredContactLanguageMethod(langContactPreferred);
    }

    @And("I update the contact home phone number on profile page in coco")
    public void updateHomePhone(){
        myProfilePage.updateContactPhoneNumberCoco();
    }

    @And("I update the contact mobile phone number on profile page in coco")
    public void updateMobilePhone(){
        myProfilePage.updateMobilePhNumCoco();
    }

    @Then("I verify Password Popup text on My profile page CoCo {string}")
    public void iverifyPasswordPopupTextOnMyProfileCoCoPage(String language) {
        myProfilePage.verifyPasswordPopupTextOnMyProfileCoCoPage(language);
    }

    @Then("I Validate the error message when no password in provided on the password popup on My profile page in CoCo {string}")
    public void iverifyErrortextpopupOnMyProfileCoCoPage(String language) {
        myProfilePage.verifyErrortextpopupOnMyProfileCoCoPage(language);
    }
    @And("I validate timeout session popup {string} on My Profile page CoCo")
    public void iVerifyTimeoutPopupCoco(String language)  { myProfilePage.VerifyTimeoutPopupCoco(language); }

    @And("I validate the incorrect password error message on My profile page in CoCo {string}")
    public void iverifyIncorrectPasswordErrortextpopupOnMyProfileCoCoPage(String language) {
        myProfilePage.verifyIncorrectPasswordErrortextpopupOnMyProfileCoCoPage(language);
    }

    @And("I validate the functionality of the Cancel link on My profile page CoCo {string}")
    public void iverifyCancelbuttonOnMyProfileCoCoPage(String language) {
        myProfilePage.verifyCancelbuttonOnMyProfileCoCoPage(language);
    }

    @Then("I validate member is logged out of account after third incorrect attempt on password popup CoCo")
    public void iValidatethirdattemptincorrectPasswordCoCo() {
        myProfilePage.ValidatethirdattemptincorrectPasswordCoCo();
    }

    @And("I update the contact email address on my profile page in coco")
    public void updateEmailAddress(){
        myProfilePage.updateContactEmailAddressCoco();
    }

    @And("I validate Email save changes on My Profile page CoCo")
    public void iValidateSaveChangesEmailCoCo() {myProfilePage.ValidateSaveChangesEmailCoCo();
    }

    @And("I validate phone number save changes on My Profile page CoCo")
    public void iValidateSaveChangesPhonenumberCoCo() {myProfilePage.ValidateSaveChangesPhonenumberCoCo();
    }

    @And("I validate Preferred Language save changes on My Profile page CoCo")
    public void iValidateSaveChangesLanguageCoCo() {myProfilePage.ValidateSaveChangesLanguageCoCo();
    }

    @And("I validate Preferred Contact Method save changes on My Profile page CoCo")
    public void iValidateSaveChangesContactMethodCoCo() {myProfilePage.ValidateSaveChangesContactMethodCoCo();
    }

    @And("I click change primary contact on my profile page CoCo") public void iClickChangePrimaryContactOnMyProfilePage() {
        myProfilePage.ClickChangePrimaryContactOnMyProfilePageCoCo();
    }

    @Then("I validate Primary Contact Change Popup {string} on My profile page CoCo")
    public void ivalidateChangePrimaryContactPopupCoCo(String language)  { myProfilePage.validateChangePrimaryContactPopupCoCo(language); }

    @And("I validate error messages {string} on My Profile page CoCo")
    public void validateErrorMessageCoCo(String language)  { myProfilePage.validateErrorMessageCoCo(language); }

    @Then("I verify Password text on My profile page {string} coco")
    public void verifyPasswordTextOnMyProfilePageCoCo(String language)  { myProfilePage.verifyPasswordTextOnMyProfileExchPageCoCo(language); }
}