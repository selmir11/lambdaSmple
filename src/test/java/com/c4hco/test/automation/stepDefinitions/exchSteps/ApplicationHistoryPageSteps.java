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

    @And("I set the updated premiums based on new aptc value")
    public void setUpdatedPremiums(){
        applicationHistoryPage.setUpdatedPremiums();
    }

    @And("I go back to Account Overview Page from My Eligibility")
    public void backToWelcomePage(){
        applicationHistoryPage.backToWelcomePage();
    }

    @Then("I validate that {string} text displays on the Application History page")
    public void validateText(String Text){applicationHistoryPage.validateTextOnPage(Text);}

    @Then("I validate that {string} text does not display on the Application History page")
    public void validateTextDNI(String Text){applicationHistoryPage.validateTextDoesNotExistOnPage(Text);}

    @Then("I validate member is eligible for a Qualified Health Plan")
    public void iValidateMemberIsEligibleForQHP() {
        applicationHistoryPage.validateTextOnPage("Qualified Health Plan");
    }

    @Then("I validate the aptc section doesn't exist on the application history page")
    public void noAptcOnPage(){
        applicationHistoryPage.validateAptcSectionDoesntExist();
    }

    @Then("I click {string} on Before you continue popup on the application history page")
    public void clickVerifyMyInfo(String popUpOption){applicationHistoryPage.clickVerifyMyInfoText(popUpOption);}

    @Then("I validate member is not eligible for MA")
    public void iValidateMemberEligibilityForMA() {applicationHistoryPage.validateMemberEligibilityForMA();}


    @Then("I validate that {string} text displays on the Application History page in Spanish")
    public void iValidateTextOnTheApplicationHistoryPageInSpanish(String text) {
        applicationHistoryPage.validatetextWithNoPolicy(text);
    }

    @And( "I validate the {string} text on the Application History page" )
    public void iValidateApplicationHistoryText(String language) {applicationHistoryPage.iValidateApplicationHistoryText(language);}
}
