package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHistoryPage {

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
}
