package com.c4hco.test.automation.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MemberDetails {
    String firstName;
    String lastName;
    String middleName;
    String middleInitial;
    String suffix;
    String emailId;
    String password = "ALaska12!";
    String phoneNumber; //homephone
    String alternatePhNum; //mobilephone
    String ssn;
    String oldSsn;
    String relation_to_subscriber;
    String signature;
    String fullName;
    String completeFullName;
    String dob;
    String zipcode;
    Address resAddress;
    Address oldResAddress;
    Address mailingAddress;
    Address oldMailingAddress;
    String gender;
    String race;
    String medicalPlan;
    String medicalPlanStartDate; // policy start date
    String medicalPlanEndDate; // policy end date
    String dentalPlanStartDate; // policy start date
    String dentalPlanEndDate; // policy end date
    String dentalPlan;
    String medicalFinancialStartDate;
    String medicalFinancialEndDate;
    String dentalFinancialStartDate;
    String dentalFinancialEndDate;
    String medicalCoverageStartDate;
    String medicalCoverageEndDate;
    String dentalCoverageStartDate;
    String dentalCoverageEndDate;
    String medicalPremiumAmt; // total premium amount
    String dentalPremiumAmt;
    String aptcAmt;
    String medicalAptcAmt;
    String dentalAptcAmt;
    String tobacco_user="No";
    String application_id;
    BigDecimal account_id;
    String policyId;
    String memberId; //excludes primary memberId
    String totalMedAmtAfterReduction;
    String totalDentalPremAfterReduction;
    String medicalEapid_db;
    String dentalEapid_db;
    Boolean financialHelp;
    String fipcode;
    String writtenLanguage;
    String spokenLanguage;
    String prefLang;
    String maritalStatus;
    Boolean isMinor= false;
    Boolean hasIncorrectEntities = false;
    String isSubscriber="N"; // Medical Subscriber
    String isDentalSubscriber = "N";
    String incorrectEntityIdCode;
    String incorrectEntityTypeQualifier;
    String incorrectIdCodeQualifier;
    String incorrectIdCode;
    String incorrect_dob;
    String incorrect_gender;
    String incorrect_race;
    String incorrect_marital_status_code;
    String incorrect_first_name ;
    String incorrect_middle_name ;
    String incorrect_last_name ;
    String incorrectEmail;
    String incorrectHomePhone;
    String incorrectMobilePhone;
    String incorrectLanguage;
    String incorrectContactPref;
    String employerName;
    String prior_subscriber_id;
    Boolean csrEligible=false;
    String medGroupInd="1";
    String denGroupInd="1";
    Boolean hasMedicalPlan=true;
    Boolean hasDentalPlan=true;
    String medSubscriberName;
    String denSubscriberName;
    List<String> taxReturnId;
    String contactPref;
    String applyingforCov;
    String medicalSesAmt;
    Boolean isProfileChange = false;
    Boolean isResAddChange = false;
    String policyDisenrollmentReasonMed;
    String policyDisenrollmentReasonDen;
    String submittedBy;
}


