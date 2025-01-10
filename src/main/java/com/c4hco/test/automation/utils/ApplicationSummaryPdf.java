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

    public static String getFamilyApplicationSummaryDetails(String coverageType,String  currentlyEnrolled, String endDate) {
        String endDateFormat = getFormattedEndDate(endDate);
        return String.format(SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" +
                "Currently enrolled " + currentlyEnrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }

    public static String getFormattedEndDate(String endDate) {
        if (endDate == null || endDate.trim().isEmpty()) {
            return "No end date provided";
        } else if ("Today".equalsIgnoreCase(endDate)) {
            return basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            return basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy");
        } else if (endDate.startsWith("Future Day:")) {
            try {
                String[] parts = endDate.split(":");
                int daysInFuture = Integer.parseInt(parts[1].trim());
                return basicActions.getFutureDate(daysInFuture);
            } catch (NumberFormatException e) {
                return "Invalid future day format";
            }
        }
        return endDate;
    }

    public static String getFamilyApplicationSummaryDetailsSp(String coverageType,String  currentlyEnrolled, String endDate) {
        String endDateFormat = getFormattedEndDate(endDate);
        return String.format(SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" +
                "Currently enrolled " + currentlyEnrolled + "\n" +
                (endDate != null && !endDate.isEmpty() ? "End date " + endDateFormat + "\n" : ""));
    }

    public static String getBasicApplicationDetails(String coverageType, String currentlyEnrolled, String insuranceEnding, String endDate) {
        String endDateFormat = getFormattedEndDate(endDate);
        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" )+
                ((currentlyEnrolled != null && currentlyEnrolled.equals("Currently enrolled")) ?
                        "Currently enrolled " + currentlyEnrolled + "\n" : "")+
                ((insuranceEnding != null && insuranceEnding.equals("Insurance ending")) ?
                        "Insurance ending in next 60 days " + insuranceEnding + "\n" +
                                "End date " + endDateFormat + "\n" : "");
    }

    public static String getBasicApplicationDetailsSp(String coverageType, String currentlyEnrolled, String insuranceEnding, String endDate) {
        String endDateFormat = getFormattedEndDate(endDate);
        return String.format("Otra cobertura de salud\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" )+
                ((currentlyEnrolled != null && currentlyEnrolled.equals("Currently enrolled")) ?
                        "Currently enrolled " + currentlyEnrolled + "\n" : "")+
                ((insuranceEnding != null && insuranceEnding.equals("Insurance ending")) ?
                        "Insurance ending in next 60 days " + insuranceEnding + "\n" +
                                "End date " + endDateFormat + "\n" : "");
    }

    public static String getMedicareApplicationDetails(String coverageType, String partAEndDate, String partBEndDate) {
        String endingDateA = getFormattedEndDate(partAEndDate);
        String endingDateB = getFormattedEndDate(partBEndDate);

        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" +
                ((endingDateA != null && endingDateA.equals("Part A End Date")) ?
                        "Part A End Date " + endingDateA + "\n" : "")+
                ((endingDateB != null && endingDateB.equals("Part B End Date")) ?
                        "Part B End Date " + endingDateB + "\n" : ""));
    }

    public static String getMedicareApplicationDetailsSp(String coverageType, String partAEndDate, String partBEndDate) {
        String endingDateA = getFormattedEndDate(partAEndDate);
        String endingDateB = getFormattedEndDate(partBEndDate);

        return String.format("Otra cobertura de salud\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                coverageType + "\n" +
                ((endingDateA != null && endingDateA.equals("Part A End Date")) ?
                        "Part A End Date " + endingDateA + "\n" : "")+
                ((endingDateB != null && endingDateB.equals("Part B End Date")) ?
                        "Part B End Date " + endingDateB + "\n" : ""));
    }



}
