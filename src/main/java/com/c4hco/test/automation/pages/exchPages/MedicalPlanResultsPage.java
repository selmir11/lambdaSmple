package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public void selectfromProviderList(String Selecting){

        String providerPath = "//span[text()='"+Selecting+"']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void SelectFirstMedicalPlan(){
        basicActions.waitForElementToBePresent(selectFirstPlan,10);
        selectFirstPlan.click();
        btnContinue.click();
    }

    public void clickInsuranceCompanyDropdown(){
        basicActions.waitForElementToBeClickable(insuranceCompanyDropdown, 10);
        insuranceCompanyDropdown.click();
    }

}