package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InitialPaymentCoCoPage {
    private BasicActions basicActions;

    PaymentSelectionCoCoPage paymentSelectionCoCoPage = new PaymentSelectionCoCoPage(WebDriverManager.getDriver());

    public InitialPaymentCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="SOL-InitialPayment-MakePayment")
    List<WebElement> makePaymentBtn;

    @FindBy(id="SOL-InitialPayment-Continue")
    WebElement continueButton;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void selectMakePaymentBtnCoCo(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(makePaymentBtn,20);
        makePaymentBtn.get(0).click();
    }

    public void clickSecondMakePaymentButton(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(makePaymentBtn,20);
        makePaymentBtn.stream().findFirst().ifPresent(WebElement::click);
    }

    public void selectContinueCoCo() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(continueButton, 20);
        continueButton.click();
    }

    public void selectMakeAllPaymentBtnCoCo(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(makePaymentBtn,20);
        while(!makePaymentBtn.isEmpty()){
            basicActions.waitForElementToDisappear(spinner, 20);
            basicActions.waitForElementListToBePresent(makePaymentBtn,20);
            makePaymentBtn.get(0).click();
            paymentSelectionCoCoPage.clickMoneyOrderButton();
            paymentSelectionCoCoPage.paymentSelectionContinueCoCo();
            basicActions.waitForElementToDisappear(spinner, 20);
        }
    }
}
