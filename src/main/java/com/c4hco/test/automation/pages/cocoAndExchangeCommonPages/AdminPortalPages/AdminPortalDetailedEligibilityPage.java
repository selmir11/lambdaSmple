package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;

import java.util.*;

public class AdminPortalDetailedEligibilityPage {

    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalDetailedEligibilityPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='dashboardHeader1']")
    WebElement detailedEligibilityHeader;

    @FindBy(xpath = "//*[@class='dashboardHeader2']")
    WebElement detailedEligibilityAcctHeader;

    @FindBy(xpath = "//*[@class='group-title']")
    List<WebElement> detailedEligibilityLabel;

    @FindBy(xpath = "//*[@class='heading3']")
    List<WebElement> houseHoldLevelTxt;

    @FindBy(xpath = "//*[@id='applicationId']/preceding-sibling::td")
    WebElement EligibilityAcctIDTxt;

    @FindBy(xpath = "//*[@id='applicationId']")
    List<WebElement> EligibilityAcctID;

    @FindBy(xpath = "//*[@id='submittedDate']/preceding-sibling::td")
    WebElement submittedDateLabel;

    @FindBy(xpath = "//*[@id='submittedDate']")
    List<WebElement> submittedDate;

    @FindBy(xpath = "//*[@id='applicationPurpose']/preceding-sibling::td")
    WebElement applicationPurposeLabel;

    @FindBy(xpath = "//*[@id='applicationPurpose']")
    List<WebElement> applicationPurpose;

    @FindBy(xpath = "//*[@id='totalAptc']/preceding-sibling::td")
    WebElement totalAPTCLabel;

    @FindBy(xpath = "//*[@id='totalAptc']")
    WebElement totalAptc;

    @FindBy(xpath = "//*[@id='eligibilityStatus']/preceding-sibling::td")
    List<WebElement> eligibilityStatusLabel;

    @FindBy(xpath = "//*[@id='eligibilityStatus']")
    List<WebElement> eligibilityStatus;

    @FindBy(xpath = "//*[@class='elig-summary-table']/tr/td")
    List<WebElement> householderFields;

    @FindBy(xpath = "//*[@id='eventType']//preceding::tr[1]/th")
    List<WebElement> LCEColNamel;

    @FindBy(xpath = "//*[@id='eventType']")
    WebElement LCEName;

    @FindBy(xpath = "//*[@id='memberName']")
    List<WebElement> LCEMemberName;

    @FindBy(xpath = "//*[@id='eventDate']")
    WebElement LCEEventDate;

    @FindBy(xpath = "//*[@class='application-container']/div/span")
    List<WebElement> PreviousApplnFields;

    @FindBy(xpath = "//*[@class='application-container']")
    List<WebElement> PreviousApplnContainer;

    @FindBy(xpath = "//*[@class='table-container'][2]//tr")
    List<WebElement> memberContainer;

    @FindBy(xpath = "//*[@class='table-container'][2]//tr/th")
    List<WebElement> memberColName;

    @FindBy(xpath = "//*[@class='table-container'][2]//tr")
    List<WebElement> memberRow;

    @FindBy(xpath = "//*[@id='csr']")
    List<WebElement> memberCSR;

    @FindBy(xpath = "//*[@id='relationship']")
    List<WebElement> memberRelationship;

    @FindBy(xpath = "//*[@id='taxFilerType']")
    List<WebElement> memberTaxFilerType;

    @FindBy(xpath = "//*[@class='application-container']")
    List<WebElement> PreviousAppln;

    @FindBy(xpath = "//*[text()='Application ID:']")
    List<WebElement> applnLabel;

    @FindBy(xpath = "//*[text()='APTC amount:']")
    List<WebElement> APTCAmountLabel;

    @FindBy(xpath = "//*[text()='Submitted on:']")
    List<WebElement> SubmittedLabel;

    @FindBy(xpath = "//*[text()='Application Purpose:']")
    List<WebElement> applnPurposeLabel;

    @FindBy(xpath = "//*[@class='application-container']//*[@id='applicationId']")
    List<WebElement> previousApplnID;

    @FindBy(xpath = "//*[@class='application-container']//*[@id='aptc1']")
    List<WebElement> previousAPTC;

    @FindBy(xpath = "//*[@class='application-container']//*[@id='submittedDate']")
    List<WebElement> previousSubmit;
    @FindBy(xpath = "//*[@class='application-container']//*[@id='applicationPurpose']")
    List<WebElement> previousApplnPurpose;

    public void verifyPrimaryHolderandAcctDetailsOnEligiblity(List<Map<String, String>> data) {
        basicActions.wait(50);
        basicActions.refreshPage();
        basicActions.waitForElementToBePresent(EligibilityAcctIDTxt, 100);
        softAssert.assertTrue(EligibilityAcctIDTxt.isDisplayed());

        String columnToUse = SharedData.getEnv().equals("staging") ? "staging" : "qa";

        String PrimaryHolderName = data.get(0).get(columnToUse);
        String AccountID = data.get(1).get(columnToUse);

        basicActions.waitForElementToBePresent(detailedEligibilityHeader, 100);
        softAssert.assertTrue(detailedEligibilityHeader.isDisplayed());

        basicActions.waitForElementToBePresent(detailedEligibilityAcctHeader, 100);
        softAssert.assertTrue(detailedEligibilityAcctHeader.isDisplayed());

        softAssert.assertEquals(detailedEligibilityHeader.getText(), "Primary Account Holder: " + PrimaryHolderName);

        int commaIndex = detailedEligibilityAcctHeader.getText().indexOf(',');
        String accountIdFromHeader = detailedEligibilityAcctHeader.getText().substring(0, commaIndex).trim();
        softAssert.assertEquals(accountIdFromHeader, "Account ID: " + AccountID);

        softAssert.assertAll();
    }

    public void verifyDetailedEligibilityHeader() {
        basicActions.waitForElementListToBePresentWithRetries(detailedEligibilityLabel, 100);
        softAssert.assertEquals(detailedEligibilityLabel.get(0).getText(), "Detailed Eligibility");
        softAssert.assertAll();
    }

    public void validateHouseHoldHeader() {
        basicActions.waitForElementListToBePresentWithRetries(houseHoldLevelTxt, 100);
        softAssert.assertEquals(houseHoldLevelTxt.get(0).getText(), "Household level application and eligibility data");
        softAssert.assertAll();
    }

    public void householdDetails(DataTable data) {
        String currentEnv = SharedData.getEnv();
        Map<String, String> filteredData = getRowForEnv(data, currentEnv);
        validateHousehold(filteredData, householderFields);
    }

    private Map<String, String> getRowForEnv(DataTable data, String currentEnv) {
        return data.asMaps().stream().filter(row -> row.get("Env").equals(currentEnv)).findFirst().orElseThrow(() -> new RuntimeException("no data"));
    }

    private void validateHousehold(Map<String, String> envRow, List<WebElement> householderFields) {
         basicActions.wait(100);
        basicActions.waitForElementListToBePresentWithRetries(householderFields, 300);
        int index = 0;
        for (Map.Entry<String, String> entry : envRow.entrySet()) {
            if (entry.getKey().equals("Env")) {
                continue; // skip Env col and move to next col to fetch fields
            }
            String expectedLabel = entry.getKey();
            String expectedValue = Optional.ofNullable(entry.getValue()).orElse("");
            basicActions.wait(100);

            WebElement fieldLabel = householderFields.get(index);
            WebElement fieldValue = householderFields.get(index + 1);

            String actualLabel = getFieldLabel(fieldLabel);
            String actualValue = getFieldLabel(fieldValue);

            softAssert.assertEquals(actualLabel, expectedLabel, "label mismatch at index " + index);
            softAssert.assertEquals(actualValue, expectedValue, " value not match for label " + expectedLabel);
            index += 2;
        }
        softAssert.assertAll();
    }

    private String getFieldLabel(WebElement fieldLabel) {
        return (String) ((JavascriptExecutor) basicActions.getDriver()).executeScript("return arguments[0].innerText", fieldLabel);
    }

    public void validateMemberLevelHeader() {
        basicActions.wait(100);
        basicActions.waitForElementListToBePresentWithRetries(houseHoldLevelTxt, 100);
        softAssert.assertEquals(houseHoldLevelTxt.get(1).getText(), "Member level eligibility data");
        softAssert.assertAll();
    }

    public void validateMemberLevelDetails(List<Map<String, String>> data) {
        basicActions.wait(200);
        String env = SharedData.getEnv();
        List<Map<String, String>> envRows = data.stream().filter(row -> row.get("Env").equalsIgnoreCase(env)).toList();

        List<String> expectedHeaders = new ArrayList<>(data.get(0).keySet());
        expectedHeaders.remove("Env");

        validateMemberLevelColHeader(expectedHeaders);
        validateMemberLevelTableValues(envRows, expectedHeaders);
    }

    private void validateMemberLevelColHeader(List<String> expectedHeaders) {
        basicActions.waitForElementListToBePresentWithRetries(memberContainer, 200);
        List<String> Headers = memberColName.stream().map(WebElement::getText).toList();
        softAssert.assertEquals(Headers, expectedHeaders, " Table header not match");
        softAssert.assertAll();
    }

    private void validateMemberLevelTableValues(List<Map<String, String>> expectedData, List<String> expectedHeaders) {
        basicActions.wait(50);
        basicActions.waitForElementListToBePresentWithRetries(memberColName,100);
        basicActions.waitForElementListToBePresentWithRetries(memberRow, 200);

        int headOffSet = 1;
        int actualDataRowCount = memberRow.size() - headOffSet;
        if (expectedData.size() > actualDataRowCount) {
            Assert.fail("Mismatch : expected " + expectedData.size() + "data row , but found " + actualDataRowCount);
        }
        for (int i = 0; i < expectedData.size(); i++) {
            Map<String, String> expectedRow = expectedData.get(i);
            List<WebElement> cells = memberRow.get(i + headOffSet).findElements(By.tagName("td"));

            for (int j = 0; j < expectedHeaders.size(); j++) {
                String col = expectedHeaders.get(j);
                String expectedValue = Optional.ofNullable(expectedRow.get(col)).orElse("");
                String actualValue = cells.get(j).getText();

                softAssert.assertEquals(actualValue, expectedValue, "value not mactch " + (i + 1) + " , column: " + col);
            }
        }
        softAssert.assertAll();
    }

    public void validateLCEHeader() {
        basicActions.waitForElementListToBePresentWithRetries(houseHoldLevelTxt, 100);
        softAssert.assertEquals(houseHoldLevelTxt.get(2).getText(), "Life change events");
        softAssert.assertAll();
    }

    public void validateLCDetails(List<Map<String, String>> data) {
        String env = SharedData.getEnv();
        List<Map<String, String>> envrows = data.stream().filter(row -> row.get("Env").equalsIgnoreCase(env)).toList();

        List<String> expectedHeaders = new ArrayList<>(data.get(0).keySet());
        expectedHeaders.remove("Env");

        validateLCEColName(expectedHeaders);
        validateLCETableValues(envrows, expectedHeaders);
    }


    private void validateLCEColName(List<String> expectedHeaders) {
        basicActions.wait(300);
        List<WebElement> actualHeaders = basicActions.getDriver().findElements(By.xpath("//*[@class='table-container'][3]//tr/th"));
        List<String> Headers = actualHeaders.stream().map(WebElement::getText).toList();
        softAssert.assertEquals(Headers, expectedHeaders, " Table header not match");
        softAssert.assertAll();
    }

    private void validateLCETableValues(List<Map<String, String>> expectedData, List<String> expectedHeaders) {
        basicActions.wait(300);
        List<WebElement> actualRows = basicActions.getDriver().findElements(By.xpath("//*[@class='table-container'][3]//tr"));

        for (int i = 0; i < expectedData.size(); i++) {
            Map<String, String> expectedrow = expectedData.get(i);

            List<WebElement> cells = actualRows.get(i + 1).findElements(By.tagName("td"));

            for (int j = 0; j < expectedHeaders.size(); j++) {
                String col = expectedHeaders.get(j);
                String expectedValue = Optional.ofNullable(expectedrow.get(col)).orElse("");
                String actualValue = cells.get(j).getText();

                softAssert.assertEquals(actualValue, expectedValue, "value not mactch " + (i + 1) + " , column: " + col);
            }
        }
        softAssert.assertAll();
    }

    public void validatePreviousApplnHeader() {
        basicActions.waitForElementListToBePresentWithRetries(detailedEligibilityLabel, 100);
        softAssert.assertEquals(detailedEligibilityLabel.get(1).getText(), "Previous Applications");
        softAssert.assertAll();

    }

    public void validatePreviousContainerDetails(List<Map<String, String>> data) {
        String currentEnv = SharedData.getEnv();
        List<Map<String, String>> filteredData = data.stream().filter(row -> row.get("Env").equalsIgnoreCase(currentEnv)).toList();
        for (Map<String, String> row : filteredData) {
            validateAppData(row);
        }
    }

    private void validateAppData(Map<String, String> expectedData) {
        basicActions.waitForElementListToBePresentWithRetries(PreviousAppln,100);
        String expectedPlanYear = expectedData.get("Plan Year");
        boolean matchfound = false;
        for (WebElement container : PreviousAppln) {
            List<WebElement> fields = container.findElements(By.xpath(".//span"));
            basicActions.waitForElementListToBePresentWithRetries(fields,100);
            String actualPlanYear = fields.get(0).getText();
            if (actualPlanYear.equals(expectedPlanYear)) {
                matchfound = true;

                softAssert.assertEquals(fields.get(1).getText(), "Application ID:", "Appln ID not match for" + expectedPlanYear);
                softAssert.assertEquals(fields.get(2).getText(), expectedData.get("Application ID:"), "Appln ID value not match for" + expectedPlanYear);

                softAssert.assertEquals(fields.get(3).getText(), "APTC amount:", "Appln ID not match for" + expectedPlanYear);
                softAssert.assertEquals(fields.get(4).getText(), expectedData.get("APTC amount:"), "Appln ID value not match for" + expectedPlanYear);

                softAssert.assertEquals(fields.get(5).getText(), "Submitted on:", " Submitted on label match for" + expectedPlanYear);
                softAssert.assertEquals(fields.get(6).getText(), expectedData.get("Submitted on:"), "submitted date value not match for" + expectedPlanYear);

                softAssert.assertEquals(fields.get(7).getText(), "Application Purpose:", "Application Purpose label not match for" + expectedPlanYear);
                softAssert.assertEquals(fields.get(8).getText(), expectedData.get("Application Purpose:"), "Application Purpose value not match for" + expectedPlanYear);
                break;
            }
        }
        if (!matchfound) {
            Assert.fail("No container fouind for plan year " + expectedPlanYear);
        }
        softAssert.assertAll();
    }

    public void validatePreviousApplicationOrder() {
        List<Date> submitted = extractSubmittedDate();
        verifyApplnOrder(submitted);
    }

    private List<Date> extractSubmittedDate() {
        List<Date> dates = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mma");
        for (WebElement container : PreviousApplnContainer) {
            List<WebElement> fields = container.findElements(By.xpath(".//span"));
            String dateText = fields.get(6).getText();
            try {
                dates.add(dateFormat.parse(dateText));
            } catch (Exception e) {
                throw new RuntimeException("Invalid submitted year: ");
            }
        }
        return dates;
    }

    private void verifyApplnOrder(List<Date> dates) {
        for (int i = 0; i < dates.size() - 1; i++) {
            if (dates.get(i).before(dates.get(i + 1))) {
                throw new AssertionError("Submitted date out of order: " + dates.get(i) + " is before " + dates.get(i + 1));
            }
        }
    }
}
