package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class FindExpertHelpPage {
    private BasicActions basicActions;

    public FindExpertHelpPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(id = "contineOwn-button")
    WebElement continueOnMyOwnButton;

    public void clickContinueOnOwnButton() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(continueOnMyOwnButton,10));
        softAssert.assertAll();
        continueOnMyOwnButton.click();
    }
    @FindBy(id = "BP-Findexperthelpnearyou-Back")
    private WebElement backButton;

    public void clickBackButton() {
        basicActions.waitForElementToBeClickable(backButton, 5);
        backButton.click();
    }
}
