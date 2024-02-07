package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class WhoAreYouPage {
    private BasicActions basicActions;

    public WhoAreYouPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

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
    @FindBy(xpath = "//*[@value='Save and Continue']")
    WebElement saveAndContinue;

    @FindBy(css = ".input-group #county")
    WebElement countyDropDown;

    @FindBy(css = "#county option")
    List<WebElement> countyDropdownOptions;

    private String addressLine1= "1234 Road";
    private String city ="Denver";
    private String state = "CO";
    private String zip = "80205";
    private String county = "DENVER";
    private String dob ="10011980";
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
        }
    }

    public void enterMemberDetails(){
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys(city);
        Select dropdown = new Select(memberState);
        dropdown.selectByValue(state);
        memberZip.sendKeys(zip);
        countyDropDown.click();
        basicActions.selectValueFromDropdown(countyDropDown, countyDropdownOptions, county);
        memberDOB.sendKeys(dob);
        memberSSN.sendKeys(SSNvalue);
        saveAndContinue.click();
    }

    public void specificMemberDetails(String zipcode, String county, String dateOfBirth){
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys("Denver");

        Select dropdown = new Select(memberState);
        dropdown.selectByValue("CO");

        memberZip.sendKeys(zipcode);

        countyDropDown.click();
        basicActions.selectValueFromDropdown(countyDropDown, countyDropdownOptions, county);

        memberDOB.sendKeys(dateOfBirth);
        memberSSN.sendKeys(SSNvalue);
        saveAndContinue.click();
    }
}
