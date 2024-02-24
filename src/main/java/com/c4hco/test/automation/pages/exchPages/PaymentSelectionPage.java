package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PaymentSelectionPage {
    private BasicActions basicActions;

    public PaymentSelectionPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="SOL-PaymentCheck-Paragraph1")
    WebElement text1;

    @FindBy(id = "SOL-PaymentCheck-Paragraph2")
    WebElement text2;
    @FindBy(id ="SOL-PaymentCheck-Paragraph3")
    WebElement text3;

    @FindBy(id = "SOL-PaymentSelection-Continue")
    WebElement continueBtnPaymentSelection;
    @FindBy(id = "SOL-PaymentSelection-GoBack")
    WebElement backBtn;

    public void paymentSelectionContinue(){
        continueBtnPaymentSelection.click();
    }

    public void verifyTextWithCheckPayment(){
        basicActions.waitForElementToBePresent(text1,10);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text1.getText(), "Currently,  Elevate by Denver Health Medical Plan  only accepts payment by check or Money Order.");
        softAssert.assertEquals(text2.getText(), "Please do not send a check until you receive a bill from Elevate by Denver Health Medical Plan.");
        softAssert.assertEquals(text3.getText(), "You must submit full payment in order for your coverage to begin.");
        softAssert.assertEquals(continueBtnPaymentSelection.getText(),"Continue");
        softAssert.assertTrue(continueBtnPaymentSelection.isEnabled());
        softAssert.assertEquals(backBtn.getText(),"Go Back");
        softAssert.assertTrue(backBtn.isEnabled());
    }

}
