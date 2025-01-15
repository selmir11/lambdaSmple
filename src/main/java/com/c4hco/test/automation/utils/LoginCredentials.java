package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.testng.Assert;

public class LoginCredentials {

    public static void setSepCredentials() {
        MemberDetails primaryMember = new MemberDetails();
        if (SharedData.getEnv().equals("qa")) {
            primaryMember.setEmailId("julie.cascade@test.com");
        } else {
            primaryMember.setEmailId("castillo.luis@test.com");
        }
        primaryMember.setPassword("ALaska12!");
        SharedData.setPrimaryMember(primaryMember);
    }

    public static void setSesCredentials() {
        MemberDetails primaryMember = new MemberDetails();
        if (SharedData.getEnv().equals("qa")) {
            primaryMember.setEmailId("");
        } else {
            primaryMember.setEmailId("daniel.peterson@test.com");
        }
        primaryMember.setPassword("ALaska12!");
        SharedData.setPrimaryMember(primaryMember);
    }


    public static void setScriptBasedDetails(String scriptNum){
        MemberDetails primaryMember = new MemberDetails();
        switch(scriptNum){
            case "SLCR-704":
                if (SharedData.getEnv().equals("qa")) {
                    primaryMember.setFirstName("Girl");
                    primaryMember.setLastName("Coco");
                    primaryMember.setDob("04212013");
                    primaryMember.setGender("Female");
                } else {
                    primaryMember.setFirstName("Dupe");
                    primaryMember.setLastName("Person");
                    primaryMember.setDob("01011900");
                    primaryMember.setGender("Male");
                }
                break;
            default: Assert.fail("Invalid script number passed");
        }
        primaryMember.setPassword("ALaska12!");
        SharedData.setPrimaryMember(primaryMember);
    }
}
