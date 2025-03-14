package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcEmployerSponsoredHealthInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class OhcEmployerSponsoredHealthInsuranceSteps {
    OhcEmployerSponsoredHealthInsurancePage ohcEmployerSponsoredHealthInsurancePage = new OhcEmployerSponsoredHealthInsurancePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the ESI page")
    public void iClickGoBack() {
        ohcEmployerSponsoredHealthInsurancePage.clickGoBack();
    }

    @Then("I select the {string} employer for {string} member on the ESI page")
    public void iSelectEmployer(String intString, String member) {
        ohcEmployerSponsoredHealthInsurancePage.selectEmployer(intString, member);
    }

    @Then("I select {string} for meet the Minimum Value Standard on the ESI page")
    public void iClickMinValueStandard(String minValueStandard) {
        ohcEmployerSponsoredHealthInsurancePage.clickMinValueStandard(minValueStandard);
    }

    @Then("I enter {string} for employee amount question on the ESI page")
    public void iEnterMonthlyAmount(String employeeAmount) {
        ohcEmployerSponsoredHealthInsurancePage.enterMonthlyAmount(employeeAmount);
    }

    @Then("I enter the end date as {string} on the ESI page")
    public void iEnterEndDate(String endDate) {
        ohcEmployerSponsoredHealthInsurancePage.enterEndDate(endDate);
    }

    @Then("I select the Are you voluntarily ending {string} button on the ESI page")
    public void iClickVoluntarilyEnding(String voluntarilyEnding) {
        ohcEmployerSponsoredHealthInsurancePage.clickVoluntarilyEnding(voluntarilyEnding);
    }

    @Then("I select the Are you currently enrolled {string} button on the ESI page")
    public void iClickCurrentlyEnrolled(String currentlyEnrolled) {
        ohcEmployerSponsoredHealthInsurancePage.clickCurrentlyEnrolled(currentlyEnrolled);
    }

    @Then("I select the Will Insurance End {string} button on the ESI page")
    public void iClickInsuranceEnd(String willEnd) {
        ohcEmployerSponsoredHealthInsurancePage.clickInsuranceEnd(willEnd);
    }

    @Then("I click {string} for offer family plans question")
    public void iClickFamilyPlansOffered(String currentlyOffered) {
        ohcEmployerSponsoredHealthInsurancePage.clickFamilyPlansOffered(currentlyOffered);
    }

    @Then("I enter {string} for offer family amount question")
    public void iEnterMonthlyFamilyAmount(String familyAmount) {
        ohcEmployerSponsoredHealthInsurancePage.enterMonthlyFamilyAmount(familyAmount);
    }

    @Then("I click enrollment status for the members")
    public void iClickFamilyEnrollmentStatusMembers(List<String> expectedValues) {
        ohcEmployerSponsoredHealthInsurancePage.clickFamilyEnrollmentStatusMembers(expectedValues);
    }

    @Then("I click continue on the ESI page")
    public void iClickSaveAndContinue() {
        ohcEmployerSponsoredHealthInsurancePage.clickSaveAndContinue();
    }

    @Then("I open or close the Help Drawer on the ESI page")
    public void iClickMainHelp() {
        ohcEmployerSponsoredHealthInsurancePage.clickMainHelp();
    }

    @Then("I open or close the {string} Help Drawer on the ESI page")
    public void iClickIconHelp(String iconName) {
        ohcEmployerSponsoredHealthInsurancePage.clickIconHelp(iconName);
    }

    @Then("I click on {string} link in Help Drawer on the ESI page")
    public void iClickHelpDrawerContactUs(String lnkName) {
        ohcEmployerSponsoredHealthInsurancePage.clickHelpDrawerContactUs(lnkName);
    }


    // =================== VALIDATION STEPS ===============//
    @And("I verify the Help Drawer is {string} on the ESI page")
    public void iVerifyHelpDrawerStatus(String drawerStatus) {
        ohcEmployerSponsoredHealthInsurancePage.verifyHelpDrawerStatus(drawerStatus);
    }

    @And("I verify the Help Drawer {string} text in {string} on the ESI page")
    public void iVerifyHelpDrawerText(String drawerPage, String language) {
        ohcEmployerSponsoredHealthInsurancePage.verifyHelpDrawerText(drawerPage, language);
    }

    @And("I verify the header for Primary Member on the ESI page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language) {
        ohcEmployerSponsoredHealthInsurancePage.verifyHeadersEsiOhcPage(language);
    }

    @And("I verify {string} is {string} on the ESI page")
    public void iVerifyCurrentSelections(String question, String dataOffered) {
        ohcEmployerSponsoredHealthInsurancePage.verifyCurrentSelections(question, dataOffered);
    }

    @And("I verify offered family amount is {string} on the ESI page")
    public void iVerifyMonthlyAmount(String familyAmount) {
        ohcEmployerSponsoredHealthInsurancePage.verifyMonthlyAmount(familyAmount);
    }

    @Then("I verify enrollment status for the members")
    public void iVerifyFamilyEnrollmentStatusMembers(List<Map<String, String>> expectedValues) {
        ohcEmployerSponsoredHealthInsurancePage.verifyFamilyEnrollmentStatusMembers(expectedValues);
    }

    @And("I verify the {string} ESI page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {
        ohcEmployerSponsoredHealthInsurancePage.verifyEsiPageData(dataToVerify, language);
    }

    @And("I verify {string} error in {string} on the ESI page")
    public void iVerifyErrorMessage(String errorType, String language) {
        ohcEmployerSponsoredHealthInsurancePage.verifyErrorMessage(errorType, language);
    }

    @And("I verify {string} error does not show for ESI page")
    public void iVerifyNoErrorMessage(String errorType) {
        ohcEmployerSponsoredHealthInsurancePage.verifyNoErrorMessage(errorType);
    }

    @Then("I validate that I am able to see the page in the relevant language so that I can review and update the ESI information")
    public void i_validate_that_i_am_able_to_see_the_page_in_both_english_and_Spanish_so_that_i_can_review_and_update_the_esi_information(List<String> dataText) {
        ohcEmployerSponsoredHealthInsurancePage.verifyLanguageTextInESIPage(dataText);
    }

    @Then("I verify the standard errors reflected in the ESI page")
    public void i_verify_the_standard_errors_reflected_in_the_esi_page(List<String> dataText) {
        ohcEmployerSponsoredHealthInsurancePage.verifyStdErrorTextInESIPage(dataText);
    }

}
