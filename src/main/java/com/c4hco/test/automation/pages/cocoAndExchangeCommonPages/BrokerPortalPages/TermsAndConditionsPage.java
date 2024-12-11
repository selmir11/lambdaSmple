package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class TermsAndConditionsPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(id = "terms-submit")
    WebElement submitTermsAndConditionsPage;

    @FindBy(xpath = "//*[@id='elem']/app-profile-complete/div/div[3]/button")
    WebElement goToMyDashboardButton;

    private BasicActions basicActions;

    public TermsAndConditionsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickSubmitBrokerPortalTermsPage(){
        basicActions.waitForElementToBeClickable(submitTermsAndConditionsPage,10);
        submitTermsAndConditionsPage.click();
    }

    public void clickGoToMyDashboard(){
        basicActions.waitForElementToBePresentWithRetries(goToMyDashboardButton, 10);
        goToMyDashboardButton.click();
    }
}
