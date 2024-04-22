package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiVaHealthcarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiVaHealthcareSteps {
    OhiVaHealthcarePage ohiVaHealthcarePage = new OhiVaHealthcarePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the VA Healthcare page")
    public void iClickGoBack(){ohiVaHealthcarePage.clickGoBack();
    }

    @Then("I click continue on the Elmo OHI VA Healthcare page")
    public void iClickSaveAndContinue(){ohiVaHealthcarePage.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in VA Healthcare question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiVaHealthcarePage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in VA Healthcare question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiVaHealthcarePage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter end date of end of current month for VA Healthcare")
    public void iEnterEndDate(){ohiVaHealthcarePage.enterEndDate();}

    @Then("I click {string} for insurance ending voluntary for VA Healthcare question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiVaHealthcarePage.clickEndVoluntaryOption(voluntaryEnding);}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the VA Healthcare page")
    public void iVerifyHeadersIndividualInsuranceOhiPageEnglish(){ohiVaHealthcarePage.verifyHeadersVaHealthcareOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the VA Healthcare page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiVaHealthcarePage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the VA Healthcare page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiVaHealthcarePage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the VA Healthcare page")
    public void iVerifyEndDate(){ohiVaHealthcarePage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the VA Healthcare page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiVaHealthcarePage.verifyVoluntaryEndingOption(voluntaryEnding);}






}
