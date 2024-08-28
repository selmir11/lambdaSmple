package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.SharedData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApplicationDetailsPdf {
    static Date today = new Date();
    static Calendar calendar = Calendar.getInstance();

    public static String getApplicationDetails(String premium, String enrolled, String insruanceEnding, String ending, String lastSet, String voluntarily) {
        calendar.setTime(today);
        DateFormat todayDate = new SimpleDateFormat("MM/dd/yyyy");
        String todayDateFormat = todayDate.format(today);
        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                "Employer Sponsored Insurance\n" +
                "Job " + SharedData.getPrimaryMember().getEmployerName() + "\n" +
                "Minimum Value Standard No\n" +
                "Lowest-Cost Monthly Individual\n" +
                "Premium Amount " + premium + "\n" +
                "Currently enrolled " + enrolled + "\n" +
                (insruanceEnding.equals("Insurance ending") ?
                        "Insurance ending in next 60 days " + ending + "\n" +
                (lastSet.equals("Voluntarily ending") ?
                        "End date " + todayDateFormat + "\n" +
                        "Voluntarily ending insurance " + voluntarily + "\n" : "") : ""));
    }

    public static String getApplicationDetailsSp(String premium, String enrolled, String insruanceEnding, String ending, String lastSet, String voluntarily) {
        calendar.setTime(today);
        DateFormat todayDate = new SimpleDateFormat("MM/dd/yyyy");
        String todayDateFormat = todayDate.format(today);
        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName()+"\n" +
                "Employer Sponsored Insurance\n" +
                "Job "+SharedData.getPrimaryMember().getEmployerName()+"\n" +
                "Minimum Value Standard No\n" +
                "Lowest-Cost Monthly Individual\n" +
                "Premium Amount "+premium+"\n" +
                "Currently enrolled "+enrolled+"\n" +
                "Insurance ending in next 60 days "+ending+"\n" +
                "End date "+todayDateFormat+"\n" +
                "Voluntarily ending insurance "+voluntarily);
    }



}
