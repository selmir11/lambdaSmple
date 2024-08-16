package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class HouseholdPage {
    // Family Overview Page - IMPORTANT - REFACTOR THE ENTIRE PAGE - SO MANY DUPLICATES AND NOT WORKING CODE
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public HouseholdPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // update locators to ids and rename methods

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;
    @FindBy(id = "submitButton_ContinueIncome")
    WebElement saveAndContinue;

    @FindBy(id = "submitButton_AddMember")
    WebElement addAdditionalMember;

    @FindBy(id = "submitButton_Income")
    WebElement editIncomeLink;

    @FindBy(xpath = "//input[@class = 'linkButton']")
    WebElement editPrimaryMember;

    @FindBy(xpath = "//input[@class = 'linkButton]")
    WebElement linkMember;

    @FindBy(xpath = "//*[@class = 'linkButton']")
    WebElement secondlinkMember;

    @FindBy(xpath = "//*[@id = 'submitButton_Income']")
    WebElement editPrimaryMemberRedIcon;

    @FindBy(css = ".memberBasicRow  #editBasicInfo")
    List<WebElement> memberBasicInformation;

    @FindBy(css = ".table-striped")
    WebElement familyOverviewTable;

    @FindBy(xpath = "//*[@class = 'fa fa-plus-circle toggleAddlRow']")
    WebElement tableDropdown;

    @FindBy(css = "input[value='Edit'][alt='Submit']")
    WebElement redIcon;

    @FindBy(css = ".memberBasicRow input.linkButton[type='submit']")
    List<WebElement> memberNamesLinks;

    @FindBy(css = "#accountID")
    WebElement accountIdTxt;

    public void clickAddMember() {
        basicActions.waitForElementToBeClickable( addAdditionalMember,15 );
        addAdditionalMember.click();
    }

    public void clickContinue() {
        basicActions.waitForElementToBePresent(saveAndContinue,15);
        getAccountId();
        saveAndContinue.click();
    }

    public void getAccountId() {
        basicActions.waitForElementToBePresent(accountIdTxt,15);
        String accId;
        if (accountIdTxt.getText().contains("Account ID")) {
            accId = accountIdTxt.getText().replace("Account ID: ", "");
        }else {
            accId = accountIdTxt.getText().replace("Identificaci\u00F3n de la cuenta ", "");
        }
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setAccount_id(new BigDecimal(accId));
    }


    public void iVerifyFamilyOverviewTablePresent() {
        // TO DO:: Sometimes, rarely we see 2 tables here. Make sure the code doesn't break when we get 2 tables displayed
        softAssert.assertTrue(familyOverviewTable.isDisplayed());
        softAssert.assertAll();
    }


    public void iEditPrimaryMember(int index) {
        basicActions.waitForElementToBePresent(editPrimaryMember,15);
        basicActions.waitForElementToBeClickableWithRetries( editPrimaryMember,15 );
        index -= 1;
        editPrimaryMember.click();
    }

    public void iClick2ndMemberLink(){
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent(secondlinkMember, 10);
        softAssert.assertTrue( secondlinkMember.isDisplayed());
        basicActions.waitForElementToBeClickable( secondlinkMember,15 );
        secondlinkMember.click();

    }

    public void iClickMemberLink (int index) {
        //linkName - aiming to use a different locator to activate the different rows
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent(linkMember, 10);
        softAssert.assertTrue( linkMember.isDisplayed());
        basicActions.waitForElementToBeClickable( linkMember,15 );
        index -= 1;
        linkMember.click();
    }

    public void iEditPrimaryMemberRedIcon(int index) {
        basicActions.waitForElementToBePresent(editPrimaryMemberRedIcon, 15 );
        basicActions.waitForElementToBeClickable( editPrimaryMemberRedIcon,15 );
       editPrimaryMemberRedIcon.click();
    }

    public void iClickTableItem(int index){
        basicActions.waitForElementToBePresent(editPrimaryMember,30);
        basicActions.waitForElementToBePresent(tableDropdown,30);
        index-= 1;
        tableDropdown.click();
    }
    public void clickBasicInfoMember1Button(int member) {
        basicActions.waitForElementListToBePresent(memberBasicInformation, 15);
        memberBasicInformation.get(member).click();
    }

    public void iClickEditIncomeLink(int index) {
        basicActions.waitForElementToBePresent(editIncomeLink,15);
        editIncomeLink.isDisplayed();
        editIncomeLink.click();
    }

    public void clickMember(String memNameToClick){
        basicActions.waitForElementListToBePresent(memberNamesLinks, 10);
        for(WebElement memNameLink:memberNamesLinks){
            if(memNameLink.getAttribute("value").contains(memNameToClick)){
                memNameLink.click();
                break;
            }
        }
    }


    }