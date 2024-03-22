package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.PolicyMember;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[@id='PlanResults-TaxCredit_0']")
    WebElement aptCreditAmt;

    /*public void aPTCredit() {
        basicActions.waitForElementListToBePresent(validateAPTC, 10);
        softAssert.assertTrue(validateAPTC.isDisplayed(), "APTC amount did not match");
    }*/

    public void validateAPTC(String planResultsAPTCredit){
        String aptCreditAmt = "//span[text()='" + planResultsAPTCredit + "']";
        basicActions.getDriver().findElement(By.xpath(aptCreditAmt)).getText();
    }
    
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

    public void selectMedicalPlan(String planName){
        PolicyMember subscriber = SharedData.getSubscriber();
        subscriber.setMedicalPlan(planName);
        SharedData.setSubscriber(subscriber);
            do {
            optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                clickPlanButton(optionalInt.get());
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


