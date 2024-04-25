package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.DocumentLookupPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class DocumentLookupPageSteps {

    DocumentLookupPage documentLookupPage = new DocumentLookupPage(WebDriverManager.getDriver());

    @And("I validate Document look Up page title is displaying on page")
    public void iValidateDocumentLookUpPageTitleIsDisplayingOnPage() {
        documentLookupPage.validateTitle();
    }

    @And("I click on Advanced search")
    public void iClickOnAdvancedSearch() {
        documentLookupPage.selectAdvancedSearch();
    }

    @When("I click on dropdown options for advanced search")
    public void iClickOnDropdownOptionsForAdvancedSearch() {
        documentLookupPage.clickdropdown();
    }

    @Then("I search with Document Handle Number")
    public void iSearchWithDocumentHandleNumber() {documentLookupPage.searchDocumentHandle();}

    @Then("I select Document Type Group dropdown options")
    public void iSelectDocumentTypeGroupDropdownOptions() {documentLookupPage.clickDropdowns();}

    @Then("I verify Admin search results table columns")
    public void iVerifyAdminSearchResultsTableColumns() {documentLookupPage.verifyAdminTableColumns();}

    @Then("I verify Document Handle search result table columns")
    public void iVerifyDocumentHandleSearchResultTableColumns() {documentLookupPage.verifycontent();}
}

