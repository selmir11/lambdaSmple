package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage {

    @FindBy(id = "ELIG-WelcomePage-ApplyForInsurance-2024")
    private WebElement applyFor2024Button;

    @FindBy(id = "ELIG-WelcomePage-MyProfile")
    private WebElement myProfileButton;

    private BasicActions basicActions;
    public WelcomePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickApply2024CoCo() {
        basicActions.waitForElementToBeClickable(applyFor2024Button, 5);
        applyFor2024Button.click(); }
    public void clickMyProfileButton() {
        basicActions.waitForElementToBeClickable(myProfileButton, 5);
        myProfileButton.click(); }

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


