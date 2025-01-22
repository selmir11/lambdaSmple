package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.Address;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = "#state option")
    List<WebElement> stateDropdownOptions;

    @FindBy(css = "#county option")
    List<WebElement> countyDropdownOptions;

    private String addressLine1= "1234 Road";
    private String SSNvalue = "653035280";

    public void checkWhoAreYouOption(String whoAreYouOption){
        basicActions.waitForElementToBePresent(member,30);
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

    public void specificMemberDetails(String City, String State, String zipcode, String county, String dateOfBirth){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        Address address = new Address();
        basicActions.waitForElementToBePresent(StreetAddress1,20);
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys(City);

        basicActions.waitForElementToBeClickable(memberState,15);
        memberState.click();
        basicActions.selectValueFromDropdown(memberState, stateDropdownOptions, State);

        memberZip.sendKeys(zipcode);

        basicActions.waitForElementToBeClickable(countyDropDown,15);
        countyDropDown.click();
        basicActions.waitForElementListToBePresent(countyDropdownOptions, 20);
        basicActions.selectValueFromDropdown(countyDropDown, countyDropdownOptions, county);

        memberDOB.sendKeys(dateOfBirth);
        subscriber.setDob(dateOfBirth);
        memberSSN.sendKeys(SSNvalue);
        subscriber.setSsn(SSNvalue);
        address.setAddressLine1(addressLine1);
        address.setAddressCity(City);
        address.setAddressState(State);
        address.setAddressZipcode(zipcode);
        address.setAddressCounty(county);
        subscriber.setResAddress(address);
        backSaveAndContinue.get(1).click();
    }

    public void specificMemberSsnDetails(String ssn, String City, String State, String zipcode, String county, String dateOfBirth){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        Address address = new Address();
        basicActions.waitForElementToBePresent(StreetAddress1,20);
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys(City);

        basicActions.waitForElementToBeClickable(memberState,15);
        memberState.click();
        basicActions.selectValueFromDropdown(memberState, stateDropdownOptions, State);

        memberZip.sendKeys(zipcode);

        basicActions.waitForElementToBeClickable(countyDropDown,15);
        countyDropDown.click();
        basicActions.waitForElementListToBePresent(countyDropdownOptions, 20);
        basicActions.selectValueFromDropdown(countyDropDown, countyDropdownOptions, county);

        memberDOB.sendKeys(dateOfBirth);
        subscriber.setDob(dateOfBirth);
        memberSSN.sendKeys(ssn);
        subscriber.setSsn(ssn);
        address.setAddressLine1(addressLine1);
        address.setAddressCity(City);
        address.setAddressState(State);
        address.setAddressZipcode(zipcode);
        address.setAddressCounty(county);
        subscriber.setResAddress(address);
        backSaveAndContinue.get(1).click();
    }

    public void ContinueId() {
        //TO DO: How is this continue diff from above backSaveAndContinue and click?
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys("Denver");
        saveAndContinue.click();
    }

    public void clickBackButton() {
        backSaveAndContinue.get(0).click();
    }

}
