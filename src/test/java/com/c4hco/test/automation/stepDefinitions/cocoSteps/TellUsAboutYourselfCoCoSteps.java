package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TellUsAboutYourselfCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class TellUsAboutYourselfCoCoSteps {
    TellUsAboutYourselfCoCoPage tellUsAboutYourselfCoCoPage = new TellUsAboutYourselfCoCoPage(WebDriverManager.getDriver());

    @Then("I enter details on tell us about yourself page and continue with {string}, {string}, and applying {string}")
    public void EnterSpecificMemberDetailsCoCo(String dateOfBirth, String gender, String applying){tellUsAboutYourselfCoCoPage.specificMemberDetailsCoCo(dateOfBirth, gender, applying); }
























}
