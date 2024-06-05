package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class DashboardPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//strong[normalize-space()='Broker Dashboard']")
    WebElement brokerDashboard;

    @FindBy(xpath = "//a[@class='action-link']")
    WebElement c4ULink;

    private BasicActions basicActions;
    public DashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickBrokerDashboard(){
        basicActions.waitForElementToBeClickable(brokerDashboard,10);
        brokerDashboard.click();
    }

    public void clickC4ULink(){
        basicActions.waitForElementToBeClickable(c4ULink,10);
        c4ULink.click();
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
    }








}
