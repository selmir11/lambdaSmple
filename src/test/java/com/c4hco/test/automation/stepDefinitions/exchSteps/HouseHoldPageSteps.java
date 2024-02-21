package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.HouseholdPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class HouseHoldPageSteps {
    HouseholdPage houseHoldPage = new HouseholdPage(WebDriverManager.getDriver());

    @Then("I click continue on family overview page")
    public void iClickContinue(){
        houseHoldPage.clickContinue();
    }

    @Then("I click Add Another Family Member")
    public void iClickAddFamilyMember(){houseHoldPage.clickAddMember();}
}

