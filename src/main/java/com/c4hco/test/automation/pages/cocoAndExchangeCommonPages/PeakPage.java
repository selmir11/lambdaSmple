package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PeakPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public PeakPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='inputLabel-89']")
    WebElement peakUsername;

    @FindBy(xpath = "//input[@id='input-93']")
    WebElement peakPassword;

    @FindBy(xpath = "//button[@name='SignInButton']")
    WebElement peakSignInButton;

    @FindBy(xpath = "//div[@class='inner-wrapper']//div")
    List<WebElement> peakSkeletonErrorMessage;

    public void clickOkOnThePeakAlertWindow() {
        Alert peakAlertWindow = basicActions.getDriver().switchTo().alert();
        peakAlertWindow.accept();
    }

    public void loginPeakUser(String username, String password) {
        basicActions.waitForElementToBePresent(peakUsername, 20);
        peakUsername.sendKeys(username);
        basicActions.waitForElementToBePresent(peakPassword, 20);
        peakPassword.sendKeys(password);
        peakSignInButton.click();
    }

    public void validatePeakSkeletonErrorMessage() {
        basicActions.waitForElementListToBePresentWithRetries(peakSkeletonErrorMessage, 20);
        softAssert.assertEquals(peakSkeletonErrorMessage.get(0).getText(), "We\u2019re sorry, but there was an error,");
        softAssert.assertEquals(peakSkeletonErrorMessage.get(1).getText(), "and we cannot sign you into Connect for Health Colorado.");
        softAssert.assertEquals(peakSkeletonErrorMessage.get(2).getText(), "Please call us at 855-752-6749.");
        softAssert.assertAll();
    }
}
