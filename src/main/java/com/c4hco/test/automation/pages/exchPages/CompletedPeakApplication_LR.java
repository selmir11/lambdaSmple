package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedPeakApplication_LR {
    private BasicActions basicActions;
    public CompletedPeakApplication_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@id='completedApplicationQYes']")
    WebElement yesImNew;
    @FindBy(xpath = "//*[@id='completedApplicationQNo']")
    WebElement noThanks;
    @FindBy(xpath = "//*[@name='saveAndContinue']")
    WebElement saveAndContinue;

    public void setYesImNew(){
        yesImNew.click();
    }

    public void setNoThanks(){
        noThanks.click();
    }

    public void saveAndContinue(){
        saveAndContinue.click();

    }

}
