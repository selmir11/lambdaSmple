package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.ApplicationResultsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class ApplicationResultsPageSteps {

    ApplicationResultsCoCoPage applicationResultsCoCoPage = new ApplicationResultsCoCoPage(WebDriverManager.getDriver());

    @And("I click on Go back to Welcome page Button on Application Results page CoCo")
    public void iBackToWelcomeButton(){
        applicationResultsCoCoPage.backToWelcomeButton();
    }

    @And("I click Continue on the Application Results Page CoCo")
    public void clickContinueButton(){applicationResultsCoCoPage.continueWithApplication();}


}
