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


    @FindBy(xpath = "//*[@id='MedicalPlanResults-Continue']")
    public WebElement continueBtn;

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

    @FindBy(id = "PlanResults-InsuranceCompany")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "PlanResults-MetalTier")
    WebElement metalTierDropdown;

    @FindBy(id = "PlanResults-HSAFilter")
    WebElement hsaDropdown;

    @FindBy(id = "PlanResults-HSAFilter-input")
    WebElement hsaOption;

    @FindBy(id = "PlanResults-CoOptionPlans")
    WebElement coloradoOptionDropdown;

    @FindBy(css = ".mdc-checkbox #PlanResults-CoOptionPlans-input")
    WebElement coloradoOptionSelection;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> medicalPlanNamesList;

    @FindBy(css = "pagination-template .pagination-next a")
    WebElement nextPageArrow;

    @FindBy(css = ".plan-results-container .responsive-text-align-left")
    WebElement planCount;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

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
        basicActions.waitForElementToBePresent( btnGoBack,30 );
        basicActions.scrollToElement( btnGoBack );
        btnGoBack.click();
    }

    public void clickSkip(){
        basicActions.waitForElementToDisappear(spinner, 20);
         basicActions.waitForElementToBePresent(btnSkip, 30);
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
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent( insuranceCompanyDropdown,30 );
        insuranceCompanyDropdown.click();

    }

    public void clickMetalTierDropdown() {
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent( metalTierDropdown,30 );
        metalTierDropdown.click();

    }

    public void clickHSADropdown() {
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent(hsaDropdown, 30);
        hsaDropdown.click();
    }

    public void selectHSAOption() {
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent(hsaOption, 100);
        hsaOption.click();

    }

    public void clickColoradoOptionDropdown() {
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent(coloradoOptionDropdown, 30);
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

    public void validatePlanCount(String plansCount){
        basicActions.waitForElementToBePresent(planCount, 30);
        Assert.assertEquals(planCount.getText(), plansCount+" of "+plansCount+"  Medical Plans", "Medical plans count did not match");
    }

}


