package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages;
import com.c4hco.test.automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage {

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "create-account-link")
    WebElement createAccountLink;


    @FindBy(xpath = "//input[@id='email']")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "main-sign-in")
    WebElement signInButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement usernameAdmin;

    @FindBy(id = "password")
    WebElement passwordAdmin;

    @FindBy(id = "main-sign-in")
    WebElement signAdmin;

    @FindBy(id = "sign-in-peak")
    WebElement signInWithPeak;

    @FindBy(xpath = "//a[text()=' password']")
    WebElement forgotPassword;

    @FindBy(xpath = "//a[text()='username']")
    WebElement forgotUsername;

    @FindBy(id = "username_mf_error")
    WebElement usernameError;

    @FindBy(id = "password_mf_error")
    WebElement passwordError;

    @FindBy(css = ".fw-bold")
    WebElement iForgotUsernameandPassword;
    @FindBy(id = "title")
    WebElement loginPageTitle;
    @FindBy(xpath = "//label[@for='email']")
    WebElement usernameText;
    @FindBy(xpath = "//label[@for='password-label']")
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
    @FindBy(xpath = "//div[normalize-space()='Access Denied']")
    WebElement accessDenied;
    @FindBy(css = ".yellow.warning.sign.icon")
    WebElement warningIcon;

    @FindBy(xpath = "//div[@class='help-block error-label mb-3 form-group-custom mb-0 ng-star-inserted']")
    WebElement lockedOutMessage;
    @FindBy(xpath = "//div[@class='help-block error-label mb-3 form-group-custom mb-0 ng-star-inserted']")
    WebElement invalidLoginMessage;
    @FindBy(id = "user-type-selection")
    WebElement userIcon;
    @FindBy(xpath = "//div[@id='inactivityDialog']//span")
    WebElement automaticallyTimeOut;
    @FindBy(xpath = "//a[@id='user-type-selection']//p")
    List<WebElement> userIconDropdown;
    @FindBy(id = "globe-image")
    WebElement languageDrpSignIn;
    @FindBy(id = "eng")
    WebElement languageDrpOptionSignInEnglish;
    @FindBy(id = "esp")
    WebElement languageDrpOptionSignInSpanish;

    private BasicActions basicActions;
    private Utils utils = new Utils(WebDriverManager.getDriver());

    public LoginPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage(String portalType) {
        basicActions.getDriver().get(utils.getBaseLoginUrl(portalType));
        basicActions.refreshPage();
    }

    public void clickCreateAccount() {
        basicActions.waitForElementToBePresentWithRetries(createAccountLink, 10);
        createAccountLink.click();
    }

    public void loginAsBrokerUser(String brokerUser, String Password) {
        basicActions.waitForElementToBePresent(usernameAdmin, 20);
        usernameAdmin.sendKeys(brokerUser);
        basicActions.waitForElementToBePresent(usernameAdmin, 20);
        passwordAdmin.sendKeys(Password);
        signAdmin.click();
    }

    public void loginAsBrokerUserAnyEnv(String stgUser, String stgPW, String qaUser, String qaPW) {
        basicActions.waitForElementToBePresentWithRetries(signInButton, 40);
            username.sendKeys(stgUser);
            password.sendKeys(stgPW);
        signInButton.click();
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

    public void clickSignInWithPeak() {
        basicActions.waitForElementToBePresentWithRetries(signInWithPeak, 20);
        signInWithPeak.click();
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
            case "login portal Spanish":
                basicActions.waitForElementToBePresent(showHidePW, 10);
                softAssert.assertEquals(showHidePW.getText(), "MOSTRAR");
                softAssert.assertTrue(showHidePW.isEnabled(), "show hide btn is enabled");
                break;
            case "create account":
                basicActions.waitForElementToBePresent(showHidePWCreateAccount, 10);
                softAssert.assertEquals(showHidePWCreateAccount.getText(), "Show");
                softAssert.assertTrue(showHidePWCreateAccount.isEnabled(), "show hide btn is enabled");
                break;
            case "create account Spanish":
                basicActions.waitForElementToBePresent(showHidePWCreateAccount, 10);
                softAssert.assertEquals(showHidePWCreateAccount.getText(), "MOSTRAR");
                softAssert.assertTrue(showHidePWCreateAccount.isEnabled(), "show hide btn is enabled");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + pageTitle);
        }
        softAssert.assertAll();
    }



    public void ValidateWhenShowPasswordIsDisplayedTheCodeIsEncrypted(String showPW, String titlePage) {
        switch (titlePage) {
            case "login page":
                showPasswordLoginPage(showPW);
                break;
            case "create account":
                showPasswordAccountCreationPage(showPW);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + showPW + titlePage);
        }
        softAssert.assertAll();

    }

    public void showPasswordAccountCreationPage(String showPW) {
        basicActions.waitForElementToBePresent(showHidePWCreateAccount, 10);
        WebElement passwordText = basicActions.getDriver().findElement(By.xpath("//input[@id='password']"));
        switch (showHidePWCreateAccount.getText()) {
            case "Show":
            case "MOSTRAR":
                softAssert.assertEquals(passwordText.getAttribute("type"), "password");
                break;
            case "Hide":
            case "OCULTAR":
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
            case "MOSTRAR":
                softAssert.assertEquals(passwordText.getAttribute("type"), "password");
                break;
            case "Hide":
            case "OCULTAR":
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
            default:
                throw new IllegalArgumentException("Invalid option: " + pageTitle);
        }
    }


    public void validateLockedOutMessage() {
        basicActions.waitForElementToBePresent(createAccountLink, 100);
        basicActions.waitForElementToBePresent(lockedOutMessage, 100);
        softAssert.assertEquals(lockedOutMessage.getText(), "Your account is locked");
        softAssert.assertTrue(lockedOutMessage.isDisplayed());
        softAssert.assertAll();
    }



    public void verifyInvalidLoginErrorMessage() {
        basicActions.waitForElementToBePresent(createAccountLink, 100);

        basicActions.waitForElementToBePresentWithRetries(invalidLoginMessage, 100);
        softAssert.assertEquals(invalidLoginMessage.getText(), "Invalid login and/or password");
        softAssert.assertTrue(invalidLoginMessage.isDisplayed());
        softAssert.assertAll();
    }

    public void clickUserTypeIconInTheLoginPage(String portal) {
        basicActions.waitForElementToBePresent(userIcon,30);
        userIcon.click();

        List<String> indUserOptions = Arrays.asList("Broker Portal", "Program Manager Account", "Admin Portal");
        List<String> indUserOptionsSP = Arrays.asList("Portal del agente","Cuenta del gerente de programa","Portal del administrador");


        List<String> existingOptions = new ArrayList<>();
        for (WebElement userIconeOption : userIconDropdown) {
            String text = userIconeOption.getText();
            existingOptions.add(text);
        }
        switch (portal){
            case "Ind Portal":
              softAssert.assertEquals(existingOptions,indUserOptions);
              break;
            case "Ind Portal SP":
                softAssert.assertEquals(existingOptions,indUserOptionsSP);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + portal);
        }
        softAssert.assertAll();
    }

    public void clickTheOptionRequested(String userOption) {
        for (WebElement userIconeOption : userIconDropdown) {
            String text = userIconeOption.getText();
            if (text.equals(userOption)){
                userIconeOption.click();
                break;
            }
        }
    }




    public void validateTheErrorMsgUsernameAndPasswordRequiredIn(String language) {
        basicActions.waitForElementToBePresentWithRetries(usernameError,60);
        basicActions.waitForElementToBePresentWithRetries(passwordError,60);
        switch (language){
            case "English":
                softAssert.assertEquals(usernameError.getText(),"Username is required");
                softAssert.assertEquals(passwordError.getText(),"Password is required");
            break;
            case "Spanish":
                softAssert.assertEquals(usernameError.getText(),"Se requiere su nombre de usuario");
                softAssert.assertEquals(passwordError.getText(),"Se requiere su contrase\u00F1a");
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);

        }
        softAssert.assertAll();
    }

    public void validateTheAutomaticallySignedOutMessageAppearIn(String language) {
        basicActions.waitForElementToBePresent(automaticallyTimeOut,30);
        if (language.equals("English")){
            softAssert.assertEquals(automaticallyTimeOut.getText(),"You have been automatically signed out of your account due to inactivity");
        }else{
            softAssert.assertEquals(automaticallyTimeOut.getText(),"La sesi\u00F3n de su cuenta se cerr\u00F3 de forma autom\u00E1tica por inactividad.");
        }
        softAssert.assertAll();
    }


    public void changeLanguage(String language) {
//        "English" and "Spanish" for CoCo and Exch Elmo pages
////        Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "English Login" and "Spanish Login" is for the Login page
//        "English ExpertHelp" and "Spanish ExpertHelp" is for the following pages: Create Account, Manage who helps you/Find Expert Help

        basicActions.wait(250);
        switch (language) {
            case "English Login":
                basicActions.waitForElementToBePresent(languageDrpSignIn, 60);
                languageDrpSignIn.click();
                basicActions.waitForElementToBePresent(languageDrpOptionSignInEnglish, 60);
                languageDrpOptionSignInEnglish.click();
                break;
            case "Spanish Login":
                basicActions.waitForElementToBePresent(languageDrpSignIn, 60);
                languageDrpSignIn.click();
                basicActions.waitForElementToBePresent(languageDrpOptionSignInSpanish, 60);
                languageDrpOptionSignInSpanish.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        basicActions.wait(50);
    }

}