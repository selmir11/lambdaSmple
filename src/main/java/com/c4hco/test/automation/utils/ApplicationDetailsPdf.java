package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ApplicationDetailsPdf {
    private static BasicActions basicActions;

    public ApplicationDetailsPdf(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    public static String getApplicationDetails(String minValue, String premium, String enrolled, String insruanceEnding, String ending, String lastSet, String endDate, String voluntarily) {
        String endingDate = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.lastDateOfCurrMonth();
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                "Employer Sponsored Insurance\n" +
                "Job " + SharedData.getPrimaryMember().getEmployerName() + "\n" +
                "Minimum Value Standard " + minValue + "\n" +
                "Lowest-Cost Monthly Individual\n" +
                "Premium Amount " + premium + "\n" +
                "Currently enrolled " + enrolled + "\n" +
                (insruanceEnding.equals("Insurance ending") ?
                        "Insurance ending in next 60 days " + ending + "\n" +
                                (lastSet.equals("Voluntarily ending") ?
                                        "End date " + endingDate + "\n" +
                                                "Voluntarily ending insurance " + voluntarily + "\n" : "") : ""));
    }

    public static String getApplicationDetailsSp(String minValue, String premium, String enrolled, String insruanceEnding, String ending, String lastSet, String endDate, String voluntarily) {
        String endingDate = "";

        if ("Today".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.getTodayDate();
        } else if ("Current Month".equalsIgnoreCase(endDate)) {
            endingDate = basicActions.lastDateOfCurrMonth();
        } else {
            System.out.println("Invalid option: " + endDate);
        }
        return String.format("Other Health Coverage\n" +
                SharedData.getPrimaryMember().getFullName() + "\n" +
                "Employer Sponsored Insurance\n" +
                "Job " + SharedData.getPrimaryMember().getEmployerName() + "\n" +
                "Minimum Value Standard " + minValue + "\n" +
                "Lowest-Cost Monthly Individual\n" +
                "Premium Amount " + premium + "\n" +
                "Currently enrolled " + enrolled + "\n" +
                (insruanceEnding.equals("Insurance ending") ?
                        "Insurance ending in next 60 days " + ending + "\n" +
                                (lastSet.equals("Voluntarily ending") ?
                                        "End date " + endingDate + "\n" +
                                                "Voluntarily ending insurance " + voluntarily + "\n" : "") : ""));
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




}