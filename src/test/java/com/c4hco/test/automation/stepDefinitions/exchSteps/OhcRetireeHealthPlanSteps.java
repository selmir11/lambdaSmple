package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcRetireeHealthPlanPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcRetireeHealthPlanSteps {
    OhcRetireeHealthPlanPage OhcRetireeHealthPlanPage = new OhcRetireeHealthPlanPage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC Retiree page")
    public void iClickSaveAndContinue(){OhcRetireeHealthPlanPage.clickSaveAndContinue();}

    @Then("I click Go Back on the OHC Retiree page")
    public void iClickGoBack(){OhcRetireeHealthPlanPage.clickGoBack();}

    @Then("I click {string} for currently enrolled in Retiree question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){OhcRetireeHealthPlanPage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Retiree question")
    public void iClickInsuranceEndingOption(String insuranceEnding){OhcRetireeHealthPlanPage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Retiree page")
    public void iEnterEndDate(String endDateData){OhcRetireeHealthPlanPage.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for Retiree question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){OhcRetireeHealthPlanPage.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the Retiree Page")
    public void iSelectHelpIcon(String labelIcon){OhcRetireeHealthPlanPage.clickHelpIcon(labelIcon);}

    @And("I click Retiree Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){OhcRetireeHealthPlanPage.clickHelpContactUsNavigation();}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Retiree page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){OhcRetireeHealthPlanPage.verifyHeadersRetireeOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Retiree page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){OhcRetireeHealthPlanPage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Retiree page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){OhcRetireeHealthPlanPage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Retiree page")
    public void iVerifyEndDate(){OhcRetireeHealthPlanPage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Retiree page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){OhcRetireeHealthPlanPage.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Retiree page data in {string}")
    public void iVerifyRetireePageData(String dataToVerify, String language) {OhcRetireeHealthPlanPage.verifyRetireePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Retiree page")
    public void iVerifyErrorMessage(String errorType, String language){OhcRetireeHealthPlanPage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Retiree page")
    public void iVerifyNoErrorMessage(String errorType)  {OhcRetireeHealthPlanPage.verifyNoErrorMessage(errorType);}

    @Then("I validate Retiree {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){OhcRetireeHealthPlanPage.validateHelpVerbiage(helpData,language);}



}
