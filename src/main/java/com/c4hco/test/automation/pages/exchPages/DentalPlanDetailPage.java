package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class DentalPlanDetailPage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();
    private Optional<Integer> optionalInt;

    public DentalPlanDetailPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(xpath = "//button[@class = 'btn-secondary m-l-15']")
    WebElement clickGoBackDetail;

    @FindBy(id = "DentalCarrierDetails-InNetworkTier1")
    WebElement inNetworkDentalDetailLink;

    @FindBy(id = "DentalCarrierDetails-OutOfNetwork")
    WebElement outNetworkDentalDetailLink;

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


    public void clickGoBackDetail() {
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent(clickGoBackDetail, 15 );
        basicActions.scrollToElement( clickGoBackDetail );
        clickGoBackDetail.click(); }


    public void clickInNetworkDental() {
        basicActions.waitForElementToBeClickable(inNetworkDentalDetailLink,15 );
        inNetworkDentalDetailLink.click();}


    public void clickOutNetworkDental() {
        basicActions.waitForElementToBeClickable(outNetworkDentalDetailLink, 15 );
        outNetworkDentalDetailLink.click();}

    public void validateInNetworkDentalDetail(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals( txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
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
    public void validateOutNetworkDentalDetail(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals( txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
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
