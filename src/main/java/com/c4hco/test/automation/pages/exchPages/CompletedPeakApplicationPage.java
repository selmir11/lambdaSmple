package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedPeakApplicationPage {
    private BasicActions basicActions;
    public CompletedPeakApplicationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
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
