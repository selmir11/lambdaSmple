package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;

public class AdminPortalReportsPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public AdminPortalReportsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);   }

    @FindBy(css = "thead td:nth-child(4) span:nth-child(1)")
    WebElement eventTime;
    @FindBy(css = "thead td:nth-child(7) span:nth-child(1)")
    WebElement detailKey;
    @FindBy(css = ".report-title")
    WebElement titleAccountActivity;
    @FindBy(xpath = "//tr[@class='sort-table-data-row']")
    List<WebElement> eventCodeList;
    @FindBy(xpath = "//table[@class='sort-table']//td")
    List<WebElement> columnsEventCode;

    public void validateTitleAccountActivity() {
        basicActions.waitForElementListToBePresentWithRetries(eventCodeList, 30);
        softAssert.assertEquals("Account Activity",titleAccountActivity.getText());
        basicActions.waitForElementToBePresent(detailKey,20);
        softAssert.assertEquals("Detail Key",detailKey.getText());
        basicActions.waitForElementToBePresent(eventTime,20);
        softAssert.assertEquals("Time",eventTime.getText());
               softAssert.assertAll(); }

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
    }  }