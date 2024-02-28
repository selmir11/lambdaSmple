package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHistoryPage {

    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;
    @FindBy(xpath = "//button[@name= 'viewResults']")
    WebElement viewResultsAndShop;
    private BasicActions basicActions;

    public ApplicationHistoryPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }


    public void clickViewResults(){
        viewResultsAndShop.click();
    }

    public void validateAPTC(String expectedAPTC){
        basicActions.waitForElementToBePresent(lblAPTCValue, 15);
        String APTC = lblAPTCValue.getText();
        Assert.assertTrue("Incorrected APTC Amount! Expected "+expectedAPTC+" but "+APTC+" displayed.", APTC.contains(expectedAPTC));
    }

    public void validateTextOnPage(String Text){
        basicActions.waitForElementToBePresent(lblAPTCValue, 15);

        basicActions.waitForElementToBePresent(basicActions.getDriver().findElement(By.xpath("//*[text()='"+Text+"']")), 15);
    }
}
