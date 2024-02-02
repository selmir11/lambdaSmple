package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class IncomeSummaryPage {
    private BasicActions basicActions;
    public IncomeSummaryPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id ="ELIG-summaryDetails-YesButton")
    WebElement btnYesProjectedDiff;

    @FindBy(id = "ELIG-summaryDetails-NoButton")
    WebElement btnNoProjectedDiff;

    @FindBy(id = "pageId-SaveAndContinue")
    WebElement btnContinue;

    public void noProjectedDiff(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(btnNoProjectedDiff, 60));

        btnNoProjectedDiff.click();
        btnContinue.click();
    }
}
