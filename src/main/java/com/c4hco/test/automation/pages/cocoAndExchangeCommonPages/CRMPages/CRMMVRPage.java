package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
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

    public void checkMVRStatus(String status){
        basicActions.waitForElementToBePresent(MVRLabel, 30);
        WebElement MVRStatusCheck = basicActions.getDriver().findElement(By.xpath("//button[@aria-label='MVR Status' and @value='"+status+"']"));
    }

    public void checkMVRTitle(String mvrType, String memPrefix){
        basicActions.wait(700);
        basicActions.waitForElementToBePresent(MVRNameHeader, 30);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        String memFullName = null;
        for (String name : allMemberNames) {
            if (name.startsWith(memPrefix)) {
                memFullName = name;
                break;
            }
        }

        softAssert.assertEquals(MVRNameHeader.getText(),memFullName+" - "+mvrType+"- Saved");
        softAssert.assertAll();
    }

}
