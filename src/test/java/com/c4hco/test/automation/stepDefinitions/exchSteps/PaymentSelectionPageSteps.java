package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.PaymentSelectionPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class PaymentSelectionPageSteps {
    PaymentSelectionPage paymentSelectionPage = new PaymentSelectionPage(WebDriverManager.getDriver());

    @And("I click continue on payment selection page")
    public void clickContinueOnMakePayment() {
        paymentSelectionPage.clickContinueOnPaymentPage();
    }

    @And("I Verify the text on payment selection page")
    public void paymentModeSelection() {
        paymentSelectionPage.verifyTextWithCheckPayment();
    }

    @And("I select the Money Order button")
    public void clickMoneyOrderButton() {
        paymentSelectionPage.clickMoneyOrderButton();
    }
    @And("I select Withdrawal from Bank Account button")
    public void clickWithdrawalFromBankButton() {
        paymentSelectionPage.clickWithdrawalFromBankButton();
    }
    @And("I enter Bank details as Acc number {string} Bank Name {string} Routing number {string} Address {string} City {string} Zip {string} State {string} bank withdrawal")
    public void enterBankDetailsForWithdrawalFromBank(String accNumber, String bankName, String routingName, String address, String city, String zip, String state) {
        paymentSelectionPage.enterBankDetailsForBankWithdrawal(accNumber, bankName, routingName, address, city, zip, state);
    }

    @And("I select Credit card payment type")
    public void clickCreditCardButton() {
        paymentSelectionPage.clickCreditCardButton();
    }

    @Then("Validate text in Credit Card Payment type")
    public void ValidateTextInCreditCardPayment(List<String> data){
        paymentSelectionPage.verifyCreditPaymentLabelText(data);
    }

    @Then("Validate text in Bank Detail Payment type")
    public void ValidateTextInBankDetailPayment(List<String> data){
        paymentSelectionPage.verifyBankDetailLabelText(data);
    }
}