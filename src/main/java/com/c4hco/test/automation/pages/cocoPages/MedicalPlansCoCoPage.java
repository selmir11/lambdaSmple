package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
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

    @FindBy(css = "#PlanResults-SelectThisPlan_1")
    public WebElement selectFirstPlan;

    @FindBy(id = "SHP-MedicalPlanResults-Continue")
    public WebElement continueButton;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "SHP-PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "SHP-PlanResults-MetalTier")
    WebElement metalTierDropdown;

    public void selectFirstMedicalPlanCoCo() {
        basicActions.waitForElementToBeClickable(selectFirstPlan, 20);
        selectFirstPlan.click();
    }

    public void selectContinueMedicalPlansCoCo() {
        basicActions.waitForElementToBeClickable(continueButton, 20);
        continueButton.click();
    }

    public void clickInsuranceCompanyDropdown() {
        basicActions.waitForElementToBeClickable(insuranceCompanyDropdown, 30);
        insuranceCompanyDropdown.click();

    }

    public void clickMetalTierDropdown() {
        basicActions.waitForElementToBeClickable(metalTierDropdown, 30);
        metalTierDropdown.click();

    }
    public void selectfromMetalTierList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void selectfromProviderList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();

    }
    public void validatePlanResults(int index, String planText) {
        basicActions.waitForElementToBePresent(selectFirstPlan, 10);
        //index = index - 1; //Index of the page starts at 0, so we take the visible order and subtract 1
        String indexString = String.valueOf(index); //turns the int index into a string value.
        String planID = "PlanResults-SelectThisPlan_" + indexString; //sets the ID String using the index
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID)); //sets the Web element based on the ID
        String expectedText = ePlanID.getText();
        expectedText.equals(planText); // compares the expected text gathered in previous line to the planText passed into the function.
    }


}
