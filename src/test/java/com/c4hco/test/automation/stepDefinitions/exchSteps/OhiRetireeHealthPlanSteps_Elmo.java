package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiRetireeHealthPlanPage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiRetireeHealthPlanSteps_Elmo {
    OhiRetireeHealthPlanPage_Elmo ohiRetireeHealthPlanPage_Elmo = new OhiRetireeHealthPlanPage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI Retiree page")
    public void iClickSaveAndContinue(){ohiRetireeHealthPlanPage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHI Retiree page")
    public void iClickGoBack(){ohiRetireeHealthPlanPage_Elmo.clickGoBack();}

    @Then("I click {string} for currently enrolled in Retiree question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiRetireeHealthPlanPage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Retiree question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiRetireeHealthPlanPage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Retiree page")
    public void iEnterEndDate(String endDate){ohiRetireeHealthPlanPage_Elmo.enterEndDate(endDate);}

    @Then("I click {string} for insurance ending voluntary for Retiree question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiRetireeHealthPlanPage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Retiree page")
    public void iVerifyTextOnOtherHealthInsurancePage(){ohiRetireeHealthPlanPage_Elmo.verifyHeadersRetireeOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the Retiree page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiRetireeHealthPlanPage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Retiree page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiRetireeHealthPlanPage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Retiree page")
    public void iVerifyEndDate(){ohiRetireeHealthPlanPage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Retiree page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiRetireeHealthPlanPage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Retiree page data in {string}")
    public void iVerifyRetireePageData(String dataToVerify, String language) {ohiRetireeHealthPlanPage_Elmo.verifyRetireePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Retiree page")
    public void iVerifyErrorMessage(String errorType, String language){ohiRetireeHealthPlanPage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Retiree page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiRetireeHealthPlanPage_Elmo.verifyNoErrorMessage(errorType);}



}
