package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InitialPaymentPage {
    private BasicActions basicActions;

    public InitialPaymentPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="SOL-InitialPayment-MakePayment")
    List<WebElement> makePaymentBtn;

    @FindBy(id = "SOL-InitialPayment-Continue")
    WebElement continueBtn;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    // TO DO: create a re-usable method for clicking on make payment button for all the plans.
    public void selectMakePaymentButton(){
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementListToBePresent(makePaymentBtn,20);
        makePaymentBtn.get(0).click();
    }

    public void clickSecondMakePaymentButton(){
        basicActions.waitForElementListToBePresent(makePaymentBtn,20);
        makePaymentBtn.stream().findFirst().ifPresent(WebElement::click);
    }

    public void clickContinue(){
        basicActions.waitForElementToBeClickable(continueBtn, 10);
        continueBtn.click();
    }
}
