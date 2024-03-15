package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiTricarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OhiTricareSteps {
    OhiTricarePage ohiTricarePage = new OhiTricarePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the TRICARE page")
    public void iClickGoBack(){ohiTricarePage.clickGoBack();
    }
}
