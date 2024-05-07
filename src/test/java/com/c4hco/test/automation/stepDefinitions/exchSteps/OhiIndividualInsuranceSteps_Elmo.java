package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiIndividualInsurancePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiIndividualInsuranceSteps_Elmo {
    OhiIndividualInsurancePage_Elmo ohiIndividualInsurancePage_Elmo = new OhiIndividualInsurancePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI Individual Insurance page")
    public void iClickSaveAndContinue(){ohiIndividualInsurancePage_Elmo.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in Individual Insurance question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiIndividualInsurancePage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Individual Insurance question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiIndividualInsurancePage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter end date of end of current month for Individual Insurance")
    public void iEnterEndDate(){ohiIndividualInsurancePage_Elmo.enterEndDate();}

    @Then("I click {string} for insurance ending voluntary for Individual Insurance question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiIndividualInsurancePage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Individual Insurance page")
    public void iVerifyHeadersIndividualInsuranceOhiPageEnglish(){ohiIndividualInsurancePage_Elmo.verifyHeadersIndividualInsuranceOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the Individual Insurance page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiIndividualInsurancePage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify {string} error in {string} on the Individual Insurance page")
    public void iVerifyErrorMessage(String errorType, String language){ohiIndividualInsurancePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Individual Insurance page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiIndividualInsurancePage_Elmo.verifyNoErrorMessage(errorType);}

    @And("I verify Insurance Ending in 60 days is {string} on the Individual Insurance page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiIndividualInsurancePage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Individual Insurance page")
    public void iVerifyEndDate(){ohiIndividualInsurancePage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Individual Insurance page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiIndividualInsurancePage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}




}
