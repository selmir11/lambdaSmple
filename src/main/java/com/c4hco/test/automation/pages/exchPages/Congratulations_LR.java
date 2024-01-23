package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Congratulations_LR {
    private BasicActions basicActions;

    public Congratulations_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@value='Save and Continue']")
    WebElement saveAndContinue;

    public void saveContinue(){
        saveAndContinue.click();
    }
}
