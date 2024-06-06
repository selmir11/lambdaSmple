package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AssistnetDashboardPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public AssistnetDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "viewMyClients")
    WebElement viewMyClientBTN ;
    @FindBy(xpath = "//span[@class='mdc-button__label']")
    WebElement printBtn;
    @FindBy(id = "user-first-name")
    WebElement usernamedrp;
    @FindBy(id = "logout-link")
    WebElement logoutLnk;

    public void ClickOnViewMyClients() {
        basicActions.waitForElementToBePresent(viewMyClientBTN,15);
        viewMyClientBTN.click();
    }

    public void verifyPrintButtonInAP() {
            basicActions.waitForElementToBePresent(printBtn,10);
            softAssert.assertTrue(printBtn.isDisplayed());
            softAssert.assertTrue(printBtn.isEnabled());
            softAssert.assertAll();}

    public void ClickOnUsernameDropdown() {
        basicActions.waitForElementToBePresent(usernamedrp,20);
        usernamedrp.click();
    }

    public void ClickSignOutFromTheAP() {
        basicActions.waitForElementToBePresent(logoutLnk,20);
        logoutLnk.click();
    }
}
