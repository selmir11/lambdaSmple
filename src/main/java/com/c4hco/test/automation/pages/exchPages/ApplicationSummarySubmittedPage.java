package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationDetailsPdf;
import com.c4hco.test.automation.utils.BasicActions;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationSummarySubmittedPage {

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public ApplicationSummarySubmittedPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    @FindBy(id = "doubleAccord-insur0")
    WebElement hdrOtherHealthCoverage;

    @FindBy(css = "#submit")
    WebElement downloadPdf;

    @FindBy(css = ".desk-button.row #submit")
    WebElement btnViewAppDetails;


    public void clickViewAppDetails(){
        basicActions.waitForElementToBeClickable(btnViewAppDetails,20);
        basicActions.scrollToElement(btnViewAppDetails);
        btnViewAppDetails.click();
    }

    public void clickDownloadPdfLink(){
        basicActions.waitForElementToBePresent(downloadPdf,20);
        basicActions.scrollToElement(downloadPdf);
        downloadPdf.click();

        waitForDownloadToComplete(SharedData.getLocalPathToDownloadFile(), 30);
    }

    public static String waitForDownloadToComplete(String localPath, int timeoutInSeconds) {
        File dir = new File(localPath);
        File[] filesBefore = dir.listFiles();
        long startTime = System.currentTimeMillis();

        // Loop until the timeout or until a new file is found
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 2000) {
            File[] filesAfter = dir.listFiles();
            if (filesAfter != null) {
                for (File file : filesAfter) {
                    if (!file.isDirectory() && (filesBefore == null || !fileExists(filesBefore, file))) {
                        if (file.length() > 0 && isFileDownloadComplete(file)) {
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

    private static boolean isFileDownloadComplete(File file) {
        long initialSize = file.length();
        try {
            TimeUnit.SECONDS.sleep(2); // Wait for 2 seconds to check if file size changes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long newSize = file.length();
        return initialSize == newSize; // If the size hasn't changed, download is complete
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




    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyOhcHeader(String language){
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        switch (language) {
            case "English":
                softAssert.assertEquals(hdrOtherHealthCoverage.getText(), "Other Health Coverage");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(hdrOtherHealthCoverage.getText(), "Otra cobertura de salud");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public boolean verifyOhcPdfHeaderText(String data, String language) throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath + "//" + fileName;
        System.out.println("Path and name is " + pathAndName);

        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));

        String headerText = "";
        switch (data) {
            case "Other Health Coverage":
                switch (language) {
                    case "English":
                        headerText = "Other Health Coverage";
                        break;
                    case "Spanish":
                        headerText = "Otra cobertura de salud";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + language);
                }
                break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + data);
        }
        if (!pdfContent.contains(headerText)) {
            Assert.fail("PDF content does not contain the expected header: " + headerText);
            return false;
        }
        return true;
    }

    private static String extractTextFromPDF(Path pdfPath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(pdfPath.toString()))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

}
