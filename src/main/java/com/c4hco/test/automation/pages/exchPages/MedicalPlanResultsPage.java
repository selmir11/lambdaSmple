package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
import io.cucumber.java.bs.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
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

    @FindBy(id = "PlanResults-SelectThisPlan_0")
    WebElement selectFirstPlan;

    @FindBy(id = "PlanResults-ProviderPlan_0")
    WebElement firstMedicalPlanName;

    @FindBy(id = "SHP-MedicalPlanResults-Continue")
    WebElement btnContinue;

    @FindBy(id = "SHP-PlanResults-ComparePlans")
    WebElement clickCompare;

    @FindBy(xpath = "//a[contains(@id,'PlanResults-Compare')]")
    List<WebElement> comparePlanLinks;

    @FindBy(id = "SHP-PlanResults-InsuranceCompany")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "SHP-PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "SHP-PlanResults-MetalTier")
    WebElement metalTierDropdown;

    @FindBy(id = "SHP-PlanResults-HSAFilter")
    WebElement hsaDropdown;

    @FindBy(id = "SHP-PlanResults-HSAFilter-input")
    WebElement hsaOption;

    @FindBy(id = "SHP-PlanResults-CoOptionPlans")
    WebElement coloradoOptionDropdown;

    @FindBy(id = "SHP-PlanResults-CoOptionPlans-input")
    WebElement coloradoOptionSelection;

    @FindBy(xpath = "//*[contains(@id, 'PlanResults-ProviderPlan_')]")
    List<WebElement> medicalPlanNamesList;

    @FindBy(css = "pagination-template .pagination-next a")
    WebElement nextPageArrow;

    public void selectfromProviderList(String Selecting) {
        String providerPath = "//span[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void iGetFirstPlaneName() {
        basicActions.waitForElementToBePresent(firstMedicalPlanName, 10);
        SharedData.setfirstPlanNameOnMedicalResultsPage(firstMedicalPlanName.getText());
    }

    public void SelectFirstMedicalPlan() {
        iGetFirstPlaneName();
        basicActions.waitForElementToBePresent(selectFirstPlan, 10);
        selectFirstPlan.click();
    }

    public void iclickContinue() {
        btnContinue.click();
    }

    public void clickCompare() {
        basicActions.waitForElementToBePresent(clickCompare, 10);
        clickCompare.click();
    }

    public void clickFirstTwoCompareButtons() {
        basicActions.waitForElementListToBePresent(comparePlanLinks, 10);
        comparePlanLinks.get(0).click();
        comparePlanLinks.get(1).click();
    }

    public void clickInsuranceCompanyDropdown() {
        basicActions.waitForElementToBeClickable(insuranceCompanyDropdown, 10);
        insuranceCompanyDropdown.click();

    }

    public void clickMetalTierDropdown() {
        basicActions.waitForElementToBeClickable(metalTierDropdown, 10);
        metalTierDropdown.click();

    }

    public void clickHSADropdown() {
        basicActions.waitForElementToBeClickable(hsaDropdown, 10);
        hsaDropdown.click();
    }

    public void selectHSAOption() {
        basicActions.waitForElementToBeClickable(hsaOption, 10);
        hsaOption.click();
    }

    public void clickColoradoOptionDropdown() {
        basicActions.waitForElementToBeClickable(coloradoOptionDropdown, 10);
        coloradoOptionDropdown.click();
    }

    public void selectColoradoOptionSelection() {
        basicActions.waitForElementToBeClickable(coloradoOptionSelection, 10);
        coloradoOptionSelection.click();

    }

    public void selectfromMetalTierList(String Selecting) {
        String providerPath = "//span[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void validatePlanResults(int index, String planText) {
        basicActions.waitForElementToBePresent(selectFirstPlan, 10);
        index = index - 1; //Index of the page starts at 0, so we take the visible order and subtract 1
        String indexString = String.valueOf(index); //turns the int index into a string value.
        String planID = "PlanResults-ProviderPlan_" + indexString; //sets the ID String using the index
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID)); //sets the Webelement based on the ID
        String expectedText = ePlanID.getText();
        expectedText.equals(planText); // compares the expected text gathered in previous line to the planText passed into the function.
    }

//    public void selectMedicalPlan(String planName) {
//        getIndexOfMatchingPlanName(planName);
//
//    }

//    public void getIndexOfMatchingPlanName(String planName) {
//        boolean isPlanPresent = false;
//        do {
//            Optional<Integer> optionalInt = checkIfPlanPresent(planName);
//            if (optionalInt.isPresent()) {
//                isPlanPresent = optionalInt.isPresent();
//                System.out.println("index get---" + optionalInt.get());
//
//            } else {
//                System.out.println("index get---" + optionalInt.get());
//                basicActions.wait(2000);
//                softAssert.assertTrue(nextPageArrow.isEnabled());
//                softAssert.assertAll();
//
//                nextPageArrow.click();
//                basicActions.wait(2000);
//                List<WebElement> nextPageList = new ArrayList<>();
//                medicalPlanNamesList = nextPageList;
//                isPlanPresent = optionalInt.isPresent();
//            }
//        } while (!isPlanPresent);
//    }

    private Optional<Integer> checkIfPlanPresent(String planName) {
        return IntStream.range(0, medicalPlanNamesList.size())
                .filter(i -> medicalPlanNamesList.get(i).getText().equals(planName))
                .boxed()
                .findFirst();
    }

       public void selectPlan(String planName){
        do {
           optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                System.out.println("If block");
                int index = optionalInt.get();
                System.out.println("index---"+index);
                // click the select plan button
                String planID = "PlanResults-ProviderPlan_" + index;
                WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID));
                basicActions.waitForElementToBeClickable(ePlanID, 10);
                ePlanID.click();

            } else {
                System.out.println("else block");
                softAssert.assertTrue(nextPageArrow.isEnabled());
                softAssert.assertAll();
                nextPageArrow.click();

                List<WebElement> nextPageList = new ArrayList<>();
                medicalPlanNamesList = nextPageList;
            }
        } while(!optionalInt.isPresent());
    }
}

