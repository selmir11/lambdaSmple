package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LifeChangeEventsPage;
import io.cucumber.java.en.And;

public class LifeChangeEventsPageSteps {
    LifeChangeEventsPage lifeChangeEventsPage = new LifeChangeEventsPage();


    @And("I report {string} and click continue")
    public void iClickQLCEOption(String lceOption){
        lifeChangeEventsPage.selectLCE(lceOption);
    }

}
