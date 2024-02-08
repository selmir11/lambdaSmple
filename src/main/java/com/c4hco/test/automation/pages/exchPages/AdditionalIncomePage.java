package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdditionalIncomePage {

    private BasicActions basicActions;
    public AdditionalIncomePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }


    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = ".additional-income-row button")
    List<WebElement> addtlIncomeOptionsCheckbox;

    public void selectAddtlIncomeOption(String addtlIncomeOption){
        switch(addtlIncomeOption){
            case "None of these":
                addtlIncomeOptionsCheckbox.get(12).click();
                break;
        }
        saveAndContinueBtn.click();
    }
}
