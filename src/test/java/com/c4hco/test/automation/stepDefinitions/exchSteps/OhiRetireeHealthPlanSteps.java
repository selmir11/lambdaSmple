package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiRetireeHealthPlanPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiRetireeHealthPlanSteps {
    OhiRetireeHealthPlanPage ohiRetireeHealthPlanPage = new OhiRetireeHealthPlanPage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the Retiree Health Plan page")
    public void iClickGoBack(){ohiRetireeHealthPlanPage.clickGoBack();
    }


}
