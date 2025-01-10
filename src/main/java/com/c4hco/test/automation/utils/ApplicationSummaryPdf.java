package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ApplicationSummaryPdf {
    private static BasicActions basicActions = new BasicActions();

    public ApplicationSummaryPdf(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

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

    public static String getFamilyApplicationSummaryDetails(String coverageType,String  currentlyEnrolled, String endDate) {
        String endDateFormat = "";

        if (endDate == null || endDate.trim().isEmpty()) {
            endDateFormat = "No end date provided";
        } else if ("Today".equalsIgnoreCase(endDate)) {
            endDateFormat = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endDateFormat = basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy");
        } else if (endDate.startsWith("Future Day:")) {
            String[] parts = endDate.split(":");
            int daysInFuture = Integer.parseInt(parts[1]);
            endDateFormat = basicActions.getFutureDate(daysInFuture);
        }
        return String.format(SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" +
                "Currently enrolled " + currentlyEnrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }

    public static String getFamilyApplicationSummaryDetailsSp(String coverageType,String  currentlyEnrolled, String endDate) {
        String endDateFormat = "";

        if (endDate == null || endDate.trim().isEmpty()) {
            endDateFormat = "No end date provided";
        } else if ("Today".equalsIgnoreCase(endDate)) {
            endDateFormat = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endDateFormat = basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy");
        } else if (endDate.startsWith("Future Day:")) {
            String[] parts = endDate.split(":");
            int daysInFuture = Integer.parseInt(parts[1]);
            endDateFormat = basicActions.getFutureDate(daysInFuture);
        }
        return String.format(SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" +
                "Currently enrolled " + currentlyEnrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }

    public static String getBasicApplicationDetails(String coverageType, String currentlyEnrolled, String insuranceEnding, String endDate) {
        String endingDate = "";

        if (endDate == null || endDate.trim().isEmpty()) {
            endingDate = "No end date provided";
        } else if ("Today".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy");
        } else if (endDate.startsWith("Future Day:")) {
            String[] parts = endDate.split(":");
            int daysInFuture = Integer.parseInt(parts[1]);
            endingDate = basicActions.getFutureDate(daysInFuture);
        }

        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" )+
                ((currentlyEnrolled != null && currentlyEnrolled.equals("Currently enrolled")) ?
                        "Currently enrolled " + currentlyEnrolled + "\n" : "")+
                ((insuranceEnding != null && insuranceEnding.equals("Insurance ending")) ?
                        "Insurance ending in next 60 days " + insuranceEnding + "\n" +
                                "End date " + endingDate + "\n" : "");
    }

    public static String getBasicApplicationDetailsSp(String coverageType, String currentlyEnrolled, String insuranceEnding, String endDate) {
        String endingDate = "";

        if (endDate == null || endDate.trim().isEmpty()) {
            endingDate = "No end date provided";
        } else if ("Today".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy");
        } else {
            System.out.println("Invalid option: " + endDate);
        }

        return String.format("Otra cobertura de salud\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" )+
                ((currentlyEnrolled != null && currentlyEnrolled.equals("Currently enrolled")) ?
                        "Currently enrolled " + currentlyEnrolled + "\n" : "")+
                ((insuranceEnding != null && insuranceEnding.equals("Insurance ending")) ?
                        "Insurance ending in next 60 days " + insuranceEnding + "\n" +
                                "End date " + endingDate + "\n" : "");
    }



}
