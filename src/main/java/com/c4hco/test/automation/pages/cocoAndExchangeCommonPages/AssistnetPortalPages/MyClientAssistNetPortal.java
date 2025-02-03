package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyClientAssistNetPortal {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public MyClientAssistNetPortal(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(id = "client-data-title-row")
    WebElement clientRowAP;
    @FindBy(xpath = "(//mat-expansion-panel-header[contains(@id, 'mat-expansion-panel-header')])[2]")
    WebElement clientSecondRow;
    @FindBy(xpath = "//span[@class='col-2']")
    WebElement selectedClientCount;
    @FindBy(xpath = "//*[@id='client-data-title-row']/span")
    WebElement clientFullName;
    @FindBy(id = "home-address-zip")
    WebElement clientZipCode;
    @FindBy(id = "phone-data")
    WebElement clientPhoneNumber;
    @FindBy(id = "account-number-data")
    WebElement clientAccountNumber;
    @FindBy(id = "plan-year")
    List<WebElement> clientPlanYear;
    @FindBy(id = "program-eligibility")
    WebElement clientEligResults;
    @FindBy(id = "issuer-name-data")
    List<WebElement> clientIssuerName;
    @FindBy(id = "fullName0")
    WebElement secondClientFullName;
    @FindBy(id = "county")
    WebElement secondClientZipCode;
    @FindBy(id = "program-name")
    WebElement secondClientEligResults;


    public void validateTheClientIsRemovedSuccessfullyFromAssistnetPortal() {
        basicActions.waitForElementToDisappear(clientSecondRow,20);
        basicActions.waitForElementToDisappear(clientRowAP,20);

    }

    public void validateTotalSelectedClientCount(String expectedCount){
        basicActions.waitForElementToBePresent(selectedClientCount,30);
        softAssert.assertEquals(selectedClientCount.getText(), expectedCount + " Clients Selected");
        softAssert.assertAll();
    }

    public void verifyExistingClientDetails(String clientName, String clientZip, String phoneNumber, String clientAccountStg, String clientAccountQA){
        basicActions.waitForElementToBePresent(clientFullName,30);
        softAssert.assertEquals(clientFullName.getText(), clientName);
        softAssert.assertEquals(clientZipCode.getText(), clientZip);
        softAssert.assertEquals(clientPhoneNumber.getText(), phoneNumber);

        if(SharedData.getEnv().equals("staging")){
            softAssert.assertEquals(clientAccountNumber.getText(), clientAccountStg);
        } else{
            softAssert.assertEquals(clientAccountNumber.getText(), clientAccountQA);
        }
        softAssert.assertAll();
    }

    public void verifyExistingClientPlanDetails(String planYear, String eligResults, String issuerName){
        basicActions.waitForElementListToBePresentWithRetries(clientPlanYear,30);
        softAssert.assertEquals(clientPlanYear.get(0).getText(), planYear);
        softAssert.assertEquals(clientEligResults.getText(), eligResults);
        softAssert.assertEquals(clientIssuerName.get(0).getText(), issuerName);
        softAssert.assertAll();
    }

    public void verifyExistingSecondaryClientDetails(String clientName, String clientZip, String planYear, String eligResults, String issuerName){
        basicActions.waitForElementListToBePresentWithRetries(clientPlanYear,30);
        softAssert.assertEquals(secondClientFullName.getText(), clientName);
        softAssert.assertEquals(secondClientZipCode.getText(), clientZip);
        softAssert.assertEquals(clientPlanYear.get(1).getText(), planYear);
        softAssert.assertEquals(secondClientEligResults.getText(), eligResults);
        softAssert.assertEquals(clientIssuerName.get(1).getText(), issuerName);
        softAssert.assertAll();
    }
}
