package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.WhatsNextPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class WhatsNextPageSteps {

    WhatsNextPage whatsNextPage = new WhatsNextPage(WebDriverManager.getDriver());

    @And("I click on Go To Welcome Page Button on whats next page")
    public void clickWelcomeBtn(){
        whatsNextPage.clickWelcomeBtn();
    }
}
