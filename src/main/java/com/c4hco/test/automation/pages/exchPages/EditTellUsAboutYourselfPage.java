package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.actions.ClickAction;
import com.c4hco.test.automation.actions.WaitAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditTellUsAboutYourselfPage extends TellUsAboutYourselfPage{

    @FindBy(id = "continueButton")
    WebElement btnSaveAndContinue;
    public EditTellUsAboutYourselfPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void saveAndContinue(){
        ClickAction.click(btnSaveAndContinue);
        WaitAction.waitForDisappear(btnSaveAndContinue, 5);
    }
}
