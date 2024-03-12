package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.MyProfileExchPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MyProfilePageSteps {

    MyProfileExchPage myProfileExchPage = new MyProfileExchPage(WebDriverManager.getDriver());

    @Then("I click on Go back to Welcome page Button on My Profile Exch")
    public void iBackToWelcomeButtonExch(){
        myProfileExchPage.backToWelcomeButtonExch();
    }
}

