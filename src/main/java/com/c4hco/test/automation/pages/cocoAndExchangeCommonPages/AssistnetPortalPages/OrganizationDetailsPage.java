package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages;

import com.c4hco.test.automation.Dto.AssisterDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(xpath = "//input[@id='orgName']")
    WebElement organizationNameField;

    @FindBy(xpath = "//label[@for='orgName']")
    WebElement organizationNameFieldLabel;

    @FindBy(id = "on_mf_error")
    WebElement organizationNameError;

    @FindBy(xpath = "//input[@id='email']")
    WebElement organizationEmailField;

    @FindBy(xpath = "//label[@for='email']")
    WebElement organizationEmailFieldLabel;

    @FindBy(id = "em_mf_error")
    WebElement organizationEmailError;

    @FindBy(xpath = "//input[@id='phoneNumber-input']")
    WebElement organizationPhoneNumberField;

    @FindBy(xpath = "//label[@for='phoneNumber']")
    WebElement organizationPhoneNumberFieldLabel;

    @FindBy(id = "op_mf_error")
    WebElement organizationPhoneNumberError;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement organizationAddressField;

    @FindBy(xpath = "//label[@for='address1']")
    WebElement organizationAddressFieldLabel;

    @FindBy(id = "address_mf_error")
    WebElement organizationAddressError;

    @FindBy(xpath = "//input[@id='city']")
    WebElement organizationCityField;

    @FindBy(xpath = "//label[@for='city']")
    WebElement organizationCityFieldLabel;

    @FindBy(id = "city_mf_error")
    WebElement organizationCityError;

    @FindBy(xpath = "//select[@id='primaryState']")
    WebElement organizationStateDropdown;

    @FindBy(id = "Colorado-option")
    WebElement organizationStateDropdownColorado;

    @FindBy(xpath = "//label[@for='primaryState']")
    WebElement organizationStateDropdownLabel;

    @FindBy(id = "state_mf_error")
    WebElement organizationStateDropdownError;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement organizationZipCodeField;

    @FindBy(xpath = "//label[@for='zipcode']")
    WebElement organizationZipCodeFieldLabel;

    @FindBy(id = "zc_mf_error")
    WebElement organizationZipCodeError;

    @FindBy(xpath = "//select[@id='county']")
    WebElement organizationCountyDropdown;

    @FindBy(id = "DENVER-option")
    WebElement organizationCountyDropdownDenver;

    @FindBy(xpath = "//label[@for='county']")
    WebElement organizationCountyDropdownLabel;

    @FindBy(id = "county_mf_error")
    WebElement organizationCountyDropdownError;

    @FindBy(xpath = "//*[@id='input-languages']/ng-select/div/div/div[2]/input")
    WebElement organizationLanguagesDropdown;

    @FindBy(xpath = "//span[normalize-space()='English']")
    WebElement organizationLanguagesDropdownEnglish;

    @FindBy(id = "languages-text")
    WebElement organizationLanguagesDropdownLabel;

    @FindBy(xpath = "//*[@id='input-area-expertise']/ng-select/div/div/div[2]/input")
    WebElement organizationAreaOfExpertiseDropdown;

    @FindBy(xpath = "//span[normalize-space()='Adults over 55 years']")
    WebElement organizationAreaOfExpertiseDropdownOption;

    @FindBy(id = "area-expertise-text")
    WebElement organizationAreaOfExpertiseDropdownLabel;

    @FindBy(xpath = "//*[@id='input-working-days']/ng-select/div/div/div[2]/input")
    WebElement organizationWorkingDaysDropdown;

    @FindBy(xpath = "//span[normalize-space()='Monday']")
    WebElement organizationWorkingDaysDropdownOption;

    @FindBy(id = "working-days-text")
    WebElement organizationWorkingDaysDropdownLabel;

    @FindBy(id = "working-hours-text")
    WebElement organizationWorkingHoursLabel;

    @FindBy(id = "input-working-from")
    WebElement organizationWorkingHoursFrom;

    @FindBy(id = "input-working-to")
    WebElement organizationWorkingHoursTo;

    @FindBy(id = "both-wh-error")
    WebElement organizationWorkingHoursError;

    @FindBy(xpath = "//label[@for='agencyOwner']//span")
    WebElement organizationClientAssociationQuestionText;

    @FindBy(id = "org_association_mf_error")
    WebElement organizationClientAssociationQuestionError;

    @FindBy(xpath = "//*[@id='agencyOwner-yes']//span")
    WebElement organizationClientAssociationYesButton;

    @FindBy(xpath = "//*[@id='agencyOwner-no']//span")
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

    public void enterOrganizationDetails() {
        basicActions.waitForElementToBePresent(organizationNameField, 20);

        AssisterDetails newOrganization = new AssisterDetails();
        newOrganization.setOrganizationSiteName(BasicActions.getUniqueString(8));
        SharedData.setProgramManager(newOrganization);

        organizationNameField.sendKeys(newOrganization.getOrganizationSiteName());
        organizationEmailField.sendKeys("testorg@gmail.com");
        organizationPhoneNumberField.sendKeys("6743676437647");
        organizationAddressField.sendKeys("3344 Some Road");
        organizationCityField.sendKeys("Denver");

        organizationStateDropdown.click();
        Select stateDropdown = new Select(organizationStateDropdown);
        stateDropdown.selectByVisibleText("Colorado");

        organizationZipCodeField.sendKeys("80205");

        organizationLanguagesDropdown.click();
        organizationLanguagesDropdownEnglish.click();

        organizationCountyDropdown.click();
        organizationCountyDropdown.sendKeys(Keys.DOWN);
        organizationCountyDropdown.sendKeys(Keys.ENTER);

        organizationAreaOfExpertiseDropdown.click();
        organizationAreaOfExpertiseDropdownOption.click();
        organizationZipCodeField.click();

        organizationWorkingDaysDropdown.click();
        organizationWorkingDaysDropdownOption.click();
        organizationZipCodeField.click();

        organizationWorkingHoursFrom.sendKeys("0800AM");
        organizationWorkingHoursTo.sendKeys("0500PM");

        organizationClientAssociationYesButton.click();
        organizationDetailsSubmitButton.click();
    }

    public void updateOrgName() {
        basicActions.waitForElementToBePresent(organizationNameField, 20);

        SharedData.getProgramManager().setOrganizationSiteName(SharedData.getProgramManager().getOrganizationSiteName() + "updated");

        organizationNameField.clear();
        organizationNameField.sendKeys(SharedData.getProgramManager().getOrganizationSiteName());
        organizationDetailsSubmitButton.click();
    }

    public void clickGoBacOrganizationDetails() {
        basicActions.waitForElementToBePresent(organizationDetailsGoBackButton, 20);
        organizationDetailsGoBackButton.click();
    }

}
