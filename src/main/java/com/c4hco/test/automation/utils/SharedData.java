package com.c4hco.test.automation.utils;

public class SharedData {
    private static String username;
    private static String emailId;
    private static String fName;
    private static String lName;
    private static String initials;
    private static String phNumber;

    public static String getUsername(){ return username; }

    public static void setUsername(String username){ SharedData.username = username; }

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

    public static void reset(){
        username = null;
        emailId = null;
    }


}
