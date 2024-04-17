package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;
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
    @FindBy(id = "submitButton_ContinueIncome")
    WebElement saveAndContinue;

    @FindBy(id = "submitButton_AddMember")
    WebElement addAdditionalMember;

    @FindBy(id= "submitButton_Income {0}")
    WebElement editIncomeLink;

    @FindBy(xpath = "//input[contains(text(),'+TestMember+'][0]")
    @FindBy(css = "td > .fa-plus-circle.toggleAddlRow")
    List<WebElement> memberBasicRow;

    @FindBy(css = "tr:nth-child(2) > td > input")
    List<WebElement> memberBasicDetailsEdit;

    @FindBy(css = ".memberBasicRow  #editBasicInfo")
    List<WebElement> memberBasicInformation;
    //input[value='QAEXCHAARONFOURFOUR test (34)']
    //input[@value='QAEXCHAARONFOURFOUR test (34)']
    //memberBasicRow addlRowClosed
    //@FindBy(css = ".memberBasicRow  #editBasicInfo")
    //List<WebElement> memberBasicInformation;
    //@FindBy(xpath = "input[@value, contains 'Test'][0]")

    @FindBy(css=".table-striped")
    WebElement familyOverviewTable;

    public void clickAddMember(){addAdditionalMember.click();}

    public void clickContinue(){saveAndContinue.click();}

    public void clickBasicInfoMember1Button(int member){
    basicActions.waitForElementListToBePresent(memberBasicInformation, 100);
       memberBasicInformation.get(member).click();
    }

    public void iVerifyFamilyOverviewTablePresent(){
        // TO DO:: Sometimes, rarely we see 2 tables here. Make sure the code doesn't break when we get 2 tables displayed
        softAssert.assertTrue(familyOverviewTable.isDisplayed());
        softAssert.assertAll();
    }
    public void iClickEditIncomeLink(int index) {
        editIncomeLink.isDisplayed();
                editIncomeLink.click();

    public void editPrimaryIncome(){
        basicActions.waitForElementListToBePresent(memberBasicRow, 20);
        memberBasicRow.get(0).click();
        basicActions.waitForElementListToBePresent(memberBasicDetailsEdit, 20);
        memberBasicDetailsEdit.get(3).click();
    }
}

