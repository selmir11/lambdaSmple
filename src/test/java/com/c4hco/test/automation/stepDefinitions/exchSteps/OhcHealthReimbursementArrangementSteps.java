package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcHealthReimbursementArrangementPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OhcHealthReimbursementArrangementSteps {
    OhcHealthReimbursementArrangementPage OhcHealthReimbursementArrangementPage = new OhcHealthReimbursementArrangementPage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the HRA page")
    public void iClickGoBack(){OhcHealthReimbursementArrangementPage.clickGoBack();
    }

}
