package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.EligNotices;
import com.c4hco.test.automation.utils.PDF;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class MedicalDetailPage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();



    public MedicalDetailPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "MedicalPlanCarrierDetails-SelectThisPlan")
    WebElement selectPlan;

    @FindBy(id = "MedicalPlanCarrierDetails-RemovePlan")
    WebElement RemovePlan;

    @FindBy(id = "MedicalCarrierDetails-GoBacktoPlans")
    WebElement goBackDetail;

    @FindBy(id = "MedicalCarrierDetails-medicalPCDetailesPDF")
    WebElement pdfDetailSummary;

    @FindBy(id = "MedicalCarrierDetails-PreferredDrugList")
    WebElement lnkDrugList;

    @FindBy(id = "MedicalCarrierDetails-ProviderNetwork")
    WebElement lnkProviderList;

    // document link list

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_0")
    WebElement lnkDocument0;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_1")
    WebElement lnkDocument1;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_2")
    WebElement lnkDocument2;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_3")
    WebElement lnkDocument3;


    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_4")
    WebElement lnkDocument4;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_5")
    WebElement lnkDocument5;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_6")
    WebElement lnkDocument6;

    @FindBy(xpath = "//td[normalize-space()='Brochure Anthem Medical English']")
    WebElement linkDoc6Anthem;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_7")
    WebElement lnkDocument7;

    @FindBy(xpath = "//td[normalize-space()='Provider Network Anthem Pathway Essentials']")
    WebElement linkDoc7Anthem;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_8")
    WebElement lnkDocument8;

    @FindBy(xpath = "//td[normalize-space()='Quality Overview Anthem English']")
    WebElement linkDoc8Anthem;


    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_9")
    WebElement lnkDocument9;

    @FindBy(xpath = "//td[normalize-space()='Quality Overview Anthem Spanish']")
    WebElement linkDoc9Anthem;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_10")
    WebElement lnkDocument10;

    @FindBy(xpath = "//td[normalize-space()='Brochure Anthem Medical Spanish']")
    WebElement linkDoc10Anthem;


    @FindBy(css = "#MedicalCarrierDetails-InNetworkTier1")
    WebElement inNetwork1;

    @FindBy(css = "#MedicalCarrierDetails-OutOfNetwork")
    WebElement outNetwork;

    @FindBy(xpath = "//div[@class = 'disclaimer body-text-2']")
    WebElement disclaimerEnglishDetail;

    @FindBy(xpath = "//div[@class = 'disclaimer body-text-2']")
    WebElement disclaimerSpanishDetail;


    //

    @FindBy(id = "MedicalCarrierDetails-MoreInformation")
    WebElement headerInfoSpanish;

    @FindBy(id = "MedicalCarrierDetails-PlanDocuments")
    WebElement headerDocEnglish;

    @FindBy(id = "MedicalCarrierDetails-PlanDocuments")
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
        basicActions.waitForElementToBePresent( inOneHeader, 10 );
        softAssert.assertEquals( inOneHeader.getText(), "General Details" );
        softAssert.assertEquals( inTwoHeader.getText(), "Provider Office Visits" );
        softAssert.assertEquals( inThreeHeader.getText(), "Prescription Drugs" );
        softAssert.assertEquals( inFourHeader.getText(), "Facilities" );
        softAssert.assertEquals( inFiveHeader.getText(), "Maternity" );
        softAssert.assertEquals( inSixHeader.getText(), "Emergency Care" );
        softAssert.assertEquals( inSevenHeader.getText(), "Mental Health Benefits" );
        softAssert.assertEquals( inEightHeader.getText(), "Testing" );
        softAssert.assertEquals( inNineHeader.getText(), "Medical Devices" );
        softAssert.assertEquals( inTenHeader.getText(), "Habilitative and Rehabilitative Services" );
        softAssert.assertEquals( inElevenHeader.getText(), "Home Care & Hospice" );
        softAssert.assertEquals( inTwelveHeader.getText(), "Additional EHB Benefits" );
        softAssert.assertAll();
    }

    public void validateEnglishTextHeadersOutNetwork() {
        basicActions.waitForElementToBePresent( outOneHeader, 10 );
        softAssert.assertEquals( outOneHeader.getText(), "General Details" );
        softAssert.assertEquals( outTwoHeader.getText(), "Provider Office Visits" );
        softAssert.assertEquals( outThreeHeader.getText(), "Prescription Drugs" );
        softAssert.assertEquals( outFourHeader.getText(), "Facilities" );
        softAssert.assertEquals( outFiveHeader.getText(), "Maternity" );
        softAssert.assertEquals( outSixHeader.getText(), "Emergency Care" );
        softAssert.assertEquals( outSevenHeader.getText(), "Mental Health Benefits" );
        softAssert.assertEquals( outEightHeader.getText(), "Testing" );
        softAssert.assertEquals( outNineHeader.getText(), "Medical Devices" );
        softAssert.assertEquals( outTenHeader.getText(), "Habilitative and Rehabilitative Services" );
        softAssert.assertEquals( outElevenHeader.getText(), "Home Care & Hospice" );
        softAssert.assertEquals( outTwelveHeader.getText(), "Additional EHB Benefits" );
        softAssert.assertAll();
    }

    public void validateDocumentsNetworkLink() {
        basicActions.waitForElementToBePresent( spinner, 40 );
        basicActions.waitForElementToBePresentWithRetries( headerDocEnglish, 60 );
        softAssert.assertEquals( headerDocEnglish.getText(), "Plan Documents" );
        lnkDocument0.isDisplayed();
        lnkDocument1.isDisplayed();
        lnkDocument2.isDisplayed();
        lnkDocument3.isDisplayed();
        lnkDocument4.isDisplayed();
        lnkDocument5.isDisplayed();
        lnkDocument6.isDisplayed();
        lnkDocument7.isDisplayed();
        lnkDocument8.isDisplayed();
        softAssert.assertAll();

    }


    public void clickPDFDetail() {
        basicActions.waitForElementToBePresent( pdfDetailSummary, 15 );
        softAssert.assertEquals( pdfDetailSummary.getText(), "Download PDF" );
        softAssert.assertAll();
        pdfDetailSummary.click();
    }

    public void clickSelectPlan() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( selectPlan, 15 );
        softAssert.assertEquals( selectPlan.getText(), "Select this Plan" );
        softAssert.assertAll();
        selectPlan.click();
    }

    public void clickRemovePlan() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( RemovePlan, 15 );
        softAssert.assertEquals( RemovePlan.getText(), "Remove Plan" );
        softAssert.assertAll();
        RemovePlan.click();
    }

    public void clickGoBackDetail() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( goBackDetail, 15 );
        basicActions.scrollToElement( goBackDetail );
        softAssert.assertEquals( goBackDetail.getText(), "Go Back to Plans" );
        softAssert.assertAll();
        goBackDetail.click();
    }


    public void clickInNetworkLink() {
        basicActions.waitForElementToBePresent( inNetwork1, 15 );
        softAssert.assertEquals( inNetwork1.getText(), "In Network Tier 1" );
        softAssert.assertAll();
        inNetwork1.click();
    }

    public void clickOutNetworkLink() {
        basicActions.waitForElementToBePresent( outNetwork, 15 );
        softAssert.assertEquals( outNetwork.getText(), "Out of Network" );
        softAssert.assertAll();
        outNetwork.click();
    }

    public void validateDisclaimerDetail() {
        basicActions.waitForElementToBePresent( disclaimerEnglishDetail, 15 );
        disclaimerEnglishDetail.isDisplayed();
        softAssert.assertEquals( disclaimerEnglishDetail.getText(), "See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information." );
        softAssert.assertAll();

    }

    public void clickSpanishSelectPlan() {
        basicActions.waitForElementToBePresent( selectPlan, 15 );
        softAssert.assertSame( selectPlan.isDisplayed(), "Seleccione este Plan" );
        softAssert.assertAll();
        selectPlan.click();

    }

    public void clickSpanishPDFDetail() {
        basicActions.waitForElementToBePresent( pdfDetailSummary, 15 );
        softAssert.assertEquals( pdfDetailSummary.getText(), "Descargar PDF" );
        softAssert.assertAll();
        pdfDetailSummary.click();
    }

    public void clickSpanishGoBackDetail() {
        basicActions.waitForElementToBePresent( goBackDetail, 15 );
        basicActions.scrollToElement( goBackDetail );
        softAssert.assertEquals( goBackDetail.getText(), "Volver a Planes" );
        softAssert.assertAll();
        goBackDetail.click();
    }

    public void clickSpanishInNetworkLink() {
        basicActions.waitForElementToBePresent( inNetwork1, 15 );
        softAssert.assertEquals( inNetwork1.getText(), "Dentro la red Nivel 1" );
        softAssert.assertAll();
        inNetwork1.click();
    }

    public void clickSpanishOutNetworkLink() {
        basicActions.waitForElementToBePresent( outNetwork, 15 );
        softAssert.assertEquals( outNetwork.getText(), "Fuera de la red" );
        softAssert.assertAll();
        outNetwork.click();
    }

    public void validateSpanishDisclaimerText() {
        basicActions.scrollToElement( disclaimerSpanishDetail );
        basicActions.waitForElementToBePresent( disclaimerSpanishDetail, 15 );
        disclaimerSpanishDetail.isDisplayed();
        softAssert.assertEquals( disclaimerSpanishDetail.getText(), "Es posible que algunos detalles y documentos del plan no est\u00e9n disponibles en espa\u00f1ol. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la informaci\u00f3n m\u00e1s completa y precisa." );
        softAssert.assertAll();
    }

    public void validateSpanishPlanDocuments() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( lnkDrugList, 15 );
        headerInfoSpanish.isDisplayed();
        softAssert.assertEquals( headerInfoSpanish.getText(), "Más información sobre este Plan" );
        lnkDrugList.isDisplayed();
        softAssert.assertEquals( lnkDrugList.getText(), "Lista de medicamentos preferidos" );
        lnkProviderList.isDisplayed();
        softAssert.assertEquals( lnkProviderList.getText(), "Red de proveedores" );
        headerDocSpanish.isDisplayed();
        softAssert.assertEquals( headerDocSpanish.getText(), "Documentos del plan" );
        lnkDocument0.isDisplayed();
        lnkDocument1.isDisplayed();
        lnkDocument2.isDisplayed();
        lnkDocument3.isDisplayed();
        lnkDocument4.isDisplayed();
        lnkDocument5.isDisplayed();
        lnkDocument6.isDisplayed();
        lnkDocument7.isDisplayed();
        lnkDocument8.isDisplayed();
        softAssert.assertAll();


    }

    public void validateSpanishTextHeadersInNetwork() {
        basicActions.waitForElementToBePresent( inOneHeader, 10 );
        basicActions.waitForElementToBePresent( lnkDrugList, 15 );
        softAssert.assertEquals( inOneHeader.getText(), "Detalles generales" );
        softAssert.assertEquals( inTwoHeader.getText(), "Consultas con proveedores" );
        softAssert.assertEquals( inThreeHeader.getText(), "Medicamentos recetados" );
        softAssert.assertEquals( inFourHeader.getText(), "Instalaciones" );
        softAssert.assertEquals( inFiveHeader.getText(), "Maternidad" );
        softAssert.assertEquals( inSixHeader.getText(), "Atenci\u00f3n de emergencia" );
        softAssert.assertEquals( inSevenHeader.getText(), "Beneficios de salud mental" );
        softAssert.assertEquals( inEightHeader.getText(), "Pruebas" );
        softAssert.assertEquals( inNineHeader.getText(), "Dispositivos m\u00e9dicos" );
        softAssert.assertEquals( inTenHeader.getText(), "Servicios de habilitaci\u00f3n y rehabilitaci\u00f3n" );
        softAssert.assertEquals( inElevenHeader.getText(), "Atenci\u00f3n a domicilio y a pacientes con enfermedades terminales" );
        softAssert.assertEquals( inTwelveHeader.getText(), "Beneficios esenciales" );
        softAssert.assertAll();
    }

    public void validateSpanishTextHeadersOutNetwork() {
        basicActions.waitForElementToBePresent( outOneHeader, 10 );
        softAssert.assertEquals( outOneHeader.getText(), "Detalles generales" );//id='ngb-accordion-item-0-toggle'
        softAssert.assertEquals( outTwoHeader.getText(), "Consultas con proveedores" );
        softAssert.assertEquals( outThreeHeader.getText(), "Medicamentos recetados" );
        softAssert.assertEquals( outFourHeader.getText(), "Instalaciones" );
        softAssert.assertEquals( outFiveHeader.getText(), "Maternidad" );
        softAssert.assertEquals( outSixHeader.getText(), "Atenci\u00f3n de emergencia" );
        softAssert.assertEquals( outSevenHeader.getText(), "Beneficios de salud mental" );
        softAssert.assertEquals( outEightHeader.getText(), "Pruebas" );
        softAssert.assertEquals( outNineHeader.getText(), "Dispositivos m\u00e9dicos" );
        softAssert.assertEquals( outTenHeader.getText(), "Servicios de habilitaci\u00f3n y rehabilitaci\u00f3n" );
        softAssert.assertEquals( outElevenHeader.getText(), "Atenci\u00f3n a domicilio y a pacientes con enfermedades terminales" );
        softAssert.assertEquals( outTwelveHeader.getText(), "Beneficios esenciales" );
        softAssert.assertAll();
    }

    /// PDF validation functions -------------------------------------------------------------------------------

    public void validateDocumentsUpload(String carrier) {
        basicActions.waitForElementToBePresentWithRetries( spinner, 140 );
        basicActions.waitForElementToBePresentWithRetries( headerDocEnglish, 60 );
        softAssert.assertEquals( headerDocEnglish.getText(), "Plan Documents" );

        // test for different carrier docs
        switch (carrier) {
                case "Anthem":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualString0 = (lnkDocument0.getText());
                softAssert.assertTrue( actualString0.contains( "Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-01" ) );
                lnkDocument0.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath0 = SharedData.getLocalPathToDownloadFile();
                    String fileName0 = SharedData.getCarrierPdfFileName();
                    String pathAndName0 = filePath0+"//"+fileName0;
                    System.out.println("path and name is "+pathAndName0);

                    softAssert.assertTrue( fileName0.contains("Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-01"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName0.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument1.isDisplayed();
                String actualString1 = (lnkDocument1.getText());
                softAssert.assertTrue( actualString1.contains( "Summary of Benefits and Coverage CO Supplement Anthem BCBS English 0220065-01" ) );
                lnkDocument1.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath1 = SharedData.getLocalPathToDownloadFile();
                    String fileName1 = SharedData.getCarrierPdfFileName();
                    String pathAndName1 = filePath1+"//"+fileName1;
                    System.out.println("path and name is "+pathAndName1);

                    softAssert.assertTrue( fileName1.contains("Summary of Benefits and Coverage CO Supplement Anthem BCBS English 0220065-01"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName1.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument2, 60 );
                lnkDocument2.isDisplayed();
                String actualString2 = (lnkDocument2.getText());
                softAssert.assertTrue( actualString2.contains( "Evidence of Coverage Anthem BCBS English 0220065-01" ) );
                lnkDocument2.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath2 = SharedData.getLocalPathToDownloadFile();
                    String fileName2 = SharedData.getCarrierPdfFileName();
                    String pathAndName2 = filePath2+"//"+fileName2;
                    System.out.println("path and name is "+pathAndName2);

                    softAssert.assertTrue( fileName2.contains("Evidence of Coverage Anthem BCBS English 0220065-01"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName2.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument3, 60 );
                lnkDocument3.isDisplayed();
                String actualString3 = (lnkDocument3.getText());
                softAssert.assertTrue( actualString3.contains( "Evidence of Coverage Anthem BCBS Spanish 0220065-01" ) );
                lnkDocument3.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath3 = SharedData.getLocalPathToDownloadFile();
                    String fileName3 = SharedData.getCarrierPdfFileName();
                    String pathAndName3 = filePath3+"//"+fileName3;
                    System.out.println("path and name is "+pathAndName3);

                    softAssert.assertTrue( fileName3.contains("Evidence of Coverage Anthem BCBS Spanish 0220065-01"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName3.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument4, 60 );
                lnkDocument4.isDisplayed();
                String actualString4 = (lnkDocument4.getText());
                softAssert.assertTrue( actualString4.contains( "Summary of Benefits and Coverage Anthem BCBS English 0220065-01" ) );
                lnkDocument4.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath4 = SharedData.getLocalPathToDownloadFile();
                    String fileName4 = SharedData.getCarrierPdfFileName();
                    String pathAndName4 = filePath4+"//"+fileName4;
                    System.out.println("path and name is "+pathAndName4);

                    softAssert.assertTrue( fileName4.contains("Summary of Benefits and Coverage Anthem BCBS English 0220065-01"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName4.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();



                basicActions.waitForElementToBePresentWithRetries( lnkDocument5, 60 );
                lnkDocument5.isDisplayed();
                String actualString5 = (lnkDocument5.getText());
                softAssert.assertTrue( actualString5.contains( "Summary of Benefits and Coverage Anthem BCBS Spanish 0220065-01" ) );
                lnkDocument5.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath5 = SharedData.getLocalPathToDownloadFile();
                    String fileName5 = SharedData.getCarrierPdfFileName();
                    String pathAndName5 = filePath5+"//"+fileName5;
                    System.out.println("path and name is "+pathAndName5);

                    softAssert.assertTrue( fileName5.contains("Summary of Benefits and Coverage Anthem BCBS Spanish 0220065-01"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName5.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();



                basicActions.waitForElementToBePresentWithRetries( lnkDocument6, 60 );
                lnkDocument6.isDisplayed();
                String actualString6 = (linkDoc6Anthem.getText());
                softAssert.assertTrue( actualString6.contains( "Brochure Anthem Medical English" ) );
                lnkDocument6.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath6 = SharedData.getLocalPathToDownloadFile();
                    String fileName6 = SharedData.getCarrierPdfFileName();
                    String pathAndName6 = filePath6+"//"+fileName6;
                    System.out.println("path and name is "+pathAndName6);

                    softAssert.assertTrue( fileName6.contains("Brochure Anthem Medical English"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName6.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument7, 60 );
                lnkDocument7.isDisplayed();
                String actualString7 = (linkDoc7Anthem.getText());
                softAssert.assertTrue( actualString7.contains( "Provider Network Anthem Pathway Essentials" ) );
                lnkDocument7.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath7 = SharedData.getLocalPathToDownloadFile();
                    String fileName7 = SharedData.getCarrierPdfFileName();
                    String pathAndName7 = filePath7+"//"+fileName7;
                    System.out.println("path and name is "+pathAndName7);

                    softAssert.assertTrue( fileName7.contains("Provider Network Anthem Pathway Essentials"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName3.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument8, 60 );
                lnkDocument8.isDisplayed();
                String actualString8 = (linkDoc8Anthem.getText());
                softAssert.assertTrue( actualString8.contains( "Quality Overview Anthem English" ) );
                lnkDocument8.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath8 = SharedData.getLocalPathToDownloadFile();
                    String fileName8 = SharedData.getCarrierPdfFileName();
                    String pathAndName8 = filePath8+"//"+fileName8;
                    System.out.println("path and name is "+pathAndName8);

                    softAssert.assertTrue( fileName8.contains("Quality Overview Anthem English"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName8.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument9.isDisplayed();
                String actualString9 = (linkDoc9Anthem.getText());
                softAssert.assertTrue( actualString9.contains( "Quality Overview Anthem Spanish" ) );
                lnkDocument9.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath9 = SharedData.getLocalPathToDownloadFile();
                    String fileName9 = SharedData.getCarrierPdfFileName();
                    String pathAndName9 = filePath9+"//"+fileName9;
                    System.out.println("path and name is "+pathAndName9);

                    softAssert.assertTrue( fileName9.contains("Quality Overview Anthem Spanish"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName9.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument10, 60 );
                lnkDocument10.isDisplayed();
                String actualString10 = (linkDoc10Anthem.getText());
                softAssert.assertTrue( actualString10.contains( "Brochure Anthem Medical Spanish" ) );
                lnkDocument10.click();
                    SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                    String filePath10 = SharedData.getLocalPathToDownloadFile();
                    String fileName10 = SharedData.getCarrierPdfFileName();
                    String pathAndName10 = filePath10+"//"+fileName10;
                    System.out.println("path and name is "+pathAndName10);

                    softAssert.assertTrue( fileName10.contains("Brochure Anthem Medical Spanish"), "Downloaded file does not exist: " );
                    softAssert.assertTrue( fileName10.length() > 0, "Downloaded file is empty: " );
                    softAssert.assertAll();

                    break;

            case "Rocky":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualString210 = (lnkDocument0.getText());
                softAssert.assertTrue( actualString210.contains( "Summary of Benefits and Coverage CO Supplement Rocky Mountain English 0420062-01 Colorado Option" ) );
                lnkDocument0.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath210 = SharedData.getLocalPathToDownloadFile();
                String fileName210 = SharedData.getCarrierPdfFileName();
                String pathAndName210 = filePath210+"//"+fileName210;
                System.out.println("path and name is "+pathAndName210);
                softAssert.assertTrue( fileName210.contains("Summary of Benefits and Coverage CO Supplement Rocky Mountain English 0420062-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName210.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument1.isDisplayed();
                String actualString211 = (lnkDocument1.getText());
                softAssert.assertTrue( actualString211.contains( "Summary of Benefits and Coverage CO Supplement Rocky Mountain Spanish 0420062-01 Colorado Option" ) );
                lnkDocument1.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath211 = SharedData.getLocalPathToDownloadFile();
                String fileName211 = SharedData.getCarrierPdfFileName();
                String pathAndName211 = filePath211+"//"+fileName211;
                System.out.println("path and name is "+pathAndName211);
                softAssert.assertTrue( fileName211.contains("Summary of Benefits and Coverage CO Supplement Rocky Mountain Spanish 0420062-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName211.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument2, 60 );
                lnkDocument2.isDisplayed();
                String actualString212 = (lnkDocument2.getText());
                softAssert.assertTrue( actualString212.contains( "Evidence of Coverage Rocky Mountain English 0420062-01 Colorado Option" ) );
                lnkDocument2.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath212 = SharedData.getLocalPathToDownloadFile();
                String fileName212 = SharedData.getCarrierPdfFileName();
                String pathAndName212 = filePath212+"//"+fileName212;
                System.out.println("path and name is "+pathAndName212);
                softAssert.assertTrue( fileName212.contains("Evidence of Coverage Rocky Mountain English 0420062-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName212.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument3, 60 );
                lnkDocument3.isDisplayed();
                String actualString213 = (lnkDocument3.getText());
                softAssert.assertTrue( actualString213.contains( "Evidence of Coverage Rocky Mountain Spanish 0420062-01 Colorado Option" ) );
                lnkDocument3.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath213 = SharedData.getLocalPathToDownloadFile();
                String fileName213 = SharedData.getCarrierPdfFileName();
                String pathAndName213 = filePath213+"//"+fileName213;
                System.out.println("path and name is "+pathAndName213);
                softAssert.assertTrue( fileName213.contains("Evidence of Coverage Rocky Mountain Spanish 0420062-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName213.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument4, 60 );
                lnkDocument4.isDisplayed();
                String actualString214 = (lnkDocument4.getText());
                softAssert.assertTrue( actualString214.contains( "Summary of Benefits and Coverage Rocky Mountain English 0420062-01 Colorado Option" ) );
                lnkDocument4.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath214 = SharedData.getLocalPathToDownloadFile();
                String fileName214 = SharedData.getCarrierPdfFileName();
                String pathAndName214 = filePath214+"//"+fileName214;
                System.out.println("path and name is "+pathAndName214);
                softAssert.assertTrue( fileName214.contains("Summary of Benefits and Coverage Rocky Mountain English 0420062-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName214.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument5, 60 );
                lnkDocument5.isDisplayed();
                String actualString215 = (lnkDocument5.getText());
                softAssert.assertTrue( actualString215.contains( "Summary of Benefits and Coverage Rocky Mountain Spanish 0420062-01 Colorado Option" ) );
                lnkDocument5.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath215 = SharedData.getLocalPathToDownloadFile();
                String fileName215 = SharedData.getCarrierPdfFileName();
                String pathAndName215 = filePath215+"//"+fileName215;
                System.out.println("path and name is "+pathAndName215);
                softAssert.assertTrue( fileName215.contains("Summary of Benefits and Coverage Rocky Mountain Spanish 0420062-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName215.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument6, 60 );
                lnkDocument6.isDisplayed();
                String actualString216 = (lnkDocument6.getText());
                softAssert.assertTrue( actualString216.contains( "Brochure RMHP-UHC English" ) );
                lnkDocument6.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath216 = SharedData.getLocalPathToDownloadFile();
                String fileName216 = SharedData.getCarrierPdfFileName();
                String pathAndName216 = filePath216+"//"+fileName216;
                System.out.println("path and name is "+pathAndName216);
                softAssert.assertTrue( fileName216.contains("Brochure RMHP-UHC English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName216.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument7, 60 );
                lnkDocument7.isDisplayed();
                String actualString217 = (lnkDocument7.getText());
                softAssert.assertTrue( actualString217.contains( "Brochure RMHP-UHC Spanish" ) );
                lnkDocument7.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath217 = SharedData.getLocalPathToDownloadFile();
                String fileName217 = SharedData.getCarrierPdfFileName();
                String pathAndName217 = filePath217+"//"+fileName217;
                System.out.println("path and name is "+pathAndName217);
                softAssert.assertTrue( fileName217.contains("Brochure RMHP-UHC Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName217.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument8, 60 );
                lnkDocument8.isDisplayed();
                String actualString218 = (lnkDocument8.getText());
                softAssert.assertTrue( actualString218.contains( "Provider Network Rocky Mountain Health Plans Rocky Mountain Valley" ) );
                lnkDocument8.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath218 = SharedData.getLocalPathToDownloadFile();
                String fileName218 = SharedData.getCarrierPdfFileName();
                String pathAndName218 = filePath218+"//"+fileName218;
                System.out.println("path and name is "+pathAndName218);
                softAssert.assertTrue( fileName218.contains("Provider Network Rocky Mountain Health Plans Rocky Mountain Valley"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName218.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument9, 60 );
                lnkDocument9.isDisplayed();
                String actualString219 = (lnkDocument9.getText());
                softAssert.assertTrue( actualString219.contains( "Quality Overview Rocky Mountain Health Plan English" ) );
                lnkDocument9.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath219 = SharedData.getLocalPathToDownloadFile();
                String fileName219= SharedData.getCarrierPdfFileName();
                String pathAndName219 = filePath219+"//"+fileName219;
                System.out.println("path and name is "+pathAndName219);
                softAssert.assertTrue( fileName219.contains("Quality Overview Rocky Mountain Health Plan English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName219.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument10, 60 );
                lnkDocument10.isDisplayed();
                String actualString2110 = (lnkDocument10.getText());
                softAssert.assertTrue( actualString2110.contains( "Quality Overview Rocky Mountain Health Plan Spanish" ) );
                lnkDocument10.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath2110 = SharedData.getLocalPathToDownloadFile();
                String fileName2110 = SharedData.getCarrierPdfFileName();
                String pathAndName2110 = filePath2110+"//"+fileName2110;
                System.out.println("path and name is "+pathAndName2110);
                softAssert.assertTrue( fileName2110.contains("Quality Overview Rocky Mountain Health Plan Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName2110.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                break;

            case "Cigna":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualString220 = (lnkDocument0.getText());
                softAssert.assertTrue( actualString220.contains( "Summary of Benefits and Coverage CO Supplement Cigna English 0060032-01 Colorado Option" ) );
                lnkDocument0.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath220 = SharedData.getLocalPathToDownloadFile();
                String fileName220 = SharedData.getCarrierPdfFileName();
                String pathAndName220 = filePath220+"//"+fileName220;
                System.out.println("path and name is "+pathAndName220);
                softAssert.assertTrue( fileName220.contains("Summary of Benefits and Coverage CO Supplement Cigna English 0060032-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName220.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument1.isDisplayed();
                String actualString221 = (lnkDocument1.getText());
                softAssert.assertTrue( actualString221.contains( "Summary of Benefits and Coverage CO Supplement Cigna Spanish 0060032-01 Colorado Option" ) );
                lnkDocument1.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath221 = SharedData.getLocalPathToDownloadFile();
                String fileName221 = SharedData.getCarrierPdfFileName();
                String pathAndName221 = filePath221+"//"+fileName221;
                System.out.println("path and name is "+pathAndName221);
                softAssert.assertTrue( fileName221.contains("Summary of Benefits and Coverage CO Supplement Cigna Spanish 0060032-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName221.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

               // basicActions.waitForElementToBePresentWithRetries( lnkDocument2, 60 );
               // lnkDocument2.isDisplayed();
               // String actualString222 = (lnkDocument2.getText());
               // softAssert.assertTrue( actualString222.contains( "Evidence of Coverage Cigna English 0060032-01 Colorado Option" ) );
               // lnkDocument2.click();
               // basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
               // String filePath222 = SharedData.getLocalPathToDownloadFile();
               // String fileName222 = SharedData.getCarrierPdfFileName();
               // String pathAndName222 = filePath222+"//"+fileName222;
               // System.out.println("path and name is "+pathAndName222);
               // softAssert.assertTrue( fileName222.contains("Evidence of Coverage Cigna English 0060032-01 Colorado Option"), "Downloaded file does not exist: " );
                //softAssert.assertTrue( fileName222.length() > 0, "Downloaded file is empty: " );
               // softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument3, 60 );
                lnkDocument3.isDisplayed();
                String actualString223 = (lnkDocument3.getText());
                softAssert.assertTrue( actualString223.contains( "Evidence of Coverage Cigna Spanish 0060032-01 Colorado Option" ) );
                lnkDocument3.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath223 = SharedData.getLocalPathToDownloadFile();
                String fileName223 = SharedData.getCarrierPdfFileName();
                String pathAndName223 = filePath223+"//"+fileName223;
                System.out.println("path and name is "+pathAndName223);
                softAssert.assertTrue( fileName223.contains("Evidence of Coverage Cigna Spanish 0060032-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName223.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument4, 60 );
                lnkDocument4.isDisplayed();
                String actualString224 = (lnkDocument4.getText());
                softAssert.assertTrue( actualString224.contains( "Summary of Benefits and Coverage Cigna English 0060032-01 Colorado Option" ) );
                lnkDocument4.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath224 = SharedData.getLocalPathToDownloadFile();
                String fileName224 = SharedData.getCarrierPdfFileName();
                String pathAndName224 = filePath224+"//"+fileName224;
                System.out.println("path and name is "+pathAndName224);
                softAssert.assertTrue( fileName224.contains("Summary of Benefits and Coverage Cigna English 0060032-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName224.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument5, 60 );
                lnkDocument5.isDisplayed();
                String actualString225 = (lnkDocument5.getText());
                softAssert.assertTrue( actualString225.contains( "Summary of Benefits and Coverage Cigna Spanish 0060032-01 Colorado Option" ) );
                lnkDocument5.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath225 = SharedData.getLocalPathToDownloadFile();
                String fileName225 = SharedData.getCarrierPdfFileName();
                String pathAndName225 = filePath225+"//"+fileName225;
                System.out.println("path and name is "+pathAndName225);
                softAssert.assertTrue( fileName225.contains("Summary of Benefits and Coverage Cigna Spanish 0060032-01 Colorado Option"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName225.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument6, 60 );
                lnkDocument6.isDisplayed();
                String actualString226 = (lnkDocument6.getText());
                softAssert.assertTrue( actualString226.contains( "Brochure Cigna English" ) );
                lnkDocument6.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath226 = SharedData.getLocalPathToDownloadFile();
                String fileName226 = SharedData.getCarrierPdfFileName();
                String pathAndName226 = filePath226+"//"+fileName226;
                System.out.println("path and name is "+pathAndName226);
                softAssert.assertTrue( fileName226.contains("Brochure Cigna English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName226.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument7, 60 );
                lnkDocument7.isDisplayed();
                String actualString227 = (lnkDocument7.getText());
                softAssert.assertTrue( actualString227.contains( "Brochure Cigna Spanish" ) );
                lnkDocument7.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath227 = SharedData.getLocalPathToDownloadFile();
                String fileName227 = SharedData.getCarrierPdfFileName();
                String pathAndName227 = filePath227+"//"+fileName227;
                System.out.println("path and name is "+pathAndName227);
                softAssert.assertTrue( fileName227.contains("Brochure Cigna Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName227.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument8, 60 );
                lnkDocument8.isDisplayed();
                String actualString228 = (lnkDocument8.getText());
                softAssert.assertTrue( actualString228.contains( "Provider Network Cigna" ) );
                lnkDocument8.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath228 = SharedData.getLocalPathToDownloadFile();
                String fileName228 = SharedData.getCarrierPdfFileName();
                String pathAndName228 = filePath228+"//"+fileName228;
                System.out.println("path and name is "+pathAndName228);
                softAssert.assertTrue( fileName228.contains("Provider Network Cigna"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName228.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument9, 60 );
                lnkDocument9.isDisplayed();
                String actualString229 = (lnkDocument9.getText());
                softAssert.assertTrue( actualString229.contains( "Quality Overview Cigna English" ) );
                lnkDocument9.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath229 = SharedData.getLocalPathToDownloadFile();
                String fileName229= SharedData.getCarrierPdfFileName();
                String pathAndName229 = filePath229+"//"+fileName229;
                System.out.println("path and name is "+pathAndName229);
                softAssert.assertTrue( fileName229.contains("Quality Overview Cigna English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName229.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument10, 60 );
                lnkDocument10.isDisplayed();
                String actualString2210 = (lnkDocument10.getText());
                softAssert.assertTrue( actualString2210.contains( "Quality Overview Cigna Spanish" ) );
                lnkDocument10.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath2210 = SharedData.getLocalPathToDownloadFile();
                String fileName2210 = SharedData.getCarrierPdfFileName();
                String pathAndName2210 = filePath2210+"//"+fileName2210;
                System.out.println("path and name is "+pathAndName2210);
                softAssert.assertTrue( fileName2210.contains("Quality Overview Cigna Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName2210.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                break;

            case "Denver":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualString230 = (lnkDocument0.getText());
                softAssert.assertTrue( actualString230.contains( "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" ) );
                lnkDocument0.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath230 = SharedData.getLocalPathToDownloadFile();
                String fileName230 = SharedData.getCarrierPdfFileName();
                String pathAndName230 = filePath230+"//"+fileName230;
                System.out.println("path and name is "+pathAndName230);
                softAssert.assertTrue( fileName230.contains("Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName230.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument1.isDisplayed();
                String actualString231 = (lnkDocument1.getText());
                softAssert.assertTrue( actualString231.contains( "Summary of Benefits and Coverage CO Supplement Denver Health Spanish 0030008-01" ) );
                lnkDocument1.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath231 = SharedData.getLocalPathToDownloadFile();
                String fileName231 = SharedData.getCarrierPdfFileName();
                String pathAndName231 = filePath231+"//"+fileName231;
                System.out.println("path and name is "+pathAndName231);
                softAssert.assertTrue( fileName231.contains("Summary of Benefits and Coverage CO Supplement Denver Health Spanish 0030008-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName231.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument2, 60 );
                lnkDocument2.isDisplayed();
                String actualString232 = (lnkDocument2.getText());
                softAssert.assertTrue( actualString232.contains( "Evidence of Coverage Denver Health English 0030008-01" ) );
                lnkDocument2.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath232 = SharedData.getLocalPathToDownloadFile();
                String fileName232 = SharedData.getCarrierPdfFileName();
                String pathAndName232 = filePath232+"//"+fileName232;
                System.out.println("path and name is "+pathAndName232);
                softAssert.assertTrue( fileName232.contains("Evidence of Coverage Denver Health English 0030008-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName232.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument3, 60 );
                lnkDocument3.isDisplayed();
                String actualString233 = (lnkDocument3.getText());
                softAssert.assertTrue( actualString233.contains( "Evidence of Coverage Denver Health Spanish 0030008-01" ) );
                lnkDocument3.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath233 = SharedData.getLocalPathToDownloadFile();
                String fileName233 = SharedData.getCarrierPdfFileName();
                String pathAndName233 = filePath233+"//"+fileName233;
                System.out.println("path and name is "+pathAndName233);
                softAssert.assertTrue( fileName233.contains("Evidence of Coverage Denver Health Spanish 0030008-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName233.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument4, 60 );
                lnkDocument4.isDisplayed();
                String actualString234 = (lnkDocument4.getText());
                softAssert.assertTrue( actualString234.contains( "Summary of Benefits and Coverage Denver Health English 0030008-01" ) );
                lnkDocument4.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath234 = SharedData.getLocalPathToDownloadFile();
                String fileName234 = SharedData.getCarrierPdfFileName();
                String pathAndName234 = filePath234+"//"+fileName234;
                System.out.println("path and name is "+pathAndName234);
                softAssert.assertTrue( fileName234.contains("Summary of Benefits and Coverage Denver Health English 0030008-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName234.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument5, 60 );
                lnkDocument5.isDisplayed();
                String actualString235 = (lnkDocument5.getText());
                softAssert.assertTrue( actualString235.contains( "Summary of Benefits and Coverage Denver Health Spanish 0030008-01" ) );
                lnkDocument5.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath235 = SharedData.getLocalPathToDownloadFile();
                String fileName235 = SharedData.getCarrierPdfFileName();
                String pathAndName235 = filePath235+"//"+fileName235;
                System.out.println("path and name is "+pathAndName235);
                softAssert.assertTrue( fileName235.contains("Summary of Benefits and Coverage Denver Health Spanish 0030008-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName235.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument6, 60 );
                lnkDocument6.isDisplayed();
                String actualString236 = (lnkDocument6.getText());
                softAssert.assertTrue( actualString236.contains( "Brochure Denver Health English" ) );
                lnkDocument6.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath236 = SharedData.getLocalPathToDownloadFile();
                String fileName236 = SharedData.getCarrierPdfFileName();
                String pathAndName236 = filePath236+"//"+fileName236;
                System.out.println("path and name is "+pathAndName236);
                softAssert.assertTrue( fileName236.contains("Brochure Denver Health English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName236.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument7, 60 );
                lnkDocument7.isDisplayed();
                String actualString237 = (lnkDocument7.getText());
                softAssert.assertTrue( actualString237.contains( "Brochure Denver Health Spanish" ) );
                lnkDocument7.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath237 = SharedData.getLocalPathToDownloadFile();
                String fileName237 = SharedData.getCarrierPdfFileName();
                String pathAndName237 = filePath237+"//"+fileName237;
                System.out.println("path and name is "+pathAndName237);
                softAssert.assertTrue( fileName237.contains("Brochure Denver Health Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName237.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument8, 60 );
                lnkDocument8.isDisplayed();
                String actualString238 = (lnkDocument8.getText());
                softAssert.assertTrue( actualString238.contains( "Provider Network Denver Health" ) );
                lnkDocument8.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath238 = SharedData.getLocalPathToDownloadFile();
                String fileName238 = SharedData.getCarrierPdfFileName();
                String pathAndName238 = filePath238+"//"+fileName238;
                System.out.println("path and name is "+pathAndName238);
                softAssert.assertTrue( fileName238.contains("Provider Network Denver Health"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName238.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument9, 60 );
                lnkDocument9.isDisplayed();
                String actualString239 = (lnkDocument9.getText());
                softAssert.assertTrue( actualString239.contains( "Quality Overview Denver Health English" ) );
                lnkDocument9.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath239 = SharedData.getLocalPathToDownloadFile();
                String fileName239= SharedData.getCarrierPdfFileName();
                String pathAndName239 = filePath239+"//"+fileName239;
                System.out.println("path and name is "+pathAndName239);
                softAssert.assertTrue( fileName239.contains("Quality Overview Denver Health English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName239.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument10, 60 );
                lnkDocument10.isDisplayed();
                String actualString2310 = (lnkDocument10.getText());
                softAssert.assertTrue( actualString2310.contains( "Quality Overview Denver Health Spanish" ) );
                lnkDocument10.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath2310 = SharedData.getLocalPathToDownloadFile();
                String fileName2310 = SharedData.getCarrierPdfFileName();
                String pathAndName2310 = filePath2310+"//"+fileName2310;
                System.out.println("path and name is "+pathAndName2310);
                softAssert.assertTrue( fileName2310.contains("Quality Overview Denver Health Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName2310.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                break;


            case "Kaiser":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualString240 = (lnkDocument0.getText());
                softAssert.assertTrue( actualString240.contains( "Summary of Benefits and Coverage CO Supplement Kaiser Permanente English 0410052-01" ) );
                lnkDocument0.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath240 = SharedData.getLocalPathToDownloadFile();
                String fileName240 = SharedData.getCarrierPdfFileName();
                String pathAndName240 = filePath240+"//"+fileName240;
                System.out.println("path and name is "+pathAndName240);
                softAssert.assertTrue( fileName240.contains("Summary of Benefits and Coverage CO Supplement Kaiser Permanente English 0410052-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName240.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument1.isDisplayed();
                String actualString241 = (lnkDocument1.getText());
                softAssert.assertTrue( actualString241.contains( "Summary of Benefits and Coverage CO Supplement Kaiser Permanente Spanish 0410052-01" ) );
                lnkDocument1.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath241 = SharedData.getLocalPathToDownloadFile();
                String fileName241 = SharedData.getCarrierPdfFileName();
                String pathAndName241 = filePath241+"//"+fileName241;
                System.out.println("path and name is "+pathAndName241);
                softAssert.assertTrue( fileName241.contains("Summary of Benefits and Coverage CO Supplement Kaiser Permanente Spanish 0410052-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName241.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument2, 60 );
                lnkDocument2.isDisplayed();
                String actualString242 = (lnkDocument2.getText());
                softAssert.assertTrue( actualString242.contains( "Evidence of Coverage Kaiser Permanente English 0410052-01" ) );
                lnkDocument2.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath242 = SharedData.getLocalPathToDownloadFile();
                String fileName242 = SharedData.getCarrierPdfFileName();
                String pathAndName242 = filePath242+"//"+fileName242;
                System.out.println("path and name is "+pathAndName242);
                softAssert.assertTrue( fileName242.contains("Evidence of Coverage Kaiser Permanente English 0410052-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName242.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument3, 60 );
                lnkDocument3.isDisplayed();
                String actualString243 = (lnkDocument3.getText());
                softAssert.assertTrue( actualString243.contains( "Summary of Benefits and Coverage Kaiser Permanente English 0410052-01" ) );
                lnkDocument3.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath243 = SharedData.getLocalPathToDownloadFile();
                String fileName243 = SharedData.getCarrierPdfFileName();
                String pathAndName243 = filePath243+"//"+fileName243;
                System.out.println("path and name is "+pathAndName243);
                softAssert.assertTrue( fileName243.contains("Summary of Benefits and Coverage Kaiser Permanente English 0410052-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName243.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument4, 60 );
                lnkDocument4.isDisplayed();
                String actualString244 = (lnkDocument4.getText());
                softAssert.assertTrue( actualString244.contains( "Summary of Benefits and Coverage Kaiser Permanente Spanish 0410052-01" ) );
                lnkDocument4.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath244 = SharedData.getLocalPathToDownloadFile();
                String fileName244 = SharedData.getCarrierPdfFileName();
                String pathAndName244 = filePath244+"//"+fileName244;
                System.out.println("path and name is "+pathAndName244);
                softAssert.assertTrue( fileName244.contains("Summary of Benefits and Coverage Kaiser Permanente Spanish 0410052-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName244.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument5, 60 );
                lnkDocument5.isDisplayed();
                String actualString245 = (lnkDocument5.getText());
                softAssert.assertTrue( actualString245.contains( "Brochure Kaiser Permanente English" ) );
                lnkDocument5.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath245 = SharedData.getLocalPathToDownloadFile();
                String fileName245 = SharedData.getCarrierPdfFileName();
                String pathAndName245 = filePath245+"//"+fileName245;
                System.out.println("path and name is "+pathAndName245);
                softAssert.assertTrue( fileName245.contains("Brochure Kaiser Permanente English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName245.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument6, 60 );
                lnkDocument6.isDisplayed();
                String actualString246 = (lnkDocument6.getText());
                softAssert.assertTrue( actualString246.contains( "Provider Network Kaiser Permanente Select" ) );
                lnkDocument6.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath246 = SharedData.getLocalPathToDownloadFile();
                String fileName246 = SharedData.getCarrierPdfFileName();
                String pathAndName246 = filePath246+"//"+fileName246;
                System.out.println("path and name is "+pathAndName246);
                softAssert.assertTrue( fileName246.contains("Provider Network Kaiser Permanente Select"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName246.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument7, 60 );
                lnkDocument7.isDisplayed();
                String actualString247 = (lnkDocument7.getText());
                softAssert.assertTrue( actualString247.contains( "Quality Overview Kaiser Permanente English" ) );
                lnkDocument7.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath247 = SharedData.getLocalPathToDownloadFile();
                String fileName247 = SharedData.getCarrierPdfFileName();
                String pathAndName247 = filePath247+"//"+fileName247;
                System.out.println("path and name is "+pathAndName247);
                softAssert.assertTrue( fileName247.contains("Quality Overview Kaiser Permanente English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName247.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument8, 60 );
                lnkDocument8.isDisplayed();
                String actualString248 = (lnkDocument8.getText());
                softAssert.assertTrue( actualString248.contains( "Quality Overview Kaiser Permanente Spanish" ) );
                lnkDocument8.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath248 = SharedData.getLocalPathToDownloadFile();
                String fileName248 = SharedData.getCarrierPdfFileName();
                String pathAndName248 = filePath248+"//"+fileName248;
                System.out.println("path and name is "+pathAndName248);
                softAssert.assertTrue( fileName248.contains("Quality Overview Kaiser Permanente Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName248.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument9, 60 );
                lnkDocument9.isDisplayed();
                String actualString249 = (lnkDocument9.getText());
                softAssert.assertTrue( actualString249.contains( "Evidence of Coverage Kaiser Permanente Spanish 0410052-01" ) );
                lnkDocument9.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath249 = SharedData.getLocalPathToDownloadFile();
                String fileName249= SharedData.getCarrierPdfFileName();
                String pathAndName249 = filePath249+"//"+fileName249;
                System.out.println("path and name is "+pathAndName249);
                softAssert.assertTrue( fileName249.contains("Evidence of Coverage Kaiser Permanente Spanish 0410052-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName249.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                break;



            case "Select":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualString250 = (lnkDocument0.getText());
                softAssert.assertTrue( actualString250.contains( "Summary of Benefits and Coverage CO Supplement Select Health English 0030009-01" ) );
                lnkDocument0.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath250 = SharedData.getLocalPathToDownloadFile();
                String fileName250 = SharedData.getCarrierPdfFileName();
                String pathAndName250 = filePath250+"//"+fileName250;
                System.out.println("path and name is "+pathAndName250);
                softAssert.assertTrue( fileName250.contains("Summary of Benefits and Coverage CO Supplement Select Health English 0030009-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName250.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument1.isDisplayed();
                String actualString251 = (lnkDocument1.getText());
                softAssert.assertTrue( actualString251.contains( "Summary of Benefits and Coverage CO Supplement Select Health Spanish 0030009-01" ) );
                lnkDocument1.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath251 = SharedData.getLocalPathToDownloadFile();
                String fileName251 = SharedData.getCarrierPdfFileName();
                String pathAndName251 = filePath251+"//"+fileName251;
                System.out.println("path and name is "+pathAndName251);
                softAssert.assertTrue( fileName251.contains("Summary of Benefits and Coverage CO Supplement Select Health Spanish 0030009-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName251.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument2, 60 );
                lnkDocument2.isDisplayed();
                String actualString252 = (lnkDocument2.getText());
                softAssert.assertTrue( actualString252.contains( "Evidence of Coverage Select Health English 0030009-01" ) );
                lnkDocument2.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath252 = SharedData.getLocalPathToDownloadFile();
                String fileName252 = SharedData.getCarrierPdfFileName();
                String pathAndName252 = filePath252+"//"+fileName252;
                System.out.println("path and name is "+pathAndName252);
                softAssert.assertTrue( fileName252.contains("Evidence of Coverage Select Health English 0030009-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName252.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument3, 60 );
                lnkDocument3.isDisplayed();
                String actualString253 = (lnkDocument3.getText());
                softAssert.assertTrue( actualString253.contains( "Evidence of Coverage Select Health Spanish 0030009-01" ) );
                lnkDocument3.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath253 = SharedData.getLocalPathToDownloadFile();
                String fileName253 = SharedData.getCarrierPdfFileName();
                String pathAndName253 = filePath253+"//"+fileName253;
                System.out.println("path and name is "+pathAndName253);
                softAssert.assertTrue( fileName253.contains("Evidence of Coverage Select Health Spanish 0030009-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName253.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument4, 60 );
                lnkDocument4.isDisplayed();
                String actualString254 = (lnkDocument4.getText());
                softAssert.assertTrue( actualString254.contains( "Summary of Benefits and Coverage Select Health English 0030009-01" ) );
                lnkDocument4.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath254 = SharedData.getLocalPathToDownloadFile();
                String fileName254 = SharedData.getCarrierPdfFileName();
                String pathAndName254 = filePath254+"//"+fileName254;
                System.out.println("path and name is "+pathAndName254);
                softAssert.assertTrue( fileName254.contains("Summary of Benefits and Coverage Select Health English 0030009-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName254.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument5, 60 );
                lnkDocument5.isDisplayed();
                String actualString255 = (lnkDocument5.getText());
                softAssert.assertTrue( actualString255.contains( "Summary of Benefits and Coverage Select Health Spanish 0030009-01" ) );
                lnkDocument5.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath255 = SharedData.getLocalPathToDownloadFile();
                String fileName255 = SharedData.getCarrierPdfFileName();
                String pathAndName255 = filePath255+"//"+fileName255;
                System.out.println("path and name is "+pathAndName255);
                softAssert.assertTrue( fileName255.contains("Summary of Benefits and Coverage Select Health Spanish 0030009-01"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName255.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument6, 60 );
                lnkDocument6.isDisplayed();
                String actualString256 = (lnkDocument6.getText());
                softAssert.assertTrue( actualString256.contains( "Brochure Select Health English" ) );
                lnkDocument6.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath256 = SharedData.getLocalPathToDownloadFile();
                String fileName256 = SharedData.getCarrierPdfFileName();
                String pathAndName256 = filePath256+"//"+fileName256;
                System.out.println("path and name is "+pathAndName256);
                softAssert.assertTrue( fileName256.contains("Brochure Select Health English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName256.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument7, 60 );
                lnkDocument7.isDisplayed();
                String actualString257 = (lnkDocument7.getText());
                softAssert.assertTrue( actualString257.contains( "Brochure Select Health Spanish" ) );
                lnkDocument7.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath257 = SharedData.getLocalPathToDownloadFile();
                String fileName257 = SharedData.getCarrierPdfFileName();
                String pathAndName257 = filePath257+"//"+fileName257;
                System.out.println("path and name is "+pathAndName257);
                softAssert.assertTrue( fileName257.contains("Brochure Select Health Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName257.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument8, 60 );
                lnkDocument8.isDisplayed();
                String actualString258 = (lnkDocument8.getText());
                softAssert.assertTrue( actualString258.contains( "Provider Network Select Health" ) );
                lnkDocument8.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath258 = SharedData.getLocalPathToDownloadFile();
                String fileName258 = SharedData.getCarrierPdfFileName();
                String pathAndName258 = filePath258+"//"+fileName258;
                System.out.println("path and name is "+pathAndName258);
                softAssert.assertTrue( fileName258.contains("Provider Network Select Health"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName258.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                basicActions.waitForElementToBePresentWithRetries( lnkDocument9, 60 );
                lnkDocument9.isDisplayed();
                String actualString259 = (lnkDocument9.getText());
                softAssert.assertTrue( actualString259.contains( "Quality Overview Select Health Plan English" ) );
                lnkDocument9.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath259 = SharedData.getLocalPathToDownloadFile();
                String fileName259= SharedData.getCarrierPdfFileName();
                String pathAndName259 = filePath259+"//"+fileName259;
                System.out.println("path and name is "+pathAndName259);
                softAssert.assertTrue( fileName259.contains("Quality Overview Select Health Plan English"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName259.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();

                basicActions.waitForElementToBePresentWithRetries( lnkDocument10, 60 );
                lnkDocument10.isDisplayed();
                String actualString2510 = (lnkDocument10.getText());
                softAssert.assertTrue( actualString2510.contains( "Quality Overview Select Health Plan Spanish" ) );
                lnkDocument10.click();
                SharedData.setCarrierPdfFileName(basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 80 ));
                String filePath2510 = SharedData.getLocalPathToDownloadFile();
                String fileName2510 = SharedData.getCarrierPdfFileName();
                String pathAndName2510 = filePath2510+"//"+fileName2510;
                System.out.println("path and name is "+pathAndName2510);
                softAssert.assertTrue( fileName2510.contains("Quality Overview Select Health Plan Spanish"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName2510.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();


                break;
        }

    }
}