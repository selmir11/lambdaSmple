package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LawfulPresencePage;
import io.cucumber.java.en.*;

public class LawfulPresencePageSteps {

    LawfulPresencePage lawfulPresencePage = new LawfulPresencePage();

    @And("I enter citizenship details and click continue")
    public void citizenshipPage(){
        lawfulPresencePage.usCitizen();
        lawfulPresencePage.naturalizedCitizen();
        lawfulPresencePage.save();
    }
}
