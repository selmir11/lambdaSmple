package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
import com.c4hco.test.automation.utils.Utils;
import com.c4hco.test.automation.utils.WebDriverManager;
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

    private BasicActions basicActions;
    private Utils utils = new Utils(WebDriverManager.getDriver());


    public LoginPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage(String appType) {
        basicActions.getDriver().get(utils.getBaseLoginUrl(appType));
    }

    public void clickCreateAccount() {
        createAccountLink.click();
    }

    public void logInWithValidCredentials() {
            username.sendKeys(SharedData.getEmailId());
            password.sendKeys(SharedData.getPassword());
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

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

}