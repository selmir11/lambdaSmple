package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiIndividualInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiIndividualInsuranceSteps {
    OhiIndividualInsurancePage ohiIndividualInsurancePage = new OhiIndividualInsurancePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the Individual Insurance page")
    public void iClickGoBack(){ohiIndividualInsurancePage.clickGoBack();
    }

    @Then("I click continue on the Elmo OHI Individual Insurance page")
    public void iClickSaveAndContinue(){ohiIndividualInsurancePage.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in Individual Insurance question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiIndividualInsurancePage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Individual Insurance question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiIndividualInsurancePage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter end date of end of current month for Individual Insurance")
    public void iEnterEndDate(){ohiIndividualInsurancePage.enterEndDate();}

    @Then("I click {string} for insurance ending voluntary for Individual Insurance question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiIndividualInsurancePage.clickEndVoluntaryOption(voluntaryEnding);}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Individual Insurance page")
    public void iVerifyHeadersIndividualInsuranceOhiPageEnglish(){ohiIndividualInsurancePage.verifyHeadersIndividualInsuranceOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the Individual Insurance page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiIndividualInsurancePage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Individual Insurance page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiIndividualInsurancePage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Individual Insurance page")
    public void iVerifyEndDate(){ohiIndividualInsurancePage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Individual Insurance page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiIndividualInsurancePage.verifyVoluntaryEndingOption(voluntaryEnding);}




}
