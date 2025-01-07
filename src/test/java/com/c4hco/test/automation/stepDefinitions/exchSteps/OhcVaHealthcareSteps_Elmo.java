package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcVaHealthcarePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcVaHealthcareSteps_Elmo {
    OhcVaHealthcarePage_Elmo OhcVaHealthcarePage_Elmo = new OhcVaHealthcarePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHC VA Healthcare page")
    public void iClickSaveAndContinue(){OhcVaHealthcarePage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHC VA Healthcare page")
    public void iClickGoBack(){OhcVaHealthcarePage_Elmo.clickGoBack();}

    @Then("I click {string} for currently enrolled in VA Healthcare question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){OhcVaHealthcarePage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in VA Healthcare question")
    public void iClickInsuranceEndingOption(String insuranceEnding){OhcVaHealthcarePage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the VA Healthcare page")
    public void iEnterEndDate(String endDateData){OhcVaHealthcarePage_Elmo.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for VA Healthcare question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){OhcVaHealthcarePage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the VA Healthcare Page")
    public void iSelectHelpIcon(String labelIcon){OhcVaHealthcarePage_Elmo.clickHelpIcon(labelIcon);}

    @And("I click VA Healthcare Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){OhcVaHealthcarePage_Elmo.clickHelpContactUsNavigation();}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the VA Healthcare page in {string}")
    public void iVerifyHeadersIndividualInsuranceOhcPage(String language){OhcVaHealthcarePage_Elmo.verifyHeadersVaHealthcareOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the VA Healthcare page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){OhcVaHealthcarePage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the VA Healthcare page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){OhcVaHealthcarePage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the VA Healthcare page")
    public void iVerifyEndDate(){OhcVaHealthcarePage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the VA Healthcare page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){OhcVaHealthcarePage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} VA Healthcare page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {OhcVaHealthcarePage_Elmo.verifyVaHealthcarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the VA Healthcare page")
    public void iVerifyErrorMessage(String errorType, String language){OhcVaHealthcarePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for VA Healthcare page")
    public void iVerifyNoErrorMessage(String errorType)  {OhcVaHealthcarePage_Elmo.verifyNoErrorMessage(errorType);}

    @Then("I validate VA Healthcare {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){OhcVaHealthcarePage_Elmo.validateHelpVerbiage(helpData,language);}





}
