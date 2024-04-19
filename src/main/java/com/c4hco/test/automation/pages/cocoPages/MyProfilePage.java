package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyProfilePage {
    @FindBy(xpath = "//button[contains(@class,'back-to-welcome')]")
    public WebElement backToWelcomeButton;

    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> MyProfileButtonCoCo; /// Go back, Make changes, Save buttons

    private BasicActions basicActions;
    public MyProfilePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }

    public void clickMakeChangesButtonCoCo() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 60);
        MyProfileButtonCoCo.get(1).click();
    }

    public void clickSaveButtonCoCo() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();

    }

}
