package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ManagePlans;
        import com.c4hco.test.automation.Dto.SharedData;
        import com.c4hco.test.automation.utils.BasicActions;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.Assert;
        import org.testng.asserts.SoftAssert;
        import java.util.List;
        import java.util.Optional;

public class AdminPortalManagePlansPage{

    private BasicActions basicActions;
    public AdminPortalManagePlansPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );


    }
    SoftAssert softAssert = new SoftAssert();

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
    @FindBy(id = "Manage Plans-Select Plan Type Medical")
    WebElement btnMedicalChecked;
    @FindBy(id = "Manage Plans-Select Plan Type Dental")
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
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[2]/div[1]/div[2]/app-previous-plan/div")
    WebElement previousFinancialMed;
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[2]/div[2]/div[2]/app-previous-plan/div")
    WebElement previousFinancialDental;
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[2]/div[1]/div[2]/app-previous-plan/div/div[2]")
    WebElement previousFinancialNoMed;
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[2]/div[2]/div[2]/app-previous-plan/div/div[2]")
    WebElement previousFinancialNoDental;
    @FindBy(css = "#enrollments-container > div.plan-header > div.select-year > div:nth-child(2) > app-plan-year-dropdown > div > app-drop-down-select > div > div.drop-down-option.drop-down-option-selected")
    WebElement planYearDownArrow;
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[1]/div[1]/div[2]/app-plan-year-dropdown/div/app-drop-down-select")
    WebElement planYearList;
    @FindBy(xpath = "//*[@id=\"enrollments-container\"]/div[1]/div[1]/div[2]/app-plan-year-dropdown/div/app-drop-down-select/div/div[2]/div[1]")
    WebElement secondYearInList;
    @FindBy(xpath= "//div[@id='coverageStartDate_1']//input[1]")
    WebElement coverageStartdate;
    @FindBy(xpath = "//div[@id='financialStartDate_1']//input[@type='date']")
    WebElement financialStartDate;
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

    public void validateBluBar(){
        basicActions.waitForElementToBePresent(blueBarlinks,20);
        softAssert.assertEquals(titleInBlueBar.getText(), "Admin Portal");
        softAssert.assertEquals(lnkSearch.getText(), "Search");
        softAssert.assertEquals(appLinks.getText(), "Application Links");
        softAssert.assertAll();     }
    public void containerTitleLabels(){
        basicActions.waitForElementToBePresent(txtTitleManagePlans,20);
        softAssert.assertEquals(txtTitleManagePlans.getText(), "Manage Plans");
        softAssert.assertEquals(txtSelectPlanYear.getText(), "Select a plan year:");
        softAssert.assertEquals(planYearLabel.getText(), "Year:");
        softAssert.assertEquals(txtSelectPlanType.getText(), "Select plan type:");
        softAssert.assertEquals(chkMedical.getText(), "Medical");
        softAssert.assertEquals(chkDental.getText(), "Dental");
        softAssert.assertAll();     }

    public void checkDefaultCurrentYear(){
        basicActions.waitForElementToBePresent(dpdCurrentYearMP,20);
        softAssert.assertEquals(dpdCurrentYearMP.getText(), "2024");
        softAssert.assertAll();     }
    public void verifyButtonsCheckedBoth(){
        basicActions.waitForElementToBePresent(btnMedicalChecked,20);
        softAssert.assertTrue(btnMedicalChecked.isDisplayed());
        softAssert.assertTrue(btnDentalChecked.isDisplayed());
        softAssert.assertAll();     }
    public void resetMakeChangeButtonsDisplayed(){
        basicActions.waitForElementToBePresent(btnMedReset,20);
        softAssert.assertEquals(btnMedReset.getText(), "Reset Changes");
        softAssert.assertEquals(btnDentalReset.getText(), "Reset Changes");
        softAssert.assertEquals(btnMakeChangeMed.getText(), "Make Changes Medical");
        softAssert.assertEquals(btnMakeChangeDental.getText(), "Make Changes Dental");
        softAssert.assertAll();     }
    public void verifySaveButtonDisplayed(String saveMed) {
        basicActions.waitForElementToBePresent(btnMedSave, 10);
        softAssert.assertEquals(btnMedSave.getText(), saveMed);
        softAssert.assertAll();    }
    public void clickMakeChangesMedical() {
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 30);
        basicActions.waitForElementToBePresent(btnMakeChangeMed, 10);
        basicActions.scrollToElement(btnMakeChangeMed);
        basicActions.waitForElementToBeClickable(btnMakeChangeMed,10);
        btnMakeChangeMed.click();       }
    public void clickResetChangesMedical() {
        basicActions.waitForElementToBePresent(btnMedReset, 10);
        btnMedReset.click();        }
    public void clickMakeChangesDental() {
        basicActions.waitForElementToBePresent(btnMakeChangeDental, 10);
        btnMakeChangeDental.click();       }
    public void verifySaveDentalButtonDisplayed(String saveDental) {
        basicActions.waitForElementToBePresent(btnDentalSave, 10);
        softAssert.assertEquals(btnDentalSave.getText(), saveDental);
        softAssert.assertAll();    }
    public void clickResetChangesDental() {
        basicActions.waitForElementToBePresent(btnDentalReset, 10);
        btnDentalReset.click();        }
    public void clickManagePlans() {
        basicActions.waitForElementToBePresent(btnManagePlans, 10);
        btnManagePlans.click();
        basicActions.switchtoactiveTab();       }
    public void validateChangeButtonsNotDisplay(){
        basicActions.waitForElementToBePresent(txtTitleManagePlans, 10);
        Assert.assertFalse(basicActions.isElementDisplayed(btnMedSave, 3));
        softAssert.assertAll();     }
    public void containerTitleLabelsCoco(){
        basicActions.waitForElementToBePresent(txtTitleManagePlans,20);
        softAssert.assertEquals(txtTitleManagePlans.getText(), "Manage Plans");
        softAssert.assertEquals(txtSelectPlanYear.getText(), "Select a plan year:");
        softAssert.assertEquals(planYearLabel.getText(), "Year:");
        softAssert.assertEquals(txtSelectPlanType.getText(), "Select plan type:");
        softAssert.assertEquals(chkMedical.getText(), "Medical");
        softAssert.assertAll();     }
    public void verifyMedicalButtonChecked(){
        basicActions.waitForElementToBePresent(btnMedicalChecked,20);
        softAssert.assertTrue(btnMedicalChecked.isDisplayed());
        softAssert.assertAll();     }
    public void resetMakeChangeButtonsCocoDisplayed(){
        basicActions.waitForElementToBePresent(btnMedReset,20);
        softAssert.assertEquals(btnMedReset.getText(), "Reset Changes");
        softAssert.assertEquals(btnMakeChangeMed.getText(), "Make Changes Medical");
        softAssert.assertAll();     }
    public void checkPreviousFinancialMedical(){
        basicActions.waitForElementToBePresent(previousFinancialMed,20);
        softAssert.assertEquals(previousFinancialMed.getText(), "Previous Financial Periods - Medical");
        softAssert.assertEquals(previousFinancialNoMed.getText(), "No Past Financial Periods - Medical");
        softAssert.assertAll();     }
    public void checkPreviousFinancialDental(){
        basicActions.waitForElementToBePresent(previousFinancialDental,20);
        softAssert.assertEquals(previousFinancialDental.getText(), "Previous Financial Periods - Dental");
        softAssert.assertEquals(previousFinancialNoDental.getText(), "No Past Financial Periods - Dental");
        softAssert.assertAll();     }
    public void validateYearsDropdown(String lowerYear){
        basicActions.waitForElementToBePresent(planYearList,20);
        softAssert.assertTrue(planYearDownArrow.isDisplayed());
        basicActions.click(dpdCurrentYearMP);
        basicActions.waitForElementToBePresent(planYearList,20);
        softAssert.assertEquals(planYearList.getText(), "2024\n" +
                "2019\n" +
                "2020\n" +
                "2021\n" +
                "2022\n" +
                "2023\n" +
                "2024\n" +
                "2025");
        softAssert.assertEquals(secondYearInList.getText(), lowerYear);
        softAssert.assertAll();     }

    public void clickSaveButton() {
        basicActions.waitForElementToBePresent(btnMedSave, 20);
        btnMedSave.click();
    }

    public void memberCoverageStrtDate(List<String> memberCoverageStrtDtList) {
        for(String memberCoverageStrtDate : memberCoverageStrtDtList) {
            String[] parts = memberCoverageStrtDate.split(":");
            String memberNo = parts[0];
            String coverageStartDateValue = parts[1];

           basicActions.waitForElementToBePresent(txtTitleManagePlans, 30);
            basicActions.waitForElementToBePresent(coverageStartdate, 30);
            basicActions.waitForElementToBeClickable(coverageStartdate, 30);
            basicActions.scrollToElement(coverageStartdate);

            boolean elementUpdated = false;
            int attempts = 0;

            while(!elementUpdated && attempts < 3) {
                try {
                    WebElement coverageStartdateMem = basicActions.getDriver()
                            .findElement(By.xpath("//div[@id='coverageStartDate_" + memberNo + "']//input[1]"));

                    coverageStartdateMem.click();
                    coverageStartdateMem.clear();
                    coverageStartdateMem.sendKeys(coverageStartDateValue);

                    elementUpdated = true;
                } catch (StaleElementReferenceException e) {
                    attempts++;
                                    }
            }

            if (!elementUpdated) {
                throw new RuntimeException("Failed to update coverage start date after multiple attempts.");
            }
        }
    }
    public void memberFinancialStrtDate(List<String> memberFinancialStrtDtList){
        for(String memberFinancialStrtDate:memberFinancialStrtDtList ){
            String[] parts = memberFinancialStrtDate.split(":");
            String memberNo = parts[0];
            String financialStartDateValue = parts[1];

            basicActions.scrollToElement( financialStartDate );
            basicActions.waitForElementToBePresent(financialStartDate,30);
            basicActions.waitForElementToBeClickable(financialStartDate,30);

            WebElement financialStartDateMem = basicActions.getDriver().findElement(By.xpath("//div[@id='financialStartDate_"+memberNo+"']//input[1]"));
            financialStartDateMem.click();
            financialStartDateMem.clear();
            financialStartDateMem.sendKeys(financialStartDateValue);

        }
    }

    public void selectReasonForTheChange(){
        basicActions.waitForElementToBeClickable(reasonForTheChange,10);
        reasonForTheChange.click();
        basicActions.waitForElementToBeClickable(optionRecon, 10);
        optionRecon.click();
        basicActions.waitForElementToBePresent(additionalReasonText, 10);
        additionalReasonText.sendKeys("Testing");
        confirmChangesButton.click();
    }
    public void verifyLabelsDataMedical() {
        basicActions.waitForElementListToBePresent(currentMedicalData, 5000);
        String[] expectedHeaders = {"Anthem Silver Pathway HMO 6500 Rx Copay $0 Select Drugs","Policy Coverage: 01/01/2024 to 12/31/2024","Latest Application Date:","11/28/2023","Financial Start Date:","01/01/2024","EHB Premium:","$1,598.46","Financial End Date:","12/31/2024","CSR Amount:","$0.00","Plan Premium:","$1,598.46","Latest LCE and Date:","","Plan APTC:","$511.57","Rating Area:","3","Premium after Subsidy:","$1,086.89","Service Area:","COS001","Plan AV:","70.54%","Policy ID:","3935009010","HIOS ID:","76680CO0220067-01"};
        for (int i = 0; i < currentMedicalData.size(); i++) {
            String actualHeader = currentMedicalData.get(i).getText();
            if (!actualHeader.equals(expectedHeaders[i])) {
                System.out.println("Label mismatch: Expected " + expectedHeaders[i] + ", but got " + actualHeader);
            }
        }
    }
    public void verifyLabelsDataDental() {
        basicActions.waitForElementListToBePresent(currentDentalData, 5000);
        String[] expectedHeaders = {"Anthem Dental Family","Policy Coverage: 01/01/2024 to 12/31/2024","Latest Application Date:","11/28/2023","Financial Start Date:","01/01/2024","EHB Premium:","$41.86","Financial End Date:","12/31/2024","CSR Amount:","$0.00","Plan Premium:","$41.86","Latest LCE and Date:","","Plan APTC:","$0.00","Rating Area:","3","Premium after Subsidy:","$41.86","Service Area:","COS003","Plan AV:","0.00%","Policy ID:","2399001105","HIOS ID:","87269CO1120003-01"};
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
        basicActions.switchtoactiveTab();       }

}

