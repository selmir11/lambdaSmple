package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;


public class AdminPortalReportsPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public AdminPortalReportsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);   }

    @FindBy(css = "thead td:nth-child(3) span:nth-child(1)")
    WebElement eventTime;
    @FindBy(css = "thead td:nth-child(6) span:nth-child(1)")
    WebElement detailKey;
    @FindBy(css = ".report-title")
    WebElement titleAccountActivity;
    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> eventCodeList;

    public void validateTitleAccountActivity()  {
        basicActions.waitForElementToBePresent(titleAccountActivity,30);
        softAssert.assertEquals("Account Activity",titleAccountActivity.getText());
        basicActions.waitForElementToBePresent(detailKey,20);
        softAssert.assertEquals("Detail Key",detailKey.getText());
        basicActions.waitForElementToBePresent(eventTime,20);
        softAssert.assertEquals("Time",eventTime.getText());
        softAssert.assertAll(); }
    public void viewActivity(String activityText,String userData,String timeForEvent, String descriptionData) {
        basicActions.waitForElementListToBePresent(eventCodeList,300);
        List<String> username = eventCodeList.stream().filter(s -> s.getText().equals(activityText)).map(AdminPortalReportsPage::getUsername).toList();
        softAssert.assertTrue(username.contains(userData));
        List<String> time = eventCodeList.stream().filter(s -> s.getText().equals(activityText)).map(AdminPortalReportsPage::gettime).toList();
        softAssert.assertTrue(time.contains(timeForEvent));
        List<String> description = eventCodeList.stream().filter(s -> s.getText().equals(activityText)).map(AdminPortalReportsPage::getDescription).toList();
        softAssert.assertTrue(description.contains(descriptionData));
        softAssert.assertAll();     }
    private static String getUsername(WebElement currentUser) {
        String username = currentUser.findElement(By.xpath("following-sibling::td[2]")).getText();
        return username;    }
    private static String gettime(WebElement eventTime) {
        String time = eventTime.findElement(By.xpath("following-sibling::td[1]")).getText();
        return time;    }
    private static String getDescription(WebElement eventDescription) {
        String description = eventDescription.findElement(By.xpath("following-sibling::td[3]")).getText();
        return description;    }
}
