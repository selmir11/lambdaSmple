package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CRMContactPage {

    @FindBy(xpath = "//li[@title='MVRs/DVRs']")
    WebElement btnMVRDVR;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public CRMContactPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openMVRDVRTab(){
        basicActions.wait(7000);
        basicActions.waitForElementToBePresentWithRetries(btnMVRDVR, 60);
        basicActions.clickElementWithRetries(btnMVRDVR, 60);
    }

    public void openMVRByTypeName(String mvrType){
        basicActions.wait(5000);
        WebElement linkOpenMVR = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),' - "+mvrType+"')]"));
        linkOpenMVR.click();
    }

    public void openDVRByTypeName(String dvrType, int typeNumber){
        basicActions.wait(5000);
        WebElement linkOpenDVR = basicActions.getDriver().findElement(By.xpath("//div["+typeNumber+"]/div[2]/div/div/div/div/div[1]/div/a//span[contains(.,'"+dvrType+"')]"));
        linkOpenDVR.click();
    }

// ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line

    public void verifyStatus(String dvrType, int typeNumber, String status){
        basicActions.wait(5000);
        WebElement statusData = basicActions.getDriver().findElement(By.xpath("//div["+typeNumber+"]/div[2]/div/div/div/div/div[1]/div/a//span[contains(.,'"+dvrType+"')]//following::div[30]"));
        softAssert.assertEquals(statusData.getText(),status);
        softAssert.assertAll();
    }
}
