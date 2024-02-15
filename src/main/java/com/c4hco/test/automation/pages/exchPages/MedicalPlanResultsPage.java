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

    @FindBy(id = "SHP-PlanResults-InsuranceCompany_1-input")
    WebElement box2CignaProvider;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany_2-input")
    WebElement box3DenverProvider;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany_3-input")
    WebElement box4KaiserProvider;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany_4-input")
    WebElement box5RockyProvider;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany_4-input")
    WebElement box6SelectProvider;

    public void selectfromProviderList(String Selecting){
        switch (Selecting){
            case "Anthem":
                box1AnthemProvider.click();
                break;
            case "Cigna":
                box2CignaProvider.click();
                break;
            case "Denver":
                box3DenverProvider.click();
                break;
            case "Kaiser":
                box4KaiserProvider.click();
                break;
            case "Rocky":
                box5RockyProvider.click();
                break;
            case "Select":
                box6SelectProvider.click();
                break;
        }

    }

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
    public void selectCignaProvider() {
        box2CignaProvider.click();
    }


}
