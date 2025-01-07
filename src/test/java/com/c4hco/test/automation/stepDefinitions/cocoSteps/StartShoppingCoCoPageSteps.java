package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.StartShoppingCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StartShoppingCoCoPageSteps {

    StartShoppingCoCoPage startShoppingCoCoPage = new StartShoppingCoCoPage(WebDriverManager.getDriver());

    @Then("I click continue on coco start shopping page")
    public void clickContinueStartShoppingPage() {
        startShoppingCoCoPage.iclickContinue();
    }

    @Then("I click Yes to the Tobacco usage question on coco start shopping page")
    public void tobaccoYesUser(String tobaccoUsageUserDetails) {
        startShoppingCoCoPage.tobaccoPage(tobaccoUsageUserDetails);
    }

    @Then("I verify text on Tobacco Usage Page CoCo")
    public void verifyTextOnTobaccoPage()  {
        startShoppingCoCoPage.verifyTextOnTobaccoPage();
    }

    @And("I click go back on the tobacco usage page coco")
    public void clickBackBtn(){
        startShoppingCoCoPage.clickBackBtn();
    }

    @And("I click on save and exit on tobacco usage page in coco")
    public void clickSaveAndExit(){
        startShoppingCoCoPage.clickSaveAndExit();
    }

    @Then("I validate the text on {string} {string} and {string} buttons on tobacco usage page coco")
    public void validateButtonText(String goBackTxt, String saveExitTxt, String continueBtnTxt){
        startShoppingCoCoPage.validateBtnTxt(goBackTxt, saveExitTxt, continueBtnTxt);
    }

    @Then("I click {string} to the Tobacco usage question on start shopping page for {string} coco")
    public void clickYestoTobaccoQuestion(String tobaccoUsageYesOrNo, String member){
        startShoppingCoCoPage.selectTobaccoUsagecoco(tobaccoUsageYesOrNo, member);}

    @And("I get the application id from the url from tobacco page coco")
    public void getApplicationId(){
        startShoppingCoCoPage.getApplicationId();
    }

}
