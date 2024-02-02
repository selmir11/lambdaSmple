package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TaxStatusPage;
import io.cucumber.java.en.Then;

public class TaxStatusPageSteps {
    TaxStatusPage taxStatusPage = new TaxStatusPage();

    @Then("My marital status is {string} and I am filing with no dependents")
    public void filingNoDependents(String FilingStatus){taxStatusPage.notClaimedNoDependents(FilingStatus);}
}
