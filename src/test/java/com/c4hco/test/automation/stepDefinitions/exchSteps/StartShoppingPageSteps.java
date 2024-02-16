package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.StartShoppingPage;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.*;

public class StartShoppingPageSteps {
    StartShoppingPage startShoppingPage = new StartShoppingPage();
    BasicActions basicActions = new BasicActions();
    @Then("I select {string} for tobacco usage on start shopping page")
    public void selectTobaccoUsage(String option) {
        startShoppingPage.iSelectTobaccoUsage(option);
    }
    @Then("I click continue on start shopping page")
    public void clickContinueStartShoppingPage(){
        startShoppingPage.clickContinue();
    }
    @And("I leave it at Default No and Click Continue")
    public void ClickContinue() {

        startShoppingPage.clickContinue();
    }

    @Then("I verify text on start shopping page")
    public void verifyText()  {
        startShoppingPage.verifyTextOnTobaccoPage();
    }
    @Then("I click save and exit on start shopping page")
    public void clickSaveAndExit() {
        startShoppingPage.clickBtnSaveNExit();
    }

}
