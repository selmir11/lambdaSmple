package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalProgramManagerAccountCreationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class AdminPortalProgramManagerAccountCreationSteps {
    AdminPortalProgramManagerAccountCreationPage accountCreationPage = new AdminPortalProgramManagerAccountCreationPage(WebDriverManager.getDriver());

    @Then("I create program manger profile on admin portal {string}")
    public void iCreateProgramMangerProfileOnAdminPortal(String emailBase) {
        accountCreationPage.createProgramMangerProfileOnAdminPortal(emailBase);
    }

    @And("I validate the success message for Profile creation is displayed")
    public void iValidateTheSuccessMessageForProfileCreationIsDisplayed() {
        accountCreationPage.validateTheSuccessMessageForProfileCreationIsDisplayed();
    }



}
