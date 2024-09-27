package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalPlansCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class MedicalPlansCoCoPageSteps {
    MedicalPlansCoCoPage medicalPlansCoCoPage = new MedicalPlansCoCoPage(WebDriverManager.getDriver());

    @And("I select the first medical plan option CoCo")
    public void selectFirstMedicalPlanOption(){medicalPlansCoCoPage.selectFirstMedicalPlanCoCo();}

    @And("I click Continue on the Medical Plans Page CoCo")
    public void selectContinueMedPlansCoCo(){medicalPlansCoCoPage.selectContinueMedicalPlansCoCo();}

    @And("I select the COCO Insurance Company dropdown")
    public void clickInsuranceCompanyDropdown() {medicalPlansCoCoPage.clickInsuranceCompanyDropdown();
    }

    @And("I select the COCO Metal Tier dropdown")
    public void clickMetalTierDropdown() {
        medicalPlansCoCoPage.clickMetalTierDropdown();
    }

    @And("I select {string} to filter for a  COCO Metal Tier plan")
    public void selectfromMetalTierList(String metalOption) {
        medicalPlansCoCoPage.selectfromMetalTierList(metalOption);
    }

    @And ("I select Silver Enhanced option")
    public void selectSilverEnhanced(){
        medicalPlansCoCoPage.selectSilverEnhancedBox();
    }

    @And( "I validate the plan totals are {string} on the COCO Medical Plan Results page" )
    public void validateCOCOPlanTotals(String planTotal){medicalPlansCoCoPage.validateCOCOPlanTotals(planTotal);}

    @And( "I validate the SES plan totals are {string} on the COCO Medical Plan Results page" )
    public void validateSESCOCOPlanTotals(String planIndividualTotal){medicalPlansCoCoPage.validateSESCOCOPlanTotals(planIndividualTotal);}

    @And("I select {string} to filter for desired COCO plan provider")
    public void selectfromProviderList(String carrierOption) {medicalPlansCoCoPage.selectfromProviderList(carrierOption);
    }

    @And( "I select initial 3 plans and click the Compare button" )
    public void selectPlanstoCompare(){
        medicalPlansCoCoPage.selectPlanstoCompare();
    }

    @And("I select {string} coco medical plan")
    public void selectMedPlan(String medicalPlan) {
        medicalPlansCoCoPage.selectCoCoMedicalplan(medicalPlan);
    }

    @And("I select the sorting {string} option in coco medical page")
    public void clickSortingDropdown(String sortingValue) {
        medicalPlansCoCoPage.clickSortingDropdown(sortingValue);
    }

    @And("I validate the COCO plan option {int} has text {string}")
    public void validatePlanText(int Index, String planText) {
        medicalPlansCoCoPage.validatePlanResults( Index, planText );
    }
    @And ("I validate the COCO plan option {int} has a premium {string}")
    public void validateCOCOPlanIndividualPremium(int Index, String planPremium){
        medicalPlansCoCoPage.validateCOCOPlanIndividualPremium( Index,planPremium );
    }

    @Then("I validate sorting based on {string} in coco medical page")
    public void validateMedicalPremiumSorting(String sortingTypeSelection) {
        medicalPlansCoCoPage.evaluateSortingValue(sortingTypeSelection);
    }


    @And( "I select 2 plans from page one and 1 plan from page two and click the Compare button" )
    public void selectPlansfromDifferentPgetoCompare(){
        medicalPlansCoCoPage.selectMultiplePlanstoCompare();
    }

    @And("Verify {string} hyperlink present in coco Medical Plan Results page and navigates to {string}")
    public void verifyHealthcareOrgLink(String hyperLink, String pageUrl){
        medicalPlansCoCoPage.verifyURLforHealthCare(hyperLink,pageUrl);
    }

    @And("I click on the Plan Details button for the first Medical plan on the Coco Medical Plan page")
    public void planDetailsbutton(){
        medicalPlansCoCoPage.selectFirstPlanDetailsCoCo();
    }

    @Then("I click Go Back on coco medical plan page")
    public void clickGoBackStartShoppingPage() {
        medicalPlansCoCoPage.iclickGoBack();
    }

    @Then("Validate {string} coco medical plan is selected")
    public void validateSelectedPlan(String planName) {
        medicalPlansCoCoPage.validatePlanSelection(planName);
    }
}
