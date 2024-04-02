package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPortalUserDashboardPage {

    public BasicActions basicActions;

    public AdminPortalUserDashboardPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//a[normalize-space()='Manage Plans']")
    WebElement ManagePlans;

    @FindBy(xpath = "//a[normalize-space()='Manage Account Access']")
    WebElement ManageAcctAccess;

    @FindBy(xpath = "//a[normalize-space()='Manage Account Details']")
    WebElement ManageAcctDetails;

    @FindBy(css = "a[routerlink='edi-transactions']")
    WebElement viewEDITransactions;

    @FindBy(css = "a[target='_blank'][routerlink='detailed-edi']")
    WebElement viewEDIDetails;

    @FindBy(css = "a[routerlink='activity-report']")
    WebElement viewAccountActivity;

    public void clickManagePlans() {
        basicActions.waitForElementToBeClickable(ManagePlans, 30);
        ManagePlans.click();
        basicActions.switchtoactiveTab();

    }

    public void clickManageAcctAccess() {
        basicActions.waitForElementToBeClickable(ManageAcctAccess, 20);
        ManageAcctAccess.click();
        basicActions.switchtoactiveTab();
    }

    public void clickManageAcctDetails() {
        basicActions.waitForElementToBeClickable(ManageAcctDetails, 20);
        ManageAcctDetails.click();
        basicActions.switchtoactiveTab();
    }

    public void clickEDITransaction() {
        basicActions.waitForElementToBeClickable(viewEDITransactions, 20);
        ManageAcctDetails.click();
        basicActions.switchtoactiveTab();
    }

    public void clickEDIDetails() {
        basicActions.waitForElementToBeClickable(viewEDIDetails, 20);
        viewEDIDetails.click();
        basicActions.switchtoactiveTab();
    }

    public void clickAccountActivity() {
        basicActions.waitForElementToBeClickable(viewAccountActivity, 20);
        viewAccountActivity.click();
        basicActions.switchtoactiveTab();
    }

}








