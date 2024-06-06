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
    @FindBy(id = "Individual Dashboard-Manage Plans")
    WebElement managePlanButton;
    @FindBy(css = "div.medical-plan-container.plan-container-fill div.plan-info-container>div")
    WebElement medicalPlan;
    @FindBy(css = "div.dental-plan-container.plan-container-fill div.plan-info-container>div")
    WebElement dentalPlan;
    @FindBy(css = "div.manage-plans-title.header-2")
    WebElement managePlanHeader;

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
        softAssert.assertAll();
    }
}