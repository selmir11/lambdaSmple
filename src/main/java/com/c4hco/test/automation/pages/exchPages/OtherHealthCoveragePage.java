package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class OtherHealthCoveragePage {
    BasicActions basicActions;
    Actions action;

    Actions actions = new Actions(WebDriverManager.getDriver());

    SoftAssert softAssert = new SoftAssert();
    private WebDriver driver;
    public OtherHealthCoveragePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        action = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement existingHealthInsuranceHeader;

    @FindBy(css = ".header-3.content-center > a")
    WebElement helpLink;

    @FindBy(css = ".parent-position > span")
    WebElement areYouCurrentlyText;

    @FindBy(css = ".parent-position > div")
    List<WebElement> existingHealthInsurancePageTxt1;

    @FindBy(css = ".parent-position > div > div")
    List<WebElement> existingHealthInsurancePageTxt2;

    @FindBy(css = "span > em")
    WebElement existingHealthInsurancePageTxtPlus;

    @FindBy(css = "lib-checkbox-control label")
    List<WebElement> insuranceOptionsBox;

    @FindBy(css = "label > button")
    List<WebElement> insuranceOptionsCheckBox;
    
    @FindBy(css = "lib-checkbox-control > label")
    List<WebElement> insuranceOptionsCheckBoxDetails;

    @FindBy(css = ".container .help-icon")
    List<WebElement> helpCircleButton;

    @FindBy(id = "existingOHC-GoBack")
    WebElement backButton;

    @FindBy(id = "existingOHC-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;
    
    @FindBy(css = ".error-message")
    WebElement errorMessageTxt;

    @FindBy(id = "Help.Button")
    WebElement helpSideButton;

    @FindBy(css = ".desktop-help span")
    List<WebElement> helpDrawerHeader;

    @FindBy(css = ".help-main-content > strong")
    List<WebElement> helpDrawerHelpHeaders;

    @FindBy(css = ".help-main-content > p")
    List<WebElement> helpDrawerBody;

    @FindBy(css = ".help-footer")
    WebElement helpDrawerFooter;

    @FindBy(css = ".help-footer a")
    WebElement helpDrawerFooterLink;

    @FindBy(css = ".loader-overlay")
    WebElement spinner;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[1]")
    WebElement labelEmpSponHealthInsurance;

    @FindBy(xpath = "//*[@class='dropdown-label form-label ng-star-inserted']")
    WebElement label_whichJobIsOffering;

    @FindBy(xpath = "//*[@id='ELIG-Ohc-Esi-employer']")
    WebElement dropDownUnderWhichJobIs;

    @FindBy(xpath = "//option[@class='ng-star-inserted']")
    List<WebElement> dropDownAllOptions;

    @FindBy(xpath = "//button[@id='Ohc-Esi-GoBack']")
    WebElement goBackBtnEmpSpon;

    @FindBy(xpath = "//*[@type='outline']")
    WebElement goBackBtnEmpSponOutline;

    @FindBy(xpath = "//button[@id='Ohc-Esi-SaveAndContinue']")
    WebElement saveAndContBtnEmpSpon;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
    WebElement labelDoesThisHealthInsurance;

    @FindBy(xpath = "//button[@id='ELIG-Ohc-Esi-minStdVal-YesButton']")
    WebElement btnYesDoesThisHealthInsurance;

    @FindBy(xpath = "//button[@id='ELIG-Ohc-Esi-minStdVal-NoButton']")
    WebElement btnNoDoesThisHealthInsurance;

    @FindBy(xpath = "//button[@id='ELIG-Ohc-Esi-minStdVal-IDontKnowButton']")
    WebElement btnIDontNoDoesThisHealthInsurance;

    @FindBy(xpath = "(//label[@class='input-label form-label ng-star-inserted'])[1]")
    WebElement labelHowMuchWouldYou;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement txtBoxMonthlyAmount;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[3]")
    WebElement labelAreYouCurrentlyEnrolled;

    @FindBy(xpath = "//*[@id='ELIG-Ohc-Esi-currEnrl-YesButton']")
    WebElement btnYesAreYouCurrentlyEnrolled;

    @FindBy(xpath = "//*[@id='ELIG-Ohc-Esi-currEnrl-NoButton']")
    WebElement btnNoAreYouCurrentlyEnrolled;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[5]")
    WebElement labelWillThisHealthInsurance;

    @FindBy(xpath ="//*[@id='ELIG-Ohc-Esi-covgEndsSoon-YesButton']")
    WebElement btnYesWillThisHealthInsurance;

    @FindBy(xpath ="//*[@id='ELIG-Ohc-Esi-covgEndsSoon-NoButton']")
    WebElement btnNoWillThisHealthInsurance;

    @FindBy(xpath = "//label[@For='ELIG-Ohc-Esi-empSponsCovgEndDate']")
    WebElement labelWhatDayWillYour;

    @FindBy(xpath = "//label[@For='ELIG-Ohc-Esi-empVoluntaryEnd']/span")
    WebElement labelAreYouVoluntarily;

    @FindBy(xpath = "//input[@type='date']")
    WebElement txtBoxCalender;

    @FindBy(xpath = "//button[@id='ELIG-Ohc-Esi-empVoluntaryEnd-YesButton']")
    WebElement btnYesAreYouVoluntarily;

    @FindBy(xpath = "//button[@id='ELIG-Ohc-Esi-empVoluntaryEnd-NoButton']")
    WebElement btnNoAreYouVoluntarily;


    public void selectInsuranceOptionOnly(String insuranceOption){
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresentWithRetries(existingHealthInsuranceHeader,15);
        basicActions.waitForElementListToBePresent(existingHealthInsurancePageTxt1,15);
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        switch(insuranceOption){
            case "Health First Colorado":
                basicActions.click(insuranceOptionsCheckBox.get(0));
                break;
            case "CHP+":
                basicActions.click(insuranceOptionsCheckBox.get(1));
                break;
            case "Medicare":
                basicActions.click(insuranceOptionsCheckBox.get(2));
                break;
            case "job":
                basicActions.click(insuranceOptionsCheckBox.get(3));
                break;
            case "HRA":
                basicActions.click(insuranceOptionsCheckBox.get(4));
                break;
            case "Retiree Health Plan":
                basicActions.click(insuranceOptionsCheckBox.get(5));
                break;
            case "Peace Corps":
                basicActions.click(insuranceOptionsCheckBox.get(6));
                break;
            case "COBRA":
                basicActions.click(insuranceOptionsCheckBox.get(7));
                break;
            case "VA Health Care":
                basicActions.click(insuranceOptionsCheckBox.get(8));
                break;
            case "TRICARE":
                basicActions.click(insuranceOptionsCheckBox.get(9));
                break;
            case "Other":
                basicActions.click(insuranceOptionsCheckBox.get(10));
                break;
            case "None of these":
                basicActions.waitForElementToBePresent(insuranceOptionsCheckBox.get(11), 30);
                basicActions.clickElementWithRetries(insuranceOptionsCheckBox.get(11), 30);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceOption);
        }
    }

    public void clickSaveAndContinue(){
        basicActions.waitForElementToDisappear(spinner, 150);
        basicActions.waitForElementToBePresentWithRetries(saveAndContinueBtn, 150);
        basicActions.scrollToElement(saveAndContinueBtn);
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 30);
        saveAndContinueBtn.click();
    }

    public void clickHelpMeUnderstandLink(){
        basicActions.waitForElementToBeClickable(helpLink, 20);
        helpLink.click();
    }

    public void clickHelpSideButton(){
        basicActions.waitForElementToBeClickable(helpSideButton, 20);
        helpSideButton.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToDisappear( spinner, 60 );
        basicActions.waitForElementToBeClickable(backButton, 20);
        basicActions.scrollToElement(backButton);
        backButton.click();
    }

    public void clickHelpContactUsNavigation() {
        basicActions.waitForElementToBePresent(helpDrawerFooter, 10);
        helpDrawerFooterLink.click();
    }




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    
    public void verifyTextOnOtherHealthCoveragePage(String language){
        switch(language){
            case "English":
                verifyTextOnOtherHealthCoveragePageEnglish();
                break;
            case "English Secondary":
                verifyTextOnOtherHealthCoveragePageEnglishSecondary();
                break;
            case "Spanish":
                verifyTextOnOtherHealthCoveragePageSpanish();
                break;
            case "Spanish Secondary":
                verifyTextOnOtherHealthCoveragePageSpanishSecondary();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnOtherHealthCoveragePageEnglish(){
        basicActions.waitForElementToBePresentWithRetries(existingHealthInsuranceHeader,30);
        basicActions.waitForElementToBePresentWithRetries(helpLink,30);
        softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(helpLink.getText(), "Help me understand this page");
        softAssert.assertEquals(helpLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(helpLink.getCssValue("font-size"), "18px");
        softAssert.assertEquals(helpLink.getCssValue("font-weight"), "700");
        softAssert.assertEquals(helpLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(areYouCurrentlyText.getText(), "Are you currently enrolled in or eligible to receive any of the following types of health coverage?");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(), "(Select all that apply)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(), "Coverage through a Public Program");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getText(), "Health First Colorado (Colorado\u2019s Medicaid Program)\nIf your Health First Colorado coverage is ending in the next 60 days, do not select this option.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getText(), "Child Health Plan\nPlus\n(CHP+)\nIf your CHP+ coverage is ending in the next 60 days, do not select this option.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(), "Medicare");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(), "Coverage through an Employer");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(), "Health insurance offered through a job");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(), "Health Reimbursement Arrangement (HRA)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(), "Retiree Health Plan");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(), "Peace Corps");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(), "COBRA");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(), "Coverage through the Military");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(), "VA Health Care");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(), "TRICARE");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(), "Individual Insurance");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(), "Health insurance purchased directly through an insurance company, through Healthcare.gov, or another state\u2019s Marketplace.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getText(), "None of these");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(backButton.getText(),"Go back");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
        action.moveToElement(backButton).pause(1000L).build().perform();
        softAssert.assertEquals(backButton.getText(),"Go back");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(226, 241, 248, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }

    public void verifyTextOnOtherHealthCoveragePageEnglishSecondary(){
        basicActions.waitForElementToBePresent(existingHealthInsuranceHeader,15);
        softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(helpLink.getText(), "Help me understand this page");
        softAssert.assertEquals(helpLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(helpLink.getCssValue("font-size"), "18px");
        softAssert.assertEquals(helpLink.getCssValue("font-weight"), "700");
        softAssert.assertEquals(helpLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertTrue(areYouCurrentlyText.getText().equalsIgnoreCase( "Is " + SharedData.getMembers().get(0).getFullName()+ " currently enrolled in or eligible to receive any of the following types of health coverage?"));
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(), "(Select all that apply)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(), "Coverage through a Public Program");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertTrue(existingHealthInsurancePageTxt2.get(1).getText().equalsIgnoreCase( "Health First Colorado (Colorado\u2019s Medicaid Program)\nIf " + SharedData.getMembers().get(0).getFullName()+ "'s Health First Colorado coverage is ending in the next 60 days, do not select this option."));
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertTrue(existingHealthInsurancePageTxt2.get(2).getText().equalsIgnoreCase( "Child Health Plan\nPlus\n(CHP+)\nIf " + SharedData.getMembers().get(0).getFullName()+ "'s CHP+ coverage is ending in the next 60 days, do not select this option."));
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(), "Medicare");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(), "Coverage through an Employer");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(), "Health insurance offered through a job");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(), "Health Reimbursement Arrangement (HRA)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(), "Retiree Health Plan");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(), "Peace Corps");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(), "COBRA");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(), "Coverage through the Military");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(), "VA Health Care");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(), "TRICARE");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(), "Individual Insurance");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(), "Health insurance purchased directly through an insurance company, through Healthcare.gov, or another state\u2019s Marketplace.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getText(), "None of these");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(backButton.getText(),"Go back");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
        action.moveToElement(backButton).pause(1000L).build().perform();
        softAssert.assertEquals(backButton.getText(),"Go back");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(226, 241, 248, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }

    public void verifyTextOnOtherHealthCoveragePageSpanish(){
        basicActions.waitForElementToBePresent(existingHealthInsuranceHeader,15);
        softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(helpLink.getText(), "Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(helpLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(helpLink.getCssValue("font-size"), "18px");
        softAssert.assertEquals(helpLink.getCssValue("font-weight"), "700");
        softAssert.assertEquals(helpLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(areYouCurrentlyText.getText(), "\u00BFEst\u00E1 inscrito actualmente o es elegible para recibir alguno de los siguientes tipos de cobertura de salud?");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(), "(Seleccione todo lo que corresponda)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(), "Cobertura a trav\u00E9s de un programa p\u00FAblico");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getText(), "Health First Colorado (Programa Medicaid de Colorado)\nSi su cobertura de Health First Colorado va a terminar en los pr\u00F3ximos 60 d\u00EDas, no seleccione esta opci\u00F3n.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getText(), "Child Health Plan\nPlus\n(CHP+)\nSi su cobertura de CHP+ va a terminar en los pr\u00F3ximos 60 d\u00EDas, no seleccione esta opci\u00F3n.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(), "Medicare");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(), "Cobertura a trav\u00E9s de un empleador");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(), "Provisi\u00F3n de reembolso de salud (HRA)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(), "Plan de salud de jubilado");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(), "Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(), "COBRA");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(), "Cobertura a trav\u00E9s del ej\u00E9rcito");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(), "Servicios de Salud para Veteranos (VA)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(), "TRICARE");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(), "Seguro individual");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(), "Seguro de salud adquirido directamente a trav\u00E9s de una compa\u00F1\u00EDa de seguros, por medio de HealthCare.gov o a trav\u00E9s de otro Mercado del estado.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getText(), "Ninguna de las anteriores");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(backButton.getText(),"Volver");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
        action.moveToElement(backButton).pause(1000L).build().perform();
        softAssert.assertEquals(backButton.getText(),"Volver");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(226, 241, 248, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }

    public void verifyTextOnOtherHealthCoveragePageSpanishSecondary(){
        basicActions.waitForElementToBePresent(existingHealthInsuranceHeader,15);
        softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(helpLink.getText(), "Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(helpLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(helpLink.getCssValue("font-size"), "18px");
        softAssert.assertEquals(helpLink.getCssValue("font-weight"), "700");
        softAssert.assertEquals(helpLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertTrue(areYouCurrentlyText.getText().equalsIgnoreCase( "\u00BFEst\u00E1 " +SharedData.getMembers().get(0).getFullName()+ " inscrito actualmente o es elegible para recibir alguno de los siguientes tipos de cobertura de salud?"));
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(areYouCurrentlyText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(), "(Seleccione todo lo que corresponda)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(), "Cobertura a trav\u00E9s de un programa p\u00FAblico");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertTrue(existingHealthInsurancePageTxt2.get(1).getText().equalsIgnoreCase( "Health First Colorado (Programa Medicaid de Colorado)\nSi la cobertura de " +SharedData.getMembers().get(0).getFullName()+ " de Health First Colorado va a terminar en los pr\u00F3ximos 60 d\u00EDas, no seleccione esta opci\u00F3n."));
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertTrue(existingHealthInsurancePageTxt2.get(2).getText().equalsIgnoreCase( "Child Health Plan\nPlus\n(CHP+)\nSi la cobertura de " +SharedData.getMembers().get(0).getFullName()+ " de CHP+ va a terminar en los pr\u00F3ximos 60 d\u00EDas, no seleccione esta opci\u00F3n."));
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(), "Medicare");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(), "Cobertura a trav\u00E9s de un empleador");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(), "Provisi\u00F3n de reembolso de salud (HRA)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(), "Plan de salud de jubilado");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(), "Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(), "COBRA");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(), "Cobertura a trav\u00E9s del ej\u00E9rcito");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(), "Servicios de Salud para Veteranos (VA)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(), "TRICARE");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(), "Seguro individual");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(), "Seguro de salud adquirido directamente a trav\u00E9s de una compa\u00F1\u00EDa de seguros, por medio de HealthCare.gov o a trav\u00E9s de otro Mercado del estado.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getText(), "Ninguna de las anteriores");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(backButton.getText(),"Volver");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
        action.moveToElement(backButton).pause(1000L).build().perform();
        softAssert.assertEquals(backButton.getText(),"Volver");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(226, 241, 248, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }

    public void verifyCheckboxesOnOtherHealthCoveragePage(){
        String expectedColor = "rgb(112, 163, 0)";
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        //softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(insuranceOptionsCheckBox.get(0).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(0));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor = insuranceOptionsCheckBox.get(0).getCssValue("background-color");
        String[] rgbaValues = rgbaColor.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues[0], rgbaValues[1], rgbaValues[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(1).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(1));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor2 = insuranceOptionsCheckBox.get(1).getCssValue("background-color");
        String[] rgbaValues2 = rgbaColor2.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues2[0], rgbaValues2[1], rgbaValues2[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(2).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(2));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor3 = insuranceOptionsCheckBox.get(2).getCssValue("background-color");
        String[] rgbaValues3 = rgbaColor3.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues3[0], rgbaValues3[1], rgbaValues3[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(3).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(3));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor4 = insuranceOptionsCheckBox.get(3).getCssValue("background-color");
        String[] rgbaValues4 = rgbaColor4.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues4[0], rgbaValues4[1], rgbaValues4[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(4).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(4));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor5 = insuranceOptionsCheckBox.get(4).getCssValue("background-color");
        String[] rgbaValues5 = rgbaColor5.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues5[0], rgbaValues5[1], rgbaValues5[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(5).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(5));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor6 = insuranceOptionsCheckBox.get(5).getCssValue("background-color");
        String[] rgbaValues6 = rgbaColor6.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues6[0], rgbaValues6[1], rgbaValues6[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(6).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(6));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor7 = insuranceOptionsCheckBox.get(6).getCssValue("background-color");
        String[] rgbaValues7 = rgbaColor7.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues7[0], rgbaValues7[1], rgbaValues7[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(7).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(7));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor8 = insuranceOptionsCheckBox.get(7).getCssValue("background-color");
        String[] rgbaValues8 = rgbaColor8.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues8[0], rgbaValues8[1], rgbaValues8[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(8).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(8));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor9 = insuranceOptionsCheckBox.get(8).getCssValue("background-color");
        String[] rgbaValues9 = rgbaColor9.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues9[0], rgbaValues9[1], rgbaValues9[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(9).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(9));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor10 = insuranceOptionsCheckBox.get(9).getCssValue("background-color");
        String[] rgbaValues10 = rgbaColor10.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues10[0], rgbaValues10[1], rgbaValues10[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(10).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(10));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor11 = insuranceOptionsCheckBox.get(10).getCssValue("background-color");
        String[] rgbaValues11 = rgbaColor11.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues11[0], rgbaValues11[1], rgbaValues11[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(11).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        basicActions.click(insuranceOptionsCheckBox.get(11));
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        String rgbaColor12 = insuranceOptionsCheckBox.get(11).getCssValue("background-color");
        String[] rgbaValues12 = rgbaColor12.replace("rgba(", "").replace(")", "").split(",\\s*");
        softAssert.assertEquals(String.format("rgb(%s, %s, %s)", rgbaValues12[0], rgbaValues12[1], rgbaValues12[2]), expectedColor);
        softAssert.assertEquals(insuranceOptionsCheckBox.get(0).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(1).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(2).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(3).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(4).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(5).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(6).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(7).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(8).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(9).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertEquals(insuranceOptionsCheckBox.get(10).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
        softAssert.assertAll();
    }

    public void verifyHelIconsOnOtherHealthCoveragePage(){
        basicActions.waitForElementListToBePresent(helpCircleButton,15);
        softAssert.assertEquals(helpCircleButton.get(0).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(1).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(2).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(3).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(4).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(5).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(6).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(7).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(8).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(9).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(helpCircleButton.get(10).getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertAll();
    }

    public void verifyHeadersOtherHealthCoveragePage(String member, String language) {
        basicActions.waitForElementToDisappear( spinner, 60 );
        basicActions.waitForElementToBePresentWithRetries(existingHealthInsuranceHeader, 60);
        basicActions.waitForElementToBePresent(saveAndContinueBtn, 60);

        String expectedText = "";
        switch (language) {
            case "English":
                expectedText = "Other Health Coverage: ";
                break;
            case "Spanish":
                expectedText = "Otra cobertura de salud: ";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }

        String memberName = getMemberFullName(member);
        expectedText += memberName;

        WebDriverWait wait = new WebDriverWait(basicActions.getDriver(), Duration.ofSeconds(50));
        WebElement value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'" + expectedText + "')]")));

        String actualText = existingHealthInsuranceHeader.getText();
        softAssert.assertTrue(actualText.equalsIgnoreCase(expectedText), "The text does not match! Expected: " + expectedText + " but found: " + actualText);
        softAssert.assertAll();
    }

    private String getMemberFullName(String member) {
        switch (member) {
            case "Primary":
                return SharedData.getPrimaryMember().getFullName();
            case "Secondary":
                return SharedData.getMembers().get(0).getFullName();
            case "Third":
                return SharedData.getMembers().get(1).getFullName();
            case "Forth":
                return SharedData.getMembers().get(2).getFullName();
            default:
                throw new IllegalArgumentException("Invalid option: " + member);
        }
    }

    public void verifyCheckboxesAttribute(String checkboxExpected) {
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBoxDetails,20);
        int[] uncheckedIndexes;
        int[] checkedIndexes;

        switch (checkboxExpected) {
            case "unselected":
                uncheckedIndexes = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
                checkedIndexes = new int[0];
                break;
            case "none of these":
                uncheckedIndexes = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                checkedIndexes = new int[]{11};
                break;
            case "Medicare, retiree, TRICARE":
                uncheckedIndexes = new int[]{0, 1, 3, 4, 6, 7, 8, 10, 11};
                checkedIndexes = new int[]{2, 5, 9};
                break;
            case "Medicaid, CHP+, COBRA":
                uncheckedIndexes = new int[]{2, 3, 4, 5, 6, 8, 10, 11};
                checkedIndexes = new int[]{0, 1, 7};
                break;
            case "Medicaid, CHP+, ESI, COBRA":
                uncheckedIndexes = new int[]{2, 4, 5, 6, 8, 10, 11};
                checkedIndexes = new int[]{0, 1, 3, 7};
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + checkboxExpected);
        }

        for (int i : uncheckedIndexes) {
            softAssert.assertEquals(insuranceOptionsCheckBoxDetails.get(i).getAttribute("className"), "checkbox-container");
            softAssert.assertAll();
        }
        for (int i : checkedIndexes) {
            softAssert.assertEquals(insuranceOptionsCheckBoxDetails.get(i).getAttribute("className"), "checkbox-container checked");
            softAssert.assertAll();
        }
    }

    public void verifyErrorMessage(String language) {
        basicActions.waitForElementToBePresent(errorMessageTxt, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(errorMessageTxt.getText(), "Please select one or more of the options below");
                softAssert.assertEquals(errorMessageTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(errorMessageTxt.getCssValue("font-size"), "16px");
                softAssert.assertEquals(errorMessageTxt.getCssValue("font-weight"), "700");
                softAssert.assertEquals(errorMessageTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(errorMessageTxt.getText(), "Seleccione una o m\u00E1s de las opciones siguientes");
                softAssert.assertEquals(errorMessageTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(errorMessageTxt.getCssValue("font-size"), "16px");
                softAssert.assertEquals(errorMessageTxt.getCssValue("font-weight"), "700");
                softAssert.assertEquals(errorMessageTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyNoErrorMessage() {
        softAssert.assertTrue(basicActions.waitForElementToDisappear(errorMessageTxt, 10));
        softAssert.assertAll();
    }

    public void verifyOhcPageData(String language){
        basicActions.waitForElementToBePresent(existingHealthInsuranceHeader,15);
        basicActions.waitForElementToBePresent(areYouCurrentlyText,15);
        switch (language){
            case "English":
                softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(helpLink.getText(),"Help me understand this page");
                softAssert.assertEquals(areYouCurrentlyText.getText(),"Are you currently enrolled in or eligible to receive any of the following types of health coverage?");
                softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(),"(Select all that apply)");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(),"Coverage through a Public Program");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getText(),"Health First Colorado (Colorado\u2019s Medicaid Program)\nIf your Health First Colorado coverage is ending in the next 60 days, do not select this option.");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getText(),"Child Health Plan\nPlus\n(CHP+)\nIf your CHP+ coverage is ending in the next 60 days, do not select this option.");
                softAssert.assertEquals(existingHealthInsurancePageTxtPlus.getText(),"Plus");
                verifyItalicFormat(existingHealthInsurancePageTxtPlus);
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(),"Medicare");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(),"Coverage through an Employer");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(),"Health insurance offered through a job");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(),"Health Reimbursement Arrangement (HRA)");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(),"Retiree Health Plan");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(),"Peace Corps");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(),"COBRA");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(),"Coverage through the Military");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(),"VA Health Care");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(),"TRICARE");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(),"Individual Insurance");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(),"Health insurance purchased directly through an insurance company, through Healthcare.gov, or another state\u2019s Marketplace.");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getText(),"None of these");
                softAssert.assertEquals(backButton.getText(),"Go back");
                softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and continue");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(helpLink.getText(),"Ayuda para entender esta p\u00E1gina");
                softAssert.assertEquals(areYouCurrentlyText.getText(),"\u00BFEst\u00E1 inscrito actualmente o es elegible para recibir alguno de los siguientes tipos de cobertura de salud?");
                softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(),"(Seleccione todo lo que corresponda)");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(),"Cobertura a trav\u00E9s de un programa p\u00FAblico");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getText(),"Health First Colorado (Programa Medicaid de Colorado)\nSi su cobertura de Health First Colorado va a terminar en los pr\u00F3ximos 60 d\u00EDas, no seleccione esta opci\u00F3n.");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getText(),"Child Health Plan\nPlus\n(CHP+)\nSi su cobertura de CHP+ va a terminar en los pr\u00F3ximos 60 d\u00EDas, no seleccione esta opci\u00F3n.");
                softAssert.assertEquals(existingHealthInsurancePageTxtPlus.getText(),"Plus");
                verifyItalicFormat(existingHealthInsurancePageTxtPlus);
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(),"Medicare");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(),"Cobertura a trav\u00E9s de un empleador");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(),"Seguro de salud ofrecido a trav\u00E9s de un empleo");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(),"Provisi\u00F3n de reembolso de salud (HRA)");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(),"Plan de salud de jubilado");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(),"Cuerpos de paz (Peace Corps)");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(),"COBRA");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(),"Cobertura a trav\u00E9s del ej\u00E9rcito");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(),"Servicios de Salud para Veteranos (VA)");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(),"TRICARE");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(),"Seguro individual");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(),"Seguro de salud adquirido directamente a trav\u00E9s de una compa\u00F1\u00EDa de seguros, por medio de HealthCare.gov o a trav\u00E9s de otro Mercado del estado.");
                softAssert.assertEquals(existingHealthInsurancePageTxt2.get(16).getText(),"Ninguna de las anteriores");
                softAssert.assertEquals(backButton.getText(),"Volver");
                softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHelpDrawerHeadersFormat(WebElement element) {
        basicActions.waitForElementListToBePresent(helpDrawerBody, 20);
        softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(element.getCssValue("font-size"), "16px");
        softAssert.assertEquals(element.getCssValue("font-weight"), "700");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(43, 49, 60, 1)");
    }

    public void verifyHelpDrawerHeadersItalicFormat(WebElement element) {
        basicActions.waitForElementListToBePresent(helpDrawerBody, 20);
        softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(element.getCssValue("font-size"), "16px");
        softAssert.assertEquals(element.getCssValue("font-style"), "italic");
        softAssert.assertEquals(element.getCssValue("font-weight"), "700");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(43, 49, 60, 1)");
    }

    public void verifyItalicFormat(WebElement element) {
        basicActions.waitForElementListToBePresent(helpDrawerBody, 20);
        softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(element.getCssValue("font-size"), "16px");
        softAssert.assertEquals(element.getCssValue("font-style"), "italic");
        softAssert.assertEquals(element.getCssValue("font-weight"), "400");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(43, 49, 60, 1)");
    }

    public void verifyHelpDrawerParagraphsFormat(WebElement element) {
        basicActions.waitForElementListToBePresent(helpDrawerBody, 20);
        softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(element.getCssValue("font-size"), "16px");
        softAssert.assertEquals(element.getCssValue("font-weight"), "400");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(43, 49, 60, 1)");
    }

    public void verifyHelpDrawerHeaderText(String language) {
        basicActions.waitForElementListToBePresent(helpDrawerHeader, 20);

        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerHeader.get(0).getText(), "Help");
                verifyHelpDrawerParagraphsFormat(helpDrawerHeader.get(0));
                softAssert.assertEquals(helpDrawerHeader.get(2).getText(), "Other Health Coverage");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("font-size"), "20px");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("font-weight"), "700");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("color"), "rgba(112, 163, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerHeader.get(0).getText(), "Ayuda");
                verifyHelpDrawerParagraphsFormat(helpDrawerHeader.get(0));
                softAssert.assertEquals(helpDrawerHeader.get(2).getText(), "Otra cobertura de salud");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("font-size"), "20px");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("font-weight"), "700");
                softAssert.assertEquals(helpDrawerHeader.get(2).getCssValue("color"), "rgba(112, 163, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHelpDrawerBodyText_English() {
        basicActions.waitForElementListToBePresent(helpDrawerHelpHeaders, 20);
        softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Overview");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
        softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Connect for Health Colorado is required to find out if you have or can get any other type of health coverage right now. This information will help us find which health plans and financial help you can get.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(1).getText(), "Health First Colorado (Colorado's Medicaid program)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(1));
        softAssert.assertEquals(helpDrawerBody.get(1).getText(), "If you will lose eligibility for this program, do not select this option. Instead, select \"None of these apply\" and click \"Save and Continue.\"\nThis program provides low and $0 health insurance coverage for people with qualified income.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(1));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(2).getText(), "Child Health Plan Plus (CHP+)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(2));
        softAssert.assertEquals(helpDrawerBody.get(2).getText(), "If you will lose eligibility for this program, do not select this option. Instead, select \"None of these apply\" and click \"Save and Continue.\"\nThis program provides low-cost health insurance for children and pregnant people who earn too much to qualify for Health First Colorado. If you decide to buy a health insurance plan through Connect for Health Colorado, you cannot keep your CHP+ insurance.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(2));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(3).getText(), "Medicare");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(3));
        softAssert.assertEquals(helpDrawerBody.get(3).getText(), "This is the national health insurance program for people age 65 or older, or who have a disability determined by the Social Security Administration.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(3));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(4).getText(), "Employer Sponsored Health Insurance");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(4));
        softAssert.assertEquals(helpDrawerBody.get(4).getText(), "This is health insurance through a job or a spouse's job. If you are currently in a waiting period for your employer-sponsored health insurance to begin (meaning that your employer has offered coverage to you or your dependent, but the coverage will be effective later), you may be eligible for a Premium Tax Credit during that waiting period. If you are currently in a waiting period, you should not check the box here. Instead, you should come back just before your waiting period is over to report your upcoming enrollment in employer-sponsored insurance. To avoid duplicate coverage and overlapping monthly premium charges for both plans, you must report your employer insurance change in your Connect for Health Colorado account as soon as possible \u2013 ideally, in the month before your coverage begins.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(4));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(5).getText(), "Employer Sponsored Health Reimbursement Arrangement");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(5));
        softAssert.assertEquals(helpDrawerBody.get(5).getText(), "Select this option if your employer offers you a Health Reimbursement Arrangement (HRA) to help you pay for health insurance, even if you do not sign up for it. The HRA option that your employer offers may be called a Qualified Small Employer HRA (QSEHRA) or an Individual Coverage HRA (ICHRA).");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(5));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(6).getText(), "Retiree Health Plan");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(6));
        softAssert.assertEquals(helpDrawerBody.get(6).getText(), "This is the health insurance option for people who have retired from their job.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(6));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(7).getText(), "Peace Corps");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(7));
        softAssert.assertEquals(helpDrawerBody.get(7).getText(), "This is a health insurance program for former Peace Corps volunteers.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(7));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(8).getText(), "COBRA");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(8));
        softAssert.assertEquals(helpDrawerBody.get(8).getText(), "This is the health insurance option for people after they've left their job with employer-sponsored health insurance.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(8));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(9).getText(), "Veteran's (VA) Healthcare");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(9));
        softAssert.assertEquals(helpDrawerBody.get(9).getText(), "This is the national health insurance program for qualified veterans of the military.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(9));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(10).getText(), "TRICARE");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(10));
        softAssert.assertEquals(helpDrawerBody.get(10).getText(), "This is a health care program of the United States Department of Defense Military Health System.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(10));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(11).getText(), "Individual Insurance (outside of Marketplace)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(11));
        softAssert.assertEquals(helpDrawerBody.get(11).getText(), "This is health private insurance that you currently have that you did not get through Connect for Health Colorado or your job.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(11));
        softAssert.assertAll();
    }

    public void verifyHelpDrawerBodyText_Spanish() {
        basicActions.waitForElementListToBePresent(helpDrawerBody, 20);
        softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Resumen");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
        softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Es obligaci\u00F3n de Connect for Health Colorado preguntarle si en este momento tiene o puede obtener alg\u00FAn otro tipo de cobertura de salud. Esta informaci\u00F3n nos ayudar\u00E1 a encontrar qu\u00E9 planes de seguro de salud y ayuda financiera puede obtener.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(1).getText(), "Health First Colorado (Programa Medicaid de Colorado)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(1));
        softAssert.assertEquals(helpDrawerBody.get(1).getText(), "No seleccione esta opci\u00F3n si va a perder elegibilidad para este programa. Seleccione \"Ninguno de estos aplica\" y haga clic en \"Guardar y continuar\".\nEste programa ofrece una cobertura de seguro de salud gratuito o de bajo costo a las personas con ingresos calificados.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(1));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(2).getText(), "Child Health Plan Plus (CHP+)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(2));
        softAssert.assertEquals(helpDrawerBody.get(2).getText(), "No seleccione esta opci\u00F3n si va a perder elegibilidad para este programa. Seleccione \"Ninguno de estos aplica\" y haga clic en \"Guardar y continuar\".\nEste programa ofrece un seguro de salud de bajo costo para ni\u00F1os y personas embarazadas que ganan demasiado para calificar para Health First Colorado. Si decide adquirir un plan de seguro de salud a trav\u00E9s de Connect for Health Colorado, no podr\u00E1 mantener su seguro CHP+.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(2));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(3).getText(), "Medicare");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(3));
        softAssert.assertEquals(helpDrawerBody.get(3).getText(), "Es el programa nacional de seguro de salud para las personas de 65 a\u00F1os o m\u00E1s o que tienen una discapacidad seg\u00FAn lo determina la Administraci\u00F3n del Seguro Social.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(3));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(4).getText(), "Seguro de salud patrocinado por el empleador");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(4));
        softAssert.assertEquals(helpDrawerBody.get(4).getText(), "Es el seguro de salud que se obtiene a trav\u00E9s de un empleo propio o del c\u00F3nyuge. Si est\u00E1 actualmente en un per\u00EDodo de espera para que comience el seguro de salud de patrocinado por su empleador (es decir, que su empleador le ofrece cobertura para usted o su dependiente, pero la cobertura tomar\u00E1 efecto despu\u00E9s), puede ser elegible para obtener un Cr\u00E9dito fiscal para el pago de la cuota durante ese per\u00EDodo. Si actualmente est\u00E1 en un per\u00EDodo de espera, no debe marcar la casilla aqu\u00ED. Por el contrario, debe regresar justo antes de que el per\u00EDodo de espera finalice para reportar su pr\u00F3xima inscripci\u00F3n en el seguro patrocinado por su empleador. Para evitar doble cobertura y cargos mensuales de las cuotas de ambos planes, debe reportar el cambio del seguro patrocinado por su empleador en su cuenta de Connect for Health Colorado lo m\u00E1s pronto posible, preferentemente, el mes antes de que comience su cobertura.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(4));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(5).getText(), "Una cuenta de reembolso de gastos m\u00E9dicos (HRA en ingl\u00E9s) ofrecido a trav\u00E9s de un empleador");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(5));
        softAssert.assertEquals(helpDrawerBody.get(5).getText(), "Seleccione esta opci\u00F3n si sus empleador le ofrece una Cuenta de reembolso de gastos m\u00E9dicos (HRA) para ayudarle a pagar su seguro de salud, incluso si no se inscribe en uno. La opci\u00F3n HRA que le ofrece su empleador puede ser llamada HRA de Peque\u00F1o empleador calificado (QSEHRA) o HRA de Cobertura individual (ICHRA).");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(5));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(6).getText(), "Plan de salud de jubilado");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(6));
        softAssert.assertEquals(helpDrawerBody.get(6).getText(), "Esta es la opci\u00F3n de seguro de salud para las personas que se han retirado en su trabajo.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(6));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(7).getText(), "Cuerpos de paz (Peace Corps)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(7));
        softAssert.assertEquals(helpDrawerBody.get(7).getText(), "Este es un programa de seguro de salud para antiguos voluntarios del Cuerpo de Paz.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(7));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(8).getText(), "COBRA");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(8));
        softAssert.assertEquals(helpDrawerBody.get(8).getText(), "Esta es la opci\u00F3n de seguro de salud para personas que han dejado su empleo con seguro de salud patrocinado por el empleador.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(8));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(9).getText(), "Servicios de Salud para Veteranos (VA)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(9));
        softAssert.assertEquals(helpDrawerBody.get(9).getText(), "Este es el programa nacional de seguro de salud para veteranos del ej\u00E9rcito aprobados.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(9));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(10).getText(), "TRICARE");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(10));
        softAssert.assertEquals(helpDrawerBody.get(10).getText(), "Este es un programa de servicios m\u00E9dicos del Sistema de Salud Militar del Departamento de Defensa de Estados Unidos.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(10));
        softAssert.assertEquals(helpDrawerHelpHeaders.get(11).getText(), "Seguro individual (fuera del Mercado)");
        verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(11));
        softAssert.assertEquals(helpDrawerBody.get(11).getText(), "Este es el seguro de salud privado que tiene usted actualmente y que no obtuvo por medio de Connect for Health Colorado o su trabajo.");
        verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(11));
        softAssert.assertAll();
    }

    public void verifyHelpDrawerBodyText(String language) {
        basicActions.waitForElementListToBePresent(helpDrawerBody, 20);

        switch (language) {
            case "English":
                verifyHelpDrawerBodyText_English();
                break;
            case "Spanish":
                verifyHelpDrawerBodyText_Spanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHelpDrawerFooterText(String language) {
        basicActions.waitForElementToBePresent(helpDrawerFooter, 20);

        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("font-size"), "16px");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("font-weight"), "400");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("color"), "rgba(77, 77, 79, 1)");
                softAssert.assertEquals(helpDrawerFooterLink.getText(), "Contact us");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("font-size"), "16px");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("font-weight"), "700");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("font-size"), "16px");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("font-weight"), "400");
                softAssert.assertEquals(helpDrawerFooter.getCssValue("color"), "rgba(77, 77, 79, 1)");
                softAssert.assertEquals(helpDrawerFooterLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("font-size"), "16px");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("font-weight"), "700");
                softAssert.assertEquals(helpDrawerFooterLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHelpTextForQuestions_English(String insurance) {
        basicActions.waitForElementListToBePresent(helpCircleButton, 20);

        switch(insurance){
            case "Health First Colorado":
                helpCircleButton.get(0).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Health First Colorado (Colorado's Medicaid program)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "If you will lose eligibility for this program, do not select this option. Instead, select \"None of these apply\" and click \"Save and Continue.\"\nThis program provides low and $0 health insurance coverage for people with qualified income.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Child Health Plan Plus":
                helpCircleButton.get(1).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Child Health Plan Plus (CHP+)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "If you will lose eligibility for this program, do not select this option. Instead, select \"None of these apply\" and click \"Save and Continue.\"\nThis program provides low-cost health insurance for children and pregnant people who earn too much to qualify for Health First Colorado. If you decide to buy a health insurance plan through Connect for Health Colorado, you cannot keep your CHP+ insurance.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Medicare":
                helpCircleButton.get(2).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Medicare");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is the national health insurance program for people age 65 or older, or who have a disability determined by the Social Security Administration.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "ESI":
                helpCircleButton.get(3).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Employer Sponsored Health Insurance");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is health insurance through a job or a spouse's job. If you are currently in a waiting period for your employer-sponsored health insurance to begin (meaning that your employer has offered coverage to you or your dependent, but the coverage will be effective later), you may be eligible for a Premium Tax Credit during that waiting period. If you are currently in a waiting period, you should not check the box here. Instead, you should come back just before your waiting period is over to report your upcoming enrollment in employer-sponsored insurance. To avoid duplicate coverage and overlapping monthly premium charges for both plans, you must report your employer insurance change in your Connect for Health Colorado account as soon as possible \u2013 ideally, in the month before your coverage begins.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "HRA":
                helpCircleButton.get(4).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Employer Sponsored Health Reimbursement Arrangement");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Select this option if your employer offers you a Health Reimbursement Arrangement (HRA) to help you pay for health insurance, even if you do not sign up for it. The HRA option that your employer offers may be called a Qualified Small Employer HRA (QSEHRA) or an Individual Coverage HRA (ICHRA).");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Retiree":
                helpCircleButton.get(5).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Retiree Health Plan");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is the health insurance option for people who have retired from their job.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Peace Corps":
                helpCircleButton.get(6).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Peace Corps");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is a health insurance program for former Peace Corps volunteers.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "COBRA":
                helpCircleButton.get(7).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "COBRA");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is the health insurance option for people after they've left their job with employer-sponsored health insurance.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "VA Health Care":
                helpCircleButton.get(8).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Veteran's (VA) Healthcare");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is the national health insurance program for qualified veterans of the military.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "TRICARE":
                helpCircleButton.get(9).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "TRICARE");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is a health care program of the United States Department of Defense Military Health System.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Individual":
                helpCircleButton.get(10).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Individual Insurance (outside of Marketplace)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "This is health private insurance that you currently have that you did not get through Connect for Health Colorado or your job.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insurance);
        }
    }

    public void verifyHelpTextForQuestions_Spanish(String insurance) {
        basicActions.waitForElementListToBePresent(helpCircleButton, 20);

        switch(insurance) {
            case "Health First Colorado":
                helpCircleButton.get(0).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Health First Colorado (Programa Medicaid de Colorado)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "No seleccione esta opci\u00F3n si va a perder elegibilidad para este programa. Seleccione \"Ninguno de estos aplica\" y haga clic en \"Guardar y continuar\".\nEste programa ofrece una cobertura de seguro de salud gratuito o de bajo costo a las personas con ingresos calificados.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Child Health Plan Plus":
                helpCircleButton.get(1).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Child Health Plan Plus (CHP+)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "No seleccione esta opci\u00F3n si va a perder elegibilidad para este programa. Seleccione \"Ninguno de estos aplica\" y haga clic en \"Guardar y continuar\".\nEste programa ofrece un seguro de salud de bajo costo para ni\u00F1os y personas embarazadas que ganan demasiado para calificar para Health First Colorado. Si decide adquirir un plan de seguro de salud a trav\u00E9s de Connect for Health Colorado, no podr\u00E1 mantener su seguro CHP+.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Medicare":
                helpCircleButton.get(2).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Medicare");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Es el programa nacional de seguro de salud para las personas de 65 a\u00F1os o m\u00E1s o que tienen una discapacidad seg\u00FAn lo determina la Administraci\u00F3n del Seguro Social.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "ESI":
                helpCircleButton.get(3).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Seguro de salud patrocinado por el empleador");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Es el seguro de salud que se obtiene a trav\u00E9s de un empleo propio o del c\u00F3nyuge. Si est\u00E1 actualmente en un per\u00EDodo de espera para que comience el seguro de salud de patrocinado por su empleador (es decir, que su empleador le ofrece cobertura para usted o su dependiente, pero la cobertura tomar\u00E1 efecto despu\u00E9s), puede ser elegible para obtener un Cr\u00E9dito fiscal para el pago de la cuota durante ese per\u00EDodo. Si actualmente est\u00E1 en un per\u00EDodo de espera, no debe marcar la casilla aqu\u00ED. Por el contrario, debe regresar justo antes de que el per\u00EDodo de espera finalice para reportar su pr\u00F3xima inscripci\u00F3n en el seguro patrocinado por su empleador. Para evitar doble cobertura y cargos mensuales de las cuotas de ambos planes, debe reportar el cambio del seguro patrocinado por su empleador en su cuenta de Connect for Health Colorado lo m\u00E1s pronto posible, preferentemente, el mes antes de que comience su cobertura.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "HRA":
                helpCircleButton.get(4).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Una cuenta de reembolso de gastos m\u00E9dicos (HRA en ingl\u00E9s) ofrecido a trav\u00E9s de un empleador");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Seleccione esta opci\u00F3n si sus empleador le ofrece una Cuenta de reembolso de gastos m\u00E9dicos (HRA) para ayudarle a pagar su seguro de salud, incluso si no se inscribe en uno. La opci\u00F3n HRA que le ofrece su empleador puede ser llamada HRA de Peque\u00F1o empleador calificado (QSEHRA) o HRA de Cobertura individual (ICHRA).");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Retiree":
                helpCircleButton.get(5).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Plan de salud de jubilado");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Esta es la opci\u00F3n de seguro de salud para las personas que se han retirado en su trabajo.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Peace Corps":
                helpCircleButton.get(6).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Cuerpos de paz (Peace Corps)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Este es un programa de seguro de salud para antiguos voluntarios del Cuerpo de Paz.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "COBRA":
                helpCircleButton.get(7).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "COBRA");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Esta es la opci\u00F3n de seguro de salud para personas que han dejado su empleo con seguro de salud patrocinado por el empleador.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "VA Health Care":
                helpCircleButton.get(8).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Servicios de Salud para Veteranos (VA)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Este es el programa nacional de seguro de salud para veteranos del ej\u00E9rcito aprobados.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "TRICARE":
                helpCircleButton.get(9).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "TRICARE");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Este es un programa de servicios m\u00E9dicos del Sistema de Salud Militar del Departamento de Defensa de Estados Unidos.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            case "Individual":
                helpCircleButton.get(10).click();
                softAssert.assertEquals(helpDrawerHelpHeaders.get(0).getText(), "Seguro individual (fuera del Mercado)");
                verifyHelpDrawerHeadersFormat(helpDrawerHelpHeaders.get(0));
                softAssert.assertEquals(helpDrawerBody.get(0).getText(), "Este es el seguro de salud privado que tiene usted actualmente y que no obtuvo por medio de Connect for Health Colorado o su trabajo.");
                verifyHelpDrawerParagraphsFormat(helpDrawerBody.get(0));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insurance);
        }
    }

    //helpCircleButton
    public void verifyHelpDrawerTextForQuestions(String language, String insurance) {
        basicActions.waitForElementListToBePresent(helpCircleButton, 20);

        switch (language) {
            case "English":
                verifyHelpTextForQuestions_English(insurance);
                break;
            case "Spanish":
                verifyHelpTextForQuestions_Spanish(insurance);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyMainOHCCheckboxes(String state){
        switch (state){
            case "Selected":
                verifySelectedStateOfCheckboxes();
                break;
            case "Hover":
                verifyHoverStateOfCheckboxes();
                break;
            case "Focus":
                verifyFocusStateOfCheckboxes();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfCheckboxes();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresentWithRetries(insuranceOptionsCheckBox, 30);
        basicActions.waitForElementListToBePresentWithRetries(insuranceOptionsBox, 30);
        for (int i = 0; i < insuranceOptionsCheckBox.size(); i++) {
            WebElement element1 = insuranceOptionsCheckBox.get(i);
            WebElement element2 = insuranceOptionsBox.get(i);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(55, 55, 55)");
            softAssert.assertAll();
        }
    }

    public void verifyFocusStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox, 15);
        for (int i = 0; i < insuranceOptionsCheckBox.size(); i++) {
            WebElement element = insuranceOptionsCheckBox.get(i);
            element.sendKeys(Keys.SHIFT);
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element.getCssValue("box-shadow"), "rgb(112, 163, 0) 0px 0px 7px 3px");
            softAssert.assertAll();
            existingHealthInsuranceHeader.click();
        }
    }

    public void verifyHoverStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox, 15);
        for (int i = 0; i < insuranceOptionsCheckBox.size(); i++) {
            WebElement element = insuranceOptionsCheckBox.get(i);
            actions.moveToElement(element).perform();
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertAll();
            existingHealthInsuranceHeader.click();
        }
    }

    public void verifySelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox, 15);
        for (int i = 0; i < insuranceOptionsCheckBox.size(); i++) {
            WebElement element1 = insuranceOptionsCheckBox.get(i);
            WebElement element2 = insuranceOptionsBox.get(i);
            element1.click();
            existingHealthInsuranceHeader.click();
            basicActions.wait(300);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container checked"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(112, 163, 0, 1)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(112, 163, 0)");
            softAssert.assertAll();
            element1.click();
            existingHealthInsuranceHeader.click();
        }
    }
    public void verifyInsuranceOptions(DataTable insuranceOptionsTable) {
        List<String> insuranceOptions = insuranceOptionsTable.asList();
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresentWithRetries(existingHealthInsuranceHeader, 15);

        for (WebElement checkbox : insuranceOptionsCheckBox) {
            String checkboxLabel = checkbox.getAttribute("value").trim();

            if (insuranceOptions.contains(checkboxLabel)) {
                if (!checkbox.isSelected()) {
                    basicActions.clickElementWithRetries(checkbox, 10);
                }
                softAssert.assertTrue(checkbox.isSelected(), "Checkbox not selected for: " + checkboxLabel);
            }
        }
        softAssert.assertAll();
    }

    public void validateFontColorSizeWhenNoJob(){
        verifyColorSizeBorderForHeaderInESPage();
        softAssert.assertEquals(label_whichJobIsOffering.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(label_whichJobIsOffering.getCssValue("font-weight"), "400","Font weight not matching");
        softAssert.assertEquals(label_whichJobIsOffering.getCssValue("color"), "rgba(149, 147, 147, 1)", "Color mismatch");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("background-color"), "rgba(252, 252, 252, 1)", "Back ground Color mismatch");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("color"), "rgba(149, 147, 147, 1)", "Color mismatch");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("border"), "2px solid rgb(149, 147, 147)","border mismatch");
        verifyColorSizeFormatOfGoBackBtnInESPage();
        softAssert.assertAll();
    }
    private void verifyColorSizeFormatOfGoBackBtnInESPage(){
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("font-size"), "20px", "Font size mismatch");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("font-weight"), "700","Font weight not matching");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("color"), "rgba(26, 112, 179, 1)", "Color mismatch");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("background-color"), "rgba(252, 252, 252, 1)", "Back ground Color mismatch");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("border-top-left-radius"), "4px", "Border radios mismatch");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("border-top-style"), "solid", "Border style mismatch");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("border-top-width"), "2px", "Border width mismatch");
        softAssert.assertEquals(goBackBtnEmpSponOutline.getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("padding-bottom"), "12px", "Padding bottom mismatch");
        softAssert.assertEquals(goBackBtnEmpSpon.getCssValue("padding-right"), "20px", "Padding right mismatch");
        softAssert.assertAll();
    }
    private void verifyColorSizeBorderForHeaderInESPage(){
        basicActions.wait(1000);
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-size"), "36px", "Font size mismatch");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-weight"), "700","Font weight not matching");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatch");
        softAssert.assertEquals(labelEmpSponHealthInsurance.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(labelEmpSponHealthInsurance.getCssValue("font-size"), "28px", "Font size mismatch");
        softAssert.assertEquals(labelEmpSponHealthInsurance.getCssValue("font-weight"), "700","Font weight not matching");
        softAssert.assertEquals(labelEmpSponHealthInsurance.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatch");
        softAssert.assertEquals(helpLink.getCssValue("font-size"), "18px", "Font size mismatch");
        softAssert.assertEquals(helpLink.getCssValue("font-weight"), "700","Font weight not matching");
        softAssert.assertEquals(helpLink.getCssValue("text-decoration-line"), "underline","Text decoration Line not matching");
        softAssert.assertAll();
    }
    public void validatePageTextESPage(List<String> pageTexts){
        String signature=SharedData.getPrimaryMember().getSignature();
        softAssert.assertEquals(existingHealthInsuranceHeader.getText(),pageTexts.get(0)+" "+signature,"Member name not matching");
        softAssert.assertEquals(labelEmpSponHealthInsurance.getText(),pageTexts.get(1),"Employer-sponsored text not matching");
        softAssert.assertEquals(helpLink.getText(),pageTexts.get(2),"Help Link text not matching");
        softAssert.assertEquals(label_whichJobIsOffering.getText(),pageTexts.get(3),"Which job offer text not matching");
        softAssert.assertEquals(dropDownAllOptions.get(0).getText().trim(),pageTexts.get(4),"No Jobs Found text not matching");
        softAssert.assertTrue((dropDownAllOptions.get(0).getAttribute("value").contains("0")),"List item is not zero");
        softAssert.assertEquals(goBackBtnEmpSpon.getText().trim(),pageTexts.get(5),"Go back text not matching");
        softAssert.assertAll();
    }
    public void clickOnGoBackBtnESPage(){
        basicActions.waitForElementToBePresent(goBackBtnEmpSpon,10);
        goBackBtnEmpSpon.click();
    }
    public void validateFontColorSizeTextWhenOneJobAdded() {
        softAssert = new SoftAssert();
        verifyColorSizeBorderForHeaderInESPage();
        softAssert.assertEquals(label_whichJobIsOffering.getCssValue("font-size"), "16px", "Font size mismatch when no jobs found");
        softAssert.assertEquals(label_whichJobIsOffering.getCssValue("font-weight"), "400", "Font weight not matching when no jobs found");
        softAssert.assertEquals(label_whichJobIsOffering.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatching");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Back ground Color mismatching");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch when no jobs found");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("border"), "1px solid rgb(149, 147, 147)", "border mismatch when no jobs found");
        verifyColorSizeFormatOfGoBackBtnInESPage();
        //When one job added
        softAssert.assertEquals(dropDownAllOptions.get(0).getText().trim(), "Select an employer", "Select an employer text not matching");
        softAssert.assertTrue((dropDownAllOptions.get(1).getAttribute("value").contains("1")), "List item is not zero");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Back ground Color mismatch");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("border"), "1px solid rgb(149, 147, 147)", "border mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("background-color"), "rgba(22, 156, 216, 1)", "Back ground Color mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("font-size"), "20px", "Font size mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("border-top-left-radius"), "4px", "Border radios mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("padding-bottom"), "12px", "Padding bottom not matching");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("padding-right"), "20px", "Pading right not matching");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("color"), "rgba(252, 252, 252, 1)", "Color mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("border"), "2px solid rgb(252, 252, 252)", "border mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getText().trim(), "Save and continue", "Save And Continue text mismatch");
        softAssert.assertAll();
    }
    public void selectFirstOptInWhichJobIsOfferingDropdown(){
        String text=dropDownAllOptions.get(1).getText();
        basicActions.selectValueFromDropdown(dropDownUnderWhichJobIs,dropDownAllOptions,text);
    }
    public void validateColorFontSizeWhenOptionIsSelected(){
        verifyColorSizeBorderForHeaderInESPage();
        verifyColorSizeWhenOneOptionSelected();
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("border"), "1px solid rgb(134, 183, 254)", "dropDownUnderWhichJobIs-border mismatch");
        softAssert.assertFalse(btnYesAreYouCurrentlyEnrolled.getAttribute("class").contains("selected"),"Yes is selected");
        softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnYesAreYouCurrentlyEnrolled-Back ground Color mismatch");
        softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("color"), "rgba(77, 77, 79, 1)", "btnYesAreYouCurrentlyEnrolled-Color mismatch");
        softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("border"), "1px solid rgb(149, 147, 147)", "btnYesAreYouCurrentlyEnrolled-border mismatch");
        verifyColorSizeFormatOfGoBackBtnInESPage();
        verifyColorSizeFormatOfSaveContinueBtnInESPage();
        softAssert.assertAll();
    }
    private void verifyColorSizeFormatOfSaveContinueBtnInESPage(){
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("font-size"), "20px", "Font size mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("border-top-left-radius"), "4px", "Border radios mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("padding-bottom"), "12px", "Padding bottom not matching");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("padding-right"), "20px", "Pading right not matching");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("color"), "rgba(252, 252, 252, 1)", "Color mismatch");
        softAssert.assertEquals(saveAndContBtnEmpSpon.getCssValue("border"), "2px solid rgb(26, 112, 179)", "border mismatch");
        softAssert.assertAll();
    }
    private void verifyColorSizeWhenOneOptionSelected(){
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Back ground Color mismatch");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch");
        softAssert.assertEquals(dropDownUnderWhichJobIs.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(labelDoesThisHealthInsurance.getCssValue("color"), "rgba(43, 49, 60, 1)", "Does this-Color mismatch");
        softAssert.assertEquals(labelDoesThisHealthInsurance.getCssValue("font-weight"), "400", "Does this-font weight mismatch");
        softAssert.assertEquals(labelDoesThisHealthInsurance.getCssValue("font-size"), "16px", "Does this-Font size mismatch");
        softAssert.assertFalse(btnYesDoesThisHealthInsurance.getAttribute("class").contains("selected"),"Yes button is selected");
        softAssert.assertEquals(btnYesDoesThisHealthInsurance.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Does this-Yes btn-Back ground Color mismatch");
        softAssert.assertEquals(btnYesDoesThisHealthInsurance.getCssValue("color"), "rgba(77, 77, 79, 1)", "Does this-Yes btn-Color mismatch");
        softAssert.assertEquals(btnYesDoesThisHealthInsurance.getCssValue("font-size"), "16px", "Does this-Yes btn-Font size mismatch");
        softAssert.assertEquals(btnYesDoesThisHealthInsurance.getCssValue("border"), "1px solid rgb(149, 147, 147)", "Does this-Yes btn-border mismatch");
        softAssert.assertEquals(btnYesDoesThisHealthInsurance.getCssValue("border-top-left-radius"), "4px", "Does this-Yes btn-Border radios mismatch");
        softAssert.assertFalse(btnNoDoesThisHealthInsurance.getAttribute("class").contains("selected"),"No button is selected");
        softAssert.assertEquals(btnNoDoesThisHealthInsurance.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Does this-No btn-Back ground Color mismatch");
        softAssert.assertEquals(btnNoDoesThisHealthInsurance.getCssValue("color"), "rgba(77, 77, 79, 1)", "Does this-No btn-Color mismatch");
        softAssert.assertEquals(btnNoDoesThisHealthInsurance.getCssValue("font-size"), "16px", "Does this-No btn-Font size mismatch");
        softAssert.assertEquals(btnNoDoesThisHealthInsurance.getCssValue("border"), "1px solid rgb(149, 147, 147)", "Does this-No btn-border mismatch");
        softAssert.assertEquals(btnNoDoesThisHealthInsurance.getCssValue("border-top-left-radius"), "4px", "Does this-No btn-Border radios mismatch");
        softAssert.assertFalse(btnIDontNoDoesThisHealthInsurance.getAttribute("class").contains("selected"),"I dont Know button is selected");
        softAssert.assertEquals(btnIDontNoDoesThisHealthInsurance.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Does this-IDN btn-Back ground Color mismatch");
        softAssert.assertEquals(btnIDontNoDoesThisHealthInsurance.getCssValue("color"), "rgba(77, 77, 79, 1)", "Does this-IDN btn-Color mismatch");
        softAssert.assertEquals(btnIDontNoDoesThisHealthInsurance.getCssValue("font-size"), "16px", "Does this-IDN btn-Font size mismatch");
        softAssert.assertEquals(btnIDontNoDoesThisHealthInsurance.getCssValue("border"), "1px solid rgb(149, 147, 147)", "Does this-IDN btn-border mismatch");
        softAssert.assertEquals(btnIDontNoDoesThisHealthInsurance.getCssValue("border-top-left-radius"), "4px", "Does this-IDN btn-Border radios mismatch");
        softAssert.assertEquals(labelHowMuchWouldYou.getCssValue("color"), "rgba(43, 49, 60, 1)", "How much would-Color mismatch");
        softAssert.assertEquals(labelHowMuchWouldYou.getCssValue("font-weight"), "400", "How much would-font weight mismatch");
        softAssert.assertEquals(labelHowMuchWouldYou.getCssValue("font-size"), "16px", "How much would-Font size mismatch");
        softAssert.assertEquals(txtBoxMonthlyAmount.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Monthly Amount-Back ground Color mismatch");
        softAssert.assertEquals(txtBoxMonthlyAmount.getCssValue("color"), "rgba(77, 77, 79, 1)", "Monthly Amount- btn-Color mismatch");
        softAssert.assertEquals(txtBoxMonthlyAmount.getCssValue("font-size"), "16px", "Monthly Amount-Font size mismatch");
        softAssert.assertEquals(txtBoxMonthlyAmount.getCssValue("border"), "1px solid rgb(149, 147, 147)", "Monthly Amount-border mismatch");
        softAssert.assertEquals(labelAreYouCurrentlyEnrolled.getCssValue("color"), "rgba(43, 49, 60, 1)", "AreYouCurrentlyEnrolled-Color mismatch");
        softAssert.assertEquals(labelAreYouCurrentlyEnrolled.getCssValue("font-weight"), "400", "AreYouCurrentlyEnrolled-font weight mismatch");
        softAssert.assertEquals(labelAreYouCurrentlyEnrolled.getCssValue("font-size"), "16px", "AreYouCurrentlyEnrolled-Font size mismatch");
        softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("font-size"), "16px", "btnYesAreYouCurrentlyEnrolled-Font size mismatch");
        softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("border-top-left-radius"), "4px", "btnYesAreYouCurrentlyEnrolled-Border radios mismatch");
        softAssert.assertFalse(btnNoAreYouCurrentlyEnrolled.getAttribute("class").contains("selected"),"No is selected");
        softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnNoAreYouCurrentlyEnrolled-Back ground Color mismatch");
        softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("color"), "rgba(77, 77, 79, 1)", "btnNoAreYouCurrentlyEnrolled-Color mismatch");
        softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("font-size"), "16px", "btnNoAreYouCurrentlyEnrolled-Font size mismatch");
        softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("border"), "1px solid rgb(149, 147, 147)", "btnNoAreYouCurrentlyEnrolled-border mismatch");
        softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("border-top-left-radius"), "4px", "btNoAreYouCurrentlyEnrolled-Border radios mismatch");
        softAssert.assertAll();
    }
    public void clickOnAreYouCurrentlyEnrolledQstn(String btnName){
        switch (btnName){
            case "Yes":
                basicActions.waitForElementToBePresent(btnYesAreYouCurrentlyEnrolled,10);
                btnYesAreYouCurrentlyEnrolled.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(btnNoAreYouCurrentlyEnrolled,10);
                btnNoAreYouCurrentlyEnrolled.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + btnName);
        }
    }
    public void validateColorFontSizeBorderWhenAreYouCurrentlyEnrolled(String btnName){
        verifyColorSizeBorderForHeaderInESPage();
        switch (btnName){
            case "Yes":
                verifyColorSizeWhenOneOptionSelected();
                softAssert.assertTrue(btnYesAreYouCurrentlyEnrolled.getAttribute("class").contains("selected"), "Yes is not selected");
                softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("background-color"), "rgba(112, 163, 0, 1)", "btnYesAreYouCurrentlyEnrolled-Back ground Color mismatch");
                softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("color"), "rgba(255, 255, 255, 1)", "btnYesAreYouCurrentlyEnrolled-Color mismatch");
                softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("border"), "1px solid rgb(112, 163, 0)", "btnYesAreYouCurrentlyEnrolled-border mismatch");
                softAssert.assertFalse(btnYesWillThisHealthInsurance.getAttribute("class").contains("selected"), "Will This Health Btn_Yes is selected");
                softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnYesWillThisHealthInsurance-Back ground Color mismatch");
                softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("color"), "rgba(77, 77, 79, 1)", "btnYesWillThisHealthInsurance-Color mismatch");
                softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("font-size"), "16px", "btnYesWillThisHealthInsurance-Font size mismatch");
                softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("border"), "1px solid rgb(149, 147, 147)", "btnYesWillThisHealthInsurance-border mismatch");
                softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("border-top-left-radius"), "4px", "btnYesWillThisHealthInsurance-Border radios mismatch");
                verifyColorFontSizeAreYouCurrentlyEnrolledYes();
                verifyColorSizeFormatOfGoBackBtnInESPage();
                verifyColorSizeFormatOfSaveContinueBtnInESPage();
                softAssert.assertAll();
                break;
            case "No":
                softAssert.assertTrue(btnNoAreYouCurrentlyEnrolled.getAttribute("class").contains("selected"), "No is not selected");
                softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("background-color"), "rgba(112, 163, 0, 1)", "btnNoAreYouCurrentlyEnrolled-Back ground Color mismatch");
                softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("color"), "rgba(255, 255, 255, 1)", "btnNoAreYouCurrentlyEnrolled-Color mismatch");
                softAssert.assertEquals(btnNoAreYouCurrentlyEnrolled.getCssValue("border"), "1px solid rgb(112, 163, 0)", "btnNoAreYouCurrentlyEnrolled-border mismatch");
                softAssert.assertFalse(btnYesAreYouCurrentlyEnrolled.getAttribute("class").contains("selected"), "Yes is selected");
                softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnYesAreYouCurrentlyEnrolled-Back ground Color mismatch");
                softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("color"), "rgba(77, 77, 79, 1)", "btnYesAreYouCurrentlyEnrolled-Color mismatch");
                softAssert.assertEquals(btnYesAreYouCurrentlyEnrolled.getCssValue("border"), "1px solid rgb(149, 147, 147)", "btnYesAreYouCurrentlyEnrolled-border mismatch");
                verifyColorSizeFormatOfGoBackBtnInESPage();
                verifyColorSizeFormatOfSaveContinueBtnInESPage();
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + btnName);
        }
    }
    private void verifyColorFontSizeAreYouCurrentlyEnrolledYes(){
        softAssert.assertEquals(labelWillThisHealthInsurance.getCssValue("color"), "rgba(43, 49, 60, 1)", "labelWillThisHealthInsurance-Color mismatch");
        softAssert.assertEquals(labelWillThisHealthInsurance.getCssValue("font-weight"), "400", "labelWillThisHealthInsurance-font weight mismatch");
        softAssert.assertEquals(labelWillThisHealthInsurance.getCssValue("font-size"), "16px", "labelWillThisHealthInsurance-Font size mismatch");
        softAssert.assertFalse(btnNoWillThisHealthInsurance.getAttribute("class").contains("selected"), "Will This_No is selected");
        softAssert.assertEquals(btnNoWillThisHealthInsurance.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnNoWillThisHealthInsurance-Back ground Color mismatch");
        softAssert.assertEquals(btnNoWillThisHealthInsurance.getCssValue("color"), "rgba(77, 77, 79, 1)", "btnNoWillThisHealthInsurance-Color mismatch");
        softAssert.assertEquals(btnNoWillThisHealthInsurance.getCssValue("font-size"), "16px", "btnNoWillThisHealthInsurance-Font size mismatch");
        softAssert.assertEquals(btnNoWillThisHealthInsurance.getCssValue("border"), "1px solid rgb(149, 147, 147)", "btnNoWillThisHealthInsurance-border mismatch");
        softAssert.assertEquals(btnNoWillThisHealthInsurance.getCssValue("border-top-left-radius"), "4px", "btnNoWillThisHealthInsurance-Border radios mismatch");
        softAssert.assertAll();
    }
    public void clickOnWillThisHealthInsuranceEndQuestion(String btnName){
        switch (btnName){
            case "Yes":
                basicActions.waitForElementToBePresent(btnYesWillThisHealthInsurance,10);
                btnYesWillThisHealthInsurance.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(btnNoWillThisHealthInsurance,10);
                btnNoWillThisHealthInsurance.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + btnName);
        }
    }
    public void validateColorFontSizeBorderWhenWillThisHealthInsurance(){
        verifyColorSizeBorderForHeaderInESPage();
        verifyColorSizeWhenOneOptionSelected();
        verifyColorFontSizeAreYouCurrentlyEnrolledYes();
        softAssert.assertTrue(btnYesWillThisHealthInsurance.getAttribute("class").contains("selected"), "Will This Health Btn_Yes is not selected");
        softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("background-color"), "rgba(112, 163, 0, 1)", "btnYesSelectedWillThisHealthInsurance-Back ground Color mismatch");
        softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("color"), "rgba(255, 255, 255, 1)", "btnYesSelectedWillThisHealthInsurance-Color mismatch");
        softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("font-size"), "16px", "btnYesWillThisHealthInsurance-Font size mismatch");
        softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("border"), "1px solid rgb(112, 163, 0)", "btnYesSelectedWillThisHealthInsurance-border mismatch");
        softAssert.assertEquals(btnYesWillThisHealthInsurance.getCssValue("border-top-left-radius"), "4px", "btnYesWillThisHealthInsurance-Border radios mismatch");
        softAssert.assertEquals(labelWhatDayWillYour.getCssValue("color"), "rgba(43, 49, 60, 1)", "labelWhatDayWillYour-Color mismatch");
        softAssert.assertEquals(labelWhatDayWillYour.getCssValue("font-weight"), "400", "labelWhatDayWillYour-font weight mismatch");
        softAssert.assertEquals(labelWhatDayWillYour.getCssValue("font-size"), "16px", "labelWhatDayWillYour-Font size mismatch");
        softAssert.assertEquals(labelAreYouVoluntarily.getCssValue("color"), "rgba(43, 49, 60, 1)", "labelAreYouVoluntarily-Color mismatch");
        softAssert.assertEquals(labelAreYouVoluntarily.getCssValue("font-weight"), "400", "labelAreYouVoluntarily-font weight mismatch");
        softAssert.assertEquals(labelAreYouVoluntarily.getCssValue("font-size"), "16px", "labelAreYouVoluntarily-Font size mismatch");
        softAssert.assertEquals(txtBoxCalender.getCssValue("color"), "rgba(77, 77, 79, 1)", "txtBoxCalender-Color mismatch");
        softAssert.assertEquals(txtBoxCalender.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "txtBoxCalender-back ground color mismatch");
        softAssert.assertEquals(txtBoxCalender.getCssValue("font-size"), "16px", "txtBoxCalender-Font size mismatch");
        softAssert.assertEquals(txtBoxCalender.getCssValue("border"), "1px solid rgb(149, 147, 147)", "txtBoxCalender-border mismatch");
        softAssert.assertFalse(btnYesAreYouVoluntarily.getAttribute("class").contains("selected"), "btnYesAreYouVoluntarily_Yes is selected");
        softAssert.assertEquals(btnYesAreYouVoluntarily.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnYesAreYouVoluntarily-Back ground Color mismatch");
        softAssert.assertEquals(btnYesAreYouVoluntarily.getCssValue("color"), "rgba(77, 77, 79, 1)", "btnYesAreYouVoluntarily-Color mismatch");
        softAssert.assertEquals(btnYesAreYouVoluntarily.getCssValue("font-size"), "16px", "btnYesAreYouVoluntarily-Font size mismatch");
        softAssert.assertEquals(btnYesAreYouVoluntarily.getCssValue("border"), "1px solid rgb(149, 147, 147)", "btnYesAreYouVoluntarily-border mismatch");
        softAssert.assertEquals(btnYesAreYouVoluntarily.getCssValue("border-top-left-radius"), "4px", "btnYesAreYouVoluntarily-Border radios mismatch");
        softAssert.assertFalse(btnNoAreYouVoluntarily.getAttribute("class").contains("selected"), "btnNoAreYouVoluntarily_Yes is selected");
        softAssert.assertEquals(btnNoAreYouVoluntarily.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnNoAreYouVoluntarily-Back ground Color mismatch");
        softAssert.assertEquals(btnNoAreYouVoluntarily.getCssValue("color"), "rgba(77, 77, 79, 1)", "btnNoAreYouVoluntarily-Color mismatch");
        softAssert.assertEquals(btnNoAreYouVoluntarily.getCssValue("font-size"), "16px", "btnNoAreYouVoluntarily-Font size mismatch");
        softAssert.assertEquals(btnNoAreYouVoluntarily.getCssValue("border"), "1px solid rgb(149, 147, 147)", "btnNoAreYouVoluntarily-border mismatch");
        softAssert.assertEquals(btnNoAreYouVoluntarily.getCssValue("border-top-left-radius"), "4px", "btnNoAreYouVoluntarily-Border radios mismatch");
        verifyColorSizeFormatOfGoBackBtnInESPage();
        verifyColorSizeFormatOfSaveContinueBtnInESPage();
        softAssert.assertAll();
    }
}
