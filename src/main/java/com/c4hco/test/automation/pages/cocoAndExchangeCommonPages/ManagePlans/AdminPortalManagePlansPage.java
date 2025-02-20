package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ManagePlans;
        import com.c4hco.test.automation.Dto.ManagePlanDentalMedicalPlan;
        import com.c4hco.test.automation.Dto.MemberDetails;
        import com.c4hco.test.automation.Dto.SharedData;
        import com.c4hco.test.automation.utils.BasicActions;
        import io.cucumber.datatable.DataTable;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.Assert;
        import org.testng.asserts.SoftAssert;

        import java.math.BigDecimal;
        import java.time.Year;
        import java.util.*;

public class AdminPortalManagePlansPage {

    private BasicActions basicActions;

    public AdminPortalManagePlansPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);


    }

    SoftAssert softAssert = new SoftAssert();
    ManagePlanDentalMedicalPlan managePlanDentalMedicalPlan = new ManagePlanDentalMedicalPlan();

    @FindBy(id = "enrollments-container")
    WebElement mPlansContainer;
    @FindBy(xpath = "//a[@routerlink='search']")
    WebElement lnkSearch;
    @FindBy(css = ".manage-plans-title.header-2")
    WebElement txtTitleManagePlans;
    @FindBy(css = ".select-year-label")
    WebElement txtSelectPlanYear;
    @FindBy(css = "p[class='page-title'] strong")
    WebElement titleInBlueBar;
    @FindBy(css = ".drop-down-option.drop-down-option-selected")
    WebElement dpdCurrentYearMP;
    @FindBy(css = "a[target='_blank'][routerlink='policies']")
    WebElement btnManagePlans;
    @FindBy(xpath = "//span[@class='select-planyear-label']")
    WebElement planYearLabel;
    @FindBy(xpath = "//div[@class='select-plan-type-label']")
    WebElement txtSelectPlanType;
    @FindBy(xpath = "//label[normalize-space()='Medical']")
    WebElement chkMedical;
    @FindBy(xpath = "//label[.='Dental']")
    WebElement chkDental;
    @FindBy(xpath = "//*[@id='enrollments-container']/div[1]/div[3]/div[2]/div[1]/label")
    WebElement btnMedicalChecked;
    @FindBy(xpath = "//*[@id='enrollments-container']/div[1]/div[3]/div[2]/div[2]/label")
    WebElement btnDentalChecked;
    @FindBy(css = ".tollbar-app-links")
    WebElement appLinks;
    @FindBy(css = ".toolbar-links")
    WebElement blueBarlinks;
    @FindBy(id = "Manage Plans-Reset Changes Medical")
    WebElement btnMedReset;
    @FindBy(id = "Manage Plans-Reset Changes Dental")
    WebElement btnDentalReset;
    @FindBy(xpath = "//button[@id='Manage Plans-Make Changes Medical']")
    WebElement btnMakeChangeMed;
    @FindBy(xpath = "//button[@id='Manage Plans-Make Change Dental']")
    WebElement btnMakeChangeDental;
    @FindBy(id = "Manage Plans-Save Button Medical")
    WebElement btnMedSave;
    @FindBy(id = "Manage Plans-Save Button Dental")
    WebElement btnDentalSave;
    @FindBy(xpath = "//div[text()='Previous Financial Periods - Medical']")
    WebElement previousFinancialMed;
    @FindBy(xpath = "//div[text()='Previous Financial Periods - Dental']")
    WebElement previousFinancialDental;
    @FindBy(xpath = "//*[@id='enrollments-container']/div[2]/div[1]/div[2]/app-previous-plan/div/div[2]")
    WebElement previousFinancialNoMed;
    @FindBy(xpath = "//*[@id='enrollments-container']/div[2]/div[2]/div[2]/app-previous-plan/div/div[2]")
    WebElement previousFinancialNoDental;
    @FindBy(css = "#enrollments-container > div.plan-header > div.select-year > div:nth-child(2) > app-plan-year-dropdown > div > app-drop-down-select > div > div.drop-down-option.drop-down-option-selected")
    WebElement planYearDownArrow;
    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//span")
    List<WebElement> planYearList;
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[1]/div[1]/div[2]/app-plan-year-dropdown/div/app-drop-down-select/div/div[2]/div[1]")
    WebElement secondYearInList;
    @FindBy(xpath = "//div[@id='coverageStartDate_1']//input[1]")
    WebElement coverageStartdate;
    @FindBy(xpath = "//div[@id='coverageEndDate_1']//input[1]")
    WebElement coverageEndDate;
    @FindBy(xpath = "//div[@id='financialStartDate_1']//input[@type='date']")
    WebElement financialStartDate;

    @FindBy(xpath = "//div[@id='financialEndDate_1']//input[1]")
    WebElement financialEndDate;

    @FindBy(css="#premium_1 > input")
    WebElement premiumAmount;

    @FindBy(css="#planAPTC_1 > input")
    WebElement aptcAmount;

    @FindBy(id= "financialEndDate_1")
    WebElement financialEndDateText;
  
    @FindBy(xpath = "//div[@id='financialEndDate_2']//input[1]")
    WebElement financialEndDateSecondMember;

    @FindBy(xpath = "//app-drop-down-select[@id='change-reason']//div[@class='drop-down-option drop-down-option-selected']")
    WebElement reasonForTheChange;
    @FindBy(xpath = "//span[normalize-space()='Recon']")
    WebElement optionRecon;
    @FindBy(xpath = "//input[@class='input-change-details ng-untouched ng-pristine ng-valid']")
    WebElement additionalReasonText;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    WebElement confirmChangesButton;
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[1]/div[1]/div[2]/app-plan-year-dropdown/div/app-drop-down-select/div/div[1]")
    WebElement yearsDpdArrow;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-plan-information[1]/div[1]/div[1]/div")
    List<WebElement> currentMedicalData;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-plan-information[1]/div[1]/div[1]/div")
    List<WebElement> currentDentalData;
    @FindBy(xpath = "//app-drop-down-select[@id='selectPolicy' and contains(@class,'dropdown-container')]")
    WebElement selectPolicyDropdown;
    @FindBy(xpath = "//*[@id='enrollments-container']/div[2]/div[1]/div[1]/app-current-plan/div/div[1]/div/p[2]")
    WebElement selectPolicyDropdownOptions;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='drop-down-option drop-down-option-selected']")
    WebElement selectDentalPolicyDropdownOptions;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span")
    List<WebElement> medicalpolicyDropdownOptions;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span")
    List<WebElement> dentalpolicyDropdownOptions;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[@class='two-column-twentyfive-row-container header-3']")
    WebElement currentDentalPlanName;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[contains(text(), 'Policy Coverage:')]")
    WebElement pnlMedPolicyCoverage;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Latest Application Date:']//following::div[1]")
    WebElement medLatestAppDateUI;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Latest Application Date:']//following::div[1]")
    WebElement denLatestAppDateUI;

    @FindBy(xpath = "//p[@class= 'plan-header header-2']")
    List<WebElement> currentMedicalDentalPlan;
    @FindBy(xpath = "//div[@class='label-container body-text-2']")
    List<WebElement> containerTextValidation;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='status_1']")
    WebElement medPolicyStatus;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='status_1']")
    WebElement denPolicyStatus;
    @FindBy(xpath = "//label[@class='form-radio-label body-text-1']")
    WebElement dentalPlanType;
    @FindBy(xpath = "/html/body/app-root/div/app-header/header/div[2]/div/div[2]/span[1]/a")
    WebElement searchInHeader;

    @FindBy(xpath = "(//input[@type='text'])[6]")
    WebElement aptcmember1;

    @FindBy(xpath = "//div[1]/div[6]/div[15]/input[1]")
    WebElement aptcmember2;

    @FindBy(xpath = "//*[@id=\"form-edit-pan-member-info\"]/div/div[7]/div/div[2]")
    WebElement EHBPremiumamtmedical;

    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[8]")
    WebElement EHBPremiumamtDental;

    //Select medical and dental checks
    @FindBy(xpath = "//input[@id='Manage Plans-Select Plan Type Dental']")
    WebElement selectDental;

    @FindBy(xpath = "//input[@id='Manage Plans-Select Plan Type Medical']")
    WebElement selectMedical;
    //Validation errors
    @FindBy(xpath = "//div[@Class='body-text-1 validation-error']")
    WebElement ValidationError;

    @FindBy(xpath = "//div[contains(text(),'Invalid monetary amount for Premium')]")
    WebElement PremiumInvalidError;

    @FindBy(xpath = "//div[contains(text(),'APTC entered exceeds EHB amount: ')]")
    WebElement APTCEHBError;

    @FindBy(xpath = "//div[contains(text(),'Invalid monetary amount for APTC')]")
    WebElement APTCInvalidError;

    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Financial Start Date:']//following::div[1]")
    WebElement pnlMedFinancialStartDate;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Financial Start Date:']//following::div[1]")
    WebElement pnlDenFinancialStartDate;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Financial End Date:']//following::div[1]")
    WebElement pnlMedFinancialEndDate;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Financial End Date:']//following::div[1]")
    WebElement pnlDenFinancialEndDate;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='CSR Amount:']//following::div[1]")
    WebElement medCsrAmount;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='CSR Amount:']//following::div[1]")
    WebElement denCsrAmount;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Plan Premium:']//following::div[1]")
    WebElement MedplnPremiumAmt;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Plan Premium:']//following::div[1]")
    WebElement denplnPremiumAmt;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Plan APTC:']//following::div[1]")
    WebElement medPlanAPTCAMount;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Plan APTC:']//following::div[1]")
    WebElement denPlanAPTCAMount;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Rating Area:']//following::div[1]")
    WebElement medRatingArea;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Rating Area:']//following::div[1]")
    WebElement denRatingArea;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Premium after Subsidy:']//following::div[1]")
    WebElement medpremiumAfterSubsidy;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Premium after Subsidy:']//following::div[1]")
    WebElement denPremiumAfterSubsidy;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Service Area:']//following::div[1]")
    WebElement medServiceArea;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Service Area:']//following::div[1]")
    WebElement denServiceArea;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Plan AV:']//following::div[1]")
    WebElement medPlanAv;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Plan AV:']//following::div[1]")
    WebElement denPlanAv;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Policy ID:']//following::div[1]")
    WebElement medpolicyId;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Policy ID:']//following::div[1]")
    WebElement denpolicyId;


    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='HIOS ID:']//following::div[1]")
    WebElement medHiosId;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='HIOS ID:']//following::div[1]")
    WebElement denHiosId;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='EHB Premium:']//following::div[1]")
    WebElement medEHBPremium;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='EHB Premium:']//following::div[1]")
    WebElement denEHBPremium;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Latest LCE and Date:']//following::div[1]")
    WebElement medLCEEventDateType;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Latest LCE and Date:']//following::div[1]")
    WebElement denLCEEventDateType;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//div[@class='member-details-grid']/div")
    List<WebElement> medicalMemberDetailsTableHeader;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//div[@class='member-details-grid']/div")
    List<WebElement> dentalMemberDetailsTableHeader;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//div[@class='body-text-1 member-details-grid-item bold-text']")
    List<WebElement> coverageDetailsTableTableHeader;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//div[@class='body-text-1 member-details-grid-item bold-text']")
    List<WebElement> dencoverageDetailsTableTableHeader;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//div[@class='financial-details-grid']/div")
    List<WebElement> coverageFinancialTableTableHeader;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//div[@class='financial-details-grid']/div")
    List<WebElement> dencoverageFinancialTableTableHeader;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='referenceId_1']")
    WebElement PersonID;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='referenceId_1']")
    WebElement denPersonID;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='firstName_1']")
    WebElement Name;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='firstName_1']")
    WebElement denName;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='dateOfBirth_1']")
    WebElement DateOfBirth;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='dateOfBirth_1']")
    WebElement denDateOfBirth;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='relationshipToSubscriber_1']")
    WebElement relationshipToSubscriber_1;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='relationshipToSubscriber_1']")
    WebElement denrelationshipToSubscriber_1;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='tobacco_1']")
    WebElement tobacco;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='tobacco_1']")
    WebElement dentobacco;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='coverageStartDate_1']")
    WebElement coverageStartDateCoTable;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='coverageStartDate_1']")
    WebElement dencoverageStartDateCoTable;
    @FindBy(xpath ="//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='coverageEndDate_1']")
    WebElement coverageEndDateCoTable;
    @FindBy(xpath ="//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='coverageEndDate_1']")
    WebElement dencoverageEndDateCoTable;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='effectuated_1']")
    WebElement medEffectuated;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='effectuated_1']")
    WebElement denEffectuated;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='terminationReason_1']")
    WebElement medTerminationReason;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='terminationReason_1']")
    WebElement denTerminationReason;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='financialStartDate_1']")
    WebElement medFinancialStartDateFNTable;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='financialStartDate_1']")
    WebElement denFinancialStartDateFNTable;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='financialEndDate_1']")
    WebElement medFinancialEndDateFNTable;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='financialEndDate_1']")
    WebElement denFinancialEndDateFNTable;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='premium_1']")
    WebElement medPlanPremiumAmtFnTable;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='premium_1']")
    WebElement denPlanPremiumAmtFnTable;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='planAPTC_1']")
    WebElement medAPTCAmtFnTable;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@class='plan-member-info']//div[@id='planAPTC_1']")
    WebElement denAPTCAmtFnTable;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-plan-information[1]/div[1]/div[1]/div[1]")
    WebElement currentMedicalPlanName;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-plan-information[1]/div[1]/div[1]/div[1]")
    WebElement dencurrentMedicalPlanName;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[contains(text(), 'Policy Coverage:')]")
    WebElement pnlDenPolicyCoverage;
    WebElement goBack;
    @FindBy(xpath = "//p[normalize-space()='Dental Plan:']")
    WebElement simplifyDental;
    @FindBy(xpath = "//p[normalize-space()='Medical Plan:']")
    WebElement simplifyMedical;
    @FindBy(xpath = "//div[@class='two-column-twentyfive-row-container header-3']")
    WebElement medicalPlanName;
    @FindBy(xpath = "//div[normalize-space()='Latest Application Date:']")                 //*[@id="enrollment-info"]/div/div[3]")
    WebElement medLatestApplicationUI;
    @FindBy(xpath = "//div[normalize-space()='CSR Amount:']")
    WebElement medCsrAmountUI;
    @FindBy(xpath = "//div[normalize-space()='EHB Premium:']")
    WebElement medEhbPremiumUI;
    @FindBy(xpath = "//div[normalize-space()='Latest LCE and Date:']")
    WebElement medLatestLCEtUI;
    @FindBy(xpath = "//div[normalize-space()='Rating Area:']")
    WebElement medRateAreaUI;
    @FindBy(xpath = "//div[normalize-space()='Service Area:']")
    WebElement medServiceAreaUI;
    @FindBy(xpath = "//div[@class='label-container-copy-icon body-text-2']")
    WebElement medPolicyIdUI;
    @FindBy(xpath = "//div[normalize-space()='Financial Start Date:']")
    WebElement medFinancialStartDateUI;
    @FindBy(xpath = "//div[normalize-space()='Financial End Date:']")
    WebElement medFinancialEndDateUI;
    @FindBy(xpath = "//div[normalize-space()='Plan Premium:']")
    WebElement medPlanPremiumUI;
    @FindBy(xpath = "//div[@id='aptcLabel']")
    WebElement medPlanAPTCUI;
    @FindBy(xpath = "//div[normalize-space()='Premium after Subsidy:']")
    WebElement medPremiumAfterSubsidyUI;
    @FindBy(xpath = "//div[normalize-space()='Plan AV:']")
    WebElement medPlanAVUI;
    @FindBy(xpath = "//div[normalize-space()='HIOS ID:']")
    WebElement medHiosIdUI;
    @FindBy(xpath = "//div[@class='two-column-twentyfive-row-container header-3']")
    WebElement medPlanNameData;
    @FindBy(xpath = "//div[@class='two-column-twentyfive-row-container body-text-2']")
    WebElement medCoverageData;
    @FindBy(xpath = "//div[@class='plan-summary']//div[4]")
    WebElement medLatestApplicationDateData;
    @FindBy(xpath = "//*[@id='no_1']")
    WebElement rowNumberData;
    @FindBy(xpath = "//*[@id='referenceId_1']")
    WebElement personIdData;
    @FindBy(xpath = "//*[@id='firstName_1']")
    WebElement nameData;
    @FindBy(xpath = "//*[@id='dateOfBirth_1']")
    WebElement dOfBData;
    @FindBy(xpath = "//*[@id='relationshipToSubscriber_1']")
    WebElement relationData;
    @FindBy(xpath = "//*[@id='tobacco_1']")
    WebElement tobaccoData;
    @FindBy(xpath = "//*[@id='no_2']")
    WebElement rowNumberDataTwo;
    @FindBy(xpath = "//*[@id='referenceId_2']")
    WebElement personIdDataTwo;
    @FindBy(xpath = "//*[@id='firstName_2']")
    WebElement nameDataTwo;
    @FindBy(xpath = "//*[@id='dateOfBirth_2']")
    WebElement dOfBDataTwo;
    @FindBy(xpath = "//*[@id='relationshipToSubscriber_2']")
    WebElement relationDataTwo;
    @FindBy(xpath = "//*[@id='tobacco_2']")
    WebElement tobaccoDataTwo;
    @FindBy(xpath = "//*[@id='no_2']")
    WebElement rowTwoData;
    @FindBy(xpath = "//*[@id='no_1']")
    WebElement coverageStartRowTwo;
    @FindBy(xpath = "//*[@id='no_1']")
    WebElement coverageEndRowTwo;
    @FindBy(xpath = "//*[@id='no_1']")
    WebElement statusRowTwo;
    @FindBy(xpath = "//*[@id='no_1']")
    WebElement effectuatedRowTwo;
    @FindBy(xpath = "//*[@id='no_1']")
    WebElement reasonRowTwo;
    @FindBy(xpath = "//div[@class='financial-details-grid']//div[12]")
    WebElement financialStartDateRowTwo;

    @FindBy(xpath = "//div[@class='financial-details-grid']//div[13]")
    WebElement financialEndDateRowTwo;

    @FindBy(xpath = "//div[@class='financial-details-grid']//div[14]")
    WebElement premiumRowTwo;
    @FindBy(xpath = "//*[@id='planAPTC_2']")
    WebElement aptcRowTwo;
    @FindBy(xpath = "//div/app-plan-container/div[3]/button")
    WebElement btnGoBack;
    @FindBy(xpath = "(//input[@type='text'])[6]")
    WebElement sesmember1;
    @FindBy(xpath = "//div[1]/div[6]/div[15]/input[1]")
    WebElement sesmember2;
    @FindBy(xpath = "//*[@id='form-edit-pan-member-info']/div/div[7]/div/div[1]")
    WebElement SESInvalidError;
    @FindBy(xpath = "//*[@id='form-edit-pan-member-info']/div/div[7]/div/div[2]")
    WebElement SESEHBError;

    public void validateBluBar() {
        basicActions.waitForElementToBePresent(blueBarlinks, 20);
        softAssert.assertEquals(titleInBlueBar.getText(), "Admin Portal");
        softAssert.assertEquals(lnkSearch.getText(), "Search");
        softAssert.assertEquals(appLinks.getText(), "Application Links");
        softAssert.assertAll();
    }

    public void containerTitleLabels() {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 20);
        softAssert.assertEquals(txtTitleManagePlans.getText(), "Manage Plans");
        softAssert.assertEquals(txtSelectPlanYear.getText(), "Select a plan year:");
        softAssert.assertEquals(planYearLabel.getText(), "Year:");
        softAssert.assertEquals(txtSelectPlanType.getText(), "Select plan type:");
        softAssert.assertEquals(chkMedical.getText(), "Medical");
        softAssert.assertEquals(chkDental.getText(), "Dental");
        softAssert.assertAll();
    }

    public void checkDefaultCurrentYear() {
        basicActions.waitForElementToBePresent(dpdCurrentYearMP, 20);
        String currentYear = String.valueOf(Year.now().getValue());

        softAssert.assertEquals(dpdCurrentYearMP.getText(), currentYear);
        softAssert.assertAll();
    }

    public void verifyButtonsCheckedBoth() {
        basicActions.waitForElementToBePresent(btnMedicalChecked, 20);
        softAssert.assertTrue(btnMedicalChecked.isDisplayed());
        softAssert.assertTrue(btnDentalChecked.isDisplayed());
        softAssert.assertAll();
    }

    public void resetMakeChangeButtonsDisplayed() {
        basicActions.waitForElementToBePresentWithRetries(btnMakeChangeMed, 60);
        softAssert.assertEquals(btnMakeChangeMed.getText(), "Make Changes Medical");
        softAssert.assertEquals(btnMakeChangeDental.getText(), "Make Changes Dental");
        softAssert.assertAll();
    }

    public void verifySaveButtonDisplayed(String saveMed) {
        basicActions.waitForElementToBePresent(btnMedSave, 10);
        softAssert.assertEquals(btnMedSave.getText(), saveMed);
        softAssert.assertAll();
    }

    public void clickMakeChangesMedical() {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 30);
        basicActions.waitForElementToBePresent(btnMakeChangeMed, 10);
        basicActions.waitForElementToBeClickable(btnMakeChangeMed, 10);
        btnMakeChangeMed.click();
    }

    public void clickResetChangesMedical() {
        basicActions.waitForElementToBePresent(btnMedReset, 10);
        btnMedReset.click();
    }

    public void clickMakeChangesDental() {
        basicActions.waitForElementToBePresent(btnMakeChangeDental, 10);
        basicActions.waitForElementToBeClickable(btnMakeChangeDental, 10);
        btnMakeChangeDental.click();
    }

    public void verifySaveDentalButtonDisplayed(String saveDental) {
        basicActions.waitForElementToBePresent(btnDentalSave, 10);
        softAssert.assertEquals(btnDentalSave.getText(), saveDental);
        softAssert.assertAll();
    }

    public void clickResetChangesDental() {
        basicActions.waitForElementToBePresent(btnDentalReset, 10);

        btnDentalReset.click();
    }

    public void validateChangeButtonsNotDisplay(){
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 10);
        Assert.assertFalse(basicActions.isElementDisplayed(btnMedSave, 3));
        softAssert.assertAll();
    }

    public void containerTitleLabelsCoco() {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 20);
        softAssert.assertEquals(txtTitleManagePlans.getText(), "Manage Plans");
        softAssert.assertEquals(txtSelectPlanYear.getText(), "Select a plan year:");
        softAssert.assertEquals(planYearLabel.getText(), "Year:");
        softAssert.assertEquals(txtSelectPlanType.getText(), "Select plan type:");
        softAssert.assertEquals(chkMedical.getText(), "Medical");
        softAssert.assertAll();
    }

    public void verifyMedicalButtonChecked() {
        basicActions.waitForElementToBePresent(btnMedicalChecked, 20);
        softAssert.assertTrue(btnMedicalChecked.isDisplayed());
        softAssert.assertAll();
    }

    public void resetMakeChangeButtonsCocoDisplayed() {
        basicActions.waitForElementToBePresent(btnMedReset, 20);
        softAssert.assertEquals(btnMakeChangeMed.getText(), "Make Changes Medical");
        softAssert.assertAll();
    }

    public void checkPreviousFinancialMedical() {
        basicActions.waitForElementToBePresent(previousFinancialMed, 20);
        softAssert.assertEquals(previousFinancialMed.getText(), "Previous Financial Periods - Medical");
        softAssert.assertEquals(previousFinancialNoMed.getText(), "No Past Financial Periods - Medical");
        softAssert.assertAll();
    }

    public void checkPreviousFinancialDental() {
        basicActions.waitForElementToBePresent(previousFinancialDental, 20);
        softAssert.assertAll();     }
  
    public void checkPreviousFinancialMedicalMessage(){
        basicActions.waitForElementToBePresent(previousFinancialMed,20);
        softAssert.assertEquals(previousFinancialMed.getText(), "Previous Financial Periods - Medical");
        softAssert.assertEquals(previousFinancialNoMed.getText(), "No Past Financial Periods - Medical");
        softAssert.assertAll();     }
  
    public void checkPreviousFinancialDentalMessage(){
        basicActions.waitForElementToBePresent(previousFinancialDental,20);
        softAssert.assertEquals(previousFinancialDental.getText(), "Previous Financial Periods - Dental");
        softAssert.assertEquals(previousFinancialNoDental.getText(), "No Past Financial Periods - Dental");
        softAssert.assertAll();
    }

    public void validateYearsDropdown(String lowerYear) {
        softAssert.assertTrue(planYearDownArrow.isDisplayed());
        basicActions.click(dpdCurrentYearMP);
        basicActions.waitForElementListToBePresent(planYearList, 20);
        List<String> expectedList = new ArrayList<>(Arrays.asList("2021", "2022", "2023", "2024", "2025"));
        List<String> existingList = new ArrayList<>();
        for (WebElement each : planYearList) {
            existingList.add(each.getText().trim());
        }
        softAssert.assertEquals(planYearList.get(0).getText(), lowerYear);
        softAssert.assertEquals(expectedList, existingList);
        softAssert.assertAll();
        basicActions.click(dpdCurrentYearMP);
    }

    public void clickSaveButton() {
        basicActions.scrollToElement(btnMedSave);
        basicActions.waitForElementToBePresent(btnMedReset, 20);
        basicActions.waitForElementToBePresent(btnMedSave, 20);
        btnMedSave.click();
    }

    public void clickSaveButtonDental() {
        basicActions.waitForElementToBePresent(btnDentalSave, 20);
        basicActions.waitForElementToBePresent(btnDentalSave, 20);
        btnDentalSave.click();
    }

    public void memberCoverageStrtDate(List<String> memberCoverageStrtDtList) {
        for (String memberCoverageStrtDate : memberCoverageStrtDtList) {
            String[] parts = memberCoverageStrtDate.split(":");
            String memberNo = parts[0];
            String coverageStartDateValue = parts[1];
            String coverageStartDatemem = "//div[@id='coverageStartDate_" + memberNo + "']//input[1]";
            basicActions.updateElementWithRetries(coverageStartDatemem, coverageStartDateValue);
        }
    }
    public void memberFinancialStrtDate(List<String> memberFinancialStrtDtList) {
        for (String memberFinancialStrtDate : memberFinancialStrtDtList) {
            String[] parts = memberFinancialStrtDate.split(":");
            String memberNo = parts[0];
            String financialStartDateValue = parts[1];

            basicActions.scrollToElement(financialStartDate);
            basicActions.waitForElementToBePresent(financialStartDate, 30);
            basicActions.waitForElementToBeClickable(financialStartDate, 30);

            WebElement financialStartDateMem = basicActions.getDriver().findElement(By.xpath("//div[@id='financialStartDate_" + memberNo + "']//input[1]"));
            financialStartDateMem.click();
            financialStartDateMem.clear();
            financialStartDateMem.sendKeys(financialStartDateValue);

        }
    }

    public void selectReasonForTheChange() {
        basicActions.waitForElementToBePresent(additionalReasonText, 20);
        basicActions.waitForElementToBeClickable(reasonForTheChange, 10);
        reasonForTheChange.click();
        basicActions.waitForElementToBeClickable(optionRecon, 10);
        optionRecon.click();
        basicActions.waitForElementToBePresent(additionalReasonText, 10);
        additionalReasonText.sendKeys("Testing");
        basicActions.waitForElementToBePresent(confirmChangesButton, 20);
        confirmChangesButton.click();
        softAssert.assertTrue(basicActions.waitForElementToBePresent(chkMedical, 20));
        softAssert.assertAll();
    }

    public void verifyLabelsDataMedical() {
        basicActions.waitForElementListToBePresent(currentMedicalData, 5000);
        String[] expectedHeaders = {"Anthem Silver Pathway HMO 6500 Rx Copay $0 Select Drugs", "Policy Coverage: 01/01/2024 to 12/31/2024", "Latest Application Date:", "11/28/2023", "Financial Start Date:", "01/01/2024", "EHB Premium:", "$1,598.46", "Financial End Date:", "12/31/2024", "CSR Amount:", "$0.00", "Plan Premium:", "$1,598.46", "Latest LCE and Date:", "", "Plan APTC:", "$511.57", "Rating Area:", "3", "Premium after Subsidy:", "$1,086.89", "Service Area:", "COS001", "Plan AV:", "70.54%", "Policy ID:", "3935009010", "HIOS ID:", "76680CO0220067-01"};
        for (int i = 0; i < currentMedicalData.size(); i++) {
            String actualHeader = currentMedicalData.get(i).getText();
            if (!actualHeader.equals(expectedHeaders[i])) {
                System.out.println("Label mismatch: Expected " + expectedHeaders[i] + ", but got " + actualHeader);
            }
        }
    }

    public void verifyLabelsDataDental() {
        basicActions.waitForElementListToBePresent(currentDentalData, 5000);
        String[] expectedHeaders = {"Anthem Dental Family", "Policy Coverage: 01/01/2024 to 12/31/2024", "Latest Application Date:", "11/28/2023", "Financial Start Date:", "01/01/2024", "EHB Premium:", "$41.86", "Financial End Date:", "12/31/2024", "CSR Amount:", "$0.00", "Plan Premium:", "$41.86", "Latest LCE and Date:", "", "Plan APTC:", "$0.00", "Rating Area:", "3", "Premium after Subsidy:", "$41.86", "Service Area:", "COS003", "Plan AV:", "0.00%", "Policy ID:", "2399001105", "HIOS ID:", "87269CO1120003-01"};
        for (int i = 0; i < currentDentalData.size(); i++) {
            String actualHeader = currentDentalData.get(i).getText();
            if (!actualHeader.equals(expectedHeaders[i])) {
                System.out.println("Label mismatch: Expected " + expectedHeaders[i] + ", but got " + actualHeader);
            }
        }
    }

    public void collapsYearDropdown() {
        basicActions.waitForElementToBePresent(yearsDpdArrow, 10);
        yearsDpdArrow.click();
        basicActions.switchtoactiveTab();
    }

    public void selectMemberNameFromPolicyDropdown(String Membername) {
        basicActions.wait(4000);    // WIP - Need to remove the wait.
        basicActions.waitForElementToBePresent(chkMedical, 20);
        basicActions.waitForElementToBePresentWithRetries(selectPolicyDropdown, 30);
        basicActions.scrollToElement(selectPolicyDropdown);
        basicActions.click(selectPolicyDropdown);
        WebElement dropdown = selectPolicyDropdownOptions.findElement(By.xpath(".//span[contains(text(),'" + Membername + "')]/parent::div"));
        basicActions.waitForElementToBePresentWithRetries(dropdown, 20);
        basicActions.click(dropdown);
        basicActions.waitForElementToBePresent(coverageStartdate, 20);
    }

    public void updateTheCoverageEndDate(List<String> memberCoverageEndDTList) {
        basicActions.waitForElementToBePresent(coverageStartdate,60);
        for (String memberCoverageEndDate : memberCoverageEndDTList) {
            String[] parts = memberCoverageEndDate.split(":");
            String memberNo = parts[0];
            String endDate = parts[1];
            String coverageEndDateValue = "";
            switch (endDate) {
                case "end of month":
                    coverageEndDateValue = basicActions.endOfMonthDate();
                    break;
                case "Cancel":
                    coverageEndDateValue = basicActions.changeDateFormat(coverageStartdate.getAttribute("value"), "yyyy-MM-dd", "MMddyyyy");
                    break;
                default:
                    coverageEndDateValue = parts[1];
            }
            basicActions.waitForElementToBePresent(coverageEndDate, 30);
            basicActions.scrollToElement(coverageEndDate);

            WebElement coverageEndDateMem = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageEndDate_" + memberNo + "']//input[1]"));
            coverageEndDateMem.sendKeys(coverageEndDateValue);
        }
    }

    public void updateTheFinancialEndDate(List<String> memberFinancialEndDTList) {
        for (String memberFinancialEndDate : memberFinancialEndDTList) {
            String[] parts = memberFinancialEndDate.split(":");
            String memberNo = parts[0];
            String endDate = parts[1];
            String financialEndDateValue = "";
            switch (endDate) {
                case "end of month":
                    financialEndDateValue = basicActions.endOfMonthDate();
                    break;
                case "Cancel":
                    financialEndDateValue = basicActions.changeDateFormat(financialStartDate.getAttribute("value"), "yyyy-MM-dd", "MMddyyyy");
                    break;
                default:
                    financialEndDateValue = parts[1];
            }
            basicActions.waitForElementToBePresent(financialEndDate, 30);
            basicActions.scrollToElement(financialEndDate);

            WebElement financialEndDateMem = basicActions.getDriver().findElement(By.xpath("//div[@id='financialEndDate_" + memberNo + "']//input[1]"));
            financialEndDateMem.sendKeys(financialEndDateValue);
        }
    }

public void selectThePlanYearOnManagePlan(String planYear) {
    basicActions.waitForElementToBePresent(dpdCurrentYearMP, 50);
    dpdCurrentYearMP.click();

    String xpath = String.format("//app-drop-down-select[1]//div[2]//*[contains(text(),'"+planYear+"')]");
    WebElement planYearBtn = basicActions.getDriver().findElement(By.xpath(xpath));
    planYearBtn.click();
    basicActions.switchtoactiveTab();
}

    MemberDetails memberDetails = new MemberDetails();

    public void UpdateMyAccount_idAnyEnv(String stgAccountId, String qaAccountId) {
        String primaryMemberId;
        if (SharedData.getEnv().contains("qa")) {
            primaryMemberId = qaAccountId;
        } else {
            primaryMemberId = stgAccountId;
        }
        BigDecimal bigDecimal = new BigDecimal(primaryMemberId);
        basicActions.waitForElementToBePresentWithRetries(currentDentalPlanName,20);

        memberDetails.setAccount_id(bigDecimal);
        SharedData.setPrimaryMember(memberDetails);
        String currentDentalPlan = currentDentalPlanName.getText();
        managePlanDentalMedicalPlan.setPlanMarketingName(currentDentalPlan);

        String MedPolicyCoverage = pnlMedPolicyCoverage.getText();
        managePlanDentalMedicalPlan.setPolicyCoverageDate(MedPolicyCoverage);

        String pnlMedLatestAppDate = medLatestAppDateUI.getText();
        pnlMedLatestAppDate = basicActions.changeDateFormat(pnlMedLatestAppDate, "MM/dd/yyyy", "MM/dd/yyyy");
        managePlanDentalMedicalPlan.setMedLatestAppDate(pnlMedLatestAppDate);
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);


    }

    public void validateTheTextOfTheMedicalContainer() {
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getText(), "Current Medical Plan:");
        List<String> existingList = Arrays.asList("Current Medical Plan:", "Latest Application Date:", "Financial Start Date:", "EHB Premium:", "Financial End Date:", "CSR Amount:", "Plan Premium:", "Latest LCE and Date:", "Plan APTC:", "Rating Area:", "Premium after Subsidy:", "Service Area:", "Plan AV:", "Policy ID:", "HIOS ID:");
        List<String> resultList = new ArrayList<>(existingList.subList(0, Math.min(existingList.size(), 15)));
        softAssert.assertEquals(existingList, resultList);
        softAssert.assertAll();
    }


    public void selectTheMedPolicyPlan(int policyNumber, String planType) {
        basicActions.waitForElementToBePresent(selectPolicyDropdownOptions, 20);

        switch (planType) {
            case "Medical":
                selectPolicyDropdownOptions.click();
                medicalpolicyDropdownOptions.get(policyNumber - 1).click();
                break;
            case "Dental":
                selectDentalPolicyDropdownOptions.click();
                dentalpolicyDropdownOptions.get(policyNumber - 1).click();
                break;

        }
    }

    public void selectPlansMedActivePolicy() {
        basicActions.waitForElementToBePresent(selectPolicyDropdownOptions, 50);
        selectPolicyDropdownOptions.click();
        for (WebElement each : medicalpolicyDropdownOptions) {
            each.click();
            if (medPolicyStatus.getText().equals("Submitted")) {
                break;
            }
            selectPolicyDropdownOptions.click();
        }
    }


    public void selectPlansDenActivePolicy() {
        basicActions.waitForElementToBePresent(selectDentalPolicyDropdownOptions, 50);
        selectDentalPolicyDropdownOptions.click();
        for (WebElement each : dentalpolicyDropdownOptions) {
            each.click();
            if (denPolicyStatus.getText().equals("Submitted")) {
                break;
            }
            selectDentalPolicyDropdownOptions.click();
        }
    }

    public void updateTheSecondMedicalPoliciyForTheYearUI() {
        selectPolicyDropdownOptions.click();//medical
        String medicalSecondPolicy = medicalpolicyDropdownOptions.get(1).getText();
        managePlanDentalMedicalPlan.setSelectMedSecondPolicyDrp(medicalSecondPolicy);
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);

        selectDentalPolicyDropdownOptions.click();//dental
        String dentalSecondPolicy = dentalpolicyDropdownOptions.get(1).getText();
        managePlanDentalMedicalPlan.setSelectDenSecondPolicyDrp(dentalSecondPolicy);
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }

    public void uncheckedFromPlanType(String planType) {
        basicActions.waitForElementToBePresent(btnDentalChecked, 20);
        basicActions.scrollToElement(btnDentalChecked);
        switch (planType) {
            case "Dental":
                btnDentalChecked.click();
                softAssert.assertEquals(currentMedicalDentalPlan.size(), 1);
                break;
            case "Medical":
                btnMedicalChecked.click();
                softAssert.assertEquals(currentMedicalDentalPlan.size(), 1);
                break;
        }
    }

    public void validateCoverageStartDateErrors() {
        basicActions.waitForElementToBePresent(ValidationError, 100);
        softAssert.assertEquals(ValidationError.getText(), "The coverage start date must be entered within the selected plan year and can not be after the coverage end date.");
        softAssert.assertAll();
    }

    public void validateFinancialStartDateErrors(){
        basicActions.waitForElementToBePresent(ValidationError, 100);
        softAssert.assertEquals(ValidationError.getText(), "The financial start date must be entered within the selected plan year and can not be after the financial end date.");
        softAssert.assertAll();
    }

    public void validateCoverageEndDateErrors() {
        basicActions.waitForElementToBePresent(ValidationError, 100);
        softAssert.assertEquals(ValidationError.getText(), "The coverage end date must be entered within the selected plan year and can not be prior to the coverage start date.");
        softAssert.assertAll();
    }
    public void validateFinancialEndDateErrors(){
    basicActions.waitForElementToBePresent(ValidationError, 100);
        softAssert.assertEquals(ValidationError.getText(), "The financial end date must be entered within the selected plan year and can not be prior to the financial start date.");
        softAssert.assertAll();
    }

    public void addAPTCvalue(List<String> memberaptctDtList) {
        for (String memberAPTCamt : memberaptctDtList) {
            String[] parts = memberAPTCamt.split(":");
            String memberNo = parts[0];
            String aptcvalue = parts[1];
            WebElement APTCMem = basicActions.getDriver().findElement(By.xpath("//div[@id='planAPTC_" + memberNo + "']//input[@type='text']"));
            APTCMem.click();
            APTCMem.clear();
            APTCMem.sendKeys(aptcvalue);
            if(SharedData.getPrimaryMember()!= null){
            SharedData.getPrimaryMember().setMedicalAptcAmt(aptcvalue);
            String totalMedPremiumAfterReduction =  String.format("%.2f",Float.parseFloat(SharedData.getPrimaryMember().getMedicalPremiumAmt()) - Float.parseFloat(SharedData.getPrimaryMember().getMedicalAptcAmt()));
            SharedData.getPrimaryMember().setTotalMedAmtAfterReduction(totalMedPremiumAfterReduction);}
        }
    }

    public void addpremiumvalue(List<String> memberpremiumList) {
        for (String memberpremiumamt : memberpremiumList) {
            String[] parts = memberpremiumamt.split(":");
            String memberNo = parts[0];
            String newPremiumAmt = parts[1];
            WebElement premiumMem = basicActions.getDriver().findElement(By.xpath("//div[@id='premium_" + memberNo + "']//input[@type='text']"));
            premiumMem.click();
            premiumMem.clear();
            premiumMem.sendKeys(newPremiumAmt);
            if(SharedData.getPrimaryMember()!=null){
            SharedData.getPrimaryMember().setMedicalPremiumAmt(newPremiumAmt);}
        }
    }

    public void validateErrorMessages(DataTable table) {
        List<Map<String, String>> memberData = table.asMaps(String.class, String.class);

        for (Map<String, String> data : memberData) {
            String memberNo = data.get("member");
            String aptcValue = data.get("aptc");

            String expectedErrorMessage = "";

            if (aptcValue == null || aptcValue.trim().isEmpty()) {
                expectedErrorMessage = "Invalid monetary amount for APTC";
            } else {
                expectedErrorMessage = "Invalid monetary amount for APTC: $" + aptcValue;
            }

            boolean errorMessageElement;
            if (APTCInvalidError.getText().equals(expectedErrorMessage)) errorMessageElement = true;
            else
                throw new AssertionError("Error message: '" + expectedErrorMessage + "' not displayed for member " + memberNo);
        }
    }

    public void validateEHBErrors(String planType) {
        String value1Text = aptcmember2.getAttribute("value");
        String numericValue1 = value1Text.replaceAll("[^0-9.]", "");
        String value2Text = aptcmember1.getAttribute("value");
        String numericValue2 = value2Text.replaceAll("[^0-9.]", "");

        String value3Text;
        String numericValue3;

        if ("medical".equalsIgnoreCase(planType)) {
            value3Text = EHBPremiumamtmedical.getText();
        } else {
            value3Text = EHBPremiumamtDental.getText();
        }

        numericValue3 = value3Text.replaceAll("[^0-9.]", "");

        double value1 = Double.parseDouble(numericValue1);
        double value2 = Double.parseDouble(numericValue2);
        double value3 = Double.parseDouble(numericValue3);

        if (value1 + value2 > value3) {
            Assert.assertTrue(APTCEHBError.isDisplayed(), "Error message should be displayed when condition is met.");
        } else {
            System.out.println("Condition not met, no error expected.");
        }
    }
    public void clickSearchInAdminPortalBlueHeader() {
        basicActions.waitForElementToBePresent(searchInHeader, 10);
        searchInHeader.click();
        basicActions.switchtoactiveTab();
    }

    public void validatePremiumErrors(){
        basicActions.waitForElementToBePresent(PremiumInvalidError, 50);
        softAssert.assertTrue(PremiumInvalidError.isDisplayed());
    }


    public void clickDentalButton(){
        basicActions.waitForElementToBePresent(selectDental, 50);
        selectDental.click();
    }

    public void clickMedicalButton(){
        basicActions.waitForElementToBePresent(selectMedical, 50);
        selectMedical.click();
    }

    public void updateTheMedicalPlanForTheUI() {
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
        SharedData.getManagePlanDentalMedicalPlan().setPlanType("1");
        //set marketing Medical Plan
        basicActions.clickElementWithRetries(currentMedicalPlanName,50);
        String currentMedPlan = currentMedicalPlanName.getText();
        managePlanDentalMedicalPlan.setPlanMarketingName(currentMedPlan);
        //set Medical Policy Coverage
        String MedPolicyCoverage = pnlMedPolicyCoverage.getText();
        managePlanDentalMedicalPlan.setPolicyCoverageDate(MedPolicyCoverage);

        String pnlMedLatestAppDate = medLatestAppDateUI.getText();
        pnlMedLatestAppDate =basicActions.changeDateFormat(pnlMedLatestAppDate,"MM/dd/yyyy","yyyy-MM-dd");
        managePlanDentalMedicalPlan.setMedLatestAppDate(pnlMedLatestAppDate);

        String MedFinancialStrDate= pnlMedFinancialStartDate.getText();
        MedFinancialStrDate = basicActions.changeDateFormat(MedFinancialStrDate,"MM/dd/yyyy","yyyy-MM-dd");
        managePlanDentalMedicalPlan.setMedFinancialStartDate(MedFinancialStrDate);

        String MedFinancialEndDate= pnlMedFinancialEndDate.getText();
        MedFinancialEndDate = basicActions.changeDateFormat(MedFinancialEndDate,"MM/dd/yyyy","yyyy-MM-dd");
        managePlanDentalMedicalPlan.setMedFinancialEndDate(MedFinancialEndDate);

        String getTotalCsrAmt = medCsrAmount.getText();
        managePlanDentalMedicalPlan.setTotal_csr_amt(getTotalCsrAmt);

        String planPremiumAmt = MedplnPremiumAmt.getText();
        managePlanDentalMedicalPlan.setPlanPremiumAmt(planPremiumAmt);

        String planAPtcAMount = medPlanAPTCAMount.getText();
        managePlanDentalMedicalPlan.setPlanAptcAmt(planAPtcAMount);

        String ratingArea = medRatingArea.getText();
        managePlanDentalMedicalPlan.setRatingArea(ratingArea);

        String premiumAfterSubsidy = medpremiumAfterSubsidy.getText();
        managePlanDentalMedicalPlan.setPremiumAfterSubsidy(premiumAfterSubsidy);
        String serviceArea = medServiceArea.getText();
        managePlanDentalMedicalPlan.setMedServiceArea(serviceArea);
        String planAV = medPlanAv.getText();
        managePlanDentalMedicalPlan.setMedPlanAV(planAV);
        managePlanDentalMedicalPlan.setPolicyID(medpolicyId.getText());
        managePlanDentalMedicalPlan.setMedHIOSId(medHiosId.getText());
        managePlanDentalMedicalPlan.setMedEhbPremiumAmt(medEHBPremium.getText());
        managePlanDentalMedicalPlan.setMedLCEEventTypeAndDate(medLCEEventDateType.getText().toLowerCase());
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }

    public void validateTheMemberDetailsTableTitleColumns(String planType) {
        int i = 0 ;
        List<String> expectedMedMemberDetails= Arrays.asList("No." , "Person ID" ,"Name" ,"Date of Birth" ,"Relationship" ,"Tobacco");
        List<String> actualMedMemberDetails= new ArrayList<>();
        List<WebElement> selectedTableHeader = null;

        switch (planType) {
            case "Medical":
                selectedTableHeader = medicalMemberDetailsTableHeader;
                break;
            case "Dental":
                selectedTableHeader = dentalMemberDetailsTableHeader;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type: " + planType);}

        for (WebElement each : selectedTableHeader) {
            actualMedMemberDetails.add(each.getText());
            if(i==5){
                break;
            }
            i++;
        }
        softAssert.assertEquals(expectedMedMemberDetails, actualMedMemberDetails);
        softAssert.assertAll();
    }

    public void validateTheCoverageDetailsTableTitleColumns(String planType) {
        List<String> expectedMedMemberDetails= Arrays.asList("No.","Coverage Start","Coverage End" ,"Status","Effectuated" ,"Termination Reason");
        List<String> actualMedCoverageDetails= new ArrayList<>();
        List<WebElement> selectedTableHeader = null;

        switch (planType) {
            case "Medical":
                selectedTableHeader = coverageDetailsTableTableHeader;
                break;
            case "Dental":
                selectedTableHeader = dencoverageDetailsTableTableHeader;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type: " + planType);}

        for (WebElement each : selectedTableHeader) {
            actualMedCoverageDetails.add(each.getText());
        }
        softAssert.assertEquals(expectedMedMemberDetails, actualMedCoverageDetails);
        softAssert.assertAll();
    }

    public void updateTheMedicalCoverageDetailsTableForTheUI() {
        managePlanDentalMedicalPlan.setCoverageStartDate(coverageStartDateCoTable.getText());
        managePlanDentalMedicalPlan.setCoverageEndDate(coverageEndDateCoTable.getText());
        managePlanDentalMedicalPlan.setMedStatus(medPolicyStatus.getText().toLowerCase());
        managePlanDentalMedicalPlan.setMedEffectuated(medEffectuated.getText().toLowerCase());
        managePlanDentalMedicalPlan.setMedTerminationReason(medTerminationReason.getText().toLowerCase());

        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);

    }

    public void validateTheFinancialDetailsTableTitleColumns(String planType) {
        List<String> expectedMedMemberDetails= Arrays.asList("No.", "Financial Start","Financial End","Premium","APTC");
        List<String> actualMedCoverageDetails= new ArrayList<>();
        List<WebElement> selectedTableHeader = null;

        switch (planType) {
            case "Medical":
                selectedTableHeader = coverageFinancialTableTableHeader;
                break;
            case "Dental":
                selectedTableHeader = dencoverageFinancialTableTableHeader;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type: " + planType);}

        int i=0;
        for (WebElement each : selectedTableHeader) {
            actualMedCoverageDetails.add(each.getText());
            if(i==4){
                break;
            }
            i++;
        }
        softAssert.assertEquals(expectedMedMemberDetails, actualMedCoverageDetails);
        softAssert.assertAll();
    }

    public void updateTheMedicalFinancialDetailsTableForTheUI(){
        managePlanDentalMedicalPlan.setMedFinancialStartFnTable(medFinancialStartDateFNTable.getText());
        managePlanDentalMedicalPlan.setMedFinancialEndFnTable(medFinancialEndDateFNTable.getText());
        managePlanDentalMedicalPlan.setMedPlanPremiumAmtFnTable(medPlanPremiumAmtFnTable.getText());
        managePlanDentalMedicalPlan.setMedPlanAptcAmtFnTable(medAPTCAmtFnTable.getText());

        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);}

    public void updateTheMedicalMemberDetailsTableForTheUI() {
        managePlanDentalMedicalPlan.setMedPersonID(PersonID.getText());
        managePlanDentalMedicalPlan.setNameMember(Name.getText());
        managePlanDentalMedicalPlan.setDateOFBirth(DateOfBirth.getText());
        managePlanDentalMedicalPlan.setRelationship(relationshipToSubscriber_1.getText().toLowerCase());
        managePlanDentalMedicalPlan.setTobacco(tobacco.getText());
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }

    public void updateTheDentalPlanForTheUI() {
        SharedData.getManagePlanDentalMedicalPlan().setPlanType("2");
        //set marketing Medical Plan
        String currentDentalPlan = currentDentalPlanName.getText();
        managePlanDentalMedicalPlan.setPlanMarketingName(currentDentalPlan);

        //set Dental Policy Coverage
        String DenPolicyCoverage = pnlDenPolicyCoverage.getText();
        managePlanDentalMedicalPlan.setDenPolicyCoverageDate(DenPolicyCoverage);

        String pnlDENLatestAppDate = denLatestAppDateUI.getText();
        pnlDENLatestAppDate =basicActions.changeDateFormat(pnlDENLatestAppDate,"MM/dd/yyyy","yyyy-MM-dd");
        managePlanDentalMedicalPlan.setDenLatestAppDate(pnlDENLatestAppDate);

        String denFinancialStrDate= pnlDenFinancialStartDate.getText();
        denFinancialStrDate = basicActions.changeDateFormat(denFinancialStrDate,"MM/dd/yyyy","yyyy-MM-dd");
        managePlanDentalMedicalPlan.setDenFinancialStartDate(denFinancialStrDate);

        String denFinancialEndDate= pnlDenFinancialEndDate.getText();
        denFinancialEndDate = basicActions.changeDateFormat(denFinancialEndDate,"MM/dd/yyyy","yyyy-MM-dd");
        managePlanDentalMedicalPlan.setDenFinancialEndDate(denFinancialEndDate);

        String getDenTotalCsrAmt = denCsrAmount.getText();
        managePlanDentalMedicalPlan.setDenTotal_csr_amt(getDenTotalCsrAmt);

        String denPlanPremiumAmt = denplnPremiumAmt.getText();
        managePlanDentalMedicalPlan.setDenPlanPremiumAmt(denPlanPremiumAmt);

        String denPlanAPtcAMount = denPlanAPTCAMount.getText();
        managePlanDentalMedicalPlan.setDenPlanAptcAmt(denPlanAPtcAMount);

        String DenRatingArea = denRatingArea.getText();
        managePlanDentalMedicalPlan.setDenRatingArea(DenRatingArea);

        String denpremiumAfterSubsidy = denPremiumAfterSubsidy.getText();
        managePlanDentalMedicalPlan.setDenPremiumAfterSubsidy(denpremiumAfterSubsidy);
        String denserviceArea = denServiceArea.getText();
        managePlanDentalMedicalPlan.setDenServiceArea(denserviceArea);
        String denplanAV = denPlanAv.getText();
        managePlanDentalMedicalPlan.setDenPlanAV(denplanAV);
        managePlanDentalMedicalPlan.setDenPolicyID(denpolicyId.getText());
        managePlanDentalMedicalPlan.setDenHIOSId(denHiosId.getText());
        managePlanDentalMedicalPlan.setDenEhbPremiumAmt(denEHBPremium.getText());
        managePlanDentalMedicalPlan.setDenLCEEventTypeAndDate(denLCEEventDateType.getText().toLowerCase());
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }

    public void updateTheDentalMemberDetailsTableForTheUI() {
        managePlanDentalMedicalPlan.setDenPersonID(denPersonID.getText());
        managePlanDentalMedicalPlan.setDenNameMember(denName.getText());
        managePlanDentalMedicalPlan.setDenDateOFBirth(denDateOfBirth.getText());
        managePlanDentalMedicalPlan.setDenRelationship(denrelationshipToSubscriber_1.getText().toLowerCase());
        managePlanDentalMedicalPlan.setDenTobacco(dentobacco.getText());
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }


    public void updateTheDentalCoverageDetailsTableForTheUI() {
        managePlanDentalMedicalPlan.setDenCoverageStartDate(dencoverageStartDateCoTable.getText());
        managePlanDentalMedicalPlan.setDenCoverageEndDate(dencoverageEndDateCoTable.getText());
        managePlanDentalMedicalPlan.setDenStatus(denPolicyStatus.getText().toLowerCase());
        managePlanDentalMedicalPlan.setDenEffectuated(denEffectuated.getText().toLowerCase());
        managePlanDentalMedicalPlan.setDenTerminationReason(denTerminationReason.getText().toLowerCase());

        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }

    public void updateTheDentalFinancialDetailsTableForTheUI() {
        managePlanDentalMedicalPlan.setDenFinancialStartFnTable(denFinancialStartDateFNTable.getText());
        managePlanDentalMedicalPlan.setDenFinancialEndFnTable(denFinancialEndDateFNTable.getText());
        managePlanDentalMedicalPlan.setDenPlanPremiumAmtFnTable(denPlanPremiumAmtFnTable.getText());
        managePlanDentalMedicalPlan.setDenPlanAptcAmtFnTable(denAPTCAmtFnTable.getText());

       SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }
    public void simplifiedContainerTitleLabels(String simplifyPlanMedical, String simplifyPlanDental) {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 30);
        softAssert.assertEquals(txtTitleManagePlans.getText(), "Manage Plans");
        softAssert.assertEquals(txtSelectPlanYear.getText(), "Select a plan year:");
        softAssert.assertEquals(planYearLabel.getText(), "Year:");
        softAssert.assertEquals(txtSelectPlanType.getText(), "Select plan type:");
        softAssert.assertEquals(chkMedical.getText(), "Medical");
        softAssert.assertEquals(chkDental.getText(), "Dental");
        softAssert.assertEquals(simplifyMedical.getText(), "Medical Plan:");
        softAssert.assertEquals(simplifyDental.getText(), "Dental Plan:");
        softAssert.assertAll();
    }
    public void clickCheckedToSeeOnlyMedicalPlanData(String planType){
        basicActions.click(chkDental);
    }
    public void verifyLabelsSimplifiedMedical() {
        basicActions.waitForElementToBePresent(currentMedicalPlanName, 5000);
        softAssert.assertEquals(currentMedicalPlanName.getText(), "Friday Bronze Rx Copay");
        softAssert.assertEquals(medLatestApplicationUI.getText(), "Latest Application Date:");
        softAssert.assertEquals(medFinancialStartDateUI.getText(), "Financial Start Date:");
        softAssert.assertEquals(medEhbPremiumUI.getText(), "EHB Premium:");
        softAssert.assertEquals(medFinancialEndDateUI.getText(), "Financial End Date:");
        softAssert.assertEquals(medCsrAmountUI.getText(), "CSR Amount:");
        softAssert.assertEquals(medPlanPremiumUI.getText(), "Plan Premium:");
        softAssert.assertEquals(medLatestLCEtUI.getText(), "Latest LCE and Date:");
        softAssert.assertEquals(medPlanAPTCUI.getText(), "Plan APTC:");
        softAssert.assertEquals(medRateAreaUI.getText(), "Rating Area:");
        softAssert.assertEquals(medPremiumAfterSubsidyUI.getText(), "Premium after Subsidy:");
        softAssert.assertEquals(medServiceAreaUI.getText(), "Service Area:");
        softAssert.assertEquals(medPlanAVUI.getText(), "Plan AV:");
        softAssert.assertEquals(medPolicyIdUI.getText(), "Policy ID:");
        softAssert.assertEquals(medHiosIdUI.getText(), "HIOS ID:");
        softAssert.assertAll();
    }
    public void validateSimplifyViewMedicalData(String planNameSTG, String policyCoverageSTG, String latestApplicationDateSTG, String planNameQA, String policyCoverageQA, String latestApplicationDateQA) {
        basicActions.switchtoactiveTab();
        basicActions.waitForElementToBePresent(medPlanNameData, 5000);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(medPlanNameData.getText(), planNameSTG);
            softAssert.assertEquals(medCoverageData.getText(), policyCoverageSTG);
            softAssert.assertEquals(medLatestApplicationDateData.getText(), latestApplicationDateSTG);
            softAssert.assertAll();
        } else {
            softAssert.assertEquals(medPlanNameData.getText(), planNameQA);
            softAssert.assertEquals(medCoverageData.getText(), policyCoverageQA);
            softAssert.assertEquals(medLatestApplicationDateData.getText(), latestApplicationDateQA);
            softAssert.assertAll(); }
    }
    public void validateDataForHIOSID(String hiosIdSTG, String hiosIdQA) {
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(medHiosId.getText(), hiosIdSTG);
        } else {
            softAssert.assertEquals(medHiosId.getText(), hiosIdQA);
        }
        softAssert.assertAll();
    }
    public void iValidateMemberTableDataRowOne(String rowNumberSTG, String personIdDataSTG, String nameSTG, String birthSTG, String relationSTG, String tobaccoSTG, String rowNumberQA, String personIdDataQA, String nameQA, String birthQA, String relationQA, String tobaccoQA){
        if (SharedData.getEnv().equals("staging")) {
            basicActions.switchtoactiveTab();
            softAssert.assertEquals(rowNumberData.getText(), rowNumberSTG);
            softAssert.assertEquals(personIdData.getText(), personIdDataSTG);
            softAssert.assertEquals(nameData.getText(), nameSTG);
            softAssert.assertEquals(dOfBData.getText(), birthSTG);
            softAssert.assertEquals(relationData.getText(), relationSTG);
            softAssert.assertEquals(tobaccoData.getText(), tobaccoSTG);
        } else {
            softAssert.assertEquals(rowNumberData.getText(), rowNumberQA);
            softAssert.assertEquals(personIdData.getText(), personIdDataQA);
            softAssert.assertEquals(nameData.getText(), nameQA);
            softAssert.assertEquals(dOfBData.getText(), birthQA);
            softAssert.assertEquals(relationData.getText(), relationQA);
            softAssert.assertEquals(tobaccoData.getText(), tobaccoQA);
        }
        softAssert.assertAll();
    }
    public void iValidateMemberTableDataRowTwo(String rowNumberTwoSTG, String personIdDataTwoSTG, String nameTwoSTG, String birthTwoSTG, String relationTwoSTG, String tobaccoTwoSTG, String rowNumberTwoQA, String personIdDataTwoQA, String nameTwoQA, String birthTwoQA, String relationTwoQA, String tobaccoTwoQA){
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(rowNumberDataTwo.getText(), rowNumberTwoSTG);
            softAssert.assertEquals(personIdDataTwo.getText(), personIdDataTwoSTG);
            softAssert.assertEquals(nameDataTwo.getText(), nameTwoSTG);
            softAssert.assertEquals(dOfBDataTwo.getText(), birthTwoSTG);
            softAssert.assertEquals(relationDataTwo.getText(), relationTwoSTG);
            softAssert.assertEquals(tobaccoDataTwo.getText(), tobaccoTwoSTG);
        } else {
            softAssert.assertEquals(rowNumberDataTwo.getText(), rowNumberTwoQA);
            softAssert.assertEquals(personIdDataTwo.getText(), personIdDataTwoQA);
            softAssert.assertEquals(nameDataTwo.getText(), nameTwoQA);
            softAssert.assertEquals(dOfBDataTwo.getText(), birthTwoQA);
            softAssert.assertEquals(relationDataTwo.getText(), relationTwoQA);
            softAssert.assertEquals(tobaccoDataTwo.getText(), tobaccoTwoQA);
        }
        softAssert.assertAll();
    }
    public void iValidateCoverageTableDataRowOne(String type, String rowSTG, String coverageStartSTG, String coverageEndSTG, String statusSTG, String effectuatedSTG, String reasonSTG, String rowQA, String coverageStartQA, String coverageEndQA, String statusQA, String effectuatedQA, String reasonQA){
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(rowNumberData.getText(), rowSTG);
            softAssert.assertEquals(coverageStartDateCoTable.getText(), coverageStartSTG);
            softAssert.assertEquals(coverageEndDateCoTable.getText(), coverageEndSTG);
            softAssert.assertEquals(medPolicyStatus.getText(), statusSTG);
            softAssert.assertEquals(medEffectuated.getText(), effectuatedSTG);
            softAssert.assertEquals(medTerminationReason.getText(), reasonSTG);
        } else {
            softAssert.assertEquals(rowNumberData.getText(), rowQA);
            softAssert.assertEquals(coverageStartDateCoTable.getText(), coverageStartQA);
            softAssert.assertEquals(coverageEndDateCoTable.getText(), coverageEndQA);
            softAssert.assertEquals(medPolicyStatus.getText(), statusQA);
            softAssert.assertEquals(medEffectuated.getText(), effectuatedQA);
            softAssert.assertEquals(medTerminationReason.getText(), reasonQA);
        }
        softAssert.assertAll();
    }
    public void validateCoverageTableDataRowTwo(String type, String rowTwoSTG, String coverageStartRowTwoSTG, String coverageEndRowTwoSTG, String statusRowTwoSTG, String effectuatedRowTwoSTG, String reasonRowTwoSTG, String rowTwoQA, String coverageStartRowTwoQA, String coverageEndRowTwoQA, String statusRowTwoQA, String effectuatedRowTwoQA, String reasonRowTwoQA){
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(rowTwoData.getText(), rowTwoSTG);
            softAssert.assertEquals(coverageStartDateCoTable.getText(), coverageStartRowTwoSTG);
            softAssert.assertEquals(coverageEndDateCoTable.getText(), coverageEndRowTwoSTG);
            softAssert.assertEquals(medPolicyStatus.getText(), statusRowTwoSTG);
            softAssert.assertEquals(medEffectuated.getText(), effectuatedRowTwoSTG);
            softAssert.assertEquals(medTerminationReason.getText(), reasonRowTwoSTG);
        } else {
            softAssert.assertEquals(rowTwoData.getText(), rowTwoQA);
            softAssert.assertEquals(coverageStartRowTwo.getText(), coverageStartRowTwoQA);
            softAssert.assertEquals(coverageEndRowTwo.getText(), coverageEndRowTwoQA);
            softAssert.assertEquals(statusRowTwo.getText(), statusRowTwoQA);
            softAssert.assertEquals(effectuatedRowTwo.getText(), effectuatedRowTwoQA);
            softAssert.assertEquals(reasonRowTwo.getText(), reasonRowTwoQA);
        }
        softAssert.assertAll();
    }
    public void iValidateFinancialTableDataRowOne(String type, String rowSTG, String financialStartSTG, String financialEndSTG, String premiumSTG, String APTCSTG, String rowQA, String financialStartQA, String financialEndQA, String premiumQA, String APTCQA){
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(rowNumberData.getText(), rowSTG);
            softAssert.assertEquals(medFinancialStartDateFNTable.getText(), financialStartSTG);
            softAssert.assertEquals(medFinancialEndDateFNTable.getText(), financialEndSTG);
            softAssert.assertEquals(medPlanPremiumAmtFnTable.getText(), premiumSTG);
            softAssert.assertEquals(medAPTCAmtFnTable.getText(), APTCSTG);
        } else {
            softAssert.assertEquals(rowNumberData.getText(), rowQA);
            softAssert.assertEquals(medFinancialStartDateFNTable.getText(), financialStartQA);
            softAssert.assertEquals(medFinancialEndDateFNTable.getText(), financialEndQA);
            softAssert.assertEquals(medPlanPremiumAmtFnTable.getText(), premiumQA);
            softAssert.assertEquals(medAPTCAmtFnTable.getText(), APTCQA);
        }
        softAssert.assertAll();
    }
    public void validateFinancialTableDataRowTwo(String type, String rowTwoSTG, String financialStartRowTwoSTG, String financialEndRowTwoSTG, String premiumRowTwoSTG, String APTCRowTwoSTG, String rowTwoQA, String financialStartRowTwoQA, String financialEndRowTwoQA, String premiumRowTwoQA, String APTCRowTwoQA){
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(rowTwoData.getText(), rowTwoSTG);
            softAssert.assertEquals(financialStartDateRowTwo.getText(), financialStartRowTwoSTG);
            softAssert.assertEquals(financialEndDateRowTwo.getText(), financialEndRowTwoSTG);
            softAssert.assertEquals(premiumRowTwo.getText(), premiumRowTwoSTG);
            softAssert.assertEquals(aptcRowTwo.getText(), APTCRowTwoSTG);
        } else {
            softAssert.assertEquals(rowTwoData.getText(), rowTwoQA);
            softAssert.assertEquals(financialStartDateRowTwo.getText(), financialStartRowTwoQA);
            softAssert.assertEquals(financialEndDateRowTwo.getText(), financialEndRowTwoQA);
            softAssert.assertEquals(premiumRowTwo.getText(), premiumRowTwoQA);
            softAssert.assertEquals(aptcRowTwo.getText(), APTCRowTwoQA);
        }
        softAssert.assertAll();
    }
    public void validateGoBackButton() {
        basicActions.waitForElementToBePresent(btnGoBack, 30);
        basicActions.scrollToElement(btnGoBack);
        softAssert.assertEquals(btnGoBack.getText(), "Go Back");
        softAssert.assertTrue(btnGoBack.isDisplayed());
        softAssert.assertAll();
    }
    public void clickGoBackButton() {
        basicActions.waitForElementToBePresent(btnGoBack, 30);
        basicActions.scrollToElement(btnGoBack);
        basicActions.click(btnGoBack);
        basicActions.closeBrowserTab();
        basicActions.switchToParentPage("C4HCO Admin Portal");
    }
    public void clickGoBackButtonOnSimplifiedView() {
        basicActions.waitForElementToBePresent(btnGoBack, 30);
        basicActions.scrollToElement(btnGoBack);
        basicActions.click(btnGoBack);
        basicActions.closeBrowserTab();
        basicActions.switchToParentPage("C4HCO Admin Portal");
    }
    public void uncheckMedicalPlanCoCo(){
    basicActions.waitForElementToBePresent(btnMedicalChecked, 20);
    basicActions.scrollToElement(btnMedicalChecked);
    btnMedicalChecked.click();
    softAssert.assertEquals(currentMedicalDentalPlan.size(), 1);
    softAssert.assertAll(); }

    public void verifyLabelsSimplifiedMedicalCoCo() {
        basicActions.waitForElementToBePresent(currentMedicalPlanName, 5000);
        softAssert.assertTrue(currentMedicalPlanName.isDisplayed());
        softAssert.assertEquals(medLatestApplicationUI.getText(), "Latest Application Date:");
        softAssert.assertEquals(medFinancialStartDateUI.getText(), "Financial Start Date:");
        softAssert.assertEquals(medEhbPremiumUI.getText(), "EHB Premium:");
        softAssert.assertEquals(medFinancialEndDateUI.getText(), "Financial End Date:");
        softAssert.assertEquals(medCsrAmountUI.getText(), "CSR Amount:");
        softAssert.assertEquals(medPlanPremiumUI.getText(), "Plan Premium:");
        softAssert.assertEquals(medLatestLCEtUI.getText(), "Latest LCE and Date:");
        softAssert.assertEquals(medPlanAPTCUI.getText(), "Plan SES:");
        softAssert.assertEquals(medRateAreaUI.getText(), "Rating Area:");
        softAssert.assertEquals(medPremiumAfterSubsidyUI.getText(), "Premium after Subsidy:");
        softAssert.assertEquals(medServiceAreaUI.getText(), "Service Area:");
        softAssert.assertEquals(medPlanAVUI.getText(), "Plan AV:");
        softAssert.assertEquals(medPolicyIdUI.getText(), "Policy ID:");
        softAssert.assertEquals(medHiosIdUI.getText(), "HIOS ID:");
        softAssert.assertAll(); }
    public void validateMakeChangesMedicalButtonNotDisplay(){
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 10);
        Assert.assertFalse(basicActions.isElementDisplayed(btnMakeChangeMed, 3));   }

    public void validateErrorMessagesCoCo(DataTable table) {
        List<Map<String, String>> memberData = table.asMaps();
        for (Map<String, String> data : memberData) {
            String memberNo = data.get("member");
            String aptcValue = data.get("aptc");

            String expectedErrorMessage = "";

            if (aptcValue == null || aptcValue.trim().isEmpty()) {
                expectedErrorMessage = "Invalid monetary amount for SES";
            } else {
                expectedErrorMessage = "Invalid monetary amount for SES: $" + aptcValue;
            }

            boolean errorMessageElement;
            softAssert.assertEquals(SESInvalidError.getText(), expectedErrorMessage, "Message didn't display");
            softAssert.assertAll();
        }
    }
    public void validateEHBErrorsCoCo() {
        double value1 = Double.parseDouble(sesmember2.getAttribute("value").replaceAll("[^0-9.]", ""));
        double value2 = Double.parseDouble(sesmember1.getAttribute("value").replaceAll("[^0-9.]", ""));
        double value3 = Double.parseDouble(EHBPremiumamtmedical.getText().replaceAll("[^0-9.]", ""));
        if (value1 + value2 > value3) {
            Assert.assertTrue(SESEHBError.isDisplayed(), "Error message should be displayed when condition is met.");
        }
    }
}


