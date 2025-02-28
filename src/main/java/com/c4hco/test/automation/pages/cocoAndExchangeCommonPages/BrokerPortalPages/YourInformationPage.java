package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.SharedData;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class YourInformationPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "your-info-header")
    WebElement yourInformationTitle;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "firstName-errorMsg")
    WebElement firstNameErrorMessage;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "lastName-errorMsg")
    WebElement lastNameErrorMessage;

    @FindBy(id = "license-match-checkbox-input")
    WebElement licenseMatchCheckbox;

    @FindBy(id = "first-name-license")
    WebElement licenseFirstName;

    @FindBy(id = "first-name-license-errorMsg")
    WebElement licenseFirstNameErrorMessage;

    @FindBy(id = "last-name-license")
    WebElement licenseLastName;

    @FindBy(id = "last-name-license-errorMsg")
    WebElement licenseLastNameErrorMessage;

    @FindBy(xpath = "//*[@id='number-license-errorMsg']/div")
    WebElement licenseErrorMessage;

    @FindBy(id = "number-license-errorMsg")
    WebElement licenseRequiredErrorMessage;

    @FindBy(id = "BP-YourInformation-GoBack")
    WebElement yourInformationGoBack;

    @FindBy(id = "state-license-num")
    WebElement license;

    @FindBy(id = "license-valid-from")
    WebElement licenseValidFromDate;

    @FindBy(id = "valid-from-errorMsg")
    WebElement licenseValidFromDateErrorMessage;

    @FindBy(id = "license-valid-to")
    WebElement licenseValidToDate;

    @FindBy(id = "valid-to-errorMsg")
    WebElement licenseValidToDateErrorMessage;

    @FindBy(id = "agencyOwner-errorMsg")
    WebElement bookOfBusinessErrorMessage;

    @FindBy(id = "agencyOwner-yes-label")
    WebElement bookOfBusinessYesButton;

    @FindBy(id = "agencyOwner-no-label")
    WebElement bookOfBusinessNoButton;

    @FindBy(id = "inviteCode-errorMsg")
    WebElement invitationCodeErrorMessage;

    @FindBy(id = "inviteCode-input")
    WebElement inviteCode;

    @FindBy(id = "have-code-checkbox-input")
    WebElement noCodeCheckbox;

    @FindBy(id = "noCode-checkbox-errorMsg")
    WebElement noInviteCodeErrorMessage;

    @FindBy(id = "communication-preference-button")
    WebElement  continueYourInformation;

    @FindBy(id= "agencyOwner-yes")
    WebElement disabledBookOfBusinessYes;

    @FindBy(id= "agencyOwner-no")
    WebElement disabledBookOfBusinessNo;

    @FindBy(id="valid-to-invalidDate-errorMsg")
    WebElement invalidErrorMsg;

    private BasicActions basicActions;
    public YourInformationPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void validateYourInformationTitle(){
        basicActions.waitForElementToBePresent(yourInformationTitle,10);
        softAssert.assertEquals(yourInformationTitle.getText(),"Your Information");
        softAssert.assertAll();
    }

    public void validateFirstNameAutoPopulated(){
        basicActions.waitForElementToBePresent(firstName,10);
        BrokerDetails broker = SharedData.getAdminStaff();
        softAssert.assertEquals(firstName.getAttribute("value"), broker.getFirstName());
        softAssert.assertAll();
    }

    public void validateFirstNameErrorMessage(){
        basicActions.waitForElementToBePresent(firstName,10);
        firstName.clear();
        firstName.sendKeys("123$# @");
        softAssert.assertEquals(firstNameErrorMessage.getText(),"First Name is required");
        softAssert.assertAll();
    }

    public void validateLastNameAutoPopulated(){
        basicActions.waitForElementToBePresent(lastName,10);
        BrokerDetails broker = SharedData.getAdminStaff();
        softAssert.assertEquals(lastName.getAttribute("value"), broker.getLastName());
        softAssert.assertAll();
    }

    public void validateLastNameErrorMessage(){
        basicActions.waitForElementToBePresent(lastName,10);
        lastName.clear();
        lastName.sendKeys("123$# @");
        softAssert.assertEquals(lastNameErrorMessage.getText(),"Last Name is required");
        softAssert.assertAll();
    }

    public void clickLicenseMatchCheckbox(){
        basicActions.waitForElementToBePresent(licenseMatchCheckbox,10);
        licenseMatchCheckbox.click();
    }

    public void validateLicenseFirstNameErrorMessage(){
        basicActions.waitForElementToBePresent(licenseFirstName,10);
        licenseFirstName.sendKeys("123$# @");
        softAssert.assertEquals(licenseFirstNameErrorMessage.getText(),"First Name on License is required");
        softAssert.assertAll();
    }

    public void validateLicenseLastNameErrorMessage(){
        basicActions.waitForElementToBePresent(licenseLastName,10);
        licenseLastName.sendKeys("123$# @");
        softAssert.assertEquals(licenseLastNameErrorMessage.getText(),"Last Name on License is required");
        softAssert.assertAll();
    }

    public void validateLicenseErrorMessage(){
        basicActions.waitForElementToBePresent(license,10);
        license.sendKeys("123$# @");
        softAssert.assertEquals(licenseErrorMessage.getText(),"License Number can only accept numeric values");
        softAssert.assertAll();
    }

    public void validateLicenseRequiredErrorMessage(){
        basicActions.waitForElementToBePresent(license,10);
        continueYourInformation.click();
        softAssert.assertEquals(licenseRequiredErrorMessage.getText(),"State License Number is required");
        softAssert.assertAll();
    }

    public void validateLicenseValidFromErrorMessage(){
        basicActions.waitForElementToBePresent(licenseValidFromDate,10);
        continueYourInformation.click();
        softAssert.assertEquals(licenseValidFromDateErrorMessage.getText(),"License Valid From is required");
        softAssert.assertAll();
    }

    public void validateLicenseValidToErrorMessage(){
        basicActions.waitForElementToBePresent(licenseValidToDate,10);
        continueYourInformation.click();
        softAssert.assertEquals(licenseValidToDateErrorMessage.getText(),"License Valid To is required");
        softAssert.assertAll();
    }

    public void validateBoBErrorMessage(){
        basicActions.waitForElementToBePresent(bookOfBusinessNoButton,10);
        continueYourInformation.click();
        softAssert.assertEquals(bookOfBusinessErrorMessage.getText(),"Please select one of the options below");
        softAssert.assertAll();
    }

    public void validateInviteCodeErrorMessage(){
        basicActions.waitForElementToBePresent(inviteCode,10);
        inviteCode.sendKeys("AAA");
        softAssert.assertEquals(invitationCodeErrorMessage.getText(),"Please enter valid invitation code\n" +
                "or select 'I do not have a code' below");
        softAssert.assertAll();
    }

    public void validateNoInviteCodeCheckboxErrorMessage(){
        basicActions.waitForElementToBePresent(noInviteCodeErrorMessage,10);
        continueYourInformation.click();
        softAssert.assertEquals(noInviteCodeErrorMessage.getText(),"Response is Required");
        softAssert.assertAll();
    }

    public void clickIDoNotHaveCodeCheckbox(){
        basicActions.waitForElementToBePresent(noCodeCheckbox,10);
        noCodeCheckbox.click();
    }

    public void validateLicenseMaxCharacterLimit(){
        basicActions.waitForElementToBePresent(license,10);
        license.clear();
        license.sendKeys("A12343b73ycvvkdhfkjdhfdjDa");
        softAssert.assertEquals(license.getAttribute("value"),"A12343b73ycvvkdhfkjdhfdjD");
        softAssert.assertAll();
    }

    public void clickGoBackYourInformationPage(){
        basicActions.waitForElementToBeClickable(yourInformationGoBack,10);
        yourInformationGoBack.click();
    }

    public void enterLicenseAndDates(String accountType){
        basicActions.waitForElementToBePresent(license,10);
        BrokerDetails broker;
        Date todayDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 4);
        Date futureDate = calendar.getTime();
        switch(accountType){
            case "Agency Owner":
                broker = SharedData.getAgencyOwner();
                license.sendKeys(broker.getLicense());
                licenseValidFromDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(todayDate));
                licenseValidToDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(futureDate));
                break;
            case "Broker":
                broker = SharedData.getBroker();
                license.sendKeys(broker.getLicense());
                licenseValidFromDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(todayDate));
                licenseValidToDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(futureDate));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + accountType);
        }
    }

    public void updateLicenseAndDates(String accountType){
        basicActions.waitForElementToBePresent(license,10);
        BrokerDetails broker = new BrokerDetails();
        broker.setLicense(generateBrokerLicense().toString());
        System.out.println("The new license number is " + broker.getLicense());
        switch(accountType){
            case "Agency Owner":
                SharedData.setAgencyOwner(broker);
                break;
            case "Broker":
                SharedData.setBroker(broker);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + accountType);
        }

        license.clear();
        license.sendKeys(SharedData.getAgencyOwner().getLicense());
        licenseValidFromDate.sendKeys(basicActions.getTodayDate());
        licenseValidToDate.sendKeys(basicActions.getFutureDate(1825));
    }

    public static CharSequence generateBrokerLicense(){
        Random rand = new Random();
        int num = 1000000 + rand.nextInt(100000);
        return Integer.toString(num);
    }

    public void clickBookOfBusinessNoButton(){
        basicActions.waitForElementToBeClickable(bookOfBusinessNoButton,10);
        bookOfBusinessNoButton.click();
    }

    public void clickBookOfBusinessYesButton(){
        basicActions.waitForElementToBeClickable(bookOfBusinessYesButton,10);
        bookOfBusinessYesButton.click();
    }

    public void clickContinueYourInformationPage(){
        basicActions.waitForElementToBeClickable(continueYourInformation,10);
        continueYourInformation.click();
    }

    public void verifyBoBDisabled(){
        basicActions.waitForElementToBePresent(disabledBookOfBusinessYes, 10);
        Assert.assertFalse(disabledBookOfBusinessYes.isEnabled());
        Assert.assertFalse(disabledBookOfBusinessNo.isEnabled());
    }

    public void validateTheErrorMessageForTheLicenseExpirationDate() {
        basicActions.waitForElementToBeClickable(continueYourInformation,20);
        license.sendKeys("789654123");
        licenseValidFromDate.click();
        Date todayDate = new Date();
        licenseValidFromDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(todayDate));
        licenseValidToDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(todayDate));
        basicActions.waitForElementToBePresent(invalidErrorMsg,20);
        continueYourInformation.click();
        softAssert.assertEquals(invalidErrorMsg.getText(),"(License Valid To) should be set after start date (License Valid From)");
        licenseValidToDate.clear();
        licenseValidToDate.sendKeys("10/11/2021");
        continueYourInformation.click();
        softAssert.assertEquals(invalidErrorMsg.getText(),"(License Valid To) should be set after start date (License Valid From)");
        softAssert.assertAll();;







    }
}
