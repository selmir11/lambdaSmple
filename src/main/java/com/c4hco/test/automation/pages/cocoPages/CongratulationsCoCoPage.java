package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CongratulationsCoCoPage {
    private BasicActions basicActions;

    public CongratulationsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-WhatsNext-Okay")
    WebElement saveAndContinueBtn;

    public void clickSaveContinueCongratsCoCo(){
        basicActions.waitForElementToBeClickable( saveAndContinueBtn, 60);
        saveAndContinueBtn.click();

    }

}
