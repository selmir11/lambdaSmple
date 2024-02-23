package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdditionalIncomePage {

    private BasicActions basicActions;
    public AdditionalIncomePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
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
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 10);

        switch(addtlIncomeOption){
            case "None of these":
                addtlIncomeOptionsCheckbox.get(12).click();
                break;
        }
        saveAndContinueBtn.click();
    }
}
