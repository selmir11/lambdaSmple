package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MyAgencyPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "action-link-approve")
    WebElement approveAgencyInviteLink;

    @FindBy(id = "action-link-deny")
    WebElement denyAgencyInviteLink;

    @FindBy(id = "agency-0-name")
    WebElement agencyNameText;

    @FindBy(id = "agency-0-phone-number")
    WebElement agencyPhoneText;

    @FindBy(id = "agency-0-status")
    WebElement agencyInviteStatusText;

    @FindBy(id = "BP-MyAgency-GoBack")
    WebElement myAgencyGoBackButton;

    @FindBy(css ="div[id='new-agency-info-message'] div")
    WebElement myAgencyErrorMessage;

    @FindBy(id = "ok-button")
    WebElement errorMessageOkButton;

    @FindBy(id = "action-link-approve-dialog")
    WebElement approveSecondAgencyInviteLink;

    private BasicActions basicActions;
    public MyAgencyPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void approveAgencyInvite(){
        basicActions.waitForElementToBePresent(approveAgencyInviteLink, 10);
        softAssert.assertEquals(approveAgencyInviteLink.getText(),"Approve");
        softAssert.assertAll();

        approveAgencyInviteLink.click();
    }

    public void denyAgencyInvite(){
        basicActions.waitForElementToBePresent(denyAgencyInviteLink, 10);
        softAssert.assertEquals(denyAgencyInviteLink.getText(),"Deny");
        softAssert.assertAll();
        denyAgencyInviteLink.click();
    }

    public void verifyAgencyInviteStatus(String agencyInviteName, String agencyPhone, String inviteStatus){
        basicActions.waitForElementToBePresent(agencyInviteStatusText, 10);
        softAssert.assertEquals(agencyNameText.getText(), agencyInviteName);
        softAssert.assertEquals(agencyPhoneText.getText(), agencyPhone);
        softAssert.assertEquals(agencyInviteStatusText.getText(), inviteStatus);
        softAssert.assertAll();
    }

    public void verifyNoPendingAgencyInvites(){
        int rows = basicActions.getDriver().findElements(By.xpath("//*[@id='associated-agencies']//tr")).size();
        softAssert.assertEquals(rows, 1);
        softAssert.assertAll();
    }

    public void clickGoBackManageAssocBrokers(){
        basicActions.waitForElementToBePresent(myAgencyGoBackButton, 10);
        myAgencyGoBackButton.click();
    }

    public void approveSecondAgencyInvite(){
        basicActions.waitForElementToBePresent(approveSecondAgencyInviteLink, 10);
        softAssert.assertEquals(approveSecondAgencyInviteLink.getText(), "Approve");
        softAssert.assertAll();

        approveSecondAgencyInviteLink.click();
    }

    public void verifyUnableToAcceptMultipleInvites(){
        basicActions.waitForElementToBePresent(myAgencyErrorMessage, 10);
        softAssert.assertEquals(myAgencyErrorMessage.getText(),"You can only be associated with one agency at a time. You are currently associated with RT1922 Agency. If you want to accept the invitation from Harrison Andersen Agency, you must first deny the invitation from RT1922 Agency.");
        softAssert.assertAll();
    }

    public void clickOkAgencyInviteErrorMessage(){
        basicActions.waitForElementToBePresent(errorMessageOkButton, 10);
        errorMessageOkButton.click();
    }
}
