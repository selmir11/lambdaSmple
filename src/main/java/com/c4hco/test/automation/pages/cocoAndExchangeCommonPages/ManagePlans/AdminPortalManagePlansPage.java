package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ManagePlans;
        import com.c4hco.test.automation.Dto.SharedData;
        import com.c4hco.test.automation.utils.BasicActions;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
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
        basicActions.waitForElementToBePresent(btnMakeChangeMed, 10);
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
}