package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DentalPlansResultsPage {
    private BasicActions basicActions;

    public DentalPlansResultsPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    @FindBy(id="DentalPlanResults-SelectThisPlan_0")
    WebElement selectFirstDentalPlanBtn;

    @FindBy(id="SHP-DentalPlanResults-Continue")
    WebElement continueBtnOnDentalPlanResults;
    public void selectFirstDentalPlan(){
        getDriver().waitForElementToBePresent(selectFirstDentalPlanBtn,10);
        selectFirstDentalPlanBtn.click();
        continueBtnOnDentalPlanResults.click();

    }
}
