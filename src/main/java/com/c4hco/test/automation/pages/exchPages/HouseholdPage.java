package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//input[@value ='Save and Continue']")
    WebElement saveAndContinue;

    @FindBy(id = "submitButton_AddMember")
    WebElement addAdditionalMember;

    @FindBy(id = "submitButton_Income")
    WebElement editIncomeLink;

    @FindBy(xpath = "//input[@class='linkButton'")
    WebElement editPrimaryMember;

    @FindBy(css = "td > .fa-plus-circle.toggleAddlRow")
    List<WebElement> memberBasicRow;

    @FindBy(css = "tr:nth-child(2) > td > input")
    List<WebElement> memberBasicDetailsEdit;

    @FindBy(css = ".memberBasicRow  #editBasicInfo")
    List<WebElement> memberBasicInformation;

    @FindBy(css = ".table-striped")
    WebElement familyOverviewTable;

    //@FindBy(css = "td > .fa-plus-circle.toggleAddlRow")
    @FindBy(xpath = "'//i[@class=\'fa fa-plus-circle toggleAddlRow\']")
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


    public void iEditFOPrimaryMember(int Index) {
        basicActions.waitForElementToBePresent(editPrimaryMember,100);
        Index -= 1;
        basicActions.getDriver().findElement(By.className("linkButton")).click();
        //((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", editPrimaryMember);
        //basicActions.click(editPrimaryMember);

    }
    public void iClickTableItem(){
       // basicActions.waitForElementToBePresent(tableDropdown,100);
       // basicActions.waitForElementToBeClickable(tableDropdown,100);
       // basicActions.getDriver().findElement(By.xpath("i[@class='fa fa-plus-circle toggleAddlRow']"(iClickTableItem());
        basicActions.getDriver().findElement(By.className("fa fa-plus-circle toggleAddlRow")).click();
        //((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", tableDropdown);
        //tableDropdown.click();
    }
    public void clickBasicInfoMember1Button(int member) {
        basicActions.waitForElementListToBePresent(memberBasicInformation, 100);
        memberBasicInformation.get(member).click();
    }


    public void iClickEditIncomeLink(int Index) {
        basicActions.waitForElementToBePresent(editIncomeLink,100);
        Index -= 1;
        editIncomeLink.isDisplayed();
        editIncomeLink.click();
    }


    }