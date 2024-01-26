package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    @FindBy(id = "ELIG-WelcomePage-ApplyForInsurance-2024")
    WebElement applyFor2024Button;


    private BasicActions basicActions;
    public WelcomePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void validateWelcomePage(){
        basicActions.getUrlWithWait("/coco/WelcomePortal", 10);
        Assert.assertTrue("Welcome page is not loaded", basicActions.getCurrentUrl().contains("welcome"));
    }
}
