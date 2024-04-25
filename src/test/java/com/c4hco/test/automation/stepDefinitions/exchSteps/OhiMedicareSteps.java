package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiMedicarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiMedicareSteps {
    OhiMedicarePage ohiMedicarePage = new OhiMedicarePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the Medicare page")
    public void iClickGoBack(){ohiMedicarePage.clickGoBack();
    }@Then("I click continue on the Elmo OHI Medicare page")
    public void iClickSaveAndContinue(){ohiMedicarePage.clickSaveAndContinue();}

    @Then("I click {string} for currently eligible in Medicare question")
    public void iClickCurrentlyEligibleOption(String currentlyEnrolled){ohiMedicarePage.clickCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I check checkbox for Part {string}")
    public void iClickInsurancePartOption(String insurancePart){ohiMedicarePage.clickInsurancePartOption(insurancePart);}

    @Then("I click {string} for Part {string} insurance ending in 60 days in Medicare question")
    public void iClickInsuranceEndingPartOption(String insuranceEnding, String part){ohiMedicarePage.clickInsuranceEndingPartOption(insuranceEnding, part);}

    @Then("I enter Part A amount of {string}")
    public void iEnterPartAAmount(String premiumAmount){ohiMedicarePage.enterPartAAmount(premiumAmount);}

    @Then("I enter end date of end of current month for Medicare part {string}")
    public void iEnterEndDate(String insurancePart){ohiMedicarePage.enterEndDate(insurancePart);}













    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Medicare page")
    public void iVerifyTextOnOtherHealthInsurancePage(){ohiMedicarePage.verifyHeadersMedicareOhiPageEnglish();}

    @And("I verify initial questions on the Medicare page in {string}")
    public void iVerifyInitialQuestions(String language){ohiMedicarePage.verifyInitialQuestions(language);}

    @And("I verify Part A {string} and Part B {string} checked on the Medicare page")
    public void iVerifyCheckboxes(String boxA, String boxB){ohiMedicarePage.verifyCheckboxes(boxA, boxB);}

    @And("I verify Currently eligible is {string} on the Medicare page")
    public void iVerifyCurrentlyEligibleOption(String currentlyEnrolled){ohiMedicarePage.verifyCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I verify Part A amount of {string}")
    public void iVerifyPartAPremiumAmount(String premiumAmount){ohiMedicarePage.verifyPartAPremiumAmount(premiumAmount);}

    @And("I verify Part {string} Insurance Ending in 60 days is {string} on the Medicare page")
    public void iVerifyPartInsuranceEndingOption(String part, String insuranceEnding){ohiMedicarePage.verifyPartInsuranceEndingOption(part, insuranceEnding);}

    @And("I verify Part {string} end date is the last day of the month on the Medicare page")
    public void iVerifyPartEndDate(String part){ohiMedicarePage.verifyPartEndDate(part);}

    

}
