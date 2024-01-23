package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Apply2024_LR {
    @FindBy(xpath = "//*[text()='Apply for  2024']")
    WebElement apply2024;

    @FindBy(xpath = "//*[@class='c4PageHeader-large']")
    WebElement header;

    private BasicActions basicActions;

    public Apply2024_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void verifyHeader(){
        Assert.assertTrue("This is not Welcome Page.", header.getText().contains("Welcome to Connect"));
    }

    public void clickApply2024(){
        apply2024.click();
    }

}
