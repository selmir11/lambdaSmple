package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LawfulPresencePage;
import io.cucumber.java.en.*;

public class LawfulPresencePageSteps {

    LawfulPresencePage lawfulPresencePage = new LawfulPresencePage();

    @Then("I select {string} for Citizen option")
    public void isMemberCitizen(String YNCitizen){lawfulPresencePage.isMemberCitizen(YNCitizen);}

    @Then("I select {string} for Naturalized Immigrant option")
    public void isMemberNaturalized(String YNNaturalized){lawfulPresencePage.isMemberNaturalized(YNNaturalized);}

    @Then("I click continue on the Citizenship page")
    public void clickContinue(){lawfulPresencePage.clickContinue();}
}
