package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.OhcTricarePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcTricareSteps_Elmo {
    OhcTricarePage_Elmo ohcTricarePage_Elmo = new OhcTricarePage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHC Tricare page")
    public void iClickSaveAndContinue(){
        ohcTricarePage_Elmo.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in Tricare question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcTricarePage_Elmo.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Tricare question")
    public void iClickInsuranceEndingOption(String insuranceEnding){
        ohcTricarePage_Elmo.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Tricare page")
    public void iEnterEndDate(String endDateData){
        ohcTricarePage_Elmo.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for Tricare question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){
        ohcTricarePage_Elmo.clickEndVoluntaryOption(voluntaryEnding);}

    @Then("I click Go Back on the Elmo OHC Tricare page")
    public void iClickGoBack(){
        ohcTricarePage_Elmo.clickGoBack();}

    @And("I select {string} icon on the Tricare Page")
    public void iSelectHelpIcon(String labelIcon){ohcTricarePage_Elmo.clickHelpIcon(labelIcon);}

    @And("I click Tricare Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){ohcTricarePage_Elmo.clickHelpContactUsNavigation();}





    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Tricare page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){
        ohcTricarePage_Elmo.verifyHeadersTricareOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Tricare page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcTricarePage_Elmo.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Tricare page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){
        ohcTricarePage_Elmo.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Tricare page")
    public void iVerifyEndDate(){
        ohcTricarePage_Elmo.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Tricare page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){
        ohcTricarePage_Elmo.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Tricare page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {
        ohcTricarePage_Elmo.verifyTricarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Tricare page")
    public void iVerifyErrorMessage(String errorType, String language){
        ohcTricarePage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Tricare page")
    public void iVerifyNoErrorMessage(String errorType)  {
        ohcTricarePage_Elmo.verifyNoErrorMessage(errorType);}

    @Then("I validate Tricare {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){ohcTricarePage_Elmo.validateHelpVerbiage(helpData,language);}









}
