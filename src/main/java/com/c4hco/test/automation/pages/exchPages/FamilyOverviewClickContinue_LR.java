package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyOverviewClickContinue_LR {
    private BasicActions basicActions;
    public FamilyOverviewClickContinue_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    @FindBy(xpath = "//*[@value='Save and Continue']")
    WebElement saveAndContinue;

    @FindBy(xpath = "//*[@id='submitButton_AddMember']")
    WebElement addAdditionalMember;

    public void clickContinue(){
        saveAndContinue.click();
    }
}
