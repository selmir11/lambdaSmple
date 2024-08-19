package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GoodNewsMAPage {

    private BasicActions basicActions;
    public GoodNewsMAPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        Assert.assertTrue(basicActions.waitForAngular(10), "page did not load in 10 seconds");    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(name = "noThanksMA")
    WebElement noThanks;

    public void iClickNoThanks(){
        basicActions.waitForElementToBePresent(noThanks, 20);
        noThanks.click();
    }
}
