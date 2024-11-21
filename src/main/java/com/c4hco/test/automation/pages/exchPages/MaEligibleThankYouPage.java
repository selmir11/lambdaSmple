package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaEligibleThankYouPage {

    private BasicActions basicActions;
    public MaEligibleThankYouPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "submitButton")
    WebElement clickContinue;

    public void clickContinue(){
        basicActions.waitForElementToBePresent(clickContinue, 20);
        clickContinue.click();
    }
}
