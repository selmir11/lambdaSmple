package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.OhcPeaceCorpsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcPeaceCorpsSteps {
    OhcPeaceCorpsPage ohcPeaceCorpsPage = new OhcPeaceCorpsPage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC Peace Corps page")
    public void iClickSaveAndContinue(){
        ohcPeaceCorpsPage.clickSaveAndContinue();}

    @Then("I click Go Back on the OHC Peace Corps page")
    public void iClickGoBack(){
        ohcPeaceCorpsPage.clickGoBack();}

    @Then("I click {string} for currently enrolled in Peace Corps question")
    public void iClickCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcPeaceCorpsPage.clickCurrentlyEnrolledOption(currentlyEnrolled);}

    @Then("I click {string} for insurance ending in 60 days in Peace Corps question")
    public void iClickInsuranceEndingOption(String insuranceEnding){
        ohcPeaceCorpsPage.clickInsuranceEndingOption(insuranceEnding);}

    @Then("I enter the end date as {string} on the Peace Corps page")
    public void iEnterEndDate(String endDateData){
        ohcPeaceCorpsPage.enterEndDate(endDateData);}

    @Then("I click {string} for insurance ending voluntary for Peace Corps question")
    public void iClickEndVoluntaryOption(String voluntaryEnding){
        ohcPeaceCorpsPage.clickEndVoluntaryOption(voluntaryEnding);}

    @And("I select {string} icon on the Peace Corps Page")
    public void iSelectHelpIcon(String labelIcon){ohcPeaceCorpsPage.clickHelpIcon(labelIcon);}

    @And("I click Peace Corps Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){ohcPeaceCorpsPage.clickHelpContactUsNavigation();}












    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Peace Corps page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){
        ohcPeaceCorpsPage.verifyHeadersPeaceCorpsOhcPage(language);}

    @And("I verify Currently Enrolled is {string} on the Peace Corps page")
    public void iVerifyCurrentlyEnrolledOption(String currentlyEnrolled){
        ohcPeaceCorpsPage.verifyCurrentlyEnrolledOption(currentlyEnrolled);}

    @And("I verify Insurance Ending in 60 days is {string} on the Peace Corps page")
    public void iVerifyInsuranceEndingOption(String insuranceEnding){
        ohcPeaceCorpsPage.verifyInsuranceEndingOption(insuranceEnding);}

    @And("I verify end date is the last day of the month on the Peace Corps page")
    public void iVerifyEndDate(){
        ohcPeaceCorpsPage.verifyEndDate();}

    @And("I verify Voluntarily Ending is {string} on the Peace Corps page")
    public void iVerifyVoluntaryEndingOption(String voluntaryEnding){
        ohcPeaceCorpsPage.verifyVoluntaryEndingOption(voluntaryEnding);}

    @And("I verify the {string} Peace Corps page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {
        ohcPeaceCorpsPage.verifyPeaceCorpsPageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the Peace Corps page")
    public void iVerifyErrorMessage(String errorType, String language){
        ohcPeaceCorpsPage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for Peace Corps page")
    public void iVerifyNoErrorMessage(String errorType)  {
        ohcPeaceCorpsPage.verifyNoErrorMessage(errorType);}

    @Then("I validate Peace Corps {string} help drawer verbiage in {string}")
    public void iValidateHelp(String helpData,String language){ohcPeaceCorpsPage.validateHelpVerbiage(helpData,language);}
    
    
    
    
}
