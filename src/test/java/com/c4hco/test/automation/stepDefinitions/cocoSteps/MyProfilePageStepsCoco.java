package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MyProfilePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyProfilePageStepsCoco {

    MyProfilePage myProfilePage = new MyProfilePage(WebDriverManager.getDriver());

    @Then("I click on Go back to Welcome page Button on My Profile CoCo")
    public void iBackToWelcomeButton(){
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
    @Then("I verify Password Popup text on My profile page CoCo {string}")
    public void iverifyPasswordPopupTextOnMyProfileCoCoPage(String language)  { myProfilePage.verifyPasswordPopupTextOnMyProfileCoCoPage(language); }

}
