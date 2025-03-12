package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.EligNotices;
import com.c4hco.test.automation.utils.PDF;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import lombok.SneakyThrows;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.time.Year;
import java.util.*;



public class MyDocumentsPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage(WebDriverManager.getDriver());
    PDF pdf = new PDF(WebDriverManager.getDriver());

    public MyDocumentsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindAll({
            @FindBy(css = ".primary-header-container > h2"), // Staging
            @FindBy(xpath = "//div[contains(@class, 'header-1')]") // QA EAVS
    })
    WebElement myDocumentsTitle;

    @FindBy(css = ".document-content-select-double-chevrons-container")
    WebElement mvrDoubleChevrons;

    @FindBy(css = ".documents-notices-title.header-2")
    WebElement myDocumentsSubTitle;

    @FindBy(css = ".documents-notices-content-container > div")
    WebElement documentsInfoMessage;

    @FindBy(xpath = "//button[normalize-space()='Go back to Welcome page']")
    WebElement goBackWelcomePage;
    @FindBy(xpath = "(//div[@class='document-notice-name-right']//span)[1]")
    WebElement expandDownloadEnrolmentDocument;
    @FindBy(css = "a.btn-second-action-button.download-button")
    WebElement downloadEnrolmentDoc;

    @FindBy(xpath = "//a[normalize-space()='Upload another document']")
    WebElement uploadAnotherDocument;

    @FindBy(xpath = "//div[@class='drop-down-options']//div")
    List<WebElement> categoryList;

    @FindBy(xpath = "(//div[@class='drop-down-option drop-down-option-selected'])[3]")
    WebElement docTypeDrpDwn;

    @FindBy(xpath = "(//div[@class='drop-down-option drop-down-option-selected'])[4]")
    WebElement docCategoryDrpDwn;

    @FindBy(xpath = "//span[@id='mvrActionButtonTitle_0']")
    WebElement verifyFinancialHelpEligbilityButton;

    //English modal text

    @FindBy(xpath = "//p[@class='modal-title']")
    WebElement txtUploadADocument;

    @FindBy(xpath = "//span[normalize-space()='Tell us more about this document']")
    WebElement txtTellUs;

    @FindBy(xpath = "//span[normalize-space()='What type of document is this?']")
    WebElement txtWhatType;

    @FindBy(xpath = "//span[normalize-space()='Which document are you submitting?']")
    WebElement txtWhichDocument;

    @FindBy(xpath = "//span[normalize-space()='Select a file from your device']")
    WebElement txtSelectAfile;

    @FindBy(xpath = "//label[normalize-space()='Browse My Files']")
    WebElement browseFiles;

    @FindBy(xpath = "//span[contains(text(),'Only one document can be uploaded at a time using ')]")
    WebElement txtOneDocument;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[normalize-space()='Upload My Document']")
    WebElement uploadMyDocument;

    @FindBy(xpath = "//span[@class='btn-close-x']")
    WebElement closeButton;

    //SPANISH modal text
    @FindBy(xpath = "//a[normalize-space()='Cargar otro documento']")
    WebElement btnCargarotrodocumento;

    @FindBy(xpath = "//a[normalize-space()='Cargar otro documento']")
    WebElement txtCargarUnDocumento;

    @FindBy(xpath = "//span[normalize-space()='Díganos m\u00E1s sobre este documento']")
    WebElement txtDiagnoMasSobre;

    @FindBy(xpath = "//span[normalize-space()='¿Qu\u00E9 tipo de documento es este?']")
    WebElement txtQuetipo;

    @FindBy(xpath = "//span[normalize-space()='¿Qu\u00E9 documento está enviando?']")
    WebElement txtQueDocumento;

    @FindBy(xpath = "//span[normalize-space()='Seleccione un archivo de su dispositivo']")
    WebElement txtSeleccioneUnArchivo;

    @FindBy(xpath = "//label[normalize-space()='Explorar Mis Archivos']")
    WebElement btnExplorarMisArchivos;

    @FindBy(xpath = "//span[contains(text(),'Solo se puede cargar un documento a la vez usando ')]")
    WebElement txtSolosepuedecargarundocumento;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    WebElement btnCancelarOnPopup;

    @FindBy(xpath = "//button[normalize-space()='Cargar Mi Documento']")
    WebElement btnCargarMisDocumento;

    //    modal options
    @FindBy(css = ".doc-subtype-select .drop-down-option.drop-down-option-selected")
    WebElement dpdWhichDocument;

    @FindBy(css = ".doc-subtype-select .drop-down-options > div")
    List<WebElement> dpdWhichDocumentOptions;

    @FindBy(css = ".file-selected-show.file-border-normal")
    WebElement txtFileUpload;

    @FindBy(css = ".error-box > p")
    WebElement txtUploadError;

    @FindBy(css = ".btn-upload.btn-primary-action-button")
    WebElement btnUploadDoc;

    @FindBy(xpath = "//*[@class='drop-down-option drop-down-option-selected']")
    List<WebElement> PlanYearDropDown;

    @FindBy(xpath = "//*[@class='drop-down-options']//span")
    List<WebElement> PlanYearValues;

    @FindBy(xpath = "//*[@class='documents-notices-content-container']")
    WebElement DocumentsNoticesList;

    @FindBy(xpath="//*[@class='document-notice-name-left body-text-1']")
    List<WebElement> DocumentsNoticesLists;

    @FindBy(xpath="//div[@class='document-notice-select-double-chevrons-container']/span")
    WebElement doubleChevrons;

    @FindBy(xpath = "//div[@class='document-notice-name-right']/span")
    List<WebElement>  SingleChevrons;

    @FindBy(xpath = "//div[contains(text(), 'Date Received')]")
    List<WebElement> dateReceived;

    @FindBy(xpath = "//div[contains(text(), 'Time Received')]")
    List<WebElement> timeReceived;

    @FindBy(css = "div.document-notice-expanded-left.body-text-1")
    List<WebElement> datetime;

    @FindBy(xpath = "//a[contains(text(), 'Download')]")
    List<WebElement> download;

    @FindBy(xpath="//*[text()='Select a file from your device']/following::*[@aria-label='Close']")
    WebElement btn_documentClose;

    @FindBy(xpath = "//a[contains(@href,'UserProfile')]")
    WebElement textUserName;

    @FindBy(xpath = "//*[@class='btn-cancel btn-second-action-button']")
    WebElement btncancel;

    @FindBy(xpath = "//span[@class='center header-3']")
    List<WebElement> txtHeaderTellUs;

    @FindBy(xpath = "//*[@class='doc-type-label body-text-1']/span")
    List<WebElement> txtWhatTypequestion;

    @FindBy(xpath = "//*[@class='label-browse-my-files btn-second-action-button']")
    WebElement browseFilesbtn;

    @FindBy(xpath = "//*[@class='uploadonlyonefile-guide body-text-1']/span")
    WebElement onlyOneDocumentTxt;

    @FindBy(xpath = "//*[@class='btns-container']/button")
    List<WebElement> btnContainertxt;

    @FindBy(xpath = "//*[@class='modal-header-container']")
    WebElement UploadPopupHeadercolor;

    @FindBy(xpath = "//*[@class='group-title-box']")
    List<WebElement> titleBackgroundrcolor;

    @FindBy(xpath = "//*[@class='modal-body group-box']")
    WebElement PopupContentBodyColor;

    @FindBy(xpath = "//div[@class='btns-container']")
    WebElement PopupFooterBackGroundColor;

    @FindBy(xpath = "(//*[@class='drop-down-options']/div/span)[1]")
    WebElement typeDrpDwn1stOption;

    @FindBy(xpath = "//*[text()='Correction Proof']")
    WebElement categoryDrpDwn1stOption;

    @FindBy(xpath = "//*[@class='error ng-star-inserted']")
    WebElement textErrorMsg_Filerequired;

    @FindBy(xpath = "//*[@class='error']")
    List<WebElement> textErrorMsg_selectionRequired;

    @FindBy(xpath = "//div[@class='doc-type-select drop-down-error']")
    WebElement redBorder_typeDrpDwnError;

    @FindBy(xpath = "//div[@class='doc-subtype-select drop-down-error']")
    WebElement redBorder_categoryDrpDwnError;

    @FindBy(xpath = "//h3[@class='we-need-doc body-text-1']")
    WebElement weNeedDocText;

    @FindBy(xpath = "//a[@class='link-text-1 clickable']")
    List<WebElement> helpMeToUnderstandText;

    @FindBy(id= "documentsUploadTitle")
    WebElement informationText;

    @FindBy(id= "uploadAnother")
    WebElement UploadDocumentText;

    @FindBy(xpath = "//p[@class='error ng-star-inserted']")
    WebElement textErrorMsg_docFileSizeLarge;

    @FindBy(xpath = "//*[@class='file-selected-show file-border-red']")
    WebElement textBox_fileAlreadySelected;

    @FindBy(xpath = "//div[@class='error-box ng-star-inserted']//*[name()='svg' and @role='img']")
    WebElement img_errorMsg_docFileSizeLarge;

    @FindBy(xpath = "//*[@class='drop-down-option drop-down-option-selected']")
    List<WebElement> drpDwn_Arrows_pastDocAndLetters;

    @FindBy(xpath = "//*[@class='drop-down-option ng-star-inserted']")
    List<WebElement> drpDwn_pastDocAndLetters;

    @FindBy(xpath = "(//*[name()='svg' and @data-icon='angle-down'])[3]")
    WebElement expandArrow_forFirstDoc;

    @FindBy(xpath = "//a[text()='Download']")
    WebElement btn_download;

    @FindBy(xpath = "//*[@class='toast fade ng-star-inserted show']")
    WebElement txtUploadSuccess;

    @FindBy(id = "documentsUploadMessage")
    WebElement noNeedToUpload;

    @FindBy(css = ".drawer-controls > div")
    WebElement helpDrawerOpen;

    @FindBy(xpath = "//div[contains(@class,'drawer-contents')]")
    WebElement helpDrawerContent;

    @FindBy(css = ".drawer-controls > div > div > a > svg")
    WebElement helpCloseSide;

    @FindBy(css = ".drawer-heading .body-text-1")
    WebElement helpDrawerHeaderText;

    @FindBy(css = ".drawer-footer > h3")
    WebElement helpDrawerNeedMoreHelp;

    @FindBy(css = ".drawer-heading .drawer-title")
    WebElement helpDrawerSubHeaderText;

    @FindBy(css = "div.drawer-text-content.body-text-1 > b")
    WebElement helpDrawerBodyHeaderText;

    @FindBy(css = "div.drawer-text-content.body-text-1 > p")
    List<WebElement> helpDrawerBodyContent;

    @FindBy(xpath = "//a[text() ='here']")
    WebElement helpDrawerHereLink;

    @FindBy(xpath = "//a[text() ='our website.']")
    WebElement helpDrawerOurWebsiteLink;

    @FindBy(xpath = "//a[text() ='Contact us']")
    WebElement helpDrawerContactUsLink;

    @FindBy(xpath = "//*[contains(@class,'header-1')]")
    WebElement myDocumentHeaderTxt;

    @FindBy(xpath = " //*[contains(@class,'header-1')]/following::div[1]")
    WebElement myDocumentSubtitleTxt;

    @FindBy(xpath = "//*[contains(text(),'Necesitamos más información para confirmar')]")
    WebElement myDocumentSubtitleTxtSpanish;

    @FindBy(xpath = "//*[contains(@class,'documents-content-row row')]")
    List<WebElement> mvrContainer;

    @FindBy(xpath = "//*[contains(@class,'documents-content-row row')]/div[1]")
    List<WebElement> mvrTypes;

    @FindBy(xpath = "//*[contains(@class,'documents-content-row row')]/div[1]/div/p/span")
    List<WebElement> mvrDueDate;

    @FindBy(xpath = "//*[contains(@class,'documents-content-row row')]/div[2]/div[1]")
    List<WebElement> houseHolderNames;

    @FindBy(xpath = "//*[contains(@class,'documents-content-row row')]/div/div[2]")
    List<WebElement> mvrUploadButton;

    @FindBy(xpath = "//*[contains(text(),'Comprobante de encarcelamiento')]")
    WebElement documentType1stValueSpanish;

    @FindBy(xpath = "//p[@class='error ng-star-inserted']//*[name()='svg']")
    WebElement ErrorSvgSymbol;

    @FindBy(xpath = "//*[@class='error']//*[name()='svg']")
    List<WebElement> SelectionRequiredErrorSvgSymbol;


    public void ClickLinkMyDocsWelcomePage() {
        basicActions.switchToParentPage("accountOverview");
        accountOverviewPage.clickHereLinks("My Documents");
    }

    public void downloadDocument(String docType) {
        // docType example "Application Results", EN-002-04
        basicActions.waitForElementToBePresent(expandDownloadEnrolmentDocument, 20);
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 20);
        basicActions.scrollToElement(expandDownloadEnrolmentDocument);
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 10);
        WebElement pastDocCarrot = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + docType + "')]/p//following::span[1]"));
        pastDocCarrot.click();
        WebElement downloadButton = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + docType + "')]/p//following::a[1]"));
        downloadButton.click();
        basicActions.waitForDownloadToComplete(SharedData.getLocalPathToDownloadFile(), 30);
    }

    public boolean verifyPDFText(String expectedText, String docType, String language, String memberNumber) throws IOException {

        String pdfContent = extractTextFromPDF(pdf.PDFDownloaded());

        // Verify the text
        switch (expectedText) {
            case "Application Results":
                switch (language){
                    case "English":
                        if (!pdfContent.contains(EligNotices.getApplicationResults(docType, language, memberNumber, basicActions))) {
                            String[] pdfLines = pdfContent.split("\n");
                            String[] expectedLines = EligNotices.getApplicationResults(docType, language, memberNumber, basicActions).split("\n");

                            StringBuilder differences = new StringBuilder("Differences found in PDF content:\n");

                            for (int i = 0; i < Math.min(pdfLines.length, expectedLines.length); i++) {
                                String pdfLine = pdfLines[i].trim();
                                String expectedLine = expectedLines[i].trim();

                                if (i == 3) { // Date on line 4 without the time
                                    String pdfLineDateOnly = pdfLine.split(" at")[0].trim();
                                    String expectedLineDateOnly = expectedLine.split(" at")[0].trim();

                                    if (!pdfLineDateOnly.equals(expectedLineDateOnly)) {
                                        differences.append("Difference at line 4 :\n");
                                        differences.append("PDF line after processing: [").append(pdfLineDateOnly).append("]\n");
                                        differences.append("Expected line............: [").append(expectedLineDateOnly).append("]\n");
                                        Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                    }
                                }
                                else if (!pdfLine.equals(expectedLine)) {
                                    differences.append("Difference at line ").append(i + 1).append(":\n");
                                    differences.append("PDF line.....: [").append(pdfLine).append("]\n");
                                    differences.append("Expected line: [").append(expectedLine).append("]\n");
                                    Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                }
                            }
                        }
                        break;
                    case "Spanish":
                        if (!pdfContent.contains(EligNotices.getApplicationResultsSpanish(docType, language, memberNumber, basicActions))) {
                            String[] pdfLines = pdfContent.split("\n");
                            String[] expectedLines = EligNotices.getApplicationResultsSpanish(docType, language, memberNumber, basicActions).split("\n");

                            StringBuilder differences = new StringBuilder("Differences found in PDF content:\n");

                            for (int i = 0; i < Math.min(pdfLines.length, expectedLines.length); i++) {
                                String pdfLine = pdfLines[i].trim();
                                String expectedLine = expectedLines[i].trim();

                                if (i == 3) { // Date on line 4 without the time
                                    String pdfLineDateOnly = pdfLine.split(" a las")[0].trim();
                                    String expectedLineDateOnly = expectedLine.split(" a las")[0].trim();

                                    if (!pdfLineDateOnly.equals(expectedLineDateOnly)) {
                                        differences.append("Difference at line 4 :\n");
                                        differences.append("PDF line after processing: [").append(pdfLineDateOnly).append("]\n");
                                        differences.append("Expected line............: [").append(expectedLineDateOnly).append("]\n");
                                        Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                    }
                                }
                                else if (!pdfLine.equals(expectedLine)) {
                                    differences.append("Difference at line ").append(i + 1).append(":\n");
                                    differences.append("PDF line.....: [").append(pdfLine).append("]\n");
                                    differences.append("Expected line: [").append(expectedLine).append("]\n");
                                    Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                }
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + language);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + expectedText);
        }
        return true;
    }


    private static String extractTextFromPDF(String pdfPath) throws IOException {
        try (PDDocument document = Loader.loadPDF(new File(pdfPath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

    //============================VALIDATION STEPS==============//
    @SneakyThrows
    public void validateNoticeText(String docType) {
        switch(docType){
            case "EN-002-04 English":
                validateEnr00204Notice();
                break;
            case "ELIG-001-01 English", "ELIG-001-01 NO CO RES English", "ELIG-001-01 MA QHP English",
                    "ELIG-001-01 QHP English", "ELIG-001-01 Gain of Tribal Status English 1",
                    "ELIG-001-01 Gain of Tribal Status English 2", "ELIG-001-01 Spanish", "ELIG-001-01 NO CO RES Spanish",
                    "ELIG-001-01 MA QHP Spanish", "ELIG-001-01 QHP Spanish", "ELIG-001-01 Gain of Tribal Status Spanish 1",
                    "ELIG-001-01 Gain of Tribal Status Spanish 2", "ELIG-001-01 English Mail", "ELIG-001-01 NO CO RES English Mail",
                    "ELIG-001-01 MA QHP English Mail", "ELIG-001-01 QHP English Mail", "ELIG-001-01 Gain of Tribal Status English 1 Mail",
                    "ELIG-001-01 Gain of Tribal Status English 2 Mail", "ELIG-001-01 Spanish Mail", "ELIG-001-01 NO CO RES Spanish Mail",
                    "ELIG-001-01 MA QHP Spanish Mail", "ELIG-001-01 QHP Spanish Mail", "ELIG-001-01 Gain of Tribal Status Spanish 1 Mail",
                    "ELIG-001-01 Gain of Tribal Status Spanish 2 Mail", "AM-011-02 English", "AM-011-02 Spanish Mail":
                    pdf.validateEntirePDF(docType);
            break;
            default: Assert.fail("Illegal argument Exception: Notice Name Incorrect");
        }
    }

    public void verifyPageText(String language) {
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(myDocumentsTitle, 20);
                softAssert.assertEquals(myDocumentsTitle.getText(),"My Documents and Letters");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Past Documents and Letters");
                softAssert.assertEquals(documentsInfoMessage.getText(),"IND_Welcome Message (AM-001-01)");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(myDocumentsTitle, 20);
                softAssert.assertEquals(myDocumentsTitle.getText(),"Mis Documentos y Cartas");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Documentos y Cartas Anteriores");
                softAssert.assertEquals(documentsInfoMessage.getText(),"No tiene documentos ni cartas en este momento");
                softAssert.assertAll();
                break;
            case "Spanish Headers":
                basicActions.waitForElementToBePresent(myDocumentsTitle, 20);
                softAssert.assertEquals(myDocumentsTitle.getText(),"Mis Documentos y Cartas");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Documentos y Cartas Anteriores");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateTheNoticeExistInMyDocumentLetterPage(String documentName) {
        basicActions.waitForElementToBePresent(myDocumentsSubTitle, 100);
        basicActions.waitForElementToBePresentWithRetries(documentsInfoMessage, 100);
        basicActions.scrollToElement(documentsInfoMessage);
        softAssert.assertEquals(documentsInfoMessage.getText(), documentName);
        softAssert.assertAll();
    }

    public void goBackToWelcomePage(){
        basicActions.waitForElementToBeClickable(goBackWelcomePage,30);
        basicActions.click(goBackWelcomePage);
    }

    public void clickUploadAnotherDocument(){
        basicActions.waitForElementToBeClickable(uploadAnotherDocument,30);
        basicActions.click(uploadAnotherDocument);
    }

    public void clickuploaddocSpanish(){
        basicActions.waitForElementToBeClickable(btnCargarotrodocumento,30);
        basicActions.click(btnCargarotrodocumento);
    }

    public void selectType() {
        StringBuilder categoryText = new StringBuilder();
        basicActions.waitForElementToBePresent(docTypeDrpDwn, 30);
        docTypeDrpDwn.click();
        for (int i = 0; i < categoryList.size(); i++) {
            WebElement categoryElement = categoryList.get(i);
            basicActions.waitForElementToBePresent(categoryElement, 30);
            categoryText.append(categoryElement.getText()).append(" ");
            categoryElement.click();
            docTypeDrpDwn.click();
        }
        String concatenatedCategoryText = categoryText.toString().trim();
        softAssert.assertEquals(concatenatedCategoryText,"1095A Dispute American Indian/Alaska Native Tribal Membership Appeals Authorized Representative Citizenship Status Complaints Customer Authorization Form Death Eligible Immigration Status Health First Colorado (Medicaid) Application Health First Colorado (Medicaid) Redetermination (RRR) Identity Incarceration Income Life Change Event Medicare Peace Corps Social Security Number TRICARE Veterans Affairs (VA) Other");
        softAssert.assertAll();
    }

    public void textValidate(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtUploadADocument,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtTellUs,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtWhatType,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtWhichDocument,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtSelectAfile,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(browseFiles,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtOneDocument,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(cancelButton,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(uploadMyDocument,30));
        softAssert.assertAll();
    }

    public void closemodal(){
        basicActions.waitForElementToBePresent(closeButton,30);
        basicActions.click(closeButton);
    }

    public void spanishModalText(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtCargarUnDocumento,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDiagnoMasSobre,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtQuetipo,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtQueDocumento,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtSeleccioneUnArchivo,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnExplorarMisArchivos,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtSolosepuedecargarundocumento,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnCancelarOnPopup,30));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnCargarMisDocumento,30));
        softAssert.assertAll();
    }

    private void validateEnr00204Notice(){
        try {

            String pdfText = extractTextFromPDF(pdf.PDFDownloaded());
            // WIP - append text for coverage start date, welcome text, Dear tag, refactor household members validation
            softAssert.assertTrue(pdfText.contains(basicActions.changeDateFormat(SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageStartDate(), "yyyy-MM-dd", "MMMM dd, yyyy")), "coverage start date failed");
            softAssert.assertTrue(pdfText.contains(SharedData.getPrimaryMember().getEmailId()), "primary member email Id is not matching");
            softAssert.assertTrue(pdfText.contains(basicActions.changeDateFormat(LocalDate.now().toString(), "yyyy-MM-dd", "MMMM d, yyyy")), "current date is not matching");
            pdf.validateMemNames(pdfText);
            pdf.validatePlanDetails(pdfText);
            softAssert.assertAll();
        } catch(IOException e){

        }
    }

    public void uploadMvrDoc(String mvrType){
        clickMvrDoubleChevrons();
        clickUploadMvr(mvrType);
        clickWhichDocument();
        uploadDoc("TestMyDocs.docx");
        clickUploadDoc();
        clickMvrDoubleChevrons();
    }

    public void clickMvrDoubleChevrons(){
        basicActions.waitForElementToBePresent(mvrDoubleChevrons,10);
        basicActions.scrollToElement(mvrDoubleChevrons);
        mvrDoubleChevrons.click();
    }

    public void clickUploadMvr(String mvrType){
        WebElement btnUploadMvr = basicActions.getDriver().findElement(By.xpath("//p[contains(text(),'Proof of "+ mvrType +"')]//following::button[1]"));
        btnUploadMvr.click();
    }

    public void clickWhichDocument(){
        basicActions.waitForElementToBePresent(dpdWhichDocument,10);
        dpdWhichDocument.click();
        dpdWhichDocumentOptions.get(0).click();
    }

    public void uploadDoc(String uploadDoc) {
        String documentPath = "src/main/resources/MyDocs/"+uploadDoc;
        String absolutePath = Paths.get(documentPath).toAbsolutePath().toString();
        WebElement fileInput = WebDriverManager.getDriver().findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(absolutePath);
        basicActions.waitForElementToBePresent(txtFileUpload, 30);
    }

    public void clickUploadDoc() {
        int retryCount = 0;
        int maxRetries = 10;

        while (retryCount < maxRetries) {
            try {
                basicActions.waitForElementToBePresent(btnUploadDoc, 10);
                btnUploadDoc.click();
                basicActions.waitForElementToBePresentWithRetries(txtUploadSuccess,20);
                Assert.assertEquals(txtUploadSuccess.getText(), "Document uploaded successfully.");
                basicActions.wait(5);
                if (basicActions.isElementDisplayed(txtUploadError,20)) {
                    throw new Exception("Upload error detected");
                }
                return;
            } catch (Exception e) {
                retryCount++;
                System.out.println("Attempt " + retryCount + " failed due to: " + e.getMessage());
                basicActions.wait(500);
            }
        }
        throw new RuntimeException("Failed to upload document after " + maxRetries + " attempts. Upload error persists.");
    }

    public void verifyMvrNeeded(String mvrType) {
        basicActions.waitForElementToBePresent(myDocumentsTitle,30);
        WebElement mvrNameType = basicActions.getDriver().findElement(By.xpath("//app-documents-upload//p[contains(text(), 'Proof of "+mvrType+"')]"));
    }

    public void clickFinancialHelpEligibilltybutton(){
      basicActions.waitForElementToBePresent(verifyFinancialHelpEligbilityButton,30);
        verifyFinancialHelpEligbilityButton.click();
    }

    public void ValidateIAmOnContainer(String container) {
        basicActions.waitForElementToBePresent(myDocumentsSubTitle,30);
        softAssert.assertEquals(myDocumentsSubTitle.getText(),container, "Past Documents and Letters container not found");
    }

    public void ValidateDefaultPlanYear() {
        String expectedYr = "";
        String actualYr = "";
        basicActions.waitForElementToBePresent(PlanYearDropDown.get(0),30);
        expectedYr = String.valueOf(Year.now().getValue());
        basicActions.wait(2000);
        softAssert.assertTrue(basicActions.waitForElementToBePresentWithRetries(PlanYearDropDown.get(0), 10));
        actualYr = PlanYearDropDown.get(0).getText();
        softAssert.assertEquals(PlanYearDropDown.get(0).getText(),expectedYr);
        System.out.println(actualYr);
        softAssert.assertAll();
    }

    public void SelectPlanYeardropdown(String selectYear) {
        basicActions.waitForElementToBePresent(PlanYearDropDown.get(0), 10);
        basicActions.refreshPage();
        basicActions.wait(50);
        basicActions.refreshPage();
        basicActions.wait(50);
        switch (selectYear) {
            case "All":
                basicActions.waitForElementToBePresentWithRetries(PlanYearDropDown.get(0), 20);
                PlanYearDropDown.get(0).click();
                basicActions.waitForElementListToBePresentWithRetries(PlanYearValues, 20);
                PlanYearValues.get(4).click();
                break;
            case "Current Year":
                basicActions.waitForElementToBePresentWithRetries(PlanYearDropDown.get(0), 20);
                PlanYearDropDown.get(0).click();
                basicActions.waitForElementListToBePresentWithRetries(PlanYearValues, 20);
                PlanYearValues.get(0).click();
                break;
            case "Previous Year":
                basicActions.waitForElementToBePresentWithRetries(PlanYearDropDown.get(0), 20);
                PlanYearDropDown.get(0).click();
                basicActions.waitForElementListToBePresentWithRetries(PlanYearValues, 20);
                PlanYearValues.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + selectYear);
        }
    }

    public void iVerifyAllNoticesPresentandStartWith(String prefix, List<String> data) {

        List<String> webElement = new ArrayList<>();
        basicActions.waitForElementListToBePresent(DocumentsNoticesLists, 50);

        //Fetching all list from container
        for (WebElement element : DocumentsNoticesLists) {
            webElement.add(element.getText().trim());
        }
        validateNoticesPresent(data, webElement);
        validateAdditionalNoticesPresent(data, webElement);
        validateNoticesStartwithIND(prefix, webElement);
        softAssert.assertAll();
    }

    void validateNoticesPresent(List<String> data, List<String> webElement) {
        //Comparing between actual and expected
        for (String Notices : data) {
            boolean isPresent = webElement.contains(Notices);
            softAssert.assertTrue(isPresent, "notices  missing in the container ->" + Notices);
        }
    }

    void validateAdditionalNoticesPresent(List<String> data, List<String> webElement) {
        Set<String> dataFileSet = new HashSet<>(data);
        Set<String> webNoticesSet = new HashSet<>(webElement);

        //To verify additional list from container
        webNoticesSet.removeAll(dataFileSet);
        softAssert.assertTrue(webNoticesSet.isEmpty(),"Additonal Notices in container -> " + webNoticesSet);
    }

    void validateNoticesStartwithIND(String prefix, List<String> webElement) {
        Set<String> webNoticesSet = new HashSet<>(webElement);
        //Verify start with IND
        for (String weblist : webNoticesSet) {
            if (!weblist.startsWith(prefix)) {
                softAssert.fail("Notices does not start with IND -> " + weblist);
            }
        }
    }

    public void clickDoubleChevron() {
        basicActions.waitForElementToBeClickable(doubleChevrons, 200);
        basicActions.wait(2000);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", doubleChevrons);
   }

    public void iValidateDateReceivedTimeReceivedAndDownloadButtonAvailable() {
        basicActions.waitForElementListToBePresent(dateReceived,30);
        int i=0;
      if( i < DocumentsNoticesLists.size()){
          softAssert.assertTrue( dateReceived.get(i).isDisplayed(),"Displayed");
          softAssert.assertTrue( timeReceived.get(i).isDisplayed(),"Dispalyed");
          softAssert.assertTrue(  download.get(i).isDisplayed(),"Displayed");
          softAssert.assertAll();
        }
    }

    public void validateYearForPresentNotice() {
        int i = 0;
        String actualYr = "", PreviousYear = "";
        PreviousYear = String.valueOf(Year.now().getValue() - 1);
        if (i < DocumentsNoticesLists.size()) {
            basicActions.waitForElementToBeClickableWithRetries(SingleChevrons.get(i), 200);
            ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", SingleChevrons.get(i));

            basicActions.waitForElementToBePresentWithRetries(datetime.get(i), 10);
            actualYr = datetime.get(i).getText();
            System.out.println(PreviousYear + " Selected as Plan year and Contains " + actualYr);
            softAssert.assertTrue(actualYr.contains(PreviousYear));
            softAssert.assertAll();
        }
    }

    public void validateNoDocumentMessage(String data) {
        basicActions.waitForElementToBePresent(DocumentsNoticesList,100);
        basicActions.wait(2000);
        softAssert.assertEquals(DocumentsNoticesList.getText(),data);
        softAssert.assertAll();
    }
    public void selectDocumentAndUpload(String documentName){
        uploadDoc(documentName);
    }
    public void verifyUploadedDocument(String uploadedDocName){
        basicActions.waitForElementToBePresent((WebDriverManager.getDriver().findElement(By.xpath("//p[text()='"+uploadedDocName+"']"))),10);
    }
    public void clickOnCloseToRemoveDoc(){
        btn_documentClose.click();
    }
    public void verifyDocRemoved(){
        basicActions.waitForElementToDisappear(btn_documentClose,10);
    }
    public void verifyUserNamePostUploadModalClose(){
        Assert.assertEquals(textUserName.getText(), SharedData.getAdminDetails().getEmail(), "Admin email did not match");
    }

    public void clickCancelButton() {
        basicActions.waitForElementToBePresent(btncancel,30);
        btncancel.click();
    }
    public void textValidateOnUploadDocumentPopUp(List<String> data){
        basicActions.waitForElementToBePresent(txtUploadADocument,30);
        softAssert.assertEquals(txtUploadADocument.getText(),data.get(0),"Upload document Text Not Match");
        softAssert.assertEquals(txtHeaderTellUs.get(0).getText(),data.get(1),"Tell us header Text Not Match");
        softAssert.assertEquals(txtWhatTypequestion.get(0).getText(),data.get(2),"what type of Document text Not Match");
        softAssert.assertTrue(PlanYearDropDown.get(2).isDisplayed(),"Dropdown Textbox not Displayed");
        softAssert.assertEquals(txtWhatTypequestion.get(1).getText(),data.get(3),"which Document text Not Match");
        softAssert.assertTrue(PlanYearDropDown.get(3).isDisplayed(),"Dropdown Textbox not Displayed");
        softAssert.assertEquals(txtHeaderTellUs.get(1).getText(),data.get(4),"Select a file from text Not Match");
        softAssert.assertEquals(browseFilesbtn.getText(),data.get(5),"Browse My File text Not Match");
        softAssert.assertEquals(onlyOneDocumentTxt.getText(),data.get(6),"Only one Document text Not Match");
        softAssert.assertEquals(btnContainertxt.get(0).getText(),data.get(7),"Cancel button text not Match");
        softAssert.assertEquals(btnContainertxt.get(1).getText(),data.get(8),"Upload my document text Not Match");
        softAssert.assertAll();
    }

    public void validateFontAndColor() {

        HeaderFooterStyleValidation();
        TitleAndTextStyleValidation();
        CancelButtonStyleValidation();
        UploadButtonStyleValidation();
        softAssert.assertAll();

    }
    void HeaderFooterStyleValidation(){
        softAssert.assertEquals(UploadPopupHeadercolor.getCssValue("background"), "rgb(22, 156, 216) none repeat scroll 0% 0% / auto padding-box border-box","Header");
        softAssert.assertEquals(txtUploadADocument.getCssValue("color"), "rgba(255, 255, 255, 1)","color error header Text ");
        softAssert.assertEquals(txtUploadADocument.getCssValue("font"), "21px / 31.5px \"PT Sans\", sans-serif","Header font error");
        softAssert.assertEquals(closeButton.getCssValue("color"), "rgba(255, 255, 255, 1)","Close X color error");

        softAssert.assertEquals(PopupContentBodyColor.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box","Body color background error");

        softAssert.assertEquals(PopupFooterBackGroundColor.getCssValue("background"), "rgb(143, 194, 217) none repeat scroll 0% 0% / auto padding-box border-box","Footer background error");

    }
    void TitleAndTextStyleValidation(){
        softAssert.assertEquals(titleBackgroundrcolor.get(0).getCssValue("background"), "rgb(230, 243, 216) none repeat scroll 0% 0% / auto padding-box border-box","background error");

        softAssert.assertEquals(txtHeaderTellUs.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)", "Body headerbackground error");
        softAssert.assertEquals(txtHeaderTellUs.get(0).getCssValue("font-size"), "19px","font size error");
        softAssert.assertEquals(txtHeaderTellUs.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif","font size error");

        softAssert.assertEquals(txtWhatTypequestion.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)","Question text color error");
        softAssert.assertEquals(txtWhatTypequestion.get(0).getCssValue("font"), "16px / 28px \"PT Sans\", sans-serif","font error");
        softAssert.assertEquals(txtWhatTypequestion.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)","Question text color error");
        softAssert.assertEquals(txtWhatTypequestion.get(1).getCssValue("font"), "16px / 28px \"PT Sans\", sans-serif","font error");

        softAssert.assertEquals(titleBackgroundrcolor.get(1).getCssValue("background"), "rgb(230, 243, 216) none repeat scroll 0% 0% / auto padding-box border-box","background error");
        softAssert.assertEquals(txtHeaderTellUs.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)", "Body headerbackground error");
        softAssert.assertEquals(txtHeaderTellUs.get(1).getCssValue("font-size"), "19px","font size error");
        softAssert.assertEquals(txtHeaderTellUs.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif","font size error");


    }
    void  CancelButtonStyleValidation(){
        softAssert.assertEquals(btncancel.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box","cancel background error");
        softAssert.assertEquals(btncancel.getCssValue("color"), "rgba(26, 112, 179, 1)","Cancel Text color  error");
        softAssert.assertEquals(btncancel.getCssValue("border-color"),"rgb(16, 111, 153)","Border color error");
        softAssert.assertEquals( btncancel .getCssValue("font-size"), "20px","font size error");
        softAssert.assertEquals(btncancel.getCssValue("font-family"), "\"PT Sans\", sans-serif","font family error");
    }
    void UploadButtonStyleValidation(){
        softAssert.assertEquals(uploadMyDocument.getCssValue("background"), "rgb(26, 112, 179) none repeat scroll 0% 0% / auto padding-box border-box","Upload background error");
        softAssert.assertEquals(uploadMyDocument.getCssValue("color"), "rgba(255, 255, 255, 1)","Upload Text color  error");
        softAssert.assertEquals(uploadMyDocument.getCssValue("border-color"),"rgb(16, 111, 153)","upload Border color error");
        softAssert.assertEquals( uploadMyDocument .getCssValue("font-size"), "20px","font size error");
        softAssert.assertEquals(uploadMyDocument.getCssValue("font-family"), "\"PT Sans\", sans-serif","font family error");
    }

    public void select1stOptionFromDocType(){
        basicActions.waitForElementToBePresent(docTypeDrpDwn,20);
        docTypeDrpDwn.click();
        typeDrpDwn1stOption.click();
    }

    public void select1stOptionFromDocCategory(){
        basicActions.waitForElementToBePresent(docCategoryDrpDwn,20);
        docCategoryDrpDwn.click();
        categoryDrpDwn1stOption.click();
    }
    public void clickOnUploadMyDoc(){
        basicActions.waitForElementToBePresent(uploadMyDocument,20);
        uploadMyDocument.click();
    }
    public void validateFileRequiredErrMsg(){
        Assert.assertTrue(textErrorMsg_Filerequired.getText().contains("File required for upload, please attach a file and try again."),"Error message is incorrect");
    }
    public void validateSelectionRequiredErrMsg(){
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(0).getText().trim(),"Selection Required");
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(1).getText().trim(),"Selection Required");
        softAssert.assertAll();
    }
    public void validateSelectionRequiredErrMsg_ForOnlyCategoryDoc(){
        Assert.assertEquals(textErrorMsg_selectionRequired.get(0).getText().trim(),"Selection Required","Selection Required error msg not displayed");
    }
    public void validateSelectionRequiredErrMsgDisappear(){
        Assert.assertTrue(textErrorMsg_selectionRequired.isEmpty(),"Selection Error message did not disappear");
    }

    public void validateFontSizeAndColour_errorMsgSR(){
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(0).getCssValue("color"), "rgba(150, 0, 0, 1)","Font colour error");
        softAssert.assertEquals( textErrorMsg_selectionRequired.get(0).getCssValue("font-size"), "14px","font size error");
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif","font family error");
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(0).getCssValue("line-height"), "24px","line height error");
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(1).getCssValue("color"), "rgba(150, 0, 0, 1)","Font colour error");
        softAssert.assertEquals( textErrorMsg_selectionRequired.get(1).getCssValue("font-size"), "14px","font size error");
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif","font family error");
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(1).getCssValue("line-height"), "24px","line height error");
        softAssert.assertAll();
    }

    public void validateFontSizeAndColour_errorMsgFR(){
        softAssert.assertEquals(textErrorMsg_Filerequired.getCssValue("color"), "rgba(150, 0, 0, 1)","Font colour error");
        softAssert.assertEquals( textErrorMsg_Filerequired.getCssValue("font-size"), "14px","font size error");
        softAssert.assertEquals(textErrorMsg_Filerequired.getCssValue("font-family"), "\"PT Sans\", sans-serif","font family error");
        softAssert.assertEquals(textErrorMsg_Filerequired.getCssValue("line-height"), "24px","line height error");
        softAssert.assertAll();
    }

    public void validateBorderColourOfTypeAndCategoryDropdown_errorMsg(){
        softAssert.assertEquals(redBorder_typeDrpDwnError.getCssValue("border-bottom-color"), "rgba(150, 0, 0, 1)","border bottom color error");
        softAssert.assertEquals(redBorder_typeDrpDwnError.getCssValue("border-left-color"), "rgba(150, 0, 0, 1)","border left color error");
        softAssert.assertEquals(redBorder_typeDrpDwnError.getCssValue("border-right-color"), "rgba(150, 0, 0, 1)","border right color error");
        softAssert.assertEquals(redBorder_typeDrpDwnError.getCssValue("border-top-color"), "rgba(150, 0, 0, 1)","border top color error");
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-bottom-color"), "rgba(150, 0, 0, 1)","border bottom color error");
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-left-color"), "rgba(150, 0, 0, 1)","border left color error");
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-right-color"), "rgba(150, 0, 0, 1)","border right color error");
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-top-color"), "rgba(150, 0, 0, 1)","border top color error");
        softAssert.assertAll();
    }
    public void verifyTextonDocumentPage(List<String > data) {
        basicActions.waitForElementToBePresent(myDocumentsTitle, 20);
        softAssert.assertEquals(myDocumentsTitle.getText(),data.get(0), "Header Text Not Match");
        softAssert.assertEquals(weNeedDocText.getText(),data.get(1), "We need more text not match");
        softAssert.assertEquals(helpMeToUnderstandText.get(0).getText(),data.get(2), "Help me to understand text not match");
        softAssert.assertEquals(informationText.getText(),data.get(3), "Information text not match");
        softAssert.assertEquals(UploadDocumentText.getText(),data.get(4), "Upload another link text not match");
        softAssert.assertEquals(myDocumentsSubTitle.getText(),data.get(5), "Past Documents and Letters Text not match");
        softAssert.assertAll();
    }

    public void validateDocSizeLargeErrMsgAndTextColour(){
        softAssert.assertTrue(textErrorMsg_docFileSizeLarge.getText().contains("Document file size too large. Files must be under 10MB."),"Error message is incorrect");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(img_errorMsg_docFileSizeLarge,10),"Img is not Present");
        softAssert.assertEquals(textErrorMsg_docFileSizeLarge.getCssValue("color"), "rgba(150, 0, 0, 1)","Font colour error");
        softAssert.assertAll();
    }
    public void validateAlreadySelectedFileBoxBorderColour(){
        softAssert.assertEquals(textBox_fileAlreadySelected.getCssValue("border-bottom-color"), "rgba(150, 0, 0, 1)","border bottom color error");
        softAssert.assertEquals(textBox_fileAlreadySelected.getCssValue("border-left-color"), "rgba(150, 0, 0, 1)","border left color error");
        softAssert.assertEquals(textBox_fileAlreadySelected.getCssValue("border-right-color"), "rgba(150, 0, 0, 1)","border right color error");
        softAssert.assertEquals(textBox_fileAlreadySelected.getCssValue("border-top-color"), "rgba(150, 0, 0, 1)","border top color error");
        softAssert.assertAll();
    }

    public void validateDocUnsupportedErrMsgAndTextColour(){
        String docFileTypeUnsupportedErrMsg="Document file type is unsupported. Files must be pdf, doc, docx, gif, jpeg, jpg, png.";
        softAssert.assertTrue(textErrorMsg_docFileSizeLarge.getText().contains(docFileTypeUnsupportedErrMsg),"Error message is incorrect");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(img_errorMsg_docFileSizeLarge,10),"Img is not Present");
        softAssert.assertEquals(textErrorMsg_docFileSizeLarge.getCssValue("color"), "rgba(150, 0, 0, 1)","Font colour error");
        softAssert.assertAll();
    }
    public void selectAllAndDocumentsFromDropDown(){
        basicActions.scrollToElement((drpDwn_Arrows_pastDocAndLetters.get(0)));
        basicActions.waitForElementToBePresent(drpDwn_Arrows_pastDocAndLetters.get(0),10);
        drpDwn_Arrows_pastDocAndLetters.get(0).click();
        drpDwn_pastDocAndLetters.get(4).click();
        basicActions.waitForElementToBePresent(drpDwn_Arrows_pastDocAndLetters.get(1),10);
        drpDwn_Arrows_pastDocAndLetters.get(1).click();
        drpDwn_pastDocAndLetters.get(6).click();
    }
    public void clickOnExpandForFirstDocument(){
        basicActions.waitForElementToBePresentWithRetries(expandArrow_forFirstDoc, 10);
        basicActions.clickElementWithRetries(expandArrow_forFirstDoc, 10);
    }
    public void verifyFileExistAndNotEmpty() {
        basicActions.waitForElementToBeClickable(btn_download, 10);
        btn_download.click();
        String fileName=basicActions.waitForDownloadToComplete(SharedData.getLocalPathToDownloadFile(),40);
        if (SharedData.getEnv().equals("qa")) {
            Assert.assertEquals(fileName, "Peace Corps-6103120466-11-Aug-2021.docx","File name is not matched");
        } else {
            Assert.assertEquals(fileName, "Peace Corps-1801096812-11-Aug-2021.docx","File name is not matched");
        }
    }


    public void ValidateDocumentCategoryinAscendingOrder(String OtherText,String language,List<String> category) {
        basicActions.waitForElementToBePresent(docTypeDrpDwn, 20);
        docTypeDrpDwn.click();

        // Extract text from elements and store in a list
        List<String> ActualCategoryList = new ArrayList<>();
        for (WebElement element : categoryList) {
            ActualCategoryList.add(element.getText());
        }

        softAssert.assertEquals(ActualCategoryList,category, "Actual and expected list are not match");
        List<String> ActualListExceptOther = new ArrayList<>(ActualCategoryList);
        ActualListExceptOther.remove(OtherText);

        //Validate Document list in ascending order
        softAssert.assertTrue(basicActions.isAscendingOrder(language,ActualListExceptOther),"Category list  not in ascending order");

        //Validate Other listed at the end
        softAssert.assertTrue(ActualCategoryList.get(ActualCategoryList.size() - 1).equals(OtherText), "Other item missing at the end of the list");
        softAssert.assertAll();

    }

    public void validateDoucmentTypeInAscendingOrder(String OtherText,String language,DataTable datable) {

        List<List<String>> expectedLists = datable.asLists();

        basicActions.waitForElementListToBePresent(categoryList, 100);

        int index = 0;
        for (WebElement element : categoryList) {
            element.click(); //Main dropdown item

            basicActions.waitForElementToBePresent(docCategoryDrpDwn,100);
            docCategoryDrpDwn.click();  // Clicking on sublist dropdown to view items

            List<String> actualList = new ArrayList<>();
            for (WebElement item : categoryList) { //Fetching sub list items
                actualList.add(item.getText().trim());
            }

            List<String> expectedList = new ArrayList<>();
            String[] splitvalues = expectedLists.get(index).get(0).split("&");
            for (int j = 0; j < splitvalues.length; j++) {
                String formattedvalue = (j == 0) ? splitvalues[j].trim() : "" + splitvalues[j].trim();
                expectedList.add(formattedvalue);
            }

            softAssert.assertEquals(actualList , expectedList , " Expected and Actual list not Match" );

            List<String> actualListExceptOther = new ArrayList<>(actualList); // Remove Other from sublist
            actualListExceptOther.removeIf(item -> item.startsWith(OtherText));

            //Validate Sublist in ASC order
            softAssert.assertTrue(basicActions.isAscendingOrder(language,actualListExceptOther), " Document type List not in ascending order");

            //using only  if, because not all sublist items contains other
            if (actualList.contains(OtherText)) {
                softAssert.assertTrue(actualList.get(actualList.size() - 1).startsWith(OtherText), "Other item  missing at the end of the list");
            }

            index++;
            docTypeDrpDwn.click();
        }
        softAssert.assertAll();

    }

    public void verifyFileNameFormat(String NoticeName,String fileType) {
        String formatedDate =   basicActions.changeDateFormat( basicActions.getTodayDate(),"MM/dd/yyyy","d-MMM-yyyy");
        basicActions.waitForElementToBePresent(expandDownloadEnrolmentDocument, 20);
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 20);
        basicActions.scrollToElement(expandDownloadEnrolmentDocument);
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 10);
        WebElement pastDocCarrot = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + NoticeName + "')]/p//following::span[1]"));
        pastDocCarrot.click();
        WebElement downloadButton = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + NoticeName + "')]/p//following::a[1]"));
        downloadButton.click();
        String fileName = basicActions.waitForDownloadToComplete(SharedData.getLocalPathToDownloadFile(), 40);
        Assert.assertEquals(fileName, NoticeName + "-" + SharedData.getPrimaryMember().getAccount_id() + "-" + formatedDate + fileType, "File Name Not Match :  ");
    }

    public void iClickUploadButton(String mvrType) {
        String btnUpload = "//p[contains(text(),'Proof of "+ mvrType +"')]//following::button[1]";
        List<WebElement> btnUploadMvr = basicActions.getDriver().findElements(By.xpath(btnUpload));
        if(!btnUploadMvr.isEmpty()) {
            btnUploadMvr.get(0).click();
        }
        else {
            basicActions.waitForElementToBeClickable(UploadDocumentText, 30);
            basicActions.click(UploadDocumentText);
        }
    }

    public void iVerifyDocumentCategoryAndTypes(String mvrType, List<String> docTypes) {
        basicActions.waitForElementToBePresent(docTypeDrpDwn, 100);
        String actual = docTypeDrpDwn.getText();
        switch (mvrType) {
            case "American Indian or Alaska Native Membership":
                if (actual.contains("American Indian/Alaska Native Tribal Membership")) {
                    Assert.assertEquals(actual, "American Indian/Alaska Native Tribal Membership", " list not defaulted with" + mvrType);
                } else {
                    docTypeDrpDwn.click();
                    basicActions.waitForElementListToBePresent(categoryList, 20);
                    categoryList.get(1).click();
                }
                break;
            case "US Citizenship":
                if (actual.contains("Citizenship Status")) {
                    Assert.assertEquals(actual, "Citizenship Status", " list not defaulted with" + mvrType);
                } else {
                    docTypeDrpDwn.click();
                    basicActions.waitForElementListToBePresent(categoryList, 20);
                    categoryList.get(4).click();
                }
                break;
            case "Life":
                if (actual.contains("Death")) {
                    Assert.assertEquals(actual, "Death", " list not defaulted with" + mvrType);
                } else {
                    docTypeDrpDwn.click();
                    basicActions.waitForElementListToBePresent(categoryList, 20);
                    categoryList.get(7).click();
                }
                break;
            case "Eligible Immigration Status":
                if (actual.contains("Eligible Immigration Status")) {
                    Assert.assertEquals(actual, "Eligible Immigration Status", " list not defaulted with" + mvrType);
                } else {
                    docTypeDrpDwn.click();
                    basicActions.waitForElementListToBePresent(categoryList, 20);
                    categoryList.get(8).click();
                }
                break;
            case "Incarceration Status":
                if (actual.contains("Incarceration")) {
                    Assert.assertEquals(actual, "Incarceration", " list not defaulted with" + mvrType);
                } else {
                    docTypeDrpDwn.click();
                    basicActions.waitForElementListToBePresent(categoryList, 20);
                    categoryList.get(12).click();
                }
                break;
            case "Financial Help Eligibility":
                if (actual.contains("Income")) {
                    Assert.assertEquals(actual, "Income", " list not defaulted with" + mvrType);
                } else {
                    docTypeDrpDwn.click();
                    basicActions.waitForElementListToBePresent(categoryList, 20);
                    categoryList.get(13).click();
                }
                break;
            case "Social Security Number":
                if (actual.contains("Social Security Number")) {
                    Assert.assertEquals(actual, "Social Security Number", " list not defaulted with" + mvrType);
                } else {
                    docTypeDrpDwn.click();
                    basicActions.waitForElementListToBePresent(categoryList, 20);
                    categoryList.get(17).click();
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + mvrType);
        }
        verifyDocumentTypes(docTypes);
    }

    private void verifyDocumentTypes(List<String > DocType){
        basicActions.waitForElementToBePresent(docCategoryDrpDwn, 100);
        docCategoryDrpDwn.click();  // Clicking on sublist dropdown to view items
        List<String> actualList = new ArrayList<>();
        for (WebElement item : categoryList) { //Fetching sub list items
            actualList.add(item.getText().trim());
        }
        List<String> expectedList = new ArrayList<>();
        String[] splitvalues = DocType.get(0).split("&");
        for (int j = 0; j < splitvalues.length; j++) {
            String formattedvalue = (j == 0) ? splitvalues[j].trim() : "" + splitvalues[j].trim();
            expectedList.add(formattedvalue);
        }
        Assert.assertEquals(actualList, expectedList, " Expected and Actual list not Match");
        dpdWhichDocumentOptions.get(0).click();
    }

    public void uploadMvrDocAndSuccesMessage() {
        clickWhichDocument();
        uploadDoc("TestMyDocs.docx");
        clickUploadDoc();
    }

    public void uploadAnotherDocWithSuccessMessage(String uploadDocFile, String mvrType) {
         selectDocumentCategoryAndType(mvrType);
         uploadDoc(uploadDocFile);
         clickUploadDoc();
    }

    private void selectDocumentCategoryAndType(String mvrType) {
        basicActions.waitForElementToBePresent(docTypeDrpDwn, 100);
        docTypeDrpDwn.click();
        basicActions.waitForElementListToBePresent(categoryList, 100);
        switch (mvrType) {
            case "American Indian or Alaska Native Membership":
                categoryList.get(1).click();
                break;
            case "US Citizenship":
                categoryList.get(4).click();
                break;
            case "Death":
                categoryList.get(7).click();
                break;
            case "Eligible Immigration Status":
                categoryList.get(8).click();
                break;
            case "Incarceration Status":
                categoryList.get(12).click();
                break;
            case "Financial Help Eligibility", "Income":
                categoryList.get(13).click();
                break;
            case "Social Security Number":
                categoryList.get(17).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + mvrType);
        }
        clickWhichDocument();
    }

    public void clickUploadAnotherDocumentlink() {
        basicActions.waitForElementToBeClickable(UploadDocumentText, 30);
        basicActions.click(UploadDocumentText);
    }

    public void uploadAnotherDocAndVerifySuccessMessage(String uploadDocFile, String mvrType, String docType) {
        selectDocumentCategoryAndType(mvrType);
        clickWhichDocumentType(docType);
        uploadDoc(uploadDocFile);
        clickUploadDoc();
    }

    public void clickWhichDocumentType(String docType){
        basicActions.waitForElementToBePresent(dpdWhichDocument,10);
        dpdWhichDocument.click();
        boolean found = false;
        for ( WebElement element : categoryList) {
            if(element.getText().trim().equals(docType)) {
                element.click();
                found = true;
                break;
            }
        }
        Assert.assertTrue(found,"Document types" +docType+ " not found");
        Assert.assertTrue(dpdWhichDocument.getText().startsWith(docType.substring(0,Math.min(5,docType.length()))),"List Not Selected");
    }

    private void selectDocumentCategory(String mvrType) {
        basicActions.waitForElementToBePresent(docTypeDrpDwn, 100);
        docTypeDrpDwn.click();
        basicActions.waitForElementListToBePresent(categoryList, 100);
        boolean found = false;
        for ( WebElement element : categoryList) {
            if(element.getText().trim().equals(mvrType)) {
                element.click();
                found = true;
                break;
            }
        }
        Assert.assertTrue(found,"Document Category " +mvrType+ " not found");
        Assert.assertTrue(docTypeDrpDwn.getText().startsWith(mvrType.substring(0,Math.min(5,mvrType.length()))),"List not selected");
    }

    public void verifyDefaultValueOnDocumentCategory() {
        basicActions.waitForElementToBePresent(docTypeDrpDwn, 30);
        Assert.assertEquals(docTypeDrpDwn.getText(),"","Document category not blank by default");
    }

    public void verifyDocumentCategorySelected(String mvrType) {
        selectDocumentCategory(mvrType);
    }

    public void verifyDefaultValueOnDocumentType() {
        basicActions.waitForElementToBePresent(docCategoryDrpDwn, 30);
        Assert.assertEquals(docCategoryDrpDwn.getText(),"","Document Type not blank by default");
    }

    public void verifyDocumentTypeSelected(String docTpe) {
        clickWhichDocumentType(docTpe);
    }
  
    public void verifyUserName(){
        Assert.assertEquals(textUserName.getText(), SharedData.getPrimaryMember().getEmailId(), "User name email did not match");
    }

    public void verifyModalPopUpClosed(){
        Assert.assertTrue( basicActions.waitForElementToDisappear(PopupContentBodyColor,10),"Modal popup not closed");
    }

    public void uploadAnotherDocAndVerifyMessageSpanish(String uploadDocFile, String mvrType, String docType,String language) {
        selectDocumentCategoryAndTypeSpanish(mvrType);
        clickWhichDocumentType(docType);
        uploadDoc(uploadDocFile);
        clickUploadDocSpanish(language);
    }
    private void selectDocumentCategoryAndTypeSpanish(String mvrType) {
        basicActions.waitForElementToBePresent(docTypeDrpDwn, 100);
        docTypeDrpDwn.click();
        basicActions.waitForElementListToBePresent(categoryList, 100);
            boolean found = false;
            for ( WebElement element : categoryList) {
                if(element.getText().trim().equals(mvrType)) {
                    element.click();
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found,"Document Category not found");
        clickWhichDocument();
    }

    public void clickUploadDocSpanish(String language) {
        basicActions.waitForElementToBePresentWithRetries(btnUploadDoc, 10);
        btnUploadDoc.click();
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresentWithRetries(txtUploadSuccess, 20);
                Assert.assertEquals(txtUploadSuccess.getText(), "Document uploaded successfully.");
                break;
            case "Spanish":
                basicActions.waitForElementToBePresentWithRetries(txtUploadSuccess, 20);
                Assert.assertEquals(txtUploadSuccess.getText(), "Documento cargado satisfactoriamente");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void clickHelpDrawerToOpen() {
        basicActions.waitForElementToBePresent(helpDrawerOpen,20);
        helpDrawerOpen.click();
    }

    public void validateHelpDrawerOpened() {
        basicActions.waitForElementToBePresentWithRetries(helpDrawerSubHeaderText,20);
        Assert.assertTrue(basicActions.waitForElementToBePresent(helpDrawerSubHeaderText,10)," Help drawer not opened");
    }

    public void verifyHelpDrawerContent(String contentOn, List<String> data) {
        basicActions.waitForElementToBePresent(helpDrawerContent,20);
        switch (contentOn) {
            case "header","Income header":
                basicActions.waitForElementToBePresent(helpDrawerHeaderText, 20);
                softAssert.assertEquals(helpDrawerHeaderText.getText(), data.get(0), " Header not match");
                break;
            case "sub header" , "Income sub header":
                basicActions.waitForElementToBePresent(helpDrawerSubHeaderText, 20);
                softAssert.assertEquals(helpDrawerSubHeaderText.getText(), data.get(0), " Sub Header title not match");
                break;
            case "body title" , "Income body title":
                basicActions.waitForElementToBePresent(helpDrawerBodyHeaderText, 20);
                softAssert.assertEquals(helpDrawerBodyHeaderText.getText(), data.get(0), " Overview title not match");
                break;
            case "body content" , "Income body content":
                basicActions.waitForElementListToBePresent(helpDrawerBodyContent, 20);
               for (int i = 0 ; i < data.size() && i < helpDrawerBodyContent.size(); i++){
                   softAssert.assertEquals( helpDrawerBodyContent.get(i).getText(), data.get(i), " Help content not match");
               }
               break;
            case "footer" , "Income footer":
                basicActions.waitForElementToBePresent(helpDrawerNeedMoreHelp, 20);
                String needHelpText = helpDrawerNeedMoreHelp.getAttribute("textContent").trim();
                softAssert.assertEquals(needHelpText,data.get(0), "Help drawer need help not match");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + contentOn);
        }
        softAssert.assertAll();
    }

    public void clickHelpDrawerToClose() {
        basicActions.waitForElementToBePresent(helpCloseSide,20);
        helpCloseSide.click();
    }

    public void validateHelpDrawerClosed() {
        Assert.assertTrue(basicActions.waitForElementToDisappear(helpDrawerContent,20)," Help drawer not closed");
    }

    public void clickLinkForHelp(String linkName) {
        switch (linkName) {
            case "Help me understand this page" :
                basicActions.waitForElementToBePresent(helpMeToUnderstandText.get(0), 10);
                helpMeToUnderstandText.get(0).click();
                break;
            case "here" :
                basicActions.waitForElementToBePresent(helpDrawerHereLink, 10);
                ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", helpDrawerHereLink);
                break;
            case "our website":
                basicActions.waitForElementToBePresent(helpDrawerOurWebsiteLink, 10);
                ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", helpDrawerOurWebsiteLink);
                break;
            case "Contact Us":
                basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
                ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", helpDrawerContactUsLink);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + linkName);
        }
    }


    public void verifyDocumentHeaderOnMyDocument(String data) {
        basicActions.waitForElementToBePresent(myDocumentHeaderTxt, 20);
        Assert.assertEquals(myDocumentHeaderTxt.getText(), data, "My Documents and Letters text not match");
    }

    public void verifySubHeaderOnMyDocumentPage(String data) {
        basicActions.waitForElementToBePresent(myDocumentSubtitleTxt, 20);
        Assert.assertEquals(myDocumentSubtitleTxt.getText(), data, "We need more text not match");
    }

    public void verifyContaineNameForInfoWeNeed(String data) {
        basicActions.waitForElementToBePresent(informationText, 20);
        Assert.assertEquals(informationText.getText(), data, "Information we need text not match");
    }

    public void verifyMvrNames(String language) {
        basicActions.waitForElementListToBePresent(mvrContainer, 20);
        List<String> expectedMvrNames;
        String[] mvrTypeName;
        for (int i = 0; i < mvrContainer.size(); i++) {
            String mvrTextWithDueDate = mvrTypes.get(i).getText();
            switch (language) {
                case "English":
                    mvrTypeName = mvrTextWithDueDate.split("Due");
                    expectedMvrNames = Arrays.asList("Proof of Financial Help Eligibility",
                            "Proof of Social Security Number",
                            "Proof of US Citizenship");
                    break;
                case "Spanish":
                    mvrTypeName = mvrTextWithDueDate.split("Fecha límite");
                    expectedMvrNames = Arrays.asList("Comprobante de elegibilidad para ayuda financiera",
                            "Comprobante de Número de Seguro Social",
                            "Comprobante de ciudadanía de EE. UU.");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            Assert.assertTrue(expectedMvrNames.contains(mvrTypeName[0].trim()), "MVR type not Match and found " + mvrTypeName[0]);
        }
    }

    public void verifyDueDateColor() {
        List<String> expectedColors = Arrays.asList("rgba(255, 0, 0, 1)", "rgba(112, 163, 0, 1)", "rgba(241, 182, 27, 1)"); //Red , Green , Yellow
        for (int i = 0; i < mvrContainer.size(); i++) {
            String mvrText = mvrTypes.get(i).getText().trim();
            String actualColorValue = mvrDueDate.get(i).getCssValue("color");
            softAssert.assertTrue(expectedColors.contains(actualColorValue), "Invalid due date color found for " + mvrText + " Color ->" + actualColorValue);
            softAssert.assertAll();
        }
    }

    public void verifyMemberName(DataTable dataTable) {
        List<Map<String,String >> expectedMemberList = dataTable.asMaps();
        List<String> ExpectedMemberName = expectedMemberList.stream()
                .filter(row -> row.get("Env").equalsIgnoreCase(SharedData.getEnv()))
                .map(row -> row.get("memberNames"))
                .toList();
        basicActions.waitForElementListToBePresent(houseHolderNames, 20);
        String actualMemberName = "";
        for (int i = 0; i < mvrContainer.size(); i++) {
            actualMemberName = houseHolderNames.get(i).getText();
            softAssert.assertTrue(ExpectedMemberName.contains(actualMemberName), "User name " + actualMemberName + " is not match ");
        }
        softAssert.assertAll();
    }

    public void verifyMvrTypesWithTextandButtons() {
        basicActions.waitForElementListToBePresent(mvrContainer, 20);
        for (int i = 0; i < mvrContainer.size(); i++) {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(mvrTypes.get(i), 20), "MVR Type not present");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(mvrDueDate.get(i), 20), "Due Date not present");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(houseHolderNames.get(i), 20), "Member name not present");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(mvrUploadButton.get(i), 20), "Upload button not present");
        }
        softAssert.assertAll();
    }

    public void verifyUploadBtnForMrv() {
        String[] mvrName;
        for (int i = 0; i < mvrContainer.size(); i++) {
            String mvrNameWithDate = mvrTypes.get(i).getText();
            mvrName = mvrNameWithDate.split("Due|Fecha");
            WebElement uploadButton = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + mvrName[0].trim() + "')]/p//following::button[1]"));
            Assert.assertTrue(basicActions.waitForElementToBePresent(uploadButton, 20), "Upload button not present");
        }
    }

    public void verifyNoDocumentMessage(String data) {
        basicActions.waitForElementToBePresent(noNeedToUpload, 20);
        Assert.assertEquals(noNeedToUpload.getText(), data, "No document message not found");
    }

    public void validateFileRequiredErrorMessage(String data){
        softAssert.assertEquals(textErrorMsg_Filerequired.getText().trim(),data,"Error message is incorrect");
        softAssert.assertTrue(ErrorSvgSymbol.isDisplayed(),"! not present in error message");
        softAssert.assertAll();
    }
    public void validateSelectionRequiredErrorMessage(String data){
        basicActions.waitForElementListToBePresent(textErrorMsg_selectionRequired,10);
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(0).getText().trim(), data , " Error message is incorrect");
        softAssert.assertTrue(SelectionRequiredErrorSvgSymbol.get(0).isDisplayed(),"! not present in error message");
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(1).getText().trim(), data , " Error message is incorrect");
        softAssert.assertTrue(SelectionRequiredErrorSvgSymbol.get(1).isDisplayed(),"! not present in error message");
        softAssert.assertAll();
    }

    public void clickUploadButton() {
        basicActions.waitForElementToBePresentWithRetries(btnUploadDoc, 10);
        btnUploadDoc.click();
    }

    public void validateBorderColorofErrorCategory() {
        basicActions.waitForElementListToBePresent(textErrorMsg_selectionRequired,20);
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-bottom-color"), "rgba(150, 0, 0, 1)","border bottom color error");
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-left-color"), "rgba(150, 0, 0, 1)","border left color error");
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-right-color"), "rgba(150, 0, 0, 1)","border right color error");
        softAssert.assertEquals(redBorder_categoryDrpDwnError.getCssValue("border-top-color"), "rgba(150, 0, 0, 1)","border top color error");
        softAssert.assertAll();
    }

    public void validateSelectionRequiredErrorMessage_ForOnlyCategoryDoc(String data) {
        basicActions.waitForElementListToBePresent(textErrorMsg_selectionRequired,10);
        softAssert.assertEquals(textErrorMsg_selectionRequired.get(0).getText().trim(),data, "Selection Required error msg not displayed");
        softAssert.assertTrue(SelectionRequiredErrorSvgSymbol.get(0).isDisplayed(),"! not present in error message");
        softAssert.assertAll();
    }

    public void validateDocUnsupportedErrorAndTextColour(String data){
        basicActions.waitForElementToBePresent(textErrorMsg_docFileSizeLarge,10);
        softAssert.assertEquals(textErrorMsg_docFileSizeLarge.getText().trim(),data,"Error message is incorrect");
        softAssert.assertTrue(ErrorSvgSymbol.isDisplayed(),"! not present in error message");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(img_errorMsg_docFileSizeLarge,10),"Img is not Present");
        softAssert.assertEquals(textErrorMsg_docFileSizeLarge.getCssValue("color"), "rgba(150, 0, 0, 1)","Font colour error");
        softAssert.assertAll();
    }

    public void select1stOptionFromDocTypeSpanish(){
        basicActions.waitForElementToBePresent(docCategoryDrpDwn,20);
        docCategoryDrpDwn.click();
        documentType1stValueSpanish.click();
    }

    public void validateDocSizeLargeErrMsgAndTextColourSpanish() {
        basicActions.waitForElementToBePresent(textErrorMsg_docFileSizeLarge,10);
        softAssert.assertEquals(textErrorMsg_docFileSizeLarge.getText()," Documento demasiado grande. El archivo deber ser menor de 10MB.","Error message is incorrect");
        softAssert.assertTrue(ErrorSvgSymbol.isDisplayed(),"! not present in error message");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(img_errorMsg_docFileSizeLarge,10),"Img is not Present");
        softAssert.assertEquals(textErrorMsg_docFileSizeLarge.getCssValue("color"), "rgba(150, 0, 0, 1)","Font colour error");
        softAssert.assertAll();
    }
}
