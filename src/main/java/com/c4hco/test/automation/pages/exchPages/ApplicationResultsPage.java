package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.NoSuchElementException;

public class ApplicationResultsPage {
    SoftAssert softAssert = new SoftAssert();

// TO DO: Update all the below locators
    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;
    @FindBy(css = ".btn-c4primary")
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

    //pop up on the app results page
    @FindBy(css = "b.popup-body-text-2")
    WebElement popUpText;

    @FindBy(css = ".btn-info")
    WebElement popUpBackButton;

    @FindBy(css = ".tot-sav")
    WebElement totalSavingsSection;

    @FindBy(css = ".tot-sav .tot-sav-head-right")
    List<WebElement> totalAptcValue;

    @FindBy(css = ".left-div > div > div button")
    WebElement applicationSummaryLnk;

    @FindBy(name = "openSelfAttestation")
    WebElement verifyMyInfoButton;

    private BasicActions basicActions;

    public ApplicationResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickBtnContinue(){
        continueBtn.click();
    }

    public void validateAPTCByTHH(int THHNum, String expectedAPTC){
        basicActions.waitForElementToBePresent(headerText, 20);
        basicActions.waitForElementToBePresent(totalSavingsSection, 20);
        basicActions.scrollToElement(totalSavingsSection);
        basicActions.waitForElementListToBePresent(totalAptcValue, 20);
        int index = THHNum - 1;
        Assert.assertEquals(totalAptcValue.get(index).getText(), expectedAPTC, "APTC Amount did not match!");
    }

    public void validateAPTCNotAppearing(){
      softAssert.assertFalse(basicActions.waitForElementToBePresent(lblAPTCValue,10));
      softAssert.assertAll();

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

    public void verifyPopUpTextOnTheApplicationResults(String language) {
        basicActions.waitForElementToBePresent(popUpText, 10);
        switch (language) {
            case "English":
                verifyPopUpTextOnTheApplicationResultsEnglish();
                break;
            case "Spanish":
                verifyPopUpTextOnTheApplicationResultsSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyPopUpTextOnTheApplicationResultsEnglish() {
        softAssert.assertEquals(popUpText.getText(), "You can't enroll in a plan because it is not Open Enrollment. The Open Enrollment period is from Nov. 1 to Jan. 15.\n\nTo enroll in a plan or change your plan outside of Open Enrollment, you must have a qualifying life change event. For questions or assistance, call our Customer Service Center at 855-752-6749 or contact your Broker or Assister.");
        softAssert.assertAll();
    }

    public void verifyPopUpTextOnTheApplicationResultsSpanish() {
        softAssert.assertEquals(popUpText.getText(), "No puede inscribirse en un plan porque no es el per\u00EDodo de inscripci\u00F3n abierta. El per\u00EDodo de inscripci\u00F3n abierta es del 1\u00BA de noviembre al 15 de enero.\n\nPara inscribirse en un plan o hacer cambios fuera del per\u00EDodo de inscripci\u00F3n abierta, debe tener un evento de vida calificado. Si tiene preguntas o desea recibir asistencia, llame a nuestro Centro de atenci\u00F3n al cliente al 855-752-6749 o contacte a su agente o asistente.");
        softAssert.assertAll();
    }

    public void clickBtnBackPopup(){
        popUpBackButton.click();
    }

    public void validateTextOnPage(String text) {
        basicActions.waitForElementToBePresent(basicActions.getDriver().findElement(By.xpath("//*[contains(text(),\""+text+"\")]")), 15);
    }

    public void clickViewApplicationSummary() {
        basicActions.waitForElementToBePresent(applicationSummaryLnk, 30);
        applicationSummaryLnk.click();
    }



    public void validateMemberResults(List<String> expectedValues) {
        for (String option : expectedValues) {
            String[] parts = option.split(":");

            String name = parts[0].trim();
            String resultExpected = parts[1].trim();
            String[] resultExpectedArray = resultExpected.split(", ");

            for (String result : resultExpectedArray) {
                validateEachMemberResults(name, result.trim());
            }
        }
        softAssert.assertAll();
    }

    private void validateEachMemberResults(String name, String resultExpected) {
        String xpath = String.format("//*[contains(text(),'%s')]//following::tr/td[contains(text(),'%s')]", name, resultExpected);
        WebElement memberResults = basicActions.getDriver().findElement(By.xpath(xpath));
        softAssert.assertEquals(memberResults.getText(), resultExpected, "Mismatch for: " + name + " -> " + resultExpected);
    }

    public void clickVerifyMyInfo() {
        WebElement textBox = basicActions.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/form/div[1]/div/div[3]/div[1]"));
        String expectedText = "Before you continue… We tried to verify your application but we need you to answer a few  questions to confirm your income and tax information.";
        softAssert.assertEquals(textBox.getText(), expectedText, "Verify My Info Button Text Incorrect");
        verifyMyInfoButton.click();
    }

//    public void checkVerifyMyInfoGone() {
//        WebDriverWait wait = new WebDriverWait(basicActions.getDriver(), timeout);
//        wait.until(ExpectedConditions.invisibilityOf(verifyMyInfoButton));
//    }
}
