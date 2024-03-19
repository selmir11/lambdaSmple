package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TobaccoUsageCoCoPage {
    private BasicActions basicActions;

    public TobaccoUsageCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SHP-StartShop-Continue")
    public WebElement continueButton;

    public void selectContinueTobacco() {
        basicActions.waitForElementToBeClickable(continueButton, 60);
        continueButton.click();
    }
}
