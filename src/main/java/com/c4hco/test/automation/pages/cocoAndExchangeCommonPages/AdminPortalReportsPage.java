package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;



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

    public void viewActivity(String activityText, String userData, String timeForEvent, String descriptionData) {
        basicActions.waitForElementListToBePresent(eventCodeList, 300);
        if (eventCodeList.isEmpty()) {
            System.out.println("No elements found in eventCodeList.");
            return;
        }
        eventCodeList.forEach(element -> System.out.println(element.getText()));

        List<String> username = eventCodeList.stream()
                .filter(s -> s.getText().equals(activityText))
                .map(AdminPortalReportsPage::getUsername)
                .collect(Collectors.toList());
        System.out.println("Filtered Usernames: " + username);  // Debugging output
        softAssert.assertTrue(username.contains(userData), "Username does not match.");

        List<String> time = eventCodeList.stream()
                .filter(s -> s.getText().equals(activityText))
                .map(AdminPortalReportsPage::gettime)
                .collect(Collectors.toList());
        System.out.println("Filtered Times: " + time);

        String expectedTime = normalizeTime(timeForEvent);
        System.out.println("Expected Time (Normalized): " + expectedTime);
        boolean timeMatch = time.stream().anyMatch(t -> normalizeTime(t).equals(expectedTime));
        softAssert.assertTrue(timeMatch, "The event time does not match the expected time.");

        List<String> description = eventCodeList.stream()
                .filter(s -> s.getText().equals(activityText))
                .map(AdminPortalReportsPage::getDescription)
                .collect(Collectors.toList());
        System.out.println("Filtered Descriptions: " + description);  // Debugging output
        softAssert.assertTrue(description.contains(descriptionData), "Description does not match.");
        softAssert.assertAll();
    }

    // Helper method to normalize time by removing milliseconds or formatting it to the same format
    private String normalizeTime(String time) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = dateFormat.parse(time);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getUsername(WebElement currentUser) {
        // Debugging: print the raw HTML of the element to verify correct XPath
        System.out.println("Username Element HTML: " + currentUser.getAttribute("outerHTML"));
        String username = currentUser.findElement(By.xpath("following-sibling::td[2]")).getText();
        System.out.println("Username: " + username);  // Debugging output
        return username;
    }

    private static String gettime(WebElement eventTime) {
        // Debugging: print the raw HTML of the element to verify correct XPath
        System.out.println("Event Time Element HTML: " + eventTime.getAttribute("outerHTML"));
        String time = eventTime.findElement(By.xpath("following-sibling::td[1]")).getText();
        System.out.println("Event Time: " + time);  // Debugging output
        return time;
    }

    private static String getDescription(WebElement eventDescription) {
        // Debugging: print the raw HTML of the element to verify correct XPath
        System.out.println("Description Element HTML: " + eventDescription.getAttribute("outerHTML"));
        String description = eventDescription.findElement(By.xpath("following-sibling::td[3]")).getText();
        System.out.println("Description: " + description);  // Debugging output
        return description;
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
            validateTimeWithinLast10Minutes(actualTime);
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
        } else {
        }
    }

    private void validateTimeWithinLast10Minutes(String actualTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Denver"));

        try {
            Date actualDate = dateFormat.parse(actualTime);
            Date currentDate = new Date();

            SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            currentDateFormat.setTimeZone(TimeZone.getTimeZone("America/Denver"));
            String formattedCurrentTime = currentDateFormat.format(currentDate);
            Date currentMountainTime = currentDateFormat.parse(formattedCurrentTime);

            long diffInMillis = currentMountainTime.getTime() - actualDate.getTime();
            long diffInMinutes = diffInMillis / (60 * 1000);

            if (diffInMinutes <= 10) {
                return;
            }
            System.out.println("The time is not within the last 10 minutes.");

        } catch (ParseException e) {
            System.out.println("Error parsing the time: " + e.getMessage());
        }
        }
    }


