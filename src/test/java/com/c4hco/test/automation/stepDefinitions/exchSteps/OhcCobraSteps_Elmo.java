package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcCobraPage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcCobraSteps_Elmo {
    OhcCobraPage_Elmo OhcCobraPage_Elmo = new OhcCobraPage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHC Cobra page")
    public void iClickSaveAndContinue(){OhcCobraPage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHC Cobra page")
    public void iClickGoBack(){OhcCobraPage_Elmo.clickGoBack();}

    @Then("I click {string} for currently enrolled in COBRA question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){OhcCobraPage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in COBRA question")
    public void iClickInsuranceEndingOption(String insuranceEnding){OhcCobraPage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Cobra page")
    public void iEnterEndDate(String endDateData){OhcCobraPage_Elmo.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for COBRA question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){OhcCobraPage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the Cobra Page")
    public void iSelectHelpIcon(String labelIcon){OhcCobraPage_Elmo.clickHelpIcon(labelIcon);}

    @And("I click Cobra Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){OhcCobraPage_Elmo.clickHelpContactUsNavigation();}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Cobra page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){OhcCobraPage_Elmo.verifyHeadersCobraOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Cobra page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){OhcCobraPage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Cobra page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){OhcCobraPage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Cobra page")
    public void iVerifyEndDate(){OhcCobraPage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Cobra page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){OhcCobraPage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Cobra page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {OhcCobraPage_Elmo.verifyCobraPageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Cobra page")
    public void iVerifyErrorMessage(String errorType, String language){OhcCobraPage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Cobra page")
    public void iVerifyNoErrorMessage(String errorType)  {OhcCobraPage_Elmo.verifyNoErrorMessage(errorType);}

    @Then("I validate Cobra {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){OhcCobraPage_Elmo.validateHelpVerbiage(helpData,language);}




}
