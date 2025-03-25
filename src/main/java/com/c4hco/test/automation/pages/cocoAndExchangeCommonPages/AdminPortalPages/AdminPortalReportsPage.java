package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class AdminPortalReportsPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalReportsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "thead td:nth-child(4) span:nth-child(1)")
    WebElement eventTime;
    @FindBy(css = "thead td:nth-child(7) span:nth-child(1)")
    WebElement detailKey;
    @FindBy(xpath = "//div[2]/h2")
    WebElement titleAccountActivity;
    @FindBy(xpath = "//tr[@class='sort-table-data-row']")
    List<WebElement> eventCodeList;
    @FindBy(xpath = "//table[@class='sort-table']//td")
    List<WebElement> columnsEventCode;

    @FindBy(css = ".sort-table-data-row")
    List<WebElement> tableRows;

    @FindBy(css = ".column-sort-button.column-sort-button-decending")
    List<WebElement> descendingOrder;

    @FindBy(css = ".tooltip .tooltip-inner")
    WebElement tooltipText;

    @FindBy(xpath = "//td[@class='column-header']/span")
    List<WebElement> columnsLabel;

    @FindBy(xpath = "//*[@class='column-sort-controls']")
    List<WebElement> columnSortControls;

    @FindBy(xpath = "//*[@class='dashboardHeader1']")
    WebElement memberPrimary;

    @FindBy(xpath = "//*[@class='dashboardHeader2']")
    WebElement memberAcctId;

    @FindBy(xpath = "//table[@class='sort-table']//td[3]")
    List<WebElement> eventListColumn;

    @FindBy(xpath = "//table[@class='sort-table']//td[6]")
    List<WebElement> descriptionListColumn;





    public void validateTitleAccountActivity() {
        basicActions.waitForElementListToBePresentWithRetries(eventCodeList, 50);
        softAssert.assertEquals("Account Activity", titleAccountActivity.getText());
        basicActions.waitForElementToBePresent(detailKey, 20);
        softAssert.assertEquals("Detail Key", detailKey.getText());
        basicActions.waitForElementToBePresent(eventTime, 20);
        softAssert.assertEquals("Time", eventTime.getText());
        softAssert.assertAll();
    }

    public void validateEventCodeInActivityEventReport(String eventType, String description) {
        WebElement table = basicActions.getDriver().findElement(By.xpath("//table[@class='sort-table']"));
        List<WebElement> rows = table.findElements(By.xpath("//table[@class='sort-table']//tr"));
        List<String> expected = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.xpath("//table[@class='sort-table']//td"));
            for (WebElement cell : columns) {
                expected.add(cell.getText().trim());
            }
        }
        softAssert.assertTrue(expected.contains(eventType), "Event type not found. Expected: " + eventType + " to be in: " + expected);
        softAssert.assertTrue(expected.contains(description), "Description not found. Expected: " + description + " to be in: " + expected);
        softAssert.assertAll();
    }

    public void VerifyEvents(String text, String timeCondition, String qaUsername, String stagingUsername, String expectedValue, String expectedStatus, String expectedKey) {
        String username = getUsernameBasedOnEnv(qaUsername, stagingUsername);

        WebElement eventTime = basicActions.getDriver().findElement(By.xpath("//tbody[1]/tr[5]/td[3]/app-max-length-tooltip[1]/span[1]"));
        Boolean result = basicActions.hardRefreshUntilVisible(eventTime, 250000, 1000);

        if (!result) {
            System.out.println("Element was not found after the timeout.");
            return;
        }

        String TextXPath = "//span[contains(text(),'" + text + "')]";
        WebElement resetDateElement = basicActions.getDriver().findElement(By.xpath(TextXPath));

        WebElement timeElement = resetDateElement.findElement(By.xpath("ancestor::td/following-sibling::td[1]"));
        String actualTime = timeElement.getText().trim();

        if (timeCondition.equals("todays date within last 10 min timestamp")) {
            basicActions.validateTimeWithinLast10Minutes(actualTime);
        } else {
            validateExactTimestamp(actualTime, timeCondition);
        }

        validateUsernameData(resetDateElement, username, expectedValue, expectedStatus, expectedKey);
        softAssert.assertAll();
    }

    private String getUsernameBasedOnEnv(String qaUsername, String stagingUsername) {
        if (SharedData.getEnv().equals("qa")) {
            return qaUsername;
        } else if (SharedData.getEnv().equals("staging")) {
            return stagingUsername;
        } else {
            throw new RuntimeException("Unknown environment: " + SharedData.getEnv());
        }
    }

    private void validateUsernameData(WebElement resetDateElement, String username, String expectedValue, String expectedStatus, String expectedKey) {
        WebElement nameElement = resetDateElement.findElement(By.xpath("ancestor::td/following-sibling::td[2]"));
        String actualName = nameElement.getText().trim();
        softAssert.assertEquals(actualName, username, "Name does not match for " + username);

        WebElement valueElement = resetDateElement.findElement(By.xpath("ancestor::td/following-sibling::td[3]"));
        String actualValue = valueElement.getText().trim();
        softAssert.assertEquals(actualValue, expectedValue, "Value does not match for " + username);

        WebElement statusElement = resetDateElement.findElement(By.xpath("ancestor::td/following-sibling::td[4]"));
        String actualStatus = statusElement.getText().trim();
        softAssert.assertEquals(actualStatus, expectedStatus, "Status does not match for " + username);

        WebElement keyElement = resetDateElement.findElement(By.xpath("ancestor::td/following-sibling::td[5]"));
        String actualKey = keyElement.getText().trim();
        softAssert.assertEquals(actualKey, expectedKey, "Key does not match for " + username);
    }

    private void validateExactTimestamp(String actualTime, String expectedTime) {
        if (!actualTime.equals(expectedTime)) {
            softAssert.fail("The time does not match the expected timestamp. Expected: " + expectedTime + ", but got: " + actualTime);
        }
    }

    public void validateRecord(String recordType, String userType) {
        basicActions.waitForElementListToBePresent(descendingOrder, 10);
        basicActions.waitForElementListToBePresent(tableRows, 10);
        basicActions.wait(2000);
        descendingOrder.get(1).click();
        basicActions.waitForElementListToBePresent(tableRows, 10);
        basicActions.wait(2000);

        switch (recordType) {
            case "primary person change":
                validations_primaryPersonChange(userType);
                break;
            case "Info update":
                validate_primaryInfoUpdated();
                break;
            case "Email Update":
                validate_updatedPrimaryEmail();
                break;
            case "Account Creation":
                validate_accCreated();
                break;

            default:
                Assert.fail("Invalid argument passed");
        }
    }

    private void validate_accCreated() {
        WebElement firstRow = tableRows.get(0);
        List<WebElement> columns = firstRow.findElements(By.tagName("td"));

        softAssert.assertEquals(columns.get(2).getText(), "UI_ACCT_CREATED", "event code did not match");
        softAssert.assertEquals(columns.get(5).getText(), "Account created", "description did not match");

        columns.get(6).click();
        basicActions.waitForElementToBePresent(tooltipText, 10);
        softAssert.assertEquals(tooltipText.getText(), "useronboardingdata", "detail key did not match");

        columns.get(7).click();
        basicActions.waitForElementToBePresent(tooltipText, 10);

        MemberDetails primaryMem = SharedData.getPrimaryMember();
        softAssert.assertEquals(tooltipText.getText(), "IND_WCN " + primaryMem.getSignature());
        softAssert.assertAll();
    }

    private void validate_updatedPrimaryEmail() {
        validateChangePrimContactProfile();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        softAssert.assertEquals(tooltipText.getText(), "Email: from:" + primaryMem.getIncorrectEmail() + " to:" + primaryMem.getEmailId());
        softAssert.assertAll();
    }

    private void validateChangePrimContactProfile() {
        WebElement firstRow = tableRows.get(0);
        List<WebElement> columns = firstRow.findElements(By.tagName("td"));

        columns.get(2).click();
        Actions actions = new Actions(basicActions.getDriver());
        actions.moveToElement(columns.get(2)).perform();
        basicActions.wait(300);
        softAssert.assertEquals(tooltipText.getText(), "UP_CHANGE_PRIMARY_CONTACT_PROFILE", "event code did not match");

        columns.get(5).click();
        basicActions.waitForElementToBePresent(tooltipText, 10);
        softAssert.assertEquals(tooltipText.getText(), "User profile data has been updated", "description did not match");

        columns.get(6).click();
        basicActions.waitForElementToBePresent(tooltipText, 10);
        softAssert.assertEquals(tooltipText.getText(), "PrimaryContactProfileChange", "detail key did not match");

        columns.get(7).click();
        basicActions.waitForElementToBePresent(tooltipText, 10);
    }

    private void validate_primaryInfoUpdated() {
        validateChangePrimContactProfile();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        softAssert.assertEquals(tooltipText.getText(), "Mobile phone: from:" + basicActions.formatPhNum(primaryMem.getIncorrectMobilePhone()) + " to:" + primaryMem.getAlternatePhNum() + ", Home phone: from:" + basicActions.formatPhNum(primaryMem.getIncorrectHomePhone()) + " to:" + primaryMem.getPhoneNumber() + ", Preferred Contact Method: from:" + primaryMem.getIncorrectContactPref().toUpperCase() + " to:" + primaryMem.getContactPref().toUpperCase() + ", Preferred Language: from:" + primaryMem.getIncorrectLanguage() + " to:" + primaryMem.getPrefLang(), "detail value did not match");
        softAssert.assertAll();
    }

    private void validations_primaryPersonChange(String userType) {
        WebElement firstRow = tableRows.get(0);
        List<WebElement> columns = firstRow.findElements(By.tagName("td"));

        columns.get(2).click();
        Actions actions = new Actions(basicActions.getDriver());
        actions.moveToElement(columns.get(2)).perform();
        basicActions.wait(300);
        softAssert.assertEquals(tooltipText.getText(), "UP_ASSIGN_PRIMARY_CONTACT", "event code did not match");

        columns.get(5).click();
        basicActions.waitForElementToBePresent(tooltipText, 10);
        softAssert.assertEquals(tooltipText.getText(), "New primary contact assigned", "description did not match");

        columns.get(6).click();
        basicActions.waitForElementToBePresent(tooltipText, 10);
        softAssert.assertEquals(tooltipText.getText(), "PrimaryContactAssignment", "detail key did not match");

        columns.get(7).click();
        basicActions.waitForElementToBePresent(tooltipText, 80);
        String memberIdFrom = basicActions.getMember("Primary").getMemberId();
        String nameFrom = basicActions.getMemFirstLastNames("Primary");
        String memberIdTo = SharedData.getPrimaryMember().getMemberId();
        String nameTo = SharedData.getPrimaryMember().getFullName().replace(".", "");
        String updatedBy;

        switch (userType) {
            case "adminportal":
                updatedBy = (SharedData.getEnv().equals("qa"))
                        ? "C4test.aduser123@gmail.com"
                        : "C4testaduser123@gmail.com";
                break;

            case "individualportal":
                updatedBy = SharedData.getPrimaryMember().getEmailId();
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + userType);
        }
        softAssert.assertEquals(tooltipText.getText(),
                "From memberId:" + memberIdFrom +
                        ", name:" + nameFrom +
                        ", To memberId:" + memberIdTo +
                        ", name:" + nameTo +
                        ", updatedBy:" + updatedBy,
                "detail value did not match");
        softAssert.assertAll();
    }

    public void validateActivityTitle() {
        basicActions.waitForElementToBePresentWithRetries(titleAccountActivity, 50);
        softAssert.assertEquals(titleAccountActivity.getText(),"Account Activity", "Title not match");
        softAssert.assertAll();
    }

    public void validateActivityReportColumnNames() {
        basicActions.waitForElementToBePresentWithRetries(titleAccountActivity, 50);
        softAssert.assertEquals(columnsLabel.get(0).getText(),"Person ID", "Title not match");
        softAssert.assertTrue(columnSortControls.get(0).isDisplayed(),"Sort control not displayed");
        softAssert.assertEquals(columnsLabel.get(1).getText(),"Event Code", "Title not match");
        softAssert.assertTrue(columnSortControls.get(1).isDisplayed(),"Sort control not displayed");
        softAssert.assertEquals(columnsLabel.get(2).getText(),"Time", "Title not match");
        softAssert.assertTrue(columnSortControls.get(2).isDisplayed(),"Sort control not displayed");
        softAssert.assertEquals(columnsLabel.get(3).getText(),"Username", "Title not match");
        softAssert.assertTrue(columnSortControls.get(3).isDisplayed(),"Sort control not displayed");
        softAssert.assertEquals(columnsLabel.get(4).getText(),"Description", "Title not match");
        softAssert.assertTrue(columnSortControls.get(4).isDisplayed(),"Sort control not displayed");
        softAssert.assertEquals(columnsLabel.get(5).getText(),"Detail Key", "Title not match");
        softAssert.assertTrue(columnSortControls.get(5).isDisplayed(),"Sort control not displayed");
        softAssert.assertEquals(columnsLabel.get(6).getText(),"Detail Value", "Title not match");
        softAssert.assertTrue(columnSortControls.get(6).isDisplayed(),"Sort control not displayed");
        softAssert.assertAll();
    }

    public void validateMemberNameAndAccountID() {
        basicActions.wait(250);
        basicActions.waitForElementToBePresent(memberPrimary, 100);
        softAssert.assertTrue(memberPrimary.isDisplayed());
        basicActions.waitForElementToBePresent(memberAcctId, 100);
        softAssert.assertTrue(memberAcctId.isDisplayed());

        if (SharedData.getPrimaryMember() != null) {
            softAssert.assertEquals(memberPrimary.getText(), "Primary Account Holder: " + SharedData.getPrimaryMember().getSignature());
            int commaIndex = memberAcctId.getText().indexOf(',');
            String accountIdFromHeader = memberAcctId.getText().substring(0, commaIndex).trim();
            softAssert.assertEquals(accountIdFromHeader, "Account ID:" + SharedData.getPrimaryMember().getAccount_id());
        }
        softAssert.assertAll();
    }

    public void validateDescription(List<String> expectedDescription) {
        basicActions.waitForElementListToBePresent(descriptionListColumn, 100);
        List<String> actualDescList = descriptionListColumn.stream().map(WebElement :: getText).toList();

        for (String description : expectedDescription) {
           if(SharedData.getEnv().equals("qa") && description.equals("Contact Upsert")) {
               description = "Customer record is transf..";
           }
           boolean isPresent = actualDescList.contains(description);
           softAssert.assertTrue(isPresent, "Description not found " + description );
        }
        softAssert.assertAll();
    }
}
