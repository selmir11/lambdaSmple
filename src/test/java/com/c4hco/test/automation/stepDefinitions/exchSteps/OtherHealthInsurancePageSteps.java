package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OtherHealthInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OtherHealthInsurancePageSteps {
    OtherHealthInsurancePage otherHealthInsurancePage = new OtherHealthInsurancePage(WebDriverManager.getDriver());

    @Then("I select {string} as health insurance option and continue")
    public void noOtherHealthInsurance(String insuranceOption){
        otherHealthInsurancePage.selectInsuranceOption( insuranceOption);
    }

    @Then("I click continue on the Other Health Insurance page")
    public void IClickSaveAndContinue(){otherHealthInsurancePage.clickSaveAndContinue();}

    @Then("I select {string} as health insurance option")
    public void iSelectInsuranceOptionOnly(String insuranceOption){
        otherHealthInsurancePage.selectInsuranceOptionOnly(insuranceOption);
    }

    @Then("I click Go Back on the Other Health Insurance page")
    public void clickGoBack() {
        otherHealthInsurancePage.clickGoBackButton();
    }
}
