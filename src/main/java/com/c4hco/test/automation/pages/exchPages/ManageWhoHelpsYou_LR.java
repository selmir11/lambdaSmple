package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageWhoHelpsYou_LR {
    private BasicActions basicActions;

    public ManageWhoHelpsYou_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    @FindBy(xpath = "//button[@id='contineOwn-button']")
    WebElement continueOnMyOwn;

    public void continueOnOwn() throws InterruptedException {
        Thread.sleep(2000);
        continueOnMyOwn.click();
    }
}
