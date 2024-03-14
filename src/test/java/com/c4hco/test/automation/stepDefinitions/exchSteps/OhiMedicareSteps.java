package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiMedicarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class OhiMedicareSteps {
    OhiMedicarePage ohiMedicarePage = new OhiMedicarePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the Medicare page")
    public void iClickGoBack(){ohiMedicarePage.clickGoBack();
    }

}
