package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ManageAssociatedBrokersPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "search")
    WebElement manageAssocBrokersSearchField;

    @FindBy(xpath = "//div[@class='col-md-6 header-2 mb-3']")
    WebElement manageAssocBrokersPageTitle;

    @FindBy(id = "action-link")
    WebElement manageAssocBrokersSendInvite;

    @FindBy(id = "action-description")
    WebElement manageAssocBrokersActionDescription;

    @FindBy(id = "action-value")
    WebElement manageAssocBrokersRemoveBroker;

    @FindBy(id = "BP-ManageAssociatedBrokers-GoBack")
    WebElement manageAssocBrokersGoBack;
    @FindBy(id = "full-name")
    WebElement brokerNameSearched;
    @FindBy(id = "email")
    WebElement brokerEmailSearched;
    @FindBy(id = "license-number")
    WebElement brokerLicenseSearched;
    @FindBy(id = "certification-status")
    WebElement BrokerCertificationStatus;
    @FindBy(id = "action-value")
    WebElement brokerActionStatus;
    @FindBy(id = "add-broker-link")
    WebElement addNewBrokerLink;

    private BasicActions basicActions;
    public ManageAssociatedBrokersPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickGoBackManageAssocBrokers(){
        basicActions.waitForElementToBePresent(manageAssocBrokersGoBack, 10);
        manageAssocBrokersGoBack.click();
    }

    public void validateManageBrokerPageTitle(){
        basicActions.waitForElementToBePresent(manageAssocBrokersPageTitle, 10);
        softAssert.assertEquals(manageAssocBrokersPageTitle.getText(),"Manage Associated Brokers");
        softAssert.assertAll();
    }

    public void manageAssocBrokerSearch(String brokerName){
        basicActions.waitForElementToBePresent(manageAssocBrokersSearchField, 10);
        manageAssocBrokersSearchField.sendKeys(brokerName);
        manageAssocBrokersSearchField.sendKeys(Keys.ENTER);
    }

    public void clickAddNewBrokerLink(){
        basicActions.waitForElementToBePresent(addNewBrokerLink, 10);
        addNewBrokerLink.click();
    }

    public void searchNewBrokerName(){
        basicActions.waitForElementToBePresent(manageAssocBrokersSearchField, 10);
        manageAssocBrokersSearchField.sendKeys(SharedData.getBroker().getFirstName());
        manageAssocBrokersSearchField.sendKeys(Keys.ENTER);
    }

    public void validateNewBrokerResults(){
        basicActions.waitForElementToBePresentWithRetries(brokerNameSearched,30);
        softAssert.assertEquals(brokerNameSearched.getText(), SharedData.getBroker().getFirstName() + " " + SharedData.getBroker().getLastName());
        softAssert.assertEquals(brokerEmailSearched.getText(), SharedData.getBroker().getEmail());
        softAssert.assertEquals(brokerLicenseSearched.getText(), SharedData.getBroker().getLicense());
        softAssert.assertAll();
    }

    public void manageAssocBrokerSendInvite(){
        basicActions.waitForElementToBePresent(manageAssocBrokersSendInvite, 10);
        manageAssocBrokersSendInvite.click();
    }

    public void manageAssocBrokerRemove(){
        basicActions.waitForElementToBePresent(manageAssocBrokersRemoveBroker, 10);
        softAssert.assertEquals(manageAssocBrokersRemoveBroker.getText(),"Remove");
        manageAssocBrokersRemoveBroker.click();
    }

    public void validateSendInviteLinkExists(String expectedState){
        switch (expectedState) {
            case "displayed":
                basicActions.waitForElementToBePresent(manageAssocBrokersSendInvite,100);
                softAssert.assertEquals(manageAssocBrokersSendInvite.getText(),"Send Invite");
                break;
            case "changed to Remove":
                basicActions.waitForElementToBePresent(manageAssocBrokersRemoveBroker,100);
                softAssert.assertEquals(manageAssocBrokersRemoveBroker.getText(),"Remove");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + expectedState);
        }
        softAssert.assertAll();
    }

    public void verifyAgencyInviteStatus(String expectedStatus){
        basicActions.waitForElementToBePresent(manageAssocBrokersActionDescription, 10);
        switch (expectedStatus) {
            case "Pending Acceptance":
                basicActions.waitForElementToBePresent(manageAssocBrokersActionDescription,100);
                softAssert.assertEquals(manageAssocBrokersActionDescription.getText(),"Pending Acceptance");
                break;
            case "Not Accepted":
                basicActions.waitForElementToBePresent(manageAssocBrokersActionDescription,100);
                softAssert.assertEquals(manageAssocBrokersActionDescription.getText(),"Not Accepted");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + expectedStatus);
        }

        softAssert.assertAll();
    }

    public void validateTheBrokerResultsMatchMyBrokerNamedOnAssociatedBrokers(String brokerName) {
        basicActions.waitForElementToBePresentWithRetries(brokerNameSearched,30);
        softAssert.assertEquals(brokerNameSearched.getText(),brokerName);
        softAssert.assertAll();
    }

    public void validateTheBrokerStatusInviteIsOnTheRightAction() {
            basicActions.waitForElementToBePresentWithRetries(BrokerCertificationStatus, 100);
            basicActions.waitForElementToBePresentWithRetries(manageAssocBrokersActionDescription, 100);
        if (basicActions.isElementDisplayed(brokerActionStatus,20)&& brokerActionStatus.getText().equals("Remove") ){
            System.out.println("The specified broker is not in the correct state for this test");
            manageAssocBrokerRemove();
            System.out.println("Broker state has been corrected");
            basicActions.waitForElementToBePresentWithRetries(manageAssocBrokersSendInvite, 50);
            manageAssocBrokersSendInvite.click();

        } else if (basicActions.isElementDisplayed(manageAssocBrokersActionDescription,20)&&manageAssocBrokersActionDescription.getText().equals("Pending Acceptance") ) {
            System.out.println("Broker current state is Pending Acceptance");

        } else if (basicActions.isElementDisplayed(manageAssocBrokersSendInvite,20)){
            System.out.println("The specified broker has been verified and is in the correct state for this test");
            basicActions.waitForElementToBePresentWithRetries(manageAssocBrokersSendInvite, 50);
            manageAssocBrokersSendInvite.click();
        }}


}
