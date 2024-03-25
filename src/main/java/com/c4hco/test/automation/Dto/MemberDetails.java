package com.c4hco.test.automation.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberDetails {
    String firstName;
    String lastName;
    String emailId;
    String password = "ALaska12!";
    String phoneNumber;
    String ssn;
    String relation_to_subscriber;
    String signature;
    String dob;
    String zipcode;
    String mailingAddress;
    String mailingZipCode;
    String residentialAddressLine1;
    String residentialAddressCity;
    String residentialAddressState;
    String residentialAddressCounty;
    String residentialAddressZipcode;
    String gender;
    String medicalPlan;
    String medicalPlanStartDate;
    String medicalPlanEndDate;
    String dentalPlan;
    String dentalPlanStartDate;
    String dentalPlanEndDate;
    String financialStartDate;
    String medicalPremiumAmt;
    String dentalPremiumAmt;
    String aptcAmt;
    String tobacco_user;

    BigDecimal account_id;
    String policyId;
}
