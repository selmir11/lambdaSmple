package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrescreenPage {

    @FindBy(css = ".linkText1")
    WebElement createMyAccount;

    private BasicActions basicActions;
    public PrescreenPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void clickCreateAccountLink(){
        System.out.println("click create account from pre screen page");
        createMyAccount.click();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

    public void validatePreScreenPage(){
        Assert.assertTrue("url doesn't have preScreen", basicActions.getCurrentUrl().contains("prescreen"));
    }
}
