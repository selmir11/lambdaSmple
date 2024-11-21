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

    public void validateDentalDocumentationComparePlan(String carrier){
        switch(carrier){
            case "2":
                validateRockySelectdocumentcolumns();
                break;
            case "3":
                validateCignaKaiserAnthemdocumentcolumns();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + carrier);
        }


        
    }
    public void validateCignaKaiserAnthemdocumentcolumns(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );

        getDrpDwnPlanCategories.get(1).click();
        basicActions.waitForElementToBePresent( planDocEnglish11,30 );
        // Cigna
        softAssert.assertEquals( planDocEnglish11.getText(), "Brochure Cigna English" );
        softAssert.assertEquals( planDocEnglish12.getText(), "Evidence of Coverage Cigna English 0060032-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish13.getText(), "Summary of Benefits and Coverage Cigna English 0060032-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish14.getText(), "Summary of Benefits and Coverage CO Supplement Cigna English 0060032-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish15.getText(), "Provider Network Cigna" );
        softAssert.assertEquals( planDocEnglish16.getText(), "Quality Overview Cigna English" );

        softAssert.assertEquals( planDocSpanish11.getText(), "Evidence of Coverage Cigna Spanish 0060032-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish12.getText(), "Summary of Benefits and Coverage Cigna Spanish 0060032-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish13.getText(), "Summary of Benefits and Coverage CO Supplement Cigna Spanish 0060032-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish14.getText(), "Brochure Cigna Spanish" );
        softAssert.assertEquals( planDocEnglish15.getText(), "Quality Overview Cigna Spanish" );

        // Kaiser
        softAssert.assertEquals( planDocEnglish21.getText(), "Brochure Kaiser Permanente English" );
        softAssert.assertEquals( planDocEnglish22.getText(), "Evidence of Coverage Kaiser Permanente English 1040003-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish23.getText(), "Summary of Benefits and Coverage Kaiser Permanente English 1040003-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish24.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente English 1040003-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish25.getText(), "Provider Network Kaiser Permanente CO Option" );
        softAssert.assertEquals( planDocEnglish26.getText(), "Quality Overview Kaiser Permanente English" );

        softAssert.assertEquals( planDocSpanish21.getText(), "Summary of Benefits and Coverage Kaiser Permanente Spanish 1040003-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish22.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente Spanish 1040003-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish23.getText(), "Quality Overview Kaiser Permanente Spanish" );
        softAssert.assertEquals( planDocSpanish24.getText(), "Evidence of Coverage Kaiser Permanente Spanish 1040002-06 Colorado Option" );

        // Anthem
        softAssert.assertEquals( planDocEnglish31.getText(), "Brochure Anthem Medical English" );
        softAssert.assertEquals( planDocEnglish32.getText(), "Evidence of Coverage Anthem BCBS English 0220074-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish33.getText(), "Summary of Benefits and Coverage Anthem BCBS English 0220074-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish34.getText(), "Summary of Benefits and Coverage CO Supplement Anthem BCBS English 0220074-00 Colorado Option" );
        softAssert.assertEquals( planDocEnglish35.getText(), "Provider Network Anthem Pathway Essentials Standard" );
        softAssert.assertEquals( planDocEnglish36.getText(), "Quality Overview Anthem English" );

        softAssert.assertEquals( planDocSpanish31.getText(), "Evidence of Coverage Anthem BCBS Spanish 0220074-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish32.getText(), "Summary of Benefits and Coverage Anthem BCBS Spanish 0220074-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish33.getText(), "Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220074-00 Colorado Option" );
        softAssert.assertEquals( planDocSpanish34.getText(), "Quality Overview Anthem Spanish" );
        softAssert.assertEquals( planDocEnglish35.getText(), "Brochure Anthem Medical Spanish" );
    }

    public void validateRockySelectdocumentcolumns(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(1).click();

        basicActions.waitForElementToBePresent( planDocEnglish11,30 );
        softAssert.assertEquals( planDocEnglish11.getText(), "Summary of Benefits and Coverage CO Supplement Rocky Mountain English 0420056-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish12.getText(), "Evidence of Coverage Rocky Mountain English 0420056-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish13.getText(), "Summary of Benefits and Coverage Rocky Mountain English 0420056-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish14.getText(), "Quality Overview Rocky Mountain Health Plan English" );
        softAssert.assertEquals( planDocEnglish15.getText(), "Brochure RMHP-UHC English" );
        softAssert.assertEquals( planDocEnglish16.getText(), "Provider Network Rocky Mountain Health Plans Colorado Doctors Plan" );

        softAssert.assertEquals( planDocSpanish11.getText(), "Summary of Benefits and Coverage CO Supplement Rocky Mountain Spanish 0420056-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish12.getText(), "Evidence of Coverage Rocky Mountain Spanish 0420056-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish13.getText(), "Summary of Benefits and Coverage Rocky Mountain Spanish 0420056-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish14.getText(), "Quality Overview Rocky Mountain Health Plan Spanish" );
        softAssert.assertEquals( planDocEnglish15.getText(), "Brochure RMHP-UHC Spanish" );

        softAssert.assertEquals( planDocEnglish21.getText(), "Summary of Benefits and Coverage CO Supplement Select Health English 0030017-06" );
        softAssert.assertEquals( planDocEnglish22.getText(), "Evidence of Coverage Select Health English 0030017-06" );
        softAssert.assertEquals( planDocEnglish23.getText(), "Summary of Benefits and Coverage Select Health English 0030017-06" );
        softAssert.assertEquals( planDocEnglish24.getText(), "Quality Overview Select Health Plan English" );
        softAssert.assertEquals( planDocEnglish25.getText(), "Brochure Select Health English" );
        softAssert.assertEquals( planDocEnglish26.getText(), "Provider Network Select Health" );

        softAssert.assertEquals( planDocSpanish21.getText(), "Summary of Benefits and Coverage CO Supplement Select Health Spanish 0030017-06" );
        softAssert.assertEquals( planDocSpanish22.getText(), "Evidence of Coverage Select Health Spanish 0030017-06" );
        softAssert.assertEquals( planDocSpanish23.getText(), "Summary of Benefits and Coverage Select Health Spanish 0030017-06" );
        softAssert.assertEquals( planDocSpanish24.getText(), "Quality Overview Select Health Plan Spanish" );
        softAssert.assertEquals( planDocEnglish25.getText(), "Brochure Select Health Spanish" );
    }


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
