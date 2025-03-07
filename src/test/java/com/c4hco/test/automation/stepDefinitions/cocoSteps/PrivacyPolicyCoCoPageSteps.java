package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PrivacyPolicyCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

import java.util.List;

public class PrivacyPolicyCoCoPageSteps {

    PrivacyPolicyCoCoPage privacyPolicyCoCoPage = new PrivacyPolicyCoCoPage(WebDriverManager.getDriver());

    @And("I verify the text on the CoCo Privacy Policy Page in {string}")
    public void iVerifyPageText(String language) {privacyPolicyCoCoPage.verifyPageText(language);}

    @And("I scroll to the Types of information we collect section and verify the following text within the section")
    public void iVerifyPageTextForTypesOfInformationWeCollectSection(List<String> expectedText) {privacyPolicyCoCoPage.verifyPageTextForTypesOfInformationWeCollectSection(expectedText);}

    @And("I scroll down to the bottom of the Privacy Policy page and verify the text {string} is present")
    public void iVerifyPageTextAtTheBottomOfThePage(String expectedText) {privacyPolicyCoCoPage.verifyPageTextAtTheBottomOfThePage(expectedText);}


}
