package com.c4hco.test.automation.pages.exchPages;


import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.ApplicationDetailsPdf;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationDetailsPage {

    SoftAssert softAssert = new SoftAssert();
    Calendar calendar = Calendar.getInstance();
    Date today = new Date();

    private BasicActions basicActions;

    public ApplicationDetailsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    @FindBy(css = "#submit")
    List<WebElement> pageLinks;

    @FindBy(id = "doubleAccord-insur0")
    WebElement hdrOtherHealthCoverage;

    @FindBy(css = "#taxFilingAndEHI > div:nth-child(2) tr")
    List<WebElement> ohcDetails;


    public void clickViewAppDetails(){
        basicActions.waitForElementListToBePresent(pageLinks,20);
        pageLinks.get(0).click();
    }

    public void clickDownloadPdfLink(){
        basicActions.waitForElementListToBePresent(pageLinks,20);
        pageLinks.get(1).click();

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

    public void clickHeader(String header){
        switch (header){
            case "Other Health Coverage":
                basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
                hdrOtherHealthCoverage.click();
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + header);
        }
    }




    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyOhcHeaderColor(){
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        softAssert.assertEquals(hdrOtherHealthCoverage.getText(), "Other Health Coverage");
        softAssert.assertEquals(hdrOtherHealthCoverage.getCssValue("background"),"rgb(254, 246, 203) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertAll();
    }

    public void verifyOhcDetailsColor(String detail, String highlight, String data){
//        for data, add space in front due to no space if data is blank
//        Ex: " Yes"
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        String backgroundColor;
        switch (highlight) {
            case "Yellow":
                backgroundColor = "rgb(254, 246, 203) none repeat scroll 0% 0% / auto padding-box border-box";
                break;
            case "Plain":
                backgroundColor = "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box";
                break;
            case "Red":
                backgroundColor = "rgb(248, 218, 218) none repeat scroll 0% 0% / auto padding-box border-box";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + highlight);
        }
        switch (detail){
            case "Employer Sponsored Insurance":
                softAssert.assertEquals(ohcDetails.get(0).getText(), "Employer Sponsored Insurance");
                softAssert.assertEquals(ohcDetails.get(0).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "Job":
                softAssert.assertEquals(ohcDetails.get(1).getText(), "Job "+ SharedData.getPrimaryMember().getEmployerName());
                softAssert.assertEquals(ohcDetails.get(1).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "Minimum Value Standard":
                softAssert.assertEquals(ohcDetails.get(2).getText(), "Minimum Value Standard"+ data);
                softAssert.assertEquals(ohcDetails.get(2).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "Lowest-Cost Monthly Individual Premium Amount":
                softAssert.assertEquals(ohcDetails.get(3).getText(), "Lowest-Cost Monthly Individual Premium Amount"+ data);
                softAssert.assertEquals(ohcDetails.get(3).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "Currently enrolled":
                softAssert.assertEquals(ohcDetails.get(4).getText(), "Currently enrolled"+ data);
                softAssert.assertEquals(ohcDetails.get(4).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "Insurance ending in next 60 days":
                softAssert.assertEquals(ohcDetails.get(5).getText(), "Insurance ending in next 60 days"+ data);
                softAssert.assertEquals(ohcDetails.get(5).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "End date":
                switch (data){
                    case "Today":
                        calendar.setTime(today);
                        DateFormat todayDate = new SimpleDateFormat("MM/dd/yyyy");
                        String todayDateFormat = todayDate.format(today);
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date " + todayDateFormat);
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    case "Future Month":
                        calendar.add(Calendar.DATE, 60);
                        Date futureDate = calendar.getTime();
                        DateFormat futureDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date "+ futureDateFormat.format(futureDate));
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    case "Prior Month":
                        calendar.add(Calendar.MONTH, 0);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        calendar.add(Calendar.DATE, -1);
                        Date lastDayOfPriorMonth = calendar.getTime();
                        DateFormat endOfPriorMonth = new SimpleDateFormat("MM/dd/yyyy");
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date "+ endOfPriorMonth.format(lastDayOfPriorMonth));
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    case "Current Month":
                        calendar.add(Calendar.MONTH, 1);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        calendar.add(Calendar.DATE, -1);
                        Date lastDayOfMonth = calendar.getTime();
                        DateFormat endOfCurrentMonth = new SimpleDateFormat("MM/dd/yyyy");
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date "+ endOfCurrentMonth.format(lastDayOfMonth));
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    case "None":
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date");
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + data);
                }
                break;
            case "Voluntarily ending insurance":
                softAssert.assertEquals(ohcDetails.get(7).getText(), "Voluntarily ending insurance"+ data);
                softAssert.assertEquals(ohcDetails.get(7).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + detail);
        }
    }

    private static String extractTextFromPDF(Path pdfPath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(pdfPath.toString()))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

    public boolean verifyOhcPdfText(String data, String language, String premium, String enrolled, String insruanceEnding, String ending, String lastSet, String voluntarily)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));

        // Verify the text
        switch (data) {
            case "Added Job":
                switch (language){
                    case "English":
                        String startPhrase = "Other Health Coverage";
                        int startIndex = pdfContent.indexOf(startPhrase);
                        if (startIndex != -1) {
                            String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                            if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getApplicationDetails(premium, enrolled, insruanceEnding, ending, lastSet, voluntarily))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationDetailsPdf.getApplicationDetails(premium, enrolled, insruanceEnding, ending, lastSet, voluntarily).split("\n");

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
                        String startPhraseSp = "Other Health Coverage";
                        int startIndexSp = pdfContent.indexOf(startPhraseSp);
                        if (startIndexSp != -1) {
                            String pdfContentFromStartPhrase = pdfContent.substring(startIndexSp);
                            if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getApplicationDetailsSp(premium, enrolled, insruanceEnding, ending, lastSet, voluntarily))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationDetailsPdf.getApplicationDetailsSp(premium, enrolled, insruanceEnding, ending, lastSet, voluntarily).split("\n");

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
