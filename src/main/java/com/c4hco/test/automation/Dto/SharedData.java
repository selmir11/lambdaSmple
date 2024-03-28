package com.c4hco.test.automation.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SharedData {
    @Getter @Setter private static String firstPlanNameOnMedicalResultsPage;
    @Getter @Setter private static String firstPlanNameOnDentalResultsPage;
    @Getter @Setter private static String appType;
    @Getter @Setter private static MemberDetails primaryMember;
    @Getter @Setter private static List<MemberDetails> members;

    public static void reset(){
        firstPlanNameOnMedicalResultsPage = null;
        firstPlanNameOnDentalResultsPage = null;
        appType = null;
        primaryMember = null;
        members = null;
    }
}
