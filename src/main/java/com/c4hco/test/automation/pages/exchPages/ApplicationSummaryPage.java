package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ApplicationSummaryPage {

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "editBasicInfo")
    WebElement editBasic;
    @FindBy(id = "submitButton_Income")
    WebElement editIncome;

    private BasicActions basicActions;

    public ApplicationSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
        Assert.assertTrue(basicActions.waitForAngular(10), "page did not load in 10 seconds");    }

    public void clickEditBasicLink(){
        editBasic.click();
    }
    public void clickEditIncomelink(){
        editIncome.click();
    }

}
