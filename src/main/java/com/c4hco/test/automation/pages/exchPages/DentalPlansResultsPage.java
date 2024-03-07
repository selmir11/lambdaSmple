package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DentalPlansResultsPage {
    private BasicActions basicActions;

    public DentalPlansResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="DentalPlanResults-SelectThisPlan_0")
    WebElement selectFirstDentalPlanBtn;

    @FindBy(id="SHP-DentalPlanResults-Continue")
    WebElement continueBtnOnDentalPlanResults;

    @FindBy(id="SHP-DentalPlanResults-GoBack")
    WebElement btnGoBack;

    @FindBy(xpath ="//a[contains(@id,'DentalPlanResults-Compare')]")
    List<WebElement> comparePlanLinks;

    @FindBy(id ="SHP-DentalPlanResults-ComparePlans")
    WebElement btnCompareOnDentalPlanResults;

    @FindBy(id = "SHP-DentalPlanResults-CoverageLevel")
    WebElement dropdownCoverageLevel;


    public void selectFirstDentalPlan(){
         basicActions.waitForElementToBePresent(selectFirstDentalPlanBtn,10);
        selectFirstDentalPlanBtn.click();
    }
    public void iclickContinueOnDentalResultsPage(){
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
        String coveragePath = "//span[text()='" + coverageLevel + "']";
        basicActions.getDriver().findElement(By.xpath(coveragePath)).click();
    }

}
