package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TobaccoUsageCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TobaccoUsageCoCoPageSteps {
    TobaccoUsageCoCoPage tobaccoUsageCoCoPage = new TobaccoUsageCoCoPage(WebDriverManager.getDriver());

    @And("I click Continue on the Tobacco Usage Page CoCo")
    public void selectContinueTobaccoUsage(){tobaccoUsageCoCoPage.selectContinueTobacco();}

    @Then("I verify text on Tobacco Usage Page CoCo")
    public void verifyTextOnTobaccoPage()  {
        tobaccoUsageCoCoPage.verifyTextOnTobaccoPage();
    }

    @And("I click go back on the tobacco usage page coco")
    public void clickBackBtn(){
        tobaccoUsageCoCoPage.clickBackBtn();
    }

    @And("I click on save and exit on tobacco usage page in coco")
    public void clickSaveAndExit(){
        tobaccoUsageCoCoPage.clickSaveAndExit();
    }

    @Then("I validate the text on {string} {string} and {string} buttons on tobacco usage page coco")
    public void validateButtonText(String goBackTxt, String saveExitTxt, String continueBtnTxt){
        tobaccoUsageCoCoPage.validateBtnTxt(goBackTxt, saveExitTxt, continueBtnTxt);
    }

}
