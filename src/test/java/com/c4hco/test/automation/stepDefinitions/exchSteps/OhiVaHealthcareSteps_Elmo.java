package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiVaHealthcarePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiVaHealthcareSteps_Elmo {
    OhiVaHealthcarePage_Elmo ohiVaHealthcarePage_Elmo = new OhiVaHealthcarePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI VA Healthcare page")
    public void iClickSaveAndContinue(){ohiVaHealthcarePage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHI VA Healthcare page")
    public void iClickGoBack(){ohiVaHealthcarePage_Elmo.clickGoBack();}

    @Then("I click {string} for currently enrolled in VA Healthcare question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiVaHealthcarePage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in VA Healthcare question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiVaHealthcarePage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the VA Healthcare page")
    public void iEnterEndDate(String endDate){ohiVaHealthcarePage_Elmo.enterEndDate(endDate);}

    @Then("I click {string} for insurance ending voluntary for VA Healthcare question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiVaHealthcarePage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the VA Healthcare page in {string}")
    public void iVerifyHeadersIndividualInsuranceOhiPage(String language){ohiVaHealthcarePage_Elmo.verifyHeadersVaHealthcareOhiPage(language);}

    @And("I verify Currently Enrolled is {string} on the VA Healthcare page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiVaHealthcarePage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the VA Healthcare page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiVaHealthcarePage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the VA Healthcare page")
    public void iVerifyEndDate(){ohiVaHealthcarePage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the VA Healthcare page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiVaHealthcarePage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} VA Healthcare page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {ohiVaHealthcarePage_Elmo.verifyVaHealthcarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the VA Healthcare page")
    public void iVerifyErrorMessage(String errorType, String language){ohiVaHealthcarePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for VA Healthcare page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiVaHealthcarePage_Elmo.verifyNoErrorMessage(errorType);}





}
