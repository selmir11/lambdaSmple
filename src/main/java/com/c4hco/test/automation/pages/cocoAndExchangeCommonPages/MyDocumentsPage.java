package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import com.jcraft.jsch.JSchException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.c4hco.test.automation.utils.WebDriverManager.getDriver;
import static java.awt.event.KeyEvent.VK_CONTROL;

public class MyDocumentsPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage(WebDriverManager.getDriver());
    SftpUtil sftpUtil = new SftpUtil();
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

    public void ClickLinkMyDocsWelcomePage() {
        basicActions.switchToParentPage("accountOverview");
        accountOverviewPage.clickHereLinks("My Documents");
    }

    public void goBackToWelcomePage(){
        basicActions.waitForElementToBeClickable(goBackWelcomePage,30);
        basicActions.click(goBackWelcomePage);
    }
    public  void downloadEnrolmentDocument() {
        basicActions.scrollToElement(expandDownloadEnrolmentDocument);
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 10);
        expandDownloadEnrolmentDocument.click();
    }

    public  void downloadDocument(String docType) throws AWTException, JSchException {
//        docType example "Application Results"
        String localPath = sftpUtil.getLocalSftpDownloadPath();
        SharedData.setLocalPathToDownloadFile(localPath);
        System.out.println("file path is "+localPath);

        basicActions.scrollToElement(expandDownloadEnrolmentDocument);
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 10);
        WebElement pastDocCarrot = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + docType + "')]/p//following::span[1]"));
        pastDocCarrot.click();
        WebElement downloadButton = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + docType + "')]/p//following::a[1]"));
        downloadButton.click();
//        String remoteLocationFull = downloadButton.getAttribute("href");
//        String remoteLocation = remoteLocationFull.substring(0, remoteLocationFull.length() - 6);
////        String remoteLocation = downloadButton.getAttribute("pathname");
//        String filename = remoteLocationFull.substring(remoteLocation.lastIndexOf('/') + 1);
//        System.out.println("path is "+remoteLocation);
//        System.out.println("file name is "+filename);
//        sftpUtil.downloadFileWithSftp(remoteLocation, filename);

        waitForDownloadToComplete(localPath, 30);
    }

//    public boolean deleteExistingFiles(String downloadpath) {;
//        File dir = new File(downloadpath);
//        if (dir.exists() && dir.isDirectory()) {
//            File[] files = dir.listFiles();
//            for (File file : files) {
//                if (file.isFile()) {
//                    file.delete();
//                    System.out.println(file);
//                }
//            }
//        } else {
//            return false;
//        }
//        return false;
//    }
//
//    public  void downloadDocument(String docType) throws AWTException {
////        docType example "Application Results"
//        String downloadDir = "D:\\Users\\*\\Downloads\\";
//        String username = System.getProperty("user.name");
//        String downloadpath = downloadDir.replace("*", username);
//        deleteExistingFiles(downloadpath);
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", downloadpath);
//        basicActions.scrollToElement(expandDownloadEnrolmentDocument);
//        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 10);
//        WebElement pastDocCarrot = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + docType + "')]/p//following::span[1]"));
//        pastDocCarrot.click();
//        WebElement downloadButton = basicActions.getDriver().findElement(By.xpath("//div[contains(normalize-space(), '" + docType + "')]/p//following::a[1]"));
//        downloadButton.click();
//        basicActions.wait(2000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(VK_CONTROL);
//        waitForDownloadToComplete(downloadpath, 30);
//    }

    public static boolean waitForDownloadToComplete(String localPath, int timeoutInSeconds) {
        File file = new File(localPath);
        for (int i = 0; i < timeoutInSeconds; i++) {
            if (file.exists() && file.length() > 0) {
                return true;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean verifyPDFText(String expectedText) throws IOException {
        String localPath = sftpUtil.getLocalSftpDownloadPath();
        SharedData.setLocalPathToDownloadFile(localPath);
//        PDDocument document = PDDocument.load(new File(filePath));
//        PDFTextStripper pdfStripper = new PDFTextStripper();
//        String pdfText = pdfStripper.getText(document);
//        document.close();
//        switch (expectedText){
//            case "Application Results: Health First Colorado":
//                return pdfText.equals("Texthere");
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + expectedText);
//        }
        return false;
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

    public void goBackToWelcomePage(){
        basicActions.waitForElementToBeClickable(goBackWelcomePage,30);
        basicActions.click(goBackWelcomePage);
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
