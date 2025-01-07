package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class TellUsAboutAdditionalMembersOfYourHouseholdCoCoPageSteps {

   TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage = new TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage(WebDriverManager.getDriver());


   @Then("I enter details on tell us about additional members of your household page with {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String Name, String DOB, String gender, String applying, List<String> Relations) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(Name, DOB, gender, Relations, applying);
   }

   @Then("I enter details on tell us about additional members of your household page in Spanish and continue with {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCoSpanish(String DOB, String gender, String Relation, String applying) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCoSpanish(DOB, gender, Relation, applying);
   }

   @And("I click continue on Tell us about additional members of your household page")
   public void clickSaveAndContinue() {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.clickSaveandContinueButton();
   }

   @And("I click Go Back on Tell us about additional members of your household page")
   public void clickGoBack() {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.clickGoBackButton();
   }

   @And("I validate the page text on Tell Us About Additional Members Of Your Household Page CoCo {string}")
   public void iverifyTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage(String language)  { tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.verifyTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage(language); }

   @Then("I validate errors are displaying on Tell Us About Additional Members Of Your Household Page CoCo {string}")
   public void iverifyerrormessageOnTellUsAboutAdditionalMembersOfYourHouseholdfPage(String language){tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.verifyerrormessageOnTellUsAboutAdditionalMembersOfYourHouseholdfPage(language); }

   @And("I get the newborn {string} dob as {string} in CoCo page")
   public void iGetMemberDOB(String namePrefix, String dob){tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.getDob(namePrefix, dob);}

   @Then("I validate the member names displayed in the label text above relationship dropdown field in Tell us About additional member page")
   public void iValidateRelationshipLabel() {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.validateRelationshipLabel();
   }

   @Then("I validate details on tell us about additional members of your household page for {string} with DOB as {string}, gender {string} and applying {string}")
   public void iValidateValuesinTellUsAboutAddMemb(String FName,String DOB, String Gender, String applying, List<String> relationship) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.validateTellUsAboutAdditionalMembersCoCo(FName,DOB,Gender,applying,relationship);
   }

   @Then("I update details on tell us about additional members of your household page for {string} with DOB as {string}, gender {string} and applying {string}")
   public void iUpdateValuesinTellUsAboutAddMemb(String FName, String DOB, String Gender, String applying, List<String> relationship) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.updateAdditionalMemberDetailsCoCo(FName,DOB,Gender,applying,relationship);
   }

   @Then("I validate the relationship dropdown values")
   public void validateRelationshipDropdownValues(List<String> relationship) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.validateDropdownOptions(relationship);
   }


}