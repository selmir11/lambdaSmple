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
import java.util.*;

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
        basicActions.waitForElementToBePresent(showChangesBtn,60);
        showChangesBtn.click();
    }

    public void clickDownloadPdfLink(){
        basicActions.waitForElementToBePresent(downloadPdf,20);
        basicActions.scrollToElement(downloadPdf);
        downloadPdf.click();

        basicActions.waitForDownloadToComplete(SharedData.getLocalPathToDownloadFile(), 30);
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
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        softAssert.assertEquals(hdrOtherHealthCoverage.getText(), "Other Health Coverage");
        softAssert.assertEquals(hdrOtherHealthCoverage.getCssValue("background"),highlightedColor(highlight));
        softAssert.assertAll();
    }

    public void verifyEsiDetailsColor(List<Map<String, String>> ohcData){
        basicActions.wait(250);
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        String coverageType = ohcData.get(0).get("OHC Type");
        String coverageTypeHighlight = ohcData.get(0).get("Type Highlight");
        String jobHighlight = ohcData.get(0).get("Job Highlight");
        String minimumValueStandard = ohcData.get(0).get("Minimum Value Standard");
        String minimumValueHighlight = ohcData.get(0).get("Minimum Value Highlight");
        String lowestCostAmount = ohcData.get(0).get("Lowest-Cost Monthly Individual Premium Amount");
        String lowestCostAmountHighlight = ohcData.get(0).get("Lowest-Cost Highlight");
        String currentlyEnrolled = ohcData.get(0).get("Currently enrolled");
        String currentlyEnrolledHighlight = ohcData.get(0).get("Enrolled Highlight");
        String insuranceEnding = ohcData.get(0).get("Insurance ending in next 60 days");
        String insuranceEndingHighlight = ohcData.get(0).get("Ending Highlight");
        String endDate = ohcData.get(0).get("End date");
        String endDateHighlight = ohcData.get(0).get("Date Highlight");
        String voluntarilyEnding = ohcData.get(0).get("Voluntarily ending");
        String voluntarilyEndingHighlight = ohcData.get(0).get("Voluntarily Highlight");
        String familyPlanOffered = ohcData.get(0).get("Family plan offered");
        String familyOfferedHighlight = ohcData.get(0).get("Family offered Highlight");
        String faimlyLowestCostAmount = ohcData.get(0).get("Lowest-Cost Monthly Family Premium Amount");
        String faimlyLowestCostHighlight = ohcData.get(0).get("Lowest-Cost Family Highlight");

        softAssert = new SoftAssert();
        softAssert.assertEquals(ohcDetails.get(0).getText(), coverageType);
        softAssert.assertEquals(ohcDetails.get(0).getCssValue("background"),highlightedColor(coverageTypeHighlight),coverageType+" highlight");
        softAssert.assertEquals(ohcDetails.get(1).getText(), "Job "+ SharedData.getPrimaryMember().getEmployerName());
        softAssert.assertEquals(ohcDetails.get(1).getCssValue("background"),highlightedColor(jobHighlight),"Job highlight");
        softAssert.assertEquals(ohcDetails.get(2).getText(), "Minimum Value Standard "+ minimumValueStandard);
        softAssert.assertEquals(ohcDetails.get(2).getCssValue("background"),highlightedColor(minimumValueHighlight),"Minimum Value Standard highlight");
        softAssert.assertEquals(ohcDetails.get(3).getText(), "Lowest-Cost Monthly Individual Premium Amount "+ lowestCostAmount);
        softAssert.assertEquals(ohcDetails.get(3).getCssValue("background"),highlightedColor(lowestCostAmountHighlight),"Lowest-Cost highlight");
        softAssert.assertEquals(ohcDetails.get(4).getText(), "Currently enrolled "+ currentlyEnrolled);
        softAssert.assertEquals(ohcDetails.get(4).getCssValue("background"),highlightedColor(currentlyEnrolledHighlight),"Currently enrolled highlight");
        if (insuranceEnding != null) {
            String expectedText = "Insurance ending in next 60 days";
            if (!"None".equals(insuranceEnding)) {
                expectedText += " " + insuranceEnding;
            }
            softAssert.assertEquals(ohcDetails.get(5).getText(), expectedText);
            softAssert.assertEquals(ohcDetails.get(5).getCssValue("background"), highlightedColor(insuranceEndingHighlight), "Insurance ending in next 60 days highlight");
        }
        if (endDate != null) {
            verifyBasicOhcEndDate(endDate,"End date", 6);
            softAssert.assertEquals(ohcDetails.get(6).getCssValue("background"),highlightedColor(endDateHighlight),"End date highlight");
        }
        if (voluntarilyEnding != null) {
            String expectedText = "Voluntarily ending insurance";
            if (!"None".equals(voluntarilyEnding)) {
                expectedText += " " + voluntarilyEnding;
            }
            softAssert.assertEquals(ohcDetails.get(7).getText(), expectedText);
            softAssert.assertEquals(ohcDetails.get(7).getCssValue("background"), highlightedColor(voluntarilyEndingHighlight), "Voluntarily ending insurance highlight");
        }
        if (familyPlanOffered != null) {
            softAssert.assertEquals(ohcDetails.get(8).getText(), "Family plan offered " + familyPlanOffered);
            softAssert.assertEquals(ohcDetails.get(8).getCssValue("background"), highlightedColor(familyOfferedHighlight), "Family plan offered highlight");
            if (faimlyLowestCostAmount != null) {
                String expectedText = "Lowest-Cost Monthly Family Premium Amount";
                if (!"None".equals(faimlyLowestCostAmount)) {
                    expectedText += " " + faimlyLowestCostAmount;
                }
                softAssert.assertEquals(ohcDetails.get(9).getText(), expectedText);
                softAssert.assertEquals(ohcDetails.get(9).getCssValue("background"), highlightedColor(faimlyLowestCostHighlight), "Lowest-Cost Monthly Family Premium Amount highlight");
            }
        }
        softAssert.assertAll();
    }

    public void verifyMedicareDetailsColor(List<Map<String, String>> ohcData){
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        String coverageType = ohcData.get(0).get("OHC Type");
        String coverageTypeHighlight = ohcData.get(0).get("Type Highlight");
        String currentlyEligible = ohcData.get(0).get("Currently Eligible");
        String currentlyEligibleHighlight = ohcData.get(0).get("Currently Eligible Highlight");
        String enrolled = ohcData.get(0).get("Enrolled");
        String enrolledHighlight = ohcData.get(0).get("Enrolled Highlight");
        String aPremium = ohcData.get(0).get("A Premium");
        String aPremiumHighlight = ohcData.get(0).get("A Premium Highlight");
        String aEnding = ohcData.get(0).get("A Ending");
        String aEndingHighlight = ohcData.get(0).get("A Ending Highlight");
        String aEndDate = ohcData.get(0).get("A End Date");
        String aEndDateHighlight = ohcData.get(0).get("A End Date Highlight");
        String bEnding = ohcData.get(0).get("B Ending");
        String bEndingHighlight = ohcData.get(0).get("B Ending Highlight");
        String bEndDate = ohcData.get(0).get("B End Date");
        String bEndDateHighlight = ohcData.get(0).get("B End Date Highlight");

        softAssert.assertEquals(ohcDetails.get(0).getText(), coverageType);
        softAssert.assertEquals(ohcDetails.get(0).getCssValue("background"),highlightedColor(coverageTypeHighlight),coverageType+" highlight");
        softAssert.assertEquals(ohcDetails.get(1).getText(), "Currently Eligible for Medicare Premium Free Part A "+ currentlyEligible);
        softAssert.assertEquals(ohcDetails.get(1).getCssValue("background"),highlightedColor(currentlyEligibleHighlight),"Currently Eligible highlight");
        softAssert.assertEquals(ohcDetails.get(2).getText(), "Enrolled in Part A or B "+ enrolled);
        softAssert.assertEquals(ohcDetails.get(2).getCssValue("background"),highlightedColor(enrolledHighlight),"Enrolled in highlight");
        int nextIndex = 3;
        if (aPremium != null) {
            String expectedText = "Part A Premium Amount";
            if (!"None".equals(aPremium)) {
                expectedText += " " + aPremium;
            }
            softAssert.assertEquals(ohcDetails.get(nextIndex).getText(), expectedText);
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(aPremiumHighlight), expectedText+" highlight");
            nextIndex++;
        }
        if (aEnding != null) {
            String expectedText = "Part A Ending in Next 60 Days";
            if (!"None".equals(aEnding)) {
                expectedText += " " + aEnding;
            }
            softAssert.assertEquals(ohcDetails.get(nextIndex).getText(), expectedText);
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(aEndingHighlight), expectedText+" highlight");
            nextIndex++;
        }
        if (aEndDate != null) {
            verifyBasicOhcEndDate(aEndDate, "Part A End Date", nextIndex);
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(aEndDateHighlight), "Part A End Date highlight");
            nextIndex++;
        }
        if (bEnding != null) {
            String expectedText = "Part B ending in next 60 days";
            if (!"None".equals(bEnding)) {
                expectedText += " " + bEnding;
            }
            softAssert.assertEquals(ohcDetails.get(nextIndex).getText(), expectedText);
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(bEndingHighlight), expectedText+" highlight");
            nextIndex++;
        }
        if (bEndDate != null) {
            verifyBasicOhcEndDate(bEndDate, "Part B End Date", nextIndex);
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(bEndDateHighlight), "Part A End Date highlight");
        }
        softAssert.assertAll();
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

        softAssert.assertEquals(ohcDetails.get(0).getText(), coverageType);
        softAssert.assertEquals(ohcDetails.get(0).getCssValue("background"), highlightedColor(coverageTypeHighlight), coverageType + " highlight");
        int nextIndex = 1;
        if (currentlyEnrolledHighlight != null) {
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(currentlyEnrolledHighlight), "Currently enrolled highlight");
        }
        if (currentlyEnrolled != null) {
            softAssert.assertEquals(ohcDetails.get(nextIndex).getText(), "Currently enrolled " + currentlyEnrolled);
            nextIndex++;
        }
        if (insuranceEndingHighlight != null) {
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(insuranceEndingHighlight), "Insurance ending highlight");
        }
        if (insuranceEnding != null && !"None".equals(insuranceEnding)) {
            softAssert.assertEquals(ohcDetails.get(nextIndex).getText(), "Insurance ending in next 60 days " + insuranceEnding);
            nextIndex++;
        }
        if (endDateHighlight != null) {
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(endDateHighlight), "End date highlight");
        }
        if (endDate != null) {
            verifyBasicOhcEndDate(endDate, "End date", nextIndex);
            nextIndex++;
        }
        if (voluntarilyEndingHighlight != null) {
            softAssert.assertEquals(ohcDetails.get(nextIndex).getCssValue("background"), highlightedColor(voluntarilyEndingHighlight), "Voluntarily ending highlight");
        }
        if (voluntarilyEnding != null) {
            String expectedText = "Voluntarily ending insurance";
            expectedText += " " + voluntarilyEnding;
            softAssert.assertEquals(ohcDetails.get(nextIndex).getText(), expectedText);
            nextIndex++;
        }
        softAssert.assertAll();
    }

    public String highlightedColor(String highlight) {
        return switch (highlight) {
            case "Yellow" -> "rgb(254, 246, 203) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Plain" -> "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Plain header" -> "rgb(230, 242, 213) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Red" -> "rgb(248, 218, 218) none repeat scroll 0% 0% / auto padding-box border-box";
            case "Green" -> "rgb(215, 233, 202) none repeat scroll 0% 0% / auto padding-box border-box";
            default -> throw new IllegalArgumentException("Invalid option: " + highlight);
        };
    }

    public void verifyBasicOhcEndDate(String data, String text, int getNum) {
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
                softAssert.assertEquals(ohcDetails.get(getNum).getText(), text +" "+ todayDate);
                break;
            case "Future Month":
                String futureDate = basicActions.getFutureDate(60);
                softAssert.assertEquals(ohcDetails.get(getNum).getText(), text +" "+ futureDate);
                break;
            case "Prior Month":
                String lastDayOfPriorMonth = basicActions.lastDateOfPriorMonth();
                lastDayOfPriorMonth = basicActions.changeDateFormat(lastDayOfPriorMonth, "MM-dd-yyyy", "MM/dd/yyyy");
                softAssert.assertEquals(ohcDetails.get(getNum).getText(), text +" "+ lastDayOfPriorMonth);
                break;
            case "Current Month":
                String lastDayOfMonth = basicActions.lastDateOfCurrMonth();
                lastDayOfMonth = basicActions.changeDateFormat(lastDayOfMonth, "MM-dd-yyyy", "MM/dd/yyyy");
                softAssert.assertEquals(ohcDetails.get(getNum).getText(), text +" "+ lastDayOfMonth);
                break;
            case "Future Day":
                String futureDate1 = basicActions.getFutureDate(daysInFuture);
                softAssert.assertEquals(ohcDetails.get(getNum).getText(), text +" "+ futureDate1);
                break;
            case "None":
                softAssert.assertEquals(ohcDetails.get(getNum).getText(), text);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + data);
        }
    }

    public void verifyNoneOhcDetailsColor(List<Map<String, String>> ohcData){
        basicActions.waitForElementToBePresent(hdrOtherHealthCoverage,20);
        String noneHighlight = ohcData.get(0).get("None Highlight");
        String removedNumber = ohcData.get(0).get("Removed");
        String removedHighlight = ohcData.get(0).get("Removed Highlight");

        softAssert.assertEquals(ohcDetails.get(0).getText(), "None");
        softAssert.assertEquals(ohcDetails.get(0).getCssValue("background"),highlightedColor(noneHighlight),"None highlight");
        if (removedNumber != null) {
            softAssert.assertEquals(ohcDetails.get(1).getText(), removedNumber + " Current Coverage(s) removed");
            softAssert.assertEquals(ohcDetails.get(1).getCssValue("background"),highlightedColor(removedHighlight),"Remove highlight");
        }
        softAssert.assertAll();
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
                        enrolledMembers.add(basicActions.getCompleteFullNameWithPrefix(name));
                    }
                    break;
                case "Offered a plan but not enrolled":
                    if (!name.isEmpty()) {
                        offeredMembers.add(basicActions.getCompleteFullNameWithPrefix(name));
                    }
                    break;
                case "No option to enroll":
                    if (!name.isEmpty()) {
                        noOptionMembers.add(basicActions.getCompleteFullNameWithPrefix(name));
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid relation: " + relation);
            }

            int index = switch (relation) {
                case "Enrolled" -> 10;
                case "Offered a plan but not enrolled" -> 11;
                case "No option to enroll" -> 12;
                default -> throw new IllegalArgumentException("Invalid relation: " + relation);
            };

            softAssert.assertEquals(ohcDetails.get(index).getCssValue("background"),highlightedColor(highlight));
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

    private static String extractTextFromPDF(Path pdfPath) throws IOException {
        try (PDDocument document = Loader.loadPDF(new File(String.valueOf(pdfPath)))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

    public boolean verifyEsiPdfText(String language, List<Map<String, String>> pdfData)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));
        String coverageType = pdfData.get(0).get("OHC Type");
        String minimumValueStandard = pdfData.get(0).get("Minimum Value Standard");
        String lowestCostAmount = pdfData.get(0).get("Lowest-Cost Monthly Individual Premium Amount");
        String currentlyEnrolled = pdfData.get(0).get("Currently enrolled");
        String insuranceEnding = pdfData.get(0).get("Insurance ending in next 60 days");
        String endDate = pdfData.get(0).get("End date");
        String voluntarilyEnding = pdfData.get(0).get("Voluntarily ending");

        // Verify the text
        switch (language){
            case "English":
                String startPhrase = "Other Health Coverage";
                int startIndex = pdfContent.indexOf(startPhrase);
                if (startIndex != -1) {
                    String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                    if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getEsiApplicationDetails(coverageType, minimumValueStandard,  lowestCostAmount, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationDetailsPdf.getEsiApplicationDetails(coverageType, minimumValueStandard,  lowestCostAmount, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding).split("\n");

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
                    if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getEsiApplicationDetailsSp(coverageType, minimumValueStandard,  lowestCostAmount, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationDetailsPdf.getEsiApplicationDetailsSp(coverageType, minimumValueStandard,  lowestCostAmount, currentlyEnrolled, insuranceEnding, endDate, voluntarilyEnding).split("\n");

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

    public boolean verifyMedicarePdfText(String language, List<Map<String, String>> pdfData)throws IOException {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath+"//"+fileName;
        System.out.println("path and name is "+pathAndName);
        // Read the PDF content using PDFBox
        String pdfContent = extractTextFromPDF(Path.of(pathAndName));
        String coverageType = pdfData.get(0).get("OHC Type");
        String premiumFree = pdfData.get(0).get("Premium Free");
        String enrolled = pdfData.get(0).get("Enrolled");
        String partAPremium = pdfData.get(0).get("Part A Premium");
        String partAEnding = pdfData.get(0).get("Part A Ending");
        String partAEndDate = pdfData.get(0).get("Part A End Date");
        String partBEnding = pdfData.get(0).get("Part B Ending");
        String partBEndDate = pdfData.get(0).get("Part B End Date");

        // Verify the text
        switch (language){
            case "English":
                String startPhrase = "Other Health Coverage";
                int startIndex = pdfContent.indexOf(startPhrase);
                if (startIndex != -1) {
                    String pdfContentFromStartPhrase = pdfContent.substring(startIndex);
                    if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getMedicareApplicationDetails(coverageType, premiumFree, enrolled, partAPremium, partAEnding, partAEndDate, partBEnding, partBEndDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationDetailsPdf.getMedicareApplicationDetails(coverageType, premiumFree, enrolled, partAPremium, partAEnding, partAEndDate, partBEnding, partBEndDate).split("\n");

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
                    if (!pdfContentFromStartPhrase.contains(ApplicationDetailsPdf.getMedicareApplicationDetailsSp(coverageType, premiumFree, enrolled, partAPremium, partAEnding, partAEndDate, partBEnding, partBEndDate))) {
                        String[] pdfLines = pdfContentFromStartPhrase.split("\n");
                        String[] expectedLines = ApplicationDetailsPdf.getMedicareApplicationDetailsSp(coverageType, premiumFree, enrolled, partAPremium, partAEnding, partAEndDate, partBEnding, partBEndDate).split("\n");

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
        if ("Individual Insurance (Outside of Marketplace)".equals(coverageType)) {
            coverageType = "Individual Insurance (Outside of \nMarketplace)";
        }
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
