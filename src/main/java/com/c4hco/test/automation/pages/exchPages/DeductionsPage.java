package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DeductionsPage {
    private BasicActions basicActions;
    public DeductionsPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "ELIG-Deductions-NoDeductions-checkBoxButton")
    WebElement chkbxNoDeductions;

    @FindBy(id = "Deductions-SaveAndContinue")
    WebElement btnContinue;

    public void noDeductions(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(chkbxNoDeductions, 60));

        chkbxNoDeductions.click();
        btnContinue.click();
    }
}
