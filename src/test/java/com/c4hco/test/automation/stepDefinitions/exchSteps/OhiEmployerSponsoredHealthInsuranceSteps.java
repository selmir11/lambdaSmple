package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiEmployerSponsoredHealthInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OhiEmployerSponsoredHealthInsuranceSteps {
    OhiEmployerSponsoredHealthInsurancePage ohiEmployerSponsoredHealthInsurancePage = new OhiEmployerSponsoredHealthInsurancePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the ESI page")
    public void iClickGoBack(){ohiEmployerSponsoredHealthInsurancePage.clickGoBack();
    }


}
