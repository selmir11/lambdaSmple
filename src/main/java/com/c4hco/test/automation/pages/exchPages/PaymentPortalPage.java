package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PaymentPortalPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public PaymentPortalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#loader-icon .fa-spinner")
    WebElement spinner;

    @FindBy(id = "SOL-PayNow-AllDone-Indv")
    WebElement allDone;

    @FindBy(css = "[id*='SOL-PayNow-AllDone']")
    WebElement allDoneObo;

    @FindBy(css = "#SOL-PayNow-PayNow-Medical-0")
    WebElement PayNowButton;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "password-button")
    WebElement continueButton;

    @FindBy(css = "#SOL-PayNow-PayLaterLink-Medical-0")
    WebElement PayLaterButton;

    @FindBy(css = "#SOL-PayNow-ModalContinue-Medical-0")
    WebElement PayLaterContinue;

    @FindBy(xpath = "//button[@id='pendo-close-guide-a06a6288']")
    WebElement recomendC4HCOToFriendPopUp;

    @FindBy(xpath = "//div[@class= 'payment-option-disabled ng-star-inserted']")
    WebElement CoordinatePayment;





    public void clickAllDone(){
        basicActions.waitForElementToDisappear(spinner, 30);;
        basicActions.waitForElementToBePresent( allDone,40 );
        basicActions.scrollToElement( allDone );
        basicActions.waitForElementToBeClickable(allDone,10);
        basicActions.wait(1000);
        List<WebElement> popups = basicActions.getDriver().findElements(By.id("recomendC4HCOToFriendPopUp"));
        if (!popups.isEmpty() && popups.get(0).isDisplayed()) {
            popups.get(0).click();
        }
        basicActions.scrollToElement( allDone );
        basicActions.clickElementWithRetries(allDone, 30);
    }

    public void clickAllDoneObo(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent( allDoneObo,30 );
        basicActions.scrollToElement( allDoneObo );
        basicActions.clickElementWithRetries(allDoneObo, 30);
    }
    public void clickPayNowButton() {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(PayNowButton, 40);
        basicActions.scrollToElement(PayNowButton);
        basicActions.clickElementWithRetries(PayNowButton, 30);
    }
    public void password() {
        basicActions.waitForElementToBePresent(password, 10);
        String pswd = SharedData.getPrimaryMember().getPassword();
        basicActions.waitForElementToBePresent(password, 10);
        password.sendKeys(pswd);
        System.out.println("Password::" + pswd);
    }

    public void clickContinue(){
        basicActions.waitForElementToBeClickable(continueButton, 10);
        continueButton.click();

    }
    public void clickPayLaterButton() {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(PayLaterButton, 40);
        basicActions.scrollToElement(PayLaterButton);
        basicActions.clickElementWithRetries(PayLaterButton, 30);
    }
    public void clickPayLaterContinue() {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(PayLaterContinue, 40);
        basicActions.scrollToElement(PayLaterContinue);
        basicActions.clickElementWithRetries(PayLaterContinue, 30);
    }
    public void verifyDisabledTextonPaymentPage() {
        basicActions.waitForElementToBePresent(CoordinatePayment, 10);
        softAssert.assertEquals(CoordinatePayment.getText(), "Your insurance company will contact you within 10 business days to coordinate payment.");
        softAssert.assertAll();
    }

}

