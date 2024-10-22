package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
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

    @FindBy(id = "MedicalComparePlans-GoBackToPlans")
    public WebElement medicalCompareGoBack;

    @FindBy(css = "div[id='medicalPlanDetails'] div:nth-child(2) em:nth-child(1)")
    public WebElement firstplan;

    @FindBy(css = "div[id='medicalPlanDetails'] div:nth-child(2) em:nth-child(1)")
    public WebElement secondplan;

    @FindBy(css = "div[id='medicalPlanDetails'] div:nth-child(2) em:nth-child(1)")
    public WebElement thirdplan;

    @FindBy(xpath = "//p[normalize-space()='There are no plans selected to compare']")
    public WebElement noTextPlan;


    //Monthly Premium header
    @FindBy(id="ngb-accordion-item-0-toggle")
    public WebElement txtCompareHeaderMonthlyPremium;

    @FindBy(id="ngb-accordion-item-13-toggle")
    public WebElement txtCompareHeaderMonthlyPremiumOut;

    @FindBy(id = "ngb-accordion-item-1-toggle")
    public WebElement getTxtCompareHeaderGeneralDetails;

    @FindBy(id = "ngb-accordion-item-14-toggle")
    public WebElement getTxtCompareHeaderGeneralDetailsOut;

    //General Details header
    @FindBy(id = "ngb-accordion-item-2-toggle")
    public WebElement getTxtCompareHeaderProviderOfficeVisits;

    @FindBy(id = "ngb-accordion-item-15-toggle")
    public WebElement getTxtCompareHeaderProviderOfficeVisitsOut;

    @FindBy(xpath = "//td[normalize-space()='Preventive Care/Screening/Immunization']")
    public WebElement getTxtPreventativeCare;

    @FindBy(xpath = "//td[normalize-space()='Primary Care Visit to Treat an Injury or Illness']")
    public WebElement getTxtPrimaryCare;

    @FindBy(xpath = "//td[normalize-space()='Specialist Visit']")
    public WebElement getTxtSpecialistVisit;

    @FindBy(xpath = "//td[normalize-space()='Telehealth PCP']")
    public WebElement getTxtTelehealthPCP;

    @FindBy(xpath = "//td[normalize-space()='Telehealth Specialist']")
    public WebElement getTxtTelehealthSpecialist;

    //Prescription Drugs header
    @FindBy(id = "ngb-accordion-item-3-toggle")
    public WebElement getTxtCompareHeaderPrescriptionDrugs;

    @FindBy(id = "ngb-accordion-item-16-toggle")
    public WebElement getTxtCompareHeaderPrescriptionDrugsOut;


    @FindBy(xpath = "//td[normalize-space()='Generic Drugs']")
    public WebElement getTxtGenericDrugs;
    @FindBy(xpath = "//td[normalize-space()='Preferred Brand Drugs']")
    public WebElement getTxtPreferredDrugs;
    @FindBy(xpath = "//td[normalize-space()='Non-Preferred Brand Drugs']")
    public WebElement getTxtNonPreferredDrugs;
    @FindBy(xpath = "//td[normalize-space()='Specialty Drugs']")
    public WebElement getTxtSpecialtyDrugs;

    //Facilities header
    @FindBy(id = "ngb-accordion-item-4-toggle")
    public WebElement getTxtCompareHeaderFacilities;

    @FindBy(id = "ngb-accordion-item-17-toggle")
    public WebElement getTxtCompareHeaderFacilitiesOut;

    @FindBy(xpath = "//td[normalize-space()='Outpatient Facility Fee (e.g., Ambulatory Surgery Center)']")
    public WebElement getTxtOutPatientFacility;
    @FindBy(xpath = "//td[normalize-space()='Outpatient Surgery Physician/Surgical Services']")
    public WebElement getTxtOutPatientSurgery;
    @FindBy(xpath = "//td[normalize-space()='Inpatient Hospital Services (e.g., Hospital Stay)']")
    public WebElement getTxtInpatientHospital;
    @FindBy(xpath = "//td[normalize-space()='Inpatient Physician and Surgical Services']")
    public WebElement getTxtInPatientPhysician;

    //Maternity header
    @FindBy(id = "ngb-accordion-item-5-toggle")
    public WebElement getTxtCompareHeaderMaternity;
    @FindBy(id = "ngb-accordion-item-18-toggle")
    public WebElement getTxtCompareHeaderMaternityOut;

    @FindBy(xpath = "//td[normalize-space()='Prenatal and Postnatal Care']")
    public WebElement getTxtPrenatal;
    @FindBy(xpath = "//td[normalize-space()='Delivery and All Inpatient Services for Maternity Care']")
    public WebElement getTxtDelivery;

    //Emergency Care header
    @FindBy(id = "ngb-accordion-item-6-toggle")
    public WebElement getTxtCompareHeaderEmergencyCare;

    @FindBy(id = "ngb-accordion-item-19-toggle")
    public WebElement getTxtCompareHeaderEmergencyCareOut;

    @FindBy(xpath = "//td[normalize-space()='Urgent Care Centers or Facilities']")
    public WebElement getTxtUrgentCare;
    @FindBy(xpath = "//td[normalize-space()='Emergency Room Services']")
    public WebElement getTxtEmergencyRoom;
    @FindBy(xpath = "//td[normalize-space()='Emergency Transportation/Ambulance']")
    public WebElement getTxtEmergencyTransportation;

    //Mental Health header
    @FindBy(id = "ngb-accordion-item-7-toggle")
    public WebElement getTxtCompareHeaderMentalHealth;
    @FindBy(id = "ngb-accordion-item-20-toggle")
    public WebElement getTxtCompareHeaderMentalHealthOut;
    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Outpatient Services']")
    public WebElement getTxtBehavioralOutpatient;
    @FindBy(xpath = "//td[normalize-space()='Mental/Behavioral Health Inpatient Services']")
    public WebElement getTxtBehavioralInpatient;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Outpatient Services']")
    public WebElement getTxtSubstanceAbuseOutpatient;
    @FindBy(xpath = "//td[normalize-space()='Substance Abuse Disorder Inpatient Services']")
    public WebElement getTxtSubstanceAbuseInpatient;

    //Testing Header
    @FindBy(id = "ngb-accordion-item-8-toggle")
    public WebElement getTxtCompareHeaderTesting;

    @FindBy(id = "ngb-accordion-item-21-toggle")
    public WebElement getTxtCompareHeaderTestingOut;
    @FindBy(xpath = "//td[normalize-space()='Laboratory Outpatient and Professional Services']")
    public WebElement getTxtLaboratoryOutpatient;
    @FindBy(xpath = "//td[normalize-space()='X-rays and Diagnostic Imaging']")
    public WebElement getTxtXraysDiagnostics;
    @FindBy(xpath = "//td[normalize-space()='Imaging (CT/PET Scans, MRIs)']")
    public WebElement getTxtImaging;


    //Medical Devices Header
    @FindBy(id = "ngb-accordion-item-9-toggle")
    public WebElement getTxtCompareHeaderMedicalDevices;

    @FindBy(id = "ngb-accordion-item-22-toggle")
    public WebElement getTxtCompareHeaderMedicalDevicesOut;
    @FindBy(xpath = "//td[normalize-space()='Durable Medical Equipment']")
    public WebElement getTxtDurableMedical;
    @FindBy(xpath = "//td[normalize-space()='Prosthetic Devices']")
    public WebElement getTxtProstheticDevices;


    // Habilitative and Rehabilitiative Header
    @FindBy(id = "ngb-accordion-item-10-toggle")
    public WebElement getTxtCompareHeaderHabRehab;

    @FindBy(id = "ngb-accordion-item-23-toggle")
    public WebElement getTxtCompareHeaderHabRehabOut;
    @FindBy(xpath = "//td[normalize-space()='Habilitation Services']")
    public WebElement getTxtHAbServices;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Speech Therapy']")
    public WebElement getTxtRehabSpeech;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Occupational Therapy']")
    public WebElement getTxtRehabOccupational;
    @FindBy(xpath = "//td[normalize-space()='Rehabilitative Physical Therapy']")
    public WebElement getTxtRehabPhysical;



    // Home Care and Hospice Header
    @FindBy(id = "ngb-accordion-item-11-toggle")
    public WebElement getTxtCompareHeaderHomeCare;

    @FindBy(id = "ngb-accordion-item-24-toggle")
    public WebElement getTxtCompareHeaderHomeCareOut;
    @FindBy(xpath = "//td[normalize-space()='Home Health Care Services']")
    public WebElement getTxtHomeCare;
    @FindBy(xpath = "//td[normalize-space()='Hospice Services']")
    public WebElement getTxtHospiceServices;


    // Additional EHB Benefits
    @FindBy(id = "ngb-accordion-item-12-toggle")
    public WebElement getTxtCompareHeaderAddEHB;

    @FindBy(id = "ngb-accordion-item-25-toggle")
    public WebElement getTxtCompareHeaderAddEHBOut;
    @FindBy(xpath = "//td[normalize-space()='Chiropractic Care']")
    public WebElement getTxtIChiroCare;
    @FindBy(xpath = "//td[normalize-space()='Bariatric Surgery']")
    public WebElement getTxtBarCare;
    @FindBy(xpath = "//td[normalize-space()='Infertility Treatment']")
    public WebElement getTxtInfertilityTreatment;

    @FindBy(id = "MedicalPlanCompare_OutOfNetworkTab")
    public WebElement selectOutofNetworkLink;

    @FindBy(xpath = "//div[@id='SHP-MedicalComparePlans-InNetworkTier1-panel'] //button")
    public List<WebElement> drpDwnPlanDetails;

    @FindBy(id = "MedicalPlanCompare_InNetworkTab")
    public WebElement selectInNetworkTier1Link;

    @FindBy(css = ".pt-5")
    public WebElement planHeaderdetails;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void  clickMedicalCompareGoBack() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent(medicalCompareGoBack, 20);
        medicalCompareGoBack.click();}

    public void verifyPlanDeselectionOne() {
        basicActions.waitForElementToBeClickable( firstplan,15 );
        firstplan.click();}

    public void verifyPlanDeselectionTwo() {
        basicActions.waitForElementToBeClickable( secondplan,15 );
        secondplan.click();}

    public void verifyPlanDeselectionThree(){
        basicActions.waitForElementToBeClickable( thirdplan,15 );
        thirdplan.click();}

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

        softAssert.assertTrue(getTxtCompareHeaderProviderOfficeVisits.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderProviderOfficeVisits.click();
        softAssert.assertTrue(getTxtPreventativeCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtPrimaryCare.isDisplayed(),"Incorrect Header");
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

        softAssert.assertTrue(getTxtCompareHeaderProviderOfficeVisitsOut.isDisplayed(),"Incorrect Header");
        getTxtCompareHeaderProviderOfficeVisitsOut.click();
        softAssert.assertTrue(getTxtPreventativeCare.isDisplayed(),"Incorrect Header");
        softAssert.assertTrue(getTxtPrimaryCare.isDisplayed(),"Incorrect Header");
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

    public void verifyTextMedicalplancmpr(List<String> planDetails){
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
