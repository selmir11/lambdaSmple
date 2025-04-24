package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.Dto.SharedData;
import de.redsix.pdfcompare.PdfComparator;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class PDF {

    // Global Variables
    private BasicActions basicActions;
    static SoftAssert softAssert = new SoftAssert();

    // Constructor for PDF class
    public PDF(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // PDF Checking
    public void validateEntirePDF(String pdfExpected) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        // Validate static and dynamic PDFs
        boolean isStaticValid = validateStaticPDF(pdfExpected);
        boolean isDynamicValid = validateDynamicPDFText();

        // Use soft assertions for validation
        softAssert.assertTrue(isStaticValid, "Static PDF validation failed.");
        softAssert.assertTrue(isDynamicValid, "Dynamic PDF text validation failed.");

        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            System.err.println("Validation failures found: " + e.getMessage());
        }
    }

    // Static PDF Validation
    public boolean validateStaticPDF(String pdfExpected) throws IOException {

        return new PdfComparator(PDFExpected(pdfExpected), String.valueOf(PDFDownloaded()))
                    .withIgnore(PDFIgnore(pdfExpected))
                    .compare()
                    .writeTo(PDFOutput(pdfExpected));
    }

    // Dynamic PDF Text Validation
    public boolean validateDynamicPDFText() throws IOException {
        String pdfText = new String(extractTextFromPDF(PDFDownloaded()));
        boolean isValid = true;

        try {
            softAssert.assertTrue(pdfText.contains(SharedData.getPrimaryMember().getEmailId()), "Primary member email ID is not matching.");
            softAssert.assertTrue(pdfText.contains(basicActions.changeDateFormat(LocalDate.now().toString(), "yyyy-MM-dd", "MMMM d, yyyy")), "Current date is not matching.");
            validateMemNames(pdfText);
            softAssert.assertAll();
        } catch (AssertionError e) {
            System.err.println("Dynamic PDF validation failed: " + e.getMessage());
            isValid = false;
        }

        return isValid;
    }

    // Gathering PDF ignore configuration (might be expanded in future)
    private String PDFIgnore(String pdfExpected) {

        nameExtract(pdfExpected);
        String[] extractedValues = nameExtract(pdfExpected);

        String language = extractedValues[0];  // "English" or "Spanish"
        String noticeType = extractedValues[1]; // "Elig"

        if (SharedData.getIsOpenEnrollment().equals("no")) {
            return String.format("src/main/resources/MyDocs/Notices/Exempt/Closed Enrollment/"+ noticeType +"/"+ language +"/"+ pdfExpected  +".conf");
        } else {
            return String.format("src/main/resources/MyDocs/Notices/Exempt/Open Enrollment/"+ noticeType +"/"+ language +"/"+ pdfExpected  +".conf");
        }


    }

    // Getting the expected PDF path
    public String PDFExpected(String pdfExpected) {

        nameExtract(pdfExpected);
        String[] extractedValues = nameExtract(pdfExpected);

        String language = extractedValues[0];  // "English" or "Spanish"
        String noticeType = extractedValues[1]; // "Elig"

        if (SharedData.getIsOpenEnrollment().equals("no")) {
            return String.format("src/main/resources/MyDocs/Notices/Source/Closed Enrollment/"+ noticeType +"/"+ language +"/"+ pdfExpected + ".pdf");
        } else {
            return String.format("src/main/resources/MyDocs/Notices/Source/Open Enrollment/"+ noticeType +"/"+ language +"/"+ pdfExpected + ".pdf");
        }
    }

    // Getting the downloaded PDF path
    public String PDFDownloaded() {
        String filePath = SharedData.getLocalPathToDownloadFile();
        String fileName = SharedData.getNoticeFileName();
        String pathAndName = filePath + "//" + fileName;
        System.out.println("File path and name is " + pathAndName);
        return Path.of(pathAndName).toString();
    }

    // Getting the output path for comparison
    public String PDFOutput(String pdfOutput) {

        Path outputDirectory = Paths.get("target/PDF-Output");

        // Check if the directory exists, and create it if it doesn't
        if (Files.notExists(outputDirectory)) {
            try {
                Files.createDirectories(outputDirectory);  // Create the directory if it doesn't exist
            } catch (IOException e) {
                e.printStackTrace();
                return null;  // Return null or handle the error appropriately
            }
        }

        return String.format("target/PDF-Output/" + BasicActions.getInstance().getDateAndTime() + "_" + pdfOutput);
    }

    // Extracting text from PDF
    private static String extractTextFromPDF(String pdfPath) throws IOException {
        try (PDDocument document = Loader.loadPDF(new File(pdfPath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

    // Validating member names in the dynamic PDF text
    public void validateMemNames(String pdfText) {
        List<MemberDetails> allMedicalEligMembers = basicActions.getAllMedicalEligibleMemInfo();
        List<String> memberCompleteFullName = allMedicalEligMembers.stream().filter(MemberDetails::getHasMedicalPlan).map(MemberDetails::getCompleteFullName).toList();
        for (String memName : memberCompleteFullName) {
            System.out.println(memName);
            softAssert.assertTrue(pdfText.contains(memName), memName + " text does not exist in downloaded PDF file.");
            softAssert.assertAll();
        }

        List<MemberDetails> allDentalEligMembers = basicActions.getAllDentalEligibleMemInfo();
        List<String> memCompleteFullName = allDentalEligMembers.stream().filter(MemberDetails::getHasMedicalPlan).map(MemberDetails::getCompleteFullName).toList();
        for (String memName : memCompleteFullName) {
            System.out.println(memName);
            softAssert.assertTrue(pdfText.contains(memName), memName + " text does not exist in downloaded PDF file.");
            softAssert.assertAll();
        }
    }

    public String[] nameExtract(String pdfExpected) {

        String language = pdfExpected.contains("English") ? "English" : "Spanish";
        String noticeType = pdfExpected.contains("ELIG") ? "Elig" : "AM";

        return new String[] { language, noticeType };
    }

    // Validating the plan details in dynamic text
    public void validatePlanDetails(String pdfText) {
        List<MemberDetails> allMedicalEligMembers = basicActions.getAllMedicalEligibleMemInfo();
        List<String> memberCompleteFullName = allMedicalEligMembers.stream().filter(MemberDetails::getHasMedicalPlan).map(MemberDetails::getCompleteFullName).toList();
        for(String memberName:memberCompleteFullName){
            String medicalPlanName = basicActions.getAllMem().stream().filter(member->member.getCompleteFullName().contains(memberName) && member.getHasMedicalPlan()).map(MemberDetails::getMedicalPlan).findFirst().orElse("Medical Plan Name Not found for member : "+memberName);
            String monthlyPremium = basicActions.getAllMem().stream().filter(member->member.getCompleteFullName().contains(memberName) && member.getHasMedicalPlan()).map(MemberDetails::getTotalMedAmtAfterReduction).findFirst().orElse("Medical Plan Premium Not found for member : "+memberName);
            String medicalPolicyId = basicActions.getAllMem().stream().filter(member->member.getCompleteFullName().contains(memberName) && member.getHasMedicalPlan()).map(MemberDetails::getMedicalEapid_db).findFirst().orElse("Medical Policy Id Not found for member : "+memberName);

            softAssert.assertTrue(pdfText.contains(medicalPlanName), "Medical plan name doesn't match.");
            softAssert.assertTrue(pdfText.contains("Monthly Premium: $" + monthlyPremium), "Medical premium amount doesn't match.");
            softAssert.assertTrue(pdfText.contains(medicalPolicyId), "Medical policy ID is not matching.");
            softAssert.assertAll();
        }

        if (SharedData.getAppType().equals("exchange")) {
            List<MemberDetails> allDentalEligMembers = basicActions.getAllMedicalEligibleMemInfo();
            List<String> memberCompleteFullNames = allDentalEligMembers.stream().filter(MemberDetails::getHasDentalPlan).map(MemberDetails::getCompleteFullName).toList();

            for (String memberName : memberCompleteFullNames) {
                String DentalPlanName = basicActions.getAllMem().stream().filter(member -> member.getCompleteFullName().contains(memberName) && member.getHasDentalPlan()).map(MemberDetails::getDentalPlan).findFirst().orElse("Dental Plan Name Not found for member : " + memberName);
                String monthlyPremium = basicActions.getAllMem().stream().filter(member -> member.getCompleteFullName().contains(memberName) && member.getHasDentalPlan()).map(MemberDetails::getTotalDentalPremAfterReduction).findFirst().orElse("Dental Premium Not found for member : " + memberName);
                String dentalPolicyId = basicActions.getAllMem().stream().filter(member -> member.getCompleteFullName().contains(memberName) && member.getHasDentalPlan()).map(MemberDetails::getDentalEapid_db).findFirst().orElse("Dental Policy Id Not found for member : " + memberName);

                softAssert.assertTrue(pdfText.contains(DentalPlanName), "Dental plan name doesn't match.");
                softAssert.assertTrue(pdfText.contains("Monthly Premium: $" + monthlyPremium), "Dental premium amount doesn't match.");
                softAssert.assertTrue(pdfText.contains(dentalPolicyId), "Dental policy ID is not matching.");
                softAssert.assertAll();
            }
        }
    }
}

