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

    @And("I select the English OutNetwork link on the Dental Detail page")
    public void clickOutNetworkDentalDetail() {dentalPlanDetailPage.clickOutNetworkDental();
    }

    @And("I select the Spanish OutNetwork link on the Dental Detail page")
    public void clickOutNetworkDentalSpanish() {dentalPlanDetailPage.clickOutNetworkDentalSpanish();
    }

    @And("I select the English InNetwork link on the Dental Detail page")
    public void clickInNetworkDentalDetail(){dentalPlanDetailPage.clickInNetworkDental();
    }

    @And("I select the Spanish InNetwork link on the Dental Detail page")
    public void clickSpanishInNetworkDental(){dentalPlanDetailPage.clickSpanishInNetworkDental();
    }

    @And( "I validate the English text headers and subheaders for the InNetwork Dental Detail page" )
    public void validateInNetworkDentalDetailEnglish(){dentalPlanDetailPage.validateInNetworkDentalDetailEnglish();
    }

    @And( "I validate the Spanish text headers and subheaders for the InNetwork Dental Detail page" )
    public void validateInNetworkDentalDetailSpanish(){dentalPlanDetailPage.validateInNetworkDentalDetailSpanish();
    }

    @And( "I validate the English text headers and subheaders for the OutNetwork Dental Detail page" )
    public void validateOutNetworkDentalDetailEnglish(){dentalPlanDetailPage.validateOutNetworkDentalDetailEnglish();
    }

    @And( "I validate the Spanish text headers and subheaders for the OutNetwork Dental Detail page" )
    public void validateOutNetworkDentalDetailSpanish(){dentalPlanDetailPage.validateOutNetworkDentalDetailSpanish();
    }

}



