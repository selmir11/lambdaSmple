package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlanComparePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
public class DentalPlanComparePageSteps {
    DentalPlanComparePage dentalPlanComparePage = new DentalPlanComparePage(WebDriverManager.getDriver());

    @And( "I click Go Back on the Dental Compare page" )
    public void clickGoBackDentalCompare() {dentalPlanComparePage.clickGoBackCompare();}

}



