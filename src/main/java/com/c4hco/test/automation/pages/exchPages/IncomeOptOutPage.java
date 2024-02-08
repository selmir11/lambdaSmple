package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncomeOptOutPage {
    // NFA Page

    @FindBy(id="NoFinancialHelpWanted")
    WebElement noThanks;

    @FindBy(id = "ApplyForFinancialHelp")
    WebElement apply;

    private BasicActions basicActions;

    public IncomeOptOutPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void chooseNoFinancialHelp(){
        basicActions.waitForElementToBeClickable(noThanks,10);
        noThanks.click();
    }

    public void chooseApply(){
        basicActions.waitForElementToBeClickable(apply, 15);
        apply.click();
    }
}