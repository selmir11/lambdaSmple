package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.ApplicationResultsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ApplicationResultsPageSteps {

    ApplicationResultsCoCoPage applicationResultsCoCoPage = new ApplicationResultsCoCoPage(WebDriverManager.getDriver());

    @And("I click on Go back to Welcome page Button on Application Results page CoCo")
    public void iBackToWelcomeButton(){
        applicationResultsCoCoPage.backToWelcomeButton();
    }

    @And("I click Continue on the Application Results Page CoCo")
    public void clickContinueButton(){applicationResultsCoCoPage.continueWithApplication();}

    @Then("I verify the header in {string} on the Application Results Page CoCo")
    public void iVerifyHeader(String language){applicationResultsCoCoPage.verifyHeader(language);}

    @Then("I verify text that the member don't qualify for a health plan on the App Results Page CoCo")
    public void verifyTextDoNotQualifyForHealthPlan(){applicationResultsCoCoPage.verifyTextNotQualifyForPlanOnAppResultsPage();
    }
    @Then("I verify text that the member qualifies for SES limited {string} on the Application Results Page CoCo")
    public void verifySESlimitedOnAppResultsPage(String language){applicationResultsCoCoPage.verifySESlimitedOnAppResultsPage(language);
    }

    @Then("I verify text that the member qualifies for SES and no spots are available in {string} on the App Results Page CoCo")
    public void verifySESClosedOnAppResultsPage(String language){applicationResultsCoCoPage.verifySESClosedOnAppResultsPage(language);
    }

    @Then("I verify text that the member qualifies for SES and spots are available in {string} on the App Results Page CoCo")
    public void verifySESOpenOnAppResultsPage(String language){applicationResultsCoCoPage.verifySESOpenOnAppResultsPage(language);
    }

    @Then("I verify eligible plan on Application Result page coco depends on SES")
    public void verifyEligiblePlan() {
        applicationResultsCoCoPage.verifyEligibleplans();
    }

    @Then("I validate that {string} results are displayed")
    public void validateResultsForYr(String year){
        applicationResultsCoCoPage.validateResultsOfYr(year);
    }

    @Then("I validate the text on the application results page coco")
    public void validateText(){
        applicationResultsCoCoPage.validateTextOnPage();
    }

    @Then("I validate eligible members list")
    public void validateEligibleMembers(){
        applicationResultsCoCoPage.validateEligibleMembers();
    }

}
