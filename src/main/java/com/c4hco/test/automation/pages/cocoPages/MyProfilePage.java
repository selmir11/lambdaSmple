package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfilePage {
    @FindBy(xpath = "//button[contains(@class,'back-to-welcome')]")
    public WebElement backToWelcomeButton;

    private BasicActions basicActions;
    public MyProfilePage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }
}
