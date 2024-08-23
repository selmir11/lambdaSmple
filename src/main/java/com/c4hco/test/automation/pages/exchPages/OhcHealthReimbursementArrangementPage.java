package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OhcHealthReimbursementArrangementPage {
    private BasicActions basicActions;
    public OhcHealthReimbursementArrangementPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "Ohc-Hra-SaveAndContinue")
    WebElement continueButton;

    @FindBy(id = "Ohc-Hra-GoBack")
    WebElement goBackButton;



    public void clickGoBack() {
        basicActions.waitForElementToBePresent(goBackButton,20);
        basicActions.click(goBackButton);
    }
}
