package com.c4hco.test.automation.pages.exchPages;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class DocumentLookupPage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public DocumentLookupPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".search-title")
    WebElement title;

    @FindBy(xpath = "//input[@value='advancedSearch']")
    WebElement advancedSearchradio;

    @FindBy(xpath = "//input[@value ='documentHandle']")
    WebElement documentHandleSearch;

    @FindBy(xpath = "//label[normalize-space()='Advanced Search']")
    WebElement advancedSearchlabel;

    @FindBy(xpath = "(//div[@class='drop-down-option drop-down-option-selected'])[1]")
    WebElement documentTypeDropdown;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//span")
    List<WebElement> documentTypeDropdownOptions;

    @FindBy(xpath = "//label[normalize-space()='Batch ID']")
    WebElement batchID;

    @FindBy(id = "receiveDate")
    WebElement receiveDate;

    @FindBy(id = "documentSource")
    WebElement documentSource;

    @FindBy(id = "documentAuthor")
    WebElement documentAuthor;

    @FindBy(id = "documentHandle")
    WebElement documentHandle;

    @FindBy(id = "carrierId")
    WebElement carrierID;

    @FindBy(id = "planId")
    WebElement planID;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//td[normalize-space()='Document Name']")
    WebElement documentName;

    @FindBy(xpath = "//td[normalize-space()='Document type']")
    WebElement documentType;

    @FindBy(xpath = "//td[normalize-space()='Account ID']")
    WebElement accountID;
    @FindBy(xpath = "//td[normalize-space()='Document Display Name']")
    WebElement documentDisplayName;
    @FindBy(xpath = "//td[normalize-space()='Created Date']")
    WebElement createdDate;
    @FindBy(xpath = "//td[normalize-space()='Archived Date']")
    WebElement archivedDate;
    @FindBy(xpath = "//td[normalize-space()='File Format']")
    WebElement fileFormat;

    @FindBy(css = "span[placement='top']")
    WebElement documentfiletxt;

    @FindBy(xpath = "//span[normalize-space()='1095A Dispute']")
    WebElement documentDisplayTxt;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/a[1]")
    WebElement accountNo;

    @FindBy(css = "a[placement='top']")
    WebElement documentDisplayNameTxt;

    @FindBy(xpath = "//app-document-lookup//table/tbody/tr/td[5]")
    WebElement txtCreateDate;

    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement txtArchivedDate;

    @FindBy(xpath = "//tbody//tr//td[7]")
    WebElement txtFileFormat;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//span")
    List<WebElement> sortOption;

    @FindBy(xpath = "//app-drop-down-select[@id='sortBy']//div[@class='drop-down-option drop-down-option-selected']")
    WebElement sortDropdown;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//div")
    List<WebElement> DropdownEntries;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement Next;

    @FindBy(xpath = "//button[normalize-space()='Previous']")
    WebElement previous;

    @FindBy(xpath = "//p[@class='paging-left body-text-1']")
    WebElement entries;

    @FindBy(xpath = "//tbody/tr/td[2]")
    List<WebElement> documentTypecolumn;

    @FindBy(xpath = "//tbody/tr/td[5]")
    List<WebElement> createdDatecolumn;

    @FindBy(xpath = "//input[@id='searchFrom']")
    WebElement fromDate;

    @FindBy(xpath = "//input[@id='searchTo']")
    WebElement ToDate;

    @FindBy(css = "div[class='scroll-area container'] div:nth-child(2)")
    List<WebElement> documentTypeOptions;

    @FindBy(css = "app-drop-down-select[id='entries'] div[class='drop-down-option drop-down-option-selected']")
    WebElement entrydropdown;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement All;

    @FindBy(xpath = "//div[@class='document-type-group row']//div[1]//input[1]")
    List<WebElement> Checkboxes;

    @FindBy(xpath = "//p[normalize-space()='Document type group is required']")
    WebElement docTypeGroupError;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//input[@id='accountId']")
    WebElement inputAccountID;

    @FindBy(xpath = "//button[@id='confirm-btn']")
    WebElement yesDeleteButton;

    @FindBy(id = "go-back-btn")
    WebElement goBackButton;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    List<WebElement> deleteButtons;


    public void validateTitle() {
        basicActions.switchtoactiveTab();
        softAssert.assertTrue(basicActions.waitForElementToBePresent(title, 10));
        softAssert.assertEquals(title.getText(), "Document Lookup Tool");
        softAssert.assertAll();
    }

    public void selectAdvancedSearch() {
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(advancedSearchradio, 15));
        advancedSearchradio.click();
        softAssert.assertEquals(advancedSearchlabel.getText(), "Advanced Search");
        softAssert.assertAll();
    }

    public void clickdropdown() {
        documentTypeDropdown.click();
    }

    public void searchDocumentHandle() {
        documentHandleSearch.click();
        basicActions.waitForElementToBePresent(documentHandle, 50);
        if (SharedData.getEnv().equals("qa"))
            documentHandle.sendKeys("311091");
        else {
            documentHandle.sendKeys("55510");
        }
        submitButton.click();
    }

    public void verifyAdminTableColumns() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentName, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentType, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(accountID, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentDisplayName, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(createdDate, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(archivedDate, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(fileFormat, 10));
        softAssert.assertAll();
    }

    public void verifyAdminSearchcriteria() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(accountID, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(batchID, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(fromDate, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(ToDate, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(receiveDate, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentSource, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentDisplayName, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(carrierID, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(planID, 10));
        softAssert.assertAll();
    }

    public void verifyDocumentTyperequireerror() {
        clickSubmit();
        softAssert.assertTrue(basicActions.waitForElementToBePresent(docTypeGroupError, 10));
        softAssert.assertAll();
    }

    public void verifycontent() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentfiletxt, 10));
        softAssert.assertEquals(documentfiletxt.getText(), "IND_1095A Dispu..");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentDisplayTxt, 10));
        softAssert.assertEquals(documentDisplayTxt.getText(), "1095A Dispute");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(accountNo, 20));
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(accountNo.getText(), "1907010548");
            softAssert.assertEquals(documentDisplayNameTxt.getText(), "Correction Requ..");
            softAssert.assertEquals(txtCreateDate.getText(), "10/26/2020 15:47:56");
            softAssert.assertEquals(txtArchivedDate.getText(), "10/26/2020 15:47:56");
            softAssert.assertEquals(txtFileFormat.getText(), "DOCX");
            softAssert.assertAll();
        } else {
            softAssert.assertEquals(accountNo.getText(), "2719004301");
            softAssert.assertEquals(documentDisplayNameTxt.getText(), "Correction Proo..");
            softAssert.assertEquals(txtCreateDate.getText(), "10/07/2020 14:04:02");
            softAssert.assertEquals(txtArchivedDate.getText(), "10/07/2020 14:04:03");
            softAssert.assertEquals(txtArchivedDate.getText(), "10/07/2020 14:04:03");
            softAssert.assertEquals(txtFileFormat.getText(), "PNG");
            softAssert.assertAll();
        }
    }

    public void selectoption(String text) {
        basicActions.selectValueFromDropdown(documentTypeDropdown, documentTypeDropdownOptions, text);
    }

    public void selectsortoption(String text) {
        basicActions.selectValueFromDropdown(sortDropdown, sortOption, text);
    }

    public void clickSubmit() {
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(submitButton, 60));
        submitButton.click();
        softAssert.assertAll();
    }

    public void inputdates() {
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(fromDate, 20));
            fromDate.sendKeys("10/01/2023");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(ToDate, 20));
            ToDate.sendKeys("02/01/2024");
            softAssert.assertAll();
        }
        else {
            softAssert.assertTrue(basicActions.waitForElementToBePresent(fromDate, 20));
            fromDate.sendKeys("07/01/2022");
            softAssert.assertTrue(basicActions.waitForElementToBePresent(ToDate, 20));
            ToDate.sendKeys("07/01/2024");
            softAssert.assertAll();
        }
    }

    public void verifysortoptionsasc(List<WebElement> options) {
        List<String> OriginalList = options.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> NewList = OriginalList.stream().sorted().collect(Collectors.toList());
        softAssert.assertEquals(NewList, OriginalList);
        softAssert.assertAll();
    }

    public void verifysortoptionsdesc(List<WebElement> options) {
        List<String> OriginalList = options.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> NewList = OriginalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        softAssert.assertEquals(NewList, OriginalList);
        softAssert.assertAll();
    }

    public void verifySortasc(String sortbyoptions) {
        clickSubmit();
        basicActions.wait(30);
        switch (sortbyoptions) {
            case "Document Type":
                verifysortoptionsasc(documentTypecolumn);
                break;
            case "Created Date":
                verifysortoptionsasc(createdDatecolumn);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " + sortbyoptions);
        }
    }

    public void verifysortdesc(String sortbyoptions) {
        clickSubmit();
        basicActions.wait(50);
        switch (sortbyoptions) {
            case "Document Type":
                verifysortoptionsdesc(documentTypecolumn);
                break;
            case "Created Date":
                verifysortoptionsdesc(createdDatecolumn);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " + sortbyoptions);
        }
    }

    public void verifysort(String ascdescoptions, String sortbyoptions) {
        switch (ascdescoptions) {
            case "asc":
                verifySortasc(sortbyoptions);
                break;
            case "desc":
                verifysortdesc(sortbyoptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " + ascdescoptions);
        }
    }

    public void unselectAllcheckbox() {
        basicActions.waitForElementToBeClickable(All, 20);
        All.click();
        boolean isSelected = All.isSelected();
        assert !isSelected : "All checkbox is not selected";
    }

    public Boolean checkboxclick() {
        for (int i = 1; i < Checkboxes.size(); i++) {
            Checkboxes.get(i).click();
            return Checkboxes.get(i).isSelected();
        }
        return false;
    }

    public void validateDropdownEntries() {
        basicActions.waitForElementToBePresent(entrydropdown, 50);
        softAssert.assertEquals(entrydropdown.getText(), "20");
        softAssert.assertAll();
    }

    public void entriesdropdown(int rowsUI) {
        basicActions.selectValueFromDropdown(entrydropdown, DropdownEntries, String.valueOf(rowsUI));
        int rows = documentTypecolumn.size();
        softAssert.assertEquals(rows,rowsUI);
        softAssert.assertAll();
    }

    public void validateNextAndPreviousButtons() {
        int initialCurrentValue = getCurrentValue();
        int currentValue = initialCurrentValue;
        while (Next.isDisplayed()) {
                int nextValue = clickNextAndGetNewValue();
                if (nextValue <= currentValue) {
                    throw new RuntimeException("Next button did not increase value as expected.");
                }
                currentValue = nextValue;
        }

        while (previous.isDisplayed()) {
                int previousValue = clickPreviousAndGetNewValue();
                if (previousValue >= currentValue) {
                    throw new RuntimeException("Previous button did not decrease value as expected.");
                }
                currentValue = previousValue;
            }
        }

    private int getCurrentValue() {
        String fullText = entries.getText();
        String extractDesiredText = fullText.substring(8, 11);
        String numericText = extractDesiredText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericText);
    }

    private int clickNextAndGetNewValue() {
        basicActions.waitForElementToBePresent(Next, 500);
        Next.click();
        basicActions.wait(500);
        return getCurrentValue(); }

    private int clickPreviousAndGetNewValue() {
        basicActions.waitForElementToBePresent(previous, 500);
        previous.click();
        basicActions.wait(500);
        return getCurrentValue();
    }

            public void clickDropdowns() {
                String Options[] = {"Exchange", "Individual", "SHOP", "Broker", "Navigator", "Carrier", "Appeal"};
                for (String option : Options) {
                    basicActions.selectValueFromDropdown(documentTypeDropdown, documentTypeDropdownOptions, option);
                    String selectedOptionText = documentTypeDropdown.getText();
                    List<String> optionslist = documentTypeOptions.stream().map(WebElement::getText).toList();
                    unselectAllcheckbox();
                    checkboxclick();
                    switch (selectedOptionText) {
                        case "Exchange":
                            List<String> ExchExpectedList = List.of("EXC_General Feedback Form (AM-009-01)", "EXC_General Complaint Form (AM-009-02)", "EXC_General Complaint Form (AM-009-02)", "EXC_Physical Returned Mail (IN-002-01)", "EXC_New Account Created (AM-006-01)", "EXC_Account Update (AM-015-01)", "EXC_Create Back Office Exchange Account Form (AM-006-03)", "EXC_Create Employee Exchange Account Form (AM-006-01)", "EXC_Change Staff Account Request (AM-015-01)", "DELETE-EXC_Individual Life Change Event Form (AM-015-02)", "DELETE-EXC_Individual Appeal Exchange Subsidy Form (AM-009-01)", "EXC_Modify Back Office Exchange Account Form (AM-015-03)", "EXC_Manage Login (AM-016-06)", "EXC_Manage Password (AM-007-06)", "EXC_Create Staff Exchange Account (AM-006-01)",
                                    "EXC_Login Reminder (AM-016-06)", "EXC_HCPF Related Correspondence", "EXC_NES Application");
                            Assert.assertEqualsNoOrder(ExchExpectedList, optionslist);
                            break;
                        case "Individual":
                            List<String> IndExpectedList = List.of("IND_Health First Colorado (Medicaid) Application", "Application Results", "IND_Health First Colorado (Medicaid) Redetermination", "IND_Health First Colorado (Medicaid) Redetermination", "IND_Employer Application Form (ELG-005-01)", "IND_SSN Verification (ELG-002-01)", "IND_Incarceration Status (ELG-002-02)", "IND_SSAP with Financial Assistance Form (EN-002-01)", "IND_Individual Addendum Form (EN-002-02)", "IND_Individual Addendum Form (EN-002-02)", "IND_Employer Coverage Tool Form (EN-002-02)", "IND_SSAP Worksheet A (EN-002-04)", "IND_SSAP Worksheet B (EN-002-05)", "IND_SSAP Worksheet C (EN-002-06)", "IND_SSAP Worksheet D (EN-002-07)", "IND_Tribal Membership Verification (ELG-005-11)", "IND_Death Certificate (ELG-005-13)", "IND_Marriage Dissolution (ELG-005-14)", "IND_Legal Separation (ELG-005-15)", "IND_Employment Status Change (ELG-005-20)",
                                    "IND_Qualified Medical Child Support Order (ELG-005-21)", "IND_Correspondence (IN-001-01)", "IND_Welcome Message (AM-001-02)", "IND_Non-ESI Peace Corps", "IND_SSAP Worksheet E (EN-002-08)", "IND_Manage Password (AM-007-01)", "IND_Employee Addendum Form (EN-003-02)",
                                    "IND_Small Business Marketplace Worksheet A (EN-003-03)", "IND_Authorized Representative Form (AM-011-01)", "IND_Preliminary Proposal (BN-004-05)", "IND_General Feedback Form (AM-009-01)", "IND_Life Change Event Form (ELG-005-01)", "SHP_Employee Life Change Event without SEP (ELG-005-07B)", "IND_Renewal Plan Still Available (EN-007-01)",
                                    "IND_Renewal Plan Not Available (EN-007-02)", "IND_Enrollment 30 Day Reminder (EN-001-03)", "IND_Enrollment 16 Day Reminder (EN-001-02)", "IND_Individual Life Change Event with SEP (ELG-005-07C)", "IND_Individual Life Change Event without SEP (ELG-005-07D)",
                                    "IND_IRS 1095A Correspondence", "IND_HCPF Related Correspondence", "IND_Effective Date Attestation (EN-008-01)",
                                    "IND_MA Site Fax", "IND_MA Site Mail", "IND_IRS 1095A Tax Form - Void", "IND_Tax Filing Status Attestation (ELG-008-01)",
                                    "IND_Attestation Approved (EN-008-02)", "IND_Attestation Denied (EN-008-03)", "IND_Renewal Action Required (EN-007-03)", "IND_1095A Dispute (DIS-001-01)",
                                    "IND_Initial Eligibility notice (ELG-101-01)", "IND_Eligibility Change with No SEP (ELG-101-02)", "IND_Eligibility Change with SEP (ELG-101-03)",
                                    "IND_Manual Verification Reminder notice (VER-001-01)", "IND_Confirm Household Information (VER-003-01)", "IND_Identity Proof (IDT-1)", "IND_Non-ESI TRICARE", "IND_Non-ESI Veterans Affairs",
                                    "IND_Dual Enrollment in Financial Help Programs (PDM-1)", "IND_Profile Change (AM-011-02)", "IND_Profile Change (AM-011-03)",
                                    "IND_Login Reminder (AM-016-01)", "IND_Final Eligibility Determination (ELG-002-01)", "IND_Final Elg Det No Subsidy (ELG-002-03)",
                                    "IND_LCE Documentation Approval (ELG-005-02)", "SHP_Employee Added to Roster (SH-003-01)", "IND_Native American Status Verification 30 day notice (EN-004-04)",
                                    "SHP_Employee Removed from Coverage (SH-003-03)", "IND_Loss of Coverage - Head of Household (ELG-005-04)", "IND_Open Enrollment Reminder (EN-001-01)", "IND_LCE Documentation Non-Receipt (ELG-005-01)", "IND_Receipt of Non-Financial SSAp (ELG-006-01)",
                                    "IND_Ineligible Life Change Event (ELG-005-05)", "SHP_Employee Open Enrollment Welcome Message (EN-001B-01)", "SHP_Employee Open Enrollment Reminder Message (EN-001B-02)", "IND_QHP Enrollment Confirmation (EN-002-01)", "IND_QHP Application Issue (EN-002-02)",
                                    "IND_QHP Non-Enrollment (EN-002-03)", "IND_Native American Status Unable to Verify (EN-004-02)", "IND_Native American Verification Documentation Request (EN-004-03)", "IND_Individual/Employee Notification of Dis-enrollment (EN-006-01)",
                                    "IND_Employer Notification of Dis-enrollment (EN-006-02)", "IND_Dis-enrollment from Plan Form (EN-006-01)", "IND_Password Change (AM-016-08)",
                                    "IND_Reset Password (AM-016-07)", "IND_Additional Documentation Request (ELG-002-02)", "IND_Citizenship/Immigration Status (ELG-002-04)", "IND_Marriage License (ELG-005-01)", "IND_Special Enrollment Period (ELG-005-03)", "IND_Special Enrollment Period Closing (ELG-005-04)",
                                    "IND_Loss of Coverage - Employer Sponsored (ELG-005-05)", "IND_Proof of Address Change (ELG-005-07)", "IND_Proof of Citizenship (ELG-005-08)",
                                    "IND_Length of Immigration Residency (ELG-005-09)", "IND_Income Verification (ELG-005-10)", "IND_Age Out for Dependent Child (ELG-005-16)",
                                    "IND_Loss of Coverage - Spouse Sponsored (ELG-005-17)", "IND_Loss of Student Status for Dependent (ELG-005-18)", "IND_Marriage of Dependent Child (ELG-005-19)",
                                    "IND_Welcome Message (AM-001-01)", "IND_Welcome Message (AM-001-03)", "IND_Subsidy Removed (Customer Choice) (ELG-005-08)", "IND_Notify Client of Broker Authorization (BN-002A-03)", "IND_Notify Client of Broker De-Authorization (BN-002A-04)", "IND_Plan Selection and Payment Confirmation (EN-002-04)", "SHP_Employee Enrollment Welcome Message (EN-003-02)", "IND_Native American Status Verification (EN-004-01)", "IND_Employer Eligibility Appeal Form (EN-002-01)", "IND_Update Native American Status Form (EN-004-01)", "IND_Individual Coverage Exemption Form (ELG-004-01)", "IND_Individual Appeal Exchange Subsidy Form (ELG-008-01)", "IND_Income Verification (ELG-002-03)", "IND_Birth Certificate (ELG-005-02)", "IND_Adoption Documentation (ELG-005-03)", "IND_Change in IAP Eligibility (ELG-005-06)", "IND_Authorized Representative (ELG-002-04)", "IND_Client Invitation (BN-003-01)", "IND_Final Proposal (BN-004-06)", "IND_My Profile Change Form (AM-011-01)", "IND_SSAP Appendix A (EN-002-09)", "IND_Additional Documentation Response (ELG-002-02)", "IND_Authorized Representative Verification Response (ELG-002-04)",
                                    "SHP_Employee Life Change Event with SEP (ELG-005-07A)", "SHP_Authorize Account Delegate (AM-005-01)", "IND_IRS 1095A Tax Form", "IND_IRS 1095A Tax Form - Corrected", "IND_Non-ESI Medicare");
                            Assert.assertEqualsNoOrder(IndExpectedList, optionslist);
                            break;
                        case "SHOP":
                            List<String> ShopExpectedList = List.of("SHP_Final Proposal (BN-004-04)", "SHP_Preliminary Proposal (BN-004-03)", "SHP_Preliminary Proposal (BN-004-03)", "SHP_Employee Life Change Event (ELG-005-06)",
                                    "SHP_Correspondence (IN-001-02)", "SHP_Eligible for Participation (SH-001-01)", "SHP_Supporting Documentation for an Appeal (SH-001A-01)", "SHP_Employer Logo (SH-002-01)", "SHP_Employer Customer Welcome Message (SH-002-02)", "SHP_Supporting Documentation for an Appeal (SH-005-01)", "SHP_Welcome Message (AM-002-01)", "SHP_Welcome Message (AM-002-02)", "SHP_QHP Employer Enrollment Confirmation (EN-003-01)", "SHP_Profile Change (AM-012-01)", "SHP_Pre-Billing Notice (Employer) (FM-002-01)",
                                    "SHP_Aggregated Monthly Bill (Employer) (FM-002-02)", "SHP_Aggregated Monthly Statement (Employer) (FM-002-03)", "SHP_Missed Due Date (Employer) (FM-002A-01)",
                                    "SHP_Lapse Date and Late Fee (Employer) (FM-002A-02)", "SHP_Not Sufficient Funds (Employer) (FM-002A-03)", "SHP_Partial Initial Payment (FM-002A-04)",
                                    "SHP_Type 2 Underpayment (FM-002A-06)", "SHP_Late Fee / Approaching Term Date (T2 Underpmt) (FM-002A-09)", "SHP_Ineligible for Participation (SH-001-02)",
                                    "SHP_No Coverage (EN-003-04)", "SHP_Non-enrollment (EN-003-05)", "SHP_Employer Application Form (EN-003-01)", "SHP_Employer Eligibility Appeal Form (SH-001A-01)",
                                    "SHP_Employer Appeal Form for Employee APTC (SH-005-01)", "SHP_Create Proposal (BN-004-01)", "SHP_Create Proposal (BN-004-03)", "SHP_Login Reminder (AM-016-02)",
                                    "SHP_Manage Password (AM-007-02)", "SHP_Number of Employees Verification (SH-001-01)", "SHP_Client Invitation (BN-003-02)", "SHP_Employer Enrollment Renewal (EN-003-06)", "SHP_Employer Notification of Dis-enrollment (EN-006-02)", "SHP_Notify SHOP of Broker Authorization (BN-002A-07)", "SHP_Notify SHOP of Broker De-Authorization (BN-002A-08)");
                            Assert.assertEqualsNoOrder(ShopExpectedList, optionslist);
                            break;
                        case "Broker":
                            List<String> BrokerexpectedList = List.of("AGY_Agency Invites Broker (AG-001-01)", "AGY_Agency Adds Authorized Rep (AG-001-02)", "AGY_Agency Adds Authorized Rep (AG-001-02)", "AGY_Broker DeAuthorization (AG-001-03)", "AGY_Broker Accepted Authorization (AG-002-01)", "AGY_Broker Revokes Authorization (AG-002-02)", "BRK_Notify Broker of New Client (BN-002A-05)", "BRK_SHOP Client Declined Proposal (BN-004-07)", "BRK_Notify Broker of De-Authorization (BN-002A-06)", "BRK_Broker Certification (AM-003-01)", "BRK_Login Reminder (AM-016-03)", "BRK_Manage Password (AM-007-03)", "BRK_Broker Certification Appeal Form (BN-001A-01)", "BRK_Agent Broker Authorization Form (BN-003-01)", "BRK_Proof of Insurance (AM-013-01)", "BRK_Proof of License (AM-013-02)", "BRK_Proof of Training Completion (AM-013-03)", "BRK_Individual Client Declined Proposal (BN-004-08)", "BRK_Individual Client Accepted Proposal (BN-004-02)", "BRK_Welcome Message (AM-003-01)", "BRK_Notify Broker of De-Authorization (BN-002A-02)", "BRK_Sub-Broker Account Created (AM-013-05)", "BRK_Sub-Broker Account Updated (AM-013-06)", "BRK_SHOP Client Accepted Proposal (BN-004-01)", "BRK_Profile Update (AM-013-01)", "BRK_Proof of Training Completion (BN-001A-03)", "BRK_Broker of Record Authorization Letter (BN-003-01)", "BRK_Broker of Record De-authorization Letter (BN-003-02)", "BRK_Correspondence (IN-001-03)", "BRK_Certified Mail Signature Receipt (IN-002-1)", "BRK_Broker Letter of Record Form (BN-003-01)", "BRK_Notify Broker of New Client (BN-002A-01)", "BRK_Proof of Insurance (BN-001A-01)", "BRK_Proof of License (BN-001A-02)", "BRK_Broker Certified (BN-001A-01)");
                            Assert.assertEqualsNoOrder(BrokerexpectedList, optionslist);
                            break;
                        case "Navigator":
                            List<String> NavigatorExpectedList = List.of("NAV_Proof of Training Completion (BN-001B-01)", "NAV_Correspondence (IN-001-04)", "NAV_Correspondence (IN-001-04)", "NAV_Profile Update (AM-013-02)",
                                    "NAV_ Navigator Entity Profile Update (AM-013-03)", "NAV_Navigator Entity Profile Update (AM-013-03)", "NAV_Welcome Message (AM-004-01)", "NAV_Welcome Message (AM-004-02)", "NAV_Navigator Certification Appeal Form (BN-001B-01)", "NAV_Navigator Authorization Form (BN-005-01)", "NAV_Proof of Training Completion (AM-013-04)", "NAV_Login Reminder (AM-016-04)",
                                    "NAV_Manage Password (AM-007-04)", "NAV_Navigator Entity Login Reminder (AM-016-05)", "NAV_Navigator Entity Manage Password (AM-007-05)", "NAV_Heatlh Coverage Guide Authorization Form (BN-005-01)");
                            Assert.assertEqualsNoOrder(NavigatorExpectedList, optionslist);
                            break;
                        case "Carrier":
                            List<String> CarrierExpectedList = List.of("CAR_Carrier Summary Invoice (FM-001-01)", "CAR_Marketing Materials (PM-004-03)", "CAR_Marketing Materials (PM-004-03)", "CAR_Correspondence (IN-001-05)", "CAR_Quality Ratings (PM-001-01)", "CAR_Transparancy Disclosure (PM-001-02)", "CAR_Marketing Materials (PM-001-03)", "CAR_Provider Network Directory (PM-004-01)", "CAR_Quality Ratings (PM-004-02)");
                            softAssert.assertEquals(CarrierExpectedList, optionslist);
                            break;
                        case "Appeal":
                            List<String> AppealExpectedList = List.of("Appeal Case Notes", "Appeal Request Form", "Appeal Request Form", "Appeal Supporting Document");
                            Assert.assertEqualsNoOrder(AppealExpectedList, optionslist);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid option: " + selectedOptionText);
                    }
                }
            }

            public void verifyDeleteButtondisplays(){
        basicActions.waitForElementToBePresent(deleteButton,50);
        softAssert.assertEquals(deleteButton.getText(),"Delete");
        softAssert.assertAll();
            }

            public void clickDeleteButton(){
          basicActions.waitForElementToBePresent(deleteButton,50);
           deleteButton.click();
            }

            public void enterAccountNumber(){
                basicActions.waitForElementToBePresent(inputAccountID,50);
                inputAccountID.click();
                inputAccountID.sendKeys(String.valueOf(SharedData.getPrimaryMember().getAccount_id()));
            }


            public void clickNoGoBackButton(){
             basicActions.waitForElementToBePresent(goBackButton,50);
             goBackButton.click();
            }

            public void clickYesDeleteButton(){
             basicActions.waitForElementToBePresent(yesDeleteButton,60);
             yesDeleteButton.click();
            }

            public void verifyDeleteButtonNotDisplay(){
            softAssert.assertTrue(deleteButtons.isEmpty());
            softAssert.assertAll();
            }

}


