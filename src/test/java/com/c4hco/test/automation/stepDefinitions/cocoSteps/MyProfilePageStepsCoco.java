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

    @And("I click on Save Button in CoCo")
    public void iclickSaveButtonCoCo() {
        myProfilePage.clickSaveButtonCoCo();
    }


}
