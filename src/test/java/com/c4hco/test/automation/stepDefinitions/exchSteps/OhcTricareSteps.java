package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.OhcTricarePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcTricareSteps {
    OhcTricarePage ohcTricarePage = new OhcTricarePage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC Tricare page")
    public void iClickSaveAndContinue(){
        ohcTricarePage.clickSaveAndContinue();}

    @Then("I click {string} for currently enrolled in Tricare question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcTricarePage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Tricare question")
    public void iClickInsuranceEndingOption(String insuranceEnding){
        ohcTricarePage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Tricare page")
    public void iEnterEndDate(String endDateData){
        ohcTricarePage.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for Tricare question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){
        ohcTricarePage.clickEndVoluntaryOption(voluntaryEnding);}

    @Then("I click Go Back on the OHC Tricare page")
    public void iClickGoBack(){
        ohcTricarePage.clickGoBack();}

    @And("I select {string} icon on the Tricare Page")
    public void iSelectHelpIcon(String labelIcon){ohcTricarePage.clickHelpIcon(labelIcon);}

    @And("I click Tricare Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){ohcTricarePage.clickHelpContactUsNavigation();}





    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Tricare page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){
        ohcTricarePage.verifyHeadersTricareOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Tricare page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcTricarePage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Tricare page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){
        ohcTricarePage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Tricare page")
    public void iVerifyEndDate(){
        ohcTricarePage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Tricare page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){
        ohcTricarePage.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Tricare page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {
        ohcTricarePage.verifyTricarePageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Tricare page")
    public void iVerifyErrorMessage(String errorType, String language){
        ohcTricarePage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Tricare page")
    public void iVerifyNoErrorMessage(String errorType)  {
        ohcTricarePage.verifyNoErrorMessage(errorType);}

    @Then("I validate Tricare {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){ohcTricarePage.validateHelpVerbiage(helpData,language);}









}
