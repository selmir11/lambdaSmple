package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.StartShoppingPage;
import io.cucumber.java.en.*;

public class StartShoppingPageSteps {
    StartShoppingPage startShoppingPage = new StartShoppingPage();


    public void clickNoAndContinue() {
      //  Thread.sleep(3000);
        startShoppingPage.clickContinue();
     //   System.out.println("Member opt No tobacco ");
    }
    public void clickYesAndContinue(){
        startShoppingPage.clickYes();
        startShoppingPage.clickContinue();
    }
    @Then("I verify text on tobacco usage page")
    public void verifyText()  {
     //   Thread.sleep(3000);
        startShoppingPage.verifyTextOnTobaccoPage();
    }
    @Then("I choose no tobacco usage and click save and exit on start shopping page")
    public void clickNoAndSaveNExit() {
      //  Thread.sleep(3000);
        startShoppingPage.clickBtnSaveNExit();
    }



}
