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

    @FindBy(id = "PlanResults-RemovePlan_1")
    WebElement removeplan;

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

    @FindBy(css = ".header-1")
    WebElement dentalplanheader;

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

    @FindBy(xpath = "(//div[@class='col detail-pane'])[1]")
    WebElement firstDentalPlanCard;

    @FindBy(xpath = "(//*[@id='DentalPlanResults-MonthlyPremium'])[1]")
    WebElement monthlypremiumdropdown;

    @FindBy(xpath = "//div[@id='MPDcollapse'] //span[contains(@class,'ngx-slider-limit ngx-slider-floor')]")
    WebElement txtpremiumamnt;

    @FindBy(id = "DentalPlanResults-SaveAndExit")
    WebElement Saveandexit;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> dentalPlanNamesList;

    @FindBy(id = "AdultDedToolTip_1")
    WebElement  TTAdultDeductable1;

    @FindBy(id = "PedDedToolTip_1")
    WebElement  TTPedDeductable1;

    @FindBy(id = "OutOfPocketMaxToolTip_1")
    WebElement  TTOutOfPocketDeductable1;

    @FindBy(id ="")
    WebElement TTFinancialHelp1;

    public void DentalresultspagetextValidation(){
        basicActions.waitForElementToDisappear(spinner, 30);
        softAssert.assertTrue(dentalplanheader.isDisplayed(), "Dental plan heading did not match");
        softAssert.assertTrue(firstDentalPlanCard.getText().contains("Adult Deductible"), "Adult deductible text is not displayed");
        softAssert.assertTrue(firstDentalPlanCard.getText().contains("Out-of-Pocket Max"), "Out of pocket max text is not displayed");
        softAssert.assertTrue(firstDentalPlanCard.getText().contains("Pediatric Deductible (Under 18)"), "Pediatric deductible text is not displayed");
        softAssert.assertTrue(firstDentalPlanCard.getText().contains("Plan Details"), "Plan details text is not displayed");
        softAssert.assertTrue(firstDentalPlanCard.getText().contains("Select this Plan"), "Select this plan text is not displayed");
        softAssert.assertTrue(btnGoBack.getText().contains("Go Back"), "Go Back text is not displayed");
        softAssert.assertTrue(dentalSkipBtn.getText().contains("Skip"), "Skip text is not displayed");
        softAssert.assertTrue(continueBtnOnDentalPlanResults.getText().contains("Continue"), "Continue text is not displayed");
        softAssert.assertTrue(Saveandexit.getText().contains("Save and Exit"), "Save and Exit text is not displayed");
        softAssert.assertAll();
    }

    public void iGetFirstDentalPlanName() {
        basicActions.waitForElementListToBePresent( dentalPlanNames, 10 );
        SharedData.setFirstPlanNameOnDentalResultsPage( dentalPlanNames.get( 0 ).getText() );
    }

    public void selectFirstDentalPlan() {
        basicActions.waitForElementToDisappear( spinner,10 );
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

    public void removeplanondentalplanresults() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( removeplan, 15 );
        removeplan.click();
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
        softAssert.assertEquals( pediatricdental1.getText(), "Anthem Dental Family", "Cigna Dental Pediatric not appearing" );
        softAssert.assertEquals( pediatricdental2.getText(), "Delta Dental of Colorado Family Basic Plan", "Cigna Dental Family + Pediatric not appearing" );
        softAssert.assertEquals( pediatricdental3.getText(), "Cigna Dental Family + Pediatric", "Delta Dental of Colorado Pediatric Enhanced Plan not appearing" );
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
        basicActions.waitForElementToDisappear(spinner, 30);
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

    public void SelectSpecificDentalPlanPerGrp(String SpecificPlan,String member){

        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementToBePresent(dentalplanheader,20);

        String headerText = dentalplanheader.getText();
        if (headerText.contains(member)) {
            clickSkip();
        } else {

            selectDentalPlan(SpecificPlan);
             clickContinueOnDentalResultsPage();
                System.out.println("Selected plan: " + SpecificPlan);

        }

    }

    public void verifyPremiumAmountIsZero() {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(txtpremiumamnt, 30);
        softAssert.assertEquals(txtpremiumamnt.getAttribute("innerText"), "0");
        softAssert.assertAll();
    }

    public void getDentalPlanMarketNames() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(dentalPlanNamesList, 20);
        while (true) {
            getPlanNamesFromPage();
            if (checkIfLastPage()) {
                break;
            }
            paginateRight();
        }
    }

    private Boolean checkIfLastPage() {
        basicActions.waitForElementListToBePresent(dentalPlanNamesList, 10);
        return !basicActions.waitForElementToBePresent(nextPageArrow, 10);
    }

    private void getPlanNamesFromPage(){
        List<String> dentalPlansList = SharedData.getDentalPlansList();
        if(dentalPlansList==null){
            dentalPlansList = new ArrayList<>();
        }
        for (WebElement planName : dentalPlanNamesList) {
            dentalPlansList.add(planName.getText());
        }
        SharedData.setDentalPlansList(dentalPlansList);
    }

    public void validateTotalDentalPlans(int expectedCount){
        int dentalPlansListcount = SharedData.getDentalPlansList().size();
        softAssert.assertEquals(dentalPlansListcount, expectedCount, "The number of dentals plans does not match the expected count");
        softAssert.assertAll();

    }

    public void validateToolTipText(String language){
        basicActions.waitForElementToDisappear( spinner,30 );
        switch(language){
            case "English":
                validateToolTipsDentalPlanResultsPageEnglish();
                break;
            case "Spanish":
                validateToolTipsDentalPlanResultsPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);

        }


    }

    public void validateToolTipsDentalPlanResultsPageEnglish() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( disclaimerDental,10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany,10 );
        softAssert.assertEquals( TTAdultDeductable1.getText(), "The amount you must spend on covered dental services before your insurance company starts to pay a percentage of your bills. This adult deductible amount applies to someone 19 or older." );
        softAssert.assertEquals( TTPedDeductable1.getText(), "The amount you must spend on covered dental services before your insurance company starts to pay a percentage of your bills. This pediatric deductible amount applies to someone 18 or younger." );
        softAssert.assertEquals( TTOutOfPocketDeductable1.getText(), "A predetermined, limited amount of money that an individual or members of your family must pay before an insurance company (or self-insured employer) will pay 100% of an individual's covered, in-network dental care expenses." );
        //softAssert.assertEquals( TTFinancialHelp1.getText(), "Tax credits are designed to help individuals with the cost of their dental coverage embedded in medical plans. If tax credits have been applied to your health insurance plan, the amount will be displayed here." );
        softAssert.assertAll();
    }

    public void validateToolTipsDentalPlanResultsPageSpanish() {
        basicActions.waitForElementToDisappear(spinner,15);
        basicActions.waitForElementToBePresent( disclaimerDental,10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany,10 );
        softAssert.assertEquals( TTAdultDeductable1.getText(),"La cantidad que debe desembolsar por servicios dentales cubiertos antes de que su compañía de seguros comience a pagar un porcentaje de sus facturas. Esta cantidad de deducible de adultos se aplica a las personas mayores de 19 años.");
        softAssert.assertEquals( TTPedDeductable1.getText(),"La cantidad que debe desembolsar por servicios dentales cubiertos antes de que su compañía de seguros comience a pagar un porcentaje de sus facturas. Esta cantidad de deducible pediátrico se aplica a personas de 18 años o menos.");
        softAssert.assertEquals( TTOutOfPocketDeductable1.getText(), "Una cantidad de dinero predeterminada y limitada que un individuo los miembros de su plan familiar deben pagar antes de que una compañía de seguros (o un empleador autoasegurado) pague el 100% de los gastos dentales de dicho individuo cubiertos dentro de la red." );
        //softAssert.assertEquals( TTFinancialHelp1.getText(),"Los créditos fiscales están diseñados para ayudar a los individuos con el costo de su cobertura dental incorporada en los planes médicos. Si se aplicaron créditos fiscales a su plan de seguro de salud, el importe se mostrará aquí.");
        softAssert.assertAll();
    }



}