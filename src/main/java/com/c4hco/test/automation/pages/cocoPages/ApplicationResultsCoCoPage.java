package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationResultsCoCoPage {
    private BasicActions basicActions;

    public ApplicationResultsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-MemberPlanInfo-SaveAndContinue")
    public WebElement continueButton;

    @FindBy(id = "ELIG-NoApplication-BackToWelcomePage")
    public WebElement backToWelcomeButton;

    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }

    public void continueWithApplication()  {
        basicActions.waitForElementToBeClickable(continueButton, 20);
        continueButton.click();
    }
}
