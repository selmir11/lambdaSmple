package com.c4hco.test.automation.pages.cocoPages;

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

public class DetailedEDICoCoPage {
    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public DetailedEDICoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    //Header
    @FindBy(xpath = "//h2[contains(normalize-space(), 'Primary Account Holder: ')]")
    WebElement txtDetailedEdiReportPrimary;
    @FindBy(xpath = "//h3[contains(., 'Account ID:')]")
    WebElement txtDetailedEdiReportAccount;

    //Container Header
    @FindBy(xpath = "//h2[@class='report-title']")
    WebElement reportTitleEDI;

    @FindBy(css = "span.column-header-text")
    static List<WebElement> TableHeadersforEDI;

    @FindBy(xpath = "//tbody/tr[1]/td")
    static List<WebElement> outboundData;

    @FindBy(xpath = "//td/div[1]//button[1]")
    List<WebElement> sortAsc;

    @FindBy(xpath = "//td/div[1]//button[2]")
    List<WebElement> sortDesc;
    @FindBy(xpath = "(//tr[@class='sort-table-data-row'])")
    List<WebElement> tablerows;

    @FindBy(xpath = "//h2[@id='individualDashboardCocoTitle']")
    WebElement COCOtitle;

    public void verifyEDIHeaders() {
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(COCOtitle, 50));
            softAssert.assertEquals(COCOtitle.getText(), "Colorado Connect");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportPrimary, 50));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Primary Account Holder: apelizawcpe apindkcbqntg");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportAccount, 50));
            softAssert.assertEquals(txtDetailedEdiReportAccount.getText(), "Account ID: 9059867099");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(reportTitleEDI, 50));
            softAssert.assertEquals(reportTitleEDI.getText(), "Detailed Outbound Transactions");
        } else {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(COCOtitle, 60));
            softAssert.assertEquals(COCOtitle.getText(), "Colorado Connect");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportPrimary, 60));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Primary Account Holder: apelizasmdy apindxzdcxiq");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportAccount, 60));
            softAssert.assertEquals(txtDetailedEdiReportAccount.getText(), "Account ID: 9055878011");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(reportTitleEDI, 60));
            softAssert.assertEquals(reportTitleEDI.getText(), "Detailed Outbound Transactions");
        }
        softAssert.assertAll();
    }

    public void verifyEDITableHeaders() {
        basicActions.waitForElementListToBePresent(TableHeadersforEDI, 5000);
        String[] expectedHeaders = {"Carrier", "Sent File Name", "Account ID", "Date Created", "Change Type", "Maintenance Type", "Policy ID", "Group ID","Enrollees", "Subscriber ID", "Relationship", "Dependent ID", "Dental Only Plan", "HIOS Plan ID", "Plan Start Date", "Plan End Date", "Financial Effective Date","Tobacco Use", "Rating Area", "Premium Amount", "APTC Amount", "Total Premium Amount", "Total Responsible Amount", "CSR Amount", "Insured Last Name", "Insured First Name", "Insured SSN", "Insured DOB", "Insured Gender", "Email Address", "Primary Phone", "Alternate Phone", "Residence Address Line 1", "Residence Address Line 2", "Residence City", "Residence State", "Residence Zip", "Residence Fips Code", "Mailing Address Line 1", "Mailing Address Line 2", "Mailing Address City", "Mailing Address State", "Mailing Address Zip", "Broker License Number", "Broker Name", "Broker Tax ID", "Plan Sponsor", "Plan Sponsor SSN", "Effectuated File Name", "Inbound999 File Name", "Inbound999 Acknowledged", "EDI Status", "EAPID", "Effectuated"};

        for (int i = 0; i < TableHeadersforEDI.size(); i++) {
            String actualHeader = TableHeadersforEDI.get(i).getText();
            softAssert.assertEquals(actualHeader, expectedHeaders[i],
                    "Header mismatch at index " + i + ": Expected " + expectedHeaders[i] + ", but got " + actualHeader);
            softAssert.assertAll();
            }
        }


    public void verifyEDIData() {
        basicActions.waitForElementListToBePresent(outboundData, 5000);
        if (SharedData.getEnv().equals("staging")) {
            String[] expectedData = {"Cigna Healthcare", "834_CIGNA_C_2025032613264296_100003726_D_O", "9055878011", "2025-03-26T13:24:47.265969", "",
                    "ADDITION", "2326005300", "1", "1", "1708298524", "SELF", "1708298524", "Y", "49375CO0060032", "2025-03-26",
                    "2025-12-31", "2025-03-26", "No", "3", "333.88", "0.00", "333.88", "333.88", "0.00", "apindxzdcxiq", "apelizasmdy",
                    "000000000", "19900303", "F", "MGC4Test+apindxzdcxiqapeliz@gmail.com", "3382901689", "3382901689", "1234 wadsworth boulevard", "",
                    "lakewood", "CO", "80229", "08001", "", "", "", "", "", "", "", "", "apelizasmdy apindxzdcxiq", "1708298524", "", "", "", "EDI_COMPLETE", "2326005300", ""};
            for (int i = 0; i < outboundData.size(); i++) {
                String actualHeader = outboundData.get(i).getText();
                softAssert.assertEquals(actualHeader, expectedData[i], "Outbound Data mismatched at index " + i + ": Expected " + expectedData[i] + ", but got " + actualHeader);
            }
        } else {
            String[] expectedData = {"Cigna Healthcare", "834_CIGNA_C_2025032615501168_100001128_D_O", "9059867099", "2025-03-26T15:49:43.990686", "ADD",
                    "ADDITION", "1701070186", "1", "2", "8790664720", "SELF", "8790664720", "N", "49375CO0060032", "2025-03-26", "2025-12-31",
                    "2025-03-26", "No", "3", "362.03", "0.00", "711.22", "711.22", "0.00", "apindkcbqntg", "apelizawcpe", "000000000", "02/01/1983",
                    "M", "MGC4Test+apindkcbqntgapeliz@gmail.com", "3971871644", "3971871644", "1234 Road", "", "Denver", "CO", "80205", "08031",
                    "", "", "", "", "", "", "", "", "apelizawcpe apindkcbqntg", "8790664720", "", "", "", "EDI_COMPLETE", "1701070186", ""};
            for (int i = 0; i < outboundData.size(); i++) {
                String actualHeader = outboundData.get(i).getText();
                softAssert.assertEquals(actualHeader, expectedData[i], "Outbound Data mismatched at index " + i + ": Expected " + expectedData[i] + ", but got " + actualHeader);
            }
        }
        softAssert.assertAll();
    }


    public void verifySort() {
        for (int i = 0; i < TableHeadersforEDI.size(); i++) {
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
        assert columnData.equals(sortedData) : "Column " + columnIndex + " is not sorted correctly in " + (isAsc ? "ascending" : "descending") + " order.";
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
}
