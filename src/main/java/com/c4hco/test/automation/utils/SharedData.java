package com.c4hco.test.automation.utils;

import java.util.List;

public class SharedData {
    private static String firstPlanNameOnMedicalResultsPage;
    private static String firstPlanNameOnDentalResultsPage;
    private static String appType;
    private static String fileNameToDownloadFromSftp;
    private static String sftpPathToDownload;
    private static String sftpPathToUpload;


    private static String selectedMedicalPlanStartDate;
    private static String selectedMedicalPlanEndDate;
    private static String selectedDentalPlanStartDate;
    private static String selectedDentalPlanEndDate;
    private static String financialStartDate;

    private static PolicyMember subscriber;
    private static List<PolicyMember> members;

    public static String getfirstPlanNameOnMedicalResultsPage() {
        return firstPlanNameOnMedicalResultsPage;
    }

    public static void setfirstPlanNameOnMedicalResultsPage(String firstPlanNameOnMedicalResultsPage) {
        SharedData.firstPlanNameOnMedicalResultsPage = firstPlanNameOnMedicalResultsPage;
    }

    public static String getAppType(){ return appType; }

    public static void setAppType(String appType){SharedData.appType = appType; }

    public static String getFileNameToDownloadFromSftp(){ return fileNameToDownloadFromSftp; }

    public static void setFileNameToDownloadFromSftp(String fileName){SharedData.fileNameToDownloadFromSftp = fileName; }

    public static String getSftpPathToDownload(){ return sftpPathToDownload; }

    public static void setSftpPathToDownload(String sftpPath){SharedData.sftpPathToDownload = sftpPath; }

    public static String getSftpPathToUpload(){ return sftpPathToUpload; }

    public static void setSftpPathToUpload(String sftpPath){SharedData.sftpPathToUpload = sftpPath; }

    public static String getSelectedMedicalPlanStartDate(){ return selectedMedicalPlanStartDate; }

    public static void setSelectedMedicalPlanStartDate(String startDate){ SharedData.selectedMedicalPlanStartDate = startDate; }

    public static String getSelectedMedicalPlanEndDate(){ return selectedMedicalPlanEndDate; }

    public static void setSelectedMedicalPlanEndDate(String endDate){ SharedData.selectedMedicalPlanEndDate = endDate; }

    public static String getSelectedDentalPlanStartDate(){ return selectedDentalPlanStartDate; }

    public static void setSelectedDentalPlanStartDate(String dentalStartDate){ SharedData.selectedDentalPlanStartDate = dentalStartDate; }

    public static String getSelectedDentalPlanEndDate(){ return selectedDentalPlanEndDate; }

    public static void setSelectedDentalPlanEndDate(String dentalPlanEndDate){ SharedData.selectedDentalPlanEndDate = dentalPlanEndDate; }

    public static String getFirstPlanNameOnDentalResultsPage(){ return firstPlanNameOnDentalResultsPage; }

    public static void setFirstPlanNameOnDentalResultsPage(String firstDentalPlan){ SharedData.firstPlanNameOnDentalResultsPage = firstDentalPlan; }

    public static void setFinancialStartDate(String financialStartDate){ SharedData.financialStartDate = financialStartDate; }

    public static void setSubscriber(PolicyMember subscriber){ SharedData.subscriber = subscriber; }

    public static PolicyMember getSubscriber(){ return subscriber; }

    public static void setMembers(List<PolicyMember> members){ SharedData.members = members; }

    public static List<PolicyMember> getMembers() { return members; }

}
