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

    @And("I verify the page text on the My Documents Page in {string}")
    public void iVerifyThePageTextOnTheMyDocumentsPage(String language, List<String> data) {
        myDocumentsPage.verifyTextonDocumentPage(language,data);
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

    @When("I select All and Documents from drop down below Past Documents and Letters")
    public void I_select_All_and_Documents_from_drop_down_below_Past_Documents_and_Letters() {myDocumentsPage.selectAllAndDocumentsFromDropDown();}

    @When("I click on expand arrow for 1st document")
    public void I_click_on_expand_arrow_for_1st_document() {myDocumentsPage.clickOnExpandForFirstDocument();}


    @Then("I verify file {string} downloaded with Proper name format in {string} type")
    public void iVerifyFileDownloadedWithProperNameFormat(String NoticeName, String fileType) {
        myDocumentsPage.verifyFileNameFormat(NoticeName,fileType);
    }

    @And("I click upload MVR button if present for category {string}")
    public void iClickUploadMVRButtonIfPresentForCategory(String mvrType) {
        myDocumentsPage.iClickUploadButton(mvrType);
    }

    @And("I click Upload MVR carrot and verify default category {string} and corresponding document types")
    public void iClickUploadMVRCarrotAndVerifyDefaultCategoryAndCorrespondingDocumentTypes(String mvrType , List<String> docTyes) {
        myDocumentsPage.iVerifyDocumentCategoryAndTypes(mvrType,docTyes);
    }

    @Then("I upload MVR doc on the My Documents page and verify success message")
    public void iUploadMVRDocForOnTheMyDocumentsPageAndVerifySuccessMessage() {
        myDocumentsPage.uploadMvrDocAndSuccesMessage();
    }

    @Then("I upload another doc {string} for {string} on the My Documents page and verify success message")
    public void iUploadAnotherDocForOnTheMyDocumentsPageAndVerifySuccessMessage(String uploadDocFile,String mvrType) {
        myDocumentsPage.uploadAnotherDocWithSuccessMessage(uploadDocFile,mvrType);
    }

    @And("I click on upload another document link")
    public void iClickOnUploadAnotherDocumentLink() {
        myDocumentsPage.clickUploadAnotherDocumentlink();
    }
    @Then("I upload another doc {string} for category {string} and type {string} and verify success message")
    public void iUploadAnotherDocForCategoryAndTypeAndVerifySuccessMessage(String uploadDocFile,String mvrType,String docType) {
        myDocumentsPage.uploadAnotherDocAndVerifySuccessMessage(uploadDocFile,mvrType,docType);
    }
    @Then("I verify Document category blank by default")
    public void iVerifyDocumentCategoryBlankByDefault() {
        myDocumentsPage.verifyDefaultValueOnDocumentCategory();
    }

    @And("I verify Document category {string} is selected on modal popup")
    public void iVerifyDocumentCategoryIsSelectedOnModalPopup(String mvrType) {
        myDocumentsPage.verifyDocumentCategorySelected(mvrType);
    }

    @And("I verify Document type blank by default")
    public void iVerifyDocumentTypeBlankByDefault() {
        myDocumentsPage.verifyDefaultValueOnDocumentType();
    }

    @Then("I verify Document type {string} is selected on modal popup")
    public void iVerifyDocumentTypeIsSelectedOnModalPopup(String DocTpe) {
        myDocumentsPage.verifyDocumentTypeSelected(DocTpe);
    }

    @Then("I see the username in Exch that I am currently logged into")
    public void iSeeTheUsernameInExchThatIAmCurrentlyLoggedInto() {
        myDocumentsPage.verifyUserName();
    }

    @Then("I verify modal popup closed")
    public void iVerifyModalPopupClosed() {
        myDocumentsPage.verifyModalPopUpClosed();
    }

    @Then("I upload another doc {string} for category {string} and type {string} and verify success message {string}")
    public void iUploadAnotherDocForCategoryAndTypeAndVerifySuccessMessageSpanish(String uploadDocFile,String mvrType,String docType,String language) {
        myDocumentsPage.uploadAnotherDocAndVerifyMessageSpanish(uploadDocFile,mvrType,docType,language);
    }

    @And("I click on the help drawer icon on the document page")
    public void iClickOnTheHelpDrawerIconOnTheDocumentPage() {
        myDocumentsPage.clickHelpDrawerToOpen();
    }

    @Then("I validate help drawer open in right side of the page")
    public void iValidateHelpDrawerOpenInRightSideOfThePage() {
        myDocumentsPage.validateHelpDrawerOpened();
    }

    @And("I verify help drawer {string} text on the My Document page")
    public void iVerifyHelpDrawerSubHeaderTextOnTheMyDocumentPage(String contentOn, List<String> data) {
        myDocumentsPage.verifyHelpDrawerContent(contentOn, data);
    }

    @And("I click on the help drawer icon to close on the document page")
    public void iClickOnTheHelpDrawerIconToCloseOnTheDocumentPage() {
        myDocumentsPage.clickHelpDrawerToClose();
    }

    @Then("I validate help drawer closed on the document page")
    public void iValidateHelpDrawerClosedOnTheDocumentPage() {
        myDocumentsPage.validateHelpDrawerClosed();
    }
    @And("I click on {string} link in Help Drawer")
    public void iClickOnLinkInHelpDrawer(String linkName) {
        myDocumentsPage.clickLinkForHelp(linkName);
    }

    @And("I click upload MVR button for {string}")
    public void iClickUploadMVRButtonFor(String mvrType) {
        myDocumentsPage.clickUploadMvr(mvrType);
    }

    @And("I verify Document header on my document page")
    public void iVerifyDocumentHeaderOnMyDocumentPage(String data) {
        myDocumentsPage.verifyDocumentHeaderOnMyDocument(data);
    }

    @Then("I verify Sub header on my document page")
    public void iVerifySubHeaderOnMyDocumentPage(String data) {
        myDocumentsPage.verifySubHeaderOnMyDocumentPage(data);

    }

    @Then("I verify container header for information we need")
    public void iVerifyContainerHeaderForInformationWeNeed(String data) {
        myDocumentsPage.verifyContaineNameForInfoWeNeed(data);
    }

    @And("I verify MVR name on the information we need container in {string}")
    public void iVerifyMVRNameAreCorrect(String language) {
        myDocumentsPage.verifyMvrNames(language);
    }

    @Then("I Verify due date are displaying in proper color")
    public void iVerifyDueDateAreDisplayingInProperColor() {
        myDocumentsPage.verifyDueDateColor();
    }

    @Then("I verify member name in MVR type")
    public void iVerifyMemberNameInMVRType(DataTable datatable) {
        myDocumentsPage.verifyMemberName(datatable);
    }

    @Then("I verify mvr type with date, member name and upload button")
    public void iVerifyMvrTypeWithDateHouseHolderNameAndUploadButton() {
        myDocumentsPage.verifyMvrTypesWithTextandButtons();
    }

    @Then("I verify Upload button on the right")
    public void iVerifyUploadButtonOnTheRight() {
        myDocumentsPage.verifyUploadBtnForMrv();
    }

    @And("I verify no document on new account")
    public void iVerifyNoDocumentOnNewAccount(String data) {
        myDocumentsPage.verifyNoDocumentMessage(data);
    }

    @Then("I validate file required error message on modal popup")
    public void iValidateFileRequiredErrorMessageOnModalPopup(String data) {
        myDocumentsPage.validateFileRequiredErrorMessage(data);
    }

    @Then("I validate selection required error message on modal popup")
    public void iValidateSelectionRequiredErrorMessageOnModalPopup(String data) {
        myDocumentsPage.validateSelectionRequiredErrorMessage(data);
    }

    @When("I click on upload documents button in modal popup")
    public void iClickOnUploadDocumentsButtonInModalPopup() {
        myDocumentsPage.clickUploadButton();
    }

    @Then("I validate border colour of category dropdown")
    public void iValidateBorderColourOfCategoryDropdown() {
        myDocumentsPage.validateBorderColorofErrorCategory();
    }

    @Then("I validate selection required error message for only document category on modal popup")
    public void iValidateSelectionRequiredErrorMessageForOnlyDocumentCategoryOnModalPopup(String data) {
        myDocumentsPage.validateSelectionRequiredErrorMessage_ForOnlyCategoryDoc(data);
    }

    @Then("I verify unsupported document error message with red in color")
    public void iVerifyUnsupportedDocumentErrorMessageWithRedInColor(String data) {
        myDocumentsPage.validateDocUnsupportedErrorAndTextColour(data);
    }

    @When("I select any category of document from dropdown in spanish")
    public void iSelectAnyCategoryOfDocumentFromDropdownInSpanish() {
        myDocumentsPage.select1stOptionFromDocTypeSpanish();
    }

    @Then("I verify doc file size large error message in red in Spanish")
    public void iVerifyDocFileSizeLargeErrorMessageInRedOnModelPopup() {
        myDocumentsPage.validateDocSizeLargeErrMsgAndTextColourSpanish();
    }

    @Then("I upload MVR doc for {string} on the My Documents page in {string}")
    public void iUploadMVRDocForOnTheMyDocumentsPageIn(String mvrType, String language) {
        myDocumentsPage.uploadMvrDocAndSuccesMessage(mvrType,language);
    }

    @Then("I upload another doc {string} for {string} on the My Documents page and verify success message in {string}")
    public void iUploadAnotherDocForOnTheMyDocumentsPageAndVerifySuccessMessageIn(String fileName, String mvrType, String language) {
        myDocumentsPage.uploadAnotherDocAndSuccessMessage(fileName,mvrType,language);
    }

    @Then("I validate help drawer open in right side of the page for {string} mvr")
    public void iValidateHelpDrawerOpenInRightSideOfThePageForMvr(String mvrType) {
        myDocumentsPage.validateHelpDrawerOpenedForMvr(mvrType);
    }

    @Then("I select {string} from document and letter dropdown")
    public void iSelectFromDocumentAndLetterDropdown(String data) {
        myDocumentsPage.selectDocumentAndLetter(data);
    }

    @And("I verify plan year label {string}")
    public void iVerifyPlanYearLabel(String planYearLabel) {
        myDocumentsPage.verifyPlanYearLabel(planYearLabel);
    }

    @And("I validate default value in Documents and letters dropdown in {string}")
    public void iValidateDefaultValueInDocumentsAndLettersDropdownIn(String language) {
        myDocumentsPage.defaultDocumentLetterValue(language);
    }

    @Then("I verify Go back to welcome page button")
    public void iVerifyGoBackToWelcomePageButtonIn(String data) {
        myDocumentsPage.verifyGoBackToWelcomePageButton(data);
    }

    @Then("I validate Date Received, Time Received and Download button available in {string}")
    public void iValidateDateReceivedTimeReceivedAndDownloadButtonAvailableIn(String language) {
        myDocumentsPage.verifyDateTimeDownloadButton(language);
    }

    @Then("I validate help drawer open in right side of the page in Spanish")
    public void iValidateHelpDrawerOpenInRightSideOfThePageInSpanish() {
        myDocumentsPage.validateHelpDrawerOpenedSpanish();
    }

    @And("I click upload MVR button for {string} in {string}")
    public void iClickUploadMVRButtonForInSpanish(String mvrType, String language) {
        myDocumentsPage.clickUploadMvr(mvrType,language);
    }

    @And("I verify I receive access denied message")
    public void iVerifyIReceiveAccessDeniedMessage() {
        myDocumentsPage.verifyAccessDenied();
    }

    @Then("I navigate to {string} url for qa and {string} for staging")
    public void iNavigateToUrlForQaAndForStaging(String qaurl, String stageurl) {
        myDocumentsPage.navigateToUrl(qaurl,stageurl);
    }

    @Then("I select {string} from the document type dropdown")
    public void iSelectFromTheDocumentTypeDropdown(String documentToSelect) {
        myDocumentsPage.selectTypeofDocument(documentToSelect);
    }

    @Then("I select {string} from the document category type dropdown")
    public void iselectTypeofDocument(String categoryToSelect) {
        myDocumentsPage.selectDocumenttypeCategory(categoryToSelect);
    }

    @Then("I verify file downloaded is {string} and it is not empty")
    public void iVerifyFileDownloadedIsAndItIsNotEmpty(String fileNamePrefix) {
        myDocumentsPage.verifyFileExistAndNotEmpty(fileNamePrefix);
    }

    @Then("I click on what type of document is this dropdown and verify the following categories")
    public void iClickOnDropdownAndVerifyTheMentionedDocumentCategories(List<String> categories) {
        myDocumentsPage.clickOnDropdownAndVerifyTheMentionedDocumentCategories(categories);
    }
    @And("I verify message You don't need to upload any documents at this time displays")
    public void iVerifyNoDocumentsNeeded() {
        myDocumentsPage.verifyNoDocumentsNeeded();
    }
}

