package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiRetireeHealthPlanPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiRetireeHealthPlanSteps {
    OhiRetireeHealthPlanPage ohiRetireeHealthPlanPage = new OhiRetireeHealthPlanPage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the Retiree Health Plan page")
    public void iClickGoBack(){ohiRetireeHealthPlanPage.clickGoBack();
    }

    @Then("I click continue on the Elmo OHI Retiree page")
    public void iClickSaveAndContinue(){ohiRetireeHealthPlanPage.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in Retiree question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiRetireeHealthPlanPage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Retiree question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiRetireeHealthPlanPage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter end date of end of current month for Retiree")
    public void iEnterEndDate(){ohiRetireeHealthPlanPage.enterEndDate();}

    @Then("I click {string} for insurance ending voluntary for Retiree question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiRetireeHealthPlanPage.clickEndVoluntaryOption(voluntaryEnding);}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Retiree page")
    public void iVerifyTextOnOtherHealthInsurancePage(){ohiRetireeHealthPlanPage.verifyHeadersRetireeOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the Retiree page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiRetireeHealthPlanPage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Retiree page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiRetireeHealthPlanPage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Retiree page")
    public void iVerifyEndDate(){ohiRetireeHealthPlanPage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Retiree page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiRetireeHealthPlanPage.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Retiree page data in {string}")
    public void iVerifyRetireePageData(String dataToVerify, String language) {ohiRetireeHealthPlanPage.verifyRetireePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Retiree page")
    public void iVerifyErrorMessage(String errorType, String language){ohiRetireeHealthPlanPage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Retiree page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiRetireeHealthPlanPage.verifyNoErrorMessage(errorType);}




}
