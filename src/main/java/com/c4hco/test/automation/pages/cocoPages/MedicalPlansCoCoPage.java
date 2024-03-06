package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
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

    @FindBy(css = ".select-plan-button button")
    public List<WebElement> selectPlanButton;

    @FindBy(id = "SHP-MedicalPlanResults-Continue")
    public WebElement continueButton;

    public void selectMedicalPlan(String medicalPlan){
        switch(medicalPlan){
            case "KP Colorado Option Bronze":
                basicActions.waitForElementListToBePresent(selectPlanButton, 15);
                selectPlanButton.get(0).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + selectPlanButton);
        }
    }

    public void selectContinueMedicalPlansCoCo() {
        basicActions.waitForElementToBeClickable(continueButton, 5);
        continueButton.click();
    }
}
