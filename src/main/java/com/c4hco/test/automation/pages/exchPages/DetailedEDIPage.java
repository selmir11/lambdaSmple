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

public class DetailedEDIPage {
    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public DetailedEDIPage(WebDriver webDriver) {
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

    public void verifyEDIHeaders() {
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportPrimary, 10));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Primary Account Holder: WreckIt Ralphmore");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportAccount, 10));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Account ID: 6702500086 , 141795155");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(reportTitleEDI, 10));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Detailed Outbound Transactions");
        } else {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportPrimary, 10));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Primary Account Holder: Scott Evile");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(txtDetailedEdiReportAccount, 10));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Account ID: 8335642700 , 57917319");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(reportTitleEDI, 10));
            softAssert.assertEquals(txtDetailedEdiReportPrimary.getText(), "Detailed Outbound Transactions");
        }
    }

    public void verifyEDITableHeaders() {
        basicActions.waitForElementListToBePresent(TableHeadersforEDI, 5000);
        String[] expectedHeaders = {"Carrier", "Sent File Name", "Account ID", "Date Created", "Change Type", "Maintenance Type", "Policy ID", "Group ID", "Enrollees", "Subscriber ID", "Relationship", "Dependent ID", "Dental Only Plan", "HIOS Plan ID", "Plan Start Date", "Plan End Date", "Financial Effective Date", "Tobacco Use", "Rating Area", "Premium Amount", "APTC Amount", "Total Premium Amount", "Total Responsible Amount", "CSR Amount", "Insured Last Name", "Insured First Name", "Insured SSN", "Insured DOB", "Insured Gender", "Email Address", "Primary Phone", "Alternate Phone", "Residence Address Line 1", "Residence Address Line 2", "Residence City", "Residence State", "Residence Zip", "Residence Fips Code", "Mailing Address Line 1", "Mailing Address Line 2", "Mailing Address City", "Mailing Address State", "Mailing Address Zip", "Broker License Number", "Broker Name", "Broker Tax ID", "Plan Sponsor", "Plan Sponsor SSN", "Responsible Person First Name", "Responsible Person Last Name", "Responsible Person Address Line 1", "Responsible Person Address Line 2", "Responsible Person City", "Responsible Person State", "Responsible Person Zip", "Responsible Person Email", "Responsible Person Phone", "Responsible Person Relationship", "Interchange ID", "Effectuated", "Effectuated File Name", "Inbound999 File Name", "Inbound999 Acknowledged", "EDI Status"};
        for (int i = 0; i < TableHeadersforEDI.size(); i++) {
            String actualHeader = TableHeadersforEDI.get(i).getText();
            if (!actualHeader.equals(expectedHeaders[i])) {
                System.out.println("Header mismatch: Expected " + expectedHeaders[i] + ", but got " + actualHeader);
            }
        }
    }

    public void verifyEDIData() {
        basicActions.waitForElementListToBePresent(outboundData, 5000);
        if (SharedData.getEnv().equals("staging")) {
            String[] expectedData = {"KPCONNECTOR", "834_KPCONNECTOR_I_2024112217546379_100006682_P_O", "8335642700", "2024-11-22 14:13:34.69265", "ADD", "021", "3543302020", "1", "2", "4207904816", "18", "4207904816", "N", "21032CO041006701", "20250101", "20251231", "20250101", "N", "3", "377.79", "0.00", "660.03", "660.03", "0.00", "Evile", "Scott", "456434564", "19981205", "M", "sevile@testing.com", "4564135646", "4564135646", "123 Eve Ave", "", "Denver", "CO", "80202", "08031", "", "", "", "", "", "", "", "", "Scott Evile", "456434564", "", "", "", "", "", "", "", "", "", "", "100006682", "N", "", "", "", "EDI_COMPLETE"};
            for (int i = 0; i < outboundData.size(); i++) {
                String actualHeader = outboundData.get(i).getText();
                if (!actualHeader.equals(expectedData[i])) {
                    System.out.println("Outbound Data mismatched: Expected " + expectedData[i] + ", but got " + actualHeader);
                }
            }
        } else {
            String[] expectedData = {"ANTHEMHIX", "834_ANTHEMHIX_I_2022121611343460_100000657_D_O", "6702500086", "2022-12-16 11:33:13.091", "CANCEL", "024", "7086096000", "1", "1", "2365022371", "18", "2365022371", "N", "76680CO022002701", "20230101", "20230101", "", "N", "3", "304.20", "", "", "", "", "Ralph", "WreckIt", "428762876", "19861128", "M", "tspellnoticetesting+wreckitralph@gmail.com", "7195551212", "7195551212", "101 Wreck It Drive", "", "Denver", "CO", "80205", "08031", "PO BOX 1454", "", "Denver", "CO", "80205", "", "", "", "WreckIt Ralph", "428762876", "", "", "", "", "", "", "", "", "", "", "100000657", "Y", "834_BRIGHTHEALTH_I_2022092012520162_100091279_D_I", "", "", "EDI_COMPLETE"};
            for (int i = 0; i < outboundData.size(); i++) {
                String actualHeader = outboundData.get(i).getText();
                if (!actualHeader.equals(expectedData[i])) {
                    System.out.println("Outbound Data mismatched: Expected " + expectedData[i] + ", but got " + actualHeader);
                }
            }
        }
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
        if (columnData.equals(sortedData)) {
        } else {
            throw new AssertionError("Column " + columnIndex + " is not sorted correctly in " + (isAsc ? "ascending" : "descending") + " order.");
        }
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

