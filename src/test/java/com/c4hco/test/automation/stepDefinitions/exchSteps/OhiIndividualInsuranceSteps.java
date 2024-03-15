package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiIndividualInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OhiIndividualInsuranceSteps {
    OhiIndividualInsurancePage ohiIndividualInsurancePage = new OhiIndividualInsurancePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the Individual Insurance page")
    public void iClickGoBack(){ohiIndividualInsurancePage.clickGoBack();
    }
}
