package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class HouseholdPage {
    // Family Overview Page
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public HouseholdPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // update locators to ids and rename methods

    @FindBy(xpath = "//input[@value ='Save and Continue']")
    WebElement saveAndContinue;

    @FindBy(id = "submitButton_AddMember")
    WebElement addAdditionalMember;

    @FindBy(id = "submitButton_Income")
    WebElement editIncomeLink;

    @FindBy(css = ".memberBasicRow .linkButton")
    WebElement editPrimaryMember;

    @FindBy(css = "td > .fa-plus-circle.toggleAddlRow")
    List<WebElement> memberBasicRow;

    @FindBy(css = "tr:nth-child(2) > td > input")
    List<WebElement> memberBasicDetailsEdit;

    @FindBy(css = ".memberBasicRow  #editBasicInfo")
    List<WebElement> memberBasicInformation;

    @FindBy(css = ".table-striped")
    WebElement familyOverviewTable;

    @FindBy(css = "i.fa.fa-plus-circle.toggleAddlRow")
    WebElement tableDropdown;

    public void clickAddMember() {
        addAdditionalMember.click();
    }

    public void clickContinue() {
        saveAndContinue.click();
    }

    public void iVerifyFamilyOverviewTablePresent() {
        // TO DO:: Sometimes, rarely we see 2 tables here. Make sure the code doesn't break when we get 2 tables displayed
        softAssert.assertTrue(familyOverviewTable.isDisplayed());
        softAssert.assertAll();
    }


    public void iEditPrimaryMember(int Index) {
        basicActions.waitForElementToBePresent(editPrimaryMember,15);
        Index -= 1;
        editPrimaryMember.click();
    }
    public void iClickTableItem(){
        basicActions.waitForElementToBePresent(tableDropdown,15);
        tableDropdown.click();
    }
    public void clickBasicInfoMember1Button(int member) {
        basicActions.waitForElementListToBePresent(memberBasicInformation, 15);
        memberBasicInformation.get(member).click();
    }


    public void iClickEditIncomeLink(int Index) {
        basicActions.waitForElementToBePresent(editIncomeLink,15);
        Index -= 1;
        editIncomeLink.isDisplayed();
        editIncomeLink.click();
    }


    }