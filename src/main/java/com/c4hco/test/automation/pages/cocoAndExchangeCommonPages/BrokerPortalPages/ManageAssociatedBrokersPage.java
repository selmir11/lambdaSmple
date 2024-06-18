package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ManageAssociatedBrokersPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "search")
    WebElement manageAssocBrokersSearchField;

    @FindBy(id = "action-link")
    WebElement manageAssocBrokersSendInvite;

    @FindBy(id = "action-description")
    WebElement manageAssocBrokersActionDescription;

    @FindBy(id = "action-link")
    WebElement manageAssocBrokersRemoveBroker;

    @FindBy(id = "BP-ManageAssociatedBrokers-GoBack")
    WebElement manageAssocBrokersGoBack;

    private BasicActions basicActions;
    public ManageAssociatedBrokersPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickGoBackManageAssocBrokers(){
        basicActions.waitForElementToBePresent(manageAssocBrokersGoBack, 10);
        manageAssocBrokersGoBack.click();
    }

    public void manageAssocBrokerSearch(String brokerName){
        basicActions.waitForElementToBePresent(manageAssocBrokersSearchField, 10);
        manageAssocBrokersSearchField.sendKeys(brokerName);
        manageAssocBrokersSearchField.sendKeys(Keys.ENTER);
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
        if(expectedState.equals("is")){
            basicActions.waitForElementToBePresent(manageAssocBrokersSendInvite,100);
            softAssert.assertEquals(manageAssocBrokersSendInvite.getText(),"Send Invite");
        } else if (expectedState.equals("is not")) {
            basicActions.waitForElementToBePresent(manageAssocBrokersRemoveBroker,100);
            softAssert.assertEquals(manageAssocBrokersRemoveBroker.getText(),"Remove");
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
}
