package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmploymentSummaryPage {
    private BasicActions basicActions;
    public EmploymentSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "EmploymentSummary-SaveAndContinue")
    WebElement btnContinue;

    @FindBy(xpath = "//*[starts-with(@id,'edit')]")
    WebElement lnkEditIncome;

    public void clickContinue(){
        basicActions.waitForElementToBePresent(btnContinue,30);
        basicActions.waitForElementToBeClickable(btnContinue, 30);
        btnContinue.click();
    }

    public void clickEditIncome(int Index){
        basicActions.waitForElementToBePresent(lnkEditIncome,10);
        Index -=1;
        lnkEditIncome.click();

    }

}
