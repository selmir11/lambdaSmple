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

public class LoginPage {

    @FindBy(id = "create-account-link")
    WebElement createAccountLink;


    private BasicActions basicActions;
    private Utils utils = new Utils();
    private String env = ApplicationProperties.getInstance().getProperty("env");
    public LoginPage(){
          this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage(){
        basicActions.getDriver().get(utils.getBaseLoginUrl(env));
    }

    public void clickCreateAccount(){
        // enhancement needed
        System.out.println("click create account");
        if(!basicActions.getUrlWithWait("login-portal/login", 10).isEmpty()){
            createAccountLink.click();
        }
        else {
            Assert.assertTrue("The login page did not open", false);
        }
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
}
