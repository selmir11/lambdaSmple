package com.c4hco.test.automation.Dto;

import com.c4hco.test.automation.Dto.Edi.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Ib999Segments;
import com.c4hco.test.automation.database.EntityObj.*;
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
    @Getter @Setter private static List<PolicyTablesEntity> policyTablesEntities;
    @Getter @Setter private static String medicalFileName; // Should the file names go to Member Details?
    @Getter @Setter private static String dentalFileName;
    @Getter @Setter private static List<Ib999Entity> ib999MedDetailsEntities;
    @Getter @Setter private static List<Ib999Entity> ib999DenDetailsEntities;
    @Getter @Setter private static String medicalIb999FileName;
    @Getter @Setter private static String dentalIb999FileName;
    @Getter @Setter private static String localPathToDownloadFile;
    @Getter @Setter private static Edi834TransactionDetails edi834TransactionDetails;
    @Getter @Setter private static CommonEDISegments commonEDISegments;
    @Getter @Setter private static Ib999Segments ib999Segments;
    @Getter @Setter private static String env;
    @Getter @Setter private static DbData dbData;
    @Getter @Setter private static Map<String, PlanDbData> medicalPlanDbData;
    @Getter @Setter private static List<PlanDbData> dentalPlanDbData;
    @Getter @Setter private static String planYear;
    @Getter @Setter private static GroupDetails groupDetails;
    @Getter @Setter private static String dbName;
    @Getter @Setter private static String isOpenEnrollment;
    @Getter @Setter private static String ses;
    @Getter @Setter private static Map<String, String> memIdAndMedicalFileName;
    @Getter @Setter private static Map<String, String> memIdAndDentalFileName;;
    @Getter @Setter private static Boolean hasBroker = false;
    @Getter @Setter private static BrokerDetails agencyOwner;
    @Getter @Setter private static BrokerDetails broker;
    @Getter @Setter private static BrokerDetails adminStaff;
    @Getter @Setter private static String noticeFileName;
    @Getter @Setter private static List<BookOfBusinessQEntity> bookOfBusinessQEntityList;
    @Getter @Setter private static Map<String, List<String>> groupingDetails;
    @Getter @Setter private static ScenarioDetails scenarioDetails;
    @Getter @Setter private static String medGroupCtlNumber;
    @Getter @Setter private static String denGroupCtlNumber;
    @Getter @Setter private static List<String> medicalPlansList;
    @Getter @Setter private static Map<String, String> calculatedDob;
    @Getter @Setter private static ExpectedCalculatedDates expectedCalculatedDates;
    @Getter @Setter private static Map<String, String> exchPersonId;


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
        policyTablesEntities = null;
        dbData = null;
        planYear = null;
        groupDetails = null;
        dbName = null;
        noticeFileName = null;
        bookOfBusinessQEntityList = null;
        isOpenEnrollment = null;
        ses = null;
        scenarioDetails = null;
        ib999Segments = null;
        medicalPlansList=null;
        calculatedDob = null;
        expectedCalculatedDates = null;
        exchPersonId=null;
    }
}