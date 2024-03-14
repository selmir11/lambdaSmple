package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OhiVaHealthcarePage {
    private BasicActions basicActions;
    public OhiVaHealthcarePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "submitButton")
    List<WebElement> goBackAndContinueButton;



    public void clickGoBack() {
        basicActions.click(goBackAndContinueButton.get(0));
    }
}
