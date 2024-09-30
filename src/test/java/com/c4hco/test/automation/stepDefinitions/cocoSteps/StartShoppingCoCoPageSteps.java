package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.StartShoppingCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

import java.util.List;

public class StartShoppingCoCoPageSteps {

    StartShoppingCoCoPage startShoppingCoCoPage = new StartShoppingCoCoPage(WebDriverManager.getDriver());

    @Then("I click continue on coco start shopping page")
    public void clickContinueStartShoppingPage() {
        startShoppingCoCoPage.iclickContinue();
    }

    @Then("I click save and exit on coco start shopping page")
    public void clickSaveAndExit() {
        startShoppingCoCoPage.clickBtnSaveNExit();
    }

    @Then("I select {string} {string} for Tobacco Use coco")
    public void tobaccoUser(String member, String YNTobaccoUser) {
        startShoppingCoCoPage.memberTobaccoUser(member, YNTobaccoUser);
    }

    @Then("I click Yes to the Tobacco usage question on coco start shopping page")
    public void tobaccoYesUser(List<String> tobaccoUsageUserDetails) {
        startShoppingCoCoPage.tobaccoPage(tobaccoUsageUserDetails);
    }


}
