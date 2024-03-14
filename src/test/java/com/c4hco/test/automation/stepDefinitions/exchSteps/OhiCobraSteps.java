package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiCobraPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OhiCobraSteps {
    OhiCobraPage ohiCobraPage = new OhiCobraPage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the COBRA page")
    public void iClickGoBack(){ohiCobraPage.clickGoBack();
    }
}
