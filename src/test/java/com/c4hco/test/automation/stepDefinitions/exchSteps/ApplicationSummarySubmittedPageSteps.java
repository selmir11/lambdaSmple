package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationSummarySubmittedPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class ApplicationSummarySubmittedPageSteps {

    ApplicationSummarySubmittedPage applicationSummaryCompletedPage = new ApplicationSummarySubmittedPage(WebDriverManager.getDriver());

    @Then("I click on View Application Details")
    public void iclickEditBasicLink() {applicationSummaryCompletedPage.clickViewAppDetails();}

    @Then("I click on Download as PDF on Application Summary")
    public void iClickDownloadPdfLink() {applicationSummaryCompletedPage.clickDownloadPdfLink();}




    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    @And("I verify the OHC header on Application Summary in {string}")
    public void iVerifyOhcHeader(String language) {applicationSummaryCompletedPage.verifyOhcHeader(language);}

    @Then("I validate PDF {string} Header in {string}")
    public void iVerifyOhcPdfHeaderText(String data, String language) throws IOException {applicationSummaryCompletedPage.verifyOhcPdfHeaderText(data, language);}

}
