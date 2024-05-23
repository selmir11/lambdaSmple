package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TellUsAboutAdditionalMembersOfYourHouseholdCoCoPageSteps {

   TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage = new TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage(WebDriverManager.getDriver());


   @Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string}, and applying {string}")
   public void EnterspecificAdditionalMemberDetailsCoCo(String DOB, String gender, String Relation, String applying) {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(DOB, gender, Relation, applying);
   }

   @And("I validate the page text on Tell us about additional members of your household")
   public void iverifyTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage() {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.verifyTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage();
   }

   @And("I click continue on Tell us about additional members of your household page")
   public void clickSaveAndContinue() {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.clickSaveandContinueButton();
   }

   @And("I click Go Back on Tell us about additional members of your household page")
   public void clickGoBack() {
      tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.clickGoBackButton();
   }
}