package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.HouseholdPage;
import io.cucumber.java.en.*;

public class HouseHoldPageSteps {
    HouseholdPage houseHoldPage = new HouseholdPage();

    @Then("I click continue on family overview page")
    public void iClickContinue(){
        houseHoldPage.clickContinue();
    }
}
