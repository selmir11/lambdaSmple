package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginPage {

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "create-account-link")
    WebElement createAccountLink;

    @FindBy(id = "email")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "main-sign-in")
    WebElement signInButton;

    @FindBy(id = "email")
    WebElement usernameAdmin;

    @FindBy(id = "password")
    WebElement passwordAdmin;

    @FindBy(id = "main-sign-in")
    WebElement signAdmin;

    @FindBy(xpath = "//a[text()=' password']")
    WebElement forgotPassword;

    @FindBy(xpath = "//a[text()='username']")
    WebElement forgotUsername;

    @FindBy(xpath = "//span[normalize-space()='Username is required']")
    WebElement usernameError;

    @FindBy(xpath = "//span[normalize-space()='Password is required']")
    WebElement passwordError;

    @FindBy(css = ".fw-bold")
    WebElement iForgotUsernameandPassword;
    @FindBy(id = "title")
    WebElement loginPageTitle;
    @FindBy(id = "email-label")
    WebElement usernameText;
    @FindBy(id = "password-label")
    WebElement passwordText;
    @FindBy(id = "peak-login")
    WebElement peakTitleText;
    @FindBy(id = "peak-login-text")
    WebElement peakDescriptionText;
    @FindBy(id = "exchNotice")
    WebElement exchLegalNotice;
    @FindBy(id = "cocoNotice")
    WebElement cocoLegalNotice;
    @FindBy(id = "password-expired")
    WebElement passwordExpiredText;
    @FindBy(css = "form > div.ng-star-inserted > div:nth-child(2)")
    WebElement passwordExpiredErrorText;
    @FindBy(id = "showHidePasswordLink")
    WebElement showHidePW;
    @FindBy(id = "passwordBtn")
    WebElement showHidePWCreateAccount;


    private BasicActions basicActions;
    private Utils utils = new Utils(WebDriverManager.getDriver());

    public LoginPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage(String portalType) {
        basicActions.getDriver().get(utils.getBaseLoginUrl(portalType));
    }

    public void clickCreateAccount() {
        createAccountLink.click();
    }

    public void logInWithValidCredentials() {
        basicActions.waitForElementToBePresent(username, 10);
        String emailId = SharedData.getPrimaryMember().getEmailId();
        System.out.println("Email::" + emailId);
        String pswd = SharedData.getPrimaryMember().getPassword();
        basicActions.wait(2000);
        username.sendKeys(emailId);
        basicActions.waitForElementToBePresent(password, 10);
        password.sendKeys(pswd);
        System.out.println("Password::" + pswd);
        signInButton.click();
    }

    public void logInBrokerPortal(String accountType) {
        basicActions.waitForElementToBePresent(username, 10);
        BrokerDetails user;
        switch(accountType){
            case "Agency Owner":
                user = SharedData.getAgencyOwner();
                break;
            case "Broker":
                user = SharedData.getBroker();
                break;
            case "Admin Staff":
                user = SharedData.getAdminStaff();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + accountType);

        }
        String emailId = user.getEmail();
        System.out.println("Email::"+emailId);
        String pswd = user.getPassword();
        System.out.println("Password::"+pswd);
        basicActions.wait(2000);
        username.sendKeys(emailId);
        password.sendKeys(pswd);
        signInButton.click();
    }
    public void loginAsBrokerUser(String brokerUser,String Password){
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        usernameAdmin.sendKeys(brokerUser);
        basicActions.waitForElementToBePresent(usernameAdmin, 20);
        passwordAdmin.sendKeys(Password);
        signAdmin.click();
    }

    public void loginAsBrokerUserAnyEnv(String stgUser, String stgPW, String qaUser, String qaPW) {
        basicActions.waitForElementToBePresent(usernameAdmin, 40);
        if (SharedData.getEnv().equals("staging")) {
            usernameAdmin.sendKeys(stgUser);
            passwordAdmin.sendKeys(stgPW);
        } else {
            usernameAdmin.sendKeys(qaUser);
            passwordAdmin.sendKeys(qaPW);
        }
        signAdmin.click();
    }

    public void loginAsAdminUserAnyEnv(String stgUser, String stgPW, String qaUser, String qaPW) {
        basicActions.refreshPage();
        basicActions.waitForElementToBePresent(usernameAdmin, 40);
        if (SharedData.getEnv().equals("staging")) {
            usernameAdmin.sendKeys(ApplicationProperties.getInstance().getProperty(stgUser));
            passwordAdmin.sendKeys(ApplicationProperties.getInstance().getProperty(stgPW));
        } else {
            usernameAdmin.sendKeys(ApplicationProperties.getInstance().getProperty(qaUser));
            passwordAdmin.sendKeys(ApplicationProperties.getInstance().getProperty(qaPW));
        }
        signAdmin.click();
    }

    public void clickForgotPassword() {
        basicActions.waitForElementToBePresent(forgotPassword, 20);
        forgotPassword.click();
    }

    public void clickForgotUsername() {
        basicActions.waitForElementToBePresent(forgotUsername, 20);
        forgotUsername.click();
    }

    public void clickSignIn() {
        signAdmin.click();
    }

    public void usernameRequiredMessage() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(usernameError, 20));
        softAssert.assertAll();
    }

    public void passwordRequiredMessage() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(passwordError, 20));
        softAssert.assertAll();
    }

    public void usernameandpasswordRequiredMessage() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(iForgotUsernameandPassword, 20));
        softAssert.assertAll();
    }

    public void loginAsExistingIndividual(String userIndividual, String passwordInd) {
        basicActions.waitForElementToBePresent(username, 10);
        username.sendKeys(userIndividual);
        password.sendKeys(passwordInd);
        basicActions.waitForElementToBePresent(signAdmin, 10);
        signAdmin.click();
    }

    public void validateTheTitleOfThePage(String language) {
        basicActions.waitForElementToBePresent(loginPageTitle, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(loginPageTitle.getText(), "Sign in to your account");
                softAssert.assertAll();
                break;
            case "Spanish":

                softAssert.assertEquals(loginPageTitle.getText(), "Inicie sesi\u00F3n en su cuenta");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void ValidateTheUsernameAndPasswordText(String language) {
        basicActions.waitForElementToBePresent(usernameText, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(usernameText.getText(), "Username");
                softAssert.assertEquals(passwordText.getText(), "Password");
                break;
            case "Spanish":
                softAssert.assertEquals(usernameText.getText(), "Nombre de usuario");
                softAssert.assertEquals(passwordText.getText(), "Contrase\u00F1a");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void ValidatePEAKText(String language) {
        basicActions.waitForElementToBePresent(peakTitleText, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(peakTitleText.getText(), "Colorado PEAK Users");
                softAssert.assertEquals(peakDescriptionText.getText(), "Looking to sign in with your Colorado PEAK account instead?");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(peakTitleText.getText(), "Usuarios de Colorado PEAK");
                softAssert.assertEquals(peakDescriptionText.getText(), "\u00BFPrefiere ingresar con su cuenta de Colorado PEAK?");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void ValidateLegalNoticeText(String language) {
        basicActions.waitForElementToBePresent(exchLegalNotice, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(exchLegalNotice.getText(), "Connect for Health Colorado Login Notice: This system contains U.S. Government information. By accessing and using this system you are consenting to system monitoring for law enforcement and other purposes. Unauthorized use of or access to this computer system may subject you to State and Federal criminal prosecution as well as civil penalties.");
                softAssert.assertEquals(cocoLegalNotice.getText(), "Colorado Connect Login Notice: By accessing and using this system you are consenting to system monitoring for security purposes. Unauthorized use of or access to this computer system may subject you to State and Federal criminal prosecution as well as civil penalties.");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(exchLegalNotice.getText(), "Aviso de acceso de Connect for Health Colorado: Este sistema contiene informaci\u00F3n del gobierno de Estados Unidos. Al acceder y utilizar este sistema, usted acepta la supervisi\u00F3n del sistema con fines de aplicaci\u00F3n de la ley y otros prop\u00F3sitos. El uso no autorizado de este sistema inform\u00E1tico o el acceso no autorizado a \u00E9l est\u00E1 sujeto a la interposici\u00F3n de acciones penales estatales o federales, as\u00ED como a la aplicaci\u00F3n de sanciones civiles.");
                softAssert.assertEquals(cocoLegalNotice.getText(), "Aviso de acceso de Colorado Connect: Al acceder y utilizar este sistema, usted acepta la supervisi\u00F3n del sistema con fines de seguridad. El uso no autorizado de este sistema inform\u00E1tico o el acceso no autorizado a \u00E9l puede sujetarlo a usted a la interposici\u00F3n de acciones penales estatales o federales, as\u00ED como a la aplicaci\u00F3n de sanciones civiles.");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }

    }

    public void verifyExpiredPasswordErrorMessage(String language) {
        basicActions.waitForElementToBePresent(passwordExpiredText, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(passwordExpiredText.getText(), "PASSWORD EXPIRED");
                softAssert.assertEquals(passwordExpiredErrorText.getText(), "Your password has expired. In order to reset it, please click on the forgot password link below");

                break;
            case "Spanish":
                softAssert.assertEquals(passwordExpiredText.getText(), "CONTRASE\u00D1A VENCIDA");
                softAssert.assertEquals(passwordExpiredErrorText.getText(), "Su contrase\u00F1a ha vencido. Para reestablecerla, haga clic en el enlace 'olvid\u00E9 mi contrase\u00F1a' de abajo.");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }


    public void ShowButtonIsDisplayedAndEnabled(String pageTitle) {
        switch (pageTitle) {
            case "login portal":
                basicActions.waitForElementToBePresent(showHidePW, 10);
                softAssert.assertEquals(showHidePW.getText(), "Show");
                softAssert.assertTrue(showHidePW.isEnabled(), "show hide btn is enabled");
                break;
            case "create account":
                basicActions.waitForElementToBePresent(showHidePWCreateAccount, 10);
                softAssert.assertEquals(showHidePWCreateAccount.getText(), "Show");
                softAssert.assertTrue(showHidePWCreateAccount.isEnabled(), "show hide btn is enabled");
                softAssert.assertAll();
                break;
        }
    }

    public void enterValidCredentialsWithoutSignIn(String STGUsername, String STGPW, String QAUsername, String QAPW) {
        basicActions.waitForElementToBePresent(username, 10);
        if (SharedData.getEnv().equals("staging")) {
            username.sendKeys(STGUsername);
            password.sendKeys(STGPW);
        } else {
            username.sendKeys(QAUsername);
            password.sendKeys(QAPW);
        }
    }

    public void ValidateWhenShowPasswordIsDisplayedTheCodeIsEncrypted(String showPW, String titlePage) {
        switch (titlePage) {
            case "login page":
                showPasswordLoginPage(showPW);
                break;
            case "create account":
                showPasswordAccountCreationPage(showPW);
                break;

        }

    }

    public void showPasswordAccountCreationPage(String showPW) {
        basicActions.waitForElementToBePresent(showHidePWCreateAccount, 10);
        WebElement passwordText = basicActions.getDriver().findElement(By.xpath("//input[@id='password']"));
        switch (showHidePWCreateAccount.getText()) {
            case "Show":
                softAssert.assertEquals(passwordText.getAttribute("type"), "password");
                break;
            case "Hide":
                softAssert.assertEquals(passwordText.getAttribute("type"), "text");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + showPW);
        }
        softAssert.assertAll();
    }

    public void showPasswordLoginPage(String showPW) {
        basicActions.waitForElementToBePresent(showHidePW, 10);
        WebElement passwordText = basicActions.getDriver().findElement(By.xpath("//input[@id='password']"));
        switch (showHidePW.getText()) {
            case "Show":
                softAssert.assertEquals(passwordText.getAttribute("type"), "password");
                break;
            case "Hide":
                softAssert.assertEquals(passwordText.getAttribute("type"), "text");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + showPW);
        }
        softAssert.assertAll();
    }

    public void ClickOnShowButton(String pageTitle) {
        switch (pageTitle) {
            case "login page":
                basicActions.waitForElementToBePresent(showHidePW, 10);
                showHidePW.click();
                break;
            case "create account":
                basicActions.waitForElementToBePresent(showHidePWCreateAccount, 10);
                showHidePWCreateAccount.click();
                break;

        }
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
}