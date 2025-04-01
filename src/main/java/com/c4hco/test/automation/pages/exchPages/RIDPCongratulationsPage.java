package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RIDPCongratulationsPage {
    private BasicActions basicActions;
    public RIDPCongratulationsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "Continue with application.Button")
    WebElement btnContinue;

    public void clickContinue(){
        btnContinue.click();
    }
}
