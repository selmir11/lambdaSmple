package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class CRMMVRPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Set<String> allMemberNames = new HashSet<>();

    public CRMMVRPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//button[@aria-label='MVR Status']")
    WebElement MVRLabel;

    @FindBy(xpath = "//*[contains(@id, 'formHeaderTitle_')]")
    WebElement MVRNameHeader;

    @FindBy(xpath = "//div[4]//div[1]/div[1]/div[3]/div[1]/div/div/div/span")
    WebElement MVRNameSubHeader;

    @FindBy(xpath = "//*[contains(@id, 'c4hco_name.fieldControl-text-input-component')]")
    WebElement MVRNameInput;

    @FindBy(xpath = "//*[contains(@id, 'c4hco_verificationtype')]//input")
    WebElement MVRVerificationTypeInput;

    public void checkMVRStatus(String status){
        basicActions.waitForElementToBePresent(MVRLabel, 30);
        WebElement MVRStatusCheck = basicActions.getDriver().findElement(By.xpath("//button[@aria-label='MVR Status' and @value='"+status+"']"));
    }

    public void checkMVRTitle(String mvrType, String memPrefix){
        basicActions.wait(1300);
        basicActions.waitForElementToBePresentWithRetries(MVRNameHeader, 30);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        String memFullName = null;
        for (String name : allMemberNames) {
            if (name.startsWith(memPrefix)) {
                memFullName = name;
                break;
            }
        }

        softAssert.assertEquals(MVRNameHeader.getText(),memFullName+" - "+mvrType+"- Saved");
        softAssert.assertEquals(MVRNameSubHeader.getText(),"Manual Verification Request");
        softAssert.assertAll();
    }

    public void checkMVRData(String mvrType, String memPrefix){
        basicActions.wait(700);
        basicActions.waitForElementToBePresentWithRetries(MVRNameHeader, 30);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        String memFullName = null;
        for (String name : allMemberNames) {
            if (name.startsWith(memPrefix)) {
                memFullName = name;
                break;
            }
        }

        softAssert.assertEquals(MVRNameInput.getAttribute("title"),memFullName+" - "+mvrType);
        softAssert.assertEquals(MVRVerificationTypeInput.getAttribute("defaultValue"),mvrType);
        softAssert.assertAll();
    }

}
