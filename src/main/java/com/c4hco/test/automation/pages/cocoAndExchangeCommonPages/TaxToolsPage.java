package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.List;

public class TaxToolsPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public TaxToolsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "zip")
    WebElement zip;
    @FindBy(xpath = "//div[1]/div[2]/div/select")
    WebElement countyDrp;
    @FindBy(xpath = "//select[@class='select-input']/option[1]")
    WebElement countyOption;
    @FindBy(id = "age0")
    WebElement age1;
    @FindBy(id = "age1")
    WebElement age2;
    @FindBy(id = "age2")
    WebElement age3;
    @FindBy(id = "age3")
    WebElement age4;
    @FindBy(id = "age4")
    WebElement age5;
    @FindBy(id = "age5")
    WebElement age6;
    @FindBy(xpath = "//button[.=' Search ']")
    WebElement searchBtn;
    @FindBy(xpath = "//div[contains(text(),'Second lowest-cost Silver plan (SLCSP) monthly premium')]//div")
    WebElement premiumAmount;
    @FindBy(xpath = "//div[contains(text(),'Second lowest-cost Silver plan (SLCSP) name')]//div[1]")
    WebElement provider;
    @FindBy(xpath = "//div[contains(text(),'Second lowest-cost Silver plan (SLCSP) name')]//div[2]")
    WebElement plan;
    @FindBy(xpath = "//a[@class='weight-600 text-color-blue']")
    WebElement addAnotherPersonButton;


        public void enterDataForOneMember(String zipCode, String county,String age){
            basicActions.scrollToElement(zip);
            basicActions.waitForElementToBePresentWithRetries(zip,30);
            zip.sendKeys(zipCode);
            countyDrp.click();
            JavascriptExecutor js = (JavascriptExecutor) basicActions.getDriver();
            js.executeScript("arguments[0].click();", countyDrp);
            basicActions.waitForElementToBePresentWithRetries(countyOption,100);
            countyDrp.click();
            basicActions.wait(200);
            countyDrp.sendKeys(county);
            countyDrp.sendKeys(Keys.ENTER);
            basicActions.waitForElementToBePresentWithRetries(age1,30);
            age1.sendKeys(age);
        }


    public void enterForOneMemberAndAndValidate(String zipCode, String county,String age, String expectedPremium, String expectedProvider, String expectedPlan) {
        enterDataForOneMember(zipCode,county, age);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
        expectedData( expectedPremium, expectedProvider,expectedPlan);

    }

    public void validatePlanForTwoMembers(String zipCode, String county, String age, String ageP2, String expectedPremium, String expectedProvider, String expectedPlan) {
        enterDataForOneMember(zipCode,county, age);
        addAnotherPersonButton.click();
        basicActions.waitForElementToBePresentWithRetries(age2,30);
        age2.sendKeys(ageP2);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
        expectedData( expectedPremium, expectedProvider,expectedPlan);
    }

    public void validatePlanFor3Members(String zipCode, String county, String age, String ageP2,String ageP3, String expectedPremium, String expectedProvider, String expectedPlan) {
        enterDataForOneMember(zipCode,county, age);
        addAnotherPersonButton.click();
        basicActions.waitForElementToBePresentWithRetries(age2,30);
        age2.sendKeys(ageP2);
        addAnotherPersonButton.click();
        age3.sendKeys(ageP3);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
        expectedData( expectedPremium, expectedProvider,expectedPlan);
    }

    public void validatePlanFor4Members(String zipCode, String county, String age, String ageP2, String ageP3, String ageP4, String expectedPremium, String expectedProvider, String expectedPlan) {
        enterDataForOneMember(zipCode,county, age);
        addAnotherPersonButton.click();
        basicActions.waitForElementToBePresentWithRetries(age2,30);
        age2.sendKeys(ageP2);
        addAnotherPersonButton.click();
        age3.sendKeys(ageP3);
        addAnotherPersonButton.click();
        age4.sendKeys(ageP4);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
        expectedData( expectedPremium, expectedProvider,expectedPlan);
        }

    public void validatePlanFor5Members(String zipCode, String county, String age, String ageP2, String ageP3, String ageP4,String ageP5,  String expectedPremium, String expectedProvider, String expectedPlan) {
        enterDataForOneMember(zipCode,county, age);
        addAnotherPersonButton.click();
        basicActions.waitForElementToBePresentWithRetries(age2,30);
        age2.sendKeys(ageP2);
        addAnotherPersonButton.click();
        age3.sendKeys(ageP3);
        addAnotherPersonButton.click();
        age4.sendKeys(ageP4);
        addAnotherPersonButton.click();
        age5.sendKeys(ageP5);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
        expectedData( expectedPremium, expectedProvider,expectedPlan);
        }

    public void validatePlanFor6Members(String zipCode, String county, String age, String ageP2, String ageP3, String ageP4,String ageP5,String ageP6,  String expectedPremium, String expectedProvider, String expectedPlan) {
        enterDataForOneMember(zipCode,county, age);
        addAnotherPersonButton.click();
        basicActions.waitForElementToBePresentWithRetries(age2,30);
        age2.sendKeys(ageP2);
        addAnotherPersonButton.click();
        age3.sendKeys(ageP3);
        addAnotherPersonButton.click();
        age4.sendKeys(ageP4);
        addAnotherPersonButton.click();
        age5.sendKeys(ageP5);
        addAnotherPersonButton.click();
        age6.sendKeys(ageP6);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
        expectedData( expectedPremium, expectedProvider,expectedPlan);

        }

        public void expectedData(String expectedPremium, String expectedProvider,String expectedPlan){
            basicActions.waitForElementToBePresentWithRetries(premiumAmount,100);
            basicActions.waitForElementToBePresentWithRetries(plan,100);
            basicActions.scrollToElement(plan);
            softAssert.assertEquals(premiumAmount.getText(),expectedPremium);
            softAssert.assertEquals(provider.getText(),expectedProvider);
            softAssert.assertEquals(plan.getText(),expectedPlan);
            softAssert.assertAll();
        }
}
