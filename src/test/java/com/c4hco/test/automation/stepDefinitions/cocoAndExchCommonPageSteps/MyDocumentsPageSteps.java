package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.MyDocumentsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class MyDocumentsPageSteps {


MyDocumentsPage myDocumentsPage = new MyDocumentsPage(WebDriverManager.getDriver());
    @Then("I click link my docs on accountOverview page")
    public void iClickLinkMyDocsOnAccountOverviewPage(){
        myDocumentsPage.ClickLinkMyDocsWelcomePage();
    }

    @And("I verify the page text in {string} on the My Documents Page")
    public void iVerifyPageText(String language){myDocumentsPage.verifyPageText(language);}

    @Then("I validate the notice {string} exist in my document letter Containers")
    public void iValidateTheNoticeExistInMyDocumentLetter(String documentName) {
        myDocumentsPage.validateTheNoticeExistInMyDocumentLetterPage(documentName);
    }

    @Then("I validate Welcome back button navigates to welcome page")
    public void iValidateWelcomeBackButtonNavigatesToWelcomePage() {
        myDocumentsPage.goBackToWelcomePage();
    }

    @And("I click on download {string} document")
    public void iDownloadDocument(String docType) {
        myDocumentsPage.downloadDocument(docType);
    }

    @Then("I validate {string} notice content")
    public void validateNotice(String docType) throws IOException {
        myDocumentsPage.validateNoticeText(docType);
    }

    @Then("I validate {string}: {string} notice in {string} for {string} members")
    public void iValidateNotice(String expectedText, String docType, String language, String memberNumber) throws IOException {
        myDocumentsPage.verifyPDFText(expectedText, docType, language, memberNumber);
    }

    @And("I click on upload another document")
    public void iClickOnUploadAnotherDocument() {
        myDocumentsPage.clickUploadAnotherDocument();
    }

    @And("I validate Modal texts on upload document pop up")
    public void iValidateModalTextsOnUploadDocumentPopUp() {
        myDocumentsPage.textValidate();
    }

    @And("I close button to close modal")
    public void iCloseButtonToCloseModal() {
        myDocumentsPage.closemodal();
    }

    @And("I validate upload another document modal texts in spanish")
    public void iValidateUploadAnotherDocumentModalTextsInSpanish() {
        myDocumentsPage.spanishModalText();
    }

    @And("I click on upload another document in spanish")
    public void iClickOnUploadAnotherDocumentInSpanish() {
        myDocumentsPage.clickuploaddocSpanish();
    }

    @And("I verify user can select each type from type dropdown")
    public void iVerifyUserCanSelectEachTypeFromTypeDropdown() {myDocumentsPage.selectType();}

    @Then("I upload MVR doc for {string} on the My Documents page")
    public void iUploadMvrDoc(String mvrType) {myDocumentsPage.uploadMvrDoc(mvrType);}

    @And("I verify {string} MRV needed on the My Documents page")
    public void iVerifyMvrNeeded(String mvrType) {myDocumentsPage.verifyMvrNeeded(mvrType);}

    @And("I click on verify Financial Help for Eligibility button is displaying for user")
    public void iClickOnVerifyFinancialHelpForEligibilityButtonIsDisplayingForUser() {
        myDocumentsPage.clickFinancialHelpEligibilltybutton();
    }
}
