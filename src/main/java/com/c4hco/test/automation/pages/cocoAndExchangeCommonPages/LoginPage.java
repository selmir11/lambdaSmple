package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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
        PolicyMember subscriber = SharedData.getSubscriber();
            username.sendKeys(subscriber.getEmailId());
            password.sendKeys(subscriber.getPassword());
            signInButton.click();
    }

    public void loginAsAnAdminUser(){
        // TO-DO:: Get the credentials from a different file
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        usernameAdmin.sendKeys("C4test.aduser123@gmail.com");
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        passwordAdmin.sendKeys("ALaska12!");
        signAdmin.click();
    }

    public void loginAsBrokerUser(){
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        usernameAdmin.sendKeys("soukainatesting+agencyQA@gmail.com");
        basicActions.waitForElementToBePresent(usernameAdmin,20 );
        passwordAdmin.sendKeys("ALaska16!");
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


    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

}