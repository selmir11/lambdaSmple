package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DentalPlansResultsPage {
    private BasicActions basicActions;

    public DentalPlansResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="DentalPlanResults-SelectThisPlan_0")
    WebElement selectFirstDentalPlanBtn;

    @FindBy(id="SHP-DentalPlanResults-Continue")
    WebElement continueBtnOnDentalPlanResults;

    @FindBy(id="SHP-DentalPlanResults-GoBack")
    WebElement btnGoBack;

    public void selectFirstDentalPlan(){
         basicActions.waitForElementToBePresent(selectFirstDentalPlanBtn,10);
        selectFirstDentalPlanBtn.click();
        continueBtnOnDentalPlanResults.click();

    }

    public void clickGoBack(){
        basicActions.waitForElementToBePresent(btnGoBack,10);
        btnGoBack.click();

    }
}
