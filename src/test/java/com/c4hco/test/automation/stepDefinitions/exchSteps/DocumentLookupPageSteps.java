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

    @Then("I verify Admin search results table columns")
    public void iVerifyAdminSearchResultsTableColumns() {documentLookupPage.verifyAdminTableColumns();}

    @Then("I verify Document Handle search result table columns")
    public void iVerifyDocumentHandleSearchResultTableColumns() {documentLookupPage.verifycontent();}

    @Then("I select {string} from advanced search dropdown options")
    public void iSelectFromAdvancedSearchDropdownOptions(String text) {documentLookupPage.selectoption(text);}

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

    @Then("I validate if I can select and unselect all checkboxes and verify their text")
    public void iValidateIfICanSelectAndUnselectAllCheckboxesAndVerifyTheirText() {documentLookupPage.clickDropdowns();}

    @Then("I verify advance search criteria from DLT page")
    public void iVerifyAdvanceSearchCriteriaFromDLTPage() { documentLookupPage.verifyAdminSearchcriteria();}

    @And("I verify error message for Advanced search on DLT page")
    public void iVerifyErrorMessageForAdvancedSearchOnDLTPage() {documentLookupPage.verifyDocumentTyperequireerror();
    }


    @Then("I validate dropdown entries are displaying based on selection")
    public void iValidateDropdownEntriesAreDisplayingBasedOnSelection() {
        documentLookupPage.verifyDocumentTyperequireerror();}

    @Then("I validate Default entry selection is twenty entries")
    public void iValidateDefaultEntrySelectionIsTwentyEntries(){
        documentLookupPage.validateDropdownEntries();
    }

    @Then("I validate next button and previous button functionality")
    public void iValidateNextButtonFunctionality(){
        documentLookupPage.validateNextAndPreviousButtons();
    }

    @Then("I select dropdown entry option and validate {int} rows are displaying")
    public void iSelectDropdownEntryOptionAndValidateRowsAreDisplaying(int rowsUI) {
        documentLookupPage.entriesdropdown(rowsUI);
    }

    @Then("I verify Delete button is displaying on document lookup page")
    public void iVerifyDeleteButtonIsDisplayingOnDocumentLookupPage() {
        documentLookupPage.verifyDeleteButtondisplays();
    }

    @Then("I click on Delete button on document lookup page")
    public void iClickOnDeleteButtonOnDocumentLookupPage() {
        documentLookupPage.clickDeleteButton();
    }

    @Then("I click on No Go Back button on document lookup page")
    public void iClickOnNoGoBackButtonOnDocumentLookupPage() {
        documentLookupPage.clickNoGoBackButton();
    }

    @And("I verify document is not deleted")
    public void iVerifyDocumentIsNotDeleted() {
     documentLookupPage.verifyDeleteButtonNotDisplay();
    }

    @And("I verify Document is deleted from document loopup page")
    public void iVerifyDocumentIsDeletedFromDocumentLoopupPage() {
        documentLookupPage.verifyDeleteButtonNotDisplay();
    }

    @And("I enter the account number")
    public void iEnterTheAccountNumber() {
        documentLookupPage.enterAccountNumber();
    }

    @And("I click on yes delete button from confirmation modal")
    public void iClickOnYesDeleteButtonFromConfirmationModal() {
        documentLookupPage.clickYesDeleteButton();
    }
}



