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
import java.util.stream.Collectors;

import static com.c4hco.test.automation.utils.WebDriverManager.getDriver;

public class AdminPortalManagePlansPage {

    private BasicActions basicActions;

    public AdminPortalManagePlansPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);


    }

    SoftAssert softAssert = new SoftAssert();
    ManagePlanDentalMedicalPlan managePlanDentalMedicalPlan = new ManagePlanDentalMedicalPlan();

    @FindBy(xpath = "//div[@id='enrollments-container']")
    WebElement managePlansContainer;
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
    @FindBy(xpath = "//span[@class='select-planyear-label']")
    WebElement planYearLabel;
    @FindBy(css = ".select-year  app-drop-down-select")
    WebElement planYearLabelYear;
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

    @FindBy(css = "#premium_1 > input")
    WebElement premiumAmount;

    @FindBy(css = "#planAPTC_1 > input")
    WebElement aptcAmount;

    @FindBy(id = "financialEndDate_1")
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
    @FindBy(css = ".medical-plan-container.plan-container-fill .current-plan-header > p")
    WebElement currentMedicalHeader;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-plan-information[1]/div[1]/div[1]/div")
    List<WebElement> currentMedicalData;
    @FindBy(css = ".dental-plan-container.plan-container-fill .current-plan-header > p")
    WebElement currentDentalHeader;
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

    @FindBy(css = "div.medical-plan-container.plan-container-fill > app-current-plan > div > div.plan-summary")
    WebElement currentMedPlanSummaryContainer;
    @FindBy(css = "div.dental-plan-container.plan-container-fill > app-current-plan > div > div.plan-summary")
    WebElement currentDentPlanSummaryContainer;
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


    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='HIOS ID:']//following::div[1]")
    WebElement medHiosId;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='HIOS ID:']//following::div[1]")
    WebElement denHiosId;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='EHB Premium:']//following::div[1]")
    WebElement medEHBPremium;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='EHB Premium:']//following::div[1]")
    WebElement denEHBPremium;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Latest LCE and Date:']//following::div[1]")
    WebElement medLCEEventDateType;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[normalize-space()='Latest LCE and Date:']//following::div[1]")
    WebElement denLCEEventDateType;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='member-details-grid']/div")
    List<WebElement> medicalMemberDetailsTableHeader;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='member-details-grid']/div")
    List<WebElement> dentalMemberDetailsTableHeader;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='body-text-1 member-details-grid-item bold-text']")
    List<WebElement> coverageDetailsTableTableHeader;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='body-text-1 member-details-grid-item bold-text']")
    List<WebElement> dencoverageDetailsTableTableHeader;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='financial-details-grid']/div")
    List<WebElement> coverageFinancialTableTableHeader;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='financial-details-grid']/div")
    List<WebElement> dencoverageFinancialTableTableHeader;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='referenceId_1']")
    WebElement PersonID;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='referenceId_1']")
    WebElement denPersonID;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='firstName_1']")
    WebElement Name;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='firstName_1']")
    WebElement denName;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='dateOfBirth_1']")
    WebElement DateOfBirth;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='dateOfBirth_1']")
    WebElement denDateOfBirth;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='relationshipToSubscriber_1']")
    WebElement relationshipToSubscriber_1;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='relationshipToSubscriber_1']")
    WebElement denrelationshipToSubscriber_1;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='tobacco_1']")
    WebElement tobacco;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='tobacco_1']")
    WebElement dentobacco;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='coverageStartDate_1']")
    WebElement coverageStartDateCoTable;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='coverageStartDate_1']")
    WebElement dencoverageStartDateCoTable;
    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//app-current-plan//div[@id='coverageEndDate_1']")
    WebElement coverageEndDateCoTable;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//app-current-plan//div[@id='coverageEndDate_1']")
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

    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='member-details-grid']//div[contains(@id,'firstName_')]")
    List<WebElement> MedicalPlanMembersDetailsContainer;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='member-details-grid']//div[contains(@id,'firstName_')]")
    List<WebElement> DentalPlanMembersDetailsContainer;
    @FindBy(xpath = "//app-current-plan//div[@class='plan-member-info']")
    WebElement CurrentPlanInfo;
    @FindBy(xpath = "//*[@id='form-edit-pan-member-info']/div/div[7]/div/div[2]")
    WebElement aptcEHBError;
    List<WebElement> PlanContainer;
    @FindBy(css = "#enrollments-container > div.no-plan-message.body-text-1")
    WebElement noPlanMessage;
    @FindBy(xpath = "//app-drop-down-select[@id='selectPolicy']//div[@class='drop-down-option drop-down-option-selected']")
    WebElement planSelected;
    @FindBy(xpath = "//*[@id='enrollment-info']/div/div[28]")
    WebElement planId;

    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']")
    WebElement dentalContainer;

    @FindBy(id = "individualDashboardCocoTitle")
    WebElement CocoTitle;
    @FindBy(xpath = "//*[@class='current-plan-container']")
    WebElement currentplancontainer;
    @FindBy(xpath = "//*[@class='select-policy-label body-text-1']")
    WebElement selectPolicyLabel;
    @FindBy(xpath = "//div[@class='coverage-details-grid']/div")
    List<WebElement> medCoverageColumnHeader;

    @FindBy(xpath = "//div[@class='two-column-twentyfive-row-container header-3']")
    List<WebElement> labelPlanNameForMedAndDen;

    @FindBy(xpath = "//div[@class='two-column-twentyfive-row-container body-text-2']")
    List<WebElement> labelCoverageForMedAndDen;

    @FindBy(xpath = "//div[@class='label-container-copy-icon body-text-2']")
    List<WebElement> labelPolicyIdForMedAndDen;

    @FindBy(xpath = "//input[@id='Manage Plans-Select Plan Type Medical']//following-sibling::label")
    WebElement medPlanTypeAlreadyChecked;

    @FindBy(xpath = "//input[@id='Manage Plans-Select Plan Type Dental']//following::label")
    WebElement denPlanTypeAlreadyChecked;

    @FindBy(xpath = "//input[@id='Manage Plans-Select Plan Type Medical Unselected']/following-sibling::label")
    WebElement medPlanTypeUnChecked;

    @FindBy(xpath = "//input[@id='Manage Plans-Select Plan Type Dental Unselcted']/following-sibling::label")
    WebElement denPlanTypeUnChecked;

    @FindBy(xpath = "(//h2[@class='dashboardHeader1'])[2]")
    WebElement labelHeader1;

    @FindBy(xpath = "//h3[@class='dashboardHeader2']")
    WebElement labelHeader2;

    @FindBy(xpath = "//div[@class='drop-down-option drop-down-option-selected']")
    WebElement txtAlreadySelectedYearOption;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']/div")
    List<WebElement> txtSecondaryYearOption;

    @FindBy(xpath = "//p[@class='select-policy-label body-text-1']")
    WebElement label_SelectAPolicy;

    @FindBy(xpath = "//div[@class='current-plan-container']")
    WebElement currentPlanContainer;

    @FindBy(xpath = "//div[@class='header-container header-2']/preceding::div[@class='member-details-grid-item body-text-1 bold-text']")
    List<WebElement> containerTableCols1;

    @FindBy(xpath = "//div[@class='header-container header-2']/preceding::div[@class='body-text-1 member-details-grid-item bold-text']")
    List<WebElement> containerTableCols2;

    @FindBy(xpath = "//div[@class='header-container header-2']/following::*[@class='two-column-twentyfive-row-container header-3']")
    WebElement labelPlanNamePFPM;

    @FindBy(xpath = "//div[@class='header-container header-2']/following::*[@class='two-column-twentyfive-row-container body-text-2']")
    WebElement labelPolicyCoveragePFPM;

    @FindBy(xpath = "//div[@class='header-container header-2']/following::div[@class='label-container body-text-2']")
    List<WebElement> allLabelsPFPM;

    @FindBy(xpath = "//*[@class='previous-plan-details-header-container']")
    List<WebElement> greenBar_financialPeriod;

    @FindBy(xpath = "//div[@class='previous-plan-detail-chevron-container']")
    List<WebElement> chevronPreviousPlanDetail;

    @FindBy(xpath = "//button[@id='Manage Plans-Show Financial Period']")
    List<WebElement> labelShowFinancialPeriod;

    @FindBy(id = "enrollments-container")
    WebElement mPlansContainer;

    @FindBy(xpath = "//*[@class='previous-plan-container']")
    WebElement previousFinancialContainer;

    @FindBy(xpath = "//div[@class='header-container header-2']")
    WebElement previousMedicalContainer;

    @FindBy(xpath = "//div[@class='previous-plan-details-header header-3']")
    List<WebElement> greenBarHeader;

    @FindBy(xpath = "//*[@class='previous-plan-details']//*[@class='label-container body-text-2']")
    List<WebElement> previousFinancialLabel;

    @FindBy(xpath = "//*[@class='previous-plan-details']//*[@class='label-container-copy-icon body-text-2']")
    WebElement previousFinancialPolicyLabel;

    @FindBy(xpath = "//p[@class='plan-header header-2 simple-view-header']")
    WebElement labelInRedMedicalPlan;

    @FindBy(xpath = "//div[@class='coverage-details-grid']/div")
    List<WebElement> labelCoverageDetailsGridItems;

    @FindBy(xpath = "//div[@class='financial-details-grid']/div")
    List<WebElement> labelFinancialDetailsGridItems;

    @FindBy(xpath = "//div[@class='header-container header-2']/following::div[@class='member-details-grid-item body-text-1 bold-text']")
    List<WebElement> PreviousFinancialPeriodsDentalContainerTable1Cols1;

    @FindBy(xpath = "//div[@class='header-container header-2']/following::div[@class='body-text-1 member-details-grid-item bold-text']")
    List<WebElement> PreviousFinancialPeriodsDentalContainerTable1Cols2;

    @FindBy(xpath = "//div[@class='multiselect-item-selected']")
    WebElement btnMedicalOrDentalWhenChecked;

    @FindBy(xpath = "//div[@class='multiselect-item-unselected']")
    WebElement btnMedicalOrDentalWhenUnchecked;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelBtnOnConfirm;


    @FindBy(xpath = "//div[@class='medical-plan-container plan-container-fill']//div[@id='coverageEndDate_1']")
    WebElement coverageEndDateMedTxt;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@id='coverageEndDate_1']")
    WebElement coverageEndDateDentTxt;

    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[@class='two-column-twentyfive-row-container header-3']")
    WebElement dentalPlanName;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[@class='two-column-twentyfive-row-container body-text-2']")
    WebElement denCoverageData;
    @FindBy(xpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='plan-summary']//div[@class='value-container body-text-1']")
    WebElement denLatestApplicationDateData;
    @FindBy(xpath = "//div[contains(@id,'coverageStartDate')]/input")
    List<WebElement> inputAllCoverageStartDate;

    @FindBy(xpath = "//div[contains(@id,'coverageEndDate')]/input")
    List<WebElement> inputAllCoverageEndDate;

    @FindBy(xpath = "//div[contains(@id,'financialStartDate')]/input")
    List<WebElement> inputAllFinancialStartDate;

    @FindBy(xpath = "//div[contains(@id,'financialEndDate')]/input")
    List<WebElement> inputAllFinancialEndDate;

    @FindBy(xpath = "//div[contains(@id,'premium')]/input")
    List<WebElement> inputAllPremiums;

    @FindBy(xpath = "//div[contains(@id,'planAPTC')]/input")
    List<WebElement> inputAllSESs;

    @FindBy(xpath = "//*[@formcontrolname='terminationReason']//div[@class='drop-down-option drop-down-option-selected']")
    List<WebElement> drpDwnArrowTerminationReason;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']/div")
    List<WebElement> allDrpDownOptionsTerminationReason;

    @FindBy(xpath = "//div[contains(text(),'Invalid monetary amount for SES: ')]")
    WebElement SESInvalidAmtError;

    @FindBy(xpath = "//div[contains(text(),'SES entered exceeds SES amount: ')]")
    WebElement SESExceedError;


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

    public void containerTitleLabelsYear(String year) {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 20);
        softAssert.assertEquals(txtTitleManagePlans.getText(), "Manage Plans");
        softAssert.assertEquals(txtSelectPlanYear.getText(), "Select a plan year:");
        softAssert.assertEquals(planYearLabel.getText(), "Year:");
        String yearValue;
        if (Character.isLetter(year.charAt(0))) {
            String coverageStartDateBase = basicActions.getDateBasedOnRequirement(year);
            yearValue = basicActions.changeDateFormat(coverageStartDateBase, "yyyy-MM-dd", "MMddyyyy");
        } else {
            yearValue = year;
        }
        softAssert.assertEquals(planYearLabelYear.getAttribute("innerText"), yearValue);
        softAssert.assertEquals(txtSelectPlanType.getText(), "Select plan type:");
        basicActions.waitForElementToBePresentWithRetries(chkMedical, 90);
        softAssert.assertEquals(chkMedical.getText(), "Medical");
        basicActions.waitForElementToBePresentWithRetries(chkDental, 90);
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
        basicActions.waitForElementToBePresentWithRetries(btnMedicalChecked, 60);
        softAssert.assertTrue(btnMedicalChecked.isDisplayed());
        softAssert.assertTrue(btnDentalChecked.isDisplayed());
        softAssert.assertAll();
    }

    public void resetMakeChangeButtonsDisplayed(String planType) {
        switch (planType){
            case "Both":
                basicActions.waitForElementToBePresentWithRetries(btnMakeChangeMed, 60);
                softAssert.assertEquals(btnMakeChangeMed.getText(), "Make Changes Medical");
                softAssert.assertEquals(btnMakeChangeDental.getText(), "Make Changes Dental");
                break;
            case "Medical":
                basicActions.waitForElementToBePresentWithRetries(btnMakeChangeMed, 60);
                softAssert.assertEquals(btnMakeChangeMed.getText(), "Make Changes Medical");
                softAssert.assertTrue(basicActions.waitForElementToDisappear(btnMakeChangeDental, 10));
                break;
            case "Dental":
                basicActions.waitForElementToBePresentWithRetries(btnMakeChangeDental, 60);
                softAssert.assertEquals(btnMakeChangeDental.getText(), "Make Changes Dental");
                softAssert.assertTrue(basicActions.waitForElementToDisappear(btnMakeChangeMed, 10));
                break;
            case "Neither":
                basicActions.waitForElementToBePresentWithRetries(noPlanMessage, 60);
                softAssert.assertTrue(basicActions.waitForElementToDisappear(btnMakeChangeDental, 10));
                softAssert.assertTrue(basicActions.waitForElementToDisappear(btnMakeChangeMed, 10));
                break;
            default:
                throw new IllegalArgumentException("Undefined Type: " + planType);
        }
        softAssert.assertAll();
    }

    public void verifySaveButtonDisplayed(String saveMed) {
        basicActions.waitForElementToBePresent(btnMedSave, 10);
        softAssert.assertEquals(btnMedSave.getText(), saveMed);
        softAssert.assertAll();
    }

    public void clickMakeChangesMedical() {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 30);
        basicActions.waitForElementToBePresent(btnMakeChangeMed, 30);
        basicActions.waitForElementToBeClickable(btnMakeChangeMed, 10);
        btnMakeChangeMed.click();
        basicActions.waitForElementToBePresentWithRetries(CurrentPlanInfo, 60);
        basicActions.waitForElementToBePresentWithRetries(btnMedSave, 60);
        PlanContainer = MedicalPlanMembersDetailsContainer;
    }

    public void clickResetChangesMedical() {
        basicActions.waitForElementToBePresent(btnMedReset, 10);
        btnMedReset.click();
    }

    public void clickMakeChangesDental() {
        basicActions.waitForElementToBePresent(btnMakeChangeDental, 60);
        basicActions.waitForElementToBeClickable(btnMakeChangeDental, 60);
        btnMakeChangeDental.click();
        basicActions.waitForElementToBePresentWithRetries(CurrentPlanInfo, 60);
        basicActions.waitForElementToBePresentWithRetries(btnDentalSave, 60);
        PlanContainer = DentalPlanMembersDetailsContainer;
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

    public void validateChangeButtonsNotDisplay() {
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
        softAssert.assertAll();
    }

    public void checkPreviousFinancialMedicalMessage() {
        basicActions.waitForElementToBePresent(previousFinancialMed, 20);
        softAssert.assertEquals(previousFinancialMed.getText(), "Previous Financial Periods - Medical");
        softAssert.assertEquals(previousFinancialNoMed.getText(), "No Past Financial Periods - Medical");
        softAssert.assertAll();
    }

    public void checkPreviousFinancialDentalMessage() {
        basicActions.waitForElementToBePresent(previousFinancialDental, 20);
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
            String coverageStartDate;
            if (Character.isLetter(coverageStartDateValue.charAt(0))) {
                String coverageStartDateBase = basicActions.getDateBasedOnRequirement(coverageStartDateValue);
                coverageStartDate = basicActions.changeDateFormat(coverageStartDateBase, "yyyy-MM-dd", "MMddyyyy");
            } else {
                coverageStartDate = coverageStartDateValue;
            }

            basicActions.waitForElementToBePresentWithRetries(coverageStartdate, 60);
            basicActions.waitForElementToBeClickableWithRetries(coverageStartdate, 60);
            basicActions.scrollToElement(coverageStartdate);
            basicActions.wait(500);
            String coverageStartDateMem = "//div[@id='coverageStartDate_" + memberNo + "']//input[1]";
            basicActions.updateElementWithRetries(coverageStartDateMem, coverageStartDate);
        }
    }

    public void memberCoverageStrtDateNew(List<String> memberCoverageStrtDtList) {
        Map<String, String> memberUpdates = memberCoverageStrtDtList.stream()
                .map(entry -> entry.split(":"))
                .collect(Collectors.toMap(parts -> parts[0].trim(), parts -> parts[1].trim()));
        basicActions.waitForElementListToBePresentWithRetries(PlanContainer, 15);
        basicActions.scrollToElement(CurrentPlanInfo);
        for (WebElement nameElement : PlanContainer) {
            String memberFullName = nameElement.getText().trim();
            String nameElementID = nameElement.getAttribute("id");
            String index = nameElementID.replace("firstName_", "");
            String matchingname = memberUpdates.keySet().stream().filter(memberFullName::startsWith).findFirst().orElse(null);
            Assert.assertNotNull(matchingname, "Member Name not found: " + memberFullName);
            String inputDate = basicActions.getDateBasedOnRequirement(memberUpdates.get(matchingname));
            String updatedDate = basicActions.changeDateFormat(inputDate, "yyyy-MM-dd", "MM/dd/yyyy");
            String coverageStartDateElement = "//div[@id='coverageStartDate_" + index + "']//input[1]";
            basicActions.waitForElementToBeClickableWithRetries(coverageStartdate, 60);
            basicActions.updateElementWithRetries(coverageStartDateElement, updatedDate);
        }
    }

    public void memberFinancialStrtDateNew(List<String> memberFinancialStrtDtList) {
        Map<String, String> memberUpdates = memberFinancialStrtDtList.stream()
                .map(entry -> entry.split(":"))
                .collect(Collectors.toMap(parts -> parts[0].trim(), parts -> parts[1].trim()));
        basicActions.waitForElementListToBePresentWithRetries(PlanContainer, 15);
        basicActions.scrollToElement(CurrentPlanInfo);
        for (WebElement nameElement : PlanContainer) {
            String memberFullName = nameElement.getText().trim();
            String nameElementID = nameElement.getAttribute("id");
            String index = nameElementID.replace("firstName_", "");
            String matchingname = memberUpdates.keySet().stream().filter(memberFullName::startsWith).findFirst().orElse(null);
            Assert.assertNotNull(matchingname, "Member Name not found: " + memberFullName);
            String inputDate = basicActions.getDateBasedOnRequirement(memberUpdates.get(matchingname));
            String updatedDate = basicActions.changeDateFormat(inputDate, "yyyy-MM-dd", "MM/dd/yyyy");
            String financialStartDateElement = "//div[@id='financialStartDate_" + index + "']//input[1]";
            basicActions.waitForElementToBeClickable(financialStartDate, 30);
            basicActions.updateElementWithRetries(financialStartDateElement, updatedDate);
        }
    }

    public void memberFinancialStrtDate(List<String> memberFinancialStrtDtList) {
        for (String memberFinancialStrtDate : memberFinancialStrtDtList) {
            String[] parts = memberFinancialStrtDate.split(":");
            String memberNo = parts[0];
            String financialStartDateValue = parts[1];
            String financialStartDates;
            if (Character.isLetter(financialStartDateValue.charAt(0))) {
                String financialStartDateBase = basicActions.getDateBasedOnRequirement(financialStartDateValue);
                financialStartDates = basicActions.changeDateFormat(financialStartDateBase, "yyyy-MM-dd", "MMddyyyy");
            } else {
                financialStartDates = financialStartDateValue;
            }

            basicActions.scrollToElement(financialStartDate);
            basicActions.waitForElementToBePresent(financialStartDate, 30);
            basicActions.waitForElementToBeClickable(financialStartDate, 30);

            WebElement financialStartDateMem = basicActions.getDriver().findElement(By.xpath("//div[@id='financialStartDate_" + memberNo + "']//input[1]"));
            financialStartDateMem.click();
            financialStartDateMem.clear();
            financialStartDateMem.sendKeys(financialStartDates);

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
        basicActions.wait(700);
        softAssert.assertTrue(basicActions.waitForElementToBePresentWithRetries(chkMedical, 60));
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
        basicActions.waitForElementToBePresent(coverageStartdate, 60);
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

    public void updateTheCoverageEndDateNew(String planType,List<String> memberCoverageEndDtList) {
        List<Map<String, String>> memberCoverageDateUpdateList = memberCoverageEndDtList.stream()
                .map(entry -> entry.split(":"))
                .map(parts -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("key", parts[0].trim());
                    map.put("value", parts[1].trim());
                    return map;
                }).collect(Collectors.toList());
        basicActions.scrollToElement(CurrentPlanInfo);
        for (WebElement nameElement : PlanContainer) {
            basicActions.waitForElementToBePresentWithRetries(nameElement,60);
            String memberFullName = nameElement.getText().trim();
            String nameElementID = nameElement.getAttribute("id");
            String index = nameElementID.replace("firstName_", "");
            Map<String,String> matchedMemberDetails = memberCoverageDateUpdateList.stream().filter(m -> memberFullName.startsWith(m.get("key"))).findFirst().orElse(null);
            Assert.assertNotNull(matchedMemberDetails, "Member Name not found: " + memberFullName);
            String inputDate = matchedMemberDetails.get("value");
            String updatedDate = basicActions.changeDateFormat(basicActions.getDateBasedOnRequirement(inputDate), "yyyy-MM-dd", "MM/dd/yyyy");
            String coverageEndDateElement = "//div[@id='coverageEndDate_" + index + "']//input[1]";
            basicActions.waitForElementToBeClickableWithRetries(coverageEndDate, 30);
            basicActions.updateElementWithRetries(coverageEndDateElement, updatedDate);
            WebElement coverageStartDateElement =  basicActions.getDriver().findElement(By.xpath("//div[@id='coverageStartDate_" + index + "']//input[1]"));
            String coverageStartDate = basicActions.changeDateFormat(coverageStartDateElement.getAttribute("value"),"yyyy-MM-dd", "MM/dd/yyyy");
            String name = matchedMemberDetails.get("key");
            // Set disenrollment reason if start and end dates are same
            if(updatedDate.equals(coverageStartDate)){
                setDisenrollmentReason(planType,name);
            }
        }
    }

    public void setDisenrollmentReason(String planType, String name){
        List<MemberDetails> members = basicActions.getAllMem();
        switch (planType){
            case("Medical"):
                members.stream().filter(member -> member.getFirstName().contains(name)).findFirst().ifPresent(member -> member.setPolicyDisenrollmentReasonMed("NO_REASON"));
                break;
            case("Dental"):
                members.stream().filter(member -> member.getFirstName().contains(name)).findFirst().ifPresent(member -> member.setPolicyDisenrollmentReasonDen("NO_REASON"));
                break;
        }
    }

    public void updateTheFinancialEndDateNew(List<String> memberFinancialEndDtList) {
        List<Map<String, String>> memberUpdates = memberFinancialEndDtList.stream()
                .map(entry -> entry.split(":"))
                .map(parts -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("key", parts[0].trim());
                    map.put("value", parts[1].trim());
                    return map;
                })
                .collect(Collectors.toList());
        basicActions.waitForElementListToBePresentWithRetries(PlanContainer, 45);
        basicActions.scrollToElement(CurrentPlanInfo);
        for (WebElement nameElement : PlanContainer) {
            String memberFullName = nameElement.getText().trim();
            String nameElementID = nameElement.getAttribute("id");
            String index = nameElementID.replace("firstName_", "");
            String matchingname = memberUpdates.stream().map(m -> m.get("key")).filter(memberFullName::startsWith).findFirst().orElse(null);
            Assert.assertNotNull(matchingname, "Member Name not found: " + memberFullName);
            String inputDate = memberUpdates.stream().map(m -> m.get("value")).findFirst().orElse("");
            String updatedDate = basicActions.changeDateFormat(basicActions.getDateBasedOnRequirement(inputDate), "yyyy-MM-dd", "MM/dd/yyyy");
            String financialEndDateElement = "//div[@id='financialEndDate_" + index + "']//input[1]";
            basicActions.waitForElementToBeClickable(financialEndDate, 30);
            basicActions.scrollToElement(financialEndDate);
            basicActions.updateElementWithRetries(financialEndDateElement, updatedDate);
        }
    }

    public void selectThePlanYearOnManagePlan(String planYear) {
        basicActions.waitForElementToBePresent(dpdCurrentYearMP, 50);
        dpdCurrentYearMP.click();

        String xpath = String.format("//app-drop-down-select[1]//div[2]//*[contains(text(),'" + planYear + "')]");
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
        basicActions.waitForElementToBePresentWithRetries(currentDentalPlanName, 20);

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

    public void validateMedicalDentalPlanSummary(String textType, String planType) {
        switch (textType) {
            case "Policy":
                validatePolicyMedicalDentalPlanSummary(planType);
                break;
            case "No Policy":
                validateNoPolicyMedicalDentalPlanSummary(planType);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + textType);
        }
    }

    public void validatePolicyMedicalDentalPlanSummary(String planType) {
        basicActions.waitForElementListToBePresent(currentMedicalDentalPlan,60);
        switch (planType) {
            case "Medical":
                validateTheTextOfTheMedicalPlanSummary();
                break;
            case "Dental":
                validateTheTextOfTheDentalPlanSummary();
                break;
            case "Both":
                validateTheTextOfTheMedicalPlanSummary();
                validateTheTextOfTheDentalPlanSummary();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }

    public void validateTheTextOfTheMedicalPlanSummary() {
        basicActions.waitForElementToBePresent(currentMedPlanSummaryContainer,60);
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getText(), "Current Medical Plan:");
        List<String> expectedLabels = Arrays.asList("Latest Application Date:", "Financial Start Date:", "EHB Premium:", "Financial End Date:", "CSR Amount:", "Plan Premium:", "Latest LCE and Date:", "Plan APTC:", "Rating Area:", "Premium after Subsidy:", "Service Area:", "Plan AV:", "Policy ID:", "HIOS ID:");
        String containerText = currentMedPlanSummaryContainer.getText();
        for (String expectedLabel : expectedLabels) {
            softAssert.assertTrue(containerText.contains(expectedLabel), "Expected label not found in container: " + expectedLabel);
        }
        softAssert.assertAll();
    }

    public void validateTheTextOfTheDentalPlanSummary() {
        basicActions.waitForElementToBePresent(currentDentPlanSummaryContainer,60);
        softAssert.assertEquals(currentMedicalDentalPlan.get(1).getText(), "Current Dental Plan:");
        List<String> expectedLabels = Arrays.asList("Latest Application Date:", "Financial Start Date:", "EHB Premium:", "Financial End Date:", "CSR Amount:", "Plan Premium:", "Latest LCE and Date:", "Plan APTC:", "Rating Area:", "Premium after Subsidy:", "Service Area:", "Plan AV:", "Policy ID:", "HIOS ID:");
        String containerText = currentDentPlanSummaryContainer.getText();
        for (String expectedLabel : expectedLabels) {
            softAssert.assertTrue(containerText.contains(expectedLabel), "Expected label not found in container: " + expectedLabel);
        }
        softAssert.assertAll();
    }

    public void validateNoPolicyMedicalDentalPlanSummary(String planType) {
        switch (planType) {
            case "Medical":
                validateTheTextOfTheMedicalNoPolicyPlanSummary();
                break;
            case "Dental":
                validateTheTextOfTheDentalNoPolicyPlanSummary();
                break;
            case "Both":
                validateNoPlanMessageIsDisplayed("Select a plan year to view policies");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }

    public void validateTheTextOfTheMedicalNoPolicyPlanSummary() {
        basicActions.waitForElementListToBePresent(currentMedicalDentalPlan,60);
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getText(), "Current Medical Plan:");
        WebElement containerText = basicActions.getDriver().findElement(By.cssSelector("div.medical-plan-container.plan-container-fill > app-current-plan > div > div.no-plan-message"));
        softAssert.assertEquals(containerText.getText(),"No Current Medical Plan");
        softAssert.assertFalse(basicActions.waitForElementPresence(currentMedPlanSummaryContainer,5));
        softAssert.assertAll();
    }

    public void validateTheTextOfTheDentalNoPolicyPlanSummary() {
        basicActions.waitForElementListToBePresent(currentMedicalDentalPlan,60);
        softAssert.assertEquals(currentMedicalDentalPlan.get(1).getText(), "Current Dental Plan:");
        WebElement containerText = basicActions.getDriver().findElement(By.cssSelector("div.dental-plan-container.plan-container-fill > app-current-plan > div > div.no-plan-message"));
        softAssert.assertEquals(containerText.getText(),"No Current Dental Plan");
        softAssert.assertFalse(basicActions.waitForElementPresence(currentDentPlanSummaryContainer,5));
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
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(selectPolicyDropdownOptions, 90);
        basicActions.waitForElementToBePresentWithRetries(currentMedicalPlanName, 60);
        basicActions.scrollToElement(selectPolicyDropdownOptions);

        selectPolicyDropdownOptions.click();
        basicActions.waitForElementListToBePresentWithRetries(medicalpolicyDropdownOptions, 60);

        for (int i = 0; i < medicalpolicyDropdownOptions.size(); i++) {
            try {
                medicalpolicyDropdownOptions = basicActions.getDriver().findElements(By.xpath("//div[@class='medical-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span"));
                if (medicalpolicyDropdownOptions.isEmpty()) {
                    reopenMedicalDropdown();
                    continue;
                }

                medicalpolicyDropdownOptions.get(i).click();
                basicActions.wait(500);
                basicActions.waitForElementToBePresent(medPolicyStatus, 5);

                String status = medPolicyStatus.getText();
                System.out.println("Policy " + i + " is " + status + " for Medical");
                if (status.equals("Submitted")) {
                    break;
                }
                reopenMedicalDropdown();
            } catch (Exception e) {
                reopenMedicalDropdown();
            }
        }
    }

    private void reopenMedicalDropdown() {
        int retryCount = 0;
        while (retryCount < 3) {
            try {
                basicActions.waitForElementToBePresentWithRetries(selectPolicyDropdownOptions, 60);
                selectPolicyDropdownOptions.click();
                basicActions.wait(50);

                medicalpolicyDropdownOptions = basicActions.getDriver().findElements(By.xpath("//div[@class='medical-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span"));
                if (!medicalpolicyDropdownOptions.isEmpty()) {
                    return;
                }
            } catch (Exception e) {
            }
            retryCount++;
        }
        throw new RuntimeException("Failed to reopen Medical dropdown after 3 attempts.");
    }

    public void selectPlansDenActivePolicy() {
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(selectDentalPolicyDropdownOptions, 60);
        basicActions.waitForElementToBePresentWithRetries(currentDentalPlanName, 60);
        basicActions.scrollToElement(selectDentalPolicyDropdownOptions);

        selectDentalPolicyDropdownOptions.click();
        basicActions.waitForElementListToBePresentWithRetries(dentalpolicyDropdownOptions, 90);

        for (int i = 0; i < dentalpolicyDropdownOptions.size(); i++) {
            try {
                dentalpolicyDropdownOptions = basicActions.getDriver().findElements(By.xpath("//div[@class='dental-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span"));

                if (dentalpolicyDropdownOptions.isEmpty()) {
                    reopenDentalDropdown();
                    continue;
                }

                dentalpolicyDropdownOptions.get(i).click();
                basicActions.wait(500);
                basicActions.waitForElementToBePresent(denPolicyStatus, 5);

                String status = denPolicyStatus.getText();
                System.out.println("Policy " + i + " is " + status + " for Dental");

                if (status.equals("Submitted")) {
                    break;
                }
                reopenDentalDropdown();
            } catch (Exception e) {
                reopenDentalDropdown();
            }
        }
    }

    private void reopenDentalDropdown() {
        int retryCount = 0;
        while (retryCount < 3) {
            try {
                basicActions.waitForElementToBePresentWithRetries(selectDentalPolicyDropdownOptions, 60);
                selectDentalPolicyDropdownOptions.click();
                basicActions.wait(50);

                dentalpolicyDropdownOptions = basicActions.getDriver().findElements(By.xpath("//div[@class='dental-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span"));

                if (!dentalpolicyDropdownOptions.isEmpty()) {
                    return;
                }
            } catch (Exception e) {
            }
            retryCount++;
        }
        throw new RuntimeException("Failed to reopen Dental dropdown after 3 attempts.");
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
        switch (planType) {
            case "Dental":
                basicActions.waitForElementToBePresent(denPlanTypeAlreadyChecked, 10);
                basicActions.scrollToElement(denPlanTypeAlreadyChecked);
                denPlanTypeAlreadyChecked.click();
                Assert.assertFalse(basicActions.waitForElementToBePresent(denPlanTypeAlreadyChecked, 5));
                break;
            case "Medical":
                basicActions.waitForElementToBePresent(medPlanTypeAlreadyChecked, 10);
                basicActions.scrollToElement(medPlanTypeAlreadyChecked);
                medPlanTypeAlreadyChecked.click();
                Assert.assertFalse(basicActions.waitForElementToBePresent(medPlanTypeAlreadyChecked, 5));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }

    public void validateCoverageStartDateErrors() {
        basicActions.waitForElementToBePresent(ValidationError, 100);
        softAssert.assertEquals(ValidationError.getText(), "The coverage start date must be entered within the selected plan year and can not be after the coverage end date.");
        softAssert.assertAll();
    }

    public void validateFinancialStartDateErrors() {
        basicActions.waitForElementToBePresent(ValidationError, 100);
        softAssert.assertEquals(ValidationError.getText(), "The financial start date must be entered within the selected plan year and can not be after the financial end date.");
        softAssert.assertAll();
    }

    public void validateCoverageEndDateErrors() {
        basicActions.waitForElementToBePresent(ValidationError, 100);
        softAssert.assertEquals(ValidationError.getText(), "The coverage end date must be entered within the selected plan year and can not be prior to the coverage start date.");
        softAssert.assertAll();
    }

    public void validateFinancialEndDateErrors() {
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
            for (int i = 0; i < 6; i++) {
                APTCMem.sendKeys(Keys.BACK_SPACE);
            }
            APTCMem.sendKeys(aptcvalue);
            if (SharedData.getPrimaryMember().getMedicalPremiumAmt() != null) {
                SharedData.getPrimaryMember().setMedicalAptcAmt(aptcvalue);
                String totalMedPremiumAfterReduction = String.format("%.2f", Float.parseFloat(SharedData.getPrimaryMember().getMedicalPremiumAmt()) - Float.parseFloat(SharedData.getPrimaryMember().getMedicalAptcAmt()));
                SharedData.getPrimaryMember().setTotalMedAmtAfterReduction(totalMedPremiumAfterReduction);
            }
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
            if (SharedData.getPrimaryMember().getMedicalPremiumAmt() != null) {
                SharedData.getPrimaryMember().setMedicalPremiumAmt(newPremiumAmt);
            }
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

    public void validatePremiumErrors() {
        basicActions.waitForElementToBePresent(PremiumInvalidError, 50);
        softAssert.assertTrue(PremiumInvalidError.isDisplayed());
    }


    public void clickDentalButton() {
        basicActions.waitForElementToBePresent(selectDental, 50);
        selectDental.click();
    }

    public void clickMedicalButton() {
        basicActions.waitForElementToBePresent(selectMedical, 50);
        selectMedical.click();
    }

    public void updateTheMedicalPlanForTheUI() {
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
        SharedData.getManagePlanDentalMedicalPlan().setPlanType("1");
        //set marketing Medical Plan
        basicActions.clickElementWithRetries(currentMedicalPlanName, 50);
        String currentMedPlan = currentMedicalPlanName.getText();
        managePlanDentalMedicalPlan.setPlanMarketingName(currentMedPlan);
        //set Medical Policy Coverage
        String MedPolicyCoverage = pnlMedPolicyCoverage.getText();
        managePlanDentalMedicalPlan.setPolicyCoverageDate(MedPolicyCoverage);

        String pnlMedLatestAppDate = medLatestAppDateUI.getText();
        pnlMedLatestAppDate = basicActions.changeDateFormat(pnlMedLatestAppDate, "MM/dd/yyyy", "yyyy-MM-dd");
        managePlanDentalMedicalPlan.setMedLatestAppDate(pnlMedLatestAppDate);

        String MedFinancialStrDate = pnlMedFinancialStartDate.getText();
        MedFinancialStrDate = basicActions.changeDateFormat(MedFinancialStrDate, "MM/dd/yyyy", "yyyy-MM-dd");
        managePlanDentalMedicalPlan.setMedFinancialStartDate(MedFinancialStrDate);

        String MedFinancialEndDate = pnlMedFinancialEndDate.getText();
        MedFinancialEndDate = basicActions.changeDateFormat(MedFinancialEndDate, "MM/dd/yyyy", "yyyy-MM-dd");
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
        int i = 0;
        List<String> expectedMedMemberDetails = Arrays.asList("No.", "Person ID", "Name", "Date of Birth", "Relationship", "Tobacco");
        List<String> actualMedMemberDetails = new ArrayList<>();
        List<WebElement> selectedTableHeader = null;

        switch (planType) {
            case "Medical":
                selectedTableHeader = medicalMemberDetailsTableHeader;
                break;
            case "Dental":
                selectedTableHeader = dentalMemberDetailsTableHeader;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type: " + planType);
        }

        for (WebElement each : selectedTableHeader) {
            actualMedMemberDetails.add(each.getText());
            if (i == 5) {
                break;
            }
            i++;
        }
        softAssert.assertEquals(expectedMedMemberDetails, actualMedMemberDetails);
        softAssert.assertAll();
    }

    public void validateTheCoverageDetailsTableTitleColumns(String planType) {
        List<String> expectedMedMemberDetails = Arrays.asList("No.", "Coverage Start", "Coverage End", "Status", "Effectuated", "Termination Reason");
        List<String> actualMedCoverageDetails = new ArrayList<>();
        List<WebElement> selectedTableHeader = null;

        switch (planType) {
            case "Medical":
                selectedTableHeader = coverageDetailsTableTableHeader;
                break;
            case "Dental":
                selectedTableHeader = dencoverageDetailsTableTableHeader;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type: " + planType);
        }

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
        List<String> expectedMedMemberDetails = Arrays.asList("No.", "Financial Start", "Financial End", "Premium", "APTC");
        List<String> actualMedCoverageDetails = new ArrayList<>();
        List<WebElement> selectedTableHeader = null;

        switch (planType) {
            case "Medical":
                selectedTableHeader = coverageFinancialTableTableHeader;
                break;
            case "Dental":
                selectedTableHeader = dencoverageFinancialTableTableHeader;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type: " + planType);
        }

        int i = 0;
        for (WebElement each : selectedTableHeader) {
            actualMedCoverageDetails.add(each.getText());
            if (i == 4) {
                break;
            }
            i++;
        }
        softAssert.assertEquals(expectedMedMemberDetails, actualMedCoverageDetails);
        softAssert.assertAll();
    }

    public void updateTheMedicalFinancialDetailsTableForTheUI() {
        managePlanDentalMedicalPlan.setMedFinancialStartFnTable(medFinancialStartDateFNTable.getText());
        managePlanDentalMedicalPlan.setMedFinancialEndFnTable(medFinancialEndDateFNTable.getText());
        managePlanDentalMedicalPlan.setMedPlanPremiumAmtFnTable(medPlanPremiumAmtFnTable.getText());
        managePlanDentalMedicalPlan.setMedPlanAptcAmtFnTable(medAPTCAmtFnTable.getText());

        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);
    }

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
        pnlDENLatestAppDate = basicActions.changeDateFormat(pnlDENLatestAppDate, "MM/dd/yyyy", "yyyy-MM-dd");
        managePlanDentalMedicalPlan.setDenLatestAppDate(pnlDENLatestAppDate);

        String denFinancialStrDate = pnlDenFinancialStartDate.getText();
        denFinancialStrDate = basicActions.changeDateFormat(denFinancialStrDate, "MM/dd/yyyy", "yyyy-MM-dd");
        managePlanDentalMedicalPlan.setDenFinancialStartDate(denFinancialStrDate);

        String denFinancialEndDate = pnlDenFinancialEndDate.getText();
        denFinancialEndDate = basicActions.changeDateFormat(denFinancialEndDate, "MM/dd/yyyy", "yyyy-MM-dd");
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

    public void clickCheckedToSeeOnlyMedicalPlanData(String planType) {
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
            softAssert.assertAll();
        }
    }

    public void validateDataForHIOSID(String hiosIdSTG, String hiosIdQA) {
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(medHiosId.getText(), hiosIdSTG);
        } else {
            softAssert.assertEquals(medHiosId.getText(), hiosIdQA);
        }
        softAssert.assertAll();
    }

    public void iValidateMemberTableDataRowOne(String rowNumberSTG, String personIdDataSTG, String nameSTG, String birthSTG, String relationSTG, String tobaccoSTG, String rowNumberQA, String personIdDataQA, String nameQA, String birthQA, String relationQA, String tobaccoQA) {
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

    public void iValidateMemberTableDataRowTwo(String rowNumberTwoSTG, String personIdDataTwoSTG, String nameTwoSTG, String birthTwoSTG, String relationTwoSTG, String tobaccoTwoSTG, String rowNumberTwoQA, String personIdDataTwoQA, String nameTwoQA, String birthTwoQA, String relationTwoQA, String tobaccoTwoQA) {
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

    public void iValidateCoverageTableDataRowOne(String type, String rowSTG, String coverageStartSTG, String coverageEndSTG, String statusSTG, String effectuatedSTG, String reasonSTG, String rowQA, String coverageStartQA, String coverageEndQA, String statusQA, String effectuatedQA, String reasonQA) {
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

    public void validateCoverageTableDataRowTwo(String type, String rowTwoSTG, String coverageStartRowTwoSTG, String coverageEndRowTwoSTG, String statusRowTwoSTG, String effectuatedRowTwoSTG, String reasonRowTwoSTG, String rowTwoQA, String coverageStartRowTwoQA, String coverageEndRowTwoQA, String statusRowTwoQA, String effectuatedRowTwoQA, String reasonRowTwoQA) {
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

    public void iValidateFinancialTableDataRowOne(String type, String rowSTG, String financialStartSTG, String financialEndSTG, String premiumSTG, String APTCSTG, String rowQA, String financialStartQA, String financialEndQA, String premiumQA, String APTCQA) {
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

    public void validateFinancialTableDataRowTwo(String type, String rowTwoSTG, String financialStartRowTwoSTG, String financialEndRowTwoSTG, String premiumRowTwoSTG, String APTCRowTwoSTG, String rowTwoQA, String financialStartRowTwoQA, String financialEndRowTwoQA, String premiumRowTwoQA, String APTCRowTwoQA) {
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

    public void uncheckMedicalPlanCoCo() {
        basicActions.waitForElementToBePresent(btnMedicalChecked, 20);
        basicActions.scrollToElement(btnMedicalChecked);
        btnMedicalChecked.click();
        softAssert.assertEquals(currentMedicalDentalPlan.size(), 1);
        softAssert.assertAll();
    }

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
        softAssert.assertAll();
    }

    public void validateMakeChangesMedicalButtonNotDisplay() {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 10);
        Assert.assertFalse(basicActions.isElementDisplayed(btnMakeChangeMed, 3));
    }

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

    public void validateTheExpectedEHBErrorMessageIsDisplayed(String expectedErrorMessage) {
        softAssert.assertEquals(aptcEHBError.getText(), expectedErrorMessage, "APTC entered exceeds EHB amount");
        softAssert.assertAll();
    }

    public void validateNoPlanMessageIsDisplayed(String expectedMessage) {
        basicActions.waitForElementToBePresent(noPlanMessage, 30);
        softAssert.assertEquals(noPlanMessage.getText(), expectedMessage, "Select a plan year to view policies");
        softAssert.assertAll();
    }

    public void verifyPlanIDDataMatchesDataInDropDownForSelectedPlan(String planSTG, String planOptionDropDownSTG, String planQA, String planOptionDropDownQA) {
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(planId.getText(), planSTG);
            softAssert.assertEquals(planSelected.getText(), planOptionDropDownSTG);
        } else {
            softAssert.assertEquals(planId.getText(), planQA);
            softAssert.assertEquals(planSelected.getText(), planOptionDropDownQA);
        }
        softAssert.assertAll();
    }

    public void updateTernimationvalue(List<String> memberCount) {
        List<WebElement> terminate = basicActions.getDriver().findElements(By.xpath("//*[@class='member-details-grid-item dropdown']"));
        for (int i = 0; i < memberCount.size(); i++) {
            String[] parts = memberCount.get(i).split(":");
            String terminateReason = parts[1];
            terminate.get(i).click();
            List<WebElement> terminateOption = basicActions.getDriver().findElements(By.xpath("//*[@class='member-details-grid-item dropdown']//div[@class='drop-down-option']"));
            terminateOption.stream().filter(e -> e.getText().equalsIgnoreCase(terminateReason)).forEach(WebElement::click);
        }
    }

    public void verifyFieldIsEditable(String fieldName, int memberList) {
        basicActions.wait(30);
        for (int i = 1; i <= memberList; i++) {
            WebElement actualField = getWebelement(fieldName,i);
            Assert.assertTrue(actualField != null && actualField.isEnabled(), "  Field not editable " + fieldName);
        }
    }

    public void verifyLabelName(List<String> expectedlabelName) {
        basicActions.waitForElementToBePresent(medicalPlanName, 20);
        softAssert.assertTrue(medicalPlanName.isDisplayed(), "Plan label not display");
        softAssert.assertTrue(medCoverageData.getText().contains("Policy Coverage:"), "Coverage label not match");
        List<String> actualLabel = containerTextValidation.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        softAssert.assertEquals(actualLabel, expectedlabelName.subList(0, 13), "label not match for");
        softAssert.assertEquals(medPolicyIdUI.getText(), expectedlabelName.get(13), "label not match for");
        softAssert.assertAll();
    }

    public void verifyDentalPlanNotPresent() {
        Assert.assertTrue(basicActions.waitForElementToDisappear(btnDentalChecked, 10), "Dental button should not be present");
        Assert.assertTrue(basicActions.waitForElementToDisappear(dentalContainer, 10), "Dental container should not be present");
    }

    public void verifyCurrentPolicyDetails(String planType, List<Map<String, String>> expectedValues) {
        for (int i = 0; i < expectedValues.size(); i++) {
            Map<String, String> row = expectedValues.get(i);
            String memberNo = row.get("no");

            if (row.containsKey("coverageStart")) {
                String coverageStartDateValue = row.get("coverageStart");
                verifyMemberCoverageStrtDate(memberNo, coverageStartDateValue, planType);
            }
            if (row.containsKey("coverageEnd")) {
                String coverageEndDateValue = row.get("coverageEnd");
                verifyMemberCoverageEndDate(memberNo, coverageEndDateValue, planType);
            }
            if (row.containsKey("terminationReason")) {
                String terminationReasonValue = row.get("terminationReason");
                verifyMemberTermReason(memberNo, terminationReasonValue, planType);
            }
            if (row.containsKey("financialStart")) {
                String financialStartDateValue = row.get("financialStart");
                verifyMemberFinancialStrtDate(memberNo, financialStartDateValue, planType);
            }
            if (row.containsKey("financialEnd")) {
                String financialEndDateValue = row.get("financialEnd");
                verifyMemberFinancialEndDate(memberNo, financialEndDateValue, planType);
            }
            if (row.containsKey("premium")) {
                String premiumValue = row.get("premium");
                verifyMemberPremium(memberNo, premiumValue, planType);
            }
            if (row.containsKey("aptc")) {
                String aptcValue = row.get("aptc");
                verifyMemberAptc(memberNo, aptcValue, planType);
            }
        }
        softAssert.assertAll();
    }

    public void verifyMemberCoverageStrtDate(String memberNo, String coverageStartDateValue, String planType) {
        String coverageStartDate = parseDate(coverageStartDateValue);

        WebElement coverageStartDateMem = getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']//div[@id='coverageStartDate_" + memberNo + "']"));
        softAssert.assertEquals(coverageStartDateMem.getText(), coverageStartDate, "Coverage Start Date mismatch");
    }

    public void verifyMemberCoverageEndDate(String memberNo, String coverageEndDateValue, String planType) {
        String coverageEndDate = parseDate(coverageEndDateValue);

        WebElement coverageEndDateMem = getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']//div[@id='coverageEndDate_" + memberNo + "']"));
        softAssert.assertEquals(coverageEndDateMem.getText(), coverageEndDate, "Coverage End Date mismatch");
    }

    public void verifyMemberTermReason(String memberNo, String termReasonValue, String planType) {
        WebElement TermReasonMem = getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']//div[@id='terminationReason_" + memberNo + "']"));
        String actualText = termReasonValue;
        actualText = (actualText == null || actualText.trim().isEmpty()) ? "" : actualText;
        softAssert.assertEquals(TermReasonMem.getText(), actualText, "Term Reason mismatch");
    }

    public void verifyMemberFinancialStrtDate(String memberNo, String financialStartDateValue, String planType) {
        String financialStartDates = parseDate(financialStartDateValue);

        WebElement financialStartDateMem = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']//div[@id='financialStartDate_" + memberNo + "']"));
        basicActions.waitForElementToBePresentWithRetries(financialStartDateMem,30);
        softAssert.assertEquals(financialStartDateMem.getText(), financialStartDates, "Financial Start Date mismatch");
    }

    public void verifyMemberFinancialEndDate(String memberNo, String financialEndDateValue, String planType) {
        String financialEndDates = parseDate(financialEndDateValue);

        WebElement financialStartDateMem = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']//div[@id='financialEndDate_" + memberNo + "']"));
        basicActions.waitForElementToBePresentWithRetries(financialStartDateMem,30);
        softAssert.assertEquals(financialStartDateMem.getText(), financialEndDates, "Financial End Date mismatch");
    }

    public void verifyMemberPremium(String memberNo, String premiumValue, String planType) {
        WebElement premiumMem = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']//div[@id='premium_" + memberNo + "']"));
        basicActions.waitForElementToBePresentWithRetries(premiumMem,30);
        softAssert.assertEquals(premiumMem.getText(), premiumValue, "Premium mismatch");
    }

    public void verifyMemberAptc(String memberNo, String aptcValue, String planType) {
        WebElement aptcMem = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']//div[@id='planAPTC_" + memberNo + "']"));
        basicActions.waitForElementToBePresentWithRetries(aptcMem,30);
        softAssert.assertEquals(aptcMem.getText(), aptcValue,"APTC/SES mismatch");
    }

    private String parseDate(String dateValue) {
        if (Character.isLetter(dateValue.charAt(0))) {
            String dateBase = basicActions.getDateBasedOnRequirement(dateValue);
            return basicActions.changeDateFormat(dateBase, "yyyy-MM-dd", "MM/dd/yyyy");
        } else {
            return dateValue;
        }
    }

    public void clickPlanType(String planType) {
        basicActions.waitForElementToBePresent(chkMedical, 60);
        basicActions.waitForElementToBePresent(chkDental, 60);
        switch(planType){
            case "Medical":
                chkMedical.click();
                break;
            case "Dental":
                chkDental.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
        basicActions.wait(250);
    }

    public void verifyPlanTypeNotShow(String planType) {
        basicActions.waitForElementToBePresent(chkMedical, 60);
        basicActions.waitForElementToBePresent(chkDental, 60);

        switch(planType){
            case "Medical":
                softAssert.assertTrue(basicActions.isElementNotDisplayed(currentMedicalHeader), "Medical header is visible");
                softAssert.assertFalse(chkMedical.getAttribute("class").contains("check"), "Medical is checked");
                break;
            case "Dental":
                softAssert.assertTrue(basicActions.isElementNotDisplayed(currentDentalHeader), "Dental header is visible");
                softAssert.assertFalse(chkDental.getAttribute("class").contains("check"), "Dental is checked");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
        softAssert.assertAll();
    }

    public void verifyPlanTypeShow(String planType) {
        basicActions.waitForElementToBePresent(chkMedical, 60);
        basicActions.waitForElementToBePresent(chkDental, 60);

        switch(planType){
            case "Medical":
                softAssert.assertTrue(basicActions.isElementDisplayed(currentMedicalHeader,60), "Medical header is visible");
                softAssert.assertTrue(chkMedical.getAttribute("class").contains("check"), "Medical is not checked");
                break;
            case "Dental":
                softAssert.assertTrue(basicActions.isElementDisplayed(currentDentalHeader,60), "Dental header is visible");
                softAssert.assertTrue(chkDental.getAttribute("class").contains("check"), "Dental is not checked");
                break;
            case "Both":
                softAssert.assertTrue(basicActions.isElementDisplayed(currentMedicalHeader,60), "Medical header is visible");
                softAssert.assertTrue(chkMedical.getAttribute("class").contains("check"), "Medical is not checked");
                softAssert.assertTrue(basicActions.isElementDisplayed(currentDentalHeader,60), "Dental header is visible");
                softAssert.assertTrue(chkDental.getAttribute("class").contains("check"), "Dental is not checked");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
        softAssert.assertAll();
    }

    public void verifyPlanNameAndPolicyCoverageDisplayed(String planType) {
        switch (planType) {
            case "medical_and_dental":
                basicActions.wait(600);
                softAssert.assertTrue(labelPlanNameForMedAndDen.get(0).isDisplayed(), "Plan name not visible for medical");
                softAssert.assertTrue(labelCoverageForMedAndDen.get(0).getText().contains("Policy Coverage:"), "Policy coverage not visible for medical");
                softAssert.assertTrue(labelPlanNameForMedAndDen.get(1).isDisplayed(), "Plan name not visible for dental");
                softAssert.assertTrue(labelCoverageForMedAndDen.get(1).getText().contains("Policy Coverage:"), "Policy coverage not visible for dental");
                softAssert.assertAll();
                break;
            case "only_medical", "only_dental":
                basicActions.wait(600);
                softAssert.assertTrue(labelPlanNameForMedAndDen.get(0).isDisplayed(), "Plan name not visible for medical or dental");
                softAssert.assertTrue(labelCoverageForMedAndDen.get(0).getText().contains("Policy Coverage:"), "Policy coverage not visible for medical or dental");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }

    public void verifyAllPageTextsMedicalAndDentalPlan(String opt, List<String> pageTexts) {
        switch (opt) {
            case "medical_and_dental":
                verifyLabelContainerMedicalOrDental(pageTexts);
                for (int i = 0; i < pageTexts.size() - 1; i++) {
                    softAssert.assertEquals(containerTextValidation.get(i + 13).getText().trim(), pageTexts.get(i), "Container Label " + i + " text not matching");
                }
                softAssert.assertEquals(labelPolicyIdForMedAndDen.get(1).getText().trim(), pageTexts.get(pageTexts.size() - 1),"Policy ID not visible");
                softAssert.assertAll();
                break;
            case "only_medical","only_dental":
                verifyLabelContainerMedicalOrDental(pageTexts);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + opt);
        }
    }

    public void validateMemberDetailsColumnNamesAndStyle(String planType, List<String> expectedMedMemberDetails ) {
        List<String> actualMedCoverageDetails= new ArrayList<>();
        List<WebElement> selectedTableHeader = null;
        int i=0;
        selectedTableHeader = switch (planType.toLowerCase()) {
            case "medical" -> medicalMemberDetailsTableHeader;
            case "dental" -> dentalMemberDetailsTableHeader;
            default -> throw new IllegalArgumentException("Invalid plan type: " + planType);
        };

        for (WebElement each : selectedTableHeader) {
            actualMedCoverageDetails.add(each.getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for "+currentMedicalDentalPlan.get(0).getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("font"), "700 16px / 24px \"PT Sans\"","font not match for "+currentMedicalDentalPlan.get(0).getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("font-weight"), "700","font not match for "+currentMedicalDentalPlan.get(0).getText());
            if(i==5){
                break;
            }
            i++;
        }
        softAssert.assertEquals(actualMedCoverageDetails,expectedMedMemberDetails, "Member Table Label not match  ");
        softAssert.assertAll();
    }

    public void validateFinancialDetailsColumnNamesAndStyle(String planType, List<String> expectedMedMemberDetails ) {
        List<String> actualMedCoverageDetails= new ArrayList<>();
        List<WebElement> selectedTableHeader = null;
        int i=0;
        selectedTableHeader = switch (planType) {
            case "medical" -> coverageFinancialTableTableHeader;
            case "Dental" -> dencoverageFinancialTableTableHeader;
            default -> throw new IllegalArgumentException("Invalid plan type: " + planType);
        };

        for (WebElement each : selectedTableHeader) {
            actualMedCoverageDetails.add(each.getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for "+currentMedicalDentalPlan.get(0).getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("font"), "700 16px / 24px \"PT Sans\"","font not match for "+currentMedicalDentalPlan.get(0).getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("font-weight"), "700","font not match for "+currentMedicalDentalPlan.get(0).getText());
            if(i==4){
                break;
            }
            i++;
        }
        softAssert.assertEquals(actualMedCoverageDetails,expectedMedMemberDetails, "Member Table Label not match  ");
        softAssert.assertAll();
    }

    public void validateCoverageDetailsColumnNamesAndStyle(String planType, List<String> expectedMedMemberDetails ) {
        List<String> actualMedCoverageDetails= new ArrayList<>();
        List<WebElement> selectedTableHeader = null;
        int i=0;
        selectedTableHeader = switch (planType) {
            case "medical" -> medCoverageColumnHeader;
            case "Dental" -> dencoverageDetailsTableTableHeader;
            default -> throw new IllegalArgumentException("Invalid plan type: " + planType);
        };

        for (WebElement each : selectedTableHeader) {
            actualMedCoverageDetails.add(each.getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for "+currentMedicalDentalPlan.get(0).getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("font"), "700 16px / 24px \"PT Sans\"","font not match for "+currentMedicalDentalPlan.get(0).getText());
            softAssert.assertEquals(selectedTableHeader.get(i).getCssValue("font-weight"), "700","font not match for "+currentMedicalDentalPlan.get(0).getText());
            if(i==5){
                break;
            }
            i++;
        }
        softAssert.assertEquals(actualMedCoverageDetails,expectedMedMemberDetails, "Member Table Label not match  ");
        softAssert.assertAll();
    }

    public void validateStyleProperties() {
        validateInformationContainerStyle();
        validateColoradoConnectStyle();
        validateAdminPortalStyle();
        validatePlanYearsStyle();
        validateManagePlansStyle();
        validateSelectPlansStyle();
        validateMedicalCheckboxStyle();
        validateCurrentContainerStyle();
        validateCurrentMedicalPlanStyle();
        validateSelectAPolicyStyle();
    }
    private void validateSelectAPolicyStyle() {
        softAssert.assertEquals(selectPolicyLabel.getText(),"Select a policy:", "Header Text not match for " +selectPolicyLabel.getText());
        softAssert.assertEquals(selectPolicyLabel.getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for "+selectPolicyLabel.getText());
        softAssert.assertEquals(selectPolicyLabel.getCssValue("font"), "16px / 24px \"PT Sans\"","font not match for "+selectPolicyLabel.getText());
        softAssert.assertEquals(selectPolicyLabel.getCssValue("font-weight"), "400","font not match for "+selectPolicyLabel.getText());
        softAssert.assertAll();
    }

    private void validateCurrentMedicalPlanStyle() {
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getText(),"Current Medical Plan:", "Header Text not match for " +currentMedicalDentalPlan.get(0).getText());
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for "+currentMedicalDentalPlan.get(0).getText());
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getCssValue("font"), "700 28px / 24px \"PT Sans\"","font not match for "+currentMedicalDentalPlan.get(0).getText());
        softAssert.assertAll();
    }

    private void validateCurrentContainerStyle() {
        softAssert.assertEquals(currentplancontainer.getCssValue("background-color"),"rgba(226, 241, 248, 1)", "Header Text not match for  Current medical plan");
        softAssert.assertEquals(currentplancontainer.getCssValue("border-top-color"), "rgba(26, 112, 179, 1)","Top border color not match for Current medical plan container " );
        softAssert.assertEquals(currentplancontainer.getCssValue("border-bottom-color"), "rgba(26, 112, 179, 1)","bottom border color not match for Current medical plan container " );
        softAssert.assertEquals(currentplancontainer.getCssValue("border-left-color"), "rgba(26, 112, 179, 1)","Left border color not match for Current medical plan container " );
        softAssert.assertEquals(currentplancontainer.getCssValue("border-right-color"), "rgba(26, 112, 179, 1)","Right border color not match for Current medical plan container " );
        softAssert.assertAll();
    }

    private void validateMedicalCheckboxStyle() {
        softAssert.assertEquals(chkMedical.getText(),"Medical", "Header Text not match for " +chkMedical.getText());
        softAssert.assertEquals(chkMedical.getCssValue("color"), "rgba(255, 255, 255, 1)","Text color not match for  "+chkMedical.getText());
        softAssert.assertEquals(chkMedical.getCssValue("font"), "700 16px / 24px \"PT Sans\", sans-serif","font not match for  "+chkMedical.getText());
        softAssert.assertAll();
    }

    private void validateSelectPlansStyle() {
        softAssert.assertEquals(txtSelectPlanType.getText(),"Select plan type:", "Header Text not match for "+txtSelectPlanType.getText());
        softAssert.assertEquals(txtSelectPlanType.getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for " +txtSelectPlanType.getText());
        softAssert.assertEquals(txtSelectPlanType.getCssValue("font"), "16px / 24px \"PT Sans\", sans-serif","font not match for "+txtSelectPlanType.getText());
        softAssert.assertEquals(txtSelectPlanType.getCssValue("font-weight"), "400","style size not match for "+txtSelectPlanType.getText());
        softAssert.assertAll();
    }

    private void validateManagePlansStyle() {
        softAssert.assertEquals(txtTitleManagePlans.getText(),"Manage Plans", "Header Text not match for " +txtTitleManagePlans.getText());
        softAssert.assertEquals(txtTitleManagePlans.getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for  "+txtTitleManagePlans.getText());
        softAssert.assertEquals(txtTitleManagePlans.getCssValue("font"), "700 28px / 24px \"PT Sans\"","font not match for "+txtTitleManagePlans.getText());
        softAssert.assertAll();
    }

    private void validatePlanYearsStyle() {
        softAssert.assertEquals(txtSelectPlanYear.getText(), "Select a plan year:", "Text not match for "+ txtSelectPlanYear.getText());
        softAssert.assertEquals(planYearLabel.getText(), "Year:"," Text not match for "+ planYearLabel.getText());
        softAssert.assertEquals(dpdCurrentYearMP.getText(),"2023", "Header Text not match for " +dpdCurrentYearMP.getText());
        softAssert.assertEquals(dpdCurrentYearMP.getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for " +dpdCurrentYearMP.getText());
        softAssert.assertEquals(dpdCurrentYearMP.getCssValue("font"), "16px / 24px \"PT Sans\", sans-serif","font not match for "+dpdCurrentYearMP.getText());
        softAssert.assertEquals(dpdCurrentYearMP.getCssValue("font-weight"), "400","style size not match for "+dpdCurrentYearMP.getText());
        softAssert.assertAll();
    }

    private void validateAdminPortalStyle() {
        softAssert.assertEquals(titleInBlueBar.getText(), "Admin Portal", "Header Text not match for " + titleInBlueBar.getText());
        softAssert.assertEquals(titleInBlueBar.getCssValue("color"), "rgba(255, 255, 255, 1)", "Text color not match for " + titleInBlueBar.getText());
        softAssert.assertEquals(titleInBlueBar.getCssValue("font"), "700 18px \"PT Sans\", sans-serif", "Text color not match for  " + titleInBlueBar.getText());
        softAssert.assertAll();
    }

    private void validateColoradoConnectStyle() {
        softAssert.assertEquals(CocoTitle.getText(),"Colorado Connect", "Header Text not match for " +CocoTitle.getText());
        softAssert.assertEquals(CocoTitle.getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for  " +CocoTitle.getText());
        softAssert.assertEquals(CocoTitle.getCssValue("font"), "36px / 43.2px \"PT Sans\"","Text color not match for  " +CocoTitle.getText());
        softAssert.assertEquals(CocoTitle.getCssValue("font-weight"), "400","style size not match for  " +CocoTitle.getText());
        softAssert.assertAll();
    }

    private void validateInformationContainerStyle() {
        softAssert.assertEquals(mPlansContainer.getCssValue("background-color"), "rgba(255, 255, 255, 1)","Background not match for Container" );
        softAssert.assertEquals(mPlansContainer.getCssValue("border-top-color"), "rgba(149, 192, 60, 1)","Top border color not match for container " );
        softAssert.assertAll();
    }

    private void verifyLabelContainerMedicalOrDental(List<String> pageTexts) {
        basicActions.wait(1000);
        for (int i = 0; i < pageTexts.size() - 1; i++) {
            softAssert.assertEquals(containerTextValidation.get(i).getText().trim(), pageTexts.get(i), "Container Label " + i + " text not matching");
        }
        softAssert.assertEquals(labelPolicyIdForMedAndDen.get(0).getText().trim(), pageTexts.get(13),"Policy ID not visible");
        softAssert.assertAll();
    }

    public void clickOnSelectPlanType(String btnName) {
        switch (btnName) {
            case "Medical":
                Assert.assertTrue(basicActions.waitForElementToBePresent(medPlanTypeUnChecked, 5), "Medical check box already checked");
                medPlanTypeUnChecked.click();
                break;
            case "Dental":
                Assert.assertTrue(basicActions.waitForElementToBePresent(denPlanTypeUnChecked, 5), "Dental check box already checked");
                denPlanTypeUnChecked.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + btnName);
        }
    }

    public void verifyHeaderText(List<String> pageTexts) {
        basicActions.wait(800);
        softAssert.assertTrue(labelHeader1.getText().contains(pageTexts.get(0)), "Header 1 not visible");
        softAssert.assertTrue(labelHeader2.getText().contains(pageTexts.get(1)), "Header 2 not visible");
        softAssert.assertAll();
    }

    public void verifyTextSelectPlanYearDD(List<String> pageTexts) {
        basicActions.waitForElementToBePresent(txtAlreadySelectedYearOption, 8);
        txtAlreadySelectedYearOption.click();
        softAssert.assertEquals(txtAlreadySelectedYearOption.getText().trim(), pageTexts.get(0), "Already selected option text mismatch");
        for (int i = 0; i < pageTexts.size() - 1; i++) {
            softAssert.assertEquals(txtSecondaryYearOption.get(i).getText().trim(), pageTexts.get(i + 1), "Secondary Option" + i + " not matching");
        }
        softAssert.assertAll();
        txtAlreadySelectedYearOption.click();
    }
    public void verifyFontColorEtcOfContainerElements(){
        basicActions.wait(700);
        softAssert.assertEquals(managePlansContainer.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "Container-back ground Color mismatching");
        softAssert.assertEquals(managePlansContainer.getCssValue("border-top-color"), "rgba(149, 192, 60, 1)", "Container-border top Color mismatching");
        softAssert.assertEquals(txtTitleManagePlans.getCssValue("font-family"), "\"PT Sans\"", "txtTitleManagePlans-Font family mismatch");
        softAssert.assertEquals(txtTitleManagePlans.getCssValue("font-size"), "28px", "txtTitleManagePlans-Font size mismatch");
        softAssert.assertEquals(txtTitleManagePlans.getCssValue("color"), "rgba(77, 77, 79, 1)", "txtTitleManagePlans-Color mismatch");
        softAssert.assertEquals(medPlanTypeUnChecked.getCssValue("font-family"), "\"PT Sans\"", "medPlanTypeUnChecked-Font family mismatch");
        softAssert.assertEquals(medPlanTypeUnChecked.getCssValue("font-size"), "16px", "medPlanTypeUnChecked-Font size mismatch");
        softAssert.assertEquals(medPlanTypeUnChecked.getCssValue("color"), "rgba(77, 77, 79, 1)", "medPlanTypeUnChecked-Color mismatch");
        softAssert.assertEquals(denPlanTypeUnChecked.getCssValue("font-family"), "\"PT Sans\"", "denPlanTypeUnChecked-Font family mismatch");
        softAssert.assertEquals(denPlanTypeUnChecked.getCssValue("font-size"), "16px", "denPlanTypeUnChecked-Font size mismatch");
        softAssert.assertEquals(denPlanTypeUnChecked.getCssValue("color"), "rgba(77, 77, 79, 1)", "denPlanTypeUnChecked-Color mismatch");
        softAssert.assertAll();
    }
    public void verifyFontColorEtcOfMedicalOrDentalPlanContainer(){
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getCssValue("font-family"), "\"PT Sans\"", "currentMedicalDentalPlan-Font family mismatch");
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getCssValue("font-size"), "28px", "currentMedicalDentalPlan-Font size mismatch");
        softAssert.assertEquals(currentMedicalDentalPlan.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)", "currentMedicalDentalPlan-Color mismatch");
        softAssert.assertEquals(label_SelectAPolicy.getCssValue("font-family"), "\"PT Sans\"", "label_SelectAPolicy-Font family mismatch");
        softAssert.assertEquals(label_SelectAPolicy.getCssValue("font-size"), "16px", "label_SelectAPolicy-Font size mismatch");
        softAssert.assertEquals(label_SelectAPolicy.getCssValue("color"), "rgba(77, 77, 79, 1)", "label_SelectAPolicy-Color mismatch");
        softAssert.assertEquals(currentPlanContainer.getCssValue("background-color"), "rgba(226, 241, 248, 1)", "currentPlanContainer-back ground Color mismatching");
        softAssert.assertEquals(currentPlanContainer.getCssValue("border"), "1px solid rgb(26, 112, 179)", "currentPlanContainer-border mismatch");
        verifyColorFontFamilyOfTableContainer();
        softAssert.assertAll();

    }
    private void verifyColorFontFamilyOfTableContainer(){
        for (int i=0;i<containerTableCols1.size();i++){
            if (i == 5) {
                continue;
            }
            softAssert.assertEquals(containerTableCols1.get(i).getCssValue("font-family"), "\"PT Sans\"", "containerTableCols1 "+i+"-Font family mismatch");
            softAssert.assertEquals(containerTableCols1.get(i).getCssValue("font-size"), "16px", "containerTableCols1 "+i+"-Font size mismatch");
            softAssert.assertEquals(containerTableCols1.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)", "containerTableCols1 "+i+"-Color mismatch");
        }
        for (int i=1;i<containerTableCols2.size();i++){
            softAssert.assertEquals(containerTableCols2.get(i).getCssValue("font-family"), "\"PT Sans\"", "containerTableCols2 "+i+"-Font family mismatch");
            softAssert.assertEquals(containerTableCols2.get(i).getCssValue("font-size"), "16px", "containerTableCols2 "+i+"-Font size mismatch");
            softAssert.assertEquals(containerTableCols2.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)", "containerTableCols2 "+i+"-Color mismatch");
        }
        softAssert.assertAll();
    }

    public void verifyPrevious_Financial_PeriodsMedicalTexts(List<String> pageTexts) {
        basicActions.scrollToElement(labelPlanNamePFPM);
        softAssert.assertTrue(labelPlanNamePFPM.isDisplayed(),"labelPlanNamePFPM is not displayed");
        softAssert.assertTrue(labelPolicyCoveragePFPM.isDisplayed(),"labelPolicyCoveragePFPM is not displayed");
        for (int i = 0; i < pageTexts.size(); i++) {
            softAssert.assertEquals(allLabelsPFPM.get(i).getText().trim(), pageTexts.get(i), "allLabelsPFPMContainer " + i + " text mismatch");
        }
        softAssert.assertAll();
    }
    public void verifyGreenBarBetweenTwoFinancialPeriods(){
        softAssert.assertTrue(greenBar_financialPeriod.get(0).isDisplayed(),"greenBar_financialPeriod is not displayed");
        softAssert.assertTrue(greenBar_financialPeriod.size()>1,"greenBar_financialPeriod is not greater than 1");
        softAssert.assertEquals(greenBar_financialPeriod.get(0).getCssValue("background-color"), "rgba(230, 243, 216, 1)", "greenBar_financialPeriod-back ground Color mismatching");
        softAssert.assertEquals(greenBar_financialPeriod.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif", "(greenBar_financialPeriod-Font family mismatch");
        softAssert.assertEquals(greenBar_financialPeriod.get(0).getCssValue("font-size"), "16px", "greenBar_financialPeriod-Font size mismatch");
        softAssert.assertEquals(greenBar_financialPeriod.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)", "greenBar_financialPeriod-Color mismatch");
        softAssert.assertAll();
    }
    public void verifyExpandAndCollapsesWithinThePFP(){
        int allShowFinancialPeriodInfoLabel=labelShowFinancialPeriod.size();
        softAssert.assertTrue(allShowFinancialPeriodInfoLabel>0,"All financial periods not expanded");
        for (WebElement element : chevronPreviousPlanDetail) {
            element.click();
            allShowFinancialPeriodInfoLabel = allShowFinancialPeriodInfoLabel - 1;
        }
        softAssert.assertEquals(allShowFinancialPeriodInfoLabel,0,"All financial periods not collapsed");
        softAssert.assertAll();
    }

    public void validatePreviousFinancialStyleProperties() {
        validateInformationContainerStyle();
        validateColoradoConnectStyle();
        validateAdminPortalStyle();
        validatePlanYearsStyle();
        validateManagePlansStyle();
        validateSelectPlansStyle();
        validateMedicalCheckboxStyle();
        validatePreviousFinancialContainerStyle();
        validatePreviousFinancialHeaderStyle();
    }

    private void validatePreviousFinancialHeaderStyle() {
        softAssert.assertEquals(previousMedicalContainer.getText(),"Previous Financial Periods - Medical", "Header Text not match for " +previousMedicalContainer.getText());
        softAssert.assertEquals(previousMedicalContainer.getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for "+previousMedicalContainer.getText());
        softAssert.assertEquals(previousMedicalContainer.getCssValue("font"), "700 28px / 24px \"PT Sans\"","font not match for "+previousMedicalContainer.getText());
        softAssert.assertAll();
    }

    private void validatePreviousFinancialContainerStyle() {
        softAssert.assertEquals(previousFinancialContainer.getCssValue("background-color"),"rgba(226, 241, 248, 1)", "Header Text not match for financial year");
        softAssert.assertEquals(previousFinancialContainer.getCssValue("border-top-color"), "rgba(26, 112, 179, 1)","Top border color not match for financial container " );
        softAssert.assertEquals(previousFinancialContainer.getCssValue("border-bottom-color"), "rgba(26, 112, 179, 1)","bottom border color not match for financial container " );
        softAssert.assertEquals(previousFinancialContainer.getCssValue("border-left-color"), "rgba(26, 112, 179, 1)","Left border color not match for financial container " );
        softAssert.assertEquals(previousFinancialContainer.getCssValue("border-right-color"), "rgba(26, 112, 179, 1)","Right border color not match for financial container " );
        softAssert.assertAll();
    }
    public void verifyGreenBarForMoreFinancialPeriods(){
        String expectedText = "Financial Period \\d{2}/\\d{2}/\\d{4} - \\d{2}/\\d{2}/\\d{4}";
        for (int i = 0; i<greenBar_financialPeriod.size() ; i++) {
            softAssert.assertTrue(greenBar_financialPeriod.get(i).isDisplayed(),"greenBar_financialPeriod is not displayed");
            softAssert.assertEquals(greenBar_financialPeriod.get(0).getCssValue("background-color"), "rgba(230, 243, 216, 1)", "greenBar_financialPeriod-back ground Color mismatching");
            softAssert.assertTrue(greenBarHeader.get(i).getText().matches(expectedText),"Header Text not match for " +greenBarHeader.get(i).getText());
            softAssert.assertEquals(greenBarHeader.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)","Text color not match for green bar header");
            softAssert.assertEquals(greenBarHeader.get(i).getCssValue("font"), "700 19px / 24px \"PT Sans\"","font not match for green bar header");
        }
        softAssert.assertAll();
    }
    public void verifyPreviousFinanicalLabel(List<String> expectedlabelName) {
        basicActions.waitForElementToBePresent(medicalPlanName, 20);
        softAssert.assertTrue(labelPlanNamePFPM.isDisplayed(),"labelPlanNamePFPM is not displayed");
        softAssert.assertTrue(labelPolicyCoveragePFPM.isDisplayed(),"labelPolicyCoveragePFPM is not displayed");
        softAssert.assertTrue(labelPolicyCoveragePFPM.getText().contains("Policy Coverage:"), "Coverage label not match");
        List<String> actualLabelList = previousFinancialLabel.stream().map(WebElement::getText)
                .toList();
        List<String> actualLabel = actualLabelList.subList(0,actualLabelList.size()-1);

        softAssert.assertEquals(actualLabel, expectedlabelName.subList(0, 11), "label not match for");
        softAssert.assertEquals(previousFinancialPolicyLabel.getText(), expectedlabelName.get(11), "label not match for");
        softAssert.assertAll();
    }

    public void selectFinancialPeriod(String planType, Integer policyNumber) {
        basicActions.waitForElementListToBePresent(labelShowFinancialPeriod, 30);
        List<WebElement> showFinancialPeriodBtn= basicActions.getDriver().findElements(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container']//button[@id='Manage Plans-Show Financial Period']"));
        int indexPolicyNumber = policyNumber - 1;
        showFinancialPeriodBtn.get(indexPolicyNumber).click();
    }

    public void verifyMedicalPlanText(){
        basicActions.waitForElementToBePresent(labelInRedMedicalPlan,10);
        softAssert.assertEquals(labelInRedMedicalPlan.getText().trim(),"Medical Plan:","Medical Plan text mismatch");
        softAssert.assertEquals(labelInRedMedicalPlan.getCssValue("color"), "rgba(255, 0, 0, 1)", "labelInRedMedicalPlan-Color mismatch");
        softAssert.assertAll();
    }

    public void verifyOneContainerForMedicalPlansDisplayedInsteadOfCurrentAndPreviousSections(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(currentPlanContainer,5),"No current medical plan container");
        softAssert.assertFalse(basicActions.waitForElementToBePresent(previousFinancialMed, 5),"previousFinancialMed is visible");
        softAssert.assertAll();
    }

    public void selectPolicyPlanFromDDByVisibleText(String policyName) {
        basicActions.waitForElementToBePresent(selectPolicyDropdownOptions, 10);
        selectPolicyDropdownOptions.click();
        WebElement policyEle = getDriver().findElement(By.xpath("//span[contains(@id,'option') and contains(text(),'" + policyName + "')]"));
        policyEle.click();
    }
    public void VerifyMemberTwoShowsTwiceInCoverageAndFinancialDetailsTables(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(labelCoverageDetailsGridItems.get(6),5),"Member 2 not present-1st time");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(labelCoverageDetailsGridItems.get(18),5),"Member 2 not present-2nd time");
        softAssert.assertEquals(labelCoverageDetailsGridItems.get(6).getText().trim(),labelCoverageDetailsGridItems.get(18).getText().trim(),"Coverage Details Row 1 and Row 3 data not matching");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(labelFinancialDetailsGridItems.get(5),5),"Member 2 not present-1st time");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(labelFinancialDetailsGridItems.get(15),5),"Member 2 not present-2nd time");
        softAssert.assertEquals(labelFinancialDetailsGridItems.get(5).getText().trim(),labelFinancialDetailsGridItems.get(15).getText().trim(),"Financial Details Row 1 and Row 3 data not matching");
        softAssert.assertAll();
    }

    public void verifyPlanDetails(List<String> data) {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 20);
        softAssert.assertEquals(txtTitleManagePlans.getText(), data.get(0));
        basicActions.waitForElementListToBePresent(labelPlanNameForMedAndDen, 20);
        softAssert.assertEquals(labelPlanNameForMedAndDen.get(0).getText(), data.get(1));
        softAssert.assertEquals(labelPlanNameForMedAndDen.get(1).getText(), data.get(2));
        softAssert.assertAll();
    }
    public void verifyPreviousFinancialPeriodsDentalColorSizeEtc(){
        softAssert.assertEquals(previousMedicalContainer.getCssValue("font-family"), "\"PT Sans\"", "previousMedicalDentalHeading-Font family mismatch");
        softAssert.assertEquals(previousMedicalContainer.getCssValue("font-size"), "28px", "previousMedicalDentalHeading-Font size mismatch");
        softAssert.assertEquals(previousMedicalContainer.getCssValue("color"), "rgba(77, 77, 79, 1)", "previousMedicalDentalHeading-Color mismatch");
        softAssert.assertAll();
    }
    public void verifyColorBorderOfPreviousFinancialPeriodsDentalContainerAndAllColumnsInsideContainer(){
        softAssert.assertEquals(previousFinancialContainer.getCssValue("background-color"), "rgba(226, 241, 248, 1)", "previousFinancialContainer-back ground Color mismatching");
        softAssert.assertEquals(previousFinancialContainer.getCssValue("border"), "1px solid rgb(26, 112, 179)", "previousFinancialContainer-border mismatch");
        verifyAllColumnsSizeColorETCOfPFPDentalContainer();
        softAssert.assertAll();
    }
    public void verifyAllColumnsSizeColorETCOfPFPDentalContainer(){
        List<WebElement> firstTenElements=PreviousFinancialPeriodsDentalContainerTable1Cols1.stream().limit(10).toList();
        for (int i=0;i<firstTenElements.size();i++){
            softAssert.assertEquals(PreviousFinancialPeriodsDentalContainerTable1Cols1.get(i).getCssValue("font-family"), "\"PT Sans\"", "PreviousFinancialPeriodsDentalContainerTable1Cols1 "+i+"-Font family mismatch");
            softAssert.assertEquals(PreviousFinancialPeriodsDentalContainerTable1Cols1.get(i).getCssValue("font-size"), "16px", "PreviousFinancialPeriodsDentalContainerTable1Cols1 "+i+"-Font size mismatch");
            softAssert.assertEquals(PreviousFinancialPeriodsDentalContainerTable1Cols1.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)", "PreviousFinancialPeriodsDentalContainerTable1Cols1 "+i+"-Color mismatch");
        }
        List<WebElement> firstSixElements=PreviousFinancialPeriodsDentalContainerTable1Cols2.stream().limit(6).toList();
        for (int i=1;i<firstSixElements.size();i++){
            softAssert.assertEquals(PreviousFinancialPeriodsDentalContainerTable1Cols2.get(i).getCssValue("font-family"), "\"PT Sans\"", "PreviousFinancialPeriodsDentalContainerTable1Cols2 "+i+"-Font family mismatch");
            softAssert.assertEquals(PreviousFinancialPeriodsDentalContainerTable1Cols2.get(i).getCssValue("font-size"), "16px", "PreviousFinancialPeriodsDentalContainerTable1Cols2 "+i+"-Font size mismatch");
            softAssert.assertEquals(PreviousFinancialPeriodsDentalContainerTable1Cols2.get(i).getCssValue("color"), "rgba(77, 77, 79, 1)", "PreviousFinancialPeriodsDentalContainerTable1Cols2 "+i+"-Color mismatch");
        }
        softAssert.assertAll();
    }
    public void validateGreenBackGroundAndWhiteTextOfMedical_or_dentalButtonWhenChecked(String btnType){
        basicActions.scrollToElement(btnMedicalOrDentalWhenChecked);
        switch (btnType){
            case "Dental":
                softAssert.assertEquals(btnMedicalOrDentalWhenChecked.getCssValue("background-color"), "rgba(112, 163, 0, 1)", "btnMedicalOrDentalWhenChecked-back ground Color mismatching");
                softAssert.assertEquals(denPlanTypeAlreadyChecked.getCssValue("color"), "rgba(255, 255, 255, 1)", "denPlanTypeAlreadyChecked-Color mismatching");
                softAssert.assertAll();
                break;
            case "Medical":
                softAssert.assertEquals(btnMedicalOrDentalWhenChecked.getCssValue("background-color"), "rgba(112, 163, 0, 1)", "btnMedicalOrDentalWhenChecked-back ground Color mismatching");
                softAssert.assertEquals(medPlanTypeAlreadyChecked.getCssValue("color"), "rgba(255, 255, 255, 1)", "medPlanTypeAlreadyChecked-Color mismatching");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + btnType);
        }
    }
    public void validateWhiteBackGroundAndBlackTextOfButtonOnlyWhenUnchecked(String btnType){
        basicActions.scrollToElement(btnMedicalOrDentalWhenUnchecked);
        switch (btnType){
            case "Dental":
                softAssert.assertEquals(btnMedicalOrDentalWhenUnchecked.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnMedicalOrDentalWhenUnchecked-back ground Color mismatching");
                softAssert.assertEquals(denPlanTypeUnChecked.getCssValue("color"), "rgba(77, 77, 79, 1)", "denPlanTypeUnChecked-Color mismatching");
                softAssert.assertAll();
                break;
            case "Medical":
                softAssert.assertEquals(btnMedicalOrDentalWhenUnchecked.getCssValue("background-color"), "rgba(255, 255, 255, 1)", "btnMedicalOrDentalWhenChecked-back ground Color mismatching");
                softAssert.assertEquals(medPlanTypeUnChecked.getCssValue("color"), "rgba(77, 77, 79, 1)", "medPlanTypeUnChecked-Color mismatching");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + btnType);
        }
    }

    public void selectTermedPolicyBasedOnEndDate(String planType, String expectedValues) {
        basicActions.wait(1000);

        WebElement dropdownElement;
        List<WebElement> dropdownOptions;
        WebElement statusElement;
        WebElement coverageEndDateElement;
        WebElement currentPlanNameElement;
        String dropdownXpath;

        switch (planType.toLowerCase()) {
            case "medical":
                dropdownElement = selectPolicyDropdownOptions;
                dropdownOptions = medicalpolicyDropdownOptions;
                statusElement = medPolicyStatus;
                coverageEndDateElement = coverageEndDateMedTxt;
                currentPlanNameElement = currentMedicalPlanName;
                dropdownXpath = "//div[@class='medical-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span";
                break;

            case "dental":
                dropdownElement = selectDentalPolicyDropdownOptions;
                dropdownOptions = dentalpolicyDropdownOptions;
                statusElement = denPolicyStatus;
                coverageEndDateElement = coverageEndDateDentTxt;
                currentPlanNameElement = currentDentalPlanName;
                dropdownXpath = "//div[@class='dental-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span";
                break;

            default:
                softAssert.fail("Invalid plan type: " + planType);
                return;
        }

        openPolicyDropdownAndWait(dropdownOptions, dropdownElement, currentPlanNameElement);
        boolean found = iterateAndMatchPolicy(dropdownXpath, dropdownElement, statusElement, coverageEndDateElement, currentPlanNameElement, expectedValues, planType);
        softAssert.assertTrue(found, " No " + planType + " policy found matching: " + expectedValues);
        softAssert.assertAll();
    }

    private void openPolicyDropdownAndWait(List<WebElement> policyDropdownOptions, WebElement selectDropdown, WebElement planNameElement) {
        basicActions.waitForElementToBePresentWithRetries(selectDropdown, 60);
        basicActions.waitForElementToBePresentWithRetries(planNameElement, 60);
        basicActions.scrollToElement(selectDropdown);
        selectDropdown.click();
        basicActions.waitForElementListToBePresentWithRetries(policyDropdownOptions, 90);
        basicActions.wait(200);
    }

    private boolean iterateAndMatchPolicy(
            String dropdownXpath,
            WebElement dropdownElement,
            WebElement statusElement,
            WebElement coverageEndDateElement,
            WebElement currentPlanNameElement,
            String expectedValues,
            String planType
    ) {
        String[] parts = expectedValues.split("\\|");
        String expectedDate = basicActions.getDateBasedOnRequirement(parts[0].trim()); // yyyy-MM-dd
        String expectedPlanName = (parts.length > 1) ? parts[1].trim().toLowerCase() : null;

        System.out.println("Looking for CANCELLED policy with end date: " + expectedDate +
                (expectedPlanName != null ? " and plan name: " + expectedPlanName : ""));

        for (int i = 0; i < 10; i++) {
            List<WebElement> options = basicActions.getDriver().findElements(By.xpath(dropdownXpath));

            if (options.isEmpty() || i >= options.size()) {
                System.out.println("No policies listed or index exceeded.");
                break;
            }

            WebElement option = options.get(i);
            String optionText = option.getText().trim();
            System.out.println("Trying option " + i + ": " + optionText);
            option.click();

            basicActions.wait(1000); // Allow time for data to refresh

            basicActions.waitForElementToBePresent(statusElement, 10);
            String status = statusElement.getText().trim();
            String uiEndDate = coverageEndDateElement.getText().trim();
            String formattedDate = basicActions.changeDateFormat(uiEndDate, "MM/dd/yyyy", "yyyy-MM-dd");

            String currentPlanText = currentPlanNameElement.getText().trim().toLowerCase();

            boolean statusOk = status.equalsIgnoreCase("Cancelled") || status.equalsIgnoreCase("Disenroll_submitted");
            boolean endDateMatches = formattedDate.equals(expectedDate);
            boolean planNameMatches = expectedPlanName == null || currentPlanText.contains(expectedPlanName);

            System.out.println("Status: " + status + ", Date: " + formattedDate + ", Plan Name: " + currentPlanText);

            if (statusOk && endDateMatches && planNameMatches) {
                System.out.println("Matching policy found.");
                return true;
            }

            if (!statusOk) System.out.println("Status does not match.");
            if (!endDateMatches) System.out.println("End date does not match.");
            if (!planNameMatches) System.out.println("Plan name does not match.");

            reopenPolicyDropdown(dropdownElement, planType);
        }

        return false;
    }

    private void reopenPolicyDropdown(WebElement dropdownElement, String planType) {
        int retry = 0;
        String xpath = planType.equalsIgnoreCase("Medical")
                ? "//div[@class='medical-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span"
                : "//div[@class='dental-plan-container plan-container-fill']//div[@class='drop-down-secondary-options']//span";

        while (retry < 3) {
            basicActions.waitForElementToBePresentWithRetries(dropdownElement, 60);
            dropdownElement.click();
            basicActions.wait(300); // Wait for the dropdown to appear again
            List<WebElement> options = basicActions.getDriver().findElements(By.xpath(xpath));
            System.out.println("Retry " + retry + ": Reopened " + planType + " dropdown with " + options.size() + " option(s).");

            if (!options.isEmpty()) {
                break;
            }

            retry++;
        }

        if (retry >= 3) {
            System.out.println("Failed to reopen " + planType + " dropdown after 3 retries.");
        }
    }

    public void setPersonIds() {
        basicActions.waitForElementToBePresent(personIdData, 30);
        List<WebElement> memberRows = basicActions.getDriver().findElements(By.xpath("//div[@class='medical-plan-container plan-container-fill']//div[contains(@id, 'firstName_')]"));
        int totalRows = memberRows.size();

        Map<String, String> exchPersonId = new HashMap<>();

        for (int i = 1; i <= totalRows; i++) {
            String firstNameXpath = "//div[@class='medical-plan-container plan-container-fill']//*[@id='firstName_" + i + "']";
            String referenceIdXpath = "//div[@class='medical-plan-container plan-container-fill']//*[@id='referenceId_" + i + "']";

            String fullName = basicActions.getDriver().findElement(By.xpath(firstNameXpath)).getText();
            String firstName = fullName.split(" ")[0];
            String referenceId = basicActions.getDriver().findElement(By.xpath(referenceIdXpath)).getText();

            exchPersonId.put(firstName, referenceId);
        }
        SharedData.setExchPersonId(exchPersonId);
    }

    public void validatePersonIdsUnchanged() {
        Map<String, String> originalIds = SharedData.getExchPersonId();
        setPersonIds();
        Map<String, String> updatedIds = SharedData.getExchPersonId();

        for (Map.Entry<String, String> entry : originalIds.entrySet()) {
            String name = entry.getKey();
            String originalId = entry.getValue();
            String updatedId = updatedIds.get(name);
            if (!originalId.equals(updatedId)) {
                throw new AssertionError("Person ID changed for member '" + name + "': expected " + originalId + ", got " + updatedId);
            }
        }
    }

    public void updateAllEditableFields(DataTable data) {
        List<Map<String, String>> allDataList = data.asMaps();
        String currentEnv = SharedData.getEnv();
        List<Map<String,String>> envBasedData = allDataList.stream().filter(row -> row.get("Env").equals(currentEnv)).toList();

        basicActions.waitForElementToBePresent(coverageStartdate, 60);
        for (int i = 0; i < envBasedData.size(); i++) {
            Map<String, String> membervalue = envBasedData.get(i);
            String memberNo = membervalue.get("Member");
            updateMPEditableTextFields("coverageEndDate" , memberNo ,membervalue.get("Coverage End"));
            updateMPEditableTextFields("coverageStartDate" , memberNo ,membervalue.get("Coverage Start"));
            updateMPEditableTextFields("financialEndDate" , memberNo ,membervalue.get("Financial End"));
            updateMPEditableTextFields("financialStartDate" , memberNo ,membervalue.get("Financial Start"));
            updateMPEditableTextFields("premium" , memberNo ,membervalue.get("Premium"));
            updateMPEditableTextFields("planAPTC" , memberNo ,membervalue.get("APTC"));
            updateReasonFields(i, membervalue.get("Termination Reason"));
        }
    }

    private void updateReasonFields(int i, String terminationReason) {
        List<WebElement> reasonField = basicActions.getDriver().findElements(By.xpath("//*[@class='member-details-grid-item dropdown']"));
        reasonField.get(i).click();
        List<WebElement> terminateOption = basicActions.getDriver().findElements(By.xpath("//*[@class='member-details-grid-item dropdown']//div[@class='drop-down-option']"));
        terminateOption.stream().filter(e -> e.getText().equalsIgnoreCase(terminationReason)).forEach(WebElement::click);
    }

    private void updateMPEditableTextFields(String fieldID,String memberNo, String value) {
        String xpathEnding = ( fieldID.equals("premium") || fieldID.equals("APTC")) ? "//input[@type='text']" : "//input[1]";
        String fieldxpath = "//div[@id ='" + fieldID + "_" + memberNo + "']" + xpathEnding;
        WebElement inputField = basicActions.getDriver().findElement(By.xpath(fieldxpath));
        inputField.clear();
        inputField.sendKeys(value);
    }

    public void verifyMPEditableFields(int memberCount) {
        for (int i = 1; i <= memberCount; i++) {
            coverageEditableFields(i);
            financialEditableFields(i);
        }
    }

    private void coverageEditableFields(int i) {
        WebElement coverageStartDate = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageStartDate_" + i + "']//input"));
        softAssert.assertTrue(coverageStartDate != null && coverageStartDate.isEnabled(), " Coverage start date field not editable ");

        WebElement coverageEndDate = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageEndDate_" + i + "']//input"));
        softAssert.assertTrue(coverageEndDate != null && coverageEndDate.isEnabled(), "  Coverage End date field not editable ");

        String terminate = "//*[@class='member-details-grid-item dropdown']";
        String terminateXpath = terminate + "[" + i + "]";
        WebElement reason = basicActions.getDriver().findElement(By.xpath(terminateXpath));
        softAssert.assertTrue(reason != null && reason.isEnabled(), "  Termination reason field not editable ");
        softAssert.assertAll();
    }

    private void financialEditableFields(int i) {
        WebElement financialStart = basicActions.getDriver().findElement(By.xpath("//div[@id='financialStartDate_" + i + "']//input"));
        softAssert.assertTrue(financialStart != null && financialStart.isEnabled(), "  Financial start date field not editable ");

        WebElement financialEndDate = basicActions.getDriver().findElement(By.xpath("//div[@id='financialEndDate_" + i + "']//input"));
        softAssert.assertTrue(financialEndDate != null && financialEndDate.isEnabled(), "  Financial End date field not editable ");

        WebElement premium= basicActions.getDriver().findElement(By.xpath("//div[@id='premium_" + i + "']//input"));
        softAssert.assertTrue(premium != null && premium.isEnabled(), "   Premium field not editable ");

        WebElement APTC= basicActions.getDriver().findElement(By.xpath("//div[@id='planAPTC_" + i + "']//input"));
        softAssert.assertTrue(APTC != null && APTC.isEnabled(), "  APTC field not editable ");
        softAssert.assertAll();
    }

    public void clickCancelOnConfirm() {
        basicActions.waitForElementToBePresent(cancelBtnOnConfirm, 20);
        cancelBtnOnConfirm.click();
        basicActions.wait(500);
    }
    public void verifyPlanNameAndPolicyCoverageDatesAreVisibleForPreviousFinancialPeriods() {
        basicActions.scrollToElement(labelPlanNamePFPM);
        softAssert.assertTrue(labelPlanNamePFPM.isDisplayed(), "labelPlanNamePFPM is not displayed");
        softAssert.assertTrue(labelPolicyCoveragePFPM.isDisplayed(), "labelPolicyCoveragePFPM is not displayed");
        softAssert.assertAll();
    }

    public void validateDentalFinancialTableDataOnSimplifiedViewOr(String rowSTG, String financialStartSTG, String financialEndSTG, String premiumSTG, String APTCSTG, String rowQA, String financialStartQA, String financialEndQA, String premiumQA, String APTCQA) {
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(rowNumberData.getText(), rowSTG);
            softAssert.assertEquals(denFinancialStartDateFNTable.getText(), financialStartSTG);
            softAssert.assertEquals(denFinancialEndDateFNTable.getText(), financialEndSTG);
            softAssert.assertEquals(denPlanPremiumAmtFnTable.getText(), premiumSTG);
            softAssert.assertEquals(denAPTCAmtFnTable.getText(), APTCSTG);
        } else {
            softAssert.assertEquals(rowNumberData.getText(), rowQA);
            softAssert.assertEquals(denFinancialStartDateFNTable.getText(), financialStartQA);
            softAssert.assertEquals(denFinancialEndDateFNTable.getText(), financialEndQA);
            softAssert.assertEquals(denPlanPremiumAmtFnTable.getText(), premiumQA);
            softAssert.assertEquals(denAPTCAmtFnTable.getText(), APTCQA);
        }
    softAssert.assertAll();
    }


    public void validateFieldValuesNotChanged(String fieldName, DataTable memberDetails) {

        List<Map<String, String>> data = memberDetails.asMaps();

        String currentEnv = SharedData.getEnv();
        List<Map<String, String>> envBasedData = data.stream().filter(row -> row.get("Env").equals(currentEnv)).toList();

        for (int i = 0; i < envBasedData.size(); i++) {
            Map<String, String> details = envBasedData.get(i);
            String memberNo = details.get("Member");
            String value = details.get("Value");
            valueNotChanged(fieldName, value, memberNo);
        }
    }

    private void valueNotChanged(String fieldName, String value, String memberNo) {
        WebElement actualField = null;
        switch (fieldName) {
            case "SES", "APTC":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='planAPTC_" + memberNo + "']"));
                break;
            case "premium":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='premium_" + memberNo + "']"));
                break;
            case "financial end date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='financialEndDate_" + memberNo + "']"));
                break;
            case "financial start date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='financialStartDate_" + memberNo + "']"));
                break;
            case "coverage start date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageStartDate_" + memberNo + "']"));
                break;
            case "coverage end date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageEndDate_" + memberNo + "']"));
                break;
            case "termination reason":
                String terminate = "//*[@class='member-details-grid-item dropdown']";
                String terminateXpath = terminate + "[" + memberNo + "]";
                actualField = basicActions.getDriver().findElement(By.xpath(terminateXpath));
                break;
        }
        softAssert.assertEquals(actualField.getText(), value, "Amount got changed");
        softAssert.assertAll();
    }

    public void updateCopyPasteValue(String fieldName,DataTable memberDetails) {
        basicActions.wait(30);
        List<Map<String, String>> data = memberDetails.asMaps();

        String currentEnv = SharedData.getEnv();
        List<Map<String, String>> envBasedData = data.stream().filter(row -> row.get("Env").equals(currentEnv)).toList();
        JavascriptExecutor js = (JavascriptExecutor) basicActions.getDriver();
        for (int i = 0; i < envBasedData.size(); i++) {
            Map<String, String> details = envBasedData.get(i);
            int memberNo = Integer.parseInt(details.get("Member"));
            String value = details.get("Value");
            WebElement fieldElement = getWebelement(fieldName, memberNo);
            String script = "arguments[0].value = arguments[1];" + // set input field value ( [0] - field = [1] - value (ie, premiumMem.value = "44444.44"')
                    "arguments[0].dispatchEvent( new Event('input'));" + //simulate typing
                    "arguments[0].dispatchEvent( new Event('change'));"; //finalize the value
            js.executeScript(script, fieldElement, value);
        }
    }

    private WebElement getWebelement(String fieldName, int memberNo) {
        WebElement actualField = null;
        switch (fieldName) {
            case "APTC", "SES":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='planAPTC_" + memberNo + "']//input"));
                break;
            case "premium":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='premium_" + memberNo + "']//input"));
                break;
            case "financial end date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='financialEndDate_" + memberNo + "']//input"));
                break;
            case "financial start date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='financialStartDate_" + memberNo + "']//input"));
                break;
            case "coverage start date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageStartDate_" + memberNo + "']//input"));
                break;
            case "coverage end date":
                actualField = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageEndDate_" + memberNo + "']//input"));
                break;
            case "termination reason":
                String terminate = "//*[@class='member-details-grid-item dropdown']";
                String terminateXpath = terminate + "[" + memberNo + "]";
                actualField = basicActions.getDriver().findElement(By.xpath(terminateXpath));
                break;
        }
        return actualField;
    }

    public void validateErrorWithColor(String  data) {
        softAssert.assertEquals(ValidationError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(ValidationError.getText(), data,"Message not match");
        softAssert.assertAll();

    }
    public void validateSESErrorWithColor(DataTable memberDetails) {

        List<Map<String, String>> data = memberDetails.asMaps();

        String currentEnv = SharedData.getEnv();
        List<Map<String, String>> envBasedData = data.stream().filter(row -> row.get("Env").equals(currentEnv)).toList();

        for (int i = 0; i < envBasedData.size(); i++) {
            Map<String, String> details = envBasedData.get(i);
            String SESInvalidAmtErr = details.get("Invalid Message");
            String SESExceedErr = details.get("SES exceed Message");
            basicActions.waitForElementToBePresent(SESInvalidAmtError, 20);
            softAssert.assertEquals(SESInvalidAmtError.getText(), SESInvalidAmtErr, "Message not match");
            softAssert.assertEquals(SESInvalidAmtError.getCssValue("color"), "rgba(150, 0, 0, 1)");
            softAssert.assertEquals(SESExceedError.getText(), SESExceedErr, "Message not match");
            softAssert.assertEquals(SESExceedError.getCssValue("color"), "rgba(150, 0, 0, 1)");

        }
        softAssert.assertAll();
    }




    public void validateSimplifyViewDentalData(String planNameSTG, String policyCoverageSTG, String latestApplicationDateSTG, String planNameQA, String policyCoverageQA, String latestApplicationDateQA) {
        basicActions.switchtoactiveTab();
        basicActions.waitForElementToBePresent(medPlanNameData, 5000);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(dentalPlanName.getText(), planNameSTG);
            softAssert.assertEquals(denCoverageData.getText(), policyCoverageSTG);
            softAssert.assertEquals(denLatestApplicationDateData.getText(), latestApplicationDateSTG);
            softAssert.assertAll();
        } else {
            softAssert.assertEquals(dentalPlanName.getText(), planNameQA);
            softAssert.assertEquals(denCoverageData.getText(), policyCoverageQA);
            softAssert.assertEquals(denLatestApplicationDateData.getText(), latestApplicationDateQA);
            softAssert.assertAll();
        }
    }

    public void validatePremiumNotEnabled( ) {
        List<WebElement> premium = basicActions.getDriver().findElements(By.xpath("//div[@id='planAPTC_']//input"));
        Assert.assertTrue(premium.isEmpty()," premium field should not be editable ");
    }
    public void validateSESNotEnabled( ) {
        List<WebElement> SES = basicActions.getDriver().findElements(By.xpath("//div[@id='planAPTC_']//input"));
        Assert.assertTrue(SES.isEmpty()," premium field should not be editable ");
    }

    public void validateCoverageStartNotEnabled( ) {
        List<WebElement> coverageStart = basicActions.getDriver().findElements(By.xpath("//div[@id='coverageStartDate_']//input"));
        Assert.assertTrue(coverageStart.isEmpty()," Coverage start field should not be editable ");
    }
    public void validateCoverageEndNotEnabled( ) {
        List<WebElement> coverageEnd = basicActions.getDriver().findElements(By.xpath("//div[@id='coverageEndDate_']//input"));
        Assert.assertTrue(coverageEnd.isEmpty()," Coverage start field should not be editable ");
    }

    public void validateFinancialStartNotEnabled( ) {
        List<WebElement> financialStart = basicActions.getDriver().findElements(By.xpath("//div[@id='financialStartDate_']//input"));
        Assert.assertTrue(financialStart.isEmpty()," Coverage start field should not be editable ");
    }
    public void validateFinancialEndNotEnabled( ) {
        List<WebElement> financialEnd = basicActions.getDriver().findElements(By.xpath("//div[@id='financialEndDate_']//input"));
        Assert.assertTrue(financialEnd.isEmpty()," Coverage start field should not be editable ");
    }
    public void validateReasonNotEnabled( ) {
        List<WebElement> reason = basicActions.getDriver().findElements(By.xpath("//*[@class='member-details-grid-item dropdown']"));
        Assert.assertTrue(reason.isEmpty()," Coverage start field should not be editable ");
    }

    public void verifyEditGridItems(String editInputTextBoxName, String inputValue){
        switch (editInputTextBoxName){
            case "coverage_start_date":
                editGridTableValues(inputAllCoverageStartDate,inputValue);
                break;
            case "coverage_end_date":
                editGridTableValues(inputAllCoverageEndDate,inputValue);
                break;
            case "financial_start_date":
                editGridTableValues(inputAllFinancialStartDate,inputValue);
                break;
            case "financial_end_date":
                editGridTableValues(inputAllFinancialEndDate,inputValue);
                break;
            case "Premium":
                editGridTableValues(inputAllPremiums,inputValue);
                break;
            case "SES":
                editGridTableValues(inputAllSESs,inputValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + editInputTextBoxName);
        }
    }

    private void editGridTableValues(List<WebElement> toBeEdited,String inputToEdit){
        basicActions.waitForElementToBePresent(toBeEdited.get(0),5);
        for (WebElement element : toBeEdited) {
            String beforeEdit = element.getAttribute("value");
            element.sendKeys(inputToEdit);
            String afterEdit = element.getAttribute("value");
            Assert.assertNotEquals(beforeEdit, afterEdit, "Edit not successful for" + element);
        }
    }

    public void verifyOptionsGettingSelectedFromTerminationReasonDropDown() {
        basicActions.waitForElementToBePresent(drpDwnArrowTerminationReason.get(0), 5);
        for (WebElement element : drpDwnArrowTerminationReason) {
            element.click();
            softAssert.assertTrue(element.getText().isEmpty(), "Initially it is not empty");
            int optionNum = basicActions.generateRandomDigits(4);
            basicActions.wait(1000);
            allDrpDownOptionsTerminationReason.get(optionNum).click();
            softAssert.assertFalse(element.getText().isEmpty(), "Option did not get selected");
            softAssert.assertAll();
        }
    }
}
