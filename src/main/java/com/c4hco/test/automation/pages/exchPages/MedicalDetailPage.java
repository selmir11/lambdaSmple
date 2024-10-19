package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Optional;
public class MedicalDetailPage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();
    private Optional<Integer> optionalInt;

    public MedicalDetailPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );


    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;
    @FindBy(id = "MedicalPlanCarrierDetails-SelectThisPlan")
    WebElement selectPlan;

    @FindBy(id =  "MedicalPlanCarrierDetails-RemovePlan")
    WebElement RemovePlan;

    @FindBy(id= "MedicalCarrierDetails-GoBacktoPlans")
    WebElement goBackDetail;

    @FindBy(id = "MedicalCarrierDetails-medicalPCDetailesPDF")
    WebElement pdfDetailSummary;

    @FindBy(id = "MedicalCarrierDetails-PreferredDrugList")
    WebElement lnkDrugList;

    @FindBy(id = "MedicalCarrierDetails-ProviderNetwork")
    WebElement lnkProviderList;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_0")
    WebElement lnkSummaryBenefitsEnglish;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_1")
    WebElement lnkQualityOverviewEnglish;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_2")
    WebElement lnkProviderNetwork;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_3")
    WebElement lnkBrochureHealthEnglish;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_4")
    WebElement lnkQualityOverviewSpanish;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_5")
    WebElement lnkSummaryBenefitsSpanish;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_6")
    WebElement lnkEvidenceCoverageEnglish;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_7")
    WebElement lnkSummaryBenefitsSupplementEnglish;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_8")
    WebElement lnkEvidenceCoverageSpanish;
    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_9")
    WebElement lnkSummaryBenefitsSupplementSpanish;

    @FindBy(css = "#MedicalCarrierDetails-InNetworkTier1")
    WebElement inNetwork1;

    @FindBy(css = "#MedicalCarrierDetails-OutOfNetwork")
    WebElement outNetwork;

    @FindBy(xpath = "//div[@class = 'disclaimer body-text-2']")
    WebElement disclaimerEnglishDetail;

    @FindBy(xpath = "//div[@class = 'disclaimer body-text-2']")
    WebElement disclaimerSpanishDetail;
    @FindBy(xpath = "//*[@div =  'MedicalCarrierDetails-MoreInformation']")
    WebElement headerInfoEnglish;

    //

    @FindBy(xpath = "//*[@div =  'MedicalCarrierDetails-MoreInformation']")
    WebElement headerInfoSpanish;

    @FindBy(xpath = "//*[@div =  'MedicalCarrierDetails-PlanDocuments']")
    WebElement headerDocEnglish;

    @FindBy(xpath = "//*[@div =  'MedicalCarrierDetails-PlanDocuments']")
    WebElement headerDocSpanish;

    @FindBy(id = "ngb-accordion-item-0-toggle")
    WebElement inOneHeader;

    @FindBy(id = "ngb-accordion-item-1-toggle")
    WebElement inTwoHeader;

    @FindBy(id = "ngb-accordion-item-2-toggle")
    WebElement inThreeHeader;

    @FindBy(id = "ngb-accordion-item-3-toggle")
    WebElement inFourHeader;

    @FindBy(id = "ngb-accordion-item-4-toggle")
    WebElement inFiveHeader;

    @FindBy(id = "ngb-accordion-item-5-toggle")
    WebElement inSixHeader;

    @FindBy(id = "ngb-accordion-item-6-toggle")
    WebElement inSevenHeader;

    @FindBy(id = "ngb-accordion-item-7-toggle")
    WebElement inEightHeader;

    @FindBy(id = "ngb-accordion-item-8-toggle")
    WebElement inNineHeader;

    @FindBy(id = "ngb-accordion-item-9-toggle")
    WebElement inTenHeader;

    @FindBy(id = "ngb-accordion-item-10-toggle")
    WebElement inElevenHeader;

    @FindBy(id = "ngb-accordion-item-11-toggle")
    WebElement inTwelveHeader;


    @FindBy(id = "ngb-accordion-item-12-toggle")
    WebElement outOneHeader;

    @FindBy(id = "ngb-accordion-item-13-toggle")
    WebElement outTwoHeader;

    @FindBy(id = "ngb-accordion-item-14-toggle")
    WebElement outThreeHeader;

    @FindBy(id = "ngb-accordion-item-15-toggle")
    WebElement outFourHeader;

    @FindBy(id = "ngb-accordion-item-16-toggle")
    WebElement outFiveHeader;

    @FindBy(id = "ngb-accordion-item-17-toggle")
    WebElement outSixHeader;

    @FindBy(id = "ngb-accordion-item-18-toggle")
    WebElement outSevenHeader;

    @FindBy(id = "ngb-accordion-item-19-toggle")
    WebElement outEightHeader;

    @FindBy(id = "ngb-accordion-item-20-toggle")
    WebElement outNineHeader;

    @FindBy(id = "ngb-accordion-item-21-toggle")
    WebElement outTenHeader;

    @FindBy(id = "ngb-accordion-item-22-toggle")
    WebElement outElevenHeader;

    @FindBy(id = "ngb-accordion-item-23-toggle")
    WebElement outTwelveHeader;



    public void validateEnglishTextHeadersInNetwork() {
        basicActions.waitForElementToBePresent(inOneHeader, 10);
        softAssert.assertEquals(inOneHeader.getText(), "General Details");
        softAssert.assertEquals(inTwoHeader.getText(), "Provider Office Visits");
        softAssert.assertEquals(inThreeHeader.getText(), "Prescription Drugs");
        softAssert.assertEquals(inFourHeader.getText(), "Facilities");
        softAssert.assertEquals(inFiveHeader.getText(), "Maternity");
        softAssert.assertEquals(inSixHeader.getText(), "Emergency Care");
        softAssert.assertEquals(inSevenHeader.getText(), "Mental Health Benefits");
        softAssert.assertEquals(inEightHeader.getText(), "Testing");
        softAssert.assertEquals(inNineHeader.getText(), "Medical Devices");
        softAssert.assertEquals(inTenHeader.getText(), "Habilitative and Rehabilitative Services");
        softAssert.assertEquals(inElevenHeader.getText(), "Home Care & Hospice");
        softAssert.assertEquals(inTwelveHeader.getText(), "Additional EHB Benefits");
        softAssert.assertAll();
    }

    public void validateEnglishTextHeadersOutNetwork() {
        basicActions.waitForElementToBePresent(outOneHeader, 10);
        softAssert.assertEquals(outOneHeader.getText(), "General Details");//id='ngb-accordion-item-0-toggle'
        softAssert.assertEquals(outTwoHeader.getText(), "Provider Office Visits");
        softAssert.assertEquals(outThreeHeader.getText(), "Prescription Drugs");
        softAssert.assertEquals(outFourHeader.getText(), "Facilities");
        softAssert.assertEquals(outFiveHeader.getText(), "Maternity");
        softAssert.assertEquals(outSixHeader.getText(), "Emergency Care");
        softAssert.assertEquals(outSevenHeader.getText(), "Mental Health Benefits");
        softAssert.assertEquals(outEightHeader.getText(), "Testing");
        softAssert.assertEquals(outNineHeader.getText(), "Medical Devices");
        softAssert.assertEquals(outTenHeader.getText(), "Habilitative and Rehabilitative Services");
        softAssert.assertEquals(outElevenHeader.getText(), "Home Care & Hospice");
        softAssert.assertEquals(outTwelveHeader.getText(), "Additional EHB Benefits");
        softAssert.assertAll();
    }

    public void validateEnglishPlanDocuments(){
        basicActions.waitForElementToBePresent( lnkDrugList,15 );
        headerInfoEnglish.isDisplayed();
        softAssert.assertEquals(headerInfoEnglish.getText(), "More Information on this Plan");
        lnkDrugList.isDisplayed();
        softAssert.assertEquals(lnkDrugList.getText(), "Preferred Drug List");
        lnkProviderList.isDisplayed();
        softAssert.assertEquals(lnkProviderList.getText(), "Provider Network");
        headerDocEnglish.isDisplayed();
        softAssert.assertEquals(headerDocEnglish.getText(), "Plan Documents");
        lnkSummaryBenefitsEnglish.isDisplayed();
        lnkQualityOverviewEnglish.isDisplayed();
        lnkProviderNetwork.isDisplayed();
        lnkBrochureHealthEnglish.isDisplayed();
        lnkQualityOverviewSpanish.isDisplayed();
        lnkSummaryBenefitsSpanish.isDisplayed();
        lnkEvidenceCoverageEnglish.isDisplayed();
        lnkSummaryBenefitsSupplementEnglish.isDisplayed();
        lnkEvidenceCoverageSpanish.isDisplayed();
        lnkSummaryBenefitsSupplementSpanish.isDisplayed();
        softAssert.assertAll();


    }


    public void clickPDFDetail(){
        basicActions.waitForElementToBePresent( pdfDetailSummary,15);
        softAssert.assertEquals(pdfDetailSummary.getText(), "Download PDF");
        softAssert.assertAll();
        pdfDetailSummary.click();
    }

    public void clickSelectPlan(){
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent( selectPlan, 15 );
        softAssert.assertEquals(selectPlan.getText(), "Select this Plan");
        softAssert.assertAll();
        selectPlan.click();
    }

    public void clickRemovePlan(){
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent( RemovePlan, 15 );
        softAssert.assertEquals(RemovePlan.getText(), "Remove Plan");
        softAssert.assertAll();
        RemovePlan.click();
    }

    public void clickGoBackDetail(){
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent( goBackDetail,15 );
        basicActions.scrollToElement( goBackDetail );
        softAssert.assertEquals(goBackDetail.getText(), "Go Back to Plans");
        softAssert.assertAll();
        goBackDetail.click();
    }



    public void clickInNetworkLink(){
        basicActions.waitForElementToBePresent( inNetwork1,15 );
        softAssert.assertEquals(inNetwork1.getText(), "In Network Tier 1");
        softAssert.assertAll();
        inNetwork1.click();
    }

    public void clickOutNetworkLink(){
        basicActions.waitForElementToBePresent( outNetwork, 15 );
        softAssert.assertEquals(outNetwork.getText(), "Out of Network");
        softAssert.assertAll();
        outNetwork.click();
    }

    public void validateDisclaimerDetail(){
        basicActions.waitForElementToBePresent( disclaimerEnglishDetail,15 );
        disclaimerEnglishDetail.isDisplayed();
        softAssert.assertEquals(disclaimerEnglishDetail.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information.");
        softAssert.assertAll();

    }

    public void clickSpanishSelectPlan(){
        basicActions.waitForElementToBePresent( selectPlan, 15 );
        //softAssert.assertEquals(selectPlan.getText(), "Seleccione este Plan");
        softAssert.assertSame(selectPlan.isDisplayed(), "Seleccione este Plan" );
        softAssert.assertAll();
        selectPlan.click();

    }

    public void clickSpanishPDFDetail(){
        basicActions.waitForElementToBePresent( pdfDetailSummary,15);
        softAssert.assertEquals(pdfDetailSummary.getText(), "Descargar PDF");
        softAssert.assertAll();
        pdfDetailSummary.click();
    }

    public void clickSpanishGoBackDetail(){
        basicActions.waitForElementToBePresent( goBackDetail,15 );
        basicActions.scrollToElement( goBackDetail );
        softAssert.assertEquals(goBackDetail.getText(), "Volver a Planes");
        softAssert.assertAll();
        goBackDetail.click();
    }
    public void clickSpanishInNetworkLink(){
        basicActions.waitForElementToBePresent( inNetwork1,15 );
        softAssert.assertEquals(inNetwork1.getText(), "Dentro la red Nivel 1");
        softAssert.assertAll();
        inNetwork1.click();
    }
    public void clickSpanishOutNetworkLink(){
        basicActions.waitForElementToBePresent( outNetwork, 15 );
        softAssert.assertEquals(outNetwork.getText(), "Fuera de la red");
        softAssert.assertAll();
        outNetwork.click();
    }
    public void validateSpanishDisclaimerText(){
        basicActions.scrollToElement(disclaimerSpanishDetail);
        basicActions.waitForElementToBePresent( disclaimerSpanishDetail,15 );
        disclaimerSpanishDetail.isDisplayed();
        softAssert.assertEquals(disclaimerSpanishDetail.getText(), "Es posible que algunos detalles y documentos del plan no est\u00e9n disponibles en espa\u00f1ol. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la informaci\u00f3n m\u00e1s completa y precisa.");
        softAssert.assertAll();
    }

    public void validateSpanishPlanDocuments(){
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent( lnkDrugList,15 );
        headerInfoSpanish.isDisplayed();
        softAssert.assertEquals(headerInfoSpanish.getText(), "Más información sobre este Plan");
        lnkDrugList.isDisplayed();
        softAssert.assertEquals(lnkDrugList.getText(), "Lista de medicamentos preferidos");
        lnkProviderList.isDisplayed();
        softAssert.assertEquals(lnkProviderList.getText(), "Red de proveedores");
        headerDocSpanish.isDisplayed();
        softAssert.assertEquals(headerDocSpanish.getText(), "Documentos del plan");
        lnkSummaryBenefitsEnglish.isDisplayed();
        lnkQualityOverviewEnglish.isDisplayed();
        lnkProviderNetwork.isDisplayed();
        lnkBrochureHealthEnglish.isDisplayed();
        lnkQualityOverviewSpanish.isDisplayed();
        lnkSummaryBenefitsSpanish.isDisplayed();
        lnkEvidenceCoverageEnglish.isDisplayed();
        lnkSummaryBenefitsSupplementEnglish.isDisplayed();
        lnkEvidenceCoverageSpanish.isDisplayed();
        lnkSummaryBenefitsSupplementSpanish.isDisplayed();
        softAssert.assertAll();


    }
    public void validateSpanishTextHeadersInNetwork() {
        basicActions.waitForElementToBePresent(inOneHeader, 10);
        basicActions.waitForElementToBePresent( lnkDrugList,15 );
        softAssert.assertEquals(inOneHeader.getText(), "Detalles generales");
        softAssert.assertEquals(inTwoHeader.getText(), "Consultas con proveedores");
        softAssert.assertEquals(inThreeHeader.getText(), "Medicamentos recetados");
        softAssert.assertEquals(inFourHeader.getText(), "Instalaciones");
        softAssert.assertEquals(inFiveHeader.getText(), "Maternidad");
        softAssert.assertEquals(inSixHeader.getText(), "Atenci\u00f3n de emergencia");
        softAssert.assertEquals(inSevenHeader.getText(), "Beneficios de salud mental");
        softAssert.assertEquals(inEightHeader.getText(), "Pruebas");
        softAssert.assertEquals(inNineHeader.getText(), "Dispositivos m\u00e9dicos");
        softAssert.assertEquals(inTenHeader.getText(), "Servicios de habilitaci\u00f3n y rehabilitaci\u00f3n");
        softAssert.assertEquals(inElevenHeader.getText(), "Atenci\u00f3n a domicilio y a pacientes con enfermedades terminales");
        softAssert.assertEquals(inTwelveHeader.getText(), "Beneficios esenciales");
        softAssert.assertAll();
    }

    public void validateSpanishTextHeadersOutNetwork() {
        basicActions.waitForElementToBePresent(outOneHeader, 10);
        softAssert.assertEquals(outOneHeader.getText(), "Detalles generales");//id='ngb-accordion-item-0-toggle'
        softAssert.assertEquals(outTwoHeader.getText(), "Consultas con proveedores");
        softAssert.assertEquals(outThreeHeader.getText(), "Medicamentos recetados");
        softAssert.assertEquals(outFourHeader.getText(), "Instalaciones");
        softAssert.assertEquals(outFiveHeader.getText(), "Maternidad");
        softAssert.assertEquals(outSixHeader.getText(), "Atenci\u00f3n de emergencia");
        softAssert.assertEquals(outSevenHeader.getText(), "Beneficios de salud mental");
        softAssert.assertEquals(outEightHeader.getText(), "Pruebas");
        softAssert.assertEquals(outNineHeader.getText(), "Dispositivos m\u00e9dicos");
        softAssert.assertEquals(outTenHeader.getText(), "Servicios de habilitaci\u00f3n y rehabilitaci\u00f3n");
        softAssert.assertEquals(outElevenHeader.getText(), "Atenci\u00f3n a domicilio y a pacientes con enfermedades terminales");
        softAssert.assertEquals(outTwelveHeader.getText(), "Beneficios esenciales");
        softAssert.assertAll();
    }
}
