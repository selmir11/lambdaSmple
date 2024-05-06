package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminPortalIndividualDashboardPage {

    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalIndividualDashboardPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Primary Account Holder: ANNA Julyeighth']")
    WebElement memberPrimary;
    @FindBy(css = "h3[class='dashboardHeader2']")
    WebElement memberId;
    @FindBy(css = "label[for='selected-member-checkbox']")
    WebElement selectedMember;
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#phone-number")
    WebElement memberPhone;
    @FindBy(css = "#email-address")
    WebElement memberEmail;
    @FindBy(css = "#dob")
    WebElement memberDob;
    @FindBy(xpath = "//span[normalize-space()='4725 S TAFT ST MORRISON, CO 80465']")
    WebElement memberAddress;

    public void checkingTitleIndividual() {
        basicActions.switchtoactiveTab();
        basicActions.waitForElementToBePresent(memberPrimary, 10);
        softAssert.assertEquals("Primary Account Holder: ANNA Julyeighth", memberPrimary.getText());
        basicActions.waitForElementToBePresent(memberId, 10);
        softAssert.assertEquals("Account ID:2425005563 , 42227731", memberId.getText());
        softAssert.assertAll(); }

    public void validateSelectedMemberData()  {
        basicActions.waitForElementToBePresent(selectedMember,10);
        basicActions.waitForElementToBePresent(memberDob,10);
        softAssert.assertEquals("10/10/1980",memberDob.getText());
        basicActions.waitForElementToBePresent(userName,10);
        softAssert.assertEquals("julynineth567@test.com",userName.getText());
        basicActions.waitForElementToBePresent(memberEmail,10);
        softAssert.assertEquals("xxmatusz@gmail.com",memberEmail.getText());
        basicActions.waitForElementToBePresent(memberPhone,10);
        softAssert.assertEquals("303-330-1222",memberPhone.getText());
        basicActions.waitForElementToBePresent(memberAddress,10);
        softAssert.assertEquals("4725 S TAFT ST\n" + "MORRISON, CO 80465",memberAddress.getText());
        softAssert.assertAll(); }
}

