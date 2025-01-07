package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcIndividualInsurancePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcIndividualInsuranceSteps_Elmo {
    OhcIndividualInsurancePage_Elmo ohcIndividualInsurancePage_Elmo = new OhcIndividualInsurancePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHC Individual Insurance page")
    public void iClickSaveAndContinue(){
        ohcIndividualInsurancePage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHC Individual Insurance page")
    public void iClickGoBack(){
        ohcIndividualInsurancePage_Elmo.clickGoBack();}

    @Then("I click {string} for currently enrolled in Individual Insurance question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcIndividualInsurancePage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Individual Insurance question")
    public void iClickInsuranceEndingOption(String insuranceEnding){
        ohcIndividualInsurancePage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Individual Insurance page")
    public void iEnterEndDate(String endDateData){
        ohcIndividualInsurancePage_Elmo.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for Individual Insurance question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){
        ohcIndividualInsurancePage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the Individual Insurance Page")
    public void iSelectHelpIcon(String labelIcon){ohcIndividualInsurancePage_Elmo.clickHelpIcon(labelIcon);}

    @And("I click Individual Insurance Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){ohcIndividualInsurancePage_Elmo.clickHelpContactUsNavigation();}




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Individual Insurance page in {string}")
    public void iVerifyHeadersIndividualInsuranceOhcPage(String language){
        ohcIndividualInsurancePage_Elmo.verifyHeadersIndividualInsuranceOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Individual Insurance page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcIndividualInsurancePage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify {string} error in {string} on the Individual Insurance page")
    public void iVerifyErrorMessage(String errorType, String language){
        ohcIndividualInsurancePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Individual Insurance page")
    public void iVerifyNoErrorMessage(String errorType)  {
        ohcIndividualInsurancePage_Elmo.verifyNoErrorMessage(errorType);}

    @And("I verify Insurance Ending in 60 days is {string} on the Individual Insurance page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){
        ohcIndividualInsurancePage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Individual Insurance page")
    public void iVerifyEndDate(){
        ohcIndividualInsurancePage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Individual Insurance page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){
        ohcIndividualInsurancePage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Individual Insurance page data in {string}")
    public void iVerifyIndividualInsurancePageData(String dataToVerify, String language) {
        ohcIndividualInsurancePage_Elmo.verifyIndividualInsurancePageData(dataToVerify, language);}

    @Then("I validate Individual Insurance {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){ohcIndividualInsurancePage_Elmo.validateHelpVerbiage(helpData,language);}




}
