package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiPeaceCorpsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OhiPeaceCorpsSteps {
    OhiPeaceCorpsPage ohiPeaceCorpsPage = new OhiPeaceCorpsPage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the Peace Corps page")
    public void iClickGoBack(){ohiPeaceCorpsPage.clickGoBack();
    }
}
