package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OtherHealthInsurancePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OtherHealthInsuranceSteps_Elmo {
    OtherHealthInsurancePage_Elmo otherHealthInsurancePage_Elmo = new OtherHealthInsurancePage_Elmo(WebDriverManager.getDriver());

    @Then("I select {string} as ELMO health insurance option")
    public void iSelectInsuranceOptionOnly(String insuranceOption){
        otherHealthInsurancePage_Elmo.selectInsuranceOptionOnly(insuranceOption);
    }






    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify text on the Other Health Insurance page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){
        otherHealthInsurancePage_Elmo.verifyTextOnOtherHealthInsurancePage(language);
    }
    @And("I verify the checkboxes on the Other Health Insurance page")
    public void iVerifyCheckboxesOnOtherHealthInsurancePage(){
        otherHealthInsurancePage_Elmo.verifyCheckboxesOnOtherHealthInsurancePage();
    }
    @And("I verify help icons on the Other Health Insurance page")
    public void iVerifyHelpIconsOnOtherHealthInsurancePage(){
        otherHealthInsurancePage_Elmo.verifyHelIconsOnOtherHealthInsurancePage();
    }
}
