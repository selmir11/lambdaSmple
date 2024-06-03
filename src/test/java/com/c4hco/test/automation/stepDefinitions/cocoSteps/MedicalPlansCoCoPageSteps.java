package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalPlansCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

public class MedicalPlansCoCoPageSteps {
    MedicalPlansCoCoPage medicalPlansCoCoPage = new MedicalPlansCoCoPage(WebDriverManager.getDriver());

    @And("I select the first medical plan option CoCo")
    public void selectFirstMedicalPlanOption(){medicalPlansCoCoPage.selectFirstMedicalPlanCoCo();}

    @And("I click Continue on the Medical Plans Page CoCo")
    public void selectContinueMedPlansCoCo(){medicalPlansCoCoPage.selectContinueMedicalPlansCoCo();}

    @And("I select the COCO Insurance Company dropdown")
    public void clickInsuranceCompanyDropdown() {
        medicalPlansCoCoPage.clickInsuranceCompanyDropdown();
    }

    @And("I select the COCO Metal Tier dropdown")
    public void clickMetalTierDropdown() {
        medicalPlansCoCoPage.clickMetalTierDropdown();
    }

    @And("I select {string} to filter for a  COCO Metal Tier plan")
    public void selectfromMetalTierList(String metalOption) {
        medicalPlansCoCoPage.selectfromMetalTierList(metalOption);
    }

    @And("I select {string} to filter for desired COCO plan provider")
    public void selectfromProviderList(String carrierOption) {
        medicalPlansCoCoPage.selectfromProviderList(carrierOption);
    }

    @And("I validate the COCO plan option {int} has text {string}")
    public void validatePlanText(int Index, String planText) {
        medicalPlansCoCoPage.validatePlanResults(Index, planText);
    }

    @And( "I select initial 3 plans and click the Compare button" )
    public void selectPlanstoCompare(){
        medicalPlansCoCoPage.selectPlanstoCompare();
    }

}
