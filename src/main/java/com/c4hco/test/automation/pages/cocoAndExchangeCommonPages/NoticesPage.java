package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class NoticesPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public NoticesPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindAll({
      @FindBy (css = "#i0116"),
      @FindBy (xpath = "//input[@id='usernameEntry']")})
    WebElement email;
    @FindBy(xpath = "//div[contains(@class,'layout section-master__layout section-master--layout-cols-2')]//span[@class='btn__text'][normalize-space()='Sign in']")
    WebElement loginMail;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordEmail;
    @FindBy(xpath = "//*[@id=\"view\"]/div/div[3]/button")
    WebElement nextButton;
    @FindAll({
            @FindBy(id = "declineButton"),
            @FindBy(xpath = "//*[@id='view']/div/div[5]/button[2]")})
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
    @FindBy(id = "x_verification-code")
    WebElement mfaCode;
    @FindBy(id = "id__30")
    WebElement deleteBtn;
    @FindBy(xpath = "//li[1]//span[1]")
    WebElement verifySpamText;
    @FindBy(xpath = "//ul/li[1]/span/u")
    WebElement verifyMfaEmail;
    @FindBy(css = "ul > li:nth-child(2) > span > strong")
    WebElement requestNewCodeBtn;
    @FindBy(id = "x_generationDateTime")
    WebElement EmailDate;
    @FindBy(xpath = "//*[@id='O365_MainLink_MePhoto']/div/div/div/div/div[2]/img")
    WebElement outlookLogOutIcon;
    @FindBy(id = "mectrl_body_signOut")
    WebElement outlookLogOut;
    @FindBy(xpath = "//div[@id='x_individualUsernameReminderBody']//p")
    List<WebElement> bodyText;
    @FindBy(xpath = "//*[@id='x_individualUsernameReminderBody']/p[3]/span/span")
    WebElement bodyText2;
    @FindBy(xpath = "//*[@id='x_programManagerLoginReminderBody']/p")
    List<WebElement> bodyTextAM1605;
    @FindBy(xpath = "//div[@id='x_individualAccountCreationNoticeBody']//div")
    List<WebElement> bodyTextAM00101;
    @FindBy(xpath = "//*[@id='x_individualAccountCreationNoticeBody']/p")
    List<WebElement> body2TextAM00101;
    @FindBy(xpath = "//*[@class='x_emailRecipientHeader']")
    WebElement individualEmailBN002A0304;
    @FindBy(id = "x_recipientName")
    WebElement individualNameBN002A0304;
    @FindBy(xpath = "//*[@id='x_notifyClientOfBrokerAuthorizationNoticeBody']/p")
    List<WebElement> bodyTextBN002A03;

    @FindBy(xpath ="//*[@id=\"UniqueMessageBody_2\"]/div/div/div/div[4]/div/div[1]/p/i/span")
    WebElement bodyTextBN002A03Part5;
    @FindBy(xpath = "//*[@id='x_notifyClientOfBrokerDeauthorizationNoticeBody']/p")
    List<WebElement> bodyTextBN002A04;
    @FindBy(xpath = "//*[@id='x_notifyBrokerOfClientAuthorizationNoticeBody']/p")
    List<WebElement> bodyTextBN002A01;
    @FindBy(xpath = "//*[@id='x_notifyBrokerOfClientDeauthorizationNoticeBody']/p")
    WebElement bodyTextBN002A02;
    @FindBy(id = "x_receivedEmailinErrorStatementForBroker")
    WebElement brokerErrorStatementBN002A0102;
    @FindBy(id = "x_recipientName")
    WebElement brokerNameBN002A0102;
    @FindBy(css = ".x_emailHeader p")
    List<WebElement> emailHdrtxt;
    @FindBy(css = "#x_recipientName > span")
    WebElement emailDeartxt;
    @FindBy(css = "#x_initialEligibilityNoticeBody p")
    List<WebElement> initialEligibilityBodyTxt;
    @FindBy(xpath = "//div[@id='x_brokerLoginReminderBody']//p")
    List<WebElement> bodyText1603;
    @FindBy(xpath = "//p[@id='x_receivedEmailinErrorStatementForBroker']")
    WebElement bodyText1603part2;
    @FindBy(xpath = "//div[@id='x_enrollmentConfirmationNoticeBody']/p")
    List<WebElement> bodyTextEN00204;
    @FindBy(xpath = "(//p[@class='x_body'])[2]")
    WebElement bodyText1607;
    @FindBy(xpath = "(//p[@class='x_body'])[3]")
    WebElement bodyText1607part2;
    @FindBy(xpath = "//a[@target='_blank']")
    WebElement resetPWLink;
    @FindBy(xpath = "//*[@id='x_passwordResetConfirmationBody']/p")
    List<WebElement> bodyConfirmationPW;
    @FindBy(xpath = "//*[@id='x_agencyAddsAuthorizedRepNoticeBody']/p")
    List<WebElement> adminStaffAG00102body;

    @FindBy(id = "x_policyInformation")
    WebElement policyinformation;
    @FindBy(css = "#x_policyInformation .x_body dl dt")
    List<WebElement> emailPolicyDetails;
    @FindBy(xpath = "//div[@class='ECSzl']/img")
    WebElement scannerLogo;
    @FindBy(xpath = "//*[@id='x_headerSection']/div/div/div[2]/div/p")
    WebElement adminNoticeEmail;
    @FindBy(xpath = "//*[@id=\"x_adminPortalAccountCreationNoticeBody\"]/p[1]")
    WebElement adminNoticeWelcome;
    @FindBy(xpath = "//*[@id='x_recipientName']/span")
    WebElement adminNoticeName;
    @FindBy(xpath = "//*[@id=\"x_adminPortalAccountCreationNoticeBody\"]/p[2]/span[1]")
    WebElement adminNoticeName2;
    @FindBy(xpath = "//*[@id=\"x_adminPortalAccountCreationNoticeBody\"]/p[2]/span[2]/span")
    WebElement adminNoticeName3;
    @FindBy(xpath = "//*[@id=\"x_adminPortalAccountCreationNoticeBody\"]/p[3]/span[1]")
    WebElement adminNoticeEmailText;
    @FindBy(xpath = "//*[@id='x_adminPortalAccountCreationNoticeBody']/p[3]/span[2]")
    WebElement adminNoticeEmailValue;
    @FindBy(xpath = "//*[@id='x_adminPortalAccountCreationNoticeBody']/p[4]")
    WebElement adminNoticeParag1;
    @FindBy(xpath = "//*[@id='x_adminPortalAccountCreationNoticeBody']/p[5]")
    WebElement adminNoticeParag2;
    @FindBy(xpath = "//*[@id=\"UniqueMessageBody_2\"]/div/div/div/p")
    WebElement adminNoticeParag3;
    @FindBy(xpath = "//p[@class='x_body']")
    List<WebElement> BodyTextBN002A0404;

    @FindBy(xpath = "//*[@id='x_accountCreationCommon']/p[1]")
    WebElement bodyTextAM00301Parag1;
    @FindBy(xpath = "//*[@id='x_accountCreationCommon']/p[3]")
    WebElement bodyTextAM00301Parag2;
    @FindBy(xpath = "//*[@id='x_brokerAccountCreationNoticeBody']/p[1]")
    WebElement bodyTextAM00301Parag3;
    @FindBy(xpath = "//*[@id='x_brokerAccountCreationNoticeBody']/p[2]")
    WebElement bodyTextAM00301Parag4;
    @FindBy(xpath = "//*[@id='x_brokerAccountCreationNoticeBody']/p[3]")
    WebElement bodyTextAM00301Parag5;
    @FindBy(xpath = "//*[@id='x_programManagerActivateAccountNoticeBody']/p[1]")
    WebElement bodyTextAM00401Parag1;
    @FindBy(xpath = "//*[@id='x_programManagerActivateAccountNoticeBody']/p[2]")
    WebElement bodyTextAM00401Parag2;
    @FindBy(xpath = "//*[@id='x_programManagerActivateAccountNoticeBody']/ul/li[1]")
    WebElement bodyTextAM00401Parag3;
    @FindBy(xpath = "//*[@id='x_programManagerActivateAccountNoticeBody']/ul/ul[1]/li")
    WebElement bodyTextAM00401Parag4;
    @FindBy(xpath = "//*[@id='x_programManagerActivateAccountNoticeBody']/ul/li[2]")
    WebElement bodyTextAM00401Parag5;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/ul/ul[2]/li[1]")
    WebElement bodyTextAM00401Parag6;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/ul/ul[2]/li[2]")
    WebElement bodyTextAM00401Parag7;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/ul/ul[2]/ul[1]/li[2]")
    WebElement bodyTextAM00401Parag8;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/ul/ul[2]/li[3]")
    WebElement bodyTextAM00401Parag9;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/ul/ul[2]/li[4]")
    WebElement bodyTextAM00401Parag10;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/ul/ul[2]/ul[2]/li[1]")
    WebElement bodyTextAM00401Parag11;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/ul/ul[2]/ul[2]/li[2]")
    WebElement bodyTextAM00401Parag12;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/p[3]/strong")
    WebElement bodyTextAM00401Parag13;
    @FindBy(xpath = "//*[@id=\"x_accountCreatedInErrorAssistnet\"]")
    WebElement bodyTextAM00401Parag14;
    @FindBy(xpath = "//*[@id='x_programManagerAccountCreationNoticeBody']/p[1]")
    WebElement bodyTextAM00403NextSteps;
    @FindBy(xpath = "//*[@id='x_programManagerAccountCreationNoticeBody']/ul/li")
    List<WebElement> bodyTextAM00403NextStepsBullets;
    @FindBy(xpath = "//*[@id='x_programManagerAccountCreationNoticeBody']/ul/ul")
    WebElement bodyTextAM00403LoginWarning;
    @FindBy(xpath = "//*[@id='x_programManagerAccountCreationNoticeBody']/p[2]")
    WebElement bodyTextAM00403TrainingLink;
    @FindBy(xpath = "//*[@id='x_brokerCertificationNoticeBody']/p[2]")
    WebElement bodyTextBN001A01;
    @FindBy(xpath = "//*[@id='x_brokerCertificationNoticeBody']/p[3]")
    WebElement bodyTextBN001A01part3;
    @FindBy(xpath = "//*[@id='x_brokerProfileUpdateNoticeBody']/p")
    List<WebElement> bodyTextAM01301;


    public String MFACode = "";
    public String customerServiceHours = "Broker Customer Service Center at 1-855-426-2765 Monday - Friday 8:00a.m. - 6:00p.m. Saturdays and Holidays 8:00a.m. - 5:00p.m.";

    public void openOutlookTab() {
        JavascriptExecutor jse = (JavascriptExecutor) basicActions.getDriver();
        jse.executeScript("window.open()");
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
        basicActions.getDriver().get(Constants.Outlook);
    }

    public void openPasswordResetTab() {
        JavascriptExecutor jse = (JavascriptExecutor) basicActions.getDriver();
        jse.executeScript("window.open()");
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
        basicActions.getDriver().get("https://" + SharedData.getEnv() + "-aws.connectforhealthco.com/login-portal/createPassword?recoveryToken%3DdrpfwFOIdEDTp9l6rBO8%26lang%3Den=");
    }

    public void signInEmail(String Gmail, String password) {
        basicActions.waitForElementToBePresentWithRetries(loginMail, 20);
        loginMail.click();
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
        basicActions.waitForElementToBePresent(email, 20);
        email.sendKeys(Gmail);
        basicActions.waitForElementToBePresent(nextButton, 20);
        nextButton.click();
        basicActions.waitForElementToBePresent(passwordEmail, 20);
        passwordEmail.sendKeys(password);
        passwordEmail.sendKeys(Keys.ENTER);
        basicActions.waitForElementToBePresent(btnStayNo, 20);
        btnStayNo.click();
    }

    public void signOutEmail() {
        basicActions.waitForElementToBePresent(outlookLogOutIcon, 10);
        outlookLogOutIcon.click();
        basicActions.waitForElementToBePresentWithRetries(outlookLogOut, 20);
        try {
            basicActions.wait(2000);
            WebElement element = basicActions.getDriver().findElement(By.id("mectrl_body_signOut"));
            if (element.isDisplayed()) {
                element.click();
            }
            basicActions.waitForElementToDisappear(outlookLogOut, 20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        basicActions.wait(500);
        basicActions.closeBrowserTab();
        basicActions.switchtoactiveTab();
        basicActions.closeBrowserTab();
    }

    public void verbiageValidation() {
        basicActions.waitForElementToBePresent(MFAHeader, 20);
        softAssert.assertEquals(MFAHeader.getText(), "A code has been emailed to t*****@outlook.com");
        softAssert.assertEquals(MFAText.getText(), "Check your email and enter the code below.");
        softAssert.assertEquals(MFASubText.getText(), "Verification Code");
        softAssert.assertEquals(sendNewCode.getText(), "Didn't receive an email?");
        softAssert.assertAll();
    }

    public void enterInvalidMFACode() {
        basicActions.waitForElementToBePresent(boxVerificationCode, 20);
        boxVerificationCode.sendKeys("invalid");
        basicActions.waitForElementToBePresent(btnVerify, 20);
        btnVerify.click();
    }

    public void verifyErrorText() {
        basicActions.waitForElementToBePresent(errorMsgText, 20);
        softAssert.assertEquals(errorMsgText.getText(), "Your passcode doesn't match our records. Please try again.");
        softAssert.assertAll();

    }

    public void openMFANotice() {
        basicActions.waitForElementToBePresentWithRetries(noticeOkta, 20);
        noticeOkta.click();
    }

    public void sendNewCode() {
        basicActions.waitForElementToBePresent(sendNewCode, 20);
        sendNewCode.click();
    }

    public String getMfaCode() {
        basicActions.waitForElementToBePresentWithRetries(mfaCode, 20);
        MFACode = mfaCode.getText();
        return MFACode;

    }


    public void enterValidMfaCode() {
        basicActions.switchToParentPage("LoginPortalUi");
        basicActions.waitForElementToBePresent(boxVerificationCode, 20);
        boxVerificationCode.sendKeys(MFACode);
        btnVerify.click();
    }

    public void deleteOpenNotice() {
        basicActions.waitForElementToBePresent(deleteBtn, 20);
        deleteBtn.click();
    }


    public void VerifyRequestNewOptionIsDisplayed() {
        basicActions.waitForElementToBePresent(verifySpamText, 20);
        softAssert.assertEquals(verifySpamText.getText(), "Check your spam folder for an email from noreply@okta.com");
        softAssert.assertEquals(verifyMfaEmail.getText(), "noreply@okta.com");
        softAssert.assertEquals(requestNewCodeBtn.getText(), "Request a new code");
        softAssert.assertAll();
    }

    public void clickRequestNewCode() {
        basicActions.waitForElementToBeClickable(requestNewCodeBtn, 30);
        softAssert.assertTrue(requestNewCodeBtn.isEnabled());
        requestNewCodeBtn.click();
        softAssert.assertAll();
    }


    public void openAllNotices(String noticeNumber, String language) {
        basicActions.waitForElementToBePresentWithRetries(EmailDate, 30);
        basicActions.getDriver().findElement(By.xpath("//div[2]/div[2]/div[2]//span[contains(text(), '" + noticeNumber + "')]")).click();
        basicActions.waitForElementToBePresentWithRetries(EmailDate, 30);

        if (basicActions.isElementDisplayed(scannerLogo, 5)) {
            String TitleText = basicActions.getDriver().findElement(By.xpath("//span[contains(@title, '" + noticeNumber + "')]")).getText();
            basicActions.waitForElementToDisappear(scannerLogo, 10);
            softAssert.assertTrue(TitleText.contains(noticeNumber));

        }
        String TitleText = basicActions.getDriver().findElement(By.xpath("//span[contains(@title, '" + noticeNumber + "')]")).getText();
        softAssert.assertTrue(TitleText.contains(noticeNumber));

        String todayDate = basicActions.getTodayDate();
        String effectiveDate = null;
        switch (language) {
            case "English": {
                effectiveDate = basicActions.changeDateFormat(todayDate, "MM/dd/yyyy", "MMMM d, yyyy", Locale.ENGLISH);
                softAssert.assertTrue(EmailDate.getText().contains(effectiveDate));
                break;
            }
            case "Spanish": {
                Locale spanishLocale = new Locale("es", "ES");
                effectiveDate = basicActions.changeDateFormat(todayDate, "MM/dd/yyyy", "d 'de' MMMM 'del' yyyy", spanishLocale);
                softAssert.assertTrue(EmailDate.getText().contains(effectiveDate));
                break;
            }
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }

        softAssert.assertAll();
    }

    public void VerifyTheNoticeText(String noticeNumber, String language, String typeAPP) {
        switch (typeAPP) {
            case "Exch":
                verifyTheNoticeEXCH(noticeNumber, language);
                break;
            case "Coco":
                verifyTheNoticeCoco(noticeNumber, language);
                break;
            case "Broker":
                verifyTheNoticeBroker(noticeNumber, language);
                break;
            case "Admin":
            verifyTheNoticeAdmin(noticeNumber, language);
            break;
            case "Program Manager":
            verifyTheNoticeProgramManager(noticeNumber, language);
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber + typeAPP);
        }
    }

    private void verifyTheNoticeProgramManager(String noticeNumber, String language) {
        switch (noticeNumber) {
            case "AM-004-01":
                VerifyTheNoticeTextAM00401PM();
                break;
            case "AM-004-03":
                VerifyTheNoticeTextAM00403PM();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber);
        }
    }

    private void VerifyTheNoticeTextAM00401PM() {
        softAssert.assertEquals(adminNoticeEmail.getText(), SharedData.getAssisterDetails().getEmail());
        softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getAssisterDetails().getFirstName()+" "+SharedData.getAssisterDetails().getLastName());
        String Date = basicActions.changeDateFormat(basicActions.getTodayDate(),"MM/dd/yyyy","MM-dd-yyyy");
        softAssert.assertEquals(bodyTextAM00401Parag1.getText(), "Welcome to the Connect for Health Colorado\u00AE Assistance Network Portal! You are invited to create an account for "+SharedData.getAssisterDetails().getOrganizationGroupName()+" effective "+Date+".");
        softAssert.assertEquals(bodyTextAM00401Parag2.getText(), "Next Steps:");
        softAssert.assertEquals(bodyTextAM00401Parag3.getText(), "Use this link and select Create a new Account: https://"+SharedData.getEnv()+"-aws.connectforhealthco.com/login-portal/createAccount?targetUrl=https://"+SharedData.getEnv()+"-aws.connectforhealthco.com/assistnet-portal/landing");
        softAssert.assertEquals(bodyTextAM00401Parag4.getText(), "Do not use the C4HCO customer account creation page.");
        softAssert.assertEquals(bodyTextAM00401Parag5.getText(), "Complete the fields for the Program Manager role and accept the terms and conditions to create your account.");
        softAssert.assertEquals(bodyTextAM00401Parag6.getText(), "Copy and Paste the Invitation Code below.");
        softAssert.assertEquals(bodyTextAM00401Parag7.getText(), "Use the email address that this notice came to in the field for email address.");
        softAssert.assertEquals(bodyTextAM00401Parag8.getText(), "Notices and password resets will be sent to this email address.");
        softAssert.assertEquals(bodyTextAM00401Parag9.getText(), "Enter a phone number for Connect for Health Colorado\u00AE to reach you.");
        softAssert.assertEquals(bodyTextAM00401Parag10.getText(), "After your account is created, sign in to complete your profile and add your organization location information.");
        softAssert.assertEquals(bodyTextAM00401Parag11.getText(), "Your Organization will not be able to be associated to customers until the profile is completed and you have added an organization location.");
        softAssert.assertEquals(bodyTextAM00401Parag12.getText(), "You will receive a second notice to remind you to complete your Profile.");
        softAssert.assertEquals(bodyTextAM00401Parag13.getText(), "Invitation Code:");
        softAssert.assertEquals(bodyTextAM00401Parag14.getText(), "If you believe that your account has been created in error or if you have additional questions, please contact the Connect for Health Colorado\u00AE Assistance Network at AssistanceNetwork@ConnectforHealthCO.com.");
        softAssert.assertAll();
    }
    private void VerifyTheNoticeTextAM00403PM() {
        softAssert.assertEquals(adminNoticeEmail.getText(), SharedData.getAssisterDetails().getEmail());
        softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getAssisterDetails().getFirstName()+" "+SharedData.getAssisterDetails().getLastName());
        String Date = basicActions.changeDateFormat(basicActions.getTodayDate(),"MM/dd/yyyy","MMMM d, yyyy");
        softAssert.assertEquals(bodyTextAM00301Parag1.getText(), "Welcome to Connect for Health Colorado\u00AE. Our records indicate that the following Assistance Network Portal account was opened on "+Date+":");
        softAssert.assertEquals(bodyTextAM00301Parag2.getText(), "Login ID: "+SharedData.getAssisterDetails().getEmail());
        softAssert.assertEquals(bodyTextAM00403NextSteps.getText(), "Next Steps:");
        softAssert.assertEquals(bodyTextAM00403NextStepsBullets.get(0).getText(), "Follow the link to Login at https://connectforhealthco.com/for-certified-assisters/");
        softAssert.assertEquals(bodyTextAM00403LoginWarning.getText(), "Do not use the login for customers");
        softAssert.assertEquals(bodyTextAM00403NextStepsBullets.get(1).getText(), "Complete your profile");
        softAssert.assertEquals(bodyTextAM00403NextStepsBullets.get(2).getText(), "Complete your organization details");
        softAssert.assertEquals(bodyTextAM00403TrainingLink.getText(), "Please visit https://c4hco.csod.com/ for training information and resources.");
        softAssert.assertEquals(bodyTextAM00401Parag14.getText(), "If you believe that your account has been created in error or if you have additional questions, please contact the Connect for Health Colorado\u00AE Assistance Network at AssistanceNetwork@ConnectforHealthCO.com.");
        softAssert.assertAll();
    }

    private void verifyTheNoticeAdmin(String noticeNumber, String language) {
        switch (noticeNumber) {
            case "AM-006-01":
                VerifyTheNoticeTextAM00601Admin();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber);
        }
    }

    private void VerifyTheNoticeTextAM00601Admin() {
        softAssert.assertEquals(adminNoticeEmail.getText(), SharedData.getAdminDetails().getEmail());
                softAssert.assertEquals(adminNoticeName.getText(), SharedData.getAdminDetails().getFirstName()+" "+ SharedData.getAdminDetails().getLastName());
                String Date = basicActions.changeDateFormat(basicActions.getTodayDate(),"MM/dd/yyyy","MMMM dd, yyyy");
                softAssert.assertEquals(adminNoticeWelcome.getText(),"Welcome to Connect for Health Colorado\u00AE. An account was opened for you on "+ Date+":");
                softAssert.assertEquals(adminNoticeName2.getText(),"Name:");
                softAssert.assertEquals(adminNoticeName3.getText(),SharedData.getAdminDetails().getFirstName()+" "+SharedData.getAdminDetails().getLastName());
                softAssert.assertEquals(adminNoticeEmailText.getText(),"Login ID:");
                softAssert.assertEquals(adminNoticeEmailValue.getText(),SharedData.getAdminDetails().getEmail());
        if (SharedData.getEnv().equals("qa")) {
                    softAssert.assertTrue(adminNoticeParag1.getText().contains( "Please click this link to setup your password https://qa-aws.connectforhealthco.com/login-portal/createPassword?recoveryToken="));
                    softAssert.assertTrue(adminNoticeParag2.getText().contains( "After your password has been created, you will be automatically directed to the \"Sign in to your account\" page https://qa-aws.connectforhealthco.com/AdminPortal. To log in, please use your Login ID and your Password."));
        }else{
                    softAssert.assertTrue(adminNoticeParag1.getText().contains( "Please click this link to setup your password https://staging-aws.connectforhealthco.com/login-portal/createPassword?recoveryToken="));
                    softAssert.assertTrue(adminNoticeParag2.getText().contains( "After your password has been created, you will be automatically directed to the \"Sign in to your account\" page https://staging-aws.connectforhealthco.com/AdminPortal. To log in, please use your Login ID and your Password."));
        }
                softAssert.assertEquals(adminNoticeParag3.getText(),"If you have questions concerning your account or feel it was created in error, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m. .");
                softAssert.assertAll();

    }


    private void verifyTheNoticeBroker(String noticeNumber, String language) {
        switch (noticeNumber) {
            case "AM-016-07":
                VerifyTheNoticeTextAM01607broker();
                break;
            case "AM-016-08":
                VerifyTheNoticeTextAM01608broker();
                break;
            case "BN-002A-01":
                VerifyTheNoticeTextBN002A01broker();
                break;
            case "BN-002A-01 Exch":
                VerifyTheNoticeTextBN002A01Exchbroker();
                break;
            case "BN-002A-02":
                VerifyTheNoticeTextBN002A02broker();
                break;
            case "BN-002A-02 Exch":
                VerifyTheNoticeTextBN002A02Exchbroker();
                break;
            case "AM-003-01":
                VerifyTheNoticeTextAM00301Exchbroker();
            break;
            case "AM-003-01 Agency":
                VerifyTheNoticeTextAM00301ExchAgency();
            break;
            case "BN-001A-01":
                VerifyTheNoticeTextBN001A01();
                break;
            case "AM-013-01 Agency":
                VerifyTheNoticeTextAM01301("Agency owner");
                break;
            case "AM-013-01 Broker":
                VerifyTheNoticeTextAM01301("Broker");
                break;
            case "AM-013-01 Admin Staff":
                VerifyTheNoticeTextAM01301("Admin Staff");
                break;
            case "AG-001-02":
                VerifyTheNoticeTextAG00102();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber);
        }
    }

    private void VerifyTheNoticeTextAM00301ExchAgency() {
        String Date = basicActions.changeDateFormat(basicActions.getTodayDate(),"MM/dd/yyyy","MMMM dd, yyyy");
        basicActions.wait(100);
        softAssert.assertEquals(brokerNameBN002A0102.getText(), SharedData.getAgencyOwner().getFirstName()+" "+SharedData.getAgencyOwner().getLastName());
        softAssert.assertEquals(bodyTextAM00301Parag1.getText(), "Welcome to Connect for Health Colorado\u00AE. An account was opened for you on "+ Date+":");
        softAssert.assertEquals(bodyTextAM00301Parag2.getText(), "Login ID: "+ SharedData.getAgencyOwner().getEmail());
        softAssert.assertEquals(bodyTextAM00301Parag3.getText(), "To get started, visit us online at https://connectforhealthco.com/for-certified-brokers/.");
        softAssert.assertEquals(bodyTextAM00301Parag4.getText(), "Log in to your account to complete your profile. You must complete training before you can be certified to place business through Connect for Health Colorado\u00AE. Visit https://c4hco.csod.com/ for more training information and resources..");
        softAssert.assertEquals(bodyTextAM00301Parag5.getText(), "If you believe that your account has been created in error or if you have additional questions, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m.");
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextAM00301Exchbroker() {
        String Date = basicActions.changeDateFormat(basicActions.getTodayDate(),"MM/dd/yyyy","MMMM dd, yyyy");
        basicActions.wait(100);
        softAssert.assertEquals(brokerNameBN002A0102.getText(), SharedData.getBroker().getFirstName()+" "+SharedData.getBroker().getLastName());
        softAssert.assertEquals(bodyTextAM00301Parag1.getText(), "Welcome to Connect for Health Colorado\u00AE. An account was opened for you on "+ Date+":");
        softAssert.assertEquals(bodyTextAM00301Parag2.getText(), "Login ID: "+ SharedData.getBroker().getEmail());
        softAssert.assertEquals(bodyTextAM00301Parag3.getText(), "To get started, visit us online at https://connectforhealthco.com/for-certified-brokers/.");
        softAssert.assertEquals(bodyTextAM00301Parag4.getText(), "Log in to your account to complete your profile. You must complete training before you can be certified to place business through Connect for Health Colorado\u00AE. Visit https://c4hco.csod.com/ for more training information and resources..");
        softAssert.assertEquals(bodyTextAM00301Parag5.getText(), "If you believe that your account has been created in error or if you have additional questions, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m.");
        softAssert.assertAll();

    }


    private void VerifyTheNoticeTextAM01608broker() {
        softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "Your Connect for Health Colorado\u00AE account password was recently reset.");
        softAssert.assertTrue(bodyConfirmationPW.get(1).getText().contains("If you did not make this change, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A01broker() {
        String formatedPhoneNumber = SharedData.getPrimaryMember().getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");

        softAssert.assertEquals(brokerNameBN002A0102.getText(), SharedData.getAgencyOwner().getBroker_name());
        softAssert.assertEquals(bodyTextBN002A01.get(0).getText(), SharedData.getPrimaryMember().getFullName() + " has selected you to work on his or her behalf to purchase health insurance through Colorado Connect\u00AE. You may login to your account to view this client.");
        softAssert.assertEquals(bodyTextBN002A01.get(1).getText(), "Individual Contact Information:");
        softAssert.assertEquals(bodyTextBN002A01.get(2).getText(), "Email: " + SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(bodyTextBN002A01.get(3).getText(), "Phone Number: " + formatedPhoneNumber);
        softAssert.assertEquals(bodyTextBN002A01.get(4).getText(), "If you have questions regarding this update or feel that these changes were not authorized, please call the Colorado Connect\u00AE " + customerServiceHours + " .");
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A01Exchbroker() {
        String formattedPhoneNumber = SharedData.getPrimaryMember().getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");

        softAssert.assertEquals(brokerNameBN002A0102.getText(), SharedData.getAgencyOwner().getBroker_name());
        softAssert.assertEquals(bodyTextBN002A01.get(0).getText(), SharedData.getPrimaryMember().getFullName() + " has selected you to work on his or her behalf to purchase health insurance through Connect for Health Colorado. You may login to your account to view this client.");
        softAssert.assertEquals(bodyTextBN002A01.get(1).getText(), "Individual Contact Information:");
        softAssert.assertEquals(bodyTextBN002A01.get(2).getText(), "Email: " + SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(bodyTextBN002A01.get(3).getText(), "Phone Number: " + formattedPhoneNumber);
        softAssert.assertEquals(bodyTextBN002A01.get(4).getText(), "If you have questions regarding this update or feel that these changes were not authorized, please call the Connect for Health Colorado\u00AE " + customerServiceHours + " .");
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A02broker() {
        softAssert.assertEquals(brokerNameBN002A0102.getText(), SharedData.getAgencyOwner().getBroker_name());
        softAssert.assertEquals(bodyTextBN002A02.getText(), SharedData.getPrimaryMember().getFullName() + " has asked that you no longer work on his or her behalf to purchase insurance through Colorado Connect\u00AE.");

        softAssert.assertEquals(brokerErrorStatementBN002A0102.getText(), "If you have questions regarding this update or feel that these changes were not authorized, please call the Colorado Connect\u00AE " + customerServiceHours);
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A02Exchbroker() {
        softAssert.assertEquals(brokerNameBN002A0102.getText(), SharedData.getAgencyOwner().getBroker_name());
        softAssert.assertEquals(bodyTextBN002A02.getText(), SharedData.getPrimaryMember().getFullName() + " has asked that you no longer work on his or her behalf to purchase insurance through Connect for Health Colorado\u00AE.");

        softAssert.assertEquals(brokerErrorStatementBN002A0102.getText(), "If you have questions regarding this update or feel that these changes were not authorized, please call the Connect for Health Colorado\u00AE " + customerServiceHours);
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextAM01607broker() {
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertTrue(bodyText1607.getText().contains("Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));

        } else if (SharedData.getEnv().equals("staging")) {
            softAssert.assertTrue(bodyText1607.getText().contains("Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));
        }
        softAssert.assertTrue(bodyText1607.getText().contains("This link will expire after 60 minutes. If you do not follow the link within the time allowed, you will need to request a new link."));
        softAssert.assertTrue(bodyText1607part2.getText().contains("If you did not request a password reset, or if you need additional support to reset your password, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));

        softAssert.assertAll();
    }

    public void verifyTheNoticeEXCH(String noticeNumber, String language) {
        switch (noticeNumber) {
            case "AM-016-01":
                VerifyTheNoticeTextAM01601Exch(language);
                break;
            case "ELG-101-01":
                VerifyTheELG10101NoticeText(language);
                break;
            case "AM-016-03":
                VerifyTheNoticeTextAM01603();
                break;
            case "AM-016-05":
                VerifyTheNoticeTextAM01605();
                break;
            case "AM-001-01":
                VerifyTheNoticeTextAM00101(language);
                break;
            case "EN-002-04":
                VerifyTheNoticeTextEN00204();
                break;
            case "AM-016-07":
                VerifyTheNoticeTextAM01607(language);
                break;
            case "AM-016-08":
                VerifyTheNoticeTextAM01608(language);
                break;
            case "BN-002A-04":
                VerifyTheNoticeTextBN002A04(language);
            break;
            case "BN-002A-03":
                VerifyTheNoticeTextBN002A03(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber);
        }
    }

    private void VerifyTheNoticeTextBN001A01() {
            softAssert.assertEquals(individualEmailBN002A0304.getText(),SharedData.getBroker().getEmail());
            softAssert.assertEquals(BodyTextBN002A0404.get(1).getText(),"We have confirmed your Colorado licensure and completion of certification training, and we have received a copy of your Certified Producer Agreement. You are now certified to assist people with applying for coverage through Connect for Health Colorado");
            softAssert.assertTrue(bodyTextBN001A01.getText().contains("Login ID: "+SharedData.getBroker().getEmail()));
            softAssert.assertTrue(bodyTextBN001A01.getText().contains("Status: ACTIVE"));
            softAssert.assertEquals(bodyTextBN001A01part3.getText(),"If you have questions regarding this update or believe that these changes were not authorized, please contact the Connect for Health Colorado Broker Team at BrokerTeam@c4hco.com <mailTo:BrokerTeam@c4hco.com>.");

            softAssert.assertAll();

    }

    private void VerifyTheNoticeTextAM01301(String userType) {
        String name;
        String email;
        switch (userType) {
            case "Agency owner":
                name = SharedData.getAgencyOwner().getFirstName()+" "+SharedData.getAgencyOwner().getLastName();
                email = SharedData.getAgencyOwner().getEmail();
                break;
            case "Broker":
                name = SharedData.getBroker().getFirstName()+" "+SharedData.getBroker().getLastName();
                email = SharedData.getBroker().getEmail();
                break;
            case "Admin Staff":
                name = SharedData.getAdminStaff().getFirstName()+" "+SharedData.getAdminStaff().getLastName();
                email = SharedData.getAdminStaff().getEmail();
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + userType);
        }
        softAssert.assertEquals(brokerNameBN002A0102.getText(), name);
        softAssert.assertTrue(bodyTextAM01301.get(0).getText().contains("Welcome to Connect for Health Colorado\u00AE. Our records indicate that your Connect for Health Colorado\u00AE Broker Portal profile for " + email));
        softAssert.assertEquals(bodyTextAM01301.get(1).getText(), "If you have questions regarding your account or feel these changes were not authorized, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m.");
        softAssert.assertAll();

    }

    private void VerifyTheNoticeTextAG00102(){
        String currentDate = basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "MMMM d, yyyy");
        softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getAdminStaff().getEmail());
        softAssert.assertEquals(adminStaffAG00102body.get(0).getText(), "Welcome to Connect for Health Colorado\u00AE. Our records indicate that you were identified as an Authorized User for Arrow Head Agency on " + currentDate + ".");
        softAssert.assertEquals(adminStaffAG00102body.get(1).getText(), "Please log in to your account and enter the Invitation Code. If you do not have an account, you can create an account by clicking the link below and selecting \"Administrative Staff\" as your role. Once you have created your account, you will enter the invitation code when completing your profile.");
        softAssert.assertEquals(adminStaffAG00102body.get(2).getText(), "Invitation Code: " +SharedData.getAdminStaff().getAdminStaffInviteCode());
        softAssert.assertEquals(adminStaffAG00102body.get(3).getText(), "Create an account https://" + SharedData.getEnv() + "-aws.connectforhealthco.com/broker-portal/landing");
        softAssert.assertEquals(adminStaffAG00102body.get(4).getText(), "If you believe that you've received this notice in error or if you have additional questions, please call the Connect for Health Colorado\u00AE " + customerServiceHours + " .");
        softAssert.assertEquals(adminStaffAG00102body.get(5).getText(), "For additional information about your account, please contact the primary agency representative.");
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A04(String language) {
        switch (language){
            case "Spanish":
                softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(bodyTextBN002A04.get(0).getText(), "Nuestros registros muestran que ha eliminado a Arrow Head Agency como Agente autorizado para trabajar en su nombre en el Mercado de Connect for Health Colorado\u00AE.");
                softAssert.assertEquals(bodyTextBN002A04.get(1).getText(), "Si considera que esta desautorizaci\u00F3n fue creada por error o si tiene otras preguntas, llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m.");
                softAssert.assertAll();
        }
    }

    private void VerifyTheNoticeTextAM01608(String language) {
        switch (language) {
            case "English":
                softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "Your Connect for Health Colorado\u00AE account password was recently reset.");
                softAssert.assertTrue(bodyConfirmationPW.get(1).getText().contains( "If you did not make this change, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
                break;
            case "Spanish":
                softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "La contrase\u00F1a de su cuenta de Connect for Health Colorado\u00AE fue cambiada recientemente.");
                softAssert.assertTrue(bodyConfirmationPW.get(1).getText().contains("Si usted no hizo este cambio, llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m."));
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextAM01607(String language) {
        switch (language) {
            case "English":
                if (SharedData.getEnv().equals("qa")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));

                } else if (SharedData.getEnv().equals("staging")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Your have requested to reset your Connect for Health Colorado\u00AE account password. To reset your password, please follow the link: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));
                }
                softAssert.assertTrue(bodyText1607.getText().contains("This link will expire after 60 minutes. If you do not follow the link within the time allowed, you will need to request a new link."));
                softAssert.assertTrue(bodyText1607part2.getText().contains("If you did not request a password reset, or if you need additional support to reset your password, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));

                break;
            case "Spanish":
                if (SharedData.getEnv().equals("qa")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Ha solicitado restablecer la contrase\u00F1a de su cuenta de Connect for Health Colorado\u00AE. Para restablecerla, haga clic en este enlace: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));

                } else if (SharedData.getEnv().equals("staging")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Ha solicitado restablecer la contrase\u00F1a de su cuenta de Connect for Health Colorado\u00AE. Para restablecerla, haga clic en este enlace: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));
                }
                softAssert.assertTrue(bodyText1607.getText().contains("Este enlace vencer\u00E1 despu\u00E9s de 60 minutos. Si no sigue el enlace durante el tiempo permitido, tendr\u00E1 que solicitar uno nuevo."));
                softAssert.assertTrue(bodyText1607part2.getText().contains("Si no solicit\u00F3 el restablecimiento de su contrase\u00F1a o si necesita m\u00E1s ayuda para hacerlo, llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m."));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void verifyTheNoticeCoco(String noticeNumber, String language) {
        switch (noticeNumber) {
            case "AM-016-01":
                VerifyTheNoticeTextAM01601coco(language);
                break;
            case "EN-002-04":
                VerifyTheNoticeTextEN00204();
                break;
            case "AM-001-01":
                VerifyTheNoticeTextAM00101Coco(language);
                break;
            case "BN-002A-03":
                VerifyTheNoticeTextBN002A03Coco(language);
                break;
            case "BN-002A-04":
                VerifyTheNoticeTextBN002A04Coco(language);
                break;
            case "AM-016-07":
                VerifyTheNoticeTextAM01607Coco(language);
                break;
            case "AM-016-08":
                VerifyTheNoticeTextAM01608Coco(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language + noticeNumber);
        }
    }

    private void VerifyTheNoticeTextAM01608Coco(String language) {
        softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
            switch (language) {
                case "English":
                    softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "Your Colorado Connect\u00AE account password was recently reset.");
                    softAssert.assertTrue(bodyConfirmationPW.get(1).getText().contains( "If you did not make this change, please call the Colorado Connect\u00AE Customer Service Center at 855-675-2626 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
                    break;
                case "Spanish":
                    softAssert.assertEquals(bodyConfirmationPW.get(0).getText(), "La contrase\u00F1a de su cuenta de Colorado Connect\u00AE fue cambiada recientemente.");
                    softAssert.assertTrue(bodyConfirmationPW.get(1).getText().contains("Si usted no hizo este cambio, llame al Centro de atenci\u00F3n al cliente de Colorado Connect\u00AE al 855-675-2626 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m."));
                    break;

                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            softAssert.assertAll();


    }

    private void VerifyTheNoticeTextAM01607Coco(String language) {
        softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
        switch (language) {
            case "English":

                if (SharedData.getEnv().equals("qa")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Your have requested to reset your Colorado Connect\u00AE account password. To reset your password, please follow the link: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));
                    softAssert.assertAll();
                } else if (SharedData.getEnv().equals("staging")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Your have requested to reset your Colorado Connect\u00AE account password. To reset your password, please follow the link: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));

                    softAssert.assertAll();
                }
                softAssert.assertTrue(bodyText1607.getText().contains("This link will expire after 60 minutes. If you do not follow the link within the time allowed, you will need to request a new link."));
                softAssert.assertAll();
                softAssert.assertTrue(bodyText1607part2.getText().contains("If you did not request a password reset, or if you need additional support to reset your password, please call the Colorado Connect\u00AE Customer Service Center at 855-675-2626 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
                softAssert.assertAll();
                break;
            case "Spanish":
                if (SharedData.getEnv().equals("qa")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Ha solicitado restablecer la contrase\u00F1a de su cuenta de Colorado Connect\u00AE. Para restablecerla, haga clic en este enlace: https://qa-aws.connectforhealthco.com/login-portal/createPassword"));
                    softAssert.assertAll();
                } else if (SharedData.getEnv().equals("staging")) {
                    softAssert.assertTrue(bodyText1607.getText().contains("Ha solicitado restablecer la contrase\u00F1a de su cuenta de Colorado Connect\u00AE. Para restablecerla, haga clic en este enlace: https://staging-aws.connectforhealthco.com/login-portal/createPassword"));
                    softAssert.assertAll();
                }
                softAssert.assertTrue(bodyText1607.getText().contains("Este enlace vencer\u00E1 despu\u00E9s de 60 minutos. Si no sigue el enlace durante el tiempo permitido, tendr\u00E1 que solicitar uno nuevo."));
                softAssert.assertAll();
                softAssert.assertTrue(bodyText1607part2.getText().contains("Si no solicit\u00F3 el restablecimiento de su contrase\u00F1a o si necesita m\u00E1s ayuda para hacerlo, llame al Centro de atenci\u00F3n al cliente de Colorado Connect\u00AE al 855-675-2626 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m."));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();

    }

    private void VerifyTheNoticeTextAM00101Coco(String language) {

        switch (language) {
            case "English":
                softAssert.assertTrue(bodyTextAM00101.get(0).getText().contains("Dear"));
                softAssert.assertTrue(bodyTextAM00101.get(1).getText().contains("Welcome to Colorado Connect\u00AE . An account was opened for you on"));
                softAssert.assertEquals(body2TextAM00101.get(0).getText(), "You are now ready to choose a health insurance plan that best fits your needs. To get started, follow the link below to log in and begin shopping!");
                softAssert.assertTrue(body2TextAM00101.get(2).getText().contains("The communication preference you chose is email. All future communications will be sent via email to"));
                break;
            case "Spanish":
                softAssert.assertTrue(bodyTextAM00101.get(0).getText().contains("Apreciable"));
                softAssert.assertTrue(bodyTextAM00101.get(1).getText().contains("Le damos la bienvenida a Colorado Connect\u00AE. Se le cre\u00F3 una cuenta el"));
                softAssert.assertTrue(body2TextAM00101.get(0).getText().contains("Ya puede elegir el plan de seguro de salud que mejor se ajuste a sus necesidades. Para empezar, haga clic en el enlace que aparece a continuaci\u00F3n"));
                softAssert.assertTrue(body2TextAM00101.get(2).getText().contains("Usted eligi\u00F3 el correo electr\u00F3nico como medio de comunicaci\u00F3n preferido. Todas las comunicaciones futuras se enviar\u00E1n por correo electr\u00F3nico"));
                break;
        }
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A03Coco(String language) {
        String agencyPhoneNumber = SharedData.getAgencyOwner().getAgencyPhoneNumber().replace("-", "");
        switch (language) {
            case "English":
                softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(bodyTextBN002A03.get(0).getText(), "Our records show that you have selected " + SharedData.getAgencyOwner().getAgencyName() + " to work with Colorado Connect\u00AE on your behalf.");
                softAssert.assertEquals(bodyTextBN002A03.get(1).getText(), "Your Account Information");
                softAssert.assertTrue(bodyTextBN002A03.get(2).getText().contains("Household Primary Contact: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(bodyTextBN002A03.get(3).getText(),"Your selected Broker or Agency is also receiving a notice that confirms the authorization. Below is your authorized Broker or Agency\u2019s information.");
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("Agency Name: "+ SharedData.getAgencyOwner().getAgencyName()));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("Agency Phone Number: "+ agencyPhoneNumber));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("License Number: "+ SharedData.getAgencyOwner().getLicense()));
                softAssert.assertEquals(bodyTextBN002A03Part5.getText(),"You can get this letter in Spanish or in a large print copy or another way that's best for you. Call 855-675-2626. Puede recibir esta carta en espa\u00F1ol o en copia impresa con letra grande o de cualquier otra manera que le resulte conveniente. Llame al 855-675-2626.");
                break;
            case "Spanish":
                softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(bodyTextBN002A03.get(0).getText(), "Nuestros registros muestran que ha elegido que " + SharedData.getAgencyOwner().getAgencyName() + " trabaje en su nombre con Colorado Connect\u00AE.");
                softAssert.assertEquals(bodyTextBN002A03.get(1).getText(), "Informaci\u00F3n de su cuenta");
                softAssert.assertTrue(bodyTextBN002A03.get(2).getText().contains("Contacto principal de la familia: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(bodyTextBN002A03.get(3).getText(),"Su agente o agencia seleccionada tambi\u00E9n recibir\u00E1 un aviso confirmando la autorizaci\u00F3n. Esta es la informaci\u00F3n de su agente o agencia autorizada.");
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("ombre de la agencia: "+ SharedData.getAgencyOwner().getAgencyName()));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("Tel\u00E9fono de la agencia: "+ agencyPhoneNumber));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("N\u00FAmero de licencia: "+ SharedData.getAgencyOwner().getLicense()));
                softAssert.assertEquals(bodyTextBN002A03Part5.getText(),"Puede recibir esta carta en ingl\u00E9s o en copia impresa con letra grande o de cualquier otra manera que le resulte conveniente. Llame al 855-675-2626. You can get this letter in English or in a large print copy or another way that's best for you. Call 855-675-2626.");
                break;
        }
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A04Coco(String language) {

        switch (language) {
            case "English":
                softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(bodyTextBN002A04.get(0).getText(), "Our records show that you have de-authorized " + SharedData.getAgencyOwner().getAgencyName() + " from working on your account. They can no longer work on your behalf to purchase health insurance through Colorado Connect\u00AE.");

                softAssert.assertTrue(bodyTextBN002A04.get(1).getText().contains("If you believe that this de-authorization has been created in error or if you have additional questions, please call the Colorado Connect\u00AE Customer Service Center at 855-675-2626 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
                break;
            case "Spanish":
                softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(bodyTextBN002A04.get(0).getText(), "Nuestros registros muestran que ha eliminado a " + SharedData.getAgencyOwner().getAgencyName() + " como Agente autorizado para trabajar en su nombre en el Mercado de Colorado Connect\u00AE.");

                softAssert.assertTrue(bodyTextBN002A04.get(1).getText().contains("Si considera que esta desautorizaci\u00F3n fue creada por error o si tiene otras preguntas, llame al Centro de atenci\u00F3n al cliente de Colorado Connect\u00AE al 855-675-2626 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m."));
                break;
        }
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextBN002A03(String language) {
        String agencyPhoneNumber = SharedData.getAgencyOwner().getAgencyPhoneNumber().replace("-", "");
        switch (language) {
            case "English":
                softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(bodyTextBN002A03.get(0).getText(), "Our records show that you have selected " + SharedData.getAgencyOwner().getAgencyName() + " to work with Connect for Health Colorado\u00AE on your behalf.");
                softAssert.assertEquals(bodyTextBN002A03.get(1).getText(), "Your Account Information");
                softAssert.assertTrue(bodyTextBN002A03.get(2).getText().contains("Household Primary Contact: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(bodyTextBN002A03.get(3).getText(),"Your selected Broker or Agency is also receiving a notice that confirms the authorization. Below is your authorized Broker or Agency\u2019s information.");
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("Agency Name: "+ SharedData.getAgencyOwner().getAgencyName()));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("Agency Phone Number: "+ agencyPhoneNumber));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("License Number: "+ SharedData.getAgencyOwner().getLicense()));
                softAssert.assertEquals(bodyTextBN002A03.get(5).getText(), "If you believe that this relationship has been authorized in error or if you have additional questions, please call us at 1-855-752-6749, TTY at 1-855-695-5935. please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m.");
                break;
            case "Spanish":
                softAssert.assertEquals(individualEmailBN002A0304.getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(individualNameBN002A0304.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(bodyTextBN002A03.get(0).getText(), "Nuestros registros muestran que ha elegido que " + SharedData.getAgencyOwner().getAgencyName() + " trabaje en su nombre con Connect for Health Colorado\u00AE.");
                softAssert.assertEquals(bodyTextBN002A03.get(1).getText(), "Informaci\u00F3n de su cuenta");
                softAssert.assertTrue(bodyTextBN002A03.get(2).getText().contains("Contacto principal de la familia: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(bodyTextBN002A03.get(3).getText(),"Su agente o agencia seleccionada tambi\u00E9n recibir\u00E1 un aviso confirmando la autorizaci\u00F3n. Esta es la informaci\u00F3n de su agente o agencia autorizada.");
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("ombre de la agencia: "+ SharedData.getAgencyOwner().getAgencyName()));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("Tel\u00E9fono de la agencia: "+ agencyPhoneNumber));
                softAssert.assertTrue(bodyTextBN002A03.get(4).getText().contains("N\u00FAmero de licencia: "+ SharedData.getAgencyOwner().getLicense()));
                softAssert.assertEquals(bodyTextBN002A03.get(5).getText(), "Si piensa que esta autorizaci\u00F3n es un error o si tiene preguntas adicionales, por favor ll\u00E1menos al 1-855-752-6749, TTY at 1-855-695-5935. llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m.");
                break;
        }
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextAM00101(String language) {
        switch (language) {
            case "English":
                softAssert.assertTrue(bodyTextAM00101.get(0).getText().contains("Dear"));
                softAssert.assertTrue(bodyTextAM00101.get(1).getText().contains("Welcome to Connect for Health Colorado\u00AE. An account was opened for you on"));
                softAssert.assertEquals(body2TextAM00101.get(0).getText(), "You are now ready to choose a health insurance plan that best fits your needs. To get started, follow the link below to log in and begin shopping!");
                softAssert.assertTrue(body2TextAM00101.get(2).getText().contains("The communication preference you chose is email. All future communications will be sent via email to "));
                break;
            case "Spanish":
                softAssert.assertTrue(bodyTextAM00101.get(0).getText().contains("Apreciable"));
                softAssert.assertTrue(bodyTextAM00101.get(1).getText().contains("Le damos la bienvenida a Connect for Health Colorado\u00AE. Se le cre\u00F3 una cuenta el"));
                softAssert.assertTrue(body2TextAM00101.get(0).getText().contains("Ya puede elegir el plan de seguro de salud que mejor se ajuste a sus necesidades. Para empezar, haga clic en el enlace que aparece a continuaci\u00F3n"));
                softAssert.assertTrue(body2TextAM00101.get(2).getText().contains("Usted eligi\u00F3 el correo electr\u00F3nico como medio de comunicaci\u00F3n preferido. Todas las comunicaciones futuras se enviar\u00E1n por correo electr\u00F3nico"));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    private void VerifyTheNoticeTextAM01605() {
        softAssert.assertTrue(bodyTextAM1605.get(0).getText().contains("Your Login ID for Connect for Health Colorado\u00AE is: "));
        softAssert.assertEquals(bodyTextAM1605.get(1).getText(), "Follow the link to Login at https://connectforhealthco.com/for-certified-assisters/.");
        softAssert.assertEquals(bodyTextAM1605.get(2).getText(), "If you didn't request to have your Login ID emailed to you, please call the Connect for Health Colorado\u00AE Broker Customer Service Center at 1-855-426-2765 Monday - Friday 8:00a.m. - 6:00p.m. Saturdays and Holidays 8:00a.m. - 5:00p.m. If you have questions about your Program Manager account, please email [AssistanceNetwork@c4hco.com]AssistanceNetwork@c4hco.com.");
        softAssert.assertAll();
    }

    public void VerifyTheELG10101NoticeText(String language) {
        switch (language) {
            case "English":
                softAssert.assertTrue(emailHdrtxt.get(0).getText().contains("ELG-101-01"));
                softAssert.assertEquals(emailHdrtxt.get(2).getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(emailDeartxt.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(initialEligibilityBodyTxt.get(1).getText(), "Account Number: " + SharedData.getPrimaryMember().getAccount_id());
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertTrue(emailHdrtxt.get(0).getText().contains("ELG-101-01"));
                softAssert.assertEquals(emailHdrtxt.get(2).getText(), SharedData.getPrimaryMember().getEmailId());
                softAssert.assertEquals(emailDeartxt.getText(), SharedData.getPrimaryMember().getFullName());
                softAssert.assertEquals(initialEligibilityBodyTxt.get(1).getText(), "N\u00FAmero de Cuenta: " + SharedData.getPrimaryMember().getAccount_id());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void VerifyTheNoticeTextAM01601coco(String language) {
        switch (language) {
            case "English":
                softAssert.assertTrue(bodyText.get(1).getText().contains("Your Username for Colorado Connect\u00AE is:"));
                softAssert.assertAll();
                softAssert.assertEquals(bodyText.get(2).getText(),"Return to the Colorado Connect\u00AE website and enter this username plus your password to log in to your account.");//®
                softAssert.assertTrue((bodyText.get(3).getText().contains("If you did not request to have your Username emailed to you, please call the Colorado Connect\u00AE Customer Service Center at 855-675-2626 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m.")));
                softAssert.assertAll();
                softAssert.assertTrue(bodyText2.getText().contains("please call the Colorado Connect\u00AE Customer Service Center at 855-675-2626 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
                softAssert.assertAll();
                break;
            case "Spanish" :
                softAssert.assertTrue(bodyText.get(1).getText().contains("Su Nombre de usuario para Colorado Connect\u00AE es:"));
                softAssert.assertAll();
                softAssert.assertEquals(bodyText.get(2).getText(),"Regrese al sitio web de Colorado Connect\u00AE y introduzca este nombre de usuario y su contrase\u00F1a para ingresar en su cuenta.");
                softAssert.assertTrue(bodyText.get(3).getText().contains("Si no solicit\u00F3 el envio por correo electr\u00F3nico de su Nombre de usario, llame al Centro de atenci\u00F3n al cliente de Colorado Connect\u00AE al 855-675-2626 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m."));
                softAssert.assertAll();
                softAssert.assertTrue(bodyText2.getText().contains("llame al Centro de atenci\u00F3n al cliente de Colorado Connect\u00AE al 855-675-2626 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m."));
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void VerifyTheNoticeTextAM01601Exch(String language) {
        switch (language) {
            case "English":
                softAssert.assertTrue(bodyText.get(1).getText().contains("Your Username for Connect for Health Colorado\u00AE is:"));
                softAssert.assertEquals(bodyText.get(2).getText(), "Return to the Connect for Heath Colorado\u00AE website and enter this username plus your password to log in to your account.");
                softAssert.assertTrue(bodyText.get(3).getText().contains( "If you did not request to have your Username emailed to you, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
                softAssert.assertTrue(bodyText2.getText().contains("please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m."));
                break;
            case "Spanish" :
                softAssert.assertTrue(bodyText.get(1).getText().contains("Su Nombre de usuario para Connect for Health Colorado\u00AE es:"));
                softAssert.assertEquals(bodyText.get(2).getText(),"Regrese al sitio web de Connect for Health Colorado\u00AE e introduzca este nombre de usuario y su contrase\u00F1a para ingresar en su cuenta.");
                softAssert.assertEquals(bodyText.get(3).getText(), "Si no solicit\u00F3 el envio por correo electr\u00F3nico de su Nombre de usario, llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m.");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void VerifyTheNoticeTextAM01603() {
        softAssert.assertTrue(bodyText1603.get(1).getText().contains("Your Login ID for Connect for Health Colorado\u00AE is: "));
        softAssert.assertEquals(bodyText1603.get(2).getText(), "If you didn't request to have your Login ID emailed to you, please call the Connect for Health Colorado\u00AE " + customerServiceHours);
        softAssert.assertEquals(bodyText1603part2.getText(), "If you have questions regarding this update or feel that these changes were not authorized, please call the Connect for Health Colorado\u00AE " + customerServiceHours);
        softAssert.assertAll();
    }

    public void VerifyTheNoticeTextEN00204() {
        String todayDate = basicActions.getTodayDate();
        todayDate = basicActions.changeDateFormat(todayDate, "MM/dd/yyyy", "MMMM d, yyyy");
        softAssert.assertEquals(emailDeartxt.getText(), SharedData.getPrimaryMember().getFullName());
        softAssert.assertTrue(EmailDate.getText().contains(todayDate), "Email generated date mismatch");
        softAssert.assertEquals(bodyTextEN00204.get(0).getText(), "Welcome! This notice confirms that you chose an insurance plan on " + todayDate + " for Plan Year 2025.");
        softAssert.assertAll();
    }

    public void clickThePasswordResetLink() {
        basicActions.waitForElementToBePresent(resetPWLink, 20);
        resetPWLink.click();
    }

    public void verifyNoticeAbsence(String noticeNumber) {
        basicActions.waitForElementToBePresentWithRetries(EmailDate, 30);

        List<WebElement> elements = basicActions.getDriver().findElements(By.xpath("//span[contains(@title, '" + noticeNumber + "')]"));
        softAssert.assertTrue(elements.isEmpty());
        softAssert.assertAll();
    }

    public void validateDetailsFromEmailPolicy(String planType, List<String> membersOnPolicy) {
        // Validating plan name, member names and coverage start date from email notice
        switch (planType) {
            case "medical":
                String coverageStartDate_medical = SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageStartDate();
                String formattedCoverageDt_med = "Coverage Start Date: "+basicActions.changeDateFormat(coverageStartDate_medical, "yyyy-MM-dd", "MMMM dd, yyyy");
                for (String member:membersOnPolicy){
                    validateMemberNameAndMedicalPlanInfo(member);
                }
                softAssert.assertTrue(emailPolicyDetails.get(15).getText().contains(formattedCoverageDt_med), "Medical coverage date mismatch");
                break;
            case "dental":
                String coverageStartDate_dental = SharedData.getExpectedCalculatedDates_dentalPlan().getCoverageStartDate();
                String formattedCoverageDt_dental = "Coverage Start Date: "+basicActions.changeDateFormat(coverageStartDate_dental, "yyyy-MM-dd", "MMMM dd, yyyy");
                for (String member:membersOnPolicy){
                    validateMemberNameAndDentalPlanInfo(member);
                }
                softAssert.assertTrue(emailPolicyDetails.get(7).getText().contains(formattedCoverageDt_dental), "Dental coverage date mismatch");
                break;
        }
        softAssert.assertAll();
    }
    private void validateMemberNameAndMedicalPlanInfo(String memPrefix) {
        List<MemberDetails> allMembers = basicActions.getAllMedicalEligibleMemInfo();
        String memberCompleteFullName = allMembers.stream().filter(member->member.getFirstName().contains(memPrefix) && member.getHasMedicalPlan()).map(MemberDetails::getCompleteFullName).findFirst().orElse("Complete Full Name Not found");
        String medicalPlanName = allMembers.stream().filter(member->member.getFirstName().contains(memPrefix) && member.getHasMedicalPlan()).map(MemberDetails::getMedicalPlan).findFirst().orElse("Medical Plan Not found");
        WebElement policyDetailsFromEmailNotice = basicActions.getDriver().findElement(By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body']) //*[contains(text(),'" + medicalPlanName + "')]/following-sibling::dd[contains(text(),'" + memberCompleteFullName + "')]"));
        basicActions.waitForElementToBePresent(policyDetailsFromEmailNotice, 30);
        softAssert.assertTrue(policyDetailsFromEmailNotice.getText().contains(memberCompleteFullName), memPrefix + " member details not found");
        softAssert.assertAll();
    }

    private void validateMemberNameAndDentalPlanInfo(String memPrefix) {
        List<MemberDetails> allMembers = basicActions.getAllDentalEligibleMemInfo();
        String dentalPlanName = allMembers.stream().filter(member->member.getFirstName().contains(memPrefix) && member.getHasDentalPlan()).map(MemberDetails::getDentalPlan).findFirst().orElse("Dental Plan Not found");
        String memberCompleteFullName = allMembers.stream().filter(member->member.getFirstName().contains(memPrefix) && member.getHasMedicalPlan()).map(MemberDetails::getCompleteFullName).findFirst().orElse("Complete Full Name Not found");
        WebElement policyDetailsFromEmailNotice = basicActions.getDriver().findElement(By.xpath("(//div[@id='x_policyInformation'] //*[@class='x_body']) //*[contains(text(),'" + dentalPlanName + "')]/following-sibling::dd[contains(text(),'" + memberCompleteFullName + "')]"));
        basicActions.waitForElementToBePresent(policyDetailsFromEmailNotice, 30);
        softAssert.assertTrue(policyDetailsFromEmailNotice.getText().contains(memberCompleteFullName), memPrefix + " member details not found");
        softAssert.assertAll();
    }

}
