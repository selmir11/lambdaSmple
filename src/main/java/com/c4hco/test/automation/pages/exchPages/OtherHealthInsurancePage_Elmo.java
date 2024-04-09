package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;



public class OtherHealthInsurancePage_Elmo {
    BasicActions basicActions;
    Actions action;
    SoftAssert softAssert = new SoftAssert();
    public OtherHealthInsurancePage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        action = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement existingHealthInsuranceHeader;

    @FindBy(css = ".content-center > span")
    WebElement helpLink;

    @FindBy(css = ".parent-position > div")
    List<WebElement> existingHealthInsurancePageTxt1;

    @FindBy(css = ".parent-position > div > div")
    List<WebElement> existingHealthInsurancePageTxt2;

    @FindBy(css = "label > button")
    List<WebElement> insuranceOptionsCheckBox;

    @FindBy(css = ".container .help-icon")
    List<WebElement> helpCircleButton;

    @FindBy(id = "existingOHI-GoBack")
    WebElement backButton;

    @FindBy(id = "existingOHI-SaveAndContinue")
    WebElement saveAndContinueBtn;
    
    public void verifyTextOnOtherHealthInsurancePage(String language){
        switch(language){
            case "English":
                verifyTextOnOtherHealthInsurancePageEnglish();
                break;
            case "Spanish":
                verifyTextOnOtherHealthInsurancePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnOtherHealthInsurancePageEnglish(){
        basicActions.waitForElementToBePresent(existingHealthInsuranceHeader,15);
        softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(helpLink.getText(), "Help me understand this page");
        softAssert.assertEquals(helpLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(helpLink.getCssValue("font-size"), "18px");
        softAssert.assertEquals(helpLink.getCssValue("font-weight"), "700");
        softAssert.assertEquals(helpLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(), "Are you currently enrolled in or eligible for any of the following types of health insurance?");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getText(), "(Select all that apply)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(), "Insurance through State of Colorado");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getText(), "Health First Colorado (Colorado\u2019s Medicaid Program)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getText(), "Child Health Plan Plus (CHP+)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(), "Insurance through Federal Government");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(), "Medicare");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(), "COBRA");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(), "Insurance through Employer");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(), "Health Insurance offered through a job");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(), "Health Reimbursement Arrangement (HRA)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(), "Retiree Health Plan");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(), "Peace Corp");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(), "Insurance through Military");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(), "VA Health Care");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(), "TRICARE");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(), "Other");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getText(), "Health insurance purchased directly through an insurance company, through Healthcare.gov, or another state\u2019s Marketplace.");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getText(), "None of these");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(backButton.getText(), "  Go Back");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(backButton).pause(1000L).build().perform();
        softAssert.assertEquals(backButton.getText(), "  Go Back");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background"), "rgb(227, 246, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and Continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(26, 112, 179) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and Continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(22, 156, 216) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertAll();
    }

    public void verifyTextOnOtherHealthInsurancePageSpanish(){
        basicActions.waitForElementToBePresent(existingHealthInsuranceHeader,15);
        softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()+" (Spanish)"));
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsuranceHeader.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(helpLink.getText(), "Help me understand this page");
        softAssert.assertEquals(helpLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(helpLink.getCssValue("font-size"), "18px");
        softAssert.assertEquals(helpLink.getCssValue("font-weight"), "700");
        softAssert.assertEquals(helpLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getText(), "Are you currently enrolled in or eligible for any of the following types of health insurance? (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getText(), "(Select all that apply) (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt1.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getText(), "Insurance through State of Colorado (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getText(), "Health First Colorado (Colorado\u2019s Medicaid Program) (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getText(), "Child Health Plan Plus (CHP+) (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(2).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getText(), "Insurance through Federal Government (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(3).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getText(), "Medicare (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(4).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getText(), "COBRA (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(5).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getText(), "Insurance through Employer (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(6).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getText(), "Health Insurance offered through a job (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(7).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getText(), "Health Reimbursement Arrangement (HRA) (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(8).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getText(), "Retiree Health Plan (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(9).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getText(), "Peace Corp (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(10).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getText(), "Insurance through Military (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(11).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getText(), "VA Health Care (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(12).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getText(), "TRICARE (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(13).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getText(), "Other (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("font-weight"), "700");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(14).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getText(), "Health insurance purchased directly through an insurance company, through Healthcare.gov, or another state\u2019s Marketplace. (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(15).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getText(), "None of these (Spanish)");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("font-size"), "16px");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("font-weight"), "400");
        softAssert.assertEquals(existingHealthInsurancePageTxt2.get(17).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(backButton.getText(), "  Volver");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(backButton).pause(1000L).build().perform();
        softAssert.assertEquals(backButton.getText(), "  Volver");
        softAssert.assertEquals(backButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
        softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(backButton.getCssValue("background"), "rgb(227, 246, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(26, 112, 179) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(22, 156, 216) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertAll();
    }
    public void verifyCheckboxesOnOtherHealthInsurancePage(){
        String expectedColor = "rgb(112, 163, 0)";
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox,15);
        softAssert.assertTrue(existingHealthInsuranceHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
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

    public void verifyHelIconsOnOtherHealthInsurancePage(){
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

}
