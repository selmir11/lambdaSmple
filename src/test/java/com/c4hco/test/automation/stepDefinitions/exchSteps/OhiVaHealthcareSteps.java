package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiVaHealthcarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiVaHealthcareSteps {
    OhiVaHealthcarePage ohiVaHealthcarePage = new OhiVaHealthcarePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the VA Healthcare page")
    public void iClickGoBack(){ohiVaHealthcarePage.clickGoBack();
    }

}
