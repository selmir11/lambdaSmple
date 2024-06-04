package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MedicalCompareCoCoPage { private BasicActions basicActions;

    public MedicalCompareCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(id = "SHP-MedicalComparePlans-GoBacktoPlans")
    public WebElement medicalCompareGoBack;

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

    @FindBy(id = "SHP-MedicalComparePlans-OutOfNetwork")
    public WebElement selectOutofNetworkLink;

    public void  clickMedicalCompareGoBack() {
          basicActions.waitForElementToBeClickable(medicalCompareGoBack, 20);
          medicalCompareGoBack.click();}

    public void  verifyTxtCompareHeader() {
        basicActions.waitForElementToBePresent(txtCompareHeaderMonthlyPremium, 10 );
        txtCompareHeaderMonthlyPremium.isDisplayed();
        txtCompareHeaderMonthlyPremium.click();

        getTxtCompareHeaderGeneralDetails.isDisplayed();
        getTxtCompareHeaderGeneralDetails.click();

        getTxtCompareHeaderProviderOfficeVisits.isDisplayed();
        getTxtCompareHeaderProviderOfficeVisits.click();
        getTxtPreventativeCare.isDisplayed();
        getTxtPrimaryCare.isDisplayed();
        getTxtSpecialistVisit.isDisplayed();
        getTxtTelehealthPCP.isDisplayed();
        getTxtTelehealthSpecialist.isDisplayed();

        getTxtCompareHeaderPrescriptionDrugs.isDisplayed();
        getTxtCompareHeaderPrescriptionDrugs.click();
        getTxtGenericDrugs.isDisplayed();
        getTxtPreferredDrugs.isDisplayed();
        getTxtNonPreferredDrugs.isDisplayed();
        getTxtSpecialtyDrugs.isDisplayed();

        getTxtCompareHeaderFacilities.isDisplayed();
        getTxtCompareHeaderFacilities.click();
        getTxtOutPatientFacility.isDisplayed();
        getTxtOutPatientSurgery.isDisplayed();
        getTxtInpatientHospital.isDisplayed();
        getTxtInPatientPhysician.isDisplayed();

        getTxtCompareHeaderMaternity.isDisplayed();
        getTxtCompareHeaderMaternity.click();
        getTxtPrenatal.isDisplayed();
        getTxtDelivery.isDisplayed();

        getTxtCompareHeaderEmergencyCare.isDisplayed();
        getTxtCompareHeaderEmergencyCare.click();
        getTxtUrgentCare.isDisplayed();
        getTxtEmergencyRoom.isDisplayed();
        getTxtEmergencyTransportation.isDisplayed();

        getTxtCompareHeaderMentalHealth.isDisplayed();
        getTxtCompareHeaderMentalHealth.click();
        getTxtBehavioralOutpatient.isDisplayed();
        getTxtBehavioralInpatient.isDisplayed();
        getTxtSubstanceAbuseOutpatient.isDisplayed();
        getTxtSubstanceAbuseInpatient.isDisplayed();

        getTxtCompareHeaderTesting.isDisplayed();
        getTxtCompareHeaderTesting.click();
        getTxtLaboratoryOutpatient.isDisplayed();
        getTxtXraysDiagnostics.isDisplayed();
        getTxtImaging.isDisplayed();

        getTxtCompareHeaderMedicalDevices.isDisplayed();
        getTxtCompareHeaderMedicalDevices.click();
        getTxtDurableMedical.isDisplayed();
        getTxtProstheticDevices.isDisplayed();

        getTxtCompareHeaderHabRehab.isDisplayed();
        getTxtCompareHeaderHabRehab.click();
        getTxtHAbServices.isDisplayed();
        getTxtRehabSpeech.isDisplayed();
        getTxtRehabOccupational.isDisplayed();
        getTxtRehabPhysical.isDisplayed();


        getTxtCompareHeaderHomeCare.isDisplayed();
        getTxtCompareHeaderHomeCare.click();
        getTxtHomeCare.isDisplayed();
        getTxtHospiceServices.isDisplayed();

        getTxtCompareHeaderAddEHB.isDisplayed();
        getTxtCompareHeaderAddEHB.click();
        getTxtIChiroCare.isDisplayed();
        getTxtBarCare.isDisplayed();
        getTxtInfertilityTreatment.isDisplayed();

    }

    public void verifyTxtOutofNetworkCompareHeader(){
        basicActions.waitForElementToBePresent(selectOutofNetworkLink, 10 );
        selectOutofNetworkLink.click();
        txtCompareHeaderMonthlyPremiumOut.isDisplayed();
        txtCompareHeaderMonthlyPremiumOut.click();

        getTxtCompareHeaderGeneralDetailsOut.isDisplayed();
        getTxtCompareHeaderGeneralDetailsOut.click();

        getTxtCompareHeaderProviderOfficeVisitsOut.isDisplayed();
        getTxtCompareHeaderProviderOfficeVisitsOut.click();
        getTxtPreventativeCare.isDisplayed();
        getTxtPrimaryCare.isDisplayed();
        getTxtSpecialistVisit.isDisplayed();
        getTxtTelehealthPCP.isDisplayed();
        getTxtTelehealthSpecialist.isDisplayed();

        getTxtCompareHeaderPrescriptionDrugsOut.isDisplayed();
        getTxtCompareHeaderPrescriptionDrugsOut.click();
        getTxtGenericDrugs.isDisplayed();
        getTxtPreferredDrugs.isDisplayed();
        getTxtNonPreferredDrugs.isDisplayed();
        getTxtSpecialtyDrugs.isDisplayed();

        getTxtCompareHeaderFacilitiesOut.isDisplayed();
        getTxtCompareHeaderFacilitiesOut.click();
        getTxtOutPatientFacility.isDisplayed();
        getTxtOutPatientSurgery.isDisplayed();
        getTxtInpatientHospital.isDisplayed();
        getTxtInPatientPhysician.isDisplayed();

        getTxtCompareHeaderMaternityOut.isDisplayed();
        getTxtCompareHeaderMaternityOut.click();
        getTxtPrenatal.isDisplayed();
        getTxtDelivery.isDisplayed();

        getTxtCompareHeaderEmergencyCareOut.isDisplayed();
        getTxtCompareHeaderEmergencyCareOut.click();
        getTxtUrgentCare.isDisplayed();
        getTxtEmergencyRoom.isDisplayed();
        getTxtEmergencyTransportation.isDisplayed();

        getTxtCompareHeaderMentalHealthOut.isDisplayed();
        getTxtCompareHeaderMentalHealthOut.click();
        getTxtBehavioralOutpatient.isDisplayed();
        getTxtBehavioralInpatient.isDisplayed();
        getTxtSubstanceAbuseOutpatient.isDisplayed();
        getTxtSubstanceAbuseInpatient.isDisplayed();

        getTxtCompareHeaderTestingOut.isDisplayed();
        getTxtCompareHeaderTestingOut.click();
        getTxtLaboratoryOutpatient.isDisplayed();
        getTxtXraysDiagnostics.isDisplayed();
        getTxtImaging.isDisplayed();

        getTxtCompareHeaderMedicalDevicesOut.isDisplayed();
        getTxtCompareHeaderMedicalDevicesOut.click();
        getTxtDurableMedical.isDisplayed();
        getTxtProstheticDevices.isDisplayed();

        getTxtCompareHeaderHabRehabOut.isDisplayed();
        getTxtCompareHeaderHabRehabOut.click();
        getTxtHAbServices.isDisplayed();
        getTxtRehabSpeech.isDisplayed();
        getTxtRehabOccupational.isDisplayed();
        getTxtRehabPhysical.isDisplayed();


        getTxtCompareHeaderHomeCareOut.isDisplayed();
        getTxtCompareHeaderHomeCareOut.click();
        getTxtHomeCare.isDisplayed();
        getTxtHospiceServices.isDisplayed();

        getTxtCompareHeaderAddEHBOut.isDisplayed();
        getTxtCompareHeaderAddEHBOut.click();
        getTxtIChiroCare.isDisplayed();
        getTxtBarCare.isDisplayed();
        getTxtInfertilityTreatment.isDisplayed();


    }

}
