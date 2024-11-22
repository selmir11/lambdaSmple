package com.c4hco.test.automation.utils;

import java.util.List;

public class Constants {
    public static String PROTOCOL = "https://";
    public static String LOGIN = "login-portal/login";
    public static String BROKER = "broker-portal/";
    public  static String ADMIN = "login-portal/login/adminUsers";
    public  static String ASSISTER = "assistnet-portal/";
    public  static String Outlook= "https://www.microsoft.com/en-us/microsoft-365/outlook/log-in";
    public static String host = "-aws.connectforhealthco.com/";

    public static final List<String> DentalPlanNamesList; // WIP - Eventually, get this list from DB

    static {
        DentalPlanNamesList = List.of(
                "Cigna Dental Pediatric",
                "Delta Dental of Colorado Pediatric Enhanced Plan",
                "Delta Dental of Colorado Pediatric Comprehensive Plan",
                "EssentialSmile Colorado - Total Care",
                "Anthem Dental Family Value",
                "Delta Dental of Colorado Family Value Plan",
                "Anthem Dental Family",
                "Delta Dental of Colorado Family Basic Plan",
                "Cigna Dental Family + Pediatric",
                "Anthem Dental Family Enhanced",
                "Delta Dental of Colorado Family Enhanced Plan",
                "Delta Dental of Colorado Family Comprehensive Plan"
        );
    }
}

