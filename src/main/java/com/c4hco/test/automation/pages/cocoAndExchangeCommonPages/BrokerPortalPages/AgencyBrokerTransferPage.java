package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AgencyBrokerTransferPage {
    @FindBy(id = "agencyBroker-search-btn")
    WebElement agencyBrokerSearchButton;

    @FindBy(id = "agency-broker-name-input")
    WebElement agencyBrokerSearchBox;

    @FindBy(xpath = "//*[@id='agency-broker-transfer-table']//tbody/tr/td")
    WebElement brokerSearchResultsName;

    @FindBy(id = "action-link-transfer")
    WebElement agencyBrokerTransferLink;

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

    public void validateBrokerSearchResults(String brokerName){
        basicActions.waitForElementToBePresent(brokerSearchResultsName,10);
        softAssert.assertEquals(brokerSearchResultsName.getText(), brokerName);
        softAssert.assertAll();
    }

    public void clickTransferLink(){
        basicActions.waitForElementToBePresent(agencyBrokerTransferLink,10);
        agencyBrokerTransferLink.click();
    }

    public void validateAgencyBrokerPageTitle(){
        basicActions.waitForElementToBePresent(agencyBrokerTransferPageTitle,10);
        softAssert.assertEquals(agencyBrokerTransferPageTitle.getText(), "Agency/Broker Transfer");
        softAssert.assertAll();
    }
}
