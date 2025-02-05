package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.GoodNewsMAPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class GoodNewsMAPageSteps {

    GoodNewsMAPage goodNewsMAPage = new GoodNewsMAPage(WebDriverManager.getDriver());

    @Then("I click on {string} on good news page")
    public void iClickNextOption(String nextOption) {goodNewsMAPage.clickNextOption(nextOption);}

    @Then("I verify text that the member eligible for MA on the Good News page")
    public void iVerifyTextThatTheMemberEligibleForMAOnTheGoodNewsPage() {
        goodNewsMAPage.verifyTextMAEligibility();
    }
}
