package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationSummaryPdf;
import com.c4hco.test.automation.utils.BasicActions;
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

    @FindBy(css= ".existing-insurance.tax-profile-div span:nth-child(1)")
    WebElement ohcMemberName;

    @FindBy(css = ".existing-insurance.tax-profile-div tr ")
    List<WebElement> ohcDetails;

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
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 3000) {
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

    public void clickOtherHealthCoverage(){
        basicActions.waitForElementToBeClickable(hdrOtherHealthCoverage,20);
        basicActions.scrollToElement(hdrOtherHealthCoverage);
        hdrOtherHealthCoverage.click();
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
        try (PDDocument document = Loader.loadPDF(new File(String.valueOf(pdfPath)))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

    public void verifyOhcDetails(String detail, String data, String language) {
//        for data, add space in front due to no space if data is blank
//        Ex: " Yes"
        WebElement ohcMemberNamePrimary = basicActions.getDriver().findElement(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '"+SharedData.getPrimaryMember().getFirstName()+"')]"));
        List<WebElement> ohcDetailsPrimary = basicActions.getDriver().findElements(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '" + SharedData.getPrimaryMember().getFirstName() + "')]//following::tr"));
        switch (language) {
            case "English":
                switch (detail) {
                    case "Name":
                        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage, 20);
                        softAssert.assertEquals(ohcMemberNamePrimary.getText(), SharedData.getPrimaryMember().getFullName());
                        softAssert.assertAll();
                        break;
                    case "Employer Sponsored Insurance":
                        softAssert.assertEquals(ohcDetailsPrimary.get(0).getText(), "Employer Sponsored Insurance");
                        softAssert.assertAll();
                        break;
                    case "Currently enrolled":
                        softAssert.assertEquals(ohcDetailsPrimary.get(1).getText(), "Currently Enrolled" + data);
                        softAssert.assertAll();
                        break;
                    case "End date":
                        verifyEndDate(data, "End Date ");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + detail);
                }
                break;
            case "Spanish":
                switch (detail) {
                    case "Name":
                        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage, 20);
                        softAssert.assertEquals(ohcMemberNamePrimary.getText(), SharedData.getPrimaryMember().getFullName());
                        softAssert.assertAll();
                        break;
                    case "Employer Sponsored Insurance":
                        softAssert.assertEquals(ohcDetailsPrimary.get(0).getText(), "Employer Sponsored Insurance");
                        softAssert.assertAll();
                        break;
                    case "Currently enrolled":
                        softAssert.assertEquals(ohcDetailsPrimary.get(1).getText(), "Inscrito(a) actualmente" + data);
                        softAssert.assertAll();
                        break;
                    case "End date":
                        verifyEndDate(data, "Fecha de terminaci\u00F3n ");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + detail);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    private void verifyEndDate(String data, String label) {
        String expectedDate = "";
        switch (data.trim()) {
            case "Today":
                expectedDate = basicActions.getTodayDate();
                break;
            case "Future Month":
                expectedDate = basicActions.getFutureDate(60);
                break;
            case "Prior Month":
                expectedDate = basicActions.changeDateFormat(basicActions.firstDateOfLastMonth(), "yyyy-MM-dd", "yyyy-MM-dd");
                break;
            case "Current Month":
                expectedDate = basicActions.changeDateFormat(basicActions.firstDateOfCurrMonth(), "yyyy-MM-dd", "yyyy-MM-dd");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + data);
        }

        List<WebElement> ohcDetailsPrimary = basicActions.getDriver().findElements(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '" + SharedData.getPrimaryMember().getFirstName() + "')]//following::tr"));
        softAssert.assertEquals(ohcDetailsPrimary.get(2).getText(), label + expectedDate);
        softAssert.assertAll();
    }

    public boolean verifyOhcPdfText(String data, String language, String ohcType, String enrolled, String endDate)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));

        // Verify the text
        switch (data) {
            case "Other Health Coverage":
                switch (language){
                    case "English":
                        String startPhrase = "Other Health Coverage";
                        int startIndex = pdfContent.indexOf(startPhrase);
                        if (startIndex != -1) {
                            String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                            if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getApplicationSummaryDetails(ohcType, enrolled, endDate))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationSummaryPdf.getApplicationSummaryDetails(ohcType, enrolled, endDate).split("\n");

                                StringBuilder differences = new StringBuilder("Differences found in PDF content:\n");

                                for (int i = 0; i < Math.min(pdfLines.length, expectedLines.length); i++) {
                                    String pdfLine = pdfLines[i].trim();
                                    String expectedLine = expectedLines[i].trim();

                                    if (!pdfLine.equals(expectedLine)) {
                                        differences.append("Difference at line ").append(i + 1).append(":\n");
                                        differences.append("PDF line.....: [").append(pdfLine).append("]\n");
                                        differences.append("Expected line: [").append(expectedLine).append("]\n");
                                        Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                    }
                                }
                            }
                        }
                        break;
                    case "Spanish":
                        String startPhraseSp = "Otra cobertura de salud";
                        int startIndexSp = pdfContent.indexOf(startPhraseSp);
                        if (startIndexSp != -1) {
                            String pdfContentFromStartPhrase = pdfContent.substring(startIndexSp);
                            if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getApplicationSummaryDetailsSp(ohcType, enrolled, endDate))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationSummaryPdf.getApplicationSummaryDetailsSp(ohcType, enrolled, endDate).split("\n");

                                StringBuilder differences = new StringBuilder("Differences found in PDF content:\n");

                                for (int i = 0; i < Math.min(pdfLines.length, expectedLines.length); i++) {
                                    String pdfLine = pdfLines[i].trim();
                                    String expectedLine = expectedLines[i].trim();

                                    if (!pdfLine.equals(expectedLine)) {
                                        differences.append("Difference at line ").append(i + 1).append(":\n");
                                        differences.append("PDF line.....: [").append(pdfLine).append("]\n");
                                        differences.append("Expected line: [").append(expectedLine).append("]\n");
                                        Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + language);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + data);
        }
        return true;
    }

    public boolean verifyOhcFamilyPdfText(String data, String language, String ohcType, String enrolled, String endDate)throws IOException {
        verifyOhcPdfHeaderText(data, language);
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));

        // Verify the text
        switch (data) {
            case "Other Health Coverage":
                switch (language){
                    case "English":
                        String startPhrase = SharedData.getPrimaryMember().getFullName() + "\n" + ohcType;
                        int startIndex = pdfContent.lastIndexOf(startPhrase);
                        if (startIndex != -1) {
                            String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                            if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getFamilyApplicationSummaryDetails(ohcType, enrolled, endDate))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationSummaryPdf.getFamilyApplicationSummaryDetails(ohcType, enrolled, endDate).split("\n");

                                StringBuilder differences = new StringBuilder("Differences found in PDF content:\n");

                                for (int i = 0; i < Math.min(pdfLines.length, expectedLines.length); i++) {
                                    String pdfLine = pdfLines[i].trim();
                                    String expectedLine = expectedLines[i].trim();

                                    if (!pdfLine.equals(expectedLine)) {
                                        differences.append("Difference at line ").append(i + 1).append(":\n");
                                        differences.append("PDF line.....: [").append(pdfLine).append("]\n");
                                        differences.append("Expected line: [").append(expectedLine).append("]\n");
                                        Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                    }
                                }
                            }
                        }
                        break;
                    case "Spanish":
                        String startPhraseSp = SharedData.getPrimaryMember().getFullName() + "\n" + ohcType;
                        int startIndexSp = pdfContent.lastIndexOf(startPhraseSp);
                        if (startIndexSp != -1) {
                            String pdfContentFromStartPhrase = pdfContent.substring(startIndexSp);
                            if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getFamilyApplicationSummaryDetailsSp(ohcType, enrolled, endDate))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationSummaryPdf.getFamilyApplicationSummaryDetailsSp(ohcType, enrolled, endDate).split("\n");

                                StringBuilder differences = new StringBuilder("Differences found in PDF content:\n");

                                for (int i = 0; i < Math.min(pdfLines.length, expectedLines.length); i++) {
                                    String pdfLine = pdfLines[i].trim();
                                    String expectedLine = expectedLines[i].trim();

                                    if (!pdfLine.equals(expectedLine)) {
                                        differences.append("Difference at line ").append(i + 1).append(":\n");
                                        differences.append("PDF line.....: [").append(pdfLine).append("]\n");
                                        differences.append("Expected line: [").append(expectedLine).append("]\n");
                                        Assert.fail("PDF content does not contain expected text for notice.\n" + differences.toString());
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + language);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + data);
        }
        return true;
    }

}
