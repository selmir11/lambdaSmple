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
    @FindBy(id = "Individual Dashboard-Manage Plans")
    WebElement managePlanButton;
    @FindBy(css = "div.medical-plan-container.plan-container-fill div.plan-info-container>div")
    WebElement medicalPlan;
    @FindBy(css = "div.dental-plan-container.plan-container-fill div.plan-info-container>div")
    WebElement dentalPlan;
    @FindBy(css = "div.manage-plans-title.header-2")
    WebElement managePlanHeader;
    @FindBy(css = "label[for='selected-member-checkbox']")
    WebElement selectedMember;
    @FindBy(css = "#full-name")
    WebElement memberFullName;
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#phone-number")
    WebElement memberPhone;
    @FindBy(css = "#email-address")
    WebElement memberEmail;
    @FindBy(css = "#dob")
    WebElement memberDob;
    @FindBy(css = "body app-root div:nth-child(6)")
    WebElement memberAddress;
    @FindBy(css = "div[id='groupBox1'] p[class='group-title']")
    List<WebElement> titleOfContainer;
    @FindBy(xpath = "//p[normalize-space()='Plans']")
    WebElement plansTitle;
    @FindBy(css = "div[class='group-box summary-container'] p[class='group-title']")
    WebElement summaryTitle;
    @FindBy(xpath = "//p[normalize-space()='Eligibility']")
    WebElement eligibilityTitle;
    @FindBy(css = ".dashboardHeader-renewal")
    WebElement renewalsTitle;
    @FindBy(xpath = "//p[normalize-space()='Payloads']")
    WebElement payloadsTitle;


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
    public void agencySummaryValidation(String name, String license, String thin, String agent, String email, String website, String phone, String preferredLanguage) {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(agencyName, 10));
        softAssert.assertEquals(agencyName.getText(),name);
        softAssert.assertEquals(stateLicenseNumber.getText(), license);
        softAssert.assertEquals(agencyThin.getText(), thin);
        softAssert.assertEquals(agencyAgent.getText(), agent);
        softAssert.assertEquals(agencyEmail.getText(), email);
        softAssert.assertEquals(agencyWebsite.getText(), website);
        softAssert.assertEquals(agencyPhone.getText(), phone);
        softAssert.assertEquals(agencyPreferredLanguage.getText(), preferredLanguage);
        softAssert.assertAll();     }
    public void validateAgencyAddress(String address){
        basicActions.waitForElementToBePresent(agencyAddress, 10);
        softAssert.assertTrue(agencyAddress.isDisplayed());
        softAssert.assertAll(); }
    public void clickManagePlan() {
        basicActions.waitForElementToBeClickable(managePlanButton, 10);
        basicActions.click(managePlanButton);
    }
    public void verifyPlanDetails(List<String> data) {
        basicActions.waitForElementToBePresent(managePlanHeader, 20);
        softAssert.assertEquals(managePlanHeader.getText(), data.get(0));
        basicActions.waitForElementToBePresent(medicalPlan, 20);
        softAssert.assertEquals(medicalPlan.getText(),data.get(1));
        basicActions.waitForElementToBePresent(dentalPlan, 20);
        softAssert.assertEquals(dentalPlan.getText(),data.get(2));
    }
    public void validateSelectedMemberData()  {
        basicActions.switchToParentPage("C4HCO Admin Portal");
        basicActions.waitForElementToBePresent(selectedMember,30);
        softAssert.assertTrue(selectedMember.isDisplayed());
        softAssert.assertTrue(memberFullName.isDisplayed());
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertTrue(memberEmail.isDisplayed());
        softAssert.assertTrue(memberPhone.isDisplayed());
        softAssert.assertTrue(memberDob.isDisplayed());
        softAssert.assertTrue(memberAddress.isDisplayed());
        softAssert.assertAll(); }
    public void validateIndividualDashboardContainerTitles(String plans, String summary, String eligibility, String renewals, String reports, String payloads)   {
        basicActions.waitForElementToBePresent(plansTitle,30);

        softAssert.assertEquals(plansTitle.getText(),plans);
        softAssert.assertEquals(summaryTitle.getText(),summary);
        softAssert.assertEquals(eligibilityTitle.getText(),eligibility);
        softAssert.assertEquals(renewalsTitle.getText(),renewals);
        softAssert.assertEquals(reportsTitle.getText(),reports);
        softAssert.assertEquals(payloadsTitle.getText(),payloads);
        softAssert.assertAll(); }
}


