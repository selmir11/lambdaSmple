package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncomeOptOutPage {
    // NFA Page

    @FindBy(xpath = "//*[@value='purchase a plan without financial help.']")
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

    //Refactor needed

    public void chooseNoFinancialHelp(){
        noThanks.click();
    }

    public void chooseApply(){
        basicActions.waitForElementToBeClickable(apply, 30);
        apply.click();
    }
}