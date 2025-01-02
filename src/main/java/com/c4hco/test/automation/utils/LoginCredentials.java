package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;

public class LoginCredentials {

    public static void setSesCredentials() {
        MemberDetails primaryMember = new MemberDetails();
        if (SharedData.getEnv().equals("qa")) {
            primaryMember.setEmailId("julie.cascade@test.com");
        } else {
            primaryMember.setEmailId("castillo.luis@test.com");
        }
        primaryMember.setPassword("ALaska12!");
        SharedData.setPrimaryMember(primaryMember);
    }
}
