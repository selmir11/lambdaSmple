package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AdminPortalAccountAccessPage {

    public BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public AdminPortalAccountAccessPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//p[@id='account-status']")
    WebElement accountStatus;

    @FindBy(xpath = "//div[@id='no-option-status']")
    WebElement statusMessage;


    public void validateAccountStatus(String status) {
        basicActions.waitForElementToBePresent(accountStatus, 60);
        basicActions.waitForElementToBePresent(statusMessage, 60);

        String input = accountStatus.getText().trim();

        String acctStatus = input.replaceFirst("(?i)^account\\s*status\\s*:\\s*", "").trim();

        String expectedMessage = "The Account is in a " + acctStatus + " status, please contact Production Support for additional information.";

        String actualStatus = accountStatus.getText().trim();
        String actualMessage = statusMessage.getText().trim();

        actualStatus = actualStatus.replaceFirst("(?i)^account\\s*status\\s*:\\s*", "").trim();
        String normalizedExpectedStatus = status.trim().toUpperCase();

        softAssert.assertEquals(actualStatus.toUpperCase(), normalizedExpectedStatus,
                "Expected account status to be '" + normalizedExpectedStatus + "', but found '" + actualStatus + "'.");

        softAssert.assertEquals(actualMessage.toLowerCase(), expectedMessage.toLowerCase(),
                "Expected account status message to be '" + expectedMessage + "', but found '" + actualMessage + "'.");

        softAssert.assertAll();
    }

    }







