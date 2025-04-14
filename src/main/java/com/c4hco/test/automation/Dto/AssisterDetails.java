package com.c4hco.test.automation.Dto;

import lombok.Data;

@Data
public class AssisterDetails {
    String firstName;
    String lastName;
    String email;
    String password = "ALaska12!";
    String phoneNumber;
    String programManagerInviteCode;
    String organizationGroupName;
    String organizationSiteName;
    String accountID;
}
