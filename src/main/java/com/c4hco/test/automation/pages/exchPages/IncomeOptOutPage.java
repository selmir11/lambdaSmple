package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncomeOptOutPage {
    // NFA Page

    @FindBy(id="NoFinancialHelpWanted")
    WebElement noThanks;
    private BasicActions basicActions;

    public IncomeOptOutPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @And("I Apply for no financial help")
    public void chooseNoFinancialHelp(){
        getDriver().waitForElementToBePresent(noThanks,10);
        noThanks.click();
    }
}
