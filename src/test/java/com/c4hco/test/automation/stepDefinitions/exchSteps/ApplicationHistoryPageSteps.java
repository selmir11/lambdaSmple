package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationHistoryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class ApplicationHistoryPageSteps {
    ApplicationHistoryPage applicationHistoryPage = new ApplicationHistoryPage(WebDriverManager.getDriver());

    @Then("I validate that my APTC value is {string}")
    public void validateAPTC(String expectedAPTC){applicationHistoryPage.validateAPTC(expectedAPTC);}

    @Then("I click on view results and shop")
    public void clickViewResultsNSHop(){
        applicationHistoryPage.clickViewResults();
    }

    @Then("I validate that {string} text displays on the Application History page")
    public void validateText(String Text){applicationHistoryPage.validateTextOnPage(Text);}

    @Then("I validate that {string} text does not display on the Application History page")
    public void validateTextDNI(String Text){applicationHistoryPage.validateTextDoesNotExistOnPage(Text);}
}
