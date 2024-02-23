package com.c4hco.test.automation.utils;

public class sharedData {
    private static String username;
    private static String emailId;

    public static String getUsername(){ return username; }

    public static void setUsername(){ sharedData.username = username; }


    public static String getEmailId(){ return emailId; }

    public static void setEmailId(){ sharedData.emailId = emailId; }

    public static void reset(){
        username = null;
        emailId = null;
    }


}
