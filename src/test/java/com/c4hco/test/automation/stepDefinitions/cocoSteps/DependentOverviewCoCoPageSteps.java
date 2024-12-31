package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DependentOverviewCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DependentOverviewCoCoPageSteps {

    DependentOverviewCoCoPage dependentOverviewCoCoPage = new DependentOverviewCoCoPage(WebDriverManager.getDriver());

    @And("I click Continue on the Dependent Overview Page CoCo")
    public void clickContinueButton(){dependentOverviewCoCoPage.clickSaveAndContinueButton();}

    @Then("I click Go Back on the Dependent Overview page")
    public void clickGoBack() {
        dependentOverviewCoCoPage.clickGoBackButton();
    }

    @Then("I verify text on the Dependent Overview page in {string}")
    public void verifyAddInfoForYourselfPageText(String Language)  { dependentOverviewCoCoPage.verifyTextOnDependentOverview(Language); }

}
