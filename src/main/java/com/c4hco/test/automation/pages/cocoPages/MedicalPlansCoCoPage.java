package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MedicalPlansCoCoPage {
    private BasicActions basicActions;

    public MedicalPlansCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "PlanResults-SelectThisPlan_0")
    public WebElement selectFirstPlan;

    @FindBy(id = "SHP-MedicalPlanResults-Continue")
    public WebElement continueButton;

    public void selectFirstMedicalPlanCoCo() {
        basicActions.waitForElementToBePresent(selectFirstPlan, 10);
        selectFirstPlan.click();
    }

    public void selectContinueMedicalPlansCoCo() {
        basicActions.waitForElementToBeClickable(continueButton, 5);
        continueButton.click();
    }
}
