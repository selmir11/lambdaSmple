package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiMedicarePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiMedicareSteps_Elmo {
    OhiMedicarePage_Elmo ohiMedicarePage_Elmo = new OhiMedicarePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI Medicare page")
    public void iClickSaveAndContinue(){ohiMedicarePage_Elmo.clickSaveAndContinue();}

    @Then("I click {string} for currently eligible in Medicare question")
    public void iClickCurrentlyEligibleOption(String currentlyEnrolled){ohiMedicarePage_Elmo.clickCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I check checkbox for Part {string}")
    public void iClickInsurancePartOption(String insurancePart){ohiMedicarePage_Elmo.clickInsurancePartOption(insurancePart);}

    @Then("I click {string} for Part {string} insurance ending in 60 days in Medicare question")
    public void iClickInsuranceEndingPartOption(String insuranceEnding, String part){ohiMedicarePage_Elmo.clickInsuranceEndingPartOption(insuranceEnding, part);}

    @Then("I enter Part A amount of {string}")
    public void iEnterPartAAmount(String premiumAmount){ohiMedicarePage_Elmo.enterPartAAmount(premiumAmount);}

    @Then("I enter end date of end of current month for Medicare part {string}")
    public void iEnterEndDate(String insurancePart){ohiMedicarePage_Elmo.enterEndDate(insurancePart);}













    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Medicare page")
    public void iVerifyTextOnOtherHealthInsurancePage(){ohiMedicarePage_Elmo.verifyHeadersMedicareOhiPageEnglish();}

    @And("I verify initial questions on the Medicare page in {string}")
    public void iVerifyInitialQuestions(String language){ohiMedicarePage_Elmo.verifyInitialQuestions(language);}

    @And("I verify Part A {string} and Part B {string} checked on the Medicare page")
    public void iVerifyCheckboxes(String boxA, String boxB){ohiMedicarePage_Elmo.verifyCheckboxes(boxA, boxB);}

    @And("I verify Currently eligible is {string} on the Medicare page")
    public void iVerifyCurrentlyEligibleOption(String currentlyEnrolled){ohiMedicarePage_Elmo.verifyCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I verify Part A amount of {string}")
    public void iVerifyPartAPremiumAmount(String premiumAmount){ohiMedicarePage_Elmo.verifyPartAPremiumAmount(premiumAmount);}

    @And("I verify Part {string} Insurance Ending in 60 days is {string} on the Medicare page")
    public void iVerifyPartInsuranceEndingOption(String part, String insuranceEnding){ohiMedicarePage_Elmo.verifyPartInsuranceEndingOption(part, insuranceEnding);}

    @And("I verify Part {string} end date is the last day of the month on the Medicare page")
    public void iVerifyPartEndDate(String part){ohiMedicarePage_Elmo.verifyPartEndDate(part);}

    @And("I verify the {string} Medicare page data in {string}")
    public void iVerifyMedicarePageData(String dataToVerify, String language) {ohiMedicarePage_Elmo.verifyMedicarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Medicare page")
    public void iVerifyErrorMessage(String errorType, String language){ohiMedicarePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Medicare page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiMedicarePage_Elmo.verifyNoErrorMessage(errorType);}




}
