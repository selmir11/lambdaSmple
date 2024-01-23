package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHistoryPage_LR {
    private BasicActions basicActions;

    public ApplicationHistoryPage_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//button[@name= 'viewResults']")
    WebElement viewResultsAndShop;

    public void clickViewResults(){
        viewResultsAndShop.click();
    }
}
