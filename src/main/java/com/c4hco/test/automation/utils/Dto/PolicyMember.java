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

    String accountId;
    String policyId;
}
