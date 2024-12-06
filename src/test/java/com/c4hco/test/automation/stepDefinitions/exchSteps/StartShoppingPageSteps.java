package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.StartShoppingPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StartShoppingPageSteps {
    StartShoppingPage startShoppingPage = new StartShoppingPage(WebDriverManager.getDriver());

    @Then("I click continue on start shopping page")
    public void clickContinueStartShoppingPage(){
        startShoppingPage.iclickContinue();
    }

    @Then("I verify text on start shopping page")
    public void verifyText()  {
        startShoppingPage.verifyTextOnTobaccoPage();
    }

    @Then("I click save and exit on start shopping page")
    public void clickSaveAndExit() {
        startShoppingPage.clickBtnSaveNExit();
    }

    @Then("I click Go Back on start shopping page")
    public void clickGoBackStartShoppingPage(){
        startShoppingPage.iclickGoBack();

    }

    @Then("I click Yes to the Tobacco usage question on start shopping page")
    public void clickYestoTobaccoQuestion(String tobaccoUsageUserDetails){
        startShoppingPage.enterTobaccoUsageInfo(tobaccoUsageUserDetails);}


    // use the initial segment of the member name if specified
    @Then("I select Tobacco Usage Yes for the {string} member")
    public void enterTobaccoUsageInfo(String tobaccoUsageDetails){
        startShoppingPage.enterTobaccoUsageInfo(tobaccoUsageDetails);
    }

}
