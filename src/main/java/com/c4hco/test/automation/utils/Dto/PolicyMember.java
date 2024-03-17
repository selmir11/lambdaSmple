package com.c4hco.test.automation.utils.Dto;

import lombok.Data;

@Data
public class PolicyMember {
    String firstName;
    String lastName;
    String emailId;
    String password = "ALaska12!";
    String phoneNumber;
    String ssn;
    String relationshipToSubscriber;
    String signature;
    String dob;
    String zipcode;
    String mailingAddress;
    String mailingZipCode;
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
    String isTobaccoUser;

    String accountId;
    String policyId;
}
