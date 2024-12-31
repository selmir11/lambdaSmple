package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationDetailsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.io.IOException;
import java.util.Map;

public class ApplicationDetailsPageSteps {

    ApplicationDetailsPage applicationDetailsPage = new ApplicationDetailsPage(WebDriverManager.getDriver());

    @Then("I click on Show Changes on Application Details")
    public void iClickEditBasicLink() {applicationDetailsPage.clickViewAppDetails();}

    @Then("I click on {string} on Application Details")
    public void iClickHeader(String header) {applicationDetailsPage.clickHeader(header);}

    @Then("I click on Download as PDF on Application Details")
    public void iClickDownloadPdfLink() {applicationDetailsPage.clickDownloadPdfLink();}




    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    @And("I verify the OHC header highlight {string} on Application Details")
    public void iVerifyOhcHeaderColor(String highlight) {applicationDetailsPage.verifyOhcHeaderColor(highlight);}

    @And("I verify the OHC detail {string} highlight {string} on Application Details with data of {string}")
    public void iVerifyOhcDetailsColor(String detail, String highlight, String data) {applicationDetailsPage.verifyOhcDetailsColor(detail, highlight, data);}

    @And("I verify the basic OHC detail on Application Details")
    public void iVerifyBasicOhcDetailsColor(List<Map<String, String>> ohcData) {applicationDetailsPage.verifyBasicOhcDetailsColor(ohcData);}

    @Then("I validate PDF OHC data {string} in {string} with Min Value {string} Premium {string} Currently enrolled {string} {string} {string} end date of {string} {string} {string}")
    public void iVerifyOhcPdfText(String data, String language, String minValue, String premium, String enrolled, String insruanceEnding, String ending, String lastSet, String endDate, String voluntarily) throws IOException {applicationDetailsPage.verifyOhcPdfText(data, language, minValue,  premium, enrolled, insruanceEnding, ending, lastSet, endDate, voluntarily);}

    @Then("I verify the OHC detail family enrollment details on Application Details")
    public void iVerifyOhcFamilyDetailsColor(DataTable familyOptionTable) {List<String> familyOption = familyOptionTable.asList(String.class);applicationDetailsPage.verifyOhcFamilyDetailsColor(familyOption);}

    @Then("I verify PDF OHC data for family with Family offered {string} and Premium {string}")
    public void iVerifyOhcPdfFamilyText(String offered, String premium, DataTable familyOptionTable) throws IOException {List<String> familyOption = familyOptionTable.asList(String.class);applicationDetailsPage.verifyOhcPdfFamilyText(offered, premium, familyOption);}

    @Then("I validate basic PDF OHC data on Application Details in {string}")
    public void iVerifyBasicOhcPdfText(String language, List<Map<String, String>> pdfData) throws IOException {applicationDetailsPage.verifyBasicOhcPdfText(language, pdfData);}



}
