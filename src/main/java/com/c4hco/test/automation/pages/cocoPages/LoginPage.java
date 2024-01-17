package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.c4hco.test.automation.pages.cocoPages.CreateAccountPage.*;


public class LoginPage {

    @FindBy(id = "create-account-link")
    WebElement createAccountLink;

    @FindBy(id = "email")
    WebElement txtSiEmailUsername;

    @FindBy(id = "password")
    WebElement txtSiPassword;

    @FindBy(id = "main-sign-in")
    WebElement btnSiSignIn;


    private BasicActions basicActions;
    private Utils utils = new Utils();
    private String env = ApplicationProperties.getInstance().getProperty("env");

    public LoginPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage() {
        basicActions.getDriver().get(utils.getBaseLoginUrl(env));
    }

    public void validateLoginPage() {
        Assert.assertTrue("Url doesn't have createAccount", basicActions.getCurrentUrl().contains("login"));
    }

    public void clickCreateAccount() {
        // enhancement needed
        System.out.println("click create account");
        if (!basicActions.getUrlWithWait("login-portal/login", 10).isEmpty()) {
            createAccountLink.click();
        } else {
            Assert.assertTrue("The login page did not open", false);
        }
    }

    public void signInWithValidCredentials() {
        System.out.println("sign in");
        if (!basicActions.getUrlWithWait("login-portal/login", 10).isEmpty()) {
            txtSiEmailUsername.sendKeys(strEmail);
            txtSiPassword.sendKeys(strPassword);
            btnSiSignIn.click();
        } else {
            Assert.assertTrue("The login page did not open", false);
        }
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

}