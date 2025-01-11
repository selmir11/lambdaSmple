package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ApplicationDetailsPdf {
    private static BasicActions basicActions = new BasicActions();

    public ApplicationDetailsPdf(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    public static String getEsiApplicationDetails(String coverageType, String minimumValueStandard,  String lowestCostAmount, String currentlyEnrolled, String insuranceEnding, String endDate, String voluntarilyEnding) {
        String endingDate = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endingDate = (basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy"));
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        StringBuilder details = new StringBuilder();
        details.append("Other Health Coverage\n")
                .append(SharedData.getPrimaryMember().getFullName()).append("\n")
                .append(coverageType).append("\n")
                .append("Job ").append(SharedData.getPrimaryMember().getEmployerName()).append("\n")
                .append("Minimum Value Standard ").append(minimumValueStandard).append("\n")
                .append("Lowest-Cost Monthly Individual\n")
                .append("Premium Amount ").append(lowestCostAmount).append("\n")
                .append("Currently enrolled ").append(currentlyEnrolled).append("\n");
        if (insuranceEnding != null) {
            details.append("Insurance ending in next 60 days ").append(insuranceEnding).append("\n");
        }
        if (voluntarilyEnding != null) {
            details.append("End date ").append(endingDate).append("\n")
                    .append("Voluntarily ending insurance ").append(voluntarilyEnding).append("\n");
        }
        return details.toString();
    }

    public static String getEsiApplicationDetailsSp(String coverageType, String minimumValueStandard,  String lowestCostAmount, String currentlyEnrolled, String insuranceEnding, String endDate, String voluntarilyEnding) {
        String endingDate = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endingDate = (basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy"));
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        StringBuilder details = new StringBuilder();
        details.append("Otra cobertura de salud\n")
                .append(SharedData.getPrimaryMember().getFullName()).append("\n")
                .append(coverageType).append("\n")
                .append("Job ").append(SharedData.getPrimaryMember().getEmployerName()).append("\n")
                .append("Minimum Value Standard ").append(minimumValueStandard).append("\n")
                .append("Lowest-Cost Monthly Individual\n")
                .append("Premium Amount ").append(lowestCostAmount).append("\n")
                .append("Currently enrolled ").append(currentlyEnrolled).append("\n");
        if (insuranceEnding != null) {
            details.append("Insurance ending in next 60 days ").append(insuranceEnding).append("\n");
        }
        if (voluntarilyEnding != null) {
            details.append("End date ").append(endingDate).append("\n")
                    .append("Voluntarily ending insurance ").append(voluntarilyEnding).append("\n");
        }
        return details.toString();
    }

    public static String getMedicareApplicationDetails(String coverageType, String premiumFree, String enrolled, String partAPremium, String partAEnding, String partAEndDate, String partBEnding, String partBEndDate) {
        String endingDateA = "";
        String endingDateB = "";
        if ("Today".equalsIgnoreCase(partAEndDate)) {
            endingDateA = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(partAEndDate)) {
            endingDateA = (basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy"));
        } else {
            System.out.println("Invalid option: " + partAEndDate);
        }
        if ("Today".equalsIgnoreCase(partBEndDate)) {
            endingDateB = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(partBEndDate)) {
            endingDateB = (basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy"));
        } else {
            System.out.println("Invalid option: " + partBEndDate);
        }

        StringBuilder details = new StringBuilder();
        details.append("Other Health Coverage\n")
                .append(SharedData.getPrimaryMember().getFullName()).append("\n")
                .append(coverageType).append("\n")
                .append("Currently Eligible for Medicare\n" + "Premium Free Part A ").append(premiumFree).append("\n")
                .append("Enrolled in Part A or B ").append(enrolled).append("\n");
        if (partAPremium != null) {
            details.append("Part A Premium Amount ").append(partAPremium).append("\n");
        }
        if (partAEnding != null) {
            details.append("Part A Ending in Next 60 Days ").append(partAEnding).append("\n");
        }
        if (endingDateA != null && !endingDateA.isEmpty()) {
            details.append("Part A End Date ").append(endingDateA).append("\n");
        }
        if (partBEnding != null) {
            details.append("Part B ending in next 60 days ").append(partBEnding).append("\n");
        }
        if (endingDateB != null && !endingDateB.isEmpty()) {
            details.append("Part B End Date ").append(endingDateB).append("\n");
        }
        return details.toString();
    }

    public static String getMedicareApplicationDetailsSp(String coverageType, String premiumFree, String enrolled, String partAPremium, String partAEnding, String partAEndDate, String partBEnding, String partBEndDate) {
        String endingDateA = "";
        String endingDateB = "";

        if ("Today".equalsIgnoreCase(partAEndDate)) {
            endingDateA = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(partAEndDate)) {
            endingDateA = (basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy"));
        } else {
            System.out.println("Invalid option: " + partAEndDate);
        }
        if ("Today".equalsIgnoreCase(partBEndDate)) {
            endingDateB = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(partBEndDate)) {
            endingDateB = (basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MM/dd/yyyy"));
        } else {
            System.out.println("Invalid option: " + partBEndDate);
        }
        StringBuilder details = new StringBuilder();
        details.append("Otra cobertura de salud\n")
                .append(SharedData.getPrimaryMember().getFullName()).append("\n")
                .append(coverageType).append("\n")
                .append("Currently Eligible for Medicare\n" + "Premium Free Part A ").append(premiumFree).append("\n")
                .append("Enrolled in Part A or B ").append(enrolled).append("\n");
        if (partAPremium != null) {
            details.append("Part A Premium Amount ").append(partAPremium).append("\n");
        }
        if (partAEnding != null) {
            details.append("Part A Ending in Next 60 Days ").append(partAEnding).append("\n");
        }
        if (endingDateA != null && !endingDateA.isEmpty()) {
            details.append("Part A End Date ").append(endingDateA).append("\n");
        }
        if (partBEnding != null) {
            details.append("Part B ending in next 60 days ").append(partBEnding).append("\n");
        }
        if (endingDateB != null && !endingDateB.isEmpty()) {
            details.append("Part B End Date ").append(endingDateB).append("\n");
        }
        return details.toString();
    }

    public static String getFamilyApplicationDetails(String offered, String premium, List<String> familyOption) {
        StringBuilder detailsBuilder = new StringBuilder();

        detailsBuilder.append("Family plan offered ").append(offered).append("\n");

        if (premium != null && !premium.isEmpty()) {
            detailsBuilder.append("Lowest-Cost Monthly Family\n")
                    .append("Premium Amount ").append(premium).append("\n");
        }

        List<String> enrolledMembers = new ArrayList<>();
        List<String> offeredNotEnrolledMembers = new ArrayList<>();
        List<String> noOptionMembers = new ArrayList<>();

        for (String option : familyOption) {
            if (option == null || option.trim().isEmpty()) {
                continue; // Skip if option is null or empty
            }

            String[] parts = option.split(":");
            if (parts.length < 2) {
                continue; // Skip if format is invalid
            }
            String name = parts[0].trim();
            String relation = parts[1].trim();

            String memberFullName = getString(name);

            switch (relation) {
                case "Enrolled":
                    enrolledMembers.add(memberFullName);
                    break;
                case "Offered a plan but not enrolled":
                    offeredNotEnrolledMembers.add(memberFullName);
                    break;
                case "No option to enroll":
                    noOptionMembers.add(memberFullName);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid relation: " + relation);
            }
        }

        appendMembers(detailsBuilder, "Enrolled", enrolledMembers);
        appendMembers(detailsBuilder, "Offered a plan but not enrolled", offeredNotEnrolledMembers);
        appendMembers(detailsBuilder, "No option to enroll", noOptionMembers);

        return detailsBuilder.toString();
    }

    private static void appendMembers(StringBuilder builder, String relation, List<String> members) {
        int totalMembers = members.size();

        if (totalMembers == 1) {
            String member = members.get(0).trim();
            member = modifyMemberSingleName(member);
            builder.append(relation).append(" ").append(member).append("\n");
        } else if (totalMembers > 1) {
            builder.append(relation).append("\n");

            for (int i = 0; i < totalMembers; i++) {
                String member = members.get(i).trim();

                if (i == 0) {
                    member = modifyMember1Name(member);
                    builder.append(" ").append(member);
                } else if (i == 1) {
                    member = modifyMember2Name(member);
                    builder.append(member);
                } else if (i == 2) {
                    member = modifyMember3Name(member);
                    builder.append(member);
                } else {
                    builder.append(member);
                }
            }
            builder.append("\n");
        }
    }


    private static String modifyMemberSingleName(String member) {
        String[] parts = member.trim().replaceAll("\\s+", " ").split(" ");

        if (parts.length >= 3) {
            return parts[0] + " " + parts[1] + "\n" + parts[2];
        }
        return member;
    }

    private static String modifyMember1Name(String member) {
        String[] parts = member.trim().replaceAll("\\s+", " ").split(" ");

        if (parts.length >= 3) {
            return parts[0] + " " + parts[1] + "\n" + parts[2] + ", ";
        }
        return member;
    }

    private static String modifyMember2Name(String member) {
        String[] parts = member.trim().replaceAll("\\s+", " ").split(" ");

        if (parts.length >= 3) {
            return parts[0] + "\n" + parts[1] + " " + parts[2] + ", \n";
        }
        return member;
    }

    private static String modifyMember3Name(String member) {
        String[] parts = member.trim().replaceAll("\\s+", " ").split(" ");

        if (parts.length >= 3) {
            return parts[0] + " " + parts[1] + "\n" + parts[2];
        }
        return member;
    }

    private static String getString(String name) {
        String memberFName;
        String memberLName;
        if (name.equals("Member1FullName")) {
            memberFName = SharedData.getMembers().get(0).getFirstName() + " " + SharedData.getMembers().get(0).getMiddleName();
            memberLName = SharedData.getMembers().get(0).getLastName();
        } else if (name.equals("Member2FullName")) {
            memberFName = SharedData.getMembers().get(1).getFirstName() + " " + SharedData.getMembers().get(1).getMiddleName();
            memberLName = SharedData.getMembers().get(1).getLastName();
        } else if (name.equals("Member3FullName")) {
            memberFName = SharedData.getMembers().get(2).getFirstName() + " " + SharedData.getMembers().get(2).getMiddleName();
            memberLName = SharedData.getMembers().get(2).getLastName();
        } else {
            throw new IllegalArgumentException("Invalid name placeholder: " + name);
        }
        return memberFName + " " + memberLName;
        }

    public static String getBasicApplicationDetails(String coverageType, String currentlyEnrolled, String insuranceEnding, String endDate, String voluntarilyEnding) {
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
                        "End date " + endingDate + "\n" +
                        "Voluntarily ending insurance " + voluntarilyEnding + "\n" : "");
    }

    public static String getBasicApplicationDetailsSp(String coverageType, String currentlyEnrolled, String insuranceEnding, String endDate, String voluntarilyEnding) {
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
                                "End date " + endingDate + "\n" +
                                "Voluntarily ending insurance " + voluntarilyEnding + "\n" : "");
    }




}