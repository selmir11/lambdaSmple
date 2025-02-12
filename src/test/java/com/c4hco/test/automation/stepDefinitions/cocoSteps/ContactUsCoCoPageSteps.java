package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.ContactUsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class ContactUsCoCoPageSteps {

    ContactUsCoCoPage conactUsCoCoPage = new ContactUsCoCoPage(WebDriverManager.getDriver());

    @And("I verify the text on the CoCo Contact Us Page")
    public void iVerifyPageText() {conactUsCoCoPage.verifyPageText();}

}
