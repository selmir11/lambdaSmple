package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcVaHealthcarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcVaHealthcareSteps {
    OhcVaHealthcarePage OhcVaHealthcarePage = new OhcVaHealthcarePage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC VA Healthcare page")
    public void iClickSaveAndContinue(){OhcVaHealthcarePage.clickSaveAndContinue();}

    @Then("I click Go Back on the OHC VA Healthcare page")
    public void iClickGoBack(){OhcVaHealthcarePage.clickGoBack();}

    @Then("I click {string} for currently enrolled in VA Healthcare question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){OhcVaHealthcarePage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in VA Healthcare question")
    public void iClickInsuranceEndingOption(String insuranceEnding){OhcVaHealthcarePage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the VA Healthcare page")
    public void iEnterEndDate(String endDateData){OhcVaHealthcarePage.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for VA Healthcare question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){OhcVaHealthcarePage.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the VA Healthcare Page")
    public void iSelectHelpIcon(String labelIcon){OhcVaHealthcarePage.clickHelpIcon(labelIcon);}

    @And("I click VA Healthcare Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){OhcVaHealthcarePage.clickHelpContactUsNavigation();}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the VA Healthcare page in {string}")
    public void iVerifyHeadersIndividualInsuranceOhcPage(String language){OhcVaHealthcarePage.verifyHeadersVaHealthcareOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the VA Healthcare page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){OhcVaHealthcarePage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the VA Healthcare page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){OhcVaHealthcarePage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the VA Healthcare page")
    public void iVerifyEndDate(){OhcVaHealthcarePage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the VA Healthcare page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){OhcVaHealthcarePage.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} VA Healthcare page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {OhcVaHealthcarePage.verifyVaHealthcarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the VA Healthcare page")
    public void iVerifyErrorMessage(String errorType, String language){OhcVaHealthcarePage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for VA Healthcare page")
    public void iVerifyNoErrorMessage(String errorType)  {OhcVaHealthcarePage.verifyNoErrorMessage(errorType);}

    @Then("I validate VA Healthcare {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){OhcVaHealthcarePage.validateHelpVerbiage(helpData,language);}





}
