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
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MedicalPlansCoCoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    Optional<Integer> optionalInt;

    public MedicalPlansCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#PlanResults-SelectThisPlan_1")
    public WebElement selectFirstPlan;

    @FindBy(xpath = "//*[@id='SHP-MedicalPlanResults-Continue'] | //*[@id='MedicalPlanResults-Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id='PlanResults-InsuranceCompany']")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "PlanResults-MetalTier")
    WebElement metalTierDropdown;
    @FindBy(id = "PlanResults-PlanCompareCheckbox_1")
    WebElement selectFirstComparebox;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_2")
    WebElement selectSecondComparebox;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_3")
    WebElement selectSThirdComparebox;

    @FindBy(id = "PlanResults-ComparePlans")
    WebElement selectCompareButton;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> medicalPlanNamesList;

    @FindBy(css = "pagination-template .pagination-next a")
    WebElement nextPageArrow;

    @FindBy(css = ".premium-summary .c4-type-header-md")
    List<WebElement> mothlyPremiumValue;

    @FindBy(css = "#dropdownBasic1")
    WebElement premiumSortingDropdown;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "PlanResults-MetalTier_0-input")
    WebElement silverEnhancedBox;

    @FindBy(xpath = "//*[@class = 'col-12 col-xl-5 responsive-text-align-left ng-star-inserted']")
    WebElement planTotalsCoCo;

    @FindBy(id = "planQualityRatingsLink")
    WebElement planQualityRatingsLink;

    @FindBy(id = "PlanResults-PlanDetails_1")
    WebElement firstPlanDetailsbtn;

    @FindBy(id = "MedicalPlanResults-GoBack")
    WebElement goBackbtn;

    @FindBy(id = "PlanResults-MonthlyPremium_1")
    WebElement planIndividualTotalCoCo;

    @FindBy(css = ".disclaimer.body-text-2")
    WebElement planHeaderdetails;

    @FindBy(css = ".header-2.text-start")
    WebElement planHeaderTwodetails;

    @FindBy(css = ".filter-section.filterText.body-text-1")
    List<WebElement> filterText;

    @FindBy(id = "PlanResults-ResetFilters")
    WebElement resetFilter;

    @FindBy(xpath = "//button[@id='dropdownBasic1'] //strong")
    WebElement textSortBy;

    @FindBy(xpath = "(//div[@class='compare-checkbox-container float-end d-inline-flex'])[1]")
    WebElement textMedicalCompare;

    @FindBy(id = "MedicalPlanResults-SaveAndExit")
    WebElement saveAndExitBtn;

    @FindBy(id = "MedicalPlanResults-Skip")
    WebElement skipBtn;

    @FindBy(id = "planQualityRatings")
    WebElement planQualityRatingtxt;

    public void selectFirstMedicalPlanCoCo() {
        basicActions.waitForElementToBeClickable(selectFirstPlan, 20);
        selectFirstPlan.click();
    }

    public void selectContinueMedicalPlansCoCo() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBeClickableWithRetries(continueButton, 20);
        continueButton.click();
    }

    public void clickInsuranceCompanyDropdown() {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresentWithRetries(insuranceCompanyDropdown, 40);
        insuranceCompanyDropdown.click();

    }

    public void clickMetalTierDropdown() {
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(metalTierDropdown, 30);
        metalTierDropdown.click();

    }

    public void selectfromMetalTierList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void selectSilverEnhancedBox() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(silverEnhancedBox, 10);
        silverEnhancedBox.click();
    }

    public void validateCOCOPlanTotals(String planTotal) {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(planTotalsCoCo, 20);
        Assert.assertEquals(planTotalsCoCo.getText(), planTotal + " of " + planTotal + " Medical Plans", "Medical plans count did not match");

    }

    public void validateSESCOCOPlanTotals(String sesPlanTotal) {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(planTotalsCoCo, 20);
        Assert.assertEquals(planTotalsCoCo.getText(), sesPlanTotal + " of 24 Medical Plans", "Medical plans count did not match");

    }

    public void validateCOCOPlanIndividualPremium(int index, String planIndividualTotal) {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(planIndividualTotalCoCo, 20);
        String indexString = String.valueOf(index); //turns the int index into a string value.
        String planIndividualPremium = "PlanResults-MonthlyPremium_" + indexString; //sets the ID String using the index
        WebElement ePlanPremiumID = basicActions.getDriver().findElement(By.id(planIndividualPremium)); //sets the Web element based on the ID
        String expectedText = ePlanPremiumID.getText();
        expectedText.equals(planIndividualTotal); // compares the expected text gathered in previous line to the planText passed into the function.
    }

    public void selectfromProviderList(String Selecting) {
        basicActions.waitForElementToDisappear(spinner, 20);
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

    public void selectPlanstoCompare() {
        basicActions.waitForElementToBePresent(insuranceCompanyDropdown, 20);
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

    private void clickPlanButton(int index) {
        String planID = "PlanResults-SelectThisPlan_" + index;
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID));
        basicActions.waitForElementToBeClickable(ePlanID, 10);
        ePlanID.click();
    }

    private void paginateRight() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(nextPageArrow, 10);
        Assert.assertTrue(nextPageArrow.isEnabled(), "Right arrow to click is not enabled!");
        basicActions.scrollToElement(nextPageArrow);
        nextPageArrow.click();
    }

    public void selectCoCoMedicalplan(String planName) {
        basicActions.waitForElementToDisappear(spinner, 20);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setMedicalPlan(planName);
        SharedData.setPrimaryMember(subscriber);
        do {
            optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                clickPlanButton(optionalInt.get() + 1);
            } else {
                paginateRight();
            }
        } while (optionalInt.isEmpty());
    }

    public void clickSortingDropdown(String sortingValue) {
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(premiumSortingDropdown, 30);
        premiumSortingDropdown.click();
        WebElement value = basicActions.getDriver().findElement(By.xpath("//strong[contains(text(),'" + sortingValue + "')]"));
        value.click();
    }

    public void evaluateSortingValue(String sortingTypeSelection) {
        while (basicActions.elementExists(basicActions.getDriver(), By.xpath("//a[@class='ng-star-inserted']"))) {
            try {
                basicActions.waitForElementToDisappear(spinner, 10);
                basicActions.waitForElementToBePresent(mothlyPremiumValue.get(0), 30);

                if (sortingTypeSelection.contains("Monthly Premium- Low to High")) {
                    Assert.assertTrue(basicActions.isSortedAscending(mothlyPremiumValue), "Medical Plan sorting for expected Monthly Premium- Low to High");
                } else if (sortingTypeSelection.contains("Monthly Premium- High to Low")) {
                    Assert.assertTrue(basicActions.isSortedDescending(mothlyPremiumValue), "Medical Plan sorting for Monthly Premium- High to Low");
                } else if (sortingTypeSelection.contains("Annual Deductible- Low to High")) {
                    List<WebElement> webElementList = new ArrayList<>();


                    for (int i = 1; i <= medicalPlanNamesList.size(); i += 2) {
                        String dynamicXPath = "((//app-medical-plan-card //*[contains(text(),'Deductible')]//ancestor-or-self::div[@class='col c4-type-body-sm'] //div[@class='row details-data-row'])[" + i + "]/div/span)[1]";
                        WebElement element = basicActions.getDriver().findElement(By.xpath(dynamicXPath));
                        webElementList.add(element);
                    }
                    Assert.assertTrue(basicActions.isSortedAscending(webElementList), "Medical Plan sorting for Annual Deductible- Low to High");
                } else if (sortingTypeSelection.contains("Annual Deductible- High to Low")) {
                    List<WebElement> webElementList = new ArrayList<>();

                    for (int i = 1; i <= medicalPlanNamesList.size(); i += 2) {
                        String dynamicXPath = "((//app-medical-plan-card //*[contains(text(),'Deductible')]//ancestor-or-self::div[@class='col c4-type-body-sm'] //div[@class='row details-data-row'])[" + i + "]/div/span)[1]";
                        WebElement element = basicActions.getDriver().findElement(By.xpath(dynamicXPath));
                        webElementList.add(element);
                    }
                    Assert.assertTrue(basicActions.isSortedDescending(webElementList), "Medical Plan sorting for Annual Deductible- High to Low");
                }
                nextPageArrow.click();
            } catch (Exception e) {
                break; // Break out of the loop if an error occurs
            }
        }


    }

    public void selectMultiplePlanstoCompare() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(insuranceCompanyDropdown, 20);
        selectFirstComparebox.click();
        selectSecondComparebox.click();
        paginateRight();
        selectFirstComparebox.click();
        selectCompareButton.click();
    }

    public void verifyURLforHealthCare(String hyperLink, String pageUrl) {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(planQualityRatingsLink, 20);
        basicActions.scrollToElement(planQualityRatingsLink);
        Assert.assertTrue(planQualityRatingsLink.isDisplayed(), "Healthcare.Org hyperlink text not available in Coco Medical Plan page");
        Assert.assertEquals(planQualityRatingsLink.getText(), hyperLink);
        planQualityRatingsLink.click();
        basicActions.switchtoactiveTab();
        Assert.assertTrue(basicActions.getUrlWithWait(pageUrl, 45).contains(pageUrl), "expected page::" + pageUrl + "::did not load");
        basicActions.closeBrowserTab();
        basicActions.switchToParentPage("Shopping Portal");
    }

    public void selectFirstPlanDetailsCoCo() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBeClickable(firstPlanDetailsbtn, 20);
        firstPlanDetailsbtn.click();
    }

    public void iclickGoBack() {
        basicActions.waitForElementToBePresent(goBackbtn, 10);
        basicActions.scrollToElement(goBackbtn);
        goBackbtn.click();
    }

    public void validatePlanSelection(String planName) {
        basicActions.waitForElementToDisappear(spinner, 20);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setMedicalPlan(planName);
        SharedData.setPrimaryMember(subscriber);
        do {
            optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                WebElement selectedPlan = basicActions.getDriver().findElement(By.id("PlanResults-RemovePlan_" + (optionalInt.get() + 1)));
                Assert.assertTrue(selectedPlan.isDisplayed());
            } else {
                paginateRight();
            }
        } while (optionalInt.isEmpty());
    }

    public void validateMedicalPlanText(List<String> testDatavalues) {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBeClickable(planHeaderdetails, 20);
        softAssert.assertEquals(planHeaderdetails.getText(), testDatavalues.get(0));
        softAssert.assertEquals(planHeaderTwodetails.getText(), testDatavalues.get(1));
        softAssert.assertEquals(filterText.get(0).getText(), testDatavalues.get(2));
        softAssert.assertEquals(filterText.get(1).getText(), testDatavalues.get(3));
        softAssert.assertEquals(filterText.get(2).getText(), testDatavalues.get(4));
        softAssert.assertEquals(filterText.get(3).getText(), testDatavalues.get(5));
        softAssert.assertEquals(filterText.get(4).getText(), testDatavalues.get(6));
        softAssert.assertEquals(resetFilter.getText(), testDatavalues.get(7));
        clickSortingDropdown(testDatavalues.get(8));
        softAssert.assertEquals(textSortBy.getText(), testDatavalues.get(8));
        clickSortingDropdown(testDatavalues.get(9));
        softAssert.assertEquals(textSortBy.getText(), testDatavalues.get(9));
        clickSortingDropdown(testDatavalues.get(10));
        softAssert.assertEquals(textSortBy.getText(), testDatavalues.get(10));
        clickSortingDropdown(testDatavalues.get(11));
        softAssert.assertEquals(textSortBy.getText(), testDatavalues.get(11));
        softAssert.assertEquals(textMedicalCompare.getText(), testDatavalues.get(12));
        softAssert.assertEquals(firstPlanDetailsbtn.getText(), testDatavalues.get(13));
        softAssert.assertEquals(selectFirstPlan.getText(), testDatavalues.get(14));
        softAssert.assertEquals(goBackbtn.getText(), testDatavalues.get(15));
        softAssert.assertEquals(saveAndExitBtn.getText(), testDatavalues.get(16));
        softAssert.assertEquals(skipBtn.getText(), testDatavalues.get(17));
        softAssert.assertEquals(continueButton.getText(), testDatavalues.get(18));
        softAssert.assertEquals(planQualityRatingtxt.getText(), testDatavalues.get(19));
        softAssert.assertEquals(planQualityRatingsLink.getText(), testDatavalues.get(20));
        softAssert.assertAll();
    }
}
