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

    @FindBy(id = "SOL-PaymentSelection-CreditCardOrDebitCard")
    WebElement creditCardBtn;

    @FindBy(id="SOL-CreditDetails-CardNumberInput")
    WebElement cardNumber;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-CardNumberInput']/parent::div/label")
    WebElement cardNumberLabel;

    @FindBy(id="SOL-CreditDetails-ExpirationInput")
    WebElement expirationDate;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-ExpirationInput']/parent::div/label")
    WebElement expirationDateLabel;

    @FindBy(id="SOL-CreditDetails-SecurityCode")
    WebElement securityCodeCVV;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-SecurityCode']/parent::div/label")
    WebElement securityCodeCVVLabel;

    @FindBy(id="SOL-CreditDetails-VisaOrMastercardInput")
    WebElement acceptVisaoMastercard;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-VisaOrMastercardInput']/parent::div/label")
    WebElement acceptVisaoMastercardLabel;

    @FindBy(id="SOL-CreditDetails-Expiration")
    WebElement invalidExpirationDateLabel;

    @FindBy(id="SOL-CreditDetails-InvalidNameInput")
    WebElement nameonCard;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-InvalidNameInput']/parent::div/label")
    WebElement nameonCardLabel;

    @FindBy(id="SOL-CreditDetails-BillingAddressForThisCard")
    WebElement billingAddressLabel;

    @FindBy(id="SOL-CreditDetails-InvalidAddressOneInput")
    WebElement addressOne;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-InvalidAddressOneInput']/parent::div/label")
    WebElement addressOneLabel;

    @FindBy(id="SOL-CreditDetails-AddressTwoInput")
    WebElement addressTwo;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-AddressTwoInput']/parent::div/label")
    WebElement addressTwoLabel;

    @FindBy(id="SOL-CreditDetails-CityInput")
    WebElement city;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-CityInput']/parent::div/label")
    WebElement cityLabel;

    @FindBy(id="SOL-CreditDetails-StateSelect")
    WebElement state;

    @FindBy(xpath = "//select[@id='SOL-CreditDetails-StateSelect']/parent::div/label")
    WebElement stateLabel;

    @FindBy(id="SOL-CreditDetails-ZipInput")
    WebElement zip;

    @FindBy(xpath = "//input[@id='SOL-CreditDetails-ZipInput']/parent::div/label")
    WebElement zipLabel;

    @FindBy(id = "SOL-BankDetails-Title")
    WebElement BankDetailTitle;

    @FindBy(id="SOL-BankDetails-InvalidAccountNumber")
    WebElement AccoutNumberLabel;

    @FindBy(id="SOL-BankDetails-ValidBankName")
    WebElement BankNameLabel;

    @FindBy(id="SOL-BankDetails-ValidRoutingNumber")
    WebElement BankRoutingNumberLabel;

    @FindBy(id="SOL-BankDetails-AccountHolder")
    WebElement AccountHolderLabel;

    @FindBy(id="SOL-BankDetails-ValidFirstName")
    WebElement FirstNameLabel;

    @FindBy(id="SOL-BankDetails-InvalidMiddleName")
    WebElement MiddleNameLabel;

    @FindBy(id="SOL-BankDetails-ValidLastName")
    WebElement LastNameLabel;

    @FindBy(id="SOL-BankDetails-ValidAddressOne")
    WebElement AddressOneLabel;

    @FindBy(id="SOL-BankDetails-AddressTwo")
    WebElement AddressTwoLabel;

    @FindBy(id="SOL-BankDetails-ValidCity")
    WebElement CityLabel;

    @FindBy(id="SOL-BankDetails-ValidZip")
    WebElement ZipLabel;

    @FindBy(id="SOL-BankDetails-ValidState")
    WebElement StateLabel;

    @FindBy(id="SOL-BankDetails-ValidAccountNumber")
    WebElement AccoutNumberInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidBankName")
    WebElement BankNameInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidRoutingNumber")
    WebElement BankRoutingNumberInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidFirstName")
    WebElement FirstNameInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidLastName")
    WebElement LastNameInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidAddressOne")
    WebElement AddressOneInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidCity")
    WebElement CityInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidZip")
    WebElement ZipInvalidLabel;

    @FindBy(id="SOL-BankDetails-InvalidState")
    WebElement StateInvalidLabel;

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
    public void enterBankDetailsForBankWithdrawal(String accNumber, String bankName, String routingName, String address, String city, String zip, String state) {
        basicActions.waitForElementToBePresent(selectBankTypeRdoBtn,  20 );
        basicActions.waitForElementToBeClickable(selectBankTypeRdoBtn, 20);
        selectBankTypeRdoBtn.click();
        enterAccountNumber.sendKeys(accNumber);
        enterBankName.sendKeys(bankName);
        enterBankRoutingNumber.sendKeys(routingName);
        enterAccountHolderFirstName.sendKeys(SharedData.getPrimaryMember().getFirstName());
        enterAccountHolderLastName.sendKeys(SharedData.getPrimaryMember().getLastName());
        addressLocatorForWithdrawalFromBank.sendKeys(address);
        cityLocatorForWithdrawalFromBank.sendKeys(city);
        zipLocatorForWithdrawalFromBank.sendKeys(zip);
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

    public void clickCreditCardButton() {
        basicActions.waitForElementToDisappear(spinner,15);
        basicActions.waitForElementToBeClickable(creditCardBtn, 20);
        creditCardBtn.click();
    }

    public void verifyCreditPaymentLabelText(List<String> data){
        basicActions.waitForElementToBePresent(cardNumber,10);
        cardNumber.click();
        expirationDate.click();
        securityCodeCVV.click();
        softAssert.assertEquals(cardNumberLabel.getText(),data.get(0));
        softAssert.assertEquals(expirationDateLabel.getText(),data.get(1));
        softAssert.assertEquals(securityCodeCVVLabel.getText(),data.get(2));
        softAssert.assertEquals(acceptVisaoMastercardLabel.getText(),data.get(3));
        softAssert.assertEquals(invalidExpirationDateLabel.getText(),data.get(4));
        softAssert.assertEquals(nameonCardLabel.getText(),data.get(5));
        softAssert.assertEquals(billingAddressLabel.getText(),data.get(6));
        softAssert.assertEquals(addressOneLabel.getText(),data.get(7));
        softAssert.assertEquals(addressTwoLabel.getText(),data.get(8));
        softAssert.assertEquals(cityLabel.getText(),data.get(9));
        softAssert.assertEquals(stateLabel.getText(),data.get(10));
        softAssert.assertEquals(zipLabel.getText(),data.get(11));
        softAssert.assertAll();
    }

    public void verifyBankDetailLabelText(List<String> data){
        basicActions.waitForElementToBePresent(cardNumber,10);
        softAssert.assertEquals(BankDetailTitle.getText(),data.get(0));
        softAssert.assertEquals(AccoutNumberLabel.getText(),data.get(1));
        softAssert.assertEquals(BankNameLabel.getText(),data.get(2));
        softAssert.assertEquals(BankRoutingNumberLabel.getText(),data.get(3));
        softAssert.assertEquals(AccountHolderLabel.getText(),data.get(4));
        softAssert.assertEquals(FirstNameLabel.getText(),data.get(5));
        softAssert.assertEquals(MiddleNameLabel.getText(),data.get(6));
        softAssert.assertEquals(LastNameLabel.getText(),data.get(7));
        softAssert.assertEquals(AddressOneLabel.getText(),data.get(8));
        softAssert.assertEquals(AddressTwoLabel.getText(),data.get(9));
        softAssert.assertEquals(CityLabel.getText(),data.get(10));
        softAssert.assertEquals(ZipLabel.getText(),data.get(11));
        softAssert.assertEquals(StateLabel.getText(),data.get(12));
        enterAccountNumber.click();
        enterBankName.click();
        enterBankRoutingNumber.click();
        enterAccountHolderFirstName.click();
        enterAccountHolderLastName.click();
        addressLocatorForWithdrawalFromBank.click();
        cityLocatorForWithdrawalFromBank.click();
        zipLocatorForWithdrawalFromBank.click();
        stateLocatorForWithdrawalFromBank.click();
        zipLocatorForWithdrawalFromBank.click();
        softAssert.assertEquals(AccoutNumberInvalidLabel.getText(),data.get(13));
        softAssert.assertEquals(BankNameInvalidLabel.getText(),data.get(14));
        softAssert.assertEquals(BankRoutingNumberInvalidLabel.getText(),data.get(15));
        softAssert.assertEquals(FirstNameInvalidLabel.getText(),data.get(16));
        softAssert.assertEquals(LastNameInvalidLabel.getText(),data.get(17));
        softAssert.assertEquals(AddressOneInvalidLabel.getText(),data.get(18));
        softAssert.assertEquals(CityInvalidLabel.getText(),data.get(19));
        softAssert.assertEquals(ZipInvalidLabel.getText(),data.get(20));
        softAssert.assertEquals(StateInvalidLabel.getText(),data.get(21));
        softAssert.assertAll();
    }
}
