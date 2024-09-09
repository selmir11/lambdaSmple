package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
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

    @FindBy(css = "#loader-icon .fa-spinner")
    WebElement spinner;

    @FindBy(css = "#SOL-PayNow-AllDone-Indv")
    WebElement allDone;

    @FindBy(id = "SOL-PayNow-AllDone-Obo")
    WebElement allDoneObo;

    @FindBy(css = "#SOL-PayNow-PayNow-Medical-0")
    WebElement PayNowButton;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "password-button")
    WebElement continueButton;


    public void clickAllDone(){
        basicActions.waitForElementToDisappear(spinner, 30);;
        basicActions.waitForElementToBePresent( allDone,40 );
        basicActions.scrollToElement( allDone );
        basicActions.clickElementWithRetries(allDone, 30);
    }

    public void clickAllDoneObo(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent( allDoneObo,30 );
        basicActions.scrollToElement( allDoneObo );
        basicActions.clickElementWithRetries(allDoneObo, 30);
    }
    public void clickPayNowButton() {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(PayNowButton, 40);
        basicActions.scrollToElement(PayNowButton);
        basicActions.clickElementWithRetries(PayNowButton, 30);
    }
    public void password() {
        basicActions.waitForElementToBePresent(password, 10);
        String pswd = SharedData.getPrimaryMember().getPassword();
        basicActions.waitForElementToBePresent(password, 10);
        password.sendKeys(pswd);
        System.out.println("Password::" + pswd);
    }

    public void clickContinue(){
        basicActions.waitForElementToBePresent(continueButton, 10);
        continueButton.click();
    }
}

