package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.ErrorCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class ErrorCoCoPageSteps {
    ErrorCoCoPage errorCoCoPage = new ErrorCoCoPage(WebDriverManager.getDriver());

    @And("I click Back to Welcome page Button on error CoCo page")
    public void clickBackToWelcome() {
        errorCoCoPage.backToWelcomeButton();
    }
}
