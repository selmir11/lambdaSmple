package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.HeaderAndFooterPage;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class UploadDocumentsRIDPPage {
    private BasicActions basicActions;
    private HeaderAndFooterPage headerandFooterpage;

    SoftAssert softAssert = new SoftAssert();

    public UploadDocumentsRIDPPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        headerandFooterpage = new HeaderAndFooterPage(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".back-button-link")
    WebElement backButton;

    @FindBy(xpath = "//a[contains(text(),'Upload Documents')]")
    WebElement uploadDocumentsButton;

    @FindBy(xpath = "//input[@name='checkStatus']")
    WebElement checkStatusbtn;

    @FindBy(id = "ridpErrorContainer")
    WebElement errorMessage;

    public void clickBackButton() {
        backButton.click();
    }

    public void clickUploadDocumentsButton() {
        uploadDocumentsButton.click();
    }

    public void clickStatusButton() {
        basicActions.waitForElementToBePresent(checkStatusbtn,10);
        basicActions.scrollToElement(checkStatusbtn);
        checkStatusbtn.click();
    }

    public void validateErrorMessage(String expectedMessage, String language){
        basicActions.waitForElementToBePresent(errorMessage,10);
        headerandFooterpage.changeLanguage(language+" NonElmo");
        basicActions.waitForElementToBePresent(errorMessage,10);
        softAssert.assertEquals(errorMessage.getText(),expectedMessage);
        softAssert.assertAll();
    }

}
