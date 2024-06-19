package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNextCoCoPage {
    private BasicActions basicActions;

    public WhatsNextCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-WhatsNext-Okay")
    WebElement welcomeBtn;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void clickWelcomeBtn(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(welcomeBtn, 10);
        basicActions.scrollToElement(welcomeBtn);
        basicActions.click(welcomeBtn);
    }
}
