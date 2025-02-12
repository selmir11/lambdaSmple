package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TermsOfUseCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class TermsOfUseCoCoPageSteps {

    TermsOfUseCoCoPage termsOfUseCoCoPage = new TermsOfUseCoCoPage(WebDriverManager.getDriver());

    @And("I verify the text on the CoCo Terms of Use Page in {string}")
    public void iVerifyPageText(String language) {termsOfUseCoCoPage.verifyPageText(language);}

}
