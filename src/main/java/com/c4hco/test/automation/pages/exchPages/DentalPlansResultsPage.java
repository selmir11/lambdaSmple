package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
    @FindBy(id="DentalPlanResults-SelectThisPlan_0")
    WebElement selectFirstDentalPlanBtn;

    @FindBy(id="SHP-DentalPlanResults-GoBack")
    WebElement btnGoBack;

    @FindBy(xpath ="//a[contains(@id,'DentalPlanResults-Compare')]")
    List<WebElement> comparePlanLinks;

    @FindBy(id ="SHP-DentalPlanResults-ComparePlans")
    WebElement btnCompareOnDentalPlanResults;

    @FindBy(id = "SHP-DentalPlanResults-CoverageLevel")
    WebElement dropdownCoverageLevel;

    @FindBy(id = "SHP-DentalPlanResults-Continue")
    WebElement continueBtnOnDentalPlanResults;

    @FindBy(id = "SHP-DentalPlanResults-InsuranceCompany")
    WebElement dropdownInsuranceCompany;

    @FindBy(xpath="//div[@class='plan'] //div[@class='col-sm-12 header-3']")
    List<WebElement> dentalPlanNames;

    @FindBy(css = "pagination-template .pagination-next")
    WebElement nextPageArrow;

    public void iGetFirstDentalPlaneName() {
        basicActions.waitForElementListToBePresent(dentalPlanNames, 10);
        SharedData.setFirstPlanNameOnDentalResultsPage(dentalPlanNames.get(0).getText());
    }

    public void selectFirstDentalPlan(){
        iGetFirstDentalPlaneName();
        basicActions.waitForElementToBePresent(selectFirstDentalPlanBtn,10);
        selectFirstDentalPlanBtn.click();
    }
    public void clickContinueOnDentalResultsPage(){
        basicActions.waitForElementToBePresent(continueBtnOnDentalPlanResults,10);
        continueBtnOnDentalPlanResults.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBePresent(btnGoBack,10);
        btnGoBack.click();

    }
    public void clickFirstTwoCompareButtons() {
        basicActions.waitForElementListToBePresent(comparePlanLinks, 10);
        comparePlanLinks.get(0).click();
        comparePlanLinks.get(1).click();
    }
    public void clickCompareOnDentalPlanResults() {
       basicActions.waitForElementToBePresent(btnCompareOnDentalPlanResults, 10);
       btnCompareOnDentalPlanResults.click();
    }

    public void clickCoverageLevelDropdown(){
        basicActions.waitForElementToBePresent(dropdownCoverageLevel, 10);
        dropdownCoverageLevel.click();

    }
    public void selectfromCoverageLevelList(String coverageLevel) {
        String coveragePath = "//div[text()='" + coverageLevel + "']";
        basicActions.getDriver().findElement(By.xpath(coveragePath)).click();
    }

    public void clickDentalInsuranceCompanyDropdown (){
        basicActions.waitForElementToBePresent(dropdownInsuranceCompany, 10);
        dropdownInsuranceCompany.click();
    }

    public void selectfromInsuranceCompanyList(String insuranceCompany){
        String companyPath = "//div[text()='" + insuranceCompany + "']";
        basicActions.getDriver().findElement(By.xpath(companyPath)).click();
    }

    public void validateDentalPlanText (int index,String dentalPlanText){
        basicActions.waitForElementToBePresent(selectFirstDentalPlanBtn, 10);
        index = index - 1;
        String indexString = String.valueOf(index);
        String planID = "DentalPlanResults-SelectThisPlan_" + indexString;
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID));
        String expectedText = ePlanID.getText();
        expectedText.equals(dentalPlanText);
    }

    public void selectDentalPlan(String planName){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setDentalPlan(planName);
        SharedData.setPrimaryMember(subscriber);
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
        basicActions.waitForElementListToBePresent(dentalPlanNames, 10);
        return IntStream.range(0, dentalPlanNames.size())
                .filter(i -> dentalPlanNames.get(i).getText().equals(planName))
                .boxed()
                .findFirst();
    }

    private void clickPlanButton(int index){
        String planID = "DentalPlanResults-SelectThisPlan_" + index;
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
