package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class TellUsAboutAdditionalMembersOfYourHouseholdCoCoPageSteps {

   TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage = new TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage(WebDriverManager.getDriver());


   @Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String DOB, String gender, String Relation, String applying) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(DOB, gender, Relation, applying);
   }

   /*@Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String DOB, String gender, String Relation, String Relation1, String applying) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(DOB, gender, Relation, Relation1, applying);
   }

   @Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String DOB, String gender, String Relation, String Relation1, String Relation2, String applying) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(DOB, gender, Relation, Relation1, Relation2, applying);
   }*/

   @Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string} and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String Name, String DOB, String gender, String applying, List<String> Relations) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(Name, DOB, gender, Relations, applying);
   }

   @Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String Name, String DOB, String gender, String Relation, String Relation1, String applying) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(Name, DOB, gender, Relation, Relation1, applying);
   }

   @Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string}, {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String Name, String DOB, String gender, String Relation, String Relation1, String Relation2, String applying) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(Name, DOB, gender, Relation, Relation1, Relation2, applying);
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

}