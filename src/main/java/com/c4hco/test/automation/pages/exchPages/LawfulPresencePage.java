package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class LawfulPresencePage {
    private BasicActions basicActions;

    public LawfulPresencePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "usCitizenYes")
    WebElement rdobtnCitizenYes;

    @FindBy(id = "usCitizenNo")
    WebElement rdobtnCitizenNo;

    @FindBy(id = "naturalizedCitizenYes")
    WebElement rdobtnNaturalizedYes;
    @FindBy(id = "naturalizedCitizenNo")
    WebElement rdobtnnaturalizedNo;

    @FindBy(id = "nonCitizenYes")
    WebElement rdobtnEligibleImmigrantYes;

    @FindBy(id = "nonCitzenNo")
    WebElement rdobtnEligibleImmigrantNo;

    @FindBy(id = "documentType")
    WebElement selectDocType;

    @FindBy(id = "alienNumberNonCitizen")
    WebElement alienNumberNonCitizen;

    @FindBy(id = "livedSince1996Yes")
    WebElement livedSince1996Yes;

    @FindBy(id = "livedSince1996No")
    WebElement livedSince1996No;

    @FindBy(id = "myselfMilitary")
    WebElement chkBoxMyselfMilitary;

    @FindBy(id = "spouseMilitary")
    WebElement chkBoxSpouseMilitary;

    @FindBy(id = "parentsMilitary")
    WebElement chkBoxParentsMilitary;

    @FindBy(id = "noneOfTheAbove")
    WebElement chkBoxNoneOfTheAbove;

    @FindBy(id = "nameMatchesYes")
    WebElement NameMatchesYes;

    @FindBy(id = "nameMatchesNo")
    WebElement nameMatchesNo;

    @FindBy(name = "saveAndContinue")
    WebElement saveContinue;

    public void isMemberCitizen(String YNCitizen){
        switch(YNCitizen){
            case "Yes":
                rdobtnCitizenYes.click();
                break;
            case "No":
                rdobtnCitizenNo.click();
        }
    }

    public void isMemberNaturalized(String YNNaturalized){
        switch(YNNaturalized){
            case "Yes":
                rdobtnNaturalizedYes.click();
                break;
            case "No":
                rdobtnnaturalizedNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNNaturalized);
        }
    }

    public void isMemberHaveEligibleImmigrationStatus(String YNEligibleImmigrationStatus){
        switch(YNEligibleImmigrationStatus){
            case "Yes":
                rdobtnEligibleImmigrantYes.click();
                break;
            case "No":
                rdobtnEligibleImmigrantNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNEligibleImmigrationStatus);
        }
    }

    public void selectDocumentType(String documentType){
        basicActions.waitForElementToBePresent(selectDocType, 15);

        Select dropdown = new Select(selectDocType);
        dropdown.selectByVisibleText(documentType);
    }

    public static String generateUSCISNumber(){
        Random rand = new Random();
        int USCISNumber = 100_000_000 + rand.nextInt(900_000_000);
        return String.valueOf(USCISNumber);
    }

    public void enterUSCISNumber(){
        String USCISNumberValue = generateUSCISNumber();
        alienNumberNonCitizen.sendKeys(USCISNumberValue);
    }

    public void isMemberLivedInUSSince1996(String YNLivedInUSSince1996){
        switch(YNLivedInUSSince1996){
            case "Yes":
                livedSince1996Yes.click();
                break;
            case "No":
                livedSince1996No.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNLivedInUSSince1996);
        }
    }

    public void selectActiveDutyMilitaryOrHonorablyDischargedVeterans(String memberOptions){
        switch(memberOptions){
            case "Me":
                chkBoxMyselfMilitary.click();
                break;
            case "My spouse":
                chkBoxSpouseMilitary.click();
                break;
            case "One or both of my parents":
                chkBoxParentsMilitary.click();
                break;
            case "None of the above":
                chkBoxNoneOfTheAbove.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + memberOptions);
        }
    }

    public void selectNameMatchesDocument(String YNNameMatchesDocument){
        switch(YNNameMatchesDocument){
            case "Yes":
                NameMatchesYes.click();
                break;
            case "No":
                nameMatchesNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNNameMatchesDocument);
        }
    }

    public  void clickContinue(){saveContinue.click();}

    public void getPrimaryMemberId() {
        String currentUrl = basicActions.getCurrentUrl();
       SharedData.setPrimaryMemberId(currentUrl.substring(currentUrl.indexOf('=')+1));
        System.out.println("Primary Member ID: "+SharedData.getPrimaryMemberId());
    }

}
