package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.WhatsNextCoCoPage;
import com.c4hco.test.automation.pages.exchPages.WhatsNextPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class WhatsNextCoCoPageSteps {

    WhatsNextCoCoPage whatsNextCoCoPage = new WhatsNextCoCoPage(WebDriverManager.getDriver());

    @And("I click on Go To Welcome Page Button on whats next coco page")
    public void clickWelcomeBtn(){
        whatsNextCoCoPage.clickWelcomeBtn();
    }
}
