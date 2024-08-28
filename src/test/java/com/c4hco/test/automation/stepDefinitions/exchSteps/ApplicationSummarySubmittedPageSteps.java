package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationSummarySubmittedPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class ApplicationSummarySubmittedPageSteps {

    ApplicationSummarySubmittedPage applicationSummaryCompletedPage = new ApplicationSummarySubmittedPage(WebDriverManager.getDriver());

    @Then("I click on View Application Details")
    public void iclickEditBasicLink() {applicationSummaryCompletedPage.clickViewAppDetails();}

}
