package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.StartShoppingPage_LR;
import io.cucumber.java.en.*;

public class StartShoppingPageSteps_LR {
    StartShoppingPage_LR startShop = new StartShoppingPage_LR();


    public void clickNoAndContinue() throws InterruptedException {
        Thread.sleep(3000);
        startShop.clickContinue();
        System.out.println("Member opt No tobacco ");
    }
    public void clickYesAndContinue(){
        startShop.clickYes();
        startShop.clickContinue();
    }
    @Then("I verify text on tobacco usage page")
    public void verifyText() throws InterruptedException {
        Thread.sleep(3000);
        startShop.verifyTextOnTobaccoPage();
    }
    @Then("I choose no tobacco usage and click save and exit on start shopping page")
    public void clickNoAndSaveNExit() throws InterruptedException {
        Thread.sleep(3000);
        startShop.clickBtnSaveNExit();
    }



}
