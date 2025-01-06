package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class MedicalComparePage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();
    private Optional<Integer> optionalInt;

    public MedicalComparePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "ComparePlans-TopGoBackToPlans")
    WebElement goBackCompareLink;
    @FindBy(id = "ComparePlans-GoBackToPlans")
    WebElement goBackCompareBtn;

    @FindBy(id = "ComparePlans-DownloadSummaryOfThisPage")
    WebElement pdfCompareSummary;

    @FindBy(id = "PlanCompare-PlanDetails_1")
    WebElement plandetailLink1;

    @FindBy(id = "PlanCompare-PlanDetails_2")
    WebElement plandetailLink2;

    @FindBy(id = "PlanCompare-PlanDetails_3")
    WebElement plandetailLink3;

    @FindBy(id = "PlanCompare_InNetworkTab")
    WebElement inNetwork1;

    @FindBy(id = "PlanCompare_InNetworkTier2Tab")
    WebElement inNetwork2;

    @FindBy(id = "PlanCompare_OutOfNetworkTab")
    WebElement outNetwork;

    //// Header page title

    @FindBy(xpath = "//div[@class='c4-type-header-lg header-container']") // Compare Medical Plans
    WebElement headerComparePlans;


    //// Headers

    //Highliohts
    @FindBy(id = "PlanCompare_Highlights")
    WebElement txtMedicalHighlights;
    @FindBy(xpath = "//td[normalize-space()='Monthly Cost']")
    WebElement getTxtMedicalMonthlyCost;
    @FindBy(xpath = "//td[normalize-space()='Deductible']")
    WebElement getTxtMedicalDeductible;
    @FindBy(xpath = "//td[normalize-space()='Coinsurance']")
    WebElement getTxtMedicalCoInsurance;
    @FindBy(xpath = "//td[normalize-space()='Out-of-Pocket Max']")
    WebElement getTxtMedicalOutOfPocket;
    @FindBy(xpath = "//td[normalize-space()='Overall Quality Rating']")
    WebElement getTxtMedicalOverallQuality;


    //Plan Documents Column 1
    @FindBy(id = "PlanCompare_PlanDocuments")
    WebElement txtMedicalPlanDocuments;

    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_1_1")
    WebElement txtMedicalEnglishPlanDocuments11;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_1_2")
    WebElement txtMedicalEnglishPlanDocuments12;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_1_3")
    WebElement txtMedicalEnglishPlanDocuments13;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_1_4")
    WebElement txtMedicalEnglishPlanDocuments14;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_1_5")
    WebElement txtMedicalEnglishPlanDocuments15;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_1_6")
    WebElement txtMedicalEnglishPlanDocuments16;


    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_1_1")
    WebElement txtMedicalSpanPlanDocuments11;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_1_2")
    WebElement txtMedicalSpanPlanDocuments12;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_1_3")
    WebElement txtMedicalSpanPlanDocuments13;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_1_4")
    WebElement txtMedicalSpanPlanDocuments14;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_1_5")
    WebElement txtMedicalSpanPlanDocuments15;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_1_6")
    WebElement txtMedicalSpanPlanDocuments16;

    //Plan Documents Column 2
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_2_1")
    WebElement txtMedicalEnglishPlanDocuments21;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_2_2")
    WebElement txtMedicalEnglishPlanDocuments22;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_2_3")
    WebElement txtMedicalEnglishPlanDocuments23;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_2_4")
    WebElement txtMedicalEnglishPlanDocuments24;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_2_5")
    WebElement txtMedicalEnglishPlanDocuments25;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_2_6")
    WebElement txtMedicalEnglishPlanDocuments26;

    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_2_1")
    WebElement txtMedicalSpanPlanDocuments21;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_2_2")
    WebElement txtMedicalSpanPlanDocuments22;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_2_3")
    WebElement txtMedicalSpanPlanDocuments23;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_2_4")
    WebElement txtMedicalSpanPlanDocuments24;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_2_5")
    WebElement txtMedicalSpanPlanDocuments25;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_2_6")
    WebElement txtMedicalSpanPlanDocuments26;

    //Plan Documents Column 3
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_3_1")
    WebElement txtMedicalEnglishPlanDocuments31;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_3_2")
    WebElement txtMedicalEnglishPlanDocuments32;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_3_3")
    WebElement txtMedicalEnglishPlanDocuments33;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_3_4")
    WebElement txtMedicalEnglishPlanDocuments34;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_3_5")
    WebElement txtMedicalEnglishPlanDocuments35;
    @FindBy(id = "PlanCompare_PlanDocumentsEnglish_3_6")
    WebElement txtMedicalEnglishPlanDocuments36;

    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_3_1")
    WebElement txtMedicalSpanPlanDocuments31;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_3_2")
    WebElement txtMedicalSpanPlanDocuments32;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_3_3")
    WebElement txtMedicalSpanPlanDocuments33;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_3_4")
    WebElement txtMedicalSpanPlanDocuments34;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_3_5")
    WebElement txtMedicalSpanPlanDocuments35;
    @FindBy(id = "PlanCompare_PlanDocumentsSpanish_3_6")
    WebElement txtMedicalSpanPlanDocuments36;


    // Doctor Visits

    @FindBy(id = "PlanCompare_DoctorsVisits")
    WebElement txtMedicalDoctorsVisits;
    @FindBy(xpath = "//td[normalize-space()='Preventive Care/ Screening/ Immunization']")
    WebElement txtMedicalPreventative;
    @FindBy(xpath = "//td[normalize-space()='Primary Care Visit to Treat an Injury or Illness']")
    WebElement txtMedicalPrimary;
    @FindBy(xpath = "//td[normalize-space()='Specialist Visit']")
    WebElement txtMedicalSpecialist;
    @FindBy(xpath = "//td[normalize-space()='Telehealth PCP']")
    WebElement txtMedicalTeleHealthPCP;
    @FindBy(xpath = "//td[normalize-space()='Telehealth Specialist']")
    WebElement txtMedicalTeleHealthSpecialist;

    // Emergency Care
    @FindBy(id = "PlanCompare_EmergencyCare")
    WebElement getTxtMedicalEmergencyCare;
    @FindBy(xpath = "//td[normalize-space()='Urgent Care Centers or Facilities']")
    WebElement txtMedicalUrgent;
    @FindBy(xpath = "//td[normalize-space()='Emergency Room Services']")
    WebElement txtMedicalEmergencyRoom;
    @FindBy(xpath = "//td[normalize-space()='Emergency Transportation/ Ambulance']")
    WebElement txtMedicalEmergencyTransportation;


    // Drugs
    @FindBy(id = "PlanCompare_Drugs")
    WebElement getTxtMedicalDrugs;

    @FindBy(xpath = "//td[normalize-space()='Generic Drugs']")
    WebElement txtMedicalGenericDrugs;
    @FindBy(xpath = "//td[normalize-space()='Preferred Brand Drugs']")
    WebElement txtMedicalPreferredDrugs;
    @FindBy(xpath = "//td[normalize-space()='Specialty Drugs']")
    WebElement txtMedicalSpecialtyDrugs;


    // Testing
    @FindBy(id = "PlanCompare_Testing")
    WebElement getTxtTesting;

    @FindBy(xpath = "//td[normalize-space()='Laboratory Outpatient and Professional Services']")
    WebElement txtMedicalLaboratory;
    @FindBy(xpath = "//td[normalize-space()='X-rays and Diagnostic Imaging']")
    WebElement txtMedicalXrays;
    @FindBy(xpath = "//td[normalize-space()='Imaging (CT/PET Scans, MRIs)']")
    WebElement txtMedicalImaging;

    // Facilities
    @FindBy(id = "PlanCompare_Facilities")
    WebElement getTxtMedicalFacilities;

    @FindBy(xpath = "//td[normalize-space()='Outpatient Facility Fee (e.g., Ambulatory Surgery Center)']")
    WebElement txtMedicalOutpatientFee;
    @FindBy(xpath = "//td[normalize-space()='Outpatient Surgery Physician/Surgical Services']")
    WebElement txtMedicalOutpatientSurgery;
    @FindBy(xpath = "//td[normalize-space()='Inpatient Hospital Services (e.g., Hospital Stay)']")
    WebElement txtMedicalInpatientHospital;
    @FindBy(xpath = "//td[normalize-space()='Inpatient Physician and Surgical Services']")
    WebElement txtMedicalInpatientPhysician;

    // Mental Health Benefits
    @FindBy(id = "PlanCompare_MentalHealthBenefits")
    WebElement getTxtMedicalMentalHealthBenefits;

    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Office Visit']")
    WebElement txtMedicalMentalBehavior;
    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Outpatient Services']")
    WebElement txtMedicalMentalBehavorialOutpatient;
    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Inpatient Services']")
    WebElement txtMedicalMentalBehavorialInpatient;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Office Visit']")
    WebElement txtMedicalSubstanceAbuseVisit;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Outpatient Services']")
    WebElement txtMedicalSubstanceAbuseOutpatientServices;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Inpatient Services']")
    WebElement txtMedicalSubstanceAbuseInpatientServices;


    // Habilitative and Rehabilitative Services
    @FindBy(id = "PlanCompare_HabilitativeAndRehabilitativeServices")
    WebElement getTxtMedicalHabilitative;

    @FindBy(xpath = "//td[normalize-space()='Habilitation Services']")
    WebElement txtMedicalHabilitativeServices;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Speech Therapy']")
    WebElement txtMedicalRehabSpeechTherapy;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Occupational Therapy']")
    WebElement txtMedicalRehabOccupationalTherapy;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Physical Therapy']")
    WebElement txtMedicalRehabPhysicalTherapy;


    // Medical Devices
    @FindBy(id = "PlanCompare_MedicalDevices")
    WebElement getTxtMedicalMedicalDevices;

    @FindBy(xpath = "//td[normalize-space()='Durable Medical Equipment']")
    WebElement txtMedicalDurableMedical;
    @FindBy(xpath = "//td[normalize-space()='Prosthetic Devices']")
    WebElement txtMedicalProstheticDevices;

    // Maternity
    @FindBy(id = "PlanCompare_Maternity")
    WebElement getTxtMedicalMaternity;

    @FindBy(xpath = "//td[normalize-space()='Prenatal and Postnatal Care']")
    WebElement txtMedicalPrenatal;
    @FindBy(xpath = "//td[normalize-space()='Delivery and All Inpatient Services for Maternity Care']")
    WebElement txtMedicalDelivery;

    // Home Care & Hospice
    @FindBy(id = "PlanCompare_HomeCareAndHospice")
    WebElement getTxtMedicalHomeCare;

    @FindBy(xpath = "//td[normalize-space()='Home Health Care Services']")
    WebElement txtMedicalHomeHealth;
    @FindBy(xpath = "//td[normalize-space()='Hospice Services']")
    WebElement txtMedicalHospice;

    // Additional Benefits
    @FindBy(id = "PlanCompare_AdditionalBenefits")
    WebElement getTxtMedicalBenefits;

    @FindBy(xpath = "//td[normalize-space()='Chiropractic Care']")
    WebElement txtMedicalChiropractic;
    @FindBy(xpath = "//td[normalize-space()='Bariatric Surgery']")
    WebElement txtMedicalBariatricy;

    @FindBy(xpath = "//td[normalize-space()='Infertility Treatment']")
    WebElement txtMedicalInfertility;



    @FindBy(xpath = "//*[contains(text(), 'Plan Details')]")
    WebElement clickPlanDetailLink;

    public void clickPlanDetailLink(){
        basicActions.waitForElementToBePresent(headerComparePlans, 20);
        clickPlanDetailLink.click();
    }

    public void validatePlanDocuments2() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( txtMedicalHighlights, 20 );
        softAssert.assertEquals( txtMedicalHighlights.getText(), "Highlights" );

        softAssert.assertEquals( txtMedicalPlanDocuments.getText(), "Plan Documents" );
        basicActions.click( txtMedicalPlanDocuments );
        basicActions.waitForElementToDisappear( spinner,20 );

        //column 1
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments11.getText(), "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments12.getText(), "Evidence of Coverage Denver Health English 0030008-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments13.getText(), "Summary of Benefits and Coverage Denver Health English 0030008-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments14.getText(), "Quality Overview Denver Health English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments15.getText(), "Brochure Denver Health English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments16.getText(), "Provider Network Denver Health" );

        softAssert.assertEquals( txtMedicalSpanPlanDocuments11.getText(), "Summary of Benefits and Coverage CO Supplement Denver Health Spanish 0030008-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments12.getText(), "Evidence of Coverage Denver Health Spanish 0030008-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments13.getText(), "Summary of Benefits and Coverage Denver Health Spanish 0030008-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments14.getText(), "Quality Overview Denver Health Spanish" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments15.getText(), "Brochure Denver Health Spanish" );

        //column 2
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments21.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente English 0410052-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments22.getText(), "Evidence of Coverage Kaiser Permanente English 0410052-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments23.getText(), "Summary of Benefits and Coverage Kaiser Permanente English 0410052-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments24.getText(), "Quality Overview Kaiser Permanente English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments25.getText(), "Brochure Kaiser Permanente English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments26.getText(), "Provider Network Kaiser Permanente Select" );

        softAssert.assertEquals( txtMedicalSpanPlanDocuments21.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente Spanish 0410052-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments22.getText(), "Summary of Benefits and Coverage Kaiser Permanente Spanish 0410052-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments23.getText(), "Quality Overview Kaiser Permanente Spanish" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments24.getText(), "Evidence of Coverage Kaiser Permanente Spanish 0410052-01" );
        softAssert.assertAll();
    }

    public void validatePlanDocuments3() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( txtMedicalHighlights, 20 );
        softAssert.assertEquals( txtMedicalHighlights.getText(), "Highlights" );

        softAssert.assertEquals( txtMedicalPlanDocuments.getText(), "Plan Documents" );
        basicActions.click( txtMedicalPlanDocuments );
        basicActions.waitForElementToDisappear( spinner,20 );
        //column 1
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments11.getText(), "Summary of Benefits and Coverage CO Supplement Denver Health English 0030008-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments12.getText(), "Evidence of Coverage Denver Health English 0030008-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments13.getText(), "Summary of Benefits and Coverage Denver Health English 0030008-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments14.getText(), "Quality Overview Denver Health English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments15.getText(), "Brochure Denver Health English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments16.getText(), "Provider Network Denver Health" );

        softAssert.assertEquals( txtMedicalSpanPlanDocuments11.getText(), "Summary of Benefits and Coverage CO Supplement Denver Health Spanish 0030008-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments12.getText(), "Evidence of Coverage Denver Health Spanish 0030008-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments13.getText(), "Summary of Benefits and Coverage Denver Health Spanish 0030008-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments14.getText(), "Quality Overview Denver Health Spanish" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments15.getText(), "Brochure Denver Health Spanish" );

        //column 2
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments21.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente English 0410052-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments22.getText(), "Evidence of Coverage Kaiser Permanente English 0410052-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments23.getText(), "Summary of Benefits and Coverage Kaiser Permanente English 0410052-01" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments24.getText(), "Quality Overview Kaiser Permanente English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments25.getText(), "Brochure Kaiser Permanente English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments26.getText(), "Provider Network Kaiser Permanente Select" );

        softAssert.assertEquals( txtMedicalSpanPlanDocuments21.getText(), "Summary of Benefits and Coverage CO Supplement Kaiser Permanente Spanish 0410052-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments22.getText(), "Summary of Benefits and Coverage Kaiser Permanente Spanish 0410052-01" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments23.getText(), "Quality Overview Kaiser Permanente Spanish" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments24.getText(), "Evidence of Coverage Kaiser Permanente Spanish 0410052-01" );

        //column 3
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments31.getText(), "Summary of Benefits and Coverage CO Supplement Cigna English 0060032-01 Colorado Option" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments32.getText(), "Evidence of Coverage Cigna English 0060032-01 Colorado Option" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments33.getText(), "Summary of Benefits and Coverage Cigna English 0060032-01 Colorado Option" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments34.getText(), "Quality Overview Cigna English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments35.getText(), "Brochure Cigna English" );
        softAssert.assertEquals( txtMedicalEnglishPlanDocuments36.getText(), "Provider Network Cigna" );

        softAssert.assertEquals( txtMedicalSpanPlanDocuments31.getText(), "Summary of Benefits and Coverage CO Supplement Cigna Spanish 0060032-01 Colorado Option" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments32.getText(), "Evidence of Coverage Cigna Spanish 0060032-01 Colorado Option" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments33.getText(), "Summary of Benefits and Coverage Cigna Spanish 0060032-01 Colorado Option" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments34.getText(), "Quality Overview Cigna Spanish" );
        softAssert.assertEquals( txtMedicalSpanPlanDocuments35.getText(), "Brochure Cigna Spanish" );
        softAssert.assertAll();
    }


    public void validateInNetworkTextHeaders() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent(txtMedicalHighlights, 20);
        softAssert.assertEquals(txtMedicalHighlights.getText(), "Highlights");

        softAssert.assertEquals(txtMedicalPlanDocuments.getText(), "Plan Documents");
        basicActions.click( txtMedicalPlanDocuments );

        softAssert.assertEquals(txtMedicalDoctorsVisits.getText(), "Doctor Visits");
        basicActions.click( txtMedicalDoctorsVisits );
        softAssert.assertEquals(txtMedicalPreventative.getText(), "Preventive Care/ Screening/ Immunization");
        softAssert.assertEquals(txtMedicalPrimary.getText(), "Primary Care Visit to Treat an Injury or Illness");
        softAssert.assertEquals(txtMedicalSpecialist.getText(), "Specialist Visit");
        softAssert.assertEquals(txtMedicalTeleHealthPCP.getText(), "Telehealth PCP");
        softAssert.assertEquals(txtMedicalTeleHealthSpecialist.getText(), "Telehealth Specialist");

        softAssert.assertEquals(getTxtMedicalEmergencyCare.getText(), "Emergency Care");
        basicActions.click( getTxtMedicalEmergencyCare );
        softAssert.assertEquals(txtMedicalUrgent.getText(), "Urgent Care Centers or Facilities");
        softAssert.assertEquals(txtMedicalEmergencyRoom.getText(), "Emergency Room Services");
        softAssert.assertEquals(txtMedicalEmergencyTransportation.getText(), "Emergency Transportation/ Ambulance");

        softAssert.assertEquals(getTxtMedicalDrugs.getText(), "Drugs");
        basicActions.click( getTxtMedicalDrugs );
        softAssert.assertEquals(txtMedicalGenericDrugs.getText(), "Generic Drugs");
        softAssert.assertEquals(txtMedicalPreferredDrugs.getText(), "Preferred Brand Drugs");
        softAssert.assertEquals(txtMedicalSpecialtyDrugs.getText(), "Specialty Drugs");

        softAssert.assertEquals(getTxtTesting.getText(), "Testing");
        basicActions.click( getTxtTesting );
        softAssert.assertEquals(txtMedicalLaboratory.getText(), "Laboratory Outpatient and Professional Services");
        softAssert.assertEquals(txtMedicalXrays.getText(), "X-rays and Diagnostic Imaging");
        softAssert.assertEquals(txtMedicalImaging.getText(), "Imaging (CT/PET Scans, MRIs)");

        softAssert.assertEquals(getTxtMedicalFacilities.getText(), "Facilities");
        basicActions.click( getTxtMedicalFacilities );
        softAssert.assertEquals(txtMedicalOutpatientFee.getText(), "Outpatient Facility Fee (e.g., Ambulatory Surgery Center)");
        softAssert.assertEquals(txtMedicalOutpatientSurgery.getText(), "Outpatient Surgery Physician/Surgical Services");
        softAssert.assertEquals(txtMedicalInpatientHospital.getText(), "Inpatient Hospital Services (e.g., Hospital Stay)");
        softAssert.assertEquals(txtMedicalInpatientPhysician.getText(), "Inpatient Physician and Surgical Services");

        softAssert.assertEquals(getTxtMedicalMentalHealthBenefits.getText(), "Mental Health Benefits");
        basicActions.click( getTxtMedicalMentalHealthBenefits );
        softAssert.assertEquals(txtMedicalMentalBehavior.getText(), "Mental/Behavioral Health Office Visit");
        softAssert.assertEquals(txtMedicalMentalBehavorialOutpatient.getText(), "Mental/Behavioral Health Outpatient Services");
        softAssert.assertEquals(txtMedicalMentalBehavorialInpatient.getText(), "Mental/Behavioral Health Inpatient Services");
        softAssert.assertEquals(txtMedicalSubstanceAbuseVisit.getText(), "Substance Abuse Disorder Office Visit");
        softAssert.assertEquals(txtMedicalSubstanceAbuseOutpatientServices.getText(), "Substance Abuse Disorder Outpatient Services");
        softAssert.assertEquals(txtMedicalSubstanceAbuseInpatientServices.getText(), "Substance Abuse Disorder Inpatient Services");

        softAssert.assertEquals(getTxtMedicalHabilitative.getText(), "Habilitative and Rehabilitative Services");
        basicActions.click( getTxtMedicalHabilitative );
        softAssert.assertEquals(txtMedicalHabilitativeServices.getText(), "Habilitation Services");
        softAssert.assertEquals(txtMedicalRehabSpeechTherapy.getText(), "Rehabilitative Speech Therapy");
        softAssert.assertEquals(txtMedicalRehabOccupationalTherapy.getText(), "Rehabilitative Occupational Therapy");
        softAssert.assertEquals(txtMedicalRehabPhysicalTherapy.getText(), "Rehabilitative Physical Therapy");

        softAssert.assertEquals(getTxtMedicalMedicalDevices.getText(), "Medical Devices");
        basicActions.click( getTxtMedicalMedicalDevices );
        softAssert.assertEquals(txtMedicalDurableMedical.getText(), "Durable Medical Equipment");
        softAssert.assertEquals(txtMedicalProstheticDevices.getText(), "Prosthetic Devices");

        softAssert.assertEquals(getTxtMedicalMaternity.getText(), "Maternity");
        basicActions.click( getTxtMedicalMaternity );
        softAssert.assertEquals(txtMedicalPrenatal.getText(), "Prenatal and Postnatal Care");
        softAssert.assertEquals(txtMedicalDelivery.getText(), "Delivery and All Inpatient Services for Maternity Care");

        softAssert.assertEquals(getTxtMedicalHomeCare.getText(), "Home Care & Hospice");
        basicActions.click( getTxtMedicalHomeCare );
        softAssert.assertEquals(txtMedicalHomeHealth.getText(), "Home Health Care Services");
        softAssert.assertEquals(txtMedicalHospice.getText(), "Hospice Services");

        softAssert.assertEquals(getTxtMedicalBenefits.getText(), "Additional Benefits");
        basicActions.click( getTxtMedicalBenefits );
        softAssert.assertEquals(txtMedicalChiropractic.getText(), "Chiropractic Care");
        softAssert.assertEquals(txtMedicalBariatricy.getText(), "Bariatric Surgery");
        softAssert.assertEquals(txtMedicalInfertility.getText(), "Infertility Treatment");
        softAssert.assertAll();
        }

    public void validateOutNetworkTextHeaders() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent(txtMedicalHighlights, 20);
        softAssert.assertEquals(txtMedicalHighlights.getText(), "Highlights");

        softAssert.assertEquals(txtMedicalPlanDocuments.getText(), "Plan Documents");
        basicActions.click( txtMedicalPlanDocuments );


        softAssert.assertAll();
    }



    public void clickPDFSummary(){
        basicActions.waitForElementToBePresent( pdfCompareSummary,15);
        pdfCompareSummary.isEnabled();
    }

    public void clickGoBackCompare(){
        basicActions.waitForElementToDisappear( spinner,40 );
        basicActions.waitForElementToBePresent( goBackCompareBtn,30 );
        basicActions.scrollToElement( goBackCompareBtn );
        goBackCompareBtn.click();
    }

    public void clickGoBackCompareLink(){
        basicActions.waitForElementToDisappear( spinner,40 );
        basicActions.waitForElementToBePresent( goBackCompareLink,30 );
        basicActions.scrollToElement( goBackCompareLink );
        goBackCompareLink.click();
    }

    public void clickInNetworkLink(){
        basicActions.waitForElementToBePresent( inNetwork1,15 );
        inNetwork1.click();
    }

    public void clickOutNetworkLink(){
        basicActions.waitForElementToBePresent( outNetwork, 15 );
        outNetwork.click();
    }



}
