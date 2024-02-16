package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.frstName;

public class WelcomePage {

    @FindBy(xpath = "//div[@class='header-1']")
    WebElement welcomeToConnectText;

    @FindBy(xpath = "//div[@class='header-2 content-center']")
    WebElement applyForHealthInsuranceText;

    @FindBy(xpath = "//div[@class='body-text-1 apply-text-body']")
    WebElement theAnnualOpenEnrollmentText;

    @FindBy(id = "ELIG-WelcomePage-ApplyForInsurance-2024")
    WebElement applyFor2024Button;

    @FindBy(xpath = "//div[.=' Your current plan(s) ']")
    WebElement yourCurrentPlansText;

    @FindBy(xpath = "//div[*='Plan Year']/label")
    WebElement planYearText;

    @FindBy(xpath = "//*[@id='plan-year-selector']")
    WebElement planYearSelectorDp;

    @FindBy(xpath = "//div[@class='no-plans plans-container']")
    WebElement youHaveNotEnrolled;

    @FindBy (xpath = "//span[.='Additional Resources']")
    WebElement additionalResourcesText;

    @FindBy(id = "ELIG-WelcomePage-MyProfile")
    WebElement myProfileButton;

    @FindBy(xpath = "//div[.='View and update your account information']")
    WebElement viewAndUpdateText;

    @FindBy(id = "ELIG-WelcomePage-ApplicationResults")
    WebElement applicationResultsButton;

    //change the locator below
    @FindBy(xpath = "//app-container//div[4]")
    WebElement viewTheBenefitsText;

    @FindBy(id = "ELIG-WelcomePage-MyDocuments")
    WebElement myDocumentsButton;

    //change the locator below
    @FindBy(xpath = "//app-container//div[6]")
    WebElement viewYourDocumentsText;

    @FindBy(css = ".action-link")
    List<WebElement> actionLinks;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;
    public WelcomePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickApply2024CoCo() {
        basicActions.waitForElementToBeClickable(applyFor2024Button, 5);
        applyFor2024Button.click(); }

    public void clickMyProfileButton() {
        basicActions.waitForElementToBeClickable(myProfileButton, 5);
        myProfileButton.click(); }

    public void clickApplicationResultsButton() {
        basicActions.waitForElementToBeClickable(applicationResultsButton, 5);
        applicationResultsButton.click(); }

    public void clickMyDocumentsButton() {
        basicActions.waitForElementToBeClickable(myDocumentsButton, 5);
        myDocumentsButton.click(); }

    public void clickActionLinks(String actionLink) {
        basicActions.waitForElementListToBePresent(actionLinks, 5);
        switch(actionLink) {
            case "Application Results":
                actionLinks.get(1).click();
                break;
            case "My Documents and Letters":
                actionLinks.get(2).click();
                break;
        }
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyTextOnWelcomePageFirstTime(){
        basicActions.waitForElementToBePresent(applyFor2024Button,10);
        String header  = applyFor2024Button.getText();
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome to Colorado Connect!");
        softAssert.assertEquals(applyForHealthInsuranceText.getText(), "Apply for health insurance");
        softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        softAssert.assertEquals(applyFor2024Button.getText(), "Apply for 2024");
        softAssert.assertEquals(yourCurrentPlansText.getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "You have not yet enrolled in a plan for 2024");
        softAssert.assertEquals(additionalResourcesText.getText(), "Additional Resources");
        softAssert.assertEquals(myProfileButton.getText(), "My Profile");
        softAssert.assertEquals(viewAndUpdateText.getText(), "View and update your account information");
        softAssert.assertEquals(applicationResultsButton.getText(), "Application Results");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(myDocumentsButton.getText(), "My Documents and Letters");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "View your documents");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePageNoPolicy(){
        basicActions.waitForElementToBePresent(applyFor2024Button,10);
        String header  = applyFor2024Button.getText();
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome back, "+frstName+"!");
        softAssert.assertEquals(applyForHealthInsuranceText.getText(), "Apply for health insurance");
        softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        softAssert.assertEquals(applyFor2024Button.getText(), "Apply for 2024");
        softAssert.assertEquals(yourCurrentPlansText.getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "You have not yet enrolled in a plan for 2024");
        softAssert.assertEquals(additionalResourcesText.getText(), "Additional Resources");
        softAssert.assertEquals(myProfileButton.getText(), "My Profile");
        softAssert.assertEquals(viewAndUpdateText.getText(), "View and update your account information");
        softAssert.assertEquals(applicationResultsButton.getText(), "Application Results");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(myDocumentsButton.getText(), "My Documents and Letters");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "View your documents");
        softAssert.assertAll();
    }

    public void validateActionLinksText(String actionLink) {
        basicActions.waitForElementListToBePresent(actionLinks, 5);
        switch(actionLink) {
            case "Application Results":
                softAssert.assertTrue(actionLinks.get(1).getText().equals(actionLink));
                softAssert.assertAll();
                break;
            case "My Documents and Letters":
                softAssert.assertTrue(actionLinks.get(2).getText().equals(actionLink));
                softAssert.assertAll();
                break;
        }
    }
}


