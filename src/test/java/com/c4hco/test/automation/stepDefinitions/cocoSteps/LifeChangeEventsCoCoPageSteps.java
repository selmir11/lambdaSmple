package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.LifeChangeEventsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LifeChangeEventsCoCoPageSteps {
    LifeChangeEventsCoCoPage lifeChangeEventsCoCoPage = new LifeChangeEventsCoCoPage(WebDriverManager.getDriver());

    @And("I select {string} life change event")
    public void selectQLCEOption(String lceOption){
        lifeChangeEventsCoCoPage.selectLCE(lceOption);
    }

    @And("I select None of these life change event")
    public void selectNoneOfTheseLCEOption(){lifeChangeEventsCoCoPage.selectNoneOfThese();}

    @And("I select continue on the LCE page")
    public void selectSaveAndContinue(){lifeChangeEventsCoCoPage.saveAndContinue();}

    @And("I select Go Back on the LCE page")
    public void selectGoBack(){lifeChangeEventsCoCoPage.goBack();}





    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo LCE page in {string}")
    public void iVerifyTextOnLcePage(String language){lifeChangeEventsCoCoPage.verifyHeadersEmploymentIncomePage(language);}

    @Then("I verify {string} life change event {string} selected")
    public void iVerifyLCECheckboxState(String LCEType, String Selection){lifeChangeEventsCoCoPage.verifyLCECheckboxState(LCEType, Selection);}

}
