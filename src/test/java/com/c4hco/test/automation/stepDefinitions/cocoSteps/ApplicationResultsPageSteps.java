package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.ApplicationResultsCoCoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ApplicationResultsPageSteps {

    ApplicationResultsCoCoPage applicationResultsCoCoPage = new ApplicationResultsCoCoPage();

    @And("I click on Go back to Welcome page Button on Application Results page CoCo")
    public void iBackToWelcomeButton(){
        applicationResultsCoCoPage.backToWelcomeButton();
    }




}
