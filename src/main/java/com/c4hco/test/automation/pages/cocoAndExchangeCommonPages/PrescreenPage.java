package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrescreenPage {

    @FindBy(css = ".linkText1")
    WebElement createMyAccount;

    private BasicActions basicActions;
    public PrescreenPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void clickCreateAccountLink(){
        createMyAccount.click();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line


}
