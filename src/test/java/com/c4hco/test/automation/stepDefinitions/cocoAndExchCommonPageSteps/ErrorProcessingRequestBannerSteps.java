package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ErrorProcessingRequestBannerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class ErrorProcessingRequestBannerSteps {
    ErrorProcessingRequestBannerPage errorProcessingRequestBannerPage = new ErrorProcessingRequestBannerPage(WebDriverManager.getDriver());

    @Then("I verify the error banner at the top of the page")
    public void iVerifyErrorBanner(){errorProcessingRequestBannerPage.verifyErrorBanner();}

    @Then("I validate no error banner is displayed at the top of the page")
    public void iValidateNoErrorsPresent(){errorProcessingRequestBannerPage.verifyNoErrorMessage();}
}
