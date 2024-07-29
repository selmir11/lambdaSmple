package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class DentalPlansResultsPage {
    private BasicActions basicActions;
    private Optional<Integer> optionalInt;

    public DentalPlansResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="PlanResults-SelectThisPlan_1")
    WebElement selectFirstDentalPlanBtn;

    @FindBy(id= "DentalPlanResults-GoBack")
    WebElement btnGoBack;

    @FindBy(id= "DentalPlanResults-Skip")
    WebElement dentalSkipBtn;

    @FindBy (id ="mat-mdc-checkbox-28-input")
    WebElement comparePlanBox1;

    @FindBy (id ="mat-mdc-checkbox-29-input")
    WebElement comparePlanBox2;

    @FindBy(id ="DentalPlanResults-ComparePlans")
    WebElement btnCompareOnDentalPlanResults;

    @FindBy(id = "DentalPlanResults-CoverageLevel")
    WebElement dropdownCoverageLevel;

    @FindBy(id = "DentalPlanResults-Continue")
    WebElement continueBtnOnDentalPlanResults;

    @FindBy(id = "DentalPlanResults-InsuranceCompany")
    WebElement dropdownInsuranceCompany;

    @FindBy(css= ".c4-type-header-sm")
    List<WebElement> dentalPlanNames;

    @FindBy(css = "pagination-template .pagination-next")
    WebElement nextPageArrow;

    @FindBy(css = ".plan-results-container .responsive-text-align-left")
    WebElement dentalPlanCount;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(id = "PlanResults-MonthlyPremium_1")
    WebElement dentalPremium1;

    @FindBy(id = "PlanResults-MonthlyPremium_2")
    WebElement dentalPremium2;

    @FindBy(id = "PlanResults-MonthlyPremium_3")
    WebElement dentalPremium3;

    @FindBy(id = "PlanResults-MonthlyPremium_4")
    WebElement dentalPremium4;

    @FindBy(id = "PlanResults-MonthlyPremium_5")
    WebElement dentalPremium5;

    @FindBy(id = "PlanResults-MonthlyPremium_6")
    WebElement dentalPremium6;

    @FindBy(id = "PlanResults-MonthlyPremium_7")
    WebElement dentalPremium7;
    @FindBy(id = "PlanResults-MonthlyPremium_8")
    WebElement dentalPremium8;
    @FindBy(id = "PlanResults-MonthlyPremium_9")
    WebElement dentalPremium9;

    @FindBy(id = "PlanResults-MonthlyPremium_10")
    WebElement dentalPremium10;


    SoftAssert softAssert = new SoftAssert();

    public void iGetFirstDentalPlanName() {
        basicActions.waitForElementListToBePresent(dentalPlanNames, 10);
        SharedData.setFirstPlanNameOnDentalResultsPage(dentalPlanNames.get(0).getText());
    }

    public void selectFirstDentalPlan(){
        basicActions.waitForElementToBeClickable(selectFirstDentalPlanBtn,20);
        selectFirstDentalPlanBtn.click();
    }
    public void clickContinueOnDentalResultsPage(){
        basicActions.waitForElementToBePresent(continueBtnOnDentalPlanResults,15);
        continueBtnOnDentalPlanResults.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBePresent(btnGoBack,10);
        btnGoBack.click();

    }
    public void clickSkip(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(dentalSkipBtn,30);
        dentalSkipBtn.click();
    }
    public void clickFirstTwoCompareBoxes() {
        basicActions.waitForElementToBePresent( comparePlanBox1,10 );
        comparePlanBox1.click();
        comparePlanBox2.click();
    }
    public void clickCompareOnDentalPlanResults() {
       basicActions.waitForElementToBePresent(btnCompareOnDentalPlanResults, 10);
       btnCompareOnDentalPlanResults.click();
    }

    public void clickCoverageLevelDropdown(){
        basicActions.waitForElementToBePresent(dropdownCoverageLevel, 10);
        basicActions.waitForElementToBeClickableWithRetries( dropdownCoverageLevel, 10 );
        dropdownCoverageLevel.click();

    }
    public void selectfromCoverageLevelList(String coverageLevel) {
        String coveragePath = "//*[text()='" + coverageLevel + "']";
        basicActions.getDriver().findElement(By.xpath(coveragePath)).click();
    }

    public void clickDentalInsuranceCompanyDropdown (){
        basicActions.waitForElementToBePresent(dropdownInsuranceCompany, 10);
        basicActions.waitForElementToBeClickableWithRetries( dropdownInsuranceCompany,10 );
        dropdownInsuranceCompany.click();
    }

    public void selectfromInsuranceCompanyList(String insuranceCompany){
        String companyPath = "//*[text()='" + insuranceCompany + "']";
        basicActions.getDriver().findElement(By.xpath(companyPath)).click();
    }

    public void validateDentalPlanText (int index,String dentalPlanText){
        basicActions.waitForElementToBeClickableWithRetries(dropdownCoverageLevel, 10);
        String indexString = String.valueOf(index);
        String planID = "DentalPlanResults-SelectThisPlan_" + indexString;
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID));
        String expectedText = ePlanID.getText();
        expectedText.equals(dentalPlanText);
    }

    public void selectDentalPlan(String dentalPlanNames){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setDentalPlan(dentalPlanNames);
        SharedData.setPrimaryMember(subscriber);
        do {
            optionalInt = checkIfPlanPresent(dentalPlanNames);
            if (optionalInt.isPresent()) {
                clickPlanButton(optionalInt.get()+1);
            } else {
                paginateRight();
            }
        } while(optionalInt.isEmpty());
    }

    private Optional<Integer> checkIfPlanPresent(String planName) {
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementListToBePresent(dentalPlanNames, 30);
        return IntStream.range(0, dentalPlanNames.size())
                .filter(i -> dentalPlanNames.get(i).getText().equals(planName))
                .boxed()
                .findFirst();
    }

    private void clickPlanButton(int index){
        String planID = "PlanResults-SelectThisPlan_" + index;
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID));
        basicActions.waitForElementToBeClickable(ePlanID, 30);
        ePlanID.click();
    }

    private void paginateRight(){
        basicActions.waitForElementToBePresent(nextPageArrow, 10);
        Assert.assertTrue(nextPageArrow.isEnabled(), "Right arrow to click is not enabled!");
        nextPageArrow.click();
    }

    public void validateDentalPlanCount(String plansCount){
        basicActions.waitForElementToBePresent(dentalPlanCount, 30);
        Assert.assertEquals(dentalPlanCount.getText(), plansCount+" of "+plansCount+" Dental Plans", "Dental plans count did not match");
    }


    public void validateDentalPlanCosts(int index, String planText) {
        basicActions.waitForElementToBePresent(dentalPremium1, 10);
        //index = index - 1; //Index of the page starts at 0, so we take the visible order and subtract 1
        String indexString = String.valueOf(index); //turns the int index into a string value.
        String dentalPlanPremiumID = "PlanResults-MonthlyPremium_" + indexString; //sets the ID String using the index
        WebElement eDentalPlanPremiumID = basicActions.getDriver().findElement(By.id(dentalPlanPremiumID)); //sets the Web element based on the ID
        String expectedText = eDentalPlanPremiumID.getText();
        expectedText.equals(planText); // compares the expected text gathered in previous line to the planText passed into the function.
    }


    public void validateDentalPlanNames(){
        List<String> dentalPlanNamesList = new ArrayList<>();

        while(true){
            basicActions.waitForElementListToBePresent(dentalPlanNames, 30);
            for(WebElement dentalPlanName: dentalPlanNames) {
                dentalPlanNamesList.add(dentalPlanName.getText());
            }
            basicActions.waitForElementToBePresent(nextPageArrow, 10);

            if(nextPageArrow.getAttribute("className").contains("disabled")){
                break;
            }

            nextPageArrow.click();
        }
        softAssert.assertEquals(dentalPlanNamesList.size(), Constants.DentalPlanNamesList.size(), "Plan count doesn't match");
        softAssert.assertEquals(dentalPlanNamesList, Constants.DentalPlanNamesList);
        softAssert.assertAll();
        }
    }