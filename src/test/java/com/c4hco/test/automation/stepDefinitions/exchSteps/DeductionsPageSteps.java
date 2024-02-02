package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DeductionsPage;
import io.cucumber.java.en.Then;

public class DeductionsPageSteps {
    DeductionsPage deductionsPage = new DeductionsPage();

    @Then("I have no Deductions")
    public void noDeductions(){deductionsPage.noDeductions();}
}
