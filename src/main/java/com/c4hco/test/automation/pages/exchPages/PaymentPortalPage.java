package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
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

    @FindBy(css = "#loader-icon .fa-spinner")
    WebElement spinner;

    @FindBy(css = "#SOL-PayNow-AllDone-Indv")
    WebElement allDone;


    public void clickAllDone(){
        basicActions.waitForElementToDisappear(spinner, 20);;
        basicActions.waitForElementToBePresent( allDone,30 );
        basicActions.scrollToElement( allDone );
        allDone.click();
    }
}

