package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
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

    @FindBy(css = ".float-start")
    WebElement txtInMonthlyPremium;

    @FindBy(id = "ngb-accordion-item-0-toggle")
    WebElement txtInGeneralDetails;

    @FindBy(id = "ngb-accordion-item-1-toggle")
    WebElement txtInDiagnosticChild;

    @FindBy(xpath = "//*[class = 'td-sub-title']")
    List<WebElement> subheader;

    @FindBy(xpath = " //*[contains(text(),\"Cleaning Child\")]")
    WebElement txtCleaningChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Child\\\")]\")")
    WebElement txtFlourideChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Child\\\")]\")")
    WebElement txtOralExamsChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Child\\\")]\")")
    WebElement txtXraysChild;

    @FindBy(id = "ngb-accordion-item-2-toggle")
    WebElement txtInDiagnosticAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Adult\\\")]\")")
    WebElement txtCleaningAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Oral Exams Adult\\\")]\")")
    WebElement txtOralExamsAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"X-rays Adult\\\")]\")")
    WebElement txtXraysAdult;
    //
    @FindBy(id = "ngb-accordion-item-3-toggle")
    WebElement txtInBasicServicesChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Amalgam (Steel) Fillings Child\\\")]\")")
    WebElement txtAmalgamChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Periodontics - Other Child\\\")]\")")
    WebElement txtPeriodonticsChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Resin (white plastic) Fillings Child\\\")]\")")
    WebElement txtResinChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Sedative Fillings Child\\\")]\")")
    WebElement txtSedativeFluidChild;

    @FindBy(id = "ngb-accordion-item-4-toggle")
    WebElement txtInBasicServicesAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Amalgam (Steel) Fillings Adult\\\")]\")")
    WebElement txtAmalgamAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Periodontics - Other Adult\\\")]\")")
    WebElement txtPeriodonticsAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Sedative Fillings Adult\\\")]\")")
    WebElement txtSedativeFluidAdult;
    //

    @FindBy(id = "ngb-accordion-item-5-toggle")
    WebElement txtInMajorServicesChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Dentures and Bridges Child\\\")]\")")
    WebElement txtDenturesChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Implants Child\\\")]\")")
    WebElement txtImplantsChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Medically Necessary Orthodontia Child\\\")]\")")
    WebElement txtOrthodontiaChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Oral Surgery Child\\\")]\")")
    WebElement txtOralSurgeryChild;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Root canal therapy Child\\\")]\")")
    WebElement txtRootCanalChild;
//
    @FindBy(id = "ngb-accordion-item-6-toggle")
    WebElement txtInMajorServicesAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Dentures and Bridges Adult\\\")]\")")
    WebElement txtDenturesAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Implants Adult\\\")]\")")
    WebElement txtImplantsAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Medically Necessary Orthodontia Adult\\\")]\")")
    WebElement txtOrthodontiaAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Oral Surgery Adult\\\")]\")")
     WebElement txtOralSurgeryAdult;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Root canal therapy Adult\\\")]\")")
    WebElement txtRootCanalAdult;
    //
    @FindBy(css = ".float-start")
    WebElement txtOutMonthlyPremium;

    @FindBy(id = "ngb-accordion-item-21-toggle")
    WebElement txtOutGeneralDetails;

    @FindBy(id = "ngb-accordion-item-22-toggle")
    WebElement txtOutDiagnosticChild;

    @FindBy(id = "ngb-accordion-item-23-toggle")
    WebElement txtOutDiagnosticAdult;

    @FindBy(id = "ngb-accordion-item-24-toggle")
    WebElement txtOutBasicServicesChild;

    @FindBy(id = "ngb-accordion-item-25-toggle")
    WebElement txtOutBasicServicesAdult;

    @FindBy(id = "ngb-accordion-item-26-toggle")
    WebElement txtOutMajorServicesChild;

    @FindBy(id = "ngb-accordion-item-27-toggle")
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
        softAssert.assertEquals(txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertEquals(txtInMonthlyPremium.getText(), "Monthly Premium");
        softAssert.assertEquals(txtInGeneralDetails.getText(), "General Details");
        softAssert.assertEquals(txtInDiagnosticChild.getText(), "Diagnostic and Preventive Services Child");
        txtInGeneralDetails.click();
        txtInDiagnosticChild.click();
        // assertions not working here  - review
        softAssert.assertEquals( subheader.get(1).getText(), "Cleaning Child" );
        softAssert.assertEquals( txtFlourideChild.getText(), "Flouride Treatments Child" );
        softAssert.assertEquals( txtOralExamsChild.getText(), "Oral Exams Child");
        softAssert.assertEquals( txtXraysChild.getText(),"X-rays Child" );
        softAssert.assertEquals(txtInDiagnosticAdult.getText(), "Diagnostic and Preventive Services Adult");
        txtInDiagnosticChild.click();
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdult.getText(), "Cleaning Adult" );
        softAssert.assertEquals( txtOralExamsAdult.getText(), "Oral Exams Adult");
        softAssert.assertEquals(txtXraysAdult.getText(), "X-rays Adult");
        softAssert.assertEquals( txtInBasicServicesChild.getText(),"Basic Services Child" );
        txtInDiagnosticAdult.click();
        txtInBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChild.getText(), "Amalgam (Steel) Fillings Child" );
        softAssert.assertEquals( txtPeriodonticsChild.getText(), "Peridontics - Other Child" );
        softAssert.assertEquals( txtResinChild.getText(), "Resin (white plastic) Fillings Child");
        softAssert.assertEquals( txtSedativeFluidChild.getText(),"Sedative Fillings Child" );
        softAssert.assertEquals(txtInBasicServicesAdult.getText(), "Basic Services Adult");
        txtInBasicServicesChild.click();
        txtInBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdult.getText(), "Amalgam (Steel) Fillings Adult" );
        softAssert.assertEquals( txtPeriodonticsAdult.getText(), "Peridontics - Other Adult" );
        softAssert.assertEquals( txtSedativeFluidAdult.getText(),"Sedative Fillings Adult" );
        softAssert.assertEquals(txtInMajorServicesChild.getText(), "Major Services Child");
        txtInBasicServicesAdult.click();
        txtInMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChild.getText(),"Dentures and Bridges Child" );
        softAssert.assertEquals( txtImplantsChild.getText(),"Implants Child" );
        softAssert.assertEquals( txtOrthodontiaChild.getText(),"Medically Necessary Orthodontia Child" );
        softAssert.assertEquals( txtOralSurgeryChild.getText(),"Oral Surgery Child" );
        softAssert.assertEquals( txtRootCanalChild.getText(),"Root canal therapy Child" );
        softAssert.assertEquals(txtInMajorServicesAdult.getText(), "Major Services Adult");
        txtInMajorServicesChild.click();
        txtInMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdult.getText(),"Dentures and Bridges Adult" );
        softAssert.assertEquals( txtImplantsAdult.getText(),"Implants Adult" );
        softAssert.assertEquals( txtOrthodontiaAdult.getText(),"Medically Necessary Orthodontia Child" );
        softAssert.assertEquals( txtOralSurgeryAdult.getText(),"Oral Surgery Adult" );
        softAssert.assertEquals( txtRootCanalAdult.getText(),"Root canal therapy Adult" );
        txtInMajorServicesAdult.click();
        softAssert.assertAll();
    }
    public void validateOutNetworkDentalDetail(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals(txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertEquals(txtInMonthlyPremium.getText(), "Monthly Premium");
        softAssert.assertEquals(txtInGeneralDetails.getText(), "General Details");
        softAssert.assertEquals(txtInDiagnosticChild.getText(), "Diagnostic and Preventive Services Child");
        txtInGeneralDetails.click();
        txtInDiagnosticChild.click();
        softAssert.assertEquals( txtCleaningChild.getText(), "Cleaning Child" );
        softAssert.assertEquals( txtFlourideChild.getText(), "Flouride Treatments Child" );
        softAssert.assertEquals( txtOralExamsChild.getText(), "Oral Exams Child");
        softAssert.assertEquals( txtXraysChild.getText(),"X-rays Child" );
        softAssert.assertEquals(txtInDiagnosticAdult.getText(), "Diagnostic and Preventive Services Adult");
        txtInDiagnosticChild.click();
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdult.getText(), "Cleaning Adult" );
        softAssert.assertEquals( txtOralExamsAdult.getText(), "Oral Exams Adult");
        softAssert.assertEquals(txtXraysAdult.getText(), "X-rays Adult");
        softAssert.assertEquals( txtInBasicServicesChild.getText(),"Basic Services Child" );
        txtInDiagnosticAdult.click();
        txtInBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChild.getText(), "Amalgam (Steel) Fillings Child" );
        softAssert.assertEquals( txtPeriodonticsChild.getText(), "Peridontics - Other Child" );
        softAssert.assertEquals( txtResinChild.getText(), "Resin (white plastic) Fillings Child");
        softAssert.assertEquals( txtSedativeFluidChild.getText(),"Sedative Fillings Child" );
        softAssert.assertEquals(txtInBasicServicesAdult.getText(), "Basic Services Adult");
        txtInBasicServicesChild.click();
        txtInBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdult.getText(), "Amalgam (Steel) Fillings Adult" );
        softAssert.assertEquals( txtPeriodonticsAdult.getText(), "Peridontics - Other Adult" );
        softAssert.assertEquals( txtSedativeFluidAdult.getText(),"Sedative Fillings Adult" );
        softAssert.assertEquals(txtInMajorServicesChild.getText(), "Major Services Child");
        txtInBasicServicesAdult.click();
        txtInMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChild.getText(),"Dentures and Bridges Child" );
        softAssert.assertEquals( txtImplantsChild.getText(),"Implants Child" );
        softAssert.assertEquals( txtOrthodontiaChild.getText(),"Medically Necessary Orthodontia Child" );
        softAssert.assertEquals( txtOralSurgeryChild.getText(),"Oral Surgery Child" );
        softAssert.assertEquals( txtRootCanalChild.getText(),"Root canal therapy Child" );
        softAssert.assertEquals(txtInMajorServicesAdult.getText(), "Major Services Adult");
        txtInMajorServicesChild.click();
        txtInMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdult.getText(),"Dentures and Bridges Adult" );
        softAssert.assertEquals( txtImplantsAdult.getText(),"Implants Adult" );
        softAssert.assertEquals( txtOrthodontiaAdult.getText(),"Medically Necessary Orthodontia Child" );
        softAssert.assertEquals( txtOralSurgeryAdult.getText(),"Oral Surgery Adult" );
        softAssert.assertEquals( txtRootCanalAdult.getText(),"Root canal therapy Adult" );
        txtInMajorServicesAdult.click();
        softAssert.assertAll();


    }


}
