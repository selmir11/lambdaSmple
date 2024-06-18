package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class DashboardPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//strong[normalize-space()='Agency Dashboard']")
    WebElement agencyDashboard ;

    @FindBy(xpath = "//strong[normalize-space()='Broker Dashboard']")
    WebElement brokerDashboard;

    @FindBy(id = "manage-account-button")
    WebElement completeProfile;

    @FindBy(id = "agency-manage-account-button")
    WebElement AgencyCompleteProfile;

    @FindBy(xpath = "//a[@class='action-link']")
    WebElement c4ULink;

    @FindBy(xpath = "//button[normalize-space()='Manage Brokers']")
    WebElement manageBrokersButton;

    @FindBy(xpath = "//a[normalize-space()='View']")
    WebElement myAgencyView;

    private BasicActions basicActions;
    public DashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickAgencyDashboard(){
        basicActions.waitForElementToBePresent(agencyDashboard,10);
        agencyDashboard.click();
    }

    public void clickBrokerDashboard(){
        basicActions.waitForElementToBePresent(brokerDashboard,10);
        brokerDashboard.click();
    }

    public void clickCompleteProfile(){
        basicActions.waitForElementToBePresent(completeProfile,10);
        completeProfile.click();
    }

    public void clickAgencyCompleteProfile(){
        basicActions.waitForElementToBePresent(AgencyCompleteProfile,10);
        AgencyCompleteProfile.click();
    }

    public void clickC4ULink(){
        basicActions.waitForElementToBeClickable(c4ULink,10);
        c4ULink.click();
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
    }

    public void clickManageBrokersButton(){
        basicActions.waitForElementToBePresent(manageBrokersButton, 10);
        manageBrokersButton.click();
    }

    public void clickMyAgencyView(){
        basicActions.waitForElementToBePresent(myAgencyView, 10);
        myAgencyView.click();
    }


}
