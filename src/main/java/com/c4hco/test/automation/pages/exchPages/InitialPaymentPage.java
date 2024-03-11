package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPaymentPage {
    private BasicActions basicActions;

    public InitialPaymentPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="SOL-InitialPayment-MakePayment")
    WebElement makePaymentBtn;

    @FindBy(id = "SOL-InitialPayment-Continue")
    WebElement continueBtn;

    public void selectMakePaymentButton(){
        basicActions.waitForElementToBeClickable(makePaymentBtn,20);
        makePaymentBtn.click();
    }

    public void clickContinue(){
        basicActions.waitForElementToBeClickable(continueBtn, 10);
        continueBtn.click();
    }
}
