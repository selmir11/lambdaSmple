package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static java.awt.SystemColor.window;

public class OhcHraPage_Elmo {
    BasicActions basicActions;
    Actions action;
    SoftAssert softAssert = new SoftAssert();
    public OhcHraPage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        action = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    @FindBy(css = ".container .header-1")
    WebElement ohcHeader;

    @FindBy(css = ".container .header-2")
    WebElement ohcHraHeader;

    @FindBy(css = ".header-3 .clickable")
    WebElement helpMeLink;

    @FindBy(css = "div.ohc-container.body-text-1 > p > span")
    WebElement whenYouPayTxt;

    @FindBy(css = "div > label")
    List<WebElement> hraQuestionTxt;

    @FindBy(css = "#ELIG-Ohc-Hra-planYear-container span")
    WebElement planYearError;

    @FindBy(css = "#ELIG-Ohc-Hra-planYear")
    WebElement planYeardpd;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContribution-container span")
    WebElement amountError;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContribution")
    WebElement amountInput;

    @FindBy(css = "#ELIG-Ohc-Hra-hraType-container div > span")
    WebElement typeError;

    @FindBy(id = "ELIG-Ohc-Hra-hraType-Hra.QSEHRAButton")
    WebElement hraQsehraBtn;

    @FindBy(id = "ELIG-Ohc-Hra-hraType-Hra.ICHRAButton")
    WebElement hraIchraBtn;

    @FindBy(css = "div.ohc-container > div > p")
    WebElement ifMayTxt;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContributionOptout-container div > span")
    WebElement optOutError;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContributionOptout-container div button")
    List<WebElement> optOutBtn;

    @FindBy(css = "#Ohc-Hra-GoBack")
    WebElement goBackBtn;

    @FindBy(css = "#Ohc-Hra-SaveAndContinue")
    WebElement saveAndContinueBtn;



    public void clickSaveAndContinue(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        basicActions.waitForElementToBePresent(ohcHraHeader,15);
        basicActions.waitForElementToBePresent(whenYouPayTxt,15);
        basicActions.waitForElementToBePresent(planYeardpd,15);
        basicActions.waitForElementToBePresent(amountInput,15);
        basicActions.waitForElementToBePresent(hraQsehraBtn,15);
        basicActions.waitForElementToBePresent(hraIchraBtn,15);
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 50);
        saveAndContinueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBeClickable(goBackBtn, 20);
        goBackBtn.click();
    }

    public void clickYear(){
        basicActions.waitForElementToBePresent(planYeardpd,20);
        planYeardpd.sendKeys("2024");
    }

    public void enterAmount(String amount){
        basicActions.waitForElementToBePresent(amountInput,20);
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        amountInput.sendKeys(amount);
    }

    public void selectHraType(String type){
        basicActions.waitForElementToBePresent(hraQsehraBtn,20);
        switch (type){
            case "ICHRA":
                hraIchraBtn.click();
                break;
            case "QSEHRA":
                hraQsehraBtn.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
    }

    public void selectOptOut(String aptc){
        basicActions.waitForElementListToBePresent(optOutBtn,20);
        switch (aptc){
            case "Yes":
                optOutBtn.get(0).click();
                break;
            case "No":
                optOutBtn.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + aptc);
        }
    }
















    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    public void verifyHeadersHraOhcPageEnglish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertAll();
    }

    public void verifyHraPageData(String dataToVerify, String expectedIncome, String language) {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        switch (language) {
            case "English":
                verifyHraPageDataEnglish(dataToVerify, expectedIncome);
                break;
            case "Spanish":
//                verifHraPageDataSpanish(dataToVerify);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHraPageDataEnglish(String dataToVerify, String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        switch (dataToVerify){
            case "Initial Page":
                verifyHraPageInitialDataEnglish(expectedIncome);
                break;
            case "Opt Out":
                verifyHraPageInitialDataEnglish(expectedIncome);
                verifyHraPageOptOutDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackBtn.getText(),"  Go Back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and Continue");
        softAssert.assertAll();
    }

    public void verifyHraPageInitialDataEnglish(String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertEquals(whenYouPayTxt.getText(), "When you pay for your health insurance using a Health Reimbursement Arrangement (HRA) provided through your employer, you may be required to buy a plan outside of Connect for Health Colorado. Confirm with your employer whether you have a salary reduction arrangement, as it could affect your ability to sign up for a plan through our Marketplace.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(),"Select the plan year for your HRA coverage.");
        softAssert.assertEquals(planYeardpd.getText(),"Select a year\n2024");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(),"Enter the amount your employer contributes each month to an HRA for your coverage.");
        softAssert.assertEquals(amountInput.getText(),expectedIncome);
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(),"What type of HRA is your employer offering?");
        softAssert.assertEquals(hraQsehraBtn.getText(),"Qualified Small Employer Health Reimbursement Arrangement (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(),"Individual Coverage Health Reimbursement Arrangement (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutDataEnglish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertEquals(ifMayTxt.getText(),"It may be less expensive to pay for your coverage with the Advanced Premium Tax Credit you could receive through Connect for Health Colorado. This would replace your employer's contribution.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(),"If receiving Advance Premium Tax Credit is a more affordable option, would you choose to opt out from receiving an employer contribution?");
        softAssert.assertEquals(optOutBtn.get(0).getText(),"Yes");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEnrolledOption(String year, String amount, String type, String withOrWithout, String aptc){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        basicActions.waitForElementToBePresent(ohcHraHeader,15);
        basicActions.waitForElementToBePresent(whenYouPayTxt,15);
        basicActions.waitForElementToBePresent(planYeardpd,15);
        basicActions.waitForElementToBePresent(amountInput,15);
        basicActions.waitForElementToBePresent(hraQsehraBtn,15);
        basicActions.waitForElementToBePresent(hraIchraBtn,15);
        switch (year){
            case "Current Year":
                basicActions.waitForElementToBePresent(planYeardpd,15);
                softAssert.assertEquals(planYeardpd.getAttribute("class"), "form-select ng-untouched ng-pristine ng-valid");
                softAssert.assertEquals(planYeardpd.getAttribute("value"),"1: 2024");
                softAssert.assertAll();
                break;
            case "Not Selected":
                basicActions.waitForElementToBePresent(planYeardpd,15);
                softAssert.assertEquals(planYeardpd.getAttribute("class"),"form-select ng-untouched ng-pristine ng-invalid");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + year);
        }
        if (!amount.equals("Not Selected")) {
            softAssert.assertEquals(amountInput.getAttribute("value"), amount);
            softAssert.assertAll();
        } else if (amount.equals("Not Selected")) {
            softAssert.assertEquals(amountInput.getAttribute("class"), "form-control monetary-input ng-untouched ng-pristine ng-invalid");
            softAssert.assertAll();
        }
        switch (type){
            case "ICHRA":
                basicActions.waitForElementToBePresent(hraIchraBtn,15);
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button option-button-selected ng-star-inserted");
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertAll();
                break;
            case "QSEHRA":
                basicActions.waitForElementToBePresent(hraQsehraBtn,15);
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button option-button-selected ng-star-inserted");
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertAll();
                break;
            case "QSEHRA no Continue":
                basicActions.waitForElementToBePresent(hraQsehraBtn,15);
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button ng-star-inserted option-button-selected");
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button ng-star-inserted option-button");
                softAssert.assertAll();
                break;
            case "Not Selected":
                basicActions.waitForElementToBePresent(hraQsehraBtn,15);
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
        switch (withOrWithout){
            case"With":
                switch (aptc){
                    case "Yes":
                        basicActions.waitForElementListToBePresent(optOutBtn,15);
                        softAssert.assertEquals(optOutBtn.get(0).getAttribute("class"),"button option-button-selected ng-star-inserted");
                        softAssert.assertEquals(optOutBtn.get(1).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertAll();
                        break;
                    case "No":
                        basicActions.waitForElementListToBePresent(optOutBtn,15);
                        softAssert.assertEquals(optOutBtn.get(1).getAttribute("class"),"button option-button-selected ng-star-inserted");
                        softAssert.assertEquals(optOutBtn.get(0).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertAll();
                        break;
                    case "Not Selected":
                        basicActions.waitForElementListToBePresent(optOutBtn,15);
                        softAssert.assertEquals(optOutBtn.get(0).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertEquals(optOutBtn.get(1).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertAll();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + aptc);
                }
                break;
            case"Without":
                if (optOutBtn.size() >= 1) {
                    Assert.assertFalse(basicActions.waitForElementToBePresent(optOutBtn.get(0), 30), "First optOutBtn should not be visible");
                    Assert.assertFalse(basicActions.waitForElementToBePresent(optOutBtn.get(1), 30), "Second optOutBtn should not be visible");
                }
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + withOrWithout);
        }
    }






}
