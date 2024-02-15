package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id ="SHP-PlanResults-InsuranceCompany")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany_0-input")
    WebElement box1AnthemProvider;

    public void SelectFirstMedicalPlan(){
        basicActions.waitForElementToBePresent(selectFirstPlan,10);
        selectFirstPlan.click();
        btnContinue.click();
    }

     public void clickInsuranceCompanyDropdown(){
        insuranceCompanyDropdown.click();
    }
    public void selectAnthemProvider() {
        box1AnthemProvider.click();
    }

}
