package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindExpertHelpPage {
    private BasicActions basicActions;

    public FindExpertHelpPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    // update the below locator to have id
    @FindBy(xpath = "//button[@id='contineOwn-button']")
    WebElement continueOnMyOwn;

    public void clickContinueOnOwnButton() {
     //   Thread.sleep(2000);
        continueOnMyOwn.click();
    }
}
