package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ForgetPasswordPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public ForgetPasswordPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id ="fn-label")
    WebElement lblEnterYourEmail;

    @FindBy(id ="submit-button")
    WebElement submitBtn;
    @FindBy(id ="fn")
    WebElement emailForgetPassword;
    @FindBy(xpath ="//div[.=' Username is required']")
    WebElement errorUsername;
    @FindBy(xpath ="//div[contains(text(), 'An email has been sent to the address on file')]")
    WebElement textNoticeIsSent;



    public void enterPasswordText() {
        softAssert.assertEquals(lblEnterYourEmail.getText(),"Enter your username in order to receive a link to reset your password");
        softAssert.assertAll();
    }
    public void clickSubmit() {
        basicActions.waitForElementToBePresent(submitBtn,10);
        submitBtn.click();
    }
    public void errorUsernameRequiredText() {
        softAssert.assertEquals(errorUsername.getText(),"Username is required");
        softAssert.assertAll();
    }


    public void enterValidPassword(String emailAddress) {
        basicActions.waitForElementToBePresent(emailForgetPassword,10);
        emailForgetPassword.sendKeys(emailAddress);
    }

    public void verifyNoticeIsSentText() {
        basicActions.waitForElementToBePresent(textNoticeIsSent,50);
        softAssert.assertEquals(textNoticeIsSent.getText(),"An email has been sent to the address on file. If you did not receive an email, please contact our Service Center.");
        softAssert.assertAll();
    }
}
