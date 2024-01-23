package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeforeYouBegin {
    private BasicActions basicActions;

    public BeforeYouBegin() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    @FindBy(xpath = "//*[@value='Continue with application']")
    WebElement continueWithApplication;

    public void continueWithApplication(){
        continueWithApplication.click();
        System.out.println("Clicked on Continue with the application");
    }
}
