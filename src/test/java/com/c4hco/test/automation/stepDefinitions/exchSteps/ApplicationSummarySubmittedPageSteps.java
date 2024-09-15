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

    @Then("I click on Other Health Coverage on Application Summary")
    public void iClickOtherHealthCoverage() {applicationSummaryCompletedPage.clickOtherHealthCoverage();}




    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    @And("I verify the OHC header on Application Summary in {string}")
    public void iVerifyOhcHeader(String language) {applicationSummaryCompletedPage.verifyOhcHeader(language);}

    @Then("I validate PDF {string} Header in {string}")
    public void iVerifyOhcPdfHeaderText(String data, String language) throws IOException {applicationSummaryCompletedPage.verifyOhcPdfHeaderText(data, language);}

    @And("I verify the OHC detail on Application Summary {string} with data of {string} in {string}")
    public void iVerifyOhcDetails(String detail, String data, String language) {applicationSummaryCompletedPage.verifyOhcDetails(detail, data, language);}

    @Then("I validate PDF OHC on Application Summary with data {string} in {string} for {string} with Currently enrolled {string} end date of {string}")
    public void iVerifyOhcPdfText(String data, String language, String ohcType, String enrolled, String endDate) throws IOException {applicationSummaryCompletedPage.verifyOhcPdfText(data, language, ohcType, enrolled, endDate);}

    @Then("I validate PDF Family OHC on Application Summary with data {string} in {string} for {string} with Currently enrolled {string} end date of {string}")
    public void iVerifyOhcPdfFamilyText(String data, String language, String ohcType, String enrolled, String endDate) throws IOException {applicationSummaryCompletedPage.verifyOhcFamilyPdfText(data, language, ohcType, enrolled, endDate);}

}
