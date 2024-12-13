package com.c4hco.test.automation.Dto;

import lombok.Data;

@Data
public class BrokerDetails {
    String firstName;
    String lastName;
    String email;
    String password = "ALaska12!";
    String phoneNumber;
    String license;
    String certification;
    Boolean bookOfBusiness;
    String adminStaffInviteCode;
    String agencyName;
    Address agencyAddress;
    String agencyEmail;
    String agencyPhoneNumber;
    String agencyTin;
    String broker_name;
    String broker_lic_num;
    String agencyClientCount;
    String brokerAccountID;
}
