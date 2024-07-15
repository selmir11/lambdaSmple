package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PaymentPortalPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public PaymentPortalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="SOL-PayNow-AllDone-Indv")
    WebElement allDoneBtn;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;


    public void clickAllDone(){
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementToBePresent(allDoneBtn, 30);
        allDoneBtn.click();
    }
}

