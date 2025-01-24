package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadDocumentsRIDPPage {
    private BasicActions basicActions;

    public UploadDocumentsRIDPPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".back-button-link")
    WebElement backButton;

    @FindBy(xpath = "//a[contains(text(),'Upload Documents')]")
    WebElement uploadDocumentsButton;

    public void clickBackButton() {
        backButton.click();
    }

    public void clickUploadDocumentsButton() {
        uploadDocumentsButton.click();
    }

}
