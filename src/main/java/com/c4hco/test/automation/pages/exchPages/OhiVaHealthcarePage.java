package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OhiVaHealthcarePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public OhiVaHealthcarePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement ohiHeader;

    @FindBy(css = ".container .header-2")
    WebElement ohiVaHealthcareHeader;

    @FindBy(id = "Ohi-Endable-enrolled-YesButton")
    WebElement currentlyEnrolledYes;

    @FindBy(id = "Ohi-Endable-enrolled-NoButton")
    WebElement currentlyEnrolledNo;

    @FindBy(id = "Ohi-Endable-endsSoon-YesButton")
    WebElement insuranceEndingYes;

    @FindBy(id = "Ohi-Endable-endsSoon-NoButton")
    WebElement insuranceEndingNo;

    @FindBy(css = "#Ohi-Endable-endDate")
    WebElement inputEndDate;

    @FindBy(id = "Ohi-Endable-endVoluntary-YesButton")
    WebElement endVoluntaryYes;

    @FindBy(id = "Ohi-Endable-endVoluntary-NoButton")
    WebElement endVoluntaryNo;

    @FindBy(id = "submitButton")
    List<WebElement> goBackAndContinueButton;

    @FindBy(id = "Ohi-Endable-SaveAndContinue")
    WebElement saveAndContinueBtn;


    public void clickGoBack() {
        basicActions.click(goBackAndContinueButton.get(0));
    }

    public void clickSaveAndContinue() {
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }

    public void clickCurrentlyEnrolledOption(String currentlyEnrolled) {
        switch (currentlyEnrolled) {
            case "Yes":
                basicActions.waitForElementToBeClickable(currentlyEnrolledYes, 20);
                basicActions.click(currentlyEnrolledYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(currentlyEnrolledNo, 20);
                basicActions.click(currentlyEnrolledNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyEnrolled);
        }
    }

    public void clickInsuranceEndingOption(String insuranceEnding) {
        switch (insuranceEnding) {
            case "Yes":
                basicActions.waitForElementToBeClickable(insuranceEndingYes, 20);
                basicActions.click(insuranceEndingYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(insuranceEndingNo, 20);
                basicActions.click(insuranceEndingNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void enterEndDate() {
        basicActions.waitForElementToBePresent(inputEndDate, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("MM-dd");

        inputEndDate.sendKeys(endOfCurrentMonth.format(lastDayOfMonth));
    }

    public void clickEndVoluntaryOption(String voluntaryEnding) {
        switch (voluntaryEnding) {
            case "Yes":
                basicActions.waitForElementToBeClickable(endVoluntaryYes, 20);
                basicActions.click(endVoluntaryYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(endVoluntaryNo, 20);
                basicActions.click(endVoluntaryNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + voluntaryEnding);
        }
    }


    // ############################## VALIDATION STEPS #########################
// Add only validation methods below this line
    public void verifyHeadersVaHealthcareOhiPageEnglish() {
        basicActions.waitForElementToBePresent(ohiHeader, 15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiVaHealthcareHeader.getText(), "VA Healthcare");
        softAssert.assertAll();
    }

    public void verifyCurrentlyEnrolledOption(String currentlyEnrolled) {
        switch (currentlyEnrolled) {
            case "Yes":
                basicActions.waitForElementToBePresent(currentlyEnrolledYes, 15);
                softAssert.assertTrue(currentlyEnrolledYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(currentlyEnrolledNo, 15);
                softAssert.assertTrue(currentlyEnrolledNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyEnrolled);
        }
    }

    public void verifyInsuranceEndingOption(String insuranceEnding) {
        switch (insuranceEnding) {
            case "Yes":
                basicActions.waitForElementToBePresent(insuranceEndingYes, 15);
                softAssert.assertTrue(insuranceEndingYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(insuranceEndingNo, 15);
                softAssert.assertTrue(insuranceEndingNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void verifyEndDate() {
        basicActions.waitForElementToBePresent(inputEndDate, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("YYY-MM-dd");

        softAssert.assertTrue(inputEndDate.getAttribute("value").contains(endOfCurrentMonth.format(lastDayOfMonth)));
        softAssert.assertAll();
    }

    public void verifyVoluntaryEndingOption(String voluntaryEnding) {
        switch (voluntaryEnding) {
            case "Yes":
                basicActions.waitForElementToBePresent(endVoluntaryYes, 15);
                softAssert.assertTrue(endVoluntaryYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(endVoluntaryNo, 15);
                softAssert.assertTrue(endVoluntaryNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + voluntaryEnding);
        }


    }
}
