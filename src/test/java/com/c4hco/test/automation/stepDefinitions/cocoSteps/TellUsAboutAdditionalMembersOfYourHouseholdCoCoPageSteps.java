package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class TellUsAboutAdditionalMembersOfYourHouseholdCoCoPageSteps {

   TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage = new TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage(WebDriverManager.getDriver());


@Then("I enter details on tell us about additional members of your household page and continue with {string}, {string}, {string}, and applying {string}")
public void EnterspecificAdditionalMemberDetailsCoCo(String dateOfBirth, String gender, String Relation, String applying){tellUsAboutAdditionalMembersOfYourHouseholdCoCoPage.specificAdditionalMemberDetailsCoCo(dateOfBirth, gender, Relation, applying); }

}
