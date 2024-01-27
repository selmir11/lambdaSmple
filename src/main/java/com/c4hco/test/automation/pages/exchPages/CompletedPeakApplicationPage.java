package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedPeakApplicationPage {
    private BasicActions basicActions;
    public CompletedPeakApplicationPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@id='completedApplicationQYes']")
    WebElement yesImNew;

//    @FindBy(xpath = "//*[@id='completedApplicationQNo']")
//    WebElement noThanksRadioButton;
@FindBy(id = "completedApplicationQNo")
WebElement noThanksRadioButton;
    @FindBy(xpath = "//*[@name='saveAndContinue']")
    WebElement saveAndContinueButton;

    public void setYesImNew(){
        yesImNew.click();
    }

    public void selectNoThanksOption(){
        noThanksRadioButton.click();
    }

    public void clickSaveAndContinueButton(){
        saveAndContinueButton.click();

    }

}
