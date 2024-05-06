package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.OhiPeaceCorpsPage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiPeaceCorpsSteps_Elmo {
    OhiPeaceCorpsPage_Elmo ohiPeaceCorpsPage_Elmo = new OhiPeaceCorpsPage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI Peace Corps page")
    public void iClickSaveAndContinue(){ohiPeaceCorpsPage_Elmo.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in Peace Corps question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){ohiPeaceCorpsPage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Peace Corps question")
    public void iClickInsuranceEndingOption(String insuranceEnding){ohiPeaceCorpsPage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter end date of end of current month for Peace Corps")
    public void iEnterEndDate(){ohiPeaceCorpsPage_Elmo.enterEndDate();}

    @Then("I click {string} for insurance ending voluntary for Peace Corps question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){ohiPeaceCorpsPage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Peace Corps page")
    public void iVerifyTextOnOtherHealthInsurancePage(){ohiPeaceCorpsPage_Elmo.verifyHeadersPeaceCorpsOhiPageEnglish();}

    @And("I verify Currently Enrolled is {string} on the Peace Corps page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){ohiPeaceCorpsPage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Peace Corps page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){ohiPeaceCorpsPage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Peace Corps page")
    public void iVerifyEndDate(){ohiPeaceCorpsPage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Peace Corps page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){ohiPeaceCorpsPage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}
    
    
    
    
}
