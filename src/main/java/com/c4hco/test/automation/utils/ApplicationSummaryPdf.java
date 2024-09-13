package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.SharedData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApplicationSummaryPdf {
    static Date today = new Date();
    static Calendar calendar = Calendar.getInstance();

    public static String getApplicationSummaryDetails(String ohcType, String enrolled, String endDate) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String endDateFormat = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endDateFormat = dateFormat.format(today);
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            calendar.setTime(today);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            Date lastDayOfMonth = calendar.getTime();
            endDateFormat = dateFormat.format(lastDayOfMonth);
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                ohcType + "\n" +
                "Currently enrolled " + enrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }

    public static String getApplicationSummaryDetailsSp(String ohcType, String enrolled, String endDate) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String endDateFormat = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endDateFormat = dateFormat.format(today);
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            calendar.setTime(today);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            Date lastDayOfMonth = calendar.getTime();
            endDateFormat = dateFormat.format(lastDayOfMonth);
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        return String.format("Otra cobertura de salud\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                ohcType + "\n" +
                "Currently enrolled " + enrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }

    public static String getFamilyApplicationSummaryDetails(String ohcType, String enrolled, String endDate) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String endDateFormat = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endDateFormat = dateFormat.format(today);
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            calendar.setTime(today);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            Date lastDayOfMonth = calendar.getTime();
            endDateFormat = dateFormat.format(lastDayOfMonth);
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        return String.format(SharedData.getPrimaryMember().getFullName() + "\n" +
                ohcType + "\n" +
                "Currently enrolled " + enrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }

    public static String getFamilyApplicationSummaryDetailsSp(String ohcType, String enrolled, String endDate) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String endDateFormat = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endDateFormat = dateFormat.format(today);
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            calendar.setTime(today);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            Date lastDayOfMonth = calendar.getTime();
            endDateFormat = dateFormat.format(lastDayOfMonth);
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        return String.format(SharedData.getPrimaryMember().getFullName() + "\n" +
                ohcType + "\n" +
                "Currently enrolled " + enrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }



}
