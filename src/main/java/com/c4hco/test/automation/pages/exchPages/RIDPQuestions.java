package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RIDPQuestions {
    private BasicActions basicActions;
    public RIDPQuestions(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "Questions-GoBack")
    WebElement btnGoBack;

    @FindBy(id = "Questions-SaveAndContinue")
    WebElement btnSaveAndContinue;
}
