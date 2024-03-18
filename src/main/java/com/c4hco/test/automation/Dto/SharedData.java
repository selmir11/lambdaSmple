package com.c4hco.test.automation.Dto;

import java.util.List;

public class SharedData {
    private static String firstPlanNameOnMedicalResultsPage;
    private static String firstPlanNameOnDentalResultsPage;
    private static String appType;
    private static String fileNameToDownloadFromSftp;
    private static String sftpPathToDownload;
    private static String sftpPathToUpload;

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

    public static void setFirstPlanNameOnDentalResultsPage(String firstDentalPlan){ SharedData.firstPlanNameOnDentalResultsPage = firstDentalPlan; }

    public static void setSubscriber(PolicyMember subscriber){ SharedData.subscriber = subscriber; }

    public static PolicyMember getSubscriber(){ return subscriber; }

    public static void setMembers(List<PolicyMember> members){ SharedData.members = members; }

    public static List<PolicyMember> getMembers() { return members; }


}
