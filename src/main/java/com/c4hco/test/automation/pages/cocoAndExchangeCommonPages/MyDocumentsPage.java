package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import com.c4hco.test.automation.utils.BasicActions;

import com.c4hco.test.automation.utils.EligNotices;
import com.c4hco.test.automation.utils.PDF;
import com.c4hco.test.automation.utils.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyDocumentsPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage(WebDriverManager.getDriver());
    PDF pdf = new PDF(WebDriverManager.getDriver());
    public MyDocumentsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".primary-header-container > h2")
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

    @FindBy(xpath = "//div[@class='doc-type-select']")
    WebElement docTypeDrpDwn;

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

    @FindBy(xpath="//*[text()='Select a file from your device']/following::*[@aria-label='Close']")
    WebElement btn_documentClose;

    @FindBy(xpath = "//a[contains(@href,'UserProfile')]")
    WebElement textUserName;

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
        waitForDownloadToComplete(SharedData.getLocalPathToDownloadFile(), 30);
    }


    public static String waitForDownloadToComplete(String localPath, int timeoutInSeconds) {
        File dir = new File(localPath);
        File[] filesBefore = dir.listFiles();
        long startTime = System.currentTimeMillis();

        // Loop until the timeout or until a new file is found
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
            File[] filesAfter = dir.listFiles();
            if (filesAfter != null) {
                for (File file : filesAfter) {
                    if (!file.isDirectory() && (filesBefore == null || !fileExists(filesBefore, file))) {
                        if (file.length() > 0) {
                            SharedData.setNoticeFileName(file.getName());
                            return file.getName();
                        }
                    }
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private static boolean fileExists(File[] files, File file) {
        if (files == null) {
            return false;
        }
        for (File f : files) {
            if (f.getName().equals(file.getName())) {
                return true;
            }
        }
        return false;
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
                    "ELIG-001-01 Gain of Tribal Status Spanish 2 Mail", "AM-011-02 English", "AM-011-02 Spanish":
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
                basicActions.wait(10);
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
}
