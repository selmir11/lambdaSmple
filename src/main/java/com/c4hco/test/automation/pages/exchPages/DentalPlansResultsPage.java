package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @FindBy(css = "#PlanResults-PlanCompareCheckbox_1")
    WebElement comparePlanBox1;

    @FindBy(css = "#PlanResults-PlanCompareCheckbox_2")
    WebElement comparePlanBox2;

    @FindBy(id = "DentalPlanResults-ComparePlans")
    WebElement btnCompareOnDentalPlanResults;

    @FindBy(css = "#DentalPlanResults-CoverageLevel")
    WebElement dropdownCoverageLevel;

    @FindBy(id = "DentalPlanResults-Continue")
    WebElement continueBtnOnDentalPlanResults;

    @FindBy(xpath = "//*[@class = 'btn-primary button-disabled']")
    WebElement continueBtnDisabledOnDentalPlanResults;

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

    @FindBy(id = "DentalPlanResults-ResetFilters")
    WebElement resetButton;

    @FindBy(id = "PlanResults-PlanName_1")
    WebElement pediatricdental1;

    @FindBy(id = "PlanResults-PlanName_2")
    WebElement pediatricdental2;

    @FindBy(id = "PlanResults-PlanName_3")
    WebElement pediatricdental3;

    @FindBy(xpath = "(//div[@class='col detail-pane'])[1]")
    WebElement firstDentalPlanCard;

    @FindBy(xpath = "//div[@id='MPDcollapse'] //span[contains(@class,'ngx-slider-limit ngx-slider-floor')]")
    WebElement txtpremiumamnt;

    @FindBy(id = "DentalPlanResults-SaveAndExit")
    WebElement Saveandexit;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> dentalPlanNamesList;

    @FindBy(id = "ngb-tooltip-10")
    WebElement TTAdultDeductable1;
    @FindBy(xpath = "//*[@id='AdultDedToolTip_1'] ")
    WebElement underTTAdultDeductable1;

    @FindBy(id = "ngb-tooltip-12")
    WebElement TTPedDeductable1;
    @FindBy(xpath = "//*[@id='PedDedToolTip_1'] ")
    WebElement underTTPedDeductable1;

    @FindBy(id = "ngb-tooltip-11")
    WebElement TTOutOfPocketDeductable1;
    @FindBy(xpath = "//*[@id='OutOfPocketMaxToolTip_1'] ")
    WebElement underTTOutOfPocketDeductable1;

    @FindBy(css = "#dropdownBasic1")
    WebElement premiumSortingDropdown;

    @FindBy(css = ".premium-summary .c4-type-header-md")
    List<WebElement> monthlyPremiumValue;

    @FindBy(id = "DentalPlanResults-CoverageLevel_0-input")
    WebElement verifyLowLevel;

    @FindBy(id = "DentalPlanResults-CoverageLevel_0")
    WebElement verifyLowLevelText;

    @FindBy(id = "DentalPlanResults-CoverageLevel_1-input")
    WebElement verifyHighLevel;

    @FindBy(id = "DentalPlanResults-CoverageLevel_1")
    WebElement verifyHighLevelText;

    @FindBy(id = "DentalPlanResults-InsuranceCompany_0")
    WebElement verifyAnthem;

    @FindBy(id = "DentalPlanResults-InsuranceCompany_1")
    WebElement verifyCigna;

    @FindBy(id = "DentalPlanResults-InsuranceCompany_2")
    WebElement verifyDelta;

    @FindBy(id = "DentalPlanResults-InsuranceCompany_3")
    WebElement verifySolstice;


    @FindBy(id = "PlanResults-CurrentPlanLabel")
    WebElement greenDentalBannerText;

    @FindBy(id="PlanResults-CurrentPlanWarningMessage")
    WebElement planDentalNotAvailableText;


    public void clickResetButton() {
        basicActions.waitForElementToDisappear( spinner, 50 );
        basicActions.waitForElementToBePresentWithRetries( resetButton, 20 );
        resetButton.click();

    }

    public void DentalresultspagetextValidation() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        softAssert.assertTrue( dentalplanheader.isDisplayed(), "Dental plan heading did not match" );
        softAssert.assertTrue( firstDentalPlanCard.getText().contains( "Adult Deductible" ), "Adult deductible text is not displayed" );
        softAssert.assertTrue( firstDentalPlanCard.getText().contains( "Out-of-Pocket Max" ), "Out of pocket max text is not displayed" );
        softAssert.assertTrue( firstDentalPlanCard.getText().contains( "Pediatric Deductible" ), "Pediatric deductible text is not displayed" );
        softAssert.assertTrue( firstDentalPlanCard.getText().contains( "Plan Details" ), "Plan details text is not displayed" );
        softAssert.assertTrue( firstDentalPlanCard.getText().contains( "Select this Plan" ), "Select this plan text is not displayed" );
        softAssert.assertTrue( btnGoBack.getText().contains( "Go Back" ), "Go Back text is not displayed" );
        softAssert.assertTrue( dentalSkipBtn.getText().contains( "Skip" ), "Skip text is not displayed" );
        softAssert.assertTrue( continueBtnOnDentalPlanResults.getText().contains( "Continue" ), "Continue text is not displayed" );
        softAssert.assertTrue( Saveandexit.getText().contains( "Save and Exit" ), "Save and Exit text is not displayed" );
        softAssert.assertAll();
    }

    public void iGetFirstDentalPlanName() {
        basicActions.waitForElementListToBePresent( dentalPlanNames, 10 );
        SharedData.setFirstPlanNameOnDentalResultsPage( dentalPlanNames.get( 0 ).getText() );
    }

    public void selectFirstDentalPlan() {
        basicActions.waitForElementToDisappear( spinner, 10 );
        basicActions.waitForElementToBeClickable( selectFirstDentalPlanBtn, 20 );
        selectFirstDentalPlanBtn.click();
    }

    public void clickFirstPlanDetailBtn() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBeClickableWithRetries( selectFirstDentalDetailButton, 15 );
        selectFirstDentalDetailButton.click();
    }

    public void clickContinueOnDentalResultsPage() {
        basicActions.waitForElementToDisappear( spinner, 160 );
        basicActions.waitForElementToBePresentWithRetries( continueBtnOnDentalPlanResults, 160 );
        basicActions.scrollToElement( continueBtnOnDentalPlanResults );
        continueBtnOnDentalPlanResults.click();
    }

    public void removeplanondentalplanresults() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( removeplan, 15 );
        removeplan.click();
    }

    public void clickGoBack() {
        basicActions.waitForElementToDisappear( spinner, 50 );
        basicActions.waitForElementToBePresentWithRetries( btnGoBack, 30 );
        basicActions.scrollToElement( btnGoBack );
        btnGoBack.click();

    }

    public void clickSkip() {
        basicActions.waitForElementToDisappear( spinner, 70 );
        basicActions.waitForElementToBePresentWithRetries( dentalSkipBtn, 30 );
        dentalSkipBtn.click();
    }

    private void setSkippedGroupNumber(String groupNum) {
        List<MemberDetails> allEligMembers = basicActions.getAllDentalEligibleMemInfo();
        for (MemberDetails member : allEligMembers) {
            if (member.getDenGroupInd().equals( groupNum )) {
                member.setHasDentalPlan( false );
            }
        }
        clickSkip();
    }

    public void clickFirstTwoCompareBoxes() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresentWithRetries( comparePlanBox1, 40 );
        comparePlanBox1.click();
        comparePlanBox2.click();
    }

    public void clickCompareOnDentalPlanResults() {
        basicActions.waitForElementToBePresent( btnCompareOnDentalPlanResults, 10 );
        btnCompareOnDentalPlanResults.click();
    }

    public void clickCoverageLevelDropdown() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBeClickableWithRetries( dropdownInsuranceCompany, 10 );
        basicActions.waitForElementToBePresent( dropdownCoverageLevel, 20 );
        dropdownCoverageLevel.click();

    }

    public void selectfromCoverageLevelList(String coverageLevel) {
        basicActions.waitForElementToBePresentWithRetries( dropdownCoverageLevel,30 );
        switch (coverageLevel) {
            case "Low":
                basicActions.waitForElementToBePresentWithRetries( verifyLowLevel,20 );
                softAssert.assertEquals( verifyLowLevelText.getText(), "Low" );
                softAssert.assertAll();
                verifyLowLevel.click();
                break;
            case "High":
                basicActions.waitForElementToBePresentWithRetries( verifyHighLevel,20 );
                softAssert.assertEquals( verifyHighLevelText.getText(), "High" );
                softAssert.assertAll();
                verifyHighLevel.click();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + dropdownCoverageLevel );

        }
    }

    public void clickDentalInsuranceCompanyDropdown() {
        basicActions.waitForElementToDisappear( spinner, 120 );
        basicActions.waitForElementToBePresentWithRetries( dropdownCoverageLevel, 110 );
        basicActions.waitForElementToBePresentWithRetries( dropdownInsuranceCompany, 110 );
        dropdownInsuranceCompany.click();
    }

    public void selectfromInsuranceCompanyList(String insuranceCompany) {
        basicActions.waitForElementToBePresentWithRetries( dropdownInsuranceCompany,30 );
        switch (insuranceCompany) {
            case "Anthem Dental":
                basicActions.waitForElementToBePresentWithRetries( verifyAnthem,20 );
                softAssert.assertEquals( verifyAnthem.getText(), "Anthem Dental" );
                softAssert.assertAll();
                verifyAnthem.click();
                break;
            case "Cigna Healthcare":
                basicActions.waitForElementToBePresentWithRetries( verifyCigna,20 );
                softAssert.assertEquals( verifyCigna.getText(), "Cigna Healthcare" );
                softAssert.assertAll();
                verifyCigna.click();
                break;
            case "Delta Dental":
                basicActions.waitForElementToBePresentWithRetries( verifyDelta,20 );
                softAssert.assertEquals( verifyDelta.getText(), "Delta Dental" );
                softAssert.assertAll();
                verifyDelta.click();
                break;
            case "Solstice Healthplans / UHC":
                basicActions.waitForElementToBePresentWithRetries( verifySolstice,20 );
                softAssert.assertEquals( verifySolstice.getText(), "Solstice Healthplans /UHC" );
                softAssert.assertAll();
                verifySolstice.click();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + dropdownCoverageLevel );

        }
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
        basicActions.waitForElementToBePresent( disclaimerDental, 10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany, 10 );
        softAssert.assertEquals( pediatricdental1.getText(), "Cigna Dental Family + Pediatric" );
        softAssert.assertEquals( pediatricdental2.getText(), "Cigna Dental Pediatric" );
        softAssert.assertEquals( pediatricdental3.getText(), "Anthem Dental Family Value" );
        softAssert.assertAll();
    }

    public void validatePediatricFalse() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( disclaimerDental, 10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany, 10 );
        softAssert.assertEquals( pediatricdental1.getText(), "Anthem Dental Family Value", "Cigna Dental Pediatric not appearing" );
        softAssert.assertEquals( pediatricdental2.getText(), "EssentialSmile Colorado - Total Care", "Cigna Dental Family + Pediatric not appearing" );
        softAssert.assertEquals( pediatricdental3.getText(), "Delta Dental of Colorado Family Value Plan", "Delta Dental of Colorado Pediatric Enhanced Plan not appearing" );
        softAssert.assertAll();
    }

    public void validateAdultPediatric() {
        basicActions.waitForElementToDisappear( spinner, 15 );
        basicActions.waitForElementToBePresent( disclaimerDental, 10 );
        basicActions.waitForElementToBePresent( dropdownInsuranceCompany, 10 );
        softAssert.assertEquals( pediatricdental1.getText(), "Cigna Dental Pediatric" );
        softAssert.assertEquals( pediatricdental2.getText(), "Delta Dental of Colorado Pediatric Enhanced Plan" );
        softAssert.assertEquals( pediatricdental3.getText(), "Anthem Dental Family Value" );
        softAssert.assertAll();
    }

    public void selectDentalPlan(String dentalPlanNames) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setDentalPlan( dentalPlanNames );
        SharedData.setPrimaryMember( subscriber );
        List<MemberDetails> memberslist = SharedData.getMembers();
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent(dentalplanheader,60);
        if (memberslist != null) {
            for (int i = 0; i < memberslist.size(); i++) {
                memberslist.get( i ).setDentalPlan( dentalPlanNames );
            }
        }
        do {
            optionalInt = checkIfPlanPresent( dentalPlanNames );
            if (optionalInt.isPresent()) {
                clickPlanButton( optionalInt.get() + 1 );
            } else {
                paginateRight();
            }
        } while (optionalInt.isEmpty());
    }

    private Optional<Integer> checkIfPlanPresent(String planName) {
        basicActions.waitForElementToDisappear( spinner, 10 );
        basicActions.waitForElementListToBePresent( dentalPlanNames, 30 );
        return IntStream.range( 0, dentalPlanNames.size() )
                .filter( i -> dentalPlanNames.get( i ).getText().equals( planName ) )
                .boxed()
                .findFirst();
    }

    private void clickPlanButton(int index) {
        basicActions.waitForElementToDisappear(spinner, 60);
        String planID = "PlanResults-SelectThisPlan_" + index;
        WebElement ePlanID = basicActions.getDriver().findElement( By.id( planID ) );
        basicActions.waitForElementToBeClickable( ePlanID, 30 );
        ePlanID.click();
    }

    private void paginateRight() {
        basicActions.waitForElementToBePresent( nextPageArrow, 10 );
        Assert.assertTrue( nextPageArrow.isEnabled(), "Right arrow to click is not enabled!" );
        nextPageArrow.click();
    }

    public void validateDentalPlanCount(String plansCount) {
        basicActions.waitForElementToDisappear( spinner, 120 );
        basicActions.waitForElementToBePresentWithRetries( dentalPlanCount, 60 );
        Assert.assertEquals( dentalPlanCount.getText(), plansCount + " of " + plansCount + " Dental Plans", "Dental plans count did not match" );
    }

    public void validateDentalPlanNames() {
        List<String> dentalPlanNamesList = new ArrayList<>();

        while (true) {
            basicActions.waitForElementListToBePresent( dentalPlanNames, 30 );
            for (WebElement dentalPlanName : dentalPlanNames) {
                dentalPlanNamesList.add( dentalPlanName.getText() );
            }
            basicActions.waitForElementToBePresent( nextPageArrow, 10 );

            if (nextPageArrow.getAttribute( "className" ).contains( "disabled" )) {
                break;
            }

            nextPageArrow.click();
        }
        softAssert.assertEquals( dentalPlanNamesList.size(), Constants.DentalPlanNamesList.size(), "Plan count doesn't match" );
        softAssert.assertEquals( dentalPlanNamesList, Constants.DentalPlanNamesList );
        softAssert.assertAll();
    }

    public void selectDentalPlansForGroups(List<String> plansOfGroups) {
        for (String planOfGroup : plansOfGroups) {
            String[] parts = planOfGroup.split( ":" );
            String plan = parts[1];
            Matcher matcher = Pattern.compile( "\\d+" ).matcher( parts[0] );
            String groupNum = matcher.find() ? matcher.group() : null;

            basicActions.waitForElementToDisappear( spinner, 30 );
            basicActions.wait( 3000 );
            basicActions.waitForElementToBePresent( dentalplanheader, 10 );
            Matcher matcher_header = Pattern.compile( "\\d+" ).matcher( dentalplanheader.getText() );
            String headerGroupNum = matcher_header.find() ? matcher.group() : null;

            Assert.assertEquals( headerGroupNum, groupNum, "Group number from header and step did not match!" );
            if (plan.equals( "skip" )) {
                setSkippedGroupNumber( groupNum );
            } else {
                selectDentalPlanForGrp( plan, groupNum );
            }
        }
    }

    public void selectDentalPlanForGrp(String planName, String grpNum) {
        List<MemberDetails> memberslist = basicActions.getAllDentalEligibleMemInfo();
        basicActions.waitForElementToDisappear( spinner, 30 );
        for (MemberDetails member : memberslist) {
            if (member.getDenGroupInd().equals( grpNum )) {
                member.setDentalPlan( planName );
            }
        }
        do {
            optionalInt = checkIfPlanPresent( planName );
            if (optionalInt.isPresent()) {
                clickPlanButton( optionalInt.get() + 1 );
            } else {
                paginateRight();
            }
        } while (optionalInt.isEmpty());
        clickContinueOnDentalResultsPage();
    }


    public void verifyPremiumAmountIsZero() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( txtpremiumamnt, 30 );
        softAssert.assertEquals( txtpremiumamnt.getAttribute( "innerText" ), "0" );
        softAssert.assertAll();
    }

    public void getDentalPlanMarketNames() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementListToBePresent( dentalPlanNamesList, 20 );
        while (true) {
            getPlanNamesFromPage();
            if (checkIfLastPage()) {
                break;
            }
            paginateRight();
        }
    }

    private Boolean checkIfLastPage() {
        basicActions.waitForElementListToBePresent( dentalPlanNamesList, 10 );
        return !basicActions.waitForElementToBePresent( nextPageArrow, 10 );
    }

    private void getPlanNamesFromPage() {
        List<String> dentalPlansList = SharedData.getDentalPlansList();
        if (dentalPlansList == null) {
            dentalPlansList = new ArrayList<>();
        }
        for (WebElement planName : dentalPlanNamesList) {
            dentalPlansList.add( planName.getText() );
        }
        SharedData.setDentalPlansList( dentalPlansList );
    }

    public void validateTotalDentalPlans(int expectedCount) {
        int dentalPlansListcount = SharedData.getDentalPlansList().size();
        softAssert.assertEquals( dentalPlansListcount, expectedCount, "The number of dentals plans does not match the expected count" );
        softAssert.assertAll();

    }

    public void validateToolTipText(String language) {
        basicActions.waitForElementToDisappear( spinner, 30 );
        switch (language) {
            case "English":
                validateToolTipsDentalPlanResultsPageEnglish();
                break;
            case "Spanish":
                validateToolTipsDentalPlanResultsPageSpanish();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );

        }
    }


    public void validateToolTipsDentalPlanResultsPageEnglish() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBePresent( disclaimerDental, 10 );
        basicActions.click( underTTAdultDeductable1 );
        basicActions.waitForElementToBePresent( TTAdultDeductable1, 20 );
        softAssert.assertEquals( TTAdultDeductable1.getText(), "The amount you must spend on covered dental services before your insurance company starts to pay a percentage of your bills. This adult deductible amount applies to someone 19 or older." );
        basicActions.click( underTTPedDeductable1 );
        basicActions.waitForElementToBePresent( TTPedDeductable1, 20 );
        softAssert.assertEquals( TTPedDeductable1.getText(), "The amount you must spend on covered dental services before your insurance company starts to pay a percentage of your bills. This pediatric deductible amount applies to someone 18 or younger." );
        basicActions.click( underTTOutOfPocketDeductable1 );
        basicActions.waitForElementToBePresent( TTOutOfPocketDeductable1, 20 );
        softAssert.assertEquals( TTOutOfPocketDeductable1.getText(), "A predetermined, limited amount of money that an individual or members of your family must pay before an insurance company (or self-insured employer) will pay 100% of an individual's covered, in-network dental care expenses." );
        softAssert.assertAll();
    }

    public void validateToolTipsDentalPlanResultsPageSpanish() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBePresent( disclaimerDental, 10 );
        basicActions.click( underTTAdultDeductable1 );
        basicActions.waitForElementToBePresent( TTAdultDeductable1, 20 );
        softAssert.assertEquals( TTAdultDeductable1.getText(), "La cantidad que debe desembolsar por servicios dentales cubiertos antes de que su compa\u00f1\u00eda de seguros comience a pagar un porcentaje de sus facturas. Esta cantidad de deducible de adultos se aplica a las personas mayores de 19 a\u00f1os." );
        basicActions.click( underTTPedDeductable1 );
        basicActions.waitForElementToBePresent( TTPedDeductable1, 20 );
        softAssert.assertEquals( TTPedDeductable1.getText(), "La cantidad que debe desembolsar por servicios dentales cubiertos antes de que su compa\u00f1\u00eda de seguros comience a pagar un porcentaje de sus facturas. Esta cantidad de deducible pedi\u00e1trico se aplica a personas de 18 a\u00f1os o menos." );
        basicActions.click( underTTOutOfPocketDeductable1 );
        basicActions.waitForElementToBePresent( TTOutOfPocketDeductable1, 20 );
        softAssert.assertEquals( TTOutOfPocketDeductable1.getText(), "Una cantidad de dinero predeterminada y limitada que un individuo los miembros de su plan familiar deben pagar antes de que una compa\u00f1\u00eda de seguros (o un empleador autoasegurado) pague el 100% de los gastos dentales de dicho individuo cubiertos dentro de la red." );
        softAssert.assertAll();
    }

    public void clickSortingDropdown(String sortingValue) {
        basicActions.waitForElementToDisappear( spinner, 40 );
        basicActions.waitForElementToBePresentWithRetries( premiumSortingDropdown, 30 );
        premiumSortingDropdown.click();
        WebElement value = basicActions.getDriver().findElement( By.xpath( "//strong[contains(text(),'" + sortingValue + "')]" ) );
        value.click();
    }

    public void evaluateSortingValue(String sortingTypeSelection) {
        basicActions.waitForElementToDisappear( spinner, 30 );
        while (basicActions.elementExists(By.xpath( "//a[@class='ng-star-inserted']" ) )) {
            try {
                basicActions.waitForElementToDisappear( spinner, 10 );
                basicActions.waitForElementToBePresent( monthlyPremiumValue.get( 0 ), 30 );

                if (sortingTypeSelection.contains( "Monthly Premium- Low to High" )) {
                    Assert.assertTrue( basicActions.isSortedAscending( monthlyPremiumValue ), "Dental Plan sorting for expected Monthly Premium- Low to High" );
                } else if (sortingTypeSelection.contains( "Monthly Premium- High to Low" )) {
                    Assert.assertTrue( basicActions.isSortedDescending( monthlyPremiumValue ), "Dental Plan sorting for Monthly Premium- High to Low" );
                } else if (sortingTypeSelection.contains( "Annual Deductible- Low to High" )) {
                    List<WebElement> webElementList = new ArrayList<>();


                    for (int i = 1; i <= dentalPlanNamesList.size(); i += 2) {
                        String dynamicXPath = "((//app-dental-plan-card //*[contains(text(),'Deductible')]//ancestor-or-self::div[@class='col c4-type-body-sm'] //div[@class='row details-data-row'])[" + i + "]/div/span)[1]";
                        WebElement element = basicActions.getDriver().findElement( By.xpath( dynamicXPath ) );
                        webElementList.add( element );
                    }
                    Assert.assertTrue( basicActions.isSortedAscending( webElementList ), "Dental Plan sorting for Annual Deductible- Low to High" );
                } else if (sortingTypeSelection.contains( "Annual Deductible- High to Low" )) {
                    List<WebElement> webElementList = new ArrayList<>();

                    for (int i = 1; i <= dentalPlanNamesList.size(); i += 2) {
                        String dynamicXPath = "((//app-dental-plan-card //*[contains(text(),'Deductible')]//ancestor-or-self::div[@class='col c4-type-body-sm'] //div[@class='row details-data-row'])[" + i + "]/div/span)[1]";
                        WebElement element = basicActions.getDriver().findElement( By.xpath( dynamicXPath ) );
                        webElementList.add( element );
                    }
                    Assert.assertTrue( basicActions.isSortedDescending( webElementList ), "Dental Plan sorting for Annual Deductible- High to Low" );
                }
                nextPageArrow.click();
            } catch (Exception e) {
                break; // Break out of the loop if an error occurs
            }
        }
    }

    public void evaluateSpanishSortingValues(String sortingTypeSelection) {

        basicActions.waitForElementToDisappear( spinner, 30 );
        while (basicActions.elementExists(By.xpath( "//a[@class='ng-star-inserted']" ) )) {
            try {
                basicActions.waitForElementToDisappear( spinner, 10 );
                basicActions.waitForElementToBePresent( monthlyPremiumValue.get( 0 ), 30 );

                if (sortingTypeSelection.contains( "Prima mensual- Baja a alta" )) {
                    Assert.assertTrue( basicActions.isSortedAscending( monthlyPremiumValue ), "Spanish Dental Plan sorting for expected Monthly Premium- Low to High" );
                } else if (sortingTypeSelection.contains( "Prima mensual- Alta a baja" )) {
                    Assert.assertTrue( basicActions.isSortedDescending( monthlyPremiumValue ), "Spanish Dental Plan sorting for Monthly Premium- High to Low" );
                } else if (sortingTypeSelection.contains( "Deducible anual- Bajo a alto" )) {
                    List<WebElement> webElementList = new ArrayList<>();


                    for (int i = 1; i <= dentalPlanNamesList.size(); i += 2) {
                        String dynamicXPath = "((//app-dental-plan-card //*[contains(text(),'Deductible')]//ancestor-or-self::div[@class='col c4-type-body-sm'] //div[@class='row details-data-row'])[" + i + "]/div/span)[1]";
                        WebElement element = basicActions.getDriver().findElement( By.xpath( dynamicXPath ) );
                        webElementList.add( element );
                    }
                    Assert.assertTrue( basicActions.isSortedAscending( webElementList ), "Spanish Dental Plan sorting for Annual Deductible- Low to High" );
                } else if (sortingTypeSelection.contains( "Deducible anual- Alto a bajo" )) {
                    List<WebElement> webElementList = new ArrayList<>();

                    for (int i = 1; i <= dentalPlanNamesList.size(); i += 2) {
                        String dynamicXPath = "((//app-dental-plan-card //*[contains(text(),'Deductible')]//ancestor-or-self::div[@class='col c4-type-body-sm'] //div[@class='row details-data-row'])[" + i + "]/div/span)[1]";
                        WebElement element = basicActions.getDriver().findElement( By.xpath( dynamicXPath ) );
                        webElementList.add( element );
                    }
                    Assert.assertTrue( basicActions.isSortedDescending( webElementList ), "Spanish Dental Plan sorting for Annual Deductible- High to Low" );
                }
                nextPageArrow.click();
            } catch (Exception e) {
                break; // Break out of the loop if an error occurs

            }
        }
    }

    public void validateGreenBannerText(String language) {
        basicActions.waitForElementToDisappear( spinner, 30 );
        switch (language) {
            case "English":
                validateDentalGreenBannerTxt();
                break;
            case "Spanish":
                validateDentalGreenBannerSPTxt();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );

        }
    }
    public void validateDentalGreenBannerTxt(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( greenDentalBannerText,20);
        softAssert.assertEquals(greenDentalBannerText.getText(), "Current plan");
        softAssert.assertAll();
    }
    public void validateDentalGreenBannerSPTxt(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( greenDentalBannerText,20);
        softAssert.assertEquals(greenDentalBannerText.getText(), "Plan actual");
        softAssert.assertAll();
    }

    public void validatePlanNotAvailableTxt(String language) {
        basicActions.waitForElementToDisappear( spinner, 30 );
        switch (language) {
            case "English":
                validateDentalPlanNotAvailableTxt();
                break;
            case "Spanish":
                validateDentalPlanNotAvailableSPTxt();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );

        }
    }
    public void validateDentalPlanNotAvailableTxt(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( planDentalNotAvailableText,20);
        softAssert.assertEquals(planDentalNotAvailableText.getText(), "Your current plan is not available, but you can choose a new one from the options below.");
        softAssert.assertAll();
    }
    public void validateDentalPlanNotAvailableSPTxt(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( planDentalNotAvailableText,20);
        softAssert.assertEquals(planDentalNotAvailableText.getText(), "Su plan actual no est\u00E1 disponible, pero puede elegir uno nuevo de entre las opciones mostradas a continuaci\u00F3n.");
        softAssert.assertAll();
    }

    public void validateContinueButtonDisabled() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( continueBtnDisabledOnDentalPlanResults, 10 );
        Assert.assertTrue( continueBtnDisabledOnDentalPlanResults.isEnabled(), "Continue button is enabled" );
    }
}