package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoPages.MyProfilePage;
import io.cucumber.java.en.*;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;

public class MyProfilePageSteps {

    MyProfilePage myProfilePage = new MyProfilePage();

    @Then("I click on Go back to Welcome page Button on My Profile CoCo")
    public void iBackToWelcomeButton(){
        myProfilePage.backToWelcomeButton();
    }




}
