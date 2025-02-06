package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class QCPFPage {
    SoftAssert softAssert= new SoftAssert();
    private BasicActions basicActions;
    public QCPFPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "get-started-button")
    WebElement getStartedButton;
    @FindBy(xpath = "//app-demographics/div/div[3]/div[1]/input")
    WebElement firstName;
    @FindBy(xpath = "//app-demographics/div/div[3]/div[2]/div[2]/select")
    WebElement sexDrp;
    @FindBy(xpath = "//app-demographics/div/div[3]/div[3]/input")
    WebElement DOBInput;
    @FindBy(id= "zip")
    WebElement zipInput;
    @FindBy(xpath= "//div[2]/div[1]/div/div[2]/select//option")
    List<WebElement> countyInput;
    @FindBy(xpath= "//label[@class='remember font-16 mobile-float-left']/span")
    List<WebElement> financialHelpOptions;
    @FindBy(xpath= "//button[text()=' Continue ']")
    WebElement continueBtn;
    @FindBy(xpath= "//button[text()=' This looks right, continue ']")
    WebElement thisLooksRighBtn;
    @FindBy(xpath= "//button[text()=' Ok, got it ']")
    WebElement okGotItBtn;
    @FindBy(xpath= "//*[@id='plans-table']/tbody/tr[1]/td[3]/div/div/button")
    WebElement viewPlanBtn;
    @FindBy(xpath= "//*[@id='print']/div[3]/div/div[2]/div[2]/button")
    WebElement choosePlanBtn;
    @FindBy(xpath= "//div[1]/div/p/span")
    WebElement planNumber;
    @FindBy(xpath= "//img[@src='assets/content/startover.svg']")
    WebElement startOver;
    @FindBy(xpath= "//*[@id='accordion']/div[3]/div[1]/h4/a/img")
    WebElement expandInsuranceBtn;

    @FindBy(xpath= "//*[@id='Carriers']/div/ul/li/ul/li[1]/div/div/span[1]/label/span")
    WebElement chkbxFirstCompany;
    @FindBy(xpath= "//*[@id='Carriers']/div/ul/li/ul/li[2]/div/div/span[1]/label/span")
    WebElement chkbxSecondCompany;
    @FindBy(xpath= "//*[@id='Carriers']/div/ul/li/ul/li[3]/div/div/span[1]/label/span")
    WebElement chkbxThirdCompany;
    @FindBy(xpath= "//*[@id='Carriers']/div/ul/li/ul/li[4]/div/div/span[1]/label/span")
    WebElement chkbxFourthCompany;
    @FindBy(xpath= "//*[@id='Carriers']/div/ul/li/ul/li[5]/div/div/span[1]/label/span")
    WebElement chkbxFifthCompany;
    @FindBy(xpath= "//*[@id='Carriers']/div/ul/li/ul/li[6]/div/div/span[1]/label/span")
    WebElement chkbxSixthCompany;
    @FindBy(xpath= "//*[@id=\"plans-table\"]/tbody/tr[2]/td[3]/div/div/a[2]")
    WebElement FirstCompanyName;




    public void clickGetStartedOnQCPFPage() {
        basicActions.waitForElementToBePresentWithRetries(getStartedButton,50);
        basicActions.scrollToElement(getStartedButton);
        getStartedButton.click();
    }

    public void enterBasicInformationNameSexDOBInQCPFPage(String name, String sex, String dob) {
        basicActions.waitForElementToBePresent(firstName,50);
        basicActions.waitForElementToBePresent(sexDrp,50);
        firstName.click();
        firstName.sendKeys(name);
        sexDrp.click();
        sexDrp.sendKeys(sex);
        DOBInput.click();
        DOBInput.sendKeys(dob);
    }

    public void enterLocationAndCoverageZipCodeCountyInQCPFPage(String zipCode, String county) {
        basicActions.waitForElementToBePresentWithRetries(zipInput,30);
        zipInput.sendKeys(zipCode);
        for (WebElement countyOption : countyInput) {
            if (countyOption.getText().equals(county)){
                countyOption.click();
                break;
            }
        }
    }

    public void clickForFinancialHelpQuestionInQCPFPage(String financialOption) {
        basicActions.waitForElementListToBePresentWithRetries(financialHelpOptions,50);
        switch (financialOption){
            case "Yes":
                financialHelpOptions.get(0).click();
                break;
            case "No":
                financialHelpOptions.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + financialOption);

        }
    }

    public void clickContinueButtonInQCPFPage() {
        basicActions.waitForElementToBePresentWithRetries(continueBtn,30);
        basicActions.waitForElementToBeClickable(continueBtn,50);
        continueBtn.click();
    }

    public void clickThisLooksRightButtonInQCPFPage() {
        basicActions.waitForElementToBePresentWithRetries(thisLooksRighBtn,30);
        thisLooksRighBtn.click();
    }

    public void clickOkGotItButtonInQCPFPage() {
        basicActions.waitForElementToBePresentWithRetries(okGotItBtn,30);
        basicActions.waitForElementToBeClickable(okGotItBtn,50);
        okGotItBtn.click();
    }

    public void clickViewPlanButtonInQCPFPage() {
        basicActions.waitForElementToBePresentWithRetries(viewPlanBtn,30);
        viewPlanBtn.click();
    }

    public void clickChoosePlanButtonInQCPFPage() {
        basicActions.waitForElementToBePresentWithRetries(choosePlanBtn,30);
        choosePlanBtn.click();
    }

    public void clickStartOverButtonInQCPFPage() {
        basicActions.waitForElementToBePresent(startOver,30);
        startOver.click();
    }


    public void validateTheTotalNumberOfPlansDisplayedAndPlanDetails(String plansNumber, String Anthem, String Kaiser, String DenverHealth, String Cigna, String RockyMountain, String Select) {
        validateTheTotalNrOfPlansDisplayedForCountiesWith5Plans(plansNumber, Anthem, Kaiser, DenverHealth, Cigna, RockyMountain);
        basicActions.waitForElementToBePresent(chkbxSixthCompany, 40);
        chkbxSixthCompany.click();
        basicActions.wait(50);
        softAssert.assertEquals(planNumber.getText(), Select);
        chkbxSixthCompany.click();
        softAssert.assertAll();

    }

    public void validateTheTotalNumberOfPlansDisplayedByCounty(String totalPlanNumber) {
        basicActions.waitForElementToBePresentWithRetries(planNumber,30);
        softAssert.assertEquals(planNumber.getText(),totalPlanNumber);
        softAssert.assertAll();
    }

    public void validateTheTotalNrOfPlansDisplayedForCountiesWith5Plans(String plansNumber, String Anthem, String Kaiser, String DenverHealth, String Cigna, String RockyMountain) {
        basicActions.waitForElementToBePresentWithRetries(planNumber,30);
        softAssert.assertEquals(planNumber.getText(),plansNumber);
        expandInsuranceBtn.click();
        basicActions.wait(100);
        basicActions.waitForElementToBePresentWithRetries(FirstCompanyName,30);
        chkbxFirstCompany.click();
        softAssert.assertEquals(planNumber.getText(),Anthem);
        chkbxFirstCompany.click();
        basicActions.waitForElementToBePresentWithRetries(chkbxSecondCompany,40);
        if (chkbxFirstCompany.isSelected()){
            chkbxFirstCompany.click();
        }
        chkbxSecondCompany.click();
        basicActions.wait(50);
        softAssert.assertEquals(planNumber.getText(),Kaiser);
        chkbxSecondCompany.click();
        basicActions.waitForElementToBePresentWithRetries(chkbxThirdCompany,40);
        chkbxThirdCompany.click();
        basicActions.wait(50);
        softAssert.assertEquals(planNumber.getText(),DenverHealth);
        chkbxThirdCompany.click();
        basicActions.waitForElementToBePresentWithRetries(chkbxFourthCompany,40);
        chkbxFourthCompany.click();
        basicActions.wait(50);
        softAssert.assertEquals(planNumber.getText(),Cigna);
        chkbxFourthCompany.click();
        basicActions.waitForElementToBePresentWithRetries(chkbxFifthCompany,40);
        chkbxFifthCompany.click();
        basicActions.wait(50);
        softAssert.assertEquals(planNumber.getText(), RockyMountain);
        chkbxFifthCompany.click();
        softAssert.assertAll();
    }
}
