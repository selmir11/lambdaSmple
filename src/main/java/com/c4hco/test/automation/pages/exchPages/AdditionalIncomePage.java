package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AdditionalIncomePage {

    private BasicActions basicActions;
    public AdditionalIncomePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "ELIG-AdditionalIncome-NoIncome-checkBoxButton")
    WebElement chkbxNoneOfThese;

    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement btnContinue;

    public void noAdditionalIncome(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(chkbxNoneOfThese, 60));

        chkbxNoneOfThese.click();
        btnContinue.click();
    }
}
