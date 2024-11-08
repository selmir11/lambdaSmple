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


    @FindBy(xpath = "//td[normalize-space()='Cleaning Child']")
    WebElement txtCleaningChild;
    @FindBy(xpath = "//td[normalize-space()='Limpieza para un hijo']")
    WebElement txtCleaningChildSP;

    @FindBy(xpath = " //td[normalize-space()='Fluoride Treatments Child']")
    WebElement txtFlourideChild;
    @FindBy(xpath = " //td[normalize-space()='Tratamientos con fluoruro para un hijo']")
    WebElement txtFlourideChildSP;

    @FindBy(xpath = " //td[normalize-space()='Oral Exams Child']")
    WebElement txtOralExamsChild;
    @FindBy(xpath = " //td[normalize-space()='Exámenes bucales para un hijo']")
    WebElement txtOralExamsChildSP;

    @FindBy(xpath = " //td[normalize-space()='X-rays Child']")
    WebElement txtXraysChild;
    @FindBy(xpath = " //td[normalize-space()='Radiografías para un hijo']")
    WebElement txtXraysChildSP;

    @FindBy(id = "ngb-accordion-item-2-toggle")
    WebElement txtInDiagnosticAdult;

    @FindBy(xpath = " //td[normalize-space()='Cleaning Adult']")
    WebElement txtCleaningAdult;
    @FindBy(xpath = " //td[normalize-space()='Limpiezas para un adulto']")
    WebElement txtCleaningAdultSP;

    @FindBy(xpath = " //td[normalize-space()='Oral Exams Adult']")
    WebElement txtOralExamsAdult;
    @FindBy(xpath = " //td[normalize-space()='Exámenes bucales para un adulto']")
    WebElement txtOralExamsAdultSP;

    @FindBy(xpath = " //td[normalize-space()='X-rays Adult']")
    WebElement txtXraysAdult;
    @FindBy(xpath = " //td[normalize-space()='Radiografías para un adulto']")
    WebElement txtXraysAdultSP;
    //
    @FindBy(id = "ngb-accordion-item-3-toggle")
    WebElement txtInBasicServicesChild;

    @FindBy(xpath = "//td[normalize-space()='Amalgam (Steel) Fillings Child']")
    WebElement txtAmalgamChild;
    @FindBy(xpath = "//td[normalize-space()='Empastes de amalgama (acero) para un hijo']")
    WebElement txtAmalgamChildSP;

    @FindBy(xpath = "//td[normalize-space()='Periodontics - Other Child']")
    WebElement txtPeriodonticsChild;
    @FindBy(xpath = " //td[normalize-space()='Periodoncia para otro hijo']")
    WebElement txtPeriodonticsChildSP;

    @FindBy(xpath = " //td[normalize-space()='Resin (white plastic) Fillings Child']")
    WebElement txtResinChild;
    @FindBy(xpath = "//td[normalize-space()='Empastes de resina (plástico blanco) para un hijo']")
    WebElement txtResinChildSP;


    @FindBy(xpath = "//td[normalize-space()='Sedative Fillings Child']")
    WebElement txtSedativeFluidChild;
    @FindBy(xpath = "//td[normalize-space()='Empastes con sedación para un hijo']")
    WebElement txtSedativeFluidChildSP;


    @FindBy(id = "ngb-accordion-item-4-toggle")
    WebElement txtInBasicServicesAdult;


    @FindBy(xpath = " //td[normalize-space()='Amalgam (Steel) Fillings Adult']")
    WebElement txtAmalgamAdult;
    @FindBy(xpath = "//td[normalize-space()='Empastes de amalgama (acero) para un adulto']")
    WebElement txtAmalgamAdultSP;

    @FindBy(xpath = " //td[normalize-space()='Periodontics - Other Adult']")
    WebElement txtPeriodonticsAdult;
    @FindBy(xpath = " //td[normalize-space()='Periodoncia para otro adulto']")
    WebElement txtPeriodonticsAdultSP;

    @FindBy(xpath = "//td[normalize-space()='Sedative Fillings Adult']")
    WebElement txtSedativeFluidAdult;
    @FindBy(xpath = " //td[normalize-space()='Empastes con sedación para un adulto']")
    WebElement txtSedativeFluidAdultSP;
    //

    @FindBy(id = "ngb-accordion-item-5-toggle")
    WebElement txtInMajorServicesChild;

    @FindBy(xpath = "  //td[normalize-space()='Dentures and Bridges Child']")
    WebElement txtDenturesChild;
    @FindBy(xpath = "  //td[normalize-space()='Dentaduras y puentes para un hijo']")
    WebElement txtDenturesChildSP;

    @FindBy(xpath = " //td[normalize-space()='Implants Child']")
    WebElement txtImplantsChild;
    @FindBy(xpath = " //td[normalize-space()='Implantes para un hijo']")
    WebElement txtImplantsChildSP;

    @FindBy(xpath = "  //td[normalize-space()='Medically Necessary Orthodontia Child']")
    WebElement txtOrthodontiaChild;
    @FindBy(xpath = "  //td[normalize-space()='Ortodoncia medicamente necesaria para un hijo']")
    WebElement txtOrthodontiaChildSP;

    @FindBy(xpath = " //td[normalize-space()='Oral Surgery Child']")
    WebElement txtOralSurgeryChild;
    @FindBy(xpath = " //td[normalize-space()='Cirugía bucal para un hijo']")
    WebElement txtOralSurgeryChildSP;

    @FindBy(xpath = " //td[normalize-space()='Root canal therapy Child']")
    WebElement txtRootCanalChild;
    @FindBy(xpath = " //td[normalize-space()='Terapia de endodoncia para un hijo']")
    WebElement txtRootCanalChildSP;
//
    @FindBy(id = "ngb-accordion-item-6-toggle")
    WebElement txtInMajorServicesAdult;

    @FindBy(xpath = " //td[normalize-space()='Dentures and Bridges Adult']")
    WebElement txtDenturesAdult;
    @FindBy(xpath = " //td[normalize-space()='Dentaduras y puentes para un adulto']")
    WebElement txtDenturesAdultSP;

    @FindBy(xpath = " //td[normalize-space()='Implants Adult']")
    WebElement txtImplantsAdult;
    @FindBy(xpath = " //td[normalize-space()='Implantes para un adulto']")
    WebElement txtImplantsAdultSP;

    @FindBy(xpath = " //td[normalize-space()='Oral Surgery Adult']")
     WebElement txtOralSurgeryAdult;
    @FindBy(xpath = " //td[normalize-space()='Cirugía bucal para un adulto']")
    WebElement txtOralSurgeryAdultSP;

    @FindBy(xpath = " //td[normalize-space()='Root canal therapy Adult']")
    WebElement txtRootCanalAdult;
    @FindBy(xpath = " //td[normalize-space()='Terapia de endodoncia para un adulto']")
    WebElement txtRootCanalAdultSP;
    //
    @FindBy(css = ".float-start")
    WebElement txtOutMonthlyPremium;

    @FindBy(id = "ngb-accordion-item-7-toggle")
    WebElement txtOutGeneralDetails;

    @FindBy(id = "ngb-accordion-item-8-toggle")
    WebElement txtOutDiagnosticChild;

    @FindBy(id = "ngb-accordion-item-9-toggle")
    WebElement txtOutDiagnosticAdult;

    @FindBy(id = "ngb-accordion-item-10-toggle")
    WebElement txtOutBasicServicesChild;

    @FindBy(id = "ngb-accordion-item-11-toggle")
    WebElement txtOutBasicServicesAdult;

    @FindBy(id = "ngb-accordion-item-12-toggle")
    WebElement txtOutMajorServicesChild;

    @FindBy(id = "ngb-accordion-item-13-toggle")
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

    public void validateInNetworkDentalDetailLanguage(String language) {
        basicActions.waitForElementToDisappear( spinner, 20 );
        switch (language) {
            case "English":
                validateEnglishInNetworkDentalDetail();
                break;
            case "Spanish":
                validateSpanishInNetworkDentalDetail();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );

        }
    }

     public void validateOutNetworkDentalDetailLanguage(String language){
            basicActions.waitForElementToDisappear( spinner, 20 );
            switch (language) {
                case "English":
                    validateEnglishOutNetworkDentalDetail();
                    break;
                case "Spanish":
                    validateSpanishOutNetworkDentalDetail();
                    break;
                default:
                    throw new IllegalArgumentException( "Invalid option: " + language );

         }
     }

     public void validateEnglishInNetworkDentalDetail() {
        basicActions.waitForElementToBePresent( txtDentalDisclaimer, 15 );
        softAssert.assertEquals( txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertEquals( txtInMonthlyPremium.getText(), "Monthly Premium" );

        basicActions.waitForElementToBePresentWithRetries(txtInGeneralDetails,30);
        softAssert.assertEquals( txtInGeneralDetails.getText(), "General Details" );
        txtInGeneralDetails.click();

        basicActions.waitForElementToBePresentWithRetries( txtInDiagnosticChild,30 );
        softAssert.assertEquals( txtInDiagnosticChild.getText(), "Diagnostic and Preventive Services Child" );
        txtInDiagnosticChild.click();

        softAssert.assertEquals( txtCleaningChild.getText(), "Cleaning Child");
        basicActions.isElementDisplayed( txtFlourideChild,20 );
        softAssert.assertEquals( txtOralExamsChild.getText(), "Oral Exams Child" );
        softAssert.assertEquals( txtXraysChild.getText(), "X-rays Child" );
         txtInDiagnosticChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtInDiagnosticAdult,30 );
        softAssert.assertEquals( txtInDiagnosticAdult.getText(), "Diagnostic and Preventive Services Adult" );
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdult.getText(), "Cleaning Adult" );
        softAssert.assertEquals( txtOralExamsAdult.getText(), "Oral Exams Adult" );
        softAssert.assertEquals( txtXraysAdult.getText(), "X-rays Adult" );
        txtInDiagnosticAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtInBasicServicesChild,30 );
        softAssert.assertEquals( txtInBasicServicesChild.getText(), "Basic Services Child" );
        txtInBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChild.getText(), "Amalgam (Steel) Fillings Child" );
        basicActions.isElementDisplayed( txtPeriodonticsChild,20 );
        softAssert.assertEquals( txtResinChild.getText(), "Resin (white plastic) Fillings Child" );
        softAssert.assertEquals( txtSedativeFluidChild.getText(), "Sedative Fillings Child" );
        txtInBasicServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtInBasicServicesAdult,30 );
        softAssert.assertEquals( txtInBasicServicesAdult.getText(), "Basic Services Adult" );
        txtInBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdult.getText(), "Amalgam (Steel) Fillings Adult" );
        softAssert.assertEquals( txtPeriodonticsAdult.getText(), "Periodontics - Other Adult" );
        softAssert.assertEquals( txtSedativeFluidAdult.getText(), "Sedative Fillings Adult" );
        txtInBasicServicesAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtInMajorServicesChild,30 );
        softAssert.assertEquals( txtInMajorServicesChild.getText(), "Major Services Child" );
        txtInMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChild.getText(), "Dentures and Bridges Child" );
        softAssert.assertEquals( txtImplantsChild.getText(), "Implants Child" );
        softAssert.assertEquals( txtOrthodontiaChild.getText(), "Medically Necessary Orthodontia Child" );
        softAssert.assertEquals( txtOralSurgeryChild.getText(), "Oral Surgery Child" );
        softAssert.assertEquals( txtRootCanalChild.getText(), "Root canal therapy Child" );
        txtInMajorServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtInMajorServicesAdult,30 );
        softAssert.assertEquals( txtInMajorServicesAdult.getText(), "Major Services Adult" );
        txtInMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdult.getText(), "Dentures and Bridges Adult" );
        softAssert.assertEquals( txtImplantsAdult.getText(), "Implants Adult" );
        softAssert.assertEquals( txtOralSurgeryAdult.getText(), "Oral Surgery Adult" );
        softAssert.assertEquals( txtRootCanalAdult.getText(), "Root canal therapy Adult" );
        txtInMajorServicesAdult.click();
        softAssert.assertAll();
    }

    public void validateEnglishOutNetworkDentalDetail() {
        basicActions.waitForElementToBePresent( txtDentalDisclaimer, 15 );
        softAssert.assertEquals( txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertEquals( txtInMonthlyPremium.getText(), "Monthly Premium" );

        basicActions.waitForElementToBePresentWithRetries( txtOutGeneralDetails,30 );
        softAssert.assertEquals( txtOutGeneralDetails.getText(), "General Details" );
        txtOutGeneralDetails.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutDiagnosticChild,30 );
        softAssert.assertEquals( txtOutDiagnosticChild.getText(), "Diagnostic and Preventive Services Child" );
        txtOutDiagnosticChild.click();

        softAssert.assertEquals( txtCleaningChild.getText(), "Cleaning Child");
        basicActions.isElementDisplayed( txtFlourideChild,20 );
        softAssert.assertEquals( txtOralExamsChild.getText(), "Oral Exams Child" );
        softAssert.assertEquals( txtXraysChild.getText(), "X-rays Child" );
        txtOutDiagnosticChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutDiagnosticAdult,30 );
        softAssert.assertEquals( txtOutDiagnosticAdult.getText(), "Diagnostic and Preventive Services Adult" );
        txtOutDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdult.getText(), "Cleaning Adult" );
        softAssert.assertEquals( txtOralExamsAdult.getText(), "Oral Exams Adult" );
        softAssert.assertEquals( txtXraysAdult.getText(), "X-rays Adult" );
        txtOutDiagnosticAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutBasicServicesChild,30 );
        softAssert.assertEquals( txtOutBasicServicesChild.getText(), "Basic Services Child" );
        txtOutBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChild.getText(), "Amalgam (Steel) Fillings Child" );
        basicActions.isElementDisplayed( txtPeriodonticsChild,20 );
        softAssert.assertEquals( txtResinChild.getText(), "Resin (white plastic) Fillings Child" );
        softAssert.assertEquals( txtSedativeFluidChild.getText(), "Sedative Fillings Child" );
        txtOutBasicServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutBasicServicesAdult,30 );
        softAssert.assertEquals( txtOutBasicServicesAdult.getText(), "Basic Services Adult" );
        txtOutBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdult.getText(), "Amalgam (Steel) Fillings Adult" );
        softAssert.assertEquals( txtPeriodonticsAdult.getText(), "Periodontics - Other Adult" );
        softAssert.assertEquals( txtSedativeFluidAdult.getText(), "Sedative Fillings Adult" );
        txtOutBasicServicesAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutMajorServicesChild,30 );
        softAssert.assertEquals( txtOutMajorServicesChild.getText(), "Major Services Child" );
        txtOutMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChild.getText(), "Dentures and Bridges Child" );
        softAssert.assertEquals( txtImplantsChild.getText(), "Implants Child" );
        softAssert.assertEquals( txtOrthodontiaChild.getText(), "Medically Necessary Orthodontia Child" );
        softAssert.assertEquals( txtOralSurgeryChild.getText(), "Oral Surgery Child" );
        softAssert.assertEquals( txtRootCanalChild.getText(), "Root canal therapy Child" );
        txtOutMajorServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutMajorServicesAdult,30 );
        softAssert.assertEquals( txtOutMajorServicesAdult.getText(), "Major Services Adult" );
        txtOutMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdult.getText(), "Dentures and Bridges Adult" );
        softAssert.assertEquals( txtImplantsAdult.getText(), "Implants Adult" );
        softAssert.assertEquals( txtOralSurgeryAdult.getText(), "Oral Surgery Adult" );
        softAssert.assertEquals( txtRootCanalAdult.getText(), "Root canal therapy Adult" );
        softAssert.assertAll();
        txtOutMajorServicesAdult.click();

    }

    public void validateSpanishInNetworkDentalDetail() {
        basicActions.waitForElementToBePresent( txtDentalDisclaimer, 15 );

        softAssert.assertEquals( txtDentalDisclaimer.getText(), "Es posible que algunos detalles y documentos del plan no est\u00E9n disponibles en espa\u00F1ol. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la informaci\u00F3n m\u00E1s completa y precisa." );
        softAssert.assertEquals( txtInMonthlyPremium.getText(), "Prima mensual" );

        softAssert.assertEquals( txtInGeneralDetails.getText(), "Detalles generales" );
        txtInGeneralDetails.click();

        basicActions.waitForElementToBePresentWithRetries( txtInDiagnosticChild,30 );
        softAssert.assertEquals( txtInDiagnosticChild.getText(), "Servicios diagn\u00F3sticos y de atenci\u00F3n preventiva para un hijo" );
        txtInDiagnosticChild.click();

        softAssert.assertEquals( txtCleaningChildSP.getText(), "Limpieza para un hijo" );
        basicActions.isElementDisplayed( txtFlourideChildSP,20 );
        softAssert.assertEquals( txtOralExamsChildSP.getText(), "Exámenes bucales para un hijo" );
        softAssert.assertEquals( txtXraysChildSP.getText(), "Radiografías para un hijo" );
        txtInDiagnosticChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtInDiagnosticAdult,30 );
        softAssert.assertEquals( txtInDiagnosticAdult.getText(), "Servicios diagn\u00F3sticos y de atenci\u00F3n preventiva para un adulto" );
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdultSP.getText(), "Limpiezas para un adulto" );
        softAssert.assertEquals( txtOralExamsAdultSP.getText(), "Ex\u00E1menes bucales para un adulto" );
        softAssert.assertEquals( txtXraysAdultSP.getText(), "Radiograf\u00EDas para un adulto" );
        txtInDiagnosticAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtInBasicServicesChild,30 );
        softAssert.assertEquals( txtInBasicServicesChild.getText(), "Servicios b\u00E1sicos para un hijo" );
        txtInBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChildSP.getText(), "Empastes de amalgama (acero) para un hijo" );
        basicActions.isElementDisplayed( txtPeriodonticsChildSP,20 );
        softAssert.assertEquals( txtResinChildSP.getText(), "Empastes de resina (pl\u00E1stico blanco) para un hijo" );
        softAssert.assertEquals( txtSedativeFluidChildSP.getText(), "Empastes con sedación para un hijo" );
        txtInBasicServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtInBasicServicesAdult,30 );
        softAssert.assertEquals( txtInBasicServicesAdult.getText(), "Servicios b\u00E1sicos para un adulto" );
        txtInBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdultSP.getText(), "Empastes de amalgama (acero) para un adulto" );
        softAssert.assertEquals( txtPeriodonticsAdultSP.getText(), "Periodoncia para otro adulto" );
        softAssert.assertEquals( txtSedativeFluidAdultSP.getText(), "Empastes con sedaci\u00F3n para un adulto" );
        txtInBasicServicesAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtInMajorServicesChild,30 );
        softAssert.assertEquals( txtInMajorServicesChild.getText(), "Servicios especializados para un hijo" );
        txtInMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChildSP.getText(), "Dentaduras y puentes para un hijo" );
        softAssert.assertEquals( txtImplantsChildSP.getText(), "Implantes para un hijo" );
        softAssert.assertEquals( txtOrthodontiaChildSP.getText(), "Ortodoncia medicamente necesaria para un hijo" );
        softAssert.assertEquals( txtOralSurgeryChildSP.getText(), "Cirugía bucal para un hijo" );
        softAssert.assertEquals( txtRootCanalChildSP.getText(), "Terapia de endodoncia para un hijo" );
        txtInMajorServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtInMajorServicesAdult,30 );
        softAssert.assertEquals( txtInMajorServicesAdult.getText(), "Servicios especializados para un adulto" );
        txtInMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdultSP.getText(), "Dentaduras y puentes para un adulto" );
        softAssert.assertEquals( txtImplantsAdultSP.getText(), "Implantes para un adulto" );
        softAssert.assertEquals( txtOralSurgeryAdultSP.getText(), "Cirug\u00EDa bucal para un adulto" );
        softAssert.assertEquals( txtRootCanalAdultSP.getText(), "Terapia de endodoncia para un adulto" );
        txtInMajorServicesAdult.click();
        softAssert.assertAll();
    }

    public void validateSpanishOutNetworkDentalDetail() {
        basicActions.waitForElementToBePresent( txtDentalDisclaimer, 15 );

        softAssert.assertEquals( txtDentalDisclaimer.getText(), "Es posible que algunos detalles y documentos del plan no est\u00E9n disponibles en espa\u00F1ol. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la informaci\u00F3n m\u00E1s completa y precisa." );
        softAssert.assertEquals( txtInMonthlyPremium.getText(), "Prima mensual" );

        softAssert.assertEquals( txtOutGeneralDetails.getText(), "Detalles generales" );
        txtOutGeneralDetails.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutDiagnosticChild,30 );
        softAssert.assertEquals( txtOutDiagnosticChild.getText(), "Servicios diagn\u00F3sticos y de atenci\u00F3n preventiva para un hijo" );
        txtOutDiagnosticChild.click();

        softAssert.assertEquals( txtCleaningChildSP.getText(), "Limpieza para un hijo" );
        basicActions.isElementDisplayed( txtFlourideChildSP,20 );
        softAssert.assertEquals( txtOralExamsChildSP.getText(), "Exámenes bucales para un hijo" );
        softAssert.assertEquals( txtXraysChildSP.getText(), "Radiografías para un hijo" );
        txtOutDiagnosticChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutDiagnosticAdult,30 );
        softAssert.assertEquals( txtOutDiagnosticAdult.getText(), "Servicios diagn\u00F3sticos y de atenci\u00F3n preventiva para un adulto" );
        txtOutDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdultSP.getText(), "Limpiezas para un adulto" );
        softAssert.assertEquals( txtOralExamsAdultSP.getText(), "Ex\u00E1menes bucales para un adulto" );
        softAssert.assertEquals( txtXraysAdultSP.getText(), "Radiograf\u00EDas para un adulto" );
        txtOutDiagnosticAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutBasicServicesChild,30 );
        softAssert.assertEquals( txtOutBasicServicesChild.getText(), "Servicios b\u00E1sicos para un hijo" );
        txtOutBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChildSP.getText(), "Empastes de amalgama (acero) para un hijo" );
        basicActions.isElementDisplayed( txtPeriodonticsChildSP,20 );
        softAssert.assertEquals( txtResinChildSP.getText(), "Empastes de resina (pl\u00E1stico blanco) para un hijo" );
        softAssert.assertEquals( txtSedativeFluidChildSP.getText(), "Empastes con sedación para un hijo" );
        txtOutBasicServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutBasicServicesAdult,30 );
        softAssert.assertEquals( txtOutBasicServicesAdult.getText(), "Servicios b\u00E1sicos para un adulto" );
        txtOutBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdultSP.getText(), "Empastes de amalgama (acero) para un adulto" );
        softAssert.assertEquals( txtPeriodonticsAdultSP.getText(), "Periodoncia para otro adulto" );
        softAssert.assertEquals( txtSedativeFluidAdultSP.getText(), "Empastes con sedaci\u00F3n para un adulto" );
        txtOutBasicServicesAdult.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutMajorServicesChild,30 );
        softAssert.assertEquals( txtOutMajorServicesChild.getText(), "Servicios especializados para un hijo" );
        txtOutMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChildSP.getText(), "Dentaduras y puentes para un hijo" );
        softAssert.assertEquals( txtImplantsChildSP.getText(), "Implantes para un hijo" );
        softAssert.assertEquals( txtOrthodontiaChildSP.getText(), "Ortodoncia medicamente necesaria para un hijo" );
        softAssert.assertEquals( txtOralSurgeryChildSP.getText(), "Cirugía bucal para un hijo" );
        softAssert.assertEquals( txtRootCanalChildSP.getText(), "Terapia de endodoncia para un hijo" );
        txtOutMajorServicesChild.click();

        basicActions.waitForElementToBePresentWithRetries( txtOutMajorServicesAdult,30 );
        softAssert.assertEquals( txtOutMajorServicesAdult.getText(), "Servicios especializados para un adulto" );
        txtOutMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdultSP.getText(), "Dentaduras y puentes para un adulto" );
        softAssert.assertEquals( txtImplantsAdultSP.getText(), "Implantes para un adulto" );
        softAssert.assertEquals( txtOralSurgeryAdultSP.getText(), "Cirug\u00EDa bucal para un adulto" );
        softAssert.assertEquals( txtRootCanalAdultSP.getText(), "Terapia de endodoncia para un adulto" );
        txtOutMajorServicesAdult.click();
        softAssert.assertAll();
    }
        }