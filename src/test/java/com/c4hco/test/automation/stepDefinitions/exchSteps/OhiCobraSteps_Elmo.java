package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiCobraPage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiCobraSteps_Elmo {
    OhiCobraPage_Elmo ohiCobraPage_Elmo = new OhiCobraPage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI Cobra page")
    public void iClickSaveAndContinue(){ohiCobraPage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHI Cobra page")
    public void iClickGoBack(){ohiCobraPage_Elmo.clickGoBack();}

    @Then("I click {string} for currently enrolled in COBRA question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiCobraPage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in COBRA question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiCobraPage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Cobra page")
    public void iEnterEndDate(String endDate){ohiCobraPage_Elmo.enterEndDate(endDate);}

    @Then("I click {string} for insurance ending voluntary for COBRA question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiCobraPage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Cobra page")
    public void iVerifyTextOnOtherHealthInsurancePage(){ohiCobraPage_Elmo.verifyHeadersCobraOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the Cobra page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiCobraPage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Cobra page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiCobraPage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Cobra page")
    public void iVerifyEndDate(){ohiCobraPage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Cobra page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiCobraPage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Cobra page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {ohiCobraPage_Elmo.verifyCobraPageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Cobra page")
    public void iVerifyErrorMessage(String errorType, String language){ohiCobraPage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Cobra page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiCobraPage_Elmo.verifyNoErrorMessage(errorType);}




}
