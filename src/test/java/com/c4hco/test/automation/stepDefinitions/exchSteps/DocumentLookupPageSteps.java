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

    @Then("I select all dropdown options")
    public void iSelectAllDropdownOptions() {
       documentLookupPage.clickDropdowns();
    }

    @Then("I search with Document Handle Number")
    public void iSearchWithDocumentHandleNumber() {
        documentLookupPage.searchDocumentHandle();
    }

    @Then("I verify Admin Table columns")
    public void iVerifyAdminTableColumns() {
        documentLookupPage.verifyAdminTableColumns();
    }

    @Then("I verify Document Handle search columns")
    public void iVerifyDocumentHandleSearchColumns() {
        documentLookupPage.verifycontent();
    }
}
