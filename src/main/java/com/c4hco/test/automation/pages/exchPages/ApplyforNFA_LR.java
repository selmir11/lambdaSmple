package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyforNFA_LR {
    private BasicActions basicActions;

    public ApplyforNFA_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@value='purchase a plan without financial help.']")
    WebElement noThanks;
    @And("I Apply for no financial help")
    public void chooseNoFinancialHelp(){
        noThanks.click();
    }
}
