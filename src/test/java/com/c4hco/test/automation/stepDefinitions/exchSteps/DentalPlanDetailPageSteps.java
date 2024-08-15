package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlanComparePage;
import com.c4hco.test.automation.pages.exchPages.DentalPlanDetailPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
public class DentalPlanDetailPageSteps {

    DentalPlanDetailPage dentalPlanDetailPage = new DentalPlanDetailPage( WebDriverManager.getDriver() );

    @And("I click Go Back on the Dental Detail page")
    public void clickGoBackDentalDetail() {
        dentalPlanDetailPage.clickGoBackDetail();
    }

    @And("I select the OutNetwork link on the Dental Detail page")
    public void clickOutNetworkDentalDetail() {dentalPlanDetailPage.clickOutNetworkDental();
    }

    @And("I select the InNetwork link on the Dental Detail page")
    public void clickInNetworkDentalDetail(){dentalPlanDetailPage.clickInNetworkDental();
    }

    @And( "I validate the text headers and subheaders for the InNetwork Dental Detail page" )
    public void validateInNetworkDentalDetail(){dentalPlanDetailPage.validateInNetworkDentalDetail();
    }

    @And( "I validate the text headers and subheaders for the OutNetwork Dental Detail page" )
    public void validateOutNetworkDentalDetail(){dentalPlanDetailPage.validateOutNetworkDentalDetail();
    }

}



