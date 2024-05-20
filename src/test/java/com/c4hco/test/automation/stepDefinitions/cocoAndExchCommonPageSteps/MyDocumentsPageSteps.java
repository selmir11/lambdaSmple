package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.MyDocumentsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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
}
