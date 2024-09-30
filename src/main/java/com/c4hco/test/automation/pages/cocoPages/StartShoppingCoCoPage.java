package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
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

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void clickBtnSaveNExit() {
        saveAndExitButton.click();
    }

    public void iclickContinue() {
        basicActions.waitForElementToDisappear( spinner,40 );
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnContinue, 30));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btnContinue);
        btnContinue.click();
    }

    public void tobaccoPage(String tobaccoUsageDetails) {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(btnNoAndYes, 10);

        String[] NameDetails = tobaccoUsageDetails.split(",");

        for (String Name : NameDetails) {
            WebElement tobaccoUsageYes = basicActions.getDriver().findElement(By.xpath("(//Strong[contains(text(),'" + Name + "')]/parent::p/following-sibling::label)[1]"));
            tobaccoUsageYes.click();
        }

    }

}
