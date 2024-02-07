package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IncomeSummaryPage {
    private BasicActions basicActions;
    public IncomeSummaryPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id ="ELIG-summaryDetails-YesButton")
    WebElement btnYesProjectedDiff;

    @FindBy(css = "lib-option-buttons button")
    List<WebElement> projectedIncomeOptions;

    @FindBy(id = "pageId-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectProjectedIncome(String projectedIncomeOption){
        switch(projectedIncomeOption){
            case "No":
                projectedIncomeOptions.get(1).click();
                break;
        }
        saveAndContinueBtn.click();
    }
}
