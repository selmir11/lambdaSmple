package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.DocumentLookupPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class DocumentLookupPageSteps {

    BasicActions basicActions = new BasicActions(WebDriverManager.getDriver());

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

    @Then("I select {string} from advanced search dropdown options")
    public void iSelectFromAdvancedSearchDropdownOptions(String text) {documentLookupPage.selectoption(text);

    }

    @Then("I select {string} from sort options")
    public void iSelectFromSortOptions(String text) {documentLookupPage.selectsortoption(text);
    }

    @Then("I click on submit button")
    public void iClickOnSubmitButton() {
        documentLookupPage.clickSubmit();
    }

    @And("I enter from and to dates")
    public void iEnterFromAndToDates() {
        documentLookupPage.inputdates();
    }

    @Then("I verify if DLT is sorted {string} by {string}")
    public void iVerifyIfDLTIsSortedBy(String ascdescoptions, String sortbyoptions) {
        documentLookupPage.verifysort(ascdescoptions,sortbyoptions);
    }
}


