package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MedicalPlanResultsPage {
    private BasicActions basicActions;

    public MedicalPlanResultsPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id ="PlanResults-SelectThisPlan_0")
    WebElement selectFirstPlan;

    @FindBy(id ="SHP-MedicalPlanResults-Continue")
    WebElement btnContinue;

    @FindBy(id ="PlanResults-Compare_0")
    WebElement selectCompare;

    @FindBy(xpath ="//a[contains(@id,'PlanResults-Compare')]")
    List<WebElement> comparePlanLinks;

    public void SelectFirstMedicalPlan(){
        basicActions.waitForElementToBePresent(selectFirstPlan,10 );
        selectFirstPlan.click();
        btnContinue.click();
    }

    public void SelectCompare() {
        basicActions.waitForElementToBePresent(selectCompare, 10);
        selectCompare.click();
    }

    public void clickFirstTwoCompareButtons(){
        basicActions.waitForElementListToBePresent(comparePlanLinks, 10);
        comparePlanLinks.get(0).click();
        comparePlanLinks.get(1).click();
    }

}
