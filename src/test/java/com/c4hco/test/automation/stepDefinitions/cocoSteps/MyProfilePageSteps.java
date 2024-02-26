package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MyProfilePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MyProfilePageSteps {

    MyProfilePage myProfilePage = new MyProfilePage(WebDriverManager.getDriver());

    @Then("I click on Go back to Welcome page Button on My Profile CoCo")
    public void iBackToWelcomeButton(){
        myProfilePage.backToWelcomeButton();
    }




}
