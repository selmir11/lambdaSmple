package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LugyPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public LugyPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(xpath = "//input[@class='input-checkbox']")
    List<WebElement> tellUsAboutYrHouseholdCheckbox;
    @FindBy(xpath = "//input[@class='form-check-input input-radio']")
    List<WebElement> questionOptions;
    @FindBy(id = "submit")
    WebElement continueBtn;
    @FindBy(id = "familySizeInput")
    WebElement householdNumberDRP;
    @FindBy(id = "householdIncome")
    WebElement householdIncome;
    @FindBy(id = "incomePeriod")
    WebElement incomePeriodOption;
    @FindBy(id = "submitButton")
    WebElement ApplyForFinancialHelpBtn;
    @FindBy(xpath = "//*[@value='Apply for Health First Colorado']")
    WebElement ApplyForHeathFirstColoradoBtn;


    public void selectTellUsAboutYourHouseholdOptionInLetUsGuideYouPage(String lugyOptions) {
        basicActions.waitForElementListToBePresentWithRetries(tellUsAboutYrHouseholdCheckbox,30);
        switch (lugyOptions){
            case "65 or older":
                tellUsAboutYrHouseholdCheckbox.get(0).click();
                break;
                case "Health First Colorado":
                tellUsAboutYrHouseholdCheckbox.get(1).click();
                break;
                case "coverage under 26":
                tellUsAboutYrHouseholdCheckbox.get(2).click();
                break;
                case "coverage live":
                tellUsAboutYrHouseholdCheckbox.get(3).click();
                break;
                case "coverage have a physical disability":
                tellUsAboutYrHouseholdCheckbox.get(4).click();
                break;
                case "None of these applies":
                tellUsAboutYrHouseholdCheckbox.get(5).click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + lugyOptions);

        }
    }

    public void selectContinueOnLetUsGuideYouPage() {
        basicActions.waitForElementToBeClickable(continueBtn,30);
        continueBtn.click();
    }

    public void selectTheNumberOfPeopleAreInYourHousehold(String houseHoldNr) {
        basicActions.waitForElementToBePresent(householdNumberDRP,30);
        householdNumberDRP.sendKeys(houseHoldNr);
    }

    public void selectIsAnyoneInYourHouseholdAgeOrUnder(String option) {
        basicActions.waitForElementListToBePresentWithRetries(questionOptions,30);
        switch (option){
            case "Yes":
                questionOptions.get(0).click();
                break;
            case "No":
            questionOptions.get(1).click();
            break;}
    }

    public void selectIsTherePregnentInYourHousehold(String option) {
        basicActions.waitForElementListToBePresentWithRetries(questionOptions,30);
        switch (option){
            case "Yes":
                questionOptions.get(2).click();
                break;
            case "No":
                questionOptions.get(3).click();
                break;}
    }

    public void selectIncomeAndOptionInLetUsGuideYouPage(String amount, String option) {
        basicActions.waitForElementToBePresent(householdIncome,40);
        householdIncome.clear();
        householdIncome.sendKeys(amount);
        incomePeriodOption.click();
        basicActions.getDriver().findElement(By.xpath("//option[@value='"+option+"']")).click();
    }

    public void clickApplyForFinancialHelpInLetUsGuideYouPage() {
        basicActions.waitForElementToBePresent(ApplyForFinancialHelpBtn,30);
        ApplyForFinancialHelpBtn.click();
    }

    public void validateApplyForFinancialHelpIsDisplayedInLetUsGuideYouPage() {
        basicActions.waitForElementToBePresent(ApplyForFinancialHelpBtn,30);
        softAssert.assertTrue(ApplyForFinancialHelpBtn.isDisplayed());
        softAssert.assertEquals(ApplyForFinancialHelpBtn.getAttribute("value"),"Apply for Financial Help");
        softAssert.assertAll();
    }

    public void clickApplyForHealthFirstColoradoInLetUsGuideYouPage() {
        basicActions.waitForElementToBePresent(ApplyForHeathFirstColoradoBtn,30);
        ApplyForHeathFirstColoradoBtn.click();
    }
}
