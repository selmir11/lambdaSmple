package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MyClientAssistNetPortal {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public MyClientAssistNetPortal(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(id = "client-data-title-row")
    WebElement clientRowAP;
    @FindBy(xpath = "(//mat-expansion-panel-header[contains(@id, 'mat-expansion-panel-header')])[2]")
    WebElement clientSecondRow;
    @FindBy(xpath = "//span[@class='col-2']")
    WebElement selectedClientCount;


    public void validateTheClientIsRemovedSuccessfullyFromAssistnetPortal() {
        basicActions.waitForElementToDisappear(clientSecondRow,20);
        basicActions.waitForElementToDisappear(clientRowAP,20);

    }

    public void validateTotalSelectedClientCount(String expectedCount){
        basicActions.waitForElementToBePresent(selectedClientCount,30);
        softAssert.assertEquals(selectedClientCount.getText(), expectedCount + " Clients Selected");
        softAssert.assertAll();
    }

}
