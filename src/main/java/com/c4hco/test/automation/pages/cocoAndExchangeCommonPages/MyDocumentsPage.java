package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MyDocumentsPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage(WebDriverManager.getDriver());
    public MyDocumentsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".primary-header-container > h2")
    WebElement myDocumentsTitle;

    @FindBy(css = ".documents-notices-title.header-2")
    WebElement myDocumentsSubTitle;
    
    @FindBy(css = ".documents-notices-content-container > div")
    WebElement documentsInfoMessage;

    @FindBy(xpath = "//button[normalize-space()='Go back to Welcome page']")
    WebElement goBackWelcomePage;
    @FindBy(xpath = "(//div[@class='documents-notices-content-container']//div//div//span)[1]")
    WebElement expandDownloadEnrolmentDocument;
    @FindBy(css = "a.btn-second-action-button.download-button")
    WebElement downloadEnrolmentDoc;

    @FindBy(xpath = "//a[normalize-space()='Upload another document']")
    WebElement uploadAnotherDocument;

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

    @FindBy(xpath = "//span[normalize-space()='Díganos más sobre este documento']")
    WebElement txtDiagnoMasSobre;

    @FindBy(xpath = "//span[normalize-space()='¿Qué tipo de documento es este?']")
    WebElement txtQuetipo;

    @FindBy(xpath = "//span[normalize-space()='¿Qué documento está enviando?']")
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

    public void ClickLinkMyDocsWelcomePage() {
        basicActions.switchToParentPage("accountOverview");
        accountOverviewPage.clickHereLinks("My Documents");
    }

                //============================VALIDATION STEPS==============//

    public void verifyPageText(String language)
        {
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
        basicActions.waitForElementToBePresent(documentsInfoMessage,100);
        basicActions.scrollToElement(documentsInfoMessage);
        softAssert.assertEquals(documentsInfoMessage.getText(),documentName);
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

    public  void downloadEnrolmentDocument() {
        basicActions.scrollToElement(expandDownloadEnrolmentDocument);
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 20);
        expandDownloadEnrolmentDocument.click();
        basicActions.waitForElementToBePresent(downloadEnrolmentDoc, 20);
        basicActions.waitForElementToBeClickable(downloadEnrolmentDoc, 20);
        downloadEnrolmentDoc.click();
    }
}
