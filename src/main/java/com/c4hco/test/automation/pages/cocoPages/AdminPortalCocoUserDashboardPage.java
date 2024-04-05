package com.c4hco.test.automation.pages.cocoPages;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AdminPortalCocoUserDashboardPage {

    public BasicActions basicActions;

    public AdminPortalCocoUserDashboardPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "a[routerlink='edi-transactions']")
    WebElement viewEDITransactions;

    @FindBy(css = "a[target='_blank'][routerlink='detailed-edi']")
    WebElement viewEDIDetails;

    @FindBy(css = "a[routerlink='activity-report']")
    WebElement viewAccountActivity;

    @FindBy(xpath = "//*[contains(text(),'Manage')]")
    List<WebElement> dashboardButtons;

    public void clickEDITransaction() {
        basicActions.waitForElementToBeClickable(viewEDITransactions, 20);
        viewEDITransactions.click();
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

    public void clickFromDashboardButtons(String DashboardButtons) {
        basicActions.waitForElementListToBePresent(dashboardButtons, 10);
        dashboardButtons.stream().filter(dashboardButtons -> dashboardButtons.getText().equals(DashboardButtons)).findFirst().ifPresent(WebElement::click);
        basicActions.switchtoactiveTab();
    }

}


