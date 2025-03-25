package com.c4hco.test.automation.pages.cocoPages;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminPortalCocoUserDashboardPage {

    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalCocoUserDashboardPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Manage')]")
    List<WebElement> dashboardButtons;

    @FindBy(css = ".container-fluid .reports-container .link-section span:nth-child(1)")
    List<WebElement> reportViewButtons;

    @FindBy(xpath = "//*[@id='individualDashboardCocoTitle']")
    WebElement CocoDashboardHeader;

    @FindBy(css = "body app-root h2:nth-child(2)")
    WebElement memberPrimary;

    @FindBy(css = ".dashboardHeader2")
    WebElement memberAcctId;



    public void clickFromDashboardButtons(String DashboardButtons) {
        basicActions.waitForElementListToBePresent(dashboardButtons, 10);
        dashboardButtons.stream().filter(dashboardButtons -> dashboardButtons.getText().equals(DashboardButtons)).findFirst().ifPresent(WebElement::click);
        basicActions.switchtoactiveTab();
    }

    public void viewReportLinks(String searchText) {
        basicActions.waitForElementListToBePresent(reportViewButtons, 20);
        WebElement viewButton = basicActions.getDriver().findElement(By.xpath("//span[contains(normalize-space(), '" + searchText + "')]//following::span[1]"));
        viewButton.click();
        basicActions.switchtoactiveTab();
    }

    public void verifyCocoPrimaryHolderHeader() {
        basicActions.wait(250);
        basicActions.waitForElementToBePresent(memberPrimary, 100);
        softAssert.assertTrue(memberPrimary.isDisplayed());
        basicActions.waitForElementToBePresent(memberAcctId, 60);
        softAssert.assertTrue(memberAcctId.isDisplayed());
        if (SharedData.getPrimaryMember() != null) {
            softAssert.assertEquals(CocoDashboardHeader.getText() , "Colorado Connect" , "Coco header not match");
            softAssert.assertEquals(memberPrimary.getText(), "Primary Account Holder: " + SharedData.getPrimaryMember().getSignature());
            softAssert.assertEquals(memberAcctId.getText(), "Account ID:" + SharedData.getPrimaryMember().getAccount_id());
        }
        softAssert.assertAll();
    }
}






