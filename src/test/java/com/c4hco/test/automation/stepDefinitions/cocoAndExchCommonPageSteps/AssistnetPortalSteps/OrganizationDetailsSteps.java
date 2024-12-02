package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.AssistnetPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages.OrganizationDetailsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OrganizationDetailsSteps {
    OrganizationDetailsPage organizationDetailsPage = new OrganizationDetailsPage(WebDriverManager.getDriver());

    @Then("I validate the Organization Details page title")
    public void iValidateOrganizationDetailsPageTitle() {
        organizationDetailsPage.validateOrganizationDetailsPageTitle();
    }

    @And("I validate the field labels on the Organization Details page")
    public void iValidateOrganizationDetailsFieldLabels() {
        organizationDetailsPage.validateOrganizationDetailsFieldLabels();
    }

    @Then("I validate the mandatory field error messages on the Organization Details page")
    public void iValidateOrganizationDetailsErrorMessages() {
        organizationDetailsPage.validateOrganizationDetailsErrorMessages();
    }

    @And("I validate the buttons on the Organization Details page")
    public void iValidateOrganizationDetailsButtons() {
        organizationDetailsPage.validateOrganizationDetailsButtons();
    }

    @Then("I validate the working hours from error message on the Organization Details page")
    public void iValidateOrganizationDetailsWorkingHoursFromError() {
        organizationDetailsPage.validateOrganizationDetailsWorkingHoursFromError();
    }

    @Then("I validate the working hours to error message on the Organization Details page")
    public void iValidateOrganizationDetailsWorkingHoursToError() {
        organizationDetailsPage.validateOrganizationDetailsWorkingHoursToError();
    }

    @Then("I click the Go Back button on the Organization Details page")
    public void iClickGoBacOrganizationDetails() {
        organizationDetailsPage.clickGoBacOrganizationDetails();
    }

}
