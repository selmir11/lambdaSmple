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
       basicActions.waitForElementToBePresent(txtDetailedEdiReportPrimary, 1500);
        basicActions.waitForElementToBePresent(txtDetailedEdiReportAccount, 1500);
        basicActions.waitForElementToBePresent(reportTitle, 1500);
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertTrue(txtDetailedEdiReportPrimary.isDisplayed(),"message should display");
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(),"Primary Account Holder: TestSubscribernltzytxtdj Usernltzytxtdj");
            softAssert.assertEquals(txtDetailedEdiReportAccount.getText(), "Account ID: 1103056956 , 174934661");

        } else {
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Primary Account Holder: Natalie Rushman");
            softAssert.assertEquals(txtDetailedEdiReportAccount.getText(), "Account ID: 2002009179 , 210777727");
        }
        softAssert.assertAll();
    }


    public void SelectCoveragetypedropdowns(String text){
        basicActions.selectValueFromDropdown(coverageTypeDropdown, selectCoverageType, text);
        searchButton.click();
    }

    public void selectYearToAnyENV(String year) {
      basicActions.selectValueFromDropdown(planyeardropdown, selectYear,year);
    }


    public void validateInsuranceRecordsDisplay(String InsuranceType) {
        searchButton.click();
        basicActions.waitForElementListToBePresentWithRetries(carrierName, 2000);
        List<String> expectedNames = new ArrayList<>();

        if ("medical".equalsIgnoreCase(InsuranceType)) {
            if (SharedData.getEnv().equals("staging")) {
                expectedNames.add("Kaiser Permanen..");
                expectedNames.add("Kaiser Foundati..");
            } else {
                expectedNames.add("Kaiser Permanen..");
            }
        } else if ("dental".equalsIgnoreCase(InsuranceType)) {
            if (SharedData.getEnv().equals("staging")) {
                expectedNames.add("Delta Dental");
            } else {
                expectedNames.add("Delta Dental");
            }
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
            int expectedCount = 1;
            int actualCount = actualCountMap.getOrDefault(expectedName, 0);

            softAssert.assertTrue(actualCount > 0,
                    "Expected name '" + expectedName + "' not found in actual names.");
        }
        softAssert.assertAll();
    }
    public void validatemedicalanddentalrecords() {

        basicActions.waitForElementListToBePresent(OutboundEDIHeaders, 5000);
            String[] expectedOutboundHeaders = {
                    "Date Sent", "Carrier Name", "Member Name", "Date of Birth", "Person ID",
                    "Assigned Policy ID", "Relationship", "Plan ID", "Total Premium",
                    "Total APTC", "Maint. Type", "Maint. Reason Code", "Plan Start Date",
                    "Plan End Date", "File Name"
            };
        String[] expectedInboundHeaders = {
                "Date Received", "Carrier Name", "Member Name", "Date of Birth", "Person ID",
                 "Plan ID", "Maint. Type", "Maint. Reason Code", "Plan Start Date",
                 "Plan End Date", "File Name"
        };
            verifyElements(OutboundEDIHeaders, expectedOutboundHeaders, softAssert, "Outbound Header mismatch");
            verifyElements(InboundEDIHeaders, expectedInboundHeaders, softAssert, "Inbound Header mismatch");

           String[] outboundfirstRow;
           String[] outboundsecondRow;
           String[] InboundfirstRow;
           String[] InboundsecondRow;
           
            if(SharedData.getEnv().equals("staging")) {
                outboundfirstRow = new String[]{
                        "10/04/2024", "Delta Dental", "Natalie Rushman", "12/03/1995",
                        "6407972338", "7066290002", "SELF", "28052CO0020004",
                        "37.75", "0.00", "ADD", "INITIAL_ENROLLM..", "01/01/2025",
                        "12/31/2025", "834_DELTADENTAL.."
                };
                outboundsecondRow = new String[]{
                        "10/17/2024", "Kaiser Permanen..", "Natalie Rushman", "12/03/1995",
                        "6407972338", "9002206070", "SELF", "21032CO0410065",
                        "770.79", "0.00", "CHANGE", "NO_REASON_GIVEN", "01/01/2025",
                        "12/31/2025", "834_KPCONNECTOR.."
                };
                InboundfirstRow = new String[]{
                        "10/11/2024", "Kaiser Foundati..", "NATALIE RUSHMAN", "12/03/1995",
                        "6407972338", "21032CO0410065", "ADD", "EFFECTUATED", "01/01/2025",
                        "12/31/2025", "834_KPCONNECTOR.."
                };
                InboundsecondRow = new String[]{
                        "10/22/2024", "Kaiser Foundati..", "NATALIE RUSHMAN", "12/03/1995",
                        "6407972338", "21032CO0410065", "ADD", "EFFECTUATED", "01/01/2025",
                        "12/31/2025", "834_KPCONNECTOR.."
                };
            }
            else {
                outboundfirstRow = new String[]{
                        "10/24/2024", "Delta Dental", "TestSonnltzytxtdj Us..", "08/28/1999",
                        "3526021750", "1901030135", "SELF", "28052CO0020006",
                        "50.50", "28.00", "ADD", "RENEWAL", "01/01/2025",
                        "12/31/2025", "834_DELTADENTAL.."
                };
                outboundsecondRow = new String[]{
                        "10/24/2024", "Kaiser Permanen..", "TestDILnltzytxtdj Us..", "05/05/2001",
                        "4207592595", "8061331000", "SPOUSE", "21032CO0410052",
                        "0.00", "0.00", "ADD", "RENEWAL", "01/01/2025",
                        "12/31/2025", "834_KPCONNECTOR.."
                };
                InboundfirstRow = new String[]{
                        "10/24/2024", "Delta Dental", "TestSonnltzytxtdj Us..", "08/28/1999",
                        "3526021750", "28052CO0020006", "ADD", "EFFECTUATED", "01/01/2025",
                        "12/31/2025", "834_DELTADENTAL.."
                };

                InboundsecondRow = new String[]{
                        "10/24/2024", "Delta Dental","TestDILnltzytxtdj Us..", "05/05/2001",
                        "4207592595", "28052CO0020006", "ADD", "EFFECTUATED", "01/01/2025",
                        "12/31/2025", "834_DELTADENTAL.."
                };

            }
            verifyElements(FirstRowoutboundEDI, outboundfirstRow, softAssert, "outbound Row 1st mismatch");
            verifyElements(SecondRowoutboundEDI, outboundsecondRow, softAssert, "outbound Row 2nd mismatch");
            verifyElements(firstRowInboundEDI, InboundfirstRow, softAssert, "Inbound Row 1st mismatch");
            verifyElements(SecondRowInboundEDI, InboundsecondRow, softAssert, "Inbound Row 2nd mismatch");
            softAssert.assertAll();
        }

        private void verifyElements (List < WebElement > actualElements, String[]expectedElements, SoftAssert
        softAssert, String messagePrefix){
            int minSize = Math.min(actualElements.size(), expectedElements.length);
            for (int i = 0; i < minSize; i++) {
                String actualText = actualElements.get(i).getText().trim();
                softAssert.assertEquals(actualText, expectedElements[i],
                        messagePrefix + " at index " + i + ": Expected '" + expectedElements[i] + "', but got '" + actualText + "'");
            }
        }
    }


