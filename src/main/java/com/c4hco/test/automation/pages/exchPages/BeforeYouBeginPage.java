package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeforeYouBeginPage {

    @FindBy(xpath = "//*[@value='Continue with application']")
    WebElement continueWithApplication;
    private BasicActions basicActions;

    public BeforeYouBeginPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }


    public void clickContinueWithApplicationButton(){
        // TO DO - create a resuable method in utils to click a button/element
        continueWithApplication.click();
    }
}
