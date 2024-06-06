package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class NoticesPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public NoticesPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css= "#i0116")
    WebElement email;
    @FindBy(xpath = "//a[@aria-label='Sign in to Microsoft Outlook']")
    WebElement loginMail;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordEmail;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement nextButton;
    @FindBy(id = "declineButton")
    WebElement btnStayNo;
    @FindBy(xpath = "//div[2]/div[2]/div[2]//span[contains(text(), 'One-time verification')]")
    WebElement noticeOkta;

    @FindBy(xpath = "//div[@class='mfa-header']")
    WebElement MFAHeader;
    @FindBy(xpath = "//div[@class='body-text1 mb-2 check-your-email']")
    WebElement MFAText;
    @FindBy(id = "verification-label")
    WebElement MFASubText;
    @FindBy(css = " form > div.body-text1.mb-2.did-not-receive-email.underline-text")
    WebElement sendNewCode;
    @FindBy(id = "verificationCode")
    WebElement boxVerificationCode;
    @FindBy(xpath = "//div[@class='col-11 mb-3 body-text1']")
     WebElement errorMsgText;
    @FindBy(id = "main-sign-in")
     WebElement btnVerify;
    @FindBy(id = "send-code-link")
     WebElement lnkSendNewCode;
    @FindBy(id= "x_verification-code")
     WebElement mfaCode;
    @FindBy(id= "id__30")
     WebElement deleteBtn;
    @FindBy(xpath= "//li[1]//span[1]")
     WebElement verifySpamText;
    @FindBy(xpath= "//ul/li[1]/span/u")
     WebElement verifyMfaEmail;
    @FindBy(css= "ul > li:nth-child(2) > span > strong")
     WebElement requestNewCodeBtn;







    public String MFACode = "";
    public void openOutlookTab(){
        JavascriptExecutor jse = (JavascriptExecutor)basicActions.getDriver();
        jse.executeScript("window.open()");
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
        basicActions.getDriver().get(Constants.Outlook);
        }
        public void openPasswordResetTab(){
        JavascriptExecutor jse = (JavascriptExecutor)basicActions.getDriver();
        jse.executeScript("window.open()");
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
        basicActions.getDriver().get("https://"+ SharedData.getEnv()+"-aws.connectforhealthco.com/login-portal/createPassword?recoveryToken%3DdrpfwFOIdEDTp9l6rBO8%26lang%3Den=");
        }

    public void signInEmail(String Gmail,String password) {
       loginMail.click();
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
            }
        basicActions.waitForElementToBePresent(email,20);
        email.sendKeys(Gmail);
        basicActions.waitForElementToBePresent(nextButton,20);
        nextButton.click();
       basicActions.waitForElementToBePresent(passwordEmail,20);
       passwordEmail.sendKeys(password);
       passwordEmail.sendKeys(Keys.ENTER );
       basicActions.waitForElementToBeClickable(btnStayNo,20);
       btnStayNo.click();
        }

        public void verbiageValidation(){
        basicActions.waitForElementToBePresent(MFAHeader,20);
            softAssert.assertEquals(MFAHeader.getText(), "A code has been emailed to t*****@outlook.com" );
            softAssert.assertEquals(MFAText.getText(),"Check your email and enter the code below.");
            softAssert.assertEquals(MFASubText.getText(), "Verification Code");
            softAssert.assertEquals(sendNewCode.getText(), "Didn't receive an email?");
            softAssert.assertAll();
        }

    public void enterInvalidMFACode(){
        basicActions.waitForElementToBePresent(boxVerificationCode,20);
        boxVerificationCode.sendKeys("invalid");
        basicActions.waitForElementToBePresent(btnVerify,20);
        btnVerify.click();
    }

    public void verifyErrorText(){
        basicActions.waitForElementToBePresent(errorMsgText,20);
        softAssert.assertEquals(errorMsgText.getText(),"Your passcode doesn't match our records. Please try again.");
        softAssert.assertAll();

    }
    public void openMFANotice(){
        basicActions.waitForElementToBePresent(noticeOkta,20);
        noticeOkta.click();
    }

    public void sendNewCode() {
        basicActions.waitForElementToBePresent(sendNewCode,20);
        sendNewCode.click();
    }

    public String getMfaCode(){
        basicActions.waitForElementToBePresent(mfaCode,20);
        MFACode = mfaCode.getText();
       return  MFACode;

    }



    public void enterValidMfaCode(){
        basicActions.switchToParentPage("LoginPortalUi");
        basicActions.waitForElementToBePresent(boxVerificationCode,20);
        boxVerificationCode.sendKeys(MFACode);
        btnVerify.click();
    }

    public void deleteOpenNotice() {
        basicActions.waitForElementToBePresent(deleteBtn,20);
        deleteBtn.click();
    }


    public void VerifyRequestNewOptionIsDisplayed() {
        basicActions.waitForElementToBePresent(verifySpamText,20);
        softAssert.assertEquals(verifySpamText.getText(),"Check your spam folder for an email from noreply@okta.com");
        softAssert.assertEquals(verifyMfaEmail.getText(),"noreply@okta.com");
        softAssert.assertEquals(requestNewCodeBtn.getText(),"Request a new code");
        softAssert.assertAll();
    }

    public void clickRequestNewCode() {
        basicActions.waitForElementToBeClickable(requestNewCodeBtn,30);
        softAssert.assertTrue(requestNewCodeBtn.isEnabled());
        requestNewCodeBtn.click();
        softAssert.assertAll();
    }
}
