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

    SoftAssert softAssert = new SoftAssert();

    public DentalPlansResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(xpath = "//*[class = 'disclaimer body-text-2']")
    WebElement disclaimerDental;
    @FindBy(id = "PlanResults-SelectThisPlan_1")
    WebElement selectFirstDentalPlanBtn;

    @FindBy(id = "PlanResults-PlanDetails_1")
    WebElement selectFirstDentalDetailButton;

    @FindBy(id = "DentalPlanResults-GoBack")
    WebElement btnGoBack;

    @FindBy(id = "DentalPlanResults-Skip")
    WebElement dentalSkipBtn;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_1")
    WebElement comparePlanBox1;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_2")
    WebElement comparePlanBox2;

    @FindBy(id = "DentalPlanResults-ComparePlans")
    WebElement btnCompareOnDentalPlanResults;

    @FindBy(css = "#DentalPlanResults-CoverageLevel")
    WebElement dropdownCoverageLevel;

    @FindBy(id = "DentalPlanResults-Continue")
    WebElement continueBtnOnDentalPlanResults;

    @FindBy(id = "DentalPlanResults-InsuranceCompany")
    WebElement dropdownInsuranceCompany;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> dentalPlanNames;

    @FindBy(css = "pagination-template .pagination-next")
    WebElement nextPageArrow;

    @FindBy(css = ".plan-results-container .responsive-text-align-left")
    WebElement dentalPlanCount;

    @FindBy(css = ".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(id = "PlanResults-MonthlyPremium_1")
    WebElement dentalPremium1;

    @FindBy(id = "PlanResults-PlanName_4")
    WebElement pediatricdental1;

    @FindBy(id = "PlanResults-PlanName_5")
    WebElement pediatricdental2;

    @FindBy(id = "PlanResults-PlanName_6")
    WebElement pediatricdental3;

    public void iGetFirstDentalPlanName() {
        basicActions.waitForElementListToBePresent( dentalPlanNames, 10 );
        SharedData.setFirstPlanNameOnDentalResultsPage( dentalPlanNames.get( 0 ).getText() );
    }

    public void selectFirstDentalPlan() {
        basicActions.waitForElementToBeClickable( selectFirstDentalPlanBtn, 20 );
        selectFirstDentalPlanBtn.click();
    }

    public void clickFirstPlanDetailBtn(){
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBeClickableWithRetries( selectFirstDentalDetailButton, 15 );
        selectFirstDentalDetailButton.click();
    }

    public void clickContinueOnDentalResultsPage() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( continueBtnOnDentalPlanResults, 15 );
        continueBtnOnDentalPlanResults.click();
    }

    public void clickGoBack() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBeClickableWithRetries( btnGoBack, 20 );
        basicActions.scrollToElement( btnGoBack );
        btnGoBack.click();

    }

    public void clickSkip() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBePresent( dentalSkipBtn, 30 );
        dentalSkipBtn.click();
    }

    public void clickFirstTwoCompareBoxes() {
        basicActions.waitForElementToBePresent( comparePlanBox1, 10 );
        comparePlanBox1.click();
        comparePlanBox2.click();
    }

    public void clickCompareOnDentalPlanResults() {
        basicActions.waitForElementToBePresent( btnCompareOnDentalPlanResults, 10 );
        btnCompareOnDentalPlanResults.click();
    }

    public void clickCoverageLevelDropdown() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBeClickableWithRetries( dropdownInsuranceCompany,10 );
        basicActions.waitForElementToBePresent( dropdownCoverageLevel, 20 );
        dropdownCoverageLevel.click();

    }

    public void selectfromCoverageLevelList(String coverageLevel) {
        basicActions.waitForElementToBeClickableWithRetries( dropdownCoverageLevel,10 );
        String coveragePath = "//*[text()='" + coverageLevel + "']";
        basicActions.getDriver().findElement( By.xpath( coveragePath ) ).click();
    }

    public void clickDentalInsuranceCompanyDropdown() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBeClickableWithRetries( dropdownCoverageLevel,10 );
        basicActions.waitForElementToBeClickableWithRetries( dropdownInsuranceCompany, 10 );
        dropdownInsuranceCompany.click();
    }

    public void selectfromInsuranceCompanyList(String insuranceCompany) {
        String companyPath = "//*[text()='" + insuranceCompany + "']";
        basicActions.getDriver().findElement( By.xpath( companyPath ) ).click();
    }

    public void validateDentalPlanText(int index, String dentalPlanText) {
        basicActions.waitForElementToBeClickableWithRetries( dropdownCoverageLevel, 10 );
        String indexString = String.valueOf( index );
        String planID = "PlanResults-PlanName_" + indexString;
        WebElement ePlanID = basicActions.getDriver().findElement( By.id( planID ) );
        String expectedText = ePlanID.getText();
        expectedText.equals( dentalPlanText );
    }

    public void validatePediatric() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( disclaimerDental,10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany,10 );
        softAssert.assertEquals( pediatricdental1.getText(), "Cigna Dental Pediatric" );
        softAssert.assertEquals( pediatricdental2.getText(), "Cigna Dental Family + Pediatric" );
        softAssert.assertEquals( pediatricdental3.getText(), "Delta Dental of Colorado Pediatric Enhanced Plan" );
        softAssert.assertAll();
    }

    public void validatePediatricFalse() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( disclaimerDental,10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany,10 );
        softAssert.assertEquals( pediatricdental1.getText(), "EssentialSmile Colorado - Total Care", "Cigna Dental Pediatric not appearing" );
        softAssert.assertEquals( pediatricdental2.getText(), "Anthem Dental Family Value", "Cigna Dental Family + Pediatric not appearing" );
        softAssert.assertEquals( pediatricdental3.getText(), "Delta Dental of Colorado Family Value Plan", "Delta Dental of Colorado Pediatric Enhanced Plan not appearing" );
        softAssert.assertAll();
    }

    public void validateAdultPediatric() {
        basicActions.waitForElementToDisappear(spinner,15);
        basicActions.waitForElementToBePresent( disclaimerDental,10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany,10 );
        softAssert.assertEquals(pediatricdental1.getText(),"Delta Dental of Colorado Pediatric Comprehensive Plan");
        softAssert.assertEquals(pediatricdental2.getText(),"Anthem Dental Family");
        softAssert.assertEquals(pediatricdental3.getText(),"Cigna Dental Family + Pediatric");
        softAssert.assertAll();
        }
    public void selectDentalPlan(String dentalPlanNames){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setDentalPlan(dentalPlanNames);
        SharedData.setPrimaryMember(subscriber);
        List<MemberDetails> memberslist = SharedData.getMembers();
        if(memberslist !=null){
            for (int i = 0; i < memberslist.size(); i++) {
                memberslist.get(i).setDentalPlan(dentalPlanNames);
            }
        }
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