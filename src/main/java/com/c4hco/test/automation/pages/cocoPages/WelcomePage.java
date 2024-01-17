package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.c4hco.test.automation.pages.cocoPages.CreateAccountPage.strEmail;
import static com.c4hco.test.automation.pages.cocoPages.CreateAccountPage.strPassword;

public class WelcomePage {

    @FindBy(id = "ELIG-WelcomePage-ApplyForInsurance-2024")
    WebElement btnApplyForYear_2024;


    private BasicActions basicActions;
    public WelcomePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage(){
        basicActions.getDriver().get("https://qa-aws.connectforhealthco.com/coco/WelcomePortal/welcome");
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void validateWelcomePage(){
        System.out.println("validate welcome");
        basicActions.getUrlWithWait("/coco/WelcomePortal", 10);
        Assert.assertTrue("Url doesn't have welcome", basicActions.getCurrentUrl().contains("welcome"));
    }
}
