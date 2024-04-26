package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class PaymentSelectionPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    private String provider;

    public PaymentSelectionPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-PaymentCheck-Paragraph1")
    WebElement text1;

    @FindBy(id = "SOL-PaymentCheck-Paragraph2")
    WebElement text2;

    @FindBy(id = "SOL-PaymentCheck-Paragraph3")
    WebElement text3;

    @FindBy(id = "SOL-PaymentSelection-Continue")
    WebElement continueBtnPaymentSelection;

    @FindBy(id = "SOL-PaymentSelection-GoBack")
    WebElement backBtn;

    @FindBy(id = "SOL-PaymentSelection-MailCheckOrMoneyOrder" )
    WebElement moneyOrderBtn;
    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void clickContinueOnPaymentPage() {
        basicActions.waitForElementToDisappear(spinner, 15);
        softAssert.assertTrue(continueBtnPaymentSelection.isEnabled());
        softAssert.assertAll();
        basicActions.waitForElementToBePresent(continueBtnPaymentSelection,20);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", continueBtnPaymentSelection);
        basicActions.click(continueBtnPaymentSelection);
    }

    public void clickMoneyOrderButton() {
        basicActions.waitForElementToBePresent(moneyOrderBtn, 10);
        moneyOrderBtn.click();
    }

    public String extractProviderName() {
        String pn = SharedData.getFirstPlanNameOnMedicalResultsPage();
        String[] pnSubstring = pn.split(" ");
        provider = pnSubstring[0];

        switch (provider) {
            case "Elevate":
                provider = "Elevate by Denver Health Medical Plan";
                break;
            case "KP":
                provider = "Kaiser Permanente Colorado";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + provider);
    }
    return provider;
}
    public void verifyTextWithCheckPayment(){
        extractProviderName();
        basicActions.waitForElementToBePresent(text1,10);
        softAssert.assertEquals(text1.getText(), "Currently, "+provider+" only accepts payment by check or Money Order.");
        softAssert.assertEquals(text2.getText(), "Please do not send a check until you receive a bill from "+provider+".");
        softAssert.assertEquals(text3.getText(), "You must submit full payment in order for your coverage to begin.");
        softAssert.assertEquals(continueBtnPaymentSelection.getText(),"Continue");
        softAssert.assertTrue(continueBtnPaymentSelection.isEnabled());
        softAssert.assertEquals(backBtn.getText(),"Go Back");
        softAssert.assertTrue(backBtn.isEnabled());
        softAssert.assertAll();
    }
}
