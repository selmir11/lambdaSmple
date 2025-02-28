package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.FiveYearBarPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class FiveYearBarPageSteps {

    FiveYearBarPage FiveYearBarPage=new FiveYearBarPage(WebDriverManager.getDriver());

    @When("I click Help me understand this page link on five year bar page")
    public void iClickHelpMeUnderstandThisPageLinkOnFiveYearBarPage() {
        FiveYearBarPage.clickHelpMeUnderstandLink();
    }
    @Then("I validate help menu page text headers on five year bar page")
    public void iValidateHelpMenuPageTextOnFiveYearBarPage(List<String> languageText) {
        FiveYearBarPage.validatePageTextEnglishAndSpanish(languageText);
    }
}
