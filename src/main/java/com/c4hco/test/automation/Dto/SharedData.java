package com.c4hco.test.automation.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SharedData {
    @Getter @Setter private static String firstPlanNameOnMedicalResultsPage;
    @Getter @Setter private static String firstPlanNameOnDentalResultsPage;
    @Getter @Setter private static String appType;
    @Getter @Setter private static MemberDetails primaryMember;
    @Getter @Setter private static List<MemberDetails> members;
    @Getter @Setter private static HashMap<String, List<String>> groupsByZipcode;
    @Getter @Setter private static Set<String> uniqueZipcodes;

}
