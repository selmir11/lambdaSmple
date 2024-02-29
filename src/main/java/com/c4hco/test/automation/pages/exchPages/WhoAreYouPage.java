package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WhoAreYouPage {
    private BasicActions basicActions;

    public WhoAreYouPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
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
    @FindBy(css = "input.btn-c4primary")
    WebElement saveAndContinue;

    @FindBy(css = ".input-group #county")
    WebElement countyDropDown;

    @FindBy(css = "#county option")
    List<WebElement> countyDropdownOptions;

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

    public void ContinueId() {
        StreetAddress1.sendKeys(addressLine1);
        memberCity.sendKeys("Denver");
        saveAndContinue.click();
    }
}
