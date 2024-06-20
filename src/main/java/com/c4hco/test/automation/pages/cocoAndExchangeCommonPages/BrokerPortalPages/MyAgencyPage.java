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

    @FindBy(id = "BP-MyAgency-GoBack")
    WebElement myAgencyGoBackButton;

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

    public void clickGoBackManageAssocBrokers(){
        basicActions.waitForElementToBePresent(myAgencyGoBackButton, 10);
        myAgencyGoBackButton.click();
    }
}
