package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmploymentSummaryPage {
    private BasicActions basicActions;
    public EmploymentSummaryPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "EmploymentSummary-SaveAndContinue")
    WebElement btnContinue;

    public void clickContinue(){
        basicActions.waitForElementToBeClickable(btnContinue, 10);
        btnContinue.click();
    }

}
