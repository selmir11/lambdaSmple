package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlanDetailPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class DentalPlanDetailPageSteps {

    DentalPlanDetailPage dentalPlanDetailPage = new DentalPlanDetailPage( WebDriverManager.getDriver() );

    @And("I click Go Back on the Dental Detail page")
    public void clickGoBackDentalDetail() {
        dentalPlanDetailPage.clickGoBackDetail();
    }

    @And("I select the English OutNetwork link on the Dental Detail page")
    public void clickOutNetworkDentalDetail() {dentalPlanDetailPage.clickOutNetworkDental();
    }

    @And("I select the Spanish OutNetwork link on the Dental Detail page")
    public void clickOutNetworkDentalSpanish() {dentalPlanDetailPage.clickOutNetworkDentalSpanish();
    }

    @And("I select the English InNetwork link on the Dental Detail page")
    public void clickInNetworkDentalDetail(){dentalPlanDetailPage.clickInNetworkDental();
    }

    @And( "I validate the {string} text headers and subheaders for the InNetwork Dental Detail page" )
    public void validateInNetworkDentalDetailLanguage(String language){dentalPlanDetailPage.validateInNetworkDentalDetailLanguage(language);
    }

    @And( "I validate the {string} text headers and subheaders for the OutNetwork Dental Detail page" )
    public void validateOutNetworkDentalDetailLanguage(String language){dentalPlanDetailPage.validateOutNetworkDentalDetailLanguage(language);
    }

}



