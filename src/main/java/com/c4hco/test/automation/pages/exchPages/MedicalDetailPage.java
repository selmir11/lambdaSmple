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
    PDF pdf = new PDF( WebDriverManager.getDriver() );
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();
    private Optional<Integer> optionalInt;
    private Object fileInput;
    private DOMCryptoContext document;


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

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-01']")
    WebElement linkDoc0Anthem;

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage CO Supplement Rocky Mountain English 0420062-01 Colorado Option']")
    WebElement linkDoc0Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_1")
    WebElement lnkDocument1;

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage CO Supplement Anthem BCBS English 0220065-01']")
    WebElement linkDoc1Anthem;

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage CO Supplement Rocky Mountain Spanish 0420062-01 Colorado Option']")
    WebElement linkDoc1Rocky;


    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_2")
    WebElement lnkDocument2;

    @FindBy(xpath = "//td[normalize-space()='Evidence of Coverage Anthem BCBS English 0220065-01']")
    WebElement linkDoc2Anthem;

    @FindBy(xpath = "//td[normalize-space()='Evidence of Coverage Rocky Mountain English 0420062-01 Colorado Option']")
    WebElement linkDoc2Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_3")
    WebElement lnkDocument3;

    @FindBy(xpath = "//td[normalize-space()='Evidence of Coverage Anthem BCBS Spanish 0220065-01']")
    WebElement linkDoc3Anthem;

    @FindBy(xpath = "//td[normalize-space()='Evidence of Coverage Rocky Mountain Spanish 0420062-01 Colorado Option']")
    WebElement linkDoc3Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_4")
    WebElement lnkDocument4;

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage Anthem BCBS English 0220065-01']")
    WebElement linkDoc4Anthem;

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage Rocky Mountain English 0420062-01 Colorado Option']")
    WebElement linkDoc4Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_5")
    WebElement lnkDocument5;

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage Anthem BCBS Spanish 0220065-01']")
    WebElement linkDoc5Anthem;

    @FindBy(xpath = "//td[normalize-space()='Summary of Benefits and Coverage Rocky Mountain Spanish 0420062-01 Colorado Option']")
    WebElement linkDoc5Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_6")
    WebElement lnkDocument6;

    @FindBy(xpath = "//td[normalize-space()='Brochure Anthem Medical English']")
    WebElement linkDoc6Anthem;

    @FindBy(xpath = "//td[normalize-space()='Brochure RMHP-UHC English']")
    WebElement linkDoc6Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_7")
    WebElement lnkDocument7;

    @FindBy(xpath = "//td[normalize-space()='Provider Network Anthem Pathway Essentials']")
    WebElement linkDoc7Anthem;

    @FindBy(xpath = "//td[normalize-space()='Brochure RMHP-UHC Spanish']")
    WebElement linkDoc7Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_8")
    WebElement lnkDocument8;

    @FindBy(xpath = "//td[normalize-space()='Quality Overview Anthem English']")
    WebElement linkDoc8Anthem;

    @FindBy(xpath = "//td[normalize-space()='Provider Network Rocky Mountain Health Plans Rocky Mountain Valley']")
    WebElement linkDoc8Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_9")
    WebElement lnkDocument9;

    @FindBy(xpath = "//td[normalize-space()='Quality Overview Anthem Spanish']")
    WebElement linkDoc9Anthem;

    @FindBy(xpath = "//td[normalize-space()='Quality Overview Rocky Mountain Health Plan English']")
    WebElement linkDoc9Rocky;

    @FindBy(id = "MedicalCarrierDetails-downloadPlanDocument_10")
    WebElement lnkDocument10;

    @FindBy(xpath = "//td[normalize-space()='Brochure Anthem Medical Spanish']")
    WebElement linkDoc10Anthem;

    @FindBy(xpath = "//td[normalize-space()='Quality Overview Rocky Mountain Health Plan Spanish']")
    WebElement linkDoc10Rocky;



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


    public void medicalDetailPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }


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

    public void validateDocumentsUpload(String carrier) {
        basicActions.waitForElementToBePresent( spinner, 100 );
        basicActions.waitForElementToBePresentWithRetries( headerDocEnglish, 60 );
        softAssert.assertEquals( headerDocEnglish.getText(), "Plan Documents" );

        // test for different carrier docs
        switch (carrier) {
            case "Anthem":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualString0 = (linkDoc0Anthem.getText());
                softAssert.assertTrue( actualString0.contains( "Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-01" ) );

                lnkDocument0.click();
                waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 30 );

                // at the step above the cursor is found on the downloaded document - next step would be to copy the file title and verify it

                //getLocalPathToDownloadFile = "/ThisPC/Downloads";
                //fileInput = document.getElementById("Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-01");
                //fileInput.value = getLocalPathToDownloadFile;


                //String localPathDownload1 = (SharedData.getLocalPathToDownloadFile());
                //softAssert.assertTrue( localPathDownload1.contains( "Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-01" ) );
                //softAssert.assertAll();

            case "Rocky":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                softAssert.assertEquals( lnkDocument0, "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" );
                lnkDocument0.click();
                waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 30 );

                softAssert.assertAll();

            case "Kaiser":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                softAssert.assertEquals( lnkDocument0, "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" );
                lnkDocument0.click();
                waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 30 );

                softAssert.assertAll();


            case "Denver":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                softAssert.assertEquals( lnkDocument0, "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" );
                lnkDocument0.click();
                waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 30 );

                softAssert.assertAll();

            case "Cigna":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                softAssert.assertEquals( lnkDocument0, "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" );
                lnkDocument0.click();
                waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 30 );


                softAssert.assertAll();

            case "Select":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                softAssert.assertEquals( lnkDocument0, "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" );
                lnkDocument0.click();
                waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 30 );


                softAssert.assertAll();
        }
    }


    public static String waitForDownloadToComplete(String localPath, int timeoutInSeconds) {
        File dir = new File( localPath );
        File[] filesBefore = dir.listFiles();
        long startTime = System.currentTimeMillis();

        // Loop until the timeout or until a new file is found
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
            File[] filesAfter = dir.listFiles();
            if (filesAfter != null) {
                for (File file : filesAfter) {
                    if (!file.isDirectory() && (filesBefore == null || !fileExists( filesBefore, file ))) {
                        if (file.length() > 0) {
                            SharedData.setNoticeFileName( file.getName() );
                            return file.getName();
                        }
                    }
                }
            }
            try {
                TimeUnit.SECONDS.sleep( 3 );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException( e );
            }
        }
        return null;
    }

    private static boolean fileExists(File[] files, File file) {
        if (files == null) {
            return false;
        }
        for (File f : files) {
            if (f.getName().equals( file.getName() )) {
                return true;
            }
        }
        return false;
    }


    public void validateDocumentsUpload2(String carrier) {
        basicActions.waitForElementToBePresent( spinner, 100 );
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
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                //String localPathDownload0 = (SharedData.getLocalPathToDownloadFile());
                //String pdfContent = extractTextFromPDF(Path.of(pathAndName));
                //File downloadedFile = new File( localPathDownload0, "Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-01" );
                    String filePath = SharedData.getLocalPathToDownloadFile();
                    String fileName = SharedData.getNoticeFileName();
                    String pathAndName = filePath+"//"+fileName;
                    System.out.println("path and name is "+pathAndName);



                softAssert.assertTrue( fileName.contains("Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220065-0"), "Downloaded file does not exist: " );
                softAssert.assertTrue( fileName.length() > 0, "Downloaded file is empty: " );
                softAssert.assertAll();
                break;
                case "Anthem1":

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument1.isDisplayed();
                String actualString1 = (lnkDocument1.getText());
                softAssert.assertTrue( actualString1.contains( "Summary of Benefits and Coverage CO Supplement Anthem BCBS English 0220065-01" ) );
                lnkDocument1.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload1 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile1 = new File( localPathDownload1, "Summary of Benefits and Coverage CO Supplement Anthem BCBS English 0220065-01" );
                softAssert.assertTrue( downloadedFile1.exists(), "Downloaded file does not exist: " + downloadedFile1.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile1.length() > 0, "Downloaded file is empty: " + downloadedFile1.getAbsolutePath() );
                softAssert.assertAll();
                break;

                case "Anthem2":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument2, 60 );
                lnkDocument2.isDisplayed();
                String actualString2 = (lnkDocument2.getText());
                softAssert.assertTrue( actualString2.contains( "Evidence of Coverage Anthem BCBS English 0220065-01" ) );
                lnkDocument2.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload2 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile2 = new File( localPathDownload2, "Evidence of Coverage Anthem BCBS English 0220065-01" );
                softAssert.assertTrue( downloadedFile2.exists(), "Downloaded file does not exist: " + downloadedFile2.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile2.length() > 0, "Downloaded file is empty: " + downloadedFile2.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument3, 60 );
                lnkDocument3.isDisplayed();
                String actualString3 = (lnkDocument3.getText());
                softAssert.assertTrue( actualString3.contains( "Evidence of Coverage Anthem BCBS Spanish 0220065-01" ) );
                lnkDocument3.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload3 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile3 = new File( localPathDownload3, "Evidence of Coverage Anthem BCBS Spanish 0220065-01" );
                softAssert.assertTrue( downloadedFile3.exists(), "Downloaded file does not exist: " + downloadedFile3.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile3.length() > 0, "Downloaded file is empty: " + downloadedFile3.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument4, 60 );
                lnkDocument4.isDisplayed();
                String actualString4 = (lnkDocument4.getText());
                softAssert.assertTrue( actualString4.contains( "Summary of Benefits and Coverage Anthem BCBS English 0220065-01" ) );
                lnkDocument4.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload4 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile4 = new File( localPathDownload4, "Summary of Benefits and Coverage Anthem BCBS English 0220065-01" );
                softAssert.assertTrue( downloadedFile4.exists(), "Downloaded file does not exist: " + downloadedFile4.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile4.length() > 0, "Downloaded file is empty: " + downloadedFile4.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument5, 60 );
                lnkDocument5.isDisplayed();
                String actualString5 = (lnkDocument5.getText());
                softAssert.assertTrue( actualString5.contains( "Summary of Benefits and Coverage Anthem BCBS Spanish 0220065-01" ) );
                lnkDocument5.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload5 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile5 = new File( localPathDownload5, "Summary of Benefits and Coverage Anthem BCBS Spanish 0220065-01" );
                softAssert.assertTrue( downloadedFile5.exists(), "Downloaded file does not exist: " + downloadedFile5.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile5.length() > 0, "Downloaded file is empty: " + downloadedFile5.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument6, 60 );
                lnkDocument6.isDisplayed();
                String actualString6 = (linkDoc6Anthem.getText());
                softAssert.assertTrue( actualString6.contains( "Brochure Anthem Medical English" ) );
                lnkDocument1.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload6 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile6 = new File( localPathDownload6, "Brochure Anthem Medical English" );
                softAssert.assertTrue( downloadedFile6.exists(), "Downloaded file does not exist: " + downloadedFile6.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile6.length() > 0, "Downloaded file is empty: " + downloadedFile6.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument7, 60 );
                lnkDocument7.isDisplayed();
                String actualString7 = (linkDoc7Anthem.getText());
                softAssert.assertTrue( actualString7.contains( "Provider Network Anthem Pathway Essentials" ) );
                lnkDocument7.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload7 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile7 = new File( localPathDownload7, "Provider Network Anthem Pathway Essentials" );
                softAssert.assertTrue( downloadedFile7.exists(), "Downloaded file does not exist: " + downloadedFile7.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile7.length() > 0, "Downloaded file is empty: " + downloadedFile7.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument8, 60 );
                lnkDocument8.isDisplayed();
                String actualString8 = (linkDoc8Anthem.getText());
                softAssert.assertTrue( actualString8.contains( "Quality Overview Anthem English" ) );
                lnkDocument1.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload8 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile8 = new File( localPathDownload8, "Quality Overview Anthem English" );
                softAssert.assertTrue( downloadedFile8.exists(), "Downloaded file does not exist: " + downloadedFile8.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile8.length() > 0, "Downloaded file is empty: " + downloadedFile8.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument1, 60 );
                lnkDocument9.isDisplayed();
                String actualString9 = (linkDoc9Anthem.getText());
                softAssert.assertTrue( actualString9.contains( "Quality Overview Anthem Spanish" ) );
                lnkDocument9.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload9 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile9 = new File( localPathDownload9, "Quality Overview Anthem Spanish" );
                softAssert.assertTrue( downloadedFile9.exists(), "Downloaded file does not exist: " + downloadedFile9.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile9.length() > 0, "Downloaded file is empty: " + downloadedFile9.getAbsolutePath() );

                basicActions.waitForElementToBePresentWithRetries( lnkDocument10, 60 );
                lnkDocument10.isDisplayed();
                String actualString10 = (linkDoc10Anthem.getText());
                softAssert.assertTrue( actualString10.contains( "Brochure Anthem Medical Spanish" ) );
                lnkDocument10.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownload10 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFile10 = new File( localPathDownload10, "Brochure Anthem Medical Spanish" );
                softAssert.assertTrue( downloadedFile10.exists(), "Downloaded file does not exist: " + downloadedFile10.getAbsolutePath() );
                softAssert.assertTrue( downloadedFile10.length() > 0, "Downloaded file is empty: " + downloadedFile10.getAbsolutePath() );
                softAssert.assertAll();
                break;

            case "Rocky":
                basicActions.waitForElementToBePresentWithRetries( lnkDocument0, 60 );
                lnkDocument0.isDisplayed();
                String actualStringR0 = (linkDoc0Rocky.getText());
                softAssert.assertTrue( actualStringR0.contains( "Summary of Benefits and Coverage CO Supplement Rocky Mountain English 0420062-01 Colorado Option" ) );
                lnkDocument0.click();
                basicActions.waitForDownloadToComplete( SharedData.getLocalPathToDownloadFile(), 60 );
                String localPathDownloadR0 = (SharedData.getLocalPathToDownloadFile());
                File downloadedFileR0 = new File( localPathDownloadR0, "Summary of Benefits and Coverage CO Supplement Rocky Mountain English 0420062-01 Colorado Option" );
                softAssert.assertTrue( downloadedFileR0.exists(), "Downloaded file does not exist: " + downloadedFileR0.getAbsolutePath() );
                softAssert.assertTrue( downloadedFileR0.length() > 0, "Downloaded file is empty: " + downloadedFileR0.getAbsolutePath() );
                softAssert.assertAll();
                break;

            case "Kaiser":


                break;

            case "Denver":

                break;

            case "Cigna":

                break;

            case "Select":

                break;
        }

    }
}