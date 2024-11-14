package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import lombok.experimental.FieldNameConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class MedicalCompareCoCoPage { private BasicActions basicActions;


    SoftAssert softAssert = new SoftAssert();
    public MedicalCompareCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );

    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "MedicalComparePlans-ToTop")
    WebElement toTop;

    @FindBy(xpath = "//*[@class = 'accordion-header c4-type-header-sm']")
    //@FindBy(xpath = "//em[@class = 'fa fa-chevron-down']")
    List<WebElement> getDrpDwnPlanCategories;

    @FindBy(id = "MedicalComparePlans-GoBackToPlans")
    public WebElement medicalCompareGoBack;

    @FindBy(xpath="//div[class = 'c4-type-header-lg header-container']")
    public WebElement compareTopHeader;

    @FindBy(id = "MedicalComparePlans-TopGoBackToPlans")
    public WebElement goBackToPlansCompareLink;

    @FindBy(id = "SHP-MedicalComparePlans-DownloadSummaryOfThisPage")
    public WebElement downloadPDF;

    @FindBy(id= "PlanCompare-PlanDetails_1")
    public WebElement linkViewDetails1;

    @FindBy(id= "PlanCompare-PlanDetails_2")
    public WebElement linkViewDetails2;

    @FindBy(id= "PlanCompare-PlanDetails_3")
    public WebElement linkViewDetails3;

    @FindBy(id= "PlanCompare-PlanDetails_4")
    public WebElement linkViewDetails4;

    @FindBy(css = ".pt-5")
    public WebElement planHeaderdetails;


    @FindBy(id = "PlanCompare-SelectThisPlan_1")
    public WebElement selectfirstplan;

    @FindBy(id = "PlanCompare-SelectThisPlan_2")
    public WebElement selectSecondplan;

    @FindBy(id = "PlanCompare-SelectThisPlan_3")
    public WebElement selectThirdplan;



    @FindBy(xpath = "//*[contains(text(), 'Plan Details')]")
    WebElement clickComparePlanDetailLinkCoCo1;

    @FindBy(xpath = "//*[contains(text(), 'Detalles Del Plan')]")
    WebElement clickComparePlanDetailLinkCoCoSP;

    @FindBy(xpath = "//p[normalize-space()='There are no plans selected to compare']")
    public WebElement noTextPlan;

    @FindBy(xpath = "//p[normalize-space()='No hay planes seleccionados para comparar']")
    public WebElement noTextPlanSP;

    @FindBy(id = "MedicalPlanCompare_InNetworkTab")
    public WebElement selectInNetworkTier1Link;

    @FindBy(id = "MedicalPlanCompare_InNetworkTier2Tab")
    public WebElement selectInNetworkTier2Link;

    @FindBy(id = "MedicalPlanCompare_OutOfNetworkTab")
    public WebElement selectOutofNetworkLink;

    @FindBy(xpath = "//div[@id='SHP-MedicalComparePlans-InNetworkTier1-panel'] //button")
    public List<WebElement> drpDwnPlanDetails;


    ////////////////////
    //Highlights  header

    //@FindBy(xpath = "//*[class = 'accordion-header c4-type-header-sm']")
    //public WebElement headerHighlights;


    @FindBy(xpath = "//span[normalize-space()='Monthly Cost']")
    public WebElement txtCompareHeaderMonthlyCost;
    @FindBy(xpath = "//span[normalize-space()='Costo mensual']")
    public WebElement txtCompareHeaderMonthlyCostSP;

    @FindBy(xpath = "//span[normalize-space()='Deductible']")
    public WebElement txtCompareHeaderDeductible;
    @FindBy(xpath = "//span[normalize-space()='Deducible']")
    public WebElement txtCompareHeaderDeductibleSP;

    @FindBy(xpath = "//span[normalize-space()='Coinsurance']")
    public WebElement txtCompareHeaderCoinsurance;
    @FindBy(xpath = "//span[normalize-space()='Coseguro']")
    public WebElement txtCompareHeaderCoinsuranceSP;

    @FindBy(xpath = "//span[normalize-space()='Out-of-Pocket Max']")
    public WebElement txtCompareHeaderOutOfPocket;
    @FindBy(xpath = "//span[normalize-space()='Desembolso máximo']")
    public WebElement txtCompareHeaderOutOfPocketSP;

    @FindBy(xpath = "//span[normalize-space()='Overall Quality Rating']")
    public WebElement txtCompareHeaderOverallQualityRating;
    @FindBy(xpath = "//span[normalize-space()='Calificación de calidad general']")
    public WebElement txtCompareHeaderOverallQualityRatingSP;

    /// remove ///////////////
    @FindBy(id="ngb-accordion-item-0-toggle")
    public WebElement txtCompareHeaderMonthlyPremium;

    @FindBy(id="ngb-accordion-item-13-toggle")
    public WebElement txtCompareHeaderMonthlyPremiumOut;

    @FindBy(id = "ngb-accordion-item-1-toggle")
    public WebElement getTxtCompareHeaderGeneralDetails;

    @FindBy(id = "ngb-accordion-item-14-toggle")
    public WebElement getTxtCompareHeaderGeneralDetailsOut;
    /////////////////////////

    // Plan Documents
    //@FindBy(xpath = "//span[normalize-space()='Plan Documents']")
    @FindBy(xpath = "//*[@class = 'accordion-header c4-type-header-sm']")
    public WebElement getTxtHeaderPlanDocuments;

    //@FindBy(xpath = "//span[normalize-space()='Documentos del plan']")
    @FindBy(xpath = "//*[@class = 'accordion-header c4-type-header-sm']")
    public WebElement getTxtHeaderPlanDocumentsSP;

    @FindBy(xpath = "//span[normalize-space()='Plan Documents\n" +
            "(En español)']")
    public WebElement getTxtPlanDocumentsEnglish;

    @FindBy(xpath = "//span[normalize-space()='Plan Documents\n" +
            "(En español)']")
    public WebElement getTxtPlanDocumentsSpanish;

    //Doctor Visits header
    @FindBy(xpath = "//div[normalize-space()='Doctor Visits']")
    public WebElement getTxtSubheaderDoctorVisits;
    @FindBy(xpath = "//div[normalize-space()='Consultas con proveedores ']")
    public WebElement getTxtSubheaderDoctorVisitsSP;

    @FindBy(xpath = "//div[normalize-space()='Preventive Care/ Screening/ Immunization']")
    public WebElement getTxtPreventativeCare;
    @FindBy(xpath = "//div[normalize-space()='Atención preventiva, exámenes, inmunización']")
    public WebElement getTxtPreventativeCareSP;
    @FindBy(xpath = "//div[normalize-space()='Primary Care Visit to Treat an Injury or Illness']")
    public WebElement getTxtPrimaryCare;
    @FindBy(xpath = "//div[normalize-space()='Consulta de atención primaria para tratar una lesión o enfermedad']")
    public WebElement getTxtPrimaryCareSP;
    @FindBy(xpath = "//div[normalize-space()='Specialist Visit']")
    public WebElement getTxtSpecialistVisit;
    @FindBy(xpath = "//div[normalize-space()='Consulta con un especialista']")
    public WebElement getTxtSpecialistVisitSP;
    @FindBy(xpath = "//div[normalize-space()='Telehealth PCP']")
    public WebElement getTxtTelehealthPCP;
    @FindBy(xpath = "//div[normalize-space()='Telemedicina PCP']")
    public WebElement getTxtTelehealthPCPSP;
    @FindBy(xpath = "//div[normalize-space()='Telehealth Specialist']")
    public WebElement getTxtTelehealthSpecialist;
    @FindBy(xpath = "//div[normalize-space()='Telemedicina especialista']")
    public WebElement getTxtTelehealthSpecialistSP;

    //Emergency Care header
    @FindBy(id = "MedicalPlanCompare_EmergencyCare")
    public WebElement getTxtCompareHeaderEmergencyCare;
    @FindBy(id = "MedicalPlanCompare_EmergencyCare")
    public WebElement getTxtCompareHeaderEmergencyCareOut;

    @FindBy(xpath = "//td[normalize-space()='Urgent Care Centers or Facilities']")
    public WebElement getTxtUrgentCare;
    @FindBy(xpath = "//td[normalize-space()='Centros o instalaciones de cuidado urgente']")
    public WebElement getTxtUrgentCareSP;
    @FindBy(xpath = "//td[normalize-space()='Emergency Room Services']")
    public WebElement getTxtEmergencyRoom;
    @FindBy(xpath = "//td[normalize-space()='Servicios de sala de emergencia']")
    public WebElement getTxtEmergencyRoomSP;
    @FindBy(xpath = "//td[normalize-space()='Emergency Transportation/ Ambulance']")
    public WebElement getTxtEmergencyTransportation;
    @FindBy(xpath = "//td[normalize-space()='Transporte de emergencia o ambulancia']")
    public WebElement getTxtEmergencyTransportationSP;


    //Header Drugs
    @FindBy(id ="MedicalPlanCompare_Drugs")
    public WebElement getTxtCompareHeaderPrescriptionDrugs;
    @FindBy(id ="MedicalPlanCompare_Drugs")
    public WebElement getTxtCompareHeaderPrescriptionDrugsOut;

    @FindBy(xpath = "//td[normalize-space()='Generic Drugs']")
    public WebElement getTxtGenericDrugs;
    @FindBy(xpath = "//td[normalize-space()='Drogas genericas']")
    public WebElement getTxtGenericDrugsSP;
    @FindBy(xpath = "//td[normalize-space()='Preferred Brand Drugs']")
    public WebElement getTxtPreferredDrugs;
    @FindBy(xpath = "//td[normalize-space()='Medicamentos de marca preferida']")
    public WebElement getTxtPreferredDrugsSP;
    @FindBy(xpath = "//td[normalize-space()='Non-Preferred Brand Drugs']")
    public WebElement getTxtNonPreferredDrugs;
    @FindBy(xpath = "//td[normalize-space()='Medicamentos de marca no preferida']")
    public WebElement getTxtNonPreferredDrugsSP;
    @FindBy(xpath = "//td[normalize-space()='Specialty Drugs']")
    public WebElement getTxtSpecialtyDrugs;
    @FindBy(xpath = "//td[normalize-space()='Medicamentos especializados']")
    public WebElement getTxtSpecialtyDrugsSP;

    //Testing Header
    @FindBy(id = "MedicalPlanCompare_Testing")
    public WebElement getTxtCompareHeaderTesting;
    @FindBy(id = "MedicalPlanCompare_Testing")
    public WebElement getTxtCompareHeaderTestingOut;

    @FindBy(xpath = "//td[normalize-space()='Laboratory Outpatient and Professional Services']")
    public WebElement getTxtLaboratoryOutpatient;
    @FindBy(xpath = "//td[normalize-space()='Servicios de laboratorio ambulatorios y profesionales']")
    public WebElement getTxtLaboratoryOutpatientSP;
    @FindBy(xpath = "//td[normalize-space()='X-rays and Diagnostic Imaging']")
    public WebElement getTxtXraysDiagnostics;
    @FindBy(xpath = "//td[normalize-space()='Radiografía y diagnóstico por imagen']")
    public WebElement getTxtXraysDiagnosticsSP;
    @FindBy(xpath = "//td[normalize-space()='Imaging (CT/PET Scans, MRIs)']")
    public WebElement getTxtImaging;
    @FindBy(xpath = "//td[normalize-space()='Estudios de Imagen (tomografía computarizada [CT], tomografía por emisión de positrones [PET], resonancia magnética [MRI])']")
    public WebElement getTxtImagingSP;

    //Facilities header

    @FindBy(id = "MedicalPlanCompare_Facilities")
    public WebElement getTxtCompareHeaderFacilities;

    @FindBy(id = "MedicalPlanCompare_Facilities")
    public WebElement getTxtCompareHeaderFacilitiesOut;

    @FindBy(xpath = "//td[normalize-space()='Outpatient Facility Fee (e.g., Ambulatory Surgery Center)']")
    public WebElement getTxtOutPatientFacility;
    @FindBy(xpath = "//td[normalize-space()='Tarifa del centro ambulatorio (p. ej., centro de cirugía ambulatoria)']")
    public WebElement getTxtOutPatientFacilitySP;
    @FindBy(xpath = "//td[normalize-space()='Outpatient Surgery Physician/Surgical Services']")
    public WebElement getTxtOutPatientSurgery;
    @FindBy(xpath = "//td[normalize-space()='Servicios médicos y quirúrgicos en cirugía ambulatoria']")
    public WebElement getTxtOutPatientSurgerySP;
    @FindBy(xpath = "//td[normalize-space()='Inpatient Hospital Services (e.g., Hospital Stay)']")
    public WebElement getTxtInpatientHospital;
    @FindBy(xpath = "//td[normalize-space()='Servicios en hospitalización (p. ej., permanencia en el hospital)']")
    public WebElement getTxtInpatientHospitalSP;
    @FindBy(xpath = "//td[normalize-space()='Inpatient Physician and Surgical Services']")
    public WebElement getTxtInPatientPhysician;
    @FindBy(xpath = "//td[normalize-space()='Servicios médicos y quirúrgicos en hospitalización']")
    public WebElement getTxtInPatientPhysicianSP;



    //Mental Health header
    @FindBy(id = "MedicalPlanCompare_MentalHealthBenefits")
    public WebElement getTxtCompareHeaderMentalHealth;
    @FindBy(id = "MedicalPlanCompare_MentalHealthBenefits")
    public WebElement getTxtCompareHeaderMentalHealthOut;

    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Office Visit']")
    public WebElement getTxtMentalBehavioralHealthOffice;
    @FindBy(xpath = "//td[normalize-space()='Consulta médica de salud mental y conductual']")
    public WebElement getTxtMentalBehavioralHealthOfficeSP;
    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Outpatient Services']")
    public WebElement getTxtBehavioralOutpatient;
    @FindBy(xpath = "//td[normalize-space()='Servicios de salud mental y conductual para pacientes ambulatorios']")
    public WebElement getTxtBehavioralOutpatientSP;
    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Inpatient Services']")
    public WebElement getTxtBehavioralInpatient;
    @FindBy(xpath = "//td[normalize-space()='Servicios de salud mental y conductual para pacientes hospitalizados']")
    public WebElement getTxtBehavioralInpatientSP;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Office Visit']")
    public WebElement getTxtSubstanceAbuseDisorderOffice;
    @FindBy(xpath = "//td[normalize-space()='Consulta médica por trastorno por abuso de sustancias']")
    public WebElement getTxtSubstanceAbuseDisorderOfficeSP;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Outpatient Services']")
    public WebElement getTxtSubstanceAbuseOutpatient;
    @FindBy(xpath = "//td[normalize-space()='Servicios de abuso de sustancias para pacientes ambulatorios']")
    public WebElement getTxtSubstanceAbuseOutpatientSP;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Inpatient Services']")
    public WebElement getTxtSubstanceAbuseInpatient;
    @FindBy(xpath = "//td[normalize-space()='Servicios de abuso de sustancias para pacientes hospitalizados']")
    public WebElement getTxtSubstanceAbuseInpatientSP;


    // Habilitative and Rehabilitiative Header
    @FindBy(id = "MedicalPlanCompare_HabilitativeAndRehabilitativeServices")
    public WebElement getTxtCompareHeaderHabRehab;
    @FindBy(id = "MedicalPlanCompare_HabilitativeAndRehabilitativeServices")
    public WebElement getTxtCompareHeaderHabRehabOut;

    @FindBy(xpath = "//td[normalize-space()='Habilitation Services']")
    public WebElement getTxtHAbServices;
    @FindBy(xpath = "//td[normalize-space()='Servicios de habilitación']")
    public WebElement getTxtHAbServicesSP;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Speech Therapy']")
    public WebElement getTxtRehabSpeech;
    @FindBy(xpath = "//td[normalize-space()='Terapia para rehabilitación del habla']")
    public WebElement getTxtRehabSpeechSP;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Occupational Therapy']")
    public WebElement getTxtRehabOccupational;
    @FindBy(xpath = "//td[normalize-space()='Terapia para rehabilitación ocupacional']")
    public WebElement getTxtRehabOccupationalSP;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Physical Therapy']")
    public WebElement getTxtRehabPhysical;
    @FindBy(xpath = "//td[normalize-space()='Terapia para fisioterapia']")
    public WebElement getTxtRehabPhysicalSP;


    //Medical Devices Header
    @FindBy(id="MedicalPlanCompare_MedicalDevices")
    public WebElement getTxtCompareHeaderMedicalDevices;
    @FindBy(id="MedicalPlanCompare_MedicalDevices")
    public WebElement getTxtCompareHeaderMedicalDevicesOut;

    @FindBy(xpath = "//td[normalize-space()='Durable Medical Equipment']")
    public WebElement getTxtDurableMedical;
    @FindBy(xpath = "//td[normalize-space()='Equipo médico duradero']")
    public WebElement getTxtDurableMedicalSP;
    @FindBy(xpath = "//td[normalize-space()='Prosthetic Devices']")
    public WebElement getTxtProstheticDevices;
    @FindBy(xpath = "//td[normalize-space()='Dispositivos prostéticos']")
    public WebElement getTxtProstheticDevicesSP;

    //Maternity header
    @FindBy(id = "MedicalPlanCompare_Maternity")
    public WebElement getTxtCompareHeaderMaternity;
    @FindBy(id = "MedicalPlanCompare_Maternity")
    public WebElement getTxtCompareHeaderMaternityOut;

    @FindBy(xpath = "//td[normalize-space()='Prenatal and Postnatal Care']")
    public WebElement getTxtPrenatal;
    @FindBy(xpath = "//td[normalize-space()='Atención prenatal y posnatal']")
    public WebElement getTxtPrenatalSP;
    @FindBy(xpath = "//td[normalize-space()='Delivery and All Inpatient Services for Maternity Care']")
    public WebElement getTxtDelivery;
    @FindBy(xpath = "//td[normalize-space()='Parto y todos los servicios hospitalarios para atención de maternidad']")
    public WebElement getTxtDeliverySP;

    // Home Care and Hospice Header
    @FindBy(id ="MedicalPlanCompare_HomeCareAndHospice")
    public WebElement getTxtCompareHeaderHomeCare;
    @FindBy(id = "MedicalPlanCompare_HomeCareAndHospice")
    public WebElement getTxtCompareHeaderHomeCareOut;

    @FindBy(xpath = "//td[normalize-space()='Home Health Care Services']")
    public WebElement getTxtHomeCare;
    @FindBy(xpath = "//td[normalize-space()='Servicios de atención médica domiciliaria']")
    public WebElement getTxtHomeCareSP;
    @FindBy(xpath = "//td[normalize-space()='Hospice Services']")
    public WebElement getTxtHospiceServices;
    @FindBy(xpath = "//td[normalize-space()='Servicios a pacientes con enfermedades terminales']")
    public WebElement getTxtHospiceServicesSP;


    // Additional EHB Benefits
    @FindBy(id="MedicalPlanCompare_AdditionalBenefits")
    public WebElement getTxtCompareHeaderAddEHB;
    @FindBy(id = "MedicalPlanCompare_AdditionalBenefits")
    public WebElement getTxtCompareHeaderAddEHBOut;

    @FindBy(xpath = "//td[normalize-space()='Chiropractic Care']")
    public WebElement getTxtIChiroCare;
    @FindBy(xpath = "//td[normalize-space()='Atención quiropráctica]")
    public WebElement getTxtIChiroCareSP;
    @FindBy(xpath = "//td[normalize-space()='Bariatric Surgery']")
    public WebElement getTxtBarCare;
    @FindBy(xpath = "//td[normalize-space()='Cirugía bariátrica']")
    public WebElement getTxtBarCareSP;
    @FindBy(xpath = "//td[normalize-space()='Infertility Treatment']")
    public WebElement getTxtInfertilityTreatment;
    @FindBy(xpath = "//td[normalize-space()='Tratamiento de infertilidad']")
    public WebElement getTxtInfertilityTreatmentSP;


    @FindBy(id= "MedicalComparePlans-GoBackToPlans")
    public WebElement goBackToPlansCompareButton;


    /////////////////////////////////////////////////////////////////////
    /// Plan Documents
    // column 1
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_1_1")
    public WebElement planDocEnglish11;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_1_2")
    public WebElement planDocEnglish12;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_1_3")
    public WebElement planDocEnglish13;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_1_4")
    public WebElement  planDocEnglish14;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_1_5")
    public WebElement planDocEnglish15;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_1_6")
    public WebElement  planDocEnglish16;


    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_1_1")
    public WebElement planDocSpanish11;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_1_2")
    public WebElement planDocSpanish12;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_1_3")
    public WebElement planDocSpanish13;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_1_4")
    public WebElement planDocSpanish14;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_1_5")
    public WebElement planDocSpanish15;

    // column 2
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_2_1")
    public WebElement planDocEnglish21;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_2_2")
    public WebElement planDocEnglish22;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_2_3")
    public WebElement planDocEnglish23;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_4")
    public WebElement planDocEnglish24;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_5")
    public WebElement planDocEnglish25;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_6")
    public WebElement planDocEnglish26;

    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_1")
    public WebElement planDocSpanish21;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_2")
    public WebElement planDocSpanish22;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_3")
    public WebElement planDocSpanish23;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_4")
    public WebElement planDocSpanish24;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_2_5")
    public WebElement planDocSpanish25;


    // column 3
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_3_1")
    public WebElement planDocEnglish31;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_3_2")
    public WebElement planDocEnglish32;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsEnglish_3_3")
    public WebElement planDocEnglish33;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_4")
    public WebElement planDocEnglish34;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_5")
    public WebElement planDocEnglish35;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_6")
    public WebElement planDocEnglish36;

    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_1")
    public WebElement planDocSpanish31;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_2")
    public WebElement planDocSpanish32;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_3")
    public WebElement planDocSpanish33;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_4")
    public WebElement planDocSpanish34;
    @FindBy(id= "MedicalPlanCompare_PlanDocumentsSpanish_3_5")
    public WebElement planDocSpanish35;

    ///////////////////////////////////////////////////////////////////////

    public void selectInNetworkTier2Link(){
        basicActions.waitForElementToDisappear( spinner,20 );
        selectInNetworkTier2Link.click();
    }

    public void selectInNetworkTier1Link(){
        basicActions.waitForElementToDisappear( spinner,20 );
        selectInNetworkTier1Link.click();
    }

    public void selectOutofNetworkLink(){
        basicActions.waitForElementToDisappear( spinner,20 );
        selectOutofNetworkLink.click();
    }

    public void validate2InNetworkTierTabs(){
        basicActions.waitForElementToDisappear( spinner,20 );
        selectInNetworkTier2Link.click();
        //selectOutofNetworkLink.click();
        selectInNetworkTier1Link.click();

    }

    public void clickComparePlanDetailLinkCoCoPage(){
        basicActions.waitForElementToDisappear(spinner, 20);
        clickComparePlanDetailLinkCoCo1.click();
    }


    public void validateDocumentationComparePlan(String carrier){
        switch(carrier){
            case "2":
                validateAnthemCignaKaiserdocumentcolumns();
                break;
            case "3":
                validateRockySelectdocumentcolumns();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + carrier);
        }
    }

    // column1
    public void validateAnthemCignaKaiserdocumentcolumns(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(1).click();
        basicActions.waitForElementToBePresent( planDocEnglish11,30 );
        softAssert.assertEquals( planDocEnglish11.getText(), "Summary of Benefits and Coverage CO Supplement Anthem BCBS English 0220104-06" );
        softAssert.assertEquals( planDocEnglish12.getText(), "Evidence of Coverage Anthem BCBS English 0220104-06" );
        softAssert.assertEquals( planDocEnglish13.getText(), "Summary of Benefits and Coverage Anthem BCBS English 0220104-06" );
        softAssert.assertEquals( planDocEnglish14.getText(), "Quality Overview Anthem English" );
        softAssert.assertEquals( planDocEnglish15.getText(), "Brochure Anthem Medical English" );
        softAssert.assertEquals( planDocEnglish16.getText(), "Provider Network Anthem Pathway Essentials" );

        softAssert.assertEquals( planDocSpanish11.getText(), "Summary of Benefits and Coverage CO Supplement Anthem BCBS Spanish 0220104-06" );
        softAssert.assertEquals( planDocSpanish12.getText(), "Evidence of Coverage Anthem BCBS Spanish 0220104-06" );
        softAssert.assertEquals( planDocSpanish13.getText(), "Summary of Benefits and Coverage Anthem BCBS Spanish 0220104-06" );
        softAssert.assertEquals( planDocSpanish14.getText(), "Quality Overview Anthem Spanish" );
        softAssert.assertEquals( planDocEnglish15.getText(), "Brochure Anthem Medical Spanish" );

        softAssert.assertEquals( planDocEnglish21.getText(), "Summary of Benefits and Coverage CO Supplement Cigna English 0060033-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish22.getText(), "Evidence of Coverage Cigna English 0060033-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish23.getText(), "Summary of Benefits and Coverage Cigna English 0060033-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish24.getText(), "Quality Overview Cigna English" );
        softAssert.assertEquals( planDocEnglish25.getText(), "Brochure Cigna English" );
        softAssert.assertEquals( planDocEnglish26.getText(), "Provider Network Cigna" );

        softAssert.assertEquals( planDocSpanish21.getText(), "Summary of Benefits and Coverage CO Supplement Cigna Spanish 0060033-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish22.getText(), "Evidence of Coverage Cigna Spanish 0060033-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish23.getText(), "Summary of Benefits and Coverage Cigna Spanish 0060033-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish24.getText(), "Quality Overview Cigna Spanish" );
        softAssert.assertEquals( planDocEnglish25.getText(), "Brochure Cigna Spanish" );

        softAssert.assertEquals( planDocEnglish31.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente English 1040002-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish32.getText(), "Evidence of Coverage Kaiser Permanente English 1040002-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish33.getText(), "Summary of Benefits and Coverage Kaiser Permanente English 1040002-06 Colorado Option" );
        softAssert.assertEquals( planDocEnglish34.getText(), "Quality Overview Kaiser Permanente English" );
        softAssert.assertEquals( planDocEnglish35.getText(), "Brochure Kaiser Permanente English" );
        softAssert.assertEquals( planDocEnglish36.getText(), "Provider Network Kaiser Permanente CO Option" );

        softAssert.assertEquals( planDocSpanish31.getText(), "Summary of Benefits and Coverage Kaiser Permanente Spanish 1040002-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish32.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente Spanish 1040002-06 Colorado Option" );
        softAssert.assertEquals( planDocSpanish33.getText(), "Quality Overview Kaiser Permanente Spanish" );
        softAssert.assertEquals( planDocSpanish34.getText(), "Evidence of Coverage Kaiser Permanente Spanish 1040002-06 Colorado Option" );
        //softAssert.assertEquals( planDocEnglish35.getText(), "" );
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



    public void validateTextComparePlanCoCoPageInNetwork(String language){
        switch(language){
            case "English":
            verifyEnglishTextPlanCompareCoCoPageInNetwork();
                break;
            case "Spanish":
            verifySpanishTextPlanCompareCoCoPageInNetwork();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
    }
}

    public void validateTextComparePlanCoCoPageOutNetwork(String language){
        switch(language){
            case "English":
                verifyEnglishTextPlanCompareCoCoPageOutNetwork();
                break;
            case "Spanish":
               // verifySpanishTextPlanCompareCoCoPageOutNetwork();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyEnglishTextPlanCompareCoCoPageInNetwork(){
            basicActions.waitForElementToDisappear( spinner,60 );
            //basicActions.waitForElementToBePresent(compareTopHeader,50);
            //softAssert.assertEquals( compareTopHeader.getText(), "Compare Medical Plans" );
            softAssert.assertEquals( downloadPDF.getText(), "Download PDF");
            softAssert.assertEquals(goBackToPlansCompareLink.getText(),"Go Back to Plans");
            //softAssert.assertEquals( linkViewDetails1.getText(), "Plan Details" );
            //softAssert.assertEquals( linkViewDetails2.getText(), "Plan Details" );
            //softAssert.assertEquals( linkViewDetails3.getText(), "Plan Details" );
            //softAssert.assertEquals( selectfirstplan.getText(), "Select Plan" );
            //softAssert.assertEquals( selectSecondplan.getText(), "Select Plan" );
            //softAssert.assertEquals( selectThirdplan.getText(), "Select Plan" );
            basicActions.scrollToElement( selectInNetworkTier1Link );
            basicActions.waitForElementToBePresent( selectInNetworkTier1Link,30 );
            softAssert.assertEquals( selectInNetworkTier1Link.getText(),"In-Network" );
            //softAssert.assertEquals( selectInNetworkTier2Link.getText(),"In-Network (Tier 2)" );
            softAssert.assertEquals( selectOutofNetworkLink.getText(),"Out-of-Network" );

            //softAssert.assertEquals( headerHighlights.getText(),"Highlights" );
            softAssert.assertEquals( txtCompareHeaderMonthlyCost.getText(),"Monthly Cost" );
            softAssert.assertEquals( txtCompareHeaderDeductible.getText(),"Deductible" );
            softAssert.assertEquals( txtCompareHeaderCoinsurance.getText(), "Coinsurance" );
            softAssert.assertEquals( txtCompareHeaderOutOfPocket.getText(),"Out-of-Pocket Max" );
            softAssert.assertEquals( txtCompareHeaderOverallQualityRating.getText(), "Overall Quality Rating");

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(1).click();
        // future - create a separate test for plan document sublinks checks - all 6 plans
            //softAssert.assertEquals( getTxtHeaderPlanDocuments.getText(), "Plan Documents" );
            //softAssert.assertEquals( getTxtPlanDocumentsEnglish.getText(), "Plan Documents\n" + "(English)" );
            //softAssert.assertEquals( getTxtPlanDocumentsSpanish.getText(), "Plan Documents\n" + "(En español)" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(2).click();
        basicActions.scrollToElement( getTxtSubheaderDoctorVisits );
        basicActions.waitForElementToBePresent( getTxtSubheaderDoctorVisits,50 );
            softAssert.assertEquals( getTxtSubheaderDoctorVisits.getText(),"Doctor Visits" );
            softAssert.assertEquals( getTxtPreventativeCare.getText(), "Preventive Care/ Screening/ Immunization");
            softAssert.assertEquals( getTxtPrimaryCare.getText(), "Primary Care Visit to Treat an Injury or Illness");
            softAssert.assertEquals( getTxtSpecialistVisit.getText(),"Specialist Visit" );
            softAssert.assertEquals( getTxtTelehealthPCP.getText(),"Telehealth PCP" );
            softAssert.assertEquals( getTxtTelehealthSpecialist.getText(),"Telehealth Specialist" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(3).click();
        basicActions.scrollToElement( getTxtCompareHeaderEmergencyCare );
        basicActions.waitForElementToBePresent(getTxtCompareHeaderEmergencyCare,50);
            softAssert.assertEquals( getTxtCompareHeaderEmergencyCare.getText(),"Emergency Care" );
            softAssert.assertEquals( getTxtUrgentCare.getText(),"Urgent Care Centers or Facilities" );
            softAssert.assertEquals( getTxtEmergencyRoom.getText(),"Emergency Room Services" );
            softAssert.assertEquals( getTxtEmergencyTransportation.getText(),"Emergency Transportation/ Ambulance" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(4).click();
        basicActions.scrollToElement( getTxtCompareHeaderPrescriptionDrugs );
        basicActions.waitForElementToBePresent( getTxtCompareHeaderPrescriptionDrugs,50 );
            softAssert.assertEquals( getTxtCompareHeaderPrescriptionDrugs.getText(), "Drugs" );
            softAssert.assertEquals( getTxtGenericDrugs.getText(), "Generic Drugs" );
            softAssert.assertEquals( getTxtPreferredDrugs.getText(), "Preferred Brand Drugs" );
            softAssert.assertEquals( getTxtNonPreferredDrugs.getText(), "Non-Preferred Brand Drugs" );
            softAssert.assertEquals( getTxtSpecialtyDrugs.getText(), "Specialty Drugs" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(5).click();
        basicActions.scrollToElement( getTxtCompareHeaderTesting );
        basicActions.waitForElementToBePresent(getTxtCompareHeaderTesting, 50  );
            softAssert.assertEquals( getTxtCompareHeaderTesting.getText(), "Testing" );
            softAssert.assertEquals( getTxtLaboratoryOutpatient.getText(), "Laboratory Outpatient and Professional Services" );
            softAssert.assertEquals( getTxtXraysDiagnostics.getText(), "X-rays and Diagnostic Imaging" );
            softAssert.assertEquals( getTxtImaging.getText(), "Imaging (CT/PET Scans, MRIs)" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(6).click();
        basicActions.scrollToElement( getTxtCompareHeaderFacilities );
        basicActions.waitForElementToBePresent( getTxtCompareHeaderFacilities,50 );
            softAssert.assertEquals( getTxtCompareHeaderFacilities.getText(), "Facilities" );
            softAssert.assertEquals( getTxtOutPatientFacility.getText(), "Outpatient Facility Fee (e.g., Ambulatory Surgery Center)" );
            softAssert.assertEquals( getTxtOutPatientSurgery.getText(), "Outpatient Surgery Physician/Surgical Services" );
            softAssert.assertEquals( getTxtInpatientHospital.getText(), "Inpatient Hospital Services (e.g., Hospital Stay)" );
            softAssert.assertEquals( getTxtInPatientPhysician.getText(), "Inpatient Physician and Surgical Services" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(7).click();
        basicActions.scrollToElement( getTxtCompareHeaderMentalHealth );
        basicActions.waitForElementToBePresent(getTxtCompareHeaderMentalHealth,50);
            softAssert.assertEquals( getTxtCompareHeaderMentalHealth.getText(), "Mental Health Benefits" );
            softAssert.assertEquals( getTxtMentalBehavioralHealthOffice.getText(), "Mental/Behavioral Health Office Visit" );
            softAssert.assertEquals( getTxtBehavioralOutpatient.getText(), "Mental/Behavioral Health Outpatient Services" );
            softAssert.assertEquals( getTxtBehavioralInpatient.getText(), "Mental/Behavioral Health Inpatient Services" );
            softAssert.assertEquals( getTxtSubstanceAbuseDisorderOffice.getText(), "Substance Abuse Disorder Office Visit" );
            softAssert.assertEquals( getTxtSubstanceAbuseOutpatient.getText(), "Substance Abuse Disorder Outpatient Services" );
            softAssert.assertEquals( getTxtSubstanceAbuseInpatient.getText(), "Substance Abuse Disorder Inpatient Services" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(8).click();
        basicActions.scrollToElement(getTxtCompareHeaderHabRehab);
        basicActions.waitForElementToBePresent( getTxtCompareHeaderHabRehab,50 );
            softAssert.assertEquals( getTxtCompareHeaderHabRehab.getText(),"Habilitative and Rehabilitative Services" );
            softAssert.assertEquals( getTxtHAbServices.getText(),"Habilitation Services" );
            softAssert.assertEquals( getTxtRehabSpeech.getText(),"Rehabilitative Speech Therapy" );
            softAssert.assertEquals( getTxtRehabOccupational.getText(),"Rehabilitative Occupational Therapy" );
            softAssert.assertEquals( getTxtRehabPhysical.getText(),"Rehabilitative Physical Therapy" );


        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(9).click();
        basicActions.scrollToElement( getTxtCompareHeaderMedicalDevices );
        basicActions.waitForElementToBePresent( getTxtCompareHeaderMedicalDevices,50 );
            softAssert.assertEquals( getTxtCompareHeaderMedicalDevices.getText(),"Medical Devices" );
            softAssert.assertEquals( getTxtDurableMedical.getText(),"Durable Medical Equipment" );
            softAssert.assertEquals( getTxtProstheticDevices.getText(),"Prosthetic Devices" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(10).click();
        basicActions.scrollToElement( getTxtCompareHeaderMaternity );
            softAssert.assertEquals( getTxtCompareHeaderMaternity.getText(), "Maternity"  );
            softAssert.assertEquals( getTxtPrenatal.getText(), "Prenatal and Postnatal Care"  );
            softAssert.assertEquals( getTxtDelivery.getText(), "Delivery and All Inpatient Services for Maternity Care"  );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(11).click();
        basicActions.scrollToElement(  getTxtCompareHeaderHomeCare);
            softAssert.assertEquals( getTxtCompareHeaderHomeCare.getText(), "Home Care & Hospice"  );
            softAssert.assertEquals( getTxtHomeCare.getText(), "Home Health Care Services"  );
            softAssert.assertEquals( getTxtHospiceServices.getText(), "Hospice Services"  );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(12).click();
        basicActions.scrollToElement( getTxtCompareHeaderAddEHB );
            softAssert.assertEquals( getTxtCompareHeaderAddEHB.getText(),"Additional Benefits");
            softAssert.assertEquals( getTxtIChiroCare.getText(),"Chiropractic Care");
            softAssert.assertEquals( getTxtBarCare.getText(),"Bariatric Surgery");
            softAssert.assertEquals( getTxtInfertilityTreatment.getText(),"Infertility Treatment");

            softAssert.assertEquals( goBackToPlansCompareButton.getText(),"Go Back to Plans");
            softAssert.assertAll();
        basicActions.click( toTop );
        }

    public void verifyEnglishTextPlanCompareCoCoPageOutNetwork(){
        basicActions.waitForElementToDisappear( spinner,60 );
        //basicActions.waitForElementToBePresent(compareTopHeader,50);
        //softAssert.assertEquals( compareTopHeader.getText(), "Compare Medical Plans" );
        softAssert.assertEquals( downloadPDF.getText(), "Download PDF");
        softAssert.assertEquals(goBackToPlansCompareLink.getText(),"Go Back to Plans");
        //softAssert.assertEquals( linkViewDetails1.getText(), "Plan Details" );
        //softAssert.assertEquals( linkViewDetails2.getText(), "Plan Details" );
        //softAssert.assertEquals( linkViewDetails3.getText(), "Plan Details" );
        //softAssert.assertEquals( selectfirstplan.getText(), "Select Plan" );
        //softAssert.assertEquals( selectSecondplan.getText(), "Select Plan" );
        //softAssert.assertEquals( selectThirdplan.getText(), "Select Plan" );
        basicActions.scrollToElement( selectInNetworkTier1Link );
        basicActions.waitForElementToBePresent( selectInNetworkTier1Link,30 );
        softAssert.assertEquals( selectInNetworkTier1Link.getText(),"In-Network" );
        //softAssert.assertEquals( selectInNetworkTier2Link.getText(),"In-Network (Tier 2)" );
        softAssert.assertEquals( selectOutofNetworkLink.getText(),"Out-of-Network" );

        //softAssert.assertEquals( headerHighlights.getText(),"Highlights" );
        softAssert.assertEquals( txtCompareHeaderMonthlyCost.getText(),"Monthly Cost" );
        softAssert.assertEquals( txtCompareHeaderDeductible.getText(),"Deductible" );
        softAssert.assertEquals( txtCompareHeaderCoinsurance.getText(), "Coinsurance" );
        softAssert.assertEquals( txtCompareHeaderOutOfPocket.getText(),"Out-of-Pocket Max" );
        softAssert.assertEquals( txtCompareHeaderOverallQualityRating.getText(), "Overall Quality Rating");

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(1).click();
        // future - create a separate test for plan document sublinks checks - all 6 plans
        softAssert.assertEquals( getTxtHeaderPlanDocuments.getText(), "Plan Documents" );
        softAssert.assertEquals( getTxtPlanDocumentsEnglish.getText(), "Plan Documents\n" + "(English)" );
        softAssert.assertEquals( getTxtPlanDocumentsSpanish.getText(), "Plan Documents\n" + "(En español)" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(2).click();
        basicActions.scrollToElement( getTxtSubheaderDoctorVisits );
        basicActions.waitForElementToBePresent( getTxtSubheaderDoctorVisits,50 );
        softAssert.assertEquals( getTxtSubheaderDoctorVisits.getText(),"Doctor Visits" );
        softAssert.assertEquals( getTxtPreventativeCare.getText(), "Preventive Care/ Screening/ Immunization");
        softAssert.assertEquals( getTxtPrimaryCare.getText(), "Primary Care Visit to Treat an Injury or Illness");
        softAssert.assertEquals( getTxtSpecialistVisit.getText(),"Specialist Visit" );
        softAssert.assertEquals( getTxtTelehealthPCP.getText(),"Telehealth PCP" );
        softAssert.assertEquals( getTxtTelehealthSpecialist.getText(),"Telehealth Specialist" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(3).click();
        basicActions.scrollToElement( getTxtCompareHeaderEmergencyCare );
        basicActions.waitForElementToBePresent(getTxtCompareHeaderEmergencyCare,50);
        softAssert.assertEquals( getTxtCompareHeaderEmergencyCare.getText(),"Emergency Care" );
        softAssert.assertEquals( getTxtUrgentCare.getText(),"Urgent Care Centers or Facilities" );
        softAssert.assertEquals( getTxtEmergencyRoom.getText(),"Emergency Room Services" );
        softAssert.assertEquals( getTxtEmergencyTransportation.getText(),"Emergency Transportation/ Ambulance" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(4).click();
        basicActions.scrollToElement( getTxtCompareHeaderPrescriptionDrugs );
        basicActions.waitForElementToBePresent( getTxtCompareHeaderPrescriptionDrugs,50 );
        softAssert.assertEquals( getTxtCompareHeaderPrescriptionDrugs.getText(), "Drugs" );
        softAssert.assertEquals( getTxtGenericDrugs.getText(), "Generic Drugs" );
        softAssert.assertEquals( getTxtPreferredDrugs.getText(), "Preferred Brand Drugs" );
        softAssert.assertEquals( getTxtNonPreferredDrugs.getText(), "Non-Preferred Brand Drugs" );
        softAssert.assertEquals( getTxtSpecialtyDrugs.getText(), "Specialty Drugs" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(5).click();
        basicActions.scrollToElement( getTxtCompareHeaderTesting );
        basicActions.waitForElementToBePresent(getTxtCompareHeaderTesting, 50  );
        softAssert.assertEquals( getTxtCompareHeaderTesting.getText(), "Testing" );
        softAssert.assertEquals( getTxtLaboratoryOutpatient.getText(), "Laboratory Outpatient and Professional Services" );
        softAssert.assertEquals( getTxtXraysDiagnostics.getText(), "X-rays and Diagnostic Imaging" );
        softAssert.assertEquals( getTxtImaging.getText(), "Imaging (CT/PET Scans, MRIs)" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(6).click();
        basicActions.scrollToElement( getTxtCompareHeaderFacilities );
        basicActions.waitForElementToBePresent( getTxtCompareHeaderFacilities,50 );
        softAssert.assertEquals( getTxtCompareHeaderFacilities.getText(), "Facilities" );
        softAssert.assertEquals( getTxtOutPatientFacility.getText(), "Outpatient Facility Fee (e.g., Ambulatory Surgery Center)" );
        softAssert.assertEquals( getTxtOutPatientSurgery.getText(), "Outpatient Surgery Physician/Surgical Services" );
        softAssert.assertEquals( getTxtInpatientHospital.getText(), "Inpatient Hospital Services (e.g., Hospital Stay)" );
        softAssert.assertEquals( getTxtInPatientPhysician.getText(), "Inpatient Physician and Surgical Services" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(7).click();
        basicActions.scrollToElement( getTxtCompareHeaderMentalHealth );
        basicActions.waitForElementToBePresent(getTxtCompareHeaderMentalHealth,50);
        softAssert.assertEquals( getTxtCompareHeaderMentalHealth.getText(), "Mental Health Benefits" );
        softAssert.assertEquals( getTxtMentalBehavioralHealthOffice.getText(), "Mental/Behavioral Health Office Visit" );
        softAssert.assertEquals( getTxtBehavioralOutpatient.getText(), "Mental/Behavioral Health Outpatient Services" );
        softAssert.assertEquals( getTxtBehavioralInpatient.getText(), "Mental/Behavioral Health Inpatient Services" );
        softAssert.assertEquals( getTxtSubstanceAbuseDisorderOffice.getText(), "Substance Abuse Disorder Office Visit" );
        softAssert.assertEquals( getTxtSubstanceAbuseOutpatient.getText(), "Substance Abuse Disorder Outpatient Services" );
        softAssert.assertEquals( getTxtSubstanceAbuseInpatient.getText(), "Substance Abuse Disorder Inpatient Services" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(8).click();
        basicActions.scrollToElement(getTxtCompareHeaderHabRehab);
        basicActions.waitForElementToBePresent( getTxtCompareHeaderHabRehab,50 );
        softAssert.assertEquals( getTxtCompareHeaderHabRehab.getText(),"Habilitative and Rehabilitative Services" );
        softAssert.assertEquals( getTxtHAbServices.getText(),"Habilitation Services" );
        softAssert.assertEquals( getTxtRehabSpeech.getText(),"Rehabilitative Speech Therapy" );
        softAssert.assertEquals( getTxtRehabOccupational.getText(),"Rehabilitative Occupational Therapy" );
        softAssert.assertEquals( getTxtRehabPhysical.getText(),"Rehabilitative Physical Therapy" );


        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(9).click();
        basicActions.scrollToElement( getTxtCompareHeaderMedicalDevices );
        basicActions.waitForElementToBePresent( getTxtCompareHeaderMedicalDevices,50 );
        softAssert.assertEquals( getTxtCompareHeaderMedicalDevices.getText(),"Medical Devices" );
        softAssert.assertEquals( getTxtDurableMedical.getText(),"Durable Medical Equipment" );
        softAssert.assertEquals( getTxtProstheticDevices.getText(),"Prosthetic Devices" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(10).click();
        basicActions.scrollToElement( getTxtCompareHeaderMaternity );
        softAssert.assertEquals( getTxtCompareHeaderMaternity.getText(), "Maternity"  );
        softAssert.assertEquals( getTxtPrenatal.getText(), "Prenatal and Postnatal Care"  );
        softAssert.assertEquals( getTxtDelivery.getText(), "Delivery and All Inpatient Services for Maternity Care"  );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(11).click();
        basicActions.scrollToElement(  getTxtCompareHeaderHomeCare);
        softAssert.assertEquals( getTxtCompareHeaderHomeCare.getText(), "Home Care & Hospice"  );
        softAssert.assertEquals( getTxtHomeCare.getText(), "Home Health Care Services"  );
        softAssert.assertEquals( getTxtHospiceServices.getText(), "Hospice Services"  );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(12).click();
        basicActions.scrollToElement( getTxtCompareHeaderAddEHB );
        softAssert.assertEquals( getTxtCompareHeaderAddEHB.getText(),"Additional Benefits");
        softAssert.assertEquals( getTxtIChiroCare.getText(),"Chiropractic Care");
        softAssert.assertEquals( getTxtBarCare.getText(),"Bariatric Surgery");
        softAssert.assertEquals( getTxtInfertilityTreatment.getText(),"Infertility Treatment");

        softAssert.assertEquals( goBackToPlansCompareButton.getText(),"Go Back to Plans");
        softAssert.assertAll();
        basicActions.click( toTop );
    }

    public void verifySpanishTextPlanCompareCoCoPageInNetwork(){
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent(compareTopHeader,20);
            //softAssert.assertEquals( compareTopHeader.getText(), "Comparar planes médicos" );
        softAssert.assertEquals( downloadPDF.getText(), "Descargar PDF");
        softAssert.assertEquals(goBackToPlansCompareLink.getText(),"Volver a Planes");
            //softAssert.assertEquals( linkViewDetails1.getText(), "Detalles Del Plan" );
            //softAssert.assertEquals( linkViewDetails2.getText(), "Detalles Del Plan" );
            //softAssert.assertEquals( linkViewDetails3.getText(), "Detalles Del Plan" );
            //softAssert.assertEquals( selectfirstplan.getText(), " Seleccione este Plan " );
            //softAssert.assertEquals( selectSecondplan.getText(), " Seleccione este Plan " );
            //softAssert.assertEquals( selectThirdplan.getText(), " Seleccione este Plan " );
        softAssert.assertEquals( selectInNetworkTier1Link.getText()," Dentro la red " );
            //softAssert.assertEquals( selectInNetworkTier2Link.getText(),"In-Network (Tier 2)" );
        softAssert.assertEquals( selectOutofNetworkLink.getText(),"Fuera de la red" );


        softAssert.assertEquals( getDrpDwnPlanCategories.get(1).getText(),"Aspectos destacados" );
        softAssert.assertEquals( txtCompareHeaderMonthlyCostSP.getText(),"Costo mensual" );
        softAssert.assertEquals( txtCompareHeaderDeductibleSP.getText(),"Deducible" );
        softAssert.assertEquals( txtCompareHeaderCoinsuranceSP.getText(), "Coseguro" );
        softAssert.assertEquals( txtCompareHeaderOutOfPocketSP.getText(),"Desembolso m\u00E1ximo" );
        softAssert.assertEquals( txtCompareHeaderOverallQualityRatingSP.getText(), "Calificaci\u00F3n de calidad general" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(2).click();
        // future - create a separate test for plan document sublinks checks - all 6 plans
        basicActions.scrollToElement( getTxtHeaderPlanDocumentsSP );
        basicActions.waitForElementToBePresentWithRetries( getTxtHeaderPlanDocumentsSP, 20 );
        softAssert.assertEquals( getTxtHeaderPlanDocumentsSP.getText(),"Documentos del plan" );
        //softAssert.assertEquals( getTxtPlanDocumentsEnglish.getText(), "Plan Documents\n" + "(English)" );
        //softAssert.assertEquals( getTxtPlanDocumentsSpanish.getText(), "Plan Documents\n" + "(En espa\u00F1ol)" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(3).click();
        //basicActions.scrollToElement( getTxtSubheaderDoctorVisitsSP );
        //softAssert.assertEquals( getTxtSubheaderDoctorVisitsSP.getText(),"Consultas con proveedores" );
        softAssert.assertEquals( getDrpDwnPlanCategories.get(3).getText(),"Consultas con proveedores" );
        softAssert.assertEquals( getTxtHeaderPlanDocumentsSP.getText(), "Atenci\u00F3n preventiva, ex\u00E1menes, inmunizaci\u00F3n" );
        softAssert.assertEquals( getTxtPreventativeCareSP.getText(), "Consulta de atenci\u00F3n primaria para tratar una lesi\u00F3n o enfermedad" );
        softAssert.assertEquals( getTxtSpecialistVisitSP.getText(),"Consulta con un especialista" );
        softAssert.assertEquals( getTxtTelehealthPCPSP.getText(),"Telemedicina PCP" );
        softAssert.assertEquals( getTxtTelehealthSpecialistSP.getText(),"Telemedicina especialista" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(4).click();
        basicActions.scrollToElement( getTxtCompareHeaderEmergencyCare );
        softAssert.assertEquals( getTxtCompareHeaderEmergencyCare.getText(), "Atenci\u00F3n de emergencia" );
        softAssert.assertEquals( getTxtUrgentCareSP.getText(),"Centros o instalaciones de cuidado urgente" );
        softAssert.assertEquals( getTxtEmergencyRoomSP.getText(),"Servicios de sala de emergencia" );
        softAssert.assertEquals( getTxtEmergencyTransportationSP.getText(),"Transporte de emergencia o ambulancia" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(5).click();
        basicActions.scrollToElement( getTxtCompareHeaderPrescriptionDrugs );
        softAssert.assertEquals( getTxtCompareHeaderPrescriptionDrugs.getText(),"Medicamentos" );
        softAssert.assertEquals( getTxtGenericDrugsSP.getText(),"Drogas genericas" );
        softAssert.assertEquals( getTxtPreferredDrugsSP.getText(),"Medicamentos de marca preferida" );
        softAssert.assertEquals( getTxtNonPreferredDrugsSP.getText(),"Medicamentos de marca no preferida" );
        softAssert.assertEquals( getTxtSpecialtyDrugsSP.getText(),"Medicamentos especializados" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(6).click();
        basicActions.scrollToElement( getTxtCompareHeaderTesting );
        softAssert.assertEquals( getTxtCompareHeaderTesting.getText(),"Pruebas" );
        softAssert.assertEquals( getTxtLaboratoryOutpatientSP.getText(),"Servicios de laboratorio ambulatorios y profesionales" );
        softAssert.assertEquals( getTxtXraysDiagnosticsSP.getText(), "Radiograf\u00EDa y diagn\u00F3stico por imagen" );
        softAssert.assertEquals( getTxtImagingSP.getText(), "Estudios de Imagen (tomograf\u00EDa computarizada [CT], tomograf\u00EDa por emisi\u00F3n de positrones [PET], resonancia magn\u00E9tica [MRI])" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(7).click();
        basicActions.scrollToElement( getTxtCompareHeaderFacilities );
        softAssert.assertEquals( getTxtCompareHeaderFacilities.getText(),"Instalaciones" );
        softAssert.assertEquals( getTxtOutPatientFacilitySP.getText(),"Tarifa del centro ambulatorio (p. ej., centro de cirugía ambulatoria)" );
        softAssert.assertEquals( getTxtOutPatientSurgerySP.getText(), "Servicios m\u00E9dicos y quir\u00FArgicos en cirug\u00EDa ambulatoria" );
        softAssert.assertEquals( getTxtInpatientHospitalSP.getText(), "Servicios en hospitalizaci\u00F3n (p. ej., permanencia en el hospital)" );
        softAssert.assertEquals( getTxtInPatientPhysicianSP.getText(),"Servicios médicos y quirúrgicos en hospitalización" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(8).click();
        basicActions.scrollToElement( getTxtCompareHeaderMentalHealth );
        softAssert.assertEquals( getTxtCompareHeaderMentalHealth.getText(),"Beneficios de salud mental" );
        softAssert.assertEquals( getTxtMentalBehavioralHealthOfficeSP.getText(), "Consulta m\u00E9dica de salud mental y conductual" );
        softAssert.assertEquals( getTxtBehavioralOutpatientSP.getText(),"Servicios de salud mental y conductual para pacientes ambulatorios" );
        softAssert.assertEquals( getTxtBehavioralInpatientSP.getText(),"Servicios de salud mental y conductual para pacientes hospitalizados" );
        softAssert.assertEquals( getTxtSubstanceAbuseDisorderOfficeSP.getText(), "Consulta m\u00E9dica por trastorno por abuso de sustancias" );
        softAssert.assertEquals( getTxtSubstanceAbuseOutpatientSP.getText(),"Servicios de abuso de sustancias para pacientes ambulatorios" );
        softAssert.assertEquals( getTxtSubstanceAbuseInpatientSP.getText(),"Servicios de abuso de sustancias para pacientes hospitalizados" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(9).click();
        basicActions.scrollToElement( getTxtCompareHeaderHabRehab );
        softAssert.assertEquals( getTxtCompareHeaderHabRehab.getText(), "Servicios de habilitaci\u00F3n y rehabilitaci\u00F3n" );
        softAssert.assertEquals( getTxtHAbServicesSP.getText(), "Servicios de habilitaci\u00F3n" );
        softAssert.assertEquals( getTxtRehabSpeechSP.getText(), "Terapia para rehabilitaci\u00F3n del habla" );
        softAssert.assertEquals( getTxtRehabOccupationalSP.getText(), "Terapia para rehabilitaci\u00F3n ocupacional" );
        softAssert.assertEquals( getTxtRehabPhysicalSP.getText(),"Terapia para fisioterapia" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(10).click();
        basicActions.scrollToElement( getTxtCompareHeaderMedicalDevices );
        softAssert.assertEquals( getTxtCompareHeaderMedicalDevices.getText(), "Dispositivos m\u00E9dicos" );
        softAssert.assertEquals( getTxtDurableMedicalSP.getText(), "Equipo m\u00E9dico duradero" );
        softAssert.assertEquals( getTxtProstheticDevicesSP.getText(), "Dispositivos prost\u00E9ticos" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(11).click();
        basicActions.scrollToElement( getTxtCompareHeaderMaternity );
        softAssert.assertEquals( getTxtCompareHeaderMaternity.getText(),"Maternidad" );
        softAssert.assertEquals( getTxtPrenatalSP.getText(), "Atenci\u00F3n prenatal y posnatal" );
        softAssert.assertEquals( getTxtDeliverySP.getText(), "Parto y todos los servicios hospitalarios para atenci\u00F3n de maternidad" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(12).click();
        basicActions.scrollToElement( getTxtCompareHeaderHomeCare );
        softAssert.assertEquals( getTxtCompareHeaderHomeCare.getText(), "Atenci\u00F3n a domicilio y a pacientes con enfermedades terminales" );
        softAssert.assertEquals( getTxtHomeCareSP.getText(), "Servicios de atenci\u00F3n m\u00E9dica domiciliaria" );
        softAssert.assertEquals( getTxtHospiceServicesSP.getText(),"Servicios a pacientes con enfermedades terminales" );

        basicActions.waitForElementListToBePresentWithRetries( getDrpDwnPlanCategories,20 );
        getDrpDwnPlanCategories.get(13).click();
        basicActions.scrollToElement( getTxtCompareHeaderAddEHB );
        softAssert.assertEquals( getTxtCompareHeaderAddEHB.getText(),"Beneficios esenciales" );
        softAssert.assertEquals( getTxtIChiroCareSP.getText(), "Atenci\u00F3n quiropr\u00E1ctica" );
        softAssert.assertEquals( getTxtBarCareSP.getText(), "Cirug\u00EDa bari\u00E1trica" );
        softAssert.assertEquals( getTxtInfertilityTreatmentSP.getText(),"Tratamiento de infertilidad" );

        softAssert.assertEquals(goBackToPlansCompareButton.getText(),"Volver a Planes");
        softAssert.assertAll();
        getDrpDwnPlanCategories.get(1).click();
        }



    public void  clickMedicalCompareGoBackLink() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent(goBackToPlansCompareLink, 20);
            goBackToPlansCompareLink.click();}

    public void  clickMedicalCompareGoBackButton() {
            basicActions.waitForElementToDisappear( spinner, 30 );
            basicActions.waitForElementToBePresent(goBackToPlansCompareButton, 20);
            goBackToPlansCompareButton.click();}

    public void selectPlanDeselectionOne() {
        basicActions.waitForElementToBeClickable( selectfirstplan,15 );
            selectfirstplan.click();}

    public void selectPlanDeselectionTwo() {
        basicActions.waitForElementToBeClickable( selectSecondplan,15 );
            selectSecondplan.click();}

    public void selectPlanDeselectionThree(){
        basicActions.waitForElementToBeClickable( selectThirdplan,15 );
            selectThirdplan.click();}

    public void verifyNoPlansSelectedTxt(){
        basicActions.waitForElementToBePresent( noTextPlan,15 );
        softAssert.assertTrue( noTextPlan.isDisplayed(), "There are no plans selected to compare" );
    }

    public void  verifyTxtCompareHeader() {
        basicActions.waitForElementToBePresent(txtCompareHeaderMonthlyPremium, 10 );
        softAssert.assertTrue(txtCompareHeaderMonthlyPremium.isDisplayed(),"Incorrect Header");
        txtCompareHeaderMonthlyPremium.click();

        softAssert.assertTrue(getTxtCompareHeaderGeneralDetails.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderGeneralDetails.click();

        //softAssert.assertTrue(getTxtCompareHeaderProviderOfficeVisits.isDisplayed(),"Incorrect Header");
        //getTxtCompareHeaderProviderOfficeVisits.click();
        softAssert.assertTrue(getTxtPreventativeCare.isDisplayed(),"Incorrect Header");
        //softAssert.assertTrue(getTxtPrimaryCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSpecialistVisit.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtTelehealthPCP.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtTelehealthSpecialist.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderPrescriptionDrugs.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderPrescriptionDrugs.click();
        softAssert.assertTrue(getTxtGenericDrugs.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtPreferredDrugs.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtNonPreferredDrugs.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSpecialtyDrugs.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderFacilities.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderFacilities.click();
        softAssert.assertTrue(getTxtOutPatientFacility.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtOutPatientSurgery.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtInpatientHospital.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtInPatientPhysician.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderMaternity.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderMaternity.click();
        softAssert.assertTrue(getTxtPrenatal.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtDelivery.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderEmergencyCare.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderEmergencyCare.click();
        softAssert.assertTrue(getTxtUrgentCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtEmergencyRoom.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtEmergencyTransportation.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderMentalHealth.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderMentalHealth.click();
        softAssert.assertTrue(getTxtBehavioralOutpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtBehavioralInpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSubstanceAbuseOutpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSubstanceAbuseInpatient.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderTesting.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderTesting.click();
        softAssert.assertTrue(getTxtLaboratoryOutpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtXraysDiagnostics.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtImaging.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderMedicalDevices.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderMedicalDevices.click();
        softAssert.assertTrue(getTxtDurableMedical.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtProstheticDevices.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderHabRehab.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderHabRehab.click();
        softAssert.assertTrue(getTxtHAbServices.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtRehabSpeech.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtRehabOccupational.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtRehabPhysical.isDisplayed(),"Incorrect Header");


        softAssert.assertTrue(getTxtCompareHeaderHomeCare.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderHomeCare.click();
        softAssert.assertTrue(getTxtHomeCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtHospiceServices.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderAddEHB.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderAddEHB.click();
        softAssert.assertTrue(getTxtIChiroCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtBarCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtInfertilityTreatment.isDisplayed(),"Incorrect Header");

    }




    public void verifyTxtOutofNetworkCompareHeader(){
        basicActions.waitForElementToBePresent(selectOutofNetworkLink, 10 );
        selectOutofNetworkLink.click();

        softAssert.assertTrue(txtCompareHeaderMonthlyPremiumOut.isDisplayed(),"Incorrect Header");
        txtCompareHeaderMonthlyPremiumOut.click();

        softAssert.assertTrue(getTxtCompareHeaderGeneralDetailsOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderGeneralDetailsOut.click();

        //softAssert.assertTrue(getTxtCompareHeaderProviderOfficeVisitsOut.isDisplayed(),"Incorrect Header");
        //getTxtCompareHeaderProviderOfficeVisitsOut.click();
        softAssert.assertTrue(getTxtPreventativeCare.isDisplayed(),"Incorrect Header");
        //softAssert.assertTrue(getTxtPrimaryCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSpecialistVisit.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtTelehealthPCP.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtTelehealthSpecialist.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderPrescriptionDrugsOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderPrescriptionDrugsOut.click();
        softAssert.assertTrue(getTxtGenericDrugs.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtPreferredDrugs.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtNonPreferredDrugs.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSpecialtyDrugs.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderFacilitiesOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderFacilitiesOut.click();
        softAssert.assertTrue(getTxtOutPatientFacility.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtOutPatientSurgery.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtInpatientHospital.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtInPatientPhysician.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderMaternityOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderMaternityOut.click();
        softAssert.assertTrue(getTxtPrenatal.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtDelivery.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderEmergencyCareOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderEmergencyCareOut.click();
        softAssert.assertTrue(getTxtUrgentCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtEmergencyRoom.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtEmergencyTransportation.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderMentalHealthOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderMentalHealthOut.click();
        softAssert.assertTrue(getTxtBehavioralOutpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtBehavioralInpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSubstanceAbuseOutpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtSubstanceAbuseInpatient.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderTestingOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderTestingOut.click();
        softAssert.assertTrue(getTxtLaboratoryOutpatient.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtXraysDiagnostics.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtImaging.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderMedicalDevicesOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderMedicalDevicesOut.click();
        softAssert.assertTrue(getTxtDurableMedical.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtProstheticDevices.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderHabRehabOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderHabRehabOut.click();
        softAssert.assertTrue(getTxtHAbServices.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtRehabSpeech.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtRehabOccupational.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtRehabPhysical.isDisplayed(),"Incorrect Header");


        softAssert.assertTrue(getTxtCompareHeaderHomeCareOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderHomeCareOut.click();
        softAssert.assertTrue(getTxtHomeCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtHospiceServices.isDisplayed(),"Incorrect Header");

        softAssert.assertTrue(getTxtCompareHeaderAddEHBOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderAddEHBOut.click();
        softAssert.assertTrue(getTxtIChiroCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtBarCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtInfertilityTreatment.isDisplayed(),"Incorrect Header");


    }

    public void verifyTextinMedicalCompare(List<String> planDetails){
        softAssert.assertEquals(planHeaderdetails.getText(), planDetails.get(0));
        softAssert.assertEquals(selectInNetworkTier1Link.getText(), planDetails.get(1));
        softAssert.assertEquals(selectOutofNetworkLink.getText(), planDetails.get(2));
        softAssert.assertEquals(drpDwnPlanDetails.get(0).getText(), planDetails.get(3));
        softAssert.assertEquals(drpDwnPlanDetails.get(1).getText(), planDetails.get(4));
        softAssert.assertEquals(drpDwnPlanDetails.get(2).getText(), planDetails.get(5));
        softAssert.assertEquals(drpDwnPlanDetails.get(3).getText(), planDetails.get(6));
        softAssert.assertEquals(drpDwnPlanDetails.get(4).getText(), planDetails.get(7));
        softAssert.assertEquals(drpDwnPlanDetails.get(5).getText(), planDetails.get(8));
        softAssert.assertEquals(drpDwnPlanDetails.get(6).getText(), planDetails.get(9));
        softAssert.assertEquals(drpDwnPlanDetails.get(7).getText(), planDetails.get(10));
        softAssert.assertEquals(drpDwnPlanDetails.get(8).getText(), planDetails.get(11));
        softAssert.assertEquals(drpDwnPlanDetails.get(9).getText(), planDetails.get(12));
        softAssert.assertEquals(drpDwnPlanDetails.get(10).getText(), planDetails.get(13));
        softAssert.assertEquals(drpDwnPlanDetails.get(11).getText(), planDetails.get(14));
        softAssert.assertEquals(drpDwnPlanDetails.get(12).getText(), planDetails.get(15));
        softAssert.assertEquals(medicalCompareGoBack.getText(),planDetails.get(16));
        softAssert.assertAll();
        medicalCompareGoBack.click();
    }

}
