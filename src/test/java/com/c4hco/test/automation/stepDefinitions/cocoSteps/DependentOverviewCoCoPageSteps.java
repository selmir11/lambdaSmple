package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DependentOverviewCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class DependentOverviewCoCoPageSteps {

    DependentOverviewCoCoPage dependentOverviewCoCoPage = new DependentOverviewCoCoPage(WebDriverManager.getDriver());

    @And("I click Continue on the Dependent Overview Page CoCo")
    public void clickContinueButton(){dependentOverviewCoCoPage.clickSaveAndContinueButton();}
}
