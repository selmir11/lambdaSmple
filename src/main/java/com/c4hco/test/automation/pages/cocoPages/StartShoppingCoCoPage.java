package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class StartShoppingCoCoPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();


    public StartShoppingCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-StartShop-Continue")
    WebElement btnContinue;

    @FindBy(css = ".container .radio-button")
    List<WebElement> btnNoAndYes;

    @FindBy(id = "SOL-StartShop-SaveAndExit")
    WebElement saveAndExitButton;

    @FindBy(css = ".container .header-1")
    WebElement headerText;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> bodyText;

    public void clickBtnSaveNExit(){
        saveAndExitButton.click();
    }
    public void iclickContinue(){
        basicActions.waitForElementListToBePresent(btnNoAndYes,10);
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnContinue, 30));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btnContinue);
        btnContinue.click();
    }

}
