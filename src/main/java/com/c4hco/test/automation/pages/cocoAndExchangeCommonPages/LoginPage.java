package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.dbUtils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.*;

public class LoginPage {

    @FindBy(id = "create-account-link")
    WebElement createAccountLink;

    @FindBy(id = "email")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "main-sign-in")
    WebElement signInButton;


    private BasicActions basicActions;
    private Utils utils = new Utils();
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private String env = ApplicationProperties.getInstance().getProperty("env");

    public LoginPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public LoginPage openPage() {
        basicActions.getDriver().get(utils.getBaseLoginUrl(env));
        return new LoginPage();
    }

    public void clickCreateAccount() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(createAccountLink, 60));
        createAccountLink.click();
    }

    public void logInWithValidCredentials() {
        // make this re-usable method - accept parameters email and password- enahancement - TO DO
        // use getters/setter or world to import data rather than direct imports
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(username, 60));
            username.sendKeys(emailId);
            password.sendKeys(pswrd);
            signInButton.click();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void validateLoginPage() {
        basicActions.getUrlWithWait("/login-portal/login", 10);
        Assert.assertTrue("Login page did not load", basicActions.getCurrentUrl().contains("login"));
    }

}