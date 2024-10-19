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

    @FindBy(xpath = "//td[normalize-space()='Fluoride Treatments Child']")
    WebElement txtFlourideChild;

    @FindBy(xpath = "//td[normalize-space()='Oral Exams Child']")
    WebElement txtOralExamsChild;

    @FindBy(xpath = "//td[normalize-space()='X-rays Child']")
    WebElement txtXraysChild;

    @FindBy(id = "ngb-accordion-item-2-toggle")
    WebElement txtInDiagnosticAdult;

    @FindBy(xpath = " //*[contains(text(),\\\"Cleaning Adult\\\")]")
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

    @FindBy(xpath = " //*[contains(text(),\"Cleaning Child\")]")
    WebElement txtCleaningChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Child\\\")]\")")
    WebElement txtFlourideChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Child\\\")]\")")
    WebElement txtOralExamsChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Child\\\")]\")")
    WebElement txtXraysChildSpanish;

    @FindBy(id = "ngb-accordion-item-2-toggle")
    WebElement txtInDiagnosticAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Cleaning Adult\\\")]\")")
    WebElement txtCleaningAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Oral Exams Adult\\\")]\")")
    WebElement txtOralExamsAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"X-rays Adult\\\")]\")")
    WebElement txtXraysAdultSpanish;
    //
    @FindBy(id = "ngb-accordion-item-3-toggle")
    WebElement txtInBasicServicesChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Amalgam (Steel) Fillings Child\\\")]\")")
    WebElement txtAmalgamChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Periodontics - Other Child\\\")]\")")
    WebElement txtPeriodonticsChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Resin (white plastic) Fillings Child\\\")]\")")
    WebElement txtResinChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Sedative Fillings Child\\\")]\")")
    WebElement txtSedativeFluidChildSpanish;

    @FindBy(id = "ngb-accordion-item-4-toggle")
    WebElement txtInBasicServicesAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Amalgam (Steel) Fillings Adult\\\")]\")")
    WebElement txtAmalgamAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Periodontics - Other Adult\\\")]\")")
    WebElement txtPeriodonticsAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Sedative Fillings Adult\\\")]\")")
    WebElement txtSedativeFluidAdultSpanish;
    //

    @FindBy(id = "ngb-accordion-item-5-toggle")
    WebElement txtInMajorServicesChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Dentures and Bridges Child\\\")]\")")
    WebElement txtDenturesChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Implants Child\\\")]\")")
    WebElement txtImplantsChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Medically Necessary Orthodontia Child\\\")]\")")
    WebElement txtOrthodontiaChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Oral Surgery Child\\\")]\")")
    WebElement txtOralSurgeryChildSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Root canal therapy Child\\\")]\")")
    WebElement txtRootCanalChildSpanish;
    //
    @FindBy(id = "ngb-accordion-item-6-toggle")
    WebElement txtInMajorServicesAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Dentures and Bridges Adult\\\")]\")")
    WebElement txtDenturesAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Implants Adult\\\")]\")")
    WebElement txtImplantsAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Medically Necessary Orthodontia Adult\\\")]\")")
    WebElement txtOrthodontiaAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Oral Surgery Adult\\\")]\")")
    WebElement txtOralSurgeryAdultSpanish;

    @FindBy(xpath = " \"//*[contains(text(),\\\"Root canal therapy Adult\\\")]\")")
    WebElement txtRootCanalAdultSpanish;
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

    public void clickSpanishInNetworkDental() {
        basicActions.waitForElementToBeClickable(inNetworkDentalDetailLink,15 );
        inNetworkDentalDetailLink.click();}


    public void clickOutNetworkDental() {
        basicActions.waitForElementToBeClickable(outNetworkDentalDetailLink, 15 );
        outNetworkDentalDetailLink.click();}

    public void clickOutNetworkDentalSpanish() {
        basicActions.waitForElementToBeClickable(outNetworkDentalDetailLink, 15 );
        outNetworkDentalDetailLink.click();}

    public void validateInNetworkDentalDetailEnglish(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals(txtDentalDisclaimer.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertEquals(txtInMonthlyPremium.getText(), "Monthly Premium");
        softAssert.assertEquals(txtInGeneralDetails.getText(), "General Details");
        softAssert.assertEquals(txtInDiagnosticChild.getText(), "Diagnostic and Preventive Services Child");
        txtInGeneralDetails.click();
        txtInDiagnosticChild.click();
        // assertions not working here  - review
        //softAssert.assertEquals( subheader.get(1).getText(), "Cleaning Child" );
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
    public void validateOutNetworkDentalDetailEnglish(){
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

    public void validateInNetworkDentalDetailSpanish(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals(txtDentalDisclaimer.getText(), "Es posible que algunos detalles y documentos del plan no est\u00e9n disponibles en español. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la informaci\u00f3n más completa y precisa." );
        softAssert.assertEquals(txtInMonthlyPremium.getText(), "Prima mensual");
        softAssert.assertEquals(txtInGeneralDetails.getText(), "Detalles generales");
        txtInGeneralDetails.click();
        softAssert.assertEquals(txtInDiagnosticChild.getText(), "Servicios diagn\u00f3sticos y de atenci\u00f3n preventiva para un hijo");
        txtInDiagnosticChild.click();
        softAssert.assertEquals( txtCleaningChild.getText(), "Limpieza para un hijo" );
        softAssert.assertEquals( txtFlourideChild.getText(), "Tratamientos con fluoruro para un hijo" );
        softAssert.assertEquals( txtOralExamsChild.getText(), "Ex\u00e1menes bucales para un hijo");
        softAssert.assertEquals( txtXraysChild.getText(),"Radiografís para un hijo" );
        txtInDiagnosticChild.click();
        softAssert.assertEquals(txtInDiagnosticAdult.getText(), "Servicios diagn\u00f3sticos y de atenci\u00f3n preventiva para un adulto");
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdult.getText(), "Limpiezas para un adulto" );
        softAssert.assertEquals( txtOralExamsAdult.getText(), "Ex\u00e1menes bucales para un adulto");
        softAssert.assertEquals(txtXraysAdult.getText(), "Radiografías para un adulto");
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtInBasicServicesChild.getText(),"Servicios b\u00e1sicos para un hijo" );
        txtInBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChild.getText(), "Empastes de amalgama (acero) para un hijo" );
        softAssert.assertEquals( txtPeriodonticsChild.getText(), "Periodoncia para otro hijo" );
        softAssert.assertEquals( txtResinChild.getText(), "Empastes de resina (pl\u00e1stico blanco) para un hijo");
        softAssert.assertEquals( txtSedativeFluidChild.getText(),"Empastes con sedaci\u00f3n para un hijo" );
        txtInBasicServicesChild.click();
        softAssert.assertEquals(txtInBasicServicesAdult.getText(), "Servicios b\u00e1sicos para un adulto");
        txtInBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdult.getText(), "Empastes de amalgama (acero) para un adulto" );
        softAssert.assertEquals( txtPeriodonticsAdult.getText(), "Periodoncia para otro adulto" );
        softAssert.assertEquals( txtSedativeFluidAdult.getText(),"Empastes con sedaci\u00f3n para un adulto" );
        txtInBasicServicesAdult.click();
        softAssert.assertEquals(txtInMajorServicesChild.getText(), "Servicios especializados para un hijo");
        txtInMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChild.getText(),"Dentaduras y puentes para un hijo" );
        softAssert.assertEquals( txtImplantsChild.getText(),"Implantes para un hijo" );
        softAssert.assertEquals( txtOrthodontiaChild.getText(),"Ortodoncia medicamente necesaria para un hijo" );
        softAssert.assertEquals( txtOralSurgeryChild.getText(),"Cirugía bucal para un hijo" );
        softAssert.assertEquals( txtRootCanalChild.getText(),"Terapia de endodoncia para un hijo" );
        txtInMajorServicesChild.click();
        softAssert.assertEquals(txtInMajorServicesAdult.getText(), "Servicios especializados para un adulto");
        txtInMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdult.getText(),"Dentaduras y puentes para un adulto" );
        softAssert.assertEquals( txtImplantsAdult.getText(),"Implantes para un adulto" );
        softAssert.assertEquals( txtOrthodontiaAdult.getText(),"Cirugía bucal para un adulto" );
        softAssert.assertEquals( txtOralSurgeryAdult.getText(),"Terapia de endodoncia para un adulto" );
        txtInMajorServicesAdult.click();
        softAssert.assertAll();
    }
    public void validateOutNetworkDentalDetailSpanish(){
        basicActions.waitForElementToBePresent( txtDentalDisclaimer,15 );
        softAssert.assertEquals(txtDentalDisclaimer.getText(), "Es posible que algunos detalles y documentos del plan no est\u00e9n disponibles en español. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la informaci\u00f3n más completa y precisa." );
        softAssert.assertEquals(txtInMonthlyPremium.getText(), "Prima mensual");
        softAssert.assertEquals(txtInGeneralDetails.getText(), "Detalles generales");
        txtInGeneralDetails.click();
        softAssert.assertEquals(txtInDiagnosticChild.getText(), "Servicios diagn\u00f3sticos y de atenci\u00f3n preventiva para un hijo");
        txtInDiagnosticChild.click();
        softAssert.assertEquals( txtCleaningChild.getText(), "Limpieza para un hijo" );
        softAssert.assertEquals( txtFlourideChild.getText(), "Tratamientos con fluoruro para un hijo" );
        softAssert.assertEquals( txtOralExamsChild.getText(), "Ex\u00e1menes bucales para un hijo");
        softAssert.assertEquals( txtXraysChild.getText(),"Radiografís para un hijo" );
        txtInDiagnosticChild.click();
        softAssert.assertEquals(txtInDiagnosticAdult.getText(), "Servicios diagn\u00f3sticos y de atenci\u00f3n preventiva para un adulto");
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtCleaningAdult.getText(), "Limpiezas para un adulto" );
        softAssert.assertEquals( txtOralExamsAdult.getText(), "Ex\u00e1menes bucales para un adulto");
        softAssert.assertEquals(txtXraysAdult.getText(), "Radiografías para un adulto");
        txtInDiagnosticAdult.click();
        softAssert.assertEquals( txtInBasicServicesChild.getText(),"Servicios b\u00e1sicos para un hijo" );
        txtInBasicServicesChild.click();
        softAssert.assertEquals( txtAmalgamChild.getText(), "Empastes de amalgama (acero) para un hijo" );
        softAssert.assertEquals( txtPeriodonticsChild.getText(), "Periodoncia para otro hijo" );
        softAssert.assertEquals( txtResinChild.getText(), "Empastes de resina (pl\u00e1stico blanco) para un hijo");
        softAssert.assertEquals( txtSedativeFluidChild.getText(),"Empastes con sedaci\u00f3n para un hijo" );
        txtInBasicServicesChild.click();
        softAssert.assertEquals(txtInBasicServicesAdult.getText(), "Servicios b\u00e1sicos para un adulto");
        txtInBasicServicesAdult.click();
        softAssert.assertEquals( txtAmalgamAdult.getText(), "Empastes de amalgama (acero) para un adulto" );
        softAssert.assertEquals( txtPeriodonticsAdult.getText(), "Periodoncia para otro adulto" );
        softAssert.assertEquals( txtSedativeFluidAdult.getText(),"Empastes con sedaci\u00f3n para un adulto" );
        txtInBasicServicesAdult.click();
        softAssert.assertEquals(txtInMajorServicesChild.getText(), "Servicios especializados para un hijo");
        txtInMajorServicesChild.click();
        softAssert.assertEquals( txtDenturesChild.getText(),"Dentaduras y puentes para un hijo" );
        softAssert.assertEquals( txtImplantsChild.getText(),"Implantes para un hijo" );
        softAssert.assertEquals( txtOrthodontiaChild.getText(),"Ortodoncia medicamente necesaria para un hijo" );
        softAssert.assertEquals( txtOralSurgeryChild.getText(),"Cirugía bucal para un hijo" );
        softAssert.assertEquals( txtRootCanalChild.getText(),"Terapia de endodoncia para un hijo" );
        txtInMajorServicesChild.click();
        softAssert.assertEquals(txtInMajorServicesAdult.getText(), "Servicios especializados para un adulto");
        txtInMajorServicesAdult.click();
        softAssert.assertEquals( txtDenturesAdult.getText(),"Dentaduras y puentes para un adulto" );
        softAssert.assertEquals( txtImplantsAdult.getText(),"Implantes para un adulto" );
        softAssert.assertEquals( txtOrthodontiaAdult.getText(),"Cirugía bucal para un adulto" );
        softAssert.assertEquals( txtOralSurgeryAdult.getText(),"Terapia de endodoncia para un adulto" );
        txtInMajorServicesAdult.click();
        softAssert.assertAll();}


}
