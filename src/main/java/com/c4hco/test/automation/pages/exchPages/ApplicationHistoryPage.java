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
import java.util.NoSuchElementException;

public class ApplicationHistoryPage {

    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;
    @FindBy(xpath = "//button[@name= 'viewResults']")
    WebElement viewResultsAndShop;
    @FindBy(id = "price-background")
    WebElement aptcSection;
    @FindBy(css = "table tbody  #align-right")
    List<WebElement> applicationSummary;
    @FindBy(className = "self-attestation-title")
    WebElement MVRPopUp;
    @FindBy(name = "verify-myinfo-btn")
    WebElement verifyMyInfoButton;
    @FindBy(name= "close")
    WebElement verifyMyInfoNoButton;
    //@FindBy(css=".self-attestation-title")
    //WebElement mvrPopUp;
    //@FindBy(css= ".no-self-attestation-btn")
    //WebElement noBtnMvrPopUp;

    private BasicActions basicActions;

    public ApplicationHistoryPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickViewResults() {
        setApplicationId();

        try {
            if (MVRPopUp.isDisplayed()) {
                System.out.println("Pop-up is displayed. Closing the pop-up.");
                verifyMyInfoNoButton.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Pop-up or button not found, continuing with the next steps.");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        try {
            if (viewResultsAndShop.isDisplayed() && viewResultsAndShop.isEnabled()) {
                System.out.println("Clicking the 'View Results' button.");
                viewResultsAndShop.click();
            } else {
                System.out.println("The 'View Results' button is not visible or not clickable.");
            }
        } catch (Exception e) {
            System.err.println("Failed to click 'View Results' button: " + e.getMessage());
        }
		
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
        basicActions.waitForElementToBePresent(verifyMyInfoButton,10);
        verifyMyInfoButton.click();
    }
}
