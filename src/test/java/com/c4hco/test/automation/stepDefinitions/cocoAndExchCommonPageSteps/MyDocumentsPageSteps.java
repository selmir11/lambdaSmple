package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.MyDocumentsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;
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
    @And("I click on download enrolment document")
    public void iClickOnEnrolmentDocumentTodownload(){
        myDocumentsPage.downloadEnrolmentDocument();
    }

    @And("I click on download {string} document")
    public void iDownloadDocument(String docType) throws AWTException, JSchException {
        myDocumentsPage.downloadDocument(docType);
    }

    @Then("I validate {string} notice")
    public void iValidateNotice(String expectedText) throws IOException {
        myDocumentsPage.verifyPDFText(expectedText);
    }
}
