package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMSearchResultsPage {

    private BasicActions basicActions;

    public CRMSearchResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openResultByName(){
        //basicActions.wait(5000);
        basicActions.waitForElementToBeClickableWithRetries(basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+ SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName()+"')]")), 30);
        WebElement linkOpenContact = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+ SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName()+"')]"));
        linkOpenContact.click();

    }
}
