package com.c4hco.test.automation.Dto;

import com.c4hco.test.automation.Dto.Edi.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834TransactionDetails;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

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
    @Getter @Setter private static String localPathToDownloadFile;
    @Getter @Setter private static Edi834TransactionDetails edi834TransactionDetails;
    @Getter @Setter private static CommonEDISegments commonEDISegments;
    @Getter @Setter private static String env;
    @Getter @Setter private static DbData dbData;
    @Getter @Setter private static String planYear;
    @Getter @Setter private static GroupDetails groupDetails;
    @Getter @Setter private static int totalGroups;
    @Getter @Setter private static String dbName;
    @Getter @Setter private static Map<String, String> memIdAndMedicalFileName;
    @Getter @Setter private static Map<String, String> memIdAndDentalFileName;;
    @Getter @Setter private static Boolean hasBroker = false;

    public static void reset(){
        firstPlanNameOnMedicalResultsPage = null;
        firstPlanNameOnDentalResultsPage = null;
        appType = null;
        primaryMember = null;
        members = null;
        primaryMemberId = null;
        edi834TransactionDetails = null;
        commonEDISegments = null;
        env = null;
        ob834DetailsEntities = null;
        dbData = null;
        totalGroups = 0;
        planYear = null;
        groupDetails = null;
        dbName = null;
    }
}
