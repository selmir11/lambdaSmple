package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.actions.ClickAction;
import com.c4hco.test.automation.actions.SelectAction;
import com.c4hco.test.automation.actions.WaitAction;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class MedicalPlanResultsPage {
    SoftAssert softAssert = new SoftAssert();

    public MedicalPlanResultsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "PlanResults-SelectThisPlan_1")
    WebElement selectFirstPlan;

    @FindBy(id = "PlanResults-SelectThisPlan_1")
    WebElement firstMedicalPlanName;

    @FindBy(id = "MedicalPlanResults-Continue")
    WebElement btnContinue;

    @FindBy(id = "MedicalPlanResults-Continue")
    WebElement continueBtn;

    @FindBy(id = "PlanResults-ComparePlans")
    WebElement clickCompare;

    @FindBy(id = "MedicalPlanResults-SaveAndExit")
    WebElement btnSaveExist;

    @FindBy(id = "MedicalPlanResults-GoBack")
    WebElement btnGoBack;
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

    public void validateAPTC(String planResultsAPTCredit) {
        WaitAction.waitForPresent(planResultsAPTC, 30);
        softAssert.assertEquals(planResultsAPTC.getText(), planResultsAPTCredit);
    }

    public void validateNoAPTC(String noAPTCCreditAmt) {
        softAssert.assertFalse(BasicActions.getInstance().waitForElementPresence(planResultsAPTC, 20));
        softAssert.assertAll();
    }

    public void selectfromProviderList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        softAssert.assertTrue(ClickAction.clickByXpath(providerPath));
    }

    public void SelectFirstMedicalPlan() {
        softAssert.assertTrue(SelectAction.select(selectFirstPlan));
    }

    public void clickContinue() {
        ClickAction.click(continueBtn);
    }

    public void clickCompare() {
        ClickAction.click(clickCompare);
    }

    public void clickFirstTwoCompareButtons() {
        ClickAction.click(comparePlanLinks.get(0), comparePlanLinks.get(1));
    }

    public void clickInsuranceCompanyDropdown() {
        softAssert.assertTrue(ClickAction.click(insuranceCompanyDropdown));
    }

    public void clickMetalTierDropdown() {
        softAssert.assertTrue(ClickAction.click(metalTierDropdown));
    }

    public void clickHSADropdown() {
        softAssert.assertTrue(ClickAction.click(hsaDropdown));
    }

    public void selectHSAOption() {
        ClickAction.click(hsaOption);
    }

    public void clickColoradoOptionDropdown() {
        ClickAction.click(coloradoOptionDropdown);
    }

    public void selectColoradoOptionSelection() {
        softAssert.assertTrue(SelectAction.select(coloradoOptionSelection));
    }

    public void selectfromMetalTierList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        softAssert.assertTrue(ClickAction.clickByXpath(providerPath));
    }

    public void validatePlanResults(int index, String planText) {
        BasicActions.getInstance().waitForElementToBePresent(selectFirstPlan, 10);
        //index = index - 1; //Index of the page starts at 0, so we take the visible order and subtract 1
        String indexString = String.valueOf(index); //turns the int index into a string value.
        String planID = "PlanResults-SelectThisPlan_" + indexString; //sets the ID String using the index
        WebElement ePlanID = BasicActions.getInstance().getDriver().findElement(By.id(planID)); //sets the Web element based on the ID
        String expectedText = ePlanID.getText();
        softAssert.assertEquals(expectedText, planText);
    }

    public void selectMedicalPlan(String planName) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setMedicalPlan(planName);
        SharedData.setPrimaryMember(subscriber);
        Optional<Integer> optionalInt;
        do {
             optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                clickPlanButton(optionalInt.get() + 1);
            } else {
                paginateRight();
            }
        } while (optionalInt.isEmpty());
    }

    private Optional<Integer> checkIfPlanPresent(String planName) {
        BasicActions.getInstance().waitForElementListToBePresent(medicalPlanNamesList, 10);
        return IntStream.range(0, medicalPlanNamesList.size())
                .filter(i -> medicalPlanNamesList.get(i).getText().equals(planName))
                .boxed()
                .findFirst();
    }

    private void clickPlanButton(int index) {
        String planID = "PlanResults-SelectThisPlan_" + index;
        ClickAction.clickById(planID);
    }

    private void paginateRight() {
        BasicActions.getInstance().waitForElementToBePresent(nextPageArrow, 10);
        softAssert.assertTrue(nextPageArrow.isEnabled(), "Right arrow to click is not enabled!");
        ClickAction.click(nextPageArrow);
    }
}


