package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OhcHealthReimbursementArrangementPage {
    private BasicActions basicActions;
    public OhcHealthReimbursementArrangementPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        Assert.assertTrue(basicActions.waitForAngular(10), "page did not load in 10 seconds");
    }

    @FindBy(id = "submitButton")
    List<WebElement> goBackAndContinueButton;



    public void clickGoBack() {
        basicActions.click(goBackAndContinueButton.get(0));
    }
}
