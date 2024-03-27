package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class YourClientsPage {
    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public YourClientsPage(WebDriver webDriver) {
       basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
   @FindBy(id = "print-link")
    WebElement printBtn;
    @FindBy(id = "ngb-nav-0")
    WebElement connectForHealthColoradoTab;
    @FindBy(id = "ngb-nav-1")
    WebElement coloradoConnectTab;


    public void clickUserTab(String userTab) {
        switch (userTab){
            case "connect For Health Colorado" :
                basicActions.waitForElementToBePresent(connectForHealthColoradoTab,10);
                connectForHealthColoradoTab.click();
            break;
                case "colorado Connect" :
                basicActions.waitForElementToBePresent(coloradoConnectTab,10);
                    coloradoConnectTab.click();
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + userTab);
        }
    }
    public void verifyPrintButtonIsDisplayed() {
        basicActions.waitForElementToBePresent(printBtn,10);
                softAssert.assertTrue(printBtn.isDisplayed());
                softAssert.assertTrue(printBtn.isEnabled());
                softAssert.assertAll();}

    public void clickPrintButton() {
        basicActions.waitForElementToBePresent(printBtn, 10);
        printBtn.click();
    }


}
