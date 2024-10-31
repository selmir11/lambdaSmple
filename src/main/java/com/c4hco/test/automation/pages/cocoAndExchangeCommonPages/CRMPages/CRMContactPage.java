package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMContactPage {

    @FindBy(xpath = "//li[@title='MVRs/DVRs']")
    WebElement btnMVRDVR;

    private BasicActions basicActions;

    public CRMContactPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openMVRDVRTab(){
        basicActions.waitForElementToBeClickableWithRetries(btnMVRDVR, 60);
        btnMVRDVR.click();
    }

    public void openMVRByTypeName(String mvrType){
        basicActions.wait(5000);
        WebElement linkOpenMVR = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),' - "+mvrType+"')]"));
        linkOpenMVR.click();
    }
}
