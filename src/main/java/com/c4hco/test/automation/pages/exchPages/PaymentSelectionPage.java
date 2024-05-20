package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;


public class PaymentSelectionPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    private String provider;

    public PaymentSelectionPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(id = "SOL-PaymentSelection-HowLikeToPay")
    WebElement likeToPay;

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

    @FindBy(id = "SOL-PaymentSelection-MailCheckOrMoneyOrder")
    WebElement moneyOrderBtn;
    @FindBy(id = "SOL-PaymentSelection-WithdrawalFromBankAccount")
    WebElement withdrawalFromBankBtn;

    @FindBy(id = "SOL-BankDetails-CheckingInput")
    WebElement selectBankTypeRdoBtn;

    @FindBy(id = "SOL-BankDetails-AccountNumberInput")
    WebElement enterAccountNumber;

    @FindBy(id = "SOL-BankDetails-BankNameInput")
    WebElement enterBankName;

    @FindBy(id = "SOL-BankDetails-RoutingNumberInput")
    WebElement enterBankRoutingNumber;

    @FindBy(id = "SOL-BankDetails-FirstNameInput")
    WebElement enterAccountHolderFirstName;

    @FindBy(id = "SOL-BankDetails-LastNameInput")
    WebElement enterAccountHolderLastName;

    @FindBy(id = "SOL-BankDetails-AddressOneInput")
    WebElement addressLocatorForWithdrawalFromBank;

    @FindBy(id = "SOL-BankDetails-City")
    WebElement cityLocatorForWithdrawalFromBank;

    @FindBy(id = "SOL-BankDetails-Zip")
    WebElement zipLocatorForWithdrawalFromBank;

    @FindBy(id = "SOL-BankDetails-State")
    WebElement stateLocatorForWithdrawalFromBank;

    @FindBy(xpath = "//*[@id='SOL-BankDetails-State']/option")
    List<WebElement> stateDropdownOptions;

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
        basicActions.waitForElementToBePresent(moneyOrderBtn,  20 );
        basicActions.waitForElementToBeClickable(moneyOrderBtn, 20);
        moneyOrderBtn.click();
    }
    public void clickWithdrawalFromBankButton() {
        basicActions.waitForElementToBePresent(withdrawalFromBankBtn,  20 );
        basicActions.waitForElementToBeClickable(withdrawalFromBankBtn, 20);
        withdrawalFromBankBtn.click();
    }
    public void enterBankDetailsForBankWithdrawal(List<String> data) {
        basicActions.waitForElementToBePresent(selectBankTypeRdoBtn,  20 );
        basicActions.waitForElementToBeClickable(selectBankTypeRdoBtn, 20);
        selectBankTypeRdoBtn.click();
        enterAccountNumber.sendKeys(data.get(0));
        enterBankName.sendKeys(data.get(1));
        enterBankRoutingNumber.sendKeys(data.get(2));
        enterAccountHolderFirstName.sendKeys(SharedData.getPrimaryMember().getFirstName());
        enterAccountHolderLastName.sendKeys(SharedData.getPrimaryMember().getLastName());
        addressLocatorForWithdrawalFromBank.sendKeys(data.get(3));
        cityLocatorForWithdrawalFromBank.sendKeys(data.get(4));
        zipLocatorForWithdrawalFromBank.sendKeys(data.get(5));
        basicActions.waitForElementToBePresent(stateLocatorForWithdrawalFromBank, 30);
        stateLocatorForWithdrawalFromBank.click();
        basicActions.selectValueFromDropdown(stateLocatorForWithdrawalFromBank, stateDropdownOptions, "CO");
        continueBtnPaymentSelection.click();
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
