package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcMedicarePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcMedicareSteps_Elmo {
    OhcMedicarePage_Elmo OhcMedicarePage_Elmo = new OhcMedicarePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHC Medicare page")
    public void iClickSaveAndContinue(){OhcMedicarePage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHC Medicare page")
    public void clickGoBack(){OhcMedicarePage_Elmo.clickGoBack();}

    @Then("I click {string} for currently eligible in Medicare question")
    public void iClickCurrentlyEligibleOption(String currentlyEnrolled){OhcMedicarePage_Elmo.clickCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I check checkbox for Part {string}")
    public void iClickInsurancePartOption(String insurancePart){OhcMedicarePage_Elmo.clickInsurancePartOption(insurancePart);}

    @Then("I click {string} for Part {string} insurance ending in 60 days in Medicare question")
    public void iClickInsuranceEndingPartOption(String insuranceEnding, String part){OhcMedicarePage_Elmo.clickInsuranceEndingPartOption(insuranceEnding, part);}

    @Then("I enter Part A amount of {string}")
    public void iEnterPartAAmount(String premiumAmount){OhcMedicarePage_Elmo.enterPartAAmount(premiumAmount);}

    @Then("I enter end date of {string} for Medicare part {string}")
    public void iEnterEndDate(String endDateData, String insurancePart){OhcMedicarePage_Elmo.enterEndDate(endDateData, insurancePart);}

    @And("I select {string} icon on the Medicare Page")
    public void iSelectHelpIcon(String labelIcon){OhcMedicarePage_Elmo.clickHelpIcon(labelIcon);}

    @And("I click Medicare Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){OhcMedicarePage_Elmo.clickHelpContactUsNavigation();}

    @And("I click Medicare DOI link in help drawer")
    public void iClickHelpDoiLink(){OhcMedicarePage_Elmo.clickHelpDoiNavigation();}













    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for {string} Member on the Medicare page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String member, String language){OhcMedicarePage_Elmo.verifyHeadersMedicareOhcPage(member, language);}

    @And("I verify initial questions on the Medicare page in {string}")
    public void iVerifyInitialQuestions(String language){OhcMedicarePage_Elmo.verifyInitialQuestions(language);}

    @And("I verify Part A {string} and Part B {string} checked on the Medicare page")
    public void iVerifyCheckboxes(String boxA, String boxB){OhcMedicarePage_Elmo.verifyCheckboxes(boxA, boxB);}

    @And("I verify Currently eligible is {string} on the Medicare page")
    public void iVerifyCurrentlyEligibleOption(String currentlyEnrolled){OhcMedicarePage_Elmo.verifyCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I verify Part A amount of {string}")
    public void iVerifyPartAPremiumAmount(String premiumAmount){OhcMedicarePage_Elmo.verifyPartAPremiumAmount(premiumAmount);}

    @And("I verify Part {string} Insurance Ending in 60 days is {string} on the Medicare page")
    public void iVerifyPartInsuranceEndingOption(String part, String insuranceEnding){OhcMedicarePage_Elmo.verifyPartInsuranceEndingOption(part, insuranceEnding);}

    @And("I verify Part {string} end date is the last day of the month on the Medicare page")
    public void iVerifyPartEndDate(String part){OhcMedicarePage_Elmo.verifyPartEndDate(part);}

    @And("I verify the {string} Medicare page data in {string}")
    public void iVerifyMedicarePageData(String dataToVerify, String language) {OhcMedicarePage_Elmo.verifyMedicarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Medicare page")
    public void iVerifyErrorMessage(String errorType, String language){OhcMedicarePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Medicare page")
    public void iVerifyNoErrorMessage(String errorType)  {OhcMedicarePage_Elmo.verifyNoErrorMessage(errorType);}

    @Then("I validate Medicare help drawer verbiage in {string}")
    public void iValidateHelp(String language){OhcMedicarePage_Elmo.validateHelpVerbiage(language);}

    @Then("I verify Medicare checkbox in {string} state")
    public void iVerifyStateOfMedicareCheckboxes(String state){
        OhcMedicarePage_Elmo.verifyMedicareCheckboxes(state);}


}
