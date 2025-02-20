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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    @FindBy(css = "button.back-button-link")
    WebElement btnBack;


    public void clickViewAppDetails(){
        basicActions.waitForElementToBeClickable(btnViewAppDetails,20);
        basicActions.scrollToElement(btnViewAppDetails);
        btnViewAppDetails.click();
    }
    public void clickBackButton(){
        basicActions.waitForElementToBeClickable(btnBack,20);
        basicActions.scrollToElement(btnBack);
        btnBack.click();
    }

    public void clickDownloadPdfLink(){
        basicActions.waitForElementToBePresent(downloadPdf,20);
        basicActions.scrollToElement(downloadPdf);
        downloadPdf.click();

        waitForDownloadToComplete(SharedData.getLocalPathToDownloadFile(), 30);
    }

    private static String lastDownloadedFileName = null; // Track last file to avoid duplicates

    public static String waitForDownloadToComplete(String localPath, int timeoutInSeconds) {
        File dir = new File(localPath);
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
            File latestFile = getLatestFile(dir);
            if (latestFile != null && isValidPdf(latestFile) && isFileDownloadComplete(latestFile)) {
                if (lastDownloadedFileName != null && latestFile.getName().equals(lastDownloadedFileName)) {
                    System.out.println("Skipping duplicate file: " + latestFile.getName());
                } else {
                    lastDownloadedFileName = latestFile.getName(); // Update the last seen file
                    SharedData.setNoticeFileName(latestFile.getName());
                    String filePath = SharedData.getLocalPathToDownloadFile();
                    String fileName = SharedData.getNoticeFileName();
                    if (filePath == null || fileName == null) {
                        System.out.println("ERROR: File path or file name is null!");
                        return null;
                    }
                    String pathAndName = filePath + "//" + fileName;
                    System.out.println("New Downloaded File: " + pathAndName);
                    return latestFile.getName();
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1); // Wait 1 sec before checking again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return null; // Timeout occurred
    }

    private static File getLatestFile(File dir) {
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null; // No files found
        }
        // Sort by last modified, newest file first
        return Arrays.stream(files)
                .filter(File::isFile)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);
    }

    private static boolean isValidPdf(File file) {
        return file.getName().endsWith(".pdf") && file.length() > 0; // Ensure it's a non-empty PDF
    }

    private static boolean isFileDownloadComplete(File file) {
        if (file.getName().endsWith(".crdownload") || file.getName().endsWith(".part")) {
            return false; // Ignore temp files
        }
        long previousSize;
        long currentSize = file.length();
        do {
            previousSize = currentSize;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            currentSize = file.length();
        } while (previousSize != currentSize);
        return true;
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

    public void verifyOhcDetails(String language, List<Map<String, String>> ohcData) {
        WebElement ohcMemberNamePrimary = basicActions.getDriver().findElement(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '"+SharedData.getPrimaryMember().getFirstName()+"')]"));
        List<WebElement> ohcDetailsPrimary = basicActions.getDriver().findElements(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '" + SharedData.getPrimaryMember().getFirstName() + "')]//following::tr"));
        String coverageType = ohcData.get(0).get("OHC Type");
        String currentlyEnrolled = ohcData.get(0).get("Currently Enrolled");
        String endDate = ohcData.get(0).get("End date");

        String currentlyEnrolledLabel = "Currently Enrolled";
        String endDateLabel = "End Date";

        if ("Spanish".equalsIgnoreCase(language)) {
            currentlyEnrolledLabel = "Inscrito(a) actualmente";
            endDateLabel = "Fecha de terminaci\u00F3n";
        }

        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage, 20);
        softAssert.assertEquals(ohcMemberNamePrimary.getText(), SharedData.getPrimaryMember().getFullName());
        softAssert.assertEquals(ohcDetailsPrimary.get(0).getText(), coverageType);
        if (currentlyEnrolled != null && !currentlyEnrolled.isEmpty()) {
            softAssert.assertEquals(ohcDetailsPrimary.get(1).getText(), currentlyEnrolledLabel + " " + currentlyEnrolled);
        }
        if (endDate != null && !endDate.isEmpty()) {
            verifyEndDate(endDate, endDateLabel + " ",2);
        }
        softAssert.assertAll();
    }

    public void verifyMedicareDetails(String language, List<Map<String, String>> ohcData) {
        WebElement ohcMemberNamePrimary = basicActions.getDriver().findElement(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '"+SharedData.getPrimaryMember().getFirstName()+"')]"));
        List<WebElement> ohcDetailsPrimary = basicActions.getDriver().findElements(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '" + SharedData.getPrimaryMember().getFirstName() + "')]//following::tr"));
        String coverageType = ohcData.get(0).get("OHC Type");
        String partAEndDate = ohcData.get(0).get("Part A End Date");
        String partBEndDate = ohcData.get(0).get("Part B End Date");

        String partAEndDateLabel = "Part A End Date";
        String partBEndDateLabel = "Part B End Date";

        if ("Spanish".equalsIgnoreCase(language)) {
            partAEndDateLabel = "Fecha de terminaci\u00F3n de la Parte A";
            partBEndDateLabel = "Fecha de terminaci\u00F3n de la Parte B";
        }

        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage, 20);
        softAssert.assertEquals(ohcMemberNamePrimary.getText(), SharedData.getPrimaryMember().getFullName());
        softAssert.assertEquals(ohcDetailsPrimary.get(0).getText(), coverageType);
        if (partAEndDate != null && !partAEndDate.isEmpty()) {
            verifyEndDate(partAEndDate, partAEndDateLabel + " ",1);
        }
        if (partBEndDate != null && !partBEndDate.isEmpty()) {
            verifyEndDate(partBEndDate, partBEndDateLabel + " ",2);
        }
        softAssert.assertAll();
    }

    private void verifyEndDate(String data, String label, int getNum) {
        String expectedDate = "";
        switch (data.trim()) {
            case "Today":
                expectedDate = basicActions.getTodayDate();
                break;
            case "Future Month":
                expectedDate = basicActions.getFutureDate(60);
                break;
            case "Prior Month":
                expectedDate = basicActions.changeDateFormat(basicActions.firstDateOfLastMonth(), "yyyy-MM-dd", "MM/dd/yyyy");
                break;
            case "Current Month":
                expectedDate = basicActions.changeDateFormat(basicActions.firstDateOfCurrMonth(), "yyyy-MM-dd", "MM/dd/yyyy");
                break;
            case "Last Current Month":
                expectedDate = basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + data);
        }

        List<WebElement> ohcDetailsPrimary = basicActions.getDriver().findElements(By.xpath("//*[@id='existingHealthInsurance']//span[contains(text(), '" + SharedData.getPrimaryMember().getFirstName() + "')]//following::tr"));
        softAssert.assertEquals(ohcDetailsPrimary.get(getNum).getText(), label + expectedDate);
    }

    public boolean verifyOhcFamilyPdfText(String language, List<Map<String, String>> pdfData)throws IOException {
        verifyOhcPdfHeaderText("Other Health Coverage", language);
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));
        String coverageType = pdfData.get(0).get("Coverage Type");
        String currentlyEnrolled = pdfData.get(0).get("Currently Enrolled");
//        String insuranceEnding = pdfData.get(0).get("Insurance Ending");
        String endDate = pdfData.get(0).get("End date");

        // Verify the text
        switch (language){
            case "English":
                String startPhrase = SharedData.getPrimaryMember().getFullName() + "\n" + coverageType;
                int startIndex = pdfContent.lastIndexOf(startPhrase);
                if (startIndex != -1) {
                    String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                    if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getFamilyApplicationSummaryDetails(coverageType, currentlyEnrolled, endDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationSummaryPdf.getFamilyApplicationSummaryDetails(coverageType, currentlyEnrolled, endDate).split("\n");

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
                String startPhraseSp = SharedData.getPrimaryMember().getFullName() + "\n" + coverageType;
                int startIndexSp = pdfContent.lastIndexOf(startPhraseSp);
                if (startIndexSp != -1) {
                    String pdfContentFromStartPhrase = pdfContent.substring(startIndexSp);
                    if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getFamilyApplicationSummaryDetailsSp(coverageType, currentlyEnrolled, endDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationSummaryPdf.getFamilyApplicationSummaryDetailsSp(coverageType, currentlyEnrolled, endDate).split("\n");

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
        return true;
    }

    public boolean verifyBasicOhcPdfText(String language, List<Map<String, String>> pdfData)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));
        String coverageType = pdfData.get(0).get("Coverage Type");
        String currentlyEnrolled = pdfData.get(0).get("Currently Enrolled");
        String insuranceEnding = pdfData.get(0).get("Insurance Ending");
        String endDate = pdfData.get(0).get("End date");

        switch (language) {
            case "English":
                String startPhrase = "Other Health Coverage";
                int startIndex = pdfContent.indexOf(startPhrase);
                if (startIndex != -1) {
                    String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                    if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getBasicApplicationDetails(coverageType, currentlyEnrolled, insuranceEnding, endDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationSummaryPdf.getBasicApplicationDetails(coverageType, currentlyEnrolled, insuranceEnding, endDate).split("\n");

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
                    if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getBasicApplicationDetailsSp(coverageType, currentlyEnrolled, insuranceEnding, endDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationSummaryPdf.getBasicApplicationDetailsSp(coverageType, currentlyEnrolled, insuranceEnding, endDate).split("\n");

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
        return false;
    }

    public boolean verifyMedicareOhcPdfText(String language, List<Map<String, String>> pdfData)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));
        String coverageType = pdfData.get(0).get("OHC Type");
        String partAEndDate = pdfData.get(0).get("Part A End Date");
        String partBEndDate = pdfData.get(0).get("Part B End Date");

        switch (language) {
            case "English":
                String startPhrase = "Other Health Coverage";
                int startIndex = pdfContent.indexOf(startPhrase);
                if (startIndex != -1) {
                    String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                    if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getMedicareApplicationDetails(coverageType, partAEndDate, partBEndDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationSummaryPdf.getMedicareApplicationDetails(coverageType, partAEndDate, partBEndDate).split("\n");

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
                    if (!pdfContentFromStartPhrase.contains(ApplicationSummaryPdf.getMedicareApplicationDetailsSp(coverageType, partAEndDate, partBEndDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationSummaryPdf.getMedicareApplicationDetailsSp(coverageType, partAEndDate, partBEndDate).split("\n");

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
        return false;
    }

}
