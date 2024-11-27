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
    @FindBy(css = "div.select-plan-type-input > div:nth-child(1)")
    WebElement btnMedicalChecked;
    @FindBy(css = "div.select-plan-type-input > div:nth-child(2)")
    WebElement btnDentalChecked;
    @FindBy(css = ".tollbar-app-links")
    WebElement appLinks;
    @FindBy(css = ".toolbar-links")
    WebElement blueBarlinks;
    @FindBy(id = "Manage Plans-Reset Changes Medical")
    WebElement btnMedReset;
    @FindBy(id = "Manage Plans-Reset Changes Dental")
    WebElement btnDentalReset;
    @FindBy(css = "button[id='Manage Plans-Make Changes Medical']")
    WebElement btnMakeChangeMed;
    @FindBy(id = "Manage Plans-Make Change Dental")
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
    @FindBy(xpath = "//div[@id='coverageEndDate_2']//input[1]")
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

    @FindBy(xpath = "//div[@class='value-container body-text-1'][3]")
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
        basicActions.waitForElementToBePresent(btnMedReset, 20);
        softAssert.assertEquals(btnMedReset.getText(), "Reset Changes");
        softAssert.assertEquals(btnDentalReset.getText(), "Reset Changes");
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

    public void clickManagePlans() {
        basicActions.waitForElementToBePresent(btnManagePlans, 10);
        btnManagePlans.click();
        basicActions.switchtoactiveTab();
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
        softAssert.assertEquals(btnMedReset.getText(), "Reset Changes");
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
        List<String> expectedList = new ArrayList<>(Arrays.asList("2019", "2020", "2021", "2022", "2023", "2024", "2025"));
        List<String> existingList = new ArrayList<>();
        for (WebElement each : planYearList) {
            existingList.add(each.getText().trim());
        }
        softAssert.assertEquals(planYearList.get(0).getText(), lowerYear);
        softAssert.assertEquals(expectedList, existingList);
        softAssert.assertAll();
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
        for (String memberFinancialEndDate : memberCoverageEndDTList) {
            String[] parts = memberFinancialEndDate.split(":");
            String memberNo = parts[0];
            String coverageEndDateValue = "";
            if (parts[1].equals("end of month")) {
                coverageEndDateValue = basicActions.endOfMonthDate();
            } else {
                coverageEndDateValue = parts[1];
            }
            basicActions.scrollToElement(coverageEndDate);
            basicActions.waitForElementToBePresent(coverageEndDate, 30);

            WebElement financialEndDateMem = basicActions.getDriver().findElement(By.xpath("//div[@id='coverageEndDate_" + memberNo + "']//input[1]"));
            financialEndDateMem.sendKeys(coverageEndDateValue);
        }
    }


    public void updateTheFinancialEndDate(List<String> memberFinancialEndDTList) {
        for (String memberFinancialEndDate : memberFinancialEndDTList) {
            String[] parts = memberFinancialEndDate.split(":");
            String memberNo = parts[0];
            String financialStartDateValue = "";
            if (parts[1].equals("end of month")) {
                financialStartDateValue = basicActions.endOfMonthDate();
            } else {
                financialStartDateValue = parts[1];
            }
            basicActions.scrollToElement(financialEndDate);
            basicActions.waitForElementToBePresent(financialEndDate, 30);
            basicActions.waitForElementToBeClickable(financialEndDate, 30);

            WebElement financialEndDateMem = basicActions.getDriver().findElement(By.xpath("//div[@id='financialEndDate_" + memberNo + "']//input[1]"));
            financialEndDateMem.sendKeys(financialStartDateValue);
        }
    }

    public void selectThePlanYearOnManagePlan(String planYear) {
        basicActions.waitForElementListToBePresent(planYearList, 50);
        dpdCurrentYearMP.click();
        for (WebElement each : planYearList) {
            if (each.getText().equals(planYear)) {
                each.click();
            }
        }
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

        memberDetails.setAccount_id(bigDecimal);
        SharedData.setPrimaryMember(memberDetails);
        String currentDentalPlan = currentDentalPlanName.getText();


        managePlanDentalMedicalPlan.setPlanMarketingName(currentDentalPlan);
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);

        String MedPolicyCoverage = pnlMedPolicyCoverage.getText();
        managePlanDentalMedicalPlan.setPolicyCoverageDate(MedPolicyCoverage);
        SharedData.setManagePlanDentalMedicalPlan(managePlanDentalMedicalPlan);

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
}


