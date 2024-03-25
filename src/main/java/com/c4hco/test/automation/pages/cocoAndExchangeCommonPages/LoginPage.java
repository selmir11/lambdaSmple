package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.Utils;
import com.c4hco.test.automation.utils.WebDriverManager;
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

    @FindBy(css = ".font-weight-bold")
    WebElement iForgotUsernameandPassword;

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
        MemberDetails subscriber = SharedData.getPrimaryMember();
        System.out.println("Email and pwd::"+subscriber.getEmailId()+"::"+subscriber.getPassword());
            username.sendKeys(subscriber.getEmailId());
            password.sendKeys(subscriber.getPassword());
            signInButton.click();
    }

    public void loginAsAnAdminUser(){
        // TO-DO:: Get the credentials from a different file
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        usernameAdmin.sendKeys("C4test.aduser123@gmail.com");
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        passwordAdmin.sendKeys("ALaska13!");
        signAdmin.click();
    }

    public void loginAsBrokerUser(String brokerUser,String Password){
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        usernameAdmin.sendKeys(brokerUser);
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        passwordAdmin.sendKeys(Password);
        signAdmin.click();
    }

    public void clickForgotPassword(){
        basicActions.waitForElementToBePresent(forgotPassword,20 );
        forgotPassword.click();
    }
    public void clickForgotUsername(){
        basicActions.waitForElementToBePresent(forgotUsername,20 );
        forgotUsername.click();
    }

    public void clickSignIn() {
        signAdmin.click();
    }
    public void usernameRequiredMessage(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(usernameError, 20));
        softAssert.assertAll();
    }

    public void passwordRequiredMessage(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(passwordError, 20));
        softAssert.assertAll();
    }

    public void usernameandpasswordRequiredMessage(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(iForgotUsernameandPassword, 20));
        softAssert.assertAll();
    }
}

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
