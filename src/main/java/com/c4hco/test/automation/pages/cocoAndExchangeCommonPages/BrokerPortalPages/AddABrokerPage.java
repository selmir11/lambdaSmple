package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AddABrokerPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "broker-name-input")
    WebElement brokerNameSearchField;

    @FindBy(id = "addBroker-search-btn")
    WebElement brokerNameSearchButton;

    @FindBy(id = "full-name")
    WebElement brokerResultsFullName;

    @FindBy(id = "email")
    WebElement brokerResultsEmail;

    @FindBy(id = "license-number")
    WebElement brokerResultsLicense;

    @FindBy(id = "action-value")
    WebElement brokerResultsAddLink;

    @FindBy(id = "action-description")
    WebElement brokerResultsInviteSentText;

    @FindBy(id = "BP-AddABroker-GoBack")
    WebElement goBackButtonAddABrokerPage;

    private BasicActions basicActions;
    public AddABrokerPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void searchForNewBroker(){
        basicActions.waitForElementToBePresent(brokerNameSearchField, 10);
        brokerNameSearchField.sendKeys(SharedData.getBroker().getFirstName());
        brokerNameSearchButton.click();
    }

    public void validateBrokerDetails(){
        basicActions.waitForElementToBePresent(brokerResultsFullName, 10);
        softAssert.assertEquals(brokerResultsFullName.getText(),SharedData.getBroker().getFirstName() + " " + SharedData.getBroker().getLastName());
        softAssert.assertEquals(brokerResultsEmail.getText(),SharedData.getBroker().getEmail());
        softAssert.assertEquals(brokerResultsLicense.getText(),SharedData.getBroker().getLicense());
        softAssert.assertAll();
    }

    public void clickAddLink(){
        basicActions.waitForElementToBePresent(brokerResultsAddLink, 10);
        brokerResultsAddLink.click();
    }

    public void validateInviteSentText(){
        basicActions.waitForElementToBePresent(brokerResultsInviteSentText, 10);
        softAssert.assertEquals(brokerResultsInviteSentText.getText(), "Invitation sent");
        softAssert.assertAll();
    }

    public void clickGoBackAddaBrokerPage(){
        basicActions.waitForElementToBePresent(goBackButtonAddABrokerPage, 10);
        goBackButtonAddABrokerPage.click();
    }
}
