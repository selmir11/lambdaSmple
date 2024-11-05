package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminPortalBrokerDashboardPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public AdminPortalBrokerDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@class='dashboardHeader1']")
    WebElement dashboardHeader;
    @FindBy(xpath = "//h3[@class='dashboardHeader2']")
    WebElement dashboardTitle;
    @FindBy(id = "broker-username")
    WebElement brokerUsername;
    @FindBy(id = "broker-email-input")
    WebElement emailUsername;
    @FindBy(id = "broker-agencyTin")
    WebElement agencyTIN;
    @FindBy(id = "broker-mailingAdd")
    WebElement mailingAddress;
    @FindBy(id = "broker-prim-phone")
    WebElement primaryPhone;
    @FindBy(id = "broker-contact")
    WebElement language;
    @FindBy(xpath = "//h6[@class='status header status-header']")
    WebElement licenceStatusText;
    @FindBy(xpath = "//h6[@class='status status-actual']")
    WebElement licenceStatus;
    @FindBy(xpath = "//h6[@class='status header license-header']")
    WebElement StateLicenseText;
    @FindBy(xpath = "//h6[@class='status license-actual']")
    WebElement StateLicense;
    @FindBy(xpath = "//h6[@class='status header expiration-header']")
    WebElement licenseValidText;
    @FindBy(xpath = "//h6[@class='status expiration-actual']")
    WebElement licenseValid;
    @FindBy(xpath = "//h6[@class='status header certification-header']")
    WebElement certificationStatusText;
    @FindBy(xpath = "//h6[@class='status certification-actual']")
    WebElement certificationStatus;
    @FindBy(id = "manage-certifications")
    WebElement manageCertifications;
    @FindBy(xpath = "(//p[@class='group-title'])[3]")
    WebElement accountActivityReportText;
    @FindBy(xpath = "(//p[@class='group-title'])[4]")
    WebElement clientInformationText;
    @FindBy(xpath = "//button[@class='btn-second-action-button view-report']")
    WebElement viewAccountActivityReport;
    @FindBy(xpath = "//button[@class='btn-second-action-button dashboard-button']")
    WebElement goBack;
    @FindBy(xpath = "//div[@class='nodata']")
    WebElement noClientInfo;
    @FindBy(xpath = "//*[@id='form-edit-certification']")
    WebElement manageCertificationContainer;
    @FindBy(css = "#form-edit-certification > h3")
    WebElement manageCertificationHeader;
    @FindBy(css = "#form-edit-certification > label.body-text-2.license-status")
    WebElement labelLicenseStatus;
    @FindBy(xpath = "//app-drop-down-select[@id='license-status']//div[@class='drop-down-option drop-down-option-selected']")
    WebElement licenseStatusDisplayed;
    @FindBy(css = "#form-edit-certification > label.body-text-2.certification-status")
    WebElement labelCertStatus;
    @FindBy(css = "app-drop-down-select[id='certification-status'] div[class='drop-down-option drop-down-option-selected']")
    WebElement certStatusDisplayed;
    @FindBy(css = "label[for='license-expiration-date']")
    WebElement labelExpirationDate;
    @FindBy(css = "#expiration-date")
    WebElement licenseDateDisplayed;
    @FindBy(css = "#option_2")
    WebElement licenseOptionNotApproved;
    @FindBy(css = "#option_2")
    WebElement certStatusNotApproved;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement buttonSave;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement buttonCancel;
    @FindBy(css = "div[class='drop-down-secondary-options'] div[class='drop-down-option']")
    WebElement licenseOptionApproved;
    @FindBy(css = "div[class='drop-down-secondary-options'] div[class='drop-down-option']")
    WebElement certStatusApproved;
    @FindBy(css = "body > app-root > div > div > app-activity-report > div.table-container.group-box > h2")
    WebElement accountActivityTitle;
    @FindBy(xpath = "//button[normalize-space()='View Report']")
    WebElement buttonViewReport;
    @FindBy(css = "#Event\\ Code_1")
    WebElement eventCode;
    @FindBy(css = "#Time_1")
    WebElement timeDate;
    @FindBy(css = "#Username_1")
    WebElement userName;
    @FindBy(css = "#Description_1")
    WebElement eventDescription;
    @FindBy(css = "#Detail\\ Value_1 > span")
    WebElement detailValue;

    public void validateAPBrokerDashboardHeader(String qaName, String qaID, String qaUserType, String stgName, String stgID, String stgUserType) {
        if (SharedData.getEnv().equals("staging")){
            validateBrokerTitle(stgName, stgID, stgUserType);
        }else{
            validateBrokerTitle(qaName, qaID, qaUserType);
        }
    }

    public void validateBrokerTitle(String Name, String ID, String UserType){
        basicActions.waitForElementToBePresent(dashboardHeader,20);
        softAssert.assertEquals(dashboardHeader.getText(),Name);
        softAssert.assertTrue(dashboardTitle.getText().contains(ID));
        softAssert.assertTrue(dashboardTitle.getText().contains(UserType));
        softAssert.assertAll();
    }

    public void VerifyBrokerInformationsAccountSummary() {
        if (SharedData.getEnv().equals("qa")){
           softAssert.assertEquals(brokerUsername.getText(),"Dale.Cooper@invalid.com");
           //softAssert.assertEquals(emailUsername.getText(),"eematu1@msn.com");
           softAssert.assertEquals(agencyTIN.getText(),"67-8675766");
           softAssert.assertEquals(mailingAddress.getText(),"4435 Cut Dr\n" +
                   "Denver, CO 80222");
           softAssert.assertEquals(primaryPhone.getText(),"567-875-4345");
           softAssert.assertEquals(language.getText(),"English");
        }else{
            softAssert.assertEquals(brokerUsername.getText(),"Crystal.Broker@invalid.com");
            //softAssert.assertEquals(emailUsername.getText(),"");
            softAssert.assertEquals(agencyTIN.getText(),"45-7654345");
            softAssert.assertEquals(mailingAddress.getText(),"3423 Gems Way\n" +
                    "Denver, CO 80205");
            softAssert.assertEquals(primaryPhone.getText(),"687-687-5676");
            softAssert.assertEquals(language.getText(),"English");
            softAssert.assertAll();
        }
        softAssert.assertAll();
    }

    public void VerifyBrokerBrokerCertificationInformationS() {
        softAssert.assertEquals(licenceStatusText.getText(),"License Status:");
        softAssert.assertEquals(StateLicenseText.getText(),"State License #:");
        softAssert.assertEquals(licenseValidText.getText(),"License Valid to:");
        softAssert.assertEquals(certificationStatusText.getText(),"Certification Status:");
        softAssert.assertEquals(manageCertifications.getText(),"Manage Certifications");
        if (SharedData.getEnv().equals("qa")){
            softAssert.assertEquals(licenceStatus.getText(),"APPROVED");
            softAssert.assertEquals(StateLicense.getText(),"5676543456");
            softAssert.assertEquals(licenseValid.getText(),"10/01/2025");
            softAssert.assertEquals(certificationStatus.getText(),"APPROVED");
        }else{
            softAssert.assertEquals(licenceStatus.getText(),"APPROVED");
            softAssert.assertEquals(StateLicense.getText(),"345676435");
            softAssert.assertEquals(licenseValid.getText(),"10/10/2025");
            softAssert.assertEquals(certificationStatus.getText(),"APPROVED");
        }
        softAssert.assertAll();
    }

    public void VerifyBrokerAccountActivityContainer() {
        softAssert.assertEquals(accountActivityReportText.getText(),"Account Activity Report");
        softAssert.assertEquals(viewAccountActivityReport.getText(),"View Report");
        softAssert.assertAll();
    }

    public void verifyBrokerClientInformationContainer() {

            WebElement table = basicActions.getDriver().findElement(By.id("broker-client-info-table"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            String[][] QAExpectedData = {
                   // {"First Name", "Last Name", "Email", "Phone Number"},
                    {"Banana", "Nut", "banananut@t..", "719-555-121.."},
                    {"Change", "Change", "changeapind..", "999-999-999.."},
                    {"IDProofing", "Account","IDProofing...", "485-694-158.."},
                    {"mgjoerlsi", "mgtmyzwueq", "mgtmyzwueqM..", "359-638-234.."},
                    {"Papa", "Smurf", "Papa.Smurf@..", "746-846-548.."}
            };
            String[][] STGExpectedData = {
                    {"apelizojkda", "apindpgupbw..", "apindpgupbw..", "317-369-529.."},
                    {"apelizrdcup", "apindyxhxqr..", "apindyxhxqr..", "359-307-333.."},
                    {"apelizwkyzl", "apindvlnqbh..","apindvlnqbh..", "393-791-537.."},
                    {"Happie", "Gilmores", "Happie.Gilm..", "555-555-555.."},
                    {"mgouxbjms", "mgoqtpfgqc", "mgoqtpfgqcM..", "333-002-711.."}
            };

            if(SharedData.getEnv().equals("qa")){
            for (int i = 0; i < QAExpectedData.length; i++) {
                List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
                for (int j = 0; j < QAExpectedData[i].length; j++) {
                    String cellText = cells.get(j).getText();
                    softAssert.assertEquals(cellText, QAExpectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
                    softAssert.assertAll();
                }
            }
        }else{
                for (int i = 0; i < STGExpectedData.length; i++) {
                    List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
                    for (int j = 0; j < STGExpectedData[i].length; j++) {
                        String cellText = cells.get(j).getText();
                        softAssert.assertEquals(cellText, STGExpectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
                        softAssert.assertAll();
                    }
                }
            }
    }

    public void clickGoBackONAdminPortalBroker() {
        basicActions.waitForElementToBePresent(goBack,20);
        goBack.click();
    }
    public void VerifyBrokerClientInformationContainerNoClients() {
        basicActions.waitForElementToBePresent(clientInformationText,20);
        softAssert.assertEquals(clientInformationText.getText(),"Client Information");
        softAssert.assertEquals(noClientInfo.getText(),"There is no client information.");
        softAssert.assertAll();
    }
    public void clickManageCertification() {
        basicActions.waitForElementToBePresent(manageCertifications, 10);
        manageCertifications.click();
    }
    public void VerifyBrokerLicenseStatusAndLicenseExpirationDateWithCertificationStatus(String licenseStatus, String licenseDate, String certificationStatus){
        basicActions.waitForElementToBePresent(manageCertificationContainer, 10);
        softAssert.assertEquals(manageCertificationHeader.getText(),"Manage Certification\n" +
                "Information");
        softAssert.assertEquals(labelLicenseStatus.getText(),"License Status:");
        softAssert.assertEquals(licenseStatusDisplayed.getText(), licenseStatus);
        softAssert.assertEquals(labelExpirationDate.getText(),"License Expiration Date:");
        licenseDateDisplayed.click();
        softAssert.assertEquals(licenseDateDisplayed.getText(), licenseDate);
        softAssert.assertEquals(labelCertStatus.getText(),"Certification Status:");
        softAssert.assertEquals(certStatusDisplayed.getText(),certificationStatus);
        softAssert.assertAll();
    }
    public void changeStatusesThenClickSaveButton() {
        basicActions.waitForElementToBePresent(buttonSave, 10);
        licenseStatusDisplayed.click();
        licenseOptionNotApproved.click();
        certStatusDisplayed.click();
        certStatusNotApproved.click();
        buttonSave.click();
    }
    public void verifyExpectedStatuses(){
        basicActions.waitForElementToBePresent(labelLicenseStatus, 10);
        softAssert.assertTrue(labelLicenseStatus.isDisplayed());
         softAssert.assertAll();
    }
    public void clickCancelButton() {
        basicActions.waitForElementToBePresent(buttonCancel, 10);
        buttonCancel.click();
    }
    public void changeStatusesBack() {
        basicActions.waitForElementToBePresent(buttonSave, 10);
        licenseStatusDisplayed.click();
        licenseOptionApproved.click();
        certStatusDisplayed.click();
        certStatusApproved.click();
        buttonSave.click();
    }
    public void clickViewReportButton() {
        basicActions.waitForElementToBePresent(buttonViewReport, 10);
        buttonViewReport.click();
        basicActions.switchtoactiveTab();
    }
    public void verifyBrokerActivityInfo() {
        WebElement table = basicActions.getDriver().findElement(By.xpath("//div[contains(@class, 'table-div')]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        String[][] QAExpectedData = {
                {"", "", "SP_BROKER_CERTIFIED", "2024-11-04T15:16:34", "AGENCY-SERVICE", "Broker certified", "Account Id", "7660020008"}
        };
        String[][] STGExpectedData = {
                {"", "", "SP_BROKER_CERTIFIED", "2024-11-04T14:42:16", "AGENCY-SERVICE", "Broker certified", "Account Id", "8363832700"}
        };
        if (SharedData.getEnv().equals("qa")) {
            for (int i = 0; i < QAExpectedData.length; i++) {
                List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
                for (int j = 0; j < QAExpectedData[i].length; j++) {
                    String cellText = cells.get(j).getText();
                    softAssert.assertEquals(cellText, QAExpectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
                    softAssert.assertAll();
                }
            }
        } else {
            for (int i = 0; i < STGExpectedData.length; i++) {
                List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
                for (int j = 0; j < STGExpectedData[i].length; j++) {
                    String cellText = cells.get(j).getText();
                    softAssert.assertEquals(cellText, STGExpectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
                    softAssert.assertAll();
                }
            }
        }
    }
    public void verifyTableTitle() {
        basicActions.waitForElementToBePresent(accountActivityTitle, 20);
        softAssert.assertTrue(accountActivityTitle.isDisplayed());
        softAssert.assertAll();
    }
    public void verifyBrokerAccountActivityReport(String eventCodeData, String dateDynamic, String nameOfUser, String description, String valueForAccountId){
        String dateOnly = dateDynamic.split("T")[0];
        System.out.println(dateOnly);
        basicActions.waitForElementToBePresent(eventCode, 10);
        softAssert.assertEquals(eventCode.getText(),eventCodeData);
        softAssert.assertEquals(dateDynamic, dateOnly);
        softAssert.assertEquals(userName.getText(), nameOfUser);
        softAssert.assertEquals(eventDescription.getText(),description);
        softAssert.assertEquals(detailValue.getText(), valueForAccountId);
        softAssert.assertAll();
    }
}
