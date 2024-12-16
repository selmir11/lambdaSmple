package com.c4hco.test.automation.utils;

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
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class PDF {

    private BasicActions basicActions;
    static SoftAssert softAssert = new SoftAssert();

    public PDF(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // PDF Checking
    public void validateEntirePDF(String pdfExpected) throws IOException {
        // Validate static and dynamic PDFs
        boolean isStaticValid = validateStaticPDF(pdfExpected);
        boolean isDynamicValid = validateDynamicPDFText();
        System.out.println("Static Text: " + isStaticValid);
        System.out.println("Dynamic Text: " + isDynamicValid);

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
                    .withIgnore(PDFIgnore())
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

    // Gathering PDF ignore configuration (may be expanded in future)
    private String PDFIgnore() {
        return String.format("src/main/resources/MyDocs/Elig/Elig/Exempt/ignore.conf");
    }

    // Getting the expected PDF path
    public String PDFExpected(String pdfExpected) {
        return String.format("src/main/resources/MyDocs/Elig/Elig/Source/" + pdfExpected + ".pdf");
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
        return String.format("target/PDF-Output/" + pdfOutput + "_" + BasicActions.getInstance().getDateAndTime());
    }

    // Extracting text from PDF
    private static String extractTextFromPDF(String pdfPath) throws IOException {
        try (PDDocument document = Loader.loadPDF(new File(pdfPath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document).trim();
        }
    }

    // Validating the plan details in dynamic text
    public void validatePlanDetails(String pdfText) {
        PlanDbData medicalPlanDbData = SharedData.getMedicalPlanDbData().get("group1");
        String medicalPolicyId = "Your Connect for Health Colorado® Policy ID is " + SharedData.getPrimaryMember().getMedicalEapid_db() + ".";

        softAssert.assertTrue(pdfText.contains(medicalPlanDbData.getPlanName()), "Medical plan name doesn't match.");
        softAssert.assertTrue(pdfText.contains("Monthly Premium: $" + SharedData.getPrimaryMember().getTotalMedAmtAfterReduction()), "Medical premium amount doesn't match.");
        softAssert.assertTrue(pdfText.contains(medicalPolicyId), "Policy ID is not matching.");

        if (SharedData.getAppType().equals("exchange")) {
            String dentalPolicyId = "Your Connect for Health Colorado® Policy ID is " + SharedData.getPrimaryMember().getDentalEapid_db() + ".";
            PlanDbData dentalPlanDbData = SharedData.getDentalPlanDbData().get("group1");
            softAssert.assertTrue(pdfText.contains(dentalPlanDbData.getPlanName()), "Dental plan name doesn't match.");
            softAssert.assertTrue(pdfText.contains("Monthly Premium: $" + SharedData.getPrimaryMember().getTotalDentalPremAfterReduction()), "Dental premium amount doesn't match.");
            softAssert.assertTrue(pdfText.contains(dentalPolicyId), "Dental policy ID is not matching.");
        }
    }

    // Validating member names in the dynamic PDF text
    public void validateMemNames(String pdfText) {
        List<String> allMemNames = basicActions.getAllMemCompleteNames();
        for (String memName : allMemNames) {
            System.out.println(memName);
            softAssert.assertTrue(pdfText.contains(memName), memName + " text does not exist in downloaded PDF file.");
        }
    }
}

