package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.MyDocumentsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;


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

    @Then("I validate I am on {string} container")
    public void iValidateIAmOnContainer(String Container) {
        myDocumentsPage.ValidateIAmOnContainer(Container);
    }

    @And("I validate current year defaulted in plan Year")
    public void iValidateCurrentYearDefaultedInPlanYear() {
        myDocumentsPage.ValidateDefaultPlanYear();
    }

    @And("I select year {string} in plan year")
    public void iSelectYearInPlanYear(String selectYear) {
        myDocumentsPage.SelectPlanYeardropdown(selectYear);
    }

    @Then("I validate all uploaded documents or notices loaded for my account start with {string}")
    public void iValidateAllUploadedDocumentsOrNoticesLoadedForMyAccountStartWith(String prefix,List<String> data) {
        myDocumentsPage.iVerifyAllNoticesPresentandStartWith( prefix,data);
    }

    @And("I Click on double chevron in Past Documents and Letters Container")
    public void iClickOnDoubleChevronInPastDocumentsAndLettersContainer() {
        myDocumentsPage.clickDoubleChevron();
    }

    @Then("I validate Date Received, Time Received and Download button available")
    public void iValidateDateReceivedTimeReceivedAndDownloadButtonAvailable() {
        myDocumentsPage.iValidateDateReceivedTimeReceivedAndDownloadButtonAvailable();
    }

    @Then("I validate no document message")
    public void iValidateNoDocumentMessage(String data) {
        myDocumentsPage.validateNoDocumentMessage(data);
    }

    @Then("I validate document date shows for selected year")
    public void iValidateDocumentDateShowsForSelectedYear() {
        myDocumentsPage.validateYearForPresentNotice();
    }
    @When("I select document {string} and upload")
    public void selectAnyDocumentAndUpload(String documentName) {myDocumentsPage.selectDocumentAndUpload(documentName);}

    @Then("I see the document {string} that I choose in the Upload modal")
    public void I_see_the_document_I_choose_in_the_Upload_modal(String uploadedDocName) {myDocumentsPage.verifyUploadedDocument(uploadedDocName);}

    @When("I click on close to remove the uploaded document")
    public void I_click_on_close_to_remove_the_uploaded_document() {myDocumentsPage.clickOnCloseToRemoveDoc();}

    @Then("I verify document removed successfully")
    public void I_verify_document_removed_successfully() {myDocumentsPage.verifyDocRemoved();}

    @Then("I see the username that I am currently logged into")
    public void I_see_the_username_that_I_am_currently_logged_into() {myDocumentsPage.verifyUserNamePostUploadModalClose();}

    @And("I click on cancel button on upload document pop up")
    public void iClickOnCancelButtonOnUploadDocumentPopUp() {
        myDocumentsPage.clickCancelButton();
    }

    @And("I validate Modal texts on upload a document pop up")
    public void iValidateModalTextsOnUploadADocumentPopUp(List<String> data) {
        myDocumentsPage.textValidateOnUploadDocumentPopUp(data);
    }

    @Then("I validate font and Background color of Document popup")
    public void iValidateFontAndBackgroundColorOfDocumentPopup() {
        myDocumentsPage.validateFontAndColor();
    }

    @When("I select any type of document from dropdown")
    public void I_select_any_type_of_document_from_dropdown() {myDocumentsPage.select1stOptionFromDocType();}

    @When("I select any category of document from dropdown")
    public void I_select_any_category_of_document_from_dropdown() {myDocumentsPage.select1stOptionFromDocCategory();}

    @When("I click on upload my document button")
    public void I_click_on_upload_my_document_button() {myDocumentsPage.clickOnUploadMyDoc();}

    @Then("I validate file required error message")
    public void I_validate_file_required_error_message() {myDocumentsPage.validateFileRequiredErrMsg();}

    @Then("I validate selection required error message")
    public void I_validate_selection_required_error_message() {myDocumentsPage.validateSelectionRequiredErrMsg();}

    @Then("I validate selection required error message disappear")
    public void I_validate_selection_required_error_message_disappear() {myDocumentsPage.validateSelectionRequiredErrMsgDisappear();}

    @Then("I validate font colour height and size of selection required error")
    public void I_validate_font_colour_height_and_size_of_selection_required_error() {myDocumentsPage.validateFontSizeAndColour_errorMsgSR();}

    @Then("I validate font colour height and size of file required error")
    public void I_validate_font_colour_height_and_size_of_file_required_error() {myDocumentsPage.validateFontSizeAndColour_errorMsgFR();}

    @Then("I validate border colour of type and category dropdown")
    public void I_validate_border_colour_of_type_and_category_dropdown() {myDocumentsPage.validateBorderColourOfTypeAndCategoryDropdown_errorMsg();}

    @And("I verify the page text on the My Documents Page")
    public void iVerifyThePageTextOnTheMyDocumentsPage(List<String> data) {
        myDocumentsPage.verifyTextonDocumentPage(data);
    }
    @Then("I validate selection required error message for only document category")
    public void I_validate_selection_required_error_message_for_only_document_category() {myDocumentsPage.validateSelectionRequiredErrMsg_ForOnlyCategoryDoc();}

    @Then("I verify doc file size large error message in red")
    public void I_verify_doc_file_size_large_error_message_in_red() {myDocumentsPage.validateDocSizeLargeErrMsgAndTextColour();}

    @Then("I validate already selected file text box border is red")
    public void I_validate_already_selected_file_text_box_border_is_red() {myDocumentsPage.validateAlreadySelectedFileBoxBorderColour();}

    @Then("I verify doc unsupported error message in red")
    public void  I_verify_doc_unsupported_error_message_in_red() {myDocumentsPage.validateDocUnsupportedErrMsgAndTextColour();}

    @And("I validate Document category displayed in ascending order and {string} at end of list {string}")
    public void iValidateDocumentCategoryDisplayedInAscendingOrder(String OtherText, String language,List<String> category) {
        myDocumentsPage.ValidateDocumentCategoryinAscendingOrder(OtherText,language, category);
    }

    @Then("I validate Document Types for corresponding category list in ascending order and {string} at end of list {string}")
    public void iValidateDocumentTypesForCorrespondingCategoryListInAscendingOrderAndAtEndOfList(String OtherText, String language,  DataTable dataTable) {
        myDocumentsPage.validateDoucmentTypeInAscendingOrder(OtherText,language, dataTable);
    }
}

