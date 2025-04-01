package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RIDPWhoAreYouPage {
    private BasicActions basicActions;
    public RIDPWhoAreYouPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "select-person-WhoAreYou.authorizedRepresentativeButton")
    WebElement selectPersonNewAuthRep;

    @FindBy(id = "select-person-WhoAreYou.someoneElseButton")
    WebElement selectPersonSomeoneElse;

    @FindBy(id = "name-firstName")
    WebElement txtFirstName;

    @FindBy(id = "name-middleName")
    WebElement txtMiddleName;

    @FindBy(id = "name-lastName")
    WebElement txtLastName;

    @FindBy(id = "name-nameSuffix")
    WebElement drpdnSuffix;

    @FindBy(id = "who-are-you-addressLine1Input")
    WebElement txtAddresLine1;

    @FindBy(id = "who-are-you-addressLine2Input")
    WebElement txtAddresLine2;

    @FindBy(id = "who-are-you-cityInput")
    WebElement txtCity;

    @FindBy(id = "who-are-you-selectState")
    WebElement drpdnState;

    @FindBy(id = "who-are-you-zipCodeInput")
    WebElement txtZip;

    @FindBy(id = "who-are-you-countySelect")
    WebElement drpdnCounty;

    @FindBy(id = "birthDate")
    WebElement txtDOB;

    @FindBy(id = "ssn")
    WebElement txtSSN;

    @FindBy(id = "whoAreYou-GoBack")
    WebElement btnGoBack;

    @FindBy(id = "whoAreYou-SaveAndContinue")
    WebElement btnSaveAndContinue;

    public void navigateWhoAreYou(){
        basicActions.getDriver().get("https://qa-aws.connectforhealthco.com/IdentityProofingPortal/who-are-you");
    }

    public void selectPerson(String member){
        basicActions.waitForElementToBePresent(selectPersonNewAuthRep,15);

        switch (member) {
            case "Primary":
                String primaryName = SharedData.getPrimaryMember().getFirstName() + SharedData.getPrimaryMember().getLastName();
                basicActions.click(basicActions.getDriver().findElement(By.id("select-person-"+primaryName)));
                break;
            case "New Authorized Rep":
                basicActions.click(selectPersonNewAuthRep);
                break;
            case "Someone Else":
                basicActions.click(selectPersonSomeoneElse);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + member);
        }
    }

}
