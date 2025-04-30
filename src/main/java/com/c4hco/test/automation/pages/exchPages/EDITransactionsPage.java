package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EDITransactionsPage {
    SoftAssert softAssert = new SoftAssert();
    BasicActions basicActions;

    public EDITransactionsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    //Header
    @FindBy(xpath = "//h2[contains(normalize-space(), 'Primary Account Holder: ')]")
    WebElement txtDetailedEdiReportPrimary;
    @FindBy(xpath = "//h3[contains(., 'Account ID:')]")
    WebElement txtDetailedEdiReportAccount;

    @FindBy(xpath = "//app-drop-down-select[@id='coverage-type']//div[@class='drop-down-option drop-down-option-selected']")
    WebElement coverageTypeDropdown;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//div")
    List<WebElement> selectCoverageType;

    //Container Header
    @FindBy(xpath = "//h1[normalize-space()='EDI Transaction Details']")
    WebElement reportTitle;

    @FindBy(xpath = "//app-drop-down-select[@id='plan-year']//div[@class='drop-down-option drop-down-option-selected']")
    WebElement planyeardropdown;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//span")
    List<WebElement> selectYear;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[2]/div[2]/app-data-grid-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/td")
    List<WebElement> OutboundEDIHeaders;

    @FindBy(xpath = "//div[2]/div[3]/app-data-grid-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/td")
    List<WebElement> InboundEDIHeaders;

    @FindBy(xpath = "//div[2]/div[2]/app-data-grid-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td/app-max-length-tooltip[1]/span[1]")
    List<WebElement> FirstRowoutboundEDI;

    @FindBy(xpath = "//div[2]/div[2]/app-data-grid-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td/app-max-length-tooltip[1]/span[1]")
    List<WebElement> SecondRowoutboundEDI;

    @FindBy(xpath = "//div[2]/div[3]/app-data-grid-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td")
    List<WebElement> firstRowInboundEDI;

    @FindBy(xpath = "//div[2]/div[3]/app-data-grid-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td")
    List<WebElement> SecondRowInboundEDI;

    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> carrierName;

    public void verifyEDITransactionHeaders() {
        basicActions.waitForElementToBePresent(txtDetailedEdiReportPrimary, 2000);
        basicActions.waitForElementToBePresent(txtDetailedEdiReportAccount, 1500);
        basicActions.waitForElementToBePresent(reportTitle, 1500);
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Primary Account Holder: TestSubscribernltzytxtdj Usernltzytxtdj");
            softAssert.assertEquals(txtDetailedEdiReportAccount.getText(), "Account ID: 1103056956 , 174934661");
        } else {
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Primary Account Holder: Natalie Rushman");
            softAssert.assertEquals(txtDetailedEdiReportAccount.getText(), "Account ID: 2002009179 , 210777727");
        }
        softAssert.assertAll();
    }

    public void SelectCoveragetypedropdowns(String text) {
        basicActions.selectValueFromDropdown(coverageTypeDropdown, selectCoverageType, text);
        searchButton.click();
    }

    public void selectYearToAnyENV(String year) {
        basicActions.selectValueFromDropdown(planyeardropdown, selectYear, year);
    }


    public void validateInsuranceRecordsDisplay(String insuranceType) {
        searchButton.click();
        basicActions.waitForElementListToBePresentWithRetries(carrierName, 2000);
        List<String> expectedNames = new ArrayList<>();
        switch (insuranceType.toLowerCase()) {
            case "medical":
                expectedNames.add("Kaiser Permanen..");
                if ((SharedData.getEnv().equals("staging"))) {
                    expectedNames.add("Kaiser Foundati..");
                }
                break;
            case "dental":
                expectedNames.add("Delta Dental");
                break;
            default: throw new IllegalArgumentException("Unexpected insurance type: " + insuranceType);
        }

        List<String> actualNames = new ArrayList<>();
        for (WebElement row : carrierName) {
            String rowText = row.getText().trim();
            actualNames.add(rowText);
        }

        HashMap<String, Integer> actualCountMap = new HashMap<>();
        for (String name : actualNames) {
            actualCountMap.put(name, actualCountMap.getOrDefault(name, 0) + 1);
        }

        for (String expectedName : expectedNames) {
            int actualCount = actualCountMap.getOrDefault(expectedName, 0);
            softAssert.assertTrue(actualCount > 0,
                    "Expected name '" + expectedName + "' not found in actual names.");
        }
        softAssert.assertAll();
    }

    public void validateMedicalAndDentalRecords(String validationOption) {
        basicActions.waitForElementListToBePresent(OutboundEDIHeaders, 5000);

        switch (validationOption) {
            case "Outbound Header":
                validateHeaders(OutboundEDIHeaders, List.of(
                        "Date Sent", "Carrier Name", "Member Name", "Date of Birth", "Person ID",
                        "Assigned Policy ID", "Relationship", "Plan ID", "Total Premium",
                        "Total APTC", "Maint. Type", "Maint. Reason Code", "Plan Start Date",
                        "Plan End Date", "File Name"));
                break;

            case "Inbound headers":
                validateHeaders(InboundEDIHeaders, List.of(
                        "Date Received", "Carrier Name", "Member Name", "Date of Birth", "Person ID",
                        "Plan ID", "Maint. Type", "Maint. Reason Code", "Plan Start Date",
                        "Plan End Date", "File Name"));
                break;

            case "outboundfirstRow":
                validateRow("outboundfirstRow", FirstRowoutboundEDI, getOutboundFirstRowData());
                break;

            case "outboundsecondRow":
                validateRow("outboundsecondRow", SecondRowoutboundEDI, getOutboundSecondRowData());
                break;

            case "InboundfirstRow":
                validateRow("InboundfirstRow", firstRowInboundEDI, getInboundFirstRowData());
                break;

            case "InboundsecondRow":
                validateRow("InboundsecondRow", SecondRowInboundEDI, getInboundSecondRowData());
                break;

            default: throw new IllegalArgumentException("Unexpected insurance type: " + validationOption);

        }

    }

    private void validateHeaders(List<WebElement> actualHeaders, List<String> expectedHeaders) {
        List<String> optionsList = actualHeaders.stream().map(WebElement::getText).toList();
        softAssert.assertEquals(optionsList, expectedHeaders, "Header mismatch!");
        softAssert.assertAll();
    }

    private void validateRow(String validationOption, List<WebElement> actualRow, List<String> expectedRow) {
        List<String> rowText = actualRow.stream().map(WebElement::getText).toList();
        softAssert.assertEquals(rowText, expectedRow, "Mismatch for " + validationOption);
        softAssert.assertAll();
    }

    private List<String> getOutboundFirstRowData() {
        if (SharedData.getEnv().equals("staging")) {
            return List.of(
                    "10/04/2024", "Delta Dental", "Natalie Rushman", "12/03/1995",
                    "6407972338", "7066290002", "SELF", "28052CO0020004",
                    "37.75", "0.00", "ADDITION", "QHP_SELECTED", "01/01/2025",
                    "12/31/2025", "834_DELTADENTAL..");
        } else {
            return List.of(
                    "10/24/2024", "Delta Dental", "TestSonnltzytxtdj Us..", "08/28/1999",
                    "3526021750", "1901030135", "SELF", "28052CO0020006",
                    "50.50", "28.00", "ADD", "RENEWAL", "01/01/2025",
                    "12/31/2025", "834_DELTADENTAL..");
        }
    }

    private List<String> getOutboundSecondRowData() {
        if (SharedData.getEnv().equals("staging")) {
            return List.of(
                    "10/17/2024", "Kaiser Permanen..", "Natalie Rushman", "12/03/1995",
                    "6407972338", "9002206070", "SELF", "21032CO0410065",
                    "770.79", "0.00", "MAINTENANCE", "NO_REASON_GIVEN", "01/01/2025",
                    "12/31/2025", "834_KPCONNECTOR..");
        } else {
            return List.of(
                    "10/24/2024", "Kaiser Permanen..", "TestDILnltzytxtdj Us..", "05/05/2001",
                    "4207592595", "8061331000", "SPOUSE", "21032CO0410052",
                    "0.00", "0.00", "ADD", "RENEWAL", "01/01/2025",
                    "12/31/2025", "834_KPCONNECTOR..");
        }
    }

    private List<String> getInboundFirstRowData() {
        if (SharedData.getEnv().equals("staging")) {
            return List.of(
                    "10/11/2024", "Kaiser Foundati..", "NATALIE RUSHMAN", "12/03/1995",
                    "6407972338", "21032CO0410065", "ADDITION", "INITIAL_ENROLLM..", "01/01/2025",
                    "12/31/2025", "834_KPCONNECTOR..");
        } else {
            return List.of(
                    "10/24/2024", "Delta Dental", "TestSonnltzytxtdj Us..", "08/28/1999",
                    "3526021750", "28052CO0020006", "ADD", "EFFECTUATED", "01/01/2025",
                    "12/31/2025", "834_DELTADENTAL..");
        }
    }

    private List<String> getInboundSecondRowData() {
        if (SharedData.getEnv().equals("staging")) {
            return List.of(
                    "10/22/2024", "Kaiser Foundati..", "NATALIE RUSHMAN", "12/03/1995",
                    "6407972338", "21032CO0410065", "ADDITION", "INITIAL_ENROLLM..", "01/01/2025",
                    "12/31/2025", "834_KPCONNECTOR..");
        } else {
            return List.of(
                    "10/24/2024", "Delta Dental", "TestDILnltzytxtdj Us..", "05/05/2001",
                    "4207592595", "28052CO0020006", "ADD", "EFFECTUATED", "01/01/2025",
                    "12/31/2025", "834_DELTADENTAL..");
        }
    }
}






