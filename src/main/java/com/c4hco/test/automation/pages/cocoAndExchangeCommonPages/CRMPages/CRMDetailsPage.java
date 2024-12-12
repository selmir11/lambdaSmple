package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CRMDetailsPage {

    @FindBy(xpath = "//input[@aria-label = 'Address 2: Street 1']")
    WebElement txtAddress1Input;

    @FindBy(xpath = "//input[@aria-label = 'Address 2: City']")
    WebElement txtCityInput;

    @FindBy(xpath = "//input[@aria-label = 'Address 2: State/Province']")
    WebElement txtStateInput;

    @FindBy(xpath = "//input[@aria-label = 'Address 2: ZIP/Postal Code']")
    WebElement txtZipCodeInput;

    @FindBy(xpath = "//input[@aria-label='Date of Broker Authorization Start Date']")
    WebElement brokerAuthStartDate;

    @FindBy(xpath = "//input[@aria-label='Date of Broker Authorization End Date']")
    WebElement brokerAuthEndDate;

    @FindBy(xpath = "//input[@aria-label='Broker License Number']")
    WebElement brokerLicenseNumber;

    @FindBy(xpath = "//input[@aria-label='Date of Broker License Issue Date']")
    WebElement brokerLicenseIssueDate;

    @FindBy(xpath = "//input[@aria-label='Date of Broker License Expiration Date']")
    WebElement brokerLicenseExpirationDate;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public CRMDetailsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void verifyDetailsData(){
        basicActions.waitForElementToBePresent(txtAddress1Input,50);
        softAssert.assertEquals(txtAddress1Input.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressLine1());
        softAssert.assertEquals(txtCityInput.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressCity());
        softAssert.assertEquals(txtStateInput.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressState());
        softAssert.assertEquals(txtZipCodeInput.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressZipcode());
        softAssert.assertAll();
    }

    public void verifyBrokerAuthStartDate(){
        basicActions.waitForElementToBePresent(brokerAuthStartDate,50);
        softAssert.assertEquals(brokerAuthStartDate.getAttribute("value"), basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "MM/d/yyyy"));
        softAssert.assertAll();
    }

    public void verifyBrokerAuthEndDate(){
        basicActions.waitForElementToBePresent(brokerAuthEndDate,50);
        softAssert.assertEquals(brokerAuthEndDate.getAttribute("value"), basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "MM/d/yyyy"));
        softAssert.assertAll();
    }

    public void verifyBrokerAuthBlankEndDate(){
        basicActions.waitForElementToBePresent(brokerAuthEndDate,50);
        softAssert.assertEquals(brokerAuthEndDate.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void verifyBrokerLicense(){
        basicActions.waitForElementToBePresent(brokerLicenseNumber,50);
        softAssert.assertEquals(brokerLicenseNumber.getAttribute("value"), SharedData.getAgencyOwner().getLicense());
        softAssert.assertEquals(brokerLicenseIssueDate.getAttribute("value"), basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "MM/d/yyyy"));
        softAssert.assertEquals(brokerLicenseExpirationDate.getAttribute("value"), basicActions.changeDateFormat(basicActions.getFutureDate(1825), "MM/dd/yyyy", "MM/d/yyyy"));
        softAssert.assertAll();
    }


}
