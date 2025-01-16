package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    @FindBy(xpath = "//select[@class='select-input ng-pristine ng-valid ng-touched']/option")
    List<WebElement> sexDrpOptions;
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
        for (WebElement each : countyInput) {
            if (each.getText().equals(county)){
                each.click();
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
}
