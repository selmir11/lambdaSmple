package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcCobraPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcCobraSteps {
    OhcCobraPage OhcCobraPage = new OhcCobraPage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC Cobra page")
    public void iClickSaveAndContinue(){OhcCobraPage.clickSaveAndContinue();}

    @Then("I click Go Back on the OHC Cobra page")
    public void iClickGoBack(){OhcCobraPage.clickGoBack();}

    @Then("I click {string} for currently enrolled in COBRA question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){OhcCobraPage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in COBRA question")
    public void iClickInsuranceEndingOption(String insuranceEnding){OhcCobraPage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Cobra page")
    public void iEnterEndDate(String endDateData){OhcCobraPage.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for COBRA question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){OhcCobraPage.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the Cobra Page")
    public void iSelectHelpIcon(String labelIcon){OhcCobraPage.clickHelpIcon(labelIcon);}

    @And("I click Cobra Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){OhcCobraPage.clickHelpContactUsNavigation();}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Cobra page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){OhcCobraPage.verifyHeadersCobraOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Cobra page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){OhcCobraPage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Cobra page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){OhcCobraPage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Cobra page")
    public void iVerifyEndDate(){OhcCobraPage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Cobra page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){OhcCobraPage.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Cobra page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {OhcCobraPage.verifyCobraPageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Cobra page")
    public void iVerifyErrorMessage(String errorType, String language){OhcCobraPage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Cobra page")
    public void iVerifyNoErrorMessage(String errorType)  {OhcCobraPage.verifyNoErrorMessage(errorType);}

    @Then("I validate Cobra {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){OhcCobraPage.validateHelpVerbiage(helpData,language);}




}
