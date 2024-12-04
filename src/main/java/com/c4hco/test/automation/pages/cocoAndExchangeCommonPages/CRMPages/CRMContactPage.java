package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CRMContactPage {

    @FindBy(xpath = "//li[@title='MVRs/DVRs']")
    WebElement btnMVRDVR;

    @FindBy(xpath = "//li[@title='Details']")
    WebElement btnDetails;

    @FindBy(xpath = "//*[contains(@id, 'DVRs-powerapps_onegrid_control_container')]//div[6]/div[3]//label/div")
    WebElement hdrStatusReason;

    @FindBy(xpath = "//*[@id='fluent-default-layer-host']//li")
    List<WebElement> btnStatusReasonOption;

    @FindBy(xpath = "//input[contains(@id, 'firstname')]")
    WebElement txtFirstNameInput;

    @FindBy(xpath = "//input[contains(@id, 'middlename')]")
    WebElement txtMiddleNameInput;

    @FindBy(xpath = "//input[contains(@id, 'lastname')]")
    WebElement txtLastNameInput;

    @FindBy(xpath = "//input[contains(@id, 'suffix')]")
    WebElement txtSuffixNameInput;

    @FindBy(xpath = "//div[contains(@id, 'emailaddress')]//input")
    WebElement txtEmailInput;

    @FindBy(xpath = "//div[contains(@id, 'telephone')]//input")
    WebElement txtPhoneInput;

    @FindBy(xpath = "//div[contains(@id, 'birthdate')]//input")
    WebElement txtDobInput;

    @FindBy(xpath = "//input[contains(@id, 'last4ssn')]")
    WebElement txtSsnInput;

    @FindBy(xpath = "//input[@aria-label = 'Address 1: Street 1']")
    WebElement txtAddress1Input;

    @FindBy(xpath = "//input[@aria-label = 'Address 1: City']")
    WebElement txtCityInput;

    @FindBy(xpath = "//input[@aria-label = 'Address 1: State/Province']")
    WebElement txtStateInput;

    @FindBy(xpath = "//input[@aria-label = 'Address 1: ZIP/Postal Code']")
    WebElement txtZipCodeInput;

    @FindBy(xpath = "//*[contains(@id, 'c4hco_exchangeaccountid')]//input")
    WebElement txtAccountIdInput;

    @FindBy(xpath = "//*[contains(@id, 'c4hco_contacttype.')]")
    WebElement txtContactTypeInput;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public CRMContactPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openCrmTab(String tabType){
        basicActions.wait(7000);
        switch(tabType){
            case "MVRDVR":
                basicActions.waitForElementToBePresentWithRetries(btnMVRDVR, 60);
                basicActions.clickElementWithRetries(btnMVRDVR, 60);
                break;
            case "Details":
                basicActions.waitForElementToBePresentWithRetries(btnDetails, 60);
                basicActions.clickElementWithRetries(btnDetails, 60);
                break;
            default:
                throw new IllegalArgumentException("Unsupported tab type: " + tabType);
        }
    }

    public void openMVRByTypeName(String mvrType){
        basicActions.wait(5000);
        WebElement linkOpenMVR = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),' - "+mvrType+"')]"));
        linkOpenMVR.click();
    }

    public void openDVRByTypeName(String dvrType, int typeNumber){
        basicActions.wait(5000);
        WebElement linkOpenDVR = basicActions.getDriver().findElement(By.xpath("//div["+typeNumber+"]/div[2]/div/div/div/div/div[1]/div/a//span[contains(.,'"+dvrType+"')]"));
        linkOpenDVR.click();
    }

    public void sortStatusAToZ(){
        basicActions.waitForElementToBePresentWithRetries(hdrStatusReason,10);
        hdrStatusReason.click();
        basicActions.waitForElementListToBePresent(btnStatusReasonOption,10);
        btnStatusReasonOption.get(0).click();
    }

// ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line

    public void verifyStatus(String dvrType, int typeNumber, String status){
        basicActions.wait(5000);
        WebElement statusData = basicActions.getDriver().findElement(By.xpath("//div["+typeNumber+"]/div[2]/div/div/div/div/div[1]/div/a//span[contains(.,'"+dvrType+"')]//following::div[30]"));
        softAssert.assertEquals(statusData.getText(),status);
        softAssert.assertAll();
    }

    public void verifyContactData(){
        basicActions.waitForElementToBePresentWithRetries(txtFirstNameInput,50);
        basicActions.waitForElementToBePresent(txtAddress1Input,50);
        basicActions.waitForElementToBePresent(txtCityInput,50);

        String fullSsn = SharedData.getPrimaryMember().getSsn();
        String lastFourSsn = fullSsn != null && fullSsn.length() >= 4 ? fullSsn.substring(fullSsn.length() - 4) : "";
        String dobValue = SharedData.getPrimaryMember().getDob();
        dobValue = basicActions.changeDateFormat(dobValue, "MMddyyyy", "M/d/yyyy");

        softAssert.assertEquals(txtFirstNameInput.getAttribute("title"), SharedData.getPrimaryMember().getFirstName());
        String expectedMiddleName = SharedData.getPrimaryMember().getMiddleName();
        String expectedSuffix = SharedData.getPrimaryMember().getSuffix();
        String expectedPhone = SharedData.getPrimaryMember().getPhoneNumber().replace("-", "");
        if (expectedMiddleName == null) {
            softAssert.assertEquals(txtMiddleNameInput.getAttribute("title"), "Select to enter data");
        } else {
            softAssert.assertEquals(txtMiddleNameInput.getAttribute("title"), expectedMiddleName);
        }
        softAssert.assertEquals(txtLastNameInput.getAttribute("title"), SharedData.getPrimaryMember().getLastName());
        if (expectedSuffix == null) {
            softAssert.assertEquals(txtSuffixNameInput.getAttribute("title"), "Select to enter data");
        } else {
            softAssert.assertEquals(txtSuffixNameInput.getAttribute("title"), expectedSuffix);
        }
        softAssert.assertEquals(txtEmailInput.getAttribute("title"), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(txtPhoneInput.getAttribute("title"), expectedPhone);
        softAssert.assertEquals(txtDobInput.getAttribute("value"), dobValue);
        softAssert.assertEquals(txtSsnInput.getAttribute("title"), lastFourSsn);
        softAssert.assertEquals(txtAddress1Input.getAttribute("title"), SharedData.getPrimaryMember().getResAddress().getAddressLine1());
        softAssert.assertEquals(txtCityInput.getAttribute("title"), SharedData.getPrimaryMember().getResAddress().getAddressCity());
        softAssert.assertEquals(txtStateInput.getAttribute("title"), SharedData.getPrimaryMember().getResAddress().getAddressState());
        softAssert.assertEquals(txtZipCodeInput.getAttribute("title"), SharedData.getPrimaryMember().getResAddress().getAddressZipcode());
        softAssert.assertEquals(txtAccountIdInput.getAttribute("defaultValue"), SharedData.getPrimaryMember().getAccount_id().toString());
        softAssert.assertEquals(txtContactTypeInput.getText(), "Individual");
        softAssert.assertAll();
    }
}
