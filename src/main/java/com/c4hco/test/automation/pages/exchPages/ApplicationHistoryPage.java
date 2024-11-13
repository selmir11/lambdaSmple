package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ApplicationHistoryPage {

    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;
    @FindBy(xpath = "//button[@name= 'viewResults']")
    WebElement viewResultsAndShop;
    @FindBy(id = "price-background")
    WebElement aptcSection;
    @FindBy(css = "table tbody  #align-right")
    List<WebElement> applicationSummary;
    @FindBy(css=".self-attestation-title")
    WebElement mvrPopUp;
    @FindBy(css= ".no-self-attestation-btn")
    WebElement noBtnMvrPopUp;
    @FindBy(css = ".yes-self-attestation-btn")
    WebElement yesBtnMvrPopUp;

    private BasicActions basicActions;

    public ApplicationHistoryPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickViewResults(){
        setApplicationId();
        if(mvrPopUp.isDisplayed()){
            noBtnMvrPopUp.click();
        }
        basicActions.waitForElementToBeClickable(viewResultsAndShop, 10);
        basicActions.clickElementWithRetries(viewResultsAndShop, 10);
    }

    private void setApplicationId(){
        basicActions.waitForElementListToBePresent(applicationSummary, 10);
        String applicationid = applicationSummary.get(0).getText();
        SharedData.getPrimaryMember().setApplication_id(applicationid);
        System.out.println("Application Id : "+ applicationid);
    }

    public void validateAPTC(String expectedAPTC){
        basicActions.waitForElementToBePresent(lblAPTCValue, 30);
        String APTC = lblAPTCValue.getText();
        Assert.assertTrue(APTC.contains(expectedAPTC),"Incorrected APTC Amount! Expected "+expectedAPTC+" but "+APTC+" displayed.");
    }

    public void validateTextOnPage(String Text){
        basicActions.waitForElementToBePresent(lblAPTCValue, 15);

        basicActions.waitForElementToBePresent(basicActions.getDriver().findElement(By.xpath("//*[text()='"+Text+"']")), 15);
    }

    public void validateTextDoesNotExistOnPage(String Text){
        basicActions.waitForElementToBePresent(viewResultsAndShop, 15);
        Assert.assertEquals(0, basicActions.getDriver().findElements(By.xpath("//*[text()='"+Text+"']")).size());
    }

    public void validateAptcSectionDoesntExist(){
        basicActions.waitForElementToBePresent(viewResultsAndShop, 10);
        Assert.assertFalse(basicActions.isElementDisplayed(aptcSection, 3));
    }

    public void clickVerifyMyInfoText(){
        basicActions.waitForElementToBePresent(yesBtnMvrPopUp,10);
        yesBtnMvrPopUp.click();
    }
}