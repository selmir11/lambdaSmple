package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TobaccoUsageCoCoPage {

    @FindBy(css = "#SHP-StartShop-Continue")
    WebElement continueButton;
    private BasicActions basicActions;

    public TobaccoUsageCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void selectContinueTobacco() {
        basicActions.waitForElementToBeClickable(continueButton, 120);
        basicActions.scrollToElement(continueButton);
        continueButton.click();
    }
}
