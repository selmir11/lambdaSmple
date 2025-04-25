package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlanComparePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
public class DentalPlanComparePageSteps {
    DentalPlanComparePage dentalPlanComparePage = new DentalPlanComparePage(WebDriverManager.getDriver());

    @And( "I click Go Back on the Dental Compare page" )
    public void clickGoBackDentalCompare() {dentalPlanComparePage.clickGoBackCompare();
    }

    @And( "I click Go Back Link on the Dental Compare page" )
    public void clickGoBackCompareLink() {dentalPlanComparePage.clickGoBackCompareLink();
    }

    @And( "I select the OutNetwork link on the Dental Compare page")
    public void clickOutNetworkDentalCompare() {dentalPlanComparePage.clickOutNetworkDental();
    }

    @And( "I select the InNetwork link on the Dental Compare page")
    public void clickInNetworkDentalCompare() {dentalPlanComparePage.clickInNetworkDental();
    }

    @And( "I validate the text headers and subheaders for the InNetwork Dental Compare page" )
    public void validateInNetworkDentalCompare(){dentalPlanComparePage.validateInNetworkDental();}

    @And( "I validate the text headers and subheaders for the OutNetwork Dental Compare page" )
    public void validateOutNetworkDentalCompare(){dentalPlanComparePage.validateOutNetworkDental();}

    @And( "I will validate the expand all and collapse all header functionality for the Dental Compare page" )
    public void validateExpandCollapseDentalCompareHeaders(){dentalPlanComparePage.validateExpandCollapseDentalCompareHeaders();}

    @And( "I will validate the expand and collapse header functionality for a specific header on the Dental Compare page" )
    public void validateSpecificExpandCollapseDentalCompareHeaders(){dentalPlanComparePage.validateSpecificExpandCollapseDentalCompareHeaders();}


    @And ("I click detail link {string} on the Dental Compare page")
    public void clickDentalPlanDetailLink(String planDetailNumber) {dentalPlanComparePage.clickDentalPlanDetaiLink(planDetailNumber);
    }

}



