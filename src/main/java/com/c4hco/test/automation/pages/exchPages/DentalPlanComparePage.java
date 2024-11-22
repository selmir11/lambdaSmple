package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class DentalPlanComparePage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();
    private Optional<Integer> optionalInt;

    public DentalPlanComparePage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "SHP-DentalComparePlans-GoBacktoPlans")
    WebElement goBackDentalCompare;

    @FindBy(id = "SHP-DentalComparePlans-InNetworkTier1")
    WebElement inNetworkDentalLink;

    @FindBy(id = "SHP-DentalComparePlans-OutOfNetwork")
    WebElement outNetworkDentalLink;

    @FindBy(xpath = "//div[@class='disclaimer body-text-2']")
    WebElement txtDentalDisclaimer;

    @FindBy(xpath = "//div[@class='pt-5 header-2']")
    WebElement txtHeader;

    @FindBy(id = "ngb-accordion-item-0-toggle")
    WebElement txtInMonthlyPremium;

    @FindBy(id = "ngb-accordion-item-1-toggle")
    WebElement txtInGeneralDetails;

    @FindBy(id = "ngb-accordion-item-2-toggle")
    WebElement txtInDiagnosticChild;

    @FindBy(id = "ngb-accordion-item-3-toggle")
    WebElement txtInDiagnosticAdult;


    @FindBy(id = "ngb-accordion-item-4-toggle")
    WebElement txtInBasicServicesChild;

    @FindBy(id = "ngb-accordion-item-5-toggle")
    WebElement txtInBasicServicesAdult;

    @FindBy(id = "ngb-accordion-item-6-toggle")
    WebElement txtInMajorServicesChild;

    @FindBy(id = "ngb-accordion-item-7-toggle")
    WebElement txtInMajorServicesAdult;

    @FindBy(id = "ngb-accordion-item-8-toggle")
    WebElement txtOutMonthlyPremium;

    @FindBy(id = "ngb-accordion-item-9-toggle")
    WebElement txtOutGeneralDetails;

    @FindBy(id = "ngb-accordion-item-10-toggle")
    WebElement txtOutDiagnosticChild;

    @FindBy(id = "ngb-accordion-item-11-toggle")
    WebElement txtOutDiagnosticAdult;

    @FindBy(id = "ngb-accordion-item-12-toggle")
    WebElement txtOutBasicServicesChild;

    @FindBy(id = "ngb-accordion-item-13-toggle")
    WebElement txtOutBasicServicesAdult;

    @FindBy(id = "ngb-accordion-item-14-toggle")
    WebElement txtOutMajorServicesChild;

    @FindBy(id = "ngb-accordion-item-15-toggle")
    WebElement txtOutMajorServicesAdult;

    public void clickGoBackCompare() {
        basicActions.waitForElementToBeClickable( goBackDentalCompare, 15 );
        goBackDentalCompare.click(); }


    public void clickInNetworkDental() {
        basicActions.waitForElementToBeClickable( inNetworkDentalLink,15 );
        inNetworkDentalLink.click();}


    public void clickOutNetworkDental() {
        basicActions.waitForElementToBeClickable( outNetworkDentalLink, 15 );
        outNetworkDentalLink.click();}

    public void validateInNetworkDental(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals( txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertEquals(txtHeader.getText(), "Plan Comparison");
        softAssert.assertEquals(txtInMonthlyPremium.getText(), "Monthly Premium");
        softAssert.assertEquals(txtInGeneralDetails.getText(), "General Details");
        softAssert.assertEquals(txtInDiagnosticChild.getText(), "Diagnostic and Preventive Services Child");
        softAssert.assertEquals(txtInDiagnosticAdult .getText(), "Diagnostic and Preventive Services Adult");
        softAssert.assertEquals(txtInBasicServicesChild.getText(), "Basic Services Child");
        softAssert.assertEquals(txtInBasicServicesAdult.getText(), "Basic Services Adult");
        softAssert.assertEquals(txtInMajorServicesChild.getText(), "Major Services Child");
        softAssert.assertEquals(txtInMajorServicesAdult.getText(), "Major Services Adult");
        softAssert.assertAll();
    }
    public void validateOutNetworkDental(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals( txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertEquals(txtHeader.getText(), "Plan Comparison");
        softAssert.assertEquals(txtOutMonthlyPremium.getText(), "Monthly Premium");
        softAssert.assertEquals(txtOutGeneralDetails.getText(), "General Details");
        softAssert.assertEquals(txtOutDiagnosticChild.getText(), "Diagnostic and Preventive Services Child");
        softAssert.assertEquals(txtOutDiagnosticAdult .getText(), "Diagnostic and Preventive Services Adult");
        softAssert.assertEquals(txtOutBasicServicesChild.getText(), "Basic Services Child");
        softAssert.assertEquals(txtOutBasicServicesAdult.getText(), "Basic Services Adult");
        softAssert.assertEquals(txtOutMajorServicesChild.getText(), "Major Services Child");
        softAssert.assertEquals(txtOutMajorServicesAdult.getText(), "Major Services Adult");
        softAssert.assertAll();


    }


}
