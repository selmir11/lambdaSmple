package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ErrorProcessingRequestBannerPage {

    @FindBy(css = ".banner-error-message")
    WebElement bannerErrorTxt;

    @FindBy(css = ".banner-error-tracking-id.ng-star-inserted")
    WebElement bannerTransactionIdTxt;


    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;
    public ErrorProcessingRequestBannerPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void verifyErrorBanner() {
        basicActions.waitForElementToBePresent(bannerErrorTxt, 15);
        softAssert.assertEquals(bannerErrorTxt.getText(), "There was an error processing your request. Please refresh the page and try again.");
        String transactionText = bannerTransactionIdTxt.getText();
        String pattern = "^Transaction ID: [a-zA-Z0-9]{32}$";
        softAssert.assertTrue(transactionText.matches(pattern), "Transaction ID format is incorrect. Found: " + transactionText);
        softAssert.assertAll();
    }

    public void verifyNoErrorMessage() {
        Assert.assertTrue(basicActions.waitForElementToDisappear(bannerErrorTxt, 30), "Error is displayed");
    }
}
