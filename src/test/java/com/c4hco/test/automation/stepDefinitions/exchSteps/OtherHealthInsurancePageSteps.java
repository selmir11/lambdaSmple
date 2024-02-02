package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OtherHealthInsurancePage;
import io.cucumber.java.en.Then;

public class OtherHealthInsurancePageSteps {
    OtherHealthInsurancePage otherHealthInsurancePage = new OtherHealthInsurancePage();

    @Then("I have no health insurance to report")
    public void noOtherHealthInsurance(){otherHealthInsurancePage.noOtherInsurance();}
}
