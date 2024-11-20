package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoodNewsMAPage {

    private BasicActions basicActions;
    public GoodNewsMAPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(css = "#submitButton")
    List<WebElement> btnSubmit;

    public void clickNextOption(String nextOption){
        basicActions.waitForElementListToBePresent(btnSubmit, 20);
        switch(nextOption) {
            case "No Thanks":
                btnSubmit.get(1).click();
                break;
            case "Continue":
                btnSubmit.get(0).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + nextOption);
        }
    }
}
