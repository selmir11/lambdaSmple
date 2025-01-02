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

    @FindBy(id = "ComparePlans-TopGoBackToPlans")
    WebElement goBackDentalCompareLink;

    @FindBy(id = "ComparePlans-GoBackToPlans")
    WebElement goBackDentalCompareBtn;

    @FindBy(id = "DentalPlanCompare_InNetworkTab")
    WebElement inNetworkDentalLink;

    @FindBy(id = "DentalPlanCompare_OutOfNetworkTab")
    WebElement outNetworkDentalLink;

    // headers

    @FindBy(id = "PlanCompare_Highlights")
    WebElement txtHighlights;

    @FindBy(id = "PlanCompare_ExpandAll")
    WebElement expandAllLink;

    @FindBy(id = "PlanCompare_CollapseAll")
    WebElement collapseAllLink;

    @FindBy(id = "PlanCompare_PlanDocuments")
    WebElement txtPlanDocuments;



    // Diagnostic and Preventive Services Child

    @FindBy(id = "PlanCompare_DiagnosticAndPreventiveServicesChild")
    WebElement txtDentalDiagnosticChild;

    @FindBy(xpath = "//td[normalize-space()='Cleaning Child']")
    public WebElement getTxtCleaningChild;
    @FindBy(xpath = "//td[normalize-space()='Fluoride Treatments Child']")
    public WebElement getTxtFlourideTreatmentChild;
    @FindBy(xpath = "//td[normalize-space()='Oral Exams Child']")
    public WebElement getTxtOralExamsChild;
    @FindBy(xpath = "//td[normalize-space()='X-rays Child']")
    public WebElement getTxtXrayChild;

    // Diagnostic and Preventive Services Adult

    @FindBy(id = "PlanCompare_DiagnosticAndPreventiveServicesAdult")
    WebElement txtDentalDiagnosticAdult;

    @FindBy(xpath = "//td[normalize-space()='Cleaning Adult']")
    public WebElement getTxtCleaningAdult;
    @FindBy(xpath = "//td[normalize-space()='Oral Exams Adult']")
    public WebElement getTxtOralExamsAdult;
    @FindBy(xpath = "//td[normalize-space()='X-rays Adult']")
    public WebElement getTxtXrayAdult;

    // Basic Services Child

    @FindBy(id = "PlanCompare_BasicServicesChild")
    WebElement txtDentalBasicServicesChild;

    @FindBy(xpath = "//td[normalize-space()='Amalgam (Steel) Fillings Child']")
    public WebElement getTxtAmalgamChild;
    @FindBy(xpath = "//td[normalize-space()='Periodontics - Other Child']")
    public WebElement getTxtPeridonticsChild;
    @FindBy(xpath = "//td[normalize-space()='Resin (white plastic) Fillings Child']")
    public WebElement getTxtResinChild;
    @FindBy(xpath = "//td[normalize-space()='Sedative Fillings Child']")
    public WebElement getTxtSedativeChild;

    // Basic Services Adult

    @FindBy(id = "PlanCompare_BasicServicesAdult")
    WebElement txtDentalBasicServicesAdult;
    @FindBy(xpath = "//td[normalize-space()='Amalgam (Steel) Fillings Adult']")
    public WebElement getTxtAmalgamAdult;
    @FindBy(xpath = "//td[normalize-space()= 'Periodontics - Other Adult']")
    public WebElement getTxtPeridonticsAdult;
    @FindBy(xpath = "//td[normalize-space()='Sedative Fillings Adult']")
    public WebElement getTxtSedativeAdult;

    // Major Services Child

    @FindBy(id = "PlanCompare_MajorServicesChild")
    WebElement txtDentalMajorServicesChild;
    @FindBy(xpath = "//td[normalize-space()='Dentures and Bridges Child']")
    public WebElement getTxtDenturesChild;
    @FindBy(xpath = "//td[normalize-space()='Implants Child']")
    public WebElement getTxtImplantsChild;
    @FindBy(xpath = "//td[normalize-space()='Medically Necessary Orthodontia Child']")
    public WebElement getTxtOrthodontiaChild;
    @FindBy(xpath = "//td[normalize-space()='Oral Surgery Child']")
    public WebElement getTxtOralChild;
    @FindBy(xpath = "//td[normalize-space()='Root canal therapy Child']")
    public WebElement getTxtRootCanalChild;

    // Major Services Adult

    @FindBy(id = "PlanCompare_MajorServicesAdult")
    WebElement txtDentalMajorServicesAdult;
    @FindBy(xpath = "//td[normalize-space()='Dentures and Bridges Adult']")
    public WebElement getTxtDenturesAdult;
    @FindBy(xpath = "//td[normalize-space()='Implants Adult']")
    public WebElement getTxtImplantsAdult;
    @FindBy(xpath = "//td[normalize-space()='Oral Surgery Adult']")
    public WebElement getTxtOralSurgery;
    @FindBy(xpath = "//td[normalize-space()='Root canal therapy Adult']")
    public WebElement getTxtRootCanalAdult;




    public void clickGoBackCompare() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresentWithRetries( goBackDentalCompareBtn, 15 );
        goBackDentalCompareBtn.click(); }

    public void clickGoBackCompareLink() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresentWithRetries( goBackDentalCompareLink, 15 );
        goBackDentalCompareLink.click(); }

    public void clickInNetworkDental() {
        basicActions.waitForElementToBeClickable( inNetworkDentalLink,15 );
        inNetworkDentalLink.click();}

    public void clickOutNetworkDental() {
        basicActions.waitForElementToBeClickable( outNetworkDentalLink, 15 );
        outNetworkDentalLink.click();}

    public void validateExpandCollapseDentalCompareHeaders(){
        basicActions.waitForElementToDisappear( spinner,30 );
        softAssert.assertEquals( txtHighlights.getText(),"Highlights" );
        softAssert.assertEquals( txtPlanDocuments.getText(),"Plan Documents" );
        basicActions.click( txtPlanDocuments );

        softAssert.assertEquals( txtDentalDiagnosticChild.getText(),"Diagnostic and Preventive Services Child" );
        basicActions.click( txtDentalDiagnosticChild );
        softAssert.assertEquals( txtDentalDiagnosticAdult.getText(),"Diagnostic and Preventive Services Adult" );
        basicActions.click( txtDentalDiagnosticAdult );

        softAssert.assertEquals( txtDentalBasicServicesChild.getText(),"Basic Services Child" );
        basicActions.click( txtDentalBasicServicesChild );
        softAssert.assertEquals( txtDentalBasicServicesAdult.getText(),"Basic Services Adult" );
        basicActions.click( txtDentalBasicServicesAdult );

        softAssert.assertEquals( txtDentalMajorServicesChild.getText(),"Major Services Child" );
        basicActions.click( txtDentalMajorServicesChild );
        softAssert.assertEquals( txtDentalMajorServicesAdult.getText(),"Major Services Adult" );
        basicActions.click( txtDentalMajorServicesAdult );

        softAssert.assertEquals( collapseAllLink.getText(),"Collapse All Categories" );
        basicActions.click(collapseAllLink );
        softAssert.assertEquals( txtDentalDiagnosticChild.getText(),"Diagnostic and Preventive Services Child" );
        basicActions.click( txtDentalDiagnosticChild );

        basicActions.scrollToElement(collapseAllLink);
        softAssert.assertEquals( collapseAllLink.getText(),"Collapse All Categories" );
        basicActions.click(collapseAllLink );
        basicActions.waitForElementToBePresent(expandAllLink,20  );
        softAssert.assertEquals( expandAllLink.getText(),"Expand All Categories" );
        basicActions.click( expandAllLink );
        basicActions.click(collapseAllLink );
    }

    public void validateInNetworkDental(){
        basicActions.waitForElementToBePresent( inNetworkDentalLink,15 );
        softAssert.assertEquals( txtHighlights.getText(),"Highlights" );
        softAssert.assertEquals( txtPlanDocuments.getText(),"Plan Documents" );
        softAssert.assertEquals(txtDentalDiagnosticChild.getText(), "Diagnostic and Preventive Services Child");
        basicActions.click( txtDentalDiagnosticChild );
        softAssert.assertEquals(getTxtCleaningChild.getText(), "Cleaning Child");
        softAssert.assertEquals(getTxtFlourideTreatmentChild.getText(), "Flouride Treatments Child");
        softAssert.assertEquals(getTxtOralExamsChild.getText(), "Oral Exams Child");
        softAssert.assertEquals(getTxtXrayChild.getText(), "X-rays Child");

        softAssert.assertEquals(txtDentalDiagnosticAdult .getText(), "Diagnostic and Preventive Services Adult");
        basicActions.click( txtDentalDiagnosticAdult );
        softAssert.assertEquals(getTxtCleaningAdult .getText(), "Cleaning Adult");
        softAssert.assertEquals(getTxtOralExamsAdult .getText(), "Oral Exams Adult");
        softAssert.assertEquals(getTxtXrayAdult .getText(), "X-rays Adult");

        softAssert.assertEquals(txtDentalBasicServicesChild.getText(), "Basic Services Child");
        basicActions.click( txtDentalBasicServicesChild );
        softAssert.assertEquals(getTxtAmalgamChild.getText(), "Amalgam (Steel) Fillings Child");
        softAssert.assertEquals(getTxtPeridonticsChild.getText(), "Periodontics - Other Child");
        softAssert.assertEquals(getTxtResinChild.getText(), "Resin (white plastic) Fillings Child");
        softAssert.assertEquals(getTxtSedativeChild.getText(), "Sedative Fillings Child");

        softAssert.assertEquals(txtDentalBasicServicesAdult.getText(), "Basic Services Adult");
        basicActions.click( txtDentalBasicServicesAdult );
        softAssert.assertEquals(getTxtAmalgamAdult.getText(), "Amalgam (Steel) Fillings Adult");
        softAssert.assertEquals(getTxtPeridonticsAdult.getText(), "Periodontics - Other Adult");
        softAssert.assertEquals(getTxtSedativeAdult.getText(), "Sedative Fillings Adult");

        softAssert.assertEquals(txtDentalMajorServicesChild.getText(), "Major Services Child");
        basicActions.click( txtDentalMajorServicesChild );
        softAssert.assertEquals(getTxtDenturesChild.getText(), "Dentures and Bridges Child");
        softAssert.assertEquals(getTxtImplantsChild.getText(), "Implants Child");
        softAssert.assertEquals(getTxtOrthodontiaChild.getText(), "Medically Necessary Orthodontia Child");
        softAssert.assertEquals(getTxtOralChild.getText(), "Oral Surgery Child");
        softAssert.assertEquals(getTxtRootCanalChild.getText(), "Root canal therapy Child");

        softAssert.assertEquals(txtDentalMajorServicesAdult.getText(), "Major Services Adult");
        basicActions.click( txtDentalMajorServicesAdult );
        softAssert.assertEquals(getTxtDenturesAdult.getText(), "Dentures and Bridges Adult");
        softAssert.assertEquals(getTxtImplantsAdult.getText(), "Implants Adult");
        softAssert.assertEquals(getTxtOralSurgery.getText(), "Oral Surgery Adult");
        softAssert.assertEquals(getTxtRootCanalAdult.getText(), "Root canal therapy Adult");
        softAssert.assertAll();
    }
    public void validateOutNetworkDental(){
        basicActions.waitForElementToBePresent( outNetworkDentalLink,15 );
        softAssert.assertEquals( txtHighlights.getText(),"Highlights" );
        softAssert.assertEquals( txtPlanDocuments.getText(),"Plan Documents" );
        softAssert.assertEquals(txtDentalDiagnosticChild.getText(), "Diagnostic and Preventive Services Child");
        basicActions.click( txtDentalDiagnosticChild );
        softAssert.assertEquals(getTxtCleaningChild.getText(), "Cleaning Child");
        softAssert.assertEquals(getTxtFlourideTreatmentChild.getText(), "Flouride Treatments Child");
        softAssert.assertEquals(getTxtOralExamsChild.getText(), "Oral Exams Child");
        softAssert.assertEquals(getTxtXrayChild.getText(), "X-rays Child");

        softAssert.assertEquals(txtDentalDiagnosticAdult .getText(), "Diagnostic and Preventive Services Adult");
        basicActions.click( txtDentalDiagnosticAdult );
        softAssert.assertEquals(getTxtCleaningAdult .getText(), "Cleaning Adult");
        softAssert.assertEquals(getTxtOralExamsAdult .getText(), "Oral Exams Adult");
        softAssert.assertEquals(getTxtXrayAdult .getText(), "X-rays Adult");

        softAssert.assertEquals(txtDentalBasicServicesChild.getText(), "Basic Services Child");
        basicActions.click( txtDentalBasicServicesChild );
        softAssert.assertEquals(getTxtAmalgamChild.getText(), "Amalgam (Steel) Fillings Child");
        softAssert.assertEquals(getTxtPeridonticsChild.getText(), "Periodontics - Other Child");
        softAssert.assertEquals(getTxtResinChild.getText(), "Resin (white plastic) Fillings Child");
        softAssert.assertEquals(getTxtSedativeChild.getText(), "Sedative Fillings Child");

        softAssert.assertEquals(txtDentalBasicServicesAdult.getText(), "Basic Services Adult");
        basicActions.click( txtDentalBasicServicesAdult );
        softAssert.assertEquals(getTxtAmalgamAdult.getText(), "Amalgam (Steel) Fillings Adult");
        softAssert.assertEquals(getTxtPeridonticsAdult.getText(), "Periodontics - Other Adult");
        softAssert.assertEquals(getTxtSedativeAdult.getText(), "Sedative Fillings Adult");

        softAssert.assertEquals(txtDentalMajorServicesChild.getText(), "Major Services Child");
        basicActions.click( txtDentalMajorServicesChild );
        softAssert.assertEquals(getTxtDenturesChild.getText(), "Dentures and Bridges Child");
        softAssert.assertEquals(getTxtImplantsChild.getText(), "Implants Child");
        softAssert.assertEquals(getTxtOrthodontiaChild.getText(), "Medically Necessary Orthodontia Child");
        softAssert.assertEquals(getTxtOralChild.getText(), "Oral Surgery Child");
        softAssert.assertEquals(getTxtRootCanalChild.getText(), "Root canal therapy Child");

        softAssert.assertEquals(txtDentalMajorServicesAdult.getText(), "Major Services Adult");
        basicActions.click( txtDentalMajorServicesAdult );
        softAssert.assertEquals(getTxtDenturesAdult.getText(), "Dentures and Bridges Adult");
        softAssert.assertEquals(getTxtImplantsAdult.getText(), "Implants Adult");
        softAssert.assertEquals(getTxtOralSurgery.getText(), "Oral Surgery Adult");
        softAssert.assertEquals(getTxtRootCanalAdult.getText(), "Root canal therapy Adult");
        softAssert.assertAll();


    }


}
