package com.c4hco.test.automation.Dto;

import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SharedData {
    @Getter @Setter private static String firstPlanNameOnMedicalResultsPage;
    @Getter @Setter private static String firstPlanNameOnDentalResultsPage;
    @Getter @Setter private static String appType;
    @Getter @Setter private static MemberDetails primaryMember;
    @Getter @Setter private static List<MemberDetails> members;
    @Getter @Setter private static String primaryMemberId;
    @Getter @Setter private static List<Ob834DetailsEntity> ob834DetailsEntities;
    @Getter @Setter private static String medicalFileName; // Should the file names go to Member Details?
    @Getter @Setter private static String dentalFileName;
    @Getter @Setter private static List<Ob834FileDetails> ob834FileDetails;
    @Getter @Setter private static String localPathToDownloadFile;
    @Getter @Setter private static String EmployerName;
    @Getter @Setter private static String env;

    public static void reset(){
        firstPlanNameOnMedicalResultsPage = null;
        firstPlanNameOnDentalResultsPage = null;
        appType = null;
        primaryMember = null;
        members = null;
        primaryMemberId = null;
        EmployerName = null;
        env = null;
        ob834DetailsEntities = null;
    }
}
