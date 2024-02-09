package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.*;


import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.emailId;
import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.pswrd;
import static com.c4hco.test.automation.utils.Constants.*;

public class LoginPage {
    CreateAccountPage createAccountPage = new CreateAccountPage();
    @FindBy(id = "create-account-link")
    WebElement createAccountLink;

    @FindBy(id = "email")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "main-sign-in")
    WebElement signInButton;

    @FindBy(id = "email")
    public WebElement usernameAdmin;

    @FindBy(id = "password")
    public WebElement passwordAdmin;

    @FindBy(id = "main-sign-in")
    public WebElement signAdmin;



    private BasicActions basicActions;
    private Utils utils = new Utils();


    public LoginPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public LoginPage openPage(String appType) {
        basicActions.getDriver().get(utils.getBaseLoginUrl(appType));
        return new LoginPage();
    }

    public void refreshPage(){
        basicActions.getDriver().navigate().refresh();
    }



    public void clickCreateAccount() {

        basicActions.implicitWait(2);
        createAccountLink.click();

    }

    public void logInWithValidCredentials() {
        // make this re-usable method - accept parameters email and password- enahancement - TO DO
        // use getters/setter or world to import data rather than direct imports
            username.sendKeys(emailId);
            password.sendKeys(pswrd);
            signInButton.click();
    }

    public void loginAsAnAdminUser(){
        basicActions.refreshPage();
        basicActions.waitForElementToBePresent(usernameAdmin,10 );
        usernameAdmin.sendKeys("C4test.aduser123@gmail.com");
        passwordAdmin.sendKeys("ALaska12!");
        signAdmin.click();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line



}