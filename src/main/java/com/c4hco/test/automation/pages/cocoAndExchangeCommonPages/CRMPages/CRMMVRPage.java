package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMMVRPage {

    private BasicActions basicActions;

    public CRMMVRPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//button[@aria-label='MVR Status']")
    WebElement MVRLabel;

    public void checkMVRStatus(String status){
        basicActions.waitForElementToBePresent(MVRLabel, 30);
        WebElement MVRStatusCheck = basicActions.getDriver().findElement(By.xpath("//button[@aria-label='MVR Status' and @value='"+status+"']"));
    }

}
