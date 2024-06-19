package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ErrorExchPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class ErrorExchPageSteps {
    ErrorExchPage errorExchPage = new ErrorExchPage(WebDriverManager.getDriver());

    @And("I click Back to Welcome page Button on error Exch page")
    public void clickBackToWelcome() {
        errorExchPage.backToWelcomeButton();
    }
}
