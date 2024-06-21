package com.c4hco.test.automation.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberDetails {
    String firstName;
    String lastName;
    String middleName;
    String middleInitial;
    String suffix;
    String emailId;
    String password = "ALaska12!";
    String phoneNumber;
    String alternatePhNum;
    String ssn;
    String oldSsn;
    String relation_to_subscriber;
    String signature;
    String fullName;
    String dob;
    String zipcode;
    Address resAddress;
    Address mailingAddress;
    String gender;
    String race;
    String medicalPlan;
    String medicalPlanStartDate;
    String medicalPlanEndDate;
    String dentalPlan;
    String dentalPlanStartDate;
    String dentalPlanEndDate;
    String medicalFinancialStartDate;
    String medicalFinancialEndDate;
    String detntalFinancialStartDate;
    String dentalFinancialEndDate;
    String medicalPremiumAmt;
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
    String maritalStatus;
    Boolean isMinor;
    Boolean hasIncorrectEntities;
    String isSubscriber="N";
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
    String employerName;
    String dependentCountTag;
    String prior_subscriber_id;
}


