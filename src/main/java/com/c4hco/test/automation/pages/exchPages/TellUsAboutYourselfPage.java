package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TellUsAboutYourselfPage {

    private BasicActions basicActions;

    public TellUsAboutYourselfPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    // update the below locators to have ids

    @FindBy(xpath = "//*[@id='genderMale']")
    WebElement sexMale;

    @FindBy(xpath = "//*[@id='genderFemale']")
    WebElement sexFemale;

    @FindBy(xpath = "//*[@id='coverageYes']")
    WebElement applyingYes;
    @FindBy(xpath = "//*[@id='coverageNo']")
    WebElement applyingNo;
    @FindBy(xpath = "//*[@id='continueButton']")
    WebElement saveContinue;
    @FindBy(xpath = "//*[@id='ssn']")
    WebElement ssn;

    public void chooseMale(){
        sexMale.click();
    }
    public void chooseFemale(){
        sexFemale.click();
    }
    public void chooseApplyYes(){
        applyingYes.click();
    }
    public void chooseApplyNo(){
        applyingNo.click();
    }
    public void saveAndContinue(){
        saveContinue.click();
    }

}
