package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
    @FindBy(xpath = "//button[contains(@class,'back-to-welcome')]")
    public WebElement backToWelcomeButton;

    private BasicActions basicActions;
    public MyProfilePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }






    public void searchIndividualAccountAdminPortal() {
        accountIndividual.sendKeys(SharedData.getIndividualAccount());
        searchIndividualButton.click();
    }
}
