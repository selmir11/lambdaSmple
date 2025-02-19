package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationSummarySubmittedPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApplicationSummarySubmittedPageSteps {

    ApplicationSummarySubmittedPage applicationSummaryCompletedPage = new ApplicationSummarySubmittedPage(WebDriverManager.getDriver());

    @Then("I click on View Application Details")
    public void iclickEditBasicLink() {applicationSummaryCompletedPage.clickViewAppDetails();}

    @Then("I click on Download as PDF on Application Summary")
    public void iClickDownloadPdfLink() {applicationSummaryCompletedPage.clickDownloadPdfLink();}

    @Then("I click on Other Health Coverage on Application Summary")
    public void iClickOtherHealthCoverage() {applicationSummaryCompletedPage.clickOtherHealthCoverage();}

    @Then("I click on back button on Application summary submitted page")
    public void iclickBackButton() {applicationSummaryCompletedPage.clickBackButton();}


    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    @And("I verify the OHC header on Application Summary in {string}")
    public void iVerifyOhcHeader(String language) {applicationSummaryCompletedPage.verifyOhcHeader(language);}

    @Then("I validate PDF {string} Header in {string}")
    public void iVerifyOhcPdfHeaderText(String data, String language) throws IOException {applicationSummaryCompletedPage.verifyOhcPdfHeaderText(data, language);}

    @And("I verify the OHC detail on Application Summary in {string}")
    public void iVerifyOhcDetails(String language, List<Map<String, String>> ohcData) {applicationSummaryCompletedPage.verifyOhcDetails(language, ohcData);}

    @And("I verify the Medicare OHC detail on Application Summary in {string}")
    public void iVerifyMedicareDetails(String language, List<Map<String, String>> ohcData) {applicationSummaryCompletedPage.verifyMedicareDetails(language, ohcData);}

    @Then("I validate PDF Family OHC on Application Summary in {string}")
    public void iVerifyOhcPdfFamilyText(String language, List<Map<String, String>> pdfData) throws IOException {applicationSummaryCompletedPage.verifyOhcFamilyPdfText(language, pdfData);}

    @Then("I validate PDF OHC data on Application Summary in {string}")
    public void iVerifyBasicOhcPdfText(String language, List<Map<String, String>> pdfData) throws IOException {applicationSummaryCompletedPage.verifyBasicOhcPdfText(language, pdfData);}

    @Then("I validate PDF Medicare OHC data on Application Summary in {string}")
    public void iVerifyMedicareOhcPdfText(String language, List<Map<String, String>> pdfData) throws IOException {applicationSummaryCompletedPage.verifyMedicareOhcPdfText(language, pdfData);}

}
