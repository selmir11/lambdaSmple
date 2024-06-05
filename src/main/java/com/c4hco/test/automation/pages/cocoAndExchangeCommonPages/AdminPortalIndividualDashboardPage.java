package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.Then;
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
    @FindBy(css = ".dashboardHeader1")
    WebElement agencyContainerTitle;
    @FindBy(css = ".dashboardHeader2")
    WebElement memberAcctId;
    @FindBy(css = ".container-fluid .reports-container .link-section span:nth-child(1)")
    List<WebElement> reportViewButtons;
    @FindBy(css = ".search-input-and-label .search-input")
    List<WebElement> searchAgencynputList;
    @FindBy(css = "tr[id='agency-name'] td[class='group-box-input']")
    WebElement agencyName;
    @FindBy(css = "tr[id='agency-license-number'] td[class='group-box-input']")
    WebElement stateLicenseNumber;
    @FindBy(css = "tr[id='agency-tin-ein'] td[class='group-box-input']")
    WebElement agencyThin;
    @FindBy(id = "agency-agent")
    WebElement agencyAgent;
    @FindBy(css = "#agency-email > td.group-box-input")
    WebElement agencyEmail;
    @FindBy(id = "agency-website")
    WebElement agencyWebsite;
    @FindBy(css = "tr[id='agency-address'] td[class='group-box-input']")
    WebElement agencyAddress;
    @FindBy(css = "tr[id='agency-prim-phone'] td[class='group-box-input']")
    WebElement agencyPhone;
    @FindBy(css = "tr[id='agency-language'] td[class='group-box-input']")
    WebElement agencyPreferredLanguage;


    public void enterAgencyData(String agencyData, String type) {
        switch (agencyData) {
            case "agencyName":
                searchAgencynputList.get(0).sendKeys(type);
                break;
            case "stateLicenseNumber":
                searchAgencynputList.get(1).sendKeys(type);
                break;
            case "agencyEmail":
                searchAgencynputList.get(2).sendKeys(type);
                break;
            case "businessAddressCity":
                searchAgencynputList.get(3).sendKeys(type);
                break;
            case "businessAddressZip":
                searchAgencynputList.get(4).sendKeys(type);
                break;
            default: throw new IllegalArgumentException("Invalid header option : " + agencyData);
        }
    }


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
        basicActions.waitForElementToBePresent(memberAcctId, 10);
        softAssert.assertTrue(memberAcctId.isDisplayed());
        softAssert.assertAll();     }

    public void verifyAgencyContainerTitle() {
        basicActions.waitForElementToBePresent(agencyContainerTitle, 10);
        softAssert.assertTrue(agencyContainerTitle.isDisplayed());
        basicActions.waitForElementToBePresent(memberAcctId, 10);
        softAssert.assertTrue(memberAcctId.isDisplayed());
        softAssert.assertAll();     }

    public void agencySummaryValidation() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(agencyName, 10));
        softAssert.assertEquals(agencyName.getText(), "Hanks Enterprises");
        softAssert.assertEquals(stateLicenseNumber.getText(), "65873464");
        softAssert.assertEquals(agencyThin.getText(), "546424428");
        softAssert.assertEquals(agencyAgent.getText(), "Agent: Tom Hanks");
        softAssert.assertEquals(agencyEmail.getText(), "invalid@test.com");
        softAssert.assertEquals(agencyWebsite.getText(), "Website:");
        softAssert.assertEquals(agencyAddress.getText(), "234 Wellness Street, Suite 161\n" +
                "Denver, CO 80205");
        softAssert.assertEquals(agencyPhone.getText(), "343-523-6523");
        softAssert.assertEquals(agencyPreferredLanguage.getText(), "English");
        softAssert.assertAll();     }
}
