package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcMedicarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcMedicareSteps {
    OhcMedicarePage OhcMedicarePage = new OhcMedicarePage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC Medicare page")
    public void iClickSaveAndContinue(){OhcMedicarePage.clickSaveAndContinue();}

    @Then("I click Go Back on the OHC Medicare page")
    public void clickGoBack(){OhcMedicarePage.clickGoBack();}

    @Then("I click {string} for currently eligible in Medicare question")
    public void iClickCurrentlyEligibleOption(String currentlyEnrolled){OhcMedicarePage.clickCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I check checkbox for Part {string}")
    public void iClickInsurancePartOption(String insurancePart){OhcMedicarePage.clickInsurancePartOption(insurancePart);}

    @Then("I click {string} for Part {string} insurance ending in 60 days in Medicare question")
    public void iClickInsuranceEndingPartOption(String insuranceEnding, String part){OhcMedicarePage.clickInsuranceEndingPartOption(insuranceEnding, part);}

    @Then("I enter Part A amount of {string}")
    public void iEnterPartAAmount(String premiumAmount){OhcMedicarePage.enterPartAAmount(premiumAmount);}

    @Then("I enter end date of {string} for Medicare part {string}")
    public void iEnterEndDate(String endDateData, String insurancePart){OhcMedicarePage.enterEndDate(endDateData, insurancePart);}

    @And("I select {string} icon on the Medicare Page")
    public void iSelectHelpIcon(String labelIcon){OhcMedicarePage.clickHelpIcon(labelIcon);}

    @And("I click Medicare Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){OhcMedicarePage.clickHelpContactUsNavigation();}

    @And("I click Medicare DOI link in help drawer")
    public void iClickHelpDoiLink(){OhcMedicarePage.clickHelpDoiNavigation();}













    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for {string} Member on the Medicare page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String member, String language){OhcMedicarePage.verifyHeadersMedicareOhcPage(member, language);}

    @And("I verify initial questions on the Medicare page in {string}")
    public void iVerifyInitialQuestions(String language){OhcMedicarePage.verifyInitialQuestions(language);}

    @And("I verify Part A {string} and Part B {string} checked on the Medicare page")
    public void iVerifyCheckboxes(String boxA, String boxB){OhcMedicarePage.verifyCheckboxes(boxA, boxB);}

    @And("I verify Currently eligible is {string} on the Medicare page")
    public void iVerifyCurrentlyEligibleOption(String currentlyEnrolled){OhcMedicarePage.verifyCurrentlyEligibleOption(currentlyEnrolled);}

    @Then("I verify Part A amount of {string}")
    public void iVerifyPartAPremiumAmount(String premiumAmount){OhcMedicarePage.verifyPartAPremiumAmount(premiumAmount);}

    @And("I verify Part {string} Insurance Ending in 60 days is {string} on the Medicare page")
    public void iVerifyPartInsuranceEndingOption(String part, String insuranceEnding){OhcMedicarePage.verifyPartInsuranceEndingOption(part, insuranceEnding);}

    @And("I verify Part {string} end date is the last day of the month on the Medicare page")
    public void iVerifyPartEndDate(String part){OhcMedicarePage.verifyPartEndDate(part);}

    @And("I verify the {string} Medicare page data in {string}")
    public void iVerifyMedicarePageData(String dataToVerify, String language) {OhcMedicarePage.verifyMedicarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Medicare page")
    public void iVerifyErrorMessage(String errorType, String language){OhcMedicarePage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Medicare page")
    public void iVerifyNoErrorMessage(String errorType)  {OhcMedicarePage.verifyNoErrorMessage(errorType);}

    @Then("I validate Medicare help drawer verbiage in {string}")
    public void iValidateHelp(String language){OhcMedicarePage.validateHelpVerbiage(language);}

    @Then("I verify Medicare checkbox in {string} state")
    public void iVerifyStateOfMedicareCheckboxes(String state){
        OhcMedicarePage.verifyMedicareCheckboxes(state);}


}
