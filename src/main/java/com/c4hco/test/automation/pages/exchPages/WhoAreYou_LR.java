package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WhoAreYou_LR {
    private BasicActions basicActions;

    public WhoAreYou_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//input[starts-with(@id,'hhcYes')]")
    WebElement member;
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

    private String addressLine1= "1234 Road";
    private String city ="Denver";
    private String state = "CO";
    private String zip = "80205";
    private String county = "DENVER";
    private String dob ="10011980";
    private String SSNvalue = "653035280";


    public void checkMember(){
        member.click();
    }
    public void enterAddress1(){
        StreetAddress1.sendKeys(addressLine1);
    }
    public void enterCity(){
        memberCity.sendKeys(city);
    }
    public void selectState(){
        Select dropdown = new Select(memberState);
        dropdown.selectByValue(state);
    }
    public void enterZip(){
        memberZip.sendKeys(zip);
    }
    public void selectCounty(){
        Select dropdown = new Select(memberCounty);
        dropdown.selectByValue(county);
    }
    public void enterDOB(){
        memberDOB.sendKeys(dob);
    }
    public void enterSSN(){
        memberSSN.sendKeys(SSNvalue);
    }
    public void clickSaveContinue(){
        saveAndContinue.click();
    }
}
