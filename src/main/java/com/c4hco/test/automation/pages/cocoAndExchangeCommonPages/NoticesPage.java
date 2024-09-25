package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class NoticesPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY");
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
    @FindBy(xpath= "//*[@id='x_individualUsernameReminderBody']/p[3]/span/span")
    WebElement bodyText2;
    @FindBy(xpath="//*[@id='x_programManagerLoginReminderBody']/p")
    List<WebElement> bodyTextAM1605;
    @FindBy(xpath="//div[@id='x_individualAccountCreationNoticeBody']//div")
    List<WebElement> bodyTextAM00101;
    @FindBy(xpath="//*[@id='x_individualAccountCreationNoticeBody']/p")
    List<WebElement> body2TextAM00101;
    @FindBy(css = ".x_emailHeader p")
    List<WebElement> emailHdrtxt;
    @FindBy(css = "#x_recipientName > span")
    WebElement emailDeartxt;
    @FindBy(css = "#x_initialEligibilityNoticeBody p")
    List<WebElement> initialEligibilityBodyTxt;
    @FindBy(xpath= "//div[@id='x_brokerLoginReminderBody']//p")
    List<WebElement> bodyText1603;
    @FindBy(xpath= "//p[@id='x_receivedEmailinErrorStatementForBroker']")
    WebElement bodyText1603part2;
    @FindBy(xpath= "//div[@id='x_enrollmentConfirmationNoticeBody']/p")
    List<WebElement> bodyTextEN00204;
    @FindBy(xpath= "(//p[@class='x_body'])[2]")
    WebElement bodyText1607;
    @FindBy(xpath= "(//p[@class='x_body'])[3]")
    WebElement bodyText1607part2;
    @FindBy(xpath= "//a[@target='_blank']")
    WebElement resetPWLink;
    @FindBy(xpath= "//*[@id='x_passwordResetConfirmationBody']/p")
    List<WebElement> bodyConfirmationPW;

    @FindBy(id = "x_policyInformation")
    WebElement policyinformation;




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
        basicActions.waitForElementToBePresentWithRetries(noticeOkta,20);
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
        basicActions.waitForElementToBePresent(EmailDate, 30);
        basicActions.getDriver().findElement(By.xpath("//div[2]/div[2]/div[2]//span[contains(text(), '"+noticeNumber+"')]")).click();
        basicActions.waitForElementToBePresent(EmailDate,30);
        String TitleText = basicActions.getDriver().findElement(By.xpath("//span[contains(@title, '"+noticeNumber+"')]")).getText();
        softAssert.assertTrue(TitleText.contains(noticeNumber));
        switch (language){
            case "English":
                softAssert.assertTrue(EmailDate.getText().contains(effectiveDate));
                break;
            case "Spanish":
                softAssert.assertTrue(EmailDate.getText().contains(effectiveDateSpanish));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void VerifyTheNoticeText(String noticeNumber, String language,String typeAPP) {
        switch (typeAPP){
            case "Exch":
            verifyTheNoticeEXCH(noticeNumber,language);
            break;
            case "Coco":
            verifyTheNoticeCoco(noticeNumber,language);
            break;
            case "Broker":
            verifyTheNoticeBroker(noticeNumber,language);
            break;
        default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber + typeAPP);
        }
    }

    private void verifyTheNoticeBroker(String noticeNumber, String language) {
        switch (noticeNumber){
            case "AM-016-07":
                VerifyTheNoticeTextAM01607broker();
                break;
            case "AM-016-08":
                VerifyTheNoticeTextAM01608broker();
                break;
        default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber );
        }
    }

    private void VerifyTheNoticeTextAM01608broker() {
        softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "Your Connect for Health Colorado\u00AE account password was recently reset.");
        softAssert.assertEquals(bodyConfirmationPW.get(1).getText(), "If you did not make this change, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m. as soon as possible to protect your account.");
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextAM01607broker() {
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertTrue(bodyText1607.getText().contains( "Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));

        } else if (SharedData.getEnv().equals("staging")) {
            softAssert.assertTrue(bodyText1607.getText().contains( "Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));
        }
        softAssert.assertTrue(bodyText1607.getText().contains("This link will expire after 60 minutes. If you do not follow the link within the time allowed, you will need to request a new link."));
        softAssert.assertEquals(bodyText1607part2.getText(),"If you did not request a password reset, or if you need additional support to reset your password, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m.");
        softAssert.assertAll();
    }

    public void verifyTheNoticeEXCH(String noticeNumber, String language){
        switch (noticeNumber){
            case "AM-016-01" :
                VerifyTheNoticeTextAM01601Exch();
                break;
            case "ELG-101-01" :
                VerifyTheELG10101NoticeText(language);
                break;
            case "AM-016-03" :
                VerifyTheNoticeTextAM01603();
                break;
            case "AM-016-05" :
                VerifyTheNoticeTextAM01605();
                break;
            case "AM-001-01" :
                VerifyTheNoticeTextAM00101();
                break;
            case "EN-002-04" :
                VerifyTheNoticeTextEN00204();
                break;
            case "AM-016-07" :
                VerifyTheNoticeTextAM01607(language);
                break;
            case "AM-016-08" :
                VerifyTheNoticeTextAM01608(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language +noticeNumber);
        }
    }

    private void VerifyTheNoticeTextAM01608(String language) {
        switch (language) {
            case "English":
                softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "Your Connect for Health Colorado\u00AE account password was recently reset.");
                softAssert.assertEquals(bodyConfirmationPW.get(1).getText(), "If you did not make this change, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m. as soon as possible to protect your account.");
                break;
            case "Spanish":
                softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "La contrase\u00F1a de su cuenta de Connect for Health Colorado\u00AE fue cambiada recientemente.");
                softAssert.assertEquals(bodyConfirmationPW.get(1).getText(), "Si usted no hizo este cambio, llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-346-3432) de lunes a viernes de 8:00 a.m. a 6:00 p.m. lo m\u00E1s pronto posible para proteger su cuenta.");
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }
    private void VerifyTheNoticeTextAM01607(String language) {
        switch (language){
            case "English" :
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertTrue(bodyText1607.getText().contains( "Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));

        } else if (SharedData.getEnv().equals("staging")) {
            softAssert.assertTrue(bodyText1607.getText().contains( "Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));
        }
        softAssert.assertTrue(bodyText1607.getText().contains("This link will expire after 60 minutes. If you do not follow the link within the time allowed, you will need to request a new link."));
        softAssert.assertEquals(bodyText1607part2.getText(),"If you did not request a password reset, or if you need additional support to reset your password, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m.");

        break;
            case "Spanish":
                if (SharedData.getEnv().equals("qa")) {
                    softAssert.assertTrue(bodyText1607.getText().contains( "Ha solicitado restablecer la contrase\u00F1a de su cuenta de Connect for Health Colorado\u00AE. Para restablecerla, haga clic en este enlace: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));

                } else if (SharedData.getEnv().equals("staging")) {
                    softAssert.assertTrue(bodyText1607.getText().contains( "Ha solicitado restablecer la contrase\u00F1a de su cuenta de Connect for Health Colorado\u00AE. Para restablecerla, haga clic en este enlace: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));
                }
                softAssert.assertTrue(bodyText1607.getText().contains("Este enlace vencer\u00E1 despu\u00E9s de 60 minutos. Si no sigue el enlace durante el tiempo permitido, tendr\u00E1 que solicitar uno nuevo."));
                softAssert.assertEquals(bodyText1607part2.getText(),"Si no solicit\u00F3 el restablecimiento de su contrase\u00F1a o si necesita m\u00E1s ayuda para hacerlo, llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-346-3432) de lunes a viernes de 8:00 a.m. a 6:00 p.m.");
                break;
        default:
        throw new IllegalArgumentException("Invalid option: " + language );
    }
        softAssert.assertAll();}

    public void verifyTheNoticeCoco(String noticeNumber,String language){
        switch (noticeNumber) {
            case "AM-016-01":
                VerifyTheNoticeTextAM01601coco(language);
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + language +noticeNumber);
        }
    }

    private void VerifyTheNoticeTextAM00101() {
        softAssert.assertTrue(bodyTextAM00101.get(0).getText().contains("Dear"));
        softAssert.assertTrue(bodyTextAM00101.get(1).getText().contains("Welcome to Connect for Health Colorado\u00AE. An account was opened for you on"));
        softAssert.assertEquals(body2TextAM00101.get(0).getText(),"You are now ready to choose a health insurance plan that best fits your needs. To get started, follow the link below to log in and begin shopping!");
        softAssert.assertTrue(body2TextAM00101.get(2).getText().contains("The communication preference you chose is email. All future communications will be sent via email to "));
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextAM01605() {
        softAssert.assertTrue(bodyTextAM1605.get(0).getText().contains("Your Login ID for Connect for Health Colorado\u00AE is: "));
        softAssert.assertEquals(bodyTextAM1605.get(1).getText(),"Follow the link to Login at https://connectforhealthco.com/for-certified-assisters/.");
        softAssert.assertEquals(bodyTextAM1605.get(2).getText(),"If you didn't request to have your Login ID emailed to you, please call the Connect for Health Colorado\u00AE Broker Customer Service Center at 1-855-426-2765 Monday - Friday 8:00a.m. - 6:00p.m. Saturdays and Holidays 8:00a.m. - 5:00p.m. If you have questions about your Program Manager account, please email [AssistanceNetwork@c4hco.com]AssistanceNetwork@c4hco.com.");
        softAssert.assertAll();
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
                throw new IllegalArgumentException("Invalid option: " + language);}
    }

    public void VerifyTheNoticeTextAM01601coco(String language) {
        switch (language){
            case "English" :
                softAssert.assertTrue(bodyText.get(1).getText().contains("Your Username for Colorado Connect\u00AE is:"));
                softAssert.assertEquals(bodyText.get(2).getText(),"Return to the Colorado Connect\u00AE website and enter this username plus your password to log in to your account.");//®
                softAssert.assertEquals(bodyText.get(3).getText(),"If you did not request to have your Username emailed to you, please call the Colorado Connect\u00AE Customer Service Center at 855-675-2626 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m.");
                softAssert.assertEquals(bodyText2.getText(),"please call the Colorado Connect\u00AE Customer Service Center at 855-675-2626 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m.");
            break;
            case "Spanish" :
                softAssert.assertTrue(bodyText.get(1).getText().contains("Su Nombre de usuario para Colorado Connect\u00AE es:"));
                softAssert.assertEquals(bodyText.get(2).getText(),"Regrese al sitio web de Colorado Connect\u00AE y introduzca este nombre de usuario y su contrase\u00F1a para ingresar en su cuenta.");
                softAssert.assertEquals(bodyText.get(3).getText(),"Si no solicit\u00F3 el envio por correo electr\u00F3nico de su Nombre de usario, llame al Centro de atenci\u00F3n al cliente de Colorado Connect\u00AE al 855-675-2626 (TTY:855-346-3432) de lunes a viernes de 8:00 a.m. a 6:00 p.m.");
                softAssert.assertEquals(bodyText2.getText(),"llame al Centro de atenci\u00F3n al cliente de Colorado Connect\u00AE al 855-675-2626 (TTY:855-346-3432) de lunes a viernes de 8:00 a.m. a 6:00 p.m.");
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void VerifyTheNoticeTextAM01601Exch(){
        softAssert.assertTrue(bodyText.get(1).getText().contains("Your Username for Connect for Health Colorado\u00AE is:"));
        softAssert.assertEquals(bodyText.get(2).getText(),"Return to the Connect for Heath Colorado\u00AE website and enter this username plus your password to log in to your account.");
        softAssert.assertEquals(bodyText.get(3).getText(),"If you did not request to have your Username emailed to you, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m.");
        softAssert.assertEquals(bodyText2.getText(),"please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m.");
        softAssert.assertAll();
    }

    public void VerifyTheNoticeTextAM01603() {
        softAssert.assertTrue(bodyText1603.get(1).getText().contains("Your Login ID for Connect for Health Colorado\u00AE is: "));
        softAssert.assertEquals(bodyText1603.get(2).getText(),"If you didn't request to have your Login ID emailed to you, please call the Connect for Health Colorado\u00AE Broker Customer Service Center at 1-855-426-2765 Monday - Friday 8:00a.m. - 6:00p.m. Saturdays and Holidays 8:00a.m. - 5:00p.m.");
        softAssert.assertEquals(bodyText1603part2.getText(),"If you have questions regarding this update or feel that these changes were not authorized, please call the Connect for Health Colorado\u00AE Broker Customer Service Center at 1-855-426-2765 Monday - Friday 8:00a.m. - 6:00p.m. Saturdays and Holidays 8:00a.m. - 5:00p.m.");
        softAssert.assertAll();
    }

    public void VerifyTheNoticeTextEN00204() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate = currentDate.format(formatter);
        softAssert.assertEquals(emailDeartxt.getText(), SharedData.getPrimaryMember().getFullName());
        System.out.println(formattedDate);
        softAssert.assertEquals(bodyTextEN00204.get(0).getText(), "Welcome! This notice confirms that you chose an insurance plan on " + formattedDate + " for Plan Year 2024.");
        softAssert.assertAll();
    }
    public void clickThePasswordResetLink() {
        basicActions.waitForElementToBePresent(resetPWLink,20);
        resetPWLink.click();
    }


    public void validateDentalPolicyMemberData(String noticeInputDetails, List<String> NoticedetailsdentalMembers) {

        WebElement Noticeplandetails = basicActions.getDriver().findElement(By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body'])[1] //*[contains(text(),'" + noticeInputDetails + "')]"));
        Assert.assertTrue(Noticeplandetails.getText().contains(noticeInputDetails), "Plan notice details not found");
        System.out.println("Dental Plan notice details found");

        for (int i = 0; i < NoticedetailsdentalMembers.size(); i++) {
            WebElement policyDetailsFromEmailNotice = basicActions.getDriver().findElement(By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body'])[1] //*[contains(text(),'" + NoticedetailsdentalMembers.get(i) + "')]"));
            basicActions.waitForElementToBePresent(policyDetailsFromEmailNotice, 30);

            if (NoticedetailsdentalMembers.get(i).equals("Primary")) {
                String primaryMemberDetails = SharedData.getPrimaryMember().getFullName();
                if (primaryMemberDetails != null && policyDetailsFromEmailNotice.getText() != null && policyDetails.getText().contains(primaryMemberDetails)) {
                    System.out.println("Primary member details found: " + primaryMemberDetails);
                    Assert.assertTrue(policyDetails.getText().contains(primaryMemberDetails), "Primary member details not found");
                } else {
                    System.out.println("Primary member details are null or not found in the policy details.");
                    Assert.fail("Primary member details not found.");
                }
            } else {
                List<MemberDetails> memberDetailsList = SharedData.getMembers();
                List<String> names = memberDetailsList.stream().map(MemberDetails::getFullMiddleName).collect(Collectors.toList());
                String result = null;
                for (String memberfullname : names) {
                    if (memberfullname.contains(NoticedetailsdentalMembers.get(i))) {
                        result = memberfullname;
                        break;
                    }
                }
                String policyMemberDetails = result;
                if (policyMemberDetails != null && policyDetails.getText() != null && policyDetails.getText().contains(policyMemberDetails)) {
                    System.out.println("Member details found: " + policyMemberDetails);
                    Assert.assertTrue(policyDetails.getText().contains(policyMemberDetails), "Member details not found");
                } else {
                    System.out.println("Member details are null or not found in the policy details.");
                    Assert.fail("Member details not found.");
                }
            }
        }
    }

    public void validatemedicalPolicyMemberData(String noticeInputDetails, List<String> NoticedetailsmedicalMembers) {

        WebElement Noticeplandetails = basicActions.getDriver().findElement(By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body'])[4] //*[contains(text(),'" + noticeInputDetails + "')]"));
        Assert.assertTrue(Noticeplandetails.getText().contains(noticeInputDetails), "Plan notice details not found");
        System.out.println("Medical Plan notice details found");

        for (int i = 0; i < NoticedetailsmedicalMembers.size(); i++) {
            WebElement policyDetails = basicActions.getDriver().findElement(By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body'])[4] //*[contains(text(),'" + NoticedetailsmedicalMembers.get(i) + "')]"));
            basicActions.waitForElementToBePresent(policyDetails, 30);

            if (NoticedetailsmedicalMembers.get(i).equals("Primary")) {
                String primaryMemberDetails = SharedData.getPrimaryMember().getFullName();
                if (primaryMemberDetails != null && policyDetails.getText() != null && policyDetails.getText().contains(primaryMemberDetails)) {
                    System.out.println("Primary member details found: " + primaryMemberDetails);
                    Assert.assertTrue(policyDetails.getText().contains(primaryMemberDetails), "Primary member details not found");
                } else {
                    System.out.println("Primary member details are null or not found in the policy details.");
                    Assert.fail("Primary member details not found.");
                }
            } else {
                List<MemberDetails> memberDetailsList = SharedData.getMembers();
                List<String> names = memberDetailsList.stream().map(MemberDetails::getFullMiddleName).collect(Collectors.toList());
                String result = null;

                for (String item : names) {
                    if (item.contains(NoticedetailsmedicalMembers.get(i))) {
                        result = item;
                        break;
                    }
                }

                String policyMemberDetails = result;
                if (policyMemberDetails != null && policyDetails.getText() != null && policyDetails.getText().contains(policyMemberDetails)) {
                    System.out.println("Member details found: " + policyMemberDetails);
                    Assert.assertTrue(policyDetails.getText().contains(policyMemberDetails), "Member details not found");
                } else {
                    System.out.println("Member details are null or not found in the policy details.");
                    Assert.fail("Member details not found.");
                }
            }
        }
    }


    public void verifypolicycoveragestartdatenoticeminusfivedays() {
        WebElement planDetailsElement = basicActions.getDriver().findElement(
                By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body'])[1]"));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        String formattedDate = "Coverage Start Date: " + dateFormat.format(calendar.getTime());
        String planDetailsText = planDetailsElement.getText();
        if(planDetailsText.contains(formattedDate)) {
            System.out.println("Coverage start date matches the expected date: " + formattedDate);
        } else {
            System.out.println("Coverage start date does NOT match. Expected: " + formattedDate + ", Found: " + planDetailsText);
        }
    }
    public void verifyPolicyCoverageStartDateForNextMonth() {

        WebElement planDetailsElement = basicActions.getDriver().findElement(
                By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body'])[1]"));

        String displayedDate = planDetailsElement.getText();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String expectedDate = sdf.format(calendar.getTime());
        if (displayedDate.equals(expectedDate)) {
            System.out.println("Coverage start date matches: " + expectedDate);
        } else {
            System.out.println("Coverage start date does not match. Expected: "
                    + expectedDate + ", but found: " + displayedDate);
        }
    }



}
