package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class InitialPaymentPage {

    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public InitialPaymentPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="SOL-InitialPayment-MakePayment")
    List<WebElement> makePaymentBtn;

    @FindBy(id = "SOL-InitialPayment-Continue")
    WebElement continueBtn;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id="SOL-FirstMonthPayment-Title")
    WebElement headerText;

    @FindBy(id="SOL-FirstMonthPayment-ByClickingMakePaymentButton")
    WebElement headerContentText;

    @FindBy(xpath = "//table[@class='table table-border'] //th")
    List<WebElement> initialPaymentTable;

    @FindBy(css=".bottom-text")
    WebElement bottomText;

    @FindBy(id = "SOL-InitialPayment-GoBack")
    WebElement goBackbtn;

    // TO DO: create a re-usable method for clicking on make payment button for all the plans.
    public void selectMakePaymentButton(){
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementListToBePresent(makePaymentBtn,20);
        makePaymentBtn.get(0).click();
    }

    public void clickSecondMakePaymentButton(){
        basicActions.waitForElementListToBePresent(makePaymentBtn,20);
        makePaymentBtn.stream().findFirst().ifPresent(WebElement::click);
    }

    public void clickContinue(){
        basicActions.waitForElementToBeClickable(continueBtn, 10);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();
    }

    public void ValidateInitialPaymentPageText(List<String> data) {
        basicActions.waitForElementToBePresent(headerText, 20);
        softAssert.assertEquals(headerText.getText(), data.get(0));
        softAssert.assertEquals(headerContentText.getText(), data.get(1));
        softAssert.assertEquals(initialPaymentTable.get(0).getText(), data.get(2));
        softAssert.assertEquals(initialPaymentTable.get(1).getText(), data.get(3));
        softAssert.assertEquals(initialPaymentTable.get(2).getText(), data.get(4));
        softAssert.assertEquals(makePaymentBtn.get(0).getText(), data.get(5));
        softAssert.assertEquals(makePaymentBtn.get(1).getText(), data.get(5));
        softAssert.assertEquals(bottomText.getText(), data.get(6));
        softAssert.assertEquals(goBackbtn.getText(), data.get(7));
        softAssert.assertAll();
    }

    public void ValidateContinueButtonText() {
        basicActions.waitForElementToBePresent(headerText, 20);
        softAssert.assertEquals(continueBtn.getText(),"Continue");
        softAssert.assertAll();
    }
}
