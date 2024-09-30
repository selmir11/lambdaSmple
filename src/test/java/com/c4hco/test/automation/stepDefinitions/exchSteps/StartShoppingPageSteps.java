package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.StartShoppingPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

import java.util.List;

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

    @Then("I select {string} {string} for Tobacco Use")
    public void isMemberTobaccoUser(String member, String YNTobaccoUser){startShoppingPage.isMemberTobaccoUser(member, YNTobaccoUser);}

    @Then("I click Go Back on start shopping page")
    public void clickGoBackStartShoppingPage(){
        startShoppingPage.iclickGoBack();
    }

    @Then("I click Yes to the Tobacco usage question on start shopping page")
    public void clickYestoTobaccoQuestion(List<String> tobaccoUsageUserDetails){
        startShoppingPage.tobaccoPage(tobaccoUsageUserDetails);
    }

}
