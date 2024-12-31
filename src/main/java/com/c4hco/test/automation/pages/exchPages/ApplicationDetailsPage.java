package com.c4hco.test.automation.pages.exchPages;


import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.ApplicationDetailsPdf;
import org.apache.pdfbox.Loader;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApplicationDetailsPage {

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public ApplicationDetailsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    @FindBy(name = "toggleChanges")
    WebElement showChangesBtn;

    @FindBy(name = "downloadAsPDF")
    WebElement downloadPdf;

    @FindBy(id = "doubleAccord-insur0")
    WebElement hdrOtherHealthCoverage;

    @FindBy(css = "#taxFilingAndEHI > div:nth-child(2) tr")
    List<WebElement> ohcDetails;


    public void clickViewAppDetails(){
        basicActions.waitForElementToBePresent(showChangesBtn,20);
        showChangesBtn.click();
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
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
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
    public void verifyOhcHeaderColor(String highlight){
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        String backgroundColor = switch (highlight) {
            case "Yellow" -> "rgb(254, 246, 203) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Plain" -> "rgb(230, 242, 213) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Red" -> "rgb(248, 218, 218) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Green" -> "rgb(215, 233, 202) none repeat scroll 0% 0% / auto padding-box border-box";
            default -> throw new IllegalArgumentException("Invalid option: " + highlight);
        };
        softAssert.assertEquals(hdrOtherHealthCoverage.getText(), "Other Health Coverage");
        softAssert.assertEquals(hdrOtherHealthCoverage.getCssValue("background"),backgroundColor);
        softAssert.assertAll();
    }

    public void verifyOhcDetailsColor(String detail, String highlight, String data){
//        for data, add space in front due to no space if data is blank
//        Ex: " Yes"
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        String backgroundColor = switch (highlight) {
            case "Yellow" -> "rgb(254, 246, 203) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Plain" -> "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Red" -> "rgb(248, 218, 218) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Green" -> "rgb(215, 233, 202) none repeat scroll 0% 0% / auto padding-box border-box";
            default -> throw new IllegalArgumentException("Invalid option: " + highlight);
        };
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
                        String todayDate = basicActions.getTodayDate();
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date " + todayDate);
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    case "Future Month":
                        String futureDate = basicActions.getFutureDate(60);
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date "+ futureDate);
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    case "Prior Month":
                        String lastDayOfPriorMonth = basicActions.lastDateOfPriorMonth();
                        lastDayOfPriorMonth = basicActions.changeDateFormat(lastDayOfPriorMonth, "MM-dd-yyyy", "MM/dd/yyyy");
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date "+ lastDayOfPriorMonth);
                        softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),backgroundColor);
                        softAssert.assertAll();
                        break;
                    case "Current Month":
                        String lastDayOfMonth = basicActions.lastDateOfCurrMonth();
                        lastDayOfMonth = basicActions.changeDateFormat(lastDayOfMonth, "MM-dd-yyyy", "MM/dd/yyyy");
                        softAssert.assertEquals(ohcDetails.get(6).getText(), "End date "+ lastDayOfMonth);
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
            case "Family plan offered":
                softAssert.assertEquals(ohcDetails.get(8).getText(), "Family plan offered"+ data);
                softAssert.assertEquals(ohcDetails.get(8).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "Lowest-Cost Monthly Family Premium Amount":
                softAssert.assertEquals(ohcDetails.get(9).getText(), "Lowest-Cost Monthly Family Premium Amount"+ data);
                softAssert.assertEquals(ohcDetails.get(9).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "Enrolled":
                softAssert.assertEquals(ohcDetails.get(10).getText(), "Enrolled"+ data);
                softAssert.assertEquals(ohcDetails.get(10).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "None":
                softAssert.assertEquals(ohcDetails.get(0).getText(), "None"+ data);
                softAssert.assertEquals(ohcDetails.get(0).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            case "1 Removed":
                softAssert.assertEquals(ohcDetails.get(1).getText(), "1 Current Coverage(s) removed"+ data);
                softAssert.assertEquals(ohcDetails.get(1).getCssValue("background"),backgroundColor);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + detail);
        }
    }

    public void verifyBasicOhcDetailsColor(List<Map<String, String>> ohcData){
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        String coverageType = ohcData.get(0).get("OHC Type");
        String coverageTypeHighlight = ohcData.get(0).get("Type Highlight");
        String currentlyEnrolled = ohcData.get(0).get("Currently enrolled");
        String currentlyEnrolledHighlight = ohcData.get(0).get("Enrolled Highlight");
        String insuranceEnding = ohcData.get(0).get("Insurance ending");
        String insuranceEndingHighlight = ohcData.get(0).get("Ending Highlight");
        String endDate = ohcData.get(0).get("End date");
        String endDateHighlight = ohcData.get(0).get("Date Highlight");
        String voluntarilyEnding = ohcData.get(0).get("Voluntarily ending");
        String voluntarilyEndingHighlight = ohcData.get(0).get("Voluntarily Highlight");

        switch (coverageType){
            case "Retiree Health Plan":
                softAssert.assertEquals(ohcDetails.get(0).getText(), "Retiree Health Plan");
                softAssert.assertEquals(ohcDetails.get(0).getCssValue("background"),highlightedColor(coverageTypeHighlight),"Retiree Health Plan highlight");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + coverageType);
        }
        softAssert.assertEquals(ohcDetails.get(1).getText(), "Currently enrolled "+ currentlyEnrolled);
        softAssert.assertEquals(ohcDetails.get(1).getCssValue("background"),highlightedColor(currentlyEnrolledHighlight),"Currently enrolled highlight");
        if (insuranceEnding != null) {
            softAssert.assertEquals(ohcDetails.get(2).getText(), "Insurance ending in next 60 days " + insuranceEnding);
        }
        softAssert.assertEquals(ohcDetails.get(2).getCssValue("background"),highlightedColor(insuranceEndingHighlight),"Insurance ending in next 60 days highlight");
        if (endDate != null) {
            verifyBasicOhcEndDate(endDate);
        }
        softAssert.assertEquals(ohcDetails.get(3).getCssValue("background"),highlightedColor(endDateHighlight),"End date highlight");
        if (voluntarilyEnding != null) {
            softAssert.assertEquals(ohcDetails.get(4).getText(), "Voluntarily ending insurance " + voluntarilyEnding);
        }
        softAssert.assertEquals(ohcDetails.get(4).getCssValue("background"),highlightedColor(voluntarilyEndingHighlight),"Voluntarily ending insurance highlight");
        softAssert.assertAll();
    }

    public String highlightedColor(String highlight) {
        return switch (highlight) {
            case "Yellow" -> "rgb(254, 246, 203) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Plain" -> "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Red" -> "rgb(248, 218, 218) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Green" -> "rgb(215, 233, 202) none repeat scroll 0% 0% / auto padding-box border-box";
            default -> throw new IllegalArgumentException("Invalid option: " + highlight);
        };
    }

    public void verifyBasicOhcEndDate(String data) {
        String endDate = data;
        int daysInFuture = 0;
        if (data.startsWith("Future Day:")) {
            String[] parts = data.split(":");
            endDate = parts[0];
            daysInFuture = Integer.parseInt(parts[1]);
        }
        switch (endDate){
            case "Today":
                String todayDate = basicActions.getTodayDate();
                softAssert.assertEquals(ohcDetails.get(3).getText(), "End date " + todayDate);
                softAssert.assertAll();
                break;
            case "Future Month":
                String futureDate = basicActions.getFutureDate(60);
                softAssert.assertEquals(ohcDetails.get(3).getText(), "End date "+ futureDate);
                softAssert.assertAll();
                break;
            case "Prior Month":
                String lastDayOfPriorMonth = basicActions.lastDateOfPriorMonth();
                lastDayOfPriorMonth = basicActions.changeDateFormat(lastDayOfPriorMonth, "MM-dd-yyyy", "MM/dd/yyyy");
                softAssert.assertEquals(ohcDetails.get(3).getText(), "End date "+ lastDayOfPriorMonth);
                softAssert.assertAll();
                break;
            case "Current Month":
                String lastDayOfMonth = basicActions.lastDateOfCurrMonth();
                lastDayOfMonth = basicActions.changeDateFormat(lastDayOfMonth, "MM-dd-yyyy", "MM/dd/yyyy");
                softAssert.assertEquals(ohcDetails.get(3).getText(), "End date "+ lastDayOfMonth);
                softAssert.assertAll();
                break;
            case "Future Day":
                String futureDate1 = basicActions.getFutureDate(daysInFuture);
                softAssert.assertEquals(ohcDetails.get(3).getText(), "End date "+ futureDate1);
                softAssert.assertAll();
                break;
            case "None":
                softAssert.assertEquals(ohcDetails.get(3).getText(), "End date");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + data);
        }
    }

    public void verifyOhcFamilyDetailsColor(List<String> familyOption){
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);

        List<String> enrolledMembers = new ArrayList<>();
        List<String> offeredMembers = new ArrayList<>();
        List<String> noOptionMembers = new ArrayList<>();

        for (String option : familyOption) {
            String[] parts = option.split(":");
            String name = parts.length > 0 ? parts[0].trim() : "";
            String relation = parts.length > 1 ? parts[1].trim() : "";
            String highlight = parts.length > 2 ? parts[2].trim() : "";

            if (relation.isEmpty() || highlight.isEmpty()) {
                continue;
            }

            switch (relation) {
                case "Enrolled":
                    if (!name.isEmpty()) {
                        enrolledMembers.add(getString(name));
                    }
                    break;
                case "Offered a plan but not enrolled":
                    if (!name.isEmpty()) {
                        offeredMembers.add(getString(name));
                    }
                    break;
                case "No option to enroll":
                    if (!name.isEmpty()) {
                        noOptionMembers.add(getString(name));
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid relation: " + relation);
            }

            String backgroundColor = switch (highlight) {
                case "Yellow" -> "rgb(254, 246, 203) none repeat scroll 0% 0% / auto padding-box border-box";
                case "Red" -> "rgb(248, 218, 218) none repeat scroll 0% 0% / auto padding-box border-box";
                case "Green" -> "rgb(215, 233, 202) none repeat scroll 0% 0% / auto padding-box border-box";
                case "Plain" -> "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box";
                default -> throw new IllegalArgumentException("Invalid highlight color: " + highlight);
            };

            int index = switch (relation) {
                case "Enrolled" -> 10;
                case "Offered a plan but not enrolled" -> 11;
                case "No option to enroll" -> 12;
                default -> throw new IllegalArgumentException("Invalid relation: " + relation);
            };

            softAssert.assertEquals(ohcDetails.get(index).getCssValue("background"), backgroundColor);
        }

        if (!enrolledMembers.isEmpty()) {
            String enrolledText = enrolledMembers.size() > 1
                    ? String.join(", ", enrolledMembers)
                    : enrolledMembers.get(0);
            softAssert.assertEquals(ohcDetails.get(10).getText(), "Enrolled " + enrolledText.trim());
        }

        if (!offeredMembers.isEmpty()) {
            String offeredText = offeredMembers.size() > 1
                    ? String.join(", ", offeredMembers)
                    : offeredMembers.get(0);
            softAssert.assertEquals(ohcDetails.get(11).getText(), "Offered a plan but not enrolled " + offeredText.trim());
        }

        if (!noOptionMembers.isEmpty()) {
            String noOptionText = noOptionMembers.size() > 1
                    ? String.join(", ", noOptionMembers)
                    : noOptionMembers.get(0);
            softAssert.assertEquals(ohcDetails.get(12).getText(), "No option to enroll " + noOptionText.trim());
        }

        softAssert.assertAll();
    }

    private static String getString(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "";
        }

        String memberFullName = "";

        switch (name) {
            case "Member1FullName":
                if (SharedData.getMembers().size() > 0) {
                    memberFullName = SharedData.getMembers().get(0).getCompleteFullName();
                }
                break;
            case "Member2FullName":
                if (SharedData.getMembers().size() > 1) {
                    memberFullName = SharedData.getMembers().get(1).getCompleteFullName();
                }
                break;
            case "Member3FullName":
                if (SharedData.getMembers().size() > 2) {
                    memberFullName = SharedData.getMembers().get(2).getCompleteFullName();
                }
                break;
            default:
                break;
        }
        return memberFullName;
    }


    private static String extractTextFromPDF(Path pdfPath) throws IOException {
        try (PDDocument document = Loader.loadPDF(new File(String.valueOf(pdfPath)))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

    public boolean verifyOhcPdfText(String data, String language, String minValue,  String premium, String enrolled, String insruanceEnding, String ending, String lastSet, String endDate, String voluntarily)throws IOException {
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
                            if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getApplicationDetails(minValue, premium, enrolled, insruanceEnding, ending, lastSet, endDate, voluntarily))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationDetailsPdf.getApplicationDetails(minValue, premium, enrolled, insruanceEnding, ending, lastSet, endDate, voluntarily).split("\n");

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
                            if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getApplicationDetailsSp(minValue, premium, enrolled, insruanceEnding, ending, lastSet, endDate, voluntarily))) {
                                String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                                String[] expectedLines = ApplicationDetailsPdf.getApplicationDetailsSp(minValue, premium, enrolled, insruanceEnding, ending, lastSet, endDate, voluntarily).split("\n");

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

    public boolean verifyOhcPdfFamilyText(String offered, String premium, List<String> familyOption)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));

        // Verify the text
            String startPhrase = "Family plan offered";
            int startIndex = pdfContent.indexOf(startPhrase);
            if (startIndex != -1) {
                String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getFamilyApplicationDetails(offered, premium, familyOption))) {
                    String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                    String[] expectedLines = ApplicationDetailsPdf.getFamilyApplicationDetails(offered, premium, familyOption).split("\n");

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
        return true;
    }

    public boolean verifyBasicOhcPdfText(String language, List<Map<String, String>> pdfData)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath + "//" + fileName;
        System.out.println("path and name is " + pathAndName);
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));
        String coverageType = pdfData.get(0).get("Coverage Type");
        String currentlyEnrolled = pdfData.get(0).get("Currently Enrolled");
        String insuranceEnding = pdfData.get(0).get("Insurance Ending");
        String endDate = pdfData.get(0).get("End date");
        String voluntarilyEnding = pdfData.get(0).get("Voluntarily ending insurance");

        switch (language) {
            case "English":
                String startPhrase = "Other Health Coverage";
                int startIndex = pdfContent.indexOf(startPhrase);
                if (startIndex != -1) {
                    String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                    if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getBasicApplicationDetails(coverageType, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationDetailsPdf.getBasicApplicationDetails(coverageType, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding).split("\n");

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
                    if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getBasicApplicationDetailsSp(coverageType, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationDetailsPdf.getBasicApplicationDetailsSp(coverageType, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding).split("\n");

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
