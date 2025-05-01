package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExclusionReasonPage {
    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public ExclusionReasonPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

//Header
    @FindBy(css = ".dashboardHeader1")
    WebElement txtExclusionReportPrimary;
    @FindBy(css = ".dashboardHeader2")
    WebElement txtExclusionReportAccount;
    @FindBy(css = ".report-title")
    WebElement txtTitleExclusionReport;

    @FindBy(css = "span.column-header-text")
    static List<WebElement> TableHeadersforExclusionReason;

    @FindBy(xpath = "//tbody/tr[1]/td")
    static List<WebElement> ExclusionReportData;

    @FindBy(xpath = "//td/div[1]//button[1]")
    List<WebElement> sortAsc;

    @FindBy(xpath = "//td/div[1]//button[2]")
    List<WebElement> sortDesc;
    @FindBy(xpath = "(//tr[@class='sort-table-data-row'])")
    List<WebElement> tablerows;

    @FindBy(xpath = "//app-drop-down-select[@id='plan-year']//div[@class='drop-down-option drop-down-option-selected']")
   WebElement planyeardropdown;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//span")
    List<WebElement> selectYear;

    public void verifyExclusionReportHeaders() {
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtExclusionReportPrimary, 10));
            softAssert.assertEquals(txtExclusionReportPrimary.getText(), "Primary Account Holder: ELA ELA");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtExclusionReportAccount, 10));
            softAssert.assertEquals(txtExclusionReportAccount.getText(), "Account ID: 4006144055 , 42131651");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtTitleExclusionReport, 10));
            softAssert.assertEquals(txtTitleExclusionReport.getText(), "Exclusion Reason Report");
        } else {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtExclusionReportPrimary, 10));
            softAssert.assertEquals(txtExclusionReportPrimary.getText(), "Primary Account Holder: Father Father");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtExclusionReportAccount, 10));
            softAssert.assertEquals(txtExclusionReportAccount.getText(), "Account ID: 4007993032 , 56261439");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtTitleExclusionReport, 10));
            softAssert.assertEquals(txtTitleExclusionReport.getText(), "Exclusion Reason Report");
        }
        softAssert.assertAll();
    }

    public void verifyExclusionReasonReportTableHeaders() {
        basicActions.waitForElementListToBePresent(TableHeadersforExclusionReason, 5000);
        String[] expectedHeaders = {"Account ID","Plan Year","Coverage Type", "Exclusion Reason", "Error Level", "Removed", "Removed Date", "Removed By","Exclusion Type","Date Updated","Date Created","Updated By","Notes"};
        for (int i = 0; i < TableHeadersforExclusionReason.size(); i++) {
            String actualHeader = TableHeadersforExclusionReason.get(i).getText();
            softAssert.assertEquals(actualHeader, expectedHeaders[i],
                    "Header mismatch at index " + i + ": Expected " + expectedHeaders[i] + ", but got " + actualHeader);
            softAssert.assertAll();
            }
        }


    public void verifyExclusionReasonData() {
        basicActions.waitForElementListToBePresent(ExclusionReportData, 5000);
        if (SharedData.getEnv().equals("staging")) {
            String[] expectedData = {"4007993032","2022","MEDICAL","Multiple Active Enrollments","Exclusion","","2023-02-23 8:44:00 AM","SYSTEM","AUTO","2022-08-29 8:21:08 AM","2022-08-17 12:12:26 PM","SYSTEM",""};
            for (int i = 0; i < ExclusionReportData.size(); i++) {
                String actualHeader = ExclusionReportData.get(i).getText();
                softAssert.assertEquals(actualHeader, expectedData[i],
                        "Exclusion Data mismatched at index " + i + ": Expected " + expectedData[i] + ", but got " + actualHeader);
            }
        } else {
            String[] expectedData = {"4006144055","2022","MEDICAL","Invalid ADDL_MAINT_REASON","Exclusion","","2023-02-17 9:00:00 AM","SYSTEM","AUTO","2022-08-08 4:19:31 PM","2022-03-10 11:08:43 AM","SYSTEM",""};
            for (int i = 0; i < ExclusionReportData.size(); i++) {
                String actualHeader = ExclusionReportData.get(i).getText();
                softAssert.assertEquals(actualHeader, expectedData[i],
                        "Exclusion Data mismatched at index " + i + ": Expected " + expectedData[i] + ", but got " + actualHeader);
            }
        }
        softAssert.assertAll();
    }
    public void verifySort() {
        for (int i = 0; i < TableHeadersforExclusionReason.size(); i++) {
            if (i < sortAsc.size()) {
                WebElement ascButton = sortAsc.get(i);
                ascButton.click();
                verifyColumnSorting(i + 1, true);
            }
            if (i < sortDesc.size()) {
                WebElement descButton = sortDesc.get(i);
                descButton.click();
                verifyColumnSorting(i + 1, false);
            }
        }
    }

    private void verifyColumnSorting(int columnIndex, boolean isAsc) {
        List<String> columnData = getColumnData(columnIndex);
        List<String> sortedData = new ArrayList<>(columnData);
        if (isAsc) {
            Collections.sort(sortedData);
        } else {
            Collections.sort(sortedData, Collections.reverseOrder());
        }
        softAssert.assertTrue(columnData.equals(sortedData),
                "Column " + columnIndex + " is not sorted correctly in " + (isAsc ? "ascending" : "descending") + " order.");
        softAssert.assertAll();
    }
    private List<String> getColumnData(int columnIndex) {
        List<String> columnData = new ArrayList<>();
        for (WebElement row : tablerows) {
            WebElement cell = row.findElement(By.xpath("td[" + columnIndex + "]"));
            columnData.add(cell.getText());
        }
        columnData.removeIf(String::isEmpty);
        return columnData;
    }

    public void selectYearToAnyENV(String year) {
        basicActions.selectValueFromDropdown(planyeardropdown, selectYear, year);
    }
}

