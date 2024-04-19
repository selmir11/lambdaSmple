package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageWhoHelpsYouPage {

    private BasicActions basicActions;

    public ManageWhoHelpsYouPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "contineOwn-button")
    WebElement continueOnMyOwnButton;

    @FindBy(id = "BP-Findexperthelpnearyou-Back")
    WebElement backButton;


    public void clickContinueOnOwnButton() {
        basicActions.waitForElementToBeClickable(continueOnMyOwnButton, 50);
        basicActions.scrollToElement(continueOnMyOwnButton);
        continueOnMyOwnButton.click();
    }

    public void clickBackButton() {
        basicActions.waitForElementToBeClickable(backButton, 5);
        backButton.click();
    }

}
