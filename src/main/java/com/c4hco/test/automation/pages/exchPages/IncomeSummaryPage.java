package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncomeSummaryPage {
    private BasicActions basicActions;
    public IncomeSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "header-1 content-center")
    WebElement incomeSummaryHeader;

    @FindBy(id ="ELIG-summaryDetails-YesButton")
    WebElement projectedIncomeYes;

    @FindBy(id = "ELIG-summaryDetails-NoButton")
    WebElement projectedIncomeNo;

    @FindBy(id = "pageId-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectProjectedIncome(String projectedIncomeOption){
        basicActions.waitForElementToBePresent(incomeSummaryHeader,1);
        switch(projectedIncomeOption){
            case "No":
                basicActions.waitForElementToBePresent(incomeSummaryHeader,5);
                basicActions.waitForElementToBeClickable(projectedIncomeNo, 30);
                basicActions.scrollToElement(projectedIncomeNo);
                projectedIncomeNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + projectedIncomeNo);
        }
        saveAndContinueBtn.click();
    }

    public void clickSaveandContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn,30);
        saveAndContinueBtn.click();
    }
}
