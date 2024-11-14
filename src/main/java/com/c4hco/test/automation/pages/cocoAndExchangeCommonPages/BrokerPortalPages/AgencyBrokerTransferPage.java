package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class AgencyBrokerTransferPage {
    @FindBy(id = "agencyBroker-search-btn")
    WebElement agencyBrokerSearchButton;

    @FindBy(id = "agency-broker-name-input")
    WebElement agencyBrokerSearchBox;

    @FindBy(id = "license-number-input")
    WebElement agencyBrokerLicenseSearchBox;

    @FindBy(xpath = "//*[@id='agency-broker-transfer-table']//tbody/tr/td")
    List<WebElement> brokerSearchResults;

    @FindBy(id = "action-link-transfer")
    WebElement agencyBrokerTransferLink;

    @FindBy(id = "BP-AgencyBrokerTransfer-GoBack")
    WebElement agencyBrokerTransferGoBackButton;

    @FindBy(xpath = "//div[contains(text(),'Broker Transfer')]")
    WebElement agencyBrokerTransferPageTitle;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AgencyBrokerTransferPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void searchBrokerOnAgencyBrokerTransfer(String brokerName){
        basicActions.waitForElementToBePresent(agencyBrokerSearchBox,10);
        agencyBrokerSearchBox.sendKeys(brokerName);
        agencyBrokerSearchButton.click();
    }

    public void searchBrokerLicenseOnAgencyBrokerTransfer(String brokerLicense){
        basicActions.waitForElementToBePresent(agencyBrokerLicenseSearchBox,10);
        agencyBrokerLicenseSearchBox.sendKeys(brokerLicense);
        agencyBrokerSearchButton.click();
    }

    public void clearBrokerSearchBoxAgencyBrokerTransfer(){
        basicActions.waitForElementToBePresent(agencyBrokerSearchBox,10);
        agencyBrokerSearchBox.clear();
    }

    public void validateBrokerSearchResults(String brokerName){
        basicActions.waitForElementListToBePresent(brokerSearchResults,10);
        softAssert.assertEquals(brokerSearchResults.get(0).getText(), brokerName);
        softAssert.assertAll();
    }

    public void validateBrokerSearchResultsDetails(String brokerName, String brokerEmailStg, String brokerEmailQa, String brokerPhone, String contactType, String agencyName, String brokerLicense){
        basicActions.waitForElementListToBePresentWithRetries(brokerSearchResults,10);
        softAssert.assertEquals(brokerSearchResults.get(0).getText(), brokerName);
        if(SharedData.getEnv().equals("staging")){
            softAssert.assertEquals(brokerSearchResults.get(1).getText(), brokerEmailStg);
        } else{
            softAssert.assertEquals(brokerSearchResults.get(1).getText(), brokerEmailQa);
        }
        softAssert.assertEquals(brokerSearchResults.get(2).getText(), brokerPhone);
        softAssert.assertEquals(brokerSearchResults.get(3).getText(), contactType);
        softAssert.assertEquals(brokerSearchResults.get(4).getText(), agencyName);
        softAssert.assertEquals(brokerSearchResults.get(5).getText(), brokerLicense);
        softAssert.assertAll();
    }

    public void clickTransferLink(){
        basicActions.waitForElementToBePresent(agencyBrokerTransferLink,10);
        agencyBrokerTransferLink.click();
    }

    public void clickTransferGoBackButton(){
        basicActions.waitForElementToBePresent(agencyBrokerTransferGoBackButton,10);
        agencyBrokerTransferGoBackButton.click();
    }

    public void validateAgencyBrokerPageTitle(){
        basicActions.waitForElementToBePresent(agencyBrokerTransferPageTitle,10);
        softAssert.assertEquals(agencyBrokerTransferPageTitle.getText(), "Agency/Broker Transfer");
        softAssert.assertAll();
    }
}
