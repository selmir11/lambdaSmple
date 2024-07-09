package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class MedicalPlanResultsPage {
    private BasicActions basicActions;
     Optional<Integer> optionalInt;
    SoftAssert softAssert = new SoftAssert();

    public MedicalPlanResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "PlanResults-SelectThisPlan_1")
    WebElement selectFirstPlan;

    @FindBy(id = "PlanResults-SelectThisPlan_1")
    WebElement firstMedicalPlanName;


    @FindBy(xpath = "//*[@id='SHP-MedicalPlanResults-Continue'] | //*[@id='MedicalPlanResults-Continue']")
    public WebElement continueBtn;// locators included for both QA and STG

    @FindBy(id = "PlanResults-ComparePlans")
    WebElement clickCompare;

    @FindBy (id = "MedicalPlanResults-SaveAndExit")
    WebElement btnSaveExist;

    @FindBy (id = "MedicalPlanResults-GoBack")
    WebElement btnGoBack;

    @FindBy (id="MedicalPlanResults-Skip")
    WebElement btnSkip;

    @FindBy(xpath = "//input[contains (@id, 'mat-mdc-checkbox')]")
    List<WebElement> comparePlanLinks;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "SHP-PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "SHP-PlanResults-MetalTier")
    WebElement metalTierDropdown;

    @FindBy(id = "SHP-PlanResults-HSAFilter")
    WebElement hsaDropdown;

    @FindBy(xpath = "//label[@for='SHP-PlanResults-HSAFilter-input']")
    WebElement hsaOption;

    @FindBy(id = "SHP-PlanResults-CoOptionPlans")
    WebElement coloradoOptionDropdown;

    @FindBy(css = ".mdc-checkbox #SHP-PlanResults-CoOptionPlans-input")
    WebElement coloradoOptionSelection;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> medicalPlanNamesList;

    @FindBy(css = "pagination-template .pagination-next a")
    WebElement nextPageArrow;

    @FindBy(xpath = "//span[@id='PlanResults-PremAfterSubsidy_1']")
    WebElement planResultsAPTC;

    public void validateAPTC(String planResultsAPTCredit){
        basicActions.waitForElementToBePresent(planResultsAPTC, 30);
        softAssert.assertEquals(planResultsAPTC.getText(),planResultsAPTCredit);
    }
    public void validateNoAPTC(String noAPTCCreditAmt) {
        softAssert.assertFalse(basicActions.waitForElementPresence(planResultsAPTC, 20 ) );
        softAssert.assertAll();

    }

    public void selectfromProviderList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();

    }

    public void iGetFirstPlanName() {
        basicActions.waitForElementToBePresent(firstMedicalPlanName, 30);
        SharedData.setFirstPlanNameOnMedicalResultsPage(firstMedicalPlanName.getText());
    }

    public void SelectFirstMedicalPlan() {
        basicActions.waitForElementToBePresent(selectFirstPlan, 30);
        selectFirstPlan.click();
    }

    public void clickContinue() {
        basicActions.waitForElementToBePresent(continueBtn,30);
        continueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBeClickableWithRetries( btnGoBack,30 );
        btnGoBack.click();
    }

    public void clickSkip(){
        basicActions.waitForElementToBeClickableWithRetries( btnSkip,30000 );
        btnSkip.click();
    }
    public void clickCompare() {
        basicActions.waitForElementToBePresent(clickCompare, 30);
        clickCompare.click();
    }

    public void clickFirstTwoCompareButtons() {
        basicActions.waitForElementListToBePresent(comparePlanLinks, 30);
        comparePlanLinks.get(0).click();
        comparePlanLinks.get(1).click();
    }

    public void clickInsuranceCompanyDropdown() {
        basicActions.waitForElementToBeClickable(insuranceCompanyDropdown, 30);
        insuranceCompanyDropdown.click();

    }

    public void clickMetalTierDropdown() {
        basicActions.waitForElementToBeClickable(metalTierDropdown, 30);
        metalTierDropdown.click();

    }

    public void clickHSADropdown() {
        basicActions.waitForElementToBeClickable(hsaDropdown, 30);
        hsaDropdown.click();
    }

    public void selectHSAOption() {
        basicActions.waitForElementToBePresent(hsaOption,30);
        basicActions.waitForElementToBeClickable(hsaOption, 100);
        hsaOption.click();

    }

    public void clickColoradoOptionDropdown() {
        basicActions.waitForElementToBeClickable(coloradoOptionDropdown, 30);
        coloradoOptionDropdown.click();
    }

    public void selectColoradoOptionSelection() {
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", coloradoOptionSelection);
        Assert.assertTrue(coloradoOptionSelection.isSelected());
    }

    public void selectfromMetalTierList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void validatePlanResults(int index, String planText) {
        basicActions.waitForElementToBePresent(selectFirstPlan, 10);
        //index = index - 1; //Index of the page starts at 0, so we take the visible order and subtract 1
        String indexString = String.valueOf(index); //turns the int index into a string value.
        String planID = "PlanResults-SelectThisPlan_" + indexString; //sets the ID String using the index
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID)); //sets the Web element based on the ID
        String expectedText = ePlanID.getText();
        expectedText.equals(planText); // compares the expected text gathered in previous line to the planText passed into the function.
    }

    public void selectMedicalPlan(String planName){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setMedicalPlan(planName);
        SharedData.setPrimaryMember(subscriber);
            do {
            optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                clickPlanButton(optionalInt.get()+1);
            } else {
                paginateRight();
            }
        } while(optionalInt.isEmpty());
    }

    private Optional<Integer> checkIfPlanPresent(String planName) {
        basicActions.waitForElementListToBePresent(medicalPlanNamesList, 10);
        return IntStream.range(0, medicalPlanNamesList.size())
                .filter(i -> medicalPlanNamesList.get(i).getText().equals(planName))
                .boxed()
                .findFirst();
    }

    private void clickPlanButton(int index){
        String planID = "PlanResults-SelectThisPlan_" + index;
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID));
        basicActions.waitForElementToBeClickable(ePlanID, 10);
        ePlanID.click();
    }

    private void paginateRight(){
        basicActions.waitForElementToBePresent(nextPageArrow, 10);
        Assert.assertTrue(nextPageArrow.isEnabled(), "Right arrow to click is not enabled!");
        nextPageArrow.click();
    }

}


