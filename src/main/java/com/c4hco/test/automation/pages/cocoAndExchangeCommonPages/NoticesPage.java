package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class NoticesPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, YYYY");
    DateTimeFormatter formatterSpanish = DateTimeFormatter.ofPattern("d 'de' MMMM 'del' yyyy",new Locale("es", "ES"));
    String effectiveDateSpanish = formatterSpanish.format(LocalDate.now());
    String effectiveDate = LocalDate.now().format(formatter);
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
    @FindBy(id= "x_generationDateTime")
     WebElement EmailDate;
    @FindBy(xpath = "//*[@id='O365_MainLink_MePhoto']/div/div/div/div/div[2]/img")
    WebElement outlookLogOutIcon;
    @FindBy(id = "mectrl_body_signOut")
    WebElement outlookLogOut;
    @FindBy(xpath= "//div[@id='x_individualUsernameReminderBody']//p")
    List<WebElement> bodyText;
    @FindBy(xpath= "//*[@id='x_individualUsernameReminderBody']/p[3]/span/span") ///please call the Colorado Connect® Customer Service Center at 855-675-2626 (TTY:855-346-3432)
    WebElement bodyText2;
    @FindBy(css = ".x_emailHeader p")
    List<WebElement> emailHdrtxt;
    @FindBy(css = "#x_recipientName > span")
    WebElement emailDeartxt;
    @FindBy(css = "#x_initialEligibilityNoticeBody p")
    List<WebElement> initialEligibilityBodyTxt;




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

        public void signOutEmail(){
            basicActions.waitForElementToBePresent(outlookLogOutIcon, 10);
            outlookLogOutIcon.click();

            basicActions.waitForElementPresence(outlookLogOut,20);
            basicActions.clickById("mectrl_body_signOut");

            basicActions.wait(500);
            basicActions.closeBrowserTab();
            basicActions.switchtoactiveTab();
            basicActions.closeBrowserTab();
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

    public void openAllNotices(String noticeNumber, String language) {
        basicActions.waitForElementToBePresent(deleteBtn,30);
        basicActions.waitForElementToBePresent(EmailDate, 30);
        basicActions.getDriver().findElement(By.xpath("//div[2]/div[2]/div[2]//span[contains(text(), '"+noticeNumber+"')]")).click();
        String TitleText = basicActions.getDriver().findElement(By.xpath("//span[contains(@title, '"+noticeNumber+"')]")).getText();
        softAssert.assertTrue(TitleText.contains(noticeNumber));
        switch (language){
            case "English":
                softAssert.assertTrue(EmailDate.getText().contains(effectiveDate));
                break;
            case "Spanish":
                System.out.println(EmailDate.getText());
                System.out.println(effectiveDateSpanish);
                softAssert.assertTrue(EmailDate.getText().contains(effectiveDateSpanish));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }


    public void VerifyTheNoticeText(String noticeNumber, String language) {
        switch (noticeNumber){
            case "AM-016-01" :
                VerifyTheAM01601NoticeText(language);
            break;
            case "ELG-101-01" :
                VerifyTheELG10101NoticeText(language);
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void VerifyTheAM01601NoticeText(String language) {
        switch (language){
            case "English" :
                softAssert.assertTrue(bodyText.get(1).getText().contains("Your Username for Colorado Connect® is:"));
                softAssert.assertEquals(bodyText.get(2).getText(),"Return to the Colorado Connect® website and enter this username plus your password to log in to your account. ");
                softAssert.assertEquals(bodyText.get(3).getText(),"If you did not request to have your Username emailed to you, ");
                softAssert.assertEquals(bodyText2.getText(),"please call the Colorado Connect® Customer Service Center at 855-675-2626 (TTY:855-346-3432)");
                softAssert.assertAll();
                break;
            case "Spanish" :
                softAssert.assertTrue(bodyText.get(1).getText().contains("Su Nombre de usuario para Colorado Connect® es:"));
                softAssert.assertEquals(bodyText.get(2).getText(),"Regrese al sitio web de Colorado Connect® y introduzca este nombre de usuario y su contraseña para ingresar en su cuenta.");
                softAssert.assertEquals(bodyText.get(3).getText(),"Si no solicitó el envio por correo electrónico de su Nombre de usario, ");
                softAssert.assertEquals(bodyText2.getText(),"llame al Centro de atención al cliente de Colorado Connect® al 855-675-2626 (TTY:855-346-3432) ");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void VerifyTheELG10101NoticeText(String language) {
        switch (language){
            case "English" :
                softAssert.assertTrue(emailHdrtxt.get(0).getText().contains("ELG-101-01"));
                softAssert.assertEquals(emailHdrtxt.get(2).getText(),SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(emailDeartxt.getText(),SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(initialEligibilityBodyTxt.get(1).getText(),"Account Number: "+SharedData.getPrimaryMember().getAccount_id());
                softAssert.assertAll();
                break;
            case "Spanish" :
                softAssert.assertTrue(emailHdrtxt.get(0).getText().contains("ELG-101-01"));
                softAssert.assertEquals(emailHdrtxt.get(2).getText(),SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(emailDeartxt.getText(),SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(initialEligibilityBodyTxt.get(1).getText(),"N\u00FAmero de Cuenta: "+SharedData.getPrimaryMember().getAccount_id());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }
}
