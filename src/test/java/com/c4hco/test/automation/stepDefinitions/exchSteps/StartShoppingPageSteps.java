package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.StartShoppingPage;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.*;

public class StartShoppingPageSteps {
    StartShoppingPage startShoppingPage = new StartShoppingPage();
    BasicActions basicActions = new BasicActions();

    public void clickNoAndContinue() {
            startShoppingPage.clickContinue();
    }
    public void clickYesAndContinue(){
        startShoppingPage.clickYes();
        startShoppingPage.clickContinue();
    }
    @Then("I verify text on tobacco usage page")
    public void verifyText()  {
        startShoppingPage.verifyTextOnTobaccoPage();
    }
    @Then("I choose no tobacco usage and click save and exit on start shopping page")
    public void clickNoAndSaveNExit() {
        startShoppingPage.clickBtnSaveNExit();
    }

}
