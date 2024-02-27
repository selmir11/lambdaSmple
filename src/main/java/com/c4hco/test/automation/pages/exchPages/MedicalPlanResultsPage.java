package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MedicalPlanResultsPage {
    private BasicActions basicActions;

    public MedicalPlanResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "PlanResults-SelectThisPlan_0")
    WebElement selectFirstPlan;
    @FindBy(id= "PlanResults-ProviderPlan_0")
    WebElement firstMedicalPlanName;

    @FindBy(id = "SHP-MedicalPlanResults-Continue")
    WebElement btnContinue;

    @FindBy(id ="PlanResults-Compare_0")
    WebElement selectCompare;

    @FindBy(xpath ="//a[contains(@id,'PlanResults-Compare')]")
    List<WebElement> comparePlanLinks;

    @FindBy(id ="SHP-PlanResults-InsuranceCompany")

    WebElement insuranceCompanyDropdown;

    @FindBy(id = "SHP-PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany")
    WebElement InsuranceCompanyDropdown;

    public void selectfromProviderList(String Selecting) {
        String providerPath = "//span[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void iGetFirstPlaneName(){
        basicActions.waitForElementToBePresent(firstMedicalPlanName,10);
        SharedData.setfirstPlanNameOnMedicalResultsPage(firstMedicalPlanName.getText());
    }
    public void SelectFirstMedicalPlan(){
        iGetFirstPlaneName();
        basicActions.waitForElementToBePresent(selectFirstPlan,10);
        selectFirstPlan.click();
    }
    public void iclickContinue(){
        btnContinue.click();
    }

    public void clickFirstTwoCompareButtons() {
        basicActions.waitForElementListToBePresent(comparePlanLinks, 10);
        comparePlanLinks.get(0).click();
        comparePlanLinks.get(1).click();
    }

        public void clickInsuranceCompanyDropdown () {
            basicActions.waitForElementToBeClickable(insuranceCompanyDropdown, 10);
            insuranceCompanyDropdown.click();

        }

        public void validatePlanResults ( int index, String planText){
            basicActions.waitForElementToBePresent(selectFirstPlan, 10);
            index = index - 1; //Index of the page starts at 0, so we take the visible order and subtract 1
            String indexString = String.valueOf(index); //turns the int index into a string value.
            String planID = "PlanResults-ProviderPlan_" + indexString; //sets the ID String using the index
            WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID)); //sets the Webelement based on the ID
            String expectedText = ePlanID.getText();
            expectedText.equals(planText); // compares the expected text gathered in previous line to the planText passed into the function.
        }
    }

