package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class AdminPortalIndividualDashboardPage {

    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalIndividualDashboardPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//p[normalize-space()='Reports']")
    WebElement reportsTitle;
    @FindBy(css = "body app-root h2:nth-child(2)")
    WebElement memberPrimary;
    @FindBy(css = ".dashboardHeader2")
    WebElement memberId;
    @FindBy(css = ".container-fluid .reports-container .link-section span:nth-child(1)")
    List<WebElement> reportViewButtons;
    WebElement selectedMember;
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#phone-number")
    WebElement memberPhone;
    @FindBy(css = "#email-address")
    WebElement memberEmail;
    @FindBy(css = "#dob")
    WebElement memberDob;
    @FindBy(xpath = "//span[normalize-space()='4725 S TAFT ST MORRISON, CO 80465']")
    WebElement memberAddress;

    public void verifyContainerTitle() {
        basicActions.waitForElementToBePresent(reportsTitle, 10);
        softAssert.assertTrue(reportsTitle.isDisplayed());
        softAssert.assertAll();     }
    public void viewReportLinks(String searchText) {
        basicActions.waitForElementListToBePresent(reportViewButtons, 20);
        WebElement viewButton = basicActions.getDriver().findElement(By.xpath("//span[contains(normalize-space(), '" + searchText + "')]//following::span[1]"));
        viewButton.click();
        basicActions.switchtoactiveTab();       }
    public void verifyPrimaryHolder() {
        basicActions.waitForElementToBePresent(memberPrimary, 10);
        softAssert.assertTrue(memberPrimary.isDisplayed());
        basicActions.waitForElementToBePresent(memberId, 10);
        softAssert.assertTrue(memberId.isDisplayed());
        softAssert.assertAll();     }
    public void validateSelectedMemberData()  {
        basicActions.switchToParentPage("C4HCO Admin Portal");
        basicActions.waitForElementToBePresent(selectedMember,10);
        basicActions.waitForElementToBePresent(memberDob,10);
        softAssert.assertEquals("10/10/1980",memberDob.getText());
        basicActions.waitForElementToBePresent(userName,10);
        softAssert.assertEquals("julynineth567@test.com",userName.getText());
        basicActions.waitForElementToBePresent(memberEmail,10);
        softAssert.assertEquals("xxmatusz@gmail.com",memberEmail.getText());
        basicActions.waitForElementToBePresent(memberPhone,10);
        softAssert.assertEquals("303-330-1222",memberPhone.getText());
        basicActions.waitForElementToBePresent(memberAddress,10);
        softAssert.assertEquals("4725 S TAFT ST\n" + "MORRISON, CO 80465",memberAddress.getText());
        softAssert.assertAll(); }
}
