package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPaymentCoCoPage {
    private BasicActions basicActions;

    public InitialPaymentCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="SOL-InitialPayment-MakePayment")
    WebElement makePaymentBtn;

    @FindBy(id="SOL-InitialPayment-Continue")
    WebElement continueButton;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void selectMakePaymentBtnCoCo(){
        basicActions.waitForElementToBePresent(makePaymentBtn,20);
        makePaymentBtn.click();
    }

    public void selectContinueCoCo() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(continueButton, 20);
        continueButton.click();
    }
}
