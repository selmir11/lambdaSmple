package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ApplicationResultsPage {
    SoftAssert softAssert = new SoftAssert();

// TO DO: Update all the below locators
    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;
    @FindBy(css = "#hiddenSubmitButton")
    WebElement continueBtn;
    @FindBy(xpath = "//*[contains(text(),\"Here's what your household qualifies\")]")
    WebElement headerText;
    @FindBy(xpath = "//*[contains(text(),\"you do not qualify for a health plan\")]")
    WebElement youDoNotQualify;
    @FindBy(xpath = "//*[contains(text(),\"Submit a new application if your situation changes\")]")
    WebElement submitNewApplication;
    @FindBy(xpath = "//*[contains(text(),\"basic requirements to buy a health plan\")]")
    WebElement basicRequirements;
    @FindBy(xpath = "//*[@id='infographic-111']/div/span[1]")
    WebElement mustLiveInColorado;
    @FindBy(xpath = "//*[@id='infographic-111']/div/span[2]")
    WebElement mustBeUSCitizen;
    @FindBy(xpath = "//*[@id='infographic-111']/div/span[3]")
    WebElement incarcerated;
    @FindBy(xpath = "//*[@id='infographic-111']/div/span[4]")
    WebElement deceased;
    @FindBy(xpath = "//*[@id='infographic-111']/div/p[2]")
    WebElement resourcesForYou;
    @FindBy(xpath = "//*[contains(text(),\"review your application results and qualifications\")]")
    WebElement callUsToReviewApplication;
    @FindBy(xpath = "//*[contains(text(),\"Find medical care and enrollment assistance\")]")
    WebElement findMedicalCare;

    @FindBy(css = ".tax-ben-table td")
    List<WebElement> textMAEligibility;

    @FindBy(id = "taxHouseholdsDropdown")
    WebElement selectTaxHouseHold;

    @FindBy(css = ".ben-container > table > tbody")
    List<WebElement> ApplicationResultDetails;

    private BasicActions basicActions;

    public ApplicationResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickBtnContinue(){
        continueBtn.click();
    }

    public void validateAPTCByTHH(String expectedAPTC){
        String aptcLocator = "//th[text()='"+expectedAPTC+"']";
        basicActions.waitForElementToBePresent(basicActions.getDriver().findElement(By.xpath(aptcLocator)),15);
    }

    public void changeTaxHouseHold(int taxHH){
        String taxHouseHold = "Tax Household #"+taxHH+" benefits";

        Select dropdown = new Select(selectTaxHouseHold);
        dropdown.selectByVisibleText(taxHouseHold);
    }

    //-----------------------Validations------------------------//
    public void verifyTextNotQualifyForPlanOnAppResultsPage(){
        basicActions.waitForElementToBePresent(headerText,10);
        softAssert.assertEquals(headerText.getText(), "Here's what your household qualifies for");
        softAssert.assertEquals(youDoNotQualify.getText(), "Based on the information listed in your application, you do not qualify for a health plan at this time.");
        softAssert.assertEquals(submitNewApplication.getText(), "Submit a new application if your situation changes - you can re-apply and newly qualify for a health plan or financial help.");
        softAssert.assertEquals(basicRequirements.getText(), "Here are the basic requirements to buy a health plan through our marketplace:");
        softAssert.assertEquals(mustLiveInColorado.getText(), "You must live in Colorado");
        softAssert.assertEquals(mustBeUSCitizen.getText(), "You must be a U.S. citizen or be lawfully present");
        softAssert.assertEquals(incarcerated.getText(), "You cannot be incarcerated");
        softAssert.assertEquals(deceased.getText(), "You cannot be identified as deceased");
        softAssert.assertEquals(resourcesForYou.getText(), "Resources for you");
        softAssert.assertEquals(callUsToReviewApplication.getText(), "Call us at 855-PLANS-4-YOU (855-752-6749) to review your application results and qualifications to buy a health plan.");
        softAssert.assertEquals(findMedicalCare.getText(), "Find medical care and enrollment assistance in your community.");
        softAssert.assertAll();
    }

    public void verifyTextMAEligibility() {
        basicActions.waitForElementListToBePresent(textMAEligibility, 10);
        softAssert.assertEquals(textMAEligibility.get(1).getText(), "Health First Colorado or CHP+, if the State of Colorado determines you qualify");
        softAssert.assertAll();
    }

    public void verifyPrimaryMemberNotQualified(){
        String PrimaryMemberFirstName = SharedData.getPrimaryMember().getFirstName();
        softAssert.assertEquals(ApplicationResultDetails.get(2).getText(), PrimaryMemberFirstName+" does not qualify for health coverage.");
        softAssert.assertAll();
    }
}
