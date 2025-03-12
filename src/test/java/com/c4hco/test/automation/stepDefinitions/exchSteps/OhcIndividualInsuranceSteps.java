package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcIndividualInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcIndividualInsuranceSteps {
    OhcIndividualInsurancePage ohcIndividualInsurancePage = new OhcIndividualInsurancePage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC Individual Insurance page")
    public void iClickSaveAndContinue(){
        ohcIndividualInsurancePage.clickSaveAndContinue();}

    @Then("I click Go Back on the OHC Individual Insurance page")
    public void iClickGoBack(){
        ohcIndividualInsurancePage.clickGoBack();}

    @Then("I click {string} for currently enrolled in Individual Insurance question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcIndividualInsurancePage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Individual Insurance question")
    public void iClickInsuranceEndingOption(String insuranceEnding){
        ohcIndividualInsurancePage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Individual Insurance page")
    public void iEnterEndDate(String endDateData){
        ohcIndividualInsurancePage.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for Individual Insurance question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){
        ohcIndividualInsurancePage.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the Individual Insurance Page")
    public void iSelectHelpIcon(String labelIcon){ohcIndividualInsurancePage.clickHelpIcon(labelIcon);}

    @And("I click Individual Insurance Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){ohcIndividualInsurancePage.clickHelpContactUsNavigation();}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Individual Insurance page in {string}")
    public void iVerifyHeadersIndividualInsuranceOhcPage(String language){
        ohcIndividualInsurancePage.verifyHeadersIndividualInsuranceOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Individual Insurance page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcIndividualInsurancePage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify {string} error in {string} on the Individual Insurance page")
    public void iVerifyErrorMessage(String errorType, String language){
        ohcIndividualInsurancePage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Individual Insurance page")
    public void iVerifyNoErrorMessage(String errorType)  {
        ohcIndividualInsurancePage.verifyNoErrorMessage(errorType);}

    @And("I verify Insurance Ending in 60 days is {string} on the Individual Insurance page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){
        ohcIndividualInsurancePage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Individual Insurance page")
    public void iVerifyEndDate(){
        ohcIndividualInsurancePage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Individual Insurance page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){
        ohcIndividualInsurancePage.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Individual Insurance page data in {string}")
    public void iVerifyIndividualInsurancePageData(String dataToVerify, String language) {
        ohcIndividualInsurancePage.verifyIndividualInsurancePageData(dataToVerify, language);}

    @Then("I validate Individual Insurance {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){ohcIndividualInsurancePage.validateHelpVerbiage(helpData,language);}




}
