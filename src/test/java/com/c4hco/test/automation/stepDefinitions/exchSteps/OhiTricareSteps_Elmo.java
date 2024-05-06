package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.OhiTricarePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiTricareSteps_Elmo {
    OhiTricarePage_Elmo ohiTricarePage_Elmo = new OhiTricarePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI Tricare page")
    public void iClickSaveAndContinue(){ohiTricarePage_Elmo.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in Tricare question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiTricarePage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Tricare question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiTricarePage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter end date of end of current month for Tricare")
    public void iEnterEndDate(){ohiTricarePage_Elmo.enterEndDate();}

    @Then("I click {string} for insurance ending voluntary for Tricare question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiTricarePage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}







    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Tricare page")
    public void iVerifyTextOnOtherHealthInsurancePage(){ohiTricarePage_Elmo.verifyHeadersTricareOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the Tricare page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiTricarePage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Tricare page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiTricarePage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Tricare page")
    public void iVerifyEndDate(){ohiTricarePage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Tricare page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiTricarePage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Tricare page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {ohiTricarePage_Elmo.verifyVaHealthcarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Tricare page")
    public void iVerifyErrorMessage(String errorType, String language){ohiTricarePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Tricare page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiTricarePage_Elmo.verifyNoErrorMessage(errorType);}









}
