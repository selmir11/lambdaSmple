package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class OrganizationDetailsPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public OrganizationDetailsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "My-info-header")
    WebElement organizationDetailsPageTitle;

    @FindBy(id = "orgName")
    WebElement organizationNameField;

    @FindBy(id = "orgName-text")
    WebElement organizationNameFieldLabel;

    @FindBy(id = "orgName-errorMsg")
    WebElement organizationNameError;

    @FindBy(id = "email")
    WebElement organizationEmailField;

    @FindBy(id = "email-text")
    WebElement organizationEmailFieldLabel;

    @FindBy(id = "email-errorMsg")
    WebElement organizationEmailError;

    @FindBy(id = "phoneNumber-input")
    WebElement organizationPhoneNumberField;

    @FindBy(id = "phoneNumber-text")
    WebElement organizationPhoneNumberFieldLabel;

    @FindBy(id = "phone-errorMsg")
    WebElement organizationPhoneNumberError;

    @FindBy(id = "address1")
    WebElement organizationAddressField;

    @FindBy(id = "address1-text")
    WebElement organizationAddressFieldLabel;

    @FindBy(id = "address1-errorMsg")
    WebElement organizationAddressError;

    @FindBy(id = "city")
    WebElement organizationCityField;

    @FindBy(id = "city-text")
    WebElement organizationCityFieldLabel;

    @FindBy(id = "city-errorMsg")
    WebElement organizationCityError;

    @FindBy(xpath = "//*[@id='primaryState']//div/div")
    WebElement organizationStateDropdown;

    @FindBy(id = "state-text")
    WebElement organizationStateDropdownLabel;

    @FindBy(id = "state-errorMsg")
    WebElement organizationStateDropdownError;

    @FindBy(id = "zipcode")
    WebElement organizationZipCodeField;

    @FindBy(id = "zipcode-text")
    WebElement organizationZipCodeFieldLabel;

    @FindBy(id = "zip-errorMsg")
    WebElement organizationZipCodeError;

    @FindBy(xpath = "//*[@id='county']//div/div")
    WebElement organizationCountyDropdown;

    @FindBy(id = "county-text")
    WebElement organizationCountyDropdownLabel;

    @FindBy(xpath = "//div[normalize-space()='County is required']//div[@id='zip-errorMsg']")
    WebElement organizationCountyDropdownError;

    @FindBy(xpath = "//*[@id='input-languages']/ng-select/div/div/div[2]/input")
    WebElement organizationLanguagesDropdown;

    @FindBy(id = "languages-text")
    WebElement organizationLanguagesDropdownLabel;

    @FindBy(xpath = "//*[@id='input-area-expertise']/ng-select/div/div/div[2]/input")
    WebElement organizationAreaOfExpertiseDropdown;

    @FindBy(id = "area-expertise-text")
    WebElement organizationAreaOfExpertiseDropdownLabel;

    @FindBy(xpath = "//*[@id='input-working-days']/ng-select/div/div/div[2]/input")
    WebElement organizationWorkingDaysDropdown;

    @FindBy(id = "working-days-text")
    WebElement organizationWorkingDaysDropdownLabel;

    @FindBy(id = "working-hours-text")
    WebElement organizationWorkingHoursLabel;

    @FindBy(id = "input-working-from")
    WebElement organizationWorkingHoursFrom;

    @FindBy(id = "input-working-to")
    WebElement organizationWorkingHoursTo;

    @FindBy(id = "working-hours-errorMsg")
    WebElement organizationWorkingHoursError;

    @FindBy(id = "allow-assoc-text")
    WebElement organizationClientAssociationQuestionText;

    @FindBy(xpath = "//div[@class='help-block text-danger w-100 text-center body-text-1']")
    WebElement organizationClientAssociationQuestionError;

    @FindBy(id = "clientAssociation-yes-label")
    WebElement organizationClientAssociationYesButton;

    @FindBy(id = "clientAssociation-no-label")
    WebElement organizationClientAssociationNoButton;

    @FindBy(id = "AN-OrganizationDetails-Submit")
    WebElement organizationDetailsSubmitButton;

    @FindBy(id = "AN-OrganizationDetails-GoBack")
    WebElement organizationDetailsGoBackButton;

    public void validateOrganizationDetailsPageTitle() {
        basicActions.waitForElementToBePresent(organizationDetailsPageTitle, 20);

        softAssert.assertEquals(organizationDetailsPageTitle.getText(), "Organization Details");
        softAssert.assertAll();
    }

    public void validateOrganizationDetailsFieldLabels() {
        basicActions.waitForElementToBePresent(organizationNameFieldLabel, 20);

        softAssert.assertEquals(organizationNameFieldLabel.getText(), "Organization Name:");
        softAssert.assertEquals(organizationEmailFieldLabel.getText(), "Email:");
        softAssert.assertEquals(organizationPhoneNumberFieldLabel.getText(), "Organization Phone:");
        softAssert.assertEquals(organizationAddressFieldLabel.getText(), "Address Line 1:");
        softAssert.assertEquals(organizationCityFieldLabel.getText(), "City:");
        softAssert.assertEquals(organizationStateDropdownLabel.getText(), "State:");
        softAssert.assertEquals(organizationZipCodeFieldLabel.getText(), "Zipcode:");
        softAssert.assertEquals(organizationCountyDropdownLabel.getText(), "County:");
        softAssert.assertEquals(organizationLanguagesDropdownLabel.getText(), "Spoken Languages:");
        softAssert.assertEquals(organizationAreaOfExpertiseDropdownLabel.getText(), "Area of Expertise:");
        softAssert.assertEquals(organizationWorkingDaysDropdownLabel.getText(), "Working Days:");
        softAssert.assertEquals(organizationWorkingHoursLabel.getText(), "Working Hours:");
        softAssert.assertEquals(organizationClientAssociationQuestionText.getText(), "Allow Customers to be associated to this organization location?");
        softAssert.assertAll();
    }

    public void validateOrganizationDetailsErrorMessages() {
        basicActions.waitForElementToBePresent(organizationDetailsSubmitButton, 20);
        organizationDetailsSubmitButton.click();

        basicActions.waitForElementToBePresent(organizationNameError, 20);

        softAssert.assertEquals(organizationNameError.getText(), "Organization Name is required");
        softAssert.assertEquals(organizationEmailError.getText(), "Please enter valid Email");
        softAssert.assertEquals(organizationPhoneNumberError.getText(), "Please enter a valid phone number");
        softAssert.assertEquals(organizationAddressError.getText(), "Address Line 1 is required");
        softAssert.assertEquals(organizationCityError.getText(), "City is required");
        softAssert.assertEquals(organizationStateDropdownError.getText(), "State is required");
        softAssert.assertEquals(organizationZipCodeError.getText(), "Zip Code is required");
        softAssert.assertEquals(organizationCountyDropdownError.getText(), "County is required");
        softAssert.assertEquals(organizationClientAssociationQuestionError.getText(), "Answer is required");
        softAssert.assertAll();
    }

    public void validateOrganizationDetailsButtons() {
        basicActions.waitForElementToBePresent(organizationDetailsSubmitButton, 20);

        softAssert.assertEquals(organizationClientAssociationYesButton.getText(), "Yes");
        softAssert.assertEquals(organizationClientAssociationNoButton.getText(), "No");
        softAssert.assertEquals(organizationDetailsSubmitButton.getText(), "Submit");
        softAssert.assertEquals(organizationDetailsGoBackButton.getText(), "Go Back");
        softAssert.assertAll();
    }

    public void validateOrganizationDetailsWorkingHoursFromError() {
        basicActions.waitForElementToBePresent(organizationWorkingHoursLabel, 20);
        organizationWorkingHoursFrom.sendKeys("0800AM");

        organizationDetailsSubmitButton.click();

        softAssert.assertEquals(organizationWorkingHoursError.getText(), "Please enter both the From and To working hours");
        softAssert.assertAll();
    }

    public void validateOrganizationDetailsWorkingHoursToError() {
        basicActions.waitForElementToBePresent(organizationWorkingHoursLabel, 20);
        organizationWorkingHoursTo.sendKeys("0500PM");

        organizationDetailsSubmitButton.click();

        softAssert.assertEquals(organizationWorkingHoursError.getText(), "Please enter both the From and To working hours");
        softAssert.assertAll();
    }

    public void clickGoBacOrganizationDetails() {
        basicActions.waitForElementToBePresent(organizationDetailsGoBackButton, 20);
        organizationDetailsGoBackButton.click();
    }

}
