package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ApplicationSummaryPage {

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "editBasicInfo")
    WebElement editBasicInfoButton;
    @FindBy(id = "submitButton_Income")
    WebElement editIncome;

    private BasicActions basicActions;

    public ApplicationSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    public void clickEditBasicLink(){
        basicActions.waitForElementToBePresent(editBasicInfoButton, 30);
        basicActions.scrollToElement(editBasicInfoButton);
        editBasicInfoButton.click();
    }
    public void clickEditIncomelink(){
        editIncome.click();
    }

}
