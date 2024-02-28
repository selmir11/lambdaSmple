package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage {
    @FindBy(name = "applyForCurrentYear")
    WebElement btnApplyForCurrentYear;

    private BasicActions basicActions;

    public AccountOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void clickApplyForCurrentYear(){
        basicActions.waitForElementToBeClickable(btnApplyForCurrentYear,10);
        btnApplyForCurrentYear.click();
    }

    // ================VALIDATION METHODS================//

}
