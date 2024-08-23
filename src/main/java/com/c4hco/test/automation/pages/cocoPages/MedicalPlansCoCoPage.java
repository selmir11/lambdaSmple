package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class MedicalPlansCoCoPage {
    private BasicActions basicActions;
    Optional<Integer> optionalInt;

    public MedicalPlansCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#PlanResults-SelectThisPlan_1")
    public WebElement selectFirstPlan;

    @FindBy(xpath = "//*[@id='SHP-MedicalPlanResults-Continue'] | //*[@id='MedicalPlanResults-Continue']")
    public WebElement continueButton;

    @FindBy(id = "PlanResults-InsuranceCompany")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "PlanResults-MetalTier")
    WebElement metalTierDropdown;
    @FindBy(id="PlanResults-PlanCompareCheckbox_1")
    WebElement selectFirstComparebox;

    @FindBy (id = "PlanResults-PlanCompareCheckbox_2")
    WebElement selectSecondComparebox;

    @FindBy (id = "PlanResults-PlanCompareCheckbox_3")
    WebElement selectSThirdComparebox;

    @FindBy(id = "PlanResults-ComparePlans")
    WebElement selectCompareButton;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> medicalPlanNamesList;

    @FindBy(css = "pagination-template .pagination-next a")
    WebElement nextPageArrow;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "PlanResults-MetalTier_0-input")
    WebElement silverEnhancedBox;

    @FindBy(xpath = "//*[@class = 'col-12 col-xl-5 responsive-text-align-left ng-star-inserted']")
    //@FindBy(css = ".plan-results-container .responsive-text-align-left")
    WebElement planTotalsCoCo;

     public void selectFirstMedicalPlanCoCo() {
        basicActions.waitForElementToBeClickable(selectFirstPlan, 20);
        selectFirstPlan.click();
    }

    public void selectContinueMedicalPlansCoCo() {
        basicActions.waitForElementToBeClickableWithRetries(continueButton, 20);
        continueButton.click();
    }

    public void clickInsuranceCompanyDropdown() {
        basicActions.waitForElementToBeClickable(insuranceCompanyDropdown, 30);
        insuranceCompanyDropdown.click();

    }

    public void clickMetalTierDropdown() {
        basicActions.waitForElementToDisappear(spinner,10);
        basicActions.waitForElementToBePresent(metalTierDropdown, 30);
        metalTierDropdown.click();

    }
    public void selectfromMetalTierList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }
    public void selectSilverEnhancedBox(){
         basicActions.waitForElementToDisappear( spinner, 20);
         basicActions.waitForElementToBePresent( silverEnhancedBox, 10 );
         silverEnhancedBox.click();
    }

    public void validateCOCOPlanTotals(String planTotal){
         basicActions.waitForElementToDisappear( spinner,30 );
         basicActions.waitForElementToBePresent( planTotalsCoCo,20 );
        Assert.assertEquals(planTotalsCoCo.getText(), planTotal+" of "+planTotal+" Medical Plans", "Medical plans count did not match");

    }

    public void validateSESCOCOPlanTotals(String sesPlanTotal){
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent( planTotalsCoCo,20 );
        Assert.assertEquals(planTotalsCoCo.getText(), sesPlanTotal+" of "+sesPlanTotal+" Medical Plans", "Medical plans count did not match");

    }

    public void selectfromProviderList(String Selecting) {
        basicActions.waitForElementToDisappear( spinner,20 );
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

    public void selectPlanstoCompare(){
        basicActions.waitForElementToBePresent( insuranceCompanyDropdown,20 );
        selectFirstComparebox.click();
        selectSecondComparebox.click();
        selectSThirdComparebox.click();
        selectCompareButton.click();
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
        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementToBePresent(nextPageArrow, 10);
        Assert.assertTrue(nextPageArrow.isEnabled(), "Right arrow to click is not enabled!");
        basicActions.scrollToElement(nextPageArrow);
        nextPageArrow.click();
    }

    public void selectCoCoMedicalplan(String planName){
        basicActions.waitForElementToDisappear(spinner,20);
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

}
