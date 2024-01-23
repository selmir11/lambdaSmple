package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitizenshipandImmigration_LR {
    private BasicActions basicActions;

    public CitizenshipandImmigration_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@id='usCitizenYes']")
    WebElement citizenYes;
    @FindBy(xpath = "//*[@id='naturalizedCitizenNo']")
    WebElement naturalizedCitizen;
    @FindBy(xpath = "//*[@value='Save and Continue']")
    WebElement saveContinue;

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
