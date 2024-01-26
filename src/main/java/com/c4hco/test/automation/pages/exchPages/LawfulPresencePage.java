package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LawfulPresencePage {
    private BasicActions basicActions;

    public LawfulPresencePage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    //update the locators to have ids
    @FindBy(xpath = "//*[@id='usCitizenYes']")
    WebElement citizenYes;
    @FindBy(xpath = "//*[@id='naturalizedCitizenNo']")
    WebElement naturalizedCitizen;
    @FindBy(xpath = "//*[@value='Save and Continue']")
    WebElement saveContinue;

    // update the naming convention for below
    public void citizen(){
        citizenYes.click();
    }
    public void naturalized(){
        naturalizedCitizen.click();
    }
    public  void save(){
        saveContinue.click();
    }
}
