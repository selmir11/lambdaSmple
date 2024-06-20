package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.EligNotices;
import com.c4hco.test.automation.utils.WebDriverManager;
import com.jcraft.jsch.JSchException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

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
        basicActions.waitForElementToBeClickable(expandDownloadEnrolmentDocument, 20);
        expandDownloadEnrolmentDocument.click();
        basicActions.waitForElementToBePresent(downloadEnrolmentDoc, 20);
        basicActions.waitForElementToBeClickable(downloadEnrolmentDoc, 20);
        downloadEnrolmentDoc.click();

    }

    public  void downloadDocument(String docType) throws AWTException, JSchException {
//        docType example "Application Results"
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

    public boolean verifyPDFText(String expectedText, String language) throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));

        // Verify the text
        switch (expectedText) {
            case "Application Results: Health First Colorado":
                switch (language){
                    case "English":
                        if (!pdfContent.contains(EligNotices.getApplicationResultsHealthFirstColorado(language))) {
                            String[] pdfLines = pdfContent.split("\n");
                            String[] expectedLines = EligNotices.getApplicationResultsHealthFirstColorado(language).split("\n");

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
                        if (!pdfContent.contains(EligNotices.getApplicationResultsHealthFirstColoradoSpanish(language))) {
                            String[] pdfLines = pdfContent.split("\n");
                            String[] expectedLines = EligNotices.getApplicationResultsHealthFirstColoradoSpanish(language).split("\n");

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

    private static String extractTextFromPDF(Path pdfPath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(pdfPath.toString()))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
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
        basicActions.waitForElementToBePresent(documentsInfoMessage, 100);
        basicActions.scrollToElement(documentsInfoMessage);
        softAssert.assertEquals(documentsInfoMessage.getText(), documentName);
        softAssert.assertAll();
    }
}
