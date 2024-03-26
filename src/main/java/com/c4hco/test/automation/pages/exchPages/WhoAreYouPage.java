package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.ResidentialAddress;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class WhoAreYouPage {
    private BasicActions basicActions;

    public WhoAreYouPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // TO DO: Update the locators on this page
    @FindBy(xpath = "//input[starts-with(@id,'hhcYes')]")
    WebElement member;
    @FindBy(id ="selectedAuthorizedRepInput")
    WebElement newAuthorizedRepresentative;
    @FindBy(id ="selectedSomeoneElseInput")
    WebElement someoneElse;
    @FindBy(xpath = "//*[@id='firstName']")
    WebElement memberFName;
    @FindBy(xpath = "//*[@id='lastName']")
    WebElement memberLName;
    @FindBy(xpath = "//*[@id='streetAddressLine1']")
    WebElement StreetAddress1;
    @FindBy(xpath = "//*[@id='city']")
    WebElement memberCity;
    @FindBy(xpath = "//*[@id='state']")
    WebElement memberState;
    @FindBy(xpath = "//*[@id='zip']")
    WebElement memberZip;
    @FindBy(xpath = "//*[@id='county']")
    WebElement memberCounty;
    @FindBy(xpath = "//*[@id='dateOfBirth']")
    WebElement memberDOB;
    @FindBy(xpath = "//*[@id='ssn']")
    WebElement memberSSN;

    @FindBy(css = "input.btn-c4primary")
    WebElement saveAndContinue;

    @FindBy(id = "submitButton")
    List <WebElement> backSaveAndContinue;

    @FindBy(css = ".input-group #county")
    WebElement countyDropDown;

    @FindBy(css = "#county option")
    List<WebElement> countyDropdownOptions;

    @FindBy(id = "continueButton")
    List<WebElement> saveAndContinueAfterUpdate;

    private String addressLine1= "1234 Road";
    private String SSNvalue = "653035280";

    public void checkWhoAreYouOption(String whoAreYouOption){
        switch(whoAreYouOption){
            case "member":
                member.click();
                break;
            case "New Authorized Representative":
                newAuthorizedRepresentative.click();
                break;
            case "Someone Else":
                someoneElse.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + whoAreYouOption);
        }
    }

    public void specificMemberDetails(String zipcode, String county, String dateOfBirth){
        MemberDetails accHolder = SharedData.getPrimaryMember();
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys("Denver");

        Select dropdown = new Select(memberState);
        dropdown.selectByValue("CO");

        memberZip.sendKeys(zipcode);
        accHolder.setZipcode(zipcode);

        countyDropDown.click();
        basicActions.selectValueFromDropdown(countyDropDown, countyDropdownOptions, county);

        memberDOB.sendKeys(dateOfBirth);
        accHolder.setDob(dateOfBirth);
        memberSSN.sendKeys(SSNvalue);
        accHolder.setSsn(SSNvalue);
        ResidentialAddress residentialAddress = new ResidentialAddress();
        residentialAddress.setResidentialAddressLine1(addressLine1);
        residentialAddress.setResidentialAddressCity("Denver");
        residentialAddress.setResidentialAddressState("CO");
        residentialAddress.setResidentialAddressZipcode(zipcode);
        residentialAddress.setResidentialAddressCounty(county);
        accHolder.setResAddress(residentialAddress);
        backSaveAndContinue.get(1).click();
    }

    public void ContinueId() {
        //TO DO: How is this continue diff from above backSaveAndContinue and click?
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys("Denver");
        saveAndContinue.click();
    }

    public void iUpdateSSN(){
        basicActions.waitForElementToBePresent(memberSSN, 20);
        memberSSN.clear();
        memberSSN.sendKeys("123-45-6789");
    }

    public void iClickContinueAfterSSNUpdate(){
        // TO DO: Check if we can always use one method to click on continue or save and continue and create a step for it
        basicActions.waitForElementListToBePresent(saveAndContinueAfterUpdate, 15);
        saveAndContinueAfterUpdate.get(0).click();
    }
}
