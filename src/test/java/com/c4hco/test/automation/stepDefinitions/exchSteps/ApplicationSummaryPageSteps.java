package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class ApplicationSummaryPageSteps {

    ApplicationSummaryPage applicationSummaryPage = new ApplicationSummaryPage(WebDriverManager.getDriver());

    @Then("I select the Basic Edit link")
    public void iclickEditBasicLink() {applicationSummaryPage.clickEditBasicLink();
    }

    @Then("I select the Edit Income link")
    public void iclickEditIncomelink() {
        applicationSummaryPage.clickEditIncomelink();

    }
}
