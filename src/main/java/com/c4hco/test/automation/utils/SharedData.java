package com.c4hco.test.automation.utils;

public class SharedData {
    private static String emailId;
    private static String fName;
    private static String lName;
    private static String initials;
    private static String phNumber;
    private static String password;
    private static String firstPlanNameOnMedicalResultsPage;
    private static String firstPlanNameOnDentalResultsPage;
    private static String appType;
    private static String fileNameToDownloadFromSftp;
    private static String sftpPathToDownload;
    private static String sftpPathToUpload;
    private static String accountId;
//    private static String selectedMedicalPlanName;
//    private static String selectedDentalPlanName;
//    private static String selectedMedicalPlanStartDate;
//    private static String selectedMedicalPlanEndDate;
//    private static String selectedDentalPlanStartDate;
//    private static String selectedDentalPlanEndDate;
//    private static String medicalPremiumAmount;
//    private static String medicalEAPID;
//    private static String medicalBenefitStartDate;
//    private static String medicalBenefitEndDate;
//    private static String dentalBenefitStartDate;
//    private static String dentalBenefitEndDate;
//    private static String dentalPremiumAmount;
//    private static String dentalEAPID;

    public static String getfirstPlanNameOnMedicalResultsPage() {
        return firstPlanNameOnMedicalResultsPage;
    }

    public static void setfirstPlanNameOnMedicalResultsPage(String firstPlanNameOnMedicalResultsPage) {
        SharedData.firstPlanNameOnMedicalResultsPage = firstPlanNameOnMedicalResultsPage;
    }

    public static String getFirstName(){ return fName; }

    public static void setFirstName(String fName){ SharedData.fName = fName; }

    public static String getLastName(){ return lName; }

    public static void setLastName(String lName){ SharedData.lName = lName; }

    public static String getInitials(){ return initials; }

    public static void setInitials(String initials){ SharedData.initials = initials; }

    public static String getEmailId(){ return emailId; }

    public static void setEmailId(String emailId){ SharedData.emailId = emailId; }

    public static String getPhoneNumber(){ return phNumber; }

    public static void setPhoneNumber(String phNumber){ SharedData.phNumber = phNumber; }

    public static String getPassword(){ return password;}

    public static void setPassword(String password){SharedData.password = password; }

    public static String getAppType(){ return appType; }

    public static void setAppType(String appType){SharedData.appType = appType; }

    public static String getFileNameToDownloadFromSftp(){ return fileNameToDownloadFromSftp; }

    public static void setFileNameToDownloadFromSftp(String fileName){SharedData.fileNameToDownloadFromSftp = fileName; }

    public static String getSftpPathToDownload(){ return sftpPathToDownload; }

    public static void setSftpPathToDownload(String sftpPath){SharedData.sftpPathToDownload = sftpPath; }

    public static String getSftpPathToUpload(){ return sftpPathToUpload; }

    public static void setSftpPathToUpload(String sftpPath){SharedData.sftpPathToUpload = sftpPath; }

    public static String getAccountId(){ return accountId; }

    public static void setAccountId(String accountId){SharedData.accountId = accountId; }

    public static void reset(){
        emailId = null;
    }


}
