package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TobaccoUsageExchPage {

    @FindBy(id = "SHP-StartShop-Continue")
    WebElement continueButton;

    private BasicActions basicActions;
    public TobaccoUsageExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void selectContinueTobacco() {
        basicActions.waitForElementToBeClickable(continueButton, 10);
        basicActions.scrollToElement(continueButton);
        continueButton.click();
    }
}
