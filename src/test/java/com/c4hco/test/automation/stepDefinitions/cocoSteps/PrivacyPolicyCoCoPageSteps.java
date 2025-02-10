package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PrivacyPolicyCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class PrivacyPolicyCoCoPageSteps {

    PrivacyPolicyCoCoPage privacyPolicyCoCoPage = new PrivacyPolicyCoCoPage(WebDriverManager.getDriver());

    @And("I verify the text on the CoCo Privacy Policy Page")
    public void iVerifyPageText() {privacyPolicyCoCoPage.verifyPageText();}

}
