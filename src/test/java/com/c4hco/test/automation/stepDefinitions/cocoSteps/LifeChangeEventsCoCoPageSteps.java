package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.LifeChangeEventsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

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
}
