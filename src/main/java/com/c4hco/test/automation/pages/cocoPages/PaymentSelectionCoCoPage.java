package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PaymentSelectionCoCoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public PaymentSelectionCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-PaymentSelection-Continue")
    WebElement continueBtnPaymentSelection;

    public void paymentSelectionContinueCoCo() {
        basicActions.waitForElementToBeClickable(continueBtnPaymentSelection, 10);
        basicActions.scrollToElement(continueBtnPaymentSelection);
        continueBtnPaymentSelection.click();
    }
}
